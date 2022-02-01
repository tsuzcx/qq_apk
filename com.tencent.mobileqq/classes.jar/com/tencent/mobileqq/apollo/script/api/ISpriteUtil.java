package com.tencent.mobileqq.apollo.script.api;

import android.content.Context;
import com.tencent.mobileqq.apollo.script.ISpriteActionScript;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ISpriteUtil
  extends QRouteApi
{
  public abstract void canInitCmShow(AppRuntime paramAppRuntime);
  
  public abstract boolean canUseCmShow(AppRuntime paramAppRuntime, int paramInt, String paramString);
  
  public abstract int getAIOSurfaceInitHeight();
  
  public abstract int getAIOSurfaceInitWidth();
  
  public abstract ISpriteActionScript getActionScript(AppRuntime paramAppRuntime);
  
  public abstract ISpriteContext getSpriteContext(AppRuntime paramAppRuntime);
  
  public abstract int getWaitingMargin(Context paramContext);
  
  public abstract boolean isCmShowKeywordAssociationActive(AppRuntime paramAppRuntime);
  
  public abstract boolean isProperAIO(AppRuntime paramAppRuntime, int paramInt, String paramString);
  
  public abstract boolean isSpriteHidden(AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.api.ISpriteUtil
 * JD-Core Version:    0.7.0.1
 */