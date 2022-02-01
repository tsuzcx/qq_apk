package com.tencent.mobileqq.activity.qwallet.notifymsg;

import akrn;
import akrp;
import akww;
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
      synchronized (akrp.jdField_a_of_type_JavaLangObject)
      {
        if (akrp.jdField_a_of_type_Akrn == null) {
          akrp.jdField_a_of_type_Akrn = new akrn(BaseApplicationImpl.getContext());
        }
        ??? = akww.a();
        if (??? == null) {
          return;
        }
      }
    } while (akrp.jdField_a_of_type_Akrn == null);
    if (this.jdField_a_of_type_Boolean)
    {
      akrp.jdField_a_of_type_Akrn.b(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    akrp.jdField_a_of_type_Akrn.c(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4
 * JD-Core Version:    0.7.0.1
 */