package com.tencent.av.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import com.tencent.qphone.base.util.QLog;

class ChildLockCircle$1
  extends CountDownTimer
{
  int jdField_a_of_type_Int = 1;
  Resources jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  
  ChildLockCircle$1(ChildLockCircle paramChildLockCircle, long paramLong1, long paramLong2, Context paramContext)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle;
    ChildLockCircle.a((ChildLockCircle)localObject, ChildLockCircle.b((ChildLockCircle)localObject));
    ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, 0);
    this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.postInvalidate();
    ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle);
    localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if (ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle) != null)
    {
      ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle).cancel();
      ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChildLockCircle", 2, "LockAnimation,CountDownTimer finish");
    }
  }
  
  public void onTick(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, this.jdField_a_of_type_AndroidContentResResources, this.jdField_a_of_type_Int);
      Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject != null)
      {
        ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, (Bitmap)localObject);
        this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.postInvalidate();
      }
      this.jdField_a_of_type_Int += 1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LockAnimation, i[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append("]");
        QLog.d("ChildLockCircle", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockCircle.1
 * JD-Core Version:    0.7.0.1
 */