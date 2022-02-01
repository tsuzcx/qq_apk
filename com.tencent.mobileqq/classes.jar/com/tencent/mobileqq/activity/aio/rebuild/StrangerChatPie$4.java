package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AddFriendHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.StrangerQidianHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class StrangerChatPie$4
  extends QidianBusinessObserver
{
  StrangerChatPie$4(StrangerChatPie paramStrangerChatPie) {}
  
  protected void c(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.a().getString(2131698323), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.a().getString(2131698322), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  protected void d(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024)) && (paramBoolean) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramHashMap.uin)))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 1025;
        }
        paramHashMap = ((StrangerQidianHelper)StrangerChatPie.a(this.a).a(61)).a();
        if (paramHashMap != null)
        {
          StrangerChatPie.a(this.a, true);
          this.a.f.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          StrangerChatPie.a(this.a).setOnClickListener(null);
          StrangerChatPie.b(this.a).setOnClickListener(null);
          this.a.f.setText(paramHashMap);
          if (ChatActivityConstants.a) {
            this.a.f.setContentDescription(paramHashMap);
          }
          StrangerChatPie.a(this.a, true);
        }
        else
        {
          StrangerChatPie.b(this.a, false);
        }
        ((AddFriendHelper)StrangerChatPie.b(this.a).a(113)).e();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, "onGetQidianUserDetailInfo not current curFriendUin");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.a.b, 2, "onGetQidianUserDetailInfo fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie.4
 * JD-Core Version:    0.7.0.1
 */