package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.view.View;
import com.tencent.widget.XPanelContainer;

public abstract interface PanelProvider<T extends View>
{
  public abstract T createPanel(Context paramContext);
  
  public abstract T getPanel();
  
  public abstract int getPanelId();
  
  public abstract boolean isNeedRecreatePanel();
  
  public abstract void onHideAllPanel();
  
  public abstract void onPanelChanged(int paramInt1, int paramInt2);
  
  public abstract void onPanelIconClick(XPanelContainer paramXPanelContainer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PanelProvider
 * JD-Core Version:    0.7.0.1
 */