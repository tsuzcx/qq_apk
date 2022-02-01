package com.tencent.biz.pubaccount.readinjoy.imageopt;

import com.tencent.qphone.base.util.QLog;
import pso;
import psp;
import syo;

public final class RIJImageOptMonitor$1
  implements Runnable
{
  public RIJImageOptMonitor$1(syo paramsyo) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.jdField_a_of_type_Long > 0L) && ((this.a.h == 0L) || ((!this.a.jdField_a_of_type_Boolean) && (this.a.e != 0))))
    {
      QLog.d("RIJImageOptMonitor", 1, "image load too slow: " + this.a);
      psp.a(this.a);
      pso.a();
      pso.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptMonitor.1
 * JD-Core Version:    0.7.0.1
 */