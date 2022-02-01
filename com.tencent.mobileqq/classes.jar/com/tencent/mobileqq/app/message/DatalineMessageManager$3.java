package com.tencent.mobileqq.app.message;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.Map;

class DatalineMessageManager$3
  implements Runnable
{
  DatalineMessageManager$3(DatalineMessageManager paramDatalineMessageManager, DataLineMsgSet paramDataLineMsgSet) {}
  
  public void run()
  {
    if (this.this$0.a().b(this.a) > 0)
    {
      Object localObject1 = UinTypeUtil.a(String.valueOf(this.this$0.c), this.this$0.d);
      boolean bool2 = this.this$0.b.a.containsKey(localObject1);
      boolean bool1 = false;
      int i;
      if (bool2)
      {
        bool1 = ((Message)this.this$0.b.a.get(localObject1)).hasReply;
        i = ((Message)this.this$0.b.a.get(localObject1)).counter;
        this.this$0.b.a.remove(localObject1);
      }
      else
      {
        i = 0;
      }
      long l = this.this$0.a().a().size();
      if (l > 0L)
      {
        localObject2 = this.this$0.a().c();
        localObject1 = localObject2;
        if (localObject2 != null) {
          if ((((DataLineMsgRecord)localObject2).msgtype != -5000) && (((DataLineMsgRecord)localObject2).msgtype != -5041))
          {
            localObject1 = localObject2;
            if (((DataLineMsgRecord)localObject2).msgtype != -2073) {}
          }
          else
          {
            localObject1 = localObject2;
            if (l > 1L) {
              localObject1 = this.this$0.a().a().get((int)(l - 2L)).getLastItem();
            }
          }
        }
        localObject2 = new Message();
        if (localObject1 != null)
        {
          MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject2, (MessageRecord)localObject1);
          ((Message)localObject2).emoRecentMsg = null;
          ((Message)localObject2).counter = i;
          ((Message)localObject2).hasReply = bool1;
          this.this$0.b.a((Message)localObject2);
          this.this$0.b.a.put(UinTypeUtil.a(String.valueOf(this.this$0.c), this.this$0.d), localObject2);
        }
      }
      Object localObject2 = this.this$0.a.getProxyManager().g();
      localObject1 = this.this$0.a.getEntityManagerFactory().createEntityManager();
      localObject2 = ((RecentUserProxy)localObject2).b(String.valueOf(this.this$0.c), this.this$0.d);
      ((EntityManager)localObject1).close();
      if (localObject2 != null) {
        this.this$0.b.a(localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DatalineMessageManager.3
 * JD-Core Version:    0.7.0.1
 */