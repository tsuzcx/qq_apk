package com.tencent.biz.qcircleshadow.local.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qcircleshadow.lib.HostUIHelper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qqcircle.events.HostActivityResultEvent;

public class QCircleHostTransFragment
  extends PublicBaseFragment
{
  private int a;
  private int b;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      bool = true;
    }
    QLog.i("QCircleHostTransFragment", 1, String.format("onActivityResult: requestCode:%d, resultCode:%d, data is null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) }));
    SimpleEventBus.getInstance().dispatchEvent(new HostActivityResultEvent(this.a, this.b, paramInt1, paramInt2, paramIntent));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (ImmersiveUtils.isSupporImmersive() != 0)
    {
      paramLayoutInflater = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
      paramLayoutInflater.init();
      paramLayoutInflater.setStatusBarColor(getResources().getColor(2131167276));
    }
    if (getActivity() != null) {
      this.a = getActivity().hashCode();
    }
    if (HostUIHelper.getShadowTopContext() != null) {
      this.b = HostUIHelper.getShadowTopContext().hashCode();
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.fragment.QCircleHostTransFragment
 * JD-Core Version:    0.7.0.1
 */