package com.tencent.mobileqq.activity.miniaio;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import java.util.HashMap;
import java.util.Map;

public class MiniChatFragmentForQzone
  extends MiniChatFragment
{
  protected void c()
  {
    Object localObject1 = a(getBaseActivity());
    if (localObject1 != null)
    {
      Bundle localBundle = ((Intent)localObject1).getExtras();
      if (localBundle == null) {
        return;
      }
      if (!localBundle.getBoolean("KEY_IS_AUTO_SEND_ARK_MESSAGE_WHEN_OPEN", false)) {
        return;
      }
      Object localObject3 = localBundle.getString("forward_ark_app_name");
      Object localObject4 = localBundle.getString("forward_ark_app_view");
      String str1 = localBundle.getString("forward_ark_app_meta");
      String str2 = localBundle.getString("forward_ark_app_config");
      String str3 = localBundle.getString("forward_ark_app_prompt");
      Object localObject2 = new HashMap();
      if (((Map)localObject2).containsKey("desc")) {
        localObject1 = (String)((Map)localObject2).get("desc");
      } else {
        localObject1 = "";
      }
      if (((Map)localObject2).containsKey("version")) {
        localObject2 = (String)((Map)localObject2).get("version");
      } else {
        localObject2 = "0.0.0.1";
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = localObject3;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          return;
        }
        localObject2 = new ArkAppMessage(str3, (String)localObject3, (String)localObject1, (String)localObject4, (String)localObject2, str1, str2, "");
        localObject3 = (ArkAppMessage)ArkAppCenterCheckEvent.a(2, (String)localObject3, localBundle, localObject2);
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = localObject2;
        }
        localObject3 = StructMsgFactory.a(localBundle);
        localObject2 = localBundle.getString("forward_appId_ark_from_sdk");
        localObject4 = localBundle.getString("struct_share_key_source_name");
        str1 = localBundle.getString("struct_share_key_source_action_data");
        str2 = localBundle.getString("struct_share_key_source_a_action_data_from_h5");
        str3 = localBundle.getString("struct_share_key_source_url");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ((ArkAppMessage)localObject1).appId = ((String)localObject2);
          ((ArkAppMessage)localObject1).mSourceName = ((String)localObject4);
          ((ArkAppMessage)localObject1).mSourceActionData = str1;
          ((ArkAppMessage)localObject1).mSource_A_ActionData = str2;
          ((ArkAppMessage)localObject1).mSourceUrl = str3;
        }
        localObject4 = getBaseActivity().app;
        if (localObject3 != null)
        {
          i = this.a.a;
          if ((i != 1000) && (i != 1004) && (i != 1020)) {}
          for (localObject2 = ((QQAppInterface)localObject4).getCurrentAccountUin();; localObject2 = this.a.c) {
            break;
          }
          str1 = ((QQAppInterface)localObject4).getCurrentAccountUin();
          str2 = this.a.b;
          i = this.a.a;
          int j = MobileQQService.seq;
          MobileQQService.seq = j + 1;
          ((ArkAppMessage)localObject1).containStructMsg = MessageRecordFactory.c((QQAppInterface)localObject4, str1, str2, (String)localObject2, i, j, (AbsStructMsg)localObject3);
        }
        int i = localBundle.getInt("KEY_MSG_FORWARD_ID");
        ChatActivityFacade.a((QQAppInterface)localObject4, this.a, (ArkAppMessage)localObject1, i);
        d();
      }
    }
  }
  
  protected void d()
  {
    if (this.b != null) {
      this.b.a(131075, 0L);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatFragmentForQzone
 * JD-Core Version:    0.7.0.1
 */