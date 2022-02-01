package com.tencent.falco.base.libapi.hostproxy;

import android.os.Bundle;
import java.util.Map;

public abstract interface HostReportInterface
{
  public abstract Map<String, String> getHostReportData();
  
  public abstract Map<String, String> getHostReportData(String paramString);
  
  public abstract String getHostReportPrivateData(String paramString, Bundle paramBundle);
  
  public abstract boolean isBeaconRealTimeDebug();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.hostproxy.HostReportInterface
 * JD-Core Version:    0.7.0.1
 */