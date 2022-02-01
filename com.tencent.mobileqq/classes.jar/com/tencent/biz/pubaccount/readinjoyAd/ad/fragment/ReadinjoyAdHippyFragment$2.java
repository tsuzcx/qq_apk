package com.tencent.biz.pubaccount.readinjoyAd.ad.fragment;

import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaViewListener;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyAdHippyFragment$2
  implements IViolaBaseView.ViolaViewListener
{
  ReadinjoyAdHippyFragment$2(ReadinjoyAdHippyFragment paramReadinjoyAdHippyFragment) {}
  
  public void a()
  {
    if (this.a.a() != null) {
      new Handler(this.a.a().getMainLooper()).postDelayed(new ReadinjoyAdHippyFragment.2.1(this), 200L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyAdMiniGameFragment", 2, "initViola success!");
    }
    if ((this.a.a != null) && (this.a.a.b()) && (this.a.b()) && (((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).isNowInKanDianTab())) {
      this.a.a.a(true);
    }
  }
  
  public void a(int paramInt)
  {
    ReadinjoyAdHippyFragment.a(this.a);
    ReadinjoyAdHippyFragment.a(this.a).b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initViola error,error code=");
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
      localStringBuilder.append("initViola process,process code=");
      localStringBuilder.append(paramInt);
      QLog.d("ReadinjoyAdMiniGameFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment.2
 * JD-Core Version:    0.7.0.1
 */