package com.tencent.mobileqq.activity.messagesearch;

import akbt;
import android.os.Bundle;
import android.os.Message;
import bhec;
import bkyc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class C2CLinkMessageResultAdapter$1
  implements Runnable
{
  public C2CLinkMessageResultAdapter$1(akbt paramakbt, String paramString, int paramInt, long paramLong) {}
  
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
      bhec.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
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
          localakbt = this.this$0;
          if (((ArrayList)localObject2).size() < 20)
          {
            localakbt.jdField_a_of_type_Boolean = bool;
            this.this$0.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData = ((ChatHistorySearchData)localObject4);
            localObject2 = this.this$0.jdField_a_of_type_Bkyc.obtainMessage(2, localObject2);
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
        akbt localakbt = this.this$0;
        if (((ArrayList)localObject2).size() < 20)
        {
          bool = true;
          localakbt.jdField_a_of_type_Boolean = bool;
          this.this$0.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData = ((ChatHistorySearchData)localObject4);
          localObject2 = this.this$0.jdField_a_of_type_Bkyc.obtainMessage(2, localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */