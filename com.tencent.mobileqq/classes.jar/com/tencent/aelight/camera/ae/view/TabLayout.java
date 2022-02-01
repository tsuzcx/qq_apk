package com.tencent.aelight.camera.ae.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import java.util.ArrayList;
import java.util.List;

public class TabLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView = new View(getContext());
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private TabLayout.OnTabSelectedCallback jdField_a_of_type_ComTencentAelightCameraAeViewTabLayout$OnTabSelectedCallback;
  private List<TabLayout.TabView> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = AEThemeUtil.a();
  @DrawableRes
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  
  public TabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramContext);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return 0;
    }
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a()
  {
    this.jdField_b_of_type_Int = 2064056404;
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_b_of_type_Int);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(a(getContext(), 7.0F), a(getContext(), 7.0F));
    localLayoutParams.addRule(12);
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeViewTabLayout$OnTabSelectedCallback;
    if (localObject != null) {
      ((TabLayout.OnTabSelectedCallback)localObject).a(paramInt);
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (TabLayout.TabView)this.jdField_a_of_type_JavaUtilList.get(i);
      boolean bool2 = true;
      boolean bool1 = true;
      if (paramInt == 0)
      {
        if (paramInt != i) {
          bool1 = false;
        }
        ((TabLayout.TabView)localObject).a(bool1, false);
      }
      else
      {
        if (paramInt == i) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        ((TabLayout.TabView)localObject).a(bool1, this.jdField_b_of_type_Boolean);
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Int == 0) {
      i = this.jdField_b_of_type_Int;
    } else if (this.jdField_b_of_type_Boolean) {
      i = 2064056403;
    } else {
      i = this.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(i);
    localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if (localObject != null) {
      ((ViewPager)localObject).setCurrentItem(paramInt);
    }
  }
  
  private void c(int paramInt)
  {
    float f1 = this.jdField_a_of_type_AndroidViewView.getX();
    float f2 = ((TabLayout.TabView)this.jdField_a_of_type_JavaUtilList.get(paramInt)).getX();
    float f3 = ((TabLayout.TabView)this.jdField_a_of_type_JavaUtilList.get(paramInt)).getWidth() / 2.0F;
    float f4 = this.jdField_a_of_type_AndroidViewView.getWidth() / 2.0F;
    ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "x", new float[] { f1, f2 + f3 - f4 }).setDuration(250L).start();
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      return;
    }
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    TabLayout.OnTabSelectedCallback localOnTabSelectedCallback = this.jdField_a_of_type_ComTencentAelightCameraAeViewTabLayout$OnTabSelectedCallback;
    if ((localOnTabSelectedCallback != null) && (!localOnTabSelectedCallback.a(paramInt)))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewTabLayout$OnTabSelectedCallback.a(paramInt);
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    c(paramInt);
    b(paramInt);
  }
  
  public void a(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = paramViewPager;
    paramViewPager.setOnPageChangeListener(new TabLayout.3(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      TabLayout.TabView localTabView = (TabLayout.TabView)this.jdField_a_of_type_JavaUtilList.get(i);
      int j = this.jdField_a_of_type_Int;
      boolean bool = true;
      paramBoolean = true;
      if (j == 0)
      {
        if (j != i) {
          paramBoolean = false;
        }
        localTabView.a(paramBoolean, false);
      }
      else
      {
        if (j == i) {
          paramBoolean = bool;
        } else {
          paramBoolean = false;
        }
        localTabView.a(paramBoolean, this.jdField_b_of_type_Boolean);
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Int == 0) {
      i = this.jdField_b_of_type_Int;
    } else if (this.jdField_b_of_type_Boolean) {
      i = 2064056403;
    } else {
      i = this.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(i);
  }
  
  public void setTabSelectedCallback(TabLayout.OnTabSelectedCallback paramOnTabSelectedCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeViewTabLayout$OnTabSelectedCallback = paramOnTabSelectedCallback;
  }
  
  public void setTabs(List<String> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() < 1) {
        return;
      }
      int j = paramList.size();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setWeightSum(j);
      int i = 0;
      while (i < j)
      {
        TabLayout.TabView localTabView = new TabLayout.TabView(getContext(), this.jdField_a_of_type_Boolean);
        localTabView.a().setText((CharSequence)paramList.get(i));
        boolean bool;
        if (paramInt == i) {
          bool = true;
        } else {
          bool = false;
        }
        localTabView.a(bool, this.jdField_b_of_type_Boolean);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
        localLayoutParams.weight = 1.0F;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTabView, localLayoutParams);
        this.jdField_a_of_type_JavaUtilList.add(localTabView);
        localTabView.setOnClickListener(new TabLayout.1(this, i));
        i += 1;
      }
      a();
      if (paramList.size() > 1) {
        ((TabLayout.TabView)this.jdField_a_of_type_JavaUtilList.get(0)).post(new TabLayout.2(this, paramInt));
      }
      this.jdField_a_of_type_Int = paramInt;
      paramInt = this.jdField_a_of_type_Int;
      if (paramInt != 0) {
        b(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.TabLayout
 * JD-Core Version:    0.7.0.1
 */