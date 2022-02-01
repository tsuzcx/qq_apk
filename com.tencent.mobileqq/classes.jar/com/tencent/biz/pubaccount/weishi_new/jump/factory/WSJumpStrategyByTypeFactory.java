package com.tencent.biz.pubaccount.weishi_new.jump.factory;

import UserGrowth.stSchema;
import com.tencent.biz.pubaccount.weishi_new.jump.AbsWSJump;
import com.tencent.biz.pubaccount.weishi_new.jump.IWSStSchemaJumpFactor;
import com.tencent.biz.pubaccount.weishi_new.jump.WSClientJumpStrategy;
import com.tencent.biz.pubaccount.weishi_new.jump.WSDownloadAppStrategy;
import com.tencent.biz.pubaccount.weishi_new.jump.WSMiniAppJumpStrategy;
import com.tencent.biz.pubaccount.weishi_new.jump.WSWebJumpStrategy;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class WSJumpStrategyByTypeFactory
  implements IWSJumpFactory
{
  private AbsWSJump b(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    if (WeishiGuideUtils.a(BaseApplicationImpl.getContext())) {
      return new WSClientJumpStrategy(paramIWSStSchemaJumpFactor);
    }
    return new WSDownloadAppStrategy(paramIWSStSchemaJumpFactor);
  }
  
  public AbsWSJump a(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    switch (paramIWSStSchemaJumpFactor.a().type)
    {
    default: 
      return null;
    case 1: 
      return new WSMiniAppJumpStrategy(paramIWSStSchemaJumpFactor);
    case 2: 
      return b(paramIWSStSchemaJumpFactor);
    }
    return new WSWebJumpStrategy(paramIWSStSchemaJumpFactor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.factory.WSJumpStrategyByTypeFactory
 * JD-Core Version:    0.7.0.1
 */