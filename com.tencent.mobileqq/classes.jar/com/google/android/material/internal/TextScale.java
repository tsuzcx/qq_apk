package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TextScale
  extends Transition
{
  private void a(@NonNull TransitionValues paramTransitionValues)
  {
    if ((paramTransitionValues.view instanceof TextView))
    {
      TextView localTextView = (TextView)paramTransitionValues.view;
      paramTransitionValues.values.put("android:textscale:scale", Float.valueOf(localTextView.getScaleX()));
    }
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    a(paramTransitionValues);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    a(paramTransitionValues);
  }
  
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, @Nullable TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    TextView localTextView = null;
    paramViewGroup = localTextView;
    if (paramTransitionValues1 != null)
    {
      paramViewGroup = localTextView;
      if (paramTransitionValues2 != null)
      {
        paramViewGroup = localTextView;
        if ((paramTransitionValues1.view instanceof TextView))
        {
          if (!(paramTransitionValues2.view instanceof TextView)) {
            return null;
          }
          localTextView = (TextView)paramTransitionValues2.view;
          paramViewGroup = paramTransitionValues1.values;
          paramTransitionValues1 = paramTransitionValues2.values;
          paramTransitionValues2 = paramViewGroup.get("android:textscale:scale");
          float f2 = 1.0F;
          float f1;
          if (paramTransitionValues2 != null) {
            f1 = ((Float)paramViewGroup.get("android:textscale:scale")).floatValue();
          } else {
            f1 = 1.0F;
          }
          if (paramTransitionValues1.get("android:textscale:scale") != null) {
            f2 = ((Float)paramTransitionValues1.get("android:textscale:scale")).floatValue();
          }
          if (f1 == f2) {
            return null;
          }
          paramViewGroup = ValueAnimator.ofFloat(new float[] { f1, f2 });
          paramViewGroup.addUpdateListener(new TextScale.1(this, localTextView));
        }
      }
    }
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.TextScale
 * JD-Core Version:    0.7.0.1
 */