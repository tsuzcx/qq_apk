package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.apollo.api.IApolloPushManager.OnActionPushListener;
import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import mqq.util.WeakReference;

class ApolloPushManagerImpl$1
  implements Runnable
{
  ApolloPushManagerImpl$1(ApolloPushManagerImpl paramApolloPushManagerImpl, int paramInt, ApolloActionPush paramApolloActionPush) {}
  
  public void run()
  {
    if (ApolloPushManagerImpl.access$000(this.this$0) != null)
    {
      IApolloPushManager.OnActionPushListener localOnActionPushListener = (IApolloPushManager.OnActionPushListener)ApolloPushManagerImpl.access$000(this.this$0).get();
      if (localOnActionPushListener != null) {
        localOnActionPushListener.a(this.a, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloPushManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */