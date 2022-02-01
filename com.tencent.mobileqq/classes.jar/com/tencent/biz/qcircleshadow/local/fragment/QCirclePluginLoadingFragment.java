package com.tencent.biz.qcircleshadow.local.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import bhht;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import vgn;
import vgz;

public class QCirclePluginLoadingFragment
  extends PublicBaseFragment
{
  private bhht a;
  
  public boolean onBackEvent()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    if (getActivity() != null) {
      getActivity().finish();
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (ImmersiveUtils.isSupporImmersive() != 0)
    {
      paramBundle = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
      paramBundle.init();
      paramBundle.setStatusBarColor(getResources().getColor(2131167276));
    }
    paramBundle = (QCirclePluginInitBean)getActivity().getIntent().getExtras().getSerializable("KEY_Q_CIRCLE_PLUGIN_INIT_BEAN");
    this.a = new bhht(getActivity());
    this.a.show();
    vgn.a(getActivity(), new vgz(this, paramBundle));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.fragment.QCirclePluginLoadingFragment
 * JD-Core Version:    0.7.0.1
 */