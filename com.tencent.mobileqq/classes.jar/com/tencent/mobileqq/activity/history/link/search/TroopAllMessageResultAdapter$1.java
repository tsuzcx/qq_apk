package com.tencent.mobileqq.activity.history.link.search;

import aieh;
import android.os.Bundle;
import android.os.Message;
import bdhf;
import bhsl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopAllMessageResultAdapter$1
  implements Runnable
{
  public TroopAllMessageResultAdapter$1(aieh paramaieh, String paramString, int paramInt, long paramLong) {}
  
  public void run()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageResultAdapter", 2, "loadMessageResult, run(), keyword = " + this.jdField_a_of_type_JavaLangString + ", loadType = " + this.jdField_a_of_type_Int);
    }
    ??? = null;
    Object localObject2;
    Object localObject4;
    if (this.jdField_a_of_type_Int == 1)
    {
      ??? = aieh.a(this.this$0).a().a(aieh.a(this.this$0), this.jdField_a_of_type_JavaLangString);
      bdhf.a(aieh.b(this.this$0).getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
      localObject2 = new ArrayList();
      localObject4 = aieh.a(this.this$0, (ChatHistorySearchData)???, (ArrayList)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("LinkMessageResultAdapter", 2, "loadMessageResult, get: messageItems[] = " + localObject2);
      }
    }
    for (;;)
    {
      synchronized (this.this$0.a)
      {
        if (aieh.a(this.this$0).equals(this.jdField_a_of_type_JavaLangString))
        {
          if (this.jdField_a_of_type_Int != 1) {
            continue;
          }
          localaieh = this.this$0;
          if (((ArrayList)localObject2).size() < 20)
          {
            aieh.a(localaieh, bool);
            aieh.a(this.this$0, (ChatHistorySearchData)localObject4);
            localObject2 = aieh.a(this.this$0).obtainMessage(2, localObject2);
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
          ??? = aieh.c(this.this$0).a().a(aieh.b(this.this$0), "");
          break;
        }
        bool = false;
        continue;
        if (this.jdField_a_of_type_Int != 2) {
          continue;
        }
        aieh localaieh = this.this$0;
        if (((ArrayList)localObject2).size() < 20)
        {
          bool = true;
          aieh.b(localaieh, bool);
          aieh.b(this.this$0, (ChatHistorySearchData)localObject4);
          localObject2 = aieh.b(this.this$0).obtainMessage(2, localObject2);
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
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */