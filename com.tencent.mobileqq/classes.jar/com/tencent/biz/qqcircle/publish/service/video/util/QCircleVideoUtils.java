package com.tencent.biz.qqcircle.publish.service.video.util;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Video.Thumbnails;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.biz.qqcircle.publish.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.UUID;

public class QCircleVideoUtils
{
  private static final String a = QCircleConstants.v;
  private static final String b;
  private static int c = 480;
  private static String d = QCircleConfigHelper.a("QZoneTextSetting", "NetWorkShouldCheck", "网络无连接，请检查你的网络连接");
  private static String e = QCircleConfigHelper.a("QZoneTextSetting", "ToastStartLiveVideoFailForErrorParam", "参数错误，无法启动, mode=");
  private static String f = QCircleConfigHelper.a("QZoneTextSetting", "ToastStartLiveVideoFailForErrorVersion", "系统版本不满足要求，无法启动直播");
  private static String g = QCircleConfigHelper.a("QZoneTextSetting", "ToastStartLiveVideoFailForErrorHardware", "手机硬件不满足要求，无法启动直播");
  private static String h = QCircleConfigHelper.a("QZoneTextSetting", "ToastStartLiveVideoFailForMemory", "SD卡不存在或手机内存不足");
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VFSAssistantUtils.getSDKPrivatePath("qcircle"));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("cover");
    b = localStringBuilder.toString();
  }
  
  public static double a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong2 != 0L))
    {
      long l;
      if (paramLong1 != 0L)
      {
        l = paramLong1;
        if (paramLong1 >= paramLong2) {}
      }
      else
      {
        l = paramLong2;
      }
      paramLong1 = new File(paramString).length();
      if (!paramBoolean2) {
        return paramLong1;
      }
      double d1;
      double d2;
      if (paramBoolean1)
      {
        d1 = paramLong1;
        Double.isNaN(d1);
        d2 = l;
        Double.isNaN(d2);
        d1 = d1 * 1.0D / d2;
        d2 = paramLong2;
        Double.isNaN(d2);
        d2 = d1 * d2;
        d1 = d2;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getVideoEstimateSize, estimateSize=");
          paramString.append(d2);
          QLog.d("[upload2]QCircleVideoUtils", 2, paramString.toString());
          return d2;
        }
      }
      else
      {
        int i = QCircleConfigHelper.a("MiniVideo", "VideoMaxBitrate", Integer.valueOf(3000000)).intValue();
        d1 = paramLong2;
        Double.isNaN(d1);
        d1 = d1 * 1.0D / 1000.0D;
        d2 = i;
        Double.isNaN(d2);
        d2 = Math.min(d1 * d2 / 8.0D, paramLong1);
        d1 = d2;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getVideoEstimateSize, totalDuration=");
          paramString.append(l);
          paramString.append(", duration=");
          paramString.append(paramLong2);
          paramString.append(", estimateSize=");
          paramString.append(d2);
          QLog.d("[upload2]QCircleVideoUtils", 2, paramString.toString());
          d1 = d2;
        }
      }
      return d1;
    }
    return 0.0D;
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    int i = 209715200;
    if (!paramBoolean) {
      return QCircleConfigHelper.a("MiniVideo", "videoTrimMinAvailRam", Integer.valueOf(209715200)).intValue();
    }
    if ("ultrafast".equalsIgnoreCase(paramString)) {
      return QCircleConfigHelper.a("MiniVideo", "videoTrimUltrafastAvailRam", Integer.valueOf(314572800)).intValue();
    }
    if ("superfast".equalsIgnoreCase(paramString)) {
      return QCircleConfigHelper.a("MiniVideo", "videoTrimSuperfastAvailRam", Integer.valueOf(419430400)).intValue();
    }
    if ("medium".equalsIgnoreCase(paramString)) {
      i = QCircleConfigHelper.a("MiniVideo", "videoTrimMediumAvailRam", Integer.valueOf(629145600)).intValue();
    }
    return i;
  }
  
  public static ShuoshuoVideoInfo a(Context paramContext, long paramLong1, String paramString1, long paramLong2, int paramInt1, String paramString2, int paramInt2, int paramInt3, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("[upload2]QCircleVideoUtils", 1, new Object[] { "prepareVideoInfos... videoId:", Long.valueOf(paramLong1), " videoPath:", paramString1, " size:", Long.valueOf(paramLong2), " videoType:", Integer.valueOf(paramInt1), " thumbnailPath:", paramString2, " thumbnailHeight:", Integer.valueOf(paramInt2), " thumbnailWidth:", Integer.valueOf(paramInt3), " startTime:", Long.valueOf(paramLong3), " duration:", Long.valueOf(paramLong4), " totalDuration:", Long.valueOf(paramLong5), " needProcess:", Boolean.valueOf(paramBoolean) });
    if (!new File(paramString1).exists())
    {
      paramContext = new StringBuilder();
      paramContext.append("Path:");
      paramContext.append(paramString1);
      paramContext.append(", not exits!");
      QLog.e("[upload2]QCircleVideoUtils", 1, paramContext.toString());
      return null;
    }
    ShuoshuoVideoInfo localShuoshuoVideoInfo = new ShuoshuoVideoInfo();
    localShuoshuoVideoInfo.b = paramString1;
    localShuoshuoVideoInfo.g = paramLong2;
    localShuoshuoVideoInfo.m = paramInt1;
    if (paramInt1 == 0)
    {
      localShuoshuoVideoInfo.i = 1;
      localShuoshuoVideoInfo.s = (500L * paramLong5 / 8L);
    }
    else if (paramInt1 == 1)
    {
      localShuoshuoVideoInfo.i = 102;
      localShuoshuoVideoInfo.s = a(paramString1, paramLong5, paramLong4, false, paramBoolean);
    }
    QLog.d("[upload2]QCircleVideoUtils", 1, new Object[] { "prepareVideoInfos... video coverUrl:", localShuoshuoVideoInfo.h });
    a(paramContext, paramLong1, paramString1, paramString2, paramInt2, paramInt3, localShuoshuoVideoInfo);
    localShuoshuoVideoInfo.o = paramLong3;
    localShuoshuoVideoInfo.p = (paramLong3 + paramLong4);
    localShuoshuoVideoInfo.n = paramBoolean;
    localShuoshuoVideoInfo.f = paramLong4;
    localShuoshuoVideoInfo.t = paramLong5;
    localShuoshuoVideoInfo.u = paramBundle;
    paramContext = new StringBuilder();
    paramContext.append("prepareVideoInfos mCoverUrl: ");
    paramContext.append(localShuoshuoVideoInfo.h);
    QLog.d("[upload2]QCircleVideoUtils", 2, paramContext.toString());
    return localShuoshuoVideoInfo;
  }
  
  public static ShuoshuoVideoInfo a(Context paramContext, long paramLong1, String paramString1, long paramLong2, int paramInt1, String paramString2, int paramInt2, int paramInt3, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2)
  {
    if ((!new File(paramString1).exists()) && (paramBoolean2))
    {
      paramContext = new StringBuilder();
      paramContext.append("Path:");
      paramContext.append(paramString1);
      paramContext.append(", not exits!");
      QLog.e("[upload2]QCircleVideoUtils", 1, paramContext.toString());
      return null;
    }
    paramContext = new ShuoshuoVideoInfo();
    paramContext.b = paramString1;
    paramContext.g = paramLong2;
    paramContext.m = paramInt1;
    if (paramInt1 == 0)
    {
      paramContext.i = 1;
      paramContext.s = (500L * paramLong5 / 8L);
    }
    else if (paramInt1 == 1)
    {
      paramContext.i = 102;
      paramContext.s = a(paramString1, paramLong5, paramLong4, false, paramBoolean1);
    }
    paramContext.h = paramString2;
    paramContext.k = paramInt2;
    paramContext.j = paramInt3;
    paramContext.o = paramLong3;
    paramContext.p = (paramLong3 + paramLong4);
    paramContext.n = paramBoolean1;
    paramContext.f = paramLong4;
    paramContext.t = paramLong5;
    paramContext.u = paramBundle;
    paramString1 = new StringBuilder();
    paramString1.append("prepareVideoInfos mCoverUrl: ");
    paramString1.append(paramContext.h);
    QLog.d("[upload2]QCircleVideoUtils", 2, paramString1.toString());
    return paramContext;
  }
  
  private static QCircleVideoUtils.ThumbnailInfo a(Context paramContext, long paramLong)
  {
    Object localObject2;
    try
    {
      paramContext = paramContext.getContentResolver();
      localObject1 = MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("video_id=");
      ((StringBuilder)localObject2).append(paramLong);
      localObject2 = ((StringBuilder)localObject2).toString();
      paramContext = paramContext.query((Uri)localObject1, new String[] { "_data", "video_id", "height", "width" }, (String)localObject2, null, null);
    }
    catch (Exception paramContext)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("query error:");
      ((StringBuilder)localObject1).append(paramContext.toString());
      QLog.e("[upload2]QCircleVideoUtils", 1, ((StringBuilder)localObject1).toString());
      paramContext = null;
    }
    Object localObject1 = new QCircleVideoUtils.ThumbnailInfo();
    if ((paramContext != null) && (paramContext.moveToFirst()))
    {
      localObject2 = paramContext.getString(paramContext.getColumnIndex("_data"));
      int i = (int)paramContext.getLong(paramContext.getColumnIndex("height"));
      int j = (int)paramContext.getLong(paramContext.getColumnIndex("width"));
      ((QCircleVideoUtils.ThumbnailInfo)localObject1).a = ((String)localObject2);
      ((QCircleVideoUtils.ThumbnailInfo)localObject1).c = i;
      ((QCircleVideoUtils.ThumbnailInfo)localObject1).b = j;
    }
    if (paramContext != null) {
      paramContext.close();
    }
    return localObject1;
  }
  
  public static String a(Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(UUID.randomUUID().toString());
    localStringBuilder.append(".jpg");
    return a(paramBitmap, localStringBuilder.toString());
  }
  
  private static String a(Bitmap paramBitmap, String paramString)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (b(paramBitmap, paramString))
      {
        QLog.d("[upload2]QCircleVideoUtils", 1, new Object[] { "saveBitmapToLocal... path:", paramString });
        return paramString;
      }
      paramBitmap = new StringBuilder();
      paramBitmap.append("saveBitmapToJPG error, path:");
      paramBitmap.append(paramString);
      QLog.e("[upload2]QCircleVideoUtils", 1, paramBitmap.toString());
      return null;
    }
    QLog.e("[upload2]QCircleVideoUtils", 1, "bmp == null");
    return null;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("[upload2]QCircleVideoUtils", 1, "videoPath == null");
      return null;
    }
    if (!new File(paramString).exists())
    {
      QLog.e("[upload2]QCircleVideoUtils", 1, "!videoFile.exists()");
      return null;
    }
    return a(b(paramString));
  }
  
  public static void a(Application paramApplication, LocalMediaInfo paramLocalMediaInfo)
  {
    if (TextUtils.isEmpty(paramLocalMediaInfo.thumbnailPath))
    {
      long l = System.currentTimeMillis();
      String str = a(paramLocalMediaInfo.path);
      QLog.d("[upload2]QCircleVideoUtils", 1, new Object[] { "processVideoCover... getVideoCover cost:", Long.valueOf(System.currentTimeMillis() - l) });
      if (!TextUtils.isEmpty(str))
      {
        paramLocalMediaInfo.thumbnailPath = str;
        return;
      }
      if ((paramLocalMediaInfo._id != -1L) && (paramApplication != null) && (TextUtils.isEmpty(paramLocalMediaInfo.thumbnailPath)))
      {
        paramApplication = a(paramApplication, paramLocalMediaInfo._id);
        paramLocalMediaInfo.thumbnailPath = paramApplication.a;
        int i;
        if (paramApplication.c == 0) {
          i = paramLocalMediaInfo.mediaHeight;
        } else {
          i = paramApplication.c;
        }
        paramLocalMediaInfo.mediaHeight = i;
        if (paramApplication.b == 0) {
          i = paramLocalMediaInfo.mediaWidth;
        } else {
          i = paramApplication.b;
        }
        paramLocalMediaInfo.mediaWidth = i;
        QLog.d("[upload2]QCircleVideoUtils", 1, new Object[] { "processVideoCover... queryVideoThumbs... mCoverUrl:", paramApplication.a, " thumbnailInfo.mThumbnailHeight:", Integer.valueOf(paramApplication.c), " thumbnailInfo.mThumbnailWidth:", Integer.valueOf(paramApplication.b) });
      }
    }
  }
  
  public static void a(Context paramContext, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, ShuoshuoVideoInfo paramShuoshuoVideoInfo)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (HostFileUtils.fileExists(paramString2)) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      paramShuoshuoVideoInfo.h = paramString2;
      paramShuoshuoVideoInfo.k = paramInt1;
      paramShuoshuoVideoInfo.j = paramInt2;
      QLog.d("[upload2]QCircleVideoUtils", 1, new Object[] { "prepareVideoInfos... use exist mCoverUrl:", paramShuoshuoVideoInfo.h });
    }
    if (TextUtils.isEmpty(paramShuoshuoVideoInfo.h))
    {
      paramString1 = a(paramString1);
      if (!TextUtils.isEmpty(paramString1))
      {
        paramShuoshuoVideoInfo.h = paramString1;
        paramShuoshuoVideoInfo.k = paramInt1;
        paramShuoshuoVideoInfo.j = paramInt2;
        return;
      }
      if ((paramLong != -1L) && (paramContext != null) && (TextUtils.isEmpty(paramShuoshuoVideoInfo.h)))
      {
        paramContext = a(paramContext, paramLong);
        paramShuoshuoVideoInfo.h = paramContext.a;
        if (paramContext.c != 0) {
          paramInt1 = paramContext.c;
        }
        paramShuoshuoVideoInfo.k = paramInt1;
        if (paramContext.b != 0) {
          paramInt2 = paramContext.b;
        }
        paramShuoshuoVideoInfo.j = paramInt2;
        QLog.d("[upload2]QCircleVideoUtils", 1, new Object[] { "prepareVideoInfos... queryVideoThumbs... mCoverUrl:", paramShuoshuoVideoInfo.h, " mVideoHeight:", Integer.valueOf(paramShuoshuoVideoInfo.k), " mVideoWidth:", Integer.valueOf(paramShuoshuoVideoInfo.j) });
      }
    }
  }
  
  public static void a(ShuoshuoVideoInfo paramShuoshuoVideoInfo, String paramString, boolean paramBoolean)
  {
    if (paramShuoshuoVideoInfo != null)
    {
      if (paramShuoshuoVideoInfo.u == null) {
        paramShuoshuoVideoInfo.u = new Bundle();
      }
      paramShuoshuoVideoInfo.u.putBoolean(paramString, paramBoolean);
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  private static Bitmap b(String paramString)
  {
    // Byte code:
    //   0: getstatic 456	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 10
    //   5: if_icmple +149 -> 154
    //   8: new 458	android/media/MediaMetadataRetriever
    //   11: dup
    //   12: invokespecial 459	android/media/MediaMetadataRetriever:<init>	()V
    //   15: astore_2
    //   16: aload_2
    //   17: aload_0
    //   18: invokevirtual 462	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   21: aload_2
    //   22: bipush 9
    //   24: invokevirtual 465	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   27: pop
    //   28: aload_2
    //   29: ldc2_w 251
    //   32: iconst_2
    //   33: invokevirtual 469	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   36: astore_1
    //   37: aload_1
    //   38: astore_0
    //   39: aload_1
    //   40: ifnonnull +21 -> 61
    //   43: ldc 127
    //   45: iconst_1
    //   46: ldc_w 471
    //   49: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_2
    //   53: ldc2_w 251
    //   56: iconst_0
    //   57: invokevirtual 469	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   60: astore_0
    //   61: aload_2
    //   62: invokevirtual 474	android/media/MediaMetadataRetriever:release	()V
    //   65: aload_0
    //   66: areturn
    //   67: astore_1
    //   68: ldc 127
    //   70: iconst_1
    //   71: ldc_w 476
    //   74: aload_1
    //   75: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   78: aload_0
    //   79: areturn
    //   80: astore_0
    //   81: goto +53 -> 134
    //   84: astore_0
    //   85: ldc 127
    //   87: iconst_1
    //   88: ldc_w 481
    //   91: aload_0
    //   92: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload_2
    //   96: invokevirtual 474	android/media/MediaMetadataRetriever:release	()V
    //   99: goto +55 -> 154
    //   102: astore_0
    //   103: ldc 127
    //   105: iconst_1
    //   106: ldc_w 483
    //   109: aload_0
    //   110: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_2
    //   114: invokevirtual 474	android/media/MediaMetadataRetriever:release	()V
    //   117: goto +37 -> 154
    //   120: astore_0
    //   121: ldc 127
    //   123: iconst_1
    //   124: ldc_w 476
    //   127: aload_0
    //   128: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   131: goto +23 -> 154
    //   134: aload_2
    //   135: invokevirtual 474	android/media/MediaMetadataRetriever:release	()V
    //   138: goto +14 -> 152
    //   141: astore_1
    //   142: ldc 127
    //   144: iconst_1
    //   145: ldc_w 476
    //   148: aload_1
    //   149: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   152: aload_0
    //   153: athrow
    //   154: aconst_null
    //   155: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString	String
    //   36	4	1	localBitmap	Bitmap
    //   67	8	1	localRuntimeException1	java.lang.RuntimeException
    //   141	8	1	localRuntimeException2	java.lang.RuntimeException
    //   15	120	2	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   61	65	67	java/lang/RuntimeException
    //   16	37	80	finally
    //   43	61	80	finally
    //   85	95	80	finally
    //   103	113	80	finally
    //   16	37	84	java/lang/RuntimeException
    //   43	61	84	java/lang/RuntimeException
    //   16	37	102	java/lang/IllegalArgumentException
    //   43	61	102	java/lang/IllegalArgumentException
    //   95	99	120	java/lang/RuntimeException
    //   113	117	120	java/lang/RuntimeException
    //   134	138	141	java/lang/RuntimeException
  }
  
  /* Error */
  private static boolean b(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: new 42	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 231	java/io/File:exists	()Z
    //   15: ifne +144 -> 159
    //   18: aload_0
    //   19: ifnonnull +5 -> 24
    //   22: iconst_0
    //   23: ireturn
    //   24: aconst_null
    //   25: astore_3
    //   26: aconst_null
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload 4
    //   32: invokevirtual 490	java/io/File:getParentFile	()Ljava/io/File;
    //   35: ifnull +27 -> 62
    //   38: aload_2
    //   39: astore_1
    //   40: aload 4
    //   42: invokevirtual 490	java/io/File:getParentFile	()Ljava/io/File;
    //   45: invokevirtual 231	java/io/File:exists	()Z
    //   48: ifne +14 -> 62
    //   51: aload_2
    //   52: astore_1
    //   53: aload 4
    //   55: invokevirtual 490	java/io/File:getParentFile	()Ljava/io/File;
    //   58: invokevirtual 493	java/io/File:mkdirs	()Z
    //   61: pop
    //   62: aload_2
    //   63: astore_1
    //   64: aload 4
    //   66: invokevirtual 496	java/io/File:createNewFile	()Z
    //   69: pop
    //   70: aload_2
    //   71: astore_1
    //   72: new 498	java/io/BufferedOutputStream
    //   75: dup
    //   76: new 500	java/io/FileOutputStream
    //   79: dup
    //   80: aload 4
    //   82: invokespecial 503	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: invokespecial 506	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   88: astore_2
    //   89: aload_0
    //   90: getstatic 512	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   93: bipush 100
    //   95: aload_2
    //   96: invokevirtual 518	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   99: pop
    //   100: aload_2
    //   101: invokevirtual 519	java/io/BufferedOutputStream:close	()V
    //   104: iconst_1
    //   105: ireturn
    //   106: astore_0
    //   107: aload_2
    //   108: astore_1
    //   109: goto +40 -> 149
    //   112: astore_1
    //   113: aload_2
    //   114: astore_0
    //   115: aload_1
    //   116: astore_2
    //   117: goto +10 -> 127
    //   120: astore_0
    //   121: goto +28 -> 149
    //   124: astore_2
    //   125: aload_3
    //   126: astore_0
    //   127: aload_0
    //   128: astore_1
    //   129: ldc 127
    //   131: iconst_1
    //   132: ldc_w 521
    //   135: aload_2
    //   136: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   139: aload_0
    //   140: ifnull +7 -> 147
    //   143: aload_0
    //   144: invokevirtual 519	java/io/BufferedOutputStream:close	()V
    //   147: iconst_0
    //   148: ireturn
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 519	java/io/BufferedOutputStream:close	()V
    //   157: aload_0
    //   158: athrow
    //   159: iconst_0
    //   160: ireturn
    //   161: astore_0
    //   162: iconst_1
    //   163: ireturn
    //   164: astore_0
    //   165: goto -18 -> 147
    //   168: astore_1
    //   169: goto -12 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramBitmap	Bitmap
    //   0	172	1	paramString	String
    //   27	90	2	localObject1	Object
    //   124	12	2	localException	Exception
    //   25	101	3	localObject2	Object
    //   8	73	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   89	100	106	finally
    //   89	100	112	java/lang/Exception
    //   30	38	120	finally
    //   40	51	120	finally
    //   53	62	120	finally
    //   64	70	120	finally
    //   72	89	120	finally
    //   129	139	120	finally
    //   30	38	124	java/lang/Exception
    //   40	51	124	java/lang/Exception
    //   53	62	124	java/lang/Exception
    //   64	70	124	java/lang/Exception
    //   72	89	124	java/lang/Exception
    //   100	104	161	java/io/IOException
    //   143	147	164	java/io/IOException
    //   153	157	168	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.service.video.util.QCircleVideoUtils
 * JD-Core Version:    0.7.0.1
 */