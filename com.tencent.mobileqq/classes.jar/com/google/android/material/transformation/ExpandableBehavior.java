package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

@Deprecated
public abstract class ExpandableBehavior
  extends CoordinatorLayout.Behavior<View>
{
  private int a = 0;
  
  public ExpandableBehavior() {}
  
  public ExpandableBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramBoolean)
    {
      int i = this.a;
      if (i != 0)
      {
        paramBoolean = bool1;
        if (i != 2) {}
      }
      else
      {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    paramBoolean = bool2;
    if (this.a == 1) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  @Nullable
  protected ExpandableWidget a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView)
  {
    List localList = paramCoordinatorLayout.getDependencies(paramView);
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localList.get(i);
      if (layoutDependsOn(paramCoordinatorLayout, paramView, localView)) {
        return (ExpandableWidget)localView;
      }
      i += 1;
    }
    return null;
  }
  
  protected abstract boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2);
  
  @CallSuper
  public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    paramCoordinatorLayout = (ExpandableWidget)paramView2;
    if (a(paramCoordinatorLayout.a()))
    {
      int i;
      if (paramCoordinatorLayout.a()) {
        i = 1;
      } else {
        i = 2;
      }
      this.a = i;
      return a((View)paramCoordinatorLayout, paramView1, paramCoordinatorLayout.a(), true);
    }
    return false;
  }
  
  @CallSuper
  public boolean onLayoutChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView, int paramInt)
  {
    if (!ViewCompat.isLaidOut(paramView))
    {
      paramCoordinatorLayout = a(paramCoordinatorLayout, paramView);
      if ((paramCoordinatorLayout != null) && (a(paramCoordinatorLayout.a())))
      {
        if (paramCoordinatorLayout.a()) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        this.a = paramInt;
        paramInt = this.a;
        paramView.getViewTreeObserver().addOnPreDrawListener(new ExpandableBehavior.1(this, paramView, paramInt, paramCoordinatorLayout));
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transformation.ExpandableBehavior
 * JD-Core Version:    0.7.0.1
 */