package com.tencent.mobileqq.activity.miniaio;

import acvv;
import ajjs;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import aovh;
import bbjb;
import bbli;
import bchh;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.HashMap;
import java.util.Map;

public class MiniChatFragmentForQzone
  extends MiniChatFragment
{
  protected void a()
  {
    Object localObject1 = a(getActivity());
    Bundle localBundle;
    if (localObject1 != null)
    {
      localBundle = ((Intent)localObject1).getExtras();
      if (localBundle != null) {
        break label25;
      }
    }
    label25:
    Object localObject4;
    String str1;
    String str2;
    String str3;
    String str4;
    Object localObject3;
    label152:
    do
    {
      do
      {
        return;
      } while (!localBundle.getBoolean("KEY_IS_AUTO_SEND_ARK_MESSAGE_WHEN_OPEN", false));
      localObject4 = localBundle.getString("forward_ark_app_name");
      str1 = localBundle.getString("forward_ark_app_view");
      str2 = localBundle.getString("forward_ark_app_meta");
      str3 = localBundle.getString("forward_ark_app_config");
      str4 = localBundle.getString("forward_ark_app_prompt");
      localObject2 = "0.0.0.1";
      localObject3 = new HashMap();
      localObject1 = null;
      if (localObject3 != null)
      {
        if (!((Map)localObject3).containsKey("desc")) {
          break;
        }
        localObject1 = (String)((Map)localObject3).get("desc");
        if (!((Map)localObject3).containsKey("version")) {
          break label464;
        }
        localObject2 = (String)((Map)localObject3).get("version");
      }
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = localObject4;
      }
    } while ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty(str1)));
    localObject1 = new ArkAppMessage(str4, (String)localObject4, (String)localObject3, str1, (String)localObject2, str2, str3, "");
    Object localObject2 = (ArkAppMessage)aovh.a(2, (String)localObject4, localBundle, localObject1);
    if (localObject2 == null) {}
    for (;;)
    {
      localObject3 = bchh.a(localBundle);
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
      localObject4 = getActivity().app;
      if (localObject3 != null) {
        switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType)
        {
        }
      }
      for (localObject2 = ((QQAppInterface)localObject4).getCurrentAccountUin();; localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin)
      {
        str1 = ((QQAppInterface)localObject4).getCurrentAccountUin();
        str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
        int j = bbjb.a;
        bbjb.a = j + 1;
        ((ArkAppMessage)localObject1).containStructMsg = bbli.a((QQAppInterface)localObject4, str1, str2, (String)localObject2, i, j, (AbsStructMsg)localObject3);
        i = localBundle.getInt("KEY_MSG_FORWARD_ID");
        acvv.a((QQAppInterface)localObject4, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkAppMessage)localObject1, i);
        b();
        return;
        localObject1 = "";
        break;
        label464:
        localObject2 = "0.0.0.1";
        break label152;
      }
      localObject1 = localObject2;
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ajjs != null) {
      this.jdField_a_of_type_Ajjs.a(131075, 0L);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatFragmentForQzone
 * JD-Core Version:    0.7.0.1
 */