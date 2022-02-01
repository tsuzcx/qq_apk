package com.tencent.mobileqq.activity.aio.rebuild;

import aibs;
import aoep;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class HotChatPie$10
  implements Runnable
{
  public HotChatPie$10(aibs paramaibs) {}
  
  public void run()
  {
    aoep localaoep = (aoep)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localaoep != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.tag + "Q.hotchat.aio_post_red_point", 2, "send_oidb_0x8c9_2");
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(1105933138L));
      localaoep.a(this.this$0.sessionInfo.curFriendUin, localArrayList, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.10
 * JD-Core Version:    0.7.0.1
 */