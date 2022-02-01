package com.tencent.gamecenter.wadl.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;

final class GameCenterUtil$1
  implements DialogInterface.OnClickListener
{
  GameCenterUtil$1(String paramString, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new WadlReportBuilder().a("dc00087").h("559").b(this.jdField_a_of_type_JavaLangString).c("202473").a(1).a();
    ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).requestPermission(this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.util.GameCenterUtil.1
 * JD-Core Version:    0.7.0.1
 */