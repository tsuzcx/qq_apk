package com.tencent.biz.pubaccount.readinjoy.viola;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class ViolaFragment$1
  implements HippyQQEngine.HippyQQEngineListener
{
  ViolaFragment$1(ViolaFragment paramViolaFragment) {}
  
  public void onError(int paramInt, String paramString)
  {
    if (this.a.getActivity() != null) {}
    for (Looper localLooper = this.a.getActivity().getMainLooper();; localLooper = BaseActivity.sTopActivity.getMainLooper())
    {
      new Handler(localLooper).postDelayed(new ViolaFragment.1.1(this), 1000L);
      if (QLog.isColorLevel()) {
        QLog.e("ViolaFragment", 2, "initHippy error statusCode=" + paramInt + ", msg=" + paramString);
      }
      return;
    }
  }
  
  public void onSuccess()
  {
    this.a.mViolaUiDelegate.b();
    this.a.mViolaUiDelegate.d();
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reloadPage success!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment.1
 * JD-Core Version:    0.7.0.1
 */