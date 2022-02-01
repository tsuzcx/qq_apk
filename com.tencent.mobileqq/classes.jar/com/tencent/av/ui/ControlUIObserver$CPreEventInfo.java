package com.tencent.av.ui;

import android.view.View;

public class ControlUIObserver$CPreEventInfo
  extends ControlUIObserver.BaseParameter
{
  private View b = null;
  public boolean d = false;
  public String e;
  
  public ControlUIObserver$CPreEventInfo(int paramInt, View paramView)
  {
    super(paramInt);
    this.b = paramView;
  }
  
  public ControlUIObserver$CPreEventInfo(View paramView)
  {
    super(0);
    this.b = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ControlUIObserver.CPreEventInfo
 * JD-Core Version:    0.7.0.1
 */