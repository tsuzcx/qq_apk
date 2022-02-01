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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mUIHandler handleMessage() msg.what = ");
      localStringBuilder.append(paramMessage.what);
      QLog.d("ReadInJoyPatchAdView", 2, localStringBuilder.toString());
    }
    switch (paramMessage.what)
    {
    default: 
    case 1203: 
      if (this.a.b != null)
      {
        this.a.b.b(ReadInJoyPatchAdView.b(this.a), ReadInJoyPatchAdView.c(this.a));
        return;
      }
      break;
    case 1202: 
      ReadInJoyPatchAdView.a(this.a);
      return;
    case 1201: 
      int i = 0;
      if ((paramMessage.obj instanceof Integer)) {
        i = ((Integer)paramMessage.obj).intValue();
      }
      ReadInJoyPatchAdView.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView.1
 * JD-Core Version:    0.7.0.1
 */