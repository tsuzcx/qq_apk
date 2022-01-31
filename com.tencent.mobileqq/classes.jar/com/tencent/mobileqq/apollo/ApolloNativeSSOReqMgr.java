package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class ApolloNativeSSOReqMgr
  implements Manager
{
  public static String a = "ApolloNativeSSOReqMgr";
  
  public ApolloNativeSSOReqMgr(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "[ApolloNativeSSOReqMgr]");
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloNativeSSOReqMgr
 * JD-Core Version:    0.7.0.1
 */