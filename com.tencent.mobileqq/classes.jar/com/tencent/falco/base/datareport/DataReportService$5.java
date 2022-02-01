package com.tencent.falco.base.datareport;

import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;

class DataReportService$5
  implements IAsyncQimeiListener
{
  DataReportService$5(DataReportService paramDataReportService) {}
  
  public void onQimeiDispatch(Qimei paramQimei)
  {
    paramQimei = paramQimei.getQimeiOld();
    LogInterface localLogInterface = this.this$0.adapter.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate end sync get qImei=");
    localStringBuilder.append(paramQimei);
    localLogInterface.i("DataReportService", localStringBuilder.toString(), new Object[0]);
    this.this$0.adapter.onGetBeaconImei(paramQimei);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.datareport.DataReportService.5
 * JD-Core Version:    0.7.0.1
 */