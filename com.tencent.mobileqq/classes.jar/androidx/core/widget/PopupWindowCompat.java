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
      if (!sOverlapAnchorFieldAttempted) {}
      try
      {
        sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
        sOverlapAnchorField.setAccessible(true);
        sOverlapAnchorFieldAttempted = true;
        if (sOverlapAnchorField == null) {}
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          try
          {
            boolean bool = ((Boolean)sOverlapAnchorField.get(paramPopupWindow)).booleanValue();
            return bool;
          }
          catch (IllegalAccessException paramPopupWindow)
          {
            Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", paramPopupWindow);
          }
          localNoSuchFieldException = localNoSuchFieldException;
          Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", localNoSuchFieldException);
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
      if (sGetWindowLayoutTypeMethod != null) {
        try
        {
          int i = ((Integer)sGetWindowLayoutTypeMethod.invoke(paramPopupWindow, new Object[0])).intValue();
          return i;
        }
        catch (Exception paramPopupWindow) {}
      }
      return 0;
    }
    catch (Exception localException)
    {
      break label40;
    }
  }
  
  public static void setOverlapAnchor(@NonNull PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT < 21) {
        continue;
      }
      if (!sOverlapAnchorFieldAttempted) {}
      try
      {
        sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
        sOverlapAnchorField.setAccessible(true);
        sOverlapAnchorFieldAttempted = true;
        if (sOverlapAnchorField == null) {
          continue;
        }
        try
        {
          sOverlapAnchorField.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
          return;
        }
        catch (IllegalAccessException paramPopupWindow)
        {
          Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", paramPopupWindow);
          return;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", localNoSuchFieldException);
        }
      }
    }
  }
  
  public static void setWindowLayoutType(@NonNull PopupWindow paramPopupWindow, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramPopupWindow.setWindowLayoutType(paramInt);
    }
    for (;;)
    {
      return;
      if (!sSetWindowLayoutTypeMethodAttempted) {}
      try
      {
        sSetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
        sSetWindowLayoutTypeMethod.setAccessible(true);
        label47:
        sSetWindowLayoutTypeMethodAttempted = true;
        if (sSetWindowLayoutTypeMethod == null) {
          continue;
        }
        try
        {
          sSetWindowLayoutTypeMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow) {}
      }
      catch (Exception localException)
      {
        break label47;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.widget.PopupWindowCompat
 * JD-Core Version:    0.7.0.1
 */