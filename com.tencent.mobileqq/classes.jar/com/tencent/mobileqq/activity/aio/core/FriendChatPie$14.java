package com.tencent.mobileqq.activity.aio.core;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.QidianHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class FriendChatPie$14
  extends QidianBusinessObserver
{
  FriendChatPie$14(FriendChatPie paramFriendChatPie) {}
  
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
    if ((paramBoolean) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramHashMap.uin)))
      {
        paramHashMap = ((QidianHelper)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(61)).a();
        if (paramHashMap != null)
        {
          this.a.a(true);
          this.a.f.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          this.a.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
          this.a.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
          this.a.a(paramHashMap);
          if (ChatActivityConstants.a) {
            this.a.f.setContentDescription(paramHashMap);
          }
          this.a.jdField_b_of_type_Boolean = true;
          return;
        }
        this.a.a(false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onGetQidianUserDetailInfo not current curFriendUin");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onGetQidianUserDetailInfo fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.14
 * JD-Core Version:    0.7.0.1
 */