package com.tencent.ilive.uicomponent;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract class UIBaseComponent
  implements UIBaseAdapter, UIRoot
{
  private Lifecycle lifecycle;
  protected UIBaseAdapter uiBaseAdapter;
  
  public void bindPageLifeCycle(Lifecycle paramLifecycle)
  {
    this.lifecycle = paramLifecycle;
  }
  
  public HttpInterface getHttp()
  {
    if (this.uiBaseAdapter != null) {
      return this.uiBaseAdapter.getHttp();
    }
    return null;
  }
  
  public ImageLoaderInterface getImageLoader()
  {
    if (this.uiBaseAdapter != null) {
      return this.uiBaseAdapter.getImageLoader();
    }
    return null;
  }
  
  public LogInterface getLog()
  {
    if (this.uiBaseAdapter != null) {
      return this.uiBaseAdapter.getLog();
    }
    return null;
  }
  
  public UIView getView()
  {
    return null;
  }
  
  public UIViewModel getViewModel()
  {
    return null;
  }
  
  public void onActivityCreate(LifecycleOwner paramLifecycleOwner) {}
  
  public void onActivityDestroy(LifecycleOwner paramLifecycleOwner) {}
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner) {}
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner) {}
  
  public void onActivityStart(LifecycleOwner paramLifecycleOwner) {}
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner) {}
  
  public void onChangeLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onCreate(View paramView)
  {
    if (this.lifecycle != null) {
      this.lifecycle.addObserver(this);
    }
  }
  
  public void onDestroy()
  {
    if (this.lifecycle != null)
    {
      this.lifecycle.removeObserver(this);
      this.lifecycle = null;
    }
  }
  
  public void onLifecycleChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent) {}
  
  public void setUIBaseAdapter(UIBaseAdapter paramUIBaseAdapter)
  {
    this.uiBaseAdapter = paramUIBaseAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.UIBaseComponent
 * JD-Core Version:    0.7.0.1
 */