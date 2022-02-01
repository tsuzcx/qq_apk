package com.tencent.mobileqq.apollo.aio;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;

class ApolloHelper$1
  implements DialogInterface.OnClickListener
{
  ApolloHelper$1(ApolloHelper paramApolloHelper, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(ApolloHelper.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioApolloHelper), QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", this.jdField_a_of_type_JavaLangString);
    ApolloHelper.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioApolloHelper).startActivity(paramDialogInterface);
    VipUtils.a(ApolloHelper.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioApolloHelper), "cmshow", "Apollo", "activity_alert_view", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloHelper.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioApolloHelper).jdField_a_of_type_Int), 0, new String[] { "" + this.jdField_a_of_type_Int, "1" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ApolloHelper.1
 * JD-Core Version:    0.7.0.1
 */