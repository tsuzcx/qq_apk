package com.tencent.biz.qqcircle.download;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants;
import com.tencent.open.base.MD5Utils;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

public class QCircleRichMediaDownLoadManager$DownLoadParams
{
  private static String a = ;
  private static String b = a;
  private String c;
  private int d;
  private String e;
  private String f;
  private QCircleRichMediaDownLoadManager.IRichMediaListener g;
  private String h;
  
  public QCircleRichMediaDownLoadManager$DownLoadParams()
  {
    if (e())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(QCircleHostConstants.AppConstants.SDCARD_ROOT());
      localStringBuilder.append("/DCIM/Video/");
      b = localStringBuilder.toString();
    }
  }
  
  private boolean e()
  {
    return String.valueOf(Build.BRAND).toLowerCase().contains("meizu");
  }
  
  public DownLoadParams a(QCircleRichMediaDownLoadManager.IRichMediaListener paramIRichMediaListener)
  {
    this.g = paramIRichMediaListener;
    return this;
  }
  
  public DownLoadParams a(String paramString1, int paramInt, String paramString2)
  {
    this.h = paramString2;
    this.c = paramString1;
    this.d = paramInt;
    if (paramInt == 1)
    {
      str = MD5Utils.encodeHexStr(QCircleFeedPicLoader.getUniKeyFromUrl(paramString1));
      paramString2 = str;
      if (TextUtils.isEmpty(str)) {
        paramString2 = MD5Utils.encodeFileHexStr(paramString1);
      }
    }
    else
    {
      paramString2 = this.h;
    }
    if (paramString2 != null) {
      paramString1 = paramString2;
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(System.currentTimeMillis());
    String str = paramString2.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCircleRichMediaDownLoadManager.c());
    localStringBuilder.append(str);
    paramString2 = ".mp4";
    if (paramInt == 0) {
      paramString1 = ".mp4";
    } else {
      paramString1 = ".jpeg";
    }
    localStringBuilder.append(paramString1);
    this.f = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      paramString1 = b;
    } else {
      paramString1 = a;
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append(str);
    if (paramInt == 0) {
      paramString1 = paramString2;
    } else {
      paramString1 = ".jpeg";
    }
    localStringBuilder.append(paramString1);
    this.e = localStringBuilder.toString();
    return this;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public int d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.DownLoadParams
 * JD-Core Version:    0.7.0.1
 */