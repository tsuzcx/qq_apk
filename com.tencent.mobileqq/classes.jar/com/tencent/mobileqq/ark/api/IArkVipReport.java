package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.ark.vipreport.ArkVipSceneConfig;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

@QAPI(process={"all"})
public abstract interface IArkVipReport
  extends QRouteApi
{
  public static final String SCENE_OPEN_LOGIN = "OpenLogin";
  public static final String SCENE_OPEN_SHARE = "OpenShare";
  
  public abstract void addEventToScene(String paramString, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap);
  
  public abstract void initScene(String paramString, ArkVipSceneConfig paramArkVipSceneConfig);
  
  public abstract void startSceneByEvent(String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkVipReport
 * JD-Core Version:    0.7.0.1
 */