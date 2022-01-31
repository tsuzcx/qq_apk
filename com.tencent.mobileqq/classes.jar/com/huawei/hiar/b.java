package com.huawei.hiar;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

abstract class b
{
  static String a = b.class.getSimpleName();
  protected HttpURLConnection b;
  final int c = 2000;
  final int d = 1000;
  final int e = 1000;
  Context f;
  Handler g;
  private HuaweiArApkBase.ICheckAvailabilityCallback h;
  
  public b(Context paramContext, HuaweiArApkBase.ICheckAvailabilityCallback paramICheckAvailabilityCallback, Handler paramHandler)
  {
    this.f = paramContext;
    this.h = paramICheckAvailabilityCallback;
    this.g = paramHandler;
  }
  
  protected HuaweiArApkBase.ICheckAvailabilityCallback a()
  {
    return this.h;
  }
  
  void a(HuaweiArApkBase.ARAvailability paramARAvailability)
  {
    this.h.onResult(paramARAvailability);
    paramARAvailability = new Message();
    paramARAvailability.what = i.c.d;
    this.g.sendMessage(paramARAvailability);
  }
  
  void a(String paramString) {}
  
  void a(URL paramURL, String paramString)
  {
    if (this.b != null)
    {
      this.b.disconnect();
      this.b = null;
    }
    try
    {
      this.b = ((HttpURLConnection)paramURL.openConnection());
      this.b.setRequestProperty("Device-ID", c.b());
      this.b.setRequestMethod(paramString);
      if (paramString.equals(ConfigAccessRainbowConst.b)) {
        this.b.setDoOutput(true);
      }
      this.b.setConnectTimeout(2000);
      this.b.setReadTimeout(1000);
      this.b.setRequestProperty("Content-Type", "application/json");
      this.b.setRequestProperty("Charset", "UTF-8");
      this.b.addRequestProperty("Connection", "Keep-Alive");
      return;
    }
    catch (IOException paramURL)
    {
      do
      {
        Log.e(a, "buildHttpURLConnection: ", paramURL);
      } while (this.h == null);
      a(HuaweiArApkBase.ARAvailability.UNKNOWN_ERROR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.b
 * JD-Core Version:    0.7.0.1
 */