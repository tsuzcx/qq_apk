package com.tencent.biz.pubaccount.readinjoyAd.ad.fragment;

import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaViewListener;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyAdHippyFragment$4
  implements IViolaBaseView.ViolaViewListener
{
  ReadinjoyAdHippyFragment$4(ReadinjoyAdHippyFragment paramReadinjoyAdHippyFragment) {}
  
  public void a()
  {
    if (this.a.v() != null) {
      new Handler(this.a.v().getMainLooper()).postDelayed(new ReadinjoyAdHippyFragment.4.2(this), 200L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyAdMiniGameFragment", 2, "reloadPage success!");
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a.v() != null) {
      new Handler(this.a.v().getMainLooper()).postDelayed(new ReadinjoyAdHippyFragment.4.1(this), 1000L);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reloadPage error,error code=");
      localStringBuilder.append(paramInt);
      QLog.e("ReadinjoyAdMiniGameFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reloadPage process,process code=");
      localStringBuilder.append(paramInt);
      QLog.d("ReadinjoyAdMiniGameFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment.4
 * JD-Core Version:    0.7.0.1
 */