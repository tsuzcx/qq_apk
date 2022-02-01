package com.tencent.aekit.api.standard.filter;

import java.util.List;
import java.util.Map;
import org.light.bean.WMElement;
import org.light.listener.IOnClickWatermarkListener;
import org.light.listener.WatermarkDelegate;

public abstract interface IWatermarkHandle
{
  public abstract void wmAddInfoDict(Map<String, String> paramMap);
  
  public abstract List<WMElement> wmGetEditableWMElements();
  
  public abstract void wmSetLocation(String paramString);
  
  public abstract void wmSetOnClickWatermarkListener(IOnClickWatermarkListener paramIOnClickWatermarkListener);
  
  public abstract void wmSetOnlineUsrCountDelegate(String paramString, WatermarkDelegate paramWatermarkDelegate);
  
  public abstract void wmSetTemperature(String paramString);
  
  public abstract void wmSetWeatherCode(int paramInt);
  
  public abstract void wmSetWeatherStr(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.IWatermarkHandle
 * JD-Core Version:    0.7.0.1
 */