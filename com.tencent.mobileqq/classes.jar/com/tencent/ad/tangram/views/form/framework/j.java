package com.tencent.ad.tangram.views.form.framework;

import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.views.form.AdFormData;
import com.tencent.ad.tangram.views.form.AdFormError;
import com.tencent.ad.tangram.views.form.textbox.a;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class j
{
  private static final String TAG = "GdtFormUploadUtil";
  
  private static byte[] getRequestData(AdFormData paramAdFormData)
  {
    JSONArray localJSONArray = toJson(paramAdFormData);
    if ((paramAdFormData != null) && (paramAdFormData.isValid()) && (localJSONArray != null) && (!JSONObject.NULL.equals(localJSONArray)))
    {
      String str;
      if (TextUtils.isEmpty(paramAdFormData.tokenForUpload)) {
        str = "";
      } else {
        str = paramAdFormData.tokenForUpload;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("token", str);
        localJSONObject.put("formId", paramAdFormData.formId);
        localJSONObject.put("formValue", localJSONArray.toString());
        paramAdFormData = localJSONObject.toString().getBytes("UTF-8");
        return paramAdFormData;
      }
      catch (UnsupportedEncodingException paramAdFormData)
      {
        AdLog.e("GdtFormUploadUtil", "getRequestData", paramAdFormData);
        return null;
      }
      catch (JSONException paramAdFormData)
      {
        AdLog.e("GdtFormUploadUtil", "getRequestData", paramAdFormData);
        return null;
      }
    }
    AdLog.e("GdtFormUploadUtil", "getRequestData error");
    return null;
  }
  
  private static j.a getRequestParams(byte[] paramArrayOfByte)
  {
    j.a locala = new j.a(null);
    locala.setUrl("https://h5.gdt.qq.com/player/api/form/saveForNative");
    locala.method = "POST";
    locala.contentType = "application/json";
    locala.connectTimeoutMillis = 5000;
    locala.readTimeoutMillis = 5000;
    locala.requestData = paramArrayOfByte;
    return locala;
  }
  
  private static AdFormError parseResponse(AdFormData paramAdFormData, j.a parama)
  {
    if ((paramAdFormData != null) && (paramAdFormData.isValid()) && (parama != null) && (parama.isSuccess())) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(new String(parama.responseData, "UTF-8"));
        parama.returnCode = ((JSONObject)localObject1).getInt("code");
        Object localObject2 = ((JSONObject)localObject1).optString("message");
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("parseResponse code:");
        ((StringBuilder)localObject3).append(parama.returnCode);
        ((StringBuilder)localObject3).append(" message:");
        ((StringBuilder)localObject3).append((String)localObject2);
        AdLog.i("GdtFormUploadUtil", ((StringBuilder)localObject3).toString());
        if (parama.returnCode == 0) {
          return new AdFormError(1, -1, null);
        }
        if (parama.returnCode == 1)
        {
          parama = new AdFormError(4, -1, null);
          localObject1 = ((JSONObject)localObject1).getJSONObject("data");
          if ((localObject1 != null) && (!JSONObject.NULL.equals(localObject1)))
          {
            localObject1 = ((JSONObject)localObject1).getJSONArray("items");
            if (((JSONArray)localObject1).length() == paramAdFormData.table.getSize()) {
              break label535;
            }
            AdLog.e("GdtFormUploadUtil", "parseResponse error");
            break;
            if (i >= ((JSONArray)localObject1).length()) {
              break;
            }
            localObject2 = paramAdFormData.table.getItem(i);
            if ((localObject2 != null) && (((d)localObject2).isValid()))
            {
              localObject3 = ((JSONArray)localObject1).getJSONObject(i);
              if ((localObject3 != null) && (!JSONObject.NULL.equals(localObject3)))
              {
                int j = ((JSONObject)localObject3).getInt("errorCode");
                if (j == 0)
                {
                  i += 1;
                  continue;
                }
                if (j == 1) {
                  return new AdFormError(5, i, ((d)localObject2).title.text);
                }
                if (j == 2) {
                  return new AdFormError(6, i, ((d)localObject2).title.text);
                }
                AdLog.e("GdtFormUploadUtil", "parseResponse error");
                return new AdFormError(4, i, ((d)localObject2).title.text);
              }
              AdLog.e("GdtFormUploadUtil", "parseResponse error");
              return new AdFormError(4, i, ((d)localObject2).title.text);
            }
            AdLog.e("GdtFormUploadUtil", "parseResponse error");
            return new AdFormError(4, -1, null);
          }
          AdLog.e("GdtFormUploadUtil", "parseResponse error");
          break;
        }
        if (parama.returnCode == 3) {
          return new AdFormError(4, -1, null);
        }
        if (parama.returnCode == 4) {
          return new AdFormError(7, -1, null);
        }
        paramAdFormData = new AdFormError(4, -1, null);
        return paramAdFormData;
      }
      catch (JSONException paramAdFormData)
      {
        AdLog.e("GdtFormUploadUtil", "parseResponse", paramAdFormData);
        return new AdFormError(4, -1, null);
      }
      catch (UnsupportedEncodingException paramAdFormData)
      {
        AdLog.e("GdtFormUploadUtil", "parseResponse", paramAdFormData);
        return new AdFormError(4, -1, null);
      }
      AdLog.e("GdtFormUploadUtil", "commit error");
      return new AdFormError(4, -1, null);
      label535:
      int i = 0;
    }
    return parama;
  }
  
  public static JSONArray toJson(AdFormData paramAdFormData)
  {
    if ((paramAdFormData != null) && (paramAdFormData.isValid()))
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramAdFormData.table.getSize())
      {
        Object localObject = paramAdFormData.table.getItem(i);
        if ((localObject != null) && (((d)localObject).isValid()))
        {
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("name", ((d)localObject).title.text);
            localJSONObject.put("require", ((d)localObject).required);
            if ((localObject instanceof a))
            {
              localObject = (a)a.class.cast(localObject);
              localJSONObject.put("regexType", ((a)localObject).regexType);
              localJSONObject.put("value", ((a)localObject).getResult());
            }
            localJSONArray.put(i, localJSONObject);
          }
          catch (JSONException localJSONException)
          {
            AdLog.e("GdtFormUploadUtil", "toJson", localJSONException);
          }
        }
        else
        {
          AdLog.e("GdtFormUploadUtil", "toJson error");
        }
        i += 1;
      }
      return localJSONArray;
    }
    AdLog.e("GdtFormUploadUtil", "toJson error");
    return null;
  }
  
  public static AdFormError upload(AdFormData paramAdFormData)
  {
    byte[] arrayOfByte = getRequestData(paramAdFormData);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      AdFormError localAdFormError = new AdFormError(4, -1, null);
      int i = 0;
      while (i < 3)
      {
        j.a locala = getRequestParams(arrayOfByte);
        if (locala != null)
        {
          AdHttp.send(locala);
          if (locala.isSuccess()) {
            localAdFormError = parseResponse(paramAdFormData, locala);
          }
          if ((locala.returnCode != 0) && (locala.returnCode != 1) && (locala.returnCode != 2))
          {
            if (locala.returnCode == 4) {
              return localAdFormError;
            }
            i += 1;
          }
          else
          {
            return localAdFormError;
          }
        }
      }
      AdLog.e("GdtFormUploadUtil", "upload error");
      return localAdFormError;
    }
    AdLog.e("GdtFormUploadUtil", "upload error");
    return new AdFormError(4, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.framework.j
 * JD-Core Version:    0.7.0.1
 */