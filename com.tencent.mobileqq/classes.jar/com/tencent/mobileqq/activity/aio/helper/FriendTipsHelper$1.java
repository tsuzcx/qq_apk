package com.tencent.mobileqq.activity.aio.helper;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

class FriendTipsHelper$1
  implements Runnable
{
  FriendTipsHelper$1(FriendTipsHelper paramFriendTipsHelper) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.this$0.d.getPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LT_tip_show_times");
    localStringBuilder.append(this.this$0.d.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), 1);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FriendTipsHelper.1
 * JD-Core Version:    0.7.0.1
 */