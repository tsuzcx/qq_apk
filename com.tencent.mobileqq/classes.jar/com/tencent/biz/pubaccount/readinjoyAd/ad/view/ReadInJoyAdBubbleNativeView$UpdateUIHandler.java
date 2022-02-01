package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

class ReadInJoyAdBubbleNativeView$UpdateUIHandler
  extends Handler
{
  SoftReference<ReadInJoyAdBubbleNativeView> a;
  
  public ReadInJoyAdBubbleNativeView$UpdateUIHandler(ReadInJoyAdBubbleNativeView paramReadInJoyAdBubbleNativeView)
  {
    super(Looper.getMainLooper());
    this.a = new SoftReference(paramReadInJoyAdBubbleNativeView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 2) {
      return;
    }
    paramMessage = this.a;
    if (paramMessage != null) {
      if (paramMessage.get() == null) {
        return;
      }
    }
    try
    {
      ReadInJoyAdBubbleNativeView.a((ReadInJoyAdBubbleNativeView)this.a.get());
      sendEmptyMessageDelayed(2, 1100L);
      return;
    }
    catch (Exception paramMessage)
    {
      label54:
      break label54;
    }
    QLog.d("ReadInJoyAdBubbleNativeView", 2, "ReadInJoyAdBubbleView is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleNativeView.UpdateUIHandler
 * JD-Core Version:    0.7.0.1
 */