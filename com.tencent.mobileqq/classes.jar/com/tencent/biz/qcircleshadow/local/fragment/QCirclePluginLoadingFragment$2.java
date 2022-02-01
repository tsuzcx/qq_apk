package com.tencent.biz.qcircleshadow.local.fragment;

import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.biz.qcircleshadow.local.widget.QCirclePluginLoadingDialog;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager;

class QCirclePluginLoadingFragment$2
  extends ILoadPluginDelegate
{
  QCirclePluginLoadingFragment$2(QCirclePluginLoadingFragment paramQCirclePluginLoadingFragment) {}
  
  public void onLoadingFailed(int paramInt, String paramString)
  {
    QCirclePluginManager.a().b();
    if ((this.a.getActivity() != null) && (!this.a.getActivity().isFinishing()) && (QCirclePluginLoadingFragment.a(this.a) != null))
    {
      QCirclePluginLoadingFragment.a(this.a).dismiss();
      this.a.getActivity().finish();
    }
  }
  
  public void onLoadingSuccess()
  {
    QCirclePluginManager.a().b();
    if ((this.a.getActivity() != null) && (!this.a.getActivity().isFinishing()) && (QCirclePluginLoadingFragment.a(this.a) != null))
    {
      QCirclePluginLoadingFragment.a(this.a).dismiss();
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.fragment.QCirclePluginLoadingFragment.2
 * JD-Core Version:    0.7.0.1
 */