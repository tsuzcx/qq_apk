package com.tencent.gdtad.views;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public final class GdtUIUtils$2
  implements Runnable
{
  public GdtUIUtils$2(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView.getHitRect((Rect)localObject);
    ((Rect)localObject).top -= this.jdField_a_of_type_Int;
    ((Rect)localObject).bottom += this.b;
    ((Rect)localObject).left -= this.c;
    ((Rect)localObject).right += this.d;
    if (QLog.isColorLevel()) {
      QLog.d("TouchDelegate", 2, " bounds.top=" + ((Rect)localObject).top + "bounds.bottom=" + ((Rect)localObject).bottom);
    }
    localObject = new TouchDelegate((Rect)localObject, this.jdField_a_of_type_AndroidViewView);
    if (View.class.isInstance(this.jdField_a_of_type_AndroidViewView.getParent())) {
      ((View)this.jdField_a_of_type_AndroidViewView.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.views.GdtUIUtils.2
 * JD-Core Version:    0.7.0.1
 */