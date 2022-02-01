package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoHeaderBlock$2
  implements View.OnClickListener
{
  VideoHeaderBlock$2(VideoHeaderBlock paramVideoHeaderBlock) {}
  
  public void onClick(View paramView)
  {
    if (!DetailBaseBlock.j())
    {
      CertifiedAccountMeta.StFeed localStFeed = VideoHeaderBlock.b(this.a);
      if (localStFeed != null)
      {
        this.a.d(localStFeed);
        if (this.a.w() != null) {
          this.a.w().c(localStFeed);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock.2
 * JD-Core Version:    0.7.0.1
 */