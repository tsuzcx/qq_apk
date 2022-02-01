package com.tencent.biz.qrcode.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.IQQAppInterfaceProcessor;
import com.tencent.mobileqq.utils.ContactUtils;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class ScanQQAppInterfaceProcessor
  implements IQQAppInterfaceProcessor
{
  public String a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ContactUtils.e((QQAppInterface)paramAppRuntime, paramAppRuntime.getCurrentAccountUin());
    }
    return paramString;
  }
  
  public void a(String paramString)
  {
    QQAppInterface.speak(paramString);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppRuntime).setTalkbackSwitch();
    }
  }
  
  public boolean b(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).isVideoChatting();
    }
    return false;
  }
  
  public boolean c(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).isRingerVibrate();
    }
    return false;
  }
  
  public boolean d(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).isRingerSilent();
    }
    return false;
  }
  
  public boolean e(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).isRingEqualsZero();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.ScanQQAppInterfaceProcessor
 * JD-Core Version:    0.7.0.1
 */