package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class PickerBarLayout
  extends RelativeLayout
  implements GroundDrawable.GroundDrawableListener, MarkDrawable.MarkDrawableListener
{
  private float jdField_a_of_type_Float = 38.0F;
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private GroundDrawable jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable;
  private MarkDrawable jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable;
  private PickerBarLayout.CheckForLongPress jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout$CheckForLongPress;
  private WeakReference<PickerBarLayout.PickerBarLayoutListener> jdField_a_of_type_JavaLangRefWeakReference;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 50.0F;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private float c = 18.0F;
  private float d = 146.0F;
  private float e = 102.0F;
  private float f = 22.0F;
  private float g = 22.0F;
  private float h = 4.0F;
  private float i = 36.0F;
  private float j;
  
  public PickerBarLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public PickerBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PickerBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float a()
  {
    return Math.round(this.c) - this.c - (Math.round(this.h) - this.h) + (Math.round(this.jdField_b_of_type_Float) - this.jdField_b_of_type_Float);
  }
  
  private int a(float paramFloat)
  {
    this.j = paramFloat;
    int k = b(paramFloat);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("movemark posY:");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(" markindex:");
      localStringBuilder.append(k);
      localStringBuilder.append("  curIndex:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d("PickerBarLayout", 2, localStringBuilder.toString());
    }
    if (k != this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Int = k;
      a(this.jdField_b_of_type_Int, false, false);
    }
    setMarkText(this.jdField_b_of_type_Int);
    float f1 = paramFloat;
    if (this.jdField_a_of_type_Boolean) {
      f1 = paramFloat - this.i;
    }
    c(f1);
    invalidate();
    return this.jdField_b_of_type_Int;
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (PickerBarLayout.PickerBarLayoutListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((PickerBarLayout.PickerBarLayoutListener)localObject).a(paramInt, (String)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramBoolean1, paramBoolean2);
        }
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Float = PickerContainer.a(paramContext, this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Float = PickerContainer.a(paramContext, this.jdField_b_of_type_Float);
    this.c = PickerContainer.a(paramContext, this.c);
    this.d = PickerContainer.a(paramContext, this.d);
    this.e = PickerContainer.a(paramContext, this.e);
    this.h = PickerContainer.a(paramContext, this.h);
    this.f = PickerContainer.a(paramContext, this.f);
    this.g = PickerContainer.a(paramContext, this.g);
    this.i = PickerContainer.a(paramContext, this.i);
  }
  
  private boolean a(float paramFloat)
  {
    return getWidth() - this.c - this.jdField_b_of_type_Float <= paramFloat;
  }
  
  private int b(float paramFloat)
  {
    GroundDrawable localGroundDrawable = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable;
    if (localGroundDrawable != null) {
      return localGroundDrawable.a(paramFloat);
    }
    return -1;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable = new MarkDrawable();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.a(getContext(), 2130839604, 2130839603, 2130839605, this);
    this.jdField_a_of_type_AndroidViewView.setBackground(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(Math.round(this.d), Math.round(this.e));
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(0, 0, Math.round(this.h), 0);
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
  }
  
  private void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (PickerBarLayout.PickerBarLayoutListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (paramBoolean1)
        {
          if (paramBoolean2)
          {
            ((PickerBarLayout.PickerBarLayoutListener)localObject).a(paramInt);
            return;
          }
          ((PickerBarLayout.PickerBarLayoutListener)localObject).b(paramInt);
          return;
        }
        if (paramBoolean2)
        {
          ((PickerBarLayout.PickerBarLayoutListener)localObject).c(paramInt);
          return;
        }
        ((PickerBarLayout.PickerBarLayoutListener)localObject).d(paramInt);
      }
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidViewView = new View(getContext());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable = new GroundDrawable();
    float f1 = a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.a(getContext(), this.jdField_a_of_type_JavaUtilList.size(), (Math.round(this.jdField_b_of_type_Float) - this.jdField_a_of_type_Float) / 2.0F + f1, (Math.round(this.jdField_b_of_type_Float) - this.jdField_a_of_type_Float) / 2.0F - f1, this);
    this.jdField_b_of_type_AndroidViewView.setBackground(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(Math.round(this.jdField_b_of_type_Float), -1);
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(0, 0, Math.round(this.c), 0);
    addView(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
  }
  
  private void c(float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localObject != null)
      {
        float f1 = this.e;
        float f2 = f1 / 2.0F;
        float f3 = this.f;
        if (paramFloat < f2 + f3)
        {
          f1 = f1 / 2.0F + f3;
        }
        else
        {
          f1 = paramFloat;
          if (paramFloat > getHeight() - this.e / 2.0F - this.g) {
            f1 = getHeight() - this.e / 2.0F - this.g;
          }
        }
        ((RelativeLayout.LayoutParams)localObject).topMargin = Math.round(f1 - this.e / 2.0F);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = Math.round(-this.e);
      }
    }
    requestLayout();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable;
    if (localObject != null) {
      ((GroundDrawable)localObject).stop();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable;
    if (localObject != null) {
      ((MarkDrawable)localObject).stop();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidViewView = null;
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable;
    if (localObject != null)
    {
      ((MarkDrawable)localObject).a();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable = null;
    }
    this.jdField_b_of_type_AndroidViewView = null;
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable;
    if (localObject != null)
    {
      ((GroundDrawable)localObject).a();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable = null;
    }
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startenter:");
      ((StringBuilder)localObject).append(paramFloat);
      QLog.d("PickerBarLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.j = paramFloat;
    this.jdField_b_of_type_Int = b(paramFloat);
    a(this.jdField_b_of_type_Int, true, false);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable != null))
    {
      int k = ((MarkDrawable)localObject).a();
      boolean bool1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.isRunning();
      int m = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.a();
      boolean bool2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.isRunning();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("drawable state, markdrawble:");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" isrun:");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append("  groundrawable:");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(" isrun:");
        ((StringBuilder)localObject).append(bool2);
        QLog.d("PickerBarLayout", 2, ((StringBuilder)localObject).toString());
      }
      if ((k == 1) && (m == 0))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.stop();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.a(6);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.start();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.stop();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.a(1);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.start();
        return;
      }
      if (k == 4)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.stop();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.a(2);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.start();
        return;
      }
      if (m == 3)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.stop();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.a(1);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.start();
        return;
      }
      if (k == 5)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.stop();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.a(6);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.start();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.stop();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.a(1);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.start();
        return;
      }
      if (m == 4)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.stop();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.a(1);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.start();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PickerBarLayout", 2, "startenter: state not process!!");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 4))
    {
      MarkDrawable localMarkDrawable = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable;
      if (localMarkDrawable != null) {
        localMarkDrawable.stop();
      }
    }
    b(paramInt, true, true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 4)
    {
      Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable;
      if (localObject != null)
      {
        if (paramInt3 == 0) {
          return;
        }
        localObject = ((GroundDrawable)localObject).a(this.j);
        if (localObject != null)
        {
          float f1 = ((RectF)localObject).centerY();
          float f2 = this.j;
          float f3 = this.i;
          c(f2 - f3 + (f1 - f2 + f3) * (paramInt2 + 1) / paramInt3);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, RectF paramRectF)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable != null) && (paramRectF != null)) {
      c(paramRectF.centerY());
    }
  }
  
  public void a(int paramInt, RectF paramRectF)
  {
    if (((paramInt == 1) || (paramInt == 4)) && (paramRectF != null)) {
      c(paramRectF.centerY());
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_b_of_type_Int = paramInt;
    setMarkText(this.jdField_b_of_type_Int);
    GroundDrawable localGroundDrawable = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable;
    if (localGroundDrawable != null) {
      localGroundDrawable.a(this.jdField_b_of_type_Int, true, paramBoolean);
    }
    invalidate();
  }
  
  public boolean a(EditVideoParams paramEditVideoParams, Context paramContext, PickerBarLayout.PickerBarLayoutListener paramPickerBarLayoutListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPickerBarLayoutListener);
    a(paramContext);
    this.jdField_a_of_type_JavaUtilList.add("4x");
    this.jdField_a_of_type_JavaUtilList.add("2x");
    this.jdField_a_of_type_JavaUtilList.add("1x");
    if (paramEditVideoParams.f())
    {
      this.jdField_a_of_type_JavaUtilList.add("1/2");
      this.jdField_a_of_type_JavaUtilList.add("1/4");
    }
    if (paramEditVideoParams.e()) {
      this.jdField_a_of_type_JavaUtilList.add(PickerContainer.a);
    }
    c();
    b();
    return true;
  }
  
  public void b(float paramFloat)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startleave:");
      ((StringBuilder)localObject).append(paramFloat);
      QLog.d("PickerBarLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.j = paramFloat;
    int k = a(this.j);
    if (k != this.jdField_b_of_type_Int) {
      this.jdField_b_of_type_Int = k;
    }
    a(this.jdField_b_of_type_Int, false, true);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable;
      if (localObject != null)
      {
        ((GroundDrawable)localObject).a(this.jdField_b_of_type_Int, false, false);
        k = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.a();
        boolean bool1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.isRunning();
        int m = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.a();
        boolean bool2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.isRunning();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("drawable state, markdrawble:");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(" isrun:");
          ((StringBuilder)localObject).append(bool1);
          ((StringBuilder)localObject).append("  groundrawable:");
          ((StringBuilder)localObject).append(m);
          ((StringBuilder)localObject).append(" isrun:");
          ((StringBuilder)localObject).append(bool2);
          QLog.d("PickerBarLayout", 2, ((StringBuilder)localObject).toString());
        }
        if ((k == 3) && (m == 2))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.stop();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.a(4);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.start();
          return;
        }
        if (m == 1)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.stop();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.a(3);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.start();
          return;
        }
        if (k == 2)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.stop();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.a(4);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.start();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PickerBarLayout", 2, "startleave: state not process!!");
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.a(this.j) != null) {
        c(this.j - this.i);
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable != null)
      {
        setMarkText(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.stop();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.a(2);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.start();
      }
    }
    else if (paramInt == 3)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable;
      if (localObject != null)
      {
        localObject = ((GroundDrawable)localObject).a();
        if (localObject != null) {
          c(((RectF)localObject).centerY());
        }
      }
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable;
      if (localObject != null)
      {
        ((MarkDrawable)localObject).stop();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.a(5);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.start();
      }
    }
    else if ((paramInt != 4) && (paramInt == 0))
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable;
      if (localObject != null)
      {
        ((MarkDrawable)localObject).stop();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.a(1);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable.start();
      }
    }
    b(paramInt, true, false);
  }
  
  public void c(int paramInt)
  {
    MarkDrawable localMarkDrawable = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable;
    if (localMarkDrawable != null) {
      localMarkDrawable.stop();
    }
  }
  
  public void d(int paramInt)
  {
    b(paramInt, false, true);
  }
  
  public void e(int paramInt)
  {
    if (paramInt != 2) {
      if (paramInt == 4)
      {
        GroundDrawable localGroundDrawable = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable;
        if (localGroundDrawable != null)
        {
          localGroundDrawable.stop();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.a(3);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable.start();
        }
      }
      else if (paramInt == 6)
      {
        c(this.j);
      }
    }
    b(paramInt, false, false);
  }
  
  public void f(int paramInt) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction() & 0xFF;
    if (k != 0)
    {
      float f1;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3) {
            return true;
          }
          k = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
          if (k == -1) {
            return true;
          }
          paramMotionEvent.getY(k);
          b(paramMotionEvent.getY());
          this.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_Boolean = false;
          return true;
        }
        k = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
        if (k == -1) {
          return true;
        }
        f1 = paramMotionEvent.getY(k);
        if (this.jdField_a_of_type_Boolean)
        {
          a(f1);
          return true;
        }
      }
      else
      {
        k = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
        if (k == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PickerBarLayout", 2, "ACTION_UP with activePointerIndex = -1");
          }
          f1 = paramMotionEvent.getY();
        }
        else
        {
          f1 = paramMotionEvent.getY(k);
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout$CheckForLongPress;
          if (paramMotionEvent != null) {
            removeCallbacks(paramMotionEvent);
          }
          paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerGroundDrawable;
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.a(f1);
            if (paramMotionEvent != null)
            {
              a(paramMotionEvent.centerY());
              a(this.jdField_b_of_type_Int, true);
              return true;
            }
          }
        }
        else
        {
          b(f1);
          this.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_Boolean = false;
          return true;
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
      if (!a(paramMotionEvent.getX())) {
        return false;
      }
      this.j = paramMotionEvent.getY();
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout$CheckForLongPress == null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout$CheckForLongPress = new PickerBarLayout.CheckForLongPress(this);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout$CheckForLongPress.a();
      postDelayed(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
    }
    return true;
  }
  
  public void setMarkText(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      MarkDrawable localMarkDrawable = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerMarkDrawable;
      if (localMarkDrawable != null) {
        localMarkDrawable.a((String)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerBarLayout
 * JD-Core Version:    0.7.0.1
 */