package com.tencent.mobileqq.app.msgnotify.api.impl;

import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog;
import com.tencent.mobileqq.app.msgnotify.api.IMsgNotifyPushDialog;
import mqq.app.AppRuntime;

public class MsgNotifyPushDialogImpl
  implements IMsgNotifyPushDialog
{
  public void parsePushOpenNotifyXML(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    MsgNotifyPushDialog.a(paramAppRuntime, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.api.impl.MsgNotifyPushDialogImpl
 * JD-Core Version:    0.7.0.1
 */