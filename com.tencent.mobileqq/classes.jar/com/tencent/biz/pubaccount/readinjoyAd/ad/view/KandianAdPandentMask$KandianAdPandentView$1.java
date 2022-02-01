package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.qphone.base.util.QLog;

class KandianAdPandentMask$KandianAdPandentView$1
  extends MediaPlayListenerAdapter
{
  KandianAdPandentMask$KandianAdPandentView$1(KandianAdPandentMask.KandianAdPandentView paramKandianAdPandentView) {}
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, Object paramObject)
  {
    QLog.d("ReadInJoySuperMaskAd", 2, "onVideoPrepared");
    KandianAdPandentMask.KandianAdPandentView.a(this.a).d();
  }
  
  public void b(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    super.b(paramVideoPlayerWrapper);
    QLog.d("ReadInJoySuperMaskAd", 2, "onCompletion");
    KandianAdPandentMask.KandianAdPandentView.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianAdPandentMask.KandianAdPandentView.1
 * JD-Core Version:    0.7.0.1
 */