package com.tencent.mobileqq.activity.pendant;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AvatarPendantActivity$12
  implements View.OnClickListener
{
  AvatarPendantActivity$12(AvatarPendantActivity paramAvatarPendantActivity, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    VasH5PayUtil.a(this.d, "mvip.gxh.android.faceaddon_nati_dft", this.a, "1450000515", this.b, this.c, "");
    boolean bool = TextUtils.isEmpty(this.c);
    String str2 = "0";
    String str1 = str2;
    if (!bool) {
      if ("QQ会员".equals(this.c)) {
        str1 = str2;
      } else {
        str1 = "1";
      }
    }
    ReportController.b(this.d.app, "CliOper", "", "", "0X8005FD2", "0X8005FD2", 0, 0, str1, "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.12
 * JD-Core Version:    0.7.0.1
 */