package com.tencent.ilivesdk.uicustomservice_interface;

import android.content.Context;
import com.tencent.ilive.uicomponent.UIOuter;
import com.tencent.ilive.uicomponent.custom.ability.BaseUICustom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseUICustomService
  implements UICustomServiceInterface
{
  private Map<Class<? extends UIOuter>, List<BaseUICustom>> mCustomMap;
  
  private void initCustoms()
  {
    if (this.mCustomMap == null)
    {
      this.mCustomMap = new HashMap();
      customUI();
    }
  }
  
  public void addCustom(BaseUICustom paramBaseUICustom)
  {
    Class localClass = paramBaseUICustom.getComponentInterface();
    if (this.mCustomMap.get(localClass) == null) {
      this.mCustomMap.put(localClass, new ArrayList());
    }
    ((List)this.mCustomMap.get(localClass)).add(paramBaseUICustom);
  }
  
  public void clearEventOutput() {}
  
  public abstract void customUI();
  
  public <T extends BaseUICustom> T getUICustom(Class<? extends UIOuter> paramClass, String paramString, Class<T> paramClass1)
  {
    initCustoms();
    paramClass = (List)this.mCustomMap.get(paramClass);
    if (paramClass == null) {
      return null;
    }
    paramClass = paramClass.iterator();
    while (paramClass.hasNext())
    {
      BaseUICustom localBaseUICustom = (BaseUICustom)paramClass.next();
      if ((localBaseUICustom.getTag().equals(paramString)) && (localBaseUICustom.getClass() == paramClass1)) {
        return localBaseUICustom;
      }
    }
    return null;
  }
  
  public List<BaseUICustom> getUICustoms(Class<? extends UIOuter> paramClass)
  {
    initCustoms();
    return (List)this.mCustomMap.get(paramClass);
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.uicustomservice_interface.BaseUICustomService
 * JD-Core Version:    0.7.0.1
 */