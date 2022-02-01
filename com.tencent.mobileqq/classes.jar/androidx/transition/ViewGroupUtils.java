package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtils
{
  private static Method sGetChildDrawingOrderMethod;
  private static boolean sGetChildDrawingOrderMethodFetched = false;
  private static boolean sTryHiddenSuppressLayout = true;
  
  static int getChildDrawingOrder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return paramViewGroup.getChildDrawingOrder(paramInt);
    }
    if (!sGetChildDrawingOrderMethodFetched) {}
    try
    {
      sGetChildDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", new Class[] { Integer.TYPE, Integer.TYPE });
      sGetChildDrawingOrderMethod.setAccessible(true);
      label53:
      sGetChildDrawingOrderMethodFetched = true;
      Method localMethod = sGetChildDrawingOrderMethod;
      if (localMethod != null) {}
      try
      {
        int i = ((Integer)localMethod.invoke(paramViewGroup, new Object[] { Integer.valueOf(paramViewGroup.getChildCount()), Integer.valueOf(paramInt) })).intValue();
        return i;
      }
      catch (IllegalAccessException|InvocationTargetException paramViewGroup) {}
      return paramInt;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label53;
    }
    return paramInt;
  }
  
  static ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new ViewGroupOverlayApi18(paramViewGroup);
    }
    return ViewGroupOverlayApi14.createFrom(paramViewGroup);
  }
  
  @SuppressLint({"NewApi"})
  @RequiresApi(18)
  private static void hiddenSuppressLayout(@NonNull ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (sTryHiddenSuppressLayout) {}
    try
    {
      paramViewGroup.suppressLayout(paramBoolean);
      return;
    }
    catch (NoSuchMethodError paramViewGroup)
    {
      label12:
      break label12;
    }
    sTryHiddenSuppressLayout = false;
  }
  
  static void suppressLayout(@NonNull ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramViewGroup.suppressLayout(paramBoolean);
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      hiddenSuppressLayout(paramViewGroup, paramBoolean);
      return;
    }
    ViewGroupUtilsApi14.suppressLayout(paramViewGroup, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ViewGroupUtils
 * JD-Core Version:    0.7.0.1
 */