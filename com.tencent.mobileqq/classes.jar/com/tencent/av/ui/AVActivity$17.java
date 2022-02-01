package com.tencent.av.ui;

import android.view.View;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AVActivity$17
  implements ActionSheet.OnButtonClickListener
{
  AVActivity$17(AVActivity paramAVActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.a != null)
    {
      this.a.a.rotateCamera();
      this.a.a.saveCameraAngle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.17
 * JD-Core Version:    0.7.0.1
 */