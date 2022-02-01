package com.tencent.mobileqq.activity.contact.troop;

import aikq;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class TroopNotifyAndRecommendView$11
  implements Runnable
{
  TroopNotifyAndRecommendView$11(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void run()
  {
    int i = 0;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    aikq localaikq;
    do
    {
      return;
      localaikq = (aikq)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    } while (localaikq == null);
    this.this$0.jdField_a_of_type_JavaUtilList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAllMessages(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, null);
    ArrayList localArrayList1 = localaikq.a(this.this$0.jdField_a_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "Get MessageRecords From DB No Seq Size =", Integer.valueOf(localArrayList1.size()) });
    }
    ArrayList localArrayList2 = new ArrayList();
    while (i < localArrayList1.size())
    {
      localArrayList2.add(localArrayList1.get(localArrayList1.size() - i - 1));
      i += 1;
    }
    localaikq.a();
    ThreadManager.getUIHandler().post(new TroopNotifyAndRecommendView.11.1(this, localaikq, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.11
 * JD-Core Version:    0.7.0.1
 */