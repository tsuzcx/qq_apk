package com.tencent.falco.base.datareport;

import android.util.Log;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import java.util.Map;

class DataReportService$2
  implements Runnable
{
  DataReportService$2(DataReportService paramDataReportService, String paramString, boolean paramBoolean, Map paramMap) {}
  
  public void run()
  {
    Log.d("DataReportService", "product report qimei=" + BeaconReport.getInstance().getQimei() + ",adapter.getAppKey()=" + this.this$0.adapter.getAppKey() + " eventName = " + this.val$eventName);
    this.this$0.setBeaconLogAble();
    BeaconEvent.Builder localBuilder = BeaconEvent.builder().withCode(this.val$eventName);
    if (this.val$realTime) {}
    for (Object localObject = EventType.REALTIME;; localObject = EventType.NORMAL)
    {
      localObject = localBuilder.withType((EventType)localObject).withParams(this.val$getParams).withIsSucceed(true).withAppKey(this.this$0.adapter.getAppKey());
      DataReportService.access$000(this.this$0, (BeaconEvent.Builder)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.datareport.DataReportService.2
 * JD-Core Version:    0.7.0.1
 */