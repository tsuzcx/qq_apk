package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.os.SystemClock;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class TroopListUI$2
  implements Runnable
{
  TroopListUI$2(TroopListUI paramTroopListUI) {}
  
  public void run()
  {
    BaseSessionInfo localBaseSessionInfo = this.this$0.b.O();
    Object localObject = this.this$0.b.a().getMessageProxy(localBaseSessionInfo.a).g(localBaseSessionInfo.b, localBaseSessionInfo.a);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int j = ((List)localObject).size();
      int i = 3;
      if (j <= 3) {
        i = ((List)localObject).size();
      }
      Iterator localIterator = ((List)localObject).iterator();
      int k = 0;
      j = 0;
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord != null)
        {
          int m;
          if (localMessageRecord.msgtype == -2058)
          {
            k += 1;
            m = j;
          }
          else
          {
            m = j + 1;
          }
          j = m;
          if (m >= i)
          {
            if (QLog.isColorLevel()) {
              QLog.i("TroopListUI", 2, "AIO has more than 3 normal message, so return!");
            }
            return;
          }
        }
      }
      if (k > ((List)localObject).size() / 2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopListUI", 2, "now pull more message for troop!");
        }
        this.this$0.i = SystemClock.uptimeMillis();
        ((ChatContext)this.this$0.h.a).a(this.this$0.i);
        this.this$0.h.g = UinTypeUtil.a((List)localObject);
        this.this$0.h.h = true;
        if (this.this$0.h.n == 0)
        {
          localObject = this.this$0.h;
          ((RefreshMessageContext)localObject).n += 1;
          this.this$0.b.a().getMessageFacade().a(localBaseSessionInfo.b, localBaseSessionInfo.a, 15, this.this$0.h);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI.2
 * JD-Core Version:    0.7.0.1
 */