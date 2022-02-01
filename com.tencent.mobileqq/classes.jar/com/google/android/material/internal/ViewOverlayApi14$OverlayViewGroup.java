package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor", "PrivateApi"})
class ViewOverlayApi14$OverlayViewGroup
  extends ViewGroup
{
  static Method a;
  ViewGroup b;
  View c;
  ArrayList<Drawable> d = null;
  ViewOverlayApi14 e;
  private boolean f;
  
  static
  {
    try
    {
      a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { Integer.TYPE, Integer.TYPE, Rect.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  ViewOverlayApi14$OverlayViewGroup(Context paramContext, ViewGroup paramViewGroup, View paramView, ViewOverlayApi14 paramViewOverlayApi14)
  {
    super(paramContext);
    this.b = paramViewGroup;
    this.c = paramView;
    setRight(paramViewGroup.getWidth());
    setBottom(paramViewGroup.getHeight());
    paramViewGroup.addView(this);
    this.e = paramViewOverlayApi14;
  }
  
  private void a()
  {
    if (!this.f) {
      return;
    }
    throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
  }
  
  private void a(int[] paramArrayOfInt)
  {
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    this.b.getLocationOnScreen(arrayOfInt1);
    this.c.getLocationOnScreen(arrayOfInt2);
    arrayOfInt2[0] -= arrayOfInt1[0];
    arrayOfInt2[1] -= arrayOfInt1[1];
  }
  
  private void b()
  {
    if (getChildCount() == 0)
    {
      ArrayList localArrayList = this.d;
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        this.f = true;
        this.b.removeView(this);
      }
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    a();
    if (this.d == null) {
      this.d = new ArrayList();
    }
    if (!this.d.contains(paramDrawable))
    {
      this.d.add(paramDrawable);
      invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(this);
    }
  }
  
  public void b(Drawable paramDrawable)
  {
    ArrayList localArrayList = this.d;
    if (localArrayList != null)
    {
      localArrayList.remove(paramDrawable);
      invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(null);
      b();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = new int[2];
    int[] arrayOfInt = new int[2];
    this.b.getLocationOnScreen((int[])localObject);
    this.c.getLocationOnScreen(arrayOfInt);
    int j = 0;
    paramCanvas.translate(arrayOfInt[0] - localObject[0], arrayOfInt[1] - localObject[1]);
    paramCanvas.clipRect(new Rect(0, 0, this.c.getWidth(), this.c.getHeight()));
    super.dispatchDraw(paramCanvas);
    localObject = this.d;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((ArrayList)localObject).size();
    }
    while (j < i)
    {
      ((Drawable)this.d.get(j)).draw(paramCanvas);
      j += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    if (this.b != null)
    {
      paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
      if (this.b != null)
      {
        paramArrayOfInt[0] = 0;
        paramArrayOfInt[1] = 0;
        int[] arrayOfInt = new int[2];
        a(arrayOfInt);
        paramRect.offset(arrayOfInt[0], arrayOfInt[1]);
        return super.invalidateChildInParent(paramArrayOfInt, paramRect);
      }
      invalidate(paramRect);
    }
    return null;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    invalidate(paramDrawable.getBounds());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected boolean verifyDrawable(@NonNull Drawable paramDrawable)
  {
    if (!super.verifyDrawable(paramDrawable))
    {
      ArrayList localArrayList = this.d;
      if ((localArrayList == null) || (!localArrayList.contains(paramDrawable))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ViewOverlayApi14.OverlayViewGroup
 * JD-Core Version:    0.7.0.1
 */