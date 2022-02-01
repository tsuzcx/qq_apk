package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.os.SystemClock;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class TroopListUI$1
  implements Runnable
{
  TroopListUI$1(TroopListUI paramTroopListUI) {}
  
  public void run()
  {
    int j = 0;
    SessionInfo localSessionInfo = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(localSessionInfo.jdField_a_of_type_Int).d(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int);
    int k;
    int i;
    label92:
    int m;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (((List)localObject).size() > 3) {
        break label160;
      }
      k = ((List)localObject).size();
      Iterator localIterator = ((List)localObject).iterator();
      i = 0;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (localMessageRecord != null) {
            if (localMessageRecord.msgtype == -2058)
            {
              m = j + 1;
              j = i;
              i = m;
              label140:
              if (j < k) {
                break label178;
              }
              if (QLog.isColorLevel()) {
                QLog.i("TroopListUI", 2, "AIO has more than 3 normal message, so return!");
              }
            }
          }
        }
      }
    }
    label160:
    label178:
    do
    {
      do
      {
        return;
        k = 3;
        break;
        m = i + 1;
        i = j;
        j = m;
        break label140;
        m = j;
        j = i;
        i = m;
        break label92;
      } while (j <= ((List)localObject).size() / 2);
      if (QLog.isColorLevel()) {
        QLog.i("TroopListUI", 2, "now pull more message for troop!");
      }
      this.this$0.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.a).a(this.this$0.jdField_a_of_type_Long);
      this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.e = UinTypeUtil.a((List)localObject);
      this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.f = true;
    } while (this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.c != 0);
    localObject = this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext;
    ((QQMessageFacade.RefreshMessageContext)localObject).c += 1;
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, 15, this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI.1
 * JD-Core Version:    0.7.0.1
 */