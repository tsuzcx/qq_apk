package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stSchema;
import UserGrowth.stUserAuth;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSUserAuthDialog$2
  implements View.OnClickListener
{
  WSUserAuthDialog$2(WSUserAuthDialog paramWSUserAuthDialog, Context paramContext, String paramString) {}
  
  public void onClick(View paramView)
  {
    WSLog.a("WSUserAuthDialog", "jump to miniApp to set auth switch");
    paramView = WSGlobalConfig.a().a();
    if ((paramView != null) && (paramView.schema != null)) {
      paramView = paramView.schema.miniAppSchema;
    } else {
      paramView = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("miniAppSchema = ");
    localStringBuilder.append(paramView);
    WSLog.a("WSUserAuthDialog", localStringBuilder.toString());
    WeishiActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, paramView, new WSUserAuthDialog.2.1(this));
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.jdField_a_of_type_JavaLangString, "authorized_window", 1000007);
    WSUserAuthDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSUserAuthDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog.2
 * JD-Core Version:    0.7.0.1
 */