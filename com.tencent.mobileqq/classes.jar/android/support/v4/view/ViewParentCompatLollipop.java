package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

class ViewParentCompatLollipop
{
  private static final String TAG = "ViewParentCompat";
  
  public static boolean onNestedFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    try
    {
      paramBoolean = paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      return paramBoolean;
    }
    catch (AbstractMethodError paramView)
    {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface method onNestedFling", paramView);
    }
    return false;
  }
  
  public static boolean onNestedPreFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
  {
    try
    {
      boolean bool = paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
      return bool;
    }
    catch (AbstractMethodError paramView)
    {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface method onNestedPreFling", paramView);
    }
    return false;
  }
  
  public static void onNestedPreScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    try
    {
      paramViewParent.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
      return;
    }
    catch (AbstractMethodError paramView)
    {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface method onNestedPreScroll", paramView);
    }
  }
  
  public static void onNestedScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      paramViewParent.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (AbstractMethodError paramView)
    {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface method onNestedScroll", paramView);
    }
  }
  
  public static void onNestedScrollAccepted(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
  {
    try
    {
      paramViewParent.onNestedScrollAccepted(paramView1, paramView2, paramInt);
      return;
    }
    catch (AbstractMethodError paramView1)
    {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface method onNestedScrollAccepted", paramView1);
    }
  }
  
  public static boolean onStartNestedScroll(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
  {
    try
    {
      boolean bool = paramViewParent.onStartNestedScroll(paramView1, paramView2, paramInt);
      return bool;
    }
    catch (AbstractMethodError paramView1)
    {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface method onStartNestedScroll", paramView1);
    }
    return false;
  }
  
  public static void onStopNestedScroll(ViewParent paramViewParent, View paramView)
  {
    try
    {
      paramViewParent.onStopNestedScroll(paramView);
      return;
    }
    catch (AbstractMethodError paramView)
    {
      Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface method onStopNestedScroll", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewParentCompatLollipop
 * JD-Core Version:    0.7.0.1
 */