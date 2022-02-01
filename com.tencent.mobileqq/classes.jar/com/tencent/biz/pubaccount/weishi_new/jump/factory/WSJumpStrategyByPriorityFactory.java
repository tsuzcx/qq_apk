package com.tencent.biz.pubaccount.weishi_new.jump.factory;

import UserGrowth.stSchema;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.jump.AbsWSJump;
import com.tencent.biz.pubaccount.weishi_new.jump.IWSStSchemaJumpFactor;
import com.tencent.biz.pubaccount.weishi_new.jump.WSClientJumpStrategy;
import com.tencent.biz.pubaccount.weishi_new.jump.WSDownloadAppStrategy;
import com.tencent.biz.pubaccount.weishi_new.jump.WSMiniAppJumpStrategy;
import com.tencent.biz.pubaccount.weishi_new.jump.WSWebJumpStrategy;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class WSJumpStrategyByPriorityFactory
  implements IWSJumpFactory
{
  public AbsWSJump a(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    if ((WeishiGuideUtils.a(BaseApplicationImpl.getContext())) && (!TextUtils.isEmpty(paramIWSStSchemaJumpFactor.a().schema))) {
      return new WSClientJumpStrategy(paramIWSStSchemaJumpFactor);
    }
    if (!TextUtils.isEmpty(paramIWSStSchemaJumpFactor.a().miniAppSchema)) {
      return new WSMiniAppJumpStrategy(paramIWSStSchemaJumpFactor);
    }
    if (!TextUtils.isEmpty(paramIWSStSchemaJumpFactor.a().H5Url)) {
      return new WSWebJumpStrategy(paramIWSStSchemaJumpFactor);
    }
    if (WeishiGuideUtils.a(BaseApplicationImpl.getContext())) {
      return new WSClientJumpStrategy(paramIWSStSchemaJumpFactor);
    }
    return new WSDownloadAppStrategy(paramIWSStSchemaJumpFactor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.factory.WSJumpStrategyByPriorityFactory
 * JD-Core Version:    0.7.0.1
 */