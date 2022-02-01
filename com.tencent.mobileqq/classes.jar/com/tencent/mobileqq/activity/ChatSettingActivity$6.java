package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class ChatSettingActivity$6
  implements BusinessObserver
{
  ChatSettingActivity$6(ChatSettingActivity paramChatSettingActivity, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label617;
      }
      localObject1 = new WebSsoBody.WebSsoResponseBody();
      ((WebSsoBody.WebSsoResponseBody)localObject1).mergeFrom(paramBundle);
      paramInt = ((WebSsoBody.WebSsoResponseBody)localObject1).ret.get();
      localObject1 = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject1).data.get());
      if (paramInt != 0)
      {
        paramBundle = ((JSONObject)localObject1).optString("msg");
        if ((TextUtils.isEmpty(paramBundle)) || (!QLog.isColorLevel())) {
          break label617;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
        ((StringBuilder)localObject1).append("Q.nearby.follow");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendOperateFollowUser,targetUin:");
        ((StringBuilder)localObject2).append(ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
        ((StringBuilder)localObject2).append(", op:");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(", errMsg:");
        ((StringBuilder)localObject2).append(paramBundle);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, 1, paramBundle, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.getTitleBarHeight());
        return;
      }
      paramBundle = ((JSONObject)localObject1).getJSONObject("result");
      if (((JSONObject)localObject1).optInt("retcode") != 0) {
        break label617;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_Boolean) {
        break label792;
      }
      paramBoolean = true;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        continue;
        paramBoolean = false;
        continue;
        paramInt = 2131694399;
      }
    }
    ((ChatSettingActivity)localObject1).jdField_a_of_type_Boolean = paramBoolean;
    ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_Boolean)
    {
      ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, false);
      ((ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).a(0, 1, ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
      ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity).setOnCheckedChangeListener(null);
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendOperateFollowUser, mIsShield=");
        ((StringBuilder)localObject2).append(ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
        ((StringBuilder)localObject2).append(", mIsFollowed=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.jdField_a_of_type_Boolean);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      ChatSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
      ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity).setOnCheckedChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
    if (this.jdField_a_of_type_JavaLangString.equals("1"))
    {
      paramInt = 2131694391;
      QQToast.a((Context)localObject1, 2, ((ChatSettingActivity)localObject2).getString(paramInt), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.getTitleBarHeight());
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
        ((StringBuilder)localObject1).append("Q.nearby.follow");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendOperateFollowUser,targetUin:");
        ((StringBuilder)localObject2).append(ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
        ((StringBuilder)localObject2).append(", op:");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(", result:");
        ((StringBuilder)localObject2).append(paramBundle.toString());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d(ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity), 2, "sendOperateFollowUser, Exception");
      }
      label617:
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity;
      if (this.jdField_a_of_type_JavaLangString.equals("1")) {
        paramInt = 2131694390;
      } else {
        paramInt = 2131694398;
      }
      paramBundle = paramBundle.getString(paramInt);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, 1, paramBundle, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.getTitleBarHeight());
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(ChatSettingActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
        ((StringBuilder)localObject1).append("Q.nearby.follow");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendOperateFollowUser,targetUin:");
        ((StringBuilder)localObject2).append(ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity));
        ((StringBuilder)localObject2).append(", op:");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(", re:");
        ((StringBuilder)localObject2).append(paramBundle);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.6
 * JD-Core Version:    0.7.0.1
 */