package com.tencent.mobileqq.activity.qwallet.notifymsg;

import ahbc;
import ahbe;
import ahiy;
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
      synchronized (ahbe.jdField_a_of_type_JavaLangObject)
      {
        if (ahbe.jdField_a_of_type_Ahbc == null) {
          ahbe.jdField_a_of_type_Ahbc = new ahbc(BaseApplicationImpl.getContext());
        }
        ??? = ahiy.a();
        if (??? == null) {
          return;
        }
      }
    } while (ahbe.jdField_a_of_type_Ahbc == null);
    if (this.jdField_a_of_type_Boolean)
    {
      ahbe.jdField_a_of_type_Ahbc.b(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    ahbe.jdField_a_of_type_Ahbc.c(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4
 * JD-Core Version:    0.7.0.1
 */