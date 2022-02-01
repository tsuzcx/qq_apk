package com.tencent.biz.pubaccount.weishi_new.jump;

import UserGrowth.stSchema;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;

public class WSMiniAppJumpStrategy
  extends AbsWSJump
{
  public WSMiniAppJumpStrategy(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    super(paramIWSStSchemaJumpFactor);
  }
  
  public boolean a(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    MiniAppLaunchListener localMiniAppLaunchListener = paramIWSStSchemaJumpFactor.f();
    WeishiActivityHelper.a(paramIWSStSchemaJumpFactor.a(), paramIWSStSchemaJumpFactor.b().miniAppSchema, new WSMiniAppJumpStrategy.1(this, localMiniAppLaunchListener));
    if (paramIWSStSchemaJumpFactor.h() != null) {
      paramIWSStSchemaJumpFactor.h().b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.WSMiniAppJumpStrategy
 * JD-Core Version:    0.7.0.1
 */