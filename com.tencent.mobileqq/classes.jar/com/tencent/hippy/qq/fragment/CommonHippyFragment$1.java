package com.tencent.hippy.qq.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommonHippyFragment$1
  implements View.OnClickListener
{
  CommonHippyFragment$1(CommonHippyFragment paramCommonHippyFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.hideNetworkErrorView();
    this.this$0.loadHippy(CommonHippyFragment.access$000(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.CommonHippyFragment.1
 * JD-Core Version:    0.7.0.1
 */