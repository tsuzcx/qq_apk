package com.tencent.mobileqq.apollo.game;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class ApolloJSContext$3
  implements ValueCallback<String>
{
  ApolloJSContext$3(ApolloJSContext paramApolloJSContext) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceiveValue] s ");
      localStringBuilder.append(paramString);
      QLog.d("[cmshow]ApolloJSContext", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloJSContext.3
 * JD-Core Version:    0.7.0.1
 */