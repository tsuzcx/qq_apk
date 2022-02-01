package com.tencent.av.config.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IVideoEffectConfigParser
  extends QRouteApi
{
  public static final int TEST_DISABLE = 0;
  public static final int TEST_ENABLE = 1;
  
  public abstract int getVideoEffectTestFlag(IConfigParser paramIConfigParser);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.api.IVideoEffectConfigParser
 * JD-Core Version:    0.7.0.1
 */