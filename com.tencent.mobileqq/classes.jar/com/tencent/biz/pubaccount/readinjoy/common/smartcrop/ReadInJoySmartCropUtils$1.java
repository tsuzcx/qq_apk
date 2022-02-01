package com.tencent.biz.pubaccount.readinjoy.common.smartcrop;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ReadInJoySmartCropUtils$1
  implements DialogInterface.OnClickListener
{
  @TargetApi(11)
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("article", this.jdField_a_of_type_JavaLangString));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.smartcrop.ReadInJoySmartCropUtils.1
 * JD-Core Version:    0.7.0.1
 */