package com.tencent.mobileqq.apollo.handler;

import com.tencent.mobileqq.app.BusinessObserver;

class ApolloExtensionHandler$UpdateRunnable
  implements Runnable
{
  BusinessObserver a;
  boolean b;
  Object c;
  
  public ApolloExtensionHandler$UpdateRunnable(BusinessObserver paramBusinessObserver, boolean paramBoolean, Object paramObject)
  {
    this.a = paramBusinessObserver;
    this.b = paramBoolean;
    this.c = paramObject;
  }
  
  public void run()
  {
    BusinessObserver localBusinessObserver = this.a;
    if (localBusinessObserver != null) {
      localBusinessObserver.onUpdate(0, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler.UpdateRunnable
 * JD-Core Version:    0.7.0.1
 */