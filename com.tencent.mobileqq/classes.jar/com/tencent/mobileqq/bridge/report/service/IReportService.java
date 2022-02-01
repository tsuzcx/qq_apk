package com.tencent.mobileqq.bridge.report.service;

import android.content.Intent;
import mqq.app.AppRuntime;

public abstract interface IReportService
{
  public abstract AppRuntime a(AppRuntime paramAppRuntime);
  
  public abstract void a(Intent paramIntent, AppRuntime paramAppRuntime);
  
  public abstract void a(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bridge.report.service.IReportService
 * JD-Core Version:    0.7.0.1
 */