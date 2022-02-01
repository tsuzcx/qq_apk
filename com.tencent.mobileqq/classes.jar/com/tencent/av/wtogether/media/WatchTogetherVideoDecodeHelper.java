package com.tencent.av.wtogether.media;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.wtogether.callback.VideoSink;
import com.tencent.av.wtogether.gles.WatchTogetherSurfaceTextureHolder;
import com.tencent.av.wtogether.gles.WatchTogetherSurfaceTextureHolder.OnSurfaceTextureEglFoucusListener;
import com.tencent.av.wtogether.util.ThreadUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread;
import com.tencent.qphone.base.util.QLog;

public class WatchTogetherVideoDecodeHelper
  implements WatchTogetherSurfaceTextureHolder.OnSurfaceTextureEglFoucusListener
{
  private final EglHandlerThread a;
  private Handler b;
  private int c = -1;
  private int d = -1;
  private boolean e;
  private int f = 0;
  private SurfaceTexture g;
  private WatchTogetherSurfaceTextureHolder h;
  private boolean i;
  private boolean j;
  private boolean k = false;
  private boolean l = false;
  private VideoSink m;
  
  private WatchTogetherVideoDecodeHelper(Handler paramHandler, EglHandlerThread paramEglHandlerThread)
  {
    this.b = paramHandler;
    this.a = paramEglHandlerThread;
    this.e = true;
    this.f = GlUtil.createTexture(36197);
    this.g = new SurfaceTexture(this.f);
    this.h = new WatchTogetherSurfaceTextureHolder(this.g, this.f);
    this.h.a(this);
    a(this.g, new WatchTogetherVideoDecodeHelper.1(this), paramHandler);
  }
  
  public static WatchTogetherVideoDecodeHelper a(String paramString)
  {
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "createWatchTogetherVideoDecodeHelper");
    paramString = new EglHandlerThread(paramString, null);
    paramString.start();
    Handler localHandler = new Handler(paramString.getLooper());
    return (WatchTogetherVideoDecodeHelper)ThreadUtils.a(localHandler, new WatchTogetherVideoDecodeHelper.2(localHandler, paramString));
  }
  
  private static void a(SurfaceTexture paramSurfaceTexture, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener, paramHandler);
      return;
    }
    paramSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
  }
  
  private void b(String arg1)
  {
    if ((!this.i) && (this.j) && (this.c != -1) && (this.d != -1))
    {
      this.j = false;
      if ((this.m != null) && (this.l))
      {
        this.k = true;
        if (this.e) {
          synchronized (this.h)
          {
            this.f = -1;
            this.e = false;
            this.h.d();
            QLog.d("WatchTogetherVideoDecodeHelper", 1, "release image stream");
          }
        }
        this.m.a(this.h, this.c, this.d);
        return;
      }
      synchronized (this.h)
      {
        if (!this.e)
        {
          if (!this.h.c())
          {
            this.j = true;
            QLog.d("WatchTogetherVideoDecodeHelper", 1, "try recycle surfaceTexture later");
            return;
          }
          QLog.d("WatchTogetherVideoDecodeHelper", 1, "recycle image stream");
        }
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryDeliverTextureFrame from:=");
    localStringBuilder.append(???);
    localStringBuilder.append(",mIsQuiting:= ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",mHasPendingTexture:=");
    localStringBuilder.append(this.j);
    QLog.d("WatchTogetherVideoDecodeHelper", 1, localStringBuilder.toString());
  }
  
  private void e()
  {
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "release");
    if (this.i)
    {
      if (this.k) {
        return;
      }
      int n = this.f;
      if (n > 0)
      {
        GlUtil.deleteTexture(n);
        this.f = -1;
      }
      Object localObject = this.g;
      if (localObject != null)
      {
        ((SurfaceTexture)localObject).release();
        this.g = null;
      }
      localObject = this.h;
      if (localObject != null)
      {
        ((WatchTogetherSurfaceTextureHolder)localObject).b();
        this.h = null;
      }
      if (this.b != null)
      {
        this.a.quitSafely();
        this.b = null;
      }
      QLog.d("WatchTogetherVideoDecodeHelper", 1, "real release");
    }
  }
  
  public void a()
  {
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "onResponsePauseMessage");
    Handler localHandler = this.b;
    if (localHandler == null) {
      return;
    }
    localHandler.post(new WatchTogetherVideoDecodeHelper.9(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSurfaceTextureDefaultSize width:=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",height:=");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("WatchTogetherVideoDecodeHelper", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject == null) {
      return;
    }
    ((Handler)localObject).post(new WatchTogetherVideoDecodeHelper.3(this, paramInt1, paramInt2));
  }
  
  public void a(VideoSink paramVideoSink)
  {
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "startVideoSinkListener");
    Handler localHandler = this.b;
    if (localHandler == null) {
      return;
    }
    localHandler.post(new WatchTogetherVideoDecodeHelper.4(this, paramVideoSink));
  }
  
  public void a(Thread paramThread)
  {
    Handler localHandler = this.b;
    if ((localHandler != null) && (localHandler.getLooper().getThread() != paramThread)) {
      this.b.post(new WatchTogetherVideoDecodeHelper.7(this));
    }
  }
  
  public SurfaceTexture b()
  {
    return this.g;
  }
  
  public void c()
  {
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "stopVideoSinkListener");
    Handler localHandler = this.b;
    if (localHandler == null) {
      return;
    }
    localHandler.post(new WatchTogetherVideoDecodeHelper.5(this));
  }
  
  public void d()
  {
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "dispose");
    ThreadUtils.a(this.b, new WatchTogetherVideoDecodeHelper.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper
 * JD-Core Version:    0.7.0.1
 */