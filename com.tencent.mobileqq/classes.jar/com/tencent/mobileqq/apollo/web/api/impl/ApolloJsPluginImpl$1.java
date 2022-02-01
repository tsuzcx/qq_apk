package com.tencent.mobileqq.apollo.web.api.impl;

import android.app.Activity;

class ApolloJsPluginImpl$1
  implements Runnable
{
  ApolloJsPluginImpl$1(ApolloJsPluginImpl paramApolloJsPluginImpl) {}
  
  public void run()
  {
    Activity localActivity = ApolloJsPluginImpl.access$100(this.this$0);
    if (localActivity != null) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.1
 * JD-Core Version:    0.7.0.1
 */