package com.tencent.mobileqq.activity.aio.doodle;

import afls;
import android.view.View;
import barp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr;

public class DoodleResHelper$2
  implements Runnable
{
  public DoodleResHelper$2(afls paramafls, int paramInt1, int paramInt2, View paramView, barp parambarp) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_a_of_type_Int == 0) {
      ScribbleResMgr.a().a(localQQAppInterface, 1, this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Barp);
    }
    while ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2)) {
      return;
    }
    ScribbleResMgr.a().a(localQQAppInterface, 2, this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Barp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper.2
 * JD-Core Version:    0.7.0.1
 */