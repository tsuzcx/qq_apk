package com.tencent.ilive.base.page.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ilive.base.bizmodule.BizModuleContext;
import com.tencent.ilive.base.bizmodule.BizModulesFactory;
import com.tencent.ilive.base.bizmodule.BootBizModules;
import com.tencent.ilive.base.component.ComponentFactory;
import com.tencent.ilive.base.page.PageListener;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilivesdk.domain.factory.LiveCaseFactory;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public abstract class LiveTemplateFragment
  extends LiveFragment
{
  protected BizModuleContext bizModuleContext;
  protected BizModulesFactory bizModulesFactory = new BizModulesFactory();
  protected BootBizModules bootBizModules;
  protected ComponentFactory componentFactory = new ComponentFactory();
  public boolean isFragmentCreated = false;
  protected LiveCaseFactory liveCaseFactory = new LiveCaseFactory();
  protected PageListener pageListener;
  
  public abstract BizModuleContext createBizModuleContext();
  
  public abstract BootBizModules createBootBizModules();
  
  public abstract void createBootBizModulesExtData();
  
  protected void destroyRoomAuto()
  {
    BootBizModules localBootBizModules = this.bootBizModules;
    if (localBootBizModules != null) {
      localBootBizModules.onDestroy();
    }
  }
  
  public void finish()
  {
    super.finish();
    BootBizModules localBootBizModules = this.bootBizModules;
    if (localBootBizModules != null) {
      localBootBizModules.finish();
    }
  }
  
  public BizModulesFactory getBizModulesFactory()
  {
    return this.bizModulesFactory;
  }
  
  public BootBizModules getBootBizModules()
  {
    return this.bootBizModules;
  }
  
  public ComponentFactory getComponentFactory()
  {
    return this.componentFactory;
  }
  
  public LiveCaseFactory getLiveCaseFactory()
  {
    return this.liveCaseFactory;
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    Log.i("AudienceTime", "-- fragment onActivityCreated--");
    if ((this.bootBizModules != null) && (BizEngineMgr.getInstance().getLiveEngine() != null))
    {
      paramBundle = this.pageListener;
      if (paramBundle != null) {
        paramBundle.onFragmentCreated();
      }
      this.isFragmentCreated = true;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bootBizModules == null,savedInstanceState=");
    localStringBuilder.append(paramBundle);
    Log.e("LiveTemplateFragment", localStringBuilder.toString());
    getActivity().finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent) {}
  
  public boolean onBackPressed()
  {
    BootBizModules localBootBizModules = this.bootBizModules;
    if (localBootBizModules != null) {
      return localBootBizModules.onBackPressed();
    }
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      Log.d("LiveFragment", "onConfigurationChanged ORIENTATION_PORTRAIT");
      return;
    }
    if (paramConfiguration.orientation == 2) {
      Log.d("LiveFragment", "onConfigurationChanged ORIENTATION_LANDSCAPE");
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("AudienceTime", "-- fragment oncreate--");
    this.componentFactory.onCreate(getLifecycle());
    this.bootBizModules = createBootBizModules();
    if ((this.bootBizModules != null) && (BizEngineMgr.getInstance().getLiveEngine() != null))
    {
      this.bootBizModules.setComponentFactory(getComponentFactory());
      this.bootBizModules.setLiveCaseFactory(getLiveCaseFactory());
      this.bootBizModules.bindActivityLifeCycleOwner(getActivity());
      this.bootBizModules.bindLifeCycleOwner(this);
      this.bizModuleContext = createBizModuleContext();
      this.bootBizModules.setBizModuleContext(this.bizModuleContext);
      createBootBizModulesExtData();
      this.bootBizModules.onCreate(getContext());
      Log.i("AudienceTime", "-- fragment onFragmentCreated--");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bootBizModules == null,savedInstanceState=");
    localStringBuilder.append(paramBundle);
    Log.e("LiveTemplateFragment", localStringBuilder.toString());
    getActivity().finish();
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = this.bootBizModules.getLayout();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    destroyRoomAuto();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.bootBizModules.onDestroyView();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt) {}
  
  public void setPageListener(PageListener paramPageListener)
  {
    this.pageListener = paramPageListener;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    BootBizModules localBootBizModules = this.bootBizModules;
    if (localBootBizModules != null) {
      localBootBizModules.setUserVisibleHint(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.base.page.fragment.LiveTemplateFragment
 * JD-Core Version:    0.7.0.1
 */