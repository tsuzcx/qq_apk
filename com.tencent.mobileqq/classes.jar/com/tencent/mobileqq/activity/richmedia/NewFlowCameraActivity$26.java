package com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import bali;
import balo;
import balt;
import yas;

class NewFlowCameraActivity$26
  implements Runnable
{
  NewFlowCameraActivity$26(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    Object localObject = balo.a().a().a(this.this$0.d);
    if (localObject != null) {
      ((bali)localObject).a(103);
    }
    for (;;)
    {
      localObject = this.this$0.getIntent();
      ((Intent)localObject).putExtra("flow_back", 0);
      this.this$0.setResult(1001, (Intent)localObject);
      this.this$0.a.b();
      this.this$0.finish();
      return;
      this.this$0.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.26
 * JD-Core Version:    0.7.0.1
 */