package com.tencent.biz.subscribe.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.bizdapters.MultiPicHeaderBlock;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscribeMultiPicFragment$2
  implements View.OnClickListener
{
  SubscribeMultiPicFragment$2(SubscribeMultiPicFragment paramSubscribeMultiPicFragment) {}
  
  public void onClick(View paramView)
  {
    if (SubscribeMultiPicFragment.a(this.a) != null)
    {
      SubscribeMultiPicFragment localSubscribeMultiPicFragment = this.a;
      localSubscribeMultiPicFragment.a(SubscribeMultiPicFragment.a(localSubscribeMultiPicFragment).a(1));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment.2
 * JD-Core Version:    0.7.0.1
 */