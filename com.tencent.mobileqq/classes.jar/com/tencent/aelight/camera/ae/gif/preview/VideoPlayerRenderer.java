package com.tencent.aelight.camera.ae.gif.preview;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;
import android.view.Surface;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.openapi.filter.SpaceFilter;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class VideoPlayerRenderer
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer
{
  private static final String a = "VideoPlayerRenderer";
  private int b;
  private SurfaceTexture c;
  private final float[] d = new float[16];
  private AtomicBoolean e = new AtomicBoolean(false);
  private final GLSurfaceView f;
  private float g;
  private float h;
  private MediaPlayer i;
  private VideoFilterProcess j = new VideoFilterProcess();
  private BaseFilter k = new SurfaceTextureFilter();
  private SpaceFilter l = new SpaceFilter();
  private Frame m = new Frame();
  private Frame n = new Frame();
  
  VideoPlayerRenderer(GLSurfaceView paramGLSurfaceView)
  {
    this.f = paramGLSurfaceView;
  }
  
  private void a(Frame paramFrame)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(0.92F, 0.93F, 0.96F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    this.l.RenderProcess(paramFrame.getTextureId(), (int)this.g, (int)this.h, 0, 0.0D, this.n);
    GLES20.glDisable(3042);
  }
  
  private void b()
  {
    Object localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    this.b = localObject[0];
    this.c = new SurfaceTexture(this.b);
    this.c.setOnFrameAvailableListener(this);
    localObject = new Surface(this.c);
    this.i.setSurface((Surface)localObject);
    this.i.prepareAsync();
  }
  
  private void c()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.b;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.c.release();
  }
  
  private void d()
  {
    this.k.apply();
    this.k.setRotationAndFlip(0, 0, 1);
    this.l.apply();
    this.l.setRotationAndFlip(0, 0, 1);
    this.j.a();
  }
  
  public void a()
  {
    this.k.clearGLSL();
    this.l.clearGLSL();
    this.m.clear();
    this.n.clear();
    c();
    this.j.b();
  }
  
  public void a(MediaPlayer paramMediaPlayer)
  {
    this.i = paramMediaPlayer;
  }
  
  public void a(VideoFilterProcess.FrameRenderCallback paramFrameRenderCallback)
  {
    VideoFilterProcess localVideoFilterProcess = this.j;
    if (localVideoFilterProcess != null) {
      localVideoFilterProcess.a(paramFrameRenderCallback);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    VideoFilterProcess localVideoFilterProcess = this.j;
    if (localVideoFilterProcess != null) {
      localVideoFilterProcess.a(paramBoolean);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.e.compareAndSet(true, false))
    {
      this.c.updateTexImage();
      this.c.getTransformMatrix(this.d);
      this.k.updateMatrix(this.d);
      this.k.RenderProcess(this.b, (int)(this.g * 2.0F), (int)this.h, -1, 0.0D, this.m);
    }
    if (GLES20.glIsTexture(this.m.getTextureId()))
    {
      a(this.j.a(this.m, (int)this.g, (int)this.h));
      return;
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
    GLES20.glClear(16384);
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.e.set(true);
      this.f.requestRender();
      return;
    }
    finally
    {
      paramSurfaceTexture = finally;
      throw paramSurfaceTexture;
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    paramGL10 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceChanged width = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("  height = ");
    localStringBuilder.append(paramInt2);
    Log.d(paramGL10, localStringBuilder.toString());
    this.g = paramInt1;
    this.h = paramInt2;
    this.j.a(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.e.set(false);
    b();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.preview.VideoPlayerRenderer
 * JD-Core Version:    0.7.0.1
 */