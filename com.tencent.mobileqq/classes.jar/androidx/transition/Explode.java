package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import java.util.Map;

public class Explode
  extends Visibility
{
  private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
  private static final TimeInterpolator sAccelerate = new AccelerateInterpolator();
  private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
  private int[] mTempLoc = new int[2];
  
  public Explode()
  {
    setPropagation(new CircularPropagation());
  }
  
  public Explode(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setPropagation(new CircularPropagation());
  }
  
  private static float calculateDistance(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  private static float calculateMaxDistance(View paramView, int paramInt1, int paramInt2)
  {
    paramInt1 = Math.max(paramInt1, paramView.getWidth() - paramInt1);
    paramInt2 = Math.max(paramInt2, paramView.getHeight() - paramInt2);
    return calculateDistance(paramInt1, paramInt2);
  }
  
  private void calculateOut(View paramView, Rect paramRect, int[] paramArrayOfInt)
  {
    paramView.getLocationOnScreen(this.mTempLoc);
    Object localObject = this.mTempLoc;
    int k = localObject[0];
    int m = localObject[1];
    localObject = getEpicenter();
    int i;
    int j;
    if (localObject == null)
    {
      i = paramView.getWidth() / 2 + k + Math.round(paramView.getTranslationX());
      j = paramView.getHeight() / 2 + m + Math.round(paramView.getTranslationY());
    }
    else
    {
      i = ((Rect)localObject).centerX();
      j = ((Rect)localObject).centerY();
    }
    int n = paramRect.centerX();
    int i1 = paramRect.centerY();
    float f3 = n - i;
    float f4 = i1 - j;
    float f2 = f3;
    float f1 = f4;
    if (f3 == 0.0F)
    {
      f2 = f3;
      f1 = f4;
      if (f4 == 0.0F)
      {
        f2 = (float)(Math.random() * 2.0D) - 1.0F;
        f1 = (float)(Math.random() * 2.0D) - 1.0F;
      }
    }
    f3 = calculateDistance(f2, f1);
    f2 /= f3;
    f1 /= f3;
    f3 = calculateMaxDistance(paramView, i - k, j - m);
    paramArrayOfInt[0] = Math.round(f2 * f3);
    paramArrayOfInt[1] = Math.round(f3 * f1);
  }
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    View localView = paramTransitionValues.view;
    localView.getLocationOnScreen(this.mTempLoc);
    int[] arrayOfInt = this.mTempLoc;
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = localView.getWidth();
    int m = localView.getHeight();
    paramTransitionValues.values.put("android:explode:screenBounds", new Rect(i, j, k + i, m + j));
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    super.captureEndValues(paramTransitionValues);
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    super.captureStartValues(paramTransitionValues);
    captureValues(paramTransitionValues);
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if (paramTransitionValues2 == null) {
      return null;
    }
    paramTransitionValues1 = (Rect)paramTransitionValues2.values.get("android:explode:screenBounds");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    calculateOut(paramViewGroup, paramTransitionValues1, this.mTempLoc);
    paramViewGroup = this.mTempLoc;
    float f3 = paramViewGroup[0];
    float f4 = paramViewGroup[1];
    return TranslationAnimationCreator.createAnimation(paramView, paramTransitionValues2, paramTransitionValues1.left, paramTransitionValues1.top, f1 + f3, f2 + f4, f1, f2, sDecelerate, this);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if (paramTransitionValues1 == null) {
      return null;
    }
    paramTransitionValues2 = (Rect)paramTransitionValues1.values.get("android:explode:screenBounds");
    int i = paramTransitionValues2.left;
    int j = paramTransitionValues2.top;
    float f3 = paramView.getTranslationX();
    float f4 = paramView.getTranslationY();
    int[] arrayOfInt = (int[])paramTransitionValues1.view.getTag(R.id.transition_position);
    float f1;
    float f2;
    if (arrayOfInt != null)
    {
      f1 = arrayOfInt[0] - paramTransitionValues2.left + f3;
      f2 = arrayOfInt[1] - paramTransitionValues2.top + f4;
      paramTransitionValues2.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    }
    else
    {
      f1 = f3;
      f2 = f4;
    }
    calculateOut(paramViewGroup, paramTransitionValues2, this.mTempLoc);
    paramViewGroup = this.mTempLoc;
    return TranslationAnimationCreator.createAnimation(paramView, paramTransitionValues1, i, j, f3, f4, f1 + paramViewGroup[0], f2 + paramViewGroup[1], sAccelerate, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.Explode
 * JD-Core Version:    0.7.0.1
 */