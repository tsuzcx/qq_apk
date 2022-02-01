package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;

class UrlQRProcessor$ConcurrentReqManager$4
  implements DialogInterface.OnClickListener
{
  UrlQRProcessor$ConcurrentReqManager$4(UrlQRProcessor.ConcurrentReqManager paramConcurrentReqManager, String paramString, Activity paramActivity, OnQRHandleResultCallback paramOnQRHandleResultCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_JavaLangString.toLowerCase();
    if (paramDialogInterface.startsWith("www."))
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("http://");
      paramDialogInterface.append(this.jdField_a_of_type_JavaLangString);
      paramDialogInterface = paramDialogInterface.toString();
    }
    else if (paramDialogInterface.startsWith("https:"))
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("https");
      paramDialogInterface.append(this.jdField_a_of_type_JavaLangString.substring(5));
      paramDialogInterface = paramDialogInterface.toString();
    }
    else if (paramDialogInterface.startsWith("http:"))
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("http");
      paramDialogInterface.append(this.jdField_a_of_type_JavaLangString.substring(4));
      paramDialogInterface = paramDialogInterface.toString();
    }
    else
    {
      paramDialogInterface = this.jdField_a_of_type_JavaLangString;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserDelegationActivity.class);
    localIntent.putExtra("url", paramDialogInterface);
    localIntent.putExtra("param_force_internal_browser", true);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("fromQrcode", true);
    localIntent.putExtra("injectrecommend", false);
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_sacan_qr");
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqQrscanOnQRHandleResultCallback.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.UrlQRProcessor.ConcurrentReqManager.4
 * JD-Core Version:    0.7.0.1
 */