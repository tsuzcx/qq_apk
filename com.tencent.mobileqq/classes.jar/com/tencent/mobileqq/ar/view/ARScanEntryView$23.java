package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import apgw;
import apiv;
import apse;
import bdll;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.qphone.base.util.BaseApplication;

class ARScanEntryView$23
  implements Runnable
{
  ARScanEntryView$23(ARScanEntryView paramARScanEntryView, apiv paramapiv, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Apiv.a.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Apiv.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (this.jdField_a_of_type_Apiv.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Apiv.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int == 0)) {
      if (this.jdField_a_of_type_Apiv.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.b)
      {
        bdll.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_Apiv.a.b, "1", "1", "");
        ARScanEntryView.a(this.this$0, true);
        if (ARScanEntryView.a(this.this$0) != null)
        {
          ARScanEntryView.a(this.this$0).a(1L);
          ARScanEntryView.a(this.this$0).l();
        }
        this.this$0.i();
      }
    }
    do
    {
      return;
      bdll.b(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.jdField_a_of_type_Apiv.a.b, "1", "0", "");
      if (this.jdField_a_of_type_Apiv.a.c()) {
        bdll.b(null, "CliOper", "", "", "0X80098D1", "0X80098D1", 0, 0, this.jdField_a_of_type_Apiv.a.b, "1", "0", "");
      }
      Object localObject = (Activity)this.this$0.jdField_a_of_type_AndroidContentContext;
      String str = this.jdField_a_of_type_Apiv.a.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString;
      ((Activity)localObject).setResult(11);
      apgw.a().b(2);
      if (this.this$0.a(str))
      {
        localObject = new Intent("android.intent.action.VIEW");
        ((Intent)localObject).setData(Uri.parse(str));
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
        ((Intent)localObject).setPackage(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getPackageName());
        this.this$0.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
      for (;;)
      {
        if ((ARScanEntryView.a(this.this$0) != null) && (!ARScanEntryView.a(this.this$0).a.d())) {
          this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), ARScanEntryView.a(this.this$0).a.b, "2");
        }
        ARScanEntryView.b(this.this$0, true);
        return;
        Intent localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_sacan");
        localIntent.putExtra("url", this.this$0.a(str));
        ((Activity)localObject).startActivity(localIntent);
      }
      ARScanEntryView.d(this.this$0);
    } while (!this.jdField_a_of_type_Boolean);
    ARScanEntryView.h(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.23
 * JD-Core Version:    0.7.0.1
 */