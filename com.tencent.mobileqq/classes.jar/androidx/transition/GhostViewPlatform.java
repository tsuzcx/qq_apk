package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
class GhostViewPlatform
  implements GhostView
{
  private static final String TAG = "GhostViewApi21";
  private static Method sAddGhostMethod;
  private static boolean sAddGhostMethodFetched;
  private static Class<?> sGhostViewClass;
  private static boolean sGhostViewClassFetched;
  private static Method sRemoveGhostMethod;
  private static boolean sRemoveGhostMethodFetched;
  private final View mGhostView;
  
  private GhostViewPlatform(@NonNull View paramView)
  {
    this.mGhostView = paramView;
  }
  
  static GhostView addGhost(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    fetchAddGhostMethod();
    Method localMethod = sAddGhostMethod;
    if (localMethod != null) {}
    try
    {
      paramView = new GhostViewPlatform((View)localMethod.invoke(null, new Object[] { paramView, paramViewGroup, paramMatrix }));
      return paramView;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
      return null;
    }
    catch (IllegalAccessException paramView) {}
    return null;
  }
  
  private static void fetchAddGhostMethod()
  {
    if (!sAddGhostMethodFetched)
    {
      try
      {
        fetchGhostViewClass();
        sAddGhostMethod = sGhostViewClass.getDeclaredMethod("addGhost", new Class[] { View.class, ViewGroup.class, Matrix.class });
        sAddGhostMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("GhostViewApi21", "Failed to retrieve addGhost method", localNoSuchMethodException);
      }
      sAddGhostMethodFetched = true;
    }
  }
  
  private static void fetchGhostViewClass()
  {
    if (!sGhostViewClassFetched)
    {
      try
      {
        sGhostViewClass = Class.forName("android.view.GhostView");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.i("GhostViewApi21", "Failed to retrieve GhostView class", localClassNotFoundException);
      }
      sGhostViewClassFetched = true;
    }
  }
  
  private static void fetchRemoveGhostMethod()
  {
    if (!sRemoveGhostMethodFetched)
    {
      try
      {
        fetchGhostViewClass();
        sRemoveGhostMethod = sGhostViewClass.getDeclaredMethod("removeGhost", new Class[] { View.class });
        sRemoveGhostMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", localNoSuchMethodException);
      }
      sRemoveGhostMethodFetched = true;
    }
  }
  
  static void removeGhost(View paramView)
  {
    fetchRemoveGhostMethod();
    Method localMethod = sRemoveGhostMethod;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(null, new Object[] { paramView });
      return;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
      return;
    }
    catch (IllegalAccessException paramView) {}
  }
  
  public void reserveEndViewTransition(ViewGroup paramViewGroup, View paramView) {}
  
  public void setVisibility(int paramInt)
  {
    this.mGhostView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.GhostViewPlatform
 * JD-Core Version:    0.7.0.1
 */