package com.tencent.av.camera;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.qphone.base.util.QLog;

class VcCamera$1
  implements Camera.AutoFocusCallback
{
  VcCamera$1(VcCamera paramVcCamera) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AndroidCamera", 2, "camera focus success ? " + paramBoolean);
    }
    GraphicRenderMgr.getInstance().setIsFocusing(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.camera.VcCamera.1
 * JD-Core Version:    0.7.0.1
 */