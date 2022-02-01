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
  protected boolean H = false;
  private ArrayList<GLView> I;
  private GLView J;
  private GLView.OnZOrderChangedListener K = new GLViewGroup.1(this);
  private Comparator<GLView> L = new GLViewGroup.SortComparator(this);
  
  public GLViewGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(GLCanvas paramGLCanvas)
  {
    paramGLCanvas.a(g() / 2, h() / 2, 0.0F);
    c(paramGLCanvas);
    paramGLCanvas.a(-g() / 2, -h() / 2, 0.0F);
    e(paramGLCanvas);
  }
  
  public void a(GLCanvas paramGLCanvas, GLView paramGLView)
  {
    if (!paramGLView.c()) {
      return;
    }
    int i = -this.o;
    int j = -this.n;
    paramGLCanvas.a(i, j);
    paramGLView.a(paramGLCanvas);
    paramGLCanvas.a(-i, -j);
  }
  
  public void a(GLView paramGLView)
  {
    if (paramGLView.h == null)
    {
      if (this.I == null) {
        this.I = new ArrayList();
      }
      this.I.add(paramGLView);
      paramGLView.h = this;
      paramGLView.a(this.K);
      Collections.sort(this.I, this.L);
      if (this.g != null) {
        paramGLView.b(this.g);
      }
      return;
    }
    throw new IllegalStateException();
  }
  
  protected boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, GLView paramGLView, boolean paramBoolean)
  {
    Rect localRect = paramGLView.d;
    if ((!paramBoolean) || (localRect.contains(paramInt1, paramInt2)))
    {
      if (paramGLView.b(paramMotionEvent)) {
        return true;
      }
      if ((this.x != null) && (this.x.a(paramGLView, paramMotionEvent))) {
        return true;
      }
    }
    return false;
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    int j = t();
    int i = 0;
    while (i < j)
    {
      h(i).a(paramInt1, paramInt2);
      i += 1;
    }
  }
  
  protected void b(GLRootView paramGLRootView)
  {
    this.g = paramGLRootView;
    int j = t();
    int i = 0;
    while (i < j)
    {
      h(i).b(paramGLRootView);
      i += 1;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  protected boolean b(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    Object localObject = this.J;
    if (localObject != null) {
      if (i == 0)
      {
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setAction(3);
        a((MotionEvent)localObject, j, k, this.J, false);
        this.J = null;
      }
      else
      {
        a(paramMotionEvent, j, k, (GLView)localObject, false);
        if ((i == 3) || (i == 1)) {
          this.J = null;
        }
        return true;
      }
    }
    if (i == 0)
    {
      i = t() - 1;
      while (i >= 0)
      {
        localObject = h(i);
        if ((((GLView)localObject).b() == 0) && (a(paramMotionEvent, j, k, (GLView)localObject, true)))
        {
          this.J = ((GLView)localObject);
          return true;
        }
        i -= 1;
      }
    }
    return super.b(paramMotionEvent);
  }
  
  public boolean b(GLView paramGLView)
  {
    Object localObject = this.I;
    if (localObject == null) {
      return false;
    }
    if (((ArrayList)localObject).remove(paramGLView))
    {
      if (this.J == paramGLView)
      {
        long l = SystemClock.uptimeMillis();
        localObject = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        b((MotionEvent)localObject);
        ((MotionEvent)localObject).recycle();
      }
      paramGLView.o();
      paramGLView.h = null;
      paramGLView.a(null);
      Collections.sort(this.I, this.L);
      return true;
    }
    return false;
  }
  
  protected void d(GLCanvas paramGLCanvas) {}
  
  protected void e(GLCanvas paramGLCanvas)
  {
    int i;
    int j;
    if ((!this.H) && (!y()))
    {
      i = 0;
      j = t();
    }
    while (i < j)
    {
      a(paramGLCanvas, h(i));
      i += 1;
      continue;
      d(paramGLCanvas);
    }
  }
  
  protected void g(int paramInt)
  {
    int j = t();
    int i = 0;
    while (i < j)
    {
      GLView localGLView = h(i);
      if (localGLView.b() == 0) {
        localGLView.g(paramInt);
      }
      i += 1;
    }
  }
  
  public GLView h(int paramInt)
  {
    ArrayList localArrayList = this.I;
    if ((localArrayList != null) && (paramInt >= 0) && (paramInt < localArrayList.size())) {
      return (GLView)this.I.get(paramInt);
    }
    throw new ArrayIndexOutOfBoundsException(paramInt);
  }
  
  protected void o()
  {
    int j = t();
    int i = 0;
    while (i < j)
    {
      h(i).o();
      i += 1;
    }
    this.g = null;
  }
  
  protected void p()
  {
    int j = t();
    int i = 0;
    while (i < j)
    {
      h(i).p();
      i += 1;
    }
  }
  
  public int t()
  {
    ArrayList localArrayList = this.I;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public void u()
  {
    ArrayList localArrayList = this.I;
    if (localArrayList != null) {
      Collections.sort(localArrayList, this.L);
    }
  }
  
  public void v()
  {
    int j = t();
    int i = 0;
    while (i < j)
    {
      GLView localGLView = (GLView)this.I.get(i);
      if (this.J == localGLView)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        b(localMotionEvent);
        localMotionEvent.recycle();
      }
      localGLView.o();
      localGLView.h = null;
      localGLView.a(null);
      i += 1;
    }
    this.I.clear();
  }
  
  protected void w()
  {
    q();
    int j = t();
    int i = 0;
    while (i < j)
    {
      h(i).q();
      i += 1;
    }
  }
  
  protected void x()
  {
    r();
    int j = t();
    int i = 0;
    while (i < j)
    {
      h(i).r();
      i += 1;
    }
  }
  
  protected boolean y()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLViewGroup
 * JD-Core Version:    0.7.0.1
 */