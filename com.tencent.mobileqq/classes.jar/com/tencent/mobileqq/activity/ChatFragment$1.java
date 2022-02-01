package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgcache.CacheConstants;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MsgCacheStrategyReport;
import java.util.HashMap;
import mqq.app.MobileQQ;

class ChatFragment$1
  implements Runnable
{
  ChatFragment$1(ChatFragment paramChatFragment, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(CacheConstants.a, 0);
    long l = ((SharedPreferences)localObject).getLong(CacheConstants.d, 0L);
    int i;
    if ((l != 0L) && (l <= System.currentTimeMillis()) && (System.currentTimeMillis() - l <= 14400000L)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      ((SharedPreferences)localObject).edit().putLong(CacheConstants.d, System.currentTimeMillis()).commit();
    }
    if (i != 0)
    {
      i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getIntExtra("entrance", 0);
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
      MsgCacheStrategyReport.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache(), (String)localObject, this.a, i, this.b);
    }
    MessageCache.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment.1
 * JD-Core Version:    0.7.0.1
 */