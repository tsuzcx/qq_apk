package com.tencent.mobileqq.app;

import ansr;
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
    Object localObject1 = (Session)this.this$0.e.get(Long.valueOf(this.a));
    Object localObject2;
    if (localObject1 == null)
    {
      Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
      localObject2 = localObject1;
      if (localIterator.hasNext())
      {
        RouterMsgRecord localRouterMsgRecord = (RouterMsgRecord)localIterator.next();
        if (localRouterMsgRecord.uSessionID != this.a) {
          break label225;
        }
        localObject2 = this.this$0.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, localRouterMsgRecord.filename, null, ansr.b(localRouterMsgRecord.msgtype), 0, this.a, 0, 0, 0);
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label225;
        }
        if (0L == ((Session)localObject2).uSessionID) {
          ((Session)localObject2).uSessionID = this.this$0.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
        }
        ((Session)localObject2).msgHeader = this.this$0.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(localRouterMsgRecord.peerDin);
        this.this$0.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject2, this.this$0.jdField_a_of_type_JavaLangString, null);
        this.this$0.e.put(Long.valueOf(this.a), localObject2);
        this.this$0.d.put(Long.valueOf(localRouterMsgRecord.uSessionID), localRouterMsgRecord);
      }
    }
    for (;;)
    {
      this.this$0.a(0, (Session)localObject2, 0.0D, 0);
      return;
      label225:
      break;
      localObject2 = localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler.5
 * JD-Core Version:    0.7.0.1
 */