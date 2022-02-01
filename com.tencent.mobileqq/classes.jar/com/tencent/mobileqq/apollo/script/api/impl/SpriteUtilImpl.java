package com.tencent.mobileqq.apollo.script.api.impl;

import android.content.Context;
import com.tencent.mobileqq.apollo.script.ISpriteActionScript;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.api.ISpriteUtil;
import mqq.app.AppRuntime;

public class SpriteUtilImpl
  implements ISpriteUtil
{
  public void canInitCmShow(AppRuntime paramAppRuntime)
  {
    SpriteUtil.a(paramAppRuntime);
  }
  
  public boolean canUseCmShow(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    return SpriteUtil.b(paramAppRuntime, paramInt, paramString);
  }
  
  public int getAIOSurfaceInitHeight()
  {
    return SpriteUtil.a();
  }
  
  public int getAIOSurfaceInitWidth()
  {
    return SpriteUtil.b();
  }
  
  public ISpriteActionScript getActionScript(AppRuntime paramAppRuntime)
  {
    return SpriteUtil.a(paramAppRuntime);
  }
  
  public ISpriteContext getSpriteContext(AppRuntime paramAppRuntime)
  {
    return SpriteUtil.a(paramAppRuntime);
  }
  
  public int getWaitingMargin(Context paramContext)
  {
    return SpriteUtil.a(paramContext);
  }
  
  public boolean isCmShowKeywordAssociationActive(AppRuntime paramAppRuntime)
  {
    return SpriteUtil.c(paramAppRuntime);
  }
  
  public boolean isProperAIO(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    return SpriteUtil.a(paramAppRuntime, paramInt, paramString);
  }
  
  public boolean isSpriteHidden(AppRuntime paramAppRuntime)
  {
    return SpriteUtil.a(paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.api.impl.SpriteUtilImpl
 * JD-Core Version:    0.7.0.1
 */