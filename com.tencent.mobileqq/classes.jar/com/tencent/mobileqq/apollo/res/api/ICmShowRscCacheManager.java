package com.tencent.mobileqq.apollo.res.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICmShowRscCacheManager
  extends QRouteApi
{
  public static final String ACTION_APOLLO_CMSHOW_CONTENT_UPDATE = "action_apollo_cmshow_content_update";
  public static final String KEY_CONTENT_UPDATE_ZIP_NAME = "key_content_update_zip_name";
  public static final String TAG = "rscContent_ApolloRscCacheManager";
  
  public abstract void onRoomZipUpdated();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.ICmShowRscCacheManager
 * JD-Core Version:    0.7.0.1
 */