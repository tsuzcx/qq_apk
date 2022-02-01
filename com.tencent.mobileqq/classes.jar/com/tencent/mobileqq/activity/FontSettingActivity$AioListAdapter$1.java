package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.widget.ListView;

class FontSettingActivity$AioListAdapter$1
  implements Runnable
{
  FontSettingActivity$AioListAdapter$1(FontSettingActivity.AioListAdapter paramAioListAdapter) {}
  
  public void run()
  {
    this.a.a.e.setAdapter(null);
    this.a.a.e.setAdapter(this.a.a.m);
    FontSettingManager.revertToLsatDendisy(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity.AioListAdapter.1
 * JD-Core Version:    0.7.0.1
 */