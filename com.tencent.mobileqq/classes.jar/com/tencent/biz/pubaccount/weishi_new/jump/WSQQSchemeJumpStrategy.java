package com.tencent.biz.pubaccount.weishi_new.jump;

import UserGrowth.stSchema;
import com.tencent.biz.pubaccount.weishi_new.wsqqscheme.WSQQSchemeUtils;

public class WSQQSchemeJumpStrategy
  extends AbsWSJump
{
  public WSQQSchemeJumpStrategy(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    super(paramIWSStSchemaJumpFactor);
  }
  
  public boolean a(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    boolean bool = WSQQSchemeUtils.a(paramIWSStSchemaJumpFactor.a(), paramIWSStSchemaJumpFactor.b().qqSchema, paramIWSStSchemaJumpFactor.i());
    if ((bool) && (paramIWSStSchemaJumpFactor.h() != null)) {
      paramIWSStSchemaJumpFactor.h().e();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.WSQQSchemeJumpStrategy
 * JD-Core Version:    0.7.0.1
 */