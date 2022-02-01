package com.tencent.mobileqq.apollo.script;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.api.ICmShowAioMatcher.AioSupported;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloMessageService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoBridge;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloMessageUtilImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
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
    if (paramInt != 7)
    {
      if (paramInt != 9) {
        return 0;
      }
      return 2;
    }
    return 1;
  }
  
  public static int a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramInt1 != 0) && (8 != paramInt1))
    {
      if (3 == paramInt1) {}
      for (;;)
      {
        return 32;
        if (6 == paramInt1)
        {
          paramInt1 = 33;
          if (paramInt3 != 2) {
            break;
          }
          return 75;
        }
        if (7 == paramInt1)
        {
          if (paramInt3 == 2) {
            return 74;
          }
        }
        else
        {
          if (9 == paramInt1) {
            return paramInt2;
          }
          QLog.d("[cmshow][scripted]SpriteUtil", 1, new Object[] { "Other bubble type, NOT Handle, bubbleType:", Integer.valueOf(paramInt1), ", bubbleId:", Integer.valueOf(32) });
        }
      }
    }
    paramInt1 = ApolloUtilImpl.handleBubbleType(208.0F, paramString, paramInt3);
    return paramInt1;
  }
  
  public static int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (paramBoolean3) {
          i = 81;
        } else {
          i = 82;
        }
      }
      else {
        i = 25;
      }
    }
    else {
      i = 0;
    }
    if (!paramBoolean1) {
      if (paramBoolean2)
      {
        if (paramBoolean3) {
          i = 84;
        } else {
          i = 83;
        }
      }
      else {
        i = 26;
      }
    }
    int j = i;
    if (!ApolloUtilImpl.isNickBubbleRscExist(paramInt, i))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("nick bubble not exist, id:");
      localStringBuilder.append(i);
      QLog.w("[cmshow][scripted]SpriteUtil", 1, localStringBuilder.toString());
      if (paramBoolean1) {
        return 25;
      }
      j = 26;
    }
    return j;
  }
  
  public static int a(Context paramContext)
  {
    int i;
    if (paramContext != null) {
      i = AIOUtils.b(46.0F, paramContext.getResources());
    } else {
      i = 0;
    }
    double d = (float)DeviceInfoUtil.h() / 7.0F;
    Double.isNaN(d);
    return Math.max(i, (int)(d / 2.84D) + 40);
  }
  
  public static int a(AppRuntime paramAppRuntime)
  {
    return ApolloManagerServiceImpl.get3dWhiteListStatus(paramAppRuntime);
  }
  
  public static ISpriteScriptManager a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    return (ISpriteScriptManager)paramAppRuntime.getRuntimeService(ISpriteScriptManager.class, "all");
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
          paramString1.put("errCode", 0);
          paramQQAppInterface = new HandleResult();
          paramQQAppInterface.b = true;
          paramQQAppInterface.jdField_a_of_type_JavaLangString = paramString1.toString();
          return paramQQAppInterface;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("[cmshow][scripted]SpriteUtil", 1, paramString1, new Object[0]);
        return null;
      }
      boolean bool = false;
    }
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
    try
    {
      if (paramSpriteContext.a() == null) {
        return null;
      }
      JSONObject localJSONObject1 = new JSONObject(new JSONObject(paramString).optString("basicMsg"));
      ApolloMessage localApolloMessage = new ApolloMessage();
      localApolloMessage.id = localJSONObject1.optInt("id");
      paramString = localJSONObject1.optString("name");
      boolean bool = TextUtils.isEmpty(paramString);
      if (!bool) {
        localApolloMessage.name = Base64Util.decode(paramString.getBytes("utf-8"), 0);
      }
      localApolloMessage.flag = localJSONObject1.optInt("flag");
      localApolloMessage.peerStatus = localJSONObject1.optInt("peerStatus");
      localApolloMessage.senderStatus = localJSONObject1.optInt("senderStatus");
      localApolloMessage.peerTs = localJSONObject1.optLong("peerTS");
      localApolloMessage.senderTs = localJSONObject1.optLong("senderTS");
      localApolloMessage.peerUin = localJSONObject1.optLong("peerUin");
      paramString = localJSONObject1.optString("atText");
      if (!paramString.isEmpty()) {
        localApolloMessage.text = Base64Util.decode(paramString.getBytes("utf-8"), 0);
      }
      Object localObject = localJSONObject1.optJSONObject("extraStr");
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("extendJson");
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = new JSONObject();
      }
      if (localJSONObject2 != null) {
        paramString.put("extendJson", localJSONObject2);
      }
      localApolloMessage.extStr = paramString.toString();
      paramSpriteContext = ApolloMessageUtilImpl.createSendMsg_ApolloAction(paramSpriteContext.a(), paramSpriteContext.a().a.jdField_a_of_type_JavaLangString, paramSpriteContext.a().a.b, paramSpriteContext.a, localApolloMessage);
      paramSpriteContext.inputText = paramString.optString("inputText");
      paramSpriteContext.audioId = paramString.optInt("audioID");
      if (paramString.has("audioStartTime")) {
        paramSpriteContext.audioStartTime = ((float)paramString.optDouble("audioStartTime"));
      }
      paramSpriteContext.actionType = paramString.optInt("actionType");
      paramSpriteContext.msgType = paramString.optInt("msgTyep");
      paramSpriteContext.welcomeId = paramString.optLong("welcomeId");
      paramSpriteContext.curUsedIdType = localJSONObject1.optInt("curUsedIdType");
      if (localJSONObject2 != null) {
        paramSpriteContext.extendJson = localJSONObject2.toString();
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
    catch (Throwable paramString)
    {
      QLog.e("[cmshow][scripted]SpriteUtil", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  public static IApolloRunnableTask a(String paramString, int paramInt, ApolloEngine paramApolloEngine)
  {
    return new SpriteUtil.1(paramString, paramApolloEngine, paramInt);
  }
  
  public static ISpriteBridge a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    paramAppRuntime = a(paramAppRuntime);
    if (paramAppRuntime == null) {
      return null;
    }
    return paramAppRuntime.getSpriteBridge();
  }
  
  public static ISpriteContext a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    return ((ISpriteScriptManager)paramAppRuntime.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteContext();
  }
  
  public static SpriteActionScript a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    return (SpriteActionScript)((SpriteScriptManagerImpl)a(paramAppRuntime)).getSpriteCreator().b(0);
  }
  
  public static SpriteRscBuilder a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    return ((SpriteScriptManagerImpl)a(paramAppRuntime)).getRscBuilder();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteUtil", 2, new Object[] { "[getSpriteName], uin:", paramString1, ",sessionType:", Integer.valueOf(paramInt), ",groupUin:", paramString2, ",isNeedRemark:", Boolean.valueOf(paramBoolean) });
    }
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return "";
      }
      if (!"-1".equals(paramString1))
      {
        if ("-2".equals(paramString1)) {
          return "";
        }
        if (-1 == paramInt)
        {
          paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramString1, true);
        }
        else
        {
          Object localObject;
          if (CmShowAioMatcherImpl.judgeSupported(paramInt, 2))
          {
            if (paramBoolean) {
              paramString2 = ContactUtils.b(paramQQAppInterface, paramString2, paramString1);
            } else {
              paramString2 = ContactUtils.a(paramQQAppInterface, paramString2, paramString1);
            }
            if (!TextUtils.isEmpty(paramString2))
            {
              localObject = paramString2;
              if (!paramString2.equals(paramString1)) {}
            }
            else
            {
              localObject = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1);
              if (localObject != null)
              {
                paramQQAppInterface = ((Friends)localObject).name;
                break label287;
              }
              ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString1, false);
              localObject = paramString2;
            }
          }
          else
          {
            if (!CmShowAioMatcherImpl.judgeSupported(paramInt, 1)) {
              break label283;
            }
            if (paramBoolean) {
              paramString2 = ContactUtils.i(paramQQAppInterface, paramString1);
            } else {
              paramString2 = ContactUtils.b(paramQQAppInterface, paramString1, true);
            }
            localObject = paramString2;
            if (paramString1.equals(paramString2))
            {
              ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString1, false);
              localObject = paramString2;
            }
          }
          paramQQAppInterface = (QQAppInterface)localObject;
          break label287;
          label283:
          paramQQAppInterface = "";
        }
        label287:
        paramString2 = paramQQAppInterface;
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          paramString2 = paramQQAppInterface.replace("\\", "").replace("'", "").replace("\"", "");
        }
        paramQQAppInterface = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramQQAppInterface = paramString1;
        }
        return paramQQAppInterface;
      }
    }
    return "";
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
    if (BaseApplicationImpl.sProcessId != 1) {
      return;
    }
    AppRuntime localAppRuntime = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
    if (localAppRuntime == null) {
      return;
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = -100;
    }
    ((IApolloMessageService)localAppRuntime.getRuntimeService(IApolloMessageService.class, "all")).reportTraceSpanMsg(i, paramVarArgs);
  }
  
  public static void a(ISpriteContext paramISpriteContext, List<SpriteTaskParam> paramList)
  {
    paramISpriteContext = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getAppInterface();
    if ((paramISpriteContext != null) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      paramISpriteContext = a(paramISpriteContext);
      if (paramISpriteContext == null) {
        return;
      }
      ((SpriteBridge)paramISpriteContext.getSpriteBridge()).a(paramList);
    }
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
    if (paramApolloActionData != null) {
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramApolloActionData.a();
    }
    paramSpriteDrawerInfoManager.a().b(localSpriteTaskParam);
  }
  
  public static void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, String paramString, int paramInt1, int paramInt2)
  {
    if (paramSpriteDrawerInfoManager != null)
    {
      if (paramSpriteDrawerInfoManager.a() == null) {
        return;
      }
      SpriteActionScript localSpriteActionScript = paramSpriteDrawerInfoManager.a();
      paramSpriteDrawerInfoManager.a().a(paramInt1);
      paramSpriteDrawerInfoManager = paramSpriteDrawerInfoManager.a();
      int i = 1;
      if (paramSpriteDrawerInfoManager != null) {
        i = ((IApolloManagerService)paramSpriteDrawerInfoManager.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramSpriteDrawerInfoManager.getCurrentUin());
      }
      localSpriteActionScript.a("", paramString, a(paramInt1, paramInt2, paramString, i));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      ISpriteContext localISpriteContext = a(paramQQAppInterface);
      if (localISpriteContext == null) {
        return;
      }
      int j = localISpriteContext.b();
      String str1 = "1";
      if ((1 != j) && (3000 != j))
      {
        if (j == 0)
        {
          if (TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {
            str1 = "0";
          }
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "msg_clk", paramSpriteTaskParam.jdField_a_of_type_Boolean ^ true, 0, new String[] { Integer.toString(paramSpriteTaskParam.f), str1, "", String.valueOf(System.currentTimeMillis() / 1000L), localISpriteContext.b() });
        }
      }
      else
      {
        int i;
        if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString))
        {
          if (paramSpriteTaskParam.b) {
            i = 2;
          } else {
            i = 1;
          }
        }
        else {
          i = 0;
        }
        boolean bool = paramSpriteTaskParam.jdField_a_of_type_Boolean;
        j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(j);
        String str2 = Integer.toString(paramSpriteTaskParam.f);
        if (paramSpriteTaskParam.e == 0) {
          str1 = "0";
        }
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "g_msg_clk", bool ^ true, j, new String[] { str2, str1, String.valueOf(i), String.valueOf(System.currentTimeMillis() / 1000L), localISpriteContext.b() });
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = a(paramAppRuntime);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime.d(true);
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject = ApolloUtilImpl.getQQApp();
    if (!TextUtils.isEmpty(paramString1))
    {
      if (localObject == null) {
        return false;
      }
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
      if ((!TextUtils.isEmpty(paramString3)) && (paramString3.length() > 4))
      {
        if ((paramString1.equals(paramString3)) && (paramString1.equals(localObject)) && (!paramString1.equals(paramString2))) {
          return true;
        }
        return (paramString1.equals(paramString2)) && (paramBoolean);
      }
      if ((!TextUtils.isEmpty(paramString2)) && (paramString1.equals(localObject))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime);
    if (paramAppRuntime == null) {
      return true;
    }
    return paramAppRuntime.a();
  }
  
  public static boolean a(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    ICmShowAioMatcher.AioSupported localAioSupported = CmShowAioMatcherImpl.match(paramInt);
    if (localAioSupported == null)
    {
      QLog.d("[cmshow][scripted]SpriteUtil", 2, "cmshow NOT support, not friend or troop or discussion.");
      return false;
    }
    return localAioSupported.a(paramAppRuntime, paramString);
  }
  
  public static boolean a(AppRuntime paramAppRuntime, @NonNull Scene paramScene)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    if (!((IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteUtil", 2, "NOT allowed to use cmshow.");
      }
      return false;
    }
    return CMShowPlatform.a.a(paramScene);
  }
  
  public static int b()
  {
    return (int)DeviceInfoUtil.i();
  }
  
  public static boolean b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime);
    return (paramAppRuntime == null) || (paramAppRuntime.b());
  }
  
  public static boolean b(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    int i = TraceReportUtil.a(0);
    if (!a(paramAppRuntime, Scene.AIO))
    {
      TraceReportUtil.a(i, 10, 102, new Object[] { "not meet basic case" });
      QLog.i("[cmshow][scripted]SpriteUtil", 1, "not meet basic case.");
      return false;
    }
    if (2 == ((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(paramAppRuntime.getCurrentUin(), paramAppRuntime))
    {
      TraceReportUtil.a(i, 10, 101, new Object[] { "cmshow switch NOT opend CLOSED_STATUS" });
      QLog.i("[cmshow][scripted]SpriteUtil", 1, "cmshow switch NOT opend.");
      return false;
    }
    if (AnonymousChatHelper.a().a(paramString))
    {
      TraceReportUtil.a(i, 10, 104, new Object[] { "aio anonymous" });
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteUtil", 2, "aio anonymous.");
      }
      return false;
    }
    if (!a(paramAppRuntime, paramInt, paramString)) {
      return false;
    }
    return !b(paramAppRuntime);
  }
  
  public static boolean c(AppRuntime paramAppRuntime)
  {
    return (!b(paramAppRuntime)) && (CmShowWnsUtils.f());
  }
  
  public static boolean d(AppRuntime paramAppRuntime)
  {
    if (!a(paramAppRuntime, Scene.DRAWER))
    {
      QLog.i("[cmshow][scripted]SpriteUtil", 1, "not meet basic case.");
      return false;
    }
    if (1 != ((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(paramAppRuntime.getCurrentUin(), paramAppRuntime))
    {
      QLog.i("[cmshow][scripted]SpriteUtil", 1, "cmshow switch NOT opend.");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUtil
 * JD-Core Version:    0.7.0.1
 */