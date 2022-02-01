package com.tencent.av.opengl.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.animation.Animation;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.texture.BitmapTexture;
import com.tencent.av.opengl.texture.ResourceTexture;
import com.tencent.av.opengl.ui.animation.GLAnimation;
import com.tencent.av.ui.InputTextureInfo;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class GLView
{
  protected float A;
  protected float B;
  protected float C;
  protected float D = 1.0F;
  protected float E = 1.0F;
  protected float F = 1.0F;
  protected List<GLAnimation> G = new ArrayList();
  private SparseArray<Object> H;
  protected boolean a = false;
  protected RenderBuffer b;
  protected InputTextureInfo c = new InputTextureInfo();
  protected final Rect d = new Rect(0, 0, 0, 0);
  protected final Rect e = new Rect(0, 0, 0, 0);
  protected final Rect f = new Rect(0, 0, 0, 0);
  protected GLRootView g;
  protected GLView h;
  protected int i = 0;
  protected int j = 0;
  protected int k = 0;
  protected int l = -1;
  protected int m = -1;
  protected int n = 0;
  protected int o = 0;
  protected BasicTexture p;
  protected int q = 0;
  protected int r = -16777216;
  protected Object s;
  protected int t = 0;
  protected Animation u;
  protected BasicTexture v;
  protected WeakReference<Context> w;
  protected GLView.OnTouchListener x;
  protected GLView.OnZOrderChangedListener y;
  protected float z;
  
  public GLView(Context paramContext)
  {
    this.w = new WeakReference(paramContext);
  }
  
  public List<GLAnimation> a()
  {
    return this.G;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == b()) {
      return;
    }
    if (paramInt == 0) {
      this.i &= 0xFFFFFFFE;
    } else {
      this.i |= 0x1;
    }
    g(paramInt);
    m();
  }
  
  protected void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f.set(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.H == null) {
      this.H = new SparseArray();
    }
    this.H.put(paramInt, paramObject);
  }
  
  public void a(long paramLong)
  {
    int i1;
    int i2;
    label110:
    synchronized (this.G)
    {
      if (this.G.size() > 0)
      {
        m();
        i1 = 0;
        i2 = this.G.size();
        if (i1 < i2) {
          try
          {
            boolean bool = ((GLAnimation)this.G.get(i1)).a(paramLong);
            i2 = i1;
            if (!bool) {
              break label110;
            }
            i2 = i1 - 1;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            i2 = i1;
          }
        }
      }
      return;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    BasicTexture localBasicTexture = this.p;
    if (localBasicTexture != null)
    {
      localBasicTexture.n();
      this.p = null;
    }
    if (paramBitmap != null)
    {
      this.p = new BitmapTexture(paramBitmap);
      this.q = 0;
    }
  }
  
  public void a(GLCanvas paramGLCanvas)
  {
    a(System.currentTimeMillis());
    int i1 = this.d.left;
    int i2 = this.d.top;
    paramGLCanvas.f();
    GLAnimation localGLAnimation;
    if (this.G.size() > 0) {
      localGLAnimation = (GLAnimation)this.G.get(0);
    } else {
      localGLAnimation = null;
    }
    if ((localGLAnimation != null) && (localGLAnimation.a())) {
      paramGLCanvas.a(localGLAnimation.b(), localGLAnimation.c(), localGLAnimation.d());
    } else {
      paramGLCanvas.a(i1, i2, this.z);
    }
    float f1 = this.D;
    f1 = this.E;
    f1 = this.F;
    if ((localGLAnimation != null) && (localGLAnimation.e()))
    {
      f1 = localGLAnimation.f();
      float f2 = localGLAnimation.g();
      b(i1, i2, (int)(i1 + f1), (int)(i2 + f2));
    }
    paramGLCanvas.a(g() / 2, h() / 2, 0.0F);
    if ((localGLAnimation != null) && (localGLAnimation.h()))
    {
      paramGLCanvas.a(localGLAnimation.i(), 1.0F, 0.0F, 0.0F);
      paramGLCanvas.a(localGLAnimation.j(), 0.0F, 1.0F, 0.0F);
      paramGLCanvas.a(localGLAnimation.k(), 0.0F, 0.0F, 1.0F);
    }
    else
    {
      f1 = this.A;
      if (f1 != 0.0F) {
        paramGLCanvas.a(f1, 1.0F, 0.0F, 0.0F);
      }
      f1 = this.B;
      if (f1 != 0.0F) {
        paramGLCanvas.a(f1, 0.0F, 1.0F, 0.0F);
      }
      f1 = this.C;
      if (f1 != 0.0F) {
        paramGLCanvas.a(f1, 0.0F, 0.0F, 1.0F);
      }
    }
    c(paramGLCanvas);
    b(paramGLCanvas);
    paramGLCanvas.g();
  }
  
  public void a(BitmapTexture paramBitmapTexture)
  {
    BasicTexture localBasicTexture = this.p;
    if (localBasicTexture != null)
    {
      localBasicTexture.n();
      this.p = null;
    }
    if (paramBitmapTexture != null)
    {
      this.p = paramBitmapTexture;
      this.q = 0;
    }
  }
  
  public void a(GLRootView paramGLRootView)
  {
    b(paramGLRootView);
  }
  
  public void a(GLView.OnTouchListener paramOnTouchListener)
  {
    this.x = paramOnTouchListener;
  }
  
  protected void a(GLView.OnZOrderChangedListener paramOnZOrderChangedListener)
  {
    this.y = paramOnZOrderChangedListener;
  }
  
  public void a(GLAnimation paramGLAnimation)
  {
    List localList = this.G;
    if (paramGLAnimation != null) {}
    try
    {
      paramGLAnimation.a(this);
      paramGLAnimation.l();
      this.G.add(paramGLAnimation);
      m();
      return;
    }
    finally {}
  }
  
  public void a(Object paramObject)
  {
    this.s = paramObject;
  }
  
  public void a(Runnable paramRunnable)
  {
    GLRootView localGLRootView = i();
    if (localGLRootView != null) {
      localGLRootView.post(paramRunnable);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    GLRootView localGLRootView = i();
    if (localGLRootView != null) {
      localGLRootView.postDelayed(paramRunnable, paramLong);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public int b()
  {
    int i2 = this.i;
    int i1 = 1;
    if ((i2 & 0x1) == 0) {
      i1 = 0;
    }
    return i1;
  }
  
  public void b(int paramInt) {}
  
  protected void b(GLCanvas paramGLCanvas)
  {
    if (this.v == null) {
      return;
    }
    int i1 = g();
    int i2 = h();
    Rect localRect = e();
    int i3 = localRect.left;
    int i4 = localRect.right;
    int i5 = localRect.top;
    int i6 = localRect.bottom;
    int i7 = localRect.left;
    int i8 = localRect.top;
    paramGLCanvas.a(2);
    this.v.a(paramGLCanvas, i7, i8, i1 - i3 - i4, i2 - i5 - i6);
    paramGLCanvas.g();
  }
  
  protected void b(GLRootView paramGLRootView)
  {
    this.g = paramGLRootView;
  }
  
  public boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool;
    if ((paramInt3 - paramInt1 == this.d.right - this.d.left) && (paramInt4 - paramInt2 == this.d.bottom - this.d.top)) {
      bool = false;
    } else {
      bool = true;
    }
    this.d.set(paramInt1, paramInt2, paramInt3, paramInt4);
    return bool;
  }
  
  protected boolean b(MotionEvent paramMotionEvent)
  {
    if (b() == 0)
    {
      GLView.OnTouchListener localOnTouchListener = this.x;
      if ((localOnTouchListener != null) && (localOnTouchListener.a(this, paramMotionEvent))) {
        return true;
      }
    }
    return a(paramMotionEvent);
  }
  
  public void c(int paramInt)
  {
    int i1 = this.t;
    if (i1 != paramInt)
    {
      this.t = paramInt;
      GLView.OnZOrderChangedListener localOnZOrderChangedListener = this.y;
      if (localOnZOrderChangedListener != null) {
        localOnZOrderChangedListener.a(this, paramInt, i1);
      }
    }
  }
  
  @SuppressLint({"WrongCall"})
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.i &= 0xFFFFFFFB;
    a(bool, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void c(GLCanvas paramGLCanvas)
  {
    if (this.p != null)
    {
      i1 = g();
      i2 = h();
      this.p.a(paramGLCanvas, 0, 0, i1, i2);
      return;
    }
    int i1 = g();
    int i2 = h();
    paramGLCanvas.a(0.0F, 0.0F, i1, i2, this.r);
  }
  
  public boolean c()
  {
    return (b() == 0) || (this.u != null);
  }
  
  public Object d(int paramInt)
  {
    SparseArray localSparseArray = this.H;
    if (localSparseArray != null) {
      return localSparseArray.get(paramInt);
    }
    return null;
  }
  
  public void d()
  {
    o();
  }
  
  public Rect e()
  {
    return this.f;
  }
  
  public void e(int paramInt)
  {
    this.r = paramInt;
  }
  
  public Rect f()
  {
    return this.d;
  }
  
  public void f(int paramInt)
  {
    if ((paramInt != 0) && (paramInt == this.q)) {
      return;
    }
    Object localObject = i();
    if (localObject != null)
    {
      BasicTexture localBasicTexture = this.p;
      ResourceTexture localResourceTexture = null;
      if (localBasicTexture != null)
      {
        localBasicTexture.n();
        this.p = null;
      }
      localObject = ((GLRootView)localObject).getContext();
      if (paramInt != 0) {
        localResourceTexture = new ResourceTexture((Context)localObject, paramInt);
      }
      this.p = localResourceTexture;
      this.q = paramInt;
      return;
    }
    throw new RuntimeException("Cannot set resource background before attach to GLRootView!");
  }
  
  protected void finalize()
  {
    try
    {
      if (this.v != null)
      {
        this.v.n();
        this.v = null;
      }
      if (this.p != null)
      {
        this.p.n();
        this.p = null;
        this.q = 0;
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int g()
  {
    return this.d.right - this.d.left;
  }
  
  protected void g(int paramInt) {}
  
  public int h()
  {
    return this.d.bottom - this.d.top;
  }
  
  public GLRootView i()
  {
    return this.g;
  }
  
  public int j()
  {
    return this.t;
  }
  
  public boolean k()
  {
    return this.a;
  }
  
  public Object l()
  {
    return this.s;
  }
  
  public void m()
  {
    GLRootView localGLRootView = i();
    if (localGLRootView != null) {
      localGLRootView.requestRender();
    }
  }
  
  public void n()
  {
    this.i |= 0x4;
    this.m = -1;
    this.l = -1;
    Object localObject = this.h;
    if (localObject != null)
    {
      ((GLView)localObject).n();
      return;
    }
    localObject = i();
    if (localObject != null) {
      ((GLRootView)localObject).a();
    }
  }
  
  protected void o()
  {
    this.g = null;
  }
  
  protected void p() {}
  
  protected void q() {}
  
  protected void r() {}
  
  public boolean s()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLView
 * JD-Core Version:    0.7.0.1
 */