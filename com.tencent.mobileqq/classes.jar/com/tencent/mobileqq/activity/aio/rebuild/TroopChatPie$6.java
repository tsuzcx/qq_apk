package com.tencent.mobileqq.activity.aio.rebuild;

import acwf;
import acwh;
import acwr;
import afxb;
import android.os.SystemClock;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class TroopChatPie$6
  implements Runnable
{
  TroopChatPie$6(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).f(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    int k;
    int i;
    label92:
    int m;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (((List)localObject).size() > 3) {
        break label165;
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
                break label183;
              }
              if (QLog.isColorLevel()) {
                QLog.i(this.this$0.jdField_a_of_type_JavaLangString, 2, "AIO has more than 3 normal message, so return!");
              }
            }
          }
        }
      }
    }
    label165:
    label183:
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
        QLog.i(this.this$0.jdField_a_of_type_JavaLangString, 2, "now pull more message for troop!");
      }
      TroopChatPie.a(this.this$0, SystemClock.uptimeMillis());
      ((afxb)TroopChatPie.a(this.this$0).a).a(TroopChatPie.a(this.this$0));
      TroopChatPie.b(this.this$0).e = acwh.c((List)localObject);
      TroopChatPie.c(this.this$0).f = true;
    } while (TroopChatPie.d(this.this$0).c != 0);
    localObject = TroopChatPie.e(this.this$0);
    ((acwr)localObject).c += 1;
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, TroopChatPie.f(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.6
 * JD-Core Version:    0.7.0.1
 */