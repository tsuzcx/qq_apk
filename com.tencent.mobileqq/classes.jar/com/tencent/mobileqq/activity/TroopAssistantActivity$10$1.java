package com.tencent.mobileqq.activity;

import android.widget.BaseAdapter;
import com.tencent.widget.XListView;

class TroopAssistantActivity$10$1
  implements Runnable
{
  TroopAssistantActivity$10$1(TroopAssistantActivity.10 param10) {}
  
  public void run()
  {
    if ((this.a.a.a.getAdapter() instanceof BaseAdapter)) {
      ((BaseAdapter)this.a.a.a.getAdapter()).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.10.1
 * JD-Core Version:    0.7.0.1
 */