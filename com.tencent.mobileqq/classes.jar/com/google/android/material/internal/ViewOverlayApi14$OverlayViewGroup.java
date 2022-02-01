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
  static Method jdField_a_of_type_JavaLangReflectMethod;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ViewOverlayApi14 jdField_a_of_type_ComGoogleAndroidMaterialInternalViewOverlayApi14;
  ArrayList<Drawable> jdField_a_of_type_JavaUtilArrayList = null;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    try
    {
      jdField_a_of_type_JavaLangReflectMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { Integer.TYPE, Integer.TYPE, Rect.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  ViewOverlayApi14$OverlayViewGroup(Context paramContext, ViewGroup paramViewGroup, View paramView, ViewOverlayApi14 paramViewOverlayApi14)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewView = paramView;
    setRight(paramViewGroup.getWidth());
    setBottom(paramViewGroup.getHeight());
    paramViewGroup.addView(this);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalViewOverlayApi14 = paramViewOverlayApi14;
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
  }
  
  private void a(int[] paramArrayOfInt)
  {
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen(arrayOfInt1);
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt2);
    arrayOfInt2[0] -= arrayOfInt1[0];
    arrayOfInt2[1] -= arrayOfInt1[1];
  }
  
  private void b()
  {
    if (getChildCount() == 0)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this);
      }
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    a();
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramDrawable))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramDrawable);
      invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(this);
    }
  }
  
  public void b(Drawable paramDrawable)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
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
    this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen((int[])localObject);
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
    int j = 0;
    paramCanvas.translate(arrayOfInt[0] - localObject[0], arrayOfInt[1] - localObject[1]);
    paramCanvas.clipRect(new Rect(0, 0, this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight()));
    super.dispatchDraw(paramCanvas);
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((ArrayList)localObject).size();
    }
    while (j < i)
    {
      ((Drawable)this.jdField_a_of_type_JavaUtilArrayList.get(j)).draw(paramCanvas);
      j += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
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
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList == null) || (!localArrayList.contains(paramDrawable))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.ViewOverlayApi14.OverlayViewGroup
 * JD-Core Version:    0.7.0.1
 */