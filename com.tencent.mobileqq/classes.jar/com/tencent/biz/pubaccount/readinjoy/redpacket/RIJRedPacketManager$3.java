package com.tencent.biz.pubaccount.readinjoy.redpacket;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import qrf;

class RIJRedPacketManager$3
  implements Runnable
{
  RIJRedPacketManager$3(RIJRedPacketManager paramRIJRedPacketManager, String paramString, qrf paramqrf) {}
  
  public void run()
  {
    try
    {
      List localList = RIJRedPacketManager.a(this.this$0).createEntityManager().query(RedPacketTaskData.class, true, "rowKey=?", new String[] { this.jdField_a_of_type_JavaLangString }, null, null, null, null);
      ThreadManager.getUIHandler().post(new RIJRedPacketManager.3.1(this, localList));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RIJRedPacketManager", 1, QLog.getStackTraceString(localException));
      ThreadManager.getUIHandler().post(new RIJRedPacketManager.3.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.3
 * JD-Core Version:    0.7.0.1
 */