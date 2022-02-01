package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import java.util.Calendar;

class BirthdayPickHelper$DateAdapter
  implements IphonePickerView.PickerViewAdapter
{
  final int jdField_a_of_type_Int;
  
  public BirthdayPickHelper$DateAdapter(BirthdayPickHelper paramBirthdayPickHelper, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int getColumnCount()
  {
    return 3;
  }
  
  public int getRowCount(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return this.jdField_a_of_type_Int;
    case 1: 
      return 12;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, BirthdayPickHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper) + BirthdayPickHelper.d(this.jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper));
    localCalendar.set(2, BirthdayPickHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper));
    localCalendar.set(5, 1);
    return localCalendar.getActualMaximum(5);
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return BirthdayPickHelper.d(this.jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper, paramInt2) + HardCodeUtil.a(2131700100);
    case 1: 
      return BirthdayPickHelper.e(this.jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper, paramInt2) + HardCodeUtil.a(2131700097);
    }
    return BirthdayPickHelper.f(this.jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper, paramInt2) + HardCodeUtil.a(2131700098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BirthdayPickHelper.DateAdapter
 * JD-Core Version:    0.7.0.1
 */