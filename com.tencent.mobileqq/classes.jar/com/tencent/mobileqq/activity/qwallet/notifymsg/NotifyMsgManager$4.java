package com.tencent.mobileqq.activity.qwallet.notifymsg;

import akar;
import akat;
import akgd;
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
      synchronized (akat.jdField_a_of_type_JavaLangObject)
      {
        if (akat.jdField_a_of_type_Akar == null) {
          akat.jdField_a_of_type_Akar = new akar(BaseApplicationImpl.getContext());
        }
        ??? = akgd.a();
        if (??? == null) {
          return;
        }
      }
    } while (akat.jdField_a_of_type_Akar == null);
    if (this.jdField_a_of_type_Boolean)
    {
      akat.jdField_a_of_type_Akar.b(((QQAppInterface)???).getCurrentUin(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    akat.jdField_a_of_type_Akar.c(((QQAppInterface)???).getCurrentUin(), this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4
 * JD-Core Version:    0.7.0.1
 */