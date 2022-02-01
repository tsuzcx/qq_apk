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
    this.this$0.b(this.a);
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
      localObject1 = this.this$0.a(this.b, this.c);
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
      if (l > this.d + 1L) {
        bool = false;
      }
      if ((j == i) || (l <= this.d)) {
        break;
      }
      if ((k % 500 == 0) && (QLog.isColorLevel()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("dead loop warning, firstSeq: ");
        ((StringBuilder)localObject1).append(this.e);
        ((StringBuilder)localObject1).append(" seq: ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", unread: ");
        ((StringBuilder)localObject1).append(this.d);
        QLog.w("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject1).toString());
      }
      int m = (int)(l - this.d);
      j = m;
      if (this.this$0.a(this.b, this.c, m).size() != m)
      {
        j = m;
        if (m > 15) {
          j = 15;
        }
      }
      localObject1 = this.a;
      ((RefreshMessageContext)localObject1).r = j;
      ((RefreshMessageContext)localObject1).l = 0;
      this.this$0.b(this.b, this.c, j, (RefreshMessageContext)localObject1);
      j = i;
      i = k;
    }
    if ((bool) && (this.f))
    {
      localObject1 = this.this$0;
      i = this.c;
      localObject2 = this.b;
      ((BaseMessageManagerForTroopAndDisc)localObject1).a(i, (String)localObject2, this.d, ((BaseMessageManagerForTroopAndDisc)localObject1).a((String)localObject2, i));
    }
    this.a.i = bool;
    this.this$0.b.setChangeAndNotify(this.a);
    this.this$0.b.getFacadeHandler().post(new BaseMessageManagerForTroopAndDisc.5.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.5
 * JD-Core Version:    0.7.0.1
 */