package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoHeaderBlock$3
  implements View.OnClickListener
{
  VideoHeaderBlock$3(VideoHeaderBlock paramVideoHeaderBlock) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a() != null)
    {
      CertifiedAccountMeta.StFeed localStFeed = this.a.a().a();
      if (localStFeed == null) {
        break label41;
      }
      this.a.d(localStFeed);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label41:
      QQToast.a(VideoHeaderBlock.a(this.a), 1, HardCodeUtil.a(2131714528), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock.3
 * JD-Core Version:    0.7.0.1
 */