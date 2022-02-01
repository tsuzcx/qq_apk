package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.emosm.BaseEmosmStrategy;

class FavEmosmManageActivity$1
  extends BroadcastReceiver
{
  FavEmosmManageActivity$1(FavEmosmManageActivity paramFavEmosmManageActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (FavEmosmManageActivity.a(this.a) != null) {
      FavEmosmManageActivity.a(this.a).a(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FavEmosmManageActivity.1
 * JD-Core Version:    0.7.0.1
 */