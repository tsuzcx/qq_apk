package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.ViolaViewListener;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyViolaChannelFragment$4
  implements ViolaBaseView.ViolaViewListener
{
  ReadInJoyViolaChannelFragment$4(ReadInJoyViolaChannelFragment paramReadInJoyViolaChannelFragment) {}
  
  public void a()
  {
    if (this.a.getActivity() != null) {
      new Handler(this.a.getActivity().getMainLooper()).postDelayed(new ReadInJoyViolaChannelFragment.4.2(this), 200L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "reloadPage success!");
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a.getActivity() != null) {
      new Handler(this.a.getActivity().getMainLooper()).postDelayed(new ReadInJoyViolaChannelFragment.4.1(this), 1000L);
    }
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyViolaChannelFragment", 2, "reloadPage error,error code=" + paramInt);
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
      QLog.d("ReadInJoyViolaChannelFragment", 2, "reloadPage process,process code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment.4
 * JD-Core Version:    0.7.0.1
 */