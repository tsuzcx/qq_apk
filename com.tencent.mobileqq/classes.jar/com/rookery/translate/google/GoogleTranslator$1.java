package com.rookery.translate.google;

import com.rookery.asyncHttpClient.JsonHttpResponseHandler;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.rookery.translate.type.TranslateWithTimeCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class GoogleTranslator$1
  extends JsonHttpResponseHandler
{
  GoogleTranslator$1(GoogleTranslator paramGoogleTranslator, TranslateWithTimeCallback paramTranslateWithTimeCallback, Long paramLong) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONArray paramJSONArray)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfHeader = new StringBuilder();
      paramArrayOfHeader.append("[ERROR][SHOULD NOT GO HERE][onSuccess] statusCode:");
      paramArrayOfHeader.append(paramInt);
      QLog.e("GoogleTranslator", 2, paramArrayOfHeader.toString());
    }
  }
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    paramArrayOfHeader = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("data");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.getJSONArray("translations");
        if (paramJSONObject != null)
        {
          paramInt = 0;
          while (paramInt < paramJSONObject.length())
          {
            String str = ((JSONObject)paramJSONObject.get(paramInt)).getString("translatedText");
            paramArrayOfHeader.add(Language.fromString(((JSONObject)paramJSONObject.get(paramInt)).getString("detectedSourceLanguage")));
            localArrayList.add(str);
            paramInt += 1;
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      this.a.a(paramArrayOfHeader, localArrayList, this.b);
    }
  }
  
  public void a(Throwable paramThrowable, String paramString)
  {
    this.a.a(new TranslateError(paramThrowable), this.b);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append(" [onFailure][GoogleTranslateClient] Throwable:");
      paramString.append(paramThrowable);
      QLog.e("GoogleTranslator", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.google.GoogleTranslator.1
 * JD-Core Version:    0.7.0.1
 */