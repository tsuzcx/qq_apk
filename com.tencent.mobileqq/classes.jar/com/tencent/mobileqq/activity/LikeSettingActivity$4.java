package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;

class LikeSettingActivity$4
  implements Runnable
{
  LikeSettingActivity$4(LikeSettingActivity paramLikeSettingActivity) {}
  
  public void run()
  {
    boolean bool = this.this$0.app.getLocZanAllowedForPeople();
    this.this$0.runOnUiThread(new LikeSettingActivity.4.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeSettingActivity.4
 * JD-Core Version:    0.7.0.1
 */