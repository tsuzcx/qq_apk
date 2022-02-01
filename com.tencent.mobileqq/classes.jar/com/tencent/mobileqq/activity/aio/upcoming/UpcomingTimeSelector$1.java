package com.tencent.mobileqq.activity.aio.upcoming;

import android.content.Context;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.IphonePickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;

class UpcomingTimeSelector$1
  implements TimeSelectView.IphonePickListener
{
  UpcomingTimeSelector$1(UpcomingTimeSelector paramUpcomingTimeSelector) {}
  
  public void a()
  {
    QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, "onConfirm: ");
    if (UpcomingTimeSelector.b(this.a) != null) {
      UpcomingTimeSelector.b(this.a).a(this.a.e);
    }
    UpcomingTimeSelector.c(this.a).dismiss();
    Object localObject = this.a;
    int i = UpcomingTimeSelector.a((UpcomingTimeSelector)localObject, ((UpcomingTimeSelector)localObject).e);
    if ((UpcomingTimeSelector.a(this.a).b(0) == 0) && (this.a.c < 23))
    {
      localObject = this.a;
      localObject = ((UpcomingTimeSelector)localObject).b(UpcomingTimeSelector.a((UpcomingTimeSelector)localObject).b(1));
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(UpcomingTimeSelector.a(this.a).b(1));
      ((StringBuilder)localObject).append(this.a.g.getString(2131892240));
      localObject = ((StringBuilder)localObject).toString();
    }
    ReportController.b(null, "dc00898", "", "", "0X800AE7F", "0X800AE7F", UpcomingTimeSelector.d(this.a), i, "", "", (String)localObject, "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("column: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", row: ");
    localStringBuilder.append(paramInt2);
    QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, localStringBuilder.toString());
    if (paramInt1 == 0) {
      UpcomingTimeSelector.a(this.a).a(1);
    }
  }
  
  public void a(View paramView)
  {
    UpcomingTimeSelector.c(this.a).dismiss();
    ReportController.b(null, "dc00898", "", "", "0X800AE80", "0X800AE80", 0, 0, "", "", "", "");
  }
  
  public void b()
  {
    if (UpcomingTimeSelector.b(this.a) != null) {
      UpcomingTimeSelector.b(this.a).a(-1L);
    }
    UpcomingTimeSelector.c(this.a).dismiss();
    ReportController.b(null, "dc00898", "", "", "0X800B411", "0X800B411", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.UpcomingTimeSelector.1
 * JD-Core Version:    0.7.0.1
 */