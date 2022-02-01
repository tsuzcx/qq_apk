package androidx.transition;

import android.view.View;
import java.util.Map;

public abstract class VisibilityPropagation
  extends TransitionPropagation
{
  private static final String PROPNAME_VIEW_CENTER = "android:visibilityPropagation:center";
  private static final String PROPNAME_VISIBILITY = "android:visibilityPropagation:visibility";
  private static final String[] VISIBILITY_PROPAGATION_VALUES = { "android:visibilityPropagation:visibility", "android:visibilityPropagation:center" };
  
  private static int getViewCoordinate(TransitionValues paramTransitionValues, int paramInt)
  {
    if (paramTransitionValues == null) {
      return -1;
    }
    paramTransitionValues = (int[])paramTransitionValues.values.get("android:visibilityPropagation:center");
    if (paramTransitionValues == null) {
      return -1;
    }
    return paramTransitionValues[paramInt];
  }
  
  public void captureValues(TransitionValues paramTransitionValues)
  {
    View localView = paramTransitionValues.view;
    Integer localInteger = (Integer)paramTransitionValues.values.get("android:visibility:visibility");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(localView.getVisibility());
    }
    paramTransitionValues.values.put("android:visibilityPropagation:visibility", localObject);
    localObject = new int[2];
    localView.getLocationOnScreen((int[])localObject);
    localObject[0] += Math.round(localView.getTranslationX());
    localObject[0] += localView.getWidth() / 2;
    localObject[1] += Math.round(localView.getTranslationY());
    localObject[1] += localView.getHeight() / 2;
    paramTransitionValues.values.put("android:visibilityPropagation:center", localObject);
  }
  
  public String[] getPropagationProperties()
  {
    return VISIBILITY_PROPAGATION_VALUES;
  }
  
  public int getViewVisibility(TransitionValues paramTransitionValues)
  {
    if (paramTransitionValues == null) {
      return 8;
    }
    paramTransitionValues = (Integer)paramTransitionValues.values.get("android:visibilityPropagation:visibility");
    if (paramTransitionValues == null) {
      return 8;
    }
    return paramTransitionValues.intValue();
  }
  
  public int getViewX(TransitionValues paramTransitionValues)
  {
    return getViewCoordinate(paramTransitionValues, 0);
  }
  
  public int getViewY(TransitionValues paramTransitionValues)
  {
    return getViewCoordinate(paramTransitionValues, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.VisibilityPropagation
 * JD-Core Version:    0.7.0.1
 */