package com.tencent.mobileqq.apollo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloGameArkHandler;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.game.ApolloFragment;
import com.tencent.mobileqq.apollo.game.ApolloFragmentManager;
import com.tencent.mobileqq.apollo.game.ApolloGameConfig;
import com.tencent.mobileqq.apollo.game.ApolloGameConst;
import com.tencent.mobileqq.apollo.game.ApolloGameView;
import com.tencent.mobileqq.apollo.game.ApolloGameView.Director;
import com.tencent.mobileqq.apollo.game.ApolloWebViewFragment;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.task.OnAddOrDeleGameListener;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.data.ApolloGameRoamData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import ytf;
import ytg;
import yti;
import ytj;
import ytk;
import ytl;
import ytm;

public class ApolloGameUtil
{
  public static int a;
  public static SparseArray a;
  public static ApolloGameUtil.CmStartTask a;
  public static int b;
  public static int c = 1;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  public static int a()
  {
    SharedPreferences localSharedPreferences;
    if (jdField_a_of_type_Int == -1)
    {
      localSharedPreferences = a();
      if (localSharedPreferences != null) {
        break label27;
      }
    }
    label27:
    for (int i = ApolloGameConst.jdField_a_of_type_Int;; i = localSharedPreferences.getInt("sp.score.num", ApolloGameConst.jdField_a_of_type_Int))
    {
      jdField_a_of_type_Int = i;
      return jdField_a_of_type_Int;
    }
  }
  
  public static int a(int paramInt)
  {
    int i = 1;
    Object localObject = new File(ApolloConstant.jdField_a_of_type_JavaLangString + "/game/" + String.valueOf(paramInt) + "/gameConfig.json");
    File localFile = new File(ApolloConstant.jdField_a_of_type_JavaLangString + "/game/" + String.valueOf(paramInt) + "/appConfig.json");
    if (((File)localObject).exists())
    {
      localObject = FileUtils.a((File)localObject);
      paramInt = i;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    do
    {
      try
      {
        boolean bool = TextUtils.isEmpty(new JSONObject((String)localObject).optString("enterUrl"));
        paramInt = i;
        if (!bool) {
          paramInt = 2;
        }
        return paramInt;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloGameUtil", 1, localThrowable, new Object[0]);
        return 1;
      }
      paramInt = i;
    } while (!localFile.exists());
    return 3;
  }
  
  public static int a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return 0;
    }
    return BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getInt("sp_key_apollo_game_life" + paramAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static int a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    int i;
    if (paramInt == 0) {
      i = 1;
    }
    do
    {
      return i;
      if (1 == paramInt)
      {
        if ((paramAppInterface != null) && (!TextUtils.isEmpty(paramString)))
        {
          paramAppInterface = (HotChatManager)paramAppInterface.getManager(59);
          if ((paramAppInterface != null) && (paramAppInterface.b(paramString))) {
            return 6;
          }
        }
        return 4;
      }
      i = paramInt;
    } while (3000 != paramInt);
    return 5;
  }
  
  public static int a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    paramChatMessage = (MessageForApollo)paramChatMessage;
    paramQQAppInterface = (ApolloDaoManager)paramQQAppInterface.getManager(154);
    if (a(paramChatMessage.msgType))
    {
      paramQQAppInterface = paramQQAppInterface.a(paramChatMessage.gameId);
      if ((ApolloManager.c("gameSwitch") != 1) || ((paramQQAppInterface != null) && (!ApolloConfigUtils.a("7.6.0", paramQQAppInterface.minVer, paramQQAppInterface.maxVer))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, "play apollo game msg but switch is 0 or version is incorrect");
        }
        return b;
      }
      if ((paramChatMessage.gameId == 1) || (paramChatMessage.gameId == 2)) {
        return b;
      }
      return c;
    }
    return b;
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    long l1 = 0L;
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return l1;
      try
      {
        SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
        if (localSharedPreferences == null) {
          continue;
        }
        long l2 = localSharedPreferences.getLong("apollo_game_roam_ts_v2_" + paramQQAppInterface.getCurrentAccountUin(), 0L);
        l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloGameUtil", 2, "[getGameRoamTS], ts:" + l2);
        l1 = l2;
      }
      finally {}
    }
  }
  
  public static Activity a()
  {
    Activity localActivity = null;
    if (SplashActivity.a != null) {
      localActivity = (Activity)SplashActivity.a.get();
    }
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseActivity.sTopActivity;
    }
    return localObject;
  }
  
  public static SharedPreferences a()
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "noLogin";
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("sp.game" + str1, 0);
  }
  
  public static SparseArray a(EntityManager paramEntityManager)
  {
    int i;
    Object localObject2;
    if (jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, "[getGameReddotMap] from cache");
      }
      paramEntityManager = new SparseArray();
      try
      {
        int k = jdField_a_of_type_AndroidUtilSparseArray.size();
        if (k > 0)
        {
          i = 0;
          while (i < k)
          {
            int m = jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
            SparseArray localSparseArray1 = (SparseArray)jdField_a_of_type_AndroidUtilSparseArray.get(m);
            if ((localSparseArray1 != null) && (localSparseArray1.size() > 0))
            {
              localObject2 = new SparseArray();
              int n = localSparseArray1.size();
              int j = 0;
              while (j < n)
              {
                int i1 = localSparseArray1.keyAt(j);
                ((SparseArray)localObject2).put(i1, (ApolloGameRedDot)localSparseArray1.get(i1));
                j += 1;
              }
              paramEntityManager.put(m, localObject2);
            }
            i += 1;
          }
        }
        return paramEntityManager;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloGameUtil", 1, localThrowable, new Object[] { "[getGameReddotMap]" });
      }
    }
    if (paramEntityManager == null) {
      return null;
    }
    Object localObject1 = paramEntityManager.a(ApolloGameRedDot.class);
    SparseArray localSparseArray2 = new SparseArray();
    Iterator localIterator;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("apolloGameReddot getGameReddotMap, redDots.size:");
      if (localObject1 == null)
      {
        i = 0;
        QLog.d("ApolloGameUtil", 2, i);
      }
    }
    else
    {
      if (localObject1 == null) {
        break label371;
      }
      localIterator = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label371;
      }
      ApolloGameRedDot localApolloGameRedDot = (ApolloGameRedDot)localIterator.next();
      if (localApolloGameRedDot != null)
      {
        if (localApolloGameRedDot.isTimeValid())
        {
          localObject2 = (SparseArray)localSparseArray2.get(localApolloGameRedDot.mGameId);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new SparseArray();
            localSparseArray2.put(localApolloGameRedDot.mGameId, localObject1);
          }
          ((SparseArray)localObject1).put(localApolloGameRedDot.mDotId, localApolloGameRedDot);
          continue;
          i = ((List)localObject1).size();
          break;
        }
        paramEntityManager.b(localApolloGameRedDot);
      }
    }
    label371:
    jdField_a_of_type_AndroidUtilSparseArray = localSparseArray2;
    return localSparseArray2;
  }
  
  public static ApolloGameRedDot a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramInt <= 0)) {
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (paramQQAppInterface == null) {
      return null;
    }
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (SparseArray)paramQQAppInterface.get(paramInt);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
      {
        ArrayList localArrayList = new ArrayList(paramQQAppInterface.size());
        int i = paramQQAppInterface.size();
        paramInt = 0;
        while (paramInt < i)
        {
          int j = paramQQAppInterface.keyAt(paramInt);
          if (paramQQAppInterface.get(j) != null) {
            localArrayList.add(paramQQAppInterface.get(j));
          }
          paramInt += 1;
        }
        if (localArrayList.size() > 0)
        {
          Collections.sort(localArrayList);
          return (ApolloGameRedDot)localArrayList.get(0);
        }
        return null;
      }
      return null;
    }
    return null;
  }
  
  public static ApolloGameRedDot a(SparseArray paramSparseArray)
  {
    if ((paramSparseArray == null) || (paramSparseArray.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList(paramSparseArray.size());
      int j = paramSparseArray.size();
      int i = 0;
      while (i < j)
      {
        int k = paramSparseArray.keyAt(i);
        if (paramSparseArray.get(k) != null) {
          localArrayList.add(paramSparseArray.get(k));
        }
        i += 1;
      }
    } while (localArrayList.size() <= 0);
    Collections.sort(localArrayList);
    return (ApolloGameRedDot)localArrayList.get(0);
  }
  
  private static final ApolloGameRedDot a(AppInterface paramAppInterface, List paramList)
  {
    if (paramAppInterface == null)
    {
      paramAppInterface = null;
      return paramAppInterface;
    }
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin() + "apollo_game_reddot_sp", 0);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      for (;;)
      {
        if (i >= paramList.size()) {
          break label159;
        }
        ApolloGameRedDot localApolloGameRedDot = (ApolloGameRedDot)paramList.get(i);
        String str = a(localApolloGameRedDot);
        if ((localApolloGameRedDot != null) && (!TextUtils.isEmpty(localApolloGameRedDot.mTipsWording)) && (!TextUtils.isEmpty(str)) && (!paramAppInterface.getBoolean(str, false)))
        {
          paramAppInterface = localApolloGameRedDot;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloGameUtil", 2, "[initReddotBubbleTips] find apolloGameReddot:" + localApolloGameRedDot);
          return localApolloGameRedDot;
        }
        i += 1;
      }
    }
    label159:
    return null;
  }
  
  private static String a(ApolloGameRedDot paramApolloGameRedDot)
  {
    if (paramApolloGameRedDot == null) {
      return null;
    }
    return "apollo_game_reddot_hasshow_" + String.valueOf(paramApolloGameRedDot.mGameId) + "_" + String.valueOf(paramApolloGameRedDot.mDotId);
  }
  
  public static ArrayList a(List paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.i("ApolloGameUtil", 2, "msgRcd size is 0.");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      Object localObject = (MessageRecord)paramList.get(i);
      if (!(localObject instanceof MessageForApollo)) {}
      for (;;)
      {
        i -= 1;
        break;
        localObject = (MessageForApollo)localObject;
        if (((MessageForApollo)localObject).roomId == paramLong) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public static List a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    List localList = paramQQAppInterface.a(paramInt).e(paramString, paramInt);
    if ((localList != null) && (localList.size() > 0))
    {
      paramQQAppInterface = localList;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, "in aio, cache size:" + localList.size());
      }
    }
    for (paramQQAppInterface = localList;; paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramInt, new int[] { -2039 }))
    {
      return a(paramQQAppInterface, paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, "NOT in aio.");
      }
    }
  }
  
  public static List a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { "[getNeedPullMsg], friendUin:", paramString, ",curType:", Integer.valueOf(paramInt1), ",createTime:", Long.valueOf(paramLong), ",from:", Integer.valueOf(paramInt2) });
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = paramQQAppInterface.a().a(paramString, paramInt1, null, 10);
      if ((paramString == null) || (paramString.size() <= 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, "[getNeedPullMsg] no message,return.");
        }
        return localArrayList;
      }
      paramInt1 = paramString.size() - 1;
      while (paramInt1 >= 0)
      {
        Object localObject = (MessageRecord)paramString.get(paramInt1);
        if ((localObject instanceof MessageForApollo))
        {
          localObject = (MessageForApollo)localObject;
          if (a(paramQQAppInterface, (MessageForApollo)localObject, paramLong)) {
            localArrayList.add(localObject);
          }
        }
        paramInt1 -= 1;
      }
      return localArrayList;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("ApolloGameUtil", 1, paramQQAppInterface, new Object[0]);
      return localArrayList;
    }
    finally
    {
      paramLong = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, new Object[] { "[getNeedPullMsg] by last 10 messages, costT:", Long.valueOf(paramLong - l), ",pull size:", Integer.valueOf(localArrayList.size()) });
      }
    }
  }
  
  public static List a(QQAppInterface paramQQAppInterface, WeakReference paramWeakReference, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    if (paramWeakReference == null)
    {
      paramLong = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, new Object[] { "[getNeedPullMsg] on stop scroll, costT:", Long.valueOf(paramLong - l), ",pull size:", Integer.valueOf(localArrayList.size()) });
      }
      return localArrayList;
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        paramWeakReference = (AbsListView)paramWeakReference.get();
        if (paramWeakReference == null) {
          return localArrayList;
        }
        j = paramWeakReference.getFirstVisiblePosition();
        k = paramWeakReference.getLastVisiblePosition();
        if (!QLog.isColorLevel()) {
          break label505;
        }
        QLog.d("ApolloGameUtil", 2, new Object[] { "firstVPos:", Integer.valueOf(j), ",lastVPos:", Integer.valueOf(k) });
      }
      catch (Throwable paramQQAppInterface)
      {
        int k;
        Object localObject;
        paramQQAppInterface.printStackTrace();
        QLog.e("ApolloGameUtil", 1, "[getNeedPullMsg],errInfo->" + paramQQAppInterface.getMessage());
        return localArrayList;
        paramLong = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloGameUtil", 2, new Object[] { "[getNeedPullMsg] on stop scroll, costT:", Long.valueOf(paramLong - l), ",pull size:", Integer.valueOf(localArrayList.size()) });
        continue;
      }
      finally
      {
        paramLong = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloGameUtil", 2, new Object[] { "[getNeedPullMsg] on stop scroll, costT:", Long.valueOf(paramLong - l), ",pull size:", Integer.valueOf(localArrayList.size()) });
      }
      if (i <= k)
      {
        localObject = paramWeakReference.getChildAt(i - j);
        if (localObject != null)
        {
          localObject = ((View)localObject).getTag();
          if ((localObject instanceof BaseBubbleBuilder.ViewHolder))
          {
            localObject = (BaseBubbleBuilder.ViewHolder)localObject;
            if ((((BaseBubbleBuilder.ViewHolder)localObject).a instanceof MessageForApollo))
            {
              localObject = (MessageForApollo)((BaseBubbleBuilder.ViewHolder)localObject).a;
              if (a(paramQQAppInterface, (MessageForApollo)localObject, paramLong)) {
                localArrayList.add(localObject);
              }
            }
          }
        }
      }
      else
      {
        label505:
        i = j;
        continue;
      }
      i += 1;
    }
  }
  
  public static List a(EntityManager paramEntityManager)
  {
    if (paramEntityManager == null) {
      return null;
    }
    Object localObject1 = paramEntityManager.a(ApolloGameRedDot.class);
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    int i;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("apolloGameReddot getGameReddotList, redDots.size:");
      if (localObject1 == null)
      {
        i = 0;
        QLog.d("ApolloGameUtil", 2, i);
      }
    }
    else
    {
      if (localObject1 == null) {
        return localArrayList;
      }
      localObject1 = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        return localArrayList;
      }
      localObject2 = (ApolloGameRedDot)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        if (((ApolloGameRedDot)localObject2).isTimeValid())
        {
          localArrayList.add(localObject2);
          continue;
          i = ((List)localObject1).size();
          break;
        }
        paramEntityManager.b((Entity)localObject2);
      }
    }
    return localArrayList;
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new JSONObject(paramString);
        long l = paramString.optLong("taskId");
        paramQQAppInterface = SpriteRscBuilder.a(paramQQAppInterface, paramString);
        if (paramQQAppInterface != null)
        {
          paramString = new JSONObject();
          paramString.put("ret", 0);
          paramString.put("actionInfo", paramQQAppInterface);
          paramString.put("taskId", l);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameUtil", 2, new Object[] { "ReqAction,", paramString.toString() });
          }
          return paramString;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("ApolloGameUtil", 1, paramQQAppInterface, new Object[0]);
      }
    }
    return null;
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_AndroidUtilSparseArray != null)
      {
        jdField_a_of_type_AndroidUtilSparseArray.clear();
        jdField_a_of_type_AndroidUtilSparseArray = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameUtil", 1, "[releaseCache] clear err");
    }
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ThreadManager.post(new ytj(paramString, paramQQAppInterface, paramLong), 5, null, true);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { "[startGameFromQRCode], url:", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramActivity = paramString.split("\\?");
    } while ((paramActivity == null) || (paramActivity.length < 2));
    paramActivity = paramActivity[1];
    try
    {
      paramActivity = new JSONObject(URLDecoder.decode(paramActivity.substring(paramActivity.indexOf('=') + 1), "UTF-8"));
      a(paramQQAppInterface, paramActivity.optInt("gameId"), paramActivity.optLong("roomId"), paramActivity.optInt("gameMode"), paramActivity.optString("extendInfo"), 220);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      QLog.w("ApolloGameUtil", 1, "[startGameFromQRCode], errInfo->" + paramActivity.getMessage());
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    ThreadManager.post(new ytm(paramContext, paramString1, paramString2, paramInt), 5, null, true);
  }
  
  public static void a(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { " [startLightGame] context=", paramContext, ", StartCheckParam=", paramStartCheckParam });
    }
    if ((paramContext == null) && (BaseActivity.sTopActivity != null)) {
      paramContext = BaseActivity.sTopActivity;
    }
    for (;;)
    {
      if ((paramContext == null) || (paramStartCheckParam == null)) {}
      while (!(paramContext instanceof Activity)) {
        return;
      }
      paramStartCheckParam.startT = System.currentTimeMillis();
      Object localObject = CmGameUtil.a();
      if (!(localObject instanceof QQAppInterface))
      {
        QLog.e("ApolloGameUtil", 1, "not QQAppInterface");
        return;
      }
      localObject = (QQAppInterface)localObject;
      if ((ApolloConfigUtils.b != null) && (ApolloConfigUtils.b.contains(Integer.valueOf(paramStartCheckParam.gameId)))) {
        paramStartCheckParam.enableMenu = false;
      }
      CmGameLifeCycle localCmGameLifeCycle = CmGameServerQIPCModule.a().a(paramStartCheckParam.gameId);
      if (localCmGameLifeCycle != null) {
        localCmGameLifeCycle.a((Activity)paramContext, paramStartCheckParam);
      }
      if (jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask == null) {
        jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask = new ApolloGameUtil.CmStartTask((QQAppInterface)localObject, paramStartCheckParam);
      }
      for (;;)
      {
        ThreadManager.remove(jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask);
        ThreadManager.post(jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask, 8, null, false);
        return;
        jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask.a((QQAppInterface)localObject, paramStartCheckParam);
      }
    }
  }
  
  public static void a(FragmentActivity paramFragmentActivity, int paramInt1, ApolloFragment paramApolloFragment, int paramInt2, ApolloGameView paramApolloGameView)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localObject2 = new StringBuilder().append(ApolloConstant.jdField_a_of_type_JavaLangString).append("/game/").append(String.valueOf(paramInt1));
        if (paramInt2 != 2) {
          break label600;
        }
        localObject1 = "/gameConfig.json";
        localObject1 = new File((String)localObject1);
        if (!((File)localObject1).exists()) {
          break label599;
        }
        localObject1 = FileUtils.a((File)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label599;
        }
        localJSONObject = new JSONObject((String)localObject1);
        localObject1 = localJSONObject.optString("enterPath");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label591;
        }
        str1 = ApolloConstant.jdField_a_of_type_JavaLangString + "/game/" + String.valueOf(paramInt1) + "/" + (String)localObject1;
        localObject1 = "file://" + str1;
        String str2 = localJSONObject.optString("enterUrl");
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = str2;
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label599;
        }
        if (URLUtil.isNetworkUrl((String)localObject2))
        {
          localObject1 = "&";
          if (!((String)localObject2).contains("?")) {
            localObject1 = "?";
          }
          localObject1 = (String)localObject2 + (String)localObject1 + "apollo_bk" + "=1";
          ApolloFragmentManager.a().a(paramFragmentActivity, 2131362800);
          paramFragmentActivity = new Intent();
          paramFragmentActivity.putExtra("url", (String)localObject1);
          if ((paramApolloFragment != null) && (paramApolloFragment.isAdded()) && ((paramApolloFragment instanceof ApolloWebViewFragment)))
          {
            WebAccelerateHelper.getInstance().preCheckOffline((String)localObject1);
            WebAccelerateHelper.getInstance().preFetchResource((String)localObject1);
            ((ApolloWebViewFragment)paramApolloFragment).a((String)localObject1);
          }
        }
        else
        {
          if (!URLUtil.isFileUrl((String)localObject2)) {
            break label599;
          }
          localObject1 = new File(str1);
          if ((((File)localObject1).exists()) && (((File)localObject1).getAbsolutePath().startsWith(AppConstants.aJ + ".apollo/game/" + String.valueOf(paramInt1)))) {
            continue;
          }
          if (!QLog.isColorLevel()) {
            break label599;
          }
          QLog.d("ApolloGameUtil", 2, str1);
          return;
        }
      }
      catch (Throwable paramFragmentActivity)
      {
        QLog.e("ApolloGameUtil", 1, paramFragmentActivity, new Object[0]);
        return;
      }
      paramApolloFragment = new ApolloGameView.Director();
      Object localObject2 = localJSONObject.optJSONObject("ui");
      if (localObject2 != null)
      {
        str1 = ((JSONObject)localObject2).optString(ApolloGameView.Director.TITLE);
        if (!TextUtils.isEmpty(str1)) {
          paramApolloFragment.title = str1;
        }
        str1 = ((JSONObject)localObject2).optString(ApolloGameView.Director.FOREGROUND_COLOR);
        if (!TextUtils.isEmpty(str1)) {
          paramApolloFragment.frontColor = str1;
        }
        localObject2 = ((JSONObject)localObject2).optString(ApolloGameView.Director.BACKGROUND_COLOR);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramApolloFragment.bgColor = ((String)localObject2);
        }
      }
      if (paramApolloGameView != null)
      {
        paramApolloGameView.a = paramApolloFragment;
        paramApolloGameView.a();
      }
      paramFragmentActivity.putExtra("Director", paramApolloFragment);
      ApolloFragmentManager.a().a(paramFragmentActivity, ApolloWebViewFragment.class);
      WebAccelerateHelper.getInstance().preGetKey((String)localObject1, paramFragmentActivity, null);
      WebAccelerateHelper.getInstance().preCheckOffline((String)localObject1);
      WebAccelerateHelper.getInstance().preFetchResource((String)localObject1);
      return;
      label591:
      String str1 = "";
      continue;
      label599:
      return;
      label600:
      Object localObject1 = "/appConfig.json";
    }
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {}
    for (;;)
    {
      return;
      SharedPreferences localSharedPreferences = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin() + "apollo_game_reddot_sp", 0);
      long l = localSharedPreferences.getLong("apollo_game_reddot_checkTime", 0L);
      if (System.currentTimeMillis() - l < 21600000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, "checkApolloGameRedDot apolloGameReddot System.currentTimeMillis() - lastCheckTime < APOLLO_GAME_REDDOT_CHECK_INTERVAL");
        }
      }
      else {
        try
        {
          Object localObject = new WebSSOAgent.UniSsoServerReqComm();
          ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
          ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
          ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.0");
          WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
          localUniSsoServerReq.comm.set((MessageMicro)localObject);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("cmd", "apollo_red_dot.get_reddot_info");
          ((JSONObject)localObject).put("from", "android.aio.panel");
          ((JSONObject)localObject).put("touin", paramAppInterface.getLongAccountUin());
          ((JSONObject)localObject).put("busType", 1);
          ((JSONObject)localObject).put("mask", 16777216);
          localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
          localObject = new NewIntent(BaseApplicationImpl.getContext(), WebSSOAgentServlet.class);
          ((NewIntent)localObject).putExtra("extra_cmd", "apollo_red_dot.get_reddot_info");
          ((NewIntent)localObject).putExtra("extra_data", localUniSsoServerReq.toByteArray());
          ((NewIntent)localObject).putExtra("extra_callbackid", MagnifierSDK.a);
          ((NewIntent)localObject).setObserver(new ytg(localSharedPreferences, paramAppInterface));
          paramAppInterface.startServlet((NewIntent)localObject);
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloGameUtil", 2, "checkApolloGameRedDot apolloGameReddot startServlet");
            return;
          }
        }
        catch (Exception paramAppInterface)
        {
          QLog.e("ApolloGameUtil", 1, "checkApolloGameRedDot apolloGameReddot failed ", paramAppInterface);
        }
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { "[saveGameCoinCount] app=", paramAppInterface, ", gameCoinCount=", Integer.valueOf(paramInt) });
    }
    if (paramAppInterface == null) {
      return;
    }
    BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 4).edit().putInt("sp_key_apollo_game_life" + paramAppInterface.getCurrentAccountUin(), paramInt).commit();
  }
  
  public static void a(OnAddOrDeleGameListener paramOnAddOrDeleGameListener, long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, "[handleResultForGameEdit], ret:" + paramLong + ",cmd:" + paramString + ",lis:" + paramOnAddOrDeleGameListener);
    }
    if (paramOnAddOrDeleGameListener == null) {
      return;
    }
    String str = "";
    if ("apollo_aio_game.add_games_to_user_gamepanel".equals(paramString)) {
      if (0L == paramLong) {
        str = "添加成功";
      }
    }
    for (;;)
    {
      paramOnAddOrDeleGameListener.a(paramLong, str);
      return;
      str = "添加失败";
      continue;
      if ("apollo_aio_game.del_games_from_user_gamepanel".equals(paramString)) {
        if (0L == paramLong) {
          str = "删除成功";
        } else {
          str = "删除失败";
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      for (;;)
      {
        return;
        b(paramQQAppInterface);
        Object localObject2 = (RedTouchManager)paramQQAppInterface.getManager(35);
        Object localObject1 = ((RedTouchManager)localObject2).a(ApolloConstant.ae);
        localObject2 = ((RedTouchManager)localObject2).a(ApolloConstant.ag);
        if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() == 1) && (localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1))
        {
          localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameUtil", 2, new Object[] { "[initBubbleRedInfo] game activity red buffer=", localObject1 });
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            try
            {
              Object localObject3 = new JSONObject((String)localObject1);
              localObject1 = ((JSONObject)localObject3).optString("_show_mission");
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                localObject2 = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
                String str = "game_activity_bubble_red_info_shown_" + paramQQAppInterface.getCurrentAccountUin() + "_" + (String)localObject1;
                if (!((SharedPreferences)localObject2).getBoolean(str, false))
                {
                  localObject3 = ((JSONObject)localObject3).optJSONObject("msg");
                  if (localObject3 != null)
                  {
                    localObject3 = ((JSONObject)localObject3).optJSONObject((String)localObject1);
                    if (localObject3 != null)
                    {
                      int i = ((JSONObject)localObject3).optInt("time");
                      localObject3 = ((JSONObject)localObject3).optString("content");
                      if (!TextUtils.isEmpty((CharSequence)localObject3))
                      {
                        localObject3 = new JSONObject((String)localObject3);
                        DrawerPushItem localDrawerPushItem = new DrawerPushItem();
                        localDrawerPushItem.msg_type = 3;
                        localDrawerPushItem.is_reddot = 1;
                        localDrawerPushItem.msg_id = ((String)localObject1);
                        if (((JSONObject)localObject3).has("mainPriority"))
                        {
                          localDrawerPushItem.priority = ((JSONObject)localObject3).optInt("mainPriority");
                          localDrawerPushItem.sub_priority = ((JSONObject)localObject3).optInt("subPriority");
                          localDrawerPushItem.start_ts = ((JSONObject)localObject3).optInt("showTime");
                          localDrawerPushItem.end_ts = ((JSONObject)localObject3).optInt("expireTime");
                          localDrawerPushItem.send_time = i;
                          localDrawerPushItem.content = ((JSONObject)localObject3).optString("bubbleText");
                          localDrawerPushItem.show_counts = ((JSONObject)localObject3).optInt("showCounts");
                          if (QLog.isColorLevel()) {
                            QLog.d("ApolloGameUtil", 2, new Object[] { "[initBubbleRedInfo] add game activity item, content=", localDrawerPushItem.content });
                          }
                          ((ApolloManager)paramQQAppInterface.getManager(152)).c(localDrawerPushItem);
                          ((SharedPreferences)localObject2).edit().putBoolean(str, true).commit();
                          return;
                        }
                      }
                    }
                  }
                }
              }
            }
            catch (Exception paramQQAppInterface) {}
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloGameUtil", 2, "[initBubbleRedInfo] exception, ", paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = 0;
    if (paramQQAppInterface == null) {
      QLog.e("ApolloGameUtil", 1, "[highLightGame] app is null");
    }
    ApolloDaoManager localApolloDaoManager;
    do
    {
      return;
      localApolloDaoManager = (ApolloDaoManager)paramQQAppInterface.getManager(154);
      localObject1 = localApolloDaoManager.g();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break;
      }
      localObject2 = (ApolloGameRoamData)((List)localObject1).get(0);
    } while ((localObject2 != null) && (((ApolloGameRoamData)localObject2).gameId == paramInt));
    Object localObject1 = new LinkedList((Collection)localObject1);
    Object localObject2 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ApolloGameRoamData)((Iterator)localObject2).next();
      if ((localObject3 != null) && (((ApolloGameRoamData)localObject3).gameId == paramInt))
      {
        ((LinkedList)localObject1).remove(localObject3);
        ((LinkedList)localObject1).addFirst(localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, new Object[] { "[highLightGame] ", Integer.valueOf(paramInt) });
        }
      }
    }
    localObject1 = new ArrayList((Collection)localObject1);
    localObject2 = new int[((ArrayList)localObject1).size()];
    Object localObject3 = ((ArrayList)localObject1).iterator();
    paramInt = i;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2[paramInt] = ((ApolloGameRoamData)((Iterator)localObject3).next()).gameId;
      paramInt += 1;
    }
    ((VasExtensionHandler)paramQQAppInterface.a(71)).a(paramQQAppInterface, (int[])localObject2);
    localApolloDaoManager.e();
    localApolloDaoManager.c((ArrayList)localObject1);
    a(paramQQAppInterface, System.currentTimeMillis() / 1000L);
    return;
    QLog.e("ApolloGameUtil", 1, "[highLightGame] no game in list");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      QLog.i("ApolloGameUtil", 1, "[launchGameFromOtherWay], src:" + paramInt3 + ",gameId:" + paramInt1 + ",gameMode:" + paramInt2);
      paramQQAppInterface = "";
      boolean bool = false;
      int i = -1;
      if (paramInt3 == 204)
      {
        paramQQAppInterface = "wechat";
        bool = false;
        i = 2;
      }
      while (BaseActivity.sTopActivity != null)
      {
        paramQQAppInterface = new CmGameStartChecker.StartCheckParam(paramInt1, bool, paramQQAppInterface, paramLong, i, paramInt2, 0, 0, "", paramInt3);
        paramQQAppInterface.extendJson = paramString;
        a(a(), paramQQAppInterface);
        return;
        if (paramInt3 == 220)
        {
          paramQQAppInterface = "qrcode";
          bool = true;
          i = 8;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, "[saveGameRoamTS], ts:" + paramLong);
        }
        SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
        if (localSharedPreferences == null) {
          continue;
        }
        localSharedPreferences.edit().putLong("apollo_game_roam_ts_v2_" + paramQQAppInterface.getCurrentAccountUin(), paramLong).commit();
      }
      finally {}
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    if ((paramQQAppInterface != null) && (paramSessionInfo != null) && (ApolloGameConfig.a("drawer.game", paramQQAppInterface) == ApolloGameConst.b)) {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "more_game_enter_exposure", ApolloUtil.a(paramSessionInfo, paramQQAppInterface), 0, new String[] { String.valueOf(paramInt) });
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ApolloPanel.GameMsgInfo paramGameMsgInfo, SessionInfo paramSessionInfo)
  {
    if ((paramGameMsgInfo == null) || (paramQQAppInterface == null) || (paramSessionInfo == null))
    {
      QLog.e("cmgame.sendmsg", 1, "[sendGameMsg], errInfo->param is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame.sendmsg", 2, new Object[] { "[sendGameMsg], gameId:", Integer.valueOf(paramGameMsgInfo.jdField_e_of_type_Int), ",roomId:", Long.valueOf(paramGameMsgInfo.b), ",extendInfo:", paramGameMsgInfo.jdField_f_of_type_JavaLangString });
    }
    ApolloMessage localApolloMessage = new ApolloMessage();
    if (!TextUtils.isEmpty(paramGameMsgInfo.d)) {
      localApolloMessage.name = paramGameMsgInfo.d.getBytes();
    }
    if (0 == 0) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("gameId", paramGameMsgInfo.jdField_e_of_type_Int);
        ((JSONObject)localObject).put("gameMode", paramGameMsgInfo.g);
        ((JSONObject)localObject).put("roomid", paramGameMsgInfo.b);
        if (paramGameMsgInfo.jdField_e_of_type_Int == 1)
        {
          ((JSONObject)localObject).put("msgTyep", 2);
          ((JSONObject)localObject).put("gameName", paramGameMsgInfo.jdField_e_of_type_JavaLangString);
          if (!TextUtils.isEmpty(paramGameMsgInfo.jdField_f_of_type_JavaLangString)) {
            ((JSONObject)localObject).put("gameExtendJson", paramGameMsgInfo.jdField_f_of_type_JavaLangString);
          }
          if (localObject != null) {
            localApolloMessage.extStr = ((JSONObject)localObject).toString();
          }
          localObject = ((ApolloManager)paramQQAppInterface.getManager(152)).b(paramQQAppInterface.getCurrentAccountUin());
          localApolloMessage.sender_ts = Utils.a(((ApolloBaseInfo)localObject).apolloServerTS);
          localApolloMessage.sender_status = ((ApolloBaseInfo)localObject).apolloStatus;
          localObject = ((ApolloDaoManager)paramQQAppInterface.getManager(154)).a(paramGameMsgInfo.jdField_e_of_type_Int);
          if ((localObject == null) || (1 != ((ApolloGameData)localObject).hasOwnArk)) {
            break label462;
          }
          i = 297;
          localApolloMessage.flag = (i | 0x200);
          paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, paramSessionInfo.jdField_a_of_type_Int, localApolloMessage);
          if (paramGameMsgInfo.jdField_e_of_type_Int == 1)
          {
            paramSessionInfo.msgType = 2;
            paramSessionInfo.gameId = paramGameMsgInfo.jdField_e_of_type_Int;
            paramSessionInfo.mGameMode = paramGameMsgInfo.g;
            paramSessionInfo.roomId = paramGameMsgInfo.b;
            paramSessionInfo.mApolloMessage.id = paramGameMsgInfo.jdField_f_of_type_Int;
            paramSessionInfo.gameName = paramGameMsgInfo.jdField_e_of_type_JavaLangString;
            paramSessionInfo.gameExtendJson = paramGameMsgInfo.jdField_f_of_type_JavaLangString;
            paramQQAppInterface.a().a(paramSessionInfo, null);
          }
        }
        else
        {
          ((JSONObject)localObject).put("msgTyep", paramGameMsgInfo.h);
          continue;
        }
        paramSessionInfo.msgType = paramGameMsgInfo.h;
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.d("cmgame.sendmsg", 2, paramQQAppInterface, new Object[0]);
        return;
      }
      continue;
      label462:
      int i = 41;
      continue;
      Object localObject = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ApolloGameRankData paramApolloGameRankData)
  {
    if ((paramQQAppInterface != null) && (paramApolloGameRankData != null)) {
      ThreadManager.post(new ytl(paramQQAppInterface, paramApolloGameRankData), 8, null, false);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null) {
      return;
    }
    Object localObject = paramMessageForApollo.mApolloMessage;
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    Iterator localIterator;
    try
    {
      localJSONObject = new JSONObject(((ApolloMessage)localObject).extStr);
      localJSONObject.put("gameStatus", paramMessageForApollo.gameStatus);
      localJSONObject.put("roomVol", paramMessageForApollo.roomVol);
      localJSONObject.put("gmUpdateStamp", paramMessageForApollo.gameStatusStamp);
      localJSONObject.put("gameMode", paramMessageForApollo.mGameMode);
      localJSONObject.put("arkInfo", paramMessageForApollo.gameArkInfo);
      localJSONObject.put("commInfo", paramMessageForApollo.commInfo);
      localJSONArray = new JSONArray();
      localIterator = paramMessageForApollo.playerList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put((Long)localIterator.next());
      }
      localJSONObject.put("playerList", localJSONArray);
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      QLog.e("ApolloGameUtil", 1, "fail to update game in db, errInfo->" + paramQQAppInterface.getMessage());
      return;
    }
    switch (paramMessageForApollo.gameStatus)
    {
    }
    for (;;)
    {
      ((ApolloMessage)localObject).extStr = localJSONObject.toString();
      localObject = MessagePkgUtils.a((Serializable)localObject);
      paramQQAppInterface.a().a(paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo.uniseq, (byte[])localObject);
      return;
      localJSONObject.put("winUin", paramMessageForApollo.winnerUin);
      localJSONObject.put("winRecord", paramMessageForApollo.winRecord);
      localJSONObject.put("gameOverType", paramMessageForApollo.overType);
      localJSONArray = new JSONArray();
      localIterator = paramMessageForApollo.winnerList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put((Long)localIterator.next());
      }
      localJSONObject.put("winnerList", localJSONArray);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, "winnerArray:" + localJSONArray);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo, WeakReference paramWeakReference1, WeakReference paramWeakReference2, Bundle paramBundle)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramWeakReference2 = ((ApolloGameManager)paramQQAppInterface.getManager(210)).a();
    if (paramWeakReference2 != null) {
      paramWeakReference2.a(paramMessageForApollo);
    }
    ThreadManager.getUIHandler().post(new ytf(paramWeakReference1, paramMessageForApollo, paramBundle, paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ApolloGameUtil", 1, "[updateRankInfo] app is null");
      return;
    }
    ThreadManager.post(new ytk(paramQQAppInterface, paramString), 5, null, false);
  }
  
  public static void a(EntityManager paramEntityManager)
  {
    if (paramEntityManager != null)
    {
      ThreadManager.post(new yti(paramEntityManager), 5, null, true);
      return;
    }
    QLog.e("ApolloGameUtil", 1, "[loadCache] em is null out ");
  }
  
  public static void a(EntityManager paramEntityManager, int paramInt1, int paramInt2)
  {
    if (paramEntityManager == null) {
      return;
    }
    int i = paramEntityManager.a(ApolloGameRedDot.class.getSimpleName(), "mGameId=? and mDotId=? ", new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2) });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, "apolloGameReddot deleteGameReddot, gameId:" + paramInt1 + ",reddotId:" + paramInt2 + ",ret:" + i);
    }
    a(paramEntityManager);
  }
  
  public static void a(EntityManager paramEntityManager, List paramList)
  {
    if ((paramEntityManager != null) && (paramList != null) && (paramList.size() > 0))
    {
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApolloGameRedDot localApolloGameRedDot = (ApolloGameRedDot)paramList.next();
        if (localApolloGameRedDot != null)
        {
          localApolloGameRedDot.mIsShow = true;
          paramEntityManager.a(localApolloGameRedDot);
        }
      }
      a(paramEntityManager);
    }
  }
  
  public static void a(EntityManager paramEntityManager, boolean paramBoolean)
  {
    if (paramEntityManager == null) {
      return;
    }
    paramBoolean = paramEntityManager.c("update ApolloGameRedDot set mIsShowForFolder = 1");
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { "update ApolloGameRedDot set mIsShowForFolder=true", Boolean.valueOf(paramBoolean) });
    }
    a(paramEntityManager);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3) || (paramInt == 4);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!ApolloManager.a(paramQQAppInterface.getApplication())) {
      return false;
    }
    paramQQAppInterface = ((ApolloManager)paramQQAppInterface.getManager(152)).b(paramQQAppInterface.c());
    return (paramQQAppInterface == null) || (paramQQAppInterface.apolloStatus == 1);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = ((ApolloDaoManager)paramQQAppInterface.getManager(154)).g();
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.iterator();
    while (paramQQAppInterface.hasNext())
    {
      ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)paramQQAppInterface.next();
      if ((localApolloGameRoamData != null) && (localApolloGameRoamData.gameId == paramInt)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo, long paramLong)
  {
    if ((paramMessageForApollo == null) || (paramQQAppInterface == null)) {
      return false;
    }
    if (!a(paramMessageForApollo.msgType)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { "[isMsgNeedPull], msg:", Long.valueOf(paramMessageForApollo.msgseq), ",roomId:", Long.valueOf(paramMessageForApollo.roomId), ",msg.msgType:", Integer.valueOf(paramMessageForApollo.msgType) });
    }
    if (paramMessageForApollo.msgType == 4) {
      return false;
    }
    paramQQAppInterface = ((ApolloDaoManager)paramQQAppInterface.getManager(154)).a(paramMessageForApollo.gameId);
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!ApolloConfigUtils.a("7.6.0", paramQQAppInterface.minVer, paramQQAppInterface.maxVer)) {
      return false;
    }
    boolean bool1;
    boolean bool2;
    label180:
    boolean bool3;
    if (paramMessageForApollo.gameStatusStamp < paramLong)
    {
      bool1 = true;
      if ((paramMessageForApollo.gameStatus != 4) && (paramMessageForApollo.gameStatus != 7) && (paramMessageForApollo.gameStatus != 8)) {
        break label375;
      }
      bool2 = true;
      if (paramMessageForApollo.gameStatus != 5) {
        break label381;
      }
      bool3 = true;
      label191:
      if (paramMessageForApollo.gameStatus != 6) {
        break label387;
      }
    }
    label387:
    for (boolean bool4 = true;; bool4 = false)
    {
      if ((!bool1) || (bool2) || (bool3) || (bool4)) {
        break label393;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, new Object[] { "RoomId ", Long.valueOf(paramMessageForApollo.roomId), " needs pulling from srv,isTimeOverdue:", Boolean.valueOf(bool1), ",isOver:", Boolean.valueOf(bool2), ",isCancel:", Boolean.valueOf(bool4), ",isInValidStatus:", Boolean.valueOf(bool3), ",msg.gameStatusStamp:", Long.valueOf(paramMessageForApollo.gameStatusStamp), ",mCreateTime:", Long.valueOf(paramLong), ",msg.gameStatus:", Integer.valueOf(paramMessageForApollo.gameStatus) });
      }
      return true;
      bool1 = false;
      break;
      label375:
      bool2 = false;
      break label180;
      label381:
      bool3 = false;
      break label191;
    }
    label393:
    if ((paramMessageForApollo.gameStatus == 1) || (paramMessageForApollo.gameStatus == 3) || (paramMessageForApollo.gameStatus == 2))
    {
      paramLong = NetConnInfoCenter.getServerTimeMillis() - paramMessageForApollo.gameStatusStamp;
      if (paramLong >= 180000L)
      {
        QLog.i("ApolloGameUtil", 1, "handle process-killing case, querySlice:" + 180000L + ",delta:" + paramLong + ",roomId:" + paramMessageForApollo.roomId);
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo, WeakReference paramWeakReference1, WeakReference paramWeakReference2)
  {
    if ((paramQQAppInterface == null) || (paramMessageForApollo == null))
    {
      QLog.e("ApolloGameUtil", 1, "[updateMsgInCacheAndDB], errInfo->param error");
      return false;
    }
    Object localObject = a(paramQQAppInterface, paramMessageForApollo.roomId, paramMessageForApollo.frienduin, paramMessageForApollo.istroop);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      QLog.i("ApolloGameUtil", 1, "no msg with the same roomid");
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)((Iterator)localObject).next();
      if ((localMessageForApollo != null) && (a(paramMessageForApollo, localMessageForApollo)))
      {
        localMessageForApollo.updateGameStatus(paramMessageForApollo);
        a(paramQQAppInterface, localMessageForApollo, paramWeakReference1, paramWeakReference2, null);
        a(paramQQAppInterface, localMessageForApollo);
      }
    }
    return true;
  }
  
  public static boolean a(MessageForApollo paramMessageForApollo1, MessageForApollo paramMessageForApollo2)
  {
    if ((paramMessageForApollo1 == null) || (paramMessageForApollo2 == null)) {
      return false;
    }
    if (paramMessageForApollo1.gameStatusStamp < paramMessageForApollo2.gameStatusStamp)
    {
      QLog.i("ApolloGameUtil", 1, "[Invalid status], new status is actually older than old status, new.stamp:" + paramMessageForApollo1.gameStatusStamp + ",old.stamp:" + paramMessageForApollo2.gameStatusStamp + ",roomId:" + paramMessageForApollo2.roomId);
      return false;
    }
    if (((paramMessageForApollo2.gameStatus == 4) && (!TextUtils.isEmpty(paramMessageForApollo2.winRecord))) || (paramMessageForApollo2.gameStatus == 5) || (paramMessageForApollo2.gameStatus == 6) || (paramMessageForApollo2.gameStatus == 7) || (paramMessageForApollo2.gameStatus == 8))
    {
      QLog.i("ApolloGameUtil", 1, "[Invalid status], game was over, roomId:" + paramMessageForApollo2.roomId);
      return false;
    }
    if ((paramMessageForApollo2.gameStatus == 3) && ((paramMessageForApollo1.gameStatus == 1) || (paramMessageForApollo1.gameStatus == 2)))
    {
      QLog.i("ApolloGameUtil", 1, "[Invalid status], game has started, roomId:" + paramMessageForApollo2.roomId);
      return false;
    }
    return true;
  }
  
  public static void b(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return;
    }
    ApolloGameRedDot localApolloGameRedDot = a(paramAppInterface, a(paramAppInterface.getEntityManagerFactory().createEntityManager()));
    if (localApolloGameRedDot != null)
    {
      DrawerPushItem localDrawerPushItem = new DrawerPushItem();
      localDrawerPushItem.msg_type = 4;
      localDrawerPushItem.is_reddot = 1;
      localDrawerPushItem.msg_id = a(localApolloGameRedDot);
      localDrawerPushItem.priority = 1000;
      localDrawerPushItem.sub_priority = 1000;
      localDrawerPushItem.start_ts = localApolloGameRedDot.mStartTime;
      localDrawerPushItem.end_ts = localApolloGameRedDot.mEndTime;
      localDrawerPushItem.send_time = ((int)(System.currentTimeMillis() / 1000L));
      localDrawerPushItem.content = localApolloGameRedDot.mTipsWording;
      localDrawerPushItem.show_counts = 1;
      localDrawerPushItem.reddotGameId = localApolloGameRedDot.mGameId;
      localDrawerPushItem.reddotRedId = localApolloGameRedDot.mDotId;
      ((ApolloManager)paramAppInterface.getManager(152)).a(localDrawerPushItem, false);
    }
    a(paramAppInterface);
  }
  
  private static void b(AppInterface paramAppInterface, Bundle paramBundle)
  {
    if ((paramAppInterface == null) || (paramBundle == null)) {
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      EntityManager localEntityManager;
      int j;
      Object localObject3;
      int k;
      Object localObject4;
      int m;
      Object localObject5;
      try
      {
        paramBundle = paramBundle.getByteArray("extra_data");
        localObject1 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramBundle);
        if (((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get() != 0L) {
          break;
        }
        paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, mRespStr:" + paramBundle);
        }
        paramBundle = new JSONObject(paramBundle).optJSONObject("data");
        if (paramBundle == null) {
          break;
        }
        localObject1 = paramBundle.optJSONArray("dotInfoList");
        localObject2 = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin() + "apollo_game_reddot_sp", 0).edit();
        localEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
        paramBundle = new ArrayList();
        i = 0;
        j = 0;
        if ((localObject1 == null) || (j >= ((JSONArray)localObject1).length())) {
          break label1008;
        }
        localObject3 = ((JSONArray)localObject1).optJSONObject(j);
        k = i;
        if (localObject3 == null) {
          break label1226;
        }
        int n = ((JSONObject)localObject3).optInt("busId");
        localEntityManager.a(ApolloGameRedDot.class.getSimpleName(), "mGameId=? ", new String[] { String.valueOf(n) });
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, em.delete，mGameId=" + n);
        }
        localObject4 = ((JSONObject)localObject3).getJSONArray("dotList");
        localObject3 = new ArrayList();
        k = 0;
        if ((localObject4 == null) || (k >= ((JSONArray)localObject4).length())) {
          break label944;
        }
        Object localObject6 = ((JSONArray)localObject4).optJSONObject(k);
        if (localObject6 == null) {
          break label1217;
        }
        m = ((JSONObject)localObject6).optInt("dotId");
        if (m == 1003)
        {
          localObject5 = new AioPushData();
          ((AioPushData)localObject5).begTs = ((JSONObject)localObject6).optInt("begTs");
          ((AioPushData)localObject5).busId = n;
          ((AioPushData)localObject5).busType = ((JSONObject)localObject6).optInt("busType");
          ((AioPushData)localObject5).dotId = ((JSONObject)localObject6).optInt("dotId");
          ((AioPushData)localObject5).endTs = ((JSONObject)localObject6).optInt("endTs");
          ((AioPushData)localObject5).priority = ((JSONObject)localObject6).optInt("priority");
          ((AioPushData)localObject5).them = ((JSONObject)localObject6).optString("theme");
          ((AioPushData)localObject5).wording = ((JSONObject)localObject6).optString("wording");
          ((AioPushData)localObject5).url = ((JSONObject)localObject6).optString("url");
          ((AioPushData)localObject5).actId = ((JSONObject)localObject6).optString("actId");
          ((AioPushData)localObject5).folderIconUrl = ((JSONObject)localObject6).optString("folderIconUrl");
          ((AioPushData)localObject5).spRegion = ((JSONObject)localObject6).optInt("spRegion");
          ((List)localObject3).add(localObject5);
          break label1217;
        }
        localObject5 = new ApolloGameRedDot();
        ((ApolloGameRedDot)localObject5).mDotId = m;
        ((ApolloGameRedDot)localObject5).mStartTime = ((JSONObject)localObject6).optInt("begTs");
        ((ApolloGameRedDot)localObject5).mEndTime = ((JSONObject)localObject6).optInt("endTs");
        ((ApolloGameRedDot)localObject5).mTipsWording = ((JSONObject)localObject6).optString("wording");
        ((ApolloGameRedDot)localObject5).mGameId = n;
        ((ApolloGameRedDot)localObject5).mUrl = ((JSONObject)localObject6).optString("url");
        ((ApolloGameRedDot)localObject5).mActId = ((JSONObject)localObject6).optString("actId");
        ((ApolloGameRedDot)localObject5).mPriority = ((JSONObject)localObject6).optInt("priority");
        ((ApolloGameRedDot)localObject5).mSpRegion = ((JSONObject)localObject6).optInt("spRegion");
        localObject6 = (HotChatCenterManager)paramAppInterface.getManager(254);
        ApolloGameData localApolloGameData = ((ApolloDaoManager)paramAppInterface.getManager(154)).a(((ApolloGameRedDot)localObject5).mGameId);
        if ((localObject6 != null) && (localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.hotChatCode)))
        {
          ((HotChatCenterManager)localObject6).b(localApolloGameData.hotChatCode, "[新活动]" + localApolloGameData.name + "：" + ((ApolloGameRedDot)localObject5).mTipsWording);
          VipUtils.a(null, "cmshow", "Apollo", "get_notice", m, 0, new String[] { String.valueOf(n), "", ((ApolloGameRedDot)localObject5).mActId });
          if (!ApolloGameRedDot.isValidReddotId(m)) {
            break label1217;
          }
        }
        else
        {
          QLog.e("ApolloGameUtil", 1, new Object[] { "[parseGameRedDot] ", Integer.valueOf(((ApolloGameRedDot)localObject5).mGameId) });
          continue;
        }
        if (((ApolloGameRedDot)localObject5).isTimeValid()) {
          break label869;
        }
      }
      catch (Throwable paramAppInterface)
      {
        QLog.e("ApolloGameUtil", 1, "apolloGameReddot checkApolloGameRedDot failed ", paramAppInterface);
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, apolloGameRedDot.isTimeValid():false," + localObject5);
        break label1217;
        label869:
        paramBundle.add(localObject5);
        localEntityManager.b((Entity)localObject5);
        ((SharedPreferences.Editor)localObject2).putBoolean(a((ApolloGameRedDot)localObject5), false);
        m = 1;
        i = m;
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, saveApolloGameRedDot:" + localObject5);
          i = m;
          break label1217;
          label944:
          a(localEntityManager);
          k = i;
          if (((List)localObject3).size() <= 0) {
            break label1226;
          }
          localObject4 = (ApolloDaoManager)paramAppInterface.getManager(154);
          if (localObject4 != null)
          {
            ((ApolloDaoManager)localObject4).a((List)localObject3, 1);
            k = i;
            break label1226;
          }
          QLog.e("ApolloGameUtil", 1, "[parseGameReddot] do manager is null");
          k = i;
          break label1226;
          label1008:
          if (i != 0)
          {
            ((SharedPreferences.Editor)localObject2).commit();
            localObject1 = a(paramAppInterface, paramBundle);
            if (localObject1 != null)
            {
              localObject2 = new DrawerPushItem();
              ((DrawerPushItem)localObject2).msg_type = 4;
              ((DrawerPushItem)localObject2).is_reddot = 1;
              ((DrawerPushItem)localObject2).msg_id = a((ApolloGameRedDot)localObject1);
              ((DrawerPushItem)localObject2).priority = 1000;
              ((DrawerPushItem)localObject2).sub_priority = 1000;
              ((DrawerPushItem)localObject2).start_ts = ((ApolloGameRedDot)localObject1).mStartTime;
              ((DrawerPushItem)localObject2).end_ts = ((ApolloGameRedDot)localObject1).mEndTime;
              ((DrawerPushItem)localObject2).send_time = ((int)(System.currentTimeMillis() / 1000L));
              ((DrawerPushItem)localObject2).content = ((ApolloGameRedDot)localObject1).mTipsWording;
              ((DrawerPushItem)localObject2).show_counts = 1;
              ((DrawerPushItem)localObject2).reddotGameId = ((ApolloGameRedDot)localObject1).mGameId;
              ((DrawerPushItem)localObject2).reddotRedId = ((ApolloGameRedDot)localObject1).mDotId;
              ((ApolloManager)paramAppInterface.getManager(152)).a((DrawerPushItem)localObject2, false);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, apolloManager.addPushItem");
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, redDotsList.size:" + paramBundle.size());
          return;
        }
      }
      label1217:
      k += 1;
      continue;
      label1226:
      j += 1;
      int i = k;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = ((ApolloDaoManager)paramQQAppInterface.getManager(154)).g();
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.iterator();
    while (paramQQAppInterface.hasNext())
    {
      ApolloGameRoamData localApolloGameRoamData = (ApolloGameRoamData)paramQQAppInterface.next();
      if ((localApolloGameRoamData != null) && (localApolloGameRoamData.gameId == paramInt) && (localApolloGameRoamData.type == 2)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil
 * JD-Core Version:    0.7.0.1
 */