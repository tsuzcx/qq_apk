package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.os.Handler;
import com.tencent.mobileqq.kandian.base.video.player.MediaPlayListenerAdapter;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.qphone.base.util.QLog;

class KandianAdPandentMask$KandianAdPandentView$1
  extends MediaPlayListenerAdapter
{
  KandianAdPandentMask$KandianAdPandentView$1(KandianAdPandentMask.KandianAdPandentView paramKandianAdPandentView) {}
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    super.a(paramIVideoPlayerWrapper);
    QLog.d("ReadInJoySuperMaskAd", 2, "onCompletion");
    KandianAdPandentMask.KandianAdPandentView.b(this.a).sendEmptyMessage(2);
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, Object paramObject)
  {
    QLog.d("ReadInJoySuperMaskAd", 2, "onVideoPrepared");
    KandianAdPandentMask.KandianAdPandentView.a(this.a).u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianAdPandentMask.KandianAdPandentView.1
 * JD-Core Version:    0.7.0.1
 */