package com.tencent.ilive.base.bizmodule;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.base.component.ComponentFactory;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.uicomponent.PageLifeCycle;
import com.tencent.ilivesdk.domain.factory.LiveCaseFactory;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.liveengine.LiveEngine;

public abstract class BaseBizModule
  implements BizModule, PageLifeCycle
{
  protected BizModuleBaseAdapter bizModuleBaseAdapter;
  protected BizModuleContext bizModuleContext;
  protected ComponentFactory componentFactory;
  public Context context;
  protected ModuleEvent event;
  public boolean isUserVisibleHint = false;
  protected boolean landscape;
  protected LiveCaseFactory liveCaseFactory;
  protected LifecycleOwner mLifecycleOwner;
  protected ViewGroup rootView;
  
  public void finish() {}
  
  public BizModuleContext getBizLogicContext()
  {
    return this.bizModuleContext;
  }
  
  public ComponentFactory getComponentFactory()
  {
    return this.componentFactory;
  }
  
  public ModuleEvent getEvent()
  {
    return this.event;
  }
  
  public HttpInterface getHttp()
  {
    return (HttpInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HttpInterface.class);
  }
  
  public ImageLoaderInterface getImageLoader()
  {
    return (ImageLoaderInterface)BizEngineMgr.getInstance().getLiveEngine().getService(ImageLoaderInterface.class);
  }
  
  public LiveCaseFactory getLiveCaseFactory()
  {
    return this.liveCaseFactory;
  }
  
  protected LiveEngine getLiveEngine()
  {
    return BizEngineMgr.getInstance().getLiveEngine();
  }
  
  public LogInterface getLog()
  {
    return (LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class);
  }
  
  public ViewGroup getRootView()
  {
    return this.rootView;
  }
  
  protected UserEngine getUserEngine()
  {
    return BizEngineMgr.getInstance().getUserEngine();
  }
  
  public void onActivityCreate(LifecycleOwner paramLifecycleOwner)
  {
    this.mLifecycleOwner = paramLifecycleOwner;
  }
  
  public void onActivityDestroy(LifecycleOwner paramLifecycleOwner)
  {
    paramLifecycleOwner.getLifecycle().removeObserver(this);
  }
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner) {}
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner) {}
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner) {}
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner) {}
  
  public boolean onBackPressed()
  {
    return true;
  }
  
  public void onCreate(Context paramContext)
  {
    this.context = paramContext;
  }
  
  protected abstract void onCreateCases();
  
  public void onCreateView() {}
  
  public void onDestroy()
  {
    this.rootView = null;
    this.context = null;
    this.bizModuleBaseAdapter = null;
    this.componentFactory = null;
    this.liveCaseFactory = null;
  }
  
  public void onDestroyView() {}
  
  public void onExtActive() {}
  
  public void onExtDeActive() {}
  
  protected abstract void onInflateComponent();
  
  protected abstract void onInitComponentEvent();
  
  public void onLifecycleChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent) {}
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    this.isUserVisibleHint = paramBoolean;
  }
  
  public <T extends BizModuleContext> void setBizLogicContext(T paramT)
  {
    this.bizModuleContext = paramT;
  }
  
  public void setBizModuleBaseAdapter(BizModuleBaseAdapter paramBizModuleBaseAdapter)
  {
    this.bizModuleBaseAdapter = paramBizModuleBaseAdapter;
  }
  
  public void setComponentFactory(ComponentFactory paramComponentFactory)
  {
    this.componentFactory = paramComponentFactory;
  }
  
  public void setEvent(ModuleEvent paramModuleEvent)
  {
    this.event = paramModuleEvent;
  }
  
  public void setLiveCaseFactory(LiveCaseFactory paramLiveCaseFactory)
  {
    this.liveCaseFactory = paramLiveCaseFactory;
  }
  
  public void setOrientation(boolean paramBoolean)
  {
    this.landscape = paramBoolean;
  }
  
  public void setRootView(ViewGroup paramViewGroup)
  {
    this.rootView = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.bizmodule.BaseBizModule
 * JD-Core Version:    0.7.0.1
 */