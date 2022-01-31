package com.tencent.mobileqq.apollo.utils;

import abor;
import absi;
import absn;
import aekt;
import aelt;
import aelz;
import agjp;
import akjc;
import akje;
import akji;
import akpc;
import akpd;
import akpe;
import akpk;
import akpq;
import akrg;
import akro;
import aktw;
import aktx;
import akwm;
import alcb;
import alee;
import alef;
import aleh;
import aley;
import alfd;
import alfe;
import alff;
import alfg;
import alfi;
import alfm;
import alfn;
import alfo;
import alfp;
import aliq;
import alpo;
import alpr;
import ammq;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.webkit.URLUtil;
import awbv;
import awbw;
import awbx;
import ayvw;
import azmz;
import bdal;
import bdcq;
import bdcs;
import bdlw;
import bdlz;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.game.ApolloFragment;
import com.tencent.mobileqq.apollo.game.ApolloWebViewFragment;
import com.tencent.mobileqq.apollo.game.WebGameFakeView;
import com.tencent.mobileqq.apollo.game.WebGameFakeView.Director;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.data.ApolloGameRoamData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloGameUtil
{
  public static int a;
  public static SparseArray<SparseArray<ApolloGameRedDot>> a;
  public static ApolloGameUtil.CmStartTask a;
  private static boolean a;
  public static int b;
  private static SparseArray<Integer> jdField_b_of_type_AndroidUtilSparseArray;
  private static boolean jdField_b_of_type_Boolean;
  public static int c;
  private static boolean c;
  public static int d;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_c_of_type_Int = 1;
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
    for (int i = akpe.jdField_a_of_type_Int;; i = localSharedPreferences.getInt("sp.score.num", akpe.jdField_a_of_type_Int))
    {
      jdField_a_of_type_Int = i;
      return jdField_a_of_type_Int;
    }
  }
  
  public static int a(int paramInt)
  {
    int i = 1;
    Object localObject = new File(alef.jdField_a_of_type_JavaLangString + "/game/" + String.valueOf(paramInt) + "/gameConfig.json");
    File localFile = new File(alef.jdField_a_of_type_JavaLangString + "/game/" + String.valueOf(paramInt) + "/appConfig.json");
    if (((File)localObject).exists())
    {
      localObject = bdcs.a((File)localObject);
      paramInt = i;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject).optString("enterUrl");
          paramInt = i;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return paramInt;
          }
          if (((String)localObject).contains("urlshare.cn")) {
            return 4;
          }
          boolean bool = ((String)localObject).contains("_bkfv=5");
          if (bool) {
            return 5;
          }
          return 2;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("ApolloGameUtil", 1, localThrowable, new Object[0]);
          return 1;
        }
      }
    }
    else
    {
      paramInt = i;
      if (localFile.exists()) {
        paramInt = 3;
      }
    }
    return paramInt;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (jdField_b_of_type_AndroidUtilSparseArray == null) {
      jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    for (int i = -2;; i = ((Integer)jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1, Integer.valueOf(-2))).intValue())
    {
      int j = i;
      Object localObject;
      if (i == -2)
      {
        localObject = new File(alef.jdField_a_of_type_JavaLangString + "/game/" + String.valueOf(paramInt1) + "/" + a(paramInt2));
        if (!((File)localObject).exists()) {}
      }
      else
      {
        try
        {
          localObject = new JSONObject(bdcs.a((File)localObject));
          if (!((JSONObject)localObject).has("viewMode")) {
            break label172;
          }
          j = ((JSONObject)localObject).optInt("viewMode") - 1;
          jdField_b_of_type_AndroidUtilSparseArray.put(paramInt1, Integer.valueOf(j));
          return j;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("ApolloGameUtil", 1, localThrowable, new Object[] { "[getGameViewMode]" });
        }
      }
    }
    label172:
    return -1;
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
          paramAppInterface = (HotChatManager)paramAppInterface.getManager(60);
          if ((paramAppInterface != null) && (paramAppInterface.b(paramString))) {
            return 6;
          }
        }
        return 4;
      }
      if (3000 == paramInt) {
        return 5;
      }
      i = paramInt;
    } while (1036 != paramInt);
    return 7;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return akji.a(paramQQAppInterface);
  }
  
  public static int a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    paramChatMessage = (MessageForApollo)paramChatMessage;
    paramQQAppInterface = (aleh)paramQQAppInterface.getManager(155);
    if (a(paramChatMessage.msgType))
    {
      paramQQAppInterface = paramQQAppInterface.b(paramChatMessage.gameId);
      if ((akji.c("gameSwitch") != 1) || ((paramQQAppInterface != null) && (!alee.a("8.3.3", paramQQAppInterface.minVer, paramQQAppInterface.maxVer))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, "play apollo game msg but switch is 0 or version is incorrect");
        }
        return jdField_b_of_type_Int;
      }
      if ((paramChatMessage.gameId == 1) || (paramChatMessage.gameId == 2)) {
        return jdField_b_of_type_Int;
      }
      return jdField_c_of_type_Int;
    }
    return jdField_b_of_type_Int;
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
  
  public static SparseArray<SparseArray<ApolloGameRedDot>> a(awbw paramawbw)
  {
    int i;
    Object localObject2;
    if (jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, "[getGameReddotMap] from cache");
      }
      paramawbw = new SparseArray();
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
              paramawbw.put(m, localObject2);
            }
            i += 1;
          }
        }
        return paramawbw;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloGameUtil", 1, localThrowable, new Object[] { "[getGameReddotMap]" });
      }
    }
    if (paramawbw == null) {
      return null;
    }
    Object localObject1 = paramawbw.a(ApolloGameRedDot.class);
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
        break label372;
      }
      localIterator = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label372;
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
        paramawbw.b(localApolloGameRedDot);
      }
    }
    label372:
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
  
  public static ApolloGameRedDot a(SparseArray<ApolloGameRedDot> paramSparseArray)
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
  
  private static final ApolloGameRedDot a(AppInterface paramAppInterface, List<ApolloGameRedDot> paramList)
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
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "gameConfig.json";
    }
    return "appConfig.json";
  }
  
  private static String a(ApolloGameRedDot paramApolloGameRedDot)
  {
    if (paramApolloGameRedDot == null) {
      return null;
    }
    return "apollo_game_reddot_hasshow_" + String.valueOf(paramApolloGameRedDot.mGameId) + "_" + String.valueOf(paramApolloGameRedDot.mDotId);
  }
  
  public static ArrayList<MessageForApollo> a(List<MessageRecord> paramList, long paramLong)
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
  
  public static List<MessageForApollo> a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    List localList = paramQQAppInterface.a(paramInt).f(paramString, paramInt);
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
  
  public static List<MessageForApollo> a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt1, int paramInt2)
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
  
  public static List<MessageForApollo> a(QQAppInterface paramQQAppInterface, WeakReference<XListView> paramWeakReference, long paramLong)
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
          if ((localObject instanceof aelt))
          {
            localObject = (aelt)localObject;
            if ((((aelt)localObject).a instanceof MessageForApollo))
            {
              localObject = (MessageForApollo)((aelt)localObject).a;
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
        paramQQAppInterface = akwm.a(paramQQAppInterface, paramString);
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
      if (jdField_b_of_type_AndroidUtilSparseArray != null)
      {
        jdField_b_of_type_AndroidUtilSparseArray.clear();
        jdField_b_of_type_AndroidUtilSparseArray = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameUtil", 1, "[releaseCache] clear err");
    }
  }
  
  public static void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new ApolloGameUtil.20(paramInt));
  }
  
  @TargetApi(26)
  public static void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
  }
  
  @TargetApi(26)
  public static void a(int paramInt, String paramString, alfo paramalfo)
  {
    ThreadManager.post(new ApolloGameUtil.13(paramInt, paramString, paramalfo), 5, null, true);
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ThreadManager.post(new ApolloGameUtil.4(paramString, paramQQAppInterface, paramLong), 5, null, true);
  }
  
  public static void a(alcb paramalcb, long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, "[handleResultForGameEdit], ret:" + paramLong + ",cmd:" + paramString + ",lis:" + paramalcb);
    }
    if (paramalcb == null) {
      return;
    }
    String str = "";
    if ("apollo_aio_game.add_games_to_user_gamepanel".equals(paramString)) {
      if (0L == paramLong) {
        str = alpo.a(2131700722);
      }
    }
    for (;;)
    {
      paramalcb.a(paramLong, str);
      return;
      str = alpo.a(2131700749);
      continue;
      if ("apollo_aio_game.del_games_from_user_gamepanel".equals(paramString)) {
        if (0L == paramLong) {
          str = alpo.a(2131700729);
        } else {
          str = alpo.a(2131700728);
        }
      }
    }
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
      int i = paramActivity.optInt("gameId");
      long l = paramActivity.optLong("roomId");
      paramString = paramActivity.optString("gameName");
      a(paramQQAppInterface, i, l, paramActivity.optInt("gameMode"), paramActivity.optString("extendInfo"), 220, paramString);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      QLog.w("ApolloGameUtil", 1, "[startGameFromQRCode], errInfo->" + paramActivity.getMessage());
    }
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, "send broadcast to finish jump activity");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("BroadcastReceiverFinishActivity");
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void a(Context paramContext, int paramInt, Intent paramIntent, String paramString, Bitmap paramBitmap, alfo paramalfo)
  {
    if ((paramContext == null) || (!(paramContext instanceof ApolloGameActivity)))
    {
      VipUtils.a(null, "cmshow", "Apollo", "pressSendToDesktopButton", 0, 1, new String[] { String.valueOf(paramInt) });
      a(paramIntent, paramString, paramBitmap, new alfe(paramalfo));
      return;
    }
    if (paramBitmap == null) {}
    try
    {
      paramBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130840157);
      int i = aekt.a(192.0F, paramContext.getResources());
      Bitmap localBitmap = paramBitmap;
      if (i != paramBitmap.getWidth()) {
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, i, i, false);
      }
      ThreadManager.getUIHandler().post(new ApolloGameUtil.15(paramContext, paramInt, paramIntent, paramString, localBitmap, paramalfo));
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.e("ApolloGameUtil", 1, paramContext, new Object[0]);
        return;
      }
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.e("ApolloGameUtil", 1, paramContext, new Object[0]);
    }
  }
  
  public static void a(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { " [startLightGame] context=", paramContext, ", StartCheckParam=", paramStartCheckParam });
    }
    if (a() == null) {
      if (!jdField_c_of_type_Boolean)
      {
        b(paramContext, paramStartCheckParam);
        jdField_c_of_type_Boolean = true;
        QLog.e("ApolloGameUtil", 1, "[startLightGame] sTopActivity is null");
      }
    }
    label388:
    label395:
    label396:
    for (;;)
    {
      return;
      QLog.e("ApolloGameUtil", 1, "[startLightGame] sTopActivity is still null");
      return;
      int i;
      if ((paramContext != null) && ((paramContext instanceof JumpActivity)))
      {
        i = 1;
        if (a() == null) {
          break label395;
        }
        paramContext = a();
      }
      for (;;)
      {
        if ((paramContext == null) || (paramStartCheckParam == null) || (!(paramContext instanceof Activity))) {
          break label396;
        }
        if ((i != 0) && (!(paramContext instanceof JumpActivity))) {
          a(paramContext);
        }
        if (a())
        {
          QLog.e("ApolloGameUtil", 1, "[startLightGame] x86 not support");
          return;
          i = 0;
          break;
        }
        paramStartCheckParam.startT = System.currentTimeMillis();
        AppInterface localAppInterface = akro.a();
        if (!(localAppInterface instanceof QQAppInterface))
        {
          QLog.e("ApolloGameUtil", 1, "not QQAppInterface");
          return;
        }
        QLog.d("CmGameStat", 1, new Object[] { "startLightGame, time=", Long.valueOf(SystemClock.uptimeMillis()) });
        Object localObject;
        if (!akji.jdField_b_of_type_Boolean)
        {
          QLog.i("ApolloGameUtil", 1, "startLightGame but apollo init first now");
          localObject = (akji)localAppInterface.getManager(153);
          if (localObject == null)
          {
            QLog.e("ApolloGameUtil", 1, "apolloManager is null");
            return;
          }
          ((akji)localObject).a(new alfd(paramContext, localAppInterface, paramStartCheckParam, SystemClock.uptimeMillis()));
          localObject = new HashMap();
          ((HashMap)localObject).put("param_gameId", String.valueOf(paramStartCheckParam.gameId));
          ((HashMap)localObject).put("param_src", String.valueOf(paramStartCheckParam.src));
          if (!akji.jdField_b_of_type_Boolean) {
            break label388;
          }
        }
        for (paramStartCheckParam = "1";; paramStartCheckParam = "0")
        {
          ((HashMap)localObject).put("param_init", paramStartCheckParam);
          azmz.a(paramContext).a(localAppInterface.getCurrentAccountUin(), "cmgame_data_init_check", true, 0L, 0L, (HashMap)localObject, "", false);
          QLog.d("CmGameStat", 1, new Object[] { "sInitedDone=", Boolean.valueOf(akji.jdField_b_of_type_Boolean) });
          return;
          b(paramContext, (QQAppInterface)localAppInterface, paramStartCheckParam);
          break;
        }
      }
    }
  }
  
  @TargetApi(26)
  public static void a(Intent paramIntent, String paramString, Bitmap paramBitmap, alfp paramalfp)
  {
    ThreadManager.excute(new ApolloGameUtil.17(BaseApplicationImpl.getApplication(), paramString, paramalfp, paramIntent, paramBitmap), 32, null, false);
  }
  
  public static void a(awbw paramawbw)
  {
    if (paramawbw != null)
    {
      ThreadManager.post(new ApolloGameUtil.3(paramawbw), 5, null, true);
      return;
    }
    QLog.e("ApolloGameUtil", 1, "[loadCache] em is null out ");
  }
  
  public static void a(awbw paramawbw, int paramInt1, int paramInt2)
  {
    if (paramawbw == null) {
      return;
    }
    int i = paramawbw.a(ApolloGameRedDot.class.getSimpleName(), "mGameId=? and mDotId=? ", new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2) });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, "apolloGameReddot deleteGameReddot, gameId:" + paramInt1 + ",reddotId:" + paramInt2 + ",ret:" + i);
    }
    a(paramawbw);
  }
  
  public static void a(awbw paramawbw, List<ApolloGameRedDot> paramList)
  {
    if ((paramawbw != null) && (paramList != null) && (paramList.size() > 0))
    {
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApolloGameRedDot localApolloGameRedDot = (ApolloGameRedDot)paramList.next();
        if (localApolloGameRedDot != null)
        {
          localApolloGameRedDot.mIsShow = true;
          paramawbw.a(localApolloGameRedDot);
        }
      }
      a(paramawbw);
    }
  }
  
  public static void a(awbw paramawbw, boolean paramBoolean)
  {
    if (paramawbw == null) {
      return;
    }
    paramBoolean = paramawbw.c("update ApolloGameRedDot set mIsShowForFolder = 1");
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { "update ApolloGameRedDot set mIsShowForFolder=true", Boolean.valueOf(paramBoolean) });
    }
    a(paramawbw);
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
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (paramAppInterface != null) {
      if (!paramBoolean) {
        break label30;
      }
    }
    label30:
    for (int i = 0;; i = 1)
    {
      VipUtils.a(paramAppInterface, "cmshow", "Apollo", "clk_shortcut", 0, i, new String[0]);
      return;
    }
  }
  
  public static void a(BaseChatPie paramBaseChatPie, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.a() == null) || (paramBaseChatPie.a() == null) || (paramBaseChatPie.a() == null))
    {
      QLog.e("ApolloGameUtil", 1, new Object[] { "aio startLightGame failed gameId:", Integer.valueOf(paramInt1), ",from:", paramString });
      return;
    }
    paramString = new CmGameStartChecker.StartCheckParam(paramInt1, true, paramString, 0L, paramInt3, 0, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, a(paramBaseChatPie.a(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt2, null);
    a(paramBaseChatPie.a(), paramString);
  }
  
  public static void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {
      return;
    }
    QLog.i("ApolloGameUtil", 2, "startGameAgain");
    if (akro.a(BaseApplicationImpl.getContext())) {
      akrg.a().a(paramStartCheckParam);
    }
    a(paramStartCheckParam, false);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.webprocess.launch_cmgame");
    localIntent.putExtra("extra_startcheckparam", paramStartCheckParam);
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    try
    {
      QLog.i("ApolloGameUtil", 2, "startGameAgain Send action launch_cmgame.");
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Throwable paramStartCheckParam)
    {
      QLog.e("ApolloGameUtil", 1, paramStartCheckParam, new Object[0]);
    }
  }
  
  public static void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, FragmentActivity paramFragmentActivity, int paramInt1, ApolloFragment paramApolloFragment, int paramInt2, WebGameFakeView paramWebGameFakeView, String paramString)
  {
    if (paramStartCheckParam == null) {}
    Object localObject1;
    Object localObject2;
    Object localObject3;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject1 = alef.jdField_a_of_type_JavaLangString + "/game/" + String.valueOf(paramInt1) + "/" + a(paramStartCheckParam.mGameType);
          localObject2 = new File((String)localObject1);
          if (((File)localObject2).exists()) {
            if (aley.a(paramStartCheckParam.isWhiteUsr, paramInt1))
            {
              localObject3 = new aley(paramInt1);
              paramStartCheckParam = a(paramStartCheckParam.mGameType);
              ((aley)localObject3).b();
              if ((!((aley)localObject3).a(paramStartCheckParam)) || (!((aley)localObject3).a((String)localObject1, paramStartCheckParam)))
              {
                QLog.e("ApolloGameUtil", 1, "[launchWebGame] failed for invalid config");
                akro.a(paramInt1);
                akro.a(new Object[] { "[launchWebGame], failed for invalid config" });
                return;
              }
            }
          }
        }
        catch (Throwable paramStartCheckParam)
        {
          QLog.e("ApolloGameUtil", 1, paramStartCheckParam, new Object[0]);
          return;
        }
      }
      paramStartCheckParam = bdcs.a((File)localObject2);
    } while (TextUtils.isEmpty(paramStartCheckParam));
    JSONObject localJSONObject = new JSONObject(paramStartCheckParam);
    paramStartCheckParam = localJSONObject.optString("enterPath");
    if (!TextUtils.isEmpty(paramStartCheckParam))
    {
      localObject2 = alef.jdField_a_of_type_JavaLangString + "/game/" + String.valueOf(paramInt1) + "/" + paramStartCheckParam;
      paramStartCheckParam = "file://" + (String)localObject2;
    }
    for (;;)
    {
      localObject3 = localJSONObject.optString("enterUrl");
      localObject1 = paramStartCheckParam;
      if (TextUtils.isEmpty(paramStartCheckParam)) {
        localObject1 = localObject3;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      if (URLUtil.isNetworkUrl((String)localObject1)) {}
      do
      {
        paramStartCheckParam = "&";
        if (!((String)localObject1).contains("?")) {
          paramStartCheckParam = "?";
        }
        localObject1 = (String)localObject1 + paramStartCheckParam + "apollo_bk" + "=1";
        paramString = akpq.c(paramString);
        paramStartCheckParam = (CmGameStartChecker.StartCheckParam)localObject1;
        if (!TextUtils.isEmpty(paramString)) {
          paramStartCheckParam = (String)localObject1 + "&" + paramString;
        }
        akpc.a().a(paramFragmentActivity, 2131367059);
        paramString = new Intent();
        paramString.putExtra("url", paramStartCheckParam);
        if ((paramApolloFragment == null) || (!paramApolloFragment.isAdded()) || (!(paramApolloFragment instanceof ApolloWebViewFragment))) {
          break label566;
        }
        WebAccelerateHelper.getInstance().preCheckOffline(paramStartCheckParam);
        WebAccelerateHelper.getInstance().preFetchResource(paramStartCheckParam);
        if (paramFragmentActivity.isFinishing()) {
          break;
        }
        akpk.a().a();
        paramFragmentActivity.runOnUiThread(new ApolloGameUtil.9(paramApolloFragment, paramStartCheckParam));
        return;
        if (!URLUtil.isFileUrl((String)localObject1)) {
          break;
        }
        paramStartCheckParam = new File((String)localObject2);
      } while ((paramStartCheckParam.exists()) && (paramStartCheckParam.getAbsolutePath().startsWith(alef.jdField_a_of_type_JavaLangString + "/game/" + String.valueOf(paramInt1))));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloGameUtil", 2, (String)localObject2);
      return;
      label566:
      paramApolloFragment = new WebGameFakeView.Director();
      localObject1 = localJSONObject.optJSONObject("ui");
      if (localObject1 != null)
      {
        localObject2 = ((JSONObject)localObject1).optString(WebGameFakeView.Director.TITLE);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramApolloFragment.title = ((String)localObject2);
        }
        localObject2 = ((JSONObject)localObject1).optString(WebGameFakeView.Director.FOREGROUND_COLOR);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramApolloFragment.frontColor = ((String)localObject2);
        }
        localObject1 = ((JSONObject)localObject1).optString(WebGameFakeView.Director.BACKGROUND_COLOR);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramApolloFragment.bgColor = ((String)localObject1);
        }
      }
      if (paramWebGameFakeView != null)
      {
        paramWebGameFakeView.a = paramApolloFragment;
        paramWebGameFakeView.a();
      }
      paramString.putExtra("Director", paramApolloFragment);
      paramString.putExtra("game_busid", String.valueOf(paramInt1));
      akpc.a(paramFragmentActivity, paramString);
      WebAccelerateHelper.getInstance().preGetKey(paramStartCheckParam, paramString, null);
      WebAccelerateHelper.getInstance().preCheckOffline(paramStartCheckParam);
      WebAccelerateHelper.getInstance().preFetchResource(paramStartCheckParam);
      return;
      localObject2 = "";
    }
  }
  
  public static void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, boolean paramBoolean)
  {
    if (paramStartCheckParam == null) {
      return;
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("start_cm_game", 4).edit().putBoolean(String.valueOf(paramStartCheckParam.mCreateTs) + "_start_flag", paramBoolean).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, int paramInt2, String paramString1, int paramInt3, String paramString2)
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
        paramQQAppInterface = new CmGameStartChecker.StartCheckParam(paramInt1, bool, paramQQAppInterface, paramLong, i, paramInt2, 0, 0, "", paramInt3, paramString2);
        paramQQAppInterface.extendJson = paramString1;
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
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    ThreadManagerV2.excute(new ApolloGameUtil.5(paramQQAppInterface, paramInt, paramBoolean), 32, null, true);
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
  
  public static void a(QQAppInterface paramQQAppInterface, alfm paramalfm)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null))
    {
      paramalfm.b(false);
      return;
    }
    if (!akji.jdField_b_of_type_Boolean)
    {
      ((akji)paramQQAppInterface.getManager(153)).a(new alff(paramalfm, paramQQAppInterface));
      return;
    }
    paramalfm.b(c(paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, alfn paramalfn)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null))
    {
      paramalfn.a(false);
      return;
    }
    if (!akji.jdField_b_of_type_Boolean)
    {
      ((akji)paramQQAppInterface.getManager(153)).a(new alfg(paramalfn));
      return;
    }
    paramalfn.a(true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, aliq paramaliq, SessionInfo paramSessionInfo)
  {
    if ((paramaliq == null) || (paramQQAppInterface == null) || (paramSessionInfo == null))
    {
      QLog.e("cmgame.sendmsg", 1, "[sendGameMsg], errInfo->param is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame.sendmsg", 2, new Object[] { "[sendGameMsg], gameId:", Integer.valueOf(paramaliq.jdField_a_of_type_Int), ",roomId:", Long.valueOf(paramaliq.jdField_a_of_type_Long), ",extendInfo:", paramaliq.jdField_c_of_type_JavaLangString });
    }
    ApolloMessage localApolloMessage = new ApolloMessage();
    if (!TextUtils.isEmpty(paramaliq.jdField_a_of_type_JavaLangString)) {
      localApolloMessage.name = paramaliq.jdField_a_of_type_JavaLangString.getBytes();
    }
    if (0 == 0) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("gameId", paramaliq.jdField_a_of_type_Int);
        ((JSONObject)localObject).put("gameMode", paramaliq.jdField_c_of_type_Int);
        ((JSONObject)localObject).put("roomid", paramaliq.jdField_a_of_type_Long);
        if (paramaliq.jdField_a_of_type_Int == 1)
        {
          ((JSONObject)localObject).put("msgTyep", 2);
          ((JSONObject)localObject).put("gameName", paramaliq.jdField_b_of_type_JavaLangString);
          if (!TextUtils.isEmpty(paramaliq.jdField_c_of_type_JavaLangString)) {
            ((JSONObject)localObject).put("gameExtendJson", paramaliq.jdField_c_of_type_JavaLangString);
          }
          if (localObject != null) {
            localApolloMessage.extStr = ((JSONObject)localObject).toString();
          }
          localObject = ((akji)paramQQAppInterface.getManager(153)).b(paramQQAppInterface.getCurrentAccountUin());
          localApolloMessage.sender_ts = bdal.a(((ApolloBaseInfo)localObject).apolloServerTS);
          localApolloMessage.sender_status = ((ApolloBaseInfo)localObject).apolloStatus;
          localObject = ((aleh)paramQQAppInterface.getManager(155)).a(paramaliq.jdField_a_of_type_Int);
          if ((localObject == null) || (1 != ((ApolloGameData)localObject).hasOwnArk)) {
            break label462;
          }
          i = 297;
          localApolloMessage.flag = (i | 0x200);
          paramSessionInfo = ayvw.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, localApolloMessage);
          if (paramaliq.jdField_a_of_type_Int == 1)
          {
            paramSessionInfo.msgType = 2;
            paramSessionInfo.gameId = paramaliq.jdField_a_of_type_Int;
            paramSessionInfo.mGameMode = paramaliq.jdField_c_of_type_Int;
            paramSessionInfo.roomId = paramaliq.jdField_a_of_type_Long;
            paramSessionInfo.mApolloMessage.id = paramaliq.jdField_b_of_type_Int;
            paramSessionInfo.gameName = paramaliq.jdField_b_of_type_JavaLangString;
            paramSessionInfo.gameExtendJson = paramaliq.jdField_c_of_type_JavaLangString;
            paramQQAppInterface.a().a(paramSessionInfo, null);
          }
        }
        else
        {
          ((JSONObject)localObject).put("msgTyep", paramaliq.d);
          continue;
        }
        paramSessionInfo.msgType = paramaliq.d;
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
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    if ((paramQQAppInterface != null) && (paramSessionInfo != null) && (akpd.a("aio.city.game", paramQQAppInterface) == akpe.d)) {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "more_game_enter_exposure", ApolloUtil.a(paramSessionInfo, paramQQAppInterface), 0, new String[] { String.valueOf(paramInt) });
    }
    if ((paramQQAppInterface != null) && (paramSessionInfo != null)) {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "game_show", ApolloUtil.b(paramSessionInfo.jdField_a_of_type_Int), 0, new String[] { "0" });
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {}
    do
    {
      return;
      if (!akro.a(paramStartCheckParam.gameId)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloGameUtil", 2, "the game is IsLand");
    return;
    Object localObject = akrg.a().a();
    if (localObject != null)
    {
      localObject = ((aktx)localObject).a(paramStartCheckParam.gameId);
      if (localObject != null) {
        ((aktw)localObject).a(paramStartCheckParam);
      }
    }
    ThreadManager.excute(new ApolloGameUtil.22(paramQQAppInterface, paramStartCheckParam), 32, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ApolloGameRankData paramApolloGameRankData)
  {
    if ((paramQQAppInterface != null) && (paramApolloGameRankData != null)) {
      ThreadManager.post(new ApolloGameUtil.8(paramQQAppInterface, paramApolloGameRankData), 8, null, false);
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
      localObject = ammq.a((Serializable)localObject);
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
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo, WeakReference<XListView> paramWeakReference, WeakReference<aelz> paramWeakReference1, Bundle paramBundle)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramWeakReference1 = ((akje)paramQQAppInterface.getManager(211)).a();
    if (paramWeakReference1 != null) {
      paramWeakReference1.a(paramMessageForApollo);
    }
    ThreadManager.getUIHandler().post(new ApolloGameUtil.1(paramWeakReference, paramMessageForApollo, paramBundle, paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ApolloGameUtil", 1, "[updateRankInfo] app is null");
      return;
    }
    ThreadManager.post(new ApolloGameUtil.7(paramQQAppInterface, paramString), 5, null, false);
  }
  
  public static void a(String paramString, int paramInt, Context paramContext)
  {
    ThreadManager.getUIHandler().post(new ApolloGameUtil.21(paramContext, paramInt, paramString));
  }
  
  public static boolean a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_b_of_type_Boolean = FlatBuffersParser.c();
      jdField_a_of_type_Boolean = true;
    }
    return jdField_b_of_type_Boolean;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3) || (paramInt == 4);
  }
  
  public static boolean a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {
      return false;
    }
    long l = System.currentTimeMillis();
    boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("start_cm_game", 4).getBoolean(String.valueOf(paramStartCheckParam.mCreateTs) + "_start_flag", false);
    if ((QLog.isColorLevel()) || (bool)) {
      QLog.e("ApolloGameUtil", 1, new Object[] { "cmgame_isStartGameCancel:", Boolean.valueOf(bool), " use:", Long.valueOf(System.currentTimeMillis() - l) });
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!akji.a(paramQQAppInterface.getApplication())) {
      return false;
    }
    paramQQAppInterface = ((akji)paramQQAppInterface.getManager(153)).a(paramQQAppInterface.c());
    return (paramQQAppInterface == null) || (paramQQAppInterface.isApolloStatusOpen());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = ((aleh)paramQQAppInterface.getManager(155)).g();
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
    if (paramMessageForApollo.roomId == 0L) {
      return false;
    }
    if (paramMessageForApollo.istroop == 1036) {
      return false;
    }
    paramQQAppInterface = ((aleh)paramQQAppInterface.getManager(155)).a(paramMessageForApollo.gameId);
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!alee.a("8.3.3", paramQQAppInterface.minVer, paramQQAppInterface.maxVer)) {
      return false;
    }
    boolean bool1;
    boolean bool2;
    label203:
    boolean bool3;
    if (paramMessageForApollo.gameStatusStamp < paramLong)
    {
      bool1 = true;
      if ((paramMessageForApollo.gameStatus != 4) && (paramMessageForApollo.gameStatus != 7) && (paramMessageForApollo.gameStatus != 8)) {
        break label398;
      }
      bool2 = true;
      if (paramMessageForApollo.gameStatus != 5) {
        break label404;
      }
      bool3 = true;
      label214:
      if (paramMessageForApollo.gameStatus != 6) {
        break label410;
      }
    }
    label398:
    label404:
    label410:
    for (boolean bool4 = true;; bool4 = false)
    {
      if ((!bool1) || (bool2) || (bool3) || (bool4)) {
        break label416;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, new Object[] { "RoomId ", Long.valueOf(paramMessageForApollo.roomId), " needs pulling from srv,isTimeOverdue:", Boolean.valueOf(bool1), ",isOver:", Boolean.valueOf(bool2), ",isCancel:", Boolean.valueOf(bool4), ",isInValidStatus:", Boolean.valueOf(bool3), ",msg.gameStatusStamp:", Long.valueOf(paramMessageForApollo.gameStatusStamp), ",mCreateTime:", Long.valueOf(paramLong), ",msg.gameStatus:", Integer.valueOf(paramMessageForApollo.gameStatus) });
      }
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label203;
      bool3 = false;
      break label214;
    }
    label416:
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
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo, WeakReference<XListView> paramWeakReference, WeakReference<aelz> paramWeakReference1)
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
        a(paramQQAppInterface, localMessageForApollo, paramWeakReference, paramWeakReference1, null);
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
  
  public static void b()
  {
    try
    {
      Object localObject = BaseActivity.sTopActivity;
      if ((localObject != null) && (!((Activity)localObject).isFinishing()) && ((localObject instanceof FragmentActivity)))
      {
        localObject = ((FragmentActivity)localObject).getChatFragment();
        if ((localObject != null) && (((ChatFragment)localObject).isAdded()))
        {
          localObject = ((ChatFragment)localObject).a();
          if ((localObject != null) && (!(localObject instanceof agjp)))
          {
            localObject = ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel;
            if (localObject != null) {
              ((ApolloPanel)localObject).m();
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameUtil", 1, localThrowable, new Object[0]);
    }
  }
  
  public static void b(int paramInt, String paramString)
  {
    ThreadManager.excute(new ApolloGameUtil.16(paramString, paramInt), 64, null, true);
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameUtil", 2, new Object[] { "[getOpenIdAndAccessToken], url:", paramString });
    }
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {}
    for (;;)
    {
      return;
      TicketManager localTicketManager = (TicketManager)paramQQAppInterface.getManager(2);
      if (localTicketManager != null)
      {
        paramActivity = paramQQAppInterface.getAccount();
        paramQQAppInterface = localTicketManager.getSkey(paramQQAppInterface.getAccount());
        if ((paramActivity != null) && (paramQQAppInterface != null) && (paramQQAppInterface.length() != 0))
        {
          paramString = paramString.split("\\?");
          if ((paramString != null) && (paramString.length >= 2))
          {
            paramString = paramString[1];
            try
            {
              paramString = new JSONObject(URLDecoder.decode(paramString.substring(paramString.indexOf('=') + 1), "UTF-8"));
              int i = paramString.optInt("token");
              int j = paramString.optInt("gameId");
              long l = paramString.optLong("appId");
              if (SplashActivity.a != null)
              {
                paramString = (Activity)SplashActivity.a.get();
                absn.a();
                paramString = absn.a(paramString, 5, String.valueOf(l));
                if (paramString == null) {
                  continue;
                }
                paramString.a("login", null, new alfi(i, j, paramActivity, paramQQAppInterface));
              }
            }
            catch (Exception paramActivity)
            {
              QLog.e("ApolloGameUtil", 2, " get openip and accesstoken exeption");
              return;
            }
          }
        }
      }
    }
    QLog.e("ApolloGameUtil", 2, "get openId and accessToken login failed");
  }
  
  public static void b(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramContext == null)
    {
      QLog.e("ApolloGameUtil", 1, "startSplashActivity context is null");
      return;
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    localIntent.addFlags(134283264);
    paramContext.startActivity(localIntent);
    ((Activity)paramContext).overridePendingTransition(0, 0);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ApolloGameUtil.11(paramContext, paramStartCheckParam), 2000L);
  }
  
  private static void b(Context paramContext, QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((alee.b != null) && (alee.b.contains(Integer.valueOf(paramStartCheckParam.gameId)))) {
      paramStartCheckParam.enableMenu = false;
    }
    aktw localaktw = akrg.a().a(paramStartCheckParam.gameId);
    if (localaktw != null) {
      localaktw.a((Activity)paramContext, paramStartCheckParam);
    }
    if (jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask == null) {
      jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask = new ApolloGameUtil.CmStartTask(paramQQAppInterface, paramStartCheckParam);
    }
    for (;;)
    {
      ThreadManager.removeJobFromThreadPool(jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask, 16);
      ThreadManager.excute(jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask, 16, null, true);
      d = paramStartCheckParam.gameId;
      return;
      jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask.a(paramQQAppInterface, paramStartCheckParam);
    }
  }
  
  private static void b(Intent paramIntent, String paramString, Bitmap paramBitmap)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (paramBitmap == null) {}
    for (;;)
    {
      try
      {
        paramBitmap = BitmapFactory.decodeResource(localBaseApplication.getResources(), 2130840157);
        paramBitmap.setDensity(localBaseApplication.getResources().getDisplayMetrics().densityDpi);
        int i = bdcq.a(localBaseApplication);
        if (i != paramBitmap.getWidth())
        {
          if (!bdlz.jdField_c_of_type_Boolean)
          {
            paramBitmap = bdlw.a().a(paramBitmap, i);
            paramIntent.setAction("com.tencent.apollo.SHORT_CUT");
            if (Build.VERSION.SDK_INT >= 26)
            {
              localObject = (ShortcutManager)localBaseApplication.getSystemService("shortcut");
              if ((localObject != null) && (((ShortcutManager)localObject).isRequestPinShortcutSupported())) {
                ((ShortcutManager)localObject).requestPinShortcut(new ShortcutInfo.Builder(localBaseApplication, "QQ" + paramString).setIcon(Icon.createWithBitmap(paramBitmap)).setShortLabel(paramString).setIntent(paramIntent).build(), PendingIntent.getBroadcast(localBaseApplication, 0, new Intent(localBaseApplication, WebProcessReceiver.class), 134217728).getIntentSender());
              }
            }
          }
          else
          {
            paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i, i, false);
            continue;
          }
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
          ((Intent)localObject).putExtra("android.intent.extra.shortcut.NAME", paramString);
          ((Intent)localObject).putExtra("android.intent.extra.shortcut.ICON", paramBitmap);
          ((Intent)localObject).putExtra("duplicate", false);
          ((Intent)localObject).setAction("com.android.launcher.action.INSTALL_SHORTCUT");
          localBaseApplication.sendOrderedBroadcast((Intent)localObject, null);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("ApolloGameUtil", 1, paramIntent, new Object[0]);
        return;
      }
      catch (OutOfMemoryError paramIntent)
      {
        QLog.e("ApolloGameUtil", 1, paramIntent, new Object[0]);
        return;
      }
    }
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
      awbw localawbw;
      int j;
      Object localObject3;
      Object localObject4;
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
        localawbw = paramAppInterface.getEntityManagerFactory().createEntityManager();
        paramBundle = new ArrayList();
        i = 0;
        j = 0;
        if ((localObject1 == null) || (j >= ((JSONArray)localObject1).length())) {
          break label908;
        }
        localObject3 = ((JSONArray)localObject1).optJSONObject(j);
        k = i;
        if (localObject3 == null) {
          break label1126;
        }
        int n = ((JSONObject)localObject3).optInt("busId");
        localawbw.a(ApolloGameRedDot.class.getSimpleName(), "mGameId=? ", new String[] { String.valueOf(n) });
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, em.delete，mGameId=" + n);
        }
        localObject4 = ((JSONObject)localObject3).getJSONArray("dotList");
        localObject3 = new ArrayList();
        k = 0;
        if ((localObject4 != null) && (k < ((JSONArray)localObject4).length()))
        {
          Object localObject5 = ((JSONArray)localObject4).optJSONObject(k);
          if (localObject5 == null) {
            break label1117;
          }
          int m = ((JSONObject)localObject5).optInt("dotId");
          Object localObject6;
          if (m == 1003)
          {
            localObject6 = new AioPushData();
            ((AioPushData)localObject6).begTs = ((JSONObject)localObject5).optInt("begTs");
            ((AioPushData)localObject6).busId = n;
            ((AioPushData)localObject6).busType = ((JSONObject)localObject5).optInt("busType");
            ((AioPushData)localObject6).dotId = ((JSONObject)localObject5).optInt("dotId");
            ((AioPushData)localObject6).endTs = ((JSONObject)localObject5).optInt("endTs");
            ((AioPushData)localObject6).priority = ((JSONObject)localObject5).optInt("priority");
            ((AioPushData)localObject6).them = ((JSONObject)localObject5).optString("theme");
            ((AioPushData)localObject6).wording = ((JSONObject)localObject5).optString("wording");
            ((AioPushData)localObject6).url = ((JSONObject)localObject5).optString("url");
            ((AioPushData)localObject6).actId = ((JSONObject)localObject5).optString("actId");
            ((AioPushData)localObject6).folderIconUrl = ((JSONObject)localObject5).optString("folderIconUrl");
            ((AioPushData)localObject6).spRegion = ((JSONObject)localObject5).optInt("spRegion");
            ((List)localObject3).add(localObject6);
          }
          else
          {
            localObject6 = new ApolloGameRedDot();
            ((ApolloGameRedDot)localObject6).mDotId = m;
            ((ApolloGameRedDot)localObject6).mStartTime = ((JSONObject)localObject5).optInt("begTs");
            ((ApolloGameRedDot)localObject6).mEndTime = ((JSONObject)localObject5).optInt("endTs");
            ((ApolloGameRedDot)localObject6).mTipsWording = ((JSONObject)localObject5).optString("wording");
            ((ApolloGameRedDot)localObject6).mGameId = n;
            ((ApolloGameRedDot)localObject6).mUrl = ((JSONObject)localObject5).optString("url");
            ((ApolloGameRedDot)localObject6).mActId = ((JSONObject)localObject5).optString("actId");
            ((ApolloGameRedDot)localObject6).mPriority = ((JSONObject)localObject5).optInt("priority");
            ((ApolloGameRedDot)localObject6).mSpRegion = ((JSONObject)localObject5).optInt("spRegion");
            localObject5 = (alpr)paramAppInterface.getManager(255);
            ((aleh)paramAppInterface.getManager(155)).a(((ApolloGameRedDot)localObject6).mGameId);
            VipUtils.a(null, "cmshow", "Apollo", "get_notice", m, 0, new String[] { String.valueOf(n), "", ((ApolloGameRedDot)localObject6).mActId });
            if (ApolloGameRedDot.isValidReddotId(m)) {
              if (!((ApolloGameRedDot)localObject6).isTimeValid())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, apolloGameRedDot.isTimeValid():false," + localObject6);
                }
              }
              else
              {
                paramBundle.add(localObject6);
                localawbw.b((awbv)localObject6);
                ((SharedPreferences.Editor)localObject2).putBoolean(a((ApolloGameRedDot)localObject6), false);
                m = 1;
                i = m;
                if (QLog.isColorLevel())
                {
                  QLog.d("ApolloGameUtil", 2, "apolloGameReddot parseGameReddot, saveApolloGameRedDot:" + localObject6);
                  i = m;
                }
              }
            }
          }
        }
      }
      catch (Throwable paramAppInterface)
      {
        QLog.e("ApolloGameUtil", 1, "apolloGameReddot checkApolloGameRedDot failed ", paramAppInterface);
        return;
      }
      a(localawbw);
      int k = i;
      if (((List)localObject3).size() > 0)
      {
        localObject4 = (aleh)paramAppInterface.getManager(155);
        if (localObject4 != null)
        {
          ((aleh)localObject4).a((List)localObject3, 1);
          k = i;
        }
        else
        {
          QLog.e("ApolloGameUtil", 1, "[parseGameReddot] do manager is null");
          k = i;
          break label1126;
          label908:
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
              ((akji)paramAppInterface.getManager(153)).a((DrawerPushItem)localObject2, false);
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
          label1117:
          k += 1;
          continue;
        }
      }
      label1126:
      j += 1;
      int i = k;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramQQAppInterface == null) || (paramStartCheckParam == null)) {
      return;
    }
    ThreadManager.post(new ApolloGameUtil.23(paramQQAppInterface, paramStartCheckParam), 5, null, true);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface) == 2;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = ((aleh)paramQQAppInterface.getManager(155)).g();
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
  
  public static void c()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("start_cm_game", 4).edit().clear().commit();
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    akji localakji = (akji)paramQQAppInterface.getManager(153);
    if ((a(paramQQAppInterface)) && (localakji.d)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, new Object[] { "isGameCityUser read in cache status:", Boolean.valueOf(bool), ", newStoreUser:", Boolean.valueOf(localakji.d) });
      }
      return bool;
    }
  }
  
  public static void d()
  {
    if ((jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask != null) && (jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask.b != null) && (jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask.b.get() != null) && (((CmGameStartChecker.StartCheckParam)jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask.b.get()).gameId == d))
    {
      QLog.i("ApolloGameUtil", 1, "get game data and restartGameTask, gameId:" + d);
      ThreadManager.removeJobFromThreadPool(jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask, 16);
      ThreadManager.excute(jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameUtil$CmStartTask, 16, null, true);
      d = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil
 * JD-Core Version:    0.7.0.1
 */