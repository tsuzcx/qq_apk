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
    int i = this.mAction;
    int j = 0;
    if ((i != 5) && (i != 6))
    {
      int k = paramMotionEvent.getPointerCount();
      i = k;
      if (k > ark.arkGetMaxTouchPoints()) {
        i = ark.arkGetMaxTouchPoints();
      }
      this.mId = new int[i];
      this.mX = new float[i];
      this.mY = new float[i];
    }
    while (j < i)
    {
      this.mId[j] = paramMotionEvent.getPointerId(j);
      this.mX[j] = (paramMotionEvent.getX(j) / paramFloat);
      this.mY[j] = (paramMotionEvent.getY(j) / paramFloat);
      j += 1;
      continue;
      this.mId = new int[1];
      this.mX = new float[1];
      this.mY = new float[1];
      i = paramMotionEvent.getActionIndex();
      this.mId[0] = paramMotionEvent.getPointerId(i);
      this.mX[0] = (paramMotionEvent.getX(i) / paramFloat);
      this.mY[0] = (paramMotionEvent.getY(i) / paramFloat);
    }
  }
  
  public void run()
  {
    if (ArkViewModelBase.ENV.mIsDebug)
    {
      i = this.mAction;
      if (i != 2) {
        Logger.logD("ArkApp.ViewModel", String.format("TouchRunnable.action.%d.count.%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mId.length) }));
      }
    }
    int i = this.mAction;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 5) {
              break label192;
            }
            if (i == 6) {}
          }
          else
          {
            localContainer = this.mContainer;
            arrayOfFloat1 = this.mX;
            arrayOfFloat2 = this.mY;
            arrayOfInt = this.mId;
            localContainer.TouchCancel(arrayOfFloat1, arrayOfFloat2, arrayOfInt, arrayOfInt.length);
          }
        }
        else
        {
          localContainer = this.mContainer;
          arrayOfFloat1 = this.mX;
          arrayOfFloat2 = this.mY;
          arrayOfInt = this.mId;
          localContainer.TouchMove(arrayOfFloat1, arrayOfFloat2, arrayOfInt, arrayOfInt.length);
          return;
        }
      }
      localContainer = this.mContainer;
      arrayOfFloat1 = this.mX;
      arrayOfFloat2 = this.mY;
      arrayOfInt = this.mId;
      localContainer.TouchEnd(arrayOfFloat1, arrayOfFloat2, arrayOfInt, arrayOfInt.length);
      return;
    }
    label192:
    ark.Container localContainer = this.mContainer;
    float[] arrayOfFloat1 = this.mX;
    float[] arrayOfFloat2 = this.mY;
    int[] arrayOfInt = this.mId;
    localContainer.TouchStart(arrayOfFloat1, arrayOfFloat2, arrayOfInt, arrayOfInt.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.TouchRunnable
 * JD-Core Version:    0.7.0.1
 */