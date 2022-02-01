package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChatSettingActivity$22
  extends ShieldListObserver
{
  ChatSettingActivity$22(ChatSettingActivity paramChatSettingActivity) {}
  
  public void a(boolean paramBoolean, List<Long> paramList)
  {
    if (!ChatSettingActivity.d(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onAddShieldList, mShieldByThis=" + ChatSettingActivity.d(this.a));
      }
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.g(this.a);
    paramList = this.a;
    ChatSettingActivity localChatSettingActivity = this.a;
    if (paramBoolean) {}
    for (int i = 2131719341;; i = 2131719330)
    {
      QQToast.a(paramList, 2, localChatSettingActivity.getString(i), 0).b(this.a.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onAddShieldList, isSuccess=" + paramBoolean + ", mShieldByThis=" + ChatSettingActivity.d(this.a) + ", mShieldUin=" + ChatSettingActivity.e(this.a) + ", mIsShield=" + ChatSettingActivity.a(this.a));
      }
      if (!paramBoolean) {
        break;
      }
      paramList = (ShieldMsgManger)this.a.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.e(this.a)))) {
        ChatSettingActivity.a(this.a, paramList.a(ChatSettingActivity.e(this.a)));
      }
      ChatSettingActivity.b(this.a);
      if (ChatSettingActivity.a(this.a))
      {
        this.a.jdField_a_of_type_Boolean = false;
        ChatSettingActivity.a(this.a);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onAddShieldList, mIsShield=" + ChatSettingActivity.a(this.a) + ", mIsFollowed=" + this.a.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  public void b(boolean paramBoolean, List<Long> paramList)
  {
    if (!ChatSettingActivity.d(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.g(this.a);
    paramList = this.a;
    ChatSettingActivity localChatSettingActivity = this.a;
    if (paramBoolean) {}
    for (int i = 2131719329;; i = 2131719328)
    {
      QQToast.a(paramList, 2, localChatSettingActivity.getString(i), 0).b(this.a.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onDeleteShieldList, isSuccess=" + paramBoolean);
      }
      if (!paramBoolean) {
        break;
      }
      paramList = (ShieldMsgManger)this.a.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.e(this.a)))) {
        ChatSettingActivity.a(this.a, paramList.a(ChatSettingActivity.e(this.a)));
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onDeleteShieldList, mIsShield=" + ChatSettingActivity.a(this.a));
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131719328, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.22
 * JD-Core Version:    0.7.0.1
 */