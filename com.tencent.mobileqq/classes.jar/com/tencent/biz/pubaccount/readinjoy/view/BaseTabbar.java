package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anll;
import bgtn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sls;
import slt;
import slu;
import slv;
import slw;

public class BaseTabbar
  extends LinearLayout
{
  private static int jdField_b_of_type_Int;
  private static final int jdField_c_of_type_Int;
  private static final int d;
  private static final int e = 14;
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 1;
  public final Paint a;
  private Handler jdField_a_of_type_AndroidOsHandler = new sls(this);
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  private List<slw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public slv a;
  private boolean jdField_a_of_type_Boolean = true;
  public final Paint b;
  private List<RelativeLayout> jdField_b_of_type_JavaUtilList = new ArrayList();
  Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private int f = jdField_c_of_type_Int;
  private int g = d;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n = e;
  private int o = -1;
  private int p = -1;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    jdField_c_of_type_Int = (int)(40.0F * localBaseApplication.getResources().getDisplayMetrics().density + 0.5F);
    d = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 4.0F + 0.5F);
  }
  
  public BaseTabbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseTabbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = paramContext.getResources().getColor(2131166994);
    this.i = paramContext.getResources().getColor(2131166986);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.h);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(0, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.weight = 1.0F;
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.gravity = 17;
    setBackgroundDrawable(getResources().getDrawable(2130850382));
    if (jdField_b_of_type_Int == 0) {
      jdField_b_of_type_Int = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-8355712);
    int i1 = bgtn.a();
    if (i1 > 480) {}
    for (this.jdField_a_of_type_Int = 1;; this.jdField_a_of_type_Int = 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabBarView", 2, "width:" + i1 + "mode:" + this.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  private float a(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramFloat < 0.6F) {
        return 0.0F;
      }
      return (paramFloat - 0.6F) / 0.4F;
    }
    if (paramFloat < 0.6F) {
      return paramFloat / 0.6F;
    }
    return 1.0F;
  }
  
  private int a(View paramView)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      if (getChildAt(i1).equals(paramView)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private void a()
  {
    Object localObject = (AccessibilityManager)getContext().getSystemService("accessibility");
    if ((localObject != null) && (((AccessibilityManager)localObject).isEnabled()))
    {
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = ((slw)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
        if (localObject != null) {
          ((RedDotTextView)localObject).setContentDescription(((RedDotTextView)localObject).getText() + getContext().getString(2131690962));
        }
        i1 += 1;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Slv != null) {
      this.jdField_a_of_type_Slv.a(paramInt1, paramInt2);
    }
  }
  
  public int a()
  {
    return this.p;
  }
  
  public slw a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    if (paramInt == 2) {
      localRelativeLayout.setVisibility(8);
    }
    Object localObject = LayoutInflater.from(getContext()).inflate(2131560070, localRelativeLayout, true);
    slw localslw = new slw();
    localslw.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131378190);
    localslw.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)((View)localObject).findViewById(2131378445));
    localslw.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131376278));
    localslw.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131371888));
    localslw.b = ((ImageView)((View)localObject).findViewById(2131368246));
    localslw.c = ((ImageView)((View)localObject).findViewById(2131377623));
    localObject = localslw.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
    ((RedDotTextView)localObject).setText(paramString);
    ((RedDotTextView)localObject).setTextSize(2, this.n);
    ((RedDotTextView)localObject).setTextColor(this.i);
    ((RedDotTextView)localObject).setPadding(this.j, this.l, this.k, this.m);
    ((RedDotTextView)localObject).setSingleLine();
    ((RedDotTextView)localObject).setFocusable(true);
    ((RedDotTextView)localObject).setContentDescription(paramString);
    ((RedDotTextView)localObject).setGravity(17);
    localslw.b.setContentDescription(paramString);
    if (this.jdField_a_of_type_Int == 1)
    {
      localslw.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, anll.a.density * 10.0F);
      ViewCompat.setAccessibilityDelegate((View)localObject, new slt(this));
      this.jdField_a_of_type_JavaUtilList.add(localslw);
      this.jdField_b_of_type_JavaUtilList.add(localRelativeLayout);
      this.jdField_c_of_type_JavaUtilList.add(paramString);
      if (this.jdField_a_of_type_JavaUtilList.size() != 2) {
        break label429;
      }
      setGravity(1);
    }
    for (;;)
    {
      localObject = new LinearLayout.LayoutParams(0, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      addView(localRelativeLayout, paramInt, (ViewGroup.LayoutParams)localObject);
      if (!TextUtils.isEmpty(paramString)) {
        localRelativeLayout.setOnClickListener(new slu(this, paramInt));
      }
      return localslw;
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      localslw.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, anll.a.density * 7.0F);
      break;
      label429:
      setGravity(8388627);
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    slw localslw = (slw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localslw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    localslw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    slw localslw;
    do
    {
      do
      {
        return;
        if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_JavaUtilList.size()))
        {
          localslw = (slw)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if (localslw != null) {
            localslw.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setTextColor(this.i);
          }
        }
      } while ((paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_JavaUtilList.size()));
      localslw = (slw)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
    } while (localslw == null);
    localslw.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setTextColor(this.h);
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    slw localslw = (slw)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
    if (paramInt2 == 0)
    {
      localslw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localslw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      if (paramInt2 > 99)
      {
        localslw.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(99) + "+");
        if (this.jdField_a_of_type_Int == 1) {
          localslw.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, anll.a.density * 8.5F);
        }
      }
      for (;;)
      {
        localslw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localslw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
        localslw.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt2));
        if (this.jdField_a_of_type_Int == 1) {
          localslw.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, anll.a.density * 10.0F);
        }
      }
    }
    localslw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    localslw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    boolean bool2 = true;
    super.dispatchDraw(paramCanvas);
    View localView1 = getChildAt(this.p);
    View localView2 = getChildAt(this.o);
    int i2;
    int i1;
    slw localslw;
    boolean bool1;
    float f1;
    if (localView1 != null)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(this.n * getContext().getResources().getDisplayMetrics().density + 0.5F);
      i2 = localView1.getLeft();
      i1 = localView1.getRight();
      localslw = (slw)this.jdField_a_of_type_JavaUtilList.get(this.p);
      if (!localslw.a()) {
        break label362;
      }
      if (this.jdField_a_of_type_Float <= 0.0F) {
        break label359;
      }
      if (this.p >= this.o) {
        break label347;
      }
      bool1 = true;
      i2 = (int)(localView1.getLeft() + a(this.jdField_a_of_type_Float, bool1) * (localView2.getLeft() - localView1.getLeft()));
      f1 = localView1.getRight();
      float f2 = this.jdField_a_of_type_Float;
      if (bool1) {
        break label353;
      }
      bool1 = bool2;
      label179:
      i1 = (int)(a(f2, bool1) * (localView2.getRight() - localView1.getRight()) + f1);
      label204:
      paramCanvas.drawRect(i2, getHeight() - this.g, i1, getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    label347:
    label353:
    label359:
    label362:
    for (;;)
    {
      i2 = (localView2.getLeft() + localView2.getRight()) / 2;
      int i3 = localslw.jdField_a_of_type_AndroidViewView.getTop();
      int i4 = localslw.jdField_a_of_type_AndroidViewView.getBottom();
      int i5 = (i3 + i4) / 2;
      f1 = (localView2.getRight() - localView2.getLeft()) / 2;
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(96.0F * (1.0F - this.jdField_a_of_type_Float)));
      paramCanvas.clipRect(0, i3, i1, i4);
      paramCanvas.drawCircle(i2, i5, this.jdField_a_of_type_Float * (f1 * 1.2F), this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label179;
      break label204;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.f, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.f);
  }
  
  public void setEnableRepeatedClick(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnTabChangeListener(slv paramslv)
  {
    this.jdField_a_of_type_Slv = paramslv;
  }
  
  public void setSelectColor(int paramInt)
  {
    this.h = paramInt;
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.h);
    invalidate();
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    setSelectedTab(paramInt, paramBoolean, false);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    if ((paramBoolean1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {}
    label175:
    do
    {
      do
      {
        return;
        int i1 = paramInt;
        if (paramInt < 0) {
          i1 = 0;
        }
        int i3 = getChildCount();
        paramInt = i1;
        if (i1 >= i3) {
          paramInt = i3 - 1;
        }
        if (this.p == paramInt) {
          break label175;
        }
        if (this.p == -1) {
          paramBoolean1 = false;
        }
        if (!paramBoolean1) {
          break;
        }
      } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true));
      this.jdField_a_of_type_Float = 0.0F;
      this.o = paramInt;
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
      paramInt = i2;
      if (paramBoolean2) {
        paramInt = 1;
      }
      localMessage.arg1 = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
      a();
      if (!paramBoolean2) {
        b(this.p, paramInt);
      }
      this.o = paramInt;
      this.jdField_a_of_type_Float = 1.0F;
      a(this.p, paramInt);
      invalidate();
      this.p = paramInt;
      return;
    } while ((!this.jdField_a_of_type_Boolean) || (paramBoolean2));
    b(this.p, this.p);
  }
  
  public void setTabHeight(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setTabLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = paramLayoutParams;
  }
  
  public void setTabTextSize(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setTextPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.j = paramInt1;
    this.l = paramInt2;
    this.k = paramInt3;
    this.m = paramInt4;
  }
  
  public void setUnderLineHeight(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setUnselectColor(int paramInt)
  {
    this.i = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar
 * JD-Core Version:    0.7.0.1
 */