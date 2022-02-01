package com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper;
import com.tencent.mobileqq.richmedia.CompoundProcessor;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.VideoCompoundController;

class NewFlowCameraActivity$25
  implements Runnable
{
  NewFlowCameraActivity$25(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    Object localObject = RichmediaClient.a().a().a(this.this$0.d);
    if (localObject != null) {
      ((CompoundProcessor)localObject).a(103);
    }
    for (;;)
    {
      localObject = this.this$0.getIntent();
      ((Intent)localObject).putExtra("flow_back", 0);
      this.this$0.setResult(1001, (Intent)localObject);
      this.this$0.a.a();
      this.this$0.finish();
      return;
      this.this$0.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.25
 * JD-Core Version:    0.7.0.1
 */