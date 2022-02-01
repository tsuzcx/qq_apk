package com.tencent.mobileqq.browser;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.qphone.base.util.BaseApplication;

class BrowserDialogViewModel$1
  implements DialogInterface.OnClickListener
{
  BrowserDialogViewModel$1(BrowserDialogViewModel paramBrowserDialogViewModel, BrowserItem paramBrowserItem) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BrowserUtilKt.a(BaseApplication.context, this.jdField_a_of_type_ComTencentMobileqqBrowserBrowserItem.d(), BrowserDialogViewModel.a(this.jdField_a_of_type_ComTencentMobileqqBrowserBrowserDialogViewModel));
    ReportHelperKt.a("0X800ADEF");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.browser.BrowserDialogViewModel.1
 * JD-Core Version:    0.7.0.1
 */