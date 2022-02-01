package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.vas.hippyhelper.HippyJSBHelper;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.util.HashMap;

@HippyNativeModule(name="QQJsbModule")
public class QQJsbModule
  extends QQBaseLifecycleModule
{
  public static final String CLASS_NAME = "QQJsbModule";
  private static final String METHOD_CALL_JSB = "callJsBridge";
  private final HippyJSBHelper mHippyJSBHelper = HippyJSBHelper.b();
  
  public QQJsbModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private static boolean hasCommandRight(HippyEngineContext paramHippyEngineContext, String paramString)
  {
    paramHippyEngineContext = HippyQQEngine.getEngineInstance(paramHippyEngineContext.getEngineId());
    if (paramHippyEngineContext == null) {
      return false;
    }
    return AuthorizeConfig.a().a(paramHippyEngineContext.getPageUrl(), paramString);
  }
  
  @HippyMethod(name="callJsBridge")
  public void callJsBridge(HippyMap paramHippyMap, Promise paramPromise)
  {
    this.mHippyJSBHelper.a(new QQJsbModule.QQJsbModuleAdapter(paramPromise, getActivity(), getAppInterface(), paramHippyMap, this.mContext));
    this.mHippyJSBHelper.a(paramHippyMap);
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    byte b = (byte)paramInt1;
    paramActivity = new HashMap();
    paramActivity.put("Intent,byte,int", new Object[] { paramIntent, Byte.valueOf(b), Integer.valueOf(paramInt2) });
    paramActivity.put("int,int,Intent", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    this.mHippyJSBHelper.a(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQJsbModule
 * JD-Core Version:    0.7.0.1
 */