package com.tencent.av.smallscreen;

import android.content.Context;
import android.view.OrientationEventListener;

class SmallScreenRelativeLayout$SmallScreenOrientationEventListener
  extends OrientationEventListener
{
  private int jdField_a_of_type_Int = -1;
  
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
    if (paramInt != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenRelativeLayout.SmallScreenOrientationEventListener
 * JD-Core Version:    0.7.0.1
 */