package com.tencent.biz.pubaccount.weishi_new;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSUserAuthDialog$4
  implements View.OnClickListener
{
  WSUserAuthDialog$4(WSUserAuthDialog paramWSUserAuthDialog, String paramString) {}
  
  public void onClick(View paramView)
  {
    WSLog.a("WSUserAuthDialog", "dialog click ok");
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.jdField_a_of_type_JavaLangString, "authorized_window", 1000001);
    WSUserAuthDialog.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSUserAuthDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog.4
 * JD-Core Version:    0.7.0.1
 */