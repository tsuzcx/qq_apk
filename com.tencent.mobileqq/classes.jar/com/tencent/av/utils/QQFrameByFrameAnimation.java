package com.tencent.av.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class QQFrameByFrameAnimation
{
  int jdField_a_of_type_Int = 300;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  View jdField_a_of_type_AndroidViewView = null;
  QQAnimationListener jdField_a_of_type_ComTencentAvUtilsQQAnimationListener = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new QQFrameByFrameAnimation.1(this);
  int[] jdField_a_of_type_ArrayOfInt;
  int b = 0;
  int c = 0;
  int d = 0;
  
  void a()
  {
    this.c += 1;
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        int i = arrayOfInt[(this.c % arrayOfInt.length)];
        if ((localObject instanceof ImageButton))
        {
          ((View)localObject).setBackgroundResource(i);
          return;
        }
        if ((localObject instanceof Button))
        {
          localObject = ((View)localObject).getResources().getDrawable(i);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          ((Button)this.jdField_a_of_type_AndroidViewView).setCompoundDrawables(null, (Drawable)localObject, null, null);
        }
      }
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
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        this.c = 0;
        if ((localObject instanceof ImageButton)) {
          ((View)localObject).setBackgroundResource(arrayOfInt[0]);
        }
        localObject = this.jdField_a_of_type_AndroidViewView;
        if ((localObject instanceof Button))
        {
          localObject = ((View)localObject).getResources().getDrawable(this.jdField_a_of_type_ArrayOfInt[0]);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          ((Button)this.jdField_a_of_type_AndroidViewView).setCompoundDrawables(null, (Drawable)localObject, null, null);
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Int);
        localObject = this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener;
        if (localObject != null) {
          ((QQAnimationListener)localObject).d();
        }
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
    QQAnimationListener localQQAnimationListener = this.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener;
    if (localQQAnimationListener != null) {
      localQQAnimationListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QQFrameByFrameAnimation
 * JD-Core Version:    0.7.0.1
 */