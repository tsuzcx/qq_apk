package com.tencent.av;

import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.camera.AndroidCamera.CameraPreviewCallback;
import com.tencent.av.camera.FrameBufMgr;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.CameraFrame;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.perfstat.MemoryPerfStat;
import com.tencent.av.utils.FramePerfData;
import com.tencent.qphone.base.util.QLog;

public abstract class CameraDataProcess
  implements AndroidCamera.CameraPreviewCallback
{
  protected int a;
  private EffectController jdField_a_of_type_ComTencentAvOpenglEffectsEffectController = null;
  protected FramePerfData a;
  protected boolean a;
  private float[] jdField_a_of_type_ArrayOfFloat;
  
  public CameraDataProcess()
  {
    this.jdField_a_of_type_ComTencentAvUtilsFramePerfData = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    int i;
    if ((this.jdField_a_of_type_Int <= 30) && (!this.jdField_a_of_type_Boolean)) {
      i = 0;
    }
    for (;;)
    {
      if ((i > 10) || (paramArrayOfByte[((int)(java.lang.Math.random() * paramArrayOfByte.length))] != 0))
      {
        if (i < 10) {
          this.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Int += 1;
        if ((this.jdField_a_of_type_Int == 30) && (!this.jdField_a_of_type_Boolean)) {
          a();
        }
        return;
      }
      i += 1;
    }
  }
  
  public abstract void a();
  
  public void a(CameraFrame paramCameraFrame)
  {
    if (paramCameraFrame.a())
    {
      paramCameraFrame.b();
      if (QLog.isColorLevel()) {
        QLog.e("OnPreviewData", 2, "onPreviewData data is null");
      }
      return;
    }
    if (paramCameraFrame.jdField_a_of_type_ArrayOfByte != null) {
      a(paramCameraFrame.jdField_a_of_type_ArrayOfByte);
    }
    if ((paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) && (this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectController == null)) {
      b();
    }
    FramePerfData localFramePerfData;
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectController != null)
    {
      if ((this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectController.a()) || (paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)) {}
      for (bool = true;; bool = false)
      {
        localFramePerfData = null;
        if (FramePerfData.a())
        {
          localFramePerfData = new FramePerfData(this.jdField_a_of_type_ComTencentAvUtilsFramePerfData, paramCameraFrame.jdField_c_of_type_Long);
          localFramePerfData.a(paramCameraFrame.a(), paramCameraFrame.jdField_a_of_type_Int, paramCameraFrame.b, paramCameraFrame.jdField_c_of_type_Int, paramCameraFrame.d, paramCameraFrame.e, paramCameraFrame.jdField_a_of_type_Long, paramCameraFrame.jdField_a_of_type_Boolean, bool);
          localFramePerfData.b();
        }
        this.jdField_a_of_type_ComTencentAvUtilsFramePerfData = localFramePerfData;
        if (!bool) {
          break label211;
        }
        paramCameraFrame.jdField_a_of_type_ComTencentAvUtilsFramePerfData = localFramePerfData;
        if (this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectController == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectController.a(paramCameraFrame);
        return;
      }
    }
    if (paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false) {
      break;
    }
    paramCameraFrame.b();
    return;
    label211:
    if (localFramePerfData != null) {
      localFramePerfData.f();
    }
    GraphicRenderMgr.getInstance().sendCameraFrame(paramCameraFrame.jdField_a_of_type_ArrayOfByte, AndroidCamera.jdField_c_of_type_Int, paramCameraFrame.jdField_a_of_type_Int, paramCameraFrame.b, paramCameraFrame.d, paramCameraFrame.e, System.currentTimeMillis(), paramCameraFrame.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfFloat, null, 0, 0);
    FrameBufMgr.a().a(paramCameraFrame.jdField_a_of_type_ArrayOfByte, 0);
    MemoryPerfStat.a().a(0);
    paramCameraFrame.b();
  }
  
  public void a(EffectController paramEffectController)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraDataProcess", 2, "setEffects, effects[" + paramEffectController + "]");
    }
    this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectController = paramEffectController;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
  }
  
  public float[] a()
  {
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.CameraDataProcess
 * JD-Core Version:    0.7.0.1
 */