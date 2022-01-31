package com.tencent.biz.pubaccount.readinjoy.redpacket;

import awbw;
import awbx;
import com.tencent.qphone.base.util.QLog;

class RIJRedPacketManager$11
  implements Runnable
{
  RIJRedPacketManager$11(RIJRedPacketManager paramRIJRedPacketManager, String paramString) {}
  
  public void run()
  {
    try
    {
      awbw localawbw = RIJRedPacketManager.a(this.this$0).createEntityManager();
      RedPacketTaskData localRedPacketTaskData = new RedPacketTaskData();
      localRedPacketTaskData.rowKey = this.a;
      localRedPacketTaskData.insertTime = System.currentTimeMillis();
      localawbw.b(localRedPacketTaskData);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RIJRedPacketManager", 1, QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.11
 * JD-Core Version:    0.7.0.1
 */