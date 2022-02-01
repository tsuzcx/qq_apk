package com.tencent.mobileqq.apollo.aio.panel;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;

class CmshowPanelDialog$2
  implements DialogInterface.OnClickListener
{
  CmshowPanelDialog$2(CmshowPanelDialog paramCmshowPanelDialog, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.a();
    if (CmshowPanelDialog.a(this.b) != null)
    {
      if (CmshowPanelDialog.b(this.b) == null) {
        return;
      }
      paramDialogInterface = new Intent(CmshowPanelDialog.a(this.b), QQBrowserActivity.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ApolloConstant.s);
      localStringBuilder.append("&actionId=");
      localStringBuilder.append(this.a);
      localStringBuilder.append("&_bid=2282");
      paramDialogInterface.putExtra("url", localStringBuilder.toString());
      CmshowPanelDialog.a(this.b).startActivityForResult(paramDialogInterface, 0);
      boolean bool = ((ApolloManagerServiceImpl)CmshowPanelDialog.b(this.b).getRuntimeService(IApolloManagerService.class, "all")).getAVIPStatus(CmshowPanelDialog.b(this.b).getCurrentUin());
      paramDialogInterface = CmshowPanelDialog.b(this.b);
      paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.b.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.a);
      VipUtils.a(paramDialogInterface, "cmshow", "Apollo", "level_alert_view", paramInt, bool ^ true, new String[] { localStringBuilder.toString(), "0" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.CmshowPanelDialog.2
 * JD-Core Version:    0.7.0.1
 */