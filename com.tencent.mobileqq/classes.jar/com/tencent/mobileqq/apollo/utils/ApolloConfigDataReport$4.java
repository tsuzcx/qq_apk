package com.tencent.mobileqq.apollo.utils;

import com.tencent.qphone.base.util.QLog;

final class ApolloConfigDataReport$4
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloConfigDataReport", 2, "interceptReport other app init opNameSet");
    }
    ApolloConfigDataReport.c(ApolloConfigDataReport.a(ApolloConfigDataReport.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.4
 * JD-Core Version:    0.7.0.1
 */