package com.tencent.mobileqq.app;

import android.view.View;
import com.tencent.mobileqq.widget.QQBlur.BackgroundViewDirtyListener;

class Frame$2
  implements QQBlur.BackgroundViewDirtyListener
{
  Frame$2(Frame paramFrame, View[] paramArrayOfView) {}
  
  public boolean isDirty()
  {
    View[] arrayOfView = this.a;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfView[i].isDirty()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.Frame.2
 * JD-Core Version:    0.7.0.1
 */