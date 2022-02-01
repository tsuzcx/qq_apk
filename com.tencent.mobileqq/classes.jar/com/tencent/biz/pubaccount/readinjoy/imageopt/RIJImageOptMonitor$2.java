package com.tencent.biz.pubaccount.readinjoy.imageopt;

import com.tencent.av.utils.SignalStrengthReport.PingUtil;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Arrays;

final class RIJImageOptMonitor$2
  implements Runnable
{
  RIJImageOptMonitor$2(ImageRequest paramImageRequest) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.a != null))
    {
      String str = this.a.a.toString();
      String[] arrayOfString = RIJImageOptMonitor.a(this.a.a.getHost());
      int i = SignalStrengthReport.PingUtil.a(str);
      QLog.d("RIJImageOptMonitor", 1, "ping url: " + str + " ip: " + Arrays.toString(arrayOfString) + " time: " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptMonitor.2
 * JD-Core Version:    0.7.0.1
 */