package com.tencent.mobileqq.activity.aio.rebuild;

import aefe;
import ajtg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class HotChatPie$13
  implements Runnable
{
  public HotChatPie$13(aefe paramaefe) {}
  
  public void run()
  {
    ajtg localajtg = (ajtg)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localajtg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.jdField_a_of_type_JavaLangString + "Q.hotchat.aio_post_red_point", 2, "send_oidb_0x8c9_2");
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(1105933138L));
      localajtg.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.13
 * JD-Core Version:    0.7.0.1
 */