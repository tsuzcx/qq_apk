package com.tencent.mobileqq.app.utils;

import android.text.Layout;
import android.widget.TextView;

class TimeWheelPanel$1
  implements Runnable
{
  TimeWheelPanel$1(TimeWheelPanel paramTimeWheelPanel) {}
  
  public void run()
  {
    if ((TimeWheelPanel.a(this.this$0).getLayout().getEllipsisCount(TimeWheelPanel.a(this.this$0).getLineCount() - 1) <= 0) || (TimeWheelPanel.a(this.this$0) == null) || (TimeWheelPanel.a(this.this$0).getText().toString().equals(TimeWheelPanel.a(this.this$0)))) {
      return;
    }
    TimeWheelPanel.a(this.this$0, true);
    TimeWheelPanel.a(this.this$0).setText(TimeWheelPanel.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.TimeWheelPanel.1
 * JD-Core Version:    0.7.0.1
 */