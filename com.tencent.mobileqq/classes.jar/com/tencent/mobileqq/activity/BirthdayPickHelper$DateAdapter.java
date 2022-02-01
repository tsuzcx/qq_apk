package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import java.util.Calendar;

class BirthdayPickHelper$DateAdapter
  implements IphonePickerView.PickerViewAdapter
{
  final int a;
  
  public BirthdayPickHelper$DateAdapter(BirthdayPickHelper paramBirthdayPickHelper, int paramInt)
  {
    this.a = paramInt;
  }
  
  public int getColumnCount()
  {
    return 3;
  }
  
  public int getRowCount(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return 0;
        }
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(1, BirthdayPickHelper.c(this.b) + BirthdayPickHelper.f(this.b));
        localCalendar.set(2, BirthdayPickHelper.d(this.b));
        localCalendar.set(5, 1);
        return localCalendar.getActualMaximum(5);
      }
      return 12;
    }
    return this.a;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return "";
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(BirthdayPickHelper.f(this.b, paramInt2));
        localStringBuilder.append(HardCodeUtil.a(2131898282));
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(BirthdayPickHelper.e(this.b, paramInt2));
      localStringBuilder.append(HardCodeUtil.a(2131898281));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BirthdayPickHelper.d(this.b, paramInt2));
    localStringBuilder.append(HardCodeUtil.a(2131898284));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BirthdayPickHelper.DateAdapter
 * JD-Core Version:    0.7.0.1
 */