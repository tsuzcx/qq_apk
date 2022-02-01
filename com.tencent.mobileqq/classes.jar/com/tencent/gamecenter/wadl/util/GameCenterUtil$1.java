package com.tencent.gamecenter.wadl.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;

final class GameCenterUtil$1
  implements DialogInterface.OnClickListener
{
  GameCenterUtil$1(String paramString, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new WadlReportBuilder().a("dc00087").h("559").b(this.a).c("202473").a(1).a(31, "1").a();
    ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).requestPermission(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.util.GameCenterUtil.1
 * JD-Core Version:    0.7.0.1
 */