package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;

class NewFlowCameraActivity$19
  implements Runnable
{
  NewFlowCameraActivity$19(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    int i = (int)(this.this$0.a.getHeight() * 0.35F);
    ViewGroup.LayoutParams localLayoutParams = this.this$0.c.getLayoutParams();
    localLayoutParams.height = (i - this.this$0.d.getHeight());
    this.this$0.c.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.19
 * JD-Core Version:    0.7.0.1
 */