package com.tencent.imcore.message;

import android.os.Handler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class BaseMessageManagerForTroopAndDisc$5
  implements Runnable
{
  BaseMessageManagerForTroopAndDisc$5(BaseMessageManagerForTroopAndDisc paramBaseMessageManagerForTroopAndDisc, RefreshMessageContext paramRefreshMessageContext, String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.b(this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage begin");
    }
    int i = 0;
    int j = 0;
    boolean bool;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      bool = true;
      int k = i + 1;
      localObject1 = this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
          if (!MsgProxyUtils.a((MessageRecord)localObject2))
          {
            i = (int)((ChatMessage)localObject2).shmsgseq;
            break label109;
          }
        }
      }
      i = 0;
      label109:
      long l = i;
      if (l > this.jdField_a_of_type_Long + 1L) {
        bool = false;
      }
      if ((j == i) || (l <= this.jdField_a_of_type_Long)) {
        break;
      }
      if ((k % 500 == 0) && (QLog.isColorLevel()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("dead loop warning, firstSeq: ");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(" seq: ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", unread: ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
        QLog.w("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject1).toString());
      }
      int m = (int)(l - this.jdField_a_of_type_Long);
      j = m;
      if (this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, m).size() != m)
      {
        j = m;
        if (m > 15) {
          j = 15;
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext;
      ((RefreshMessageContext)localObject1).e = j;
      ((RefreshMessageContext)localObject1).jdField_a_of_type_Int = 0;
      this.this$0.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, j, (RefreshMessageContext)localObject1);
      j = i;
      i = k;
    }
    if ((bool) && (this.jdField_a_of_type_Boolean))
    {
      localObject1 = this.this$0;
      i = this.jdField_a_of_type_Int;
      localObject2 = this.jdField_a_of_type_JavaLangString;
      BaseMessageManagerForTroopAndDisc.a((BaseMessageManagerForTroopAndDisc)localObject1, i, (String)localObject2, this.jdField_a_of_type_Long, ((BaseMessageManagerForTroopAndDisc)localObject1).a((String)localObject2, i));
    }
    this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.g = bool;
    this.this$0.a.setChangeAndNotify(this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
    this.this$0.a.getFacadeHandler().post(new BaseMessageManagerForTroopAndDisc.5.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.5
 * JD-Core Version:    0.7.0.1
 */