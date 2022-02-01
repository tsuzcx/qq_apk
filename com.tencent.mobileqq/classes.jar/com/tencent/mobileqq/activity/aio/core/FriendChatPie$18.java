package com.tencent.mobileqq.activity.aio.core;

import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class FriendChatPie$18
  extends QidianBusinessObserver
{
  FriendChatPie$18(FriendChatPie paramFriendChatPie) {}
  
  public void c(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
      QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.a().getString(2131698258), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.a().getString(2131698257), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public void d(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramHashMap.uin))) {
        if (this.a.jdField_a_of_type_ComTencentQidianQidianManager == null) {
          break label260;
        }
      }
    }
    label260:
    for (paramHashMap = this.a.jdField_a_of_type_ComTencentQidianQidianManager.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);; paramHashMap = null)
    {
      if (paramHashMap != null)
      {
        this.a.b(true);
        this.a.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.a.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.a.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.a.jdField_f_of_type_JavaLangString = paramHashMap;
        this.a.c(paramHashMap);
        if (ChatActivityConstants.a) {
          this.a.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(paramHashMap);
        }
        this.a.jdField_b_of_type_Boolean = true;
      }
      do
      {
        do
        {
          return;
          this.a.b(false);
          return;
        } while (!QLog.isColorLevel());
        QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onGetQidianUserDetailInfo not current curFriendUin");
        return;
      } while (!QLog.isColorLevel());
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onGetQidianUserDetailInfo fail");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.18
 * JD-Core Version:    0.7.0.1
 */