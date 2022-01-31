package com.tencent.mobileqq.apollo.process;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.HardwareInfo;
import com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;
import com.tencent.mobileqq.apollo.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.ar.config.WorldCupStaticInstance;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import ywm;

public class CmGameUtil
{
  public static int a()
  {
    return CmGameServerQIPCModule.a().a();
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {}
    do
    {
      return 1;
      if (paramInt == 2) {
        return 8;
      }
    } while (paramInt != 3);
    return 0;
  }
  
  public static int a(long paramLong)
  {
    CmGameLauncher localCmGameLauncher = b(paramLong);
    if (localCmGameLauncher == null) {
      return -1;
    }
    return localCmGameLauncher.a();
  }
  
  public static AppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("cmshowgame_module");
        if (!(localObject instanceof AppInterface)) {
          break label53;
        }
        return (AppInterface)localObject;
      }
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
    label53:
    return null;
  }
  
  public static ApolloSurfaceView a()
  {
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((CmGameManager)localObject).a();
    } while (localObject == null);
    return ((CmGameLauncher)localObject).a();
  }
  
  public static ApolloCmdChannel a()
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager != null) {
      return localCmGameManager.a();
    }
    return null;
  }
  
  public static CmGameLauncher a()
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.a();
  }
  
  public static CmGameLauncher a(int paramInt)
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.a(paramInt);
  }
  
  public static CmGameLauncher a(long paramLong)
  {
    ApolloRender localApolloRender = ApolloRender.getRenderByThreadId();
    if ((localApolloRender == null) || (localApolloRender.getSavaWrapper() == null))
    {
      QLog.w("cmgame_process.CmGameUtil", 1, "render is null.");
      return null;
    }
    return b(localApolloRender.getSavaWrapper().a());
  }
  
  public static CmGameMainManager a()
  {
    int i = a();
    if (-1 == i) {}
    CmGameLifeCycle localCmGameLifeCycle;
    do
    {
      return null;
      localCmGameLifeCycle = CmGameServerQIPCModule.a().a(i);
    } while (localCmGameLifeCycle == null);
    return localCmGameLifeCycle.a();
  }
  
  public static CmGameManager a()
  {
    AppInterface localAppInterface = a();
    if ((localAppInterface instanceof CmGameAppInterface)) {
      return (CmGameManager)((CmGameAppInterface)localAppInterface).getManager(255);
    }
    return null;
  }
  
  public static CmGameOpenIdFinder a(int paramInt)
  {
    CmGameLauncher localCmGameLauncher = a(paramInt);
    if (localCmGameLauncher != null) {
      return localCmGameLauncher.a();
    }
    QLog.w("cmgame_process.CmGameUtil", 1, "CmGameOpenIdFinder is nulllll.");
    return null;
  }
  
  public static CmGameOpenIdFinder a(long paramLong)
  {
    CmGameLauncher localCmGameLauncher = b(paramLong);
    if (localCmGameLauncher != null) {
      return localCmGameLauncher.a();
    }
    QLog.w("cmgame_process.CmGameUtil", 1, "CmGameOpenIdFinder is nulllll.");
    return null;
  }
  
  public static CmGameSSoHandler a()
  {
    try
    {
      Object localObject = a();
      if ((localObject != null) && ((localObject instanceof CmGameAppInterface)))
      {
        localObject = (CmGameSSoHandler)((AppInterface)localObject).getBusinessHandler(0);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
      return null;
    }
    return null;
  }
  
  public static Class a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        int i = paramString.indexOf(')');
        if (-1 != i)
        {
          paramString = a(paramString.substring(i + 1));
          if ((paramString != null) && (paramString.length != 0))
          {
            paramString = paramString[0];
            return paramString;
          }
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmgame_process.CmGameUtil", 1, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  public static String a(CmGameInitParams paramCmGameInitParams)
  {
    if (paramCmGameInitParams == null) {
      return "";
    }
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("roomId", String.valueOf(paramCmGameInitParams.mRoomId));
        if (("1".equals(paramCmGameInitParams.mGameName)) || ("2".equals(paramCmGameInitParams.mGameName)))
        {
          localJSONObject1.put("gameId", paramCmGameInitParams.mGameName);
          localJSONObject1.put("gameVersion", paramCmGameInitParams.mVersion);
          localJSONObject1.put("QQVer", "7.6.8.3615");
          localJSONObject1.put("platform", "android");
          if ((!ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) || (ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo == null)) {
            break label479;
          }
          localJSONObject1.put("freeMemory", ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo.jdField_b_of_type_Long);
          localJSONObject1.put("totalMemory", ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo.jdField_c_of_type_Long);
          localJSONObject1.put("osVersion", ApolloGameStateMachine.HardwareInfo.jdField_a_of_type_JavaLangString);
          localJSONObject1.put("model", ApolloGameStateMachine.HardwareInfo.jdField_b_of_type_JavaLangString);
          str2 = paramCmGameInitParams.mGameParam;
          if (!TextUtils.isEmpty(str2))
          {
            bool = str2.contains("extendInfo");
            localObject = str2;
            if (!bool) {}
          }
        }
      }
      catch (Exception paramCmGameInitParams)
      {
        Object localObject;
        JSONObject localJSONObject2;
        label407:
        QLog.e("cmgame_process.CmGameUtil", 2, paramCmGameInitParams.getMessage());
        return "{}";
      }
      try
      {
        localJSONObject2 = new JSONObject(str2);
        localObject = str2;
        if (localJSONObject2.has("extendInfo")) {
          localObject = localJSONObject2.optString("extendInfo");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
        String str1 = str2;
        continue;
        if (!paramCmGameInitParams.mIsMaster) {
          break label569;
        }
        i = 1;
        localJSONObject1.put("isMaster", i);
        break label584;
        i = 0;
        while (!bool)
        {
          i = 1;
          break label407;
          bool = true;
          break;
        }
        i = 0;
        continue;
      }
      localJSONObject1.put("gameParam", localObject);
      localJSONObject1.put("src", paramCmGameInitParams.mSrc);
      localJSONObject1.put("networkType", ApolloGameBasicEventUtil.b());
      localJSONObject1.put("connType", NetworkUtil.a(BaseApplicationImpl.getContext()));
      if (!TextUtils.isEmpty(paramCmGameInitParams.openId)) {
        localJSONObject1.put("openId", paramCmGameInitParams.openId);
      }
      localJSONObject1.put("accessTokenCode", paramCmGameInitParams.accessTokenRet);
      localJSONObject1.put("accessToken", paramCmGameInitParams.accessToken);
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
      if (localObject == null) {
        break label579;
      }
      bool = ((SharedPreferences)localObject).getBoolean("is_ever_play_cmgame" + paramCmGameInitParams.mGameName + paramCmGameInitParams.mSelfUin, false);
      if ((paramCmGameInitParams.mGameMode != 1) && (paramCmGameInitParams.mGameMode != 2)) {
        break;
      }
      localJSONObject1.put("isMaster", 1);
      break label584;
      localJSONObject1.put("isFirstPlay", i);
      localJSONObject1.put("sex", paramCmGameInitParams.gender);
      paramCmGameInitParams = localJSONObject1.toString();
      return paramCmGameInitParams;
      try
      {
        localJSONObject1.put("gameId", Integer.parseInt(paramCmGameInitParams.mGameName));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      label479:
      localJSONObject1.put("freeMemory", DeviceInfoUtil.a(Process.myPid()));
      localJSONObject1.put("totalMemory", DeviceInfoUtil.g());
      localJSONObject1.put("osVersion", DeviceInfoUtil.f());
      localJSONObject1.put("model", DeviceInfoUtil.j());
    }
  }
  
  public static void a(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameUtil", 1, "fail to close game, gameId:" + paramInt);
    }
    do
    {
      return;
      localObject = ((CmGameLauncher)localObject).a();
    } while (localObject == null);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, "success to close game, gameId:" + paramInt);
    }
    ((Activity)localObject).finish();
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    QLog.i("cmgame_process.CmGameUtil", 1, "[sendActLifeCycleIpc], gameId:" + paramInt2 + ",status:" + paramInt1);
    Bundle localBundle = new Bundle();
    localBundle.putInt("status", paramInt1);
    localBundle.putInt("gameId", paramInt2);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "game_activity_lifecycle", localBundle, null);
  }
  
  public static void a(int paramInt1, int paramInt2, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    QLog.i("cmgame_process.CmGameUtil", 1, "[sendActLifeCycleIpc], gameId:" + paramInt2 + ",status:" + paramInt1);
    Bundle localBundle = new Bundle();
    localBundle.putInt("status", paramInt1);
    localBundle.putInt("gameId", paramInt2);
    localBundle.putSerializable("para", paramStartCheckParam);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "game_activity_lifecycle", localBundle, null);
  }
  
  public static void a(int paramInt, Context paramContext)
  {
    try
    {
      localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      localObject = ((CmGameLauncher)localObject).a();
      if (localObject == null)
      {
        QLog.w("cmgame_process.CmGameUtil", 1, "CmGameInitParams is null.");
        return;
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, paramContext, new Object[0]);
      return;
    }
    if ((paramContext instanceof ApolloGameActivity)) {
      ((ApolloGameActivity)paramContext).moveTaskToBack(true);
    }
    paramInt = ((CmGameStartChecker.StartCheckParam)localObject).enter;
    Object localObject = new Intent(paramContext, SplashActivity.class);
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 7))
    {
      ((Intent)localObject).putExtra("fragment_id", 2);
      for (;;)
      {
        ((Intent)localObject).putExtra("fromApollo", 1);
        ((Intent)localObject).setFlags(67174400);
        paramContext.startActivity((Intent)localObject);
        return;
        label122:
        ((Intent)localObject).putExtra("fragment_id", 1);
        ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      break;
      if ((paramInt == 2) || (paramInt == 8)) {
        break label122;
      }
      if (paramInt != 5) {
        if (paramInt != 4) {
          break;
        }
      }
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      Intent localIntent = new Intent(paramActivity, SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      localIntent.putExtra("fromApolloNewUser", 1);
      localIntent.setFlags(67174400);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static void a(Activity paramActivity, Conversation paramConversation)
  {
    if (a() == null) {}
    WorldCupConfigInfo localWorldCupConfigInfo;
    ApolloManager localApolloManager;
    do
    {
      return;
      localWorldCupConfigInfo = WorldCup.a(a());
      localApolloManager = (ApolloManager)a().getManager(152);
      if (WorldCupConfigInfo.d(localWorldCupConfigInfo)) {
        localApolloManager.l = true;
      }
    } while ((localApolloManager == null) || (!localApolloManager.k) || (paramActivity == null) || (!(paramActivity instanceof SplashActivity)) || (paramActivity.isFinishing()) || (!((SplashActivity)paramActivity).isResume()) || (WorldCupStaticInstance.a().c) || (WorldCupConfigInfo.d(localWorldCupConfigInfo)) || (paramConversation == null));
    if (FrameHelperActivity.a())
    {
      FrameHelperActivity.b(true);
      FrameHelperActivity.o();
    }
    a(paramConversation.b);
    localApolloManager.k = false;
    paramConversation.f = true;
  }
  
  public static void a(View paramView)
  {
    if (paramView != null)
    {
      Object localObject = new Rect();
      paramView.getGlobalVisibleRect((Rect)localObject);
      int i = (int)((float)DeviceInfoUtil.l() - DeviceInfoUtil.a * 7.0F - DeviceInfoUtil.a * 159.0F);
      int j = (int)(((Rect)localObject).bottom - 6.0F * DeviceInfoUtil.a);
      localObject = new PopupWindow(paramView.getContext());
      TextView localTextView = new TextView(paramView.getContext());
      localTextView.setText("手Q可以玩轻游戏啦");
      localTextView.setGravity(17);
      localTextView.setTextSize(16.0F);
      localTextView.setTextColor(-1);
      localTextView.setPadding(0, (int)(DeviceInfoUtil.a * 7.0F), 0, 0);
      localTextView.setWidth((int)(DeviceInfoUtil.a * 159.0F));
      localTextView.setHeight((int)(DeviceInfoUtil.a * 42.0F));
      localTextView.setBackgroundResource(2130838151);
      ((PopupWindow)localObject).setContentView(localTextView);
      ((PopupWindow)localObject).setOutsideTouchable(true);
      ((PopupWindow)localObject).setBackgroundDrawable(new ColorDrawable(0));
      ((PopupWindow)localObject).showAtLocation(paramView.getRootView(), 0, i, j);
      ((PopupWindow)localObject).update(i, j, (int)(DeviceInfoUtil.a * 159.0F), (int)(DeviceInfoUtil.a * 42.0F));
      b(1);
      ThreadManager.getUIHandler().postDelayed(new ywm((PopupWindow)localObject), 10000L);
      QLog.d("cmgame_process.CmGameUtil", 1, "showNewPlusGuidePop");
      VipUtils.a(a(), "cmshow", "Apollo", "plusbubbleexposure", 0, 0, new String[] { "" + c(), "" + ApolloManager.a() });
    }
  }
  
  public static void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, "[launchGame]");
    }
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
      QLog.e("cmgame_process.CmGameUtil", 1, "[launchGame], null params.");
    }
    do
    {
      return;
      if (!a(paramStartCheckParam)) {
        break;
      }
      localObject = a();
    } while (localObject == null);
    Object localObject = ((CmGameManager)localObject).a();
    if (localObject != null)
    {
      Activity localActivity = ((CmGameLauncher)localObject).a();
      if (localActivity != null)
      {
        localActivity.finish();
        CmGameToolCmdChannel.a("cs.close_room.local", "{}", false, null, ((CmGameLauncher)localObject).a());
        QLog.i("cmgame_process.CmGameUtil", 1, "finish old act.");
      }
    }
    localObject = new Intent(BaseApplicationImpl.getApplication(), ApolloGameActivity.class);
    ((Intent)localObject).putExtra("extra_startcheckparam", paramStartCheckParam);
    ((Intent)localObject).addFlags(268435456);
    BaseApplicationImpl.getApplication().startActivity((Intent)localObject);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!a()) {}
    CmGameSSoHandler localCmGameSSoHandler;
    do
    {
      do
      {
        return;
      } while (!"apollo_aio_game.cancel_game_room".equals(paramString1));
      localCmGameSSoHandler = a();
    } while (localCmGameSSoHandler == null);
    localCmGameSSoHandler.a(paramString1, paramString2, -1L, 4, false, null);
  }
  
  public static boolean a()
  {
    AppInterface localAppInterface = a();
    return (localAppInterface != null) && ((localAppInterface instanceof CmGameAppInterface));
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 1000;
  }
  
  public static boolean a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {}
    Object localObject;
    CmGameLauncher localCmGameLauncher;
    do
    {
      do
      {
        do
        {
          return false;
          localObject = a();
        } while (localObject == null);
        localCmGameLauncher = ((CmGameManager)localObject).c(paramStartCheckParam.game.gameId);
        if (localCmGameLauncher != null) {
          break;
        }
      } while (((CmGameManager)localObject).a() == null);
      return true;
      localObject = localCmGameLauncher.a();
    } while ((localCmGameLauncher.a() == paramStartCheckParam.game.gameId) && ((paramStartCheckParam.roomId == 0L) || (paramStartCheckParam.roomId == ((ApolloPanel.GameMsgInfo)localObject).jdField_b_of_type_Long)));
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramQQAppInterface == null)) {
      return false;
    }
    Object localObject = ((ApolloDaoManager)paramQQAppInterface.getManager(154)).a(paramStartCheckParam.gameId);
    if (localObject == null)
    {
      ApolloItemBuilder.a("游戏数据更新中，请稍后再试", 2, BaseApplicationImpl.getContext());
      ApolloContentUpdateHandler.a(paramQQAppInterface, 2);
      return false;
    }
    ApolloManager localApolloManager = (ApolloManager)paramQQAppInterface.getManager(152);
    if (localApolloManager != null)
    {
      paramStartCheckParam.game = ((ApolloGameData)localObject);
      paramStartCheckParam.version = localApolloManager.a(paramStartCheckParam.gameId);
      localObject = paramQQAppInterface.getCurrentAccountUin();
      paramStartCheckParam.isWhiteUsr = localApolloManager.b((String)localObject);
      paramStartCheckParam.apolloStatus = localApolloManager.b((String)localObject);
    }
    paramStartCheckParam.mGameType = ApolloGameUtil.a(paramStartCheckParam.game.gameId);
    int i = ((ApolloGameManager)paramQQAppInterface.getManager(210)).a(paramStartCheckParam.game.gameId, paramStartCheckParam.mGameType);
    if (i != -1) {
      paramStartCheckParam.game.viewMode = i;
    }
    paramStartCheckParam.gender = ((NearbyCardManager)paramQQAppInterface.getManager(105)).b();
    return true;
  }
  
  public static Class[] a(String paramString)
  {
    int i1 = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (TextUtils.isEmpty(paramString.trim())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i2 = paramString.length();
    int k = 0;
    int j = 0;
    int m;
    if (k < i2)
    {
      m = paramString.charAt(k);
      if (41 != m) {}
    }
    else
    {
      if (localArrayList.size() != 0) {
        break label726;
      }
      return null;
    }
    int n = k;
    int i = j;
    switch (m)
    {
    default: 
      i = j;
      n = k;
    }
    for (;;)
    {
      k = n + 1;
      j = i;
      break;
      localArrayList.add(Void.TYPE);
      n = k;
      i = j;
      continue;
      i = 1;
      n = k;
      continue;
      if (j != 0)
      {
        localArrayList.add([Z.class);
        i = 0;
        n = k;
      }
      else
      {
        localArrayList.add(Boolean.TYPE);
        n = k;
        i = j;
        continue;
        if (j != 0)
        {
          localArrayList.add([B.class);
          i = 0;
          n = k;
        }
        else
        {
          localArrayList.add(Byte.TYPE);
          n = k;
          i = j;
          continue;
          if (j != 0)
          {
            localArrayList.add([C.class);
            i = 0;
            n = k;
          }
          else
          {
            localArrayList.add(Character.TYPE);
            n = k;
            i = j;
            continue;
            if (j != 0)
            {
              localArrayList.add([S.class);
              i = 0;
              n = k;
            }
            else
            {
              localArrayList.add(Short.TYPE);
              n = k;
              i = j;
              continue;
              if (j != 0)
              {
                localArrayList.add([I.class);
                i = 0;
                n = k;
              }
              else
              {
                localArrayList.add(Integer.TYPE);
                n = k;
                i = j;
                continue;
                if (j != 0)
                {
                  localArrayList.add([J.class);
                  i = 0;
                  n = k;
                }
                else
                {
                  localArrayList.add(Long.TYPE);
                  n = k;
                  i = j;
                  continue;
                  if (j != 0)
                  {
                    localArrayList.add([F.class);
                    i = 0;
                    n = k;
                  }
                  else
                  {
                    localArrayList.add(Float.TYPE);
                    n = k;
                    i = j;
                    continue;
                    if (j != 0)
                    {
                      localArrayList.add([D.class);
                      i = 0;
                      n = k;
                    }
                    else
                    {
                      localArrayList.add(Double.TYPE);
                      n = k;
                      i = j;
                      continue;
                      n = k + 1;
                      k = n;
                      for (i = m; (k < i2) && (i != 59); i = paramString.charAt(k)) {
                        k += 1;
                      }
                      m = j;
                      try
                      {
                        Object localObject = paramString.substring(n, k);
                        m = j;
                        if (QLog.isColorLevel())
                        {
                          m = j;
                          QLog.d("cmgame_process.CmGameUtil", 2, new Object[] { "clsName:", localObject });
                        }
                        m = j;
                        String str = ((String)localObject).replace('/', '.');
                        i = j;
                        localObject = str;
                        if (j != 0)
                        {
                          m = j;
                          localObject = "[L" + str + ";";
                          i = 0;
                        }
                        m = i;
                        localArrayList.add(Class.forName((String)localObject));
                        n = k;
                      }
                      catch (Throwable localThrowable)
                      {
                        QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
                        n = k;
                        i = m;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label726:
    paramString = new Class[localArrayList.size()];
    Iterator localIterator = localArrayList.iterator();
    i = i1;
    while (localIterator.hasNext())
    {
      paramString[i] = ((Class)localIterator.next());
      i += 1;
    }
    return paramString;
  }
  
  public static int b()
  {
    if (a() == null) {
      return 0;
    }
    ApolloManager localApolloManager = (ApolloManager)a().getManager(152);
    if ((localApolloManager != null) && (localApolloManager.g())) {
      return 1;
    }
    return 0;
  }
  
  public static CmGameLauncher b(int paramInt)
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.c(paramInt);
  }
  
  public static CmGameLauncher b(long paramLong)
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.a(paramLong);
  }
  
  public static String b(CmGameInitParams paramCmGameInitParams)
  {
    if (paramCmGameInitParams == null) {
      return "";
    }
    for (;;)
    {
      try
      {
        localJSONObject1 = ApolloGameBasicEventUtil.a(0, ApolloResDownloader.a);
        if (localJSONObject1 == null)
        {
          QLog.e("cmgame_process.CmGameUtil", 1, "json is null");
          return "{}";
        }
        localJSONObject1.put("roomId", String.valueOf(paramCmGameInitParams.mRoomId));
        localJSONObject1.put("svrIp", paramCmGameInitParams.mServerIp);
        localJSONObject1.put("port", paramCmGameInitParams.mPort);
        localJSONObject1.put("spriteDesignHeight", 368);
        if (("1".equals(paramCmGameInitParams.mGameName)) || ("2".equals(paramCmGameInitParams.mGameName)))
        {
          localJSONObject1.put("gameId", paramCmGameInitParams.mGameName);
          if ((!ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) || (ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo == null)) {
            break label906;
          }
          localJSONObject1.put("freeMemory", ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo.jdField_b_of_type_Long);
          localJSONObject1.put("totalMemory", ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo.jdField_c_of_type_Long);
          localJSONObject1.put("osVersion", ApolloGameStateMachine.HardwareInfo.jdField_a_of_type_JavaLangString);
          localJSONObject1.put("model", ApolloGameStateMachine.HardwareInfo.jdField_b_of_type_JavaLangString);
          localJSONObject1.put("cpuType", ApolloGameStateMachine.HardwareInfo.jdField_c_of_type_JavaLangString);
          localJSONObject1.put("cpuNumber", ApolloGameStateMachine.HardwareInfo.jdField_a_of_type_Int);
          localJSONObject1.put("cpuFrequency", ApolloGameStateMachine.HardwareInfo.jdField_a_of_type_Long);
          localJSONObject1.put("gameVersion", paramCmGameInitParams.mVersion);
          localJSONObject1.put("QQVer", "7.6.8.3615");
          localJSONObject1.put("platform", "android");
          localJSONObject1.put("gameMode", paramCmGameInitParams.mGameMode);
          if (!TextUtils.isEmpty(paramCmGameInitParams.openId)) {
            localJSONObject1.put("openId", paramCmGameInitParams.openId);
          }
          str2 = paramCmGameInitParams.mGameParam;
          if (!TextUtils.isEmpty(str2))
          {
            bool1 = str2.contains("extendInfo");
            localObject = str2;
            if (!bool1) {}
          }
        }
      }
      catch (Exception paramCmGameInitParams)
      {
        Object localObject;
        JSONObject localJSONObject2;
        QLog.e("cmgame_process.CmGameUtil", 2, paramCmGameInitParams.getMessage());
        return "{}";
      }
      try
      {
        localJSONObject2 = new JSONObject(str2);
        localObject = str2;
        if (localJSONObject2.has("extendInfo")) {
          localObject = localJSONObject2.optString("extendInfo");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
        String str1 = str2;
        continue;
        localJSONObject1.put("aioType", paramCmGameInitParams.mSessionType);
        if (!paramCmGameInitParams.mIsMaster) {
          break label1048;
        }
        for (i = 1;; i = 0)
        {
          localJSONObject1.put("isMaster", i);
          break;
        }
        bool2 = false;
        bool1 = true;
        if (!bool1) {
          break label1074;
        }
        i = 0;
        continue;
        i = 0;
        continue;
        i = 1;
        continue;
      }
      localJSONObject1.put("gameParam", localObject);
      if (!paramCmGameInitParams.isWhiteUsr) {
        break label1069;
      }
      i = 1;
      localJSONObject1.put("isWhiteUser", i);
      localJSONObject1.put("src", paramCmGameInitParams.mSrc);
      localJSONObject1.put("networkType", ApolloGameBasicEventUtil.b());
      localJSONObject1.put("connType", NetworkUtil.a(BaseApplicationImpl.getContext()));
      localJSONObject1.put("accessTokenCode", paramCmGameInitParams.accessTokenRet);
      localJSONObject1.put("accessToken", paramCmGameInitParams.accessToken);
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
      if (localObject == null) {
        break label1053;
      }
      bool1 = ((SharedPreferences)localObject).getBoolean("is_ever_play_cmgame" + paramCmGameInitParams.mGameName + paramCmGameInitParams.mSelfUin, false);
      bool2 = ((SharedPreferences)localObject).getBoolean("is_first_install_cmgame" + paramCmGameInitParams.mGameName + paramCmGameInitParams.mSelfUin, true);
      if (!bool2) {
        break label1060;
      }
      ((SharedPreferences)localObject).edit().putBoolean("is_first_install_cmgame" + paramCmGameInitParams.mGameName + paramCmGameInitParams.mSelfUin, false).commit();
      break label1060;
      localJSONObject1.put("isFirstPlay", i);
      localJSONObject1.put("isFirstInstall", bool2);
      localJSONObject1.put("sessionId", String.valueOf(new Random(System.currentTimeMillis()).nextInt(100000)));
      if ((paramCmGameInitParams.mGameMode != 1) && (paramCmGameInitParams.mGameMode != 2)) {
        break;
      }
      localJSONObject1.put("aioType", 1);
      localJSONObject1.put("isMaster", 1);
      if ((!TextUtils.isEmpty(paramCmGameInitParams.mExtraStr)) && (("1".equals(paramCmGameInitParams.mGameName)) || ("2".equals(paramCmGameInitParams.mGameName)))) {
        localJSONObject1.put("extraStr", paramCmGameInitParams.mExtraStr);
      }
      localJSONObject1.put("sex", paramCmGameInitParams.gender);
      localJSONObject1.put("apolloStatus", paramCmGameInitParams.apolloStatus);
      localJSONObject1.put("gameType", paramCmGameInitParams.gameType);
      localJSONObject1.put("redUrl", paramCmGameInitParams.redUrl);
      QLog.i("cmgame_process.CmGameUtil", 1, "gameId:" + paramCmGameInitParams.mGameName + ",gameMode:" + paramCmGameInitParams.mGameMode + ",src:" + paramCmGameInitParams.mSrc + ",roomId:" + paramCmGameInitParams.mRoomId);
      paramCmGameInitParams = localJSONObject1.toString();
      return paramCmGameInitParams;
      try
      {
        localJSONObject1.put("gameId", Integer.parseInt(paramCmGameInitParams.mGameName));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      label906:
      localJSONObject1.put("freeMemory", DeviceInfoUtil.a(Process.myPid()));
      localJSONObject1.put("totalMemory", DeviceInfoUtil.g());
      localJSONObject1.put("osVersion", DeviceInfoUtil.f());
      localJSONObject1.put("model", DeviceInfoUtil.j());
      localJSONObject1.put("cpuType", DeviceInfoUtil.h());
      localJSONObject1.put("cpuNumber", DeviceInfoUtil.b());
      localJSONObject1.put("cpuFrequency", DeviceInfoUtil.a());
    }
  }
  
  public static void b(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", paramInt);
      ((VasExtensionHandler)a().getBusinessHandler(71)).a("apollo_router_game.game_extend_linkcmd_set_plus_flag", localJSONObject.toString(), -1L, 0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static boolean b()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
      if (localAudioManager != null)
      {
        int i = localAudioManager.getRingerMode();
        if (i == 1) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("cmgame_process.CmGameUtil", 1, "isRingerVibrate error: " + localThrowable.getMessage());
    }
    return false;
  }
  
  public static int c()
  {
    if (a() == null) {
      return 0;
    }
    ApolloManager localApolloManager = (ApolloManager)a().getManager(152);
    if ((localApolloManager != null) && (localApolloManager.f)) {
      return 1;
    }
    return 0;
  }
  
  public static CmGameLauncher c(int paramInt)
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.b(paramInt);
  }
  
  public static boolean c()
  {
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getStreamVolume(2) == 0);
  }
  
  public static boolean d()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)BaseApplicationImpl.getApplication().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameUtil
 * JD-Core Version:    0.7.0.1
 */