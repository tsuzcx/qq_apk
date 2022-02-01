package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomGiftCallback;

class KandianAdPandentMask$KandianAdPandentView$4
  implements LiveRoomGiftCallback
{
  KandianAdPandentMask$KandianAdPandentView$4(KandianAdPandentMask.KandianAdPandentView paramKandianAdPandentView) {}
  
  public void onCall(int paramInt, String paramString)
  {
    if (paramInt == 7)
    {
      QLog.d("ReadInJoySuperMaskAd", 2, "Vpng play completion!");
      KandianAdPandentMask.KandianAdPandentView.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianAdPandentMask.KandianAdPandentView.4
 * JD-Core Version:    0.7.0.1
 */