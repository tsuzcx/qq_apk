package com.huawei.hiar;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class g
  extends b
{
  static String h = g.class.getSimpleName();
  
  public g(Context paramContext, HuaweiArApkBase.ICheckAvailabilityCallback paramICheckAvailabilityCallback, Handler paramHandler)
  {
    super(paramContext, paramICheckAvailabilityCallback, paramHandler);
    try
    {
      a(new URL("https://configserver.hicloud.com/servicesupport/updateserver/data/com.huawei.hiAR_ARSDK_ProductConfig"), ConfigAccessRainbowConst.b);
      return;
    }
    catch (MalformedURLException paramContext)
    {
      Log.e(h, "Malformed URL" + "https://configserver.hicloud.com/servicesupport/updateserver/data/com.huawei.hiAR_ARSDK_ProductConfig", paramContext);
      this.b = null;
    }
  }
  
  void a(String paramString)
  {
    String str;
    if (this.b != null)
    {
      str = this.b.getHeaderField("Result-Type");
      if (!str.equals("0")) {}
    }
    else
    {
      try
      {
        paramString = new JSONArray(paramString).getJSONObject(0).getString("downloadUrl");
        new f(this.f, a(), paramString, this.g).b();
        return;
      }
      catch (JSONException paramString)
      {
        Log.e(h, "Json error", paramString);
        a(HuaweiArApkBase.ARAvailability.UNKNOWN_ERROR);
        return;
      }
    }
    if (str.equals("1"))
    {
      Log.d(h, "result_type is text" + paramString);
      a(HuaweiArApkBase.ARAvailability.UNKNOWN_ERROR);
      return;
    }
    Log.w(h, "unknown type " + str);
    a(HuaweiArApkBase.ARAvailability.UNKNOWN_ERROR);
  }
  
  public void b()
  {
    if (this.b != null)
    {
      h localh = new h(this.b, this);
      Message localMessage = new Message();
      localMessage.obj = localh;
      localMessage.what = i.a.d;
      Log.d(h, "accessRainbowServer: send message");
      this.g.sendMessage(localMessage);
      return;
    }
    Log.e(h, "accessRainbowServer: HttpURLConnection is null");
    a(HuaweiArApkBase.ARAvailability.UNKNOWN_ERROR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.g
 * JD-Core Version:    0.7.0.1
 */