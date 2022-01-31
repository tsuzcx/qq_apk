package com.tencent.mobileqq.app.utils;

import amrj;
import amrt;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.widget.VerticalGallery;

public class TimeWheelPanel
  extends LinearLayout
  implements amrj
{
  public int a;
  private amrt jdField_a_of_type_Amrt;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NumberWheelView jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private NumberWheelView jdField_b_of_type_ComTencentMobileqqAppUtilsNumberWheelView;
  private boolean jdField_b_of_type_Boolean;
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
      this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560859, this);
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView = ((NumberWheelView)findViewById(2131365018));
      this.jdField_b_of_type_ComTencentMobileqqAppUtilsNumberWheelView = ((NumberWheelView)findViewById(2131367799));
      this.jdField_c_of_type_ComTencentMobileqqAppUtilsNumberWheelView = ((NumberWheelView)findViewById(2131370659));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365019));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367800));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370660));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365779));
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
    if (paramInt4 > 0)
    {
      this.h = paramInt4;
      if ((paramInt1 < 0) || (paramInt1 >= this.h)) {
        break label109;
      }
      label23:
      this.i = paramInt1;
      if ((paramInt2 < 0) || (paramInt2 >= 24)) {
        break label114;
      }
      label38:
      this.j = paramInt2;
      if ((paramInt3 < 0) || (paramInt3 >= 60)) {
        break label119;
      }
    }
    for (;;)
    {
      this.k = paramInt3;
      this.jdField_a_of_type_Int = this.i;
      this.jdField_b_of_type_Int = this.j;
      this.jdField_c_of_type_Int = this.k;
      this.l = 1;
      this.m = 1;
      this.n = 1;
      a();
      return;
      paramInt4 = 30;
      break;
      label109:
      paramInt1 = 0;
      break label23;
      label114:
      paramInt2 = 0;
      break label38;
      label119:
      paramInt3 = 0;
    }
  }
  
  public void a(NumberWheelView paramNumberWheelView, VerticalGallery paramVerticalGallery)
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView.a();
    this.jdField_b_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqAppUtilsNumberWheelView.a();
    this.jdField_c_of_type_Int = this.jdField_c_of_type_ComTencentMobileqqAppUtilsNumberWheelView.a();
    setValues(false);
    if (this.jdField_a_of_type_Amrt != null) {
      this.jdField_a_of_type_Amrt.a(paramNumberWheelView, paramVerticalGallery);
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
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.post(new TimeWheelPanel.1(this));
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString1);
    }
  }
  
  public void setScrollerStateListener(amrt paramamrt)
  {
    this.jdField_a_of_type_Amrt = paramamrt;
  }
  
  public void setValues(boolean paramBoolean)
  {
    if ((this.l != 1) || (this.m != 1) || (this.n != 1)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0) && (this.jdField_c_of_type_Int == 0) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_c_of_type_Int = 1;
        this.jdField_c_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setValue(this.jdField_c_of_type_Int);
      }
    } while (!paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setValue(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setValue(this.jdField_b_of_type_Int);
    this.jdField_c_of_type_ComTencentMobileqqAppUtilsNumberWheelView.setValue(this.jdField_c_of_type_Int);
  }
  
  public void setViewVisibility(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      findViewById(2131365014).setVisibility(paramInt2);
    }
    do
    {
      return;
      if (paramInt1 == 1)
      {
        findViewById(2131367795).setVisibility(paramInt2);
        return;
      }
      if (paramInt1 == 2)
      {
        findViewById(2131370656).setVisibility(paramInt2);
        return;
      }
    } while (paramInt1 != 3);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.TimeWheelPanel
 * JD-Core Version:    0.7.0.1
 */