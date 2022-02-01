package com.tencent.mobileqq.activity;

import afbj;
import android.widget.BaseAdapter;
import com.tencent.widget.XListView;

public class TroopAssistantActivity$11$1
  implements Runnable
{
  public TroopAssistantActivity$11$1(afbj paramafbj) {}
  
  public void run()
  {
    if ((this.a.a.a.getAdapter() instanceof BaseAdapter)) {
      ((BaseAdapter)this.a.a.a.getAdapter()).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.11.1
 * JD-Core Version:    0.7.0.1
 */