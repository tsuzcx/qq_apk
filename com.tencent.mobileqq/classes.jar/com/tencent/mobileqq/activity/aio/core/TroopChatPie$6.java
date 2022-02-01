package com.tencent.mobileqq.activity.aio.core;

import abwx;
import abwz;
import aezq;
import android.os.SystemClock;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class TroopChatPie$6
  implements Runnable
{
  TroopChatPie$6(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = this.this$0.app.getMessageProxy(this.this$0.sessionInfo.curType).f(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType);
    int k;
    int i;
    label92:
    int m;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (((List)localObject).size() > 3) {
        break label165;
      }
      k = ((List)localObject).size();
      Iterator localIterator = ((List)localObject).iterator();
      i = 0;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (localMessageRecord != null) {
            if (localMessageRecord.msgtype == -2058)
            {
              m = j + 1;
              j = i;
              i = m;
              label140:
              if (j < k) {
                break label183;
              }
              if (QLog.isColorLevel()) {
                QLog.i(this.this$0.tag, 2, "AIO has more than 3 normal message, so return!");
              }
            }
          }
        }
      }
    }
    label165:
    label183:
    do
    {
      do
      {
        return;
        k = 3;
        break;
        m = i + 1;
        i = j;
        j = m;
        break label140;
        m = j;
        j = i;
        i = m;
        break label92;
      } while (j <= ((List)localObject).size() / 2);
      if (QLog.isColorLevel()) {
        QLog.i(this.this$0.tag, 2, "now pull more message for troop!");
      }
      this.this$0.pullReqTime = SystemClock.uptimeMillis();
      ((aezq)this.this$0.refreshMessageContext.context).a(this.this$0.pullReqTime);
      this.this$0.refreshMessageContext.needAutoNavigateTop = abwz.c((List)localObject);
      this.this$0.refreshMessageContext.needNotifyUI = true;
    } while (this.this$0.refreshMessageContext.repullStickerMsgIndex != 0);
    localObject = this.this$0.refreshMessageContext;
    ((QQMessageFacade.RefreshMessageContext)localObject).repullStickerMsgIndex += 1;
    this.this$0.app.getMessageFacade().refreshMessageListHead(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, 15, this.this$0.refreshMessageContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.6
 * JD-Core Version:    0.7.0.1
 */