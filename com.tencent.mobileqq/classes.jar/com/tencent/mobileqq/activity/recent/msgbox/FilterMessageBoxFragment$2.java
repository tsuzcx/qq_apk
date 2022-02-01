package com.tencent.mobileqq.activity.recent.msgbox;

import android.support.v4.app.FragmentActivity;
import java.util.List;

class FilterMessageBoxFragment$2
  implements Runnable
{
  FilterMessageBoxFragment$2(FilterMessageBoxFragment paramFilterMessageBoxFragment) {}
  
  public void run()
  {
    List localList = FilterMessageBoxFragment.a(this.this$0);
    this.this$0.getActivity().runOnUiThread(new FilterMessageBoxFragment.2.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.FilterMessageBoxFragment.2
 * JD-Core Version:    0.7.0.1
 */