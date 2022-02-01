package com.tencent.mobileqq.app;

import anwd;
import axql;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class HotChatManager$AddHotChatInfoRunnable
  implements Runnable
{
  HotChatInfo a = null;
  
  HotChatManager$AddHotChatInfoRunnable(HotChatManager paramHotChatManager, HotChatInfo paramHotChatInfo)
  {
    this.a = paramHotChatInfo;
  }
  
  public void run()
  {
    if (this.a != null)
    {
      if (this.this$0.jdField_a_of_type_JavaUtilMap.get(String.valueOf(this.a.troopUin)) == null) {
        break label63;
      }
      if (QLog.isColorLevel()) {
        axql.a("HotChatManager", new Object[] { "AddHotChatInfoRunnable already exist", this.a.troopUin });
      }
    }
    return;
    label63:
    if (QLog.isColorLevel()) {
      axql.a("HotChatManager", new Object[] { "AddHotChatInfoRunnable", this.a.troopUin });
    }
    this.this$0.a(this.a, 4);
    ((anwd)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatManager.AddHotChatInfoRunnable
 * JD-Core Version:    0.7.0.1
 */