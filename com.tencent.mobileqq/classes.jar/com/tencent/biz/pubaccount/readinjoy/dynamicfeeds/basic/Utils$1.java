package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic;

import com.tencent.biz.pubaccount.readinjoy.kandianreport.ProteusJsHelper;
import com.tencent.qphone.base.util.QLog;

public final class Utils$1
  implements Runnable
{
  public void run()
  {
    QLog.d("DynamicChannelUtils", 1, "begin to prepare it.");
    ProteusJsHelper.prepare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.Utils.1
 * JD-Core Version:    0.7.0.1
 */