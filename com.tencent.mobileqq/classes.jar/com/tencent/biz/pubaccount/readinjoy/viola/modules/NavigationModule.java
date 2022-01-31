package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.module.BaseModule;

public class NavigationModule
  extends BaseModule
{
  @JSMethod(uiThread=true)
  public void hide(String paramString)
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment)))
    {
      ((ViolaFragment)localFragment).o();
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, "", true);
    }
  }
  
  @JSMethod(uiThread=true)
  public void reloadPage()
  {
    if (ViolaEnvironment.isDebugable())
    {
      Object localObject = getViolaInstance().getFragment();
      if ((localObject != null) && ((localObject instanceof ViolaFragment)))
      {
        FragmentActivity localFragmentActivity = ((Fragment)localObject).getActivity();
        localObject = ((Fragment)localObject).getActivity().getIntent();
        localFragmentActivity.overridePendingTransition(0, 0);
        ((Intent)localObject).addFlags(65536);
        localFragmentActivity.finish();
        localFragmentActivity.overridePendingTransition(0, 0);
        localFragmentActivity.startActivity((Intent)localObject);
      }
    }
  }
  
  @JSMethod(uiThread=false)
  public void setTitle(String paramString)
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment))) {
      new Handler(BaseActivity.sTopActivity.getMainLooper()).postDelayed(new NavigationModule.1(this, localFragment, paramString), 0L);
    }
  }
  
  @JSMethod(uiThread=true)
  public void show(String paramString)
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment)))
    {
      ((ViolaFragment)localFragment).p();
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.NavigationModule
 * JD-Core Version:    0.7.0.1
 */