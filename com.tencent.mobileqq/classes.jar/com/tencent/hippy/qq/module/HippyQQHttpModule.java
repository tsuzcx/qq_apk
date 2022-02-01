package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.kandian.biz.viola.api.IBaseHttpAdapterFactory;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
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
  private IHttpAdapter mAdapter = ((IBaseHttpAdapterFactory)QRoute.api(IBaseHttpAdapterFactory.class)).create();
  
  public HippyQQHttpModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  public static void encodeDataFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        Object localObject1 = paramJSONObject.keys();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next().toString();
          String str = paramJSONObject.getString((String)localObject2);
          if (!TextUtils.isEmpty(str))
          {
            str = URLEncoder.encode(str);
            if (!TextUtils.isEmpty(str)) {
              paramJSONObject.put((String)localObject2, str.replace("+", "%20"));
            }
          }
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("encodeDataFromJson Exception e:");
        ((StringBuilder)localObject2).append(paramJSONObject.getMessage());
        ViolaLogUtils.e((String)localObject1, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  static String getHeader(Map<String, String> paramMap, String paramString)
  {
    if ((paramMap != null) && (paramString != null))
    {
      if (paramMap.containsKey(paramString)) {
        return (String)paramMap.get(paramString);
      }
      return (String)paramMap.get(paramString.toLowerCase());
    }
    return null;
  }
  
  static String readAsString(byte[] paramArrayOfByte, String paramString)
  {
    if (paramString != null)
    {
      paramString = CHARSET_PATTERN.matcher(paramString.toLowerCase());
      if (paramString.find())
      {
        paramString = paramString.group(1);
        break label34;
      }
    }
    paramString = "utf-8";
    try
    {
      label34:
      paramString = new String(paramArrayOfByte, paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Log.e("", paramString.getMessage());
    }
    return new String(paramArrayOfByte);
  }
  
  private void reuqestHttp(String paramString1, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt, Promise paramPromise, String paramString2, boolean paramBoolean)
  {
    HttpRequset localHttpRequset = new HttpRequset();
    localHttpRequset.url = paramString1;
    localHttpRequset.method = paramString2;
    if ((!paramString2.equals("GET")) || (paramJSONObject1 != null)) {}
    try
    {
      paramString2 = new JSONObject(paramJSONObject1.toString());
      encodeDataFromJson(paramString2);
      localHttpRequset.url = ViolaUtils.splittUrlForHttpGet(paramString2, paramString1);
    }
    catch (JSONException paramString2)
    {
      label68:
      break label68;
    }
    localHttpRequset.url = ViolaUtils.splittUrlForHttpGet(paramJSONObject1, paramString1);
    break label91;
    localHttpRequset.url = ViolaUtils.splittUrlForHttpGet(paramJSONObject1, paramString1);
    label91:
    localHttpRequset.timeoutMs = paramInt;
    paramString1 = new HashMap();
    if (paramJSONObject2 != null)
    {
      paramString2 = paramJSONObject2.keys();
      while (paramString2.hasNext())
      {
        String str = (String)paramString2.next();
        paramString1.put(str, paramJSONObject2.optString(str));
      }
      localHttpRequset.paramMap = paramString1;
    }
    if (paramJSONObject1 != null) {
      if ((paramString1.containsKey("Content-Type")) && (!TextUtils.isEmpty((CharSequence)paramString1.get("Content-Type"))) && (((String)paramString1.get("Content-Type")).contains("application/json"))) {
        localHttpRequset.body = paramJSONObject1.toString();
      } else {
        localHttpRequset.body = ViolaUtils.splittBodyEncodeUrl(paramJSONObject1);
      }
    }
    this.mAdapter.sendRequest(localHttpRequset, new HippyQQHttpModule.HttpListener(this, new HippyQQHttpModule.1(this, localHttpRequset, paramPromise)), paramBoolean);
  }
  
  public void destroy() {}
  
  Object parseData(String paramString1, String paramString2)
  {
    if ("json".equals(paramString2)) {
      return new JSONObject(paramString1);
    }
    Object localObject = paramString1;
    if ("jsonp".equals(paramString2))
    {
      if ((paramString1 != null) && (!paramString1.isEmpty()))
      {
        int i = paramString1.indexOf("(") + 1;
        int j = paramString1.lastIndexOf(")");
        if ((i != 0) && (i < j) && (j > 0)) {
          return new JSONObject(paramString1.substring(i, j));
        }
        return new JSONObject();
      }
      localObject = new JSONObject();
    }
    return localObject;
  }
  
  @HippyMethod(name="request")
  public void request(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {
      paramHippyMap = paramHippyMap.toJSONObject();
    } else {
      paramHippyMap = new JSONObject();
    }
    if (TextUtils.isEmpty(paramHippyMap.optString("url"))) {
      return;
    }
    int i = paramHippyMap.optInt("timeout", 10000);
    boolean bool = paramHippyMap.optBoolean("forReport", false);
    GamePubAccountHelper.b(paramHippyMap.optString("url"), System.currentTimeMillis());
    reuqestHttp(paramHippyMap.optString("url"), paramHippyMap.optJSONObject("data"), paramHippyMap.optJSONObject("headers"), i, paramPromise, paramHippyMap.optString("method", "POST").toUpperCase(), bool);
  }
  
  @HippyMethod(name="requestGet")
  public void requestGet(String paramString, HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {
      paramHippyMap = paramHippyMap.toJSONObject();
    } else {
      paramHippyMap = new JSONObject();
    }
    reuqestHttp(paramString, paramHippyMap, null, 10000, paramPromise, "GET", false);
  }
  
  @HippyMethod(name="requestPost")
  public void requestPost(String paramString, HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {
      paramHippyMap = paramHippyMap.toJSONObject();
    } else {
      paramHippyMap = new JSONObject();
    }
    reuqestHttp(paramString, paramHippyMap, null, 10000, paramPromise, "POST", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.HippyQQHttpModule
 * JD-Core Version:    0.7.0.1
 */