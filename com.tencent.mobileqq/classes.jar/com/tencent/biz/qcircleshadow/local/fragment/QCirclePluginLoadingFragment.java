package com.tencent.biz.qcircleshadow.local.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qcircleshadow.lib.QCircleInitInject;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.biz.qcircleshadow.local.QCirclePluginEnter;
import com.tencent.biz.qcircleshadow.local.widget.QCirclePluginLoadingDialog;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.app.MobileQQ;

public class QCirclePluginLoadingFragment
  extends QPublicBaseFragment
{
  private ILoadPluginDelegate jdField_a_of_type_ComTencentBizQcircleshadowLibDelegateILoadPluginDelegate;
  private QCirclePluginLoadingDialog jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetQCirclePluginLoadingDialog;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetQCirclePluginLoadingDialog = new QCirclePluginLoadingDialog(getActivity());
    this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetQCirclePluginLoadingDialog.setOnKeyListener(new QCirclePluginLoadingFragment.1(this));
    this.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetQCirclePluginLoadingDialog.a();
  }
  
  private void a(QCirclePluginInitBean paramQCirclePluginInitBean)
  {
    this.jdField_a_of_type_ComTencentBizQcircleshadowLibDelegateILoadPluginDelegate = new QCirclePluginLoadingFragment.2(this);
  }
  
  private void b()
  {
    if ((getActivity().getIntent() != null) && (getActivity().getIntent().getExtras() != null))
    {
      if (!getActivity().getIntent().getExtras().containsKey("KEY_Q_CIRCLE_PLUGIN_INIT_BEAN")) {
        return;
      }
      QCirclePluginInitBean localQCirclePluginInitBean = (QCirclePluginInitBean)getActivity().getIntent().getExtras().getSerializable("KEY_Q_CIRCLE_PLUGIN_INIT_BEAN");
      if (localQCirclePluginInitBean == null) {
        return;
      }
      a(localQCirclePluginInitBean);
      QCircleInitInject.g().injectPluginCallback(this.jdField_a_of_type_ComTencentBizQcircleshadowLibDelegateILoadPluginDelegate);
      localQCirclePluginInitBean.setLoadAction(1004);
      QCirclePluginEnter.enterQCirclePlugin(MobileQQ.sMobileQQ, localQCirclePluginInitBean);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (ImmersiveUtils.isSupporImmersive() != 0)
    {
      paramBundle = ((QPublicFragmentActivity)getActivity()).mSystemBarComp;
      if (paramBundle != null)
      {
        paramBundle.init();
        paramBundle.setStatusBarColor(getResources().getColor(2131167333));
      }
    }
    a();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.fragment.QCirclePluginLoadingFragment
 * JD-Core Version:    0.7.0.1
 */