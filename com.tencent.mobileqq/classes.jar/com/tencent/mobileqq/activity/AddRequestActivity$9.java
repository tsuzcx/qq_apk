package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.ThreadManager;

class AddRequestActivity$9
  extends FriendListObserver
{
  AddRequestActivity$9(AddRequestActivity paramAddRequestActivity) {}
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if (AddRequestActivity.e(this.a))
    {
      if (!paramBoolean)
      {
        paramString = this.a;
        paramString.showToast(2130839791, paramString.getString(2131916242));
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("base_uin", paramString);
      String str = this.a.l;
      if (TextUtils.isEmpty(this.a.l)) {
        str = this.a.a;
      }
      localBundle.putString("base_nick", str);
      localBundle.putInt("verfy_type", AddRequestActivity.f(this.a));
      localBundle.putString("verfy_msg", AddRequestActivity.g(this.a));
      if (AddRequestActivity.a(this.a) != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      localBundle.putBoolean("isFromWzry", paramBoolean);
      AutoRemarkActivity.a(this.a, 0, paramString, 0L, localBundle);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.a != null) && (this.a.a.equals(paramString))) {
      ThreadManager.post(new AddRequestActivity.9.1(this), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.9
 * JD-Core Version:    0.7.0.1
 */