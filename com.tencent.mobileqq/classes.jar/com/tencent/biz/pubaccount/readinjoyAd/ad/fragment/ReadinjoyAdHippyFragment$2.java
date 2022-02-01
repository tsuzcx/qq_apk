package com.tencent.biz.pubaccount.readinjoyAd.ad.fragment;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.ViolaViewListener;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyAdHippyFragment$2
  implements ViolaBaseView.ViolaViewListener
{
  ReadinjoyAdHippyFragment$2(ReadinjoyAdHippyFragment paramReadinjoyAdHippyFragment) {}
  
  public void a()
  {
    if (this.a.getActivity() != null) {
      new Handler(this.a.getActivity().getMainLooper()).postDelayed(new ReadinjoyAdHippyFragment.2.1(this), 200L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyAdMiniGameFragment", 2, "initViola success!");
    }
    if ((this.a.a != null) && (this.a.a.c()) && (this.a.c()) && (RIJXTabFrameUtils.a.a())) {
      this.a.a.a(true);
    }
  }
  
  public void a(int paramInt)
  {
    ReadinjoyAdHippyFragment.a(this.a);
    ReadinjoyAdHippyFragment.a(this.a).c();
    if (QLog.isColorLevel()) {
      QLog.e("ReadinjoyAdMiniGameFragment", 2, "initViola error,error code=" + paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void a(String paramString, int paramInt)
  {
    if ((1 == paramInt) && (ChannelModeConfigHandler.a())) {
      ReadInJoyLogicEngineEventDispatcher.a().k();
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyAdMiniGameFragment", 2, "initViola process,process code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment.2
 * JD-Core Version:    0.7.0.1
 */