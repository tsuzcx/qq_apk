package com.tencent.av.opengl.effects;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.view.Surface;
import com.tencent.avcore.data.RecordParam;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;

public class EGLScreenCaptureThread
  extends GLContextThread
  implements SurfaceTexture.OnFrameAvailableListener
{
  private long A = 0L;
  private long B = 0L;
  private final int a = 1;
  private final int b = 2;
  private final int c = 3;
  private boolean d = false;
  private Surface e;
  private int f;
  private SurfaceTexture g;
  private float[] h;
  private float j = -1.0F;
  private int k;
  private int l;
  private RenderBuffer m;
  private TextureRender n;
  private float[] o;
  private RenderBuffer p = null;
  private ByteBuffer q = null;
  private byte[] r = null;
  private RGBToI420Filter s = null;
  private boolean t = true;
  private int u = 100;
  private EGLScreenCaptureThread.onVideoFrameAvailableListener v;
  private final RecordParam w = new RecordParam();
  private final RecordParam x = new RecordParam();
  private final EGLScreenCaptureThread.PerfData y = new EGLScreenCaptureThread.PerfData();
  private long z = 0L;
  
  @RequiresApi(api=21)
  private void d()
  {
    this.f = GlUtil.createTexture(36197);
    GLES20.glBindTexture(36197, 0);
    this.g = new SurfaceTexture(this.f);
    this.g.setOnFrameAvailableListener(this, b());
    this.g.setDefaultBufferSize(this.k, this.l);
    this.e = new Surface(this.g);
    this.n = new TextureRender();
    this.d = true;
    this.A = 0L;
    this.z = 0L;
    this.B = 0L;
    this.y.a();
    if (QLog.isColorLevel()) {
      QLog.i("EGLScreenCaptureThread", 2, "initGLEnv");
    }
  }
  
  private void e()
  {
    this.d = false;
    this.i.removeMessages(3);
    Object localObject = this.n;
    if (localObject != null)
    {
      ((TextureRender)localObject).release();
      this.n = null;
    }
    localObject = this.m;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.p;
    if (localObject != null)
    {
      ((RenderBuffer)localObject).destroy();
      this.p = null;
    }
    localObject = this.s;
    if (localObject != null)
    {
      ((RGBToI420Filter)localObject).c();
      this.s = null;
    }
    this.y.b();
    this.A = 0L;
    this.z = 0L;
    this.B = 0L;
    if (QLog.isColorLevel()) {
      QLog.i("EGLScreenCaptureThread", 2, "releaseGLEnv");
    }
  }
  
  private void f()
  {
    if (!this.d) {
      return;
    }
    if ((!this.x.isValid()) && (!this.w.isValid()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("EGLScreenCaptureThread", 4, "check, param not valid.");
      }
    }
    else {
      j();
    }
    this.i.removeMessages(3);
    this.i.sendEmptyMessageDelayed(3, 2000L);
  }
  
  private void i()
  {
    boolean bool = this.w.update(this.x);
    RenderBuffer localRenderBuffer;
    if ((this.m == null) || (bool))
    {
      localRenderBuffer = this.m;
      if (localRenderBuffer != null) {
        localRenderBuffer.destroy();
      }
      this.m = new RenderBuffer(this.w.width, this.w.height, 33984);
    }
    if (this.t)
    {
      if ((this.p == null) || (bool))
      {
        localRenderBuffer = this.p;
        if (localRenderBuffer != null) {
          localRenderBuffer.destroy();
        }
        this.p = new RenderBuffer(this.w.width, this.w.height, 33985);
      }
      if (this.s == null)
      {
        this.s = new RGBToI420Filter();
        this.s.b();
      }
      if (bool) {
        this.s.a(this.w.width, this.w.height);
      }
      if ((this.q == null) || (bool)) {
        this.q = ByteBuffer.allocate(this.w.width * this.w.height * 3 / 2);
      }
    }
    if ((this.r == null) || (bool)) {
      this.r = new byte[this.w.width * this.w.height * 3 / 2];
    }
  }
  
  private void j()
  {
    long l5 = SystemClock.elapsedRealtime();
    i();
    this.m.bind();
    if (this.o == null)
    {
      this.o = GPUBaseFilter.caculateCenterCropMvpMatrix(this.k, this.l, this.w.width, this.w.height);
      Matrix.scaleM(this.o, 0, 1.0F, -1.0F, 1.0F);
    }
    this.n.drawTexture(36197, this.f, this.h, this.o);
    this.m.unbind();
    long l6 = Math.abs(SystemClock.elapsedRealtime() - l5);
    long l1;
    long l2;
    Object localObject;
    long l3;
    if (this.t)
    {
      l1 = SystemClock.elapsedRealtime();
      this.p.bind();
      this.s.a(this.m.getTexId());
      l2 = Math.abs(SystemClock.elapsedRealtime() - l1);
      l1 = SystemClock.elapsedRealtime();
      GLES20.glReadPixels(0, 0, this.w.width, this.w.height * 3 / 8, 6408, 5121, this.q);
      this.p.unbind();
      l4 = Math.abs(SystemClock.elapsedRealtime() - l1);
      this.q.get(this.r, 0, this.w.width * this.w.height * 3 / 2);
      this.q.clear();
      localObject = this.v;
      if (localObject != null)
      {
        l1 = SystemClock.elapsedRealtime();
        ((EGLScreenCaptureThread.onVideoFrameAvailableListener)localObject).a(this.r, this.u, 2, this.w);
        l1 = SystemClock.elapsedRealtime() - l1;
      }
      else
      {
        l1 = 0L;
      }
      l3 = l1;
      l1 = l2;
      l2 = l4;
    }
    else
    {
      localObject = GlUtil.captureFrame(this.m.getTexId(), this.w.width, this.w.height, 0);
      EGLScreenCaptureThread.onVideoFrameAvailableListener localonVideoFrameAvailableListener = this.v;
      if (localonVideoFrameAvailableListener != null)
      {
        l1 = SystemClock.elapsedRealtime();
        localonVideoFrameAvailableListener.a((Bitmap)localObject, this.w);
        l3 = SystemClock.elapsedRealtime() - l1;
        l1 = 0L;
        l2 = l1;
      }
      else
      {
        l1 = 0L;
        l2 = l1;
        l3 = l2;
      }
    }
    this.B = SystemClock.elapsedRealtime();
    long l4 = this.B;
    this.y.a(l6, l1, l2, l3, l4 - l5);
  }
  
  public void a()
  {
    this.i.sendEmptyMessage(1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
  }
  
  @RequiresApi(api=21)
  public void a(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        f();
        return;
      }
      e();
      n();
      return;
    }
    g();
    d();
  }
  
  public void a(EGLScreenCaptureThread.onVideoFrameAvailableListener paramonVideoFrameAvailableListener)
  {
    this.v = paramonVideoFrameAvailableListener;
  }
  
  public void a(RecordParam paramRecordParam)
  {
    if (paramRecordParam != null)
    {
      if (!paramRecordParam.isValid()) {
        return;
      }
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateRecordParam cur[");
        localStringBuilder.append(this.x);
        localStringBuilder.append("], come[");
        localStringBuilder.append(paramRecordParam);
        localStringBuilder.append("]");
        QLog.i("EGLScreenCaptureThread", 4, localStringBuilder.toString());
      }
      this.x.update(paramRecordParam);
    }
  }
  
  @RequiresApi(api=18)
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("EGLScreenCaptureThread", 4, "quit");
    }
    if (this.i != null) {
      this.i.sendEmptyMessage(2);
    }
    if ((paramBoolean) && (this.i != null)) {
      this.i.getLooper().quitSafely();
    }
  }
  
  public Handler b()
  {
    return this.i;
  }
  
  public Surface c()
  {
    return this.e;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (!this.d) {
      return;
    }
    this.A += 1L;
    long l1 = SystemClock.elapsedRealtime();
    this.z = l1;
    if (this.h == null) {
      this.h = new float[16];
    }
    paramSurfaceTexture.updateTexImage();
    paramSurfaceTexture.getTransformMatrix(this.h);
    this.j = ((float)paramSurfaceTexture.getTimestamp());
    if (this.j == 0.0F)
    {
      if (QLog.isDevelopLevel())
      {
        paramSurfaceTexture = new StringBuilder();
        paramSurfaceTexture.append("onFrameAvailable, time[");
        paramSurfaceTexture.append(this.j);
        paramSurfaceTexture.append("]");
        QLog.i("EGLScreenCaptureThread", 4, paramSurfaceTexture.toString());
      }
      return;
    }
    long l2 = Math.abs(l1 - this.B);
    l1 = this.B;
    int i1 = 0;
    int i = i1;
    if (l1 != 0L)
    {
      i = i1;
      if (l2 < this.w.intervalTime) {
        i = 1;
      }
    }
    l1 = 2000L;
    if (i != 0) {
      l1 = Math.min(this.w.intervalTime - l2, 2000L);
    }
    this.i.removeMessages(3);
    this.i.sendEmptyMessageDelayed(3, l1);
    if (i != 0) {
      return;
    }
    if ((this.x.isValid()) || (this.w.isValid())) {
      j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EGLScreenCaptureThread
 * JD-Core Version:    0.7.0.1
 */