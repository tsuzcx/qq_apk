package com.tencent.av.ui;

import android.view.View;

public class ControlUIObserver$CPreEventInfo
  extends ControlUIObserver.BaseParameter
{
  private View a = null;
  public String b;
  public boolean b = false;
  
  public ControlUIObserver$CPreEventInfo(int paramInt, View paramView)
  {
    super(paramInt);
    this.a = paramView;
  }
  
  public ControlUIObserver$CPreEventInfo(View paramView)
  {
    super(0);
    this.a = paramView;
  }
  
  public View a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.ControlUIObserver.CPreEventInfo
 * JD-Core Version:    0.7.0.1
 */