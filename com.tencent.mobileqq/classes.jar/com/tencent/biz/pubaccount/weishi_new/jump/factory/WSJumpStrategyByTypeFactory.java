package com.tencent.biz.pubaccount.weishi_new.jump.factory;

import UserGrowth.stSchema;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.jump.AbsWSJump;
import com.tencent.biz.pubaccount.weishi_new.jump.IWSStSchemaJumpFactor;
import com.tencent.biz.pubaccount.weishi_new.jump.WSClientJumpStrategy;
import com.tencent.biz.pubaccount.weishi_new.jump.WSDownloadAppStrategy;
import com.tencent.biz.pubaccount.weishi_new.jump.WSMiniAppJumpStrategy;
import com.tencent.biz.pubaccount.weishi_new.jump.WSQQSchemeJumpStrategy;
import com.tencent.biz.pubaccount.weishi_new.jump.WSWebJumpStrategy;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class WSJumpStrategyByTypeFactory
  implements IWSJumpFactory
{
  private AbsWSJump b(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    String str = paramIWSStSchemaJumpFactor.a().schema;
    boolean bool = WeishiGuideUtils.a(BaseApplicationImpl.getContext());
    if ((paramIWSStSchemaJumpFactor.b()) && (!TextUtils.isEmpty(str)) && (!bool)) {
      WeishiUtils.a(str);
    }
    return new WSWebJumpStrategy(paramIWSStSchemaJumpFactor);
  }
  
  private AbsWSJump c(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    if (WeishiGuideUtils.a(BaseApplicationImpl.getContext())) {
      return new WSClientJumpStrategy(paramIWSStSchemaJumpFactor);
    }
    return new WSDownloadAppStrategy(paramIWSStSchemaJumpFactor);
  }
  
  public AbsWSJump a(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    int i = paramIWSStSchemaJumpFactor.a().type;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return null;
          }
          return new WSQQSchemeJumpStrategy(paramIWSStSchemaJumpFactor);
        }
        return b(paramIWSStSchemaJumpFactor);
      }
      return c(paramIWSStSchemaJumpFactor);
    }
    return new WSMiniAppJumpStrategy(paramIWSStSchemaJumpFactor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.factory.WSJumpStrategyByTypeFactory
 * JD-Core Version:    0.7.0.1
 */