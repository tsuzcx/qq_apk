package com.tencent.mobileqq.activity.recent.msgbox;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.Iterator;
import java.util.List;

class FilterMsgBoxFragment$8
  implements Runnable
{
  FilterMsgBoxFragment$8(FilterMsgBoxFragment paramFilterMsgBoxFragment) {}
  
  public void run()
  {
    Iterator localIterator = FilterMsgBoxFragment.f(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
      FilterMsgBoxFragment.a(this.this$0, localRecentBaseData);
    }
    this.this$0.getBaseActivity().runOnUiThread(new FilterMsgBoxFragment.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment.8
 * JD-Core Version:    0.7.0.1
 */