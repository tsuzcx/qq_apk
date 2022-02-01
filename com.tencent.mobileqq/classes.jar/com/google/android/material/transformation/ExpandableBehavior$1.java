package com.google.android.material.transformation;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.google.android.material.expandable.ExpandableWidget;

class ExpandableBehavior$1
  implements ViewTreeObserver.OnPreDrawListener
{
  ExpandableBehavior$1(ExpandableBehavior paramExpandableBehavior, View paramView, int paramInt, ExpandableWidget paramExpandableWidget) {}
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnPreDrawListener(this);
    if (ExpandableBehavior.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTransformationExpandableBehavior) == this.jdField_a_of_type_Int)
    {
      ExpandableBehavior localExpandableBehavior = this.jdField_a_of_type_ComGoogleAndroidMaterialTransformationExpandableBehavior;
      ExpandableWidget localExpandableWidget = this.jdField_a_of_type_ComGoogleAndroidMaterialExpandableExpandableWidget;
      localExpandableBehavior.a((View)localExpandableWidget, this.jdField_a_of_type_AndroidViewView, localExpandableWidget.a(), false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transformation.ExpandableBehavior.1
 * JD-Core Version:    0.7.0.1
 */