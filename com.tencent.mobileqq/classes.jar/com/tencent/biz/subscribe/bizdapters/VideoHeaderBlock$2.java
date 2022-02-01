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
    if (!DetailBaseBlock.c())
    {
      CertifiedAccountMeta.StFeed localStFeed = VideoHeaderBlock.a(this.a);
      if (localStFeed != null)
      {
        this.a.d(localStFeed);
        if (this.a.a() != null) {
          this.a.a().c(localStFeed);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock.2
 * JD-Core Version:    0.7.0.1
 */