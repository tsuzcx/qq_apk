package com.tencent.ilive.base.event;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

public class ModuleEvent
{
  public LifecycleOwner lifecycleOwner;
  
  public void clearObservers()
  {
    EventManger.getInstance().removeObservers(this.lifecycleOwner);
  }
  
  public <T extends ModuleEventInterface> void observe(Class<T> paramClass, Observer<T> paramObserver)
  {
    EventManger.getInstance().observe(this.lifecycleOwner, paramObserver);
  }
  
  public void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    this.lifecycleOwner = paramLifecycleOwner;
  }
  
  public void onDestroy()
  {
    this.lifecycleOwner = null;
  }
  
  public void post(ModuleEventInterface paramModuleEventInterface)
  {
    EventManger.getInstance().post(this.lifecycleOwner, paramModuleEventInterface);
  }
  
  public <T extends ModuleEventInterface> void removeObserver(Class<T> paramClass, Observer<T> paramObserver)
  {
    EventManger.getInstance().removeObserver(this.lifecycleOwner, paramObserver);
  }
  
  public void syncPost(ModuleEventInterface paramModuleEventInterface)
  {
    EventManger.getInstance().syncPost(this.lifecycleOwner, paramModuleEventInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.event.ModuleEvent
 * JD-Core Version:    0.7.0.1
 */