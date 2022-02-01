package com.tencent.biz.pubaccount.weishi_new;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSUserAuthDialog$3
  implements DialogInterface.OnCancelListener
{
  WSUserAuthDialog$3(WSUserAuthDialog paramWSUserAuthDialog, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    WSLog.a("WSUserAuthDialog", "dialog cancel");
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.jdField_a_of_type_JavaLangString, "authorized_window", 1000001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog.3
 * JD-Core Version:    0.7.0.1
 */