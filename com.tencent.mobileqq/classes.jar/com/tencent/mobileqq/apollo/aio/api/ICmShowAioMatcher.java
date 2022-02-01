package com.tencent.mobileqq.apollo.aio.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/aio/api/ICmShowAioMatcher;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isSupported", "", "aioType", "", "type", "AioSupported", "Constant", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface ICmShowAioMatcher
  extends QRouteApi
{
  public static final int AIO_TYPE_ALL = 0;
  public static final int AIO_TYPE_C2C = 1;
  public static final int AIO_TYPE_GROUP = 2;
  public static final ICmShowAioMatcher.Constant Constant = ICmShowAioMatcher.Constant.a;
  
  public abstract boolean isSupported(int paramInt);
  
  public abstract boolean isSupported(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.api.ICmShowAioMatcher
 * JD-Core Version:    0.7.0.1
 */