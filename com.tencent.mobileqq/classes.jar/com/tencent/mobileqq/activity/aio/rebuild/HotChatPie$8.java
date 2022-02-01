package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatRecentUserMgr;
import com.tencent.mobileqq.data.HotChatInfo;

class HotChatPie$8
  implements Runnable
{
  HotChatPie$8(HotChatPie paramHotChatPie) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.state;
    HotChatRecentUserMgr.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, i);
    HotChatRecentUserMgr.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.8
 * JD-Core Version:    0.7.0.1
 */