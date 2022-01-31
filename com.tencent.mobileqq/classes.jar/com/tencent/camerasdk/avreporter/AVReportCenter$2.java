package com.tencent.camerasdk.avreporter;

import java.io.File;
import java.util.HashMap;

class AVReportCenter$2
  implements Runnable
{
  AVReportCenter$2(AVReportCenter paramAVReportCenter, BaseBean paramBaseBean, Boolean paramBoolean) {}
  
  public void run()
  {
    if (AVReportCenter.access$200(this.this$0) == null) {
      AVReportCenter.access$202(this.this$0, new Reporter(new File(AVReportCenter.access$000(this.this$0)), AVReportCenter.access$300(this.this$0)));
    }
    HashMap localHashMap = this.val$bean.extractReportData(this.val$explicit);
    AVReportCenter.access$400(this.this$0, localHashMap);
    AVReportCenter.access$500(this.this$0, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.camerasdk.avreporter.AVReportCenter.2
 * JD-Core Version:    0.7.0.1
 */