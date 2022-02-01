package com.tencent.mobileqq.apollo.aio.panel;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;

class CmshowPanelDialog$4
  implements DialogInterface.OnClickListener
{
  CmshowPanelDialog$4(CmshowPanelDialog paramCmshowPanelDialog, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.f.a();
    if (CmshowPanelDialog.a(this.f) == null) {
      return;
    }
    paramDialogInterface = new Intent(CmshowPanelDialog.a(this.f), QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", this.a);
    boolean bool = TextUtils.isEmpty(this.b);
    int j = 1;
    int k = 0;
    QQAppInterface localQQAppInterface;
    StringBuilder localStringBuilder;
    int i;
    if ((!bool) && (this.b.equals("true")))
    {
      localQQAppInterface = CmshowPanelDialog.b(this.f);
      paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.f.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.c);
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "activity_alert_view", paramInt, 0, new String[] { localStringBuilder.toString(), "0" });
      localQQAppInterface = CmshowPanelDialog.b(this.f);
      paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.f.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.c);
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "participate", paramInt, 0, new String[] { localStringBuilder.toString() });
      i = 14007;
      paramInt = j;
    }
    else
    {
      paramInt = j;
      i = k;
      if (!TextUtils.isEmpty(this.d)) {
        if (this.d.equals(String.valueOf(9)))
        {
          ApolloUtilImpl.jumpToH5PreviewAction(CmshowPanelDialog.a(this.f), this.c, this.e);
          localQQAppInterface = CmshowPanelDialog.b(this.f);
          paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.f.a);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(this.c);
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "vip_alert_view", paramInt, 0, new String[] { localStringBuilder.toString(), "0" });
          paramInt = 0;
          i = k;
        }
        else
        {
          paramInt = j;
          i = k;
          if (this.d.equals(String.valueOf(2)))
          {
            localQQAppInterface = CmshowPanelDialog.b(this.f);
            paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.f.a);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(this.c);
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "debt_alert_clickcharge", paramInt, 0, new String[] { localStringBuilder.toString() });
            i = k;
            paramInt = j;
          }
        }
      }
    }
    if (paramInt != 0) {
      CmshowPanelDialog.a(this.f).startActivityForResult(paramDialogInterface, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.CmshowPanelDialog.4
 * JD-Core Version:    0.7.0.1
 */