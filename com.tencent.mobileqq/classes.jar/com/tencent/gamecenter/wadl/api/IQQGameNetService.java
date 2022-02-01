package com.tencent.gamecenter.wadl.api;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.listener.WadlCmdListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IQQGameNetService
  extends QRouteApi
{
  public abstract void addListener(WadlCmdListener paramWadlCmdListener);
  
  public abstract void checkGameDownload(WadlParams paramWadlParams, Bundle paramBundle);
  
  public abstract void destroy();
  
  public abstract void getApkDownloadInfo(String paramString, ArrayList<String> paramArrayList);
  
  public abstract void getAutoDownloadApk();
  
  public abstract void getFloadWindowInfo(String paramString);
  
  public abstract void getGameRegisterInfo(String paramString);
  
  public abstract void onRespWebSso(Intent paramIntent, boolean paramBoolean, byte[] paramArrayOfByte);
  
  public abstract void removeListener(WadlCmdListener paramWadlCmdListener);
  
  public abstract void reportDownloadStart(JSONArray paramJSONArray1, JSONArray paramJSONArray2);
  
  public abstract void requestArk(String paramString, int paramInt);
  
  public abstract void requestRedPoint(int paramInt);
  
  public abstract void requestWebSso(String paramString, JSONObject paramJSONObject, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.IQQGameNetService
 * JD-Core Version:    0.7.0.1
 */