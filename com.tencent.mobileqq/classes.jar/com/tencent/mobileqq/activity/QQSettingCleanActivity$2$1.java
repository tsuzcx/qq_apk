package com.tencent.mobileqq.activity;

import adrx;
import azqs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;

public class QQSettingCleanActivity$2$1
  implements Runnable
{
  public QQSettingCleanActivity$2$1(adrx paramadrx) {}
  
  public void run()
  {
    azqs.b(this.a.a.app, "dc00898", "", "", "0X8007914", "0X8007914", 0, 0, this.a.a.app.getCurrentAccountUin(), "", "", "");
    HttpDownloadUtil.a("http://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean", this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity.2.1
 * JD-Core Version:    0.7.0.1
 */