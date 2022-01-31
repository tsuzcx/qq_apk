package com.tencent.biz.qqstory.view.widget;

import aepi;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import xwm;
import xwn;
import xwo;

public class SlideTabViewPager
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -8421505;
  private Context jdField_a_of_type_AndroidContentContext;
  protected ViewPager.OnPageChangeListener a;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  protected View.OnClickListener a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewPagerTapBlockView jdField_a_of_type_ComTencentBizQqstoryViewWidgetViewPagerTapBlockView;
  private ArrayList<TextView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private xwo jdField_a_of_type_Xwo;
  private int jdField_b_of_type_Int = -12143138;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ArrayList<View> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int c = 14;
  private int d;
  
  public SlideTabViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlideTabViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlideTabViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new xwm(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new xwn(this);
    a(paramContext);
  }
  
  private int a(float paramFloat)
  {
    return aepi.a(paramFloat, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    inflate(paramContext, 2131561656, this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetViewPagerTapBlockView = ((ViewPagerTapBlockView)findViewById(2131377459));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377460));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131364973));
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (i == paramInt) {
        localTextView.setTextColor(this.jdField_b_of_type_Int);
      }
      for (;;)
      {
        i += 1;
        break;
        localTextView.setTextColor(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void onClick(View paramView) {}
  
  public void setOnPageSelected(xwo paramxwo)
  {
    this.jdField_a_of_type_Xwo = paramxwo;
  }
  
  public void setSlideBlockColor(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetViewPagerTapBlockView.setBlockColor(paramInt);
  }
  
  public void setTab(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
    }
  }
  
  public void setTabTextStyle(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.SlideTabViewPager
 * JD-Core Version:    0.7.0.1
 */