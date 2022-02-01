package com.tencent.mobileqq.apollo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloDress;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameMsgInfo;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameTool;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApolloGameBasicEventUtil
{
  public static long a;
  public static String[] a;
  public static String[] b;
  public static String[] c;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "117.144.242.75", "117.144.245.207" };
    b = new String[] { "14.17.42.125", "59.37.96.212", "180.163.32.167", "101.226.90.166" };
    c = new String[] { "58.250.137.13", "163.177.90.55", "140.206.160.112", "140.207.123.182" };
    jdField_a_of_type_Long = 0L;
  }
  
  public static int a()
  {
    int i = 10060;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "[getRecommendIp]");
    }
    int j = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getInt("game_rec_port", 10060);
    if (j <= 0) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameBasicEventUtil", 2, "recom_port:" + i);
      }
      return i;
      i = j;
    }
  }
  
  public static String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "[getRecommendIp]");
    }
    String str2 = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getString("game_rec_ip", "");
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "recom_ip:" + str2);
    }
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str2 = b();
      str1 = str2;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloGameBasicEventUtil", 2, "random_ip:" + str2);
        str1 = str2;
      }
    }
    return str1;
  }
  
  public static String a(String[] paramArrayOfString)
  {
    String str1 = "14.17.42.125";
    if (paramArrayOfString != null) {}
    for (;;)
    {
      try
      {
        int i = paramArrayOfString.length;
        if (i != 0) {
          continue;
        }
        paramArrayOfString = str1;
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloGameBasicEventUtil", 2, "[getRandomIp], retIp:" + "14.17.42.125");
          paramArrayOfString = str1;
        }
      }
      catch (Exception paramArrayOfString)
      {
        String str2;
        QLog.e("ApolloGameBasicEventUtil", 1, "[getRandomIp], errInfo->" + paramArrayOfString.getMessage());
        return "14.17.42.125";
      }
      finally
      {
        paramArrayOfString = str1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloGameBasicEventUtil", 2, "[getRandomIp], retIp:" + "14.17.42.125");
      }
      return paramArrayOfString;
      str2 = paramArrayOfString[com.tencent.mobileqq.magicface.drawable.PngFrameUtil.a(paramArrayOfString.length)];
      paramArrayOfString = str2;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloGameBasicEventUtil", 2, "[getRandomIp], retIp:" + str2);
        return str2;
      }
    }
    return "14.17.42.125";
  }
  
  public static JSONObject a(int paramInt, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return null;
    }
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject();
        try
        {
          Object localObject = new JSONObject();
          if (paramInt == 0)
          {
            ((JSONObject)localObject).put("atlas", "def/basic/skeleton/role");
            ((JSONObject)localObject).put("json", "def/basic/skeleton/role");
            localJSONObject1.put("skltPath", localObject);
            localObject = new JSONArray();
            int j = paramArrayOfInt.length;
            int i = 0;
            if (i >= j) {
              continue;
            }
            localInteger = Integer.valueOf(paramArrayOfInt[i]);
            localJSONObject2 = new JSONObject();
            if (paramInt != 0) {
              continue;
            }
            localJSONObject2.put("atlas", "def/basic/dress/" + localInteger + "/dress");
            localJSONObject2.put("json", "def/basic/dress/" + localInteger + "/dress");
            ((JSONArray)localObject).put(localJSONObject2);
            i += 1;
            continue;
          }
          ((JSONObject)localObject).put("atlas", ApolloActionHelperImpl.getResAddPrefixPath(paramInt + "/role", 1));
          ((JSONObject)localObject).put("json", ApolloActionHelperImpl.getResAddPrefixPath(paramInt + "/role", 1));
          continue;
          QLog.e("ApolloGameBasicEventUtil", 1, "[notifyRoleDress], errInfo->" + localException1.getMessage());
        }
        catch (Exception localException1)
        {
          paramArrayOfInt = localJSONObject1;
        }
      }
      catch (Exception localException2)
      {
        JSONObject localJSONObject1;
        Integer localInteger;
        JSONObject localJSONObject2;
        paramArrayOfInt = null;
        continue;
      }
      return paramArrayOfInt;
      localJSONObject2.put("atlas", ApolloActionHelperImpl.getResAddPrefixPath(localInteger + "/dress", 2));
      localJSONObject2.put("json", ApolloActionHelperImpl.getResAddPrefixPath(localInteger + "/dress", 2));
    }
    localJSONObject1.put("dressPath", localException1);
    return localJSONObject1;
  }
  
  public static void a(int paramInt1, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt2, String paramString3, ApolloGameBasicEventUtil.NotifyGameDressReady paramNotifyGameDressReady)
  {
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    Object localObject = localApolloManagerServiceImpl.getApolloBaseInfo(paramString1);
    if (localObject != null)
    {
      paramInt2 = ((ApolloBaseInfo)localObject).apolloStatus;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameBasicEventUtil", 2, "uin: " + ((ApolloBaseInfo)localObject).uin + ", funcSwitch:" + paramInt2);
      }
      localObject = ((ApolloBaseInfo)localObject).getApolloDress(false);
      int i;
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        paramInt2 = 0;
        i = 0;
        if (paramInt2 < j)
        {
          ApolloDress localApolloDress = localObject[paramInt2];
          i = localApolloDress.mRoleGender;
          int[] arrayOfInt = localApolloDress.getDressIds();
          if ((ApolloActionHelperImpl.isRscValid(paramString1, localApolloDress.roleId, arrayOfInt, paramQQAppInterface, new ApolloGameBasicEventUtil.4(paramNotifyGameDressReady, paramInt1, paramQQAppInterface, paramString2, paramString3, localApolloDress, arrayOfInt))) && (localApolloDress.roleId != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloGameBasicEventUtil", 2, "valid role and dress RSC.");
            }
            if (paramNotifyGameDressReady != null) {
              paramNotifyGameDressReady.a(paramInt1, paramQQAppInterface, paramString1, paramString2, paramString3, localApolloDress.roleId, arrayOfInt, 3);
            }
          }
        }
      }
      label296:
      label447:
      label451:
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameBasicEventUtil", 2, "try to get history dress ....");
        }
        paramInt2 += 1;
        break;
        if (paramNotifyGameDressReady != null)
        {
          if (i == 2)
          {
            paramInt2 = 2;
            paramNotifyGameDressReady.a(paramInt1, paramQQAppInterface, paramString1, paramString2, paramString3, paramInt2, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(paramInt2), 1);
          }
        }
        else
        {
          localApolloManagerServiceImpl.checkUserDress(paramQQAppInterface, paramString1, "apllo_game");
          paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if ((paramQQAppInterface == null) || (paramQQAppInterface.b(paramString1))) {
            continue;
          }
          paramQQAppInterface = localApolloManagerServiceImpl.getApolloBaseInfo(paramString1);
          if (paramQQAppInterface == null) {
            break label447;
          }
        }
        for (long l = paramQQAppInterface.apolloUpdateTime;; l = 0L)
        {
          if (NetConnInfoCenter.getServerTime() - l <= 300L) {
            break label451;
          }
          localApolloManagerServiceImpl.addToBulkPullMap(paramString1, 2);
          return;
          paramInt2 = 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameBasicEventUtil", 2, "uin: " + paramString1 + " dress is null,try to pull player's dress info.");
          }
          localApolloManagerServiceImpl.checkUserDress(paramQQAppInterface, paramString1, "apllo_game");
          if (paramNotifyGameDressReady == null) {
            break label296;
          }
          paramNotifyGameDressReady.a(paramInt1, paramQQAppInterface, paramString1, paramString2, paramString3, 1, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(1), 1);
          break label296;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "warning: apolloBaseInfo or apolloBaseInfo.apolloDress is NULL, fail to get role info. apolloBaseInfo:" + localObject);
    }
    if (paramNotifyGameDressReady != null) {
      paramNotifyGameDressReady.a(paramInt1, paramQQAppInterface, paramString1, paramString2, paramString3, paramInt2, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(paramInt2), 1);
    }
    localApolloManagerServiceImpl.checkUserDress(paramQQAppInterface, paramString1, "apllo_game");
  }
  
  public static void a(int paramInt, String paramString, Activity paramActivity)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {}
    int i;
    ApolloGameMsgInfo localApolloGameMsgInfo;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("cmgame.sendmsg", 2, new Object[] { "[sendGameShareMsg],json:", paramString });
      }
      long l;
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("gameMode");
        l = paramString.optLong("roomId");
        localApolloGameMsgInfo = new ApolloGameMsgInfo();
        localObject1 = CmGameUtil.a(paramInt);
        if (localObject1 != null)
        {
          localObject1 = ((CmGameLauncher)localObject1).a();
          if ((localObject1 != null) && (((CmGameStartChecker.StartCheckParam)localObject1).game != null))
          {
            localApolloGameMsgInfo.actionId = ((CmGameStartChecker.StartCheckParam)localObject1).game.actionId;
            localApolloGameMsgInfo.gameName = ((CmGameStartChecker.StartCheckParam)localObject1).game.name;
          }
        }
        if (localApolloGameMsgInfo.actionId <= 0) {
          localApolloGameMsgInfo.actionId = 439;
        }
        localApolloGameMsgInfo.gameId = paramInt;
        localApolloGameMsgInfo.actionName = HardCodeUtil.a(2131700447);
        localApolloGameMsgInfo.gameMode = i;
        localApolloGameMsgInfo.roomId = l;
        localApolloGameMsgInfo.msgType = 4;
        Object localObject2 = paramString.optString("extendInfo");
        localObject1 = new JSONObject();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).put("extendInfo", localObject2);
        }
        localObject2 = paramString.optString("summary");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).put("summary", localObject2);
        }
        localObject2 = paramString.optString("picUrl");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).put("picUrl", localObject2);
        }
        ((JSONObject)localObject1).put("xyRootSrc", ApolloGameTool.a(paramInt));
        i = paramString.optInt("activityId");
        int j = paramString.optInt("reqCode");
        localObject2 = CmGameUtil.a(paramInt);
        if (localObject2 != null)
        {
          ((CmGameLauncher)localObject2).b = i;
          ((CmGameLauncher)localObject2).c = j;
        }
        localApolloGameMsgInfo.gameExtendJson = ((JSONObject)localObject1).toString();
        if (localApolloGameMsgInfo.gameExtendJson.length() >= 500)
        {
          QLog.w("cmgame.sendmsg", 1, "extendInfo is too long, len:" + localApolloGameMsgInfo.gameExtendJson.length() + ",content:" + localApolloGameMsgInfo.gameExtendJson);
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmgame.sendmsg", 1, paramString, new Object[0]);
        return;
      }
      i = paramString.optInt("isSelectFriend");
      if (!paramString.has("isSelectFriend")) {
        i = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmgame.sendmsg", 2, new Object[] { "isSelectFriend:", Integer.valueOf(i) });
      }
      Object localObject1 = CmGameMainManager.a();
      if ((localObject1 != null) && (((CmGameMainManager)localObject1).a != null) && (0L != l)) {
        ((CmGameMainManager)localObject1).a.roomId = l;
      }
      if (i == 0)
      {
        paramString.put("msgType", 4);
        CmGameToolCmdChannel.a("cs.send_game_msg.local", paramString.toString(), true, null, paramInt);
        return;
      }
    } while (1 != i);
    a(localApolloGameMsgInfo, paramActivity, 3);
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    Object localObject = ApolloManagerServiceImpl.sApolloGameStkey;
    paramQQAppInterface = ApolloManagerServiceImpl.sApolloGameSt;
    paramString = a(((String)localObject).getBytes(), paramString.getBytes());
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("data", paramString.toString());
      ((JSONObject)localObject).put("st", paramQQAppInterface);
      ApolloUtilImpl.getCmdChannel().callbackFromRequest(paramLong, 0, "cs.encrypt_data.local", ((JSONObject)localObject).toString());
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      QLog.e("ApolloGameBasicEventUtil", 2, "doEncrypt fail e:" + paramQQAppInterface.toString());
    }
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    try
    {
      paramString2 = new JSONObject(paramString2).optString("uin");
      if (!TextUtils.isEmpty(paramString2)) {
        QLog.i("ApolloGameBasicEventUtil", 1, "pass uin.");
      }
      for (;;)
      {
        a(paramLong, paramQQAppInterface, paramString2, "", 1, paramString1, new ApolloGameBasicEventUtil.1());
        return;
        QLog.w("ApolloGameBasicEventUtil", 1, "This branch cann't be reached. If so, something illegal must have been happening.");
        paramString2 = "";
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[getUsrDressInfo], errInfo->" + paramQQAppInterface.getMessage());
    }
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady)
  {
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    Object localObject = localApolloManagerServiceImpl.getApolloBaseInfo(paramString1);
    if (localObject != null)
    {
      paramInt = ((ApolloBaseInfo)localObject).apolloStatus;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameBasicEventUtil", 2, "uin: " + ((ApolloBaseInfo)localObject).uin + ", funcSwitch:" + paramInt);
      }
      localObject = ((ApolloBaseInfo)localObject).getApolloDress(false);
      int i;
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        paramInt = 0;
        i = 0;
        if (paramInt < j)
        {
          ApolloDress localApolloDress = localObject[paramInt];
          i = localApolloDress.mRoleGender;
          int[] arrayOfInt = localApolloDress.getDressIds();
          if ((ApolloActionHelperImpl.isRscValid(paramString1, localApolloDress.roleId, arrayOfInt, paramQQAppInterface, new ApolloGameBasicEventUtil.3(paramNotifyDressReady, paramLong, paramQQAppInterface, paramString2, paramString3, localApolloDress, arrayOfInt))) && (localApolloDress.roleId != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloGameBasicEventUtil", 2, "valid role and dress RSC.");
            }
            if (paramNotifyDressReady != null) {
              paramNotifyDressReady.a(paramLong, paramQQAppInterface, paramString1, paramString2, paramString3, localApolloDress.roleId, arrayOfInt, 3);
            }
          }
        }
      }
      label299:
      label449:
      label452:
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameBasicEventUtil", 2, "try to get history dress ....");
        }
        paramInt += 1;
        break;
        if (paramNotifyDressReady != null)
        {
          if (i == 2)
          {
            paramInt = 2;
            paramNotifyDressReady.a(paramLong, paramQQAppInterface, paramString1, paramString2, paramString3, paramInt, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(paramInt), 1);
          }
        }
        else
        {
          localApolloManagerServiceImpl.checkUserDress(paramQQAppInterface, paramString1, "apllo_game");
          paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if ((paramQQAppInterface == null) || (paramQQAppInterface.b(paramString1))) {
            continue;
          }
          paramQQAppInterface = localApolloManagerServiceImpl.getApolloBaseInfo(paramString1);
          if (paramQQAppInterface == null) {
            break label449;
          }
        }
        for (paramLong = paramQQAppInterface.apolloUpdateTime;; paramLong = 0L)
        {
          if (NetConnInfoCenter.getServerTime() - paramLong <= 300L) {
            break label452;
          }
          localApolloManagerServiceImpl.addToBulkPullMap(paramString1, 2);
          return;
          paramInt = 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameBasicEventUtil", 2, "uin: " + paramString1 + " dress is null,try to pull player's dress info.");
          }
          localApolloManagerServiceImpl.checkUserDress(paramQQAppInterface, paramString1, "apllo_game");
          if (paramNotifyDressReady == null) {
            break label299;
          }
          paramNotifyDressReady.a(paramLong, paramQQAppInterface, paramString1, paramString2, paramString3, 1, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(1), 1);
          break label299;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "warning: apolloBaseInfo or apolloBaseInfo.apolloDress is NULL, fail to get role info. apolloBaseInfo:" + localObject);
    }
    if (paramNotifyDressReady != null) {
      paramNotifyDressReady.a(paramLong, paramQQAppInterface, paramString1, paramString2, paramString3, paramInt, ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(paramInt), 1);
    }
    localApolloManagerServiceImpl.checkUserDress(paramQQAppInterface, paramString1, "apllo_game");
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, new Object[] { "[openFloatTransparentView] context=", paramContext, ", jsonStr=", paramString });
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject(paramString);
      paramString = localJSONObject1.getString("url");
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("ApolloGameBasicEventUtil", 1, "[openFloatTransparentView] openUrl null");
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[openFloatTransparentView] exception=", paramContext);
      return;
    }
    Object localObject = paramString;
    if (localJSONObject1.has("param"))
    {
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("param");
      localObject = paramString;
      if (localJSONObject2 != null)
      {
        localObject = localJSONObject2.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          paramString = com.tencent.util.URLUtil.a(paramString, str, localJSONObject2.getString(str));
        }
      }
    }
    for (;;)
    {
      int i = localJSONObject1.optInt("closeBtn");
      int j = localJSONObject1.optInt("fullScreen");
      paramString = new Intent(paramContext, ApolloFloatActivity.class);
      paramString.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      paramString.putExtra("extra_key_click_time", System.currentTimeMillis());
      paramString.putExtra("extra_key_weburl", (String)localObject);
      if (i == 1)
      {
        bool = true;
        paramString.putExtra("extra_key_close_btn", bool);
        if (j != 1) {
          break label284;
        }
      }
      label284:
      for (boolean bool = true;; bool = false)
      {
        paramString.putExtra("extra_key_fullscreen", bool);
        paramContext.startActivity(paramString);
        return;
        bool = false;
        break;
      }
      localObject = paramString;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    int j = 0;
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramAppInterface = "";
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        if (!((JSONObject)localObject).has("enter")) {
          break label360;
        }
        i = ((JSONObject)localObject).getInt("enter");
        if (((JSONObject)localObject).has("result")) {
          j = ((JSONObject)localObject).getInt("result");
        }
        if (((JSONObject)localObject).has("actionName")) {
          paramAppInterface = ((JSONObject)localObject).getString("actionName");
        }
        if (!((JSONObject)localObject).has("r2")) {
          break label354;
        }
        paramString = ((JSONObject)localObject).getString("r2");
        if (!((JSONObject)localObject).has("r3")) {
          break label347;
        }
        str1 = ((JSONObject)localObject).getString("r3");
        if (!((JSONObject)localObject).has("r4")) {
          break label340;
        }
        str2 = ((JSONObject)localObject).getString("r4");
        if (((JSONObject)localObject).has("r5"))
        {
          localObject = ((JSONObject)localObject).getString("r5");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameBasicEventUtil", 2, "[reportData2Compass],entry:" + i + ",result:" + j + ",actionName:" + paramAppInterface + ",r2:" + paramString + ",r3:" + str1 + ",r4:" + str2 + ",r5:" + (String)localObject);
          }
          VipUtils.a(null, "cmshow", "Apollo", paramAppInterface, i, j, new String[] { paramString, str1, str2, localObject });
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        QLog.e("ApolloGameBasicEventUtil", 1, "[reportData2Compass], errInfo->" + paramAppInterface.getMessage());
        return;
      }
      Object localObject = "";
      continue;
      label340:
      String str2 = "";
      continue;
      label347:
      String str1 = "";
      continue;
      label354:
      paramString = "";
      continue;
      label360:
      int i = 0;
    }
  }
  
  public static void a(ApolloGameMsgInfo paramApolloGameMsgInfo, Activity paramActivity, int paramInt)
  {
    if (paramApolloGameMsgInfo == null)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[forwardGameMsg], Fail to forward gameMsg, msgInfo is null.");
      return;
    }
    paramApolloGameMsgInfo.print();
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent();
    localBundle.putInt("apollo.game.invite.from", paramInt);
    localBundle.putInt("forward.apollo.gameid", paramApolloGameMsgInfo.gameId);
    localBundle.putInt("forward.apollo.gameMode", paramApolloGameMsgInfo.gameMode);
    localBundle.putInt("forward_type", 34);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "[forwardGameMsg] gameId:" + paramApolloGameMsgInfo.gameId + ";fromtype:" + paramInt);
    }
    if (paramInt == 2)
    {
      localIntent.putExtras(localBundle);
      ForwardBaseOption.a(paramActivity, localIntent, 99999);
      return;
    }
    localBundle.putInt("forward.apollo.actionid", paramApolloGameMsgInfo.actionId);
    localBundle.putLong("forward.apollo.roomid", paramApolloGameMsgInfo.roomId);
    localBundle.putString("forward.apollo.gamename", paramApolloGameMsgInfo.gameName);
    localBundle.putString("forward.apollo.actionname", paramApolloGameMsgInfo.actionName);
    localBundle.putInt("forward.apollo.msgtype", paramApolloGameMsgInfo.msgType);
    localBundle.putString("forward.apollo.sharejson", paramApolloGameMsgInfo.gameExtendJson);
    localIntent.putExtras(localBundle);
    ForwardBaseOption.a(paramActivity, localIntent, 20180426);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    try
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
      paramString = new JSONObject(paramString);
      paramQQAppInterface = "";
      if (paramString.has("ip")) {
        paramQQAppInterface = paramString.getString("ip");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameBasicEventUtil", 2, "[saveRecommendIp], ip:" + paramQQAppInterface);
      }
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        return;
      }
      localSharedPreferences.edit().putString("game_rec_ip", paramQQAppInterface).commit();
      if (paramString.has("port")) {
        i = paramString.getInt("port");
      }
      localSharedPreferences.edit().putInt("game_rec_port", i).commit();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[saveRecommendIp], errInfo->" + paramQQAppInterface.getMessage());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Activity paramActivity)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    while (System.currentTimeMillis() - jdField_a_of_type_Long <= 1000L) {
      return;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame.sendmsg", 2, new Object[] { "[sendCmGameMsg],jsonParam:", paramString });
    }
    label429:
    label438:
    label448:
    label501:
    for (;;)
    {
      JSONObject localJSONObject;
      ApolloGameMsgInfo localApolloGameMsgInfo;
      try
      {
        Object localObject = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        localJSONObject = new JSONObject(paramString);
        int j = localJSONObject.optInt("gameMode");
        int k = localJSONObject.optInt("gameId");
        long l = localJSONObject.optLong("roomId");
        localApolloGameMsgInfo = new ApolloGameMsgInfo();
        ApolloGameData localApolloGameData = ((ApolloDaoManagerServiceImpl)localObject).findGameById(k);
        paramString = HardCodeUtil.a(2131700429);
        if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
        {
          localObject = ((ApolloDaoManagerServiceImpl)localObject).findActionById(localApolloGameData.actionId);
          if (localObject == null) {
            break label501;
          }
          paramString = ((ApolloActionData)localObject).actionName;
          i = localApolloGameData.actionId;
          localApolloGameMsgInfo.gameName = localApolloGameData.name;
          if (0L == l) {
            QLog.w("cmgame.sendmsg", 1, "[sendCmGameMsg] roomId is invalid. gameId:" + k + ",gameMode:" + j);
          }
          localApolloGameMsgInfo.actionName = paramString;
          localApolloGameMsgInfo.actionId = i;
          localApolloGameMsgInfo.gameMode = j;
          localApolloGameMsgInfo.roomId = l;
          localApolloGameMsgInfo.gameId = k;
          i = localJSONObject.optInt("msgType");
          if (i == 0) {
            break label429;
          }
          localApolloGameMsgInfo.msgType = i;
          paramString = CmGameMainManager.a();
          if ((paramString != null) && (paramString.a != null) && (0L != l)) {
            paramString.a.roomId = l;
          }
          paramString = localJSONObject.optString("extendInfo");
          localJSONObject = new JSONObject();
          if (TextUtils.isEmpty(paramString)) {
            break label448;
          }
          localJSONObject.put("extendInfo", paramString);
          if (paramString.length() < 500) {
            break label438;
          }
          QLog.w("cmgame.sendmsg", 1, "[sendCmGameMsg],extendInfo is too long, extendInfo:" + paramString);
          return;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("cmgame.sendmsg", 1, paramQQAppInterface, new Object[0]);
        return;
      }
      localApolloGameMsgInfo.gameName = HardCodeUtil.a(2131700448);
      int i = 0;
      continue;
      localApolloGameMsgInfo.msgType = 3;
      continue;
      localApolloGameMsgInfo.gameExtendJson = localJSONObject.toString();
      paramString = ((FragmentActivity)paramActivity).getChatFragment().a();
      if ((paramString == null) || (paramString.h() >= 7))
      {
        QLog.i("cmgame.sendmsg", 1, "aio is closed, choose a friend to send msg.");
        a(localApolloGameMsgInfo, paramActivity, 3);
        return;
      }
      ApolloGameUtil.a(paramQQAppInterface, localApolloGameMsgInfo, paramString.a());
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        paramString2 = localJSONObject.optString("uin");
        String str = localJSONObject.optString("openId");
        int i = localJSONObject.optInt("gameId");
        if (!TextUtils.isEmpty(paramString2))
        {
          QLog.i("ApolloGameBasicEventUtil", 1, "pass uin.");
          a(paramInt, paramQQAppInterface, paramString2, str, 1, paramString1, new ApolloGameBasicEventUtil.2(i));
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloGameBasicEventUtil", 1, "[getUsrDressInfo], errInfo->" + paramQQAppInterface.getMessage());
        return;
      }
      paramString2 = "";
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, new Object[] { "[sendEventToPage] jsonStr=", paramString });
    }
    Intent localIntent = new Intent("action_apollo_game_event_notify");
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("data", paramString);
    }
    try
    {
      localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, paramString, new Object[] { "[sendEventToPage] failed to send cast" });
    }
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, new Object[] { "[openWebViewWithoutUrl] context=", paramContext, ", jsonStr=", paramString, "gameId:", Integer.valueOf(paramInt1), ",taskId:", Integer.valueOf(paramInt2) });
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    for (;;)
    {
      int i;
      Intent localIntent;
      CmGameLauncher localCmGameLauncher;
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("businessType");
        localIntent = new Intent(paramContext, ApolloFloatActivity.class);
        localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
        localCmGameLauncher = CmGameUtil.a();
        if ((localCmGameLauncher == null) || (localCmGameLauncher.a() == null)) {
          break label724;
        }
        if (localCmGameLauncher.a().game != null) {
          break label726;
        }
      }
      catch (Throwable paramContext)
      {
        QLog.e("ApolloGameBasicEventUtil", 1, paramContext, new Object[] { "[openWebViewWithoutUrl]" });
        return false;
      }
      QLog.e("ApolloGameBasicEventUtil", 1, new Object[] { "[openWebViewWithoutUrl] not bustype", Integer.valueOf(i) });
      localIntent.putExtra("game_busid", "Android.H5");
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(localIntent, 9999);
      }
      paramInt2 = paramString.optInt("gameOrientation");
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = 1;
      }
      if (paramInt1 == 2)
      {
        ApolloUtilImpl.setActivityFadeIn(paramContext, 0, 0);
        break;
        int j = paramString.optInt("gameOrientation");
        i = j;
        if (j == 0) {
          i = 1;
        }
        String str = String.format("https://cmshow.qq.com/apollo/html/game-platform/buy-props.html?_wv=3&adtag=inside_game&gameId=%s&gameOrientation=%s&itemList=%s", new Object[] { Integer.valueOf(localCmGameLauncher.a()), Integer.valueOf(i), URLEncoder.encode(paramString.optString("itemList"), "UTF-8") });
        localIntent.putExtra("extra_key_weburl", str);
        localIntent.putExtra("url", str);
        localIntent.putExtra("extra_key_transparent", paramString.optInt("transparent"));
        localIntent.putExtra("extra_key_fullscreen", true);
        localIntent.putExtra("extra_key_close_btn", true);
        localIntent.putExtra("extra_key_entratation", i);
        localIntent.putExtra("extra_key_from", 1);
        localIntent.putExtra("extra_key_gameid", paramInt1);
        localIntent.putExtra("extra_key_taskid", paramInt2);
        VipUtils.a(null, "cmshow", "Apollo", "open_webpage", 0, 0, new String[] { localCmGameLauncher.a().mGameName });
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloGameBasicEventUtil", 2, new Object[] { "[openWebViewWithoutUrl] url ", str });
          continue;
          str = paramString.optString("url");
          if ((TextUtils.isEmpty(str)) || (!android.webkit.URLUtil.isNetworkUrl(str)))
          {
            QLog.e("ApolloGameBasicEventUtil", 1, "[openWebViewWithoutUrl] ill url " + str);
            return false;
          }
          j = paramString.optInt("gameOrientation");
          i = j;
          if (j == 0) {
            i = 1;
          }
          localIntent.putExtra("url", str);
          localIntent.putExtra("extra_key_weburl", str);
          localIntent.putExtra("extra_key_transparent", paramString.optInt("transparent"));
          localIntent.putExtra("extra_key_fullscreen", true);
          localIntent.putExtra("extra_key_close_btn", false);
          localIntent.putExtra("extra_key_entratation", i);
          localIntent.putExtra("extra_key_from", 1);
          localIntent.putExtra("extra_key_gameid", paramInt1);
          localIntent.putExtra("extra_key_taskid", paramInt2);
          localIntent.addFlags(65536);
          VipUtils.a(null, "cmshow", "Apollo", "open_webpage", 1, 0, new String[] { localCmGameLauncher.a().mGameName });
        }
      }
      else
      {
        if (paramInt1 == 3)
        {
          ApolloUtilImpl.setActivityFadeIn(paramContext, 4, 4);
          break;
        }
        ApolloUtilImpl.setActivityFadeIn(paramContext, 1, 1);
        break;
        label724:
        return false;
        label726:
        switch (i)
        {
        }
      }
    }
    return true;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new Cryptor().encrypt(paramArrayOfByte2, paramArrayOfByte1);
  }
  
  public static int b()
  {
    switch (HwNetworkUtil.getCarrierOperatorType(BaseApplicationImpl.getContext()))
    {
    default: 
      return 0;
    case 2: 
      return 3;
    case 3: 
      return 2;
    }
    return 1;
  }
  
  private static String b()
  {
    String str = ((TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone")).getNetworkOperatorName();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, "[selectProperSvrAddr], opratorName:" + str);
    }
    if (!TextUtils.isEmpty(str))
    {
      if ((HardCodeUtil.a(2131700456).equals(str)) || (str.contains(HardCodeUtil.a(2131700441)))) {
        return a(b);
      }
      if ((HardCodeUtil.a(2131700454).equals(str)) || (str.contains(HardCodeUtil.a(2131700415)))) {
        return a(c);
      }
      if ((HardCodeUtil.a(2131700427).equals(str)) || (str.contains(HardCodeUtil.a(2131700421)))) {
        return a(jdField_a_of_type_ArrayOfJavaLangString);
      }
      return a(b);
    }
    return a(b);
  }
  
  public static void b(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = b(ApolloManagerServiceImpl.sApolloGameStkey.getBytes(), paramString.getBytes());
    try
    {
      paramString = new JSONObject();
      paramString.put("data", paramQQAppInterface.toString());
      ApolloUtilImpl.getCmdChannel().callbackFromRequest(paramLong, 0, "cs.decrypt_data.local", paramString.toString());
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      QLog.e("ApolloGameBasicEventUtil", 2, "doEncrypt fail e:" + paramQQAppInterface.toString());
    }
  }
  
  public static void b(long paramLong, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramQQAppInterface = b();
    try
    {
      paramString2 = new JSONObject();
      paramString2.put("ip", paramQQAppInterface);
      paramString2.put("port", 10060);
      ApolloUtilImpl.getCmdChannel().callbackFromRequest(paramLong, 0, paramString1, paramString2.toString());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[getSvrIpPort], errInfo->" + paramQQAppInterface.getMessage());
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameBasicEventUtil", 2, new Object[] { "[openWebView] context=", paramContext, ", jsonStr=", paramString });
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.getString("url");
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("ApolloGameBasicEventUtil", 1, "[openWebView] openUrl null");
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[openWebView] exception=", paramContext);
      return;
    }
    String str = paramString;
    if (localJSONObject.has("param"))
    {
      localJSONObject = localJSONObject.getJSONObject("param");
      str = paramString;
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        for (;;)
        {
          str = paramString;
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
          paramString = com.tencent.util.URLUtil.a(paramString, str, localJSONObject.getString(str));
        }
      }
    }
    paramString = new Intent(paramContext, QQBrowserActivity.class);
    paramString.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(paramContext, str, -1L, paramString, false, -1);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int i = 0;
    long l1 = 0L;
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    boolean bool = false;
    String str4 = "";
    String str1 = "";
    String str2 = "";
    String str3 = "";
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("tvalue")) {
        i = localJSONObject.getInt("tvalue");
      }
      if (localJSONObject.has("uintp1")) {
        l1 = localJSONObject.getLong("uintp1");
      }
      if (localJSONObject.has("uintp2")) {
        l2 = localJSONObject.getLong("uintp2");
      }
      if (localJSONObject.has("uintp3")) {
        l3 = localJSONObject.getLong("uintp3");
      }
      if (localJSONObject.has("uintp4")) {
        l4 = localJSONObject.getLong("uintp4");
      }
      if (localJSONObject.has("isNeedMac")) {
        bool = localJSONObject.getBoolean("isNeedMac");
      }
      paramString = str4;
      if (localJSONObject.has("puin")) {
        paramString = localJSONObject.getString("puin");
      }
      if (localJSONObject.has("strp1")) {
        str1 = localJSONObject.getString("strp1");
      }
      if (localJSONObject.has("strp2")) {
        str2 = localJSONObject.getString("strp2");
      }
      if (localJSONObject.has("strp3")) {
        str3 = localJSONObject.getString("strp3");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameBasicEventUtil", 2, "[reportData2BackStage],tValue:" + i + ",uintp1:" + l1 + ",uintp2:" + l2 + ",uintp3:" + l3 + ",uintp4:" + l4 + ",isNeedMac:" + bool + ",puin:" + paramString + ",strp1:" + str1 + ",strp2:" + str2 + ",strp3:" + str3);
      }
      ((EcshopReportHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(i, paramString, str1, str2, str3, l1, l2, l3, l4, bool);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ApolloGameBasicEventUtil", 1, "[reportData2BackStage], errInfo->" + paramQQAppInterface.getMessage());
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new Cryptor().decrypt(paramArrayOfByte2, paramArrayOfByte1);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      paramQQAppInterface.getAccount();
      NetworkUtil.b(paramQQAppInterface.getApp());
      try
      {
        paramQQAppInterface = new JSONObject(paramString);
        if (((!paramQQAppInterface.has("isUp")) || (paramQQAppInterface.getInt("isUp") != 1)) || (paramQQAppInterface.has("byteSize"))) {
          paramQQAppInterface.getLong("byteSize");
        }
        if (paramQQAppInterface.has("aioType"))
        {
          paramQQAppInterface.getInt("aioType");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloGameBasicEventUtil", 1, "[reportFlowData], errInfo->" + paramQQAppInterface.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil
 * JD-Core Version:    0.7.0.1
 */