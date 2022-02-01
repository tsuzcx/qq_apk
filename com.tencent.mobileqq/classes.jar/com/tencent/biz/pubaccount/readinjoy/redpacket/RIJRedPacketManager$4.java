package com.tencent.biz.pubaccount.readinjoy.redpacket;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

class RIJRedPacketManager$4
  implements Runnable
{
  RIJRedPacketManager$4(RIJRedPacketManager paramRIJRedPacketManager, String paramString) {}
  
  public void run()
  {
    try
    {
      EntityManager localEntityManager = RIJRedPacketManager.a(this.this$0).createEntityManager();
      RedPacketTaskData localRedPacketTaskData = new RedPacketTaskData();
      localRedPacketTaskData.rowKey = this.a;
      localRedPacketTaskData.insertTime = System.currentTimeMillis();
      localEntityManager.persistOrReplace(localRedPacketTaskData);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RIJRedPacketManager", 1, QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.4
 * JD-Core Version:    0.7.0.1
 */