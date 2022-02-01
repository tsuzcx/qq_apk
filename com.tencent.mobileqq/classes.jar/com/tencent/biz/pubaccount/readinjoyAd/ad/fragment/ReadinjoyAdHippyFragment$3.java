package com.tencent.biz.pubaccount.readinjoyAd.ad.fragment;

import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyAdHippyFragment$3
  implements HippyQQEngine.HippyQQEngineListener
{
  ReadinjoyAdHippyFragment$3(ReadinjoyAdHippyFragment paramReadinjoyAdHippyFragment) {}
  
  public void onError(int paramInt, String paramString)
  {
    ReadinjoyAdHippyFragment.a(this.a);
    if (paramInt != -11) {
      ReadinjoyAdHippyFragment.c(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyAdMiniGameFragment", 2, "Hippy: initHippy error statusCode=" + paramInt + ", msg=" + paramString);
    }
  }
  
  public void onSuccess()
  {
    ReadinjoyAdHippyFragment.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyAdMiniGameFragment", 2, "Hippy: initHippy success!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment.3
 * JD-Core Version:    0.7.0.1
 */