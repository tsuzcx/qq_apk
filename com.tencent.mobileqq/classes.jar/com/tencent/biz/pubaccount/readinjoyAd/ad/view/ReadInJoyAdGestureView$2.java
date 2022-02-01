package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.qphone.base.util.QLog;
import tqa;

class ReadInJoyAdGestureView$2
  implements Runnable
{
  ReadInJoyAdGestureView$2(ReadInJoyAdGestureView paramReadInJoyAdGestureView, String paramString) {}
  
  public void run()
  {
    try
    {
      ReadInJoyAdGestureView.a(this.this$0, tqa.a(this.a, (int)this.this$0.e, (int)this.this$0.f));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdGestureView", 2, localException.toString());
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdGestureView.2
 * JD-Core Version:    0.7.0.1
 */