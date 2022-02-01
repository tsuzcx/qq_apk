package com.tencent.mobileqq.apollo.statistics.product;

import mqq.app.AppRuntime;

final class ApolloConfigDataReport$1
  implements Runnable
{
  ApolloConfigDataReport$1(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = this.a;
    if (localAppRuntime == null) {
      return;
    }
    ApolloConfigDataReport.a(localAppRuntime, "https://cmshow.gtimg.cn/xydata/cmshow/app/terminalCmConfig/xydata.json", "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/apollo_report_config.json", new ApolloConfigDataReport.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.ApolloConfigDataReport.1
 * JD-Core Version:    0.7.0.1
 */