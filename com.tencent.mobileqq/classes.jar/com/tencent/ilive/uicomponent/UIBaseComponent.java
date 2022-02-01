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
    UIBaseAdapter localUIBaseAdapter = this.uiBaseAdapter;
    if (localUIBaseAdapter != null) {
      return localUIBaseAdapter.getHttp();
    }
    return null;
  }
  
  public ImageLoaderInterface getImageLoader()
  {
    UIBaseAdapter localUIBaseAdapter = this.uiBaseAdapter;
    if (localUIBaseAdapter != null) {
      return localUIBaseAdapter.getImageLoader();
    }
    return null;
  }
  
  public LogInterface getLog()
  {
    UIBaseAdapter localUIBaseAdapter = this.uiBaseAdapter;
    if (localUIBaseAdapter != null) {
      return localUIBaseAdapter.getLog();
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
    paramView = this.lifecycle;
    if (paramView != null) {
      paramView.addObserver(this);
    }
  }
  
  public void onDestroy()
  {
    Lifecycle localLifecycle = this.lifecycle;
    if (localLifecycle != null)
    {
      localLifecycle.removeObserver(this);
      this.lifecycle = null;
    }
  }
  
  public void onLifecycleChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent) {}
  
  public void setUIBaseAdapter(UIBaseAdapter paramUIBaseAdapter)
  {
    this.uiBaseAdapter = paramUIBaseAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.UIBaseComponent
 * JD-Core Version:    0.7.0.1
 */