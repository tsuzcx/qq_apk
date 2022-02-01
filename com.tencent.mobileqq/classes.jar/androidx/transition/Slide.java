package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class Slide
  extends Visibility
{
  private static final String PROPNAME_SCREEN_POSITION = "android:slide:screenPosition";
  private static final TimeInterpolator sAccelerate;
  private static final Slide.CalculateSlide sCalculateBottom = new Slide.6();
  private static final Slide.CalculateSlide sCalculateEnd;
  private static final Slide.CalculateSlide sCalculateLeft;
  private static final Slide.CalculateSlide sCalculateRight;
  private static final Slide.CalculateSlide sCalculateStart;
  private static final Slide.CalculateSlide sCalculateTop;
  private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
  private Slide.CalculateSlide mSlideCalculator = sCalculateBottom;
  private int mSlideEdge = 80;
  
  static
  {
    sAccelerate = new AccelerateInterpolator();
    sCalculateLeft = new Slide.1();
    sCalculateStart = new Slide.2();
    sCalculateTop = new Slide.3();
    sCalculateRight = new Slide.4();
    sCalculateEnd = new Slide.5();
  }
  
  public Slide()
  {
    setSlideEdge(80);
  }
  
  public Slide(int paramInt)
  {
    setSlideEdge(paramInt);
  }
  
  @SuppressLint({"RestrictedApi"})
  public Slide(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.SLIDE);
    int i = TypedArrayUtils.getNamedInt(paramContext, (XmlPullParser)paramAttributeSet, "slideEdge", 0, 80);
    paramContext.recycle();
    setSlideEdge(i);
  }
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    View localView = paramTransitionValues.view;
    int[] arrayOfInt = new int[2];
    localView.getLocationOnScreen(arrayOfInt);
    paramTransitionValues.values.put("android:slide:screenPosition", arrayOfInt);
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
  
  public int getSlideEdge()
  {
    return this.mSlideEdge;
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if (paramTransitionValues2 == null) {
      return null;
    }
    paramTransitionValues1 = (int[])paramTransitionValues2.values.get("android:slide:screenPosition");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    float f3 = this.mSlideCalculator.getGoneX(paramViewGroup, paramView);
    float f4 = this.mSlideCalculator.getGoneY(paramViewGroup, paramView);
    return TranslationAnimationCreator.createAnimation(paramView, paramTransitionValues2, paramTransitionValues1[0], paramTransitionValues1[1], f3, f4, f1, f2, sDecelerate, this);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if (paramTransitionValues1 == null) {
      return null;
    }
    paramTransitionValues2 = (int[])paramTransitionValues1.values.get("android:slide:screenPosition");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    float f3 = this.mSlideCalculator.getGoneX(paramViewGroup, paramView);
    float f4 = this.mSlideCalculator.getGoneY(paramViewGroup, paramView);
    return TranslationAnimationCreator.createAnimation(paramView, paramTransitionValues1, paramTransitionValues2[0], paramTransitionValues2[1], f1, f2, f3, f4, sAccelerate, this);
  }
  
  public void setSlideEdge(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 48)
        {
          if (paramInt != 80)
          {
            if (paramInt != 8388611)
            {
              if (paramInt == 8388613) {
                this.mSlideCalculator = sCalculateEnd;
              } else {
                throw new IllegalArgumentException("Invalid slide direction");
              }
            }
            else {
              this.mSlideCalculator = sCalculateStart;
            }
          }
          else {
            this.mSlideCalculator = sCalculateBottom;
          }
        }
        else {
          this.mSlideCalculator = sCalculateTop;
        }
      }
      else {
        this.mSlideCalculator = sCalculateRight;
      }
    }
    else {
      this.mSlideCalculator = sCalculateLeft;
    }
    this.mSlideEdge = paramInt;
    SidePropagation localSidePropagation = new SidePropagation();
    localSidePropagation.setSide(paramInt);
    setPropagation(localSidePropagation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.Slide
 * JD-Core Version:    0.7.0.1
 */