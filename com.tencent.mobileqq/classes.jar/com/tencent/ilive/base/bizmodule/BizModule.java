package com.tencent.ilive.base.bizmodule;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleObserver;
import com.tencent.ilive.base.component.ComponentFactory;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilivesdk.domain.factory.LiveCaseFactory;

public abstract interface BizModule
  extends LifecycleObserver, BizModuleBaseAdapter
{
  public abstract void finish();
  
  public abstract BizModuleContext getBizLogicContext();
  
  public abstract ComponentFactory getComponentFactory();
  
  public abstract ModuleEvent getEvent();
  
  public abstract LiveCaseFactory getLiveCaseFactory();
  
  public abstract ViewGroup getRootView();
  
  public abstract boolean onBackPressed();
  
  public abstract void onCreate(Context paramContext);
  
  public abstract void onCreateView();
  
  public abstract void onDestroy();
  
  public abstract void onDestroyView();
  
  public abstract void onExtActive();
  
  public abstract void onExtDeActive();
  
  public abstract void onExtOnStart();
  
  public abstract void onExtOnStop();
  
  public abstract void onVisibleToUser(boolean paramBoolean);
  
  public abstract <T extends BizModuleContext> void setBizLogicContext(T paramT);
  
  public abstract void setBizModuleBaseAdapter(BizModuleBaseAdapter paramBizModuleBaseAdapter);
  
  public abstract void setComponentFactory(ComponentFactory paramComponentFactory);
  
  public abstract void setEvent(ModuleEvent paramModuleEvent);
  
  public abstract void setLiveCaseFactory(LiveCaseFactory paramLiveCaseFactory);
  
  public abstract void setOrientation(boolean paramBoolean);
  
  public abstract void setRootView(ViewGroup paramViewGroup);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.base.bizmodule.BizModule
 * JD-Core Version:    0.7.0.1
 */