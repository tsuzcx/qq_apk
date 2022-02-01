package com.tencent.mobileqq.browser;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class DraggablePopup$1
  implements View.OnKeyListener
{
  DraggablePopup$1(DraggablePopup paramDraggablePopup) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.a.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.browser.DraggablePopup.1
 * JD-Core Version:    0.7.0.1
 */