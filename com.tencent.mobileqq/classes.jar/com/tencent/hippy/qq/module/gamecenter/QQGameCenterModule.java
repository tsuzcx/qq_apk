package com.tencent.hippy.qq.module.gamecenter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.TabFile;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.module.QQBaseWebIpcModule;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi;
import com.tencent.mobileqq.gamecenter.message.GameMsgAppFragment;
import com.tencent.mobileqq.qroute.QRoute;
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
  public static final String TAG = "QQGameCenterModule";
  boolean mIsInMainProcess;
  private BroadcastReceiver mMsgReceiver;
  Bundle mReqBundle = new Bundle();
  
  public QQGameCenterModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext, bool1);
    boolean bool1 = bool2;
    if (BaseApplicationImpl.sProcessId == 1) {
      bool1 = true;
    }
    this.mIsInMainProcess = bool1;
    this.mMsgReceiver = new QQGameCenterModule.1(this);
    paramHippyEngineContext = new IntentFilter();
    paramHippyEngineContext.addAction("action_qgame_messgae_change");
    paramHippyEngineContext.addAction("action_qgame_unread_change");
    BaseApplicationImpl.getApplication().registerReceiver(this.mMsgReceiver, paramHippyEngineContext);
  }
  
  private void clickCommonSessionByIpc(HippyMap paramHippyMap, Promise paramPromise)
  {
    int i = saveCallback(paramPromise);
    this.mReqBundle.clear();
    paramPromise = this.mReqBundle;
    if (paramHippyMap.containsKey("sessionId")) {
      paramHippyMap = paramHippyMap.getString("sessionId");
    } else {
      paramHippyMap = "";
    }
    paramPromise.putString("sessionId", paramHippyMap);
    super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_open_aio", String.valueOf(i), this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void clickCommonSessionInMainProcess(HippyMap paramHippyMap, Promise paramPromise)
  {
    AppInterface localAppInterface = getAppInterface();
    if (!(localAppInterface instanceof QQAppInterface)) {
      return;
    }
    boolean bool = paramHippyMap.containsKey("sessionId");
    String str = "";
    if (bool) {
      paramHippyMap = paramHippyMap.getString("sessionId");
    } else {
      paramHippyMap = "";
    }
    paramHippyMap = parseClickCommonSessionRsp(MessengerService.a((QQAppInterface)localAppInterface, paramHippyMap));
    if (paramPromise != null)
    {
      if (paramHippyMap == null) {
        paramHippyMap = str;
      } else {
        paramHippyMap = paramHippyMap.toString();
      }
      paramPromise.resolve(paramHippyMap);
    }
  }
  
  private void delSessionByIpc(HippyMap paramHippyMap, Promise paramPromise)
  {
    int i = saveCallback(paramPromise);
    this.mReqBundle.clear();
    paramPromise = this.mReqBundle;
    if (paramHippyMap.containsKey("sessionList")) {
      paramHippyMap = paramHippyMap.getString("sessionList");
    } else {
      paramHippyMap = "";
    }
    paramPromise.putString("sessionList", paramHippyMap);
    super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_del_game_session", String.valueOf(i), this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void delSessionInMainProcess(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameCenterModule", 2, "[delSessionInMainProcess]");
    }
    paramPromise = getAppInterface();
    if (!(paramPromise instanceof QQAppInterface)) {
      return;
    }
    if (paramHippyMap.containsKey("sessionList")) {
      paramHippyMap = paramHippyMap.getString("sessionList");
    } else {
      paramHippyMap = "";
    }
    MessengerService.b((QQAppInterface)paramPromise, paramHippyMap);
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
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = parseGetNewMsgCountRsp(MessengerService.a((QQAppInterface)localObject));
    if (paramPromise != null)
    {
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((JSONObject)localObject).toString();
      }
      paramPromise.resolve(localObject);
    }
  }
  
  private void getRequestDataByIpc(HippyMap paramHippyMap, Promise paramPromise)
  {
    int i = saveCallback(paramPromise);
    if (paramHippyMap.containsKey("gameId")) {
      paramHippyMap = paramHippyMap.getString("gameId");
    } else {
      paramHippyMap = "";
    }
    this.mReqBundle.clear();
    this.mReqBundle.putString("gameId", paramHippyMap);
    super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_get_request_info", String.valueOf(i), this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void getRequestDataInMainProcess(HippyMap paramHippyMap, Promise paramPromise)
  {
    AppInterface localAppInterface = getAppInterface();
    if (!(localAppInterface instanceof QQAppInterface)) {
      return;
    }
    boolean bool = paramHippyMap.containsKey("gameId");
    String str = "";
    if (bool) {
      paramHippyMap = paramHippyMap.getString("gameId");
    } else {
      paramHippyMap = "";
    }
    paramHippyMap = parseGetSessionRsp(MessengerService.c((QQAppInterface)localAppInterface, paramHippyMap));
    if (paramPromise != null)
    {
      if (paramHippyMap == null) {
        paramHippyMap = str;
      } else {
        paramHippyMap = paramHippyMap.toString();
      }
      paramPromise.resolve(paramHippyMap);
    }
  }
  
  private void getSessionDataByIpc(HippyMap paramHippyMap, Promise paramPromise)
  {
    int i = saveCallback(paramPromise);
    this.mReqBundle.clear();
    if (paramHippyMap.containsKey("gameId")) {
      paramPromise = paramHippyMap.getString("gameId");
    } else {
      paramPromise = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getSessionDataByIpc], gameId:");
    localStringBuilder.append(paramPromise);
    QLog.i("QQGameCenterModule", 1, localStringBuilder.toString());
    this.mReqBundle.putInt("dataType", paramHippyMap.getInt("dataType"));
    this.mReqBundle.putString("gameId", paramPromise);
    super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_get_session_info", String.valueOf(i), this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void getSessionDataInMainProcess(HippyMap paramHippyMap, Promise paramPromise)
  {
    AppInterface localAppInterface = getAppInterface();
    if (!(localAppInterface instanceof QQAppInterface)) {
      return;
    }
    boolean bool = paramHippyMap.containsKey("gameId");
    String str2 = "";
    String str1;
    if (bool) {
      str1 = paramHippyMap.getString("gameId");
    } else {
      str1 = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getSessionDataInMainProcess], gameId:");
    localStringBuilder.append(str1);
    QLog.i("QQGameCenterModule", 1, localStringBuilder.toString());
    int i = paramHippyMap.getInt("dataType");
    paramHippyMap = parseGetSessionRsp(MessengerService.a((QQAppInterface)localAppInterface, i, str1));
    if (paramPromise != null)
    {
      if (paramHippyMap == null) {
        paramHippyMap = str2;
      } else {
        paramHippyMap = paramHippyMap.toString();
      }
      paramPromise.resolve(paramHippyMap);
    }
  }
  
  private void openQQPlayerAioByIpc(HippyMap paramHippyMap, Promise paramPromise)
  {
    int j = saveCallback(paramPromise);
    this.mReqBundle.clear();
    Bundle localBundle = this.mReqBundle;
    boolean bool = paramHippyMap.containsKey("fromRoleId");
    String str = "";
    if (bool) {
      paramPromise = paramHippyMap.getString("fromRoleId");
    } else {
      paramPromise = "";
    }
    localBundle.putString("fromRoleId", paramPromise);
    localBundle = this.mReqBundle;
    if (paramHippyMap.containsKey("fromOpenId")) {
      paramPromise = paramHippyMap.getString("fromOpenId");
    } else {
      paramPromise = "";
    }
    localBundle.putString("fromOpenId", paramPromise);
    localBundle = this.mReqBundle;
    if (paramHippyMap.containsKey("toRoleId")) {
      paramPromise = paramHippyMap.getString("toRoleId");
    } else {
      paramPromise = "";
    }
    localBundle.putString("toRoleId", paramPromise);
    localBundle = this.mReqBundle;
    if (paramHippyMap.containsKey("toOpenId")) {
      paramPromise = paramHippyMap.getString("toOpenId");
    } else {
      paramPromise = "";
    }
    localBundle.putString("toOpenId", paramPromise);
    localBundle = this.mReqBundle;
    if (paramHippyMap.containsKey("fromTinyId")) {
      paramPromise = paramHippyMap.getString("fromTinyId");
    } else {
      paramPromise = "";
    }
    localBundle.putString("fromTinyId", paramPromise);
    localBundle = this.mReqBundle;
    if (paramHippyMap.containsKey("toTinyId")) {
      paramPromise = paramHippyMap.getString("toTinyId");
    } else {
      paramPromise = "";
    }
    localBundle.putString("toTinyId", paramPromise);
    paramPromise = this.mReqBundle;
    long l;
    if (paramHippyMap.containsKey("gameAppId")) {
      l = paramHippyMap.getLong("gameAppId");
    } else {
      l = 0L;
    }
    paramPromise.putLong("gameAppId", l);
    paramPromise = this.mReqBundle;
    int i;
    if (paramHippyMap.containsKey("windowFlag")) {
      i = paramHippyMap.getInt("windowFlag");
    } else {
      i = 0;
    }
    paramPromise.putInt("windowFlag", i);
    localBundle = this.mReqBundle;
    if (paramHippyMap.containsKey("topGrayText")) {
      paramPromise = paramHippyMap.getString("topGrayText");
    } else {
      paramPromise = "";
    }
    localBundle.putString("topGrayText", paramPromise);
    localBundle = this.mReqBundle;
    paramPromise = str;
    if (paramHippyMap.containsKey("sig")) {
      paramPromise = paramHippyMap.getString("sig");
    }
    localBundle.putString("sig", paramPromise);
    paramPromise = this.mReqBundle;
    if (paramHippyMap.containsKey("fromPage")) {
      i = paramHippyMap.getInt("fromPage");
    } else {
      i = 0;
    }
    paramPromise.putInt("fromPage", i);
    super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_open_qqplayer_aio", String.valueOf(j), this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void openQQPlayerAioInMainProcess(HippyMap paramHippyMap, Promise paramPromise)
  {
    Object localObject = getAppInterface();
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
    Context localContext = localQQAppInterface.getApp().getApplicationContext();
    boolean bool = paramHippyMap.containsKey("fromRoleId");
    String str8 = "";
    if (bool) {
      localObject = paramHippyMap.getString("fromRoleId");
    } else {
      localObject = "";
    }
    String str1;
    if (paramHippyMap.containsKey("fromOpenId")) {
      str1 = paramHippyMap.getString("fromOpenId");
    } else {
      str1 = "";
    }
    String str2;
    if (paramHippyMap.containsKey("toRoleId")) {
      str2 = paramHippyMap.getString("toRoleId");
    } else {
      str2 = "";
    }
    String str3;
    if (paramHippyMap.containsKey("toOpenId")) {
      str3 = paramHippyMap.getString("toOpenId");
    } else {
      str3 = "";
    }
    String str4;
    if (paramHippyMap.containsKey("fromTinyId")) {
      str4 = paramHippyMap.getString("fromTinyId");
    } else {
      str4 = "";
    }
    String str5;
    if (paramHippyMap.containsKey("toTinyId")) {
      str5 = paramHippyMap.getString("toTinyId");
    } else {
      str5 = "";
    }
    String str6;
    if (paramHippyMap.containsKey("topGrayText")) {
      str6 = paramHippyMap.getString("topGrayText");
    } else {
      str6 = "";
    }
    String str7;
    if (paramHippyMap.containsKey("sig")) {
      str7 = paramHippyMap.getString("sig");
    } else {
      str7 = "";
    }
    int i;
    if (paramHippyMap.containsKey("windowFlag")) {
      i = paramHippyMap.getInt("windowFlag");
    } else {
      i = 0;
    }
    int j;
    if (paramHippyMap.containsKey("fromPage")) {
      j = paramHippyMap.getInt("fromPage");
    } else {
      j = 0;
    }
    long l;
    if (paramHippyMap.containsKey("gameAppId")) {
      l = paramHippyMap.getLong("gameAppId");
    } else {
      l = 0L;
    }
    ((IGameQQPlayerUtilApi)QRoute.api(IGameQQPlayerUtilApi.class)).openGameMsgAIO(localQQAppInterface, localContext, (String)localObject, str1, str2, str3, str6, str7, l, str4, str5, i, j);
    paramHippyMap = new Bundle();
    paramHippyMap.putInt("result", 0);
    paramHippyMap = parseClickCommonSessionRsp(paramHippyMap);
    if (paramPromise != null)
    {
      if (paramHippyMap == null) {
        paramHippyMap = str8;
      } else {
        paramHippyMap = paramHippyMap.toString();
      }
      paramPromise.resolve(paramHippyMap);
    }
  }
  
  private void setSwitchByIpc(HippyMap paramHippyMap, Promise paramPromise)
  {
    int k = saveCallback(paramPromise);
    this.mReqBundle.clear();
    Bundle localBundle = this.mReqBundle;
    if (paramHippyMap.containsKey("gameId")) {
      paramPromise = paramHippyMap.getString("gameId");
    } else {
      paramPromise = "";
    }
    localBundle.putString("gameId", paramPromise);
    paramPromise = this.mReqBundle;
    boolean bool = paramHippyMap.containsKey("switchType");
    int j = -1;
    if (bool) {
      i = paramHippyMap.getInt("switchType");
    } else {
      i = -1;
    }
    paramPromise.putInt("switchType", i);
    paramPromise = this.mReqBundle;
    int i = j;
    if (paramHippyMap.containsKey("value")) {
      i = paramHippyMap.getInt("value");
    }
    paramPromise.putInt("value", i);
    super.sendRemoteReq(DataFactory.a("ipc_cmd_gamecenter_toggle_changed", String.valueOf(k), this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  private void setSwitchInMainProcess(HippyMap paramHippyMap, Promise paramPromise)
  {
    AppInterface localAppInterface = getAppInterface();
    if (!(localAppInterface instanceof QQAppInterface)) {
      return;
    }
    String str;
    if (paramHippyMap.containsKey("gameId")) {
      str = paramHippyMap.getString("gameId");
    } else {
      str = "";
    }
    boolean bool = paramHippyMap.containsKey("switchType");
    int j = -1;
    int i;
    if (bool) {
      i = paramHippyMap.getInt("switchType");
    } else {
      i = -1;
    }
    if (paramHippyMap.containsKey("value")) {
      j = paramHippyMap.getInt("value");
    }
    MessengerService.a((QQAppInterface)localAppInterface, str, i, j);
    callback(paramPromise, 0, "");
  }
  
  void callback(Promise paramPromise, int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramInt);
      localJSONObject.put("ret", paramInt);
      localJSONObject.put("msg", paramString);
      if (paramPromise != null)
      {
        paramPromise.resolve(localJSONObject.toString());
        return;
      }
    }
    catch (Exception paramPromise)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGameCenterModule", 2, paramPromise.getMessage());
      }
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
      if (QLog.isColorLevel()) {
        QLog.e("QQGameCenterModule", 2, paramString1.getMessage());
      }
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
  
  @HippyMethod(name="delGameSession")
  public void delGameSession(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[delGameSession], params:");
      localStringBuilder.append(paramHippyMap);
      QLog.d("QQGameCenterModule", 2, localStringBuilder.toString());
    }
    if (this.mIsInMainProcess)
    {
      delSessionInMainProcess(paramHippyMap, paramPromise);
      return;
    }
    delSessionByIpc(paramHippyMap, paramPromise);
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
    HippyQQEngine localHippyQQEngine = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
    String str = "";
    if (localHippyQQEngine != null)
    {
      if (localHippyQQEngine.getPageUrl() != null) {
        str = localHippyQQEngine.getPageUrl();
      }
      paramPromise.resolve(str);
      return;
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
    QBaseFragment localQBaseFragment = super.getFragment();
    if ((localQBaseFragment instanceof GameMsgAppFragment)) {
      ((GameMsgAppFragment)localQBaseFragment).a();
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    super.onResponse(paramBundle);
    if (paramBundle == null) {
      return;
    }
    Object localObject2 = paramBundle.getString("cmd");
    int i = paramBundle.getInt("respkey", 0);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onResponse] cmd:");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" respkey:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("，key:");
      ((StringBuilder)localObject1).append(this.mOnRemoteResp.key);
      QLog.d("QQGameCenterModule", 1, ((StringBuilder)localObject1).toString());
    }
    if (i != this.mOnRemoteResp.key) {
      return;
    }
    Object localObject1 = paramBundle.getString("callbackid");
    Bundle localBundle = paramBundle.getBundle("response");
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (localBundle == null) {
        return;
      }
      paramBundle = getActivity();
      if ((paramBundle != null) && (!paramBundle.isFinishing()))
      {
        try
        {
          boolean bool = "ipc_cmd_gamecenter_get_session_info".equals(localObject2);
          paramBundle = "";
          if ((!bool) && (!"ipc_cmd_gamecenter_get_request_info".equals(localObject2)))
          {
            if ("ipc_cmd_gamecenter_open_aio".equals(localObject2))
            {
              localObject2 = parseClickCommonSessionRsp(localBundle);
              if (localObject2 != null) {
                paramBundle = ((JSONObject)localObject2).toString();
              }
              callback((String)localObject1, paramBundle);
              return;
            }
            if ("ipc_cmd_gamecenter_get_unread_total".equals(localObject2))
            {
              localObject2 = parseGetNewMsgCountRsp(localBundle);
              if (localObject2 != null) {
                paramBundle = ((JSONObject)localObject2).toString();
              }
              callback((String)localObject1, paramBundle);
              return;
            }
            if ("ipc_cmd_gamecenter_toggle_changed".equals(localObject2))
            {
              callback((String)localObject1, 0, "");
              return;
            }
            if ("ipc_cmd_gamecenter_open_qqplayer_aio".equals(localObject2))
            {
              localObject2 = parseClickCommonSessionRsp(localBundle);
              if (localObject2 != null) {
                paramBundle = ((JSONObject)localObject2).toString();
              }
              callback((String)localObject1, paramBundle);
              return;
            }
            if ("ipc_cmd_gamecenter_del_game_session".equals(localObject2))
            {
              localObject2 = parseClickCommonSessionRsp(localBundle);
              if (localObject2 != null) {
                paramBundle = ((JSONObject)localObject2).toString();
              }
              callback((String)localObject1, paramBundle);
            }
          }
          else
          {
            localObject2 = parseGetSessionRsp(localBundle);
            if (localObject2 != null) {
              paramBundle = ((JSONObject)localObject2).toString();
            }
            callback((String)localObject1, paramBundle);
            return;
          }
        }
        catch (Throwable paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQGameCenterModule", 2, paramBundle.getMessage());
          }
          callback((String)localObject1, 1, "-2000");
        }
        return;
      }
      callback((String)localObject1, 1, "-1000");
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
      try
      {
        paramBundle.put("ret", i);
        Object localObject = paramBundle;
        if (!QLog.isColorLevel()) {
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseClickCommonSessionRsp ret:");
        ((StringBuilder)localObject).append(i);
        QLog.d("QQGameCenterModule", 2, ((StringBuilder)localObject).toString());
        return paramBundle;
      }
      catch (Throwable localThrowable1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Throwable localThrowable2)
    {
      paramBundle = null;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("parseClickCommonSessionRsp error:");
    localStringBuilder.append(localThrowable2);
    QLog.d("QQGameCenterModule", 1, localStringBuilder.toString());
    Bundle localBundle = paramBundle;
    return localBundle;
  }
  
  protected JSONObject parseGetNewMsgCountRsp(Bundle paramBundle)
  {
    try
    {
      int i = paramBundle.getInt("result");
      int j = paramBundle.getInt("cnt");
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ret", i);
        ((JSONObject)localObject).put("newMsgCount", j);
        paramBundle = paramBundle.getString("singleUnread", "");
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[parseGetNewMsgCountRsp] ----unreadStr---:");
        localStringBuilder1.append(paramBundle);
        QLog.i("QQGameCenterModule", 1, localStringBuilder1.toString());
        if (!TextUtils.isEmpty(paramBundle)) {
          ((JSONObject)localObject).put("tabMsgCount", new JSONObject(paramBundle));
        }
        paramBundle = new StringBuilder();
        paramBundle.append("----885unread----:");
        paramBundle.append(localObject);
        QLog.d("QQGameCenterModule", 1, paramBundle.toString());
        return localObject;
      }
      catch (Throwable localThrowable2)
      {
        paramBundle = (Bundle)localObject;
        localObject = localThrowable2;
      }
      localStringBuilder2 = new StringBuilder();
    }
    catch (Throwable localThrowable1)
    {
      paramBundle = null;
    }
    StringBuilder localStringBuilder2;
    localStringBuilder2.append("parseGetNewMsgCountRsp error:");
    localStringBuilder2.append(localThrowable1);
    QLog.d("QQGameCenterModule", 1, localStringBuilder2.toString());
    return paramBundle;
  }
  
  protected JSONObject parseGetSessionRsp(Bundle paramBundle)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        int i = paramBundle.getInt("result");
        localObject2 = paramBundle.getString("data");
        if (localObject2 != null) {
          break label136;
        }
        paramBundle = "";
        paramBundle = new JSONObject(paramBundle);
        try
        {
          paramBundle.put("ret", i);
          Object localObject1 = paramBundle;
          if (!QLog.isColorLevel()) {
            break label134;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("parseGetSessionRsp dataStr is:");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("QQGameCenterModule", 2, ((StringBuilder)localObject1).toString());
          return paramBundle;
        }
        catch (Throwable localThrowable1) {}
        localObject2 = new StringBuilder();
      }
      catch (Throwable localThrowable2)
      {
        paramBundle = null;
      }
      ((StringBuilder)localObject2).append("parseGetSessionRsp error:");
      ((StringBuilder)localObject2).append(localThrowable2);
      QLog.d("QQGameCenterModule", 1, ((StringBuilder)localObject2).toString());
      Bundle localBundle = paramBundle;
      label134:
      return localBundle;
      label136:
      paramBundle = (Bundle)localObject2;
    }
  }
  
  @HippyMethod(name="requestGameCenterTabConfig")
  public void requestGameCenterTabConfig(String paramString, Promise paramPromise)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = (TabFile)((IHippyUpdate)QRoute.api(IHippyUpdate.class)).getTabFilesConfig().get(paramString);
    if (paramString == null) {
      paramString = "";
    } else {
      paramString = paramString.tabFileJson;
    }
    paramPromise.resolve(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.gamecenter.QQGameCenterModule
 * JD-Core Version:    0.7.0.1
 */