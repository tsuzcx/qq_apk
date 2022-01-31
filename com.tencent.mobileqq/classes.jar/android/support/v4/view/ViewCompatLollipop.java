package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

class ViewCompatLollipop
{
  public static WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    Object localObject = paramWindowInsetsCompat;
    if ((paramWindowInsetsCompat instanceof WindowInsetsCompatApi21))
    {
      WindowInsets localWindowInsets = ((WindowInsetsCompatApi21)paramWindowInsetsCompat).unwrap();
      paramView = paramView.dispatchApplyWindowInsets(localWindowInsets);
      localObject = paramWindowInsetsCompat;
      if (paramView != localWindowInsets) {
        localObject = new WindowInsetsCompatApi21(paramView);
      }
    }
    return localObject;
  }
  
  public static boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return paramView.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public static boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return paramView.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public static boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return paramView.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return paramView.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  static ColorStateList getBackgroundTintList(View paramView)
  {
    return paramView.getBackgroundTintList();
  }
  
  static PorterDuff.Mode getBackgroundTintMode(View paramView)
  {
    return paramView.getBackgroundTintMode();
  }
  
  public static float getElevation(View paramView)
  {
    return paramView.getElevation();
  }
  
  public static String getTransitionName(View paramView)
  {
    return paramView.getTransitionName();
  }
  
  public static float getTranslationZ(View paramView)
  {
    return paramView.getTranslationZ();
  }
  
  public static float getZ(View paramView)
  {
    return paramView.getZ();
  }
  
  public static boolean hasNestedScrollingParent(View paramView)
  {
    return paramView.hasNestedScrollingParent();
  }
  
  public static boolean isImportantForAccessibility(View paramView)
  {
    return paramView.isImportantForAccessibility();
  }
  
  public static boolean isNestedScrollingEnabled(View paramView)
  {
    return paramView.isNestedScrollingEnabled();
  }
  
  public static WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    Object localObject = paramWindowInsetsCompat;
    if ((paramWindowInsetsCompat instanceof WindowInsetsCompatApi21))
    {
      WindowInsets localWindowInsets = ((WindowInsetsCompatApi21)paramWindowInsetsCompat).unwrap();
      paramView = paramView.onApplyWindowInsets(localWindowInsets);
      localObject = paramWindowInsetsCompat;
      if (paramView != localWindowInsets) {
        localObject = new WindowInsetsCompatApi21(paramView);
      }
    }
    return localObject;
  }
  
  public static void requestApplyInsets(View paramView)
  {
    paramView.requestApplyInsets();
  }
  
  static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
  {
    paramView.setBackgroundTintList(paramColorStateList);
  }
  
  static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
  {
    paramView.setBackgroundTintMode(paramMode);
  }
  
  public static void setElevation(View paramView, float paramFloat)
  {
    paramView.setElevation(paramFloat);
  }
  
  public static void setNestedScrollingEnabled(View paramView, boolean paramBoolean)
  {
    paramView.setNestedScrollingEnabled(paramBoolean);
  }
  
  public static void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    if (paramOnApplyWindowInsetsListener == null)
    {
      paramView.setOnApplyWindowInsetsListener(null);
      return;
    }
    paramView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
    {
      public WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
      {
        paramAnonymousWindowInsets = new WindowInsetsCompatApi21(paramAnonymousWindowInsets);
        return ((WindowInsetsCompatApi21)this.val$listener.onApplyWindowInsets(paramAnonymousView, paramAnonymousWindowInsets)).unwrap();
      }
    });
  }
  
  public static void setTransitionName(View paramView, String paramString)
  {
    paramView.setTransitionName(paramString);
  }
  
  public static void setTranslationZ(View paramView, float paramFloat)
  {
    paramView.setTranslationZ(paramFloat);
  }
  
  public static boolean startNestedScroll(View paramView, int paramInt)
  {
    return paramView.startNestedScroll(paramInt);
  }
  
  public static void stopNestedScroll(View paramView)
  {
    paramView.stopNestedScroll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompatLollipop
 * JD-Core Version:    0.7.0.1
 */