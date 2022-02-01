package com.tencent.mobileqq.apollo.aio.panel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class CmshowPanelDialog$3
  implements DialogInterface.OnClickListener
{
  CmshowPanelDialog$3(CmshowPanelDialog paramCmshowPanelDialog, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.d.a();
    if (CmshowPanelDialog.b(this.d) == null) {
      return;
    }
    paramDialogInterface = (ApolloExtensionHandler)CmshowPanelDialog.b(this.d).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (!this.a.equals(String.valueOf(2)))
    {
      QLog.d("[cmshow]CmshowPanelDialog", 2, "free action item click");
      return;
    }
    try
    {
      Object localObject = CmshowPanelDialog.b(this.d);
      paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.d.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.b);
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "icon_alert_clickbuy", paramInt, 0, new String[] { localStringBuilder.toString() });
      localObject = new JSONObject(this.c).getString("packageId");
      paramDialogInterface.a(CmshowPanelDialog.b(this.d).getCurrentAccountUin(), Integer.parseInt(this.b), Integer.parseInt((String)localObject));
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      QLog.e("[cmshow]CmshowPanelDialog", 1, "[showAioDialog] Exception:", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.CmshowPanelDialog.3
 * JD-Core Version:    0.7.0.1
 */