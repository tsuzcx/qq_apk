package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class LimitChatPie$16
  implements View.OnClickListener
{
  LimitChatPie$16(LimitChatPie paramLimitChatPie) {}
  
  public void onClick(View paramView)
  {
    if (!LimitChatPie.e(this.a)) {
      if (LimitChatPie.a(this.a) == null)
      {
        LimitChatPie.e(this.a);
        QLog.e(this.a.b, 2, "onClick mExtendFriendUserInfo IS null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((ExtendFriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f())
      {
        if ((!LimitChatPie.a(this.a).enableQQCall) && (LimitChatPie.g(this.a) != 5))
        {
          LimitChatPie.e(this.a);
          QLog.e(this.a.b, 2, "onClick mExtendFriendUserInfo enableQQCall false" + LimitChatPie.a(this.a).tagID);
        }
      }
      else if ((!LimitChatPie.a(this.a).enableQQCall) && (LimitChatPie.a(this.a).tagID != 10000))
      {
        LimitChatPie.e(this.a);
        QLog.e(this.a.b, 2, "onClick mExtendFriendUserInfo enableQQCall false" + LimitChatPie.a(this.a).tagID);
        continue;
      }
      com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
      HashMap localHashMap = new HashMap();
      localHashMap.put("chat_id", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ExpandReportUtils.a("click#chat_page#voice_frequency", true, -1L, -1L, localHashMap, true, true);
      PlusPanelUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, null);
      if (LimitChatPie.a(this.a) != null) {
        if (LimitChatPie.a(this.a).tagID == 1) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD92", "0X800AD92", 1, 0, "", "", "", "");
        } else {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD92", "0X800AD92", 2, 0, "", "", LimitChatPie.a(this.a).tagName, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.16
 * JD-Core Version:    0.7.0.1
 */