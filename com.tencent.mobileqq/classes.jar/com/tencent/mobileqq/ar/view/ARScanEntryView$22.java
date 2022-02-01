package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.ar.model.QQARSession;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;
import com.tencent.qphone.base.util.BaseApplication;

class ARScanEntryView$22
  implements Runnable
{
  ARScanEntryView$22(ARScanEntryView paramARScanEntryView, ARTarget paramARTarget, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.b)
      {
        ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.b, "1", "1", "");
        ARScanEntryView.b(this.this$0, true);
        if (ARScanEntryView.a(this.this$0) != null)
        {
          ARScanEntryView.a(this.this$0).a(1L);
          ARScanEntryView.a(this.this$0).n();
        }
        this.this$0.i();
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.b, "1", "0", "");
      if (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.c()) {
        ReportController.b(null, "CliOper", "", "", "0X80098D1", "0X80098D1", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.b, "1", "0", "");
      }
      Object localObject = (Activity)this.this$0.jdField_a_of_type_AndroidContentContext;
      String str = this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
      ((Activity)localObject).setResult(11);
      ARVideoRecordUIControllerImpl.a().b(2);
      if (this.this$0.a(str))
      {
        localObject = new Intent("android.intent.action.VIEW");
        ((Intent)localObject).setData(Uri.parse(str));
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
        ((Intent)localObject).setPackage(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getPackageName());
        this.this$0.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
      else
      {
        Intent localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_sacan");
        localIntent.putExtra("url", this.this$0.a(str));
        ((Activity)localObject).startActivity(localIntent);
      }
      if ((ARScanEntryView.a(this.this$0) != null) && (!ARScanEntryView.a(this.this$0).a.d())) {
        AppIntefaceReportWrap.a(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), ARScanEntryView.a(this.this$0).a.b, "2");
      }
      ARScanEntryView.c(this.this$0, true);
      return;
    }
    ARScanEntryView.d(this.this$0);
    if (this.jdField_a_of_type_Boolean) {
      ARScanEntryView.h(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.22
 * JD-Core Version:    0.7.0.1
 */