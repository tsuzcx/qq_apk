package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class AEVideoStoryDashboardPart$11
  implements CompoundButton.OnCheckedChangeListener
{
  AEVideoStoryDashboardPart$11(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AEDashboardUtil.b(paramBoolean);
    QQToast.makeText(BaseApplicationImpl.getContext(), "重启相机显示切换效果", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.11
 * JD-Core Version:    0.7.0.1
 */