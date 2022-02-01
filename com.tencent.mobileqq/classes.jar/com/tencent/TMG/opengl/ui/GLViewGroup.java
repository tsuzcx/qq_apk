package com.tencent.TMG.opengl.ui;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.TMG.opengl.glrenderer.GLCanvas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GLViewGroup
  extends GLView
{
  private static final String TAG = "GLViewGroup";
  protected final Rect mBounds = new Rect();
  private ArrayList<GLView> mChildren;
  private GLView mMotionTarget;
  private GLView.OnZOrderChangedListener mOnZOrderChangedListener = new GLViewGroup.1(this);
  protected final Rect mPaddings = new Rect();
  private Comparator<GLView> mSortComparator = new GLViewGroup.SortComparator(this);
  
  public void addView(GLView paramGLView)
  {
    if (paramGLView.mParent == null)
    {
      if (this.mChildren == null) {
        this.mChildren = new ArrayList();
      }
      this.mChildren.add(paramGLView);
      paramGLView.mParent = this;
      paramGLView.setOnZOrderChangedListener(this.mOnZOrderChangedListener);
      Collections.sort(this.mChildren, this.mSortComparator);
      if (this.mRootView != null) {
        paramGLView.onAttachToRoot(this.mRootView);
      }
      return;
    }
    throw new IllegalStateException();
  }
  
  protected boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    Object localObject = this.mMotionTarget;
    if (localObject != null) {
      if (i == 0)
      {
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setAction(3);
        dispatchTouchEvent((MotionEvent)localObject, j, k, this.mMotionTarget, false);
        this.mMotionTarget = null;
      }
      else
      {
        dispatchTouchEvent(paramMotionEvent, j, k, (GLView)localObject, false);
        if ((i == 3) || (i == 1)) {
          this.mMotionTarget = null;
        }
        return true;
      }
    }
    if (i == 0)
    {
      i = getChildCount() - 1;
      while (i >= 0)
      {
        try
        {
          localObject = getChild(i);
          if ((((GLView)localObject).getVisibility() == 0) && (dispatchTouchEvent(paramMotionEvent, j, k, (GLView)localObject, true)))
          {
            this.mMotionTarget = ((GLView)localObject);
            return true;
          }
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          label152:
          break label152;
        }
        i -= 1;
      }
    }
    else
    {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  protected boolean dispatchTouchEvent(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, GLView paramGLView, boolean paramBoolean)
  {
    Rect localRect = paramGLView.mBounds;
    if ((!paramBoolean) || (localRect.contains(paramInt1, paramInt2)))
    {
      if (paramGLView.dispatchTouchEvent(paramMotionEvent)) {
        return true;
      }
      if ((this.mOnTouchListener != null) && (this.mOnTouchListener.onTouch(paramGLView, paramMotionEvent))) {
        return true;
      }
    }
    return false;
  }
  
  public GLView getChild(int paramInt)
  {
    ArrayList localArrayList = this.mChildren;
    if ((localArrayList != null) && (paramInt >= 0) && (paramInt < localArrayList.size())) {
      return (GLView)this.mChildren.get(paramInt);
    }
    throw new ArrayIndexOutOfBoundsException(paramInt);
  }
  
  public int getChildCount()
  {
    ArrayList localArrayList = this.mChildren;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  protected void onAttachToRoot(GLRootView paramGLRootView)
  {
    this.mRootView = paramGLRootView;
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        getChild(i).onAttachToRoot(paramGLRootView);
        label26:
        i += 1;
        continue;
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        break label26;
      }
    }
  }
  
  protected void onDetachFromRoot()
  {
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        getChild(i).onDetachFromRoot();
        label20:
        i += 1;
        continue;
        this.mRootView = null;
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        break label20;
      }
    }
  }
  
  protected void onVisibilityChanged(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        GLView localGLView = getChild(i);
        if (localGLView.getVisibility() == 0) {
          localGLView.onVisibilityChanged(paramInt);
        }
        label33:
        i += 1;
        continue;
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        break label33;
      }
    }
  }
  
  public void removeAllView()
  {
    if (this.mChildren == null) {
      return;
    }
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      GLView localGLView = (GLView)this.mChildren.get(i);
      if (this.mMotionTarget == localGLView)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      localGLView.onDetachFromRoot();
      localGLView.mParent = null;
      localGLView.setOnZOrderChangedListener(null);
      i += 1;
    }
    this.mChildren.clear();
  }
  
  public boolean removeView(GLView paramGLView)
  {
    Object localObject = this.mChildren;
    if (localObject == null) {
      return false;
    }
    if (((ArrayList)localObject).remove(paramGLView))
    {
      if (this.mMotionTarget == paramGLView)
      {
        long l = SystemClock.uptimeMillis();
        localObject = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        dispatchTouchEvent((MotionEvent)localObject);
        ((MotionEvent)localObject).recycle();
      }
      paramGLView.onDetachFromRoot();
      paramGLView.mParent = null;
      paramGLView.setOnZOrderChangedListener(null);
      Collections.sort(this.mChildren, this.mSortComparator);
      return true;
    }
    return false;
  }
  
  protected void render(GLCanvas paramGLCanvas)
  {
    renderBackground(paramGLCanvas);
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        renderChild(paramGLCanvas, getChild(i));
        label27:
        i += 1;
        continue;
        return;
      }
      catch (ArrayIndexOutOfBoundsException|IndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        break label27;
      }
    }
  }
  
  protected void renderChild(GLCanvas paramGLCanvas, GLView paramGLView)
  {
    if ((paramGLView.getVisibility() != 0) && (paramGLView.mAnimation == null)) {
      return;
    }
    int i = paramGLView.mBounds.left - this.mScrollX;
    int j = paramGLView.mBounds.top - this.mScrollY;
    paramGLCanvas.translate(i, j);
    paramGLView.render(paramGLCanvas);
    paramGLCanvas.translate(-i, -j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.ui.GLViewGroup
 * JD-Core Version:    0.7.0.1
 */