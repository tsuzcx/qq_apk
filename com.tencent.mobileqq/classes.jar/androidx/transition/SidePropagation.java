package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

public class SidePropagation
  extends VisibilityPropagation
{
  private float mPropagationSpeed = 3.0F;
  private int mSide = 80;
  
  private int distance(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int j = this.mSide;
    int k = 1;
    int i = 1;
    if (j == 8388611)
    {
      if (ViewCompat.getLayoutDirection(paramView) != 1) {
        i = 0;
      }
      if (i != 0)
      {
        i = 5;
        break label87;
      }
    }
    for (;;)
    {
      i = 3;
      break label87;
      i = j;
      if (j != 8388613) {
        break label87;
      }
      if (ViewCompat.getLayoutDirection(paramView) == 1) {
        i = k;
      } else {
        i = 0;
      }
      if (i == 0) {
        break;
      }
    }
    label87:
    if (i != 3)
    {
      if (i != 5)
      {
        if (i != 48)
        {
          if (i != 80) {
            return 0;
          }
          return paramInt2 - paramInt6 + Math.abs(paramInt3 - paramInt1);
        }
        return paramInt8 - paramInt2 + Math.abs(paramInt3 - paramInt1);
      }
      return paramInt1 - paramInt5 + Math.abs(paramInt4 - paramInt2);
    }
    return paramInt7 - paramInt1 + Math.abs(paramInt4 - paramInt2);
  }
  
  private int getMaxDistance(ViewGroup paramViewGroup)
  {
    int i = this.mSide;
    if ((i != 3) && (i != 5) && (i != 8388611) && (i != 8388613)) {
      return paramViewGroup.getHeight();
    }
    return paramViewGroup.getWidth();
  }
  
  public long getStartDelay(ViewGroup paramViewGroup, Transition paramTransition, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if ((paramTransitionValues1 == null) && (paramTransitionValues2 == null)) {
      return 0L;
    }
    Rect localRect = paramTransition.getEpicenter();
    int i;
    if ((paramTransitionValues2 != null) && (getViewVisibility(paramTransitionValues1) != 0))
    {
      i = 1;
      paramTransitionValues1 = paramTransitionValues2;
    }
    else
    {
      i = -1;
    }
    int m = getViewX(paramTransitionValues1);
    int n = getViewY(paramTransitionValues1);
    paramTransitionValues1 = new int[2];
    paramViewGroup.getLocationOnScreen(paramTransitionValues1);
    int i1 = paramTransitionValues1[0] + Math.round(paramViewGroup.getTranslationX());
    int i2 = paramTransitionValues1[1] + Math.round(paramViewGroup.getTranslationY());
    int i3 = i1 + paramViewGroup.getWidth();
    int i4 = i2 + paramViewGroup.getHeight();
    int j;
    int k;
    if (localRect != null)
    {
      j = localRect.centerX();
      k = localRect.centerY();
    }
    else
    {
      j = (i1 + i3) / 2;
      k = (i2 + i4) / 2;
    }
    float f = distance(paramViewGroup, m, n, j, k, i1, i2, i3, i4) / getMaxDistance(paramViewGroup);
    long l2 = paramTransition.getDuration();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 300L;
    }
    return Math.round((float)(l1 * i) / this.mPropagationSpeed * f);
  }
  
  public void setPropagationSpeed(float paramFloat)
  {
    if (paramFloat != 0.0F)
    {
      this.mPropagationSpeed = paramFloat;
      return;
    }
    throw new IllegalArgumentException("propagationSpeed may not be 0");
  }
  
  public void setSide(int paramInt)
  {
    this.mSide = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.SidePropagation
 * JD-Core Version:    0.7.0.1
 */