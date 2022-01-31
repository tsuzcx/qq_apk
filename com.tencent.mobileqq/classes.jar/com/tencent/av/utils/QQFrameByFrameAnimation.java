package com.tencent.av.utils;

import android.os.Handler;
import android.view.View;
import khd;

public class QQFrameByFrameAnimation
{
  public int a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView = null;
  public QQAnimationListener a;
  Runnable jdField_a_of_type_JavaLangRunnable = new khd(this);
  public int[] a;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  
  public QQFrameByFrameAnimation()
  {
    this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener = null;
    this.jdField_a_of_type_Int = 300;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public void a()
  {
    this.c += 1;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0)) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ArrayOfInt[(this.c % this.jdField_a_of_type_ArrayOfInt.length)]);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(QQAnimationListener paramQQAnimationListener)
  {
    this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener = paramQQAnimationListener;
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      this.c = 0;
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ArrayOfInt[0]);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener.d();
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener != null) {
      this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.QQFrameByFrameAnimation
 * JD-Core Version:    0.7.0.1
 */