package com.tencent.mobileqq.apollo.statistics.product;

import com.tencent.qphone.base.util.QLog;

final class ApolloConfigDataReport$4
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloConfigDataReport", 2, "interceptReport other app init opNameSet");
    }
    ApolloConfigDataReport.c(ApolloConfigDataReport.a(ApolloConfigDataReport.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.ApolloConfigDataReport.4
 * JD-Core Version:    0.7.0.1
 */