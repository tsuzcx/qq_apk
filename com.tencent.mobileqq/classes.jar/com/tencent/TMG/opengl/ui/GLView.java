package com.tencent.TMG.opengl.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.TMG.opengl.glrenderer.GLCanvas;
import com.tencent.TMG.opengl.texture.BasicTexture;
import com.tencent.TMG.opengl.texture.ResourceTexture;

public class GLView
{
  protected static final int FLAG_INVISIBLE = 1;
  protected static final int FLAG_LAYOUT_REQUESTED = 4;
  protected static final int FLAG_SET_MEASURED_SIZE = 2;
  public static final int INVISIBLE = 1;
  private static final String TAG = "GLView";
  public static final int VISIBLE = 0;
  protected Animation mAnimation;
  protected BasicTexture mBackground;
  protected final Object mBackgroundBitmapLock = new Object();
  protected int mBackgroundColor = -16777216;
  protected int mBackgroundResource = 0;
  protected final Rect mBounds = new Rect(0, 0, 0, 0);
  protected int mLastHeightSpec = -1;
  protected int mLastWidthSpec = -1;
  protected int mMeasuredHeight = 0;
  protected int mMeasuredWidth = 0;
  protected OnTouchListener mOnTouchListener;
  protected OnZOrderChangedListener mOnZOrderChangedListener;
  protected final Rect mPaddings = new Rect(0, 0, 0, 0);
  protected GLView mParent;
  protected GLRootView mRootView;
  protected int mScrollHeight = 0;
  protected int mScrollWidth = 0;
  protected int mScrollX = 0;
  protected int mScrollY = 0;
  protected Transformation mTransformation;
  protected int mViewFlags = 0;
  protected int mZOrder = 0;
  
  public void attachToRoot(GLRootView paramGLRootView)
  {
    onAttachToRoot(paramGLRootView);
  }
  
  public void detachFromRoot()
  {
    onDetachFromRoot();
  }
  
  protected boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getVisibility() == 0) && (this.mOnTouchListener != null) && (this.mOnTouchListener.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return onTouchEvent(paramMotionEvent);
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (this.mBackground != null)
    {
      this.mBackground = null;
      this.mBackgroundResource = 0;
    }
  }
  
  public int getBackgroundColor()
  {
    return this.mBackgroundColor;
  }
  
  public Rect getBounds()
  {
    return this.mBounds;
  }
  
  public boolean getBoundsOf(GLView paramGLView, Rect paramRect)
  {
    GLView localGLView = paramGLView;
    int i = 0;
    int j = 0;
    while (localGLView != this)
    {
      if (localGLView == null) {
        return false;
      }
      Rect localRect = localGLView.mBounds;
      j += localRect.left;
      i += localRect.top;
      localGLView = localGLView.mParent;
    }
    paramRect.set(j, i, paramGLView.getWidth() + j, paramGLView.getHeight() + i);
    return true;
  }
  
  public GLRootView getGLRootView()
  {
    return this.mRootView;
  }
  
  public int getHeight()
  {
    return this.mBounds.bottom - this.mBounds.top;
  }
  
  public int getMeasuredHeight()
  {
    return this.mMeasuredHeight;
  }
  
  public int getMeasuredWidth()
  {
    return this.mMeasuredWidth;
  }
  
  public Rect getPaddings()
  {
    return this.mPaddings;
  }
  
  public int getVisibility()
  {
    if ((this.mViewFlags & 0x1) == 0) {
      return 0;
    }
    return 1;
  }
  
  public int getWidth()
  {
    return this.mBounds.right - this.mBounds.left;
  }
  
  public int getZOrder()
  {
    return this.mZOrder;
  }
  
  public void invalidate()
  {
    GLRootView localGLRootView = getGLRootView();
    if (localGLRootView != null) {
      localGLRootView.requestRender();
    }
  }
  
  @SuppressLint({"WrongCall"})
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mViewFlags &= 0xFFFFFFFB;
    onLayout(bool, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void lockRendering()
  {
    if (this.mRootView != null) {
      this.mRootView.lockRenderThread();
    }
  }
  
  @SuppressLint({"WrongCall"})
  public void measure(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.mLastWidthSpec) && (paramInt2 == this.mLastHeightSpec) && ((this.mViewFlags & 0x4) == 0)) {}
    do
    {
      return;
      this.mLastWidthSpec = paramInt1;
      this.mLastHeightSpec = paramInt2;
      this.mViewFlags &= 0xFFFFFFFD;
      onMeasure(paramInt1, paramInt2);
    } while ((this.mViewFlags & 0x2) != 0);
    throw new IllegalStateException(getClass().getName() + " should call setMeasuredSize() in onMeasure()");
  }
  
  protected void onAttachToRoot(GLRootView paramGLRootView)
  {
    this.mRootView = paramGLRootView;
  }
  
  protected void onDetachFromRoot()
  {
    this.mRootView = null;
  }
  
  protected void onFirstDraw() {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onMeasure(int paramInt1, int paramInt2) {}
  
  protected boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onVisibilityChanged(int paramInt) {}
  
  protected void render(GLCanvas paramGLCanvas)
  {
    renderBackground(paramGLCanvas);
  }
  
  protected void renderBackground(GLCanvas paramGLCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    if (this.mBackground != null) {
      synchronized (this.mBackgroundBitmapLock)
      {
        this.mBackground.draw(paramGLCanvas, 0, 0, i, j);
        return;
      }
    }
    paramGLCanvas.fillRect(0.0F, 0.0F, i, j, this.mBackgroundColor);
  }
  
  public void requestLayout()
  {
    this.mViewFlags |= 0x4;
    this.mLastHeightSpec = -1;
    this.mLastWidthSpec = -1;
    if (this.mParent != null) {
      this.mParent.requestLayout();
    }
    GLRootView localGLRootView;
    do
    {
      return;
      localGLRootView = getGLRootView();
    } while (localGLRootView == null);
    localGLRootView.requestLayoutContentPane();
  }
  
  public void setBackground(int paramInt)
  {
    Object localObject1 = null;
    Object localObject3 = this.mBackgroundBitmapLock;
    if (paramInt != 0) {}
    try
    {
      if (paramInt == this.mBackgroundResource) {
        return;
      }
      localObject4 = getGLRootView();
      if (localObject4 == null) {
        throw new RuntimeException("Cannot set resource background before attach to GLRootView!");
      }
    }
    finally {}
    if (this.mBackground != null)
    {
      this.mBackground.recycle();
      this.mBackground = null;
    }
    Object localObject4 = ((GLRootView)localObject4).getContext();
    if (paramInt == 0) {}
    for (;;)
    {
      this.mBackground = localObject2;
      this.mBackgroundResource = paramInt;
      return;
      ResourceTexture localResourceTexture = new ResourceTexture((Context)localObject4, paramInt);
    }
  }
  
  /* Error */
  public void setBackground(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 95	com/tencent/TMG/opengl/ui/GLView:mBackgroundBitmapLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_2
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 127	com/tencent/TMG/opengl/ui/GLView:mBackground	Lcom/tencent/TMG/opengl/texture/BasicTexture;
    //   18: ifnull +15 -> 33
    //   21: aload_0
    //   22: getfield 127	com/tencent/TMG/opengl/ui/GLView:mBackground	Lcom/tencent/TMG/opengl/texture/BasicTexture;
    //   25: invokevirtual 256	com/tencent/TMG/opengl/texture/BasicTexture:recycle	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 127	com/tencent/TMG/opengl/ui/GLView:mBackground	Lcom/tencent/TMG/opengl/texture/BasicTexture;
    //   33: aload_0
    //   34: new 268	com/tencent/TMG/opengl/texture/BitmapTexture
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 270	com/tencent/TMG/opengl/texture/BitmapTexture:<init>	(Landroid/graphics/Bitmap;)V
    //   42: putfield 127	com/tencent/TMG/opengl/ui/GLView:mBackground	Lcom/tencent/TMG/opengl/texture/BasicTexture;
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 88	com/tencent/TMG/opengl/ui/GLView:mBackgroundResource	I
    //   50: aload_2
    //   51: monitorexit
    //   52: return
    //   53: astore_1
    //   54: aload_2
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	GLView
    //   0	58	1	paramBitmap	android.graphics.Bitmap
    //   4	51	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	13	53	finally
    //   14	33	53	finally
    //   33	52	53	finally
    //   54	56	53	finally
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
  }
  
  public boolean setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 - paramInt1 != this.mBounds.right - this.mBounds.left) || (paramInt4 - paramInt2 != this.mBounds.bottom - this.mBounds.top)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
      return bool;
    }
  }
  
  protected void setMeasuredSize(int paramInt1, int paramInt2)
  {
    this.mViewFlags |= 0x2;
    this.mMeasuredWidth = paramInt1;
    this.mMeasuredHeight = paramInt2;
  }
  
  public void setOnTouchListener(OnTouchListener paramOnTouchListener)
  {
    this.mOnTouchListener = paramOnTouchListener;
  }
  
  protected void setOnZOrderChangedListener(OnZOrderChangedListener paramOnZOrderChangedListener)
  {
    this.mOnZOrderChangedListener = paramOnZOrderChangedListener;
  }
  
  public void setPaddings(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPaddings.set(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setRotation(int paramInt) {}
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == getVisibility()) {
      return;
    }
    if (paramInt == 0) {}
    for (this.mViewFlags &= 0xFFFFFFFE;; this.mViewFlags |= 0x1)
    {
      onVisibilityChanged(paramInt);
      invalidate();
      return;
    }
  }
  
  public void setZOrder(int paramInt)
  {
    if (this.mZOrder != paramInt)
    {
      int i = this.mZOrder;
      this.mZOrder = paramInt;
      if (this.mOnZOrderChangedListener != null) {
        this.mOnZOrderChangedListener.OnZOrderChanged(this, paramInt, i);
      }
    }
  }
  
  public void startAnimation(Animation paramAnimation)
  {
    if (getGLRootView() == null) {
      throw new IllegalStateException();
    }
    this.mAnimation = paramAnimation;
    if (this.mAnimation != null) {
      this.mAnimation.start();
    }
    invalidate();
  }
  
  public void unlockRendering()
  {
    if (this.mRootView != null) {
      this.mRootView.unlockRenderThread();
    }
  }
  
  public static abstract interface OnTouchListener
  {
    public abstract boolean onTouch(GLView paramGLView, MotionEvent paramMotionEvent);
  }
  
  public static abstract interface OnZOrderChangedListener
  {
    public abstract void OnZOrderChanged(GLView paramGLView, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.opengl.ui.GLView
 * JD-Core Version:    0.7.0.1
 */