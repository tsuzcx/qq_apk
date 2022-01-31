package com.tencent.mobileqq.activity;

import acvg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bdiv;
import com.tencent.common.app.BaseApplicationImpl;

public class FriendProfileCardActivity$32$2
  implements Runnable
{
  public FriendProfileCardActivity$32$2(acvg paramacvg) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("showPresentRed", 0).edit();
    localEditor.putBoolean("showRed", false);
    bdiv.a(localEditor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.32.2
 * JD-Core Version:    0.7.0.1
 */