package com.tencent.mobileqq.activity.aio.rebuild;

import agrn;
import aluv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.HotChatInfo;

public class HotChatPie$8
  implements Runnable
{
  public HotChatPie$8(agrn paramagrn) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.state;
    aluv.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, i);
    aluv.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.8
 * JD-Core Version:    0.7.0.1
 */