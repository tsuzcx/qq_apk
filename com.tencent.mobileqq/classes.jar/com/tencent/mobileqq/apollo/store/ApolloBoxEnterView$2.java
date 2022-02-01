package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ApolloBoxEnterView$2
  implements Runnable
{
  ApolloBoxEnterView$2(ApolloBoxEnterView paramApolloBoxEnterView) {}
  
  public void run()
  {
    if (ApolloBoxEnterView.a(this.this$0) == null) {
      return;
    }
    Object localObject = (QQAppInterface)ApolloBoxEnterView.a(this.this$0).get();
    if (ApolloBoxEnterView.b(this.this$0) != null)
    {
      if (localObject == null) {
        return;
      }
      localObject = (ApolloDaoManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all");
      ApolloBoxEnterView.b(this.this$0).hadStolen = 1;
      ((ApolloDaoManagerServiceImpl)localObject).saveOrUpdateApolloPandora(ApolloBoxEnterView.b(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloBoxEnterView", 2, "updateApolloPandora");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBoxEnterView.2
 * JD-Core Version:    0.7.0.1
 */