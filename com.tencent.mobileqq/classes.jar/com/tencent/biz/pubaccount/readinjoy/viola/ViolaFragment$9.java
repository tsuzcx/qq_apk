package com.tencent.biz.pubaccount.readinjoy.viola;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.ViolaViewListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class ViolaFragment$9
  implements ViolaBaseView.ViolaViewListener
{
  ViolaFragment$9(ViolaFragment paramViolaFragment) {}
  
  public void a()
  {
    this.a.mViolaUiDelegate.b();
    this.a.mViolaUiDelegate.d();
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reloadPage success!");
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a.getActivity() != null) {}
    for (Looper localLooper = this.a.getActivity().getMainLooper();; localLooper = BaseActivity.sTopActivity.getMainLooper())
    {
      new Handler(localLooper).postDelayed(new ViolaFragment.9.1(this), 1000L);
      if (QLog.isColorLevel()) {
        QLog.e("ViolaFragment", 2, "reloadPage error,error code=" + paramInt);
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reloadPage process,process code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment.9
 * JD-Core Version:    0.7.0.1
 */