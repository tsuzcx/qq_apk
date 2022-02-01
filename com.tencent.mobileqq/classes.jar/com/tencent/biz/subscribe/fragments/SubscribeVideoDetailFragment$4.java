package com.tencent.biz.subscribe.fragments;

import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.mobileqq.kandian.base.video.player.videourl.api.UrlToUUIDCallback;
import com.tencent.qphone.base.util.QLog;

class SubscribeVideoDetailFragment$4
  implements UrlToUUIDCallback
{
  SubscribeVideoDetailFragment$4(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void a(String paramString1, String paramString2)
  {
    QLog.i("SubscribeVideoDetailFragment", 1, "sendUrlToUUIDRequest getUUID Success");
    if (this.a.a != null) {
      this.a.a.a(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment.4
 * JD-Core Version:    0.7.0.1
 */