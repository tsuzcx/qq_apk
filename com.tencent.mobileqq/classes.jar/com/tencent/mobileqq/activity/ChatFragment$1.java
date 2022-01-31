package com.tencent.mobileqq.activity;

import amms;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import ayzl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import mqq.app.MobileQQ;

class ChatFragment$1
  implements Runnable
{
  ChatFragment$1(ChatFragment paramChatFragment, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(amms.a, 0);
    long l = ((SharedPreferences)localObject).getLong(amms.d, 0L);
    if ((l == 0L) || (l > System.currentTimeMillis()) || (System.currentTimeMillis() - l > 14400000L)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((SharedPreferences)localObject).edit().putLong(amms.d, System.currentTimeMillis()).commit();
      }
      if (i != 0)
      {
        i = this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("entrance", 0);
        localObject = this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, this.a, i, this.b);
      }
      ayzl.b.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment.1
 * JD-Core Version:    0.7.0.1
 */