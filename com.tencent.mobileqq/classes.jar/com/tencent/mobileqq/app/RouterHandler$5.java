package com.tencent.mobileqq.app;

import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.data.RouterMsgRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class RouterHandler$5
  implements Runnable
{
  RouterHandler$5(RouterHandler paramRouterHandler, long paramLong) {}
  
  public void run()
  {
    Object localObject1 = (Session)this.this$0.o.get(Long.valueOf(this.a));
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      Iterator localIterator = this.this$0.l.iterator();
      RouterMsgRecord localRouterMsgRecord;
      do
      {
        do
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localRouterMsgRecord = (RouterMsgRecord)localIterator.next();
        } while (localRouterMsgRecord.uSessionID != this.a);
        localObject2 = this.this$0.k.genSession(0, localRouterMsgRecord.filename, null, DataLineHandler.c(localRouterMsgRecord.msgtype), 0, this.a, 0, 0, 0);
        localObject1 = localObject2;
      } while (localObject2 == null);
      if (0L == ((Session)localObject2).uSessionID) {
        ((Session)localObject2).uSessionID = this.this$0.j.generateSessionID(0);
      }
      ((Session)localObject2).msgHeader = this.this$0.k.msgHeader(localRouterMsgRecord.peerDin);
      this.this$0.k.fillService((Session)localObject2, this.this$0.h, null);
      this.this$0.o.put(Long.valueOf(this.a), localObject2);
      this.this$0.m.put(Long.valueOf(localRouterMsgRecord.uSessionID), localRouterMsgRecord);
    }
    this.this$0.a(0, (Session)localObject2, 0.0D, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler.5
 * JD-Core Version:    0.7.0.1
 */