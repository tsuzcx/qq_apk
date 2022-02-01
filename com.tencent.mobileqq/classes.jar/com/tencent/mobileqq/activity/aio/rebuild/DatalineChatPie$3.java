package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;

class DatalineChatPie$3
  implements Runnable
{
  DatalineChatPie$3(DatalineChatPie paramDatalineChatPie) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(0).a(true);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(1).a(true);
    if (QFileAssistantUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))
    {
      this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().putExtra("qq_sub_business_id", 110);
      this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().putExtra("enter_from", 51);
    }
    DatalineChatPie.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie.3
 * JD-Core Version:    0.7.0.1
 */