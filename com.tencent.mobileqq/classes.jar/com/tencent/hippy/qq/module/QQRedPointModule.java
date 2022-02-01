package com.tencent.hippy.qq.module;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
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
  public OnRemoteRespObserver mOnRemoteResp = new QQRedPointModule.2(this);
  
  public QQRedPointModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void handleSetAppInfo(String paramString, Bundle paramBundle)
  {
    int i;
    if (paramBundle == null) {
      i = -1;
    } else {
      i = paramBundle.getInt("iret");
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("code", i);
      if (i == -3) {
        paramBundle.put("errorMessage", "appInfo not found");
      } else if (i == -4) {
        paramBundle.put("errorMessage", "failed to set appInfo");
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAppInfo:");
        localStringBuilder.append(paramBundle.toString());
        QLog.i("QQRedPointModule", 2, localStringBuilder.toString());
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    paramString = getCallback(paramString);
    if (paramString != null) {
      paramString.resolve(paramBundle.toString());
    }
  }
  
  @HippyMethod(name="getAppInfo")
  public void getAppInfo(String paramString, Promise paramPromise)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getappinfo js startime : ");
      localStringBuilder.append(l);
      QLog.i("QQRedPointModule", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new QQRedPointModule.1(this, paramString, l, paramPromise), 8, null, true);
  }
  
  @HippyMethod(name="isEnterFromRedPoint")
  public void isEnterFromRedPoint(String paramString, Promise paramPromise)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
    {
      String str1 = paramBundle.getString("cmd");
      String str2 = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if ("redTouch_setAppInfo".equals(str1)) {
        handleSetAppInfo(str2, paramBundle);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQRedPointModule
 * JD-Core Version:    0.7.0.1
 */