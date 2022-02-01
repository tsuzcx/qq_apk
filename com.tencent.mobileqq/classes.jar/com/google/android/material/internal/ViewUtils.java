package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.styleable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ViewUtils
{
  public static float a(@NonNull Context paramContext, @Dimension(unit=0) int paramInt)
  {
    paramContext = paramContext.getResources();
    return TypedValue.applyDimension(1, paramInt, paramContext.getDisplayMetrics());
  }
  
  public static float a(@NonNull View paramView)
  {
    paramView = paramView.getParent();
    float f = 0.0F;
    while ((paramView instanceof View))
    {
      f += ViewCompat.getElevation((View)paramView);
      paramView = paramView.getParent();
    }
    return f;
  }
  
  public static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          switch (paramInt)
          {
          default: 
            return paramMode;
          case 16: 
            return PorterDuff.Mode.ADD;
          case 15: 
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
  
  @Nullable
  public static ViewGroup a(@Nullable View paramView)
  {
    if (paramView == null) {
      return null;
    }
    View localView = paramView.getRootView();
    ViewGroup localViewGroup = (ViewGroup)localView.findViewById(16908290);
    if (localViewGroup != null) {
      return localViewGroup;
    }
    if ((localView != paramView) && ((localView instanceof ViewGroup))) {
      return (ViewGroup)localView;
    }
    return null;
  }
  
  @Nullable
  public static ViewOverlayImpl a(@Nullable View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 18) {
      return new ViewOverlayApi18(paramView);
    }
    return ViewOverlayApi14.a(paramView);
  }
  
  public static void a(@NonNull View paramView)
  {
    paramView.requestFocus();
    paramView.post(new ViewUtils.1(paramView));
  }
  
  public static void a(@NonNull View paramView, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2, @Nullable ViewUtils.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    paramAttributeSet = paramView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.E, paramInt1, paramInt2);
    boolean bool1 = paramAttributeSet.getBoolean(R.styleable.cb, false);
    boolean bool2 = paramAttributeSet.getBoolean(R.styleable.cc, false);
    boolean bool3 = paramAttributeSet.getBoolean(R.styleable.cd, false);
    paramAttributeSet.recycle();
    a(paramView, new ViewUtils.2(bool1, bool2, bool3, paramOnApplyWindowInsetsListener));
  }
  
  public static void a(@NonNull View paramView, @NonNull ViewUtils.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    ViewCompat.setOnApplyWindowInsetsListener(paramView, new ViewUtils.3(paramOnApplyWindowInsetsListener, new ViewUtils.RelativePadding(ViewCompat.getPaddingStart(paramView), paramView.getPaddingTop(), ViewCompat.getPaddingEnd(paramView), paramView.getPaddingBottom())));
    b(paramView);
  }
  
  public static boolean a(View paramView)
  {
    return ViewCompat.getLayoutDirection(paramView) == 1;
  }
  
  @Nullable
  public static ViewOverlayImpl b(@NonNull View paramView)
  {
    return a(a(paramView));
  }
  
  public static void b(@NonNull View paramView)
  {
    if (ViewCompat.isAttachedToWindow(paramView))
    {
      ViewCompat.requestApplyInsets(paramView);
      return;
    }
    paramView.addOnAttachStateChangeListener(new ViewUtils.4());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.ViewUtils
 * JD-Core Version:    0.7.0.1
 */