package com.tencent.biz.pubaccount.api.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class PublicAccountJavascriptInterfaceImpl$5
  implements DialogInterface.OnCancelListener
{
  PublicAccountJavascriptInterfaceImpl$5(PublicAccountJavascriptInterfaceImpl paramPublicAccountJavascriptInterfaceImpl, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-3", "{}" });
    this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.hasAsked = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.5
 * JD-Core Version:    0.7.0.1
 */