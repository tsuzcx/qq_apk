package com.tencent.av.camera;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.api.IGraphicRender;
import com.tencent.qphone.base.util.QLog;

class VcCamera$1
  implements Camera.AutoFocusCallback
{
  VcCamera$1(VcCamera paramVcCamera) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel())
    {
      paramCamera = new StringBuilder();
      paramCamera.append("camera focus success ? ");
      paramCamera.append(paramBoolean);
      QLog.d("AndroidCamera", 2, paramCamera.toString());
    }
    GraphicRenderMgr.getInstance().setIsFocusing(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.VcCamera.1
 * JD-Core Version:    0.7.0.1
 */