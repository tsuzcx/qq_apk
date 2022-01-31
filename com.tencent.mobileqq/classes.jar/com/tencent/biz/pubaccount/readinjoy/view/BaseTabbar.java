package com.tencent.biz.pubaccount.readinjoy.view;

import alsf;
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
import bdoo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rot;
import rou;
import rov;
import row;
import rox;

public class BaseTabbar
  extends LinearLayout
{
  private static int jdField_c_of_type_Int;
  private static final int d;
  private static final int e;
  private static final int f = 14;
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 1;
  public final Paint a;
  private Handler jdField_a_of_type_AndroidOsHandler = new rot(this);
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  private List<rox> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public row a;
  private boolean jdField_a_of_type_Boolean = true;
  protected int b;
  public final Paint b;
  private List<RelativeLayout> b;
  Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private int g = d;
  private int h = e;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o = f;
  private int p = -1;
  private int q = -1;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    d = (int)(40.0F * localBaseApplication.getResources().getDisplayMetrics().density + 0.5F);
    e = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 4.0F + 0.5F);
  }
  
  public BaseTabbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseTabbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = 99;
    this.i = paramContext.getResources().getColor(2131166911);
    this.j = paramContext.getResources().getColor(2131166903);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.i);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(0, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.weight = 1.0F;
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.gravity = 17;
    setBackgroundDrawable(getResources().getDrawable(2130849796));
    if (jdField_c_of_type_Int == 0) {
      jdField_c_of_type_Int = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-8355712);
    int i1 = bdoo.a();
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
        localObject = ((rox)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
        if (localObject != null) {
          ((RedDotTextView)localObject).setContentDescription(((RedDotTextView)localObject).getText() + getContext().getString(2131691159));
        }
        i1 += 1;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Row != null) {
      this.jdField_a_of_type_Row.a(paramInt1, paramInt2);
    }
  }
  
  public int a()
  {
    return this.q;
  }
  
  public rox a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    if (paramInt == 2) {
      localRelativeLayout.setVisibility(8);
    }
    Object localObject = LayoutInflater.from(getContext()).inflate(2131559922, localRelativeLayout, true);
    rox localrox = new rox();
    localrox.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131377365);
    localrox.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)((View)localObject).findViewById(2131377606));
    localrox.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131375551));
    localrox.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131371322));
    localrox.b = ((ImageView)((View)localObject).findViewById(2131367921));
    localrox.c = ((ImageView)((View)localObject).findViewById(2131376811));
    localObject = localrox.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
    ((RedDotTextView)localObject).setText(paramString);
    ((RedDotTextView)localObject).setTextSize(2, this.o);
    ((RedDotTextView)localObject).setTextColor(this.j);
    ((RedDotTextView)localObject).setPadding(this.k, this.m, this.l, this.n);
    ((RedDotTextView)localObject).setSingleLine();
    ((RedDotTextView)localObject).setFocusable(true);
    ((RedDotTextView)localObject).setContentDescription(paramString);
    ((RedDotTextView)localObject).setGravity(17);
    localrox.b.setContentDescription(paramString);
    if (this.jdField_a_of_type_Int == 1)
    {
      localrox.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, alsf.a.density * 10.0F);
      ViewCompat.setAccessibilityDelegate((View)localObject, new rou(this));
      this.jdField_a_of_type_JavaUtilList.add(localrox);
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
        localRelativeLayout.setOnClickListener(new rov(this, paramInt));
      }
      return localrox;
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      localrox.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, alsf.a.density * 7.0F);
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
    rox localrox = (rox)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localrox.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    localrox.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    rox localrox;
    do
    {
      do
      {
        return;
        if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_JavaUtilList.size()))
        {
          localrox = (rox)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if (localrox != null) {
            localrox.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setTextColor(this.j);
          }
        }
      } while ((paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_JavaUtilList.size()));
      localrox = (rox)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
    } while (localrox == null);
    localrox.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setTextColor(this.i);
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    rox localrox = (rox)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
    if (paramInt2 == 0)
    {
      localrox.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localrox.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      if (paramInt2 > this.jdField_b_of_type_Int)
      {
        localrox.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(99) + "+");
        if (this.jdField_a_of_type_Int == 1) {
          localrox.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, alsf.a.density * 8.5F);
        }
      }
      for (;;)
      {
        localrox.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localrox.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
        localrox.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt2));
        if (this.jdField_a_of_type_Int == 1) {
          localrox.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, alsf.a.density * 10.0F);
        }
      }
    }
    localrox.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    localrox.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    boolean bool2 = true;
    super.dispatchDraw(paramCanvas);
    View localView1 = getChildAt(this.q);
    View localView2 = getChildAt(this.p);
    int i2;
    int i1;
    rox localrox;
    boolean bool1;
    float f1;
    if (localView1 != null)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(this.o * getContext().getResources().getDisplayMetrics().density + 0.5F);
      i2 = localView1.getLeft();
      i1 = localView1.getRight();
      localrox = (rox)this.jdField_a_of_type_JavaUtilList.get(this.q);
      if (!localrox.a()) {
        break label362;
      }
      if (this.jdField_a_of_type_Float <= 0.0F) {
        break label359;
      }
      if (this.q >= this.p) {
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
      paramCanvas.drawRect(i2, getHeight() - this.h, i1, getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    label347:
    label353:
    label359:
    label362:
    for (;;)
    {
      i2 = (localView2.getLeft() + localView2.getRight()) / 2;
      int i3 = localrox.jdField_a_of_type_AndroidViewView.getTop();
      int i4 = localrox.jdField_a_of_type_AndroidViewView.getBottom();
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
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.g, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.g);
  }
  
  public void setEnableRepeatedClick(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnTabChangeListener(row paramrow)
  {
    this.jdField_a_of_type_Row = paramrow;
  }
  
  public void setSelectColor(int paramInt)
  {
    this.i = paramInt;
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.i);
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
        if (this.q == paramInt) {
          break label175;
        }
        if (this.q == -1) {
          paramBoolean1 = false;
        }
        if (!paramBoolean1) {
          break;
        }
      } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true));
      this.jdField_a_of_type_Float = 0.0F;
      this.p = paramInt;
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
        b(this.q, paramInt);
      }
      this.p = paramInt;
      this.jdField_a_of_type_Float = 1.0F;
      a(this.q, paramInt);
      invalidate();
      this.q = paramInt;
      return;
    } while ((!this.jdField_a_of_type_Boolean) || (paramBoolean2));
    b(this.q, this.q);
  }
  
  public void setTabHeight(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setTabLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = paramLayoutParams;
  }
  
  public void setTabTextSize(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setTextPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.k = paramInt1;
    this.m = paramInt2;
    this.l = paramInt3;
    this.n = paramInt4;
  }
  
  public void setUnderLineHeight(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setUnselectColor(int paramInt)
  {
    this.j = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar
 * JD-Core Version:    0.7.0.1
 */