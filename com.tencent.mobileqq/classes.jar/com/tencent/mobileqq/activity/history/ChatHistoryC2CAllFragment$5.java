package com.tencent.mobileqq.activity.history;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aocm;
import apdn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.TimeZone;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

class ChatHistoryC2CAllFragment$5
  implements Runnable
{
  ChatHistoryC2CAllFragment$5(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool1 = false;
    if (VipUtils.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.this$0.jdField_b_of_type_JavaLangString = "svip";
      this.this$0.c = "2";
      VipUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "vip", "0X8004FAB", "0X8004FAB", 0, 0, new String[] { this.this$0.jdField_b_of_type_JavaLangString });
    }
    for (;;)
    {
      try
      {
        localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
        if (1 == ((SharedPreferences)localObject).getInt("setting_guide_tips_flag" + this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1)) {
          continue;
        }
        localEditor = ((SharedPreferences)localObject).edit();
        j = ((SharedPreferences)localObject).getInt("setting_guide_tips_show_time" + this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
        if (!this.this$0.c.equals("2")) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        Object localObject;
        SharedPreferences.Editor localEditor;
        int j;
        boolean bool2;
        QLog.d("Q.history.C2CAllFragment", 2, "settingGuideFlag Exception: " + localException.getMessage());
        continue;
        int i = 0;
        continue;
      }
      if (i != 0) {
        localEditor.putInt("setting_guide_tips_flag" + this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
      }
      i = TimeZone.getTimeZone("GMT+8").getRawOffset();
      i = (int)Math.ceil((System.currentTimeMillis() + i) / 86400000L);
      if (j != i) {
        bool1 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.C2CAllFragment", 2, "settingGuideFlag isShow: " + bool1 + ", showDay: " + j + ", nowDay: " + i);
      }
      if (bool1)
      {
        localEditor.putInt("setting_guide_tips_show_time" + this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i).commit();
        this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10, this.this$0.jdField_b_of_type_AndroidViewView));
      }
      if (this.this$0.jdField_a_of_type_Aocm.b() == 0)
      {
        localObject = (apdn)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(59);
        if (localObject != null) {
          ((apdn)localObject).a();
        }
      }
      return;
      if (VipUtils.c(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        this.this$0.jdField_b_of_type_JavaLangString = "vip";
        this.this$0.c = "1";
        break;
      }
      this.this$0.jdField_b_of_type_JavaLangString = "notvip";
      this.this$0.c = "0";
      break;
      if (this.this$0.c.equals("1"))
      {
        if (this.this$0.jdField_a_of_type_Int < 3) {
          continue;
        }
        i = 1;
      }
      else
      {
        bool2 = this.a;
        if (!bool2) {
          continue;
        }
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.5
 * JD-Core Version:    0.7.0.1
 */