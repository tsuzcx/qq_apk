package com.tencent.av.opengl.ui;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GLViewGroup
  extends GLView
{
  private ArrayList<GLView> jdField_a_of_type_JavaUtilArrayList;
  private Comparator<GLView> jdField_a_of_type_JavaUtilComparator = new GLViewGroup.SortComparator(this);
  private GLView.OnZOrderChangedListener jdField_b_of_type_ComTencentAvOpenglUiGLView$OnZOrderChangedListener = new GLViewGroup.1(this);
  private GLView jdField_b_of_type_ComTencentAvOpenglUiGLView;
  protected boolean b;
  
  public GLViewGroup(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public GLView a(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (paramInt >= 0) && (paramInt < localArrayList.size())) {
      return (GLView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    throw new ArrayIndexOutOfBoundsException(paramInt);
  }
  
  public void a(GLCanvas paramGLCanvas)
  {
    paramGLCanvas.a(b() / 2, c() / 2, 0.0F);
    c(paramGLCanvas);
    paramGLCanvas.a(-b() / 2, -c() / 2, 0.0F);
    e(paramGLCanvas);
  }
  
  public void a(GLCanvas paramGLCanvas, GLView paramGLView)
  {
    if (!paramGLView.a()) {
      return;
    }
    int i = -this.g;
    int j = -this.f;
    paramGLCanvas.a(i, j);
    paramGLView.a(paramGLCanvas);
    paramGLCanvas.a(-i, -j);
  }
  
  public void a(GLView paramGLView)
  {
    if (paramGLView.jdField_a_of_type_ComTencentAvOpenglUiGLView == null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramGLView);
      paramGLView.jdField_a_of_type_ComTencentAvOpenglUiGLView = this;
      paramGLView.a(this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnZOrderChangedListener);
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
      if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
        paramGLView.b(this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView);
      }
      return;
    }
    throw new IllegalStateException();
  }
  
  protected boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, GLView paramGLView, boolean paramBoolean)
  {
    Rect localRect = paramGLView.jdField_a_of_type_AndroidGraphicsRect;
    if ((!paramBoolean) || (localRect.contains(paramInt1, paramInt2)))
    {
      if (paramGLView.b(paramMotionEvent)) {
        return true;
      }
      if ((this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnTouchListener != null) && (this.jdField_a_of_type_ComTencentAvOpenglUiGLView$OnTouchListener.a(paramGLView, paramMotionEvent))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(GLView paramGLView)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject == null) {
      return false;
    }
    if (((ArrayList)localObject).remove(paramGLView))
    {
      if (this.jdField_b_of_type_ComTencentAvOpenglUiGLView == paramGLView)
      {
        long l = SystemClock.uptimeMillis();
        localObject = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        b((MotionEvent)localObject);
        ((MotionEvent)localObject).recycle();
      }
      paramGLView.d();
      paramGLView.jdField_a_of_type_ComTencentAvOpenglUiGLView = null;
      paramGLView.a(null);
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
      return true;
    }
    return false;
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    int j = e();
    int i = 0;
    while (i < j)
    {
      a(i).a(paramInt1, paramInt2);
      i += 1;
    }
  }
  
  protected void b(GLRootView paramGLRootView)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = paramGLRootView;
    int j = e();
    int i = 0;
    while (i < j)
    {
      a(i).b(paramGLRootView);
      i += 1;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  protected boolean b(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    Object localObject = this.jdField_b_of_type_ComTencentAvOpenglUiGLView;
    if (localObject != null) {
      if (i == 0)
      {
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setAction(3);
        a((MotionEvent)localObject, j, k, this.jdField_b_of_type_ComTencentAvOpenglUiGLView, false);
        this.jdField_b_of_type_ComTencentAvOpenglUiGLView = null;
      }
      else
      {
        a(paramMotionEvent, j, k, (GLView)localObject, false);
        if ((i == 3) || (i == 1)) {
          this.jdField_b_of_type_ComTencentAvOpenglUiGLView = null;
        }
        return true;
      }
    }
    if (i == 0)
    {
      i = e() - 1;
      while (i >= 0)
      {
        localObject = a(i);
        if ((((GLView)localObject).a() == 0) && (a(paramMotionEvent, j, k, (GLView)localObject, true)))
        {
          this.jdField_b_of_type_ComTencentAvOpenglUiGLView = ((GLView)localObject);
          return true;
        }
        i -= 1;
      }
    }
    return super.b(paramMotionEvent);
  }
  
  protected void d()
  {
    int j = e();
    int i = 0;
    while (i < j)
    {
      a(i).d();
      i += 1;
    }
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = null;
  }
  
  protected void d(GLCanvas paramGLCanvas) {}
  
  protected boolean d()
  {
    return false;
  }
  
  public int e()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  protected void e()
  {
    int j = e();
    int i = 0;
    while (i < j)
    {
      a(i).e();
      i += 1;
    }
  }
  
  protected void e(GLCanvas paramGLCanvas)
  {
    int i;
    int j;
    if ((!this.jdField_b_of_type_Boolean) && (!d()))
    {
      i = 0;
      j = e();
    }
    while (i < j)
    {
      a(paramGLCanvas, a(i));
      i += 1;
      continue;
      d(paramGLCanvas);
    }
  }
  
  protected void f(int paramInt)
  {
    int j = e();
    int i = 0;
    while (i < j)
    {
      GLView localGLView = a(i);
      if (localGLView.a() == 0) {
        localGLView.f(paramInt);
      }
      i += 1;
    }
  }
  
  public void h()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      Collections.sort(localArrayList, this.jdField_a_of_type_JavaUtilComparator);
    }
  }
  
  public void i()
  {
    int j = e();
    int i = 0;
    while (i < j)
    {
      GLView localGLView = (GLView)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_b_of_type_ComTencentAvOpenglUiGLView == localGLView)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        b(localMotionEvent);
        localMotionEvent.recycle();
      }
      localGLView.d();
      localGLView.jdField_a_of_type_ComTencentAvOpenglUiGLView = null;
      localGLView.a(null);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  protected void j()
  {
    f();
    int j = e();
    int i = 0;
    while (i < j)
    {
      a(i).f();
      i += 1;
    }
  }
  
  protected void k()
  {
    g();
    int j = e();
    int i = 0;
    while (i < j)
    {
      a(i).g();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLViewGroup
 * JD-Core Version:    0.7.0.1
 */