package com.tencent.camerasdk.avreport;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class AVReportCenter$2
  implements Runnable
{
  AVReportCenter$2(AVReportCenter paramAVReportCenter, BaseBean paramBaseBean, Boolean paramBoolean) {}
  
  public void run()
  {
    if (AVReportCenter.access$200(this.this$0) == null) {
      AVReportCenter.access$202(this.this$0, new Reporter(new File(AVReportCenter.access$000(this.this$0)), AVReportCenter.access$300(this.this$0)));
    }
    Object localObject = this.val$bean.extractReportData(this.val$explicit);
    ((HashMap)localObject).put("device", DeviceInfo.getBrand() + " + " + DeviceInfo.getDeviceName());
    ((HashMap)localObject).put("device_id", AVReportCenter.access$400(this.this$0));
    ((HashMap)localObject).put("platform", "and");
    ((HashMap)localObject).put("os", AVReportCenter.access$500(this.this$0));
    ((HashMap)localObject).put("appid", AVReportCenter.access$600(this.this$0));
    ((HashMap)localObject).put("_dc", Integer.valueOf(Math.abs(new Random().nextInt())));
    localObject = AVReportCenter.access$700((Map)localObject);
    AVReportCenter.access$800(this.this$0, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.AVReportCenter.2
 * JD-Core Version:    0.7.0.1
 */