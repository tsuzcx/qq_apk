package com.tencent.falco.base.libapi.floatwindow;

import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.log.LogInterface;

public abstract interface FloatWindowPermissionAdapter
{
  public abstract ActivityLifeService getActivityLifeService();
  
  public abstract DataReportInterface getDataReporter();
  
  public abstract HostProxyInterface getHostProxy();
  
  public abstract LogInterface getLog();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionAdapter
 * JD-Core Version:    0.7.0.1
 */