package com.tencent.mobileqq.apollo.game;

import akug;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.smtt.sdk.ValueCallback;

public class ApolloJSContext$2
  implements Runnable
{
  public ApolloJSContext$2(akug paramakug, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (akug.a(this.this$0) != null) {
      akug.a(this.this$0).evaluateJavascript(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentSmttSdkValueCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloJSContext.2
 * JD-Core Version:    0.7.0.1
 */