package com.tencent.biz.pubaccount.weishi_new.recommend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSGridPageFragment$1
  implements View.OnClickListener
{
  WSGridPageFragment$1(WSGridPageFragment paramWSGridPageFragment) {}
  
  public void onClick(View paramView)
  {
    WSGridPageFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment.1
 * JD-Core Version:    0.7.0.1
 */