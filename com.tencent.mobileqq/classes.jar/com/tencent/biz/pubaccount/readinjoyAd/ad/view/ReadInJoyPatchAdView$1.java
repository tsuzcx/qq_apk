package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyPatchAdView$1
  extends Handler
{
  ReadInJoyPatchAdView$1(ReadInJoyPatchAdView paramReadInJoyPatchAdView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyPatchAdView", 2, "mUIHandler handleMessage() msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      int i = 0;
      if ((paramMessage.obj instanceof Integer)) {
        i = ((Integer)paramMessage.obj).intValue();
      }
      ReadInJoyPatchAdView.a(this.a, i);
      return;
      ReadInJoyPatchAdView.a(this.a);
      return;
    } while (this.a.a == null);
    this.a.a.b(ReadInJoyPatchAdView.a(this.a), ReadInJoyPatchAdView.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView.1
 * JD-Core Version:    0.7.0.1
 */