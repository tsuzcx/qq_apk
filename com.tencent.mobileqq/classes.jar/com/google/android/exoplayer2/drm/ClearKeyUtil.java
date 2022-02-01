package com.google.android.exoplayer2.drm;

import android.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ClearKeyUtil
{
  private static final Pattern REQUEST_KIDS_PATTERN = Pattern.compile("\"kids\":\\[\"(.*?)\"]");
  private static final String TAG = "ClearKeyUtil";
  
  public static byte[] adjustRequestData(byte[] paramArrayOfByte)
  {
    if (Util.SDK_INT >= 27) {
      return paramArrayOfByte;
    }
    String str = Util.fromUtf8Bytes(paramArrayOfByte);
    Object localObject = REQUEST_KIDS_PATTERN.matcher(str);
    if (!((Matcher)localObject).find())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to adjust request data: ");
      ((StringBuilder)localObject).append(str);
      Log.e("ClearKeyUtil", ((StringBuilder)localObject).toString());
      return paramArrayOfByte;
    }
    int i = ((Matcher)localObject).start(1);
    int j = ((Matcher)localObject).end(1);
    paramArrayOfByte = new StringBuilder(str);
    base64ToBase64Url(paramArrayOfByte, i, j);
    return Util.getUtf8Bytes(paramArrayOfByte.toString());
  }
  
  public static byte[] adjustResponseData(byte[] paramArrayOfByte)
  {
    if (Util.SDK_INT >= 27) {
      return paramArrayOfByte;
    }
    try
    {
      Object localObject1 = new JSONObject(Util.fromUtf8Bytes(paramArrayOfByte));
      localObject2 = ((JSONObject)localObject1).getJSONArray("keys");
      int i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
        localJSONObject.put("k", base64UrlToBase64(localJSONObject.getString("k")));
        localJSONObject.put("kid", base64UrlToBase64(localJSONObject.getString("kid")));
        i += 1;
      }
      localObject1 = Util.getUtf8Bytes(((JSONObject)localObject1).toString());
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Failed to adjust response data: ");
      ((StringBuilder)localObject2).append(Util.fromUtf8Bytes(paramArrayOfByte));
      Log.e("ClearKeyUtil", ((StringBuilder)localObject2).toString(), localJSONException);
    }
    return paramArrayOfByte;
  }
  
  private static void base64ToBase64Url(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      int i = paramStringBuilder.charAt(paramInt1);
      if (i != 43)
      {
        if (i == 47) {
          paramStringBuilder.setCharAt(paramInt1, '_');
        }
      }
      else {
        paramStringBuilder.setCharAt(paramInt1, '-');
      }
      paramInt1 += 1;
    }
  }
  
  private static String base64UrlToBase64(String paramString)
  {
    return paramString.replace('-', '+').replace('_', '/');
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.ClearKeyUtil
 * JD-Core Version:    0.7.0.1
 */