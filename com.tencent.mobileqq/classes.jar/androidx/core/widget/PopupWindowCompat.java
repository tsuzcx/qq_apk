package androidx.core.widget;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat
{
  private static final String TAG = "PopupWindowCompatApi21";
  private static Method sGetWindowLayoutTypeMethod;
  private static boolean sGetWindowLayoutTypeMethodAttempted;
  private static Field sOverlapAnchorField;
  private static boolean sOverlapAnchorFieldAttempted;
  private static Method sSetWindowLayoutTypeMethod;
  private static boolean sSetWindowLayoutTypeMethodAttempted;
  
  public static boolean getOverlapAnchor(@NonNull PopupWindow paramPopupWindow)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramPopupWindow.getOverlapAnchor();
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (!sOverlapAnchorFieldAttempted)
      {
        try
        {
          sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
          sOverlapAnchorField.setAccessible(true);
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", localNoSuchFieldException);
        }
        sOverlapAnchorFieldAttempted = true;
      }
      Field localField = sOverlapAnchorField;
      if (localField != null) {
        try
        {
          boolean bool = ((Boolean)localField.get(paramPopupWindow)).booleanValue();
          return bool;
        }
        catch (IllegalAccessException paramPopupWindow)
        {
          Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", paramPopupWindow);
        }
      }
    }
    return false;
  }
  
  public static int getWindowLayoutType(@NonNull PopupWindow paramPopupWindow)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramPopupWindow.getWindowLayoutType();
    }
    if (!sGetWindowLayoutTypeMethodAttempted) {}
    try
    {
      sGetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
      sGetWindowLayoutTypeMethod.setAccessible(true);
      label40:
      sGetWindowLayoutTypeMethodAttempted = true;
      Method localMethod = sGetWindowLayoutTypeMethod;
      if (localMethod != null) {}
      try
      {
        int i = ((Integer)localMethod.invoke(paramPopupWindow, new Object[0])).intValue();
        return i;
      }
      catch (Exception paramPopupWindow) {}
      return 0;
    }
    catch (Exception localException)
    {
      break label40;
    }
    return 0;
  }
  
  public static void setOverlapAnchor(@NonNull PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (!sOverlapAnchorFieldAttempted)
      {
        try
        {
          sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
          sOverlapAnchorField.setAccessible(true);
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", localNoSuchFieldException);
        }
        sOverlapAnchorFieldAttempted = true;
      }
      Field localField = sOverlapAnchorField;
      if (localField != null) {
        try
        {
          localField.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
          return;
        }
        catch (IllegalAccessException paramPopupWindow)
        {
          Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", paramPopupWindow);
        }
      }
    }
  }
  
  public static void setWindowLayoutType(@NonNull PopupWindow paramPopupWindow, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramPopupWindow.setWindowLayoutType(paramInt);
      return;
    }
    if (!sSetWindowLayoutTypeMethodAttempted) {}
    try
    {
      sSetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
      sSetWindowLayoutTypeMethod.setAccessible(true);
      sSetWindowLayoutTypeMethodAttempted = true;
      localMethod = sSetWindowLayoutTypeMethod;
      if (localMethod == null) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          Method localMethod;
          localMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow) {}
        localException = localException;
      }
    }
  }
  
  public static void showAsDropDown(@NonNull PopupWindow paramPopupWindow, @NonNull View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
      return;
    }
    int i = paramInt1;
    if ((GravityCompat.getAbsoluteGravity(paramInt3, ViewCompat.getLayoutDirection(paramView)) & 0x7) == 5) {
      i = paramInt1 - (paramPopupWindow.getWidth() - paramView.getWidth());
    }
    paramPopupWindow.showAsDropDown(paramView, i, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.widget.PopupWindowCompat
 * JD-Core Version:    0.7.0.1
 */