package com.tencent.livesdk.servicefactory.builder.floatwindowpermission;

import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionAdapter;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class FloatWindowPermissionBuilder$1
  implements FloatWindowPermissionAdapter
{
  FloatWindowPermissionBuilder$1(FloatWindowPermissionBuilder paramFloatWindowPermissionBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public ActivityLifeService getActivityLifeService()
  {
    return (ActivityLifeService)this.val$serviceManager.getService(ActivityLifeService.class);
  }
  
  public DataReportInterface getDataReporter()
  {
    return (DataReportInterface)this.val$serviceManager.getService(DataReportInterface.class);
  }
  
  public HostProxyInterface getHostProxy()
  {
    return (HostProxyInterface)this.val$serviceManager.getService(HostProxyInterface.class);
  }
  
  public LogInterface getLog()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.floatwindowpermission.FloatWindowPermissionBuilder.1
 * JD-Core Version:    0.7.0.1
 */