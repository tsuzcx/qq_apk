package com.tencent.mobileqq.activity.qwallet.notifymsg;

import alcy;
import alda;
import alil;
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
      synchronized (alda.jdField_a_of_type_JavaLangObject)
      {
        if (alda.jdField_a_of_type_Alcy == null) {
          alda.jdField_a_of_type_Alcy = new alcy(BaseApplicationImpl.getContext());
        }
        ??? = alil.a();
        if (??? == null) {
          return;
        }
      }
    } while (alda.jdField_a_of_type_Alcy == null);
    if (this.jdField_a_of_type_Boolean)
    {
      alda.jdField_a_of_type_Alcy.b(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    alda.jdField_a_of_type_Alcy.c(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4
 * JD-Core Version:    0.7.0.1
 */