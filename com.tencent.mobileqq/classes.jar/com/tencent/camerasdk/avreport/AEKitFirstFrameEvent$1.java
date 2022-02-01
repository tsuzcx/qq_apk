package com.tencent.camerasdk.avreport;

class AEKitFirstFrameEvent$1
  implements Runnable
{
  AEKitFirstFrameEvent$1(AEKitFirstFrameEvent paramAEKitFirstFrameEvent) {}
  
  public void run()
  {
    AEKitBean localAEKitBean = new AEKitBean(AEKitReportEvent.PREVIEW_FIRST_FRAME.value);
    localAEKitBean.ext_int1 = Integer.valueOf(AEKitFirstFrameEvent.access$000(this.this$0));
    localAEKitBean.ext_int2 = Integer.valueOf(AEKitFirstFrameEvent.access$100(this.this$0));
    localAEKitBean.ext_str1 = AEKitFirstFrameEvent.access$200(this.this$0);
    AEKitFirstFrameEvent.access$300(this.this$0);
    AVReportCenter.getInstance().commit(localAEKitBean, Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.AEKitFirstFrameEvent.1
 * JD-Core Version:    0.7.0.1
 */