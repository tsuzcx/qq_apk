package com.tencent.mobileqq.activity;

import android.app.Activity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopshare.TroopShareUtility;

final class DiscussionInfoCardActivity$17
  implements Runnable
{
  DiscussionInfoCardActivity$17(String paramString1, Activity paramActivity, String paramString2, String paramString3, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("temp_discuss_link_share_");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    Activity localActivity = this.b;
    localObject = QRUtils.a(localActivity, (String)localObject, TroopShareUtility.a(this.c, localActivity.getResources()));
    this.b.runOnUiThread(new DiscussionInfoCardActivity.17.1(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.17
 * JD-Core Version:    0.7.0.1
 */