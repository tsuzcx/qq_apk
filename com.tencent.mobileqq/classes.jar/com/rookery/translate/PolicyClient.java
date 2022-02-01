package com.rookery.translate;

import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;

class PolicyClient
  extends TranslateClient
{
  public static void a(Context paramContext, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    a().a(paramContext, "https://passport.imqq.com/App/MobileQQ/ChangeTrans.html", null, null, new PolicyClient.1(paramAsyncHttpResponseHandler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.PolicyClient
 * JD-Core Version:    0.7.0.1
 */