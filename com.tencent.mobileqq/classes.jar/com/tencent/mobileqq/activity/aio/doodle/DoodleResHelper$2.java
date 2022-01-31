package com.tencent.mobileqq.activity.aio.doodle;

import aevw;
import android.view.View;
import ayck;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr;

public class DoodleResHelper$2
  implements Runnable
{
  public DoodleResHelper$2(aevw paramaevw, int paramInt1, int paramInt2, View paramView, ayck paramayck) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_a_of_type_Int == 0) {
      ScribbleResMgr.a().a(localQQAppInterface, 1, this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Ayck);
    }
    while ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2)) {
      return;
    }
    ScribbleResMgr.a().a(localQQAppInterface, 2, this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Ayck);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper.2
 * JD-Core Version:    0.7.0.1
 */