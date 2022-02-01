package com.tencent.aelight.camera.aeeditor.lyric.interaction;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new ViewDragHelper.1();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ScrollerCompat jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private final ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final ViewDragHelper.Callback jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new ViewDragHelper.2(this);
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int[] jdField_a_of_type_ArrayOfInt;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private int[] jdField_b_of_type_ArrayOfInt;
  private int jdField_c_of_type_Int = -1;
  private float[] jdField_c_of_type_ArrayOfFloat;
  private int[] jdField_c_of_type_ArrayOfInt;
  private int jdField_d_of_type_Int;
  private float[] jdField_d_of_type_ArrayOfFloat;
  private int e;
  private int f;
  
  private ViewDragHelper(Context paramContext, ViewGroup paramViewGroup, Interpolator paramInterpolator, ViewDragHelper.Callback paramCallback)
  {
    if (paramViewGroup != null)
    {
      if (paramCallback != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback = paramCallback;
        paramViewGroup = ViewConfiguration.get(paramContext);
        this.e = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
        this.jdField_b_of_type_Int = paramViewGroup.getScaledTouchSlop();
        this.jdField_a_of_type_Float = paramViewGroup.getScaledMaximumFlingVelocity();
        this.jdField_b_of_type_Float = paramViewGroup.getScaledMinimumFlingVelocity();
        if (paramInterpolator == null) {
          paramInterpolator = jdField_a_of_type_AndroidViewAnimationInterpolator;
        }
        this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat = ScrollerCompat.create(paramContext, paramInterpolator);
        return;
      }
      throw new IllegalArgumentException("Callback may not be null");
    }
    throw new IllegalArgumentException("Parent view may not be null");
  }
  
  private float a(float paramFloat)
  {
    double d1 = paramFloat - 0.5F;
    Double.isNaN(d1);
    return (float)Math.sin((float)(d1 * 0.47123891676382D));
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Math.abs(paramFloat1);
    if (f1 < paramFloat2) {
      return 0.0F;
    }
    if (f1 > paramFloat3)
    {
      if (paramFloat1 > 0.0F) {
        return paramFloat3;
      }
      return -paramFloat3;
    }
    return paramFloat1;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.jdField_a_of_type_AndroidViewViewGroup.getLeft() + this.e) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (paramInt2 < this.jdField_a_of_type_AndroidViewViewGroup.getTop() + this.e) {
      i = j | 0x4;
    }
    int j = i;
    if (paramInt1 > this.jdField_a_of_type_AndroidViewViewGroup.getRight() - this.e) {
      j = i | 0x2;
    }
    paramInt1 = j;
    if (paramInt2 > this.jdField_a_of_type_AndroidViewViewGroup.getBottom() - this.e) {
      paramInt1 = j | 0x8;
    }
    return paramInt1;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_AndroidViewViewGroup.getWidth();
    int j = i / 2;
    float f2 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    f2 = a(f2);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0)
    {
      paramInt1 = Math.round(Math.abs((f1 + f2 * f1) / paramInt2) * 1000.0F) * 4;
    }
    else
    {
      if (paramInt3 == 0) {
        break label111;
      }
      paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F);
    }
    return Math.min(paramInt1, 600);
    label111:
    return 0;
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = b(paramInt3, (int)this.jdField_b_of_type_Float, (int)this.jdField_a_of_type_Float);
    paramInt4 = b(paramInt4, (int)this.jdField_b_of_type_Float, (int)this.jdField_a_of_type_Float);
    int i = Math.abs(paramInt1);
    int j = Math.abs(paramInt2);
    int k = Math.abs(paramInt3);
    int m = Math.abs(paramInt4);
    int n = k + m;
    int i1 = i + j;
    float f1;
    float f2;
    if (paramInt3 != 0)
    {
      f1 = k;
      f2 = n;
    }
    else
    {
      f1 = i;
      f2 = i1;
    }
    float f3 = f1 / f2;
    if (paramInt4 != 0)
    {
      f1 = m;
      f2 = n;
    }
    else
    {
      f1 = j;
      f2 = i1;
    }
    f1 /= f2;
    paramInt1 = a(paramInt1, paramInt3, this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.b(paramView));
    paramInt2 = a(paramInt2, paramInt4, this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(paramView));
    return (int)(paramInt1 * f3 + paramInt2 * f1);
  }
  
  public static ViewDragHelper a(ViewGroup paramViewGroup, float paramFloat, Interpolator paramInterpolator, ViewDragHelper.Callback paramCallback)
  {
    paramViewGroup = a(paramViewGroup, paramInterpolator, paramCallback);
    paramViewGroup.jdField_b_of_type_Int = ((int)(paramViewGroup.jdField_b_of_type_Int * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static ViewDragHelper a(ViewGroup paramViewGroup, Interpolator paramInterpolator, ViewDragHelper.Callback paramCallback)
  {
    return new ViewDragHelper(paramViewGroup.getContext(), paramViewGroup, paramInterpolator, paramCallback);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Boolean = true;
    ViewDragHelper.Callback localCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback;
    if (localCallback != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null) {
        localCallback.a(localView, paramFloat1, paramFloat2);
      }
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Int == 1) {
      a(0);
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    c(paramInt);
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    this.jdField_c_of_type_ArrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    this.jdField_d_of_type_ArrayOfFloat[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.jdField_a_of_type_ArrayOfInt[paramInt] = a((int)paramFloat1, (int)paramFloat2);
    this.jdField_d_of_type_Int |= 1 << paramInt;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.jdField_a_of_type_AndroidViewView.getLeft();
    int k = this.jdField_a_of_type_AndroidViewView.getTop();
    int i = paramInt1;
    if (paramInt3 != 0)
    {
      i = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.b(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt3);
      this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(i - j);
    }
    paramInt1 = paramInt2;
    if (paramInt4 != 0)
    {
      paramInt1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(this.jdField_a_of_type_AndroidViewView, paramInt2, paramInt4);
      this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(paramInt1 - k);
    }
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(this.jdField_a_of_type_AndroidViewView, i, paramInt1, i - j, paramInt1 - k);
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    int i = this.jdField_a_of_type_ArrayOfInt[paramInt1];
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((i & paramInt2) == paramInt2)
    {
      bool1 = bool2;
      if ((this.f & paramInt2) != 0)
      {
        bool1 = bool2;
        if ((this.jdField_c_of_type_ArrayOfInt[paramInt1] & paramInt2) != paramInt2)
        {
          bool1 = bool2;
          if ((this.jdField_b_of_type_ArrayOfInt[paramInt1] & paramInt2) != paramInt2)
          {
            i = this.jdField_b_of_type_Int;
            if ((paramFloat1 <= i) && (paramFloat2 <= i)) {
              return false;
            }
            if ((paramFloat1 < paramFloat2 * 0.5F) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(paramInt2)))
            {
              int[] arrayOfInt = this.jdField_c_of_type_ArrayOfInt;
              arrayOfInt[paramInt1] |= paramInt2;
              return false;
            }
            bool1 = bool2;
            if ((this.jdField_b_of_type_ArrayOfInt[paramInt1] & paramInt2) == 0)
            {
              bool1 = bool2;
              if (paramFloat1 > this.jdField_b_of_type_Int) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.jdField_a_of_type_AndroidViewView.getLeft();
    int j = this.jdField_a_of_type_AndroidViewView.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.abortAnimation();
      a(0);
      return false;
    }
    paramInt3 = a(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    a(2);
    return true;
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramView == null) {
      return false;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.b(paramView) > 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(paramView) > 0) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) && (j != 0))
    {
      i = this.jdField_b_of_type_Int;
      if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > i * i) {
        bool1 = true;
      }
      return bool1;
    }
    if (i != 0)
    {
      bool1 = bool3;
      if (Math.abs(paramFloat1) > this.jdField_b_of_type_Int) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (j != 0)
    {
      bool1 = bool2;
      if (Math.abs(paramFloat2) > this.jdField_b_of_type_Int) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (i < paramInt2) {
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0) {
        return paramInt3;
      }
      return -paramInt3;
    }
    return paramInt1;
  }
  
  private void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    if (!a(paramFloat1, paramFloat2, paramInt, 1)) {
      j = 0;
    }
    int i = j;
    if (a(paramFloat2, paramFloat1, paramInt, 4)) {
      i = j | 0x4;
    }
    j = i;
    if (a(paramFloat1, paramFloat2, paramInt, 2)) {
      j = i | 0x2;
    }
    i = j;
    if (a(paramFloat2, paramFloat1, paramInt, 8)) {
      i = j | 0x8;
    }
    if (i != 0)
    {
      int[] arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
      arrayOfInt[paramInt] |= i;
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.b(i, paramInt);
    }
  }
  
  private void b(int paramInt)
  {
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    if (arrayOfFloat != null)
    {
      if (arrayOfFloat.length <= paramInt) {
        return;
      }
      arrayOfFloat[paramInt] = 0.0F;
      this.jdField_b_of_type_ArrayOfFloat[paramInt] = 0.0F;
      this.jdField_c_of_type_ArrayOfFloat[paramInt] = 0.0F;
      this.jdField_d_of_type_ArrayOfFloat[paramInt] = 0.0F;
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 0;
      this.jdField_b_of_type_ArrayOfInt[paramInt] = 0;
      this.jdField_c_of_type_ArrayOfInt[paramInt] = 0;
      this.jdField_d_of_type_Int = ((1 << paramInt ^ 0xFFFFFFFF) & this.jdField_d_of_type_Int);
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    int j = MotionEventCompat.getPointerCount(paramMotionEvent);
    int i = 0;
    while (i < j)
    {
      int k = MotionEventCompat.getPointerId(paramMotionEvent, i);
      float f1 = MotionEventCompat.getX(paramMotionEvent, i);
      float f2 = MotionEventCompat.getY(paramMotionEvent, i);
      float[] arrayOfFloat1 = this.jdField_c_of_type_ArrayOfFloat;
      if (arrayOfFloat1 != null)
      {
        float[] arrayOfFloat2 = this.jdField_d_of_type_ArrayOfFloat;
        if ((arrayOfFloat2 != null) && (arrayOfFloat1.length > k) && (arrayOfFloat2.length > k))
        {
          arrayOfFloat1[k] = f1;
          arrayOfFloat2[k] = f2;
        }
      }
      i += 1;
    }
  }
  
  private void c()
  {
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    if (arrayOfFloat == null) {
      return;
    }
    Arrays.fill(arrayOfFloat, 0.0F);
    Arrays.fill(this.jdField_b_of_type_ArrayOfFloat, 0.0F);
    Arrays.fill(this.jdField_c_of_type_ArrayOfFloat, 0.0F);
    Arrays.fill(this.jdField_d_of_type_ArrayOfFloat, 0.0F);
    Arrays.fill(this.jdField_a_of_type_ArrayOfInt, 0);
    Arrays.fill(this.jdField_b_of_type_ArrayOfInt, 0);
    Arrays.fill(this.jdField_c_of_type_ArrayOfInt, 0);
    this.jdField_d_of_type_Int = 0;
  }
  
  private void c(int paramInt)
  {
    float[] arrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
    if ((arrayOfFloat1 == null) || (arrayOfFloat1.length <= paramInt))
    {
      paramInt += 1;
      arrayOfFloat1 = new float[paramInt];
      float[] arrayOfFloat2 = new float[paramInt];
      float[] arrayOfFloat3 = new float[paramInt];
      float[] arrayOfFloat4 = new float[paramInt];
      int[] arrayOfInt1 = new int[paramInt];
      int[] arrayOfInt2 = new int[paramInt];
      int[] arrayOfInt3 = new int[paramInt];
      Object localObject = this.jdField_a_of_type_ArrayOfFloat;
      if (localObject != null)
      {
        System.arraycopy(localObject, 0, arrayOfFloat1, 0, localObject.length);
        localObject = this.jdField_b_of_type_ArrayOfFloat;
        System.arraycopy(localObject, 0, arrayOfFloat2, 0, localObject.length);
        localObject = this.jdField_c_of_type_ArrayOfFloat;
        System.arraycopy(localObject, 0, arrayOfFloat3, 0, localObject.length);
        localObject = this.jdField_d_of_type_ArrayOfFloat;
        System.arraycopy(localObject, 0, arrayOfFloat4, 0, localObject.length);
        localObject = this.jdField_a_of_type_ArrayOfInt;
        System.arraycopy(localObject, 0, arrayOfInt1, 0, localObject.length);
        localObject = this.jdField_b_of_type_ArrayOfInt;
        System.arraycopy(localObject, 0, arrayOfInt2, 0, localObject.length);
        localObject = this.jdField_c_of_type_ArrayOfInt;
        System.arraycopy(localObject, 0, arrayOfInt3, 0, localObject.length);
      }
      this.jdField_a_of_type_ArrayOfFloat = arrayOfFloat1;
      this.jdField_b_of_type_ArrayOfFloat = arrayOfFloat2;
      this.jdField_c_of_type_ArrayOfFloat = arrayOfFloat3;
      this.jdField_d_of_type_ArrayOfFloat = arrayOfFloat4;
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt1;
      this.jdField_b_of_type_ArrayOfInt = arrayOfInt2;
      this.jdField_c_of_type_ArrayOfInt = arrayOfInt3;
    }
  }
  
  private void d()
  {
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.computeCurrentVelocity(1000, this.jdField_a_of_type_Float);
      a(a(VelocityTrackerCompat.getXVelocity(this.jdField_a_of_type_AndroidViewVelocityTracker, this.jdField_c_of_type_Int), this.jdField_b_of_type_Float, this.jdField_a_of_type_Float), a(VelocityTrackerCompat.getYVelocity(this.jdField_a_of_type_AndroidViewVelocityTracker, this.jdField_c_of_type_Int), this.jdField_b_of_type_Float, this.jdField_a_of_type_Float));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_AndroidViewViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(i));
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = -1;
    c();
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      ViewDragHelper.Callback localCallback = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback;
      if (localCallback != null) {
        localCallback.a(paramInt);
      }
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_AndroidViewView = null;
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    int m = MotionEventCompat.getActionMasked(paramMotionEvent);
    int k = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (m == 0) {
      a();
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int j = 0;
    int i = 0;
    float f1;
    float f2;
    if (m != 0)
    {
      if (m != 1)
      {
        Object localObject;
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 5)
            {
              if (m != 6) {
                return;
              }
              j = MotionEventCompat.getPointerId(paramMotionEvent, k);
              if ((this.jdField_a_of_type_Int == 1) && (j == this.jdField_c_of_type_Int))
              {
                k = MotionEventCompat.getPointerCount(paramMotionEvent);
                while (i < k)
                {
                  m = MotionEventCompat.getPointerId(paramMotionEvent, i);
                  if (m != this.jdField_c_of_type_Int)
                  {
                    f1 = MotionEventCompat.getX(paramMotionEvent, i);
                    f2 = MotionEventCompat.getY(paramMotionEvent, i);
                    localObject = this.jdField_a_of_type_AndroidViewView;
                    if ((localObject != null) && (localObject.equals(a((int)f1, (int)f2))) && (a(this.jdField_a_of_type_AndroidViewView, m)))
                    {
                      i = this.jdField_c_of_type_Int;
                      break label219;
                    }
                  }
                  i += 1;
                }
                i = -1;
                label219:
                if (i == -1) {
                  d();
                }
              }
              b(j);
              return;
            }
            i = MotionEventCompat.getPointerId(paramMotionEvent, k);
            f1 = MotionEventCompat.getX(paramMotionEvent, k);
            f2 = MotionEventCompat.getY(paramMotionEvent, k);
            a(f1, f2, i);
            if (this.jdField_a_of_type_Int == 0)
            {
              a(a((int)f1, (int)f2), i);
              j = this.jdField_a_of_type_ArrayOfInt[i];
              k = this.f;
              if ((j & k) != 0) {
                this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(j & k, i);
              }
            }
            else if (b((int)f1, (int)f2))
            {
              a(this.jdField_a_of_type_AndroidViewView, i);
            }
          }
          else
          {
            if (this.jdField_a_of_type_Int == 1) {
              a(0.0F, 0.0F);
            }
            a();
          }
        }
        else
        {
          if (this.jdField_a_of_type_Int == 1)
          {
            i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.jdField_c_of_type_Int);
            f1 = MotionEventCompat.getX(paramMotionEvent, i);
            f2 = MotionEventCompat.getY(paramMotionEvent, i);
            localObject = this.jdField_c_of_type_ArrayOfFloat;
            j = this.jdField_c_of_type_Int;
            i = (int)(f1 - localObject[j]);
            j = (int)(f2 - this.jdField_d_of_type_ArrayOfFloat[j]);
            a(this.jdField_a_of_type_AndroidViewView.getLeft() + i, this.jdField_a_of_type_AndroidViewView.getTop() + j, i, j);
            b(paramMotionEvent);
            return;
          }
          k = MotionEventCompat.getPointerCount(paramMotionEvent);
          i = j;
          while (i < k)
          {
            j = MotionEventCompat.getPointerId(paramMotionEvent, i);
            f2 = MotionEventCompat.getX(paramMotionEvent, i);
            f1 = MotionEventCompat.getY(paramMotionEvent, i);
            f2 -= this.jdField_a_of_type_ArrayOfFloat[j];
            f1 -= this.jdField_b_of_type_ArrayOfFloat[j];
            b(f2, f1, j);
            if (this.jdField_a_of_type_Int == 1) {
              break;
            }
            localObject = a((int)this.jdField_a_of_type_ArrayOfFloat[j], (int)this.jdField_b_of_type_ArrayOfFloat[j]);
            if ((a((View)localObject, f2, f1)) && (a((View)localObject, j))) {
              break;
            }
            i += 1;
          }
          b(paramMotionEvent);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Int == 1) {
          d();
        }
        a();
      }
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      paramMotionEvent = a((int)f1, (int)f2);
      a(f1, f2, i);
      a(paramMotionEvent, i);
      j = this.jdField_a_of_type_ArrayOfInt[i];
      k = this.f;
      if ((j & k) != 0) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(j & k, i);
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    ViewParent localViewParent;
    if (paramView == null) {
      localViewParent = null;
    } else {
      localViewParent = paramView.getParent();
    }
    if ((localViewParent != null) && (!localViewParent.equals(this.jdField_a_of_type_AndroidViewViewGroup)))
    {
      paramView = new StringBuilder();
      paramView.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
      paramView.append(this.jdField_a_of_type_AndroidViewViewGroup);
      paramView.append(")");
      throw new IllegalArgumentException(paramView.toString());
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(paramView, paramInt);
    a(1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return a(paramInt1, paramInt2, (int)VelocityTrackerCompat.getXVelocity(this.jdField_a_of_type_AndroidViewVelocityTracker, this.jdField_c_of_type_Int), (int)VelocityTrackerCompat.getYVelocity(this.jdField_a_of_type_AndroidViewVelocityTracker, this.jdField_c_of_type_Int));
    }
    throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    int j = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (i == 0) {
      a();
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    boolean bool = false;
    float f1;
    float f2;
    int k;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i != 6) {
                break label512;
              }
              b(MotionEventCompat.getPointerId(paramMotionEvent, j));
              break label512;
            }
            i = MotionEventCompat.getPointerId(paramMotionEvent, j);
            f1 = MotionEventCompat.getX(paramMotionEvent, j);
            f2 = MotionEventCompat.getY(paramMotionEvent, j);
            a(f1, f2, i);
            j = this.jdField_a_of_type_Int;
            if (j == 0)
            {
              j = this.jdField_a_of_type_ArrayOfInt[i];
              k = this.f;
              if ((j & k) == 0) {
                break label512;
              }
              this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(j & k, i);
              break label512;
            }
            if (j != 2) {
              break label512;
            }
            paramMotionEvent = a((int)f1, (int)f2);
            if ((paramMotionEvent == null) || (!paramMotionEvent.equals(this.jdField_a_of_type_AndroidViewView))) {
              break label512;
            }
            a(paramMotionEvent, i);
            break label512;
          }
        }
        else
        {
          j = MotionEventCompat.getPointerCount(paramMotionEvent);
          i = 0;
          while ((i < j) && (this.jdField_a_of_type_ArrayOfFloat != null) && (this.jdField_b_of_type_ArrayOfFloat != null))
          {
            k = MotionEventCompat.getPointerId(paramMotionEvent, i);
            if ((k < this.jdField_a_of_type_ArrayOfFloat.length) && (k < this.jdField_b_of_type_ArrayOfFloat.length))
            {
              f2 = MotionEventCompat.getX(paramMotionEvent, i);
              f1 = MotionEventCompat.getY(paramMotionEvent, i);
              f2 -= this.jdField_a_of_type_ArrayOfFloat[k];
              f1 -= this.jdField_b_of_type_ArrayOfFloat[k];
              b(f2, f1, k);
              if (this.jdField_a_of_type_Int == 1) {
                break;
              }
              View localView = a((int)this.jdField_a_of_type_ArrayOfFloat[k], (int)this.jdField_b_of_type_ArrayOfFloat[k]);
              if ((localView != null) && (a(localView, f2, f1)) && (a(localView, k))) {
                break;
              }
            }
            i += 1;
          }
          b(paramMotionEvent);
          break label512;
        }
      }
      a();
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      a(f1, f2, i);
      paramMotionEvent = a((int)f1, (int)f2);
      if ((paramMotionEvent != null) && (paramMotionEvent.equals(this.jdField_a_of_type_AndroidViewView)) && (this.jdField_a_of_type_Int == 2)) {
        a(paramMotionEvent, i);
      }
      j = this.jdField_a_of_type_ArrayOfInt[i];
      k = this.f;
      if ((j & k) != 0) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(j & k, i);
      }
    }
    label512:
    if (this.jdField_a_of_type_Int == 1) {
      bool = true;
    }
    return bool;
  }
  
  boolean a(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramView.equals(this.jdField_a_of_type_AndroidViewView)) && (this.jdField_c_of_type_Int == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(paramView, paramInt)))
    {
      this.jdField_c_of_type_Int = paramInt;
      a(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public boolean a(View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_c_of_type_Int = -1;
    return a(paramInt1, paramInt2, 0, 0);
  }
  
  public boolean a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    boolean bool2 = false;
    if (localView == null) {
      return false;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      boolean bool3 = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.computeScrollOffset();
      int i = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getCurrX();
      int j = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getCurrY();
      int k = i - this.jdField_a_of_type_AndroidViewView.getLeft();
      int m = j - this.jdField_a_of_type_AndroidViewView.getTop();
      if ((!bool3) && (m != 0))
      {
        this.jdField_a_of_type_AndroidViewView.setTop(0);
        return true;
      }
      if (k != 0) {
        this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(k);
      }
      if (m != 0) {
        this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(this.jdField_a_of_type_AndroidViewView, i, j, k, m);
      }
      boolean bool1 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        if (i == this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getFinalX())
        {
          bool1 = bool3;
          if (j == this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getFinalY())
          {
            this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.abortAnimation();
            bool1 = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.isFinished();
          }
        }
      }
      if (!bool1) {
        if (paramBoolean) {
          this.jdField_a_of_type_AndroidViewViewGroup.post(this.jdField_a_of_type_JavaLangRunnable);
        } else {
          a(0);
        }
      }
    }
    paramBoolean = bool2;
    if (this.jdField_a_of_type_Int == 2) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    a();
    if (this.jdField_a_of_type_Int == 2)
    {
      int i = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getCurrX();
      int j = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getCurrY();
      this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.abortAnimation();
      int k = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getCurrX();
      int m = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getCurrY();
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricInteractionViewDragHelper$Callback.a(this.jdField_a_of_type_AndroidViewView, k, m, k - i, m - j);
    }
    a(0);
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return b(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt2);
  }
  
  public boolean b(View paramView, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramInt1 >= paramView.getLeft())
    {
      bool1 = bool2;
      if (paramInt1 < paramView.getRight())
      {
        bool1 = bool2;
        if (paramInt2 >= paramView.getTop())
        {
          bool1 = bool2;
          if (paramInt2 < paramView.getBottom()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.interaction.ViewDragHelper
 * JD-Core Version:    0.7.0.1
 */