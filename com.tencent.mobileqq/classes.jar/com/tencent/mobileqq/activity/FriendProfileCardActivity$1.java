package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.util.WeakReferenceHandler;

class FriendProfileCardActivity$1
  extends CallBacker
{
  FriendProfileCardActivity$1(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramLong == 15L) && (paramString1.startsWith("card.")) && (this.a.a != null))
    {
      paramString1 = this.a.a.obtainMessage();
      paramString1.what = 7;
      if (paramInt1 != 0) {
        break label82;
      }
      paramString1.arg1 = 1;
    }
    for (paramString1.arg2 = 1;; paramString1.arg2 = 0)
    {
      if (this.a.a != null) {
        this.a.a.sendMessage(paramString1);
      }
      return;
      label82:
      paramString1.arg1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.1
 * JD-Core Version:    0.7.0.1
 */