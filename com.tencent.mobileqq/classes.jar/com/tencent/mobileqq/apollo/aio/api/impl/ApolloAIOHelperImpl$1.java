package com.tencent.mobileqq.apollo.aio.api.impl;

import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;

class ApolloAIOHelperImpl$1
  implements IApolloExtensionObserver
{
  ApolloAIOHelperImpl$1(ApolloAIOHelperImpl paramApolloAIOHelperImpl) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    this.a.onAuthActionResponse(paramBoolean, paramObject);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 5) {
      a(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.api.impl.ApolloAIOHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */