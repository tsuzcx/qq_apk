package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.dimen;

@RequiresApi(21)
public final class SlideDistanceProvider
  implements VisibilityAnimatorProvider
{
  private int a;
  @Px
  private int b;
  
  private int a(Context paramContext)
  {
    int i = this.b;
    if (i != -1) {
      return i;
    }
    return paramContext.getResources().getDimensionPixelSize(R.dimen.aw);
  }
  
  private static Animator a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[] { paramFloat1, paramFloat2 }) });
    localObjectAnimator.addListener(new SlideDistanceProvider.1(paramView, paramFloat3));
    return localObjectAnimator;
  }
  
  private static Animator a(View paramView1, View paramView2, int paramInt1, @Px int paramInt2)
  {
    float f2 = paramView2.getTranslationX();
    float f1 = paramView2.getTranslationY();
    if (paramInt1 != 3)
    {
      if (paramInt1 != 5)
      {
        if (paramInt1 != 48)
        {
          if (paramInt1 != 80)
          {
            if (paramInt1 != 8388611)
            {
              if (paramInt1 == 8388613)
              {
                if (a(paramView1)) {
                  f1 = f2 - paramInt2;
                } else {
                  f1 = paramInt2 + f2;
                }
                return a(paramView2, f1, f2, f2);
              }
              paramView1 = new StringBuilder();
              paramView1.append("Invalid slide direction: ");
              paramView1.append(paramInt1);
              throw new IllegalArgumentException(paramView1.toString());
            }
            if (a(paramView1)) {
              f1 = paramInt2 + f2;
            } else {
              f1 = f2 - paramInt2;
            }
            return a(paramView2, f1, f2, f2);
          }
          return b(paramView2, paramInt2 + f1, f1, f1);
        }
        return b(paramView2, f1 - paramInt2, f1, f1);
      }
      return a(paramView2, f2 - paramInt2, f2, f2);
    }
    return a(paramView2, paramInt2 + f2, f2, f2);
  }
  
  private static boolean a(View paramView)
  {
    return ViewCompat.getLayoutDirection(paramView) == 1;
  }
  
  private static Animator b(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { paramFloat1, paramFloat2 }) });
    localObjectAnimator.addListener(new SlideDistanceProvider.2(paramView, paramFloat3));
    return localObjectAnimator;
  }
  
  private static Animator b(View paramView1, View paramView2, int paramInt1, @Px int paramInt2)
  {
    float f2 = paramView2.getTranslationX();
    float f1 = paramView2.getTranslationY();
    if (paramInt1 != 3)
    {
      if (paramInt1 != 5)
      {
        if (paramInt1 != 48)
        {
          if (paramInt1 != 80)
          {
            if (paramInt1 != 8388611)
            {
              if (paramInt1 == 8388613)
              {
                if (a(paramView1)) {
                  f1 = paramInt2 + f2;
                } else {
                  f1 = f2 - paramInt2;
                }
                return a(paramView2, f2, f1, f2);
              }
              paramView1 = new StringBuilder();
              paramView1.append("Invalid slide direction: ");
              paramView1.append(paramInt1);
              throw new IllegalArgumentException(paramView1.toString());
            }
            if (a(paramView1)) {
              f1 = f2 - paramInt2;
            } else {
              f1 = paramInt2 + f2;
            }
            return a(paramView2, f2, f1, f2);
          }
          return b(paramView2, f1, f1 - paramInt2, f1);
        }
        return b(paramView2, f1, paramInt2 + f1, f1);
      }
      return a(paramView2, f2, paramInt2 + f2, f2);
    }
    return a(paramView2, f2, f2 - paramInt2, f2);
  }
  
  @Nullable
  public Animator a(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    return a(paramViewGroup, paramView, this.a, a(paramView.getContext()));
  }
  
  @Nullable
  public Animator b(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    return b(paramViewGroup, paramView, this.a, a(paramView.getContext()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.platform.SlideDistanceProvider
 * JD-Core Version:    0.7.0.1
 */