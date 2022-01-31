package com.tencent.mobileqq.activity;

import aaur;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import baig;
import com.tencent.common.app.BaseApplicationImpl;

public class FriendProfileCardActivity$32$2
  implements Runnable
{
  public FriendProfileCardActivity$32$2(aaur paramaaur) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("showPresentRed", 0).edit();
    localEditor.putBoolean("showRed", false);
    baig.a(localEditor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.32.2
 * JD-Core Version:    0.7.0.1
 */