package com.tencent.ilive.base.component;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.tencent.ilive.uicomponent.UIBaseAdapter;
import com.tencent.ilive.uicomponent.UIBaseComponent;
import com.tencent.ilive.uicomponent.UIOuter;
import com.tencent.ilive.uicomponent.UIRoot;
import java.util.List;
import java.util.Map;

public class ComponentFactory$ComponentsBuilder
{
  private static UIBaseAdapter uiBaseAdapter = new ComponentFactory.ComponentsBuilder.1();
  Class cls;
  ComponentConfig componentConfig;
  List<UIRoot> componentList;
  Lifecycle lifecycle;
  View rootView;
  
  ComponentFactory$ComponentsBuilder(Class paramClass, Lifecycle paramLifecycle, List<UIRoot> paramList, ComponentConfig paramComponentConfig)
  {
    this.cls = paramClass;
    this.lifecycle = paramLifecycle;
    this.componentList = paramList;
    this.componentConfig = paramComponentConfig;
  }
  
  public <T extends UIOuter> T build()
  {
    try
    {
      Object localObject = (ComponentBuilder)this.componentConfig.get().get(this.cls);
      if (localObject != null)
      {
        localObject = (UIBaseComponent)((ComponentBuilder)localObject).build();
        ((UIBaseComponent)localObject).bindPageLifeCycle(this.lifecycle);
        ((UIBaseComponent)localObject).onCreate(this.rootView);
        ((UIBaseComponent)localObject).setUIBaseAdapter(uiBaseAdapter);
        this.componentList.add(localObject);
        localObject = (UIOuter)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public ComponentsBuilder setRootView(View paramView)
  {
    this.rootView = paramView;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.base.component.ComponentFactory.ComponentsBuilder
 * JD-Core Version:    0.7.0.1
 */