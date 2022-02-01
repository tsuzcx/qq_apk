package com.tencent.mobileqq.activity.photo.album;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.widget.TextView;
import com.tencent.component.media.image.ImageManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomization;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AppOpenConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class QQAlbumUtils
{
  public static int a(List<String> paramList, int paramInt, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = null;
      if (paramMap2 != null) {
        paramList = (LocalMediaInfo)paramMap2.get(str);
      }
      Object localObject = paramList;
      if (paramList == null)
      {
        localObject = paramList;
        if (paramMap1 != null) {
          localObject = (LocalMediaInfo)paramMap1.get(str);
        }
      }
      if ((localObject == null) || (QAlbumUtil.getMediaType((LocalMediaInfo)localObject) != 1))
      {
        long l1 = new File(str).length();
        long l2 = paramInt;
        if (l1 > l2)
        {
          i += 1;
          StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "sendQualityPicLimit", true, l2, l1, null, "");
        }
      }
    }
    return i;
  }
  
  public static int a(List<String> paramList, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, HashMap<String, PhotoSendParams> paramHashMap, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long l;
      if ((paramHashMap != null) && (ImageManager.isNetworkUrl(str)))
      {
        if (paramHashMap.get(str) != null)
        {
          l = ((PhotoSendParams)paramHashMap.get(str)).fileSize;
        }
        else
        {
          paramList = new StringBuilder();
          paramList.append("mSelectedSendParams.get(p) == null path:");
          paramList.append(str);
          QLog.w("_photo", 1, paramList.toString());
          l = 0L;
        }
      }
      else
      {
        paramList = null;
        if (paramMap2 != null) {
          paramList = (LocalMediaInfo)paramMap2.get(str);
        }
        if ((paramList == null) && (paramMap1 != null)) {
          paramList = (LocalMediaInfo)paramMap1.get(str);
        }
        l = new File(str).length();
      }
      int j = (int)(i + l);
      i = j;
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("setQualityTextViewText, path:");
        paramList.append(str);
        paramList.append(",len:");
        paramList.append(l);
        QLog.d("_photo", 2, paramList.toString());
        i = j;
      }
    }
    return i;
  }
  
  public static URLDrawable a(URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mFailedDrawable = paramDrawable2;
    localURLDrawableOptions.mPlayGifImage = false;
    return URLDrawable.getDrawable(paramURL, localURLDrawableOptions);
  }
  
  public static String a(Context paramContext, float paramFloat)
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
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("userAlbumSourceTypeStatistic (");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt5);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt6);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt7);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt8);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt9);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt10);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt11);
      ((StringBuilder)localObject).append(")");
      QLog.d("QQAlbum", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    long l1 = ((SharedPreferences)localObject).getLong("PhotoConst.last_album_source_type", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("");
      localHashMap.put("param_systemAlbumCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("");
      localHashMap.put("param_screnshot_qq_cnt", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("");
      localHashMap.put("param_screnshot_other_cnt", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("");
      localHashMap.put("param_appCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt5);
      localStringBuilder.append("");
      localHashMap.put("param_otherCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt6);
      localStringBuilder.append("");
      localHashMap.put("param_qq_collection_cnt", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt8);
      localStringBuilder.append("");
      localHashMap.put("param_qq_filerecv_cnt", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt7);
      localStringBuilder.append("");
      localHashMap.put("param_qq_image_cnt", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt9);
      localStringBuilder.append("");
      localHashMap.put("param_qq_zebra_cnt", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt10);
      localStringBuilder.append("");
      localHashMap.put("param_qq_favorite_cnt", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt11);
      localStringBuilder.append("");
      localHashMap.put("param_weixinCnt", localStringBuilder.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actAlbumPicSourceType", false, 0L, 0L, localHashMap, "", false);
      ((SharedPreferences)localObject).edit().putLong("PhotoConst.last_album_source_type", l2).commit();
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, String paramString)
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
          QLog.e("QQAlbum", 2, "[onSendResult] data = null");
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
      else if (paramActivity.getIntent().getIntExtra("uintype", -1) == 10014)
      {
        paramIntent = (Intent)paramActivity.getIntent().getParcelableExtra("key_guild_open_aio_intent");
        if (paramIntent != null) {
          paramActivity.startActivity(paramIntent);
        } else {
          QLog.e("QQAlbum", 1, "OpenGuild Error ! guildIntent is null!");
        }
      }
      else
      {
        paramIntent = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        localIntent.setClassName(paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramIntent);
        if (!paramBoolean)
        {
          localIntent.addFlags(603979776);
          paramActivity.startActivity(localIntent);
        }
        else
        {
          QLog.e("QQAlbum", 1, "Watermark has been deleted!");
        }
      }
      paramActivity.finish();
      QAlbumUtil.anim(paramActivity, false, false);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      FileProvider7Helper.savePhotoToSysAlbum(paramContext, paramString);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QQAlbum", 2, "scanMediaFile :", paramContext);
    }
  }
  
  public static void a(Intent paramIntent, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", paramBoolean);
      paramIntent.putExtra("ALBUM_ID", paramString1);
      paramIntent.putExtra("PhotoConst.LAST_ALBUMPATH", paramString2);
    }
  }
  
  public static void a(TextView paramTextView, List<String> paramList, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Activity paramActivity, HashMap<String, PhotoSendParams> paramHashMap, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!ImageManager.isNetworkUrl(str))
      {
        LocalMediaInfo localLocalMediaInfo1 = null;
        if (paramMap2 != null) {
          localLocalMediaInfo1 = (LocalMediaInfo)paramMap2.get(str);
        }
        LocalMediaInfo localLocalMediaInfo2 = localLocalMediaInfo1;
        if (localLocalMediaInfo1 == null)
        {
          localLocalMediaInfo2 = localLocalMediaInfo1;
          if (paramMap1 != null) {
            localLocalMediaInfo2 = (LocalMediaInfo)paramMap1.get(str);
          }
        }
        if (localLocalMediaInfo2 != null) {
          QAlbumUtil.getMediaType(localLocalMediaInfo2);
        }
      }
    }
    int i = a(paramList, paramMap1, paramBoolean, paramHashMap, paramMap2);
    if (i == 0)
    {
      paramTextView.setVisibility(4);
      return;
    }
    paramMap1 = a(paramActivity, i);
    paramBoolean = paramMap1.equals("0");
    i = 0;
    if (paramBoolean)
    {
      paramTextView.setVisibility(4);
      paramMap1 = "(999K)";
    }
    else
    {
      paramActivity = new StringBuilder();
      paramActivity.append("(");
      paramActivity.append(paramMap1);
      paramActivity.append(")");
      paramMap1 = paramActivity.toString();
      paramTextView.setVisibility(0);
    }
    int j = paramMap1.length();
    while (i < 6 - j)
    {
      paramActivity = new StringBuilder();
      paramActivity.append(paramMap1);
      paramActivity.append(" ");
      paramMap1 = paramActivity.toString();
      i += 1;
    }
    paramTextView.setText(paramMap1);
    if (paramList.isEmpty()) {
      paramTextView.setVisibility(4);
    }
  }
  
  public static void a(LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      paramLocalMediaInfo.mediaHeight = localOptions.outHeight;
      paramLocalMediaInfo.mediaWidth = localOptions.outWidth;
      paramLocalMediaInfo.mMimeType = localOptions.outMimeType;
      paramLocalMediaInfo.addedDate = System.currentTimeMillis();
      paramLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      paramLocalMediaInfo.path = paramString;
      paramLocalMediaInfo.panoramaPhotoType = 3;
      paramLocalMediaInfo.fileSize = new File(paramString).length();
      return;
    }
    catch (Exception paramLocalMediaInfo)
    {
      QLog.e("QQAlbum", 2, "decode image error", paramLocalMediaInfo);
    }
  }
  
  public static void a(PhotoListCustomization<? extends OtherCommonData> paramPhotoListCustomization)
  {
    if ((paramPhotoListCustomization != null) && (((paramPhotoListCustomization.g.O) && ("$RecentAlbumId".equals(paramPhotoListCustomization.e.albumId))) || ((paramPhotoListCustomization.g.P) && ("$VideoAlbumId".equals(paramPhotoListCustomization.e.albumId))))) {
      paramPhotoListCustomization.h.c(true);
    }
  }
  
  public static void a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.getAbsolutePath());
      localStringBuilder.append("/.nomedia");
      paramString = new File(localStringBuilder.toString());
      if (!paramString.exists()) {
        try
        {
          paramString.createNewFile();
          return;
        }
        catch (IOException paramString)
        {
          QLog.e("QQAlbum", 1, "createNewFile error, ", paramString);
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject = new File(paramString).getParentFile().getName();
      paramString = new StringBuilder(AppConstants.SDCARD_IMG_CAMERA);
      paramString.append((String)localObject);
      paramString.append(".mp4");
      localObject = new File(AppConstants.SDCARD_IMG_CAMERA);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      QZLog.i("QQAlbum", 1, "get target path error encode error", paramString);
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    if ((paramString != null) && (paramString.startsWith(AppOpenConstants.d))) {
      return paramString;
    }
    try
    {
      File localFile = new File(paramString);
      if (localFile.exists())
      {
        String str = localFile.getName();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AppConstants.SDCARD_IMG_CAMERA);
        ((StringBuilder)localObject).append(str);
        str = ((StringBuilder)localObject).toString();
        if (!str.equals(paramString))
        {
          localObject = new File(AppConstants.SDCARD_IMG_CAMERA);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdirs();
          }
          boolean bool2 = localFile.renameTo(new File(str));
          boolean bool1 = bool2;
          if (!bool2) {
            bool1 = FileUtils.moveFile(paramString, str);
          }
          QLog.d("QQAlbum", 2, new Object[] { "saveToDCIM rename to :", str });
          if (bool1) {
            return str;
          }
          return paramString;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQAlbum", 2, "saveToDCIM :", localThrowable);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.QQAlbumUtils
 * JD-Core Version:    0.7.0.1
 */