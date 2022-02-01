package com.tencent.mobileqq.activity.aio.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class HWTroopClassInfoTipsHelper$3
  extends BroadcastReceiver
{
  HWTroopClassInfoTipsHelper$3(HWTroopClassInfoTipsHelper paramHWTroopClassInfoTipsHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction())) && ("onHomeworkTroopIdentityChanged".equals(paramIntent.getStringExtra("event"))))
    {
      paramContext = paramIntent.getStringExtra("data");
      if (TextUtils.isEmpty(paramContext)) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramContext);
        paramContext = ((JSONObject)localObject).optString("groupCode");
        if (!TextUtils.equals(paramContext, HWTroopClassInfoTipsHelper.a(this.a).a)) {
          return;
        }
        paramIntent = ((JSONObject)localObject).optString("content");
        String str1 = ((JSONObject)localObject).optString("source");
        int i = ((JSONObject)localObject).optInt("rankId", 333);
        String str2 = ((JSONObject)localObject).optString("nickName");
        String str3 = ((JSONObject)localObject).optString("uin");
        String str4 = ((JSONObject)localObject).optString("course");
        localObject = ((JSONObject)localObject).optString("name");
        if ((!"join".equals(str1)) && (TextUtils.equals(str3, HWTroopClassInfoTipsHelper.a(this.a).getCurrentAccountUin())))
        {
          ((IBizTroopMemberInfoService)HWTroopClassInfoTipsHelper.a(this.a).getRuntimeService(IBizTroopMemberInfoService.class, "")).asynSaveHomeworkTroopMemberIdentity(HWTroopClassInfoTipsHelper.a(this.a).a, str3, str2, i, str4, (String)localObject);
          if (this.a.a != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("HWTroopClassInfoTipsHelper", 2, "mHomeworkTroopIdentityChangedReceiver dismissTipsBar.");
            }
            this.a.a.a(HWTroopClassInfoTipsHelper.a(this.a), false);
          }
          if (HWTroopClassInfoTipsHelper.a(this.a) != null) {
            HWTroopClassInfoTipsHelper.a(this.a).a(i);
          }
          if (QLog.isColorLevel()) {
            QLog.d("zivonchen", 2, new Object[] { "mHomeworkTroopIdentityChangedReceiver troopUin = ", paramContext, ", content = ", paramIntent, ", source = ", str1, ", rankId = ", Integer.valueOf(i), ", nickName = ", str2, "uin = ", str3 });
          }
          return;
        }
      }
      catch (JSONException paramContext)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HWTroopClassInfoTipsHelper.3
 * JD-Core Version:    0.7.0.1
 */