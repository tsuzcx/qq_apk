package com.tencent.mobileqq.apollo.utils;

import ankc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public final class ApolloConfigUtils$2
  implements Runnable
{
  public ApolloConfigUtils$2(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ankc localankc = (ankc)this.a.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
    if (localankc.a) {
      localankc.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConfigUtils.2
 * JD-Core Version:    0.7.0.1
 */