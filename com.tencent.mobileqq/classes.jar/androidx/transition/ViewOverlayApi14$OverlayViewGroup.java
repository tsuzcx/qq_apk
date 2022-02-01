package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ViewOverlayApi14$OverlayViewGroup
  extends ViewGroup
{
  static Method sInvalidateChildInParentFastMethod;
  private boolean mDisposed;
  ArrayList<Drawable> mDrawables = null;
  ViewGroup mHostView;
  View mRequestingView;
  ViewOverlayApi14 mViewOverlay;
  
  static
  {
    try
    {
      sInvalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { Integer.TYPE, Integer.TYPE, Rect.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  ViewOverlayApi14$OverlayViewGroup(Context paramContext, ViewGroup paramViewGroup, View paramView, ViewOverlayApi14 paramViewOverlayApi14)
  {
    super(paramContext);
    this.mHostView = paramViewGroup;
    this.mRequestingView = paramView;
    setRight(paramViewGroup.getWidth());
    setBottom(paramViewGroup.getHeight());
    paramViewGroup.addView(this);
    this.mViewOverlay = paramViewOverlayApi14;
  }
  
  private void assertNotDisposed()
  {
    if (!this.mDisposed) {
      return;
    }
    throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
  }
  
  private void disposeIfEmpty()
  {
    if (getChildCount() == 0)
    {
      ArrayList localArrayList = this.mDrawables;
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        this.mDisposed = true;
        this.mHostView.removeView(this);
      }
    }
  }
  
  private void getOffset(int[] paramArrayOfInt)
  {
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    this.mHostView.getLocationOnScreen(arrayOfInt1);
    this.mRequestingView.getLocationOnScreen(arrayOfInt2);
    arrayOfInt2[0] -= arrayOfInt1[0];
    arrayOfInt2[1] -= arrayOfInt1[1];
  }
  
  public void add(Drawable paramDrawable)
  {
    assertNotDisposed();
    if (this.mDrawables == null) {
      this.mDrawables = new ArrayList();
    }
    if (!this.mDrawables.contains(paramDrawable))
    {
      this.mDrawables.add(paramDrawable);
      invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(this);
    }
  }
  
  public void add(View paramView)
  {
    assertNotDisposed();
    if ((paramView.getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if ((localViewGroup != this.mHostView) && (localViewGroup.getParent() != null) && (ViewCompat.isAttachedToWindow(localViewGroup)))
      {
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        localViewGroup.getLocationOnScreen(arrayOfInt1);
        this.mHostView.getLocationOnScreen(arrayOfInt2);
        ViewCompat.offsetLeftAndRight(paramView, arrayOfInt1[0] - arrayOfInt2[0]);
        ViewCompat.offsetTopAndBottom(paramView, arrayOfInt1[1] - arrayOfInt2[1]);
      }
      localViewGroup.removeView(paramView);
      if (paramView.getParent() != null) {
        localViewGroup.removeView(paramView);
      }
    }
    super.addView(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = new int[2];
    int[] arrayOfInt = new int[2];
    this.mHostView.getLocationOnScreen((int[])localObject);
    this.mRequestingView.getLocationOnScreen(arrayOfInt);
    int j = 0;
    paramCanvas.translate(arrayOfInt[0] - localObject[0], arrayOfInt[1] - localObject[1]);
    paramCanvas.clipRect(new Rect(0, 0, this.mRequestingView.getWidth(), this.mRequestingView.getHeight()));
    super.dispatchDraw(paramCanvas);
    localObject = this.mDrawables;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((ArrayList)localObject).size();
    }
    while (j < i)
    {
      ((Drawable)this.mDrawables.get(j)).draw(paramCanvas);
      j += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    if (this.mHostView != null)
    {
      paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
      if ((this.mHostView instanceof ViewGroup))
      {
        paramArrayOfInt[0] = 0;
        paramArrayOfInt[1] = 0;
        int[] arrayOfInt = new int[2];
        getOffset(arrayOfInt);
        paramRect.offset(arrayOfInt[0], arrayOfInt[1]);
        return super.invalidateChildInParent(paramArrayOfInt, paramRect);
      }
      invalidate(paramRect);
    }
    return null;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected ViewParent invalidateChildInParentFast(int paramInt1, int paramInt2, Rect paramRect)
  {
    if (((this.mHostView instanceof ViewGroup)) && (sInvalidateChildInParentFastMethod != null)) {
      try
      {
        getOffset(new int[2]);
        sInvalidateChildInParentFastMethod.invoke(this.mHostView, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramRect });
      }
      catch (InvocationTargetException paramRect)
      {
        paramRect.printStackTrace();
      }
      catch (IllegalAccessException paramRect)
      {
        paramRect.printStackTrace();
      }
    }
    return null;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    invalidate(paramDrawable.getBounds());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void remove(Drawable paramDrawable)
  {
    ArrayList localArrayList = this.mDrawables;
    if (localArrayList != null)
    {
      localArrayList.remove(paramDrawable);
      invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(null);
      disposeIfEmpty();
    }
  }
  
  public void remove(View paramView)
  {
    super.removeView(paramView);
    disposeIfEmpty();
  }
  
  protected boolean verifyDrawable(@NonNull Drawable paramDrawable)
  {
    if (!super.verifyDrawable(paramDrawable))
    {
      ArrayList localArrayList = this.mDrawables;
      if ((localArrayList == null) || (!localArrayList.contains(paramDrawable))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ViewOverlayApi14.OverlayViewGroup
 * JD-Core Version:    0.7.0.1
 */