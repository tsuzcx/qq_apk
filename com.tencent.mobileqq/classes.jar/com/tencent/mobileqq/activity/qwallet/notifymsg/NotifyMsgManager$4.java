package com.tencent.mobileqq.activity.qwallet.notifymsg;

import akwk;
import akwm;
import albw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public final class NotifyMsgManager$4
  implements Runnable
{
  public NotifyMsgManager$4(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    do
    {
      synchronized (akwm.jdField_a_of_type_JavaLangObject)
      {
        if (akwm.jdField_a_of_type_Akwk == null) {
          akwm.jdField_a_of_type_Akwk = new akwk(BaseApplicationImpl.getContext());
        }
        ??? = albw.a();
        if (??? == null) {
          return;
        }
      }
    } while (akwm.jdField_a_of_type_Akwk == null);
    if (this.jdField_a_of_type_Boolean)
    {
      akwm.jdField_a_of_type_Akwk.b(((QQAppInterface)???).getCurrentUin(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    akwm.jdField_a_of_type_Akwk.c(((QQAppInterface)???).getCurrentUin(), this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4
 * JD-Core Version:    0.7.0.1
 */