package com.tencent.mobileqq.apollo.web.api.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;

class ApolloJsPluginImpl$3$1
  implements DialogInterface.OnClickListener
{
  ApolloJsPluginImpl$3$1(ApolloJsPluginImpl.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl.callbackError(this.a.jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131700676));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.3.1
 * JD-Core Version:    0.7.0.1
 */