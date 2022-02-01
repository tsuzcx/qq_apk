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
  private static ThreadLocal<Class<BasicTexture>> jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  private static WeakHashMap<BasicTexture, Object> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  protected int a;
  protected GLCanvas a;
  protected int[] a;
  protected int b;
  protected int c = 0;
  protected int d = 0;
  protected int e = -1;
  protected int f = -1;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  
  protected BasicTexture()
  {
    this(null, 0);
  }
  
  protected BasicTexture(GLCanvas arg1, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas = null;
    a(???);
    this.b = paramInt;
    this.jdField_a_of_type_Int = 0;
    synchronized (jdField_a_of_type_JavaUtilWeakHashMap)
    {
      jdField_a_of_type_JavaUtilWeakHashMap.put(this, null);
      return;
    }
  }
  
  public static void c()
  {
    synchronized (jdField_a_of_type_JavaUtilWeakHashMap)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilWeakHashMap.keySet().iterator();
      if (localIterator.hasNext()) {
        ((BasicTexture)localIterator.next()).b();
      }
    }
  }
  
  public static void d()
  {
    synchronized (jdField_a_of_type_JavaUtilWeakHashMap)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilWeakHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        BasicTexture localBasicTexture = (BasicTexture)localIterator.next();
        localBasicTexture.b = 0;
        localBasicTexture.a(null);
      }
    }
  }
  
  public static boolean d()
  {
    return jdField_a_of_type_JavaLangThreadLocal.get() != null;
  }
  
  private void e()
  {
    GLCanvas localGLCanvas = this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas;
    if ((localGLCanvas != null) && (this.jdField_a_of_type_ArrayOfInt != null))
    {
      localGLCanvas.a(this);
      this.jdField_a_of_type_ArrayOfInt = null;
    }
    this.b = 0;
    a(null);
  }
  
  public int a()
  {
    return this.i;
  }
  
  public Rect a()
  {
    return new Rect(this.c, this.d, this.c + this.e, this.d + this.f);
  }
  
  TextureProgram a()
  {
    return TextureProgramFactory.a(this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    e();
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    if (((this.g > 4096) || (this.h > 4096)) && (QLog.isColorLevel())) {
      QLog.w("BasicTexture", 2, String.format("texture is too large: %d x %d", new Object[] { Integer.valueOf(this.g), Integer.valueOf(this.h) }), new Exception());
    }
    if (this.e == -1)
    {
      this.e = paramInt1;
      this.f = paramInt2;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
  }
  
  protected void a(GLCanvas paramGLCanvas)
  {
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas = paramGLCanvas;
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramGLCanvas.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public abstract boolean a(GLCanvas paramGLCanvas);
  
  public byte[] a()
  {
    return null;
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int[] a(GLCanvas paramGLCanvas)
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public ShaderParameter[] a(GLCanvas paramGLCanvas)
  {
    int k = 0;
    TextureProgram localTextureProgram = a();
    GLES20.glUseProgram(localTextureProgram.a());
    Utils.a();
    if ((!b()) || (paramGLCanvas.a() < 0.95F)) {}
    for (boolean bool = true;; bool = false)
    {
      GLES20Canvas.a(bool);
      if (!a(paramGLCanvas)) {
        break;
      }
      int[] arrayOfInt = a();
      while (k < arrayOfInt.length)
      {
        GLES20.glActiveTexture(33984 + k);
        Utils.a();
        GLES20.glBindTexture(g(), arrayOfInt[k]);
        Utils.a();
        GLES20.glUniform1i(localTextureProgram.a()[(k + 4)].jdField_a_of_type_Int, k);
        Utils.a();
        k += 1;
      }
    }
    GLES20.glUniform1f(localTextureProgram.a()[2].jdField_a_of_type_Int, paramGLCanvas.a());
    Utils.a();
    return localTextureProgram.a();
  }
  
  public int b()
  {
    return this.j;
  }
  
  public void b()
  {
    e();
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public abstract boolean b();
  
  public int c()
  {
    return this.e;
  }
  
  public boolean c()
  {
    return this.b == 1;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public int e()
  {
    return this.g;
  }
  
  public int f()
  {
    return this.h;
  }
  
  protected void finalize()
  {
    try
    {
      jdField_a_of_type_JavaLangThreadLocal.set(BasicTexture.class);
      a();
      jdField_a_of_type_JavaLangThreadLocal.set(null);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public abstract int g();
  
  public int h()
  {
    return 0;
  }
  
  public int i()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.texture.BasicTexture
 * JD-Core Version:    0.7.0.1
 */