package com.tencent.hippy.qq.module.gamecenter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import ascz;
import asdd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.module.QQBaseWebIpcModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

@HippyNativeModule(name="QQGameCenterModule")
public class QQGameCenterModule
  extends QQBaseWebIpcModule
{
  static final String CLASSNAME = "QQGameCenterModule";
  static final String GAME_CENTER_EVENT_MSG_CHANGE = "QQGameCenter_newMsgCountChanged";
  static final String GAME_CENTER_EVENT_MSG_UNREAD_CNT = "QQGameCenter_sessionChanged";
  private BroadcastReceiver mMsgReceiver = new QQGameCenterModule.1(this);
  Bundle mReqBundle = new Bundle();
  
  public QQGameCenterModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    paramHippyEngineContext = new IntentFilter();
    paramHippyEngineContext.addAction("action_qgame_messgae_change");
    paramHippyEngineContext.addAction("action_qgame_unread_change");
    BaseApplicationImpl.getApplication().registerReceiver(this.mMsgReceiver, paramHippyEngineContext);
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
    int i = saveCallback(paramPromise);
    this.mReqBundle.clear();
    paramPromise = this.mReqBundle;
    if (paramHippyMap.containsKey("sessionId")) {}
    for (paramHippyMap = paramHippyMap.getString("sessionId");; paramHippyMap = "")
    {
      paramPromise.putString("sessionId", paramHippyMap);
      super.sendRemoteReq(asdd.a("ipc_cmd_gamecenter_open_aio", String.valueOf(i), this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
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
    int i = saveCallback(paramPromise);
    this.mReqBundle.clear();
    super.sendRemoteReq(asdd.a("ipc_cmd_gamecenter_get_unread_total", String.valueOf(i), this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  @HippyMethod(name="getRequestData")
  public void getRequestData(HippyMap paramHippyMap, Promise paramPromise)
  {
    int i = saveCallback(paramPromise);
    this.mReqBundle.clear();
    paramPromise = this.mReqBundle;
    if (paramHippyMap.containsKey("gameId")) {}
    for (paramHippyMap = paramHippyMap.getString("gameId");; paramHippyMap = "")
    {
      paramPromise.putString("gameId", paramHippyMap);
      super.sendRemoteReq(asdd.a("ipc_cmd_gamecenter_get_request_info", String.valueOf(i), this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
  }
  
  @HippyMethod(name="getSessionData")
  public void getSessionData(HippyMap paramHippyMap, Promise paramPromise)
  {
    int i = saveCallback(paramPromise);
    this.mReqBundle.clear();
    this.mReqBundle.putInt("dataType", paramHippyMap.getInt("dataType"));
    super.sendRemoteReq(asdd.a("ipc_cmd_gamecenter_get_session_info", String.valueOf(i), this.mOnRemoteResp.key, this.mReqBundle), false, true);
  }
  
  public void onResponse(Bundle paramBundle)
  {
    super.onResponse(paramBundle);
    if (paramBundle == null) {}
    Object localObject1;
    String str;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            localObject1 = paramBundle.getString("cmd");
            i = paramBundle.getInt("respkey", 0);
            if (QLog.isColorLevel()) {
              QLog.d("QQGameCenterModule", 1, "[onResponse] cmd:" + (String)localObject1 + " respkey:" + i + "，key:" + this.mOnRemoteResp.key);
            }
            if (i == this.mOnRemoteResp.key)
            {
              str = paramBundle.getString("callbackid");
              paramBundle = paramBundle.getBundle("response");
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (paramBundle != null))
              {
                Object localObject2 = getActivity();
                if ((localObject2 == null) || (((Activity)localObject2).isFinishing()))
                {
                  callback(str, 1, "-1000");
                  return;
                }
                try
                {
                  if (("ipc_cmd_gamecenter_get_session_info".equals(localObject1)) || ("ipc_cmd_gamecenter_get_request_info".equals(localObject1)))
                  {
                    i = paramBundle.getInt("result");
                    paramBundle = paramBundle.getString("data");
                    localObject2 = new JSONObject(paramBundle);
                    ((JSONObject)localObject2).put("ret", i);
                    callback(str, ((JSONObject)localObject2).toString());
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("QQGameCenterModule", 2, (String)localObject1 + " onResponse dataStr is:" + paramBundle);
                  }
                }
                catch (Throwable paramBundle)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("QQGameCenterModule", 2, paramBundle.getMessage());
                  }
                  callback(str, 1, "-2000");
                  return;
                }
              }
            }
          }
          if (!"ipc_cmd_gamecenter_open_aio".equals(localObject1)) {
            break;
          }
          i = paramBundle.getInt("result", -1);
          paramBundle = new JSONObject();
          paramBundle.put("ret", i);
          callback(str, paramBundle.toString());
        } while (!QLog.isColorLevel());
        QLog.d("QQGameCenterModule", 2, (String)localObject1 + " onResponse ret:" + i);
        return;
        if (!"ipc_cmd_gamecenter_get_unread_total".equals(localObject1)) {
          break;
        }
        int i = paramBundle.getInt("result");
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("ret", i);
        ((JSONObject)localObject1).put("newMsgCount", paramBundle.getInt("cnt"));
        callback(str, ((JSONObject)localObject1).toString());
      } while (!QLog.isColorLevel());
      QLog.d("QQGameCenterModule", 2, "ipc_cmd_gamecenter_get_request_info onResponse dataStr is:" + ((JSONObject)localObject1).toString());
      return;
    } while (!"ipc_cmd_gamecenter_toggle_changed".equals(localObject1));
    callback(str, 0, "");
  }
  
  @HippyMethod(name="setSwitch")
  public void setSwitch(HippyMap paramHippyMap, Promise paramPromise)
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
        break label147;
      }
    }
    label147:
    for (int i = paramHippyMap.getInt("switchType");; i = -1)
    {
      paramPromise.putInt("switchType", i);
      paramPromise = this.mReqBundle;
      i = j;
      if (paramHippyMap.containsKey("value")) {
        i = paramHippyMap.getInt("value");
      }
      paramPromise.putInt("value", i);
      super.sendRemoteReq(asdd.a("ipc_cmd_gamecenter_toggle_changed", String.valueOf(k), this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
      paramPromise = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.gamecenter.QQGameCenterModule
 * JD-Core Version:    0.7.0.1
 */