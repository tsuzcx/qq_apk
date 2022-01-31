package com.tencent.mobileqq.activity.qwallet.notifymsg;

import aivf;
import aivh;
import ajaf;
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
      synchronized (aivh.jdField_a_of_type_JavaLangObject)
      {
        if (aivh.jdField_a_of_type_Aivf == null) {
          aivh.jdField_a_of_type_Aivf = new aivf(BaseApplicationImpl.getContext());
        }
        ??? = ajaf.a();
        if (??? == null) {
          return;
        }
      }
    } while (aivh.jdField_a_of_type_Aivf == null);
    if (this.jdField_a_of_type_Boolean)
    {
      aivh.jdField_a_of_type_Aivf.b(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    aivh.jdField_a_of_type_Aivf.c(((QQAppInterface)???).c(), this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4
 * JD-Core Version:    0.7.0.1
 */