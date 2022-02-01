package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private int jdField_a_of_type_Int = 0;
  private ViewOffsetHelper jdField_a_of_type_ComGoogleAndroidMaterialAppbarViewOffsetHelper;
  private int b = 0;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt)
  {
    paramCoordinatorLayout.onLayoutChild(paramV, paramInt);
  }
  
  public boolean a(int paramInt)
  {
    ViewOffsetHelper localViewOffsetHelper = this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarViewOffsetHelper;
    if (localViewOffsetHelper != null) {
      return localViewOffsetHelper.a(paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
    return false;
  }
  
  public int b()
  {
    ViewOffsetHelper localViewOffsetHelper = this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarViewOffsetHelper;
    if (localViewOffsetHelper != null) {
      return localViewOffsetHelper.a();
    }
    return 0;
  }
  
  public boolean onLayoutChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt)
  {
    a(paramCoordinatorLayout, paramV, paramInt);
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarViewOffsetHelper == null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarViewOffsetHelper = new ViewOffsetHelper(paramV);
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarViewOffsetHelper.a();
    this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarViewOffsetHelper.b();
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarViewOffsetHelper.a(paramInt);
      this.jdField_a_of_type_Int = 0;
    }
    paramInt = this.b;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarViewOffsetHelper.b(paramInt);
      this.b = 0;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.appbar.ViewOffsetBehavior
 * JD-Core Version:    0.7.0.1
 */