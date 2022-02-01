package com.tencent.mobileqq.apollo.aio.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;

class ApolloAIOHelperImpl$2
  implements DialogInterface.OnClickListener
{
  ApolloAIOHelperImpl$2(ApolloAIOHelperImpl paramApolloAIOHelperImpl, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(ApolloAIOHelperImpl.access$000(this.c), QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", this.a);
    ApolloAIOHelperImpl.access$000(this.c).startActivity(paramDialogInterface);
    paramDialogInterface = ApolloAIOHelperImpl.access$100(this.c);
    paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(ApolloAIOHelperImpl.access$200(this.c).a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.b);
    VipUtils.a(paramDialogInterface, "cmshow", "Apollo", "activity_alert_view", paramInt, 0, new String[] { localStringBuilder.toString(), "1" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.api.impl.ApolloAIOHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */