package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;

class FriendProfileMoreInfoActivity$7
  implements DialogInterface.OnClickListener
{
  FriendProfileMoreInfoActivity$7(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "dc00898", "", "", "0X800A0D9", "0X800A0D9", 0, 0, "", "", "", "");
    if (NetworkUtil.isNetSupport(this.a)) {
      FriendProfileMoreInfoActivity.d(this.a);
    }
    FriendProfileMoreInfoActivity.a(this.a, "https://ti.qq.com/hybrid-h5/school_relation/chooseschool?_wv=67108994");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.7
 * JD-Core Version:    0.7.0.1
 */