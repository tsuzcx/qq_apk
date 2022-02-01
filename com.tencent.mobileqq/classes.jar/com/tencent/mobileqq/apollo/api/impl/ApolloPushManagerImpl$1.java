package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.apollo.api.IApolloPushManager.OnActionPushListener;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPush;
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
        localOnActionPushListener.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloPushManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */