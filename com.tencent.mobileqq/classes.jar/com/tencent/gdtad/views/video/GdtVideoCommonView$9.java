package com.tencent.gdtad.views.video;

import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class GdtVideoCommonView$9
  implements INetInfoHandler
{
  GdtVideoCommonView$9(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void onNetMobile2None()
  {
    QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetMobile2None()");
    GdtVideoCommonView.a(this.a, 0);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("INetInfoHandler onNetMobile2Wifi() ssid=");
    localStringBuilder.append(paramString);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    GdtVideoCommonView.a(this.a, 1);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("INetInfoHandler onNetNone2Mobile() apn=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" onNetWifi2None ");
    localStringBuilder.append(GdtVideoCommonView.c(this.a));
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    GdtVideoCommonView.a(this.a, 2);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("INetInfoHandler onNetNone2Wifi() ssid=");
    localStringBuilder.append(paramString);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    GdtVideoCommonView.a(this.a, 1);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("INetInfoHandler onNetWifi2Mobile() apn=");
    localStringBuilder.append(paramString);
    QLog.i("GdtVideoCommonView", 1, localStringBuilder.toString());
    GdtVideoCommonView.a(this.a, 2);
    if ((this.a.a) && (this.a.a()))
    {
      GdtVideoCommonView.d(this.a);
      GdtVideoCommonView.a(this.a).post(GdtVideoCommonView.a(this.a));
    }
  }
  
  public void onNetWifi2None()
  {
    QLog.i("GdtVideoCommonView", 1, "INetInfoHandler onNetWifi2None()");
    GdtVideoCommonView.b(this.a, true);
    GdtVideoCommonView.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.9
 * JD-Core Version:    0.7.0.1
 */