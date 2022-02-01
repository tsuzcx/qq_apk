package com.tencent.mobileqq.apollo.res.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICmShowRscUpdateHandler
  extends QRouteApi
{
  public static final String CONTENT_UPDATE_ROOM3D_ZIP_NAME = "all_room3D";
  
  public abstract void checkUpdateAsync(AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.ICmShowRscUpdateHandler
 * JD-Core Version:    0.7.0.1
 */