package com.tencent.biz.pubaccount.readinjoy.imageopt;

import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Arrays;
import muu;
import qdl;
import tlw;

public final class RIJImageOptMonitor$2
  implements Runnable
{
  public RIJImageOptMonitor$2(tlw paramtlw) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.a != null))
    {
      String str = this.a.a.toString();
      String[] arrayOfString = qdl.a(this.a.a.getHost());
      int i = muu.a(str);
      QLog.d("RIJImageOptMonitor", 1, "ping url: " + str + " ip: " + Arrays.toString(arrayOfString) + " time: " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptMonitor.2
 * JD-Core Version:    0.7.0.1
 */