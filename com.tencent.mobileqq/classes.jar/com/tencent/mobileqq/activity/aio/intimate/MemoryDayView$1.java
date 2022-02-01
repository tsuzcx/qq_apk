package com.tencent.mobileqq.activity.aio.intimate;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;

class MemoryDayView$1
  implements MemoryDayView.OnItemClick
{
  MemoryDayView$1(MemoryDayView paramMemoryDayView) {}
  
  public void a(View paramView, IntimateInfo.MemoryDayInfo paramMemoryDayInfo)
  {
    if (MemoryDayView.a(this.a) != null)
    {
      int j = MemoryDayView.a(this.a).getChildCount();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          paramView = MemoryDayView.a(this.a).getChildAt(i).getTag();
          if (((paramView instanceof IntimateInfo.MemoryDayInfo)) && (((IntimateInfo.MemoryDayInfo)paramView).dateType == paramMemoryDayInfo.dateType))
          {
            MemoryDayView.a(this.a).removeViewAt(i);
            break;
          }
          i += 1;
        }
      }
      if (MemoryDayView.a(this.a).getChildCount() <= 0) {
        MemoryDayView.a(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.MemoryDayView.1
 * JD-Core Version:    0.7.0.1
 */