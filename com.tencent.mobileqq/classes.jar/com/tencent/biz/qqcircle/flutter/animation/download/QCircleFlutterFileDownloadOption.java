package com.tencent.biz.qqcircle.flutter.animation.download;

import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.qcircle.cooperation.config.download.QCircleDownloadConfig;

public class QCircleFlutterFileDownloadOption
{
  private String a = "";
  private String b = "";
  private boolean c = false;
  private RFWDownloadStrategy d;
  
  public static QCircleFlutterFileDownloadOption e()
  {
    return new QCircleFlutterFileDownloadOption();
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public RFWDownloadStrategy d()
  {
    if (this.d == null) {
      this.d = QCircleDownloadConfig.a();
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.download.QCircleFlutterFileDownloadOption
 * JD-Core Version:    0.7.0.1
 */