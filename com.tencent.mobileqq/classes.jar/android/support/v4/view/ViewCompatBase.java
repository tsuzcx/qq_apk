package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

class ViewCompatBase
{
  private static final String TAG = "ViewCompatBase";
  private static Field sMinHeightField;
  private static boolean sMinHeightFieldFetched;
  private static Field sMinWidthField;
  private static boolean sMinWidthFieldFetched;
  
  static ColorStateList getBackgroundTintList(View paramView)
  {
    if ((paramView instanceof TintableBackgroundView)) {
      return ((TintableBackgroundView)paramView).getSupportBackgroundTintList();
    }
    return null;
  }
  
  static PorterDuff.Mode getBackgroundTintMode(View paramView)
  {
    if ((paramView instanceof TintableBackgroundView)) {
      return ((TintableBackgroundView)paramView).getSupportBackgroundTintMode();
    }
    return null;
  }
  
  static int getMinimumHeight(View paramView)
  {
    if (!sMinHeightFieldFetched) {}
    try
    {
      sMinHeightField = View.class.getDeclaredField("mMinHeight");
      sMinHeightField.setAccessible(true);
      label23:
      sMinHeightFieldFetched = true;
      Field localField = sMinHeightField;
      if (localField != null) {}
      try
      {
        int i = ((Integer)localField.get(paramView)).intValue();
        return i;
      }
      catch (Exception paramView)
      {
        label49:
        break label49;
      }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
  
  static int getMinimumWidth(View paramView)
  {
    if (!sMinWidthFieldFetched) {}
    try
    {
      sMinWidthField = View.class.getDeclaredField("mMinWidth");
      sMinWidthField.setAccessible(true);
      label23:
      sMinWidthFieldFetched = true;
      Field localField = sMinWidthField;
      if (localField != null) {}
      try
      {
        int i = ((Integer)localField.get(paramView)).intValue();
        return i;
      }
      catch (Exception paramView)
      {
        label49:
        break label49;
      }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
  
  static boolean isAttachedToWindow(View paramView)
  {
    return paramView.getWindowToken() != null;
  }
  
  static boolean isLaidOut(View paramView)
  {
    return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
  }
  
  static void offsetLeftAndRight(View paramView, int paramInt)
  {
    int i = paramView.getLeft();
    paramView.offsetLeftAndRight(paramInt);
    if (paramInt != 0)
    {
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View))
      {
        paramInt = Math.abs(paramInt);
        ((View)localViewParent).invalidate(i - paramInt, paramView.getTop(), i + paramView.getWidth() + paramInt, paramView.getBottom());
        return;
      }
      paramView.invalidate();
    }
  }
  
  static void offsetTopAndBottom(View paramView, int paramInt)
  {
    int i = paramView.getTop();
    paramView.offsetTopAndBottom(paramInt);
    if (paramInt != 0)
    {
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View))
      {
        paramInt = Math.abs(paramInt);
        ((View)localViewParent).invalidate(paramView.getLeft(), i - paramInt, paramView.getRight(), i + paramView.getHeight() + paramInt);
        return;
      }
      paramView.invalidate();
    }
  }
  
  static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
  {
    if ((paramView instanceof TintableBackgroundView)) {
      ((TintableBackgroundView)paramView).setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
  {
    if ((paramView instanceof TintableBackgroundView)) {
      ((TintableBackgroundView)paramView).setSupportBackgroundTintMode(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompatBase
 * JD-Core Version:    0.7.0.1
 */