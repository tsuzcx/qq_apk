package com.tencent.mobileqq.activity.qwallet.notifymsg;

import aizu;
import aizw;
import ajeu;
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
      synchronized (aizw.jdField_a_of_type_JavaLangObject)
      {
        if (aizw.jdField_a_of_type_Aizu == null) {
          aizw.jdField_a_of_type_Aizu = new aizu(BaseApplicationImpl.getContext());
        }
        ??? = ajeu.a();
        if (??? == null) {
          return;
        }
      }
    } while (aizw.jdField_a_of_type_Aizu == null);
    if (this.jdField_a_of_type_Boolean)
    {
      aizw.jdField_a_of_type_Aizu.b(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    aizw.jdField_a_of_type_Aizu.c(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4
 * JD-Core Version:    0.7.0.1
 */