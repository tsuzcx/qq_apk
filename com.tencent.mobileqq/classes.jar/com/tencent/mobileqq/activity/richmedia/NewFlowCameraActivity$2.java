package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class NewFlowCameraActivity$2
  implements NewFlowCameraActivity.VideoProcessListener
{
  NewFlowCameraActivity$2(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (this.a.q == 10011)
    {
      NewFlowCameraActivity.a(this.a, paramString1);
      return;
    }
    if (paramBoolean)
    {
      NewFlowCameraActivity.b(this.a, paramString1);
      return;
    }
    this.a.i(true);
    QQToast.a(this.a, HardCodeUtil.a(2131707491), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.2
 * JD-Core Version:    0.7.0.1
 */