package com.tencent.ark;

import android.view.MotionEvent;

final class ArkViewModelBase$TouchRunnable
  implements Runnable
{
  private int mAction;
  private ark.Container mContainer;
  private int[] mId;
  private float[] mX;
  private float[] mY;
  
  public ArkViewModelBase$TouchRunnable(MotionEvent paramMotionEvent, ark.Container paramContainer, float paramFloat)
  {
    this.mAction = paramMotionEvent.getActionMasked();
    this.mContainer = paramContainer;
    int i;
    if ((this.mAction == 5) || (this.mAction == 6))
    {
      this.mId = new int[1];
      this.mX = new float[1];
      this.mY = new float[1];
      i = paramMotionEvent.getActionIndex();
      this.mId[0] = paramMotionEvent.getPointerId(i);
      this.mX[0] = (paramMotionEvent.getX(i) / paramFloat);
      this.mY[0] = (paramMotionEvent.getY(i) / paramFloat);
    }
    for (;;)
    {
      return;
      int k = paramMotionEvent.getPointerCount();
      i = k;
      if (k > ark.arkGetMaxTouchPoints()) {
        i = ark.arkGetMaxTouchPoints();
      }
      this.mId = new int[i];
      this.mX = new float[i];
      this.mY = new float[i];
      while (j < i)
      {
        this.mId[j] = paramMotionEvent.getPointerId(j);
        this.mX[j] = (paramMotionEvent.getX(j) / paramFloat);
        this.mY[j] = (paramMotionEvent.getY(j) / paramFloat);
        j += 1;
      }
    }
  }
  
  public void run()
  {
    if ((ArkViewModelBase.ENV.mIsDebug) && (this.mAction != 2)) {
      ArkViewModelBase.ENV.logD("ArkApp.ArkViewModelBase", String.format("TouchRunnable.action.%d.count.%d", new Object[] { Integer.valueOf(this.mAction), Integer.valueOf(this.mId.length) }));
    }
    switch (this.mAction)
    {
    case 4: 
    default: 
      return;
    case 0: 
    case 5: 
      this.mContainer.TouchStart(this.mX, this.mY, this.mId, this.mId.length);
      return;
    case 2: 
      this.mContainer.TouchMove(this.mX, this.mY, this.mId, this.mId.length);
      return;
    case 1: 
    case 6: 
      this.mContainer.TouchEnd(this.mX, this.mY, this.mId, this.mId.length);
      return;
    }
    this.mContainer.TouchCancel(this.mX, this.mY, this.mId, this.mId.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.TouchRunnable
 * JD-Core Version:    0.7.0.1
 */