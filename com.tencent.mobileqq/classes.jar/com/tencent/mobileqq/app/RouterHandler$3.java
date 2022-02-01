package com.tencent.mobileqq.app;

import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class RouterHandler$3
  implements Runnable
{
  RouterHandler$3(RouterHandler paramRouterHandler, long paramLong, MsgHeader paramMsgHeader) {}
  
  public void run()
  {
    Object localObject2 = (Session)this.this$0.e.get(Long.valueOf(this.jdField_a_of_type_Long));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.this$0.b.getEntityManagerFactory().createEntityManager();
      List localList = ((EntityManager)localObject1).rawQuery(RouterMsgRecord.class, "select * from " + RouterMsgRecord.sBasicTableName + this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader.uint64_src_uin + " where uSessionID=?", new String[] { String.valueOf(this.jdField_a_of_type_Long) });
      ((EntityManager)localObject1).close();
      if ((localList == null) || (localList.size() <= 0)) {
        break label265;
      }
      localObject1 = (RouterMsgRecord)localList.get(0);
      localObject2 = this.this$0.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, ((RouterMsgRecord)localObject1).filename, null, 0, 0, this.jdField_a_of_type_Long, 0, 0, 0);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        if (0L == ((Session)localObject2).uSessionID) {
          ((Session)localObject2).uSessionID = this.this$0.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
        }
        ((Session)localObject2).msgHeader = this.this$0.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader.uint64_src_uin);
        this.this$0.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject2, null, null);
        this.this$0.e.put(Long.valueOf(((Session)localObject2).uSessionID), localObject2);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      this.this$0.a((ArrayList)localObject2, true);
    }
    label265:
    while (!QLog.isColorLevel())
    {
      return;
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("dataline.Router", 2, "cannot find session from db and memory, sessiondi=" + this.jdField_a_of_type_Long);
      localObject1 = localObject2;
      break;
    }
    QLog.d("dataline.Router", 2, "cannot handle session, sessiondi=" + this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler.3
 * JD-Core Version:    0.7.0.1
 */