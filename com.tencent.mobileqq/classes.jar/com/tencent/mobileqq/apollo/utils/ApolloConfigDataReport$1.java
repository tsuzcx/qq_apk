package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;

final class ApolloConfigDataReport$1
  implements Runnable
{
  ApolloConfigDataReport$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    ((ApolloManagerServiceImpl)this.a.getRuntimeService(IApolloManagerService.class, "all")).downloadFileBy304("https://cmshow.gtimg.cn/xydata/cmshow/app/terminalCmConfig/xydata.json", "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/apollo_report_config.json", new ApolloConfigDataReport.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.1
 * JD-Core Version:    0.7.0.1
 */