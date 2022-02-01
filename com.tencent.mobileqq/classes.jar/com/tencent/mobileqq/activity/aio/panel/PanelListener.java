package com.tencent.mobileqq.activity.aio.panel;

public abstract interface PanelListener
{
  public abstract void onHideAllPanel();
  
  public abstract void onPanelChanged(int paramInt1, int paramInt2);
  
  public abstract void onPanelIconClickBeforeCreate(int paramInt);
  
  public abstract void postOnPanelChanged(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PanelListener
 * JD-Core Version:    0.7.0.1
 */