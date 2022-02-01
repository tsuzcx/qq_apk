package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class AVActivity$AnimationTrigger
  implements Runnable
{
  float jdField_a_of_type_Float = -1.0F;
  final int jdField_a_of_type_Int = 1000;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  boolean jdField_a_of_type_Boolean = false;
  float b = -1.0F;
  
  public AVActivity$AnimationTrigger(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("AnimationTrigger", 2, "[childLock] requestShowOrHiddenChildLockUI");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(119), Integer.valueOf(3) });
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("AnimationTrigger", 2, "[childLock] requestShowTips");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(119), Integer.valueOf(2) });
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("AnimationTrigger", 2, "[childLock] cancel animation");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(119), Integer.valueOf(0) });
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AnimationTrigger", 1, "[childLock] trigger animation, isTriggeredAnimation[" + this.jdField_a_of_type_Boolean + "]");
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(119), Integer.valueOf(1), Float.valueOf(this.jdField_a_of_type_Float), Float.valueOf(this.b) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.AnimationTrigger
 * JD-Core Version:    0.7.0.1
 */