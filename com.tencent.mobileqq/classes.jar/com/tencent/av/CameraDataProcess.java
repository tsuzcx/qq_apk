package com.tencent.av;

import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.camera.CameraPreviewCallback;
import com.tencent.av.camera.FrameBufMgr;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.api.IGraphicRender;
import com.tencent.av.opengl.effects.CameraFrame;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.perfstat.MemoryPerfStat;
import com.tencent.av.utils.FramePerfData;
import com.tencent.qphone.base.util.QLog;

public abstract class CameraDataProcess
  implements CameraPreviewCallback
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
    if ((this.jdField_a_of_type_Int <= 30) && (!this.jdField_a_of_type_Boolean))
    {
      int i = 0;
      while (i <= 10)
      {
        double d1 = Math.random();
        double d2 = paramArrayOfByte.length;
        Double.isNaN(d2);
        if (paramArrayOfByte[((int)(d1 * d2))] != 0) {
          break;
        }
        i += 1;
      }
      if (i < 10) {
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Int += 1;
    }
    if ((this.jdField_a_of_type_Int == 30) && (!this.jdField_a_of_type_Boolean)) {
      a();
    }
  }
  
  public abstract void a();
  
  public void a(EffectController paramEffectController)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setEffects, effects[");
      localStringBuilder.append(paramEffectController);
      localStringBuilder.append("]");
      QLog.i("CameraDataProcess", 2, localStringBuilder.toString());
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
  
  public void onPreviewData(CameraFrame paramCameraFrame)
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
    Object localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectController;
    boolean bool2 = true;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((EffectController)localObject).a()) {
        break label110;
      }
      if (paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        bool1 = bool2;
        break label110;
      }
    }
    while (paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null)
    {
      bool1 = false;
      break;
    }
    boolean bool1 = bool2;
    label110:
    localObject = null;
    if (FramePerfData.a())
    {
      localObject = new FramePerfData(this.jdField_a_of_type_ComTencentAvUtilsFramePerfData, paramCameraFrame.jdField_c_of_type_Long);
      ((FramePerfData)localObject).a(paramCameraFrame.a(), paramCameraFrame.jdField_a_of_type_Int, paramCameraFrame.b, paramCameraFrame.jdField_c_of_type_Int, paramCameraFrame.d, paramCameraFrame.e, paramCameraFrame.jdField_a_of_type_Long, paramCameraFrame.jdField_a_of_type_Boolean, bool1);
      ((FramePerfData)localObject).b();
    }
    this.jdField_a_of_type_ComTencentAvUtilsFramePerfData = ((FramePerfData)localObject);
    if (bool1)
    {
      paramCameraFrame.jdField_a_of_type_ComTencentAvUtilsFramePerfData = ((FramePerfData)localObject);
      localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsEffectController;
      if (localObject != null)
      {
        ((EffectController)localObject).a(paramCameraFrame);
        return;
      }
      paramCameraFrame.b();
      return;
    }
    if (localObject != null) {
      ((FramePerfData)localObject).e();
    }
    GraphicRenderMgr.getInstance().sendCameraFrame(paramCameraFrame.jdField_a_of_type_ArrayOfByte, AndroidCamera.jdField_c_of_type_Int, paramCameraFrame.jdField_a_of_type_Int, paramCameraFrame.b, paramCameraFrame.d, paramCameraFrame.e, System.currentTimeMillis(), paramCameraFrame.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfFloat, null, 0, 0);
    FrameBufMgr.a().a(paramCameraFrame.jdField_a_of_type_ArrayOfByte, 0);
    MemoryPerfStat.a().a(0);
    paramCameraFrame.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.CameraDataProcess
 * JD-Core Version:    0.7.0.1
 */