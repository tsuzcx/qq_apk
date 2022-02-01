package com.tencent.mobileqq.apollo.api.web.impl;

import android.app.Activity;

class ApolloJsPluginImpl$2
  implements Runnable
{
  ApolloJsPluginImpl$2(ApolloJsPluginImpl paramApolloJsPluginImpl) {}
  
  public void run()
  {
    Activity localActivity = ApolloJsPluginImpl.access$000(this.this$0);
    if (localActivity != null) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.2
 * JD-Core Version:    0.7.0.1
 */