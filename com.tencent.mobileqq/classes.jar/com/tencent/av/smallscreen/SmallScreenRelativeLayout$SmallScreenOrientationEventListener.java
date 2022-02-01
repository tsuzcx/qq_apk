package com.tencent.av.smallscreen;

import android.content.Context;
import android.view.OrientationEventListener;

class SmallScreenRelativeLayout$SmallScreenOrientationEventListener
  extends OrientationEventListener
{
  private int b = -1;
  
  SmallScreenRelativeLayout$SmallScreenOrientationEventListener(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = paramInt + 360;
    }
    if ((i <= 314) && (i >= 45))
    {
      if (i < 135) {
        paramInt = 90;
      } else if (i < 225) {
        paramInt = 180;
      } else {
        paramInt = 270;
      }
    }
    else {
      paramInt = 0;
    }
    if (paramInt != this.b)
    {
      this.b = paramInt;
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenRelativeLayout.SmallScreenOrientationEventListener
 * JD-Core Version:    0.7.0.1
 */