package com.tencent.hippy.qq.module;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="QQRedPointModule")
public class QQRedPointModule
  extends QQBaseWebIpcModule
{
  static final String CLASSNAME = "QQRedPointModule";
  public Client.OnRemoteRespObserver mOnRemoteResp = new QQRedPointModule.2(this);
  
  public QQRedPointModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void handleSetAppInfo(String paramString, Bundle paramBundle)
  {
    int i;
    if (paramBundle == null)
    {
      i = -1;
      paramBundle = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramBundle.put("code", i);
        if (i != -3) {
          continue;
        }
        paramBundle.put("errorMessage", "appInfo not found");
        if (QLog.isColorLevel()) {
          QLog.i("QQRedPointModule", 2, "setAppInfo:" + paramBundle.toString());
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      paramString = getCallback(paramString);
      if (paramString != null) {
        paramString.resolve(paramBundle.toString());
      }
      return;
      i = paramBundle.getInt("iret");
      break;
      if (i == -4) {
        paramBundle.put("errorMessage", "failed to set appInfo");
      }
    }
  }
  
  @HippyMethod(name="getAppInfo")
  public void getAppInfo(String paramString, Promise paramPromise)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QQRedPointModule", 2, "getappinfo js startime : " + l);
    }
    ThreadManager.post(new QQRedPointModule.1(this, paramString, l, paramPromise), 8, null, true);
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str1;
    String str2;
    do
    {
      do
      {
        return;
      } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
      str1 = paramBundle.getString("cmd");
      str2 = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
    } while (!"redTouch_setAppInfo".equals(str1));
    handleSetAppInfo(str2, paramBundle);
  }
  
  @HippyMethod(name="setAppInfo")
  public void setAppInfo(String paramString, Promise paramPromise)
  {
    HashMap localHashMap = RedTouchWebviewHandler.parseSetAppInfoParam(paramString);
    int i = ((Integer)localHashMap.get("code")).intValue();
    paramString = paramPromise.getCallId();
    if (i == 0)
    {
      saveCallback(paramPromise);
      paramPromise = (Bundle)localHashMap.get("req");
      super.sendRemoteReq(DataFactory.a("redTouch_setAppInfo", paramString, this.mOnRemoteResp.key, paramPromise), false, true);
      return;
    }
    paramPromise.resolve((String)localHashMap.get("errorJson"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQRedPointModule
 * JD-Core Version:    0.7.0.1
 */