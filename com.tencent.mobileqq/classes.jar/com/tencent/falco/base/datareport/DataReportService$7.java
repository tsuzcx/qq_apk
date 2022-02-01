package com.tencent.falco.base.datareport;

import com.tencent.beacon.event.open.BeaconReport;

class DataReportService$7
  implements Runnable
{
  DataReportService$7(DataReportService paramDataReportService) {}
  
  public void run()
  {
    BeaconReport.getInstance().getQimei(new DataReportService.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.datareport.DataReportService.7
 * JD-Core Version:    0.7.0.1
 */