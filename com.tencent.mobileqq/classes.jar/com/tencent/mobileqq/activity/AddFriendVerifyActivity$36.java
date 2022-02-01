package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class AddFriendVerifyActivity$36
  implements Runnable
{
  AddFriendVerifyActivity$36(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3) {}
  
  public void run()
  {
    if (this.a == 3004)
    {
      int i = this.b;
      if ((i == 5) || (i == 6) || (i == 7) || (i == 8))
      {
        String str1;
        if (this.c) {
          str1 = "multiMode_send";
        } else {
          str1 = "singleMode_send";
        }
        QQAppInterface localQQAppInterface = this.this$0.app;
        String str3 = this.d;
        String str2;
        if (this.c) {
          str2 = "1";
        } else {
          str2 = String.valueOf(this.e);
        }
        ReportController.b(localQQAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", str1, 0, 0, str3, str2, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.36
 * JD-Core Version:    0.7.0.1
 */