package com.tencent.mobileqq.activity.aio.doodle;

import afal;
import android.view.View;
import aygt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr;

public class DoodleResHelper$1
  implements Runnable
{
  public DoodleResHelper$1(afal paramafal, int paramInt1, int paramInt2, View paramView, aygt paramaygt) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_a_of_type_Int == 0) {
      ScribbleResMgr.a().a(localQQAppInterface, 3, this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Aygt);
    }
    while ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2)) {
      return;
    }
    ScribbleResMgr.a().a(localQQAppInterface, 4, this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Aygt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper.1
 * JD-Core Version:    0.7.0.1
 */