package com.tencent.av.opengl.texture;

import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class BasicTexture
{
  private static WeakHashMap<BasicTexture, Object> o = new WeakHashMap();
  private static ThreadLocal<Class<BasicTexture>> p = new ThreadLocal();
  protected int[] a;
  protected int[] b;
  protected int c;
  protected int d;
  protected int e = 0;
  protected int f = 0;
  protected int g = -1;
  protected int h = -1;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  public boolean m = false;
  protected GLCanvas n = null;
  
  protected BasicTexture()
  {
    this(null, 0);
  }
  
  protected BasicTexture(GLCanvas arg1, int paramInt)
  {
    a(???);
    this.d = paramInt;
    this.c = 0;
    synchronized (o)
    {
      o.put(this, null);
      return;
    }
  }
  
  public static boolean p()
  {
    return p.get() != null;
  }
  
  public static void q()
  {
    synchronized (o)
    {
      Iterator localIterator = o.keySet().iterator();
      while (localIterator.hasNext()) {
        ((BasicTexture)localIterator.next()).o();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void r()
  {
    synchronized (o)
    {
      Iterator localIterator = o.keySet().iterator();
      while (localIterator.hasNext())
      {
        BasicTexture localBasicTexture = (BasicTexture)localIterator.next();
        localBasicTexture.d = 0;
        localBasicTexture.a(null);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void v()
  {
    GLCanvas localGLCanvas = this.n;
    if ((localGLCanvas != null) && (this.a != null))
    {
      localGLCanvas.a(this);
      this.a = null;
    }
    this.d = 0;
    a(null);
  }
  
  public int a()
  {
    return this.k;
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
    if (((this.i > 4096) || (this.j > 4096)) && (QLog.isColorLevel())) {
      QLog.w("BasicTexture", 2, String.format("texture is too large: %d x %d", new Object[] { Integer.valueOf(this.i), Integer.valueOf(this.j) }), new Exception());
    }
    if (this.g == -1)
    {
      this.g = paramInt1;
      this.h = paramInt2;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
  }
  
  protected void a(GLCanvas paramGLCanvas)
  {
    this.n = paramGLCanvas;
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramGLCanvas.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int b()
  {
    return this.l;
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public abstract boolean b(GLCanvas paramGLCanvas);
  
  TextureProgram c()
  {
    return TextureProgramFactory.a(this.c);
  }
  
  public ShaderParameter[] c(GLCanvas paramGLCanvas)
  {
    TextureProgram localTextureProgram = c();
    GLES20.glUseProgram(localTextureProgram.a());
    Utils.a();
    boolean bool = k();
    int i1 = 0;
    if ((bool) && (paramGLCanvas.e() >= 0.95F)) {
      bool = false;
    } else {
      bool = true;
    }
    GLES20Canvas.a(bool);
    if (b(paramGLCanvas))
    {
      int[] arrayOfInt = e();
      while ((arrayOfInt != null) && (i1 < arrayOfInt.length))
      {
        GLES20.glActiveTexture(33984 + i1);
        Utils.a();
        GLES20.glBindTexture(l(), arrayOfInt[i1]);
        Utils.a();
        GLES20.glUniform1i(localTextureProgram.b()[(i1 + 4)].a, i1);
        Utils.a();
        i1 += 1;
      }
    }
    GLES20.glUniform1f(localTextureProgram.b()[2].a, paramGLCanvas.e());
    Utils.a();
    return localTextureProgram.b();
  }
  
  public boolean d()
  {
    return false;
  }
  
  public int[] e()
  {
    if (this.m)
    {
      if (this.b == null) {
        this.b = new int[1];
      }
      return this.b;
    }
    return this.a;
  }
  
  public int f()
  {
    return this.g;
  }
  
  protected void finalize()
  {
    try
    {
      p.set(BasicTexture.class);
      n();
      p.set(null);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int g()
  {
    return this.h;
  }
  
  public Rect h()
  {
    int i1 = this.e;
    int i2 = this.f;
    return new Rect(i1, i2, this.g + i1, this.h + i2);
  }
  
  public int i()
  {
    return this.i;
  }
  
  public int j()
  {
    return this.j;
  }
  
  public abstract boolean k();
  
  public abstract int l();
  
  public boolean m()
  {
    return this.d == 1;
  }
  
  public void n()
  {
    v();
  }
  
  public void o()
  {
    v();
  }
  
  public byte[] s()
  {
    return null;
  }
  
  public int t()
  {
    return 0;
  }
  
  public int u()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.BasicTexture
 * JD-Core Version:    0.7.0.1
 */