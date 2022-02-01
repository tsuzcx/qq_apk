package com.tencent.mobileqq.apollo.game;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.smtt.sdk.ValueCallback;

class ApolloJSContext$2
  implements Runnable
{
  ApolloJSContext$2(ApolloJSContext paramApolloJSContext, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (ApolloJSContext.a(this.this$0) != null) {
      ApolloJSContext.a(this.this$0).evaluateJavascript(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentSmttSdkValueCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloJSContext.2
 * JD-Core Version:    0.7.0.1
 */