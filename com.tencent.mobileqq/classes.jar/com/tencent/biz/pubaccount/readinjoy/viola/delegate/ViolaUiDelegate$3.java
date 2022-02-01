package com.tencent.biz.pubaccount.readinjoy.viola.delegate;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ViolaUiDelegate$3
  implements DialogInterface.OnClickListener
{
  ViolaUiDelegate$3(Context paramContext, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, this.jdField_a_of_type_JavaLangString));
      com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.ssoTimeOutRecordStr = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate.3
 * JD-Core Version:    0.7.0.1
 */