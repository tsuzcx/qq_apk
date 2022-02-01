package com.tencent.mobileqq.app.proxy;

import android.util.SparseArray;
import mqq.app.AppRuntime;

public abstract interface IProxyService
{
  public abstract SparseArray<BaseProxy> getBusinessProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager);
  
  public abstract boolean getSQLiteSwitchBySample();
  
  public abstract boolean isMessageRecord(Object paramObject);
  
  public abstract boolean isSQLiteReportVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.IProxyService
 * JD-Core Version:    0.7.0.1
 */