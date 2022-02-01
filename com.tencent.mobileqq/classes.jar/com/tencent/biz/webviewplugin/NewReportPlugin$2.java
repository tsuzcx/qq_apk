package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.nearby.FaceScoreCallBack;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

final class NewReportPlugin$2
  extends FaceScoreCallBack
{
  NewReportPlugin$2(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, int paramInt, String paramString3, QQProgressDialog paramQQProgressDialog, Bundle paramBundle, long paramLong) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (paramLong2 > 0L) {
      NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, String.valueOf(paramLong2), this.jdField_a_of_type_JavaLangString, this.b, NewReportPlugin.b(this.jdField_a_of_type_Int), NewReportPlugin.a(this.jdField_a_of_type_Int, this.c), this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog, this.jdField_a_of_type_AndroidOsBundle);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new NewReportPlugin.2.1(this));
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewReportPlugin", 2, String.format("handleGetTinyId [%s, %s, %s] ", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.2
 * JD-Core Version:    0.7.0.1
 */