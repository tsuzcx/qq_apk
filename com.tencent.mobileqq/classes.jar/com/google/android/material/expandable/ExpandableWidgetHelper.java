package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class ExpandableWidgetHelper
{
  @IdRes
  private int jdField_a_of_type_Int = 0;
  @NonNull
  private final View jdField_a_of_type_AndroidViewView;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ExpandableWidgetHelper(ExpandableWidget paramExpandableWidget)
  {
    this.jdField_a_of_type_AndroidViewView = ((View)paramExpandableWidget);
  }
  
  private void a()
  {
    ViewParent localViewParent = this.jdField_a_of_type_AndroidViewView.getParent();
    if ((localViewParent instanceof CoordinatorLayout)) {
      ((CoordinatorLayout)localViewParent).dispatchDependentViewsChanged(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  @IdRes
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NonNull
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("expanded", this.jdField_a_of_type_Boolean);
    localBundle.putInt("expandedComponentIdHint", this.jdField_a_of_type_Int);
    return localBundle;
  }
  
  public void a(@IdRes int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@NonNull Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("expanded", false);
    this.jdField_a_of_type_Int = paramBundle.getInt("expandedComponentIdHint", 0);
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.expandable.ExpandableWidgetHelper
 * JD-Core Version:    0.7.0.1
 */