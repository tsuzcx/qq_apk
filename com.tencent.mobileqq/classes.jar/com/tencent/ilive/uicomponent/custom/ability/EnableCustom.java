package com.tencent.ilive.uicomponent.custom.ability;

import com.tencent.ilive.uicomponent.UIOuter;
import com.tencent.ilive.uicomponent.custom.behavior.EnableSetter;

public class EnableCustom
  extends BaseUICustom
{
  public EnableCustom(String paramString, Class<? extends UIOuter> paramClass, boolean paramBoolean)
  {
    super(paramString, paramClass);
    this.viewBehaviorSetter = new EnableSetter(paramBoolean);
  }
  
  public BaseUICustom getCustom(boolean paramBoolean)
  {
    this.viewBehaviorSetter = new EnableSetter(paramBoolean);
    return this;
  }
  
  public boolean getEnable()
  {
    return ((EnableSetter)this.viewBehaviorSetter).isEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.custom.ability.EnableCustom
 * JD-Core Version:    0.7.0.1
 */