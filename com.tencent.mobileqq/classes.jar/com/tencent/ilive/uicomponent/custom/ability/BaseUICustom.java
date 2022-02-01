package com.tencent.ilive.uicomponent.custom.ability;

import com.tencent.ilive.uicomponent.UIOuter;
import com.tencent.ilive.uicomponent.custom.behavior.ViewBehaviorSetter;

public class BaseUICustom
{
  protected Class<? extends UIOuter> belongComponent;
  protected String tag;
  protected ViewBehaviorSetter viewBehaviorSetter;
  
  public BaseUICustom(String paramString, Class<? extends UIOuter> paramClass)
  {
    this.tag = paramString;
    this.belongComponent = paramClass;
  }
  
  public Class<? extends UIOuter> getComponentInterface()
  {
    return this.belongComponent;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public ViewBehaviorSetter getViewBehaviorSetter()
  {
    return this.viewBehaviorSetter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.custom.ability.BaseUICustom
 * JD-Core Version:    0.7.0.1
 */