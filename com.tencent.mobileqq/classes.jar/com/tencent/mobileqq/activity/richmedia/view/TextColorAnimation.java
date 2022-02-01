package com.tencent.mobileqq.activity.richmedia.view;

import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.ArrayList;

public class TextColorAnimation
  extends Animation
{
  private int jdField_a_of_type_Int;
  private TextColorAnimation.OnUpdateColorListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation$OnUpdateColorListener;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  
  public TextColorAnimation(ArrayList<Integer> paramArrayList)
  {
    a(paramArrayList);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(ArrayList<Integer> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    paramTransformation = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramTransformation != null)
    {
      if (paramTransformation.size() < 2) {
        return;
      }
      float f = 1.0F / (this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      int j = (int)(paramFloat / f);
      f = (paramFloat - j * f) / f;
      int i = j;
      if (j == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size() - 2;
      }
      int k = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).intValue();
      j = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i + 1)).intValue();
      i = j;
      if (paramFloat < 1.0F) {
        i = Color.argb((int)(Color.alpha(k) + (Color.alpha(j) - Color.alpha(k)) * f), (int)(Color.red(k) + (Color.red(j) - Color.red(k)) * f), (int)(Color.green(k) + (Color.green(j) - Color.green(k)) * f), (int)(Color.blue(k) + f * (Color.blue(j) - Color.blue(k))));
      }
      this.jdField_a_of_type_Int = i;
      paramTransformation = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewTextColorAnimation$OnUpdateColorListener;
      if (paramTransformation != null) {
        paramTransformation.a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.TextColorAnimation
 * JD-Core Version:    0.7.0.1
 */