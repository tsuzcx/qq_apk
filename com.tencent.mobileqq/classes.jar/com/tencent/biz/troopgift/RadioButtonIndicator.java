package com.tencent.biz.troopgift;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class RadioButtonIndicator
  extends RadioGroup
  implements ViewPager.OnPageChangeListener, View.OnClickListener, absMultiViewPager.OnPagerSizeChangeListener
{
  protected int a;
  protected ViewPager a;
  public int b;
  
  public RadioButtonIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RadioButtonIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2130839777;
  }
  
  public RadioButton a(int paramInt)
  {
    RadioButtonIndicator.1 local1 = new RadioButtonIndicator.1(this, getContext());
    local1.setButtonDrawable(this.jdField_a_of_type_Int);
    local1.setPadding(10, 0, 10, 0);
    local1.setClickable(true);
    if ((AppSetting.d) && (Build.VERSION.SDK_INT > 16)) {
      ViewCompat.setImportantForAccessibility(local1, 2);
    }
    return local1;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    setButtons(paramInt2);
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    RadioButton localRadioButton = (RadioButton)getChildAt(paramInt);
    if (localRadioButton != null) {
      localRadioButton.setChecked(true);
    }
  }
  
  public void setButtonResourceId(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setButtons(int paramInt)
  {
    removeAllViews();
    if (paramInt <= 1) {
      return;
    }
    int i = 0;
    while (i < paramInt)
    {
      RadioButton localRadioButton = a(i);
      localRadioButton.setTag(Integer.valueOf(i));
      localRadioButton.setOnClickListener(this);
      addView(localRadioButton);
      i += 1;
    }
    this.b = paramInt;
    ((RadioButton)getChildAt(0)).setChecked(true);
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.RadioButtonIndicator
 * JD-Core Version:    0.7.0.1
 */