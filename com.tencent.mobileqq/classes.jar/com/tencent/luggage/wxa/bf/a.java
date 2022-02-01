package com.tencent.luggage.wxa.bf;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import com.tencent.luggage.wxa.be.i;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.sc.d;

public class a
  extends i
{
  private final String a = "MicroMsg.SameLayerYUVDateRenderToRBGBufferThread";
  private HandlerThread b = d.d("SameLayerYUVDateRenderToRBGBufferThread", 5);
  private s c;
  private c d;
  private c.a e = null;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private boolean k = false;
  private int[] l = { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344 };
  private EGLDisplay m = null;
  private EGLSurface n = null;
  private EGLContext o = null;
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.d = new c(paramInt1, paramInt2, paramInt3, paramInt4);
    this.d.onSurfaceCreated(null, null);
    this.d.onSurfaceChanged(null, paramInt3, paramInt4);
    c.a locala = this.e;
    if (locala != null) {
      this.d.a(locala.b());
    }
  }
  
  private void a(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    this.m = EGL14.eglGetDisplay(0);
    if (this.m != EGL14.EGL_NO_DISPLAY)
    {
      Object localObject = new int[2];
      if (EGL14.eglInitialize(this.m, (int[])localObject, 0, (int[])localObject, 1))
      {
        localObject = new EGLConfig[1];
        int[] arrayOfInt = new int[1];
        EGL14.eglChooseConfig(this.m, this.l, 0, (EGLConfig[])localObject, 0, localObject.length, arrayOfInt, 0);
        if (localObject[0] != null)
        {
          this.o = EGL14.eglCreateContext(this.m, localObject[0], paramEGLContext, new int[] { 12440, 2, 12344 }, 0);
          if (this.o != EGL14.EGL_NO_CONTEXT)
          {
            a("eglCreateContext");
            this.n = null;
            try
            {
              this.n = EGL14.eglCreatePbufferSurface(this.m, localObject[0], new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
            }
            catch (IllegalArgumentException paramEGLContext)
            {
              o.b("MicroMsg.SameLayerYUVDateRenderToRBGBufferThread", "eglCreateWindowSurface", new Object[] { paramEGLContext });
            }
            a("eglCreatePbufferSurface");
            paramEGLContext = this.n;
            if (((paramEGLContext == null) || (paramEGLContext == EGL14.EGL_NO_SURFACE)) && (EGL14.eglGetError() == 12299)) {
              o.b("MicroMsg.SameLayerYUVDateRenderToRBGBufferThread", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
            }
            paramEGLContext = this.m;
            localObject = this.n;
            if (!EGL14.eglMakeCurrent(paramEGLContext, (EGLSurface)localObject, (EGLSurface)localObject, this.o))
            {
              paramEGLContext = new StringBuilder();
              paramEGLContext.append("eglMakeCurrent:");
              paramEGLContext.append(EGL14.eglGetError());
              o.c("MicroMsg.SameLayerYUVDateRenderToRBGBufferThread", paramEGLContext.toString());
            }
            return;
          }
          paramEGLContext = new StringBuilder();
          paramEGLContext.append("EGL error ");
          paramEGLContext.append(EGL14.eglGetError());
          throw new RuntimeException(paramEGLContext.toString());
        }
        throw new RuntimeException("chooseConfig failed");
      }
      this.m = null;
      throw new RuntimeException("eglInitialize failed");
    }
    throw new RuntimeException("unable to get EGL14 display");
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.b.isAlive()) {
      this.c.a(paramRunnable);
    }
  }
  
  private boolean a(String paramString)
  {
    int i1 = EGL14.eglGetError();
    if (i1 != 12288)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": EGL error: 0x");
      localStringBuilder.append(Integer.toHexString(i1));
      o.h("MicroMsg.SameLayerYUVDateRenderToRBGBufferThread", localStringBuilder.toString(), new Object[0]);
      return true;
    }
    return false;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    o.d("MicroMsg.SameLayerYUVDateRenderToRBGBufferThread", "setFrameInfo, width: %s, height: %s, rotate: %s ,targetWidth:%d ,targetHeight:%d , this: %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), this });
    if ((paramInt1 != this.f) || (paramInt2 != this.g) || (paramInt3 != this.h))
    {
      this.f = paramInt1;
      this.g = paramInt2;
      this.h = paramInt3;
    }
    this.i = paramInt4;
    this.j = paramInt5;
  }
  
  public void a(EGLContext paramEGLContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start context : ");
    localStringBuilder.append(paramEGLContext);
    localStringBuilder.append("  hasStart : ");
    localStringBuilder.append(this.k);
    o.e("MicroMsg.SameLayerYUVDateRenderToRBGBufferThread", localStringBuilder.toString());
    if (!this.k)
    {
      if (paramEGLContext == null) {
        return;
      }
      this.k = true;
      this.b.start();
      this.c = new s(this.b.getLooper());
      a(new a.1(this, paramEGLContext));
    }
  }
  
  public void a(c.a parama)
  {
    this.e = parama;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((!this.k) && (this.d == null)) {
      return;
    }
    a(new a.2(this, paramArrayOfByte, paramInt));
  }
  
  public void b()
  {
    a(new a.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bf.a
 * JD-Core Version:    0.7.0.1
 */