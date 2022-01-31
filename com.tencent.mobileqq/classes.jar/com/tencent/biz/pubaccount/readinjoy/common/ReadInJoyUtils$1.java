package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import onk;

public final class ReadInJoyUtils$1
  implements Runnable
{
  public ReadInJoyUtils$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.a == null) || (!this.a.isLogin())) {}
    do
    {
      do
      {
        return;
      } while (!onk.y());
      onk.e(this.a);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyUtils", 2, "handNet2Wifi is show conversation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.1
 * JD-Core Version:    0.7.0.1
 */