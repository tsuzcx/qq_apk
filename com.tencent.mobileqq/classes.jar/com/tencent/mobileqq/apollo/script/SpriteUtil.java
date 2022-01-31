package com.tencent.mobileqq.apollo.script;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import ypf;

public class SpriteUtil
{
  public static int a(int paramInt, String paramString)
  {
    int j = 32;
    int i;
    if ((paramInt == 0) || (8 == paramInt)) {
      i = ApolloUtil.a(208.0F, paramString);
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (3 == paramInt);
        if (6 == paramInt) {
          return 33;
        }
        i = j;
      } while (7 == paramInt);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteUtil", 2, "Other bubble type, NOT Handle.");
    return 32;
  }
  
  public static HandleResult a(String paramString1, QQAppInterface paramQQAppInterface, int paramInt, String paramString2)
  {
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        int j = paramString1.optInt("isNeedRemark");
        JSONArray localJSONArray1 = paramString1.optJSONArray("uins");
        paramString1 = new JSONObject();
        JSONArray localJSONArray2 = new JSONArray();
        int i = 0;
        if (i < localJSONArray1.length())
        {
          JSONObject localJSONObject = new JSONObject();
          String str1 = localJSONArray1.optString(i);
          if (j == 0)
          {
            bool = true;
            String str2 = a(paramQQAppInterface, paramInt, str1, paramString2, bool);
            localJSONObject.put("uin", str1);
            localJSONObject.put("nickname", str2);
            localJSONArray2.put(localJSONObject);
            i += 1;
          }
        }
        else
        {
          paramString1.put("nicknames", localJSONArray2);
          paramQQAppInterface = new HandleResult();
          paramQQAppInterface.b = true;
          paramQQAppInterface.jdField_a_of_type_JavaLangString = paramString1.toString();
          return paramQQAppInterface;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("cmshow_scripted_SpriteUtil", 1, paramString1, new Object[0]);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public static SpriteActionScript a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (SpriteActionScript)((SpriteScriptManager)paramQQAppInterface.getManager(248)).a().a(0);
  }
  
  public static SpriteContext a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((SpriteScriptManager)paramQQAppInterface.getManager(248)).a();
  }
  
  public static SpriteRscBuilder a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((SpriteScriptManager)paramQQAppInterface.getManager(248)).a();
  }
  
  public static SpriteScriptManager a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (SpriteScriptManager)paramQQAppInterface.getManager(248);
  }
  
  public static MessageForApollo a(String paramString, SpriteContext paramSpriteContext)
  {
    for (;;)
    {
      try
      {
        if (paramSpriteContext.a() == null) {
          return null;
        }
        JSONObject localJSONObject = new JSONObject(new JSONObject(paramString).optString("basicMsg"));
        ApolloMessage localApolloMessage = new ApolloMessage();
        localApolloMessage.id = localJSONObject.optInt("id");
        paramString = localJSONObject.optString("name");
        if (!TextUtils.isEmpty(paramString)) {
          localApolloMessage.name = Base64Util.decode(paramString.getBytes("utf-8"), 0);
        }
        localApolloMessage.flag = localJSONObject.optInt("flag");
        localApolloMessage.peer_status = localJSONObject.optInt("peerStatus");
        localApolloMessage.sender_status = localJSONObject.optInt("senderStatus");
        localApolloMessage.peer_ts = localJSONObject.optLong("peerTS");
        localApolloMessage.sender_ts = localJSONObject.optLong("senderTS");
        localApolloMessage.peer_uin = localJSONObject.optLong("peerUin");
        paramString = localJSONObject.optString("atText");
        if (!paramString.isEmpty()) {
          localApolloMessage.text = Base64Util.decode(paramString.getBytes("utf-8"), 0);
        }
        paramString = localJSONObject.optJSONObject("extraStr");
        localJSONObject = localJSONObject.optJSONObject("extendJson");
        if (paramString == null)
        {
          paramString = new JSONObject();
          if (localJSONObject != null) {
            paramString.put("extendJson", localJSONObject);
          }
          localApolloMessage.extStr = paramString.toString();
          paramSpriteContext = MessageRecordFactory.a(paramSpriteContext.a(), paramSpriteContext.a().a.jdField_a_of_type_JavaLangString, paramSpriteContext.a().a.b, paramSpriteContext.jdField_a_of_type_Int, localApolloMessage);
          paramSpriteContext.inputText = paramString.optString("inputText");
          paramSpriteContext.audioId = paramString.optInt("audioID");
          if (paramString.has("audioStartTime")) {
            paramSpriteContext.audioStartTime = ((float)paramString.optDouble("audioStartTime"));
          }
          paramSpriteContext.actionType = paramString.optInt("actionType");
          if (localJSONObject != null) {
            paramSpriteContext.extendJson = localJSONObject.toString();
          }
          return paramSpriteContext;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteUtil", 1, paramString, new Object[0]);
        return null;
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteUtil", 2, new Object[] { "[getSpriteName], uin:", paramString1, ",sessionType:", Integer.valueOf(paramInt), ",groupUin:", paramString2, ",isNeedRemark:", Boolean.valueOf(paramBoolean) });
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)))
    {
      paramString1 = "";
      return paramString1;
    }
    if (("-1".equals(paramString1)) || ("-2".equals(paramString1))) {
      return "";
    }
    String str = "";
    if (-1 == paramInt) {
      paramString2 = ContactUtils.c(paramQQAppInterface, paramString1, true);
    }
    label253:
    do
    {
      for (;;)
      {
        paramQQAppInterface = paramString2;
        if (!TextUtils.isEmpty(paramString2)) {
          paramQQAppInterface = paramString2.replace("\\", "").replace("'", "").replace("\"", "");
        }
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break;
        }
        return paramQQAppInterface;
        if ((paramInt != 1) && (paramInt != 3000)) {
          break label272;
        }
        if (paramBoolean) {}
        for (str = ContactUtils.f(paramQQAppInterface, paramString2, paramString1);; str = ContactUtils.e(paramQQAppInterface, paramString2, paramString1))
        {
          if (!TextUtils.isEmpty(str))
          {
            paramString2 = str;
            if (!str.equals(paramString1)) {
              break;
            }
          }
          paramString2 = ((FriendsManager)paramQQAppInterface.getManager(50)).c(paramString1);
          if (paramString2 == null) {
            break label253;
          }
          paramString2 = paramString2.name;
          break;
        }
        ((FriendListHandler)paramQQAppInterface.a(1)).a(paramString1, false);
        paramString2 = str;
      }
      paramString2 = str;
    } while (paramInt != 0);
    label272:
    if (paramBoolean) {}
    for (str = ContactUtils.p(paramQQAppInterface, paramString1);; str = ContactUtils.c(paramQQAppInterface, paramString1, true))
    {
      paramString2 = str;
      if (!paramString1.equals(str)) {
        break;
      }
      ((FriendListHandler)paramQQAppInterface.a(1)).a(paramString1, false);
      paramString2 = str;
      break;
    }
  }
  
  public static String a(String paramString)
  {
    String str = "";
    if (paramString != null) {
      str = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
    }
    return str;
  }
  
  public static void a(SpriteContext paramSpriteContext, List paramList)
  {
    if ((paramSpriteContext == null) || (paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      paramSpriteContext = a(paramSpriteContext.a());
    } while (paramSpriteContext == null);
    paramSpriteContext.a().a(paramList);
  }
  
  public static void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, ApolloActionData paramApolloActionData)
  {
    if (paramSpriteDrawerInfoManager == null) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = paramApolloActionData.actionId;
    localSpriteTaskParam.k = paramInt;
    localSpriteTaskParam.jdField_c_of_type_Int = paramApolloActionData.actionType;
    localSpriteTaskParam.g = 5;
    localSpriteTaskParam.e = 0;
    localSpriteTaskParam.jdField_a_of_type_Long = 1000000L;
    localSpriteTaskParam.jdField_a_of_type_Boolean = true;
    localSpriteTaskParam.b = false;
    paramApolloActionData = paramSpriteDrawerInfoManager.a();
    if ((paramApolloActionData != null) && (paramApolloActionData.a() != null)) {
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = String.valueOf(paramApolloActionData.b);
    }
    paramSpriteDrawerInfoManager.a().a(localSpriteTaskParam);
  }
  
  public static void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, String paramString, int paramInt)
  {
    if ((paramSpriteDrawerInfoManager == null) || (paramSpriteDrawerInfoManager.a() == null)) {
      return;
    }
    SpriteActionScript localSpriteActionScript = paramSpriteDrawerInfoManager.a();
    paramSpriteDrawerInfoManager.a().a(paramInt);
    localSpriteActionScript.a("", paramString, a(paramInt, paramString));
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = a(paramQQAppInterface);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.jdField_a_of_type_Boolean = true;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (paramQQAppInterface == null)) {}
    SpriteContext localSpriteContext;
    int k;
    label71:
    do
    {
      do
      {
        return;
        localSpriteContext = a(paramQQAppInterface);
      } while (localSpriteContext == null);
      k = localSpriteContext.jdField_a_of_type_Int;
      if ((1 == k) || (3000 == k))
      {
        i = 0;
        int j;
        if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString))
        {
          if (paramSpriteTaskParam.b) {
            i = 2;
          }
        }
        else
        {
          if (!paramSpriteTaskParam.jdField_a_of_type_Boolean) {
            break label161;
          }
          j = 0;
          k = ApolloUtil.b(k);
          str = Integer.toString(paramSpriteTaskParam.f);
          if (paramSpriteTaskParam.e != 0) {
            break label166;
          }
        }
        for (paramSpriteTaskParam = "0";; paramSpriteTaskParam = "1")
        {
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "g_msg_clk", j, k, new String[] { str, paramSpriteTaskParam, String.valueOf(i), String.valueOf(System.currentTimeMillis() / 1000L), localSpriteContext.jdField_a_of_type_JavaLangString });
          return;
          i = 1;
          break;
          j = 1;
          break label71;
        }
      }
    } while (k != 0);
    label161:
    label166:
    String str = "0";
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {
      str = "1";
    }
    if (paramSpriteTaskParam.jdField_a_of_type_Boolean) {}
    for (int i = 0;; i = 1)
    {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "msg_clk", i, 0, new String[] { Integer.toString(paramSpriteTaskParam.f), str, "", String.valueOf(System.currentTimeMillis() / 1000L), localSpriteContext.jdField_a_of_type_JavaLangString });
      return;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {}
    do
    {
      return true;
      if (-1 == paramQQAppInterface.jdField_c_of_type_Int) {
        paramQQAppInterface.a();
      }
    } while (paramQQAppInterface.jdField_c_of_type_Int == 1);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if ((paramInt == 1) || (paramInt == 3000))
    {
      paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(59);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.b(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteUtil", 2, "cmshow NOT support hot chat right now.");
        }
        return false;
      }
    }
    if ((paramInt == 1) || (paramInt == 0) || ((paramInt == 3000) && (ApolloManager.c("discuss") == 1))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      SpriteContext localSpriteContext;
      SharedPreferences localSharedPreferences;
      int i;
      do
      {
        do
        {
          do
          {
            return;
            localSpriteContext = a(paramQQAppInterface);
          } while (localSpriteContext == null);
          localSharedPreferences = localSpriteContext.jdField_a_of_type_AndroidContentSharedPreferences;
        } while (localSharedPreferences == null);
        i = localSharedPreferences.getInt("audio_tips_times" + localSpriteContext.b, 0);
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteUtil", 2, "totalTimes:" + i);
        }
      } while (3 == i);
      localSharedPreferences.edit().putInt("audio_tips_times" + localSpriteContext.b, i + 1).commit();
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.post(new ypf());
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    return (paramQQAppInterface == null) || (paramQQAppInterface.b());
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (!c(paramQQAppInterface)) {
      QLog.i("cmshow_scripted_SpriteUtil", 1, "not meet basic case.");
    }
    do
    {
      return false;
      if (1 != ApolloActionHelper.a(paramQQAppInterface.c(), paramQQAppInterface))
      {
        QLog.i("cmshow_scripted_SpriteUtil", 1, "cmshow switch NOT opend.");
        return false;
      }
    } while ((!a(paramQQAppInterface, paramInt, paramString)) || ((paramInt == 1) && (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramString))) || (b(paramQQAppInterface)) || (AnonymousChatHelper.a().a(paramString)));
    paramQQAppInterface = new SessionInfo();
    paramQQAppInterface.jdField_a_of_type_Int = paramInt;
    paramQQAppInterface.jdField_a_of_type_JavaLangString = paramString;
    if (GoldMsgChatHelper.a(paramQQAppInterface))
    {
      QLog.i("cmshow_scripted_SpriteUtil", 1, "gold msg state, NOT use cmshow.");
      return false;
    }
    return true;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return false;
        if (ApolloManager.a(BaseApplicationImpl.getContext())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmshow_scripted_SpriteUtil", 2, "NOT allowed to use cmshow.");
      return false;
    } while (!ApolloEngine.a());
    return true;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    if (!c(paramQQAppInterface))
    {
      QLog.i("cmshow_scripted_SpriteUtil", 1, "not meet basic case.");
      return false;
    }
    if (1 != ApolloActionHelper.a(paramQQAppInterface.c(), paramQQAppInterface))
    {
      QLog.i("cmshow_scripted_SpriteUtil", 1, "cmshow switch NOT opend.");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUtil
 * JD-Core Version:    0.7.0.1
 */