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
    if (this.a.w() != null)
    {
      CertifiedAccountMeta.StFeed localStFeed = this.a.w().j();
      if (localStFeed != null) {
        this.a.d(localStFeed);
      } else {
        QQToast.makeText(VideoHeaderBlock.c(this.a), 1, HardCodeUtil.a(2131911959), 0).show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock.3
 * JD-Core Version:    0.7.0.1
 */