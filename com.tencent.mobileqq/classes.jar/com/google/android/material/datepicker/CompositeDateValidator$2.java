package com.google.android.material.datepicker;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;

final class CompositeDateValidator$2
  implements CompositeDateValidator.Operator
{
  public int a()
  {
    return 2;
  }
  
  public boolean a(@NonNull List<CalendarConstraints.DateValidator> paramList, long paramLong)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CalendarConstraints.DateValidator localDateValidator = (CalendarConstraints.DateValidator)paramList.next();
      if ((localDateValidator != null) && (!localDateValidator.a(paramLong))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.CompositeDateValidator.2
 * JD-Core Version:    0.7.0.1
 */