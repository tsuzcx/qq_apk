package com.tencent.av.opengl.effects;

import android.os.Handler;
import android.os.Message;
import com.tencent.av.avatar.IAvatar2DAIDataListener;
import com.tencent.av.camera.FrameBufMgr;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.FramePerfData;
import com.tencent.av.utils.SeqUtil;
import com.tencent.avcore.util.AVCoreLog;

public abstract class EffectRenderWrapper
  extends GLContextThread
{
  public FilterProcessRender b = null;
  protected boolean c = false;
  protected final ProcessFrameInfo d = new ProcessFrameInfo();
  protected final RenderParams e = new RenderParams();
  protected final RenderResult f = new RenderResult();
  protected CameraFrame g = null;
  
  private void b(CameraFrame paramCameraFrame)
  {
    if (this.g == paramCameraFrame) {
      this.g = null;
    }
    this.f.a();
    byte[] arrayOfByte = paramCameraFrame.a;
    if (arrayOfByte != null) {
      FrameBufMgr.a().a(arrayOfByte, 3);
    }
    a(paramCameraFrame, this.e);
    FramePerfData localFramePerfData = paramCameraFrame.k;
    localFramePerfData.e();
    FilterProcessRender localFilterProcessRender = this.b;
    if (localFilterProcessRender != null) {
      localFilterProcessRender.a(paramCameraFrame, this.e, null, this.f);
    }
    paramCameraFrame.d();
    localFramePerfData.f();
    if (arrayOfByte != null) {
      FrameBufMgr.a().a(arrayOfByte, 0);
    }
    if (this.f.a == null) {
      this.f.a = paramCameraFrame;
    }
    this.f.a.k = localFramePerfData;
    a(this.e, this.f);
  }
  
  private void c()
  {
    FilterProcessRender localFilterProcessRender = this.b;
    if (localFilterProcessRender != null) {
      localFilterProcessRender.a();
    }
  }
  
  public void a()
  {
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("EffectRenderWrapper", "uninit");
    }
    this.i.obtainMessage(5).sendToTarget();
  }
  
  public void a(long paramLong)
  {
    FilterProcessRender localFilterProcessRender = this.b;
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
      c();
      return;
    case 5: 
      k();
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
  
  public void a(IAvatar2DAIDataListener paramIAvatar2DAIDataListener)
  {
    FilterProcessRender localFilterProcessRender = this.b;
    if (localFilterProcessRender != null) {
      localFilterProcessRender.a(paramIAvatar2DAIDataListener);
    }
  }
  
  public void a(CameraFrame paramCameraFrame)
  {
    Object localObject = paramCameraFrame.n;
    int i = 1;
    if (localObject == null)
    {
      this.d.a(paramCameraFrame.a, paramCameraFrame.b, paramCameraFrame.c, paramCameraFrame.d, paramCameraFrame.e, paramCameraFrame.h, paramCameraFrame.g, paramCameraFrame.j);
      if ((paramCameraFrame.a == null) || (paramCameraFrame.b == 0) || (paramCameraFrame.c == 0)) {
        i = 0;
      }
    }
    if (i == 0)
    {
      paramCameraFrame.e();
      return;
    }
    if (this.i.hasMessages(3))
    {
      this.i.removeMessages(3);
      localObject = this.g;
      if ((localObject == null) || (localObject == paramCameraFrame)) {}
    }
    try
    {
      ((CameraFrame)localObject).e();
      label125:
      this.g = null;
      if (paramCameraFrame.a != null) {
        FrameBufMgr.a().a(2, 0);
      }
      if (paramCameraFrame.a != null) {
        FrameBufMgr.a().a(paramCameraFrame.a, 2);
      }
      this.g = paramCameraFrame;
      this.i.obtainMessage(3, paramCameraFrame).sendToTarget();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label125;
    }
  }
  
  protected abstract void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams);
  
  protected abstract void a(RenderParams paramRenderParams, RenderResult paramRenderResult);
  
  public void b(long paramLong)
  {
    Message localMessage = this.i.obtainMessage(4);
    localMessage.obj = Long.valueOf(paramLong);
    localMessage.sendToTarget();
  }
  
  protected void c(long paramLong)
  {
    if (AVCoreLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initInGL, isInitial[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("], loadPtvSo[");
      ((StringBuilder)localObject).append(GraphicRenderMgr.soloadedPTV);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      AVCoreLog.i("EffectRenderWrapper", ((StringBuilder)localObject).toString());
    }
    if (this.c) {
      return;
    }
    this.c = true;
    super.g();
    Object localObject = this.b;
    if (localObject != null) {
      ((FilterProcessRender)localObject).a(paramLong, l());
    }
  }
  
  protected void d(long paramLong)
  {
    if (!this.c) {
      return;
    }
    this.c = false;
    if (AVCoreLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("terminateInGL, seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      AVCoreLog.i("EffectRenderWrapper", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((FilterProcessRender)localObject).b(paramLong);
    }
    super.h();
  }
  
  protected void e(long paramLong)
  {
    FilterProcessRender localFilterProcessRender = this.b;
    if (localFilterProcessRender != null) {
      localFilterProcessRender.a(paramLong, l());
    }
  }
  
  public void g()
  {
    Message localMessage = this.i.obtainMessage(1);
    localMessage.obj = Long.valueOf(AudioHelper.c());
    localMessage.sendToTarget();
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("SurfaceTag", "Effect-init");
    }
  }
  
  public void h()
  {
    Message localMessage = this.i.obtainMessage(2);
    localMessage.obj = Long.valueOf(AudioHelper.c());
    localMessage.sendToTarget();
  }
  
  public void j()
  {
    this.i.obtainMessage(6).sendToTarget();
  }
  
  protected void k()
  {
    if (AVCoreLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unInitInGL, p[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("]");
      AVCoreLog.i("EffectRenderWrapper", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((FilterProcessRender)localObject).b();
    }
  }
  
  protected int l()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectRenderWrapper
 * JD-Core Version:    0.7.0.1
 */