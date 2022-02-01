package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

class ViewOffsetHelper
{
  private int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  private int c;
  private int d;
  
  public ViewOffsetHelper(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public int a()
  {
    return this.c;
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidViewView.getTop();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidViewView.getLeft();
  }
  
  public boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.c != paramInt))
    {
      this.c = paramInt;
      b();
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    ViewCompat.offsetTopAndBottom(localView, this.c - (localView.getTop() - this.jdField_a_of_type_Int));
    localView = this.jdField_a_of_type_AndroidViewView;
    ViewCompat.offsetLeftAndRight(localView, this.d - (localView.getLeft() - this.jdField_b_of_type_Int));
  }
  
  public boolean b(int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.d != paramInt))
    {
      this.d = paramInt;
      b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.appbar.ViewOffsetHelper
 * JD-Core Version:    0.7.0.1
 */