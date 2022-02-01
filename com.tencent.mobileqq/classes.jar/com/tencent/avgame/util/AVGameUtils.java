package com.tencent.avgame.util;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.avgame.ui.AVGameBackAction;
import com.tencent.avgame.ui.AvGameLoadingActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class AVGameUtils
{
  public static Intent a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    MessageForArkApp localMessageForArkApp;
    label66:
    int j;
    String str3;
    if ((paramQQAppInterface != null) && (paramMessage != null) && (paramMessage.msgtype == -5008))
    {
      paramQQAppInterface = paramQQAppInterface.getMessageFacade();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
        if ((paramQQAppInterface instanceof MessageForArkApp))
        {
          localMessageForArkApp = (MessageForArkApp)paramQQAppInterface;
          break label66;
        }
      }
      localMessageForArkApp = null;
      if ((localMessageForArkApp != null) && (localMessageForArkApp.ark_app_message != null) && ("com.tencent.avgame".equals(localMessageForArkApp.ark_app_message.appName)) && ("invite".equals(localMessageForArkApp.ark_app_message.appView)))
      {
        j = paramMessage.istroop;
        str3 = paramMessage.frienduin;
      }
    }
    for (;;)
    {
      String str1;
      try
      {
        paramQQAppInterface = new JSONObject(localMessageForArkApp.ark_app_message.metaList);
        if (!paramQQAppInterface.has("invite")) {
          break label609;
        }
        paramQQAppInterface = paramQQAppInterface.getJSONObject("invite");
        if ((paramQQAppInterface == null) || (!paramQQAppInterface.has("extra"))) {
          break label614;
        }
        paramQQAppInterface = paramQQAppInterface.getJSONObject("extra");
        if ((paramQQAppInterface != null) && (paramQQAppInterface.has("jump_url"))) {
          str1 = paramQQAppInterface.getString("jump_url");
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVGameUtils", 2, "getAVGameIntentFromArkMessage", paramQQAppInterface);
        }
        str1 = null;
      }
      Object localObject2;
      if ((str1 != null) && (str1.startsWith("mqqapi://avgame/join_room")))
      {
        paramQQAppInterface = str1.split("\\?");
        if (paramQQAppInterface.length == 2) {
          paramQQAppInterface = paramQQAppInterface[1];
        } else {
          paramQQAppInterface = null;
        }
        if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0))
        {
          String[] arrayOfString = paramQQAppInterface.split("&");
          int i = 0;
          localObject1 = null;
          Object localObject3;
          for (paramQQAppInterface = null; i < arrayOfString.length; paramQQAppInterface = (QQAppInterface)localObject3)
          {
            String str2 = arrayOfString[i];
            localObject2 = localObject1;
            localObject3 = paramQQAppInterface;
            if (str2.split("=").length == 2)
            {
              int k = str2.indexOf("=");
              String str4 = str2.substring(0, k);
              str2 = str2.substring(k + 1);
              if (("room".equals(str4)) && (TextUtils.isDigitsOnly(str2)))
              {
                localObject2 = str2;
                localObject3 = paramQQAppInterface;
              }
              else
              {
                localObject2 = localObject1;
                localObject3 = paramQQAppInterface;
                if ("uin".equals(str4))
                {
                  localObject2 = localObject1;
                  localObject3 = paramQQAppInterface;
                  if (TextUtils.isDigitsOnly(str2))
                  {
                    localObject3 = str2;
                    localObject2 = localObject1;
                  }
                }
              }
            }
            i += 1;
            localObject1 = localObject2;
          }
          break label439;
        }
      }
      Object localObject1 = null;
      paramQQAppInterface = null;
      label439:
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAVGameIntentFromArkMessage, room[");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append("], uin[");
        ((StringBuilder)localObject2).append(paramQQAppInterface);
        ((StringBuilder)localObject2).append("], jump[");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append("], json[");
        ((StringBuilder)localObject2).append(localMessageForArkApp.ark_app_message.metaList);
        ((StringBuilder)localObject2).append("]");
        QLog.i("AVGameUtils", 4, ((StringBuilder)localObject2).toString());
      }
      if ((!TextUtils.isEmpty(localObject1)) && (!TextUtils.isEmpty(paramQQAppInterface)))
      {
        paramQQAppInterface = AvGameLoadingActivity.b(false, j, str3, localObject1, 0, null);
        paramQQAppInterface.setClass(BaseApplicationImpl.getApplication(), QPublicFragmentActivity.class);
        paramQQAppInterface.addFlags(268435456);
        paramQQAppInterface.putExtra("public_fragment_class", AvGameLoadingActivity.class.getName());
        AVGameBackAction.a(paramQQAppInterface, paramMessage);
        return paramQQAppInterface;
      }
      return null;
      return null;
      label609:
      paramQQAppInterface = null;
      continue;
      label614:
      paramQQAppInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.AVGameUtils
 * JD-Core Version:    0.7.0.1
 */