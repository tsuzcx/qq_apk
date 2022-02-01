package com.rookery.translate;

import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.asyncHttpClient.JsonHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

final class PolicyClient$1
  extends JsonHttpResponseHandler
{
  PolicyClient$1(AsyncHttpResponseHandler paramAsyncHttpResponseHandler) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    super.a(paramInt, paramArrayOfHeader, paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getString("id");
      this.a.a(paramInt, paramArrayOfHeader, paramJSONObject);
      return;
    }
    catch (JSONException paramArrayOfHeader)
    {
      paramArrayOfHeader.printStackTrace();
    }
  }
  
  public void a(Throwable paramThrowable, JSONObject paramJSONObject)
  {
    super.a(paramThrowable, paramJSONObject);
    if ((paramThrowable != null) && (paramThrowable.getMessage() != null)) {
      this.a.a(paramThrowable, paramThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.PolicyClient.1
 * JD-Core Version:    0.7.0.1
 */