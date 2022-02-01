package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;

class TroopAssisSettingActivity$2
  extends Handler
{
  TroopAssisSettingActivity$2(TroopAssisSettingActivity paramTroopAssisSettingActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    this.a.b.a(this.a.c);
    this.a.b.notifyDataSetChanged();
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */