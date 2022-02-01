package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class AddFriendVerifyActivity$32
  implements DialogInterface.OnClickListener
{
  AddFriendVerifyActivity$32(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B993", "0X800B993", 0, 0, "", "", "", "");
    if (QLog.isColorLevel())
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("jumpUrl: mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pages%2Fqq_risk%2Fgood_person%2Fadd_friend%3Ftype%3Dadd_firend&_vt=3&referer=2017&via=tencent_csd&_sig=3708401383");
      paramDialogInterface.append(String.format("&uin=%s", new Object[] { AddFriendVerifyActivity.d(this.a) }));
      QLog.i("AddFriendVerifyActivity", 2, paramDialogInterface.toString());
    }
    paramDialogInterface = (IMiniAppService)QRoute.api(IMiniAppService.class);
    AddFriendVerifyActivity localAddFriendVerifyActivity = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pages%2Fqq_risk%2Fgood_person%2Fadd_friend%3Ftype%3Dadd_firend&_vt=3&referer=2017&via=tencent_csd&_sig=3708401383");
    localStringBuilder.append(String.format("&uin=%s", new Object[] { AddFriendVerifyActivity.d(this.a) }));
    paramDialogInterface.startMiniApp(localAddFriendVerifyActivity, localStringBuilder.toString(), 2017, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.32
 * JD-Core Version:    0.7.0.1
 */