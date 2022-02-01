package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stSchema;
import UserGrowth.stUserAuth;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSUserAuthDialog$2
  implements View.OnClickListener
{
  WSUserAuthDialog$2(WSUserAuthDialog paramWSUserAuthDialog, Context paramContext, String paramString) {}
  
  public void onClick(View paramView)
  {
    WSLog.a("WSUserAuthDialog", "jump to miniApp to set auth switch");
    String str2 = "";
    stUserAuth localstUserAuth = WSGlobalConfig.a().a();
    String str1 = str2;
    if (localstUserAuth != null)
    {
      str1 = str2;
      if (localstUserAuth.schema != null) {
        str1 = localstUserAuth.schema.miniAppSchema;
      }
    }
    WSLog.a("WSUserAuthDialog", "miniAppSchema = " + str1);
    WeishiActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, str1, new WSUserAuthDialog.2.1(this));
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.jdField_a_of_type_JavaLangString, "authorized_window", 1000007);
    WSUserAuthDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSUserAuthDialog);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog.2
 * JD-Core Version:    0.7.0.1
 */