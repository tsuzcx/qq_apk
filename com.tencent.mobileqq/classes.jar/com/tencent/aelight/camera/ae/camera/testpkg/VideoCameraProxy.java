package com.tencent.aelight.camera.ae.camera.testpkg;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.view.Surface;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqcamerakit.capture.CameraPreviewCallBack;
import com.tencent.qqcamerakit.capture.CameraProxy.CameraAutoFocusCallBack;
import com.tencent.qqcamerakit.capture.CameraProxy.PictureCallback;
import com.tencent.qqcamerakit.capture.CameraSize;
import com.tencent.qqcamerakit.common.Observer;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoCameraProxy
  implements IProxyForTestCap, HWDecodeListener
{
  protected HWVideoDecoder a;
  protected DecodeConfig b;
  protected long c;
  protected int d;
  protected int e;
  protected VideoDecodeHardWare f;
  private boolean g = false;
  private List<Observer> h;
  private SurfaceTextureForTest i;
  private Object j = new Object();
  private Object k = new Object();
  private boolean l = false;
  private long m = -1L;
  private long n = -1L;
  private long o = -1L;
  
  public VideoCameraProxy(String paramString)
  {
    a(paramString);
    this.b = new DecodeConfig(paramString, 0, true, true, 0L, this.c);
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (!new File(paramString).exists())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" is not exits.");
      QLog.e("VideoCameraProxy", 4, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject2 = new MediaMetadataRetriever();
    ((MediaMetadataRetriever)localObject2).setDataSource(paramString);
    Object localObject1 = ((MediaMetadataRetriever)localObject2).extractMetadata(9);
    this.c = Long.valueOf((String)localObject1).longValue();
    this.d = Integer.valueOf(((MediaMetadataRetriever)localObject2).extractMetadata(19)).intValue();
    this.e = Integer.valueOf(((MediaMetadataRetriever)localObject2).extractMetadata(18)).intValue();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(":duration:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(",width:");
    ((StringBuilder)localObject2).append(this.e);
    ((StringBuilder)localObject2).append(",height:");
    ((StringBuilder)localObject2).append(this.d);
    QLog.i("VideoCameraProxy", 4, ((StringBuilder)localObject2).toString());
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(Matrix paramMatrix, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2) {}
  
  public void a(SurfaceTexture paramSurfaceTexture, CameraPreviewCallBack paramCameraPreviewCallBack)
  {
    if (this.g) {
      return;
    }
    if (!(paramSurfaceTexture instanceof SurfaceTextureForTest))
    {
      QLog.e("VideoCameraProxy", 4, "surface is not instanceof SurfaceTextureForTest.");
      return;
    }
    this.g = true;
    this.f = new VideoDecodeHardWare();
    this.f.a(new Surface(paramSurfaceTexture), this.b.inputFilePath);
    this.f.a(new VideoCameraProxy.1(this));
    this.f.b();
    this.i = ((SurfaceTextureForTest)paramSurfaceTexture);
    this.i.a(new VideoCameraProxy.2(this));
    paramSurfaceTexture = this.h;
    if (paramSurfaceTexture != null)
    {
      if (paramSurfaceTexture.size() == 0) {
        return;
      }
      paramSurfaceTexture = new CameraSize(this.d, this.e);
      paramCameraPreviewCallBack = this.h.iterator();
      while (paramCameraPreviewCallBack.hasNext()) {
        ((Observer)paramCameraPreviewCallBack.next()).notify(2, 0, null, new Object[] { paramSurfaceTexture });
      }
    }
  }
  
  public void a(CameraSize paramCameraSize1, CameraSize paramCameraSize2, CameraSize paramCameraSize3, int paramInt1, String paramString, int paramInt2, int paramInt3) {}
  
  public void a(CameraSize paramCameraSize, boolean paramBoolean, String paramString, int paramInt, CameraProxy.PictureCallback paramPictureCallback) {}
  
  public void a(Observer paramObserver)
  {
    if (this.h == null) {
      this.h = new ArrayList();
    }
    if (paramObserver != null)
    {
      if (this.h.contains(paramObserver)) {
        return;
      }
      this.h.add(paramObserver);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((HWVideoDecoder)localObject).stopDecode();
    }
    localObject = this.f;
    if (localObject != null) {
      ((VideoDecodeHardWare)localObject).d();
    }
    this.g = false;
  }
  
  public Object b()
  {
    return null;
  }
  
  public void b(int paramInt) {}
  
  public void b(Observer paramObserver)
  {
    if (paramObserver != null)
    {
      List localList = this.h;
      if (localList == null) {
        return;
      }
      localList.remove(paramObserver);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
  
  public void c(boolean paramBoolean) {}
  
  public void onDecodeCancel()
  {
    QLog.i("VideoCameraProxy", 4, "onDecodeCancel.");
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    QLog.i("VideoCameraProxy", 4, "onDecodeError.");
  }
  
  public void onDecodeFinish()
  {
    QLog.i("VideoCameraProxy", 4, "onDecodeFinish.");
  }
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    QLog.i("VideoCameraProxy", 4, "onDecodeFrame.");
    synchronized (this.j)
    {
      this.n = paramLong1;
      this.o = paramLong2;
      synchronized (this.k)
      {
        this.k.notifyAll();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("onDecodeFrame start timestamp = ");
          ((StringBuilder)???).append(paramLong1);
          QLog.d("VideoCameraProxy", 2, ((StringBuilder)???).toString());
        }
        try
        {
          this.j.wait(2000L);
          if (!this.l)
          {
            this.m = -1L;
            this.n = 0L;
            this.o = 0L;
          }
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("onDecodeFrame end timestamp = ");
            ((StringBuilder)???).append(paramLong1);
            QLog.d("VideoCameraProxy", 2, ((StringBuilder)???).toString());
          }
          this.l = false;
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoCameraProxy", 2, "onDecodeFrame InterruptedException");
          }
          this.l = false;
          throw localInterruptedException;
        }
      }
    }
  }
  
  public void onDecodeRepeat()
  {
    QLog.i("VideoCameraProxy", 4, "onDecodeRepeat.");
  }
  
  public void onDecodeSeekTo(long paramLong)
  {
    QLog.i("VideoCameraProxy", 4, "onDecodeSeekTo.");
  }
  
  public void onDecodeStart()
  {
    QLog.i("VideoCameraProxy", 4, "onDecodeStart.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.testpkg.VideoCameraProxy
 * JD-Core Version:    0.7.0.1
 */