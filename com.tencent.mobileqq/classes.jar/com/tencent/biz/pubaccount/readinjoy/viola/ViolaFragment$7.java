package com.tencent.biz.pubaccount.readinjoy.viola;

import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.ViolaViewListener;
import com.tencent.mobileqq.activity.qwallet.utils.FlymeOSStatusBarFontUtils;
import com.tencent.qphone.base.util.QLog;

class ViolaFragment$7
  implements ViolaBaseView.ViolaViewListener
{
  ViolaFragment$7(ViolaFragment paramViolaFragment) {}
  
  public void a()
  {
    this.a.mViolaUiDelegate.b();
    this.a.mViolaUiDelegate.d();
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "initViola success!");
    }
  }
  
  public void a(int paramInt)
  {
    this.a.mViolaUiDelegate.b();
    this.a.mViolaUiDelegate.c();
    if (QLog.isColorLevel()) {
      QLog.e("ViolaFragment", 2, "initViola error,error code=" + paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if ((this.a.mViolaUiDelegate.b()) && (paramBoolean))
    {
      if (Math.abs(paramInt1) < this.a.mViolaUiDelegate.a() / 2) {
        break label79;
      }
      if (!ViolaFragment.access$100(this.a))
      {
        this.a.setStatusBarFontColor(Boolean.valueOf(false));
        FlymeOSStatusBarFontUtils.a(this.a.getActivity(), true);
        ViolaFragment.access$102(this.a, true);
      }
    }
    label79:
    while (!ViolaFragment.access$100(this.a)) {
      return;
    }
    this.a.setStatusBarFontColor(Boolean.valueOf(true));
    FlymeOSStatusBarFontUtils.a(this.a.getActivity(), false);
    ViolaFragment.access$102(this.a, false);
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "initViola process,process code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment.7
 * JD-Core Version:    0.7.0.1
 */