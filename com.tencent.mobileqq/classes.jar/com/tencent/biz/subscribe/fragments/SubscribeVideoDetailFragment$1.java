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
    boolean bool2 = true;
    ShareInfoBean localShareInfoBean;
    if ((SubscribeVideoDetailFragment.a(this.a) != null) && (SubscribeVideoDetailFragment.a(this.a) != null))
    {
      localShareInfoBean = SubscribeVideoDetailFragment.a(this.a).a(1);
      bool1 = bool2;
      if (SubscribeVideoDetailFragment.a(this.a).f()) {
        if (SubscribeVideoDetailFragment.a(this.a).h()) {
          break label88;
        }
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localShareInfoBean.c = bool1;
      this.a.a(localShareInfoBean);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment.1
 * JD-Core Version:    0.7.0.1
 */