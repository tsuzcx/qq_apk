package com.tencent.biz.pubaccount.readinjoy.video.videoconverter;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.io.File;
import java.text.DecimalFormat;

public class VideoConvertUtil
{
  public static final String a = AppConstants.SDCARD_PATH_READINJOY;
  
  public static int a(int paramInt)
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    if (localAladdinConfig == null) {
      return 2048;
    }
    switch (paramInt)
    {
    default: 
      return localAladdinConfig.getIntegerFromString("compress_bitrate_720p", 2048);
    case 480: 
      return localAladdinConfig.getIntegerFromString("compress_bitrate_480p", 1024);
    case 640: 
      return localAladdinConfig.getIntegerFromString("compress_bitrate_640p", 1536);
    case 720: 
      return localAladdinConfig.getIntegerFromString("compress_bitrate_720p", 2048);
    }
    return localAladdinConfig.getIntegerFromString("compress_bitrate_1080p", 4096);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 480;
    int n = Math.min(paramInt1, paramInt2);
    int j = Math.abs(n - 480);
    int k = Math.abs(n - 640);
    int m = Math.abs(n - 720);
    n = Math.abs(n - 1080);
    int i1 = Math.min(Math.min(j, k), Math.min(m, n));
    if (i1 == j) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoConvertUtils", 2, "calculateTargetVideoResolution(): width:" + paramInt1 + ", height:" + paramInt2 + " => resolution:" + i);
      }
      return i;
      if (i1 == k) {
        i = 640;
      } else if (i1 == m) {
        i = 720;
      } else if (i1 == n) {
        i = 1080;
      }
    }
  }
  
  public static long a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    long l = 60L;
    if (localAladdinConfig != null)
    {
      l = localAladdinConfig.getIntegerFromString("compress_size_lower_bound", 60);
      QLog.d("VideoConvertUtils", 1, new Object[] { "getConfigCompressFileSizeLowerBound(), value = ", Long.valueOf(l) });
    }
    return l * 1048576L;
  }
  
  public static long a(int paramInt1, int paramInt2)
  {
    return a(a(paramInt1, paramInt2)) * 1024;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(a);
    localStringBuilder.append("convert");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  @TargetApi(9)
  public static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = MD5.a(paramString1 + System.currentTimeMillis());
      StringBuilder localStringBuilder = new StringBuilder(a());
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("VideoConvertUtils", 2, "getVideoCompressedPath: sourcePath=" + paramString1 + "\n compressPath=" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static boolean a()
  {
    return DeviceInfoUtils.a();
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    QLog.d("VideoConvertUtils", 1, "isExceedResolutionLimit(): width:" + paramInt1 + ", height:" + paramInt2);
    return paramInt1 * paramInt2 > 3110400.0F;
  }
  
  public static boolean a(VideoMediaInfo paramVideoMediaInfo)
  {
    if (paramVideoMediaInfo == null) {
      return false;
    }
    if ((paramVideoMediaInfo.d < a()) || (paramVideoMediaInfo.d > b()))
    {
      QLog.d("VideoConvertUtils", 1, "needCompress(): false! fileSize not match, size=" + paramVideoMediaInfo.d);
      return false;
    }
    if (a(paramVideoMediaInfo.a, paramVideoMediaInfo.jdField_b_of_type_Int))
    {
      QLog.d("VideoConvertUtils", 1, "needCompress(): true! isExceedResolutionLimit");
      return true;
    }
    if (!a())
    {
      QLog.d("VideoConvertUtils", 1, "needCompress(): false! not High Profile Device");
      return false;
    }
    long l = a(paramVideoMediaInfo.a, paramVideoMediaInfo.jdField_b_of_type_Int);
    if ((l > 0L) && (paramVideoMediaInfo.jdField_b_of_type_Long > 3L * l))
    {
      QLog.d("VideoConvertUtils", 1, "needCompress(): true! sourceBitRate:" + paramVideoMediaInfo.jdField_b_of_type_Long + ", targetBitRate:" + l);
      return true;
    }
    QLog.d("VideoConvertUtils", 1, "needCompress(): false, bitrate not match, sourceBitRate:" + paramVideoMediaInfo.jdField_b_of_type_Long + ", targetBitRate:" + l);
    return false;
  }
  
  public static long b()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    long l = 60L;
    if (localAladdinConfig != null)
    {
      l = localAladdinConfig.getIntegerFromString("compress_size_upper_bound", 1024);
      QLog.d("VideoConvertUtils", 1, new Object[] { "getConfigCompressFileSizeUpperBound(), value = ", Long.valueOf(l) });
    }
    return l * 1048576L;
  }
  
  public static String b()
  {
    long l = b();
    if (l < 1073741824L) {
      return l / 1048576L + "MB";
    }
    if (l % 1073741824L == 0L) {
      return l / 1073741824L + "GB";
    }
    DecimalFormat localDecimalFormat = new DecimalFormat(".00");
    return localDecimalFormat.format((float)l / 1.073742E+009F) + "GB";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videoconverter.VideoConvertUtil
 * JD-Core Version:    0.7.0.1
 */