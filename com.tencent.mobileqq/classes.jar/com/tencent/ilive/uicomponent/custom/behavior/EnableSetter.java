package com.tencent.ilive.uicomponent.custom.behavior;

import android.view.View;

public class EnableSetter
  implements ViewBehaviorSetter
{
  private boolean enabled;
  
  public EnableSetter(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
  
  public void apply(View paramView)
  {
    if (paramView != null) {
      paramView.setEnabled(this.enabled);
    }
  }
  
  public boolean isEnabled()
  {
    return this.enabled;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.custom.behavior.EnableSetter
 * JD-Core Version:    0.7.0.1
 */