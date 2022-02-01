package com.tencent.av.opengl.effects;

import android.os.Handler;
import android.os.Message;
import com.tencent.av.camera.FrameBufMgr;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.FramePerfData;
import com.tencent.av.utils.SeqUtil;
import com.tencent.avcore.util.AVCoreLog;

public abstract class EffectRenderWrapper
  extends GLContextThread
{
  protected CameraFrame a;
  public FilterProcessRender a;
  protected final ProcessFrameInfo a;
  protected final RenderParams a;
  protected final RenderResult a;
  protected boolean a;
  
  public EffectRenderWrapper()
  {
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvOpenglEffectsProcessFrameInfo = new ProcessFrameInfo();
    this.jdField_a_of_type_ComTencentAvOpenglEffectsRenderParams = new RenderParams();
    this.jdField_a_of_type_ComTencentAvOpenglEffectsRenderResult = new RenderResult();
    this.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame = null;
  }
  
  private void b(CameraFrame paramCameraFrame)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame == paramCameraFrame) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame = null;
    }
    this.jdField_a_of_type_ComTencentAvOpenglEffectsRenderResult.a();
    byte[] arrayOfByte = paramCameraFrame.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte != null) {
      FrameBufMgr.a().a(arrayOfByte, 3);
    }
    a(paramCameraFrame, this.jdField_a_of_type_ComTencentAvOpenglEffectsRenderParams);
    FramePerfData localFramePerfData = paramCameraFrame.jdField_a_of_type_ComTencentAvUtilsFramePerfData;
    localFramePerfData.c();
    FilterProcessRender localFilterProcessRender = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender;
    if (localFilterProcessRender != null) {
      localFilterProcessRender.a(paramCameraFrame, this.jdField_a_of_type_ComTencentAvOpenglEffectsRenderParams, null, this.jdField_a_of_type_ComTencentAvOpenglEffectsRenderResult);
    }
    paramCameraFrame.a();
    localFramePerfData.d();
    if (arrayOfByte != null) {
      FrameBufMgr.a().a(arrayOfByte, 0);
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsRenderResult.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame == null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsRenderResult.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame = paramCameraFrame;
    }
    this.jdField_a_of_type_ComTencentAvOpenglEffectsRenderResult.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame.jdField_a_of_type_ComTencentAvUtilsFramePerfData = localFramePerfData;
    a(this.jdField_a_of_type_ComTencentAvOpenglEffectsRenderParams, this.jdField_a_of_type_ComTencentAvOpenglEffectsRenderResult);
  }
  
  private void g()
  {
    FilterProcessRender localFilterProcessRender = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender;
    if (localFilterProcessRender != null) {
      localFilterProcessRender.a();
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  public void a()
  {
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("EffectRenderWrapper", "uninit");
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5).sendToTarget();
  }
  
  public void a(long paramLong)
  {
    FilterProcessRender localFilterProcessRender = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender;
    if (localFilterProcessRender != null) {
      localFilterProcessRender.a(paramLong);
    }
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 6: 
      g();
      return;
    case 5: 
      e();
      return;
    case 4: 
      e(SeqUtil.a(paramMessage.obj));
      return;
    case 3: 
      b((CameraFrame)paramMessage.obj);
      return;
    case 2: 
      d(SeqUtil.a(paramMessage.obj));
      return;
    }
    c(SeqUtil.a(paramMessage.obj));
  }
  
  public void a(CameraFrame paramCameraFrame)
  {
    Object localObject = paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    int i = 1;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsProcessFrameInfo.a(paramCameraFrame.jdField_a_of_type_ArrayOfByte, paramCameraFrame.jdField_a_of_type_Int, paramCameraFrame.b, paramCameraFrame.jdField_c_of_type_Int, paramCameraFrame.d, paramCameraFrame.jdField_a_of_type_Long, paramCameraFrame.jdField_a_of_type_Boolean, paramCameraFrame.jdField_c_of_type_Long);
      if ((paramCameraFrame.jdField_a_of_type_ArrayOfByte == null) || (paramCameraFrame.jdField_a_of_type_Int == 0) || (paramCameraFrame.b == 0)) {
        i = 0;
      }
    }
    if (i == 0)
    {
      paramCameraFrame.b();
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(3))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame;
      if ((localObject == null) || (localObject == paramCameraFrame)) {}
    }
    try
    {
      ((CameraFrame)localObject).b();
      label125:
      this.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame = null;
      if (paramCameraFrame.jdField_a_of_type_ArrayOfByte != null) {
        FrameBufMgr.a().a(2, 0);
      }
      if (paramCameraFrame.jdField_a_of_type_ArrayOfByte != null) {
        FrameBufMgr.a().a(paramCameraFrame.jdField_a_of_type_ArrayOfByte, 2);
      }
      this.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame = paramCameraFrame;
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramCameraFrame).sendToTarget();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label125;
    }
  }
  
  protected abstract void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams);
  
  protected abstract void a(RenderParams paramRenderParams, RenderResult paramRenderResult);
  
  public void b()
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.obj = Long.valueOf(AudioHelper.b());
    localMessage.sendToTarget();
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("SurfaceTag", "Effect-init");
    }
  }
  
  public void b(long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.sendToTarget();
  }
  
  public void c()
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = Long.valueOf(AudioHelper.b());
    localMessage.sendToTarget();
  }
  
  protected void c(long paramLong)
  {
    if (AVCoreLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initInGL, isInitial[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("], loadPtvSo[");
      ((StringBuilder)localObject).append(GraphicRenderMgr.soloadedPTV);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      AVCoreLog.i("EffectRenderWrapper", ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    super.b();
    Object localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender;
    if (localObject != null) {
      ((FilterProcessRender)localObject).a(paramLong, a());
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6).sendToTarget();
  }
  
  protected void d(long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (AVCoreLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("terminateInGL, seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      AVCoreLog.i("EffectRenderWrapper", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender;
    if (localObject != null) {
      ((FilterProcessRender)localObject).b(paramLong);
    }
    super.c();
  }
  
  protected void e()
  {
    if (AVCoreLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unInitInGL, p[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender);
      ((StringBuilder)localObject).append("]");
      AVCoreLog.i("EffectRenderWrapper", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender;
    if (localObject != null) {
      ((FilterProcessRender)localObject).b();
    }
  }
  
  protected void e(long paramLong)
  {
    FilterProcessRender localFilterProcessRender = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender;
    if (localFilterProcessRender != null) {
      localFilterProcessRender.a(paramLong, a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectRenderWrapper
 * JD-Core Version:    0.7.0.1
 */