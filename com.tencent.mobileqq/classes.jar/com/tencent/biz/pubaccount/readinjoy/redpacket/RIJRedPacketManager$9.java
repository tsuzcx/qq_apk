package com.tencent.biz.pubaccount.readinjoy.redpacket;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class RIJRedPacketManager$9
  implements Runnable
{
  RIJRedPacketManager$9(RIJRedPacketManager paramRIJRedPacketManager) {}
  
  public void run()
  {
    try
    {
      List localList = RIJRedPacketManager.a(this.this$0).createEntityManager().query(RedPacketTaskData.class, true, null, null, null, null, "insertTime desc", "500");
      ThreadManager.getUIHandler().post(new RIJRedPacketManager.9.1(this, localList));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RIJRedPacketManager", 1, QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.9
 * JD-Core Version:    0.7.0.1
 */