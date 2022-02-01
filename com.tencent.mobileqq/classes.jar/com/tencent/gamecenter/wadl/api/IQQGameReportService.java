package com.tencent.gamecenter.wadl.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IQQGameReportService
  extends QRouteApi
{
  public abstract void report(JSONObject paramJSONObject, int paramInt);
  
  public abstract void reportDC(WadlReportBuilder paramWadlReportBuilder);
  
  public abstract void reportDC(String paramString1, String paramString2, WadlReportInfo paramWadlReportInfo, String paramString3);
  
  public abstract void reportDC(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void reportGamePubAccountMsgStatus(int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.IQQGameReportService
 * JD-Core Version:    0.7.0.1
 */