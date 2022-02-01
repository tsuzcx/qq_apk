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
  
  protected void a(boolean paramBoolean, List<Long> paramList)
  {
    Object localObject;
    if (!ChatSettingActivity.d(this.a))
    {
      if (QLog.isColorLevel())
      {
        paramList = this.a.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAddShieldList, mShieldByThis=");
        ((StringBuilder)localObject).append(ChatSettingActivity.d(this.a));
        QLog.d(paramList, 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.g(this.a);
    paramList = this.a;
    int i;
    if (paramBoolean) {
      i = 2131719059;
    } else {
      i = 2131719048;
    }
    QQToast.a(paramList, 2, paramList.getString(i), 0).b(this.a.getTitleBarHeight());
    if (QLog.isColorLevel())
    {
      paramList = this.a.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAddShieldList, isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", mShieldByThis=");
      ((StringBuilder)localObject).append(ChatSettingActivity.d(this.a));
      ((StringBuilder)localObject).append(", mShieldUin=");
      ((StringBuilder)localObject).append(ChatSettingActivity.e(this.a));
      ((StringBuilder)localObject).append(", mIsShield=");
      ((StringBuilder)localObject).append(ChatSettingActivity.a(this.a));
      QLog.d(paramList, 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      paramList = (ShieldMsgManger)this.a.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.e(this.a))))
      {
        localObject = this.a;
        ChatSettingActivity.a((ChatSettingActivity)localObject, paramList.a(ChatSettingActivity.e((ChatSettingActivity)localObject)));
      }
      ChatSettingActivity.b(this.a);
      if (ChatSettingActivity.a(this.a))
      {
        paramList = this.a;
        paramList.jdField_a_of_type_Boolean = false;
        ChatSettingActivity.a(paramList);
      }
      if (QLog.isColorLevel())
      {
        paramList = this.a.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAddShieldList, mIsShield=");
        ((StringBuilder)localObject).append(ChatSettingActivity.a(this.a));
        ((StringBuilder)localObject).append(", mIsFollowed=");
        ((StringBuilder)localObject).append(this.a.jdField_a_of_type_Boolean);
        QLog.d(paramList, 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void b(boolean paramBoolean, List<Long> paramList)
  {
    if (!ChatSettingActivity.d(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.g(this.a);
    paramList = this.a;
    int i;
    if (paramBoolean) {
      i = 2131719047;
    } else {
      i = 2131719046;
    }
    QQToast.a(paramList, 2, paramList.getString(i), 0).b(this.a.getTitleBarHeight());
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramList = this.a.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDeleteShieldList, isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d(paramList, 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      paramList = (ShieldMsgManger)this.a.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.e(this.a))))
      {
        localObject = this.a;
        ChatSettingActivity.a((ChatSettingActivity)localObject, paramList.a(ChatSettingActivity.e((ChatSettingActivity)localObject)));
      }
      if (QLog.isColorLevel())
      {
        paramList = this.a.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDeleteShieldList, mIsShield=");
        ((StringBuilder)localObject).append(ChatSettingActivity.a(this.a));
        QLog.d(paramList, 2, ((StringBuilder)localObject).toString());
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131719046, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.22
 * JD-Core Version:    0.7.0.1
 */