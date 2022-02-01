package com.tencent.ilive.base.component;

import androidx.lifecycle.Lifecycle;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.uicomponent.UIOuter;
import com.tencent.ilive.uicomponent.UIRoot;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.ServiceAccessorConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComponentFactory
{
  protected ComponentConfig componentConfig = new ComponentConfig();
  private List<UIRoot> componentList;
  private Lifecycle lifecycle;
  
  public void addConfig(ComponentConfig paramComponentConfig, RoomEngine paramRoomEngine)
  {
    Object localObject2 = BizEngineMgr.getInstance().getLiveEngine().getServiceAccessor();
    ServiceAccessor localServiceAccessor = BizEngineMgr.getInstance().getUserEngine().getServiceAccessor();
    Object localObject1 = null;
    if (paramRoomEngine != null) {
      localObject1 = paramRoomEngine.getServiceAccessor();
    }
    paramRoomEngine = new ServiceAccessorConfig((ServiceAccessor)localObject2, localServiceAccessor, (ServiceAccessor)localObject1);
    if (paramComponentConfig.get().size() > 0)
    {
      localObject1 = paramComponentConfig.get().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Class)((Iterator)localObject1).next();
        localObject2 = (ComponentBuilder)paramComponentConfig.get().get(localObject2);
        if (localObject2 != null) {
          ((ComponentBuilder)localObject2).setAccessorConfig(paramRoomEngine);
        }
      }
    }
    this.componentConfig.merge(paramComponentConfig);
  }
  
  public ComponentFactory.ComponentsBuilder getComponent(Class<? extends UIOuter> paramClass)
  {
    return new ComponentFactory.ComponentsBuilder(paramClass, this.lifecycle, this.componentList, this.componentConfig);
  }
  
  public ComponentConfig getConfig()
  {
    return this.componentConfig;
  }
  
  public void onCreate(Lifecycle paramLifecycle)
  {
    this.lifecycle = paramLifecycle;
    this.componentList = new ArrayList();
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.componentList.iterator();
    while (localIterator.hasNext()) {
      ((UIRoot)localIterator.next()).onDestroy();
    }
    this.componentList.clear();
    this.componentConfig.clear();
    this.lifecycle = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.component.ComponentFactory
 * JD-Core Version:    0.7.0.1
 */