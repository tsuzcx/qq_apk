package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.Map;

public class ChangeClipBounds
  extends Transition
{
  private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
  private static final String PROPNAME_CLIP = "android:clipBounds:clip";
  private static final String[] sTransitionProperties = { "android:clipBounds:clip" };
  
  public ChangeClipBounds() {}
  
  public ChangeClipBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    Object localObject = paramTransitionValues.view;
    if (((View)localObject).getVisibility() == 8) {
      return;
    }
    Rect localRect = ViewCompat.getClipBounds((View)localObject);
    paramTransitionValues.values.put("android:clipBounds:clip", localRect);
    if (localRect == null)
    {
      localObject = new Rect(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
      paramTransitionValues.values.put("android:clipBounds:bounds", localObject);
    }
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    Object localObject = null;
    paramViewGroup = (ViewGroup)localObject;
    if (paramTransitionValues1 != null)
    {
      paramViewGroup = (ViewGroup)localObject;
      if (paramTransitionValues2 != null)
      {
        paramViewGroup = (ViewGroup)localObject;
        if (paramTransitionValues1.values.containsKey("android:clipBounds:clip"))
        {
          if (!paramTransitionValues2.values.containsKey("android:clipBounds:clip")) {
            return null;
          }
          localObject = (Rect)paramTransitionValues1.values.get("android:clipBounds:clip");
          Rect localRect = (Rect)paramTransitionValues2.values.get("android:clipBounds:clip");
          int i;
          if (localRect == null) {
            i = 1;
          } else {
            i = 0;
          }
          if ((localObject == null) && (localRect == null)) {
            return null;
          }
          if (localObject == null)
          {
            paramViewGroup = (Rect)paramTransitionValues1.values.get("android:clipBounds:bounds");
            paramTransitionValues1 = localRect;
          }
          else
          {
            paramViewGroup = (ViewGroup)localObject;
            paramTransitionValues1 = localRect;
            if (localRect == null)
            {
              paramTransitionValues1 = (Rect)paramTransitionValues2.values.get("android:clipBounds:bounds");
              paramViewGroup = (ViewGroup)localObject;
            }
          }
          if (paramViewGroup.equals(paramTransitionValues1)) {
            return null;
          }
          ViewCompat.setClipBounds(paramTransitionValues2.view, paramViewGroup);
          localObject = new RectEvaluator(new Rect());
          paramTransitionValues1 = ObjectAnimator.ofObject(paramTransitionValues2.view, ViewUtils.CLIP_BOUNDS, (TypeEvaluator)localObject, new Rect[] { paramViewGroup, paramTransitionValues1 });
          paramViewGroup = paramTransitionValues1;
          if (i != 0)
          {
            paramTransitionValues1.addListener(new ChangeClipBounds.1(this, paramTransitionValues2.view));
            paramViewGroup = paramTransitionValues1;
          }
        }
      }
    }
    return paramViewGroup;
  }
  
  public String[] getTransitionProperties()
  {
    return sTransitionProperties;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ChangeClipBounds
 * JD-Core Version:    0.7.0.1
 */