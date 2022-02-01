package com.tencent.hippy.qq.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommonHippyFragment$1
  implements View.OnClickListener
{
  CommonHippyFragment$1(CommonHippyFragment paramCommonHippyFragment) {}
  
  public void onClick(View paramView)
  {
    CommonHippyFragment.access$000(this.this$0).hideNetworkErrorView();
    if (this.this$0.mHippyQQEngine != null) {
      this.this$0.mHippyQQEngine.destroyEngineImmediately();
    }
    CommonHippyFragment localCommonHippyFragment = this.this$0;
    localCommonHippyFragment.loadHippy(CommonHippyFragment.access$100(localCommonHippyFragment));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.CommonHippyFragment.1
 * JD-Core Version:    0.7.0.1
 */