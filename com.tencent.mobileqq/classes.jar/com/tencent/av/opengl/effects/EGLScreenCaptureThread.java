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
  private float jdField_a_of_type_Float = -1.0F;
  private final int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 0L;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private final EGLScreenCaptureThread.PerfData jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread$PerfData = new EGLScreenCaptureThread.PerfData();
  private EGLScreenCaptureThread.onVideoFrameAvailableListener jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread$onVideoFrameAvailableListener;
  private RGBToI420Filter jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter = null;
  private final RecordParam jdField_a_of_type_ComTencentAvcoreDataRecordParam = new RecordParam();
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer = null;
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private final int jdField_b_of_type_Int = 2;
  private long jdField_b_of_type_Long = 0L;
  private final RecordParam jdField_b_of_type_ComTencentAvcoreDataRecordParam = new RecordParam();
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
  private boolean jdField_b_of_type_Boolean = true;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private final int jdField_c_of_type_Int = 3;
  private long jdField_c_of_type_Long = 0L;
  private int d;
  private int e;
  private int f;
  private int g = 100;
  
  @RequiresApi(api=21)
  private void d()
  {
    this.d = GlUtil.createTexture(36197);
    GLES20.glBindTexture(36197, 0);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.d);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this, a());
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setDefaultBufferSize(this.e, this.f);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread$PerfData.a();
    if (QLog.isColorLevel()) {
      QLog.i("EGLScreenCaptureThread", 2, "initGLEnv");
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    Object localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
    if (localObject != null)
    {
      ((TextureRender)localObject).release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    if (localObject != null)
    {
      ((RenderBuffer)localObject).destroy();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter;
    if (localObject != null)
    {
      ((RGBToI420Filter)localObject).c();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter = null;
    }
    this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread$PerfData.b();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    if (QLog.isColorLevel()) {
      QLog.i("EGLScreenCaptureThread", 2, "releaseGLEnv");
    }
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((!this.jdField_b_of_type_ComTencentAvcoreDataRecordParam.isValid()) && (!this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.isValid()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("EGLScreenCaptureThread", 4, "check, param not valid.");
      }
    }
    else {
      i();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 2000L);
  }
  
  private void h()
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.update(this.jdField_b_of_type_ComTencentAvcoreDataRecordParam);
    RenderBuffer localRenderBuffer;
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) || (bool))
    {
      localRenderBuffer = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
      if (localRenderBuffer != null) {
        localRenderBuffer.destroy();
      }
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.width, this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.height, 33984);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) || (bool))
      {
        localRenderBuffer = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        if (localRenderBuffer != null) {
          localRenderBuffer.destroy();
        }
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.width, this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.height, 33985);
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter == null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter = new RGBToI420Filter();
        this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter.b();
      }
      if (bool) {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter.a(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.width, this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.height);
      }
      if ((this.jdField_a_of_type_JavaNioByteBuffer == null) || (bool)) {
        this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.width * this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.height * 3 / 2);
      }
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (bool)) {
      this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.width * this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.height * 3 / 2];
    }
  }
  
  private void i()
  {
    long l5 = SystemClock.elapsedRealtime();
    h();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    if (this.jdField_b_of_type_ArrayOfFloat == null)
    {
      this.jdField_b_of_type_ArrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.e, this.f, this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.width, this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.height);
      Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, 1.0F, -1.0F, 1.0F);
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.d, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    long l6 = Math.abs(SystemClock.elapsedRealtime() - l5);
    long l1;
    long l2;
    Object localObject;
    long l3;
    if (this.jdField_b_of_type_Boolean)
    {
      l1 = SystemClock.elapsedRealtime();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter.a(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId());
      l2 = Math.abs(SystemClock.elapsedRealtime() - l1);
      l1 = SystemClock.elapsedRealtime();
      GLES20.glReadPixels(0, 0, this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.width, this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.height * 3 / 8, 6408, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      l4 = Math.abs(SystemClock.elapsedRealtime() - l1);
      this.jdField_a_of_type_JavaNioByteBuffer.get(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.width * this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.height * 3 / 2);
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread$onVideoFrameAvailableListener;
      if (localObject != null)
      {
        l1 = SystemClock.elapsedRealtime();
        ((EGLScreenCaptureThread.onVideoFrameAvailableListener)localObject).a(this.jdField_a_of_type_ArrayOfByte, this.g, 2, this.jdField_a_of_type_ComTencentAvcoreDataRecordParam);
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
      localObject = GlUtil.captureFrame(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.width, this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.height, 0);
      EGLScreenCaptureThread.onVideoFrameAvailableListener localonVideoFrameAvailableListener = this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread$onVideoFrameAvailableListener;
      if (localonVideoFrameAvailableListener != null)
      {
        l1 = SystemClock.elapsedRealtime();
        localonVideoFrameAvailableListener.a((Bitmap)localObject, this.jdField_a_of_type_ComTencentAvcoreDataRecordParam);
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
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    long l4 = this.jdField_c_of_type_Long;
    this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread$PerfData.a(l6, l1, l2, l3, l4 - l5);
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
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
        g();
        return;
      }
      e();
      f();
      return;
    }
    b();
    d();
  }
  
  public void a(EGLScreenCaptureThread.onVideoFrameAvailableListener paramonVideoFrameAvailableListener)
  {
    this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread$onVideoFrameAvailableListener = paramonVideoFrameAvailableListener;
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
        localStringBuilder.append(this.jdField_b_of_type_ComTencentAvcoreDataRecordParam);
        localStringBuilder.append("], come[");
        localStringBuilder.append(paramRecordParam);
        localStringBuilder.append("]");
        QLog.i("EGLScreenCaptureThread", 4, localStringBuilder.toString());
      }
      this.jdField_b_of_type_ComTencentAvcoreDataRecordParam.update(paramRecordParam);
    }
  }
  
  @RequiresApi(api=18)
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("EGLScreenCaptureThread", 4, "quit");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.getLooper().quitSafely();
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Long += 1L;
    long l1 = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_Long = l1;
    if (this.jdField_a_of_type_ArrayOfFloat == null) {
      this.jdField_a_of_type_ArrayOfFloat = new float[16];
    }
    paramSurfaceTexture.updateTexImage();
    paramSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_a_of_type_Float = ((float)paramSurfaceTexture.getTimestamp());
    if (this.jdField_a_of_type_Float == 0.0F)
    {
      if (QLog.isDevelopLevel())
      {
        paramSurfaceTexture = new StringBuilder();
        paramSurfaceTexture.append("onFrameAvailable, time[");
        paramSurfaceTexture.append(this.jdField_a_of_type_Float);
        paramSurfaceTexture.append("]");
        QLog.i("EGLScreenCaptureThread", 4, paramSurfaceTexture.toString());
      }
      return;
    }
    long l2 = Math.abs(l1 - this.jdField_c_of_type_Long);
    l1 = this.jdField_c_of_type_Long;
    int j = 0;
    int i = j;
    if (l1 != 0L)
    {
      i = j;
      if (l2 < this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.intervalTime) {
        i = 1;
      }
    }
    l1 = 2000L;
    if (i != 0) {
      l1 = Math.min(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.intervalTime - l2, 2000L);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, l1);
    if (i != 0) {
      return;
    }
    if ((this.jdField_b_of_type_ComTencentAvcoreDataRecordParam.isValid()) || (this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.isValid())) {
      i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EGLScreenCaptureThread
 * JD-Core Version:    0.7.0.1
 */