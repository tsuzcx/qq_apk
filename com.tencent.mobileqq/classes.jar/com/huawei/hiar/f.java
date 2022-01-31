package com.huawei.hiar;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class f
  extends b
{
  private static final String h = f.class.getSimpleName();
  
  f(Context paramContext, HuaweiArApkBase.ICheckAvailabilityCallback paramICheckAvailabilityCallback, String paramString, Handler paramHandler)
  {
    super(paramContext, paramICheckAvailabilityCallback, paramHandler);
    try
    {
      a(new URL(paramString), ConfigAccessRainbowConst.a);
      return;
    }
    catch (MalformedURLException paramContext)
    {
      Log.e(h, "Malformed URL" + paramString, paramContext);
      this.b = null;
    }
  }
  
  private HuaweiArApkBase.ARAvailability b(String paramString)
  {
    Log.e(h, "DeviceModel:" + c.a());
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("Supported_Product");
        i = 0;
        if (i < paramString.length())
        {
          Object localObject = paramString.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("Product");
          localObject = ((JSONObject)localObject).getString("EMUI_BUILD_DATE");
          if (str.equals(c.a())) {
            return c((String)localObject);
          }
        }
        else
        {
          paramString = HuaweiArApkBase.ARAvailability.UNSUPPORTED_DEVICE_NOT_CAPABLE;
          return paramString;
        }
      }
      catch (JSONException paramString)
      {
        Log.e(h, "json error", paramString);
        return HuaweiArApkBase.ARAvailability.UNKNOWN_ERROR;
      }
      i += 1;
    }
  }
  
  private HuaweiArApkBase.ARAvailability c(String paramString)
  {
    if (j.b().a(paramString))
    {
      if (j.b().d(this.f))
      {
        if (j.b().c(this.f)) {
          return HuaweiArApkBase.ARAvailability.SUPPORTED_INSTALLED;
        }
        return HuaweiArApkBase.ARAvailability.SUPPORTED_APK_TOO_OLD;
      }
      return HuaweiArApkBase.ARAvailability.SUPPORTED_NOT_INSTALLED;
    }
    return HuaweiArApkBase.ARAvailability.UNSUPPORTED_EMUI_NOT_CAPABLE;
  }
  
  void a(String paramString)
  {
    a(b(paramString));
  }
  
  void b()
  {
    if (this.b != null)
    {
      e locale = new e(this.b, this);
      Message localMessage = new Message();
      localMessage.what = i.b.d;
      localMessage.obj = locale;
      this.g.sendMessage(localMessage);
      return;
    }
    Log.e(h, "checkSupport: HttpURLConnection is null");
    a(HuaweiArApkBase.ARAvailability.UNKNOWN_ERROR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.f
 * JD-Core Version:    0.7.0.1
 */