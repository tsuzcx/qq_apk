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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class GLView
{
  protected final Rect a;
  private SparseArray a;
  protected Animation a;
  protected GLView.OnZOrderChangedListener a;
  protected GLView a;
  protected Object a;
  protected WeakReference a;
  protected float b;
  protected final Rect b;
  protected GLRootView b;
  protected GLView.OnTouchListener b;
  protected float c;
  public BasicTexture c;
  protected List c;
  protected float d;
  protected BasicTexture d;
  protected float e;
  protected float f = 1.0F;
  protected float g = 1.0F;
  protected float h = 1.0F;
  protected int p;
  protected int q = -1;
  protected int r = -1;
  protected int s;
  protected int t;
  protected int u;
  public int v = -16777216;
  protected int w;
  
  public GLView(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
  }
  
  public Rect a()
  {
    return this.jdField_b_of_type_AndroidGraphicsRect;
  }
  
  public GLRootView a()
  {
    return this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public Object a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = null;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramObject);
  }
  
  public void a(GLCanvas paramGLCanvas)
  {
    if (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null)
    {
      i = g();
      j = h();
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, i, j);
      return;
    }
    int i = g();
    int j = h();
    paramGLCanvas.a(0.0F, 0.0F, i, j, this.v);
  }
  
  public void a(GLRootView paramGLRootView)
  {
    b(paramGLRootView);
  }
  
  public void a(GLView.OnTouchListener paramOnTouchListener)
  {
    this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener = paramOnTouchListener;
  }
  
  protected void a(GLView.OnZOrderChangedListener paramOnZOrderChangedListener)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnZOrderChangedListener = paramOnZOrderChangedListener;
  }
  
  public void a(GLAnimation paramGLAnimation)
  {
    List localList = this.jdField_c_of_type_JavaUtilList;
    if (paramGLAnimation != null) {}
    try
    {
      paramGLAnimation.a(this);
      paramGLAnimation.a();
      this.jdField_c_of_type_JavaUtilList.add(paramGLAnimation);
      v();
      return;
    }
    finally {}
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(Runnable paramRunnable)
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.post(paramRunnable);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.postDelayed(paramRunnable, paramLong);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 - paramInt1 != this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left) || (paramInt4 - paramInt2 != this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
      return bool;
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public Rect b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  @SuppressLint({"WrongCall"})
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.p &= 0xFFFFFFFB;
    a(bool, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void b(long paramLong)
  {
    label101:
    for (;;)
    {
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        if (this.jdField_c_of_type_JavaUtilList.size() > 0)
        {
          v();
          int i = 0;
          int j = this.jdField_c_of_type_JavaUtilList.size();
          if (i < j) {
            try
            {
              boolean bool = ((GLAnimation)this.jdField_c_of_type_JavaUtilList.get(i)).a(paramLong);
              if (!bool) {
                break label101;
              }
              i -= 1;
              i += 1;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              break label101;
            }
          }
        }
        return;
      }
    }
  }
  
  public void b(Bitmap paramBitmap)
  {
    if (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null)
    {
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a();
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture = null;
    }
    if (paramBitmap != null)
    {
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture = new BitmapTexture(paramBitmap);
      this.u = 0;
    }
  }
  
  public void b(GLCanvas paramGLCanvas)
  {
    if (this.jdField_d_of_type_ComTencentAvOpenglTextureBasicTexture == null) {
      return;
    }
    int i = g();
    int j = h();
    Rect localRect = a();
    int k = localRect.left;
    int m = localRect.right;
    int n = localRect.top;
    int i1 = localRect.bottom;
    int i2 = localRect.left;
    int i3 = localRect.top;
    paramGLCanvas.a(2);
    this.jdField_d_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, i2, i3, i - k - m, j - n - i1);
    paramGLCanvas.c();
  }
  
  protected void b(GLRootView paramGLRootView)
  {
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = paramGLRootView;
  }
  
  protected boolean b(MotionEvent paramMotionEvent)
  {
    if ((f() == 0) && (this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener != null) && (this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener.a(this, paramMotionEvent))) {
      return true;
    }
    return a(paramMotionEvent);
  }
  
  public void c(GLCanvas paramGLCanvas)
  {
    b(System.currentTimeMillis());
    int i = this.jdField_a_of_type_AndroidGraphicsRect.left;
    int j = this.jdField_a_of_type_AndroidGraphicsRect.top;
    paramGLCanvas.b();
    GLAnimation localGLAnimation = null;
    if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
      localGLAnimation = (GLAnimation)this.jdField_c_of_type_JavaUtilList.get(0);
    }
    if ((localGLAnimation != null) && (localGLAnimation.a()))
    {
      paramGLCanvas.a(localGLAnimation.a(), localGLAnimation.b(), localGLAnimation.c());
      float f1 = this.f;
      f1 = this.g;
      f1 = this.h;
      if ((localGLAnimation != null) && (localGLAnimation.b()))
      {
        f1 = localGLAnimation.d();
        float f2 = localGLAnimation.e();
        a(i, j, (int)(f1 + i), (int)(f2 + j));
      }
      paramGLCanvas.a(g() / 2, h() / 2, 0.0F);
      if ((localGLAnimation == null) || (!localGLAnimation.c())) {
        break label268;
      }
      paramGLCanvas.a(localGLAnimation.f(), 1.0F, 0.0F, 0.0F);
      paramGLCanvas.a(localGLAnimation.g(), 0.0F, 1.0F, 0.0F);
      paramGLCanvas.a(localGLAnimation.h(), 0.0F, 0.0F, 1.0F);
    }
    for (;;)
    {
      a(paramGLCanvas);
      b(paramGLCanvas);
      paramGLCanvas.c();
      return;
      paramGLCanvas.a(i, j, this.jdField_b_of_type_Float);
      break;
      label268:
      if (this.jdField_c_of_type_Float != 0.0F) {
        paramGLCanvas.a(this.jdField_c_of_type_Float, 1.0F, 0.0F, 0.0F);
      }
      if (this.jdField_d_of_type_Float != 0.0F) {
        paramGLCanvas.a(this.jdField_d_of_type_Float, 0.0F, 1.0F, 0.0F);
      }
      if (this.e != 0.0F) {
        paramGLCanvas.a(this.e, 0.0F, 0.0F, 1.0F);
      }
    }
  }
  
  public void d() {}
  
  public int f()
  {
    if ((this.p & 0x1) == 0) {
      return 0;
    }
    return 1;
  }
  
  public void finalize()
  {
    try
    {
      if (this.jdField_d_of_type_ComTencentAvOpenglTextureBasicTexture != null)
      {
        this.jdField_d_of_type_ComTencentAvOpenglTextureBasicTexture.a();
        this.jdField_d_of_type_ComTencentAvOpenglTextureBasicTexture = null;
      }
      if (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null)
      {
        this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a();
        this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture = null;
        this.u = 0;
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
    return this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left;
  }
  
  public void g(int paramInt)
  {
    if (paramInt == f()) {
      return;
    }
    if (paramInt == 0) {}
    for (this.p &= 0xFFFFFFFE;; this.p |= 0x1)
    {
      k(paramInt);
      v();
      return;
    }
  }
  
  public int h()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
  }
  
  public void h(int paramInt)
  {
    if (this.w != paramInt)
    {
      int i = this.w;
      this.w = paramInt;
      if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnZOrderChangedListener != null) {
        this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnZOrderChangedListener.a(this, paramInt, i);
      }
    }
  }
  
  public int i()
  {
    return this.w;
  }
  
  public void i(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void j(int paramInt)
  {
    ResourceTexture localResourceTexture = null;
    if ((paramInt != 0) && (paramInt == this.u)) {
      return;
    }
    Object localObject = a();
    if (localObject == null) {
      throw new RuntimeException("Cannot set resource background before attach to GLRootView!");
    }
    if (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null)
    {
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a();
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture = null;
    }
    localObject = ((GLRootView)localObject).getContext();
    if (paramInt == 0) {}
    for (;;)
    {
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture = localResourceTexture;
      this.u = paramInt;
      return;
      localResourceTexture = new ResourceTexture((Context)localObject, paramInt);
    }
  }
  
  protected void k(int paramInt) {}
  
  public void u()
  {
    a();
  }
  
  public void v()
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.requestRender();
    }
  }
  
  public void w()
  {
    this.p |= 0x4;
    this.r = -1;
    this.q = -1;
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLView.w();
    }
    GLRootView localGLRootView;
    do
    {
      return;
      localGLRootView = a();
    } while (localGLRootView == null);
    localGLRootView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLView
 * JD-Core Version:    0.7.0.1
 */