package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class RIJAppSetting$1
  implements Runnable
{
  RIJAppSetting$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.a == null) || (!this.a.isLogin())) {}
    do
    {
      do
      {
        return;
      } while (!RIJAppSetting.a);
      RIJAppSetting.b(this.a);
    } while (!QLog.isColorLevel());
    QLog.d("RIJAppSetting", 2, "handNet2Wifi is show conversation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting.1
 * JD-Core Version:    0.7.0.1
 */