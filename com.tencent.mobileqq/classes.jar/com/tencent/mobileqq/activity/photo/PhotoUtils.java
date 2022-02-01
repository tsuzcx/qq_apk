package com.tencent.mobileqq.activity.photo;

import aevv;
import akgm;
import akgy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.text.TextUtils;
import anni;
import bcst;
import bctj;
import bgjw;
import bgkc;
import bgmo;
import blfh;
import blfq;
import bljn;
import blsb;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicProxyActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import cooperation.troop.TroopFileProxyActivity;
import java.io.File;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class PhotoUtils
{
  public static SimpleDateFormat a = new SimpleDateFormat("yyyy年MM月dd HH点mm分");
  public static SimpleDateFormat b = new SimpleDateFormat("yyyy年MM月dd HH点");
  
  public static int a(SessionInfo paramSessionInfo)
  {
    int i = 0;
    if (paramSessionInfo != null) {}
    switch (paramSessionInfo.a)
    {
    default: 
      i = 5;
      return i;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  public static long a()
  {
    return System.currentTimeMillis();
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt)
  {
    new Canvas(paramBitmap1).drawBitmap(paramBitmap2, 0.0F, paramInt, null);
    return paramBitmap1;
  }
  
  /* Error */
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 55	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_1
    //   12: ifnull +47 -> 59
    //   15: aload_2
    //   16: astore_0
    //   17: aload_1
    //   18: getfield 62	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   21: ifeq +38 -> 59
    //   24: aload_2
    //   25: astore_0
    //   26: new 64	java/io/BufferedInputStream
    //   29: dup
    //   30: aload_2
    //   31: sipush 8192
    //   34: invokespecial 67	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   37: aconst_null
    //   38: aload_1
    //   39: invokestatic 73	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_0
    //   46: astore_1
    //   47: aload_2
    //   48: ifnull +9 -> 57
    //   51: aload_2
    //   52: invokevirtual 78	java/io/InputStream:close	()V
    //   55: aload_0
    //   56: astore_1
    //   57: aload_1
    //   58: areturn
    //   59: aload_2
    //   60: astore_0
    //   61: new 64	java/io/BufferedInputStream
    //   64: dup
    //   65: aload_2
    //   66: sipush 8192
    //   69: invokespecial 67	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   72: aconst_null
    //   73: aload_1
    //   74: invokestatic 73	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: goto -35 -> 45
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_2
    //   86: aload_2
    //   87: astore_0
    //   88: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +14 -> 105
    //   94: aload_2
    //   95: astore_0
    //   96: ldc 86
    //   98: iconst_2
    //   99: ldc 88
    //   101: aload_1
    //   102: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload_3
    //   106: astore_1
    //   107: aload_2
    //   108: ifnull -51 -> 57
    //   111: aload_2
    //   112: invokevirtual 78	java/io/InputStream:close	()V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_0
    //   118: aconst_null
    //   119: areturn
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: astore_0
    //   125: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +14 -> 142
    //   131: aload_2
    //   132: astore_0
    //   133: ldc 86
    //   135: iconst_2
    //   136: ldc 88
    //   138: aload_1
    //   139: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: aload_3
    //   143: astore_1
    //   144: aload_2
    //   145: ifnull -88 -> 57
    //   148: aload_2
    //   149: invokevirtual 78	java/io/InputStream:close	()V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_0
    //   155: aconst_null
    //   156: areturn
    //   157: astore_1
    //   158: aconst_null
    //   159: astore_0
    //   160: aload_0
    //   161: ifnull +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 78	java/io/InputStream:close	()V
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: aload_0
    //   172: areturn
    //   173: astore_0
    //   174: goto -6 -> 168
    //   177: astore_1
    //   178: goto -18 -> 160
    //   181: astore_1
    //   182: goto -59 -> 123
    //   185: astore_1
    //   186: goto -100 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramString	String
    //   0	189	1	paramOptions	BitmapFactory.Options
    //   10	139	2	localFileInputStream	java.io.FileInputStream
    //   1	142	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	83	java/lang/OutOfMemoryError
    //   111	115	117	java/io/IOException
    //   2	11	120	java/lang/Exception
    //   148	152	154	java/io/IOException
    //   2	11	157	finally
    //   51	55	170	java/io/IOException
    //   164	168	173	java/io/IOException
    //   17	24	177	finally
    //   26	43	177	finally
    //   61	78	177	finally
    //   88	94	177	finally
    //   96	105	177	finally
    //   125	131	177	finally
    //   133	142	177	finally
    //   17	24	181	java/lang/Exception
    //   26	43	181	java/lang/Exception
    //   61	78	181	java/lang/Exception
    //   17	24	185	java/lang/OutOfMemoryError
    //   26	43	185	java/lang/OutOfMemoryError
    //   61	78	185	java/lang/OutOfMemoryError
  }
  
  public static String a(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    default: 
      localStringBuilder.append("照片 ");
    }
    for (;;)
    {
      localStringBuilder.append("拍摄时间: ");
      paramLocalMediaInfo = new Date(paramLocalMediaInfo.modifiedDate * 1000L);
      localStringBuilder.append(a.format(paramLocalMediaInfo));
      return localStringBuilder.toString();
      localStringBuilder.append("视频 ");
    }
  }
  
  public static String a(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    default: 
      localStringBuilder.append("照片 ");
    }
    for (;;)
    {
      localStringBuilder.append("拍摄时间: ");
      paramLocalMediaInfo = new Date(paramLocalMediaInfo.modifiedDate * 1000L);
      localStringBuilder.append(b.format(paramLocalMediaInfo));
      return localStringBuilder.toString();
      localStringBuilder.append("视频 ");
    }
  }
  
  public static String a(Context paramContext, float paramFloat)
  {
    paramFloat /= 1024000;
    if (paramFloat >= 10.0F)
    {
      paramContext = new DecimalFormat("0");
      return paramContext.format(paramFloat) + "M";
    }
    if (paramFloat >= 1.0F)
    {
      paramContext = new DecimalFormat("0.0");
      return paramContext.format(paramFloat) + "M";
    }
    if (paramFloat >= 0.001D)
    {
      paramContext = new DecimalFormat("0");
      return paramContext.format(paramFloat * 1024.0F) + "K";
    }
    if (paramFloat >= 0.0001D)
    {
      paramContext = new DecimalFormat("0.0");
      return paramContext.format(paramFloat * 1024.0F) + "K";
    }
    return "0.1K";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    a(paramString, localOptions);
    return localOptions.outMimeType;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
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
    paramString3.append(localCalendar.get(1));
    int i = localCalendar.get(2) + 1;
    if (i < 10)
    {
      paramString1 = "0" + i;
      paramString3.append(paramString1);
      i = localCalendar.get(5);
      if (i >= 10) {
        break label316;
      }
      paramString1 = "0" + i;
      label126:
      paramString3.append(paramString1);
      i = localCalendar.get(11);
      if (i >= 10) {
        break label324;
      }
      paramString1 = "0" + i;
      label166:
      paramString3.append(paramString1);
      i = localCalendar.get(12);
      if (i >= 10) {
        break label332;
      }
      paramString1 = "0" + i;
      label206:
      paramString3.append(paramString1);
      i = localCalendar.get(13);
      if (i >= 10) {
        break label340;
      }
    }
    label316:
    label324:
    label332:
    label340:
    for (paramString1 = "0" + i;; paramString1 = Integer.valueOf(i))
    {
      paramString3.append(paramString1);
      if (new File(paramString3.toString() + paramString2).exists()) {
        break label348;
      }
      return paramString3.toString() + paramString2;
      paramString1 = Integer.valueOf(i);
      break;
      paramString1 = Integer.valueOf(i);
      break label126;
      paramString1 = Integer.valueOf(i);
      break label166;
      paramString1 = Integer.valueOf(i);
      break label206;
    }
    label348:
    paramString1 = new StringBuilder(paramString3);
    int j = paramString3.length();
    i = 1;
    for (;;)
    {
      if (i < 2147483647)
      {
        paramString1.append('(');
        paramString1.append(i);
        paramString1.append(')');
        paramString1.append(paramString2);
        if (new File(paramString1.toString()).exists()) {}
      }
      else
      {
        return paramString1.toString();
      }
      paramString1.delete(j, paramString1.length());
      i += 1;
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean)
  {
    if ((paramActivity != null) && (((BaseActivity)paramActivity).app != null)) {
      a(paramActivity, paramInt1, paramInt2, paramIntent, paramBoolean, ((BaseActivity)paramActivity).app.getCurrentAccountUin());
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, String paramString)
  {
    if (paramIntent != null) {
      paramIntent.removeExtra("PhotoConst.VIDEO_INFOS");
    }
    Intent localIntent;
    if (((paramInt1 == 2) || (paramInt1 == 7001)) && (paramInt2 == -1))
    {
      localIntent = paramIntent;
      if (paramIntent == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoUtils", 2, "[onSendResult] data = null");
        }
        localIntent = new Intent();
      }
      localIntent.putExtra("PhotoConst.send_photo_activity_result", -1);
      if (paramInt1 != 7001) {
        break label176;
      }
      paramIntent = paramActivity.getIntent();
      String str1 = paramIntent.getStringExtra("UploadPhoto.key_album_id");
      String str2 = paramIntent.getStringExtra("UploadPhoto.key_album_name");
      blsb.a(paramString, paramIntent.getStringExtra("uin"), str1, str2);
      paramIntent.putExtras(localIntent);
      paramString = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      paramIntent.setClassName(paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramString);
      if (!paramBoolean)
      {
        paramIntent.addFlags(603979776);
        paramActivity.startActivity(paramIntent);
      }
    }
    for (;;)
    {
      paramActivity.finish();
      bgkc.anim(paramActivity, false, false);
      return;
      label176:
      paramIntent = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localIntent.setClassName(paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramIntent);
      if (!paramBoolean)
      {
        localIntent.addFlags(603979776);
        akgm.a(localIntent);
        paramActivity.startActivity(localIntent);
      }
      else
      {
        QLog.e("PhotoUtils", 1, "Watermark has been deleted!");
      }
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), str1);
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    if (paramArrayList.size() == 1) {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
    }
    paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    paramIntent.putExtra("PhotoConst.SEND_FLAG", true);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, "sendPhotoForPhotoPlus , activity = " + paramActivity + ",data = " + paramIntent.getExtras());
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
      if (("com.tencent.mobileqq.activity.SplashActivity".equals(paramArrayList)) && ("com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(str1)) && ("com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(str2)))
      {
        paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramArrayList);
        paramIntent.putExtra("open_chatfragment_fromphoto", true);
        paramActivity.startActivity(paramIntent);
      }
    }
    while (!"qzone_plugin.apk".equals(paramIntent.getStringExtra("PhotoConst.PLUGIN_APK"))) {
      for (;;)
      {
        if (bgjw.b(paramIntent.getStringExtra("uin"))) {
          bcst.b(null, "dc00898", "", "", "0X8007249", "0X8007249", 0, 0, "", "", "", "");
        }
        paramActivity.finish();
        return;
        if ("com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(str1)) {
          paramIntent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.SplashActivity");
        }
      }
    }
    if ((!str1.contains("QZone")) && (paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME") != null)) {}
    for (paramArrayList = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");; paramArrayList = str1)
    {
      paramIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
      str1 = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      str2 = paramIntent.getStringExtra("PhotoConst.UIN");
      if (!"qzone_plugin.apk".equals(str1)) {
        break;
      }
      QzonePluginProxyActivity.a(paramIntent, paramArrayList);
      paramIntent.putExtra("cleartop", true);
      blsb.a(paramActivity, str2, paramIntent, -1);
      break;
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
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
    String str3 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME");
    str1 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
    String str2;
    if (!TextUtils.isEmpty(str1))
    {
      str2 = str3;
      if (!TextUtils.isEmpty(str3)) {}
    }
    else
    {
      str2 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      str1 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, String.format("sendPhoto packageName=%s className=%s", new Object[] { str2, str1 }));
    }
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1)))
    {
      paramArrayList = paramIntent.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME");
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, String.format("sendPhoto action=%s", new Object[] { paramArrayList }));
      }
      if (TextUtils.isEmpty(paramArrayList)) {
        QQToast.a(paramActivity, anni.a(2131706913), 0).a();
      }
    }
    for (;;)
    {
      return;
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
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, String.format("sendPhoto extras=%s", new Object[] { paramIntent.getExtras() }));
      }
      paramIntent.setClassName(str2, str1);
      paramIntent.addFlags(603979776);
      boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "sendPhoto isCallFromPlugin=" + bool1 + "className=" + str1);
      }
      boolean bool2 = paramIntent.getBooleanExtra("PhotoConst.is_troop_send_mixed_msg", false);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "sendPhoto isTroopSendMixedMsg = " + bool2);
      }
      boolean bool3 = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
      if (bool2)
      {
        a(paramActivity, paramIntent, paramArrayList, paramInt);
        paramActivity.finish();
        bool1 = paramBoolean;
      }
      while (!bool1)
      {
        paramActivity.finish();
        bgkc.anim(paramActivity, false, false);
        return;
        if (bool3)
        {
          a(paramActivity, paramIntent, paramArrayList, paramInt);
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
          else if (str1.equals(ReadInJoyUploadAvatarFragment.class.getName()))
          {
            bool1 = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
            paramIntent.putExtra("keyAction", "actionSelectPicture");
            paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
            aevv.a(paramActivity, paramIntent, PublicTransFragmentActivity.class, ReadInJoyUploadAvatarFragment.class, 2);
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
          str2 = paramIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
          str3 = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
          String str4 = paramIntent.getStringExtra("PhotoConst.UIN");
          if ("qzone_plugin.apk".equals(str3))
          {
            if (str1.equals("com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity"))
            {
              a(paramActivity, (String)paramArrayList.get(0), paramIntent.getIntExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", 0));
              bool1 = paramBoolean;
            }
            else
            {
              QzonePluginProxyActivity.a(paramIntent, str1);
              paramIntent.putExtra("cleartop", true);
              paramIntent.putExtra("PhotoConst.IS_FROM_PHOTO_LIST", true);
              blsb.a(paramActivity, str4, paramIntent, -1);
              bool1 = false;
            }
          }
          else if ("qqfav.apk".equals(str3))
          {
            bljn.a(paramActivity, str4, paramIntent, 2);
            bool1 = paramBoolean;
          }
          else if ("qqsmartdevice.apk".equals(str3))
          {
            paramIntent.putExtra("cleartop", true);
            paramArrayList = new blfq(0);
            paramArrayList.jdField_b_of_type_JavaLangString = str3;
            paramArrayList.d = str2;
            paramArrayList.jdField_a_of_type_JavaLangString = str4;
            paramArrayList.e = str1;
            paramArrayList.jdField_a_of_type_JavaLangClass = SmartDevicePluginProxyActivity.class;
            paramArrayList.jdField_a_of_type_AndroidContentIntent = paramIntent;
            paramArrayList.jdField_b_of_type_Int = 2;
            blfh.a(paramActivity, paramArrayList);
            bool1 = paramBoolean;
          }
          else
          {
            bool1 = paramBoolean;
            if ("comic_plugin.apk".equals(str3))
            {
              paramIntent.putExtra("cleartop", true);
              paramArrayList = new blfq(0);
              paramArrayList.jdField_b_of_type_JavaLangString = str3;
              paramArrayList.d = str2;
              paramArrayList.jdField_a_of_type_JavaLangString = str4;
              paramArrayList.e = str1;
              paramArrayList.jdField_a_of_type_JavaLangClass = VipComicProxyActivity.a(str1);
              paramArrayList.jdField_a_of_type_AndroidContentIntent = paramIntent;
              paramArrayList.jdField_b_of_type_Int = 2;
              blfh.a(paramActivity, paramArrayList);
              bool1 = paramBoolean;
            }
          }
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList, HashMap<String, PhotoSendParams> paramHashMap, int paramInt, boolean paramBoolean)
  {
    paramIntent.setExtrasClassLoader(PhotoSendParams.class.getClassLoader());
    Object localObject = paramIntent.getStringExtra("PHOTO_KEY_FRIEND_UIN");
    if (localObject != null) {
      paramIntent.putExtra("uin", (String)localObject);
    }
    localObject = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramArrayList.size())
    {
      PhotoSendParams localPhotoSendParams = (PhotoSendParams)paramHashMap.get(paramArrayList.get(i));
      if (localPhotoSendParams != null)
      {
        ((HashMap)localObject).put(localPhotoSendParams.thumbPath, localPhotoSendParams);
        if (QLog.isColorLevel()) {
          QLog.d("aioSendPhotos", 2, new Object[] { "[Qzone] thumbPath:", localPhotoSendParams.thumbPath, " photoSendParams:", localPhotoSendParams.toString() });
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (!ImageManager.isNetworkUrl((String)paramArrayList.get(i)))
        {
          localArrayList.add(paramArrayList.get(i));
          if (QLog.isColorLevel()) {
            QLog.d("aioSendPhotos", 2, new Object[] { "[QQ] local path:", paramArrayList.get(i) });
          }
        }
        else
        {
          QLog.w("aioSendPhotos", 2, "[Error] path:" + (String)paramArrayList.get(i));
        }
      }
    }
    paramIntent.putExtra("PhotoConst.photo_send_pic_type", (Serializable)localObject);
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
    localObject = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME");
    paramHashMap = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
    if (!TextUtils.isEmpty(paramHashMap))
    {
      paramArrayList = (ArrayList<String>)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    else
    {
      paramArrayList = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      paramHashMap = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, String.format("sendPhoto packageName=%s className=%s", new Object[] { paramArrayList, paramHashMap }));
    }
    if ((TextUtils.isEmpty(paramArrayList)) || (TextUtils.isEmpty(paramHashMap)))
    {
      paramArrayList = paramIntent.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME");
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, String.format("sendPhoto action=%s", new Object[] { paramArrayList }));
      }
      if (TextUtils.isEmpty(paramArrayList)) {
        QQToast.a(paramActivity, anni.a(2131706914), 0).a();
      }
    }
    for (;;)
    {
      return;
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
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, String.format("sendPhoto extras=%s", new Object[] { paramIntent.getExtras() }));
      }
      paramIntent.setClassName(paramArrayList, paramHashMap);
      paramIntent.addFlags(603979776);
      boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "sendPhoto isCallFromPlugin=" + bool1 + "className=" + paramHashMap);
      }
      boolean bool2 = paramIntent.getBooleanExtra("PhotoConst.is_troop_send_mixed_msg", false);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "sendPhoto isTroopSendMixedMsg = " + bool2);
      }
      if (!bool1)
      {
        if (!paramHashMap.equals("com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity")) {
          break label702;
        }
        paramIntent.putExtra("cleartop", true);
        TroopFileProxyActivity.a(paramActivity, paramIntent, 2, null);
      }
      while (!paramBoolean)
      {
        paramActivity.finish();
        bgkc.anim(paramActivity, false, false);
        return;
        label702:
        paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
        paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
        if (paramIntent.getBooleanExtra("sIsCloudPrinter", false)) {
          paramActivity.startActivityForResult(paramIntent, 102);
        } else {
          paramActivity.startActivityForResult(paramIntent, 2);
        }
      }
    }
  }
  
  public static final void a(Context paramContext, Intent paramIntent, ArrayList<String> paramArrayList, int paramInt)
  {
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
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, "sendPhotoFromAio activity = " + str + ", packageName = " + paramIntent + ", data = " + localIntent.getExtras());
    }
    localIntent.putExtra("open_chatfragment_fromphoto", true);
    paramContext.startActivity(localIntent);
  }
  
  static void a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action.com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity.cover_img_crop_end");
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void a(Intent paramIntent, Activity paramActivity)
  {
    String str = paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), str);
    paramIntent.addFlags(603979776);
    paramActivity.startActivity(paramIntent);
    paramActivity.finish();
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    a(paramIntent, paramActivity, paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2, -1);
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    paramIntent.setClass(paramActivity, NewPhotoListActivity.class);
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
    for (;;)
    {
      bgkc.anim(paramActivity, false, true);
      return;
      paramActivity.startActivity(paramIntent);
    }
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    int i = paramIntent.getIntExtra("Business_Origin", 0);
    if ((100 == i) || (102 == i) || (103 == i))
    {
      paramIntent.setClass(paramActivity, PhotoCropForPortraitActivity.class);
      paramIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", akgy.c(i));
    }
    for (;;)
    {
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
      bgkc.anim(paramActivity, false, true);
      return;
      paramIntent.setClass(paramActivity, PhotoCropActivity.class);
    }
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, int paramInt5)
  {
    int i = paramIntent.getIntExtra("Business_Origin", 0);
    if ((100 == i) || (102 == i) || (103 == i))
    {
      paramIntent.setClass(paramActivity, PhotoCropForPortraitActivity.class);
      paramIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", akgy.c(i));
    }
    for (;;)
    {
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
      bgkc.anim(paramActivity, false, true);
      return;
      paramIntent.setClass(paramActivity, PhotoCropActivity.class);
    }
  }
  
  public static void a(Intent paramIntent1, Intent paramIntent2)
  {
    boolean bool = paramIntent1.getBooleanExtra("custom_photopreview_sendbtn_report", false);
    String str1 = paramIntent1.getStringExtra("custom_photopreview_sendbtn_reportActionName");
    String str2 = paramIntent1.getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
    paramIntent1 = paramIntent1.getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
    paramIntent2.putExtra("custom_photopreview_sendbtn_report", bool);
    paramIntent2.putExtra("custom_photopreview_sendbtn_reportActionName", str1);
    paramIntent2.putExtra("custom_photopreview_sendbtn_album_reportReverse2", str2);
    paramIntent2.putExtra("custom_photopreview_sendbtn_camera_reportReverse2", paramIntent1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      String str;
      Iterator localIterator;
      switch (paramInt)
      {
      case 1: 
      default: 
        str = "Send_compress";
        localIterator = paramArrayList.iterator();
        paramInt = 0;
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label140;
        }
        Object localObject = (String)localIterator.next();
        if (localObject == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PhotoUtils", 2, "reportSendSize sendReportType:path == null");
          continue;
          str = "Send_compress";
          break;
          str = "Send_raw";
          break;
        }
        localObject = new File((String)localObject);
        long l = paramInt;
        paramInt = (int)(((File)localObject).length() + l);
      }
      label140:
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, "reportSendSize sendReportType:" + str + ",count:" + paramArrayList.size() + ",totalSize:" + paramInt);
      }
      a(paramQQAppInterface, str, paramArrayList.size(), paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    bctj.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "Pic_edit", paramString, 0, 1, null, String.valueOf(paramInt1), null, String.valueOf(paramInt2), null);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      bgmo.a(paramString, localOptions);
      int i = localOptions.outHeight;
      int j = localOptions.outWidth;
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "isLargeFile w:" + j + ",h:" + i);
      }
      boolean bool1 = bool2;
      if (i != -1)
      {
        bool1 = bool2;
        if (j != -1) {
          if (i <= j * 3)
          {
            bool1 = bool2;
            if (j <= i * 3) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("_photo", 1, paramString, new Object[0]);
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        QLog.e("_photo", 1, paramString, new Object[0]);
      }
    }
  }
  
  public static int b(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return -1;
    }
    if (paramSessionInfo.a == 3000) {
      return 2;
    }
    return a(paramSessionInfo);
  }
  
  public static boolean b(String paramString)
  {
    paramString = a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.contains("image/jpeg");
  }
  
  public static int c(SessionInfo paramSessionInfo)
  {
    int i = 0;
    if (paramSessionInfo != null) {}
    switch (paramSessionInfo.a)
    {
    default: 
      i = -1;
      return i;
    case 0: 
      return 1;
    case 1: 
      return 2;
    case 1000: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1020: 
    case 1021: 
    case 1022: 
    case 1023: 
    case 1025: 
    case 7400: 
    case 10004: 
    case 10008: 
      return 3;
    case 3000: 
      return 4;
    }
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoUtils
 * JD-Core Version:    0.7.0.1
 */