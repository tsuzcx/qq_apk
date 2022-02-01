package com.rookery.translate.google;

import android.content.Context;
import android.util.Pair;
import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.translate.TranslateClient;
import java.util.List;
import org.apache.http.Header;

abstract class GoogleTranslateClient
  extends TranslateClient
{
  public static void a(Context paramContext, Header[] paramArrayOfHeader, List<Pair<String, String>> paramList, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    a().a(paramContext, "https://www.googleapis.com/language/translate/v2", paramArrayOfHeader, paramList, paramAsyncHttpResponseHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.google.GoogleTranslateClient
 * JD-Core Version:    0.7.0.1
 */