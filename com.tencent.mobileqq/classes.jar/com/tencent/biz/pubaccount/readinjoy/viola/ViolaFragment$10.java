package com.tencent.biz.pubaccount.readinjoy.viola;

import com.tencent.hippy.qq.app.HippyQQEngine;

class ViolaFragment$10
  implements Runnable
{
  ViolaFragment$10(ViolaFragment paramViolaFragment) {}
  
  public void run()
  {
    if (this.this$0.mHippyQQEngine != null)
    {
      this.this$0.mHippyQQEngine.onDestroy();
      this.this$0.mHippyQQEngine = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment.10
 * JD-Core Version:    0.7.0.1
 */