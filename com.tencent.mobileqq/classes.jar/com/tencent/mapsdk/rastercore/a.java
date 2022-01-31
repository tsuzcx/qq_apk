package com.tencent.mapsdk.rastercore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.f.b;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.zip.GZIPInputStream;

public class a
{
  private final String a = a.class.getSimpleName();
  private StringBuffer b = new StringBuffer(300);
  private boolean c = false;
  
  public a()
  {
    Object localObject1 = b.a(f.a());
    try
    {
      localObject1 = URLEncoder.encode((String)localObject1, "UTF-8");
      this.b.append("key=");
      this.b.append((String)localObject1);
      this.b.append("&output=json");
      this.b.append("&pf=and_2Dmap");
      this.b.append("&ver=");
      try
      {
        this.b.append(URLEncoder.encode("1.3.1.3", "UTF-8"));
        for (;;)
        {
          try
          {
            label114:
            this.b.append("&hm=");
            this.b.append(URLEncoder.encode(Build.MODEL, "UTF-8"));
            this.b.append("&os=A");
            this.b.append(Build.VERSION.SDK_INT);
            this.b.append("&pid=");
            this.b.append(URLEncoder.encode(f.a().getPackageName(), "UTF-8"));
            this.b.append("&nt=");
            localObject3 = this.b;
            localObject1 = (ConnectivityManager)f.a().getSystemService("connectivity");
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((NetworkInfo)localObject1).getTypeName();
            ((StringBuffer)localObject3).append(URLEncoder.encode((String)localObject1));
          }
          catch (Exception localException5)
          {
            Object localObject3;
            continue;
          }
          this.b.append("&suid=");
          this.b.append(b());
          try
          {
            localObject1 = f.a().getPackageManager();
            localObject3 = ((PackageManager)localObject1).getPackageInfo(f.a().getPackageName(), 0);
            localObject1 = ((PackageInfo)localObject3).applicationInfo.loadLabel((PackageManager)localObject1).toString();
          }
          catch (Exception localException1)
          {
            try
            {
              localObject3 = ((PackageInfo)localObject3).versionName;
              boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
              if (bool) {
                break label546;
              }
              if (localObject1 != null) {
                this.b.append("&ref=");
              }
            }
            catch (Exception localException8)
            {
              continue;
            }
            try
            {
              this.b.append(URLEncoder.encode((String)localObject1, "UTF-8"));
              if (localObject3 != null) {
                this.b.append("&psv=");
              }
              try
              {
                this.b.append(URLEncoder.encode((String)localObject3, "UTF-8"));
                try
                {
                  localObject1 = f.a().getResources().getDisplayMetrics();
                  int i = ((DisplayMetrics)localObject1).densityDpi;
                  int j = ((DisplayMetrics)localObject1).widthPixels;
                  int k = ((DisplayMetrics)localObject1).heightPixels;
                  this.b.append("&dpi=");
                  this.b.append(i);
                  this.b.append("&scrn=");
                  this.b.append(j);
                  this.b.append("*");
                  this.b.append(k);
                  localObject1 = this.b;
                  return;
                  localObject1 = "";
                  continue;
                  localObject1 = "";
                  continue;
                  localException1 = localException1;
                  Object localObject2 = null;
                  localObject3 = null;
                }
                catch (Exception localException2) {}
              }
              catch (Exception localException3) {}
            }
            catch (Exception localException4) {}
          }
        }
      }
      catch (Exception localException6)
      {
        break label114;
      }
    }
    catch (Exception localException7)
    {
      for (;;)
      {
        continue;
        label546:
        Object localObject4 = null;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public static String b()
  {
    Object localObject2 = "";
    Context localContext = f.a();
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject1 = localObject2;
      if (localContext != null)
      {
        localObject1 = localObject2;
        if (localContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {}
      }
    }
    else
    {
      localObject1 = ((TelephonyManager)localContext.getSystemService("phone")).getDeviceId();
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "noIMEI";
    }
    return localObject2;
  }
  
  public final void a()
  {
    if (this.c) {
      return;
    }
    new Thread()
    {
      public final void run()
      {
        a.a(a.this, true);
        int i = 0;
        for (;;)
        {
          if (i < 2) {}
          try
          {
            Object localObject = (HttpURLConnection)new URL("https://apikey.map.qq.com/mkey/index.php/mkey/check?" + a.a(a.this).toString()).openConnection();
            ((HttpURLConnection)localObject).setRequestProperty("Accept-Encoding", "gzip");
            if (((HttpURLConnection)localObject).getResponseCode() == 200)
            {
              String str = ((HttpURLConnection)localObject).getHeaderField("Content-Encoding");
              int j;
              if ((str != null) && (str.length() > 0) && (str.toLowerCase().contains("gzip")))
              {
                j = 1;
                if (j == 0) {
                  break label170;
                }
              }
              label170:
              for (localObject = new BufferedInputStream(new GZIPInputStream(((HttpURLConnection)localObject).getInputStream()));; localObject = new BufferedInputStream(((HttpURLConnection)localObject).getInputStream()))
              {
                localObject = new String(c.a((InputStream)localObject));
                a.a(a.this, (String)localObject);
                a.a(a.this, false);
                return;
                j = 0;
                break;
              }
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            i += 1;
          }
        }
      }
    }.start();
  }
  
  public final String c()
  {
    if (this.b == null) {
      return "";
    }
    return this.b.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.a
 * JD-Core Version:    0.7.0.1
 */