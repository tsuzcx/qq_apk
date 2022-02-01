package com.tencent.mobileqq.activity.aio.upcoming;

import android.content.Context;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.PickerViewAdapter;
import java.util.Calendar;
import java.util.Date;

class UpcomingTimeSelector$TimeAdapter
  implements TimeSelectView.PickerViewAdapter
{
  UpcomingTimeSelector$TimeAdapter(UpcomingTimeSelector paramUpcomingTimeSelector) {}
  
  public int a()
  {
    return 2;
  }
  
  public int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return 1;
      }
      if ((UpcomingTimeSelector.a(this.a).a(0) == 0) && (this.a.c < 23)) {
        return this.a.a();
      }
      return 24;
    }
    if (this.a.c >= 23) {
      return 365;
    }
    return 366;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return "";
      }
      if ((UpcomingTimeSelector.a(this.a).a(0) == 0) && (this.a.c < 23))
      {
        localObject1 = this.a.a(paramInt2);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append(this.a.a.getString(2131694556));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append((String)localObject1);
      return ((StringBuilder)localObject2).toString();
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setFirstDayOfWeek(1);
    if (this.a.c < 23) {
      paramInt1 = paramInt2;
    } else {
      paramInt1 = paramInt2 + 1;
    }
    ((Calendar)localObject1).add(6, paramInt1);
    Object localObject2 = this.a.a(paramInt2, (Calendar)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append((String)localObject2);
    localObject2 = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" day_of_week ");
      localStringBuilder.append(((Calendar)localObject1).get(7));
      localStringBuilder.append("\n");
      localStringBuilder.append(((Calendar)localObject1).getTime().toString());
      QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 1, localStringBuilder.toString());
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.UpcomingTimeSelector.TimeAdapter
 * JD-Core Version:    0.7.0.1
 */