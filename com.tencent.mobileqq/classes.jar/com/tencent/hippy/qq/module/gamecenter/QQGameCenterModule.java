package com.tencent.hippy.qq.module.gamecenter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.module.QQBaseWebIpcModule;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.update.HippyUpdateManager.TabFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.gamecenter.data.GameQQPlayerUtil;
import com.tencent.mobileqq.gamecenter.message.GameMsgAppFragment;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

@HippyNativeModule(init=true, name="QQGameCenterModule")
public class QQGameCenterModule
  extends QQBaseWebIpcModule
{
  static final String CLASSNAME = "QQGameCenterModule";
  static final String GAME_CENTER_EVENT_MSG_CHANGE = "QQGameCenter_sessionChanged";
  static final String GAME_CENTER_EVENT_MSG_UNREAD_CNT = "QQGameCenter_newMsgCountChanged";
  boolean mIsInMainProcess;
  private BroadcastReceiver mMsgReceiver;
  Bundle mReqBundle;
  
  public QQGameCenterModule(HippyEngineContext paramHippyEngineContext) {}
  
  private void clickCommonSessionByIpc(HippyMap paramHippyMap, Promise paramPromise)
  {
    int i = saveCallback(paramPromise);
    this.mReqBundle.clear();
    paramPromise = this.mReqBundle;
    if (paramHippyMap.containsKey("sessionId")) {}
    for (paramHippyMap = paramHippyMap.getString("sessionId");; paramHippyMap = "")
    {
      paramPromise.putString("sessionId", paramHippyMap);
      super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_open_aio", String.valueOf(i), this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
  }
  
  private void clickCommonSessionInMainProcess(HippyMap paramHippyMap, Promise paramPromise)
  {
    AppInterface localAppInterface = getAppInterface();
    if (!(localAppInterface instanceof QQAppInterface)) {}
    do
    {
      return;
      if (!paramHippyMap.containsKey("sessionId")) {
        break;
      }
      paramHippyMap = paramHippyMap.getString("sessionId");
      paramHippyMap = parseClickCommonSessionRsp(MessengerService.a((QQAppInterface)localAppInterface, paramHippyMap));
    } while (paramPromise == null);
    if (paramHippyMap == null) {}
    for (paramHippyMap = "";; paramHippyMap = paramHippyMap.toString())
    {
      paramPromise.resolve(paramHippyMap);
      return;
      paramHippyMap = "";
      break;
    }
  }
  
  private void getNewMsgCountByIpc(Promise paramPromise)
  {
    int i = saveCallback(paramPromise);
    this.mReqBundle.clear();
    super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_get_unread_total", String.valueOf(i), this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void getNewMsgCountInMainProcess(Promise paramPromise)
  {
    Object localObject = getAppInterface();
    if (!(localObject instanceof QQAppInterface)) {}
    do
    {
      return;
      localObject = parseGetNewMsgCountRsp(MessengerService.a((QQAppInterface)localObject));
    } while (paramPromise == null);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((JSONObject)localObject).toString())
    {
      paramPromise.resolve(localObject);
      return;
    }
  }
  
  private void getRequestDataByIpc(HippyMap paramHippyMap, Promise paramPromise)
  {
    int i = saveCallback(paramPromise);
    this.mReqBundle.clear();
    paramPromise = this.mReqBundle;
    if (paramHippyMap.containsKey("gameId")) {}
    for (paramHippyMap = paramHippyMap.getString("gameId");; paramHippyMap = "")
    {
      paramPromise.putString("gameId", paramHippyMap);
      super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_get_request_info", String.valueOf(i), this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
  }
  
  private void getRequestDataInMainProcess(HippyMap paramHippyMap, Promise paramPromise)
  {
    AppInterface localAppInterface = getAppInterface();
    if (!(localAppInterface instanceof QQAppInterface)) {}
    do
    {
      return;
      if (!paramHippyMap.containsKey("gameId")) {
        break;
      }
      paramHippyMap = paramHippyMap.getString("gameId");
      paramHippyMap = parseGetSessionRsp(MessengerService.b((QQAppInterface)localAppInterface, paramHippyMap));
    } while (paramPromise == null);
    if (paramHippyMap == null) {}
    for (paramHippyMap = "";; paramHippyMap = paramHippyMap.toString())
    {
      paramPromise.resolve(paramHippyMap);
      return;
      paramHippyMap = "";
      break;
    }
  }
  
  private void getSessionDataByIpc(HippyMap paramHippyMap, Promise paramPromise)
  {
    int i = saveCallback(paramPromise);
    this.mReqBundle.clear();
    this.mReqBundle.putInt("dataType", paramHippyMap.getInt("dataType"));
    super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_get_session_info", String.valueOf(i), this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void getSessionDataInMainProcess(HippyMap paramHippyMap, Promise paramPromise)
  {
    AppInterface localAppInterface = getAppInterface();
    if (!(localAppInterface instanceof QQAppInterface)) {}
    do
    {
      return;
      int i = paramHippyMap.getInt("dataType");
      paramHippyMap = parseGetSessionRsp(MessengerService.a((QQAppInterface)localAppInterface, i));
    } while (paramPromise == null);
    if (paramHippyMap == null) {}
    for (paramHippyMap = "";; paramHippyMap = paramHippyMap.toString())
    {
      paramPromise.resolve(paramHippyMap);
      return;
    }
  }
  
  private void openQQPlayerAioByIpc(HippyMap paramHippyMap, Promise paramPromise)
  {
    int j = saveCallback(paramPromise);
    this.mReqBundle.clear();
    Bundle localBundle = this.mReqBundle;
    label66:
    label96:
    label126:
    long l;
    if (paramHippyMap.containsKey("fromRoleId"))
    {
      paramPromise = paramHippyMap.getString("fromRoleId");
      localBundle.putString("fromRoleId", paramPromise);
      localBundle = this.mReqBundle;
      if (!paramHippyMap.containsKey("fromOpenId")) {
        break label374;
      }
      paramPromise = paramHippyMap.getString("fromOpenId");
      localBundle.putString("fromOpenId", paramPromise);
      localBundle = this.mReqBundle;
      if (!paramHippyMap.containsKey("toRoleId")) {
        break label380;
      }
      paramPromise = paramHippyMap.getString("toRoleId");
      localBundle.putString("toRoleId", paramPromise);
      localBundle = this.mReqBundle;
      if (!paramHippyMap.containsKey("toOpenId")) {
        break label386;
      }
      paramPromise = paramHippyMap.getString("toOpenId");
      localBundle.putString("toOpenId", paramPromise);
      localBundle = this.mReqBundle;
      if (!paramHippyMap.containsKey("fromTinyId")) {
        break label392;
      }
      paramPromise = paramHippyMap.getString("fromTinyId");
      label156:
      localBundle.putString("fromTinyId", paramPromise);
      localBundle = this.mReqBundle;
      if (!paramHippyMap.containsKey("toTinyId")) {
        break label398;
      }
      paramPromise = paramHippyMap.getString("toTinyId");
      label186:
      localBundle.putString("toTinyId", paramPromise);
      paramPromise = this.mReqBundle;
      if (!paramHippyMap.containsKey("gameAppId")) {
        break label404;
      }
      l = paramHippyMap.getLong("gameAppId");
      label216:
      paramPromise.putLong("gameAppId", l);
      paramPromise = this.mReqBundle;
      if (!paramHippyMap.containsKey("windowFlag")) {
        break label410;
      }
      i = paramHippyMap.getInt("windowFlag");
      label245:
      paramPromise.putInt("windowFlag", i);
      localBundle = this.mReqBundle;
      if (!paramHippyMap.containsKey("topGrayText")) {
        break label415;
      }
      paramPromise = paramHippyMap.getString("topGrayText");
      label274:
      localBundle.putString("topGrayText", paramPromise);
      localBundle = this.mReqBundle;
      if (!paramHippyMap.containsKey("sig")) {
        break label421;
      }
      paramPromise = paramHippyMap.getString("sig");
      label304:
      localBundle.putString("sig", paramPromise);
      paramPromise = this.mReqBundle;
      if (!paramHippyMap.containsKey("fromPage")) {
        break label427;
      }
    }
    label386:
    label392:
    label398:
    label404:
    label410:
    label415:
    label421:
    label427:
    for (int i = paramHippyMap.getInt("fromPage");; i = 0)
    {
      paramPromise.putInt("fromPage", i);
      super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_open_qqplayer_aio", String.valueOf(j), this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
      paramPromise = "";
      break;
      label374:
      paramPromise = "";
      break label66;
      label380:
      paramPromise = "";
      break label96;
      paramPromise = "";
      break label126;
      paramPromise = "";
      break label156;
      paramPromise = "";
      break label186;
      l = 0L;
      break label216;
      i = 0;
      break label245;
      paramPromise = "";
      break label274;
      paramPromise = "";
      break label304;
    }
  }
  
  private void openQQPlayerAioInMainProcess(HippyMap paramHippyMap, Promise paramPromise)
  {
    Object localObject = getAppInterface();
    if (!(localObject instanceof QQAppInterface)) {}
    String str1;
    label66:
    String str2;
    label83:
    String str3;
    label100:
    String str4;
    label117:
    String str5;
    label134:
    String str6;
    label151:
    String str7;
    label168:
    int i;
    label184:
    int j;
    label201:
    long l;
    label218:
    do
    {
      return;
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      Context localContext = localQQAppInterface.getApp().getApplicationContext();
      if (!paramHippyMap.containsKey("fromRoleId")) {
        break;
      }
      localObject = paramHippyMap.getString("fromRoleId");
      if (!paramHippyMap.containsKey("fromOpenId")) {
        break label293;
      }
      str1 = paramHippyMap.getString("fromOpenId");
      if (!paramHippyMap.containsKey("toRoleId")) {
        break label300;
      }
      str2 = paramHippyMap.getString("toRoleId");
      if (!paramHippyMap.containsKey("toOpenId")) {
        break label307;
      }
      str3 = paramHippyMap.getString("toOpenId");
      if (!paramHippyMap.containsKey("fromTinyId")) {
        break label314;
      }
      str4 = paramHippyMap.getString("fromTinyId");
      if (!paramHippyMap.containsKey("toTinyId")) {
        break label321;
      }
      str5 = paramHippyMap.getString("toTinyId");
      if (!paramHippyMap.containsKey("topGrayText")) {
        break label328;
      }
      str6 = paramHippyMap.getString("topGrayText");
      if (!paramHippyMap.containsKey("sig")) {
        break label335;
      }
      str7 = paramHippyMap.getString("sig");
      if (!paramHippyMap.containsKey("windowFlag")) {
        break label342;
      }
      i = paramHippyMap.getInt("windowFlag");
      if (!paramHippyMap.containsKey("fromPage")) {
        break label347;
      }
      j = paramHippyMap.getInt("fromPage");
      if (!paramHippyMap.containsKey("gameAppId")) {
        break label353;
      }
      l = paramHippyMap.getLong("gameAppId");
      GameQQPlayerUtil.a(localQQAppInterface, localContext, (String)localObject, str1, str2, str3, str6, str7, l, str4, str5, i, j);
      paramHippyMap = new Bundle();
      paramHippyMap.putInt("result", 0);
      paramHippyMap = parseClickCommonSessionRsp(paramHippyMap);
    } while (paramPromise == null);
    if (paramHippyMap == null) {}
    for (paramHippyMap = "";; paramHippyMap = paramHippyMap.toString())
    {
      paramPromise.resolve(paramHippyMap);
      return;
      localObject = "";
      break;
      label293:
      str1 = "";
      break label66;
      label300:
      str2 = "";
      break label83;
      label307:
      str3 = "";
      break label100;
      label314:
      str4 = "";
      break label117;
      label321:
      str5 = "";
      break label134;
      label328:
      str6 = "";
      break label151;
      label335:
      str7 = "";
      break label168;
      label342:
      i = 0;
      break label184;
      label347:
      j = 0;
      break label201;
      label353:
      l = 0L;
      break label218;
    }
  }
  
  private void setSwitchByIpc(HippyMap paramHippyMap, Promise paramPromise)
  {
    int j = -1;
    int k = saveCallback(paramPromise);
    this.mReqBundle.clear();
    Bundle localBundle = this.mReqBundle;
    if (paramHippyMap.containsKey("gameId"))
    {
      paramPromise = paramHippyMap.getString("gameId");
      localBundle.putString("gameId", paramPromise);
      paramPromise = this.mReqBundle;
      if (!paramHippyMap.containsKey("switchType")) {
        break label140;
      }
    }
    label140:
    for (int i = paramHippyMap.getInt("switchType");; i = -1)
    {
      paramPromise.putInt("switchType", i);
      paramPromise = this.mReqBundle;
      i = j;
      if (paramHippyMap.containsKey("value")) {
        i = paramHippyMap.getInt("value");
      }
      paramPromise.putInt("value", i);
      super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_toggle_changed", String.valueOf(k), this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
      paramPromise = "";
      break;
    }
  }
  
  private void setSwitchInMainProcess(HippyMap paramHippyMap, Promise paramPromise)
  {
    int j = -1;
    AppInterface localAppInterface = getAppInterface();
    if (!(localAppInterface instanceof QQAppInterface)) {
      return;
    }
    String str;
    if (paramHippyMap.containsKey("gameId"))
    {
      str = paramHippyMap.getString("gameId");
      if (!paramHippyMap.containsKey("switchType")) {
        break label98;
      }
    }
    label98:
    for (int i = paramHippyMap.getInt("switchType");; i = -1)
    {
      if (paramHippyMap.containsKey("value")) {
        j = paramHippyMap.getInt("value");
      }
      MessengerService.a((QQAppInterface)localAppInterface, str, i, j);
      callback(paramPromise, 0, "");
      return;
      str = "";
      break;
    }
  }
  
  void callback(Promise paramPromise, int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramInt);
      localJSONObject.put("ret", paramInt);
      localJSONObject.put("msg", paramString);
      if (paramPromise != null) {
        paramPromise.resolve(localJSONObject.toString());
      }
      return;
    }
    catch (Exception paramPromise)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQGameCenterModule", 2, paramPromise.getMessage());
    }
  }
  
  void callback(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramInt);
      localJSONObject.put("ret", paramInt);
      localJSONObject.put("msg", paramString2);
      callback(paramString1, localJSONObject.toString());
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQGameCenterModule", 2, paramString1.getMessage());
    }
  }
  
  void callback(String paramString1, String paramString2)
  {
    paramString1 = getCallback(paramString1);
    if (paramString1 != null) {
      paramString1.resolve(paramString2);
    }
  }
  
  @HippyMethod(name="clickCommonSession")
  public void clickCommonSession(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (this.mIsInMainProcess)
    {
      clickCommonSessionInMainProcess(paramHippyMap, paramPromise);
      return;
    }
    clickCommonSessionByIpc(paramHippyMap, paramPromise);
  }
  
  public void destroy()
  {
    if (this.mMsgReceiver != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.mMsgReceiver);
    }
    super.destroy();
  }
  
  @HippyMethod(name="getNewMsgCount")
  public void getNewMsgCount(Promise paramPromise)
  {
    if (this.mIsInMainProcess)
    {
      getNewMsgCountInMainProcess(paramPromise);
      return;
    }
    getNewMsgCountByIpc(paramPromise);
  }
  
  @HippyMethod(name="getPageUrl")
  public void getPageUrl(Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    Object localObject = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
    if (localObject != null)
    {
      if (((HippyQQEngine)localObject).getPageUrl() == null) {}
      for (localObject = "";; localObject = ((HippyQQEngine)localObject).getPageUrl())
      {
        paramPromise.resolve(localObject);
        return;
      }
    }
    paramPromise.reject("");
  }
  
  @HippyMethod(name="getRequestData")
  public void getRequestData(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (this.mIsInMainProcess)
    {
      getRequestDataInMainProcess(paramHippyMap, paramPromise);
      return;
    }
    getRequestDataByIpc(paramHippyMap, paramPromise);
  }
  
  @HippyMethod(name="getSessionData")
  public void getSessionData(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (this.mIsInMainProcess)
    {
      getSessionDataInMainProcess(paramHippyMap, paramPromise);
      return;
    }
    getSessionDataByIpc(paramHippyMap, paramPromise);
  }
  
  @HippyMethod(name="onBackButtonClick")
  public void onBackButtonClick()
  {
    Fragment localFragment = super.getFragment();
    if ((localFragment instanceof GameMsgAppFragment)) {
      ((GameMsgAppFragment)localFragment).a();
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    super.onResponse(paramBundle);
    if (paramBundle == null) {}
    String str2;
    String str1;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          str2 = paramBundle.getString("cmd");
          i = paramBundle.getInt("respkey", 0);
          if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterModule", 1, "[onResponse] cmd:" + str2 + " respkey:" + i + "，key:" + this.mOnRemoteResp.key);
          }
        } while (i != this.mOnRemoteResp.key);
        str1 = paramBundle.getString("callbackid");
        paramBundle = paramBundle.getBundle("response");
      } while ((TextUtils.isEmpty(str2)) || (paramBundle == null));
      Activity localActivity = getActivity();
      if ((localActivity == null) || (localActivity.isFinishing()))
      {
        callback(str1, 1, "-1000");
        return;
      }
      for (;;)
      {
        try
        {
          if ((!"ipc_cmd_gamecenter_get_session_info".equals(str2)) && (!"ipc_cmd_gamecenter_get_request_info".equals(str2))) {
            break;
          }
          paramBundle = parseGetSessionRsp(paramBundle);
          if (paramBundle == null)
          {
            paramBundle = "";
            callback(str1, paramBundle);
            return;
          }
        }
        catch (Throwable paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQGameCenterModule", 2, paramBundle.getMessage());
          }
          callback(str1, 1, "-2000");
          return;
        }
        paramBundle = paramBundle.toString();
      }
      if ("ipc_cmd_gamecenter_open_aio".equals(str2))
      {
        paramBundle = parseClickCommonSessionRsp(paramBundle);
        if (paramBundle == null) {}
        for (paramBundle = "";; paramBundle = paramBundle.toString())
        {
          callback(str1, paramBundle);
          return;
        }
      }
      if ("ipc_cmd_gamecenter_get_unread_total".equals(str2))
      {
        paramBundle = parseGetNewMsgCountRsp(paramBundle);
        if (paramBundle == null) {}
        for (paramBundle = "";; paramBundle = paramBundle.toString())
        {
          callback(str1, paramBundle);
          return;
        }
      }
      if ("ipc_cmd_gamecenter_toggle_changed".equals(str2))
      {
        callback(str1, 0, "");
        return;
      }
    } while (!"ipc_cmd_gamecenter_open_qqplayer_aio".equals(str2));
    paramBundle = parseClickCommonSessionRsp(paramBundle);
    if (paramBundle == null) {}
    for (paramBundle = "";; paramBundle = paramBundle.toString())
    {
      callback(str1, paramBundle);
      return;
    }
  }
  
  @HippyMethod(name="openQQPlayerAio")
  public void openQQPlayerAio(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (this.mIsInMainProcess)
    {
      openQQPlayerAioInMainProcess(paramHippyMap, paramPromise);
      return;
    }
    openQQPlayerAioByIpc(paramHippyMap, paramPromise);
  }
  
  protected JSONObject parseClickCommonSessionRsp(Bundle paramBundle)
  {
    try
    {
      int i = paramBundle.getInt("result", -1);
      paramBundle = new JSONObject();
      QLog.d("QQGameCenterModule", 1, "parseClickCommonSessionRsp error:" + localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        paramBundle.put("ret", i);
        if (QLog.isColorLevel()) {
          QLog.d("QQGameCenterModule", 2, "parseClickCommonSessionRsp ret:" + i);
        }
        return paramBundle;
      }
      catch (Throwable localThrowable2)
      {
        break label62;
      }
      localThrowable1 = localThrowable1;
      paramBundle = null;
    }
    label62:
    return paramBundle;
  }
  
  /* Error */
  protected JSONObject parseGetNewMsgCountRsp(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 244
    //   3: invokevirtual 433	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   6: istore_2
    //   7: aload_1
    //   8: ldc_w 435
    //   11: invokevirtual 433	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   14: istore_3
    //   15: new 149	org/json/JSONObject
    //   18: dup
    //   19: invokespecial 262	org/json/JSONObject:<init>	()V
    //   22: astore_1
    //   23: aload_1
    //   24: ldc_w 268
    //   27: iload_2
    //   28: invokevirtual 266	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   31: pop
    //   32: aload_1
    //   33: ldc_w 437
    //   36: iload_3
    //   37: invokevirtual 266	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   40: pop
    //   41: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +29 -> 73
    //   47: ldc 12
    //   49: iconst_2
    //   50: new 368	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 439
    //   60: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload_1
    //   74: areturn
    //   75: astore 4
    //   77: aconst_null
    //   78: astore_1
    //   79: ldc 12
    //   81: iconst_1
    //   82: new 368	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 441
    //   92: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload 4
    //   97: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload_1
    //   107: areturn
    //   108: astore 4
    //   110: goto -31 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	QQGameCenterModule
    //   0	113	1	paramBundle	Bundle
    //   6	22	2	i	int
    //   14	23	3	j	int
    //   75	21	4	localThrowable1	Throwable
    //   108	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	23	75	java/lang/Throwable
    //   23	73	108	java/lang/Throwable
  }
  
  /* Error */
  protected JSONObject parseGetSessionRsp(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 244
    //   3: invokevirtual 433	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   6: istore_2
    //   7: aload_1
    //   8: ldc_w 443
    //   11: invokevirtual 361	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnonnull +58 -> 74
    //   19: ldc 125
    //   21: astore_1
    //   22: new 149	org/json/JSONObject
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 445	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: aload_1
    //   32: ldc_w 268
    //   35: iload_2
    //   36: invokevirtual 266	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   39: pop
    //   40: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +29 -> 72
    //   46: ldc 12
    //   48: iconst_2
    //   49: new 368	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 447
    //   59: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_3
    //   63: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_1
    //   73: areturn
    //   74: aload_3
    //   75: astore_1
    //   76: goto -54 -> 22
    //   79: astore_3
    //   80: aconst_null
    //   81: astore_1
    //   82: ldc 12
    //   84: iconst_1
    //   85: new 368	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 449
    //   95: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_3
    //   99: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload_1
    //   109: areturn
    //   110: astore_3
    //   111: goto -29 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	QQGameCenterModule
    //   0	114	1	paramBundle	Bundle
    //   6	30	2	i	int
    //   14	61	3	str	String
    //   79	20	3	localThrowable1	Throwable
    //   110	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	15	79	java/lang/Throwable
    //   22	31	79	java/lang/Throwable
    //   31	72	110	java/lang/Throwable
  }
  
  @HippyMethod(name="requestGameCenterTabConfig")
  public void requestGameCenterTabConfig(String paramString, Promise paramPromise)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = (HippyUpdateManager.TabFile)HippyUpdateManager.getInstance().getTabFilesConfig().get(paramString);
    if (paramString == null) {}
    for (paramString = "";; paramString = paramString.tabFileJson)
    {
      paramPromise.resolve(paramString);
      return;
    }
  }
  
  @HippyMethod(name="setSwitch")
  public void setSwitch(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (this.mIsInMainProcess)
    {
      setSwitchInMainProcess(paramHippyMap, paramPromise);
      return;
    }
    setSwitchByIpc(paramHippyMap, paramPromise);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.gamecenter.QQGameCenterModule
 * JD-Core Version:    0.7.0.1
 */