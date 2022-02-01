package com.tencent.falco.base.datareport;

import android.os.Bundle;
import android.util.Log;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.HostReportInterface;
import java.util.Map;

class DataReportService$1
  implements Runnable
{
  DataReportService$1(DataReportService paramDataReportService, Map paramMap, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.this$0.adapter.getHostProxy().getReportInterface() != null)
    {
      localObject = this.this$0.adapter.getHostProxy().getReportInterface().getHostReportData();
      if (localObject != null) {
        this.val$getParams.putAll((Map)localObject);
      }
      localObject = this.this$0.adapter.getHostProxy().getReportInterface().getHostReportData(this.val$eventName);
      if (localObject != null) {
        this.val$getParams.putAll((Map)localObject);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("anchor", (String)this.val$getParams.get("anchor"));
      localObject = this.this$0.adapter.getHostProxy().getReportInterface().getHostReportPrivateData(this.val$eventName, (Bundle)localObject);
      if (localObject != null) {
        this.val$getParams.put("zt_str6", localObject);
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("product report qimei=");
    ((StringBuilder)localObject).append(BeaconReport.getInstance().getQimei());
    ((StringBuilder)localObject).append(",adapter.getAppKey()=");
    ((StringBuilder)localObject).append(this.this$0.adapter.getAppKey());
    ((StringBuilder)localObject).append(" eventName = ");
    ((StringBuilder)localObject).append(this.val$eventName);
    Log.d("DataReportService", ((StringBuilder)localObject).toString());
    this.this$0.setBeaconLogAble();
    BeaconEvent.Builder localBuilder = BeaconEvent.builder().withCode(this.val$eventName);
    if (this.val$isRealTime) {
      localObject = EventType.REALTIME;
    } else {
      localObject = EventType.NORMAL;
    }
    localObject = localBuilder.withType((EventType)localObject).withParams(this.val$getParams).withIsSucceed(this.val$isSucceed).withAppKey(this.this$0.adapter.getAppKey());
    DataReportService.access$000(this.this$0, (BeaconEvent.Builder)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.datareport.DataReportService.1
 * JD-Core Version:    0.7.0.1
 */