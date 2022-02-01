package com.tencent.ilivesdk.uicustomservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilive.uicomponent.UIOuter;
import com.tencent.ilive.uicomponent.custom.ability.BaseUICustom;
import java.util.List;

public abstract interface UICustomServiceInterface
  extends ServiceBaseInterface
{
  public abstract void addCustom(BaseUICustom paramBaseUICustom);
  
  public abstract void customUI();
  
  public abstract <T extends BaseUICustom> T getUICustom(Class<? extends UIOuter> paramClass, String paramString, Class<T> paramClass1);
  
  public abstract List<BaseUICustom> getUICustoms(Class<? extends UIOuter> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.uicustomservice_interface.UICustomServiceInterface
 * JD-Core Version:    0.7.0.1
 */