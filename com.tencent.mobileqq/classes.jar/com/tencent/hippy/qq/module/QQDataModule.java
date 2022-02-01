package com.tencent.hippy.qq.module;

import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONObject;

@HippyNativeModule(name="QQDataModule")
public class QQDataModule
  extends QQBaseModule
{
  static final String CLASSNAME = "QQDataModule";
  private static final String QQGAMECENTER_DOMAIN = "gamecenter.qq.com";
  
  public QQDataModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="userInfo")
  public void userInfo(Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    Object localObject1 = getBaseActivity();
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = ((BaseActivity)localObject1).getAppInterface();; localObject2 = null)
    {
      Object localObject3 = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
      if ((localObject1 != null) && (((AppInterface)localObject1).isLogin()) && (localObject3 != null) && (((HippyQQEngine)localObject3).getModuleName() != null) && (((HippyQQEngine)localObject3).getModuleName().startsWith("QQGameCenter")))
      {
        localObject3 = ((AppInterface)localObject1).getCurrentAccountUin();
        String str1 = ((AppInterface)localObject1).getCurrentNickname();
        Object localObject4 = (TicketManager)((AppInterface)localObject1).getManager(2);
        String str2 = ((TicketManager)localObject4).getSkey((String)localObject3);
        localObject4 = ((TicketManager)localObject4).getPskey((String)localObject3, "gamecenter.qq.com");
        localObject1 = SwiftBrowserCookieMonster.b((AppRuntime)localObject1, "gamecenter.qq.com");
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uin", localObject3);
          localJSONObject.put("nick", str1);
          localJSONObject.put("skey", str2);
          localJSONObject.put("p_skey", localObject4);
          localJSONObject.put("pt4_token", localObject1);
          paramPromise.resolve(localJSONObject.toString());
          return;
        }
        catch (Throwable localThrowable) {}
      }
      paramPromise.resolve("{}");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQDataModule
 * JD-Core Version:    0.7.0.1
 */