package com.tencent.falco.base.datareport;

import android.util.Log;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import java.util.Map;

class DataReportService$3
  implements Runnable
{
  DataReportService$3(DataReportService paramDataReportService, String paramString, boolean paramBoolean, Map paramMap) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("product report qimei=");
    ((StringBuilder)localObject).append(BeaconReport.getInstance().getQimei());
    ((StringBuilder)localObject).append(",adapter.getAppKey()=");
    ((StringBuilder)localObject).append(this.this$0.adapter.getAppKey());
    ((StringBuilder)localObject).append(" eventName = ");
    ((StringBuilder)localObject).append(this.val$eventName);
    Log.d("DataReportService", ((StringBuilder)localObject).toString());
    BeaconEvent.Builder localBuilder = BeaconEvent.builder().withCode(this.val$eventName);
    if (this.val$realTime) {
      localObject = EventType.REALTIME;
    } else {
      localObject = EventType.NORMAL;
    }
    localObject = localBuilder.withType((EventType)localObject).withParams(this.val$getParams).withIsSucceed(true).withAppKey(this.this$0.adapter.getAppKey());
    this.this$0.setBeaconLogAble();
    DataReportService.access$000(this.this$0, (BeaconEvent.Builder)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.datareport.DataReportService.3
 * JD-Core Version:    0.7.0.1
 */