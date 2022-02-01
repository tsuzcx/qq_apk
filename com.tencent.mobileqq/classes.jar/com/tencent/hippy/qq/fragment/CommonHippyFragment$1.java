package com.tencent.hippy.qq.fragment;

import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.detection.DetectionPolicy;

class CommonHippyFragment$1
  implements Runnable
{
  CommonHippyFragment$1(CommonHippyFragment paramCommonHippyFragment) {}
  
  public void run()
  {
    if (!DetectionPolicy.isAbleToDetect(this.this$0.getActivity())) {
      VideoReport.addToDetectionWhitelist(this.this$0.getActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.fragment.CommonHippyFragment.1
 * JD-Core Version:    0.7.0.1
 */