package com.tencent.biz.subscribe.bizdapters;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DetailBaseBlock$1
  implements View.OnClickListener
{
  DetailBaseBlock$1(DetailBaseBlock paramDetailBaseBlock) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.A() instanceof SubscribeBaseFragment)) {
      ((SubscribeBaseFragment)this.a.A()).a(this.a.b(2));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.1
 * JD-Core Version:    0.7.0.1
 */