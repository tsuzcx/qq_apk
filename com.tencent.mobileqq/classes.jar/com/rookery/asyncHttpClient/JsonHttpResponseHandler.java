package com.rookery.asyncHttpClient;

import android.os.Message;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonHttpResponseHandler
  extends AsyncHttpResponseHandler
{
  protected Object a(String paramString)
  {
    String str = paramString.trim();
    if ((!str.startsWith("{")) && (!str.startsWith("["))) {
      paramString = null;
    } else {
      paramString = new JSONTokener(str).nextValue();
    }
    if (paramString == null) {
      return str;
    }
    return paramString;
  }
  
  protected void a(int paramInt, Header[] paramArrayOfHeader, Object paramObject)
  {
    if ((paramObject instanceof JSONObject))
    {
      a(paramInt, paramArrayOfHeader, (JSONObject)paramObject);
      return;
    }
    if ((paramObject instanceof JSONArray))
    {
      a(paramInt, paramArrayOfHeader, (JSONArray)paramObject);
      return;
    }
    paramArrayOfHeader = new StringBuilder();
    paramArrayOfHeader.append("Unexpected type ");
    paramArrayOfHeader.append(paramObject.getClass().getName());
    a(new JSONException(paramArrayOfHeader.toString()), (JSONObject)null);
  }
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONArray paramJSONArray) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject) {}
  
  protected void a(Message paramMessage)
  {
    if (paramMessage.what != 100)
    {
      super.a(paramMessage);
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    a(((Integer)paramMessage[0]).intValue(), (Header[])paramMessage[1], paramMessage[2]);
  }
  
  public void a(Throwable paramThrowable, JSONArray paramJSONArray) {}
  
  public void a(Throwable paramThrowable, JSONObject paramJSONObject) {}
  
  protected void b(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    if (paramInt != 204) {
      try
      {
        b(a(100, new Object[] { Integer.valueOf(paramInt), paramArrayOfHeader, a(paramString) }));
        return;
      }
      catch (JSONException paramArrayOfHeader)
      {
        b(paramArrayOfHeader, paramString);
        return;
      }
    }
    b(a(100, new Object[] { Integer.valueOf(paramInt), new JSONObject() }));
  }
  
  protected void c(Throwable paramThrowable, String paramString)
  {
    if (paramString != null) {}
    try
    {
      Object localObject = a(paramString);
      if ((localObject instanceof JSONObject))
      {
        a(paramThrowable, (JSONObject)localObject);
        return;
      }
      if ((localObject instanceof JSONArray))
      {
        a(paramThrowable, (JSONArray)localObject);
        return;
      }
      a(paramThrowable, paramString);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label59;
    }
    a(paramThrowable, "");
    return;
    label59:
    a(paramThrowable, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.asyncHttpClient.JsonHttpResponseHandler
 * JD-Core Version:    0.7.0.1
 */