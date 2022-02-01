package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class BirthdayPickHelper
{
  private int jdField_a_of_type_Int;
  BirthdayPickHelper.BirthdayChangeListener jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper$BirthdayChangeListener;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private Calendar jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
  private int jdField_b_of_type_Int;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  private int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  
  public BirthdayPickHelper(Context paramContext, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    this.d = this.jdField_a_of_type_JavaUtilCalendar.get(1);
    this.e = (this.jdField_a_of_type_JavaUtilCalendar.get(2) + 1);
    this.f = this.jdField_a_of_type_JavaUtilCalendar.get(5);
    this.jdField_b_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    this.jdField_b_of_type_JavaUtilCalendar.add(1, -120);
    this.jdField_b_of_type_JavaUtilCalendar.add(5, 1);
    this.g = this.jdField_b_of_type_JavaUtilCalendar.get(1);
    this.h = (this.jdField_b_of_type_JavaUtilCalendar.get(2) + 1);
    this.i = this.jdField_b_of_type_JavaUtilCalendar.get(5);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)LayoutInflater.from(paramContext).inflate(2131561132, null));
    int j = this.d;
    int k = this.g;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new BirthdayPickHelper.DateAdapter(this, j - k + 1));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new BirthdayPickHelper.PickListener(this, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(paramContext.getResources().getColor(2131167116));
    a(paramInt);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BirthdayPickHelper", 2, String.format("BirthdayPickHelper date range: %s-%s-%s to %s-%s-%s", new Object[] { Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f) }));
    }
  }
  
  private int a(int paramInt)
  {
    return this.g + paramInt;
  }
  
  private void a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.g + this.jdField_a_of_type_Int);
    localCalendar.set(2, this.jdField_b_of_type_Int);
    localCalendar.set(5, this.c + 1);
    if (localCalendar.before(this.jdField_b_of_type_JavaUtilCalendar))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = (this.h - 1);
      this.c = (this.i - 1);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.c);
      return;
    }
    if (localCalendar.after(this.jdField_a_of_type_JavaUtilCalendar))
    {
      this.jdField_a_of_type_Int = (this.d - this.g);
      this.jdField_b_of_type_Int = (this.e - 1);
      this.c = (this.f - 1);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.c);
    }
  }
  
  private int b(int paramInt)
  {
    return paramInt + 1;
  }
  
  private int c(int paramInt)
  {
    return paramInt + 1;
  }
  
  public IphonePickerView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  }
  
  public void a(int paramInt)
  {
    int k;
    int j;
    if (paramInt <= 0)
    {
      k = 2000 - this.g;
      paramInt = 0;
      j = 0;
    }
    else
    {
      k = this.g;
      j = ((0xFF00 & paramInt) >>> 8) - 1;
      int m = (paramInt & 0xFF) - 1;
      k = ((0xFFFF0000 & paramInt) >>> 16) - k;
      paramInt = m;
    }
    this.jdField_a_of_type_Int = k;
    this.jdField_b_of_type_Int = j;
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, k);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, j);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, paramInt);
  }
  
  public void a(BirthdayPickHelper.BirthdayChangeListener paramBirthdayChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper$BirthdayChangeListener = paramBirthdayChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BirthdayPickHelper
 * JD-Core Version:    0.7.0.1
 */