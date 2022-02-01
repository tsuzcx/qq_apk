package com.tencent.mobileqq.bridge.report.service;

import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager.ConfigType;

public abstract interface IReportDataProviderService
{
  public abstract <T> T a();
  
  public abstract <T> T a(AppRuntime paramAppRuntime);
  
  public abstract String a(AppRuntime paramAppRuntime, ServerConfigManager.ConfigType paramConfigType, String paramString);
  
  public abstract List<String> a();
  
  public abstract boolean a(String paramString);
  
  public abstract List<String> b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bridge.report.service.IReportDataProviderService
 * JD-Core Version:    0.7.0.1
 */