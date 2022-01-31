package com.tencent.mobileqq.activity.qwallet.notifymsg;

import ahba;
import ahbc;
import ahiw;
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
      synchronized (ahbc.jdField_a_of_type_JavaLangObject)
      {
        if (ahbc.jdField_a_of_type_Ahba == null) {
          ahbc.jdField_a_of_type_Ahba = new ahba(BaseApplicationImpl.getContext());
        }
        ??? = ahiw.a();
        if (??? == null) {
          return;
        }
      }
    } while (ahbc.jdField_a_of_type_Ahba == null);
    if (this.jdField_a_of_type_Boolean)
    {
      ahbc.jdField_a_of_type_Ahba.b(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    ahbc.jdField_a_of_type_Ahba.c(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4
 * JD-Core Version:    0.7.0.1
 */