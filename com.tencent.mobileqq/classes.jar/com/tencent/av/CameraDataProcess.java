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
  protected FramePerfData a = null;
  protected int b = 0;
  protected boolean c = false;
  private float[] d;
  private EffectController e = null;
  
  private void a(byte[] paramArrayOfByte)
  {
    if ((this.b <= 30) && (!this.c))
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
        this.c = true;
      }
      this.b += 1;
    }
    if ((this.b == 30) && (!this.c)) {
      b();
    }
  }
  
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
    this.e = paramEffectController;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.d = paramArrayOfFloat;
  }
  
  public float[] a()
  {
    return this.d;
  }
  
  public abstract void b();
  
  public abstract void c();
  
  public void onPreviewData(CameraFrame paramCameraFrame)
  {
    if (paramCameraFrame.a())
    {
      paramCameraFrame.e();
      if (QLog.isColorLevel()) {
        QLog.e("OnPreviewData", 2, "onPreviewData data is null");
      }
      return;
    }
    if (paramCameraFrame.a != null) {
      a(paramCameraFrame.a);
    }
    if ((paramCameraFrame.n != null) && (this.e == null)) {
      c();
    }
    Object localObject = this.e;
    boolean bool2 = true;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((EffectController)localObject).b()) {
        break label110;
      }
      if (paramCameraFrame.n != null)
      {
        bool1 = bool2;
        break label110;
      }
    }
    while (paramCameraFrame.n == null)
    {
      bool1 = false;
      break;
    }
    boolean bool1 = bool2;
    label110:
    localObject = null;
    if (FramePerfData.a())
    {
      localObject = new FramePerfData(this.a, paramCameraFrame.j);
      ((FramePerfData)localObject).a(paramCameraFrame.b(), paramCameraFrame.b, paramCameraFrame.c, paramCameraFrame.d, paramCameraFrame.e, paramCameraFrame.f, paramCameraFrame.h, paramCameraFrame.g, bool1);
      ((FramePerfData)localObject).d();
    }
    this.a = ((FramePerfData)localObject);
    if (bool1)
    {
      paramCameraFrame.k = ((FramePerfData)localObject);
      localObject = this.e;
      if (localObject != null)
      {
        ((EffectController)localObject).a(paramCameraFrame);
        return;
      }
      paramCameraFrame.e();
      return;
    }
    if (localObject != null) {
      ((FramePerfData)localObject).g();
    }
    GraphicRenderMgr.getInstance().sendCameraFrame(paramCameraFrame.a, AndroidCamera.d, paramCameraFrame.b, paramCameraFrame.c, paramCameraFrame.e, paramCameraFrame.f, System.currentTimeMillis(), paramCameraFrame.g, this.d, null, 0, 0);
    FrameBufMgr.a().a(paramCameraFrame.a, 0);
    MemoryPerfStat.a().a(0);
    paramCameraFrame.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.CameraDataProcess
 * JD-Core Version:    0.7.0.1
 */