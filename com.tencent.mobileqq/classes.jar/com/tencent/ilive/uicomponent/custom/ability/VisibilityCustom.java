package com.tencent.ilive.uicomponent.custom.ability;

import com.tencent.ilive.uicomponent.UIOuter;
import com.tencent.ilive.uicomponent.custom.behavior.VisibilitySetter;

public class VisibilityCustom
  extends BaseUICustom
{
  public VisibilityCustom(String paramString, Class<? extends UIOuter> paramClass, int paramInt)
  {
    super(paramString, paramClass);
    this.viewBehaviorSetter = new VisibilitySetter(paramInt);
  }
  
  public BaseUICustom getCustom(int paramInt)
  {
    this.viewBehaviorSetter = new VisibilitySetter(paramInt);
    return this;
  }
  
  public int getVisibility()
  {
    return ((VisibilitySetter)this.viewBehaviorSetter).getVisibility();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.custom.ability.VisibilityCustom
 * JD-Core Version:    0.7.0.1
 */