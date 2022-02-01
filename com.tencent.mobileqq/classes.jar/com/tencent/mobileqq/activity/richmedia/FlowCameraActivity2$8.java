package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.concurrent.atomic.AtomicInteger;

class FlowCameraActivity2$8
  implements ActionSheet.OnButtonClickListener
{
  FlowCameraActivity2$8(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.a.a.b.get() == 4) {
      this.a.a(false);
    }
    this.a.a.a("FlowCameraActivity");
    this.a.b();
    FlowCameraMqqAction.b("", "0X800656F", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.8
 * JD-Core Version:    0.7.0.1
 */