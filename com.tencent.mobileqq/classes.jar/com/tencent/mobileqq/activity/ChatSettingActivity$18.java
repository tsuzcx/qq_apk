package com.tencent.mobileqq.activity;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ChatSettingActivity$18
  extends MqqHandler
{
  ChatSettingActivity$18(ChatSettingActivity paramChatSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    if (j != 18)
    {
      if (j != 16711681)
      {
        boolean bool3 = false;
        boolean bool1 = false;
        int i = 0;
        boolean bool2 = true;
        Object localObject;
        switch (j)
        {
        default: 
          return;
        case 37: 
          localObject = (String)paramMessage.obj;
          if ((this.a.p == null) || (!((String)localObject).equals(ChatSettingActivity.a(this.a)))) {
            break;
          }
          if (paramMessage.arg1 == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (bool1 == this.a.p.a()) {
            break;
          }
          this.a.p.setOnCheckedChangeListener(null);
          localObject = this.a.p;
          if (paramMessage.arg1 == 1) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          ((FormSwitchItem)localObject).setChecked(bool1);
          this.a.a();
          paramMessage = this.a.n;
          if ((this.a.p.a()) || (this.a.q.a())) {
            i = 8;
          }
          paramMessage.setVisibility(i);
          this.a.p.setOnCheckedChangeListener(this.a);
          return;
        case 36: 
          localObject = (String)paramMessage.obj;
          if ((this.a.n == null) || (!((String)localObject).equals(ChatSettingActivity.a(this.a)))) {
            break;
          }
          if (paramMessage.arg1 == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (bool1 == this.a.n.a()) {
            break;
          }
          this.a.n.setOnCheckedChangeListener(null);
          localObject = this.a.n;
          bool1 = bool3;
          if (paramMessage.arg1 == 1) {
            bool1 = true;
          }
          ((FormSwitchItem)localObject).setChecked(bool1);
          this.a.a();
          this.a.n.setOnCheckedChangeListener(this.a);
          return;
        case 35: 
          if (!((String)paramMessage.obj).equals(ChatSettingActivity.a(this.a))) {
            break;
          }
          bool1 = FriendsStatusUtil.a(this.a.app, ChatSettingActivity.a(this.a), ChatSettingActivity.n(this.a));
          if ((this.a.s == null) || (bool1 == this.a.s.a())) {
            break;
          }
          this.a.s.setOnCheckedChangeListener(null);
          this.a.s.setChecked(bool1);
          this.a.s.setOnCheckedChangeListener(this.a);
          return;
        case 34: 
          ChatSettingActivity.s(this.a);
          return;
        case 33: 
          ChatSettingActivity.r(this.a);
          return;
        case 32: 
          StringBuilder localStringBuilder;
          if ((ChatSettingActivity.n(this.a) != 1001) && (ChatSettingActivity.n(this.a) != 10002))
          {
            if (ChatSettingActivity.n(this.a) == 1006) {
              if (TextUtils.isEmpty(ChatSettingActivity.o(this.a)))
              {
                ChatSettingActivity.b(this.a, false);
              }
              else
              {
                paramMessage = ContactUtils.b(this.a.app, ChatSettingActivity.o(this.a));
                if (TextUtils.isEmpty(paramMessage))
                {
                  ChatSettingActivity.b(this.a, false);
                }
                else
                {
                  ChatSettingActivity.b(this.a, true);
                  ChatSettingActivity.d(this.a, paramMessage);
                }
              }
            }
            paramMessage = (ShieldMsgManger)this.a.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
            if ((paramMessage != null) && (!TextUtils.isEmpty(ChatSettingActivity.p(this.a))))
            {
              localObject = this.a;
              ChatSettingActivity.a((ChatSettingActivity)localObject, paramMessage.a(ChatSettingActivity.p((ChatSettingActivity)localObject)));
            }
            if (QLog.isColorLevel())
            {
              localObject = this.a.a;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("handleMessage, shieldMsgManger=");
              if (paramMessage == null) {
                bool1 = true;
              }
              localStringBuilder.append(bool1);
              QLog.d((String)localObject, 2, localStringBuilder.toString());
            }
          }
          else
          {
            paramMessage = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (paramMessage != null)
            {
              paramMessage = paramMessage.m(ChatSettingActivity.p(this.a));
              if (QLog.isColorLevel())
              {
                localObject = this.a.a;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("handleMessage, f=");
                if (paramMessage == null) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
                localStringBuilder.append(bool1);
                QLog.d((String)localObject, 2, localStringBuilder.toString());
              }
              if ((paramMessage != null) && (paramMessage.groupid == -1002)) {
                ChatSettingActivity.a(this.a, true);
              } else {
                ChatSettingActivity.a(this.a, false);
              }
            }
          }
          if (QLog.isColorLevel())
          {
            paramMessage = this.a.a;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleMessage, REFRESH_STRANGER_SHIELD_BUTTON, mIsShield=");
            ((StringBuilder)localObject).append(ChatSettingActivity.h(this.a));
            ((StringBuilder)localObject).append(", mIsFollowed=");
            ((StringBuilder)localObject).append(this.a.b);
            ((StringBuilder)localObject).append(", mShieldEnable=");
            ((StringBuilder)localObject).append(ChatSettingActivity.q(this.a));
            QLog.d(paramMessage, 2, ((StringBuilder)localObject).toString());
          }
          ChatSettingActivity.i(this.a);
          return;
        }
      }
      else if (ChatSettingActivity.n(this.a) == 0)
      {
        paramMessage = (String)paramMessage.obj;
        if ((ChatSettingActivity.a(this.a) != null) && (paramMessage != null) && (ChatSettingActivity.a(this.a).equals(paramMessage))) {
          this.a.finish();
        }
      }
    }
    else
    {
      paramMessage = (String)paramMessage.obj;
      ChatSettingActivity.c(this.a, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.18
 * JD-Core Version:    0.7.0.1
 */