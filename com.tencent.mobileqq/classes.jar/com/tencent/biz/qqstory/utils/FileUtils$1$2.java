package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;

class FileUtils$1$2
  implements DialogInterface.OnClickListener
{
  FileUtils$1$2(FileUtils.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent(this.a.a, QQSettingMsgHistoryActivity.class);
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.FileUtils.1.2
 * JD-Core Version:    0.7.0.1
 */