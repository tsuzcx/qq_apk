package com.tencent.mobileqq.apollo.utils;

import amme;
import anjw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public final class ApolloConfigDataReport$1
  implements Runnable
{
  public ApolloConfigDataReport$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    ((amme)this.a.getManager(QQManagerFactory.APOLLO_MANAGER)).a("https://cmshow.gtimg.cn/xydata/cmshow/app/terminalCmConfig/xydata.json", "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/apollo_report_config.json", new anjw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.1
 * JD-Core Version:    0.7.0.1
 */