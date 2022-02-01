package com.tencent.ilive.uicomponent.custom.behavior;

import android.view.View;

public class VisibilitySetter
  implements ViewBehaviorSetter
{
  private int visibility;
  
  public VisibilitySetter(int paramInt)
  {
    this.visibility = paramInt;
  }
  
  public void apply(View paramView)
  {
    paramView.setVisibility(this.visibility);
  }
  
  public int getVisibility()
  {
    return this.visibility;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.custom.behavior.VisibilitySetter
 * JD-Core Version:    0.7.0.1
 */