package com.tencent.av.opengl.ui;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import jko;
import jkp;

public class GLViewGroup
  extends GLView
{
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private Comparator jdField_a_of_type_JavaUtilComparator = new jkp(this);
  private GLView.OnZOrderChangedListener jdField_b_of_type_ComTencentAvOpenglUiGLView$OnZOrderChangedListener = new jko(this);
  private GLView jdField_b_of_type_ComTencentAvOpenglUiGLView;
  protected final Rect c = new Rect();
  protected final Rect d = new Rect();
  
  public GLViewGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public GLView a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }
    return (GLView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  protected void a()
  {
    int i = 0;
    int j = j();
    while (i < j)
    {
      a(i).a();
      i += 1;
    }
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = null;
  }
  
  protected void a(GLCanvas paramGLCanvas, GLView paramGLView)
  {
    if ((paramGLView.f() != 0) && (paramGLView.jdField_a_of_type_AndroidViewAnimationAnimation == null)) {
      return;
    }
    int i = -this.t;
    int j = -this.s;
    paramGLCanvas.a(i, j);
    paramGLView.c(paramGLCanvas);
    paramGLCanvas.a(-i, -j);
  }
  
  public void a(GLView paramGLView)
  {
    if (paramGLView.jdField_a_of_type_ComTencentAvOpenglUiGLView != null) {
      throw new IllegalStateException();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramGLView);
    paramGLView.jdField_a_of_type_ComTencentAvOpenglUiGLView = this;
    paramGLView.a(this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnZOrderChangedListener);
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      paramGLView.b(this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView);
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, GLView paramGLView, boolean paramBoolean)
  {
    Rect localRect = paramGLView.jdField_a_of_type_AndroidGraphicsRect;
    if ((!paramBoolean) || (localRect.contains(paramInt1, paramInt2)))
    {
      if (paramGLView.b(paramMotionEvent)) {}
      while ((this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener != null) && (this.jdField_b_of_type_ComTencentAvOpenglUiGLView$OnTouchListener.a(paramGLView, paramMotionEvent))) {
        return true;
      }
    }
    return false;
  }
  
  protected void b(GLRootView paramGLRootView)
  {
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = paramGLRootView;
    int i = 0;
    int j = j();
    while (i < j)
    {
      a(i).b(paramGLRootView);
      i += 1;
    }
  }
  
  protected boolean b(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    Object localObject;
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLView != null)
    {
      if (i == 0)
      {
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setAction(3);
        a((MotionEvent)localObject, j, k, this.jdField_b_of_type_ComTencentAvOpenglUiGLView, false);
        this.jdField_b_of_type_ComTencentAvOpenglUiGLView = null;
      }
    }
    else
    {
      if (i != 0) {
        break label151;
      }
      i = j() - 1;
      if (i < 0) {
        break label151;
      }
      localObject = a(i);
      if (((GLView)localObject).f() == 0) {
        break label129;
      }
    }
    label129:
    while (!a(paramMotionEvent, j, k, (GLView)localObject, true))
    {
      i -= 1;
      break;
      a(paramMotionEvent, j, k, this.jdField_b_of_type_ComTencentAvOpenglUiGLView, false);
      if ((i == 3) || (i == 1)) {
        this.jdField_b_of_type_ComTencentAvOpenglUiGLView = null;
      }
      return true;
    }
    this.jdField_b_of_type_ComTencentAvOpenglUiGLView = ((GLView)localObject);
    return true;
    label151:
    return super.b(paramMotionEvent);
  }
  
  public void c(GLCanvas paramGLCanvas)
  {
    paramGLCanvas.a(g() / 2, h() / 2, 0.0F);
    a(paramGLCanvas);
    paramGLCanvas.a(-g() / 2, -h() / 2, 0.0F);
    int i = 0;
    int j = j();
    while (i < j)
    {
      a(paramGLCanvas, a(i));
      i += 1;
    }
  }
  
  public void d()
  {
    int i = 0;
    int j = j();
    while (i < j)
    {
      a(i).d();
      i += 1;
    }
  }
  
  public int j()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  protected void k(int paramInt)
  {
    int i = 0;
    int j = j();
    while (i < j)
    {
      GLView localGLView = a(i);
      if (localGLView.f() == 0) {
        localGLView.k(paramInt);
      }
      i += 1;
    }
  }
  
  public void x()
  {
    int j = j();
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
      localGLView.a();
      localGLView.jdField_a_of_type_ComTencentAvOpenglUiGLView = null;
      localGLView.a(null);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLViewGroup
 * JD-Core Version:    0.7.0.1
 */