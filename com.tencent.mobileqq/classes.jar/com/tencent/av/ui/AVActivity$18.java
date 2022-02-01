package com.tencent.av.ui;

import android.view.View;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AVActivity$18
  implements ActionSheet.OnButtonClickListener
{
  AVActivity$18(AVActivity paramAVActivity) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.a.M != null)
    {
      this.a.M.rotateCamera();
      this.a.M.saveCameraAngle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.18
 * JD-Core Version:    0.7.0.1
 */