package com.tencent.ad.tangram.canvas.views.form.framework;

import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.form.textbox.a;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class e
{
  private static final String TAG = "GdtFormUploadUtil";
  
  private static byte[] getRequestData(AdFormData paramAdFormData)
  {
    JSONArray localJSONArray = toJson(paramAdFormData);
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()) || (localJSONArray == null) || (JSONObject.NULL.equals(localJSONArray)))
    {
      AdLog.e("GdtFormUploadUtil", "getRequestData error");
      return null;
    }
    if (TextUtils.isEmpty(paramAdFormData.tokenForUpload)) {}
    for (String str = "";; str = paramAdFormData.tokenForUpload) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("token", str);
        localJSONObject.put("formId", paramAdFormData.formId);
        localJSONObject.put("formValue", localJSONArray.toString());
        paramAdFormData = localJSONObject.toString().getBytes("UTF-8");
        return paramAdFormData;
      }
      catch (JSONException paramAdFormData)
      {
        AdLog.e("GdtFormUploadUtil", "getRequestData", paramAdFormData);
        return null;
      }
      catch (UnsupportedEncodingException paramAdFormData)
      {
        AdLog.e("GdtFormUploadUtil", "getRequestData", paramAdFormData);
      }
    }
    return null;
  }
  
  private static e.a getRequestParams(byte[] paramArrayOfByte)
  {
    e.a locala = new e.a(null);
    locala.setUrl("https://h5.gdt.qq.com/player/api/form/saveForNative");
    locala.method = "POST";
    locala.contentType = "application/json";
    locala.connectTimeoutMillis = 5000;
    locala.readTimeoutMillis = 5000;
    locala.requestData = paramArrayOfByte;
    return locala;
  }
  
  private static AdFormError parseResponse(AdFormData paramAdFormData, e.a parama)
  {
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()) || (parama == null) || (!parama.isSuccess()))
    {
      AdLog.e("GdtFormUploadUtil", "commit error");
      parama = new AdFormError(4, -1, null);
      return parama;
    }
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(new String(parama.responseData, "UTF-8"));
      parama.returnCode = ((JSONObject)localObject2).getInt("code");
      localObject1 = ((JSONObject)localObject2).optString("message");
      AdLog.i("GdtFormUploadUtil", "parseResponse code:" + parama.returnCode + " message:" + (String)localObject1);
      if (parama.returnCode == 0)
      {
        paramAdFormData = new AdFormError(1, -1, null);
        return paramAdFormData;
      }
    }
    catch (UnsupportedEncodingException paramAdFormData)
    {
      AdLog.e("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
      if (parama.returnCode != 1) {
        break label452;
      }
      localObject1 = new AdFormError(4, -1, null);
      parama = ((JSONObject)localObject2).getJSONObject("data");
      if ((parama == null) || (JSONObject.NULL.equals(parama)))
      {
        AdLog.e("GdtFormUploadUtil", "parseResponse error");
        return localObject1;
      }
    }
    catch (JSONException paramAdFormData)
    {
      AdLog.e("GdtFormUploadUtil", "parseResponse", paramAdFormData);
      return new AdFormError(4, -1, null);
    }
    Object localObject2 = parama.getJSONArray("items");
    if (((JSONArray)localObject2).length() != paramAdFormData.table.getSize())
    {
      AdLog.e("GdtFormUploadUtil", "parseResponse error");
      return localObject1;
    }
    for (;;)
    {
      parama = (e.a)localObject1;
      int i;
      if (i >= ((JSONArray)localObject2).length()) {
        break;
      }
      parama = paramAdFormData.table.getItem(i);
      if ((parama == null) || (!parama.isValid()))
      {
        AdLog.e("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, -1, null);
      }
      JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
      if ((localJSONObject == null) || (JSONObject.NULL.equals(localJSONObject)))
      {
        AdLog.e("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, parama.title.text);
      }
      int j = localJSONObject.getInt("errorCode");
      if (j == 0)
      {
        i += 1;
      }
      else
      {
        if (j == 1) {
          return new AdFormError(5, i, parama.title.text);
        }
        if (j == 2) {
          return new AdFormError(6, i, parama.title.text);
        }
        AdLog.e("GdtFormUploadUtil", "parseResponse error");
        return new AdFormError(4, i, parama.title.text);
        label452:
        if (parama.returnCode == 3) {
          return new AdFormError(4, -1, null);
        }
        if (parama.returnCode == 4) {
          return new AdFormError(7, -1, null);
        }
        paramAdFormData = new AdFormError(4, -1, null);
        return paramAdFormData;
        i = 0;
      }
    }
  }
  
  public static JSONArray toJson(AdFormData paramAdFormData)
  {
    if ((paramAdFormData == null) || (!paramAdFormData.isValid()))
    {
      AdLog.e("GdtFormUploadUtil", "toJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramAdFormData.table.getSize())
    {
      Object localObject = paramAdFormData.table.getItem(i);
      if ((localObject == null) || (!((AdFormItemData)localObject).isValid())) {
        AdLog.e("GdtFormUploadUtil", "toJson error");
      }
      for (;;)
      {
        i += 1;
        break;
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("name", ((AdFormItemData)localObject).title.text);
          localJSONObject.put("require", ((AdFormItemData)localObject).required);
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
    }
    return localJSONArray;
  }
  
  public static AdFormError upload(AdFormData paramAdFormData)
  {
    byte[] arrayOfByte = getRequestData(paramAdFormData);
    Object localObject;
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AdLog.e("GdtFormUploadUtil", "upload error");
      localObject = new AdFormError(4, -1, null);
      return localObject;
    }
    AdFormError localAdFormError = new AdFormError(4, -1, null);
    int i = 0;
    for (;;)
    {
      e.a locala;
      if (i < 3)
      {
        locala = getRequestParams(arrayOfByte);
        if (locala != null) {}
      }
      else
      {
        AdLog.e("GdtFormUploadUtil", "upload error");
        return localAdFormError;
      }
      AdHttp.send(locala);
      if (locala.isSuccess()) {
        localAdFormError = parseResponse(paramAdFormData, locala);
      }
      localObject = localAdFormError;
      if (locala.returnCode == 0) {
        break;
      }
      localObject = localAdFormError;
      if (locala.returnCode == 1) {
        break;
      }
      localObject = localAdFormError;
      if (locala.returnCode == 2) {
        break;
      }
      localObject = localAdFormError;
      if (locala.returnCode == 4) {
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.framework.e
 * JD-Core Version:    0.7.0.1
 */