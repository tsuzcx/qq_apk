package com.tencent.biz.qcircleshadow.local.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.app.MobileQQ;

public class QCircleHostTransLoginOutFragment
  extends QPublicBaseFragment
{
  private int a;
  private int b;
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ((ILoginApi)QRoute.api(ILoginApi.class)).checkA1Error(getActivity(), MobileQQ.sMobileQQ.waitAppRuntime(null), "登录异常", "当前QQ帐号状态异常。你可以退出当前帐号，并在重新登录后再次尝试。", "qq_circle", new QCircleHostTransLoginOutFragment.1(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (ImmersiveUtils.isSupporImmersive() != 0)
    {
      ((QPublicFragmentActivity)getActivity()).mSystemBarComp.init();
      ((QPublicFragmentActivity)getActivity()).mSystemBarComp.setStatusBarColor(getResources().getColor(2131168376));
    }
    if (getActivity() != null) {
      this.a = getActivity().hashCode();
    }
    if (HostUIHelper.getShadowTopContext() != null) {
      this.b = HostUIHelper.getShadowTopContext().hashCode();
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.fragment.QCircleHostTransLoginOutFragment
 * JD-Core Version:    0.7.0.1
 */