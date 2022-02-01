package com.tencent.mobileqq.activity;

import android.provider.Settings.System;
import bdwt;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class Conversation$DateFormatChangeRunnable
  implements Runnable
{
  private Conversation$DateFormatChangeRunnable(Conversation paramConversation) {}
  
  public void run()
  {
    Object localObject = Settings.System.getString(this.this$0.a().getContentResolver(), "date_format");
    if ((this.this$0.jdField_a_of_type_Alms != null) && (TimeManager.getInstance().setDateFormat((String)localObject)) && (this.this$0.f)) {
      this.this$0.a(1014, 0L, false);
    }
    bdwt.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(TroopAssistantActivity.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.DateFormatChangeRunnable
 * JD-Core Version:    0.7.0.1
 */