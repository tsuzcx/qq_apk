package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChatSettingActivity$23
  extends ShieldListObserver
{
  ChatSettingActivity$23(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList)
  {
    Object localObject;
    if (!ChatSettingActivity.w(this.a))
    {
      if (QLog.isColorLevel())
      {
        paramList = this.a.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAddShieldList, mShieldByThis=");
        ((StringBuilder)localObject).append(ChatSettingActivity.w(this.a));
        QLog.d(paramList, 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.v(this.a);
    paramList = this.a;
    int i;
    if (paramBoolean) {
      i = 2131916595;
    } else {
      i = 2131916584;
    }
    QQToast.makeText(paramList, 2, paramList.getString(i), 0).show(this.a.getTitleBarHeight());
    if (QLog.isColorLevel())
    {
      paramList = this.a.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAddShieldList, isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", mShieldByThis=");
      ((StringBuilder)localObject).append(ChatSettingActivity.w(this.a));
      ((StringBuilder)localObject).append(", mShieldUin=");
      ((StringBuilder)localObject).append(ChatSettingActivity.p(this.a));
      ((StringBuilder)localObject).append(", mIsShield=");
      ((StringBuilder)localObject).append(ChatSettingActivity.h(this.a));
      QLog.d(paramList, 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      paramList = (ShieldMsgManger)this.a.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.p(this.a))))
      {
        localObject = this.a;
        ChatSettingActivity.a((ChatSettingActivity)localObject, paramList.a(ChatSettingActivity.p((ChatSettingActivity)localObject)));
      }
      ChatSettingActivity.i(this.a);
      if (ChatSettingActivity.h(this.a))
      {
        paramList = this.a;
        paramList.b = false;
        ChatSettingActivity.f(paramList);
      }
      if (QLog.isColorLevel())
      {
        paramList = this.a.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAddShieldList, mIsShield=");
        ((StringBuilder)localObject).append(ChatSettingActivity.h(this.a));
        ((StringBuilder)localObject).append(", mIsFollowed=");
        ((StringBuilder)localObject).append(this.a.b);
        QLog.d(paramList, 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void b(boolean paramBoolean, List<Long> paramList)
  {
    if (!ChatSettingActivity.w(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.v(this.a);
    paramList = this.a;
    int i;
    if (paramBoolean) {
      i = 2131916583;
    } else {
      i = 2131916582;
    }
    QQToast.makeText(paramList, 2, paramList.getString(i), 0).show(this.a.getTitleBarHeight());
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramList = this.a.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDeleteShieldList, isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d(paramList, 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      paramList = (ShieldMsgManger)this.a.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.p(this.a))))
      {
        localObject = this.a;
        ChatSettingActivity.a((ChatSettingActivity)localObject, paramList.a(ChatSettingActivity.p((ChatSettingActivity)localObject)));
      }
      if (QLog.isColorLevel())
      {
        paramList = this.a.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDeleteShieldList, mIsShield=");
        ((StringBuilder)localObject).append(ChatSettingActivity.h(this.a));
        QLog.d(paramList, 2, ((StringBuilder)localObject).toString());
      }
      ChatSettingActivity.i(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131916582, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.23
 * JD-Core Version:    0.7.0.1
 */