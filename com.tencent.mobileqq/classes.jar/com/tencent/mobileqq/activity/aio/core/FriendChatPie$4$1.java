package com.tencent.mobileqq.activity.aio.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import mqq.os.MqqHandler;

class FriendChatPie$4$1
  implements Runnable
{
  FriendChatPie$4$1(FriendChatPie.4 param4) {}
  
  public void run()
  {
    Message localMessage = this.a.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    this.a.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    SharedPreUtils.a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).edit().putBoolean("aio_jump_lightalk_red_dot", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.4.1
 * JD-Core Version:    0.7.0.1
 */