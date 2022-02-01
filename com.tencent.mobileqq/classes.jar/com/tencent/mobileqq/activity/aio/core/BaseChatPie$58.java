package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.apollo.aio.ApolloHelper;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionObserver;

class BaseChatPie$58
  implements IApolloExtensionObserver
{
  BaseChatPie$58(BaseChatPie paramBaseChatPie) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    ((ApolloHelper)this.a.a.a(8)).a(paramBoolean, paramObject);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 5) {
      a(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.58
 * JD-Core Version:    0.7.0.1
 */