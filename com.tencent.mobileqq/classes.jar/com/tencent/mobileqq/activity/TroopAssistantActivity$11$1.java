package com.tencent.mobileqq.activity;

import android.widget.BaseAdapter;
import com.tencent.widget.XListView;

class TroopAssistantActivity$11$1
  implements Runnable
{
  TroopAssistantActivity$11$1(TroopAssistantActivity.11 param11) {}
  
  public void run()
  {
    if ((this.a.a.b.getAdapter() instanceof BaseAdapter)) {
      ((BaseAdapter)this.a.a.b.getAdapter()).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.11.1
 * JD-Core Version:    0.7.0.1
 */