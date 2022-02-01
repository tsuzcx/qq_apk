package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.RotateAnimation;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationCrop;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.BasePhotoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.util.QZLog;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import cooperation.troop.TroopFileProxyActivity;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PhotoUtils
  extends BasePhotoUtils
{
  private static final String KEY_FRIEND_UIN = "PHOTO_KEY_FRIEND_UIN";
  public static final int SIZE_1_M = 1048576;
  private static final String TAG = "PhotoUtils";
  public static SimpleDateFormat sDateFormatForHour = new SimpleDateFormat("yyyy年MM月dd HH点");
  public static SimpleDateFormat sDateFormatForMinute = new SimpleDateFormat("yyyy年MM月dd HH点mm分");
  
  public static void backToPhoto(Intent paramIntent, Activity paramActivity)
  {
    String str = paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), str);
    paramIntent.addFlags(603979776);
    paramActivity.startActivity(paramIntent);
    paramActivity.finish();
  }
  
  public static int calculateInSampleSizeByWidth(BitmapFactory.Options paramOptions, int paramInt)
  {
    int k = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if (k > paramInt)
    {
      k /= 2;
      for (;;)
      {
        j = i;
        if (k / i <= paramInt) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public static void copyReportInfo(Intent paramIntent, ActivityURIRequest paramActivityURIRequest)
  {
    boolean bool = paramIntent.getBooleanExtra("custom_photopreview_sendbtn_report", false);
    String str1 = paramIntent.getStringExtra("custom_photopreview_sendbtn_reportActionName");
    String str2 = paramIntent.getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
    paramIntent = paramIntent.getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
    paramActivityURIRequest.extra().putBoolean("custom_photopreview_sendbtn_report", bool);
    paramActivityURIRequest.extra().putString("custom_photopreview_sendbtn_reportActionName", str1);
    paramActivityURIRequest.extra().putString("custom_photopreview_sendbtn_album_reportReverse2", str2);
    paramActivityURIRequest.extra().putString("custom_photopreview_sendbtn_camera_reportReverse2", paramIntent);
  }
  
  public static String createContentDescription(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 != 1) {
      localStringBuilder.append("照片 ");
    } else {
      localStringBuilder.append("视频 ");
    }
    localStringBuilder.append("拍摄时间: ");
    paramLocalMediaInfo = new Date(paramLocalMediaInfo.modifiedDate * 1000L);
    localStringBuilder.append(sDateFormatForMinute.format(paramLocalMediaInfo));
    return localStringBuilder.toString();
  }
  
  public static String createContentDescriptionWithCheckBox(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 != 1) {
      localStringBuilder.append("照片 ");
    } else {
      localStringBuilder.append("视频 ");
    }
    localStringBuilder.append("拍摄时间: ");
    paramLocalMediaInfo = new Date(paramLocalMediaInfo.modifiedDate * 1000L);
    localStringBuilder.append(sDateFormatForHour.format(paramLocalMediaInfo));
    return localStringBuilder.toString();
  }
  
  public static Bitmap drawBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt)
  {
    new Canvas(paramBitmap1).drawBitmap(paramBitmap2, 0.0F, paramInt, null);
    return paramBitmap1;
  }
  
  public static Bitmap getBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      decodeFileWithBuffer(paramString, localOptions);
      if ((paramInt1 <= 0) && (paramInt2 <= 0)) {
        paramInt1 = 1;
      } else {
        paramInt1 = calculateInSampleSizeByWidth(localOptions, paramInt1);
      }
      localOptions.inSampleSize = paramInt1;
      localOptions.inJustDecodeBounds = false;
      paramString = decodeFileWithBuffer(paramString, localOptions);
      return paramString;
    }
    catch (Exception paramString)
    {
      QZLog.e("PhotoUtils", 1, new Object[] { "getBitmapFromFile, exception", paramString });
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      label65:
      break label65;
    }
    QZLog.e("PhotoUtils", 1, new Object[] { "getBitmapFromFile, OutOfMemoryError" });
    return null;
  }
  
  public static String getCameraPath(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    Calendar localCalendar = Calendar.getInstance();
    paramString3 = new StringBuilder(paramString1);
    paramString3.append(str);
    int i = 1;
    paramString3.append(localCalendar.get(1));
    int j = localCalendar.get(2) + 1;
    if (j < 10)
    {
      paramString1 = new StringBuilder();
      paramString1.append("0");
      paramString1.append(j);
      paramString1 = paramString1.toString();
    }
    else
    {
      paramString1 = Integer.valueOf(j);
    }
    paramString3.append(paramString1);
    j = localCalendar.get(5);
    if (j < 10)
    {
      paramString1 = new StringBuilder();
      paramString1.append("0");
      paramString1.append(j);
      paramString1 = paramString1.toString();
    }
    else
    {
      paramString1 = Integer.valueOf(j);
    }
    paramString3.append(paramString1);
    j = localCalendar.get(11);
    if (j < 10)
    {
      paramString1 = new StringBuilder();
      paramString1.append("0");
      paramString1.append(j);
      paramString1 = paramString1.toString();
    }
    else
    {
      paramString1 = Integer.valueOf(j);
    }
    paramString3.append(paramString1);
    j = localCalendar.get(12);
    if (j < 10)
    {
      paramString1 = new StringBuilder();
      paramString1.append("0");
      paramString1.append(j);
      paramString1 = paramString1.toString();
    }
    else
    {
      paramString1 = Integer.valueOf(j);
    }
    paramString3.append(paramString1);
    j = localCalendar.get(13);
    if (j < 10)
    {
      paramString1 = new StringBuilder();
      paramString1.append("0");
      paramString1.append(j);
      paramString1 = paramString1.toString();
    }
    else
    {
      paramString1 = Integer.valueOf(j);
    }
    paramString3.append(paramString1);
    paramString1 = new StringBuilder();
    paramString1.append(paramString3.toString());
    paramString1.append(paramString2);
    if (!new File(paramString1.toString()).exists())
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString3.toString());
      paramString1.append(paramString2);
      return paramString1.toString();
    }
    paramString1 = new StringBuilder(paramString3);
    j = paramString3.length();
    while (i < 2147483647)
    {
      paramString1.append('(');
      paramString1.append(i);
      paramString1.append(')');
      paramString1.append(paramString2);
      if (!new File(paramString1.toString()).exists()) {
        break;
      }
      paramString1.delete(j, paramString1.length());
      i += 1;
    }
    return paramString1.toString();
  }
  
  public static int getFileType(String paramString, ArrayList<LocalMediaInfo> paramArrayList)
  {
    paramString = getMediaInfo(paramString, paramArrayList);
    if (paramString == null) {
      return -1;
    }
    return AlbumUtil.getMediaType(paramString);
  }
  
  public static LocalMediaInfo getMediaInfo(String paramString, ArrayList<LocalMediaInfo> paramArrayList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayList != null))
    {
      if (paramArrayList.isEmpty()) {
        return null;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramArrayList.next();
        if (localLocalMediaInfo.path.equals(paramString)) {
          return localLocalMediaInfo;
        }
      }
      return null;
    }
    return null;
  }
  
  public static String getRawPhotoSize(Context paramContext, float paramFloat)
  {
    paramFloat /= 1024000;
    StringBuilder localStringBuilder;
    if (paramFloat >= 10.0F)
    {
      paramContext = new DecimalFormat("0");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.format(paramFloat));
      localStringBuilder.append("M");
      return localStringBuilder.toString();
    }
    if (paramFloat >= 1.0F)
    {
      paramContext = new DecimalFormat("0.0");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.format(paramFloat));
      localStringBuilder.append("M");
      return localStringBuilder.toString();
    }
    double d = paramFloat;
    if (d >= 0.001D)
    {
      paramContext = new DecimalFormat("0");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.format(paramFloat * 1024.0F));
      localStringBuilder.append("K");
      return localStringBuilder.toString();
    }
    if (d >= 0.0001D)
    {
      paramContext = new DecimalFormat("0.0");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.format(paramFloat * 1024.0F));
      localStringBuilder.append("K");
      return localStringBuilder.toString();
    }
    return "0.1K";
  }
  
  public static int getTypeforReport(SessionInfo paramSessionInfo)
  {
    int i = 1;
    if (paramSessionInfo != null)
    {
      int j = paramSessionInfo.a;
      if (j != 0)
      {
        if (j != 1)
        {
          if ((j != 1000) && (j != 1025) && (j != 7400) && (j != 10004) && (j != 10008) && (j != 10013)) {
            switch (j)
            {
            default: 
              switch (j)
              {
              default: 
                return 5;
              }
              break;
            }
          }
          return 3;
        }
        return 2;
      }
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public static int getTypeforReport2(SessionInfo paramSessionInfo)
  {
    int i = 1;
    if (paramSessionInfo != null)
    {
      int j = paramSessionInfo.a;
      if (j != 0)
      {
        if (j != 1)
        {
          if ((j != 1000) && (j != 1025))
          {
            if (j != 3000) {
              if (j != 6000) {
                if ((j == 7400) || (j == 10004) || (j == 10008) || (j == 10013)) {
                  break label146;
                }
              }
            }
            switch (j)
            {
            default: 
              switch (j)
              {
              default: 
                return -1;
                return 5;
                return 4;
              }
              break;
            }
          }
          label146:
          return 3;
        }
        return 2;
      }
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public static int getTypeforReportSpcialDiscuss(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return -1;
    }
    if (paramSessionInfo.a == 3000) {
      return 2;
    }
    return getTypeforReport(paramSessionInfo);
  }
  
  public static boolean isJPEGImage(String paramString)
  {
    paramString = getImageMimeType(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.contains("image/jpeg");
  }
  
  public static long makeBatchIdQzone()
  {
    return System.currentTimeMillis();
  }
  
  public static void onSendResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean)
  {
    if ((paramActivity != null) && (((BaseActivity)paramActivity).app != null)) {
      onSendResult(paramActivity, paramInt1, paramInt2, paramIntent, paramBoolean, MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
    }
  }
  
  public static void onSendResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, String paramString)
  {
    if (paramIntent != null) {
      paramIntent.removeExtra("PhotoConst.VIDEO_INFOS");
    }
    if (((paramInt1 == 2) || (paramInt1 == 7001)) && (paramInt2 == -1))
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoUtils", 2, "[onSendResult] data = null");
        }
        localIntent = new Intent();
      }
      localIntent.putExtra("PhotoConst.send_photo_activity_result", -1);
      if (paramInt1 == 7001)
      {
        paramIntent = paramActivity.getIntent();
        String str1 = paramIntent.getStringExtra("UploadPhoto.key_album_id");
        String str2 = paramIntent.getStringExtra("UploadPhoto.key_album_name");
        QZoneHelper.saveSelectedAlbumInfo(paramString, paramIntent.getStringExtra("uin"), str1, str2);
        paramIntent.putExtras(localIntent);
        paramString = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        paramIntent.setClassName(paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramString);
        if (!paramBoolean)
        {
          paramIntent.addFlags(603979776);
          paramActivity.startActivity(paramIntent);
        }
      }
      else
      {
        paramIntent = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        localIntent.setClassName(paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramIntent);
        if (!paramBoolean)
        {
          localIntent.addFlags(603979776);
          StatisticConstants.a(localIntent);
          paramActivity.startActivity(localIntent);
        }
        else
        {
          QLog.e("PhotoUtils", 1, "Watermark has been deleted!");
        }
      }
      paramActivity.finish();
      AlbumUtil.anim(paramActivity, false, false);
    }
  }
  
  public static void reportSendSize(QQAppInterface paramQQAppInterface, int paramInt, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Object localObject2 = "Send_compress";
      Object localObject1 = localObject2;
      if (paramInt != 0) {
        if (paramInt != 2) {
          localObject1 = localObject2;
        } else {
          localObject1 = "Send_raw";
        }
      }
      paramInt = 0;
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject2).next();
        if (localObject3 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoUtils", 2, "reportSendSize sendReportType:path == null");
          }
        }
        else
        {
          localObject3 = new File((String)localObject3);
          paramInt = (int)(paramInt + ((File)localObject3).length());
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportSendSize sendReportType:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",count:");
        ((StringBuilder)localObject2).append(paramArrayList.size());
        ((StringBuilder)localObject2).append(",totalSize:");
        ((StringBuilder)localObject2).append(paramInt);
        QLog.d("PhotoUtils", 2, ((StringBuilder)localObject2).toString());
      }
      reportSendSize(paramQQAppInterface, (String)localObject1, paramArrayList.size(), paramInt);
    }
  }
  
  public static void reportSendSize(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "Pic_edit", paramString, 0, 1, null, String.valueOf(paramInt1), null, String.valueOf(paramInt2), null);
  }
  
  public static boolean restorePhotoExif(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject = new File(paramString1);
      File localFile = new File(paramString2);
      if ((((File)localObject).exists()) && (localFile.exists())) {
        try
        {
          boolean bool = JpegExifReader.isCrashJpeg(paramString1);
          if (!bool) {
            try
            {
              if (!JpegExifReader.isCrashJpeg(paramString2))
              {
                bool = isJPEGImage(paramString1);
                if ((bool) && (isJPEGImage(paramString2)))
                {
                  paramString1 = new ExifInterface(paramString1);
                  paramString2 = new ExifInterface(paramString2);
                  localObject = paramString1.getAttribute("GPSLatitude");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    paramString2.setAttribute("GPSLatitude", (String)localObject);
                  }
                  localObject = paramString1.getAttribute("GPSLatitudeRef");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    paramString2.setAttribute("GPSLatitudeRef", (String)localObject);
                  }
                  localObject = paramString1.getAttribute("GPSLongitude");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    paramString2.setAttribute("GPSLongitude", (String)localObject);
                  }
                  localObject = paramString1.getAttribute("GPSLongitudeRef");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    paramString2.setAttribute("GPSLongitudeRef", (String)localObject);
                  }
                  localObject = paramString1.getAttribute("DateTime");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    paramString2.setAttribute("DateTime", (String)localObject);
                  }
                  localObject = paramString1.getAttribute("Flash");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    paramString2.setAttribute("Flash", (String)localObject);
                  }
                  localObject = paramString1.getAttribute("FocalLength");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    paramString2.setAttribute("FocalLength", (String)localObject);
                  }
                  localObject = paramString1.getAttribute("GPSDateStamp");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    paramString2.setAttribute("GPSDateStamp", (String)localObject);
                  }
                  localObject = paramString1.getAttribute("GPSTimeStamp");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    paramString2.setAttribute("GPSTimeStamp", (String)localObject);
                  }
                  localObject = paramString1.getAttribute("Make");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    paramString2.setAttribute("Make", (String)localObject);
                  }
                  localObject = paramString1.getAttribute("Model");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    paramString2.setAttribute("Model", (String)localObject);
                  }
                  localObject = paramString1.getAttribute("WhiteBalance");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    paramString2.setAttribute("WhiteBalance", (String)localObject);
                  }
                  if (Build.VERSION.SDK_INT >= 11)
                  {
                    localObject = paramString1.getAttribute("FNumber");
                    if (!TextUtils.isEmpty((CharSequence)localObject)) {
                      paramString2.setAttribute("FNumber", (String)localObject);
                    }
                    localObject = paramString1.getAttribute("ExposureTime");
                    if (!TextUtils.isEmpty((CharSequence)localObject)) {
                      paramString2.setAttribute("ExposureTime", (String)localObject);
                    }
                    localObject = paramString1.getAttribute("ISOSpeedRatings");
                    if (!TextUtils.isEmpty((CharSequence)localObject)) {
                      paramString2.setAttribute("ISOSpeedRatings", (String)localObject);
                    }
                  }
                  if (Build.VERSION.SDK_INT >= 9)
                  {
                    localObject = paramString1.getAttribute("GPSAltitude");
                    if (!TextUtils.isEmpty((CharSequence)localObject)) {
                      paramString2.setAttribute("GPSAltitude", (String)localObject);
                    }
                    paramString1 = paramString1.getAttribute("GPSAltitudeRef");
                    if (!TextUtils.isEmpty(paramString1)) {
                      paramString2.setAttribute("GPSAltitudeRef", paramString1);
                    }
                  }
                  paramString2.saveAttributes();
                  return true;
                }
                return false;
              }
            }
            catch (IOException paramString1) {}
          }
          return false;
        }
        catch (Exception paramString1)
        {
          QLog.e("PhotoUtils", 1, paramString1, new Object[0]);
          return false;
        }
        catch (IOException paramString1)
        {
          QLog.e("PhotoUtils", 1, paramString1, new Object[0]);
          return false;
        }
      }
      return false;
    }
    return false;
  }
  
  public static void rotate180Degrees(View paramView, boolean paramBoolean)
  {
    float f1;
    if (paramBoolean) {
      f1 = 180.0F;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (paramBoolean) {
      f2 = 360.0F;
    } else {
      f2 = 180.0F;
    }
    RotateAnimation localRotateAnimation = new RotateAnimation(f1, f2, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(300L);
    localRotateAnimation.setFillAfter(true);
    paramView.startAnimation(localRotateAnimation);
  }
  
  /* Error */
  public static boolean saveBitmapToFile(Bitmap paramBitmap, File paramFile, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: new 559	java/io/BufferedOutputStream
    //   15: dup
    //   16: new 561	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 564	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: invokespecial 567	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore_1
    //   28: aload_0
    //   29: aload_2
    //   30: iload_3
    //   31: aload_1
    //   32: invokevirtual 573	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   35: istore 6
    //   37: iload 6
    //   39: istore 5
    //   41: aload_1
    //   42: invokevirtual 576	java/io/BufferedOutputStream:flush	()V
    //   45: iload 4
    //   47: ifeq +11 -> 58
    //   50: iload 6
    //   52: istore 5
    //   54: aload_0
    //   55: invokevirtual 579	android/graphics/Bitmap:recycle	()V
    //   58: iload 6
    //   60: istore 4
    //   62: aload_1
    //   63: invokevirtual 582	java/io/BufferedOutputStream:close	()V
    //   66: iload 6
    //   68: ireturn
    //   69: astore_0
    //   70: aload_0
    //   71: invokevirtual 585	java/io/IOException:printStackTrace	()V
    //   74: iload 4
    //   76: ireturn
    //   77: astore_0
    //   78: aload_1
    //   79: astore 7
    //   81: goto +51 -> 132
    //   84: astore_2
    //   85: aload_1
    //   86: astore_0
    //   87: aload_2
    //   88: astore_1
    //   89: goto +15 -> 104
    //   92: astore_0
    //   93: goto +39 -> 132
    //   96: astore_1
    //   97: aload 8
    //   99: astore_0
    //   100: iload 6
    //   102: istore 5
    //   104: aload_0
    //   105: astore 7
    //   107: ldc 14
    //   109: iconst_1
    //   110: ldc_w 587
    //   113: aload_1
    //   114: invokestatic 590	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   117: aload_0
    //   118: ifnull +11 -> 129
    //   121: iload 5
    //   123: istore 4
    //   125: aload_0
    //   126: invokevirtual 582	java/io/BufferedOutputStream:close	()V
    //   129: iload 5
    //   131: ireturn
    //   132: aload 7
    //   134: ifnull +16 -> 150
    //   137: aload 7
    //   139: invokevirtual 582	java/io/BufferedOutputStream:close	()V
    //   142: goto +8 -> 150
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 585	java/io/IOException:printStackTrace	()V
    //   150: aload_0
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramBitmap	Bitmap
    //   0	152	1	paramFile	File
    //   0	152	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	152	3	paramInt	int
    //   0	152	4	paramBoolean	boolean
    //   4	126	5	bool1	boolean
    //   1	100	6	bool2	boolean
    //   10	128	7	localObject1	Object
    //   7	91	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   62	66	69	java/io/IOException
    //   125	129	69	java/io/IOException
    //   28	37	77	finally
    //   41	45	77	finally
    //   54	58	77	finally
    //   28	37	84	java/lang/Exception
    //   41	45	84	java/lang/Exception
    //   54	58	84	java/lang/Exception
    //   12	28	92	finally
    //   107	117	92	finally
    //   12	28	96	java/lang/Exception
    //   137	142	145	java/io/IOException
  }
  
  static void sendCropImgResultToCoverStoreBroadCast(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action.com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity.cover_img_crop_end");
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void sendPhoto(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
  {
    String str1 = paramIntent.getStringExtra("PHOTO_KEY_FRIEND_UIN");
    if (str1 != null) {
      paramIntent.putExtra("uin", str1);
    }
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    if (paramArrayList.size() == 1) {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
    }
    paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
    String str2 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME");
    str1 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
    Object localObject;
    if (!TextUtils.isEmpty(str1))
    {
      localObject = str2;
      if (!TextUtils.isEmpty(str2)) {}
    }
    else
    {
      localObject = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      str1 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, String.format("sendPhoto packageName=%s className=%s", new Object[] { localObject, str1 }));
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, String.format("sendPhoto extras=%s", new Object[] { paramIntent.getExtras() }));
      }
      paramIntent.setClassName((String)localObject, str1);
      paramIntent.addFlags(603979776);
      boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendPhoto isCallFromPlugin=");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append("className=");
        ((StringBuilder)localObject).append(str1);
        QLog.d("forward", 2, ((StringBuilder)localObject).toString());
      }
      boolean bool2 = paramIntent.getBooleanExtra("PhotoConst.is_troop_send_mixed_msg", false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendPhoto isTroopSendMixedMsg = ");
        ((StringBuilder)localObject).append(bool2);
        QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
      }
      boolean bool3 = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
      if (bool2)
      {
        sendPhotoFromAio(paramActivity, paramIntent, paramArrayList, paramInt);
        paramActivity.finish();
        bool1 = paramBoolean;
      }
      else if (bool3)
      {
        sendPhotoFromAio(paramActivity, paramIntent, paramArrayList, paramInt);
        paramActivity.finish();
        bool1 = paramBoolean;
      }
      else if (!bool1)
      {
        if (str1.equals("com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity"))
        {
          paramIntent.putExtra("cleartop", true);
          TroopFileProxyActivity.a(paramActivity, paramIntent, 2, null);
          bool1 = paramBoolean;
        }
        else if (str1.equals(((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getReadInJoyUploadAvatarFragmentClazz().getName()))
        {
          bool1 = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
          paramIntent.putExtra("keyAction", "actionSelectPicture");
          paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
          PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicTransFragmentActivity.class, ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getReadInJoyUploadAvatarFragmentClazz(), 2);
        }
        else
        {
          paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
          if (paramIntent.getBooleanExtra("sIsCloudPrinter", false))
          {
            paramActivity.startActivityForResult(paramIntent, 102);
            bool1 = paramBoolean;
          }
          else
          {
            paramActivity.startActivityForResult(paramIntent, 2);
            bool1 = paramBoolean;
          }
        }
      }
      else
      {
        localObject = paramIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
        str2 = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
        String str3 = paramIntent.getStringExtra("PhotoConst.UIN");
        if ("qzone_plugin.apk".equals(str2))
        {
          if (str1.equals("com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity"))
          {
            sendCropImgResultToCoverStoreBroadCast(paramActivity, (String)paramArrayList.get(0), paramIntent.getIntExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", 0));
            bool1 = paramBoolean;
          }
          else
          {
            QzonePluginProxyActivity.setActivityNameToIntent(paramIntent, str1);
            paramIntent.putExtra("cleartop", true);
            paramIntent.putExtra("PhotoConst.IS_FROM_PHOTO_LIST", true);
            QZoneHelper.launchQZone(paramActivity, str3, paramIntent, -1);
            bool1 = false;
          }
        }
        else if ("qqfav.apk".equals(str2))
        {
          QfavHelper.a(paramActivity, str3, paramIntent, 2);
          bool1 = paramBoolean;
        }
        else if ("qqsmartdevice.apk".equals(str2))
        {
          paramIntent.putExtra("cleartop", true);
          paramArrayList = new IPluginManager.PluginParams(0);
          paramArrayList.d = str2;
          paramArrayList.g = ((String)localObject);
          paramArrayList.c = str3;
          paramArrayList.h = str1;
          paramArrayList.i = SmartDevicePluginProxyActivity.class;
          paramArrayList.j = paramIntent;
          paramArrayList.k = 2;
          IPluginManager.a(paramActivity, paramArrayList);
          bool1 = paramBoolean;
        }
        else
        {
          bool1 = paramBoolean;
          if ("comic_plugin.apk".equals(str2))
          {
            paramIntent.putExtra("cleartop", true);
            paramArrayList = new IPluginManager.PluginParams(0);
            paramArrayList.d = str2;
            paramArrayList.g = ((String)localObject);
            paramArrayList.c = str3;
            paramArrayList.h = str1;
            paramArrayList.i = ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).getProxyActivityClass(str1);
            paramArrayList.j = paramIntent;
            paramArrayList.k = 2;
            IPluginManager.a(paramActivity, paramArrayList);
            bool1 = paramBoolean;
          }
        }
      }
      if (!bool1)
      {
        paramActivity.finish();
        AlbumUtil.anim(paramActivity, false, false);
      }
      return;
    }
    paramArrayList = paramIntent.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME");
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, String.format("sendPhoto action=%s", new Object[] { paramArrayList }));
    }
    if (TextUtils.isEmpty(paramArrayList))
    {
      QQToast.makeText(paramActivity, HardCodeUtil.a(2131905944), 0).show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, String.format("sendPhoto extras=%s", new Object[] { paramIntent.getExtras() }));
    }
    paramIntent.setComponent(null);
    paramIntent.setAction(paramArrayList);
    paramIntent.setFlags(paramIntent.getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
    try
    {
      paramActivity.sendBroadcast(paramIntent);
      paramActivity.finish();
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.d("PhotoUtils", 1, "sendPhoto fail!", paramActivity);
    }
  }
  
  public static void sendPhotoForPhotoPlus(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), str1);
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    if (paramArrayList.size() == 1) {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
    }
    paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    paramIntent.putExtra("PhotoConst.SEND_FLAG", true);
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("sendPhotoForPhotoPlus , activity = ");
      paramArrayList.append(paramActivity);
      paramArrayList.append(",data = ");
      paramArrayList.append(paramIntent.getExtras());
      QLog.d("PhotoUtils", 2, paramArrayList.toString());
    }
    paramIntent.addFlags(603979776);
    if ((Build.VERSION.SDK_INT >= 21) && (str1.contains("ForwardRecentActivity")))
    {
      int i = paramIntent.getFlags();
      if ((0x80000 & i) > 0) {
        paramIntent.setFlags(i & 0xFFF7FFFF);
      }
    }
    String str2;
    if (!paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
    {
      paramArrayList = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
      if (("com.tencent.mobileqq.activity.SplashActivity".equals(paramArrayList)) && ("com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(str1)) && ("com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(str2))) {
        paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramArrayList);
      } else if ("com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(str1)) {
        paramIntent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.SplashActivity");
      }
      paramIntent.putExtra("open_chatfragment_fromphoto", true);
      paramActivity.startActivity(paramIntent);
    }
    else if ("qzone_plugin.apk".equals(paramIntent.getStringExtra("PhotoConst.PLUGIN_APK")))
    {
      paramArrayList = str1;
      if (!str1.contains("QZone"))
      {
        paramArrayList = str1;
        if (paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME") != null) {
          paramArrayList = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        }
      }
      paramIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
      str1 = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      str2 = paramIntent.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str1))
      {
        QzonePluginProxyActivity.setActivityNameToIntent(paramIntent, paramArrayList);
        paramIntent.putExtra("cleartop", true);
        QZoneHelper.launchQZone(paramActivity, str2, paramIntent, -1);
      }
    }
    if (Utils.c(paramIntent.getStringExtra("uin"))) {
      ReportController.b(null, "dc00898", "", "", "0X8007249", "0X8007249", 0, 0, "", "", "", "");
    }
    paramActivity.finish();
  }
  
  public static final void sendPhotoFromAio(Context paramContext, Intent paramIntent, ArrayList<String> paramArrayList, int paramInt)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      paramIntent = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      String str = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localIntent.setClassName(paramIntent, str);
      localIntent.putExtra("open_chatfragment_fromphoto", true);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
      localIntent.putExtra("PhotoConst.SEND_FLAG", true);
      localIntent.addFlags(603979776);
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("sendPhotoFromAio activity = ");
        paramArrayList.append(str);
        paramArrayList.append(", packageName = ");
        paramArrayList.append(paramIntent);
        paramArrayList.append(", data = ");
        paramArrayList.append(localIntent.getExtras());
        QLog.d("PhotoUtils", 2, paramArrayList.toString());
      }
      localIntent.putExtra("open_chatfragment_fromphoto", true);
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void startPhotoEdit(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    int i = paramIntent.getIntExtra("Business_Origin", 0);
    if ((100 != i) && (102 != i) && (103 != i))
    {
      paramIntent.setClass(paramActivity, PhotoCropActivity.class);
    }
    else
    {
      paramIntent.setClass(paramActivity, PhotoCropForPortraitActivity.class);
      paramIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getShapeOfBusi(i));
    }
    paramIntent.removeExtra("Business_Origin");
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString2);
    paramIntent.putExtra("PhotoConst.TARGET_PATH", paramString3);
    paramIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt1);
    paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt2);
    paramIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt3);
    paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt4);
    paramActivity.startActivity(paramIntent);
    AlbumUtil.anim(paramActivity, false, true);
  }
  
  public static void startPhotoEditForResult(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, int paramInt5)
  {
    int i = paramIntent.getIntExtra("Business_Origin", 0);
    if ((100 != i) && (102 != i) && (103 != i))
    {
      paramIntent.setClass(paramActivity, PhotoCropActivity.class);
    }
    else
    {
      paramIntent.setClass(paramActivity, PhotoCropForPortraitActivity.class);
      paramIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getShapeOfBusi(i));
    }
    paramIntent.removeExtra("Business_Origin");
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString2);
    paramIntent.putExtra("PhotoConst.TARGET_PATH", paramString3);
    paramIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt1);
    paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt2);
    paramIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt3);
    paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt4);
    paramActivity.startActivityForResult(paramIntent, paramInt5);
    AlbumUtil.anim(paramActivity, false, true);
  }
  
  public static void startPhotoListEdit(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    startPhotoListEditForResult(paramIntent, paramActivity, paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2, -1);
  }
  
  public static void startPhotoListEditForResult(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    paramIntent.setClass(paramActivity, NewPhotoListActivity.class);
    paramIntent.putExtra("enter_from", 50);
    paramIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationCrop.a);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    paramIntent.putExtra("PhotoConst.TARGET_PATH", paramString2);
    paramIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt1);
    paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt2);
    paramIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt3);
    paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt4);
    paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    paramIntent.putExtra("PhotoConst.32_Bit_Config", true);
    if (paramInt5 > -1)
    {
      paramIntent.putExtra("keyAction", "actionSelectPicture");
      paramActivity.startActivityForResult(paramIntent, paramInt5);
    }
    else
    {
      paramActivity.startActivity(paramIntent);
    }
    AlbumUtil.anim(paramActivity, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoUtils
 * JD-Core Version:    0.7.0.1
 */