package com.tencent.mobileqq.activity.recent.msgbox;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import java.util.Iterator;
import java.util.List;

class FilterMessageBoxFragment$8
  implements Runnable
{
  FilterMessageBoxFragment$8(FilterMessageBoxFragment paramFilterMessageBoxFragment) {}
  
  public void run()
  {
    Iterator localIterator = FilterMessageBoxFragment.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
      FilterMessageBoxFragment.a(this.this$0, localRecentBaseData);
    }
    this.this$0.getActivity().runOnUiThread(new FilterMessageBoxFragment.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.FilterMessageBoxFragment.8
 * JD-Core Version:    0.7.0.1
 */