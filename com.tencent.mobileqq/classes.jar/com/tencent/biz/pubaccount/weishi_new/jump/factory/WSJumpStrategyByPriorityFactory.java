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

public class WSJumpStrategyByPriorityFactory
  implements IWSJumpFactory
{
  public AbsWSJump a(IWSStSchemaJumpFactor paramIWSStSchemaJumpFactor)
  {
    boolean bool = WeishiGuideUtils.a(BaseApplicationImpl.getContext());
    if (!TextUtils.isEmpty(paramIWSStSchemaJumpFactor.b().qqSchema)) {
      return new WSQQSchemeJumpStrategy(paramIWSStSchemaJumpFactor);
    }
    if ((bool) && (!TextUtils.isEmpty(paramIWSStSchemaJumpFactor.b().schema))) {
      return new WSClientJumpStrategy(paramIWSStSchemaJumpFactor);
    }
    if (!TextUtils.isEmpty(paramIWSStSchemaJumpFactor.b().miniAppSchema)) {
      return new WSMiniAppJumpStrategy(paramIWSStSchemaJumpFactor);
    }
    if (!TextUtils.isEmpty(paramIWSStSchemaJumpFactor.b().H5Url))
    {
      String str = paramIWSStSchemaJumpFactor.b().schema;
      if ((paramIWSStSchemaJumpFactor.e()) && (!TextUtils.isEmpty(str)) && (!bool)) {
        WeishiUtils.e(str);
      }
      return new WSWebJumpStrategy(paramIWSStSchemaJumpFactor);
    }
    if (bool) {
      return new WSClientJumpStrategy(paramIWSStSchemaJumpFactor);
    }
    return new WSDownloadAppStrategy(paramIWSStSchemaJumpFactor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.jump.factory.WSJumpStrategyByPriorityFactory
 * JD-Core Version:    0.7.0.1
 */