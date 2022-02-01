package com.tencent.mobileqq.apollo.script;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloMessageService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher.AioSupported;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.api.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.uitls.IApolloActionHelper;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpriteUtil
{
  public static int a()
  {
    return (int)(DeviceInfoUtil.i() * 4L / 3L);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return 0;
    case 7: 
      return 1;
    }
    return 2;
  }
  
  public static int a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramInt1 == 0) || (8 == paramInt1)) {
      paramInt2 = ApolloUtilImpl.handleBubbleType(208.0F, paramString, paramInt3);
    }
    do
    {
      do
      {
        return paramInt2;
        if (3 == paramInt1) {
          return 32;
        }
        if (6 != paramInt1) {
          break;
        }
        paramInt2 = 33;
      } while (paramInt3 != 2);
      return 75;
      if (7 == paramInt1)
      {
        if (paramInt3 != 2) {
          break;
        }
        return 74;
      }
    } while (9 == paramInt1);
    QLog.d("cmshow_scripted_SpriteUtil", 1, new Object[] { "Other bubble type, NOT Handle, bubbleType:", Integer.valueOf(paramInt1), ", bubbleId:", Integer.valueOf(32) });
    return 32;
  }
  
  public static int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = 26;
    int i = 0;
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        break label93;
      }
      if (paramBoolean3) {
        i = 81;
      }
    }
    else if (!paramBoolean1)
    {
      if (!paramBoolean2) {
        break label107;
      }
      if (!paramBoolean3) {
        break label100;
      }
      i = 84;
    }
    for (;;)
    {
      if (ApolloUtilImpl.isNickBubbleRscExist(paramInt, i)) {
        break label114;
      }
      QLog.w("cmshow_scripted_SpriteUtil", 1, "nick bubble not exist, id:" + i);
      paramInt = j;
      if (paramBoolean1) {
        paramInt = 25;
      }
      return paramInt;
      i = 82;
      break;
      label93:
      i = 25;
      break;
      label100:
      i = 83;
      continue;
      label107:
      i = 26;
    }
    label114:
    return i;
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    if (paramContext != null) {
      i = AIOUtils.a(46.0F, paramContext.getResources());
    }
    return Math.max(i, (int)((float)DeviceInfoUtil.h() / 7.0F / 2.84D) + 40);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return ApolloManagerServiceImpl.get3dWhiteListStatus(paramQQAppInterface);
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
          paramQQAppInterface.jdField_b_of_type_Boolean = true;
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
  
  public static ISpriteScriptManager a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (ISpriteScriptManager)paramQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
  }
  
  public static ApolloActionData a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getActionInfoById(paramInt);
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
        Object localObject = new JSONObject(new JSONObject(paramString).optString("basicMsg"));
        ApolloMessage localApolloMessage = new ApolloMessage();
        localApolloMessage.id = ((JSONObject)localObject).optInt("id");
        paramString = ((JSONObject)localObject).optString("name");
        if (!TextUtils.isEmpty(paramString)) {
          localApolloMessage.name = Base64Util.decode(paramString.getBytes("utf-8"), 0);
        }
        localApolloMessage.flag = ((JSONObject)localObject).optInt("flag");
        localApolloMessage.peer_status = ((JSONObject)localObject).optInt("peerStatus");
        localApolloMessage.sender_status = ((JSONObject)localObject).optInt("senderStatus");
        localApolloMessage.peer_ts = ((JSONObject)localObject).optLong("peerTS");
        localApolloMessage.sender_ts = ((JSONObject)localObject).optLong("senderTS");
        localApolloMessage.peer_uin = ((JSONObject)localObject).optLong("peerUin");
        paramString = ((JSONObject)localObject).optString("atText");
        if (!paramString.isEmpty()) {
          localApolloMessage.text = Base64Util.decode(paramString.getBytes("utf-8"), 0);
        }
        paramString = ((JSONObject)localObject).optJSONObject("extraStr");
        JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("extendJson");
        if (paramString == null)
        {
          paramString = new JSONObject();
          if (localJSONObject != null) {
            paramString.put("extendJson", localJSONObject);
          }
          localApolloMessage.extStr = paramString.toString();
          paramSpriteContext = MessageRecordFactory.a(paramSpriteContext.a(), paramSpriteContext.a().a.jdField_a_of_type_JavaLangString, paramSpriteContext.a().a.jdField_b_of_type_JavaLangString, paramSpriteContext.a, localApolloMessage);
          paramSpriteContext.inputText = paramString.optString("inputText");
          paramSpriteContext.audioId = paramString.optInt("audioID");
          if (paramString.has("audioStartTime")) {
            paramSpriteContext.audioStartTime = ((float)paramString.optDouble("audioStartTime"));
          }
          paramSpriteContext.actionType = paramString.optInt("actionType");
          paramSpriteContext.msgType = paramString.optInt("msgTyep");
          paramSpriteContext.welcomeId = paramString.optLong("welcomeId");
          paramSpriteContext.curUsedIdType = ((JSONObject)localObject).optInt("curUsedIdType");
          if (localJSONObject != null) {
            paramSpriteContext.extendJson = localJSONObject.toString();
          }
          if (paramString.has("mApollo3DMessage"))
          {
            paramString = paramString.getJSONObject("mApollo3DMessage");
            localObject = new Apollo3DMessage();
            ((Apollo3DMessage)localObject).setMessageWithJSONObject(paramString);
            paramSpriteContext.mApollo3DMessage = ((Apollo3DMessage)localObject);
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
  
  public static ISpriteBridge a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return null;
      paramQQAppInterface = a(paramQQAppInterface);
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.getSpriteBridge();
  }
  
  public static ISpriteContext a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((ISpriteScriptManager)paramQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteContext();
  }
  
  public static SpriteActionScript a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (SpriteActionScript)((SpriteScriptManagerImpl)a(paramQQAppInterface)).getSpriteCreator().a(0);
  }
  
  public static SpriteRscBuilder a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((SpriteScriptManagerImpl)a(paramQQAppInterface)).getRscBuilder();
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
      paramString2 = ContactUtils.d(paramQQAppInterface, paramString1, true);
    }
    label250:
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
        if (!CmShowAioMatcher.a(paramInt, 2)) {
          break label271;
        }
        if (paramBoolean) {}
        for (str = ContactUtils.e(paramQQAppInterface, paramString2, paramString1);; str = ContactUtils.d(paramQQAppInterface, paramString2, paramString1))
        {
          if (!TextUtils.isEmpty(str))
          {
            paramString2 = str;
            if (!str.equals(paramString1)) {
              break;
            }
          }
          paramString2 = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1);
          if (paramString2 == null) {
            break label250;
          }
          paramString2 = paramString2.name;
          break;
        }
        ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString1, false);
        paramString2 = str;
      }
      paramString2 = str;
    } while (!CmShowAioMatcher.a(paramInt, 1));
    label271:
    if (paramBoolean) {}
    for (str = ContactUtils.p(paramQQAppInterface, paramString1);; str = ContactUtils.d(paramQQAppInterface, paramString1, true))
    {
      paramString2 = str;
      if (!paramString1.equals(str)) {
        break;
      }
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString1, false);
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
  
  public static void a(int paramInt, Object... paramVarArgs)
  {
    if (BaseApplicationImpl.sProcessId != 1) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
    } while (localQQAppInterface == null);
    int i = paramInt;
    if (paramInt == 0) {
      i = -100;
    }
    ((IApolloMessageService)localQQAppInterface.getRuntimeService(IApolloMessageService.class, "all")).reportTraceSpanMsg(i, paramVarArgs);
  }
  
  public static void a(ISpriteContext paramISpriteContext, List<SpriteTaskParam> paramList)
  {
    paramISpriteContext = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getQQApp();
    if ((paramISpriteContext == null) || (paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      paramISpriteContext = a(paramISpriteContext);
    } while (paramISpriteContext == null);
    ((SpriteBridge)paramISpriteContext.getSpriteBridge()).a(paramList);
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
    localSpriteTaskParam.jdField_b_of_type_Boolean = false;
    paramApolloActionData = paramSpriteDrawerInfoManager.a();
    if (paramApolloActionData != null) {
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramApolloActionData.a();
    }
    paramSpriteDrawerInfoManager.a().b(localSpriteTaskParam);
  }
  
  public static void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramSpriteDrawerInfoManager == null) || (paramSpriteDrawerInfoManager.a() == null)) {
      return;
    }
    SpriteActionScript localSpriteActionScript = paramSpriteDrawerInfoManager.a();
    IApolloRenderView localIApolloRenderView = paramSpriteDrawerInfoManager.a().a();
    if (localIApolloRenderView != null) {
      localIApolloRenderView.setBubbleType(paramInt1);
    }
    paramSpriteDrawerInfoManager = paramSpriteDrawerInfoManager.a();
    int i = 1;
    if (paramSpriteDrawerInfoManager != null) {
      i = ((IApolloManagerService)paramSpriteDrawerInfoManager.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramSpriteDrawerInfoManager, paramSpriteDrawerInfoManager.getCurrentUin());
    }
    localSpriteActionScript.a("", paramString, a(paramInt1, paramInt2, paramString, i));
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = a(paramQQAppInterface);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.d(true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (paramQQAppInterface == null)) {}
    ISpriteContext localISpriteContext;
    do
    {
      return;
      localISpriteContext = a(paramQQAppInterface);
    } while (localISpriteContext == null);
    int k = localISpriteContext.c();
    int i;
    if ((1 == k) || (3000 == k))
    {
      if (TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {
        break label289;
      }
      if (paramSpriteTaskParam.jdField_b_of_type_Boolean) {
        i = 2;
      }
    }
    for (;;)
    {
      int j;
      if (paramSpriteTaskParam.jdField_a_of_type_Boolean)
      {
        j = 0;
        label71:
        k = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(k);
        str = Integer.toString(paramSpriteTaskParam.f);
        if (paramSpriteTaskParam.e != 0) {
          break label179;
        }
      }
      label179:
      for (paramSpriteTaskParam = "0";; paramSpriteTaskParam = "1")
      {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "g_msg_clk", j, k, new String[] { str, paramSpriteTaskParam, String.valueOf(i), String.valueOf(System.currentTimeMillis() / 1000L), localISpriteContext.b() });
        return;
        i = 1;
        break;
        j = 1;
        break label71;
      }
      if (k != 0) {
        break;
      }
      String str = "0";
      if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {
        str = "1";
      }
      if (paramSpriteTaskParam.jdField_a_of_type_Boolean) {}
      for (i = 0;; i = 1)
      {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "msg_clk", i, 0, new String[] { Integer.toString(paramSpriteTaskParam.f), str, "", String.valueOf(System.currentTimeMillis() / 1000L), localISpriteContext.b() });
        return;
      }
      label289:
      i = 0;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      return true;
    }
    if (-1 == paramQQAppInterface.a()) {
      paramQQAppInterface.a();
    }
    return paramQQAppInterface.a();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    CmShowAioMatcher.AioSupported localAioSupported = CmShowAioMatcher.a(paramInt);
    if (localAioSupported == null)
    {
      QLog.d("cmshow_scripted_SpriteUtil", 2, "cmshow NOT support, not friend or troop or discussion.");
      return false;
    }
    return localAioSupported.a(paramQQAppInterface, paramString);
  }
  
  public static boolean a(String paramString, SpriteTaskParam paramSpriteTaskParam, SpriteContext paramSpriteContext, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || (paramSpriteContext == null) || (paramSpriteContext.a() == null)) {
      bool1 = false;
    }
    label111:
    do
    {
      do
      {
        do
        {
          return bool1;
          paramSpriteContext = paramSpriteContext.a().getCurrentAccountUin();
          if ((TextUtils.isEmpty(paramSpriteTaskParam.jdField_b_of_type_JavaLangString)) || (paramSpriteTaskParam.jdField_b_of_type_JavaLangString.length() <= 4)) {
            break label111;
          }
          if ((!paramString.equals(paramSpriteTaskParam.jdField_b_of_type_JavaLangString)) || (!paramString.equals(paramSpriteContext))) {
            break;
          }
          bool1 = bool2;
        } while (!paramString.equals(paramSpriteTaskParam.jdField_a_of_type_JavaLangString));
        if (!paramString.equals(paramSpriteTaskParam.jdField_a_of_type_JavaLangString)) {
          break;
        }
        bool1 = bool2;
      } while (paramBoolean);
      return false;
      if (TextUtils.isEmpty(paramSpriteTaskParam.jdField_a_of_type_JavaLangString)) {
        break;
      }
      bool1 = bool2;
    } while (paramString.equals(paramSpriteContext));
    return false;
    return false;
  }
  
  public static int b()
  {
    return (int)DeviceInfoUtil.i();
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    }
    return 113;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      ISpriteContext localISpriteContext;
      SharedPreferences localSharedPreferences;
      int i;
      do
      {
        do
        {
          return;
          localISpriteContext = a(paramQQAppInterface);
        } while (localISpriteContext == null);
        localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
        i = localSharedPreferences.getInt("audio_tips_times" + localISpriteContext.a(), 0);
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteUtil", 2, "totalTimes:" + i);
        }
      } while (3 == i);
      localSharedPreferences.edit().putInt("audio_tips_times" + localISpriteContext.a(), i + 1).commit();
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.post(new SpriteUtil.1());
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    return (paramQQAppInterface == null) || (paramQQAppInterface.b());
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int i = b(0);
    if (!d(paramQQAppInterface))
    {
      TraceReportUtil.a(i, 10, 102, new Object[] { "not meet basic case" });
      QLog.i("cmshow_scripted_SpriteUtil", 1, "not meet basic case.");
      return false;
    }
    if (2 == ((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(paramQQAppInterface.getCurrentUin(), paramQQAppInterface))
    {
      TraceReportUtil.a(i, 10, 101, new Object[] { "cmshow switch NOT opend CLOSED_STATUS" });
      QLog.i("cmshow_scripted_SpriteUtil", 1, "cmshow switch NOT opend.");
      return false;
    }
    if (AnonymousChatHelper.a().a(paramString))
    {
      TraceReportUtil.a(i, 10, 104, new Object[] { "aio anonymous" });
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteUtil", 2, "aio anonymous.");
      }
      return false;
    }
    if (!a(paramQQAppInterface, paramInt, paramString)) {
      return false;
    }
    return !b(paramQQAppInterface);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    return (!b(paramQQAppInterface)) && (CmShowWnsUtils.e());
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteUtil", 2, "NOT allowed to use cmshow.");
      }
      return false;
    }
    return ApolloEngine.a();
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface)
  {
    if (!d(paramQQAppInterface))
    {
      QLog.i("cmshow_scripted_SpriteUtil", 1, "not meet basic case.");
      return false;
    }
    if (1 != ((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(paramQQAppInterface.getCurrentUin(), paramQQAppInterface))
    {
      QLog.i("cmshow_scripted_SpriteUtil", 1, "cmshow switch NOT opend.");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUtil
 * JD-Core Version:    0.7.0.1
 */