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

class ChatSettingActivity$17
  extends MqqHandler
{
  ChatSettingActivity$17(ChatSettingActivity paramChatSettingActivity) {}
  
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
          if ((this.a.b == null) || (!((String)localObject).equals(ChatSettingActivity.a(this.a)))) {
            break;
          }
          if (paramMessage.arg1 == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (bool1 == this.a.b.a()) {
            break;
          }
          this.a.b.setOnCheckedChangeListener(null);
          localObject = this.a.b;
          if (paramMessage.arg1 == 1) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          ((FormSwitchItem)localObject).setChecked(bool1);
          this.a.a();
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
          if ((this.a.b.a()) || (this.a.c.a())) {
            i = 8;
          }
          paramMessage.setVisibility(i);
          this.a.b.setOnCheckedChangeListener(this.a);
          return;
        case 36: 
          localObject = (String)paramMessage.obj;
          if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (!((String)localObject).equals(ChatSettingActivity.a(this.a)))) {
            break;
          }
          if (paramMessage.arg1 == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (bool1 == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
          localObject = this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
          bool1 = bool3;
          if (paramMessage.arg1 == 1) {
            bool1 = true;
          }
          ((FormSwitchItem)localObject).setChecked(bool1);
          this.a.a();
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.a);
          return;
        case 35: 
          if (!((String)paramMessage.obj).equals(ChatSettingActivity.a(this.a))) {
            break;
          }
          bool1 = FriendsStatusUtil.a(this.a.app, ChatSettingActivity.a(this.a), ChatSettingActivity.a(this.a));
          if ((this.a.e == null) || (bool1 == this.a.e.a())) {
            break;
          }
          this.a.e.setOnCheckedChangeListener(null);
          this.a.e.setChecked(bool1);
          this.a.e.setOnCheckedChangeListener(this.a);
          return;
        case 34: 
          ChatSettingActivity.f(this.a);
          return;
        case 33: 
          ChatSettingActivity.e(this.a);
          return;
        case 32: 
          StringBuilder localStringBuilder;
          if ((ChatSettingActivity.a(this.a) != 1001) && (ChatSettingActivity.a(this.a) != 10002))
          {
            if (ChatSettingActivity.a(this.a) == 1006) {
              if (TextUtils.isEmpty(ChatSettingActivity.d(this.a)))
              {
                ChatSettingActivity.b(this.a, false);
              }
              else
              {
                paramMessage = ContactUtils.b(this.a.app, ChatSettingActivity.d(this.a));
                if (TextUtils.isEmpty(paramMessage))
                {
                  ChatSettingActivity.b(this.a, false);
                }
                else
                {
                  ChatSettingActivity.b(this.a, true);
                  ChatSettingActivity.b(this.a, paramMessage);
                }
              }
            }
            paramMessage = (ShieldMsgManger)this.a.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
            if ((paramMessage != null) && (!TextUtils.isEmpty(ChatSettingActivity.e(this.a))))
            {
              localObject = this.a;
              ChatSettingActivity.a((ChatSettingActivity)localObject, paramMessage.a(ChatSettingActivity.e((ChatSettingActivity)localObject)));
            }
            if (QLog.isColorLevel())
            {
              localObject = this.a.jdField_a_of_type_JavaLangString;
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
              paramMessage = paramMessage.e(ChatSettingActivity.e(this.a));
              if (QLog.isColorLevel())
              {
                localObject = this.a.jdField_a_of_type_JavaLangString;
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
            paramMessage = this.a.jdField_a_of_type_JavaLangString;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleMessage, REFRESH_STRANGER_SHIELD_BUTTON, mIsShield=");
            ((StringBuilder)localObject).append(ChatSettingActivity.a(this.a));
            ((StringBuilder)localObject).append(", mIsFollowed=");
            ((StringBuilder)localObject).append(this.a.jdField_a_of_type_Boolean);
            ((StringBuilder)localObject).append(", mShieldEnable=");
            ((StringBuilder)localObject).append(ChatSettingActivity.c(this.a));
            QLog.d(paramMessage, 2, ((StringBuilder)localObject).toString());
          }
          ChatSettingActivity.b(this.a);
          return;
        }
      }
      else if (ChatSettingActivity.a(this.a) == 0)
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
      ChatSettingActivity.a(this.a, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.17
 * JD-Core Version:    0.7.0.1
 */