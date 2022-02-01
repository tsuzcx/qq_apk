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
  protected float a;
  protected int a;
  protected final Rect a;
  private SparseArray<Object> a;
  protected Animation a;
  protected BasicTexture a;
  protected GLRootView a;
  protected GLView.OnTouchListener a;
  protected GLView.OnZOrderChangedListener a;
  protected GLView a;
  protected InputTextureInfo a;
  protected RenderBuffer a;
  protected Object a;
  protected WeakReference<Context> a;
  protected List<GLAnimation> a;
  protected boolean a;
  protected float b;
  protected int b;
  protected final Rect b;
  protected BasicTexture b;
  protected float c;
  protected int c;
  protected final Rect c;
  protected float d;
  protected int d;
  protected float e;
  protected int e;
  protected float f;
  protected int f;
  protected float g;
  protected int g;
  protected int h = 0;
  protected int i = -16777216;
  protected int j = 0;
  
  public GLView(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUiInputTextureInfo = new InputTextureInfo();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_e_of_type_Float = 1.0F;
    this.jdField_f_of_type_Float = 1.0F;
    this.jdField_g_of_type_Float = 1.0F;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
  }
  
  public int a()
  {
    int m = this.jdField_a_of_type_Int;
    int k = 1;
    if ((m & 0x1) == 0) {
      k = 0;
    }
    return k;
  }
  
  public Rect a()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect;
  }
  
  public GLRootView a()
  {
    return this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public Object a(int paramInt)
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    if (localSparseArray != null) {
      return localSparseArray.get(paramInt);
    }
    return null;
  }
  
  public List<GLAnimation> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    d();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == a()) {
      return;
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_Int &= 0xFFFFFFFE;
    } else {
      this.jdField_a_of_type_Int |= 0x1;
    }
    f(paramInt);
    b();
  }
  
  protected void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_c_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramObject);
  }
  
  public void a(long paramLong)
  {
    int k;
    int m;
    label110:
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        b();
        k = 0;
        m = this.jdField_a_of_type_JavaUtilList.size();
        if (k < m) {
          try
          {
            boolean bool = ((GLAnimation)this.jdField_a_of_type_JavaUtilList.get(k)).a(paramLong);
            m = k;
            if (!bool) {
              break label110;
            }
            m = k - 1;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            m = k;
          }
        }
      }
      return;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    BasicTexture localBasicTexture = this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture;
    if (localBasicTexture != null)
    {
      localBasicTexture.a();
      this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture = null;
    }
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture = new BitmapTexture(paramBitmap);
      this.h = 0;
    }
  }
  
  public void a(GLCanvas paramGLCanvas)
  {
    a(System.currentTimeMillis());
    int k = this.jdField_a_of_type_AndroidGraphicsRect.left;
    int m = this.jdField_a_of_type_AndroidGraphicsRect.top;
    paramGLCanvas.b();
    GLAnimation localGLAnimation;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      localGLAnimation = (GLAnimation)this.jdField_a_of_type_JavaUtilList.get(0);
    } else {
      localGLAnimation = null;
    }
    if ((localGLAnimation != null) && (localGLAnimation.a())) {
      paramGLCanvas.a(localGLAnimation.a(), localGLAnimation.b(), localGLAnimation.c());
    } else {
      paramGLCanvas.a(k, m, this.jdField_a_of_type_Float);
    }
    float f1 = this.jdField_e_of_type_Float;
    f1 = this.jdField_f_of_type_Float;
    f1 = this.jdField_g_of_type_Float;
    if ((localGLAnimation != null) && (localGLAnimation.b()))
    {
      f1 = localGLAnimation.d();
      float f2 = localGLAnimation.e();
      a(k, m, (int)(k + f1), (int)(m + f2));
    }
    paramGLCanvas.a(b() / 2, c() / 2, 0.0F);
    if ((localGLAnimation != null) && (localGLAnimation.c()))
    {
      paramGLCanvas.a(localGLAnimation.f(), 1.0F, 0.0F, 0.0F);
      paramGLCanvas.a(localGLAnimation.g(), 0.0F, 1.0F, 0.0F);
      paramGLCanvas.a(localGLAnimation.h(), 0.0F, 0.0F, 1.0F);
    }
    else
    {
      f1 = this.jdField_b_of_type_Float;
      if (f1 != 0.0F) {
        paramGLCanvas.a(f1, 1.0F, 0.0F, 0.0F);
      }
      f1 = this.jdField_c_of_type_Float;
      if (f1 != 0.0F) {
        paramGLCanvas.a(f1, 0.0F, 1.0F, 0.0F);
      }
      f1 = this.jdField_d_of_type_Float;
      if (f1 != 0.0F) {
        paramGLCanvas.a(f1, 0.0F, 0.0F, 1.0F);
      }
    }
    c(paramGLCanvas);
    b(paramGLCanvas);
    paramGLCanvas.c();
  }
  
  public void a(BitmapTexture paramBitmapTexture)
  {
    BasicTexture localBasicTexture = this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture;
    if (localBasicTexture != null)
    {
      localBasicTexture.a();
      this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture = null;
    }
    if (paramBitmapTexture != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture = paramBitmapTexture;
      this.h = 0;
    }
  }
  
  public void a(GLRootView paramGLRootView)
  {
    b(paramGLRootView);
  }
  
  public void a(GLView.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnTouchListener = paramOnTouchListener;
  }
  
  protected void a(GLView.OnZOrderChangedListener paramOnZOrderChangedListener)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnZOrderChangedListener = paramOnZOrderChangedListener;
  }
  
  public void a(GLAnimation paramGLAnimation)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (paramGLAnimation != null) {}
    try
    {
      paramGLAnimation.a(this);
      paramGLAnimation.a();
      this.jdField_a_of_type_JavaUtilList.add(paramGLAnimation);
      b();
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
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean a()
  {
    return (a() == 0) || (this.jdField_a_of_type_AndroidViewAnimationAnimation != null);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool;
    if ((paramInt3 - paramInt1 == this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left) && (paramInt4 - paramInt2 == this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top)) {
      bool = false;
    } else {
      bool = true;
    }
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
    return bool;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left;
  }
  
  public Rect b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public void b()
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.requestRender();
    }
  }
  
  public void b(int paramInt) {}
  
  @SuppressLint({"WrongCall"})
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int &= 0xFFFFFFFB;
    a(bool, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void b(GLCanvas paramGLCanvas)
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture == null) {
      return;
    }
    int k = b();
    int m = c();
    Rect localRect = a();
    int n = localRect.left;
    int i1 = localRect.right;
    int i2 = localRect.top;
    int i3 = localRect.bottom;
    int i4 = localRect.left;
    int i5 = localRect.top;
    paramGLCanvas.a(2);
    this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, i4, i5, k - n - i1, m - i2 - i3);
    paramGLCanvas.c();
  }
  
  protected void b(GLRootView paramGLRootView)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = paramGLRootView;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected boolean b(MotionEvent paramMotionEvent)
  {
    if (a() == 0)
    {
      GLView.OnTouchListener localOnTouchListener = this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnTouchListener;
      if ((localOnTouchListener != null) && (localOnTouchListener.a(this, paramMotionEvent))) {
        return true;
      }
    }
    return a(paramMotionEvent);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int |= 0x4;
    this.jdField_e_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    Object localObject = this.jdField_a_of_type_ComTencentAvOpenglUiGLView;
    if (localObject != null)
    {
      ((GLView)localObject).c();
      return;
    }
    localObject = a();
    if (localObject != null) {
      ((GLRootView)localObject).a();
    }
  }
  
  public void c(int paramInt)
  {
    int k = this.j;
    if (k != paramInt)
    {
      this.j = paramInt;
      GLView.OnZOrderChangedListener localOnZOrderChangedListener = this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnZOrderChangedListener;
      if (localOnZOrderChangedListener != null) {
        localOnZOrderChangedListener.a(this, paramInt, k);
      }
    }
  }
  
  protected void c(GLCanvas paramGLCanvas)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture != null)
    {
      k = b();
      m = c();
      this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, k, m);
      return;
    }
    int k = b();
    int m = c();
    paramGLCanvas.a(0.0F, 0.0F, k, m, this.i);
  }
  
  public boolean c()
  {
    return false;
  }
  
  public int d()
  {
    return this.j;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = null;
  }
  
  public void d(int paramInt)
  {
    this.i = paramInt;
  }
  
  protected void e() {}
  
  public void e(int paramInt)
  {
    if ((paramInt != 0) && (paramInt == this.h)) {
      return;
    }
    Object localObject = a();
    if (localObject != null)
    {
      BasicTexture localBasicTexture = this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture;
      ResourceTexture localResourceTexture = null;
      if (localBasicTexture != null)
      {
        localBasicTexture.a();
        this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture = null;
      }
      localObject = ((GLRootView)localObject).getContext();
      if (paramInt != 0) {
        localResourceTexture = new ResourceTexture((Context)localObject, paramInt);
      }
      this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture = localResourceTexture;
      this.h = paramInt;
      return;
    }
    throw new RuntimeException("Cannot set resource background before attach to GLRootView!");
  }
  
  protected void f() {}
  
  protected void f(int paramInt) {}
  
  protected void finalize()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture != null)
      {
        this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture.a();
        this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture = null;
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.a();
        this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture = null;
        this.h = 0;
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  protected void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLView
 * JD-Core Version:    0.7.0.1
 */