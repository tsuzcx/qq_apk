package com.tencent.av.ui;

import com.tencent.av.VideoCameraListener.SwitchCameraListener;
import com.tencent.av.utils.AVTraceUtil;
import com.tencent.qphone.base.util.QLog;

class VideoLayerUI$6
  implements VideoCameraListener.SwitchCameraListener
{
  VideoLayerUI$6(VideoLayerUI paramVideoLayerUI, int paramInt, boolean paramBoolean) {}
  
  public void a()
  {
    Object localObject;
    if ((this.c.ae != null) && (this.c.ae.length > this.a))
    {
      AVTraceUtil.a("switch_camera", "onSwitchCameraFirstFrame", 3, new Object[0]);
      localObject = this.c;
      VideoLayerUI.b((VideoLayerUI)localObject, localObject.ae[this.a], this.b);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.c.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSwitchCameraFirstFrame Error : Index = ");
      localStringBuilder.append(this.a);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.6
 * JD-Core Version:    0.7.0.1
 */