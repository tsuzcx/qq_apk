package com.tencent.mobileqq.antiphing;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class AntiphingHandler$1
  implements DialogInterface.OnClickListener
{
  AntiphingHandler$1(AntiphingHandler paramAntiphingHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AntiphingHandler.a(this.a), 2, "On Click Left Button! ");
    }
    if (this.a.mRuntime.d() != null) {
      this.a.mRuntime.d().finish();
    } else if (QLog.isDevelopLevel()) {
      QLog.d(AntiphingHandler.a(this.a), 4, "Call back object is null!");
    }
    AntiphingHandler.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphingHandler.1
 * JD-Core Version:    0.7.0.1
 */