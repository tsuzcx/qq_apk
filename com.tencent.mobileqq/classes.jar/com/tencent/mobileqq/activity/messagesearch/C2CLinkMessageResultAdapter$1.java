package com.tencent.mobileqq.activity.messagesearch;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;

class C2CLinkMessageResultAdapter$1
  implements Runnable
{
  C2CLinkMessageResultAdapter$1(C2CLinkMessageResultAdapter paramC2CLinkMessageResultAdapter, String paramString, int paramInt, long paramLong) {}
  
  public void run()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("C2CLinkMessageResultAdapter", 2, "loadMessageResult, run(), keyword = " + this.jdField_a_of_type_JavaLangString + ", loadType = " + this.jdField_a_of_type_Int);
    }
    ??? = null;
    Object localObject2;
    Object localObject4;
    if (this.jdField_a_of_type_Int == 1)
    {
      ??? = this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString);
      HistoryChatMsgSearchKeyUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
      localObject2 = new ArrayList();
      localObject4 = this.this$0.b((ChatHistorySearchData)???, (ArrayList)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("C2CLinkMessageResultAdapter", 2, "loadMessageResult, get: messageItems[] = " + localObject2);
      }
    }
    for (;;)
    {
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        if (this.this$0.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))
        {
          if (this.jdField_a_of_type_Int != 1) {
            continue;
          }
          localC2CLinkMessageResultAdapter = this.this$0;
          if (((ArrayList)localObject2).size() < 20)
          {
            localC2CLinkMessageResultAdapter.jdField_a_of_type_Boolean = bool;
            this.this$0.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData = ((ChatHistorySearchData)localObject4);
            localObject2 = this.this$0.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(2, localObject2);
            ((Message)localObject2).arg1 = 1;
            localObject4 = new Bundle();
            ((Bundle)localObject4).putLong("searchSequence", this.jdField_a_of_type_Long);
            ((Bundle)localObject4).putString("searchKeyword", this.jdField_a_of_type_JavaLangString);
            ((Message)localObject2).setData((Bundle)localObject4);
            ((Message)localObject2).sendToTarget();
          }
        }
        else
        {
          return;
          if (this.jdField_a_of_type_Int != 2) {
            break;
          }
          ??? = this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "");
          break;
        }
        bool = false;
        continue;
        if (this.jdField_a_of_type_Int != 2) {
          continue;
        }
        C2CLinkMessageResultAdapter localC2CLinkMessageResultAdapter = this.this$0;
        if (((ArrayList)localObject2).size() < 20)
        {
          bool = true;
          localC2CLinkMessageResultAdapter.jdField_a_of_type_Boolean = bool;
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
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */