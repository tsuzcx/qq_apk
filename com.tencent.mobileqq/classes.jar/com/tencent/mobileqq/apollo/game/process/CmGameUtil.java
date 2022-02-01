package com.tencent.mobileqq.apollo.game.process;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.HardwareInfo;
import com.tencent.mobileqq.apollo.game.CmGameAudioManager;
import com.tencent.mobileqq.apollo.game.CmGameServlet;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
import com.tencent.mobileqq.apollo.game.process.data.CmGameAppInterface;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.game.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.game.process.data.CmGameOpenIdFinder;
import com.tencent.mobileqq.apollo.game.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResDownloaderImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.SavaNativeMethodUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.util.QQDeviceInfo;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameUtil
{
  static float jdField_a_of_type_Float = 0.0F;
  static int jdField_a_of_type_Int = 0;
  public static long a = 0L;
  private static LRULinkedHashMap<String, String> jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(3);
  public static boolean a = true;
  static long b;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_Float = -1.0F;
    jdField_b_of_type_Long = -1L;
  }
  
  public static final int a()
  {
    if (NetworkState.isWifiConn()) {
      return 4;
    }
    int j = 0;
    String str = QQDeviceInfo.getIMSI("7411ce");
    int i = j;
    if (!TextUtils.isEmpty(str)) {
      if ((!str.startsWith("46000")) && (!str.startsWith("46002")))
      {
        if (str.startsWith("46001")) {
          return 2;
        }
        i = j;
        if (str.startsWith("46003")) {
          return 3;
        }
      }
      else
      {
        i = 1;
      }
    }
    return i;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 2) {
      return 8;
    }
    if (paramInt == 3) {
      return 0;
    }
    return 1;
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
    Object localObject3 = BaseApplicationImpl.getApplication();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
      if ((localObject3 instanceof ToolAppRuntime))
      {
        localObject3 = ((AppRuntime)localObject3).getAppRuntime("cmshowgame_module");
        localObject1 = localObject2;
        if ((localObject3 instanceof AppInterface)) {
          return (AppInterface)localObject3;
        }
      }
      else
      {
        localObject1 = localObject2;
        if ((localObject3 instanceof QQAppInterface)) {
          localObject1 = (QQAppInterface)localObject3;
        }
      }
    }
    return localObject1;
  }
  
  public static CmGameLauncher a(int paramInt)
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.a(paramInt);
  }
  
  public static CmGameLauncher a(int paramInt1, int paramInt2)
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.a(paramInt1, paramInt2);
  }
  
  public static CmGameLauncher a(long paramLong)
  {
    ApolloRender localApolloRender = ApolloRender.getCurrentRender();
    if ((localApolloRender != null) && (localApolloRender.getSavaWrapper() != null)) {
      return b(localApolloRender.getSavaWrapper().getLuaState());
    }
    QLog.w("cmgame_process.CmGameUtil", 1, "render is null.");
    return null;
  }
  
  public static CmGameManager a()
  {
    AppInterface localAppInterface = a();
    if ((localAppInterface instanceof CmGameAppInterface)) {
      return (CmGameManager)((CmGameAppInterface)localAppInterface).getManager(CmGameAppInterface.jdField_a_of_type_Int);
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
      if (localObject != null)
      {
        if (!(localObject instanceof CmGameAppInterface)) {
          return null;
        }
        localObject = (CmGameSSoHandler)((AppInterface)localObject).getBusinessHandler(CmGameAppInterface.jdField_a_of_type_JavaLangString);
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
    }
    return null;
  }
  
  public static Class a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      int i = paramString.indexOf(')');
      if (-1 == i) {
        return null;
      }
      paramString = SavaNativeMethodUtil.a(paramString.substring(i + 1));
      if ((paramString != null) && (paramString.length != 0))
      {
        paramString = paramString[0];
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  public static String a(CmGameInitParams paramCmGameInitParams)
  {
    return b(paramCmGameInitParams);
  }
  
  public static String a(String paramString)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[getMainJsFromCache] sEnableMainJsCache=", Boolean.valueOf(jdField_a_of_type_Boolean), ", mainJsPath=", paramString });
    if ((jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramString))) {
      return (String)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
    }
    return null;
  }
  
  public static void a()
  {
    if (a(BaseApplicationImpl.getContext())) {
      return;
    }
    Object localObject = a();
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((AppInterface)localObject).getAccount())) {
        return;
      }
      QLog.d("cmgame_process.CmGameUtil", 1, "onGameCrashed");
      localObject = (ApolloGameManagerImpl)((AppInterface)localObject).getRuntimeService(IApolloGameManager.class, "all");
      if ((localObject != null) && (((ApolloGameManagerImpl)localObject).isGameAudioManagerCreated())) {
        ((ApolloGameManagerImpl)localObject).getCmGameAudioManager().a();
      }
    }
  }
  
  public static void a(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fail to close game, gameId:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("cmgame_process.CmGameUtil", 1, ((StringBuilder)localObject).toString());
      return;
    }
    localObject = ((CmGameLauncher)localObject).a();
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("success to close game, gameId:");
        localStringBuilder.append(paramInt);
        QLog.d("cmgame_process.CmGameUtil", 2, localStringBuilder.toString());
      }
      ((Activity)localObject).finish();
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[sendActLifeCycleIpc], gameId:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(",status:");
    ((StringBuilder)localObject).append(paramInt1);
    QLog.i("cmgame_process.CmGameUtil", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putInt("status", paramInt1);
    ((Bundle)localObject).putInt("gameId", paramInt2);
    ((Bundle)localObject).putInt("activityId", paramInt3);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "game_activity_lifecycle", (Bundle)localObject, null);
  }
  
  public static void a(int paramInt, Context paramContext)
  {
    try
    {
      Object localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      localObject = ((CmGameLauncher)localObject).a();
      if (localObject == null)
      {
        QLog.w("cmgame_process.CmGameUtil", 1, "CmGameInitParams is null.");
        return;
      }
      paramInt = ((StartCheckParam)localObject).enter;
      localObject = new Intent(paramContext, SplashActivity.class);
      if ((paramInt != 0) && (paramInt != 1) && (paramInt != 7))
      {
        if ((paramInt != 2) && (paramInt != 8))
        {
          if ((paramInt == 5) || (paramInt == 4))
          {
            ((Intent)localObject).putExtra("fragment_id", 1);
            ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
          }
        }
        else
        {
          ((Intent)localObject).putExtra("fragment_id", 1);
          ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
        }
      }
      else {
        ((Intent)localObject).putExtra("fragment_id", 2);
      }
      ((Intent)localObject).putExtra("fromApollo", 1);
      ((Intent)localObject).setFlags(67174400);
      paramContext.startActivity((Intent)localObject);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, paramContext, new Object[0]);
    }
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3, long paramLong, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, new Object[] { "[reportGameEvent] gameId=", Integer.valueOf(paramInt3), ", eventId=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", failCode=", Long.valueOf(paramLong), ", extInfo=", paramJSONObject });
    }
    if (paramAppInterface == null)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[reportGameEvent] app null");
      return;
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.7.0");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("platform", 109);
      ((JSONObject)localObject).put("osVersion", Build.VERSION.RELEASE);
      ((JSONObject)localObject).put("brand", Build.BRAND);
      ((JSONObject)localObject).put("model", Build.MODEL);
      ((JSONObject)localObject).put("sqVersion", "8.7.0.5295");
      ((JSONObject)localObject).put("ts", NetConnInfoCenter.getServerTime());
      ((JSONObject)localObject).put("mid", paramInt1);
      ((JSONObject)localObject).put("value", paramInt2);
      ((JSONObject)localObject).put("gameId", paramInt3);
      ((JSONObject)localObject).put("failCode", paramLong);
      if (paramJSONObject != null) {
        ((JSONObject)localObject).put("extInfo", paramJSONObject);
      }
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramJSONObject = new NewIntent(paramAppInterface.getApp(), CmGameServlet.class);
      paramJSONObject.putExtra("cmd", "apollo_monit_report.game_report_single");
      paramJSONObject.putExtra("data", localUniSsoServerReq.toByteArray());
      paramJSONObject.setObserver(new CmGameUtil.2());
      paramAppInterface.startServlet(paramJSONObject);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[reportGameEvent] failed, exception=", paramAppInterface);
    }
  }
  
  public static void a(String paramString)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[clearMainJsCache] mainJsPath=", paramString });
    if (!TextUtils.isEmpty(paramString)) {
      jdField_a_of_type_ComTencentUtilLRULinkedHashMap.remove(paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!a()) {
      return;
    }
    if ("apollo_aio_game.cancel_game_room".equals(paramString1))
    {
      CmGameSSoHandler localCmGameSSoHandler = a();
      if (localCmGameSSoHandler == null) {
        return;
      }
      localCmGameSSoHandler.a(paramString1, paramString2, -1L, 4, false, null);
    }
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
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(StartCheckParam paramStartCheckParam)
  {
    return (paramStartCheckParam != null) && (paramStartCheckParam.gameId == 4698);
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 252	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc_w 577
    //   12: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_2
    //   17: aload_0
    //   18: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: ldc_w 579
    //   26: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_2
    //   31: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore_2
    //   35: new 252	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   42: astore_3
    //   43: aload_3
    //   44: ldc_w 577
    //   47: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_3
    //   52: aload_0
    //   53: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: ldc_w 581
    //   61: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_3
    //   66: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore_3
    //   70: new 252	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   77: astore 4
    //   79: aload 4
    //   81: ldc_w 577
    //   84: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 4
    //   90: aload_0
    //   91: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 4
    //   97: ldc_w 583
    //   100: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 4
    //   106: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore 4
    //   111: new 585	java/io/File
    //   114: dup
    //   115: aload_2
    //   116: invokespecial 587	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: astore_0
    //   120: new 585	java/io/File
    //   123: dup
    //   124: aload_3
    //   125: invokespecial 587	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore_2
    //   129: new 585	java/io/File
    //   132: dup
    //   133: aload 4
    //   135: invokespecial 587	java/io/File:<init>	(Ljava/lang/String;)V
    //   138: astore_3
    //   139: aload_3
    //   140: invokevirtual 590	java/io/File:exists	()Z
    //   143: ifeq +8 -> 151
    //   146: aload_3
    //   147: invokevirtual 593	java/io/File:delete	()Z
    //   150: pop
    //   151: aload_3
    //   152: invokevirtual 596	java/io/File:createNewFile	()Z
    //   155: pop
    //   156: aload_0
    //   157: invokevirtual 590	java/io/File:exists	()Z
    //   160: ifeq +153 -> 313
    //   163: aload_0
    //   164: invokevirtual 599	java/io/File:isFile	()Z
    //   167: ifeq +146 -> 313
    //   170: aload_2
    //   171: invokevirtual 590	java/io/File:exists	()Z
    //   174: ifeq +139 -> 313
    //   177: aload_2
    //   178: invokevirtual 599	java/io/File:isFile	()Z
    //   181: ifeq +132 -> 313
    //   184: aload_0
    //   185: invokevirtual 602	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   188: aload_2
    //   189: invokevirtual 602	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   192: aload_3
    //   193: invokevirtual 602	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   196: invokestatic 607	com/tencent/open/base/BspatchUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   199: ifeq +114 -> 313
    //   202: aload_2
    //   203: invokevirtual 593	java/io/File:delete	()Z
    //   206: pop
    //   207: aload_0
    //   208: invokevirtual 593	java/io/File:delete	()Z
    //   211: pop
    //   212: aload_3
    //   213: aload_0
    //   214: invokevirtual 611	java/io/File:renameTo	(Ljava/io/File;)Z
    //   217: pop
    //   218: aload_0
    //   219: invokestatic 616	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   222: astore 4
    //   224: aload 4
    //   226: ifnull +52 -> 278
    //   229: aload 4
    //   231: aload_1
    //   232: invokevirtual 531	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   235: ifne +43 -> 278
    //   238: ldc 137
    //   240: iconst_1
    //   241: ldc_w 618
    //   244: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_0
    //   248: invokevirtual 593	java/io/File:delete	()Z
    //   251: pop
    //   252: aload_3
    //   253: invokevirtual 590	java/io/File:exists	()Z
    //   256: ifeq +8 -> 264
    //   259: aload_3
    //   260: invokevirtual 593	java/io/File:delete	()Z
    //   263: pop
    //   264: aload_2
    //   265: invokevirtual 590	java/io/File:exists	()Z
    //   268: ifeq +8 -> 276
    //   271: aload_2
    //   272: invokevirtual 593	java/io/File:delete	()Z
    //   275: pop
    //   276: iconst_0
    //   277: ireturn
    //   278: ldc 137
    //   280: iconst_1
    //   281: ldc_w 620
    //   284: invokestatic 286	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload_3
    //   288: invokevirtual 590	java/io/File:exists	()Z
    //   291: ifeq +8 -> 299
    //   294: aload_3
    //   295: invokevirtual 593	java/io/File:delete	()Z
    //   298: pop
    //   299: aload_2
    //   300: invokevirtual 590	java/io/File:exists	()Z
    //   303: ifeq +8 -> 311
    //   306: aload_2
    //   307: invokevirtual 593	java/io/File:delete	()Z
    //   310: pop
    //   311: iconst_1
    //   312: ireturn
    //   313: ldc 137
    //   315: iconst_1
    //   316: ldc_w 622
    //   319: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: aload_0
    //   323: invokevirtual 590	java/io/File:exists	()Z
    //   326: ifeq +8 -> 334
    //   329: aload_0
    //   330: invokevirtual 593	java/io/File:delete	()Z
    //   333: pop
    //   334: aload_3
    //   335: invokevirtual 590	java/io/File:exists	()Z
    //   338: ifeq +8 -> 346
    //   341: aload_3
    //   342: invokevirtual 593	java/io/File:delete	()Z
    //   345: pop
    //   346: aload_2
    //   347: invokevirtual 590	java/io/File:exists	()Z
    //   350: ifeq +8 -> 358
    //   353: aload_2
    //   354: invokevirtual 593	java/io/File:delete	()Z
    //   357: pop
    //   358: iconst_0
    //   359: ireturn
    //   360: astore_0
    //   361: goto +52 -> 413
    //   364: astore_1
    //   365: ldc 137
    //   367: iconst_1
    //   368: ldc_w 624
    //   371: aload_1
    //   372: invokestatic 517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   375: aload_0
    //   376: invokevirtual 590	java/io/File:exists	()Z
    //   379: ifeq +8 -> 387
    //   382: aload_0
    //   383: invokevirtual 593	java/io/File:delete	()Z
    //   386: pop
    //   387: aload_3
    //   388: invokevirtual 590	java/io/File:exists	()Z
    //   391: ifeq +8 -> 399
    //   394: aload_3
    //   395: invokevirtual 593	java/io/File:delete	()Z
    //   398: pop
    //   399: aload_2
    //   400: invokevirtual 590	java/io/File:exists	()Z
    //   403: ifeq +8 -> 411
    //   406: aload_2
    //   407: invokevirtual 593	java/io/File:delete	()Z
    //   410: pop
    //   411: iconst_0
    //   412: ireturn
    //   413: aload_3
    //   414: invokevirtual 590	java/io/File:exists	()Z
    //   417: ifeq +8 -> 425
    //   420: aload_3
    //   421: invokevirtual 593	java/io/File:delete	()Z
    //   424: pop
    //   425: aload_2
    //   426: invokevirtual 590	java/io/File:exists	()Z
    //   429: ifeq +8 -> 437
    //   432: aload_2
    //   433: invokevirtual 593	java/io/File:delete	()Z
    //   436: pop
    //   437: aload_0
    //   438: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	paramString1	String
    //   0	439	1	paramString2	String
    //   7	426	2	localObject1	Object
    //   42	379	3	localObject2	Object
    //   77	153	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   139	151	360	finally
    //   151	224	360	finally
    //   229	252	360	finally
    //   278	287	360	finally
    //   313	334	360	finally
    //   365	387	360	finally
    //   139	151	364	java/lang/Exception
    //   151	224	364	java/lang/Exception
    //   229	252	364	java/lang/Exception
    //   278	287	364	java/lang/Exception
    //   313	334	364	java/lang/Exception
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("cmgame_process.CmGameUtil", 1, "encrypt, no key");
      return paramArrayOfByte;
    }
    paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(1, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static int b()
  {
    if (jdField_a_of_type_Int < 0) {
      jdField_a_of_type_Int = DeviceInfoUtil.b();
    }
    if (jdField_a_of_type_Float < 0.0F) {
      jdField_a_of_type_Float = (float)DeviceInfoUtil.b() / 1.0F / 1024.0F;
    }
    if (jdField_b_of_type_Long < 0L)
    {
      double d = DeviceInfoUtil.a();
      Double.isNaN(d);
      jdField_b_of_type_Long = Math.ceil(d / 1073741824.0D);
    }
    boolean bool = QLog.isColorLevel();
    int j = 3;
    if (bool) {
      QLog.d("cmgame_process.CmGameUtil", 2, new Object[] { "[mobile_performance],cpuCoreNumber:", Integer.valueOf(jdField_a_of_type_Int), ",cpuFrequency:", Float.valueOf(jdField_a_of_type_Float), ",totalMemory:", Long.valueOf(jdField_b_of_type_Long) });
    }
    int i;
    if ((jdField_b_of_type_Long >= 4.0D) && (jdField_a_of_type_Int >= 4) && (jdField_a_of_type_Float > 1.5D))
    {
      i = 1;
    }
    else
    {
      long l = jdField_b_of_type_Long;
      i = j;
      if (l >= 3.0D)
      {
        i = j;
        if (l <= 4.0D)
        {
          i = j;
          if (jdField_a_of_type_Int >= 4)
          {
            if (l < 4.0D)
            {
              i = j;
              if (jdField_a_of_type_Float <= 1.5D) {
                break label243;
              }
            }
            else
            {
              i = j;
              if (l != 4.0D) {
                break label243;
              }
            }
            i = 2;
          }
        }
      }
    }
    label243:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[mobile_performance],level:");
    localStringBuilder.append(i);
    QLog.i("cmgame_process.CmGameUtil", 1, localStringBuilder.toString());
    return i;
  }
  
  public static int b(int paramInt)
  {
    try
    {
      Object localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("gameConfig.json");
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists())
      {
        QLog.w("cmgame_process.CmGameUtil", 1, "[getGameRscType], gameConfig.json NOT exist.");
        return 0;
      }
      localObject = new JSONObject(FileUtils.readFileToString((File)localObject)).optJSONArray("subpackages");
      if (localObject != null)
      {
        paramInt = ((JSONArray)localObject).length();
        if (paramInt > 0) {
          return 1;
        }
      }
      return 0;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
    }
    return 0;
  }
  
  public static CmGameLauncher b(int paramInt1, int paramInt2)
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.b(paramInt1, paramInt2);
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
    boolean bool1;
    int i;
    boolean bool2;
    try
    {
      int[] arrayOfInt = ApolloResDownloaderImpl.DEFAULT_DRESSIDS_ROLE0;
      j = 0;
      localJSONObject1 = ApolloGameBasicEventUtil.a(0, arrayOfInt);
      if (localJSONObject1 == null)
      {
        QLog.e("cmgame_process.CmGameUtil", 1, "json is null");
        return "{}";
      }
      localJSONObject1.put("roomId", String.valueOf(paramCmGameInitParams.mRoomId));
      localJSONObject1.put("svrIp", paramCmGameInitParams.mServerIp);
      localJSONObject1.put("port", paramCmGameInitParams.mPort);
      localJSONObject1.put("spriteDesignHeight", 368);
      bool1 = "1".equals(paramCmGameInitParams.mGameName);
      if (!bool1)
      {
        bool1 = "2".equals(paramCmGameInitParams.mGameName);
        if (!bool1) {
          try
          {
            localJSONObject1.put("gameId", Integer.parseInt(paramCmGameInitParams.mGameName));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      localJSONObject1.put("gameId", paramCmGameInitParams.mGameName);
      bool1 = ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
      if ((bool1) && (ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo != null))
      {
        localJSONObject1.put("freeMemory", ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo.jdField_b_of_type_Long);
        localJSONObject1.put("totalMemory", ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo.jdField_c_of_type_Long);
        localJSONObject1.put("osVersion", ApolloGameStateMachine.HardwareInfo.jdField_a_of_type_JavaLangString);
        localJSONObject1.put("model", ApolloGameStateMachine.HardwareInfo.jdField_b_of_type_JavaLangString);
        localJSONObject1.put("cpuType", ApolloGameStateMachine.HardwareInfo.jdField_c_of_type_JavaLangString);
        localJSONObject1.put("cpuNumber", ApolloGameStateMachine.HardwareInfo.jdField_a_of_type_Int);
        localJSONObject1.put("cpuFrequency", ApolloGameStateMachine.HardwareInfo.jdField_a_of_type_Long);
      }
      else
      {
        localJSONObject1.put("freeMemory", DeviceInfoUtil.a(Process.myPid()));
        localJSONObject1.put("totalMemory", DeviceInfoUtil.f());
        localJSONObject1.put("osVersion", DeviceInfoUtil.e());
        localJSONObject1.put("model", DeviceInfoUtil.i());
        localJSONObject1.put("cpuType", DeviceInfoUtil.g());
        localJSONObject1.put("cpuNumber", DeviceInfoUtil.b());
        localJSONObject1.put("cpuFrequency", DeviceInfoUtil.b());
      }
      localJSONObject1.put("gameVersion", paramCmGameInitParams.mVersion);
      localJSONObject1.put("QQVer", "8.7.0.5295");
      localJSONObject1.put("platform", "android");
      localJSONObject1.put("gameMode", paramCmGameInitParams.mGameMode);
      if (!TextUtils.isEmpty(paramCmGameInitParams.openId)) {
        localJSONObject1.put("openId", paramCmGameInitParams.openId);
      }
      if (!TextUtils.isEmpty(paramCmGameInitParams.mRobotOpenId)) {
        localJSONObject1.put("robotOpenId", paramCmGameInitParams.mRobotOpenId);
      }
      Object localObject3 = paramCmGameInitParams.mGameParam;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        bool1 = ((String)localObject3).contains("extendInfo");
        Object localObject1 = localObject3;
        if (bool1) {
          try
          {
            JSONObject localJSONObject2 = new JSONObject((String)localObject3);
            localObject1 = localObject3;
            if (localJSONObject2.has("extendInfo")) {
              localObject1 = localJSONObject2.optString("extendInfo");
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
            localObject2 = localObject3;
          }
        }
        localJSONObject1.put("gameParam", localObject2);
      }
      if (!paramCmGameInitParams.isWhiteUsr) {
        break label1260;
      }
      i = 1;
      localJSONObject1.put("isWhiteUser", i);
      localJSONObject1.put("src", paramCmGameInitParams.mSrc);
      localJSONObject1.put("networkType", 0);
      localJSONObject1.put("connType", NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext()));
      localJSONObject1.put("accessTokenCode", paramCmGameInitParams.accessTokenRet);
      localJSONObject1.put("accessToken", paramCmGameInitParams.accessToken);
      localJSONObject1.put("commFlagBits", paramCmGameInitParams.commFlag);
      localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 4);
      if (localObject2 == null) {
        break label1265;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("is_ever_play_cmgame");
      ((StringBuilder)localObject3).append(paramCmGameInitParams.mGameName);
      ((StringBuilder)localObject3).append(paramCmGameInitParams.mSelfUin);
      boolean bool3 = ((SharedPreferences)localObject2).getBoolean(((StringBuilder)localObject3).toString(), false);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("is_first_install_cmgame");
      ((StringBuilder)localObject3).append(paramCmGameInitParams.mGameName);
      ((StringBuilder)localObject3).append(paramCmGameInitParams.mSelfUin);
      boolean bool4 = ((SharedPreferences)localObject2).getBoolean(((StringBuilder)localObject3).toString(), true);
      bool2 = bool4;
      bool1 = bool3;
      if (!bool4) {
        break label1270;
      }
      localObject2 = ((SharedPreferences)localObject2).edit();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("is_first_install_cmgame");
      ((StringBuilder)localObject3).append(paramCmGameInitParams.mGameName);
      ((StringBuilder)localObject3).append(paramCmGameInitParams.mSelfUin);
      ((SharedPreferences.Editor)localObject2).putBoolean(((StringBuilder)localObject3).toString(), false).commit();
      bool2 = bool4;
      bool1 = bool3;
    }
    catch (Exception paramCmGameInitParams)
    {
      int j;
      JSONObject localJSONObject1;
      Object localObject2;
      label873:
      QLog.e("cmgame_process.CmGameUtil", 2, paramCmGameInitParams.getMessage());
      return "{}";
    }
    localJSONObject1.put("isFirstPlay", i);
    if (bool2) {
      i = 1;
    }
    for (;;)
    {
      localJSONObject1.put("isFirstInstall", i);
      localJSONObject1.put("sessionId", String.valueOf(new Random(System.currentTimeMillis()).nextInt(100000)));
      if ((paramCmGameInitParams.mGameMode != 1) && (paramCmGameInitParams.mGameMode != 2))
      {
        localJSONObject1.put("aioType", paramCmGameInitParams.mSessionType);
        i = j;
        if (paramCmGameInitParams.mIsMaster) {
          i = 1;
        }
        localJSONObject1.put("isMaster", i);
      }
      else
      {
        localJSONObject1.put("aioType", 1);
        localJSONObject1.put("isMaster", 1);
      }
      if ((!TextUtils.isEmpty(paramCmGameInitParams.mExtraStr)) && (("1".equals(paramCmGameInitParams.mGameName)) || ("2".equals(paramCmGameInitParams.mGameName)))) {
        localJSONObject1.put("extraStr", paramCmGameInitParams.mExtraStr);
      }
      localJSONObject1.put("sex", paramCmGameInitParams.gender);
      localJSONObject1.put("apolloStatus", paramCmGameInitParams.apolloStatus);
      localJSONObject1.put("gameType", paramCmGameInitParams.gameType);
      localJSONObject1.put("redUrl", paramCmGameInitParams.redUrl);
      if (paramCmGameInitParams.adForbidPosId != null) {
        localJSONObject1.put("adForbitPosId", paramCmGameInitParams.adForbidPosId);
      }
      localJSONObject1.put("transInfo", paramCmGameInitParams.transInfo);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("gameId:");
      ((StringBuilder)localObject2).append(paramCmGameInitParams.mGameName);
      ((StringBuilder)localObject2).append(",gameMode:");
      ((StringBuilder)localObject2).append(paramCmGameInitParams.mGameMode);
      ((StringBuilder)localObject2).append(",src:");
      ((StringBuilder)localObject2).append(paramCmGameInitParams.mSrc);
      ((StringBuilder)localObject2).append(",roomId:");
      ((StringBuilder)localObject2).append(paramCmGameInitParams.mRoomId);
      QLog.i("cmgame_process.CmGameUtil", 1, ((StringBuilder)localObject2).toString());
      paramCmGameInitParams = localJSONObject1.toString();
      return paramCmGameInitParams;
      label1260:
      i = 0;
      break;
      label1265:
      bool2 = false;
      bool1 = true;
      label1270:
      if (bool1)
      {
        i = 0;
        break label873;
      }
      i = 1;
      break label873;
      i = 0;
    }
  }
  
  public static void b(int paramInt)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[clearMainJsCache] gameId=", Integer.valueOf(paramInt) });
    a(ApolloUtilImpl.getApolloGameLuaPath(paramInt));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[putMainJsToCache] sEnableMainJsCache=", Boolean.valueOf(jdField_a_of_type_Boolean), ", mainJsPath=", paramString1 });
    if ((jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramString1, paramString2);
    }
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    try
    {
      AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
      boolean bool1 = bool2;
      if (localAudioManager != null)
      {
        int i = localAudioManager.getRingerMode();
        bool1 = bool2;
        if (i == 1) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isRingerVibrate error: ");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.i("cmgame_process.CmGameUtil", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("cmgame_process.CmGameUtil", 1, "decrypt, no key");
      return paramArrayOfByte;
    }
    paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    localCipher.init(2, paramString);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static boolean c()
  {
    boolean bool2 = false;
    try
    {
      AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
      boolean bool1 = bool2;
      if (localAudioManager != null)
      {
        int i = localAudioManager.getStreamVolume(2);
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isRingEqualsZero error: ");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.i("cmgame_process.CmGameUtil", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean d()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)BaseApplicationImpl.getApplication().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.CmGameUtil
 * JD-Core Version:    0.7.0.1
 */