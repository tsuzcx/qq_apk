package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtilsApi14
{
  private static final int LAYOUT_TRANSITION_CHANGING = 4;
  private static final String TAG = "ViewGroupUtilsApi14";
  private static Method sCancelMethod;
  private static boolean sCancelMethodFetched;
  private static LayoutTransition sEmptyLayoutTransition;
  private static Field sLayoutSuppressedField;
  private static boolean sLayoutSuppressedFieldFetched;
  
  private static void cancelLayoutTransition(LayoutTransition paramLayoutTransition)
  {
    if (!sCancelMethodFetched) {}
    try
    {
      sCancelMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
      sCancelMethod.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label30:
      Method localMethod;
      break label30;
    }
    Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
    sCancelMethodFetched = true;
    localMethod = sCancelMethod;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramLayoutTransition, new Object[0]);
      return;
    }
    catch (IllegalAccessException paramLayoutTransition)
    {
      break label70;
    }
    catch (InvocationTargetException paramLayoutTransition)
    {
      label61:
      break label61;
    }
    Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
    return;
    label70:
    Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
  }
  
  static void suppressLayout(@NonNull ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Object localObject = sEmptyLayoutTransition;
    boolean bool2 = false;
    bool1 = false;
    if (localObject == null)
    {
      sEmptyLayoutTransition = new ViewGroupUtilsApi14.1();
      sEmptyLayoutTransition.setAnimator(2, null);
      sEmptyLayoutTransition.setAnimator(0, null);
      sEmptyLayoutTransition.setAnimator(1, null);
      sEmptyLayoutTransition.setAnimator(3, null);
      sEmptyLayoutTransition.setAnimator(4, null);
    }
    if (paramBoolean)
    {
      localObject = paramViewGroup.getLayoutTransition();
      if (localObject != null)
      {
        if (((LayoutTransition)localObject).isRunning()) {
          cancelLayoutTransition((LayoutTransition)localObject);
        }
        if (localObject != sEmptyLayoutTransition) {
          paramViewGroup.setTag(R.id.transition_layout_save, localObject);
        }
      }
      paramViewGroup.setLayoutTransition(sEmptyLayoutTransition);
      return;
    }
    paramViewGroup.setLayoutTransition(null);
    if (!sLayoutSuppressedFieldFetched) {}
    try
    {
      sLayoutSuppressedField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
      sLayoutSuppressedField.setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      label148:
      break label148;
    }
    Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
    sLayoutSuppressedFieldFetched = true;
    localObject = sLayoutSuppressedField;
    paramBoolean = bool2;
    if (localObject != null) {}
    try
    {
      paramBoolean = ((Field)localObject).getBoolean(paramViewGroup);
      if (!paramBoolean) {}
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      for (;;)
      {
        label194:
        paramBoolean = bool1;
      }
    }
    try
    {
      sLayoutSuppressedField.setBoolean(paramViewGroup, false);
    }
    catch (IllegalAccessException localIllegalAccessException2)
    {
      break label194;
    }
    break label200;
    break label208;
    label200:
    Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
    label208:
    if (paramBoolean) {
      paramViewGroup.requestLayout();
    }
    localObject = (LayoutTransition)paramViewGroup.getTag(R.id.transition_layout_save);
    if (localObject != null)
    {
      paramViewGroup.setTag(R.id.transition_layout_save, null);
      paramViewGroup.setLayoutTransition((LayoutTransition)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ViewGroupUtilsApi14
 * JD-Core Version:    0.7.0.1
 */