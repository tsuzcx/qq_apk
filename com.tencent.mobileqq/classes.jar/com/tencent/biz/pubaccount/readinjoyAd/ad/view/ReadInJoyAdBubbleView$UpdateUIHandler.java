package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

class ReadInJoyAdBubbleView$UpdateUIHandler
  extends Handler
{
  SoftReference<ReadInJoyAdBubbleView> a;
  
  public ReadInJoyAdBubbleView$UpdateUIHandler(ReadInJoyAdBubbleView paramReadInJoyAdBubbleView)
  {
    super(Looper.getMainLooper());
    this.a = new SoftReference(paramReadInJoyAdBubbleView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((this.a == null) || (this.a.get() == null));
    try
    {
      ReadInJoyAdBubbleView.a((ReadInJoyAdBubbleView)this.a.get());
      sendEmptyMessageDelayed(2, 1100L);
      return;
    }
    catch (Exception paramMessage)
    {
      QLog.d("ReadInJoyAdBubbleView", 2, "ReadInJoyAdBubbleView is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleView.UpdateUIHandler
 * JD-Core Version:    0.7.0.1
 */