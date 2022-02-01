package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.widget.VerticalGallery;

public class TimeWheelPanel
  extends LinearLayout
  implements NumberWheelView.ScrollStateListener
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NumberWheelView jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView;
  private TimeWheelPanel.ScrollStateListener jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel$ScrollStateListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  public int b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private NumberWheelView jdField_b_of_type_ComTencentMobileqqAppUtilsNumberWheelView;
  private boolean jdField_b_of_type_Boolean = false;
  public int c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private NumberWheelView jdField_c_of_type_ComTencentMobileqqAppUtilsNumberWheelView;
  private final int jdField_d_of_type_Int = 30;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private final int e = 24;
  private final int f = 60;
  private final int g = 60;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  
  public TimeWheelPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidViewLayoutInflater == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView == null) || (this.jdField_b_of_type_ComTencentMobileqqAppUtilsNumberWheelView == null) || (this.jdField_c_of_type_ComTencentMobileqqAppUtilsNumberWheelView == null))
    {
      this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560985, this);
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView = ((NumberWheelView)findViewById(2131365432));
      this.jdField_b_of_type_ComTencentMobileqqAppUtilsNumberWheelView = ((NumberWheelView)findViewById(2131368319));
      this.jdField_c_of_type_ComTencentMobileqqAppUtilsNumberWheelView = ((NumberWheelView)findViewById(2131371413));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365433));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368320));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371414));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366257));
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setScrollStateListener(this);
      this.jdField_b_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setScrollStateListener(this);
      this.jdField_c_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setScrollStateListener(this);
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setmMaxRotationAngle(0);
      this.jdField_b_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setmMaxRotationAngle(0);
      this.jdField_c_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setmMaxRotationAngle(0);
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setRange(0, this.h - 1);
      this.jdField_b_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setRange(0, 23);
      this.jdField_c_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setRange(0, 59);
    }
    setValues(true);
  }
  
  public int a()
  {
    return ((this.jdField_a_of_type_Int * 24 + this.jdField_b_of_type_Int) * 60 + this.jdField_c_of_type_Int) * 60;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 <= 0) {
      paramInt4 = 30;
    }
    this.h = paramInt4;
    if ((paramInt1 < 0) || (paramInt1 >= this.h)) {
      paramInt1 = 0;
    }
    this.i = paramInt1;
    if ((paramInt2 < 0) || (paramInt2 >= 24)) {
      paramInt2 = 0;
    }
    this.j = paramInt2;
    if ((paramInt3 < 0) || (paramInt3 >= 60)) {
      paramInt3 = 0;
    }
    this.k = paramInt3;
    this.jdField_a_of_type_Int = this.i;
    this.jdField_b_of_type_Int = this.j;
    this.jdField_c_of_type_Int = this.k;
    this.l = 1;
    this.m = 1;
    this.n = 1;
    a();
  }
  
  public void a(NumberWheelView paramNumberWheelView, VerticalGallery paramVerticalGallery)
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView.a();
    this.jdField_b_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqAppUtilsNumberWheelView.a();
    this.jdField_c_of_type_Int = this.jdField_c_of_type_ComTencentMobileqqAppUtilsNumberWheelView.a();
    setValues(false);
    TimeWheelPanel.ScrollStateListener localScrollStateListener = this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel$ScrollStateListener;
    if (localScrollStateListener != null) {
      localScrollStateListener.a(paramNumberWheelView, paramVerticalGallery);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setEndTime(String paramString)
  {
    setEndTime(paramString, null);
  }
  
  public void setEndTime(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    if (paramString2 == null)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString2);
    } else {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString1);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.post(new TimeWheelPanel.1(this));
  }
  
  public void setScrollerStateListener(TimeWheelPanel.ScrollStateListener paramScrollStateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel$ScrollStateListener = paramScrollStateListener;
  }
  
  public void setValues(boolean paramBoolean)
  {
    if ((this.l == 1) && (this.m == 1))
    {
      if (this.n != 1) {
        return;
      }
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0) && (this.jdField_c_of_type_Int == 0) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_c_of_type_Int = 1;
        this.jdField_c_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setValue(this.jdField_c_of_type_Int);
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setValue(this.jdField_a_of_type_Int);
        this.jdField_b_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setValue(this.jdField_b_of_type_Int);
        this.jdField_c_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setValue(this.jdField_c_of_type_Int);
      }
    }
  }
  
  public void setViewVisibility(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      findViewById(2131365428).setVisibility(paramInt2);
      return;
    }
    if (paramInt1 == 1)
    {
      findViewById(2131368315).setVisibility(paramInt2);
      return;
    }
    if (paramInt1 == 2)
    {
      findViewById(2131371410).setVisibility(paramInt2);
      return;
    }
    if (paramInt1 == 3) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.TimeWheelPanel
 * JD-Core Version:    0.7.0.1
 */