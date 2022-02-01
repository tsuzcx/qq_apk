package com.tencent.avgame.qav;

import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.opengl.effects.RGBToI420Filter;
import com.tencent.avcore.data.RecordParam;
import com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper;
import com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.OnAVGameMediaPlayerCallBack;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread;
import com.tencent.qav.log.AVLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

public class AVGameMediaPlayerCtrl
  implements AVGameMediaPlayerWrapper.OnAVGameMediaPlayerCallBack, IAVGameMediaPlayerCtrl
{
  protected AVGameMediaPlayerWrapper a;
  private EglHandlerThread b;
  private AVGameMediaPlayerCtrl.CustomHandler c;
  private float[] d = new float[16];
  private float[] e = new float[16];
  private RenderBuffer f;
  private TextureRender g;
  private RenderBuffer h = null;
  private ByteBuffer i = null;
  private byte[] j = null;
  private RGBToI420Filter k = null;
  private boolean l = false;
  private RecordParam m = new RecordParam();
  private boolean n = false;
  private boolean o = true;
  private AVGameVideoPreLoadMgr p;
  private String q;
  private Integer r;
  private Integer s;
  private volatile boolean t = true;
  private CopyOnWriteArrayList<WeakReference<IAVGameMediaPlayerCtrl.PushDecodeMsg>> u = new CopyOnWriteArrayList();
  private volatile Float v;
  
  private void a(int paramInt1, int paramInt2)
  {
    Integer localInteger = this.r;
    if ((localInteger != null) && (paramInt1 == localInteger.intValue()) && (paramInt2 == this.s.intValue()))
    {
      paramInt1 = 0;
    }
    else
    {
      this.r = Integer.valueOf(paramInt1);
      this.s = Integer.valueOf(paramInt2);
      paramInt1 = 1;
    }
    if (paramInt1 != 0) {
      o();
    }
    if (this.f == null)
    {
      this.f = new RenderBuffer(this.r.intValue(), this.s.intValue(), 33984);
      Matrix.setIdentityM(this.e, 0);
      Matrix.scaleM(this.e, 0, 1.0F, -1.0F, 1.0F);
    }
    if (this.g == null) {
      this.g = new TextureRender();
    }
    if (this.h == null)
    {
      this.h = new RenderBuffer(this.r.intValue(), this.s.intValue(), 33985);
      this.i = ByteBuffer.allocate(this.r.intValue() * this.s.intValue() * 3 / 2);
      this.j = new byte[this.r.intValue() * this.s.intValue() * 3 / 2];
    }
    if (this.k == null)
    {
      this.k = new RGBToI420Filter();
      this.k.b();
      this.k.a(this.r.intValue(), this.s.intValue());
    }
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong)
  {
    a(paramInt1 / 16 * 16, paramInt2 / 8 * 8);
    this.f.bind();
    this.g.drawTexture(36197, this.a.e(), this.d, this.e);
    this.f.unbind();
    this.h.bind();
    this.k.a(this.f.getTexId());
    GLES20.glReadPixels(0, 0, this.r.intValue(), this.s.intValue() * 3 / 8, 6408, 5121, this.i);
    this.h.unbind();
    this.i.get(this.j, 0, this.r.intValue() * this.s.intValue() * 3 / 2);
    this.i.clear();
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((IAVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).a(this.j, this.r.intValue(), this.s.intValue(), paramLong);
      }
    }
    if (this.n) {
      this.m.update(this.r.intValue(), this.s.intValue(), 15);
    }
  }
  
  private void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, long paramLong)
  {
    paramSurfaceTexture = this.a;
    if ((paramSurfaceTexture != null) && (paramSurfaceTexture.f() != null))
    {
      if (this.a.e() == -1) {
        return;
      }
      try
      {
        this.a.f().updateTexImage();
        this.a.f().getTransformMatrix(this.d);
        if (this.t)
        {
          a(paramInt1, paramInt2, paramLong);
          return;
        }
      }
      catch (Throwable paramSurfaceTexture)
      {
        QLog.d("AVGameMediaPlayerCtrl", 1, "onFrameAvailable", paramSurfaceTexture);
      }
    }
  }
  
  private void m()
  {
    if (this.b == null)
    {
      this.b = new EglHandlerThread("eglHandelr_thread", null);
      this.b.start();
      this.c = new AVGameMediaPlayerCtrl.CustomHandler(this, this.b.getLooper());
      this.c.sendEmptyMessage(152);
    }
  }
  
  private void n()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "initEgl");
    Matrix.setIdentityM(this.d, 0);
    Matrix.setIdentityM(this.e, 0);
    this.a.a(this, this.c);
  }
  
  private void o()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "unInitEgl");
    Object localObject = this.f;
    if (localObject != null)
    {
      ((RenderBuffer)localObject).destroy();
      this.f = null;
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((TextureRender)localObject).release();
      this.g = null;
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((RenderBuffer)localObject).destroy();
      this.h = null;
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((RGBToI420Filter)localObject).c();
      this.k = null;
    }
    this.i = null;
    this.j = null;
  }
  
  public String a()
  {
    return this.q;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.v = Float.valueOf(paramInt3 * 1.0F / paramInt2);
  }
  
  public void a(IAVGameMediaPlayerCtrl.PushDecodeMsg paramPushDecodeMsg)
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (paramPushDecodeMsg == localWeakReference.get())) {
        return;
      }
    }
    this.u.add(new WeakReference(paramPushDecodeMsg));
  }
  
  public void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    if (!this.o) {
      return;
    }
    l();
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (paramTPAudioFrameBuffer.getChannelLayout() == 3L)
      {
        int i5 = paramTPAudioFrameBuffer.getSize()[0] / 2;
        byte[] arrayOfByte1 = new byte[i5];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i5)
        {
          byte[] arrayOfByte2 = paramTPAudioFrameBuffer.data[0];
          int i9 = i3 * 2;
          int i7 = (short)arrayOfByte2[i9];
          int i6 = (short)paramTPAudioFrameBuffer.data[0][(i9 + 1)];
          int i8 = (short)paramTPAudioFrameBuffer.data[0][(i9 + 2)];
          i9 = (short)paramTPAudioFrameBuffer.data[0][(i9 + 3)];
          i7 = (i7 + i8) / 2;
          i6 = (i6 + i9) / 2;
          i8 = i4 + 1;
          int i2 = -128;
          int i1;
          if (i7 > 127) {
            i1 = 127;
          } else if (i7 < -128) {
            i1 = -128;
          } else {
            i1 = (byte)i7;
          }
          arrayOfByte1[i4] = i1;
          i4 = i8 + 1;
          if (i6 > 127) {
            i1 = 127;
          } else if (i6 < -128) {
            i1 = i2;
          } else {
            i1 = (byte)i6;
          }
          arrayOfByte1[i8] = i1;
          i3 += 2;
        }
        if ((this.v.floatValue() < 0.99F) || (this.v.floatValue() > 1.01F)) {
          AudioProcess.a(arrayOfByte1, this.v.floatValue());
        }
        AudioProcess.a(arrayOfByte1, arrayOfByte1.length);
        return;
      }
      if (paramTPAudioFrameBuffer.getChannelLayout() == 4L)
      {
        if ((this.v.floatValue() < 0.99F) || (this.v.floatValue() > 1.01F)) {
          AudioProcess.a(paramTPAudioFrameBuffer.data[0], this.v.floatValue());
        }
        AudioProcess.a(paramTPAudioFrameBuffer.data[0], paramTPAudioFrameBuffer.data[0].length);
      }
    }
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((IAVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).a(paramString);
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "playAudioByURL");
    this.q = paramString;
    this.p.a(this.q);
    paramString = this.a;
    if (paramString != null) {
      paramString.a(this.q, paramLong);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a(3);
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playVideoByURl hasAVRoom:=");
    localStringBuilder.append(paramBoolean);
    QLog.d("AVGameMediaPlayerCtrl", 1, localStringBuilder.toString());
    this.q = paramString;
    if ((this.l) || (!this.n))
    {
      if (!this.n) {
        if (paramBoolean) {
          AVGameBusinessCtrl.b().b(true);
        } else {
          AVGameBusinessCtrl.b().a(true);
        }
      }
      this.p.a(this.q);
      paramString = this.a;
      if (paramString != null) {
        paramString.b(this.q, paramLong);
      }
    }
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a(3);
    }
  }
  
  public void a(List<AVGameMediaFileInfo> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setPreLoadVideoResourceInfos infoList:=");
    ((StringBuilder)localObject).append(Arrays.toString(paramList.toArray()));
    QLog.d("AVGameMediaPlayerCtrl", 1, ((StringBuilder)localObject).toString());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (AVGameMediaFileInfo)paramList.next();
      this.p.a(((AVGameMediaFileInfo)localObject).a, ((AVGameMediaFileInfo)localObject).c, 3000L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public long b()
  {
    AVGameMediaPlayerWrapper localAVGameMediaPlayerWrapper = this.a;
    if (localAVGameMediaPlayerWrapper != null) {
      return localAVGameMediaPlayerWrapper.a();
    }
    return 0L;
  }
  
  public void b(IAVGameMediaPlayerCtrl.PushDecodeMsg paramPushDecodeMsg)
  {
    Iterator localIterator = this.u.iterator();
    label11:
    WeakReference localWeakReference;
    for (Object localObject = null; localIterator.hasNext(); localObject = localWeakReference)
    {
      localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference == null) || (paramPushDecodeMsg != localWeakReference.get())) {
        break label11;
      }
    }
    if (localObject != null) {
      this.u.remove(localObject);
    }
  }
  
  public void b(String paramString)
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((IAVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).b(paramString);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    AVGameMediaPlayerCtrl.CustomHandler localCustomHandler = this.c;
    if (localCustomHandler == null) {
      return;
    }
    localCustomHandler.post(new AVGameMediaPlayerCtrl.1(this, paramBoolean));
  }
  
  public void c(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B1F3", "0X800B1F3", 0, 0, "", "", "", "");
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((IAVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).c(paramString);
      }
    }
  }
  
  public boolean c()
  {
    boolean bool3 = this.n;
    boolean bool1 = false;
    boolean bool2 = false;
    if (bool3)
    {
      bool1 = bool2;
      if (this.l)
      {
        bool1 = bool2;
        if (this.a.d()) {
          bool1 = true;
        }
      }
      return bool1;
    }
    AVGameMediaPlayerWrapper localAVGameMediaPlayerWrapper = this.a;
    if (localAVGameMediaPlayerWrapper != null) {
      bool1 = localAVGameMediaPlayerWrapper.d();
    }
    return bool1;
  }
  
  public void d()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "relasePlayVideo");
    Object localObject = this.a;
    if (localObject != null) {
      ((AVGameMediaPlayerWrapper)localObject).b();
    }
    localObject = this.c;
    if (localObject != null) {
      ((AVGameMediaPlayerCtrl.CustomHandler)localObject).sendEmptyMessage(258);
    }
  }
  
  public void d(String paramString)
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((IAVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).d(paramString);
      }
    }
  }
  
  public void e()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "stopVideoPlay");
    AVGameMediaPlayerWrapper localAVGameMediaPlayerWrapper = this.a;
    if (localAVGameMediaPlayerWrapper != null) {
      localAVGameMediaPlayerWrapper.c();
    }
  }
  
  public void f()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "stopVideoSend");
    if ((this.l) && (this.n)) {
      return;
    }
    if (!this.n) {
      AVGameBusinessCtrl.b().b(false);
    }
  }
  
  public void g()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "stopNoAVRoomVideoSend");
    if ((this.l) && (this.n)) {
      return;
    }
    if (!this.n) {
      AVGameBusinessCtrl.b().a(false);
    }
  }
  
  public void h()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "init");
    this.p = new AVGameVideoPreLoadMgr();
    this.a = new AVGameMediaPlayerWrapper();
    m();
  }
  
  public void i()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "doOnResume");
    this.t = true;
  }
  
  public void j()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "doOnStop");
    this.t = false;
    AVGameMediaPlayerCtrl.CustomHandler localCustomHandler = this.c;
    if (localCustomHandler != null) {
      localCustomHandler.sendEmptyMessage(258);
    }
  }
  
  public void k()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "unInit");
    Object localObject = this.a;
    if (localObject != null) {
      ((AVGameMediaPlayerWrapper)localObject).g();
    }
    this.p.a();
    f();
    this.u.clear();
    this.l = false;
    if (this.b != null)
    {
      localObject = this.c;
      if (localObject != null) {
        ((AVGameMediaPlayerCtrl.CustomHandler)localObject).sendEmptyMessage(153);
      }
      this.b.quitSafely();
      this.b = null;
    }
  }
  
  public void l()
  {
    if (this.v != null) {
      return;
    }
    Object localObject = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
    int i1 = ((AudioManager)localObject).getStreamVolume(0);
    int i2 = ((AudioManager)localObject).getStreamMaxVolume(0);
    this.v = Float.valueOf(i1 * 1.0F / i2);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init scaleFacors:=");
    ((StringBuilder)localObject).append(this.v);
    AVLog.d("AVGameMediaPlayerCtrl", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameMediaPlayerCtrl
 * JD-Core Version:    0.7.0.1
 */