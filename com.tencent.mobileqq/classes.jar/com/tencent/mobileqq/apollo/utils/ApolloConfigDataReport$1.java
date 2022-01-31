package com.tencent.mobileqq.apollo.utils;

import aifg;
import aiyp;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ApolloConfigDataReport$1
  implements Runnable
{
  public ApolloConfigDataReport$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    ((aifg)this.a.getManager(153)).a("https://cmshow.gtimg.cn/xydata/cmshow/app/terminalCmConfig/xydata.json", ApolloUtil.b, new aiyp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.1
 * JD-Core Version:    0.7.0.1
 */