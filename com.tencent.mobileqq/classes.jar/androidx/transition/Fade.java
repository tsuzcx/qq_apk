package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import java.util.Map;

public class Fade
  extends Visibility
{
  public static final int IN = 1;
  private static final String LOG_TAG = "Fade";
  public static final int OUT = 2;
  private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";
  
  public Fade() {}
  
  public Fade(int paramInt)
  {
    setMode(paramInt);
  }
  
  @SuppressLint({"RestrictedApi"})
  public Fade(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.FADE);
    setMode(TypedArrayUtils.getNamedInt(paramContext, (XmlResourceParser)paramAttributeSet, "fadingMode", 0, getMode()));
    paramContext.recycle();
  }
  
  private Animator createAnimation(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return null;
    }
    ViewUtils.setTransitionAlpha(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, ViewUtils.TRANSITION_ALPHA, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new Fade.FadeAnimatorListener(paramView));
    addListener(new Fade.1(this, paramView));
    return localObjectAnimator;
  }
  
  private static float getStartAlpha(TransitionValues paramTransitionValues, float paramFloat)
  {
    float f = paramFloat;
    if (paramTransitionValues != null)
    {
      paramTransitionValues = (Float)paramTransitionValues.values.get("android:fade:transitionAlpha");
      f = paramFloat;
      if (paramTransitionValues != null) {
        f = paramTransitionValues.floatValue();
      }
    }
    return f;
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    super.captureStartValues(paramTransitionValues);
    paramTransitionValues.values.put("android:fade:transitionAlpha", Float.valueOf(ViewUtils.getTransitionAlpha(paramTransitionValues.view)));
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    float f1 = 0.0F;
    float f2 = getStartAlpha(paramTransitionValues1, 0.0F);
    if (f2 != 1.0F) {
      f1 = f2;
    }
    return createAnimation(paramView, f1, 1.0F);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    ViewUtils.saveNonTransitionAlpha(paramView);
    return createAnimation(paramView, getStartAlpha(paramTransitionValues1, 1.0F), 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.Fade
 * JD-Core Version:    0.7.0.1
 */