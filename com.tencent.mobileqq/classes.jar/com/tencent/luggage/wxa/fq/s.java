package com.tencent.luggage.wxa.fq;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.luggage.wxa.fr.d;
import com.tencent.luggage.wxa.fv.e;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rn.a;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.luggage.xlog.Xlog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public class s
{
  static boolean a = false;
  public static String b;
  public static String c;
  private static final long d = ;
  
  public static String a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("#client.version=");
    ((StringBuilder)localObject1).append(Integer.toHexString(654316592));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("#client.process=");
    ((StringBuilder)localObject2).append(r.c());
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("#client.hostAppId=");
    ((StringBuilder)localObject3).append(g.c.a.a());
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#xwalk.coreVersion=");
    localStringBuilder.append(XWalkEnvironment.getInstalledNewstVersion(r.a()));
    return StringUtils.join(new String[] { localObject1, "#client.sdk=1.5.1", "#client.revision=897a5c67ab7684eb5b9d8eba155ed3fc26c6dded", localObject2, "#client.buildTime=2021-06-22 15:37:22", localObject3, "#client.buildNumber=1221", localStringBuilder.toString() }, '\n');
  }
  
  public static String a(String paramString1, String paramString2)
  {
    long l = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("process", r.c());
      localJSONObject.put("company", Build.BRAND);
      localJSONObject.put("uin", e.a.a());
      localJSONObject.put("is_front", true);
      localJSONObject.put("phone", Build.MODEL);
      localJSONObject.put("is_jni", d.c.name().equals(paramString1));
      localJSONObject.put("cver", 553976065);
      localJSONObject.put("c_time", l / 1000L);
      localJSONObject.put("rev", "897a5c67ab7684eb5b9d8eba155ed3fc26c6dded");
      localJSONObject.put("runtime", l - d);
      paramString1 = new StringBuilder();
      paramString1.append("android-");
      paramString1.append(Build.VERSION.SDK_INT);
      localJSONObject.put("api_level", paramString1.toString());
      localJSONObject.put("pipeline_num", 1221);
      localJSONObject.put("time:", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.ENGLISH).format(new Date()));
      localJSONObject.put("client.sdkVersion", Integer.toHexString(553976065));
      localJSONObject.put("client.wxVersion", Integer.toHexString(654316592));
      localJSONObject.put("client.sdk", "1.5.1");
      localJSONObject.put("client.buildTime", "2021-06-22 15:37:22");
      localJSONObject.put("client.hostAppPkgName", r.b());
      localJSONObject.put("client.hostAppId", g.c.a.a());
      localJSONObject.put("xwalk.coreVersion", XWalkEnvironment.getInstalledNewstVersion(r.a()));
      localJSONObject.put("stack", paramString2);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      throw new RuntimeException("build crash report content fail", paramString1);
    }
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    if (!k.h(c)) {
      k.g(c);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(((SimpleDateFormat)localObject).format(new Date()));
    localStringBuilder.append(".txt");
    localObject = localStringBuilder.toString();
    if (!k.h((String)localObject)) {
      k.k((String)localObject);
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("==================================================");
    localStringBuilder.append("\n");
    localStringBuilder.append(a());
    localStringBuilder.append('\n');
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.ENGLISH);
    localStringBuilder.append("time:");
    localStringBuilder.append(localSimpleDateFormat.format(new Date()));
    localStringBuilder.append("\n");
    localStringBuilder.append("crashType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\n");
    localStringBuilder.append("errorType:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\n");
    localStringBuilder.append("errorMessage:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\n");
    localStringBuilder.append("errorStack:");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("\n");
    localStringBuilder.append("==================================================");
    localStringBuilder.append("\n");
    localStringBuilder.append("\n");
    paramString1 = localStringBuilder.toString();
    k.a((String)localObject, paramString1.getBytes());
    o.b("Luggage.XLogSetup", paramString1);
  }
  
  public static void a(String paramString)
  {
    if (a) {
      return;
    }
    long l1 = af.b();
    System.loadLibrary("wechatxlog");
    System.loadLibrary("stlport_shared");
    long l2 = af.b();
    long l3 = af.b();
    Object localObject = b().getAbsolutePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("/wxa/xlog");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("/wxa/xlog/crash/");
    c = localStringBuilder.toString();
    k.g(b);
    k.g(c);
    long l4 = af.b();
    long l5 = af.b();
    Log.i("Luggage.XLogSetup", String.format(Locale.ENGLISH, "init done nameprefix:%s debug[%b] snapshot[%b]", new Object[] { paramString, Boolean.valueOf(false), Boolean.valueOf(f.a()) }));
    localObject = new Xlog();
    if (f.a())
    {
      ((Xlog)localObject).appenderOpen(0, 1, "", b, paramString, 3);
      ((Xlog)localObject).setConsoleLogOpen(0L, true);
    }
    else
    {
      ((Xlog)localObject).appenderOpen(1, 0, "", b, paramString, 7);
    }
    long l6 = af.b();
    long l7 = af.b();
    o.a(new s.1((Xlog)localObject));
    com.tencent.luggage.wxa.ry.b.a(new s.2());
    a.a(new s.3());
    com.tencent.luggage.wxa.hs.b.a(new s.4());
    com.tencent.luggage.wxa.gw.b.a(new s.5((Xlog)localObject));
    com.tencent.luggage.wxa.f.f.a(new s.6());
    long l8 = af.b();
    o.d("Luggage.XLogSetup", String.format(Locale.ENGLISH, "|runProfiled|init done nameprefix:%s debug[%b] snapshot[%b], loadXlogSoCost[%d], setupXlogDirCost[%d], initializeXlogCost[%s], setLogImpCost[%d]", new Object[] { paramString, Boolean.valueOf(false), Boolean.valueOf(f.a()), Long.valueOf(l2 - l1), Long.valueOf(l4 - l3), Long.valueOf(l6 - l5), Long.valueOf(l8 - l7) }));
    a = true;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a(paramString1, paramString2);
    if (!af.c(paramString3))
    {
      o.d("Luggage.XLogSetup", "create crash info file");
      if (k.h(paramString3)) {
        k.i(paramString3);
      }
      if (k.k(paramString3))
      {
        k.b(paramString3, paramString1.getBytes());
        return;
      }
      o.b("Luggage.XLogSetup", "create file:%s fail", new Object[] { paramString3 });
    }
  }
  
  private static File b()
  {
    Object localObject = r.a().getExternalFilesDir("");
    if (localObject != null)
    {
      Log.i("Luggage.XLogSetup", "safeGetExternalFilesDir, api get ok");
      return localObject;
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/sdcard/Android/data/");
      ((StringBuilder)localObject).append(r.b());
      ((StringBuilder)localObject).append("/files/");
      localObject = new File(((StringBuilder)localObject).toString());
      ((File)localObject).mkdirs();
      Log.i("Luggage.XLogSetup", "safeGetExternalFilesDir, manual get ok");
      return localObject;
    }
    catch (Exception localException)
    {
      label87:
      break label87;
    }
    Log.e("Luggage.XLogSetup", "safeGetExternalFilesDir, manual get error");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/");
    ((StringBuilder)localObject).append(r.b());
    ((StringBuilder)localObject).append("/files/");
    localObject = new File(((StringBuilder)localObject).toString());
    ((File)localObject).mkdirs();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.s
 * JD-Core Version:    0.7.0.1
 */