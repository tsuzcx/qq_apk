package com.tencent.mobileqq.activity.qwallet.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QWalletRedPkgUtils
{
  public static Bundle a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = -1;
    Object localObject = "";
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      paramSessionInfo = (SessionInfo)localObject;
    }
    for (;;)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putInt("groupType", i);
      paramQQAppInterface.putString("name", paramSessionInfo);
      return paramQQAppInterface;
      i = 0;
      paramSessionInfo = a(paramQQAppInterface);
      continue;
      i = 2;
      paramSessionInfo = a(paramQQAppInterface);
      continue;
      localObject = (HotChatManager)paramQQAppInterface.getManager(59);
      int j;
      if ((localObject != null) && (((HotChatManager)localObject).b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        j = 5;
        localObject = ContactUtils.q(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        paramSessionInfo = (SessionInfo)localObject;
        i = j;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramSessionInfo = a(paramQQAppInterface);
          i = j;
        }
      }
      else
      {
        i = 1;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        i = 3;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        i = 4;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        j = 6;
        localObject = ContactUtils.q(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        paramSessionInfo = (SessionInfo)localObject;
        i = j;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramSessionInfo = a(paramQQAppInterface);
          i = j;
          continue;
          i = 58;
          paramSessionInfo = a(paramQQAppInterface);
        }
      }
    }
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    int i = -1;
    String str = "";
    switch (paramMessageForQQWalletMsg.istroop)
    {
    default: 
      paramSessionInfo = str;
    }
    for (;;)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putInt("groupType", i);
      paramQQAppInterface.putString("name", paramSessionInfo);
      return paramQQAppInterface;
      i = 0;
      paramSessionInfo = a(paramQQAppInterface);
      continue;
      i = 2;
      paramSessionInfo = a(paramQQAppInterface);
      continue;
      paramMessageForQQWalletMsg = (HotChatManager)paramQQAppInterface.getManager(59);
      int j;
      if ((paramMessageForQQWalletMsg != null) && (paramMessageForQQWalletMsg.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        j = 5;
        paramMessageForQQWalletMsg = ContactUtils.q(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        paramSessionInfo = paramMessageForQQWalletMsg;
        i = j;
        if (TextUtils.isEmpty(paramMessageForQQWalletMsg))
        {
          paramSessionInfo = a(paramQQAppInterface);
          i = j;
        }
      }
      else
      {
        i = 1;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        i = 3;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        i = 4;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        j = 6;
        paramMessageForQQWalletMsg = ContactUtils.q(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        paramSessionInfo = paramMessageForQQWalletMsg;
        i = j;
        if (TextUtils.isEmpty(paramMessageForQQWalletMsg))
        {
          paramSessionInfo = a(paramQQAppInterface);
          i = j;
          continue;
          i = 58;
          paramSessionInfo = a(paramQQAppInterface);
        }
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).c(str);
    if (paramQQAppInterface != null)
    {
      if ((paramQQAppInterface.name != null) && (paramQQAppInterface.name.length() > 0)) {
        return paramQQAppInterface.name;
      }
      return paramQQAppInterface.uin;
    }
    return str;
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt2, paramInt3, "", paramInt4);
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3, String paramString8, int paramInt4)
  {
    paramString1 = a(paramString2, paramString1, paramInt1, paramString3, paramString4, paramString7, paramSessionInfo.b, paramInt2, paramInt3, 0, paramString8, paramInt4);
    if (paramSessionInfo.jdField_a_of_type_Int == 1008) {
      paramSessionInfo = new JSONObject();
    }
    try
    {
      paramSessionInfo.put("channel", 2);
      paramString1.put("detailinfo", paramSessionInfo);
      paramSessionInfo = new JSONObject();
    }
    catch (Exception paramSessionInfo)
    {
      try
      {
        do
        {
          paramSessionInfo.put("userId", paramQQAppInterface.getCurrentAccountUin());
          paramSessionInfo.put("viewTag", paramString6);
          paramSessionInfo.put("app_info", paramString5);
          paramSessionInfo.put("come_from", 2);
          paramSessionInfo.put("extra_data", paramString1);
          return paramSessionInfo;
          paramSessionInfo = paramSessionInfo;
        } while (!QLog.isDevelopLevel());
        paramSessionInfo.printStackTrace();
      }
      catch (Exception paramQQAppInterface)
      {
        while (!QLog.isDevelopLevel()) {}
        paramQQAppInterface.printStackTrace();
      }
    }
    return paramSessionInfo;
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, MessageForQQWalletMsg paramMessageForQQWalletMsg, SessionInfo paramSessionInfo, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    int i = 0;
    int j = 0;
    if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null)
    {
      i = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.resourceType;
      j = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId;
    }
    for (int k = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.special_pop_id;; k = 0)
    {
      paramString1 = a(paramString2, paramString1, paramInt, paramString3, paramString4, paramString7, paramMessageForQQWalletMsg.senderuin, paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, i, j, "", paramMessageForQQWalletMsg.fromHBList);
      try
      {
        paramString1.put("bigAnimId", k);
        paramString1.put("hb_from", paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.hbFrom);
        if (paramSessionInfo.jdField_a_of_type_Int == 1008)
        {
          paramSessionInfo = new JSONObject();
          paramSessionInfo.put("channel", 2);
          paramString1.put("detailinfo", paramSessionInfo);
        }
        paramSessionInfo = new JSONObject();
      }
      catch (Exception paramSessionInfo)
      {
        try
        {
          do
          {
            paramSessionInfo.put("userId", paramQQAppInterface.getCurrentAccountUin());
            paramSessionInfo.put("viewTag", paramString6);
            paramSessionInfo.put("app_info", paramString5);
            paramSessionInfo.put("come_from", 2);
            paramSessionInfo.put("extra_data", paramString1);
            paramSessionInfo.put("senderuin", MsgProxyUtils.c(paramMessageForQQWalletMsg));
            return paramSessionInfo;
            paramSessionInfo = paramSessionInfo;
          } while (!QLog.isDevelopLevel());
          paramSessionInfo.printStackTrace();
        }
        catch (Exception paramQQAppInterface)
        {
          while (!QLog.isDevelopLevel()) {}
          paramQQAppInterface.printStackTrace();
          return paramSessionInfo;
        }
      }
    }
  }
  
  public static JSONObject a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, int paramInt3, int paramInt4, String paramString7, int paramInt5)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("listid", paramString1);
      localJSONObject.put("name", paramString2);
      localJSONObject.put("grouptype", paramInt1 + "");
      localJSONObject.put("groupid", paramString4);
      localJSONObject.put("channel", paramInt2);
      localJSONObject.put("resource_type", paramInt3);
      localJSONObject.put("skin_id", paramInt4);
      localJSONObject.put("fromHBList", paramInt5);
      if (paramString6 != null) {
        localJSONObject.put("groupuin", paramString6);
      }
      if (paramString3 != null) {
        localJSONObject.put("authkey", paramString3);
      }
      if (paramString5 != null) {
        localJSONObject.put("cftImageUrl", paramString5);
      }
      if (!TextUtils.isEmpty(paramString7)) {
        localJSONObject.put("voice_rate_id", paramString7);
      }
    }
    catch (Exception paramString1)
    {
      while (!QLog.isDevelopLevel()) {}
      paramString1.printStackTrace();
    }
    return localJSONObject;
    return localJSONObject;
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1000L;
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    if (DisplayUtil.a(paramContext, 600.0F) < localDisplayMetrics.heightPixels) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, JumpActivity.class);
    localIntent.setData(Uri.parse(paramString));
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public static boolean a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    boolean bool = true;
    QQWalletTransferMsgElem localQQWalletTransferMsgElem = null;
    if (paramMessageForQQWalletMsg == null) {
      break label25;
    }
    label25:
    do
    {
      do
      {
        return false;
        if (paramMessageForQQWalletMsg.mQQWalletTransferMsg == null) {
          break;
        }
        localQQWalletTransferMsgElem = paramMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
      } while (localQQWalletTransferMsgElem == null);
      paramMessageForQQWalletMsg = localQQWalletTransferMsgElem.nativeAndroid;
    } while (TextUtils.isEmpty(paramMessageForQQWalletMsg));
    paramMessageForQQWalletMsg = paramMessageForQQWalletMsg.split("\\?");
    if ((!TextUtils.isEmpty(paramMessageForQQWalletMsg[0])) && (paramMessageForQQWalletMsg[0].equals("red"))) {}
    for (;;)
    {
      return bool;
      if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
        break;
      }
      return true;
      bool = false;
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils
 * JD-Core Version:    0.7.0.1
 */