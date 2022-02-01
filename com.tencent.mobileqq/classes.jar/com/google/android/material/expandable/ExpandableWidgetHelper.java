package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class ExpandableWidgetHelper
{
  @NonNull
  private final View a;
  private boolean b = false;
  @IdRes
  private int c = 0;
  
  public ExpandableWidgetHelper(ExpandableWidget paramExpandableWidget)
  {
    this.a = ((View)paramExpandableWidget);
  }
  
  private void d()
  {
    ViewParent localViewParent = this.a.getParent();
    if ((localViewParent instanceof CoordinatorLayout)) {
      ((CoordinatorLayout)localViewParent).dispatchDependentViewsChanged(this.a);
    }
  }
  
  public void a(@IdRes int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(@NonNull Bundle paramBundle)
  {
    this.b = paramBundle.getBoolean("expanded", false);
    this.c = paramBundle.getInt("expandedComponentIdHint", 0);
    if (this.b) {
      d();
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  @NonNull
  public Bundle b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("expanded", this.b);
    localBundle.putInt("expandedComponentIdHint", this.c);
    return localBundle;
  }
  
  @IdRes
  public int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.expandable.ExpandableWidgetHelper
 * JD-Core Version:    0.7.0.1
 */