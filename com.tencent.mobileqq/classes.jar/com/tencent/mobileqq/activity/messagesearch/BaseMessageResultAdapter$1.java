package com.tencent.mobileqq.activity.messagesearch;

import agdg;
import android.os.Bundle;
import android.os.Message;
import bbeb;
import bfnk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class BaseMessageResultAdapter$1
  implements Runnable
{
  public BaseMessageResultAdapter$1(agdg paramagdg, String paramString, int paramInt, long paramLong) {}
  
  public void run()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i(agdg.b(), 2, "loadMessageResult, run(), keyword = " + this.jdField_a_of_type_JavaLangString + ", loadType = " + this.jdField_a_of_type_Int);
    }
    ??? = null;
    Object localObject2;
    Object localObject4;
    if (this.jdField_a_of_type_Int == 1)
    {
      ??? = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString);
      bbeb.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
      localObject2 = new ArrayList();
      localObject4 = this.this$0.b((ChatHistorySearchData)???, (ArrayList)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i(agdg.b(), 2, "loadMessageResult, get: messageItems[] = " + localObject2);
      }
    }
    for (;;)
    {
      synchronized (this.this$0.b)
      {
        if (this.this$0.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))
        {
          if (this.jdField_a_of_type_Int != 1) {
            continue;
          }
          localagdg = this.this$0;
          if (((ArrayList)localObject2).size() < 20)
          {
            localagdg.jdField_a_of_type_Boolean = bool;
            this.this$0.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData = ((ChatHistorySearchData)localObject4);
            localObject2 = this.this$0.jdField_a_of_type_Bfnk.obtainMessage(2, localObject2);
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
          ??? = this.this$0.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData;
          break;
        }
        bool = false;
        continue;
        if (this.jdField_a_of_type_Int != 2) {
          continue;
        }
        agdg localagdg = this.this$0;
        if (((ArrayList)localObject2).size() < 20)
        {
          bool = true;
          localagdg.jdField_a_of_type_Boolean = bool;
          this.this$0.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData = ((ChatHistorySearchData)localObject4);
          localObject2 = this.this$0.jdField_a_of_type_Bfnk.obtainMessage(2, localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */