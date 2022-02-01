package com.tencent.biz.pubaccount.readinjoy.imageopt;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.qphone.base.util.QLog;

final class RIJImageOptMonitor$1
  implements Runnable
{
  RIJImageOptMonitor$1(ImageRequest paramImageRequest) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.jdField_a_of_type_Long > 0L) && ((this.a.h == 0L) || ((!this.a.jdField_a_of_type_Boolean) && (this.a.e != 0))))
    {
      QLog.d("RIJImageOptMonitor", 1, "image load too slow: " + this.a);
      RIJImageOptReport.a(this.a);
      RIJImageOptMonitor.a();
      RIJImageOptMonitor.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptMonitor.1
 * JD-Core Version:    0.7.0.1
 */