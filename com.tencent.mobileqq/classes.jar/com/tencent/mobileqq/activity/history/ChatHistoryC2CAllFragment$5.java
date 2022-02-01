package com.tencent.mobileqq.activity.history;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
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
    if (VasUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().isSVip())
    {
      localObject1 = this.this$0;
      ((ChatHistoryC2CAllFragment)localObject1).jdField_b_of_type_JavaLangString = "svip";
      ((ChatHistoryC2CAllFragment)localObject1).c = "2";
    }
    else if (VasUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().isVip())
    {
      localObject1 = this.this$0;
      ((ChatHistoryC2CAllFragment)localObject1).jdField_b_of_type_JavaLangString = "vip";
      ((ChatHistoryC2CAllFragment)localObject1).c = "1";
    }
    else
    {
      localObject1 = this.this$0;
      ((ChatHistoryC2CAllFragment)localObject1).jdField_b_of_type_JavaLangString = "notvip";
      ((ChatHistoryC2CAllFragment)localObject1).c = "0";
    }
    Object localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool = true;
    VipUtils.a((AppInterface)localObject1, "vip", "0X8004FAB", "0X8004FAB", 0, 0, new String[] { this.this$0.jdField_b_of_type_JavaLangString });
    try
    {
      localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setting_guide_tips_flag");
      ((StringBuilder)localObject1).append(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (1 == ((SharedPreferences)localObject2).getInt(((StringBuilder)localObject1).toString(), -1)) {
        break label616;
      }
      localObject1 = ((SharedPreferences)localObject2).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setting_guide_tips_show_time");
      localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      j = ((SharedPreferences)localObject2).getInt(localStringBuilder.toString(), 1);
      if (this.this$0.c.equals("2")) {
        break label658;
      }
      if (this.this$0.c.equals("1")) {
        if (this.this$0.jdField_a_of_type_Int < 3) {
          break label663;
        }
      } else {
        if (!this.a) {
          break label663;
        }
      }
    }
    catch (Exception localException)
    {
      int j;
      label415:
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("settingGuideFlag Exception: ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.d("Q.history.C2CAllFragment", 2, ((StringBuilder)localObject2).toString());
    }
    if (i != 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setting_guide_tips_flag");
      ((StringBuilder)localObject2).append(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), 1);
    }
    int i = TimeZone.getTimeZone("GMT+8").getRawOffset();
    i = (int)Math.ceil((System.currentTimeMillis() + i) / 86400000L);
    if (j != i) {
      break label415;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("settingGuideFlag isShow: ");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append(", showDay: ");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(", nowDay: ");
        ((StringBuilder)localObject2).append(i);
        QLog.d("Q.history.C2CAllFragment", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setting_guide_tips_show_time");
        ((StringBuilder)localObject2).append(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), i).commit();
        this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10, this.this$0.jdField_b_of_type_AndroidViewView));
      }
      label616:
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b() == 0)
      {
        MessageRoamHandler localMessageRoamHandler = (MessageRoamHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_ROAMMESSAGE_HANDLER);
        if (localMessageRoamHandler != null) {
          localMessageRoamHandler.a();
        }
      }
      return;
      label658:
      i = 1;
      break;
      label663:
      i = 0;
      break;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.5
 * JD-Core Version:    0.7.0.1
 */