package com.tencent.biz.qcircleshadow.local.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import vvh;
import vvt;
import vvu;
import vwe;

public class QCirclePluginLoadingFragment
  extends PublicBaseFragment
{
  private ILoadPluginDelegate jdField_a_of_type_ComTencentBizQcircleshadowLibDelegateILoadPluginDelegate;
  private vwe jdField_a_of_type_Vwe;
  
  private void a()
  {
    this.jdField_a_of_type_Vwe = new vwe(getActivity());
    this.jdField_a_of_type_Vwe.setOnKeyListener(new vvt(this));
    this.jdField_a_of_type_Vwe.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizQcircleshadowLibDelegateILoadPluginDelegate = new vvu(this, (QCirclePluginInitBean)getActivity().getIntent().getExtras().getSerializable("KEY_Q_CIRCLE_PLUGIN_INIT_BEAN"));
    vvh.a(getActivity(), this.jdField_a_of_type_ComTencentBizQcircleshadowLibDelegateILoadPluginDelegate);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (ImmersiveUtils.isSupporImmersive() != 0)
    {
      paramBundle = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
      paramBundle.init();
      paramBundle.setStatusBarColor(getResources().getColor(2131167296));
    }
    a();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.fragment.QCirclePluginLoadingFragment
 * JD-Core Version:    0.7.0.1
 */