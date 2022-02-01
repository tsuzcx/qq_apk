package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.viola.adapter.HttpRequset;
import com.tencent.viola.adapter.IHttpAdapter;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import tly;

@HippyNativeModule(name="http")
public class HippyQQHttpModule
  extends HippyNativeModuleBase
{
  static final Pattern CHARSET_PATTERN = Pattern.compile("charset=([a-z0-9-]+)");
  static final String CLASSNAME = "http";
  public static final String HTPP_ERROR_TEXT = "errorText";
  public static final String HTTP_CODE = "code";
  public static final String HTTP_DATA = "data";
  public static final String HTTP_METHOD_GET = "GET";
  public static final String HTTP_METHOD_POST = "POST";
  public static final String HTTP_SUCCESS = "success";
  public static final String MODULE_NAME = "http";
  public static String TAG = "HttpModule";
  private IHttpAdapter mAdapter = new tly();
  
  public HippyQQHttpModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  public static void encodeDataFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str1 = localIterator.next().toString();
          String str2 = paramJSONObject.getString(str1);
          if (!TextUtils.isEmpty(str2))
          {
            str2 = URLEncoder.encode(str2);
            if (!TextUtils.isEmpty(str2)) {
              paramJSONObject.put(str1, str2.replace("+", "%20"));
            }
          }
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        ViolaLogUtils.e(TAG, "encodeDataFromJson Exception e:" + paramJSONObject.getMessage());
      }
    }
  }
  
  static String getHeader(Map<String, String> paramMap, String paramString)
  {
    if ((paramMap == null) || (paramString == null)) {
      return null;
    }
    if (paramMap.containsKey(paramString)) {
      return (String)paramMap.get(paramString);
    }
    return (String)paramMap.get(paramString.toLowerCase());
  }
  
  static String readAsString(byte[] paramArrayOfByte, String paramString)
  {
    if (paramString != null)
    {
      paramString = CHARSET_PATTERN.matcher(paramString.toLowerCase());
      if (!paramString.find()) {}
    }
    for (paramString = paramString.group(1);; paramString = "utf-8") {
      try
      {
        paramString = new String(paramArrayOfByte, paramString);
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        Log.e("", paramString.getMessage());
        return new String(paramArrayOfByte);
      }
    }
  }
  
  private void reuqestHttp(String paramString1, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt, Promise paramPromise, String paramString2, boolean paramBoolean)
  {
    HttpRequset localHttpRequset = new HttpRequset();
    localHttpRequset.url = paramString1;
    localHttpRequset.method = paramString2;
    if ((!paramString2.equals("GET")) || (paramJSONObject1 != null)) {}
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramJSONObject1.toString());
        encodeDataFromJson(paramString2);
        localHttpRequset.url = ViolaUtils.splittUrlForHttpGet(paramString2, paramString1);
        localHttpRequset.timeoutMs = paramInt;
        paramString1 = new HashMap();
        if (paramJSONObject2 == null) {
          break label162;
        }
        paramString2 = paramJSONObject2.keys();
        if (!paramString2.hasNext()) {
          break;
        }
        String str = (String)paramString2.next();
        paramString1.put(str, paramJSONObject2.optString(str));
        continue;
      }
      catch (JSONException paramString2)
      {
        localHttpRequset.url = ViolaUtils.splittUrlForHttpGet(paramJSONObject1, paramString1);
        continue;
      }
      localHttpRequset.url = ViolaUtils.splittUrlForHttpGet(paramJSONObject1, paramString1);
    }
    localHttpRequset.paramMap = paramString1;
    label162:
    if (paramJSONObject1 != null) {
      if ((!paramString1.containsKey("Content-Type")) || (TextUtils.isEmpty((CharSequence)paramString1.get("Content-Type"))) || (!((String)paramString1.get("Content-Type")).contains("application/json"))) {
        break label248;
      }
    }
    label248:
    for (localHttpRequset.body = paramJSONObject1.toString();; localHttpRequset.body = ViolaUtils.splittBodyEncodeUrl(paramJSONObject1))
    {
      this.mAdapter.sendRequest(localHttpRequset, new HippyQQHttpModule.HttpListener(this, new HippyQQHttpModule.1(this, paramPromise)), paramBoolean);
      return;
    }
  }
  
  public void destroy() {}
  
  Object parseData(String paramString1, String paramString2)
  {
    Object localObject;
    if ("json".equals(paramString2)) {
      localObject = new JSONObject(paramString1);
    }
    do
    {
      return localObject;
      localObject = paramString1;
    } while (!"jsonp".equals(paramString2));
    if ((paramString1 == null) || (paramString1.isEmpty())) {
      return new JSONObject();
    }
    int i = paramString1.indexOf("(") + 1;
    int j = paramString1.lastIndexOf(")");
    if ((i == 0) || (i >= j) || (j <= 0)) {
      return new JSONObject();
    }
    return new JSONObject(paramString1.substring(i, j));
  }
  
  @HippyMethod(name="request")
  public void request(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject(); TextUtils.isEmpty(paramHippyMap.optString("url")); paramHippyMap = new JSONObject()) {
      return;
    }
    int i = paramHippyMap.optInt("timeout", 10000);
    boolean bool = paramHippyMap.optBoolean("forReport", false);
    reuqestHttp(paramHippyMap.optString("url"), paramHippyMap.optJSONObject("data"), paramHippyMap.optJSONObject("headers"), i, paramPromise, paramHippyMap.optString("method", "POST").toUpperCase(), bool);
  }
  
  @HippyMethod(name="requestGet")
  public void requestGet(String paramString, HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      reuqestHttp(paramString, paramHippyMap, null, 10000, paramPromise, "GET", false);
      return;
    }
  }
  
  @HippyMethod(name="requestPost")
  public void requestPost(String paramString, HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      reuqestHttp(paramString, paramHippyMap, null, 10000, paramPromise, "POST", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.HippyQQHttpModule
 * JD-Core Version:    0.7.0.1
 */