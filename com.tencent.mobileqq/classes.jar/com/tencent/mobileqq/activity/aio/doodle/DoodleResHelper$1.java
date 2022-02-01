package com.tencent.mobileqq.activity.aio.doodle;

import agpy;
import android.view.View;
import bbxu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr;

public class DoodleResHelper$1
  implements Runnable
{
  public DoodleResHelper$1(agpy paramagpy, int paramInt1, int paramInt2, View paramView, bbxu parambbxu) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_a_of_type_Int == 0) {
      ScribbleResMgr.a().a(localQQAppInterface, 3, this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Bbxu);
    }
    while ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2)) {
      return;
    }
    ScribbleResMgr.a().a(localQQAppInterface, 4, this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Bbxu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper.1
 * JD-Core Version:    0.7.0.1
 */