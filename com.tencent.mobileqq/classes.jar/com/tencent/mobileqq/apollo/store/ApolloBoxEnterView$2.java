package com.tencent.mobileqq.apollo.store;

import amme;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ApolloBoxEnterView$2
  implements Runnable
{
  ApolloBoxEnterView$2(ApolloBoxEnterView paramApolloBoxEnterView) {}
  
  public void run()
  {
    if (ApolloBoxEnterView.a(this.this$0) == null) {}
    do
    {
      do
      {
        return;
        localObject = (QQAppInterface)ApolloBoxEnterView.a(this.this$0).get();
      } while ((ApolloBoxEnterView.a(this.this$0) == null) || (localObject == null));
      Object localObject = (amme)((QQAppInterface)localObject).getManager(QQManagerFactory.APOLLO_MANAGER);
      ApolloBoxEnterView.a(this.this$0).hadStolen = 1;
      ((amme)localObject).a(ApolloBoxEnterView.a(this.this$0));
    } while (!QLog.isColorLevel());
    QLog.d("ApolloBoxEnterView", 2, "updateApolloPandora");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBoxEnterView.2
 * JD-Core Version:    0.7.0.1
 */