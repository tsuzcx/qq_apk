package com.tencent.biz.pubaccount.weishi_new.jump;

import UserGrowth.stSchema;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;

public class WSWebJumpStrategy
  extends AbsWSJump
{
  public WSWebJumpStrategy(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    super(paramIWSStSchemaJumpFactor);
  }
  
  public boolean a(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    WeishiActivityHelper.a(paramIWSStSchemaJumpFactor.a(), paramIWSStSchemaJumpFactor.b().H5Url);
    if (paramIWSStSchemaJumpFactor.h() != null) {
      paramIWSStSchemaJumpFactor.h().c();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.WSWebJumpStrategy
 * JD-Core Version:    0.7.0.1
 */