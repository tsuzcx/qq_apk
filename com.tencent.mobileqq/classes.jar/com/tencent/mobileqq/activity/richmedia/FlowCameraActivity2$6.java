package com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import bbeb;
import bbeh;
import bbem;

class FlowCameraActivity2$6
  implements Runnable
{
  FlowCameraActivity2$6(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void run()
  {
    Object localObject = bbeh.a().a().a(this.this$0.a);
    if (localObject != null) {
      ((bbeb)localObject).a(103);
    }
    for (;;)
    {
      localObject = this.this$0.getIntent();
      ((Intent)localObject).putExtra("flow_back", 0);
      this.this$0.setResult(1001, (Intent)localObject);
      this.this$0.finish();
      return;
      this.this$0.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.6
 * JD-Core Version:    0.7.0.1
 */