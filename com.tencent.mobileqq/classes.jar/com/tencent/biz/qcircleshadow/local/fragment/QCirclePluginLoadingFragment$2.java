package com.tencent.biz.qcircleshadow.local.fragment;

import android.support.v4.app.QFragmentActivity;
import com.tencent.biz.qcircleshadow.lib.QCircleInitInject;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.biz.qcircleshadow.local.widget.QCirclePluginLoadingDialog;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager;
import java.util.List;

class QCirclePluginLoadingFragment$2
  extends ILoadPluginDelegate
{
  QCirclePluginLoadingFragment$2(QCirclePluginLoadingFragment paramQCirclePluginLoadingFragment, QCirclePluginInitBean paramQCirclePluginInitBean) {}
  
  public void onLoadingFailed(int paramInt, String paramString)
  {
    QCirclePluginManager.a().b();
    QCircleInitInject.g().getPluginCallbacks().clear();
    if ((this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment.getActivity() != null) && (!this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment.getActivity().isFinishing()) && (QCirclePluginLoadingFragment.a(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment) != null))
    {
      QCirclePluginLoadingFragment.a(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment).dismiss();
      this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment.getActivity().finish();
    }
  }
  
  public void onLoadingSuccess()
  {
    QCirclePluginManager.a().b();
    QCircleInitInject.g().getPluginCallbacks().clear();
    if ((this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment.getActivity() != null) && (!this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment.getActivity().isFinishing()) && (QCirclePluginLoadingFragment.a(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment) != null))
    {
      this.jdField_a_of_type_ComTencentBizQcircleshadowLibQCirclePluginInitBean.setStartTime(System.currentTimeMillis());
      QCirclePluginLoadingFragment.a(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment).dismiss();
      this.jdField_a_of_type_ComTencentBizQcircleshadowLocalFragmentQCirclePluginLoadingFragment.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.fragment.QCirclePluginLoadingFragment.2
 * JD-Core Version:    0.7.0.1
 */