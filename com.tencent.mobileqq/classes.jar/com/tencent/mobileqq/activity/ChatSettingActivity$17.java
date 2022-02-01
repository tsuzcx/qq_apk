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
    int i = 0;
    boolean bool3 = true;
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    }
    Object localObject;
    boolean bool1;
    label309:
    label462:
    label759:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramMessage = (String)paramMessage.obj;
                ChatSettingActivity.a(this.a, paramMessage);
                return;
              } while (ChatSettingActivity.a(this.a) != 0);
              paramMessage = (String)paramMessage.obj;
            } while ((ChatSettingActivity.a(this.a) == null) || (paramMessage == null) || (!ChatSettingActivity.a(this.a).equals(paramMessage)));
            this.a.finish();
            return;
            StringBuilder localStringBuilder;
            if ((ChatSettingActivity.a(this.a) != 1001) && (ChatSettingActivity.a(this.a) != 10002)) {
              if (ChatSettingActivity.a(this.a) == 1006)
              {
                if (TextUtils.isEmpty(ChatSettingActivity.d(this.a))) {
                  ChatSettingActivity.b(this.a, false);
                }
              }
              else
              {
                paramMessage = (ShieldMsgManger)this.a.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
                if ((paramMessage != null) && (!TextUtils.isEmpty(ChatSettingActivity.e(this.a)))) {
                  ChatSettingActivity.a(this.a, paramMessage.a(ChatSettingActivity.e(this.a)));
                }
                if (QLog.isColorLevel())
                {
                  localObject = this.a.jdField_a_of_type_JavaLangString;
                  localStringBuilder = new StringBuilder().append("handleMessage, shieldMsgManger=");
                  if (paramMessage != null) {
                    break label462;
                  }
                  bool1 = true;
                  QLog.d((String)localObject, 2, bool1);
                }
              }
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "handleMessage, REFRESH_STRANGER_SHIELD_BUTTON, mIsShield=" + ChatSettingActivity.a(this.a) + ", mIsFollowed=" + this.a.jdField_a_of_type_Boolean + ", mShieldEnable=" + ChatSettingActivity.c(this.a));
              }
              ChatSettingActivity.b(this.a);
              return;
              paramMessage = ContactUtils.e(this.a.app, ChatSettingActivity.d(this.a));
              if (TextUtils.isEmpty(paramMessage))
              {
                ChatSettingActivity.b(this.a, false);
                break;
              }
              ChatSettingActivity.b(this.a, true);
              ChatSettingActivity.b(this.a, paramMessage);
              break;
              bool1 = false;
              break label309;
              paramMessage = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
              if (paramMessage != null)
              {
                paramMessage = paramMessage.e(ChatSettingActivity.e(this.a));
                if (QLog.isColorLevel())
                {
                  localObject = this.a.jdField_a_of_type_JavaLangString;
                  localStringBuilder = new StringBuilder().append("handleMessage, f=");
                  if (paramMessage != null) {
                    break label576;
                  }
                }
                for (bool1 = true;; bool1 = false)
                {
                  QLog.d((String)localObject, 2, bool1);
                  if ((paramMessage == null) || (paramMessage.groupid != -1002)) {
                    break label581;
                  }
                  ChatSettingActivity.a(this.a, true);
                  break;
                }
                ChatSettingActivity.a(this.a, false);
              }
            }
            ChatSettingActivity.e(this.a);
            return;
            ChatSettingActivity.f(this.a);
            return;
          } while (!((String)paramMessage.obj).equals(ChatSettingActivity.a(this.a)));
          bool1 = FriendsStatusUtil.a(this.a.app, ChatSettingActivity.a(this.a), ChatSettingActivity.a(this.a));
        } while ((this.a.e == null) || (bool1 == this.a.e.a()));
        this.a.e.setOnCheckedChangeListener(null);
        this.a.e.setChecked(bool1);
        this.a.e.setOnCheckedChangeListener(this.a);
        return;
        localObject = (String)paramMessage.obj;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (!((String)localObject).equals(ChatSettingActivity.a(this.a))));
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        if (bool1 == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
          break label835;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (paramMessage.arg1 != 1) {
          break label837;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        ((FormSwitchItem)localObject).setChecked(bool1);
        this.a.a();
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.a);
        return;
        bool1 = false;
        break label759;
        break;
      }
      localObject = (String)paramMessage.obj;
    } while ((this.a.b == null) || (!((String)localObject).equals(ChatSettingActivity.a(this.a))));
    label576:
    label581:
    if (paramMessage.arg1 == 1)
    {
      bool1 = true;
      label886:
      if (bool1 == this.a.b.a()) {
        break label1001;
      }
      this.a.b.setOnCheckedChangeListener(null);
      localObject = this.a.b;
      if (paramMessage.arg1 != 1) {
        break label1003;
      }
      bool1 = bool3;
      ((FormSwitchItem)localObject).setChecked(bool1);
      this.a.a();
      paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((this.a.b.a()) || (this.a.c.a())) {
        break label1008;
      }
    }
    for (;;)
    {
      label835:
      label837:
      paramMessage.setVisibility(i);
      label931:
      this.a.b.setOnCheckedChangeListener(this.a);
      return;
      bool1 = false;
      break label886;
      label1001:
      break;
      label1003:
      bool1 = false;
      break label931;
      label1008:
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.17
 * JD-Core Version:    0.7.0.1
 */