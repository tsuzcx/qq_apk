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

class ChatSettingActivity$7
  implements BusinessObserver
{
  ChatSettingActivity$7(ChatSettingActivity paramChatSettingActivity, String paramString) {}
  
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
        ((StringBuilder)localObject1).append(ChatSettingActivity.e(this.b));
        ((StringBuilder)localObject1).append("Q.nearby.follow");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendOperateFollowUser,targetUin:");
        ((StringBuilder)localObject2).append(ChatSettingActivity.a(this.b));
        ((StringBuilder)localObject2).append(", op:");
        ((StringBuilder)localObject2).append(this.a);
        ((StringBuilder)localObject2).append(", errMsg:");
        ((StringBuilder)localObject2).append(paramBundle);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        QQToast.makeText(this.b, 1, paramBundle, 0).show(this.b.getTitleBarHeight());
        return;
      }
      paramBundle = ((JSONObject)localObject1).getJSONObject("result");
      if (((JSONObject)localObject1).optInt("retcode") != 0) {
        break label617;
      }
      localObject1 = this.b;
      if (this.b.b) {
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
        paramInt = 2131892078;
      }
    }
    ((ChatSettingActivity)localObject1).b = paramBoolean;
    ChatSettingActivity.f(this.b);
    if (this.b.b)
    {
      ChatSettingActivity.a(this.b, false);
      ((ShieldMsgManger)this.b.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).a(0, 1, ChatSettingActivity.a(this.b));
      ChatSettingActivity.g(this.b).setOnCheckedChangeListener(null);
      if (QLog.isColorLevel())
      {
        localObject1 = this.b.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendOperateFollowUser, mIsShield=");
        ((StringBuilder)localObject2).append(ChatSettingActivity.h(this.b));
        ((StringBuilder)localObject2).append(", mIsFollowed=");
        ((StringBuilder)localObject2).append(this.b.b);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      ChatSettingActivity.i(this.b);
      ChatSettingActivity.g(this.b).setOnCheckedChangeListener(this.b);
    }
    localObject1 = this.b;
    localObject2 = this.b;
    if (this.a.equals("1"))
    {
      paramInt = 2131892070;
      QQToast.makeText((Context)localObject1, 2, ((ChatSettingActivity)localObject2).getString(paramInt), 0).show(this.b.getTitleBarHeight());
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(ChatSettingActivity.e(this.b));
        ((StringBuilder)localObject1).append("Q.nearby.follow");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendOperateFollowUser,targetUin:");
        ((StringBuilder)localObject2).append(ChatSettingActivity.a(this.b));
        ((StringBuilder)localObject2).append(", op:");
        ((StringBuilder)localObject2).append(this.a);
        ((StringBuilder)localObject2).append(", result:");
        ((StringBuilder)localObject2).append(paramBundle.toString());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d(ChatSettingActivity.e(this.b), 2, "sendOperateFollowUser, Exception");
      }
      label617:
      paramBundle = this.b;
      if (this.a.equals("1")) {
        paramInt = 2131892069;
      } else {
        paramInt = 2131892077;
      }
      paramBundle = paramBundle.getString(paramInt);
      QQToast.makeText(this.b, 1, paramBundle, 0).show(this.b.getTitleBarHeight());
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(ChatSettingActivity.e(this.b));
        ((StringBuilder)localObject1).append("Q.nearby.follow");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendOperateFollowUser,targetUin:");
        ((StringBuilder)localObject2).append(ChatSettingActivity.a(this.b));
        ((StringBuilder)localObject2).append(", op:");
        ((StringBuilder)localObject2).append(this.a);
        ((StringBuilder)localObject2).append(", re:");
        ((StringBuilder)localObject2).append(paramBundle);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.7
 * JD-Core Version:    0.7.0.1
 */