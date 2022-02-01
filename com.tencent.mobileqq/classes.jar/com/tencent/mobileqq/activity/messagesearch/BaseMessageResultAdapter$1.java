package com.tencent.mobileqq.activity.messagesearch;

import android.os.Bundle;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;

class BaseMessageResultAdapter$1
  implements Runnable
{
  BaseMessageResultAdapter$1(BaseMessageResultAdapter paramBaseMessageResultAdapter, String paramString, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      ??? = BaseMessageResultAdapter.b();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadMessageResult, run(), keyword = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", loadType = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
      QLog.i((String)???, 2, ((StringBuilder)localObject2).toString());
    }
    ??? = null;
    int i = this.jdField_a_of_type_Int;
    boolean bool1 = true;
    if (i == 1)
    {
      ??? = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      HistoryChatMsgSearchKeyUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    }
    else if (i == 2)
    {
      ??? = this.this$0.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData;
    }
    Object localObject2 = new ArrayList();
    Object localObject4 = this.this$0.b((ChatHistorySearchData)???, (ArrayList)localObject2);
    Object localObject5;
    if (QLog.isColorLevel())
    {
      ??? = BaseMessageResultAdapter.b();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("loadMessageResult, get: messageItems[] = ");
      ((StringBuilder)localObject5).append(localObject2);
      QLog.i((String)???, 2, ((StringBuilder)localObject5).toString());
    }
    for (;;)
    {
      synchronized (this.this$0.b)
      {
        if (this.this$0.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))
        {
          i = this.jdField_a_of_type_Int;
          boolean bool2 = false;
          if (i == 1)
          {
            localObject5 = this.this$0;
            bool1 = bool2;
            if (((ArrayList)localObject2).size() < 20) {
              bool1 = true;
            }
            ((BaseMessageResultAdapter)localObject5).jdField_a_of_type_Boolean = bool1;
            this.this$0.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData = ((ChatHistorySearchData)localObject4);
            localObject2 = this.this$0.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(2, localObject2);
            ((Message)localObject2).arg1 = 1;
            localObject4 = new Bundle();
            ((Bundle)localObject4).putLong("searchSequence", this.jdField_a_of_type_Long);
            ((Bundle)localObject4).putString("searchKeyword", this.jdField_a_of_type_JavaLangString);
            ((Message)localObject2).setData((Bundle)localObject4);
            ((Message)localObject2).sendToTarget();
          }
          else if (this.jdField_a_of_type_Int == 2)
          {
            localObject5 = this.this$0;
            if (((ArrayList)localObject2).size() >= 20) {
              break label495;
            }
            ((BaseMessageResultAdapter)localObject5).jdField_a_of_type_Boolean = bool1;
            this.this$0.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData = ((ChatHistorySearchData)localObject4);
            localObject2 = this.this$0.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(2, localObject2);
            ((Message)localObject2).arg1 = 2;
            localObject4 = new Bundle();
            ((Bundle)localObject4).putLong("searchSequence", this.jdField_a_of_type_Long);
            ((Bundle)localObject4).putString("searchKeyword", this.jdField_a_of_type_JavaLangString);
            ((Message)localObject2).setData((Bundle)localObject4);
            ((Message)localObject2).sendToTarget();
          }
        }
        return;
      }
      label495:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */