package com.tencent.gamecenter.wadl.api;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeReq;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IQQGameTrpcService
  extends QRouteApi
{
  public abstract void addListener(WadlTrpcListener paramWadlTrpcListener);
  
  public abstract TrpcProxy.TrpcInovkeReq createTrpcInvokeReq(String paramString, boolean paramBoolean, byte[] paramArrayOfByte);
  
  public abstract void destroy();
  
  public abstract void onRespTrpcSso(Intent paramIntent, boolean paramBoolean, byte[] paramArrayOfByte);
  
  public abstract void removeListener(WadlTrpcListener paramWadlTrpcListener);
  
  public abstract void reportAtta(JSONObject paramJSONObject);
  
  public abstract void reportTianJi(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8);
  
  public abstract void requestTrpc(TrpcProxy.TrpcListReq paramTrpcListReq, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.IQQGameTrpcService
 * JD-Core Version:    0.7.0.1
 */