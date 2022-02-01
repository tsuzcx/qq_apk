package com.qflutter.qqcircle;

import io.flutter.plugin.common.MethodChannel.Result;
import java.util.List;
import java.util.Map;

public abstract interface IQQCircleMethod
{
  public abstract void changeFollowState(String paramString1, String paramString2);
  
  public abstract void clearCache(String paramString, int paramInt);
  
  public abstract List<String> getCache(String paramString, int paramInt);
  
  public abstract void gotoMainPage(String paramString);
  
  public abstract void loadNoNetworkImage(MethodChannel.Result paramResult);
  
  public abstract void openDetailPage(String paramString1, String paramString2, String paramString3);
  
  public abstract void openTagPage(String paramString1, String paramString2);
  
  public abstract void parseText(String paramString, MethodChannel.Result paramResult);
  
  public abstract void parseTextBatch(Map<String, String> paramMap, MethodChannel.Result paramResult);
  
  public abstract void reportDC05504(int paramInt1, int paramInt2, int paramInt3, Map<String, Object> paramMap, boolean paramBoolean);
  
  public abstract void saveCache(String paramString, List<String> paramList, int paramInt, long paramLong);
  
  public abstract void sendSsoRequest(String paramString, byte[] paramArrayOfByte, MethodChannel.Result paramResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.qqcircle.IQQCircleMethod
 * JD-Core Version:    0.7.0.1
 */