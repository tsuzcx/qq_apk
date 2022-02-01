package com.tencent.mobileqq.apollo.game.process;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
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
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.HardwareInfo;
import com.tencent.mobileqq.apollo.game.ApolloGameTool;
import com.tencent.mobileqq.apollo.game.CmGameServlet;
import com.tencent.mobileqq.apollo.game.process.data.CmGameAppInterface;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.game.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.game.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResHelperImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.util.QQDeviceInfo;
import cooperation.qzone.util.NetworkState;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class CmGameUtil
{
  public static long a = 0L;
  public static boolean b = true;
  static int c = -1;
  static float d = -1.0F;
  static long e = -1L;
  private static LRULinkedHashMap<String, String> f = new LRULinkedHashMap(3);
  
  public static CmGameLauncher a(int paramInt)
  {
    CmGameManager localCmGameManager = c();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.a(paramInt);
  }
  
  public static CmGameLauncher a(int paramInt1, int paramInt2)
  {
    CmGameManager localCmGameManager = c();
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
  
  public static String a(CmGameInitParams paramCmGameInitParams)
  {
    if (paramCmGameInitParams == null) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = ApolloGameBasicEventUtil.a(0, ApolloResHelperImpl.DEFAULT_DRESSIDS_ROLE0);
      if (localJSONObject == null)
      {
        QLog.e("cmgame_process.CmGameUtil", 1, "json is null");
        return "{}";
      }
      localJSONObject.put("roomId", String.valueOf(paramCmGameInitParams.mRoomId));
      localJSONObject.put("svrIp", paramCmGameInitParams.mServerIp);
      localJSONObject.put("port", paramCmGameInitParams.mPort);
      localJSONObject.put("spriteDesignHeight", 368);
      localJSONObject.put("gameId", paramCmGameInitParams.mGameId);
      boolean bool = ApolloGameStateMachine.b.getAndSet(false);
      if ((bool) && (ApolloGameStateMachine.a != null))
      {
        localJSONObject.put("freeMemory", ApolloGameStateMachine.a.f);
        localJSONObject.put("totalMemory", ApolloGameStateMachine.a.g);
        localJSONObject.put("osVersion", ApolloGameStateMachine.HardwareInfo.a);
        localJSONObject.put("model", ApolloGameStateMachine.HardwareInfo.b);
        localJSONObject.put("cpuType", ApolloGameStateMachine.HardwareInfo.c);
        localJSONObject.put("cpuNumber", ApolloGameStateMachine.HardwareInfo.d);
        localJSONObject.put("cpuFrequency", ApolloGameStateMachine.HardwareInfo.e);
      }
      else
      {
        localJSONObject.put("freeMemory", DeviceInfoUtil.a(Process.myPid()));
        localJSONObject.put("totalMemory", DeviceInfoUtil.s());
        localJSONObject.put("osVersion", DeviceInfoUtil.g());
        localJSONObject.put("model", DeviceInfoUtil.u());
        localJSONObject.put("cpuType", DeviceInfoUtil.m());
        localJSONObject.put("cpuNumber", DeviceInfoUtil.h());
        localJSONObject.put("cpuFrequency", DeviceInfoUtil.k());
      }
      localJSONObject.put("gameVersion", paramCmGameInitParams.mVersion);
      localJSONObject.put("QQVer", "8.8.17.5770");
      localJSONObject.put("platform", "android");
      localJSONObject.put("gameMode", paramCmGameInitParams.mGameMode);
      Object localObject = paramCmGameInitParams.mGameParam;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localJSONObject.put("gameParam", localObject);
      }
      localJSONObject.put("src", paramCmGameInitParams.mSrc);
      localJSONObject.put("networkType", 0);
      localJSONObject.put("connType", NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext()));
      localJSONObject.put("accessTokenCode", paramCmGameInitParams.accessTokenRet);
      localJSONObject.put("accessToken", paramCmGameInitParams.accessToken);
      localJSONObject.put("commFlagBits", paramCmGameInitParams.commFlag);
      localJSONObject.put("sessionId", String.valueOf(new Random(System.currentTimeMillis()).nextInt(100000)));
      if (paramCmGameInitParams.mGameMode == 1)
      {
        localJSONObject.put("aioType", 1);
        localJSONObject.put("isMaster", 1);
      }
      localJSONObject.put("sex", paramCmGameInitParams.gender);
      localJSONObject.put("apolloStatus", paramCmGameInitParams.apolloStatus);
      localJSONObject.put("gameType", paramCmGameInitParams.gameType);
      localJSONObject.put("redUrl", paramCmGameInitParams.redUrl);
      localJSONObject.put("transInfo", paramCmGameInitParams.transInfo);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gameId:");
      ((StringBuilder)localObject).append(paramCmGameInitParams.mGameName);
      ((StringBuilder)localObject).append(",gameMode:");
      ((StringBuilder)localObject).append(paramCmGameInitParams.mGameMode);
      ((StringBuilder)localObject).append(",src:");
      ((StringBuilder)localObject).append(paramCmGameInitParams.mSrc);
      ((StringBuilder)localObject).append(",roomId:");
      ((StringBuilder)localObject).append(paramCmGameInitParams.mRoomId);
      QLog.i("cmgame_process.CmGameUtil", 1, ((StringBuilder)localObject).toString());
      paramCmGameInitParams = localJSONObject.toString();
      return paramCmGameInitParams;
    }
    catch (Exception paramCmGameInitParams)
    {
      QLog.e("cmgame_process.CmGameUtil", 2, paramCmGameInitParams.getMessage());
    }
    return "{}";
  }
  
  public static String a(String paramString)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[getMainJsFromCache] sEnableMainJsCache=", Boolean.valueOf(b), ", mainJsPath=", paramString });
    if ((b) && (!TextUtils.isEmpty(paramString))) {
      return (String)f.get(paramString);
    }
    return null;
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
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.8.17");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("platform", 109);
      ((JSONObject)localObject).put("osVersion", Build.VERSION.RELEASE);
      ((JSONObject)localObject).put("brand", Build.BRAND);
      ((JSONObject)localObject).put("model", Build.MODEL);
      ((JSONObject)localObject).put("sqVersion", "8.8.17.5770");
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
      paramJSONObject.setObserver(new CmGameUtil.1());
      paramAppInterface.startServlet(paramJSONObject);
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[reportGameEvent] failed, exception=", paramAppInterface);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[putMainJsToCache] sEnableMainJsCache=", Boolean.valueOf(b), ", mainJsPath=", paramString1 });
    if ((b) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      f.put(paramString1, paramString2);
    }
  }
  
  public static boolean a()
  {
    AppInterface localAppInterface = b();
    return (localAppInterface != null) && ((localAppInterface instanceof CmGameAppInterface));
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
  
  public static AppInterface b()
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
  
  public static CmGameLauncher b(int paramInt1, int paramInt2)
  {
    CmGameManager localCmGameManager = c();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.b(paramInt1, paramInt2);
  }
  
  public static CmGameLauncher b(long paramLong)
  {
    CmGameManager localCmGameManager = c();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.a(paramLong);
  }
  
  public static void b(String paramString)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[clearMainJsCache] mainJsPath=", paramString });
    if (!TextUtils.isEmpty(paramString)) {
      f.remove(paramString);
    }
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == 1000;
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
  
  public static int c(long paramLong)
  {
    CmGameLauncher localCmGameLauncher = b(paramLong);
    if (localCmGameLauncher == null) {
      return -1;
    }
    return localCmGameLauncher.g();
  }
  
  public static CmGameManager c()
  {
    AppInterface localAppInterface = b();
    if ((localAppInterface instanceof CmGameAppInterface)) {
      return (CmGameManager)((CmGameAppInterface)localAppInterface).getManager(CmGameAppInterface.a);
    }
    return null;
  }
  
  public static void c(int paramInt)
  {
    QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[clearMainJsCache] gameId=", Integer.valueOf(paramInt) });
    b(ApolloGameTool.a(paramInt));
  }
  
  public static CmGameSSoHandler d()
  {
    try
    {
      Object localObject = b();
      if (localObject != null)
      {
        if (!(localObject instanceof CmGameAppInterface)) {
          return null;
        }
        localObject = (CmGameSSoHandler)((AppInterface)localObject).getBusinessHandler(CmGameAppInterface.c);
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
  
  public static boolean e()
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
  
  public static boolean f()
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
  
  public static boolean g()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)BaseApplicationImpl.getApplication().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
  
  public static final int h()
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
  
  public static void i()
  {
    if (a(BaseApplicationImpl.getContext())) {
      return;
    }
    AppInterface localAppInterface = b();
    if (localAppInterface != null)
    {
      if (TextUtils.isEmpty(localAppInterface.getAccount())) {
        return;
      }
      QLog.d("cmgame_process.CmGameUtil", 1, "onGameCrashed");
    }
  }
  
  public static int j()
  {
    if (c < 0) {
      c = DeviceInfoUtil.h();
    }
    if (d < 0.0F) {
      d = (float)DeviceInfoUtil.k() / 1.0F / 1024.0F;
    }
    if (e < 0L)
    {
      double d1 = DeviceInfoUtil.a();
      Double.isNaN(d1);
      e = Math.ceil(d1 / 1073741824.0D);
    }
    boolean bool = QLog.isColorLevel();
    int j = 3;
    if (bool) {
      QLog.d("cmgame_process.CmGameUtil", 2, new Object[] { "[mobile_performance],cpuCoreNumber:", Integer.valueOf(c), ",cpuFrequency:", Float.valueOf(d), ",totalMemory:", Long.valueOf(e) });
    }
    int i;
    if ((e >= 4.0D) && (c >= 4) && (d > 1.5D))
    {
      i = 1;
    }
    else
    {
      long l = e;
      i = j;
      if (l >= 3.0D)
      {
        i = j;
        if (l <= 4.0D)
        {
          i = j;
          if (c >= 4)
          {
            if (l < 4.0D)
            {
              i = j;
              if (d <= 1.5D) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.CmGameUtil
 * JD-Core Version:    0.7.0.1
 */