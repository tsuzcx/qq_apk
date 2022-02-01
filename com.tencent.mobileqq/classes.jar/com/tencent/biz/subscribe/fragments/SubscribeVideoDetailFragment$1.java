package com.tencent.biz.subscribe.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.subscribe.bizdapters.VideoHeaderBlock;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribeVideoDetailFragment$1
  implements View.OnClickListener
{
  SubscribeVideoDetailFragment$1(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void onClick(View paramView)
  {
    if ((SubscribeVideoDetailFragment.a(this.a) != null) && (SubscribeVideoDetailFragment.b(this.a) != null))
    {
      Object localObject = SubscribeVideoDetailFragment.a(this.a);
      boolean bool2 = true;
      localObject = ((VideoHeaderBlock)localObject).b(1);
      boolean bool1 = bool2;
      if (SubscribeVideoDetailFragment.b(this.a).u()) {
        if (!SubscribeVideoDetailFragment.b(this.a).w()) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      ((ShareInfoBean)localObject).h = bool1;
      this.a.a((ShareInfoBean)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment.1
 * JD-Core Version:    0.7.0.1
 */