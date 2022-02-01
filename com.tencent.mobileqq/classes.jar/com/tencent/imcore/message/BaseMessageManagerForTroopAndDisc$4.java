package com.tencent.imcore.message;

import android.os.Handler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class BaseMessageManagerForTroopAndDisc$4
  implements Runnable
{
  BaseMessageManagerForTroopAndDisc$4(BaseMessageManagerForTroopAndDisc paramBaseMessageManagerForTroopAndDisc, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.b(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage begin");
    }
    int k = 0;
    int j = 0;
    k += 1;
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    ChatMessage localChatMessage;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
      } while (MsgProxyUtils.a(localChatMessage));
    }
    for (int i = (int)localChatMessage.shmsgseq;; i = 0)
    {
      if (i <= this.jdField_a_of_type_Long + 1L) {}
      for (boolean bool = true; (j == i) || (i <= this.jdField_a_of_type_Long); bool = false)
      {
        if ((bool) && (this.jdField_a_of_type_Boolean)) {
          BaseMessageManagerForTroopAndDisc.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int));
        }
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.g = bool;
        this.this$0.a.a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
        this.this$0.a.a.post(new BaseMessageManagerForTroopAndDisc.4.1(this));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage end");
        }
        return;
      }
      if ((k % 500 == 0) && (QLog.isColorLevel())) {
        QLog.w("Q.msg.BaseMessageManager", 2, "dead loop warning, firstSeq: " + this.b + " seq: " + i + ", unread: " + this.jdField_a_of_type_Long);
      }
      int m = (int)(i - this.jdField_a_of_type_Long);
      j = m;
      if (this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, m).size() != m)
      {
        j = m;
        if (m > 15) {
          j = 15;
        }
      }
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.e = j;
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Int = 0;
      this.this$0.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, j, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
      j = i;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.4
 * JD-Core Version:    0.7.0.1
 */