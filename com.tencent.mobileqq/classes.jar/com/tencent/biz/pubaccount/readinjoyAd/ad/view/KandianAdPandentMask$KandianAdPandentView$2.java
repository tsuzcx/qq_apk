package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class KandianAdPandentMask$KandianAdPandentView$2
  implements Handler.Callback
{
  KandianAdPandentMask$KandianAdPandentView$2(KandianAdPandentMask.KandianAdPandentView paramKandianAdPandentView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      KandianAdPandentMask.KandianAdPandentView.e(this.a);
      return false;
    }
    if (System.currentTimeMillis() - KandianAdPandentMask.KandianAdPandentView.c(this.a) > 1500L)
    {
      KandianAdPandentMask.KandianAdPandentView.a(this.a, false);
      QLog.d("ReadInJoySuperMaskAd", 2, "time up do not update volume");
    }
    if (KandianAdPandentMask.KandianAdPandentView.d(this.a))
    {
      KandianAdPandentMask.KandianAdPandentView.b(this.a).sendEmptyMessageDelayed(1, 300L);
      this.a.d();
      return false;
    }
    KandianAdPandentMask.KandianAdPandentView.b(this.a).removeMessages(1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianAdPandentMask.KandianAdPandentView.2
 * JD-Core Version:    0.7.0.1
 */