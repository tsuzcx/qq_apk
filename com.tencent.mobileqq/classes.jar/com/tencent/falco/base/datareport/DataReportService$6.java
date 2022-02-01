package com.tencent.falco.base.datareport;

import android.content.Context;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconConfig.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;

class DataReportService$6
  implements Runnable
{
  DataReportService$6(DataReportService paramDataReportService, Context paramContext) {}
  
  public void run()
  {
    try
    {
      BeaconConfig localBeaconConfig = BeaconConfig.builder().build();
      BeaconReport localBeaconReport = BeaconReport.getInstance();
      localBeaconReport.setLogAble(false);
      localBeaconReport.setChannelID(this.this$0.adapter.getChannelId());
      localBeaconReport.setAppVersion(this.this$0.adapter.getAppVersion());
      localBeaconReport.start(this.val$context, this.this$0.adapter.getAppKey(), localBeaconConfig);
      DataReportService.access$100(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      this.this$0.adapter.getLog().printStackTrace(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.datareport.DataReportService.6
 * JD-Core Version:    0.7.0.1
 */