package com.tencent.mobileqq.activity.qwallet.notifymsg;

import agon;
import agop;
import agwj;
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
      synchronized (agop.jdField_a_of_type_JavaLangObject)
      {
        if (agop.jdField_a_of_type_Agon == null) {
          agop.jdField_a_of_type_Agon = new agon(BaseApplicationImpl.getContext());
        }
        ??? = agwj.a();
        if (??? == null) {
          return;
        }
      }
    } while (agop.jdField_a_of_type_Agon == null);
    if (this.jdField_a_of_type_Boolean)
    {
      agop.jdField_a_of_type_Agon.b(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    agop.jdField_a_of_type_Agon.c(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4
 * JD-Core Version:    0.7.0.1
 */