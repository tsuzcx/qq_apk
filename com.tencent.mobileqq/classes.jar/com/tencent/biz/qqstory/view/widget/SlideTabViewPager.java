package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import ovv;
import ovw;

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
  private SlideTabViewPager.OnPageChangeListener jdField_a_of_type_ComTencentBizQqstoryViewWidgetSlideTabViewPager$OnPageChangeListener;
  private ViewPagerTapBlockView jdField_a_of_type_ComTencentBizQqstoryViewWidgetViewPagerTapBlockView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int = -12143138;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
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
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new ovv(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ovw(this);
    a(paramContext);
  }
  
  private int a(float paramFloat)
  {
    return AIOUtils.a(paramFloat, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    inflate(paramContext, 2130970926, this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetViewPagerTapBlockView = ((ViewPagerTapBlockView)findViewById(2131372154));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372183));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131372155));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public TextView a(int paramInt, String paramString, View paramView)
  {
    this.jdField_b_of_type_JavaUtilArrayList.add(paramInt, paramView);
    paramView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    paramView.setText(paramString);
    paramView.setTextColor(this.jdField_a_of_type_Int);
    paramView.setTextSize(this.c);
    paramView.setGravity(15);
    paramView.setTag(Integer.valueOf(paramInt));
    paramView.setPadding(0, a(5.0F), 0, a(5.0F));
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.gravity = 15;
    if (paramInt != 0) {
      paramString.leftMargin = a(37.0F);
    }
    paramView.setLayoutParams(paramString);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, paramInt);
    return paramView;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() == 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return;
    }
    Object localObject = new SlideTabViewPager.TabViewAdapter(this, this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter((PagerAdapter)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(1));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    }
    localObject = (TextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    b(paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetViewPagerTapBlockView.setBlockWidth(((TextView)localObject).getWidth());
  }
  
  public void a(int paramInt, String paramString, View paramView)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      ((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).setText(paramString);
      this.jdField_b_of_type_JavaUtilArrayList.add(paramInt, paramView);
      paramString = new SlideTabViewPager.TabViewAdapter(this, this.jdField_b_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(paramString);
    }
  }
  
  public void b(int paramInt)
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
  
  public void setOnPageSelected(SlideTabViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetSlideTabViewPager$OnPageChangeListener = paramOnPageChangeListener;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.SlideTabViewPager
 * JD-Core Version:    0.7.0.1
 */