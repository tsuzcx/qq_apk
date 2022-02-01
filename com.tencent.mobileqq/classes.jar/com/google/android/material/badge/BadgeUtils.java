package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewOverlay;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.internal.ParcelableSparseArray;

@ExperimentalBadgeUtils
public class BadgeUtils
{
  public static final boolean a;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 18) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
  }
  
  @NonNull
  public static SparseArray<BadgeDrawable> a(Context paramContext, @NonNull ParcelableSparseArray paramParcelableSparseArray)
  {
    SparseArray localSparseArray = new SparseArray(paramParcelableSparseArray.size());
    int i = 0;
    while (i < paramParcelableSparseArray.size())
    {
      int j = paramParcelableSparseArray.keyAt(i);
      BadgeDrawable.SavedState localSavedState = (BadgeDrawable.SavedState)paramParcelableSparseArray.valueAt(i);
      if (localSavedState != null)
      {
        localSparseArray.put(j, BadgeDrawable.a(paramContext, localSavedState));
        i += 1;
      }
      else
      {
        throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
      }
    }
    return localSparseArray;
  }
  
  @NonNull
  public static ParcelableSparseArray a(@NonNull SparseArray<BadgeDrawable> paramSparseArray)
  {
    ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      int j = paramSparseArray.keyAt(i);
      BadgeDrawable localBadgeDrawable = (BadgeDrawable)paramSparseArray.valueAt(i);
      if (localBadgeDrawable != null)
      {
        localParcelableSparseArray.put(j, localBadgeDrawable.a());
        i += 1;
      }
      else
      {
        throw new IllegalArgumentException("badgeDrawable cannot be null");
      }
    }
    return localParcelableSparseArray;
  }
  
  public static void a(@NonNull Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramRect.set((int)(paramFloat1 - paramFloat3), (int)(paramFloat2 - paramFloat4), (int)(paramFloat1 + paramFloat3), (int)(paramFloat2 + paramFloat4));
  }
  
  public static void a(@Nullable BadgeDrawable paramBadgeDrawable, @NonNull View paramView)
  {
    if (paramBadgeDrawable == null) {
      return;
    }
    if ((!a) && (paramBadgeDrawable.a() == null))
    {
      paramView.getOverlay().remove(paramBadgeDrawable);
      return;
    }
    paramBadgeDrawable.a().setForeground(null);
  }
  
  public static void a(@NonNull BadgeDrawable paramBadgeDrawable, @NonNull View paramView, @Nullable FrameLayout paramFrameLayout)
  {
    b(paramBadgeDrawable, paramView, paramFrameLayout);
    if (paramBadgeDrawable.a() != null)
    {
      paramBadgeDrawable.a().setForeground(paramBadgeDrawable);
      return;
    }
    if (!a)
    {
      paramView.getOverlay().add(paramBadgeDrawable);
      return;
    }
    throw new IllegalArgumentException("Trying to reference null customBadgeParent");
  }
  
  public static void b(@NonNull BadgeDrawable paramBadgeDrawable, @NonNull View paramView, @Nullable FrameLayout paramFrameLayout)
  {
    Rect localRect = new Rect();
    paramView.getDrawingRect(localRect);
    paramBadgeDrawable.setBounds(localRect);
    paramBadgeDrawable.a(paramView, paramFrameLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.badge.BadgeUtils
 * JD-Core Version:    0.7.0.1
 */