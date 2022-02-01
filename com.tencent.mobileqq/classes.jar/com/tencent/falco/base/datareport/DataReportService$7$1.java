package com.tencent.falco.base.datareport;

import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;

class DataReportService$7$1
  implements IAsyncQimeiListener
{
  DataReportService$7$1(DataReportService.7 param7) {}
  
  public void onQimeiDispatch(Qimei paramQimei)
  {
    paramQimei = paramQimei.getQimeiOld();
    this.a.this$0.adapter.getLog().i("DataReportService", "onCreate end sync get qImei=" + paramQimei, new Object[0]);
    this.a.this$0.adapter.onGetBeaconImei(paramQimei);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.datareport.DataReportService.7.1
 * JD-Core Version:    0.7.0.1
 */