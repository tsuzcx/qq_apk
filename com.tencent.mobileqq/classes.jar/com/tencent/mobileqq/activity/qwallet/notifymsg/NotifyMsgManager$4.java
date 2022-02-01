package com.tencent.mobileqq.activity.qwallet.notifymsg;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

final class NotifyMsgManager$4
  implements Runnable
{
  NotifyMsgManager$4(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    do
    {
      synchronized (NotifyMsgManager.jdField_a_of_type_JavaLangObject)
      {
        if (NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper == null) {
          NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper = new NotifyMsgDBHelper(BaseApplicationImpl.getContext());
        }
        ??? = QWalletTools.a();
        if (??? == null) {
          return;
        }
      }
    } while (NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper == null);
    if (this.jdField_a_of_type_Boolean)
    {
      NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper.b(((QQAppInterface)???).getCurrentUin(), this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper.c(((QQAppInterface)???).getCurrentUin(), this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4
 * JD-Core Version:    0.7.0.1
 */