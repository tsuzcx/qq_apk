package com.tencent.liteav.basic.d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PrivateKey;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  protected static c f;
  private static Context g;
  protected String a;
  SharedPreferences b;
  SharedPreferences.Editor c;
  String d = "";
  long e = 0L;
  private boolean h = false;
  private boolean i = false;
  private c.a j = new c.a(null);
  private final b k = new b();
  private SharedPreferences l;
  private final Object m = new Object();
  
  private long a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    long l2 = -1L;
    long l1 = l2;
    if (!bool)
    {
      l1 = l2;
      if (c.a.q(this.j) != null)
      {
        paramString1 = c.a.q(this.j).optJSONObject(paramString1);
        l1 = l2;
        if (paramString1 != null)
        {
          paramString1 = paramString1.optJSONObject(paramString2);
          l1 = l2;
          if (paramString1 != null) {
            l1 = paramString1.optLong(paramString3, -1L);
          }
        }
      }
    }
    return l1;
  }
  
  public static c a()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new c();
        }
      }
      finally {}
    }
    return f;
  }
  
  private static String a(File paramFile)
  {
    try
    {
      paramFile = new ZipFile(paramFile);
      Object localObject1 = paramFile.entries();
      while (((Enumeration)localObject1).hasMoreElements())
      {
        Object localObject2 = (ZipEntry)((Enumeration)localObject1).nextElement();
        if (!((ZipEntry)localObject2).isDirectory())
        {
          localObject1 = paramFile.getInputStream((ZipEntry)localObject2);
          localObject2 = new byte[1048576];
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          for (;;)
          {
            int n = ((InputStream)localObject1).read((byte[])localObject2);
            if (n <= 0) {
              break;
            }
            localByteArrayOutputStream.write((byte[])localObject2, 0, n);
          }
          ((InputStream)localObject1).close();
          paramFile.close();
          paramFile = localByteArrayOutputStream.toString();
          return paramFile;
        }
      }
      paramFile.close();
      return "";
    }
    finally {}
    for (;;)
    {
      throw paramFile;
    }
  }
  
  private void a(int paramInt)
  {
    int n = paramInt;
    if (paramInt < 1) {
      n = 1;
    }
    try
    {
      this.e = (System.currentTimeMillis() + n * 24 * 60 * 60 * 1000);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setExpiredtime: days=");
      localStringBuilder.append(n);
      localStringBuilder.append(" expiredTime=");
      localStringBuilder.append(this.e);
      TXCLog.i("CloudConfig", localStringBuilder.toString());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(c.a parama, JSONObject paramJSONObject)
  {
    if (this.c == null)
    {
      localObject1 = g;
      if (localObject1 != null)
      {
        localObject1 = ((Context)localObject1).getSharedPreferences("cloud_config", 0);
        if (localObject1 != null) {
          this.c = ((SharedPreferences)localObject1).edit();
        }
      }
    }
    Object localObject1 = this.c;
    if (localObject1 != null)
    {
      ((SharedPreferences.Editor)localObject1).putLong("expired_time", this.e);
      this.c.putInt("hw_config", c.a.b(parama));
      this.c.putInt("ExposureCompensation", c.a.c(parama));
      this.c.putInt("UGCSWMuxerConfig", c.a.d(parama));
      this.c.putInt("CPU", c.a.i(parama));
      this.c.putInt("FPS", c.a.j(parama));
      this.c.putInt("CPU_MAX", c.a.g(parama));
      this.c.putInt("FPS_MIN", c.a.h(parama));
      this.c.putInt("CheckCount", c.a.f(parama));
      this.c.putInt("PreGenerateSW", c.a.e(parama));
      this.c.putString("trae_config", c.a.a(parama));
      if (c.a.q(parama) != null) {
        this.c.putString("AppIDConfig", c.a.q(parama).toString());
      }
      if (c.a.n(parama) != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(c.a.n(parama)[0]);
        localObject1 = ((StringBuilder)localObject1).toString();
        int n = 1;
        for (;;)
        {
          localObject2 = localObject1;
          if (n >= c.a.n(parama).length) {
            break;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("|");
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(c.a.n(parama)[n]);
          localObject1 = ((StringBuilder)localObject2).toString();
          n += 1;
        }
      }
      Object localObject2 = "0";
      if (c.a.k(parama) == null) {
        c.a.a(parama, "");
      }
      localObject1 = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c.a.l(parama));
      localStringBuilder.append(",");
      localStringBuilder.append(c.a.m(parama));
      localStringBuilder.append(",");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(",");
      localStringBuilder.append(c.a.p(parama));
      localStringBuilder.append(",");
      localStringBuilder.append(c.a.k(parama));
      ((SharedPreferences.Editor)localObject1).putString("system_aec_config", localStringBuilder.toString());
      if (paramJSONObject == null) {
        this.c.putString("compatible_config", null);
      } else {
        this.c.putString("compatible_config", paramJSONObject.toString());
      }
      this.c.commit();
    }
  }
  
  private void a(String paramString, c.a parama)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("InfoList"))
      {
        paramString = paramString.getJSONArray("InfoList");
        int n = 0;
        while (n < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(n);
          if ((localJSONObject != null) && (localJSONObject.getString("MachineType").equals(Build.MODEL)))
          {
            c.a.b(parama, localJSONObject.getString("ConfigValue"));
            return;
          }
          n += 1;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      parama = new StringBuilder();
      parama.append("parseTraeLocalConfig catch ecxeption");
      parama.append(paramString);
      TXCLog.w("CloudConfig", parama.toString());
    }
  }
  
  private void a(JSONObject paramJSONObject, c.a parama)
  {
    c.a.a(parama, 0);
    c.a.b(parama, 0);
    Object localObject2 = null;
    c.a.a(parama, null);
    c.a.c(parama, 0);
    c.a.a(parama, "");
    Object localObject1 = localObject2;
    if (paramJSONObject.has("SystemAECConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("SystemAECConfig");
      localObject1 = localObject2;
      if (paramJSONObject.has("InfoList"))
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray("InfoList");
        paramJSONObject = null;
        int n = 0;
        while (n < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(n);
          localObject2 = paramJSONObject;
          if (localJSONObject != null)
          {
            localObject2 = paramJSONObject;
            if (localJSONObject.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER))
            {
              localObject1 = localJSONObject.optJSONArray("WhiteList");
              int i3 = 1;
              if (localObject1 != null)
              {
                i1 = 0;
                while (i1 < ((JSONArray)localObject1).length())
                {
                  localObject2 = ((JSONArray)localObject1).optJSONObject(i1);
                  if (localObject2 != null)
                  {
                    localObject2 = ((JSONObject)localObject2).optString("Model");
                    if ((localObject2 != null) && (Build.MODEL.equals(localObject2)))
                    {
                      i1 = 1;
                      break label217;
                    }
                  }
                  i1 += 1;
                }
              }
              int i1 = 0;
              label217:
              localObject1 = localJSONObject.optJSONArray("BlackList");
              if (localObject1 != null)
              {
                i2 = 0;
                while (i2 < ((JSONArray)localObject1).length())
                {
                  localObject2 = ((JSONArray)localObject1).optJSONObject(i2);
                  if (localObject2 != null)
                  {
                    localObject2 = ((JSONObject)localObject2).optString("Model");
                    if ((localObject2 != null) && (Build.MODEL.equals(localObject2)))
                    {
                      i2 = i3;
                      break label304;
                    }
                  }
                  i2 += 1;
                }
              }
              int i2 = 0;
              label304:
              localObject1 = paramJSONObject;
              if (i1 != 0)
              {
                localObject1 = paramJSONObject;
                try
                {
                  c.a.a(parama, localJSONObject.optInt("SystemAEC", 0));
                  localObject1 = paramJSONObject;
                  c.a.b(parama, localJSONObject.optInt("AGC", 0));
                  localObject1 = paramJSONObject;
                  paramJSONObject = localJSONObject.optString("SampleRate", "");
                  localObject1 = paramJSONObject;
                  if (!paramJSONObject.isEmpty())
                  {
                    localObject1 = paramJSONObject;
                    localObject2 = paramJSONObject.split("\\|");
                    localObject1 = paramJSONObject;
                    c.a.a(parama, new int[localObject2.length]);
                    i1 = 0;
                    for (;;)
                    {
                      localObject1 = paramJSONObject;
                      if (i1 >= localObject2.length) {
                        break;
                      }
                      localObject1 = paramJSONObject;
                      c.a.n(parama)[i1] = Integer.valueOf(localObject2[i1].trim()).intValue();
                      i1 += 1;
                    }
                  }
                  localObject1 = paramJSONObject;
                  c.a.c(parama, localJSONObject.optInt("HWAACCodec", 0));
                  localObject1 = paramJSONObject;
                  c.a.a(parama, localJSONObject.optString("SceneType", ""));
                  localObject1 = paramJSONObject;
                }
                catch (Exception paramJSONObject)
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("parseSysAECConfig Exception: ");
                  ((StringBuilder)localObject2).append(paramJSONObject.getMessage());
                  TXCLog.e("CloudConfig", ((StringBuilder)localObject2).toString());
                }
              }
              localObject2 = localObject1;
              if (i2 != 0)
              {
                c.a.a(parama, 0);
                c.a.b(parama, 0);
                c.a.a(parama, null);
                c.a.c(parama, 0);
                c.a.a(parama, "");
                localObject2 = localObject1;
              }
            }
          }
          n += 1;
          paramJSONObject = (JSONObject)localObject2;
        }
        localObject1 = paramJSONObject;
      }
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("system aec config1:");
    paramJSONObject.append(c.a.l(parama));
    paramJSONObject.append(",");
    paramJSONObject.append(c.a.m(parama));
    paramJSONObject.append(",");
    paramJSONObject.append((String)localObject1);
    paramJSONObject.append(",");
    paramJSONObject.append(c.a.p(parama));
    paramJSONObject.append(",");
    paramJSONObject.append(c.a.k(parama));
    paramJSONObject.append(", model = ");
    paramJSONObject.append(Build.MODEL);
    paramJSONObject.append(", manufacturer = ");
    paramJSONObject.append(Build.MANUFACTURER);
    paramJSONObject.append("， board = ");
    paramJSONObject.append(Build.BOARD);
    TXCLog.i("CloudConfig", paramJSONObject.toString());
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("HEVCConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("HEVCConfig");
      if ((paramJSONObject != null) && (paramJSONObject.has("Decoder")))
      {
        paramJSONObject = paramJSONObject.optJSONObject("Decoder");
        if ((paramJSONObject != null) && (paramJSONObject.has("BlackConfig")))
        {
          paramJSONObject = paramJSONObject.getJSONObject("BlackConfig");
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.getJSONArray("InfoList");
            int n = 0;
            while (n < paramJSONObject.length())
            {
              JSONObject localJSONObject = paramJSONObject.getJSONObject(n);
              if ((localJSONObject.has("Manufacture")) && (localJSONObject.has("Model")) && (localJSONObject.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER)) && (localJSONObject.getString("Model").equalsIgnoreCase(Build.MODEL)))
              {
                if (localJSONObject.has("HWMiniSupportAPI"))
                {
                  n = localJSONObject.getInt("HWMiniSupportAPI");
                  if (Build.VERSION.SDK_INT >= n) {
                    break;
                  }
                }
                return false;
              }
              n += 1;
            }
          }
        }
      }
    }
    return true;
  }
  
  private void b(JSONObject paramJSONObject, c.a parama)
  {
    if (paramJSONObject.has("TraeConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("TraeConfig");
      if (paramJSONObject.has("InfoList"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("InfoList");
        int n = 0;
        while (n < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(n);
          if ((localJSONObject != null) && (localJSONObject.getString("MachineType").equals(Build.MODEL)))
          {
            c.a.b(parama, localJSONObject.getString("ConfigValue"));
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("parseTRAEConfig get TRAE config: ");
            paramJSONObject.append(c.a.a(parama));
            TXCLog.d("CloudConfig", paramJSONObject.toString());
            return;
          }
          n += 1;
        }
      }
    }
  }
  
  private boolean b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (c.a.q(this.j) != null))
    {
      paramString = c.a.q(this.j).optJSONObject(paramString);
      if (paramString != null) {
        try
        {
          boolean bool = b(paramString);
          return bool;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return true;
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("HEVCConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("HEVCConfig");
      if ((paramJSONObject != null) && (paramJSONObject.has("Encoder")))
      {
        paramJSONObject = paramJSONObject.optJSONObject("Encoder");
        if ((paramJSONObject != null) && (paramJSONObject.has("BlackConfig")))
        {
          paramJSONObject = paramJSONObject.getJSONObject("BlackConfig");
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.getJSONArray("InfoList");
            int n = 0;
            while (n < paramJSONObject.length())
            {
              JSONObject localJSONObject = paramJSONObject.getJSONObject(n);
              if ((localJSONObject.has("Manufacture")) && (localJSONObject.has("Model")) && (localJSONObject.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER)) && (localJSONObject.getString("Model").equalsIgnoreCase(Build.MODEL)))
              {
                if (localJSONObject.has("HWMiniSupportAPI"))
                {
                  n = localJSONObject.getInt("HWMiniSupportAPI");
                  if (Build.VERSION.SDK_INT >= n) {
                    break;
                  }
                }
                return false;
              }
              n += 1;
            }
          }
        }
      }
    }
    return true;
  }
  
  private c.a c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject = new c.a(null);
    try
    {
      f(paramJSONObject, (c.a)localObject);
      e(paramJSONObject, (c.a)localObject);
      d(paramJSONObject, (c.a)localObject);
      a(paramJSONObject, (c.a)localObject);
      b(paramJSONObject, (c.a)localObject);
      c(paramJSONObject, (c.a)localObject);
      g(paramJSONObject, (c.a)localObject);
      i(paramJSONObject, (c.a)localObject);
      h(paramJSONObject, (c.a)localObject);
      this.k.a(paramJSONObject.optJSONArray("compatible_config"));
      return localObject;
    }
    catch (JSONException paramJSONObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse config catch exception ");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      TXCLog.w("CloudConfig", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private void c(JSONObject paramJSONObject, c.a parama)
  {
    if (paramJSONObject.has("WeiXinConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("WeiXinConfig");
      if (paramJSONObject.has("InfoList"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("InfoList");
        int n = 0;
        while (n < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(n);
          if (localJSONObject != null)
          {
            String str1 = localJSONObject.getString("Manufacture");
            String str2 = localJSONObject.getString("Model");
            if ((str1.equals(Build.MANUFACTURER)) && (str2.equals(Build.MODEL)))
            {
              c.a.d(parama, Integer.parseInt(localJSONObject.getString("SampleRate")));
              paramJSONObject = new StringBuilder();
              paramJSONObject.append("parseWeiXinConfig get WeiXin config: record sample rate = ");
              paramJSONObject.append(c.a.o(parama));
              TXCLog.d("CloudConfig", paramJSONObject.toString());
              return;
            }
          }
          n += 1;
        }
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      this.h = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (c.a.q(this.j) != null))
    {
      paramString = c.a.q(this.j).optJSONObject(paramString);
      if (paramString != null) {
        try
        {
          boolean bool = a(paramString);
          return bool;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return true;
  }
  
  private void d(String paramString)
  {
    c(false);
    try
    {
      paramString = new JSONObject(paramString);
      int n = 1;
      if (paramString.has("UpdateFrequency")) {
        n = paramString.getInt("UpdateFrequency");
      }
      a(n);
      paramString = c(paramString);
      if (paramString != null)
      {
        this.j = paramString;
        a(paramString, this.k.a());
        return;
      }
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseRespon catch ecxeption");
      localStringBuilder.append(paramString);
      TXCLog.w("CloudConfig", localStringBuilder.toString());
    }
  }
  
  private void d(JSONObject paramJSONObject, c.a parama)
  {
    c.a.e(parama, 60);
    c.a.f(parama, 70);
    c.a.g(parama, 80);
    c.a.h(parama, 50);
    c.a.i(parama, 10);
    if (paramJSONObject.has("HWWhiteList"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("HWWhiteList");
      if (paramJSONObject.has("SWToHWThreshold"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("SWToHWThreshold");
        StringBuilder localStringBuilder;
        if (paramJSONObject.has("CPU"))
        {
          c.a.e(parama, paramJSONObject.getInt("CPU"));
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parseAutoSWHWConfig get SWToHWThreshold.CPU:");
          localStringBuilder.append(c.a.i(parama));
          TXCLog.d("CloudConfig", localStringBuilder.toString());
        }
        if (paramJSONObject.has("FPS"))
        {
          c.a.f(parama, paramJSONObject.getInt("FPS"));
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parseAutoSWHWConfig get SWToHWThreshold.FPS:");
          localStringBuilder.append(c.a.j(parama));
          TXCLog.d("CloudConfig", localStringBuilder.toString());
        }
        if (paramJSONObject.has("CPU_MAX"))
        {
          c.a.g(parama, paramJSONObject.getInt("CPU_MAX"));
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parseAutoSWHWConfig get SWToHWThreshold.CPU:");
          localStringBuilder.append(c.a.g(parama));
          TXCLog.d("CloudConfig", localStringBuilder.toString());
        }
        if (paramJSONObject.has("FPS_MIN"))
        {
          c.a.h(parama, paramJSONObject.getInt("FPS_MIN"));
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parseAutoSWHWConfig get SWToHWThreshold.FPS:");
          localStringBuilder.append(c.a.h(parama));
          TXCLog.d("CloudConfig", localStringBuilder.toString());
        }
        if (paramJSONObject.has("CheckCount"))
        {
          c.a.i(parama, paramJSONObject.getInt("CheckCount"));
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("parseAutoSWHWConfig get SWToHWThreshold.CheckCount:");
          paramJSONObject.append(c.a.f(parama));
          TXCLog.d("CloudConfig", paramJSONObject.toString());
        }
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    try
    {
      this.i = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void e(JSONObject paramJSONObject, c.a parama)
  {
    if (paramJSONObject.has("ExposureWhiteConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("ExposureWhiteConfig").getJSONArray("InfoList");
      int n = 0;
      while (n < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(n);
        if ((localJSONObject.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER)) && (localJSONObject.getString("Model").equalsIgnoreCase(Build.MODEL)))
        {
          c.a.j(parama, localJSONObject.getInt("ExposureCompensation"));
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("parseExposureConfig get exposure config: ");
          paramJSONObject.append(c.a.c(parama));
          TXCLog.d("CloudConfig", paramJSONObject.toString());
          break;
        }
        n += 1;
      }
      if (g != null)
      {
        paramJSONObject = new Intent("com.tencent.liteav.basic.serverconfig.get");
        g.sendBroadcast(paramJSONObject);
      }
    }
  }
  
  private void f(JSONObject paramJSONObject, c.a parama)
  {
    if (paramJSONObject.has("HWBlackConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("HWBlackConfig");
      int n = 16;
      if (paramJSONObject.has("HWMiniSupportAPI")) {
        n = paramJSONObject.getInt("HWMiniSupportAPI");
      }
      if (Build.VERSION.SDK_INT < n)
      {
        c.a.k(parama, 0);
        return;
      }
      paramJSONObject = paramJSONObject.getJSONArray("InfoList");
      n = 0;
      while (n < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(n);
        if ((localJSONObject.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER)) && (localJSONObject.getString("Model").equalsIgnoreCase(Build.MODEL)))
        {
          if (localJSONObject.has("profile"))
          {
            c.a.k(parama, 1);
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("parseHWBlackConfig get HWBlack config: ");
            paramJSONObject.append(c.a.b(parama));
            TXCLog.d("CloudConfig", paramJSONObject.toString());
            return;
          }
          c.a.k(parama, 0);
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("parseHWBlackConfig get HWBlack config: ");
          paramJSONObject.append(c.a.b(parama));
          TXCLog.d("CloudConfig", paramJSONObject.toString());
          return;
        }
        n += 1;
      }
    }
  }
  
  private void g(JSONObject paramJSONObject, c.a parama)
  {
    if (paramJSONObject.has("UGCSWMuxerConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("UGCSWMuxerConfig").getJSONArray("InfoList");
      int n = 0;
      while (n < paramJSONObject.length())
      {
        if (paramJSONObject.getJSONObject(n).getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER))
        {
          c.a.l(parama, 1);
          return;
        }
        n += 1;
      }
    }
  }
  
  private void h(JSONObject paramJSONObject, c.a parama)
  {
    if (paramJSONObject.has("UGCConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("UGCConfig");
      if (paramJSONObject != null)
      {
        if ((paramJSONObject.has("PreGenerateALLSW")) && (paramJSONObject.getInt("PreGenerateALLSW") == 1))
        {
          c.a.m(parama, 1);
          return;
        }
        if (paramJSONObject.has("PreGenerateSW"))
        {
          paramJSONObject = paramJSONObject.getJSONObject("PreGenerateSW");
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.getJSONArray("InfoList");
            int n = 0;
            while (n < paramJSONObject.length())
            {
              JSONObject localJSONObject = paramJSONObject.getJSONObject(n);
              if ((localJSONObject.has("Manufacture")) && (localJSONObject.has("Model")) && (localJSONObject.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER)) && (localJSONObject.getString("Model").equalsIgnoreCase(Build.MODEL)))
              {
                c.a.m(parama, 1);
                return;
              }
              n += 1;
            }
          }
        }
      }
    }
  }
  
  private void i(JSONObject paramJSONObject, c.a parama)
  {
    if (paramJSONObject.has("AppIDConfig"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("AppIDConfig");
      if (paramJSONObject != null)
      {
        c.a.a(parama, paramJSONObject);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parse global config : ");
        paramJSONObject.append(c.a.q(parama));
        TXCLog.w("CloudConfig", paramJSONObject.toString());
      }
    }
  }
  
  private void n()
  {
    o();
    l();
  }
  
  private void o()
  {
    try
    {
      if (q())
      {
        d(true);
        if (!s()) {
          t();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load config(system aec):");
        localStringBuilder.append(c.a.l(this.j));
        localStringBuilder.append(",");
        localStringBuilder.append(c.a.m(this.j));
        localStringBuilder.append(",");
        localStringBuilder.append(c.a.p(this.j));
        localStringBuilder.append(",");
        localStringBuilder.append(c.a.k(this.j));
        localStringBuilder.append(", model = ");
        localStringBuilder.append(Build.MODEL);
        localStringBuilder.append(", manufacturer = ");
        localStringBuilder.append(Build.MANUFACTURER);
        localStringBuilder.append("， board = ");
        localStringBuilder.append(Build.BOARD);
        TXCLog.i("CloudConfig", localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  private boolean p()
  {
    try
    {
      if (!this.h)
      {
        long l1 = this.e;
        long l2 = System.currentTimeMillis();
        if (l1 <= l2) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean q()
  {
    try
    {
      boolean bool = this.i;
      return !bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void r()
  {
    try
    {
      TXCLog.w("CloudConfig", "update server config ");
      Object localObject1 = (HttpURLConnection)new URL("http://dldir1.qq.com/hudongzhibo/liteavsvrcfg/serverconfig_en.zip").openConnection();
      if (!this.d.isEmpty()) {
        ((HttpURLConnection)localObject1).addRequestProperty("If-Modified-Since", this.d);
      }
      localObject4 = ((HttpURLConnection)localObject1).getHeaderField("Last-Modified");
      int n = ((HttpURLConnection)localObject1).getResponseCode();
      if (n == 200)
      {
        if ((localObject4 != null) && (!((String)localObject4).isEmpty()))
        {
          this.d = ((String)localObject4);
          if (this.c != null) {
            this.c.putString("last_modify", this.d);
          }
        }
        localObject4 = ((HttpURLConnection)localObject1).getInputStream();
        Object localObject5 = new byte[1024];
        localObject1 = new ByteArrayOutputStream();
        for (;;)
        {
          n = ((InputStream)localObject4).read((byte[])localObject5);
          if (n == -1) {
            break;
          }
          ((ByteArrayOutputStream)localObject1).write((byte[])localObject5, 0, n);
        }
        localObject4 = a.a(Base64.decode(TXCCommonUtil.getConfigCenterKey().getBytes("UTF-8"), 2));
        localObject4 = a.a(((ByteArrayOutputStream)localObject1).toByteArray(), (PrivateKey)localObject4);
        localObject1 = null;
        try
        {
          if (!TextUtils.isEmpty(this.a))
          {
            localObject1 = new File(this.a, "serverconfig_dec.zip");
            localObject5 = new FileOutputStream((File)localObject1);
            ((FileOutputStream)localObject5).write((byte[])localObject4);
            ((FileOutputStream)localObject5).close();
          }
          d(a((File)localObject1));
          return;
        }
        finally {}
      }
      if (n == 304)
      {
        a(1);
        Object localObject3 = g;
        if (localObject3 != null)
        {
          localObject3 = ((Context)localObject3).getSharedPreferences("cloud_config", 0);
          if (localObject3 != null)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("updateInternal: return 304(code), update expiredTime into file. expiredTime=");
            ((StringBuilder)localObject4).append(this.e);
            TXCLog.i("CloudConfig", ((StringBuilder)localObject4).toString());
            ((SharedPreferences)localObject3).edit().putLong("expired_time", this.e).commit();
          }
        }
        c(false);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("fetch config Not-Modified-Since ");
        ((StringBuilder)localObject3).append(this.d);
        if (((StringBuilder)localObject3).toString() == null) {
          localObject3 = "";
        } else {
          localObject3 = this.d;
        }
        TXCLog.d("CloudConfig", (String)localObject3);
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("fetch config catch exception ");
      ((StringBuilder)localObject4).append(localException);
      TXCLog.e("CloudConfig", ((StringBuilder)localObject4).toString());
      c(false);
    }
  }
  
  private boolean s()
  {
    Object localObject1 = g;
    if (localObject1 == null) {
      return false;
    }
    this.b = ((Context)localObject1).getSharedPreferences("cloud_config", 0);
    localObject1 = this.b;
    if ((localObject1 != null) && (((SharedPreferences)localObject1).contains("expired_time")))
    {
      TXCLog.w("CloudConfig", "loadLocalFileConfig ");
      this.c = this.b.edit();
      try
      {
        this.d = this.b.getString("last_modify", "");
        this.e = this.b.getLong("expired_time", System.currentTimeMillis());
        c.a.k(this.j, this.b.getInt("hw_config", 2));
        c.a.j(this.j, this.b.getInt("ExposureCompensation", 0));
        c.a.l(this.j, this.b.getInt("UGCSWMuxerConfig", 0));
        c.a.e(this.j, this.b.getInt("CPU", 60));
        c.a.f(this.j, this.b.getInt("FPS", 70));
        c.a.g(this.j, this.b.getInt("CPU_MAX", 80));
        c.a.h(this.j, this.b.getInt("FPS_MIN", 50));
        c.a.i(this.j, this.b.getInt("CheckCount", 10));
        c.a.b(this.j, this.b.getString("trae_config", ""));
        c.a.m(this.j, this.b.getInt("PreGenerateSW", 1));
        localObject1 = this.b.getString("system_aec_config", "");
        localObject2 = this.b.getString("AppIDConfig", "");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          c.a.a(this.j, new JSONObject((String)localObject2));
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("system aec config:");
        ((StringBuilder)localObject2).append((String)localObject1);
        TXCLog.i("CloudConfig", ((StringBuilder)localObject2).toString());
        if (!((String)localObject1).isEmpty())
        {
          localObject1 = ((String)localObject1).split(",");
          if ((localObject1 != null) && (localObject1.length >= 5))
          {
            c.a.a(this.j, Integer.valueOf(localObject1[0]).intValue());
            c.a.b(this.j, Integer.valueOf(localObject1[1]).intValue());
            localObject2 = localObject1[2].split("\\|");
            if (localObject2 != null)
            {
              c.a.a(this.j, new int[localObject2.length]);
              int n = 0;
              while (n < localObject2.length)
              {
                c.a.n(this.j)[n] = Integer.valueOf(localObject2[n].trim()).intValue();
                n += 1;
              }
            }
            c.a.c(this.j, Integer.valueOf(localObject1[3]).intValue());
            c.a.a(this.j, localObject1[4]);
          }
        }
        this.k.a(this.b.getString("compatible_config", null));
        return true;
      }
      catch (Exception localException)
      {
        this.c.clear();
        this.c.commit();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadLocalFileConfig catch exception ");
        ((StringBuilder)localObject2).append(localException);
        TXCLog.d("CloudConfig", ((StringBuilder)localObject2).toString());
      }
    }
    return false;
  }
  
  private void t()
  {
    try
    {
      TXCLog.w("CloudConfig", "loadDefaultConfig ");
      c.a locala = c(new JSONObject("{\n    \"version\": 3,\n    \"UpdateFrequency\": 1,\n    \"AppIDConfig\": {\n        \"Global\": {\n            \"DataReport\": {\n                \"UserPortrait\":0\n            },\n            \"DNSWhiteList\": {\n              \"InfoList\": [\n                \"qq\",\n                \"tencent\"\n              ]\n            },\n            \"Audio\": {\n                \"RTC_JitterCycle\":240,\n                \"LIVE_JitterCycle\":500,\n                \"LoadingThreshold\":800,\n                \"SmoothModeAdjust\":0,\n                \"SmoothAdjust\":10,\n                \"RtcPlayHungryTimeThreshold\":60,\n                \"BlockThreshold\": 100,\n                \"SmoothSpeed\":1.2\n            },\n            \"Network\": {\n                \"EnableRouteOptimize\":0,\n                \"RouteSamplingMaxCount\":10,\n                \"QualityDataCacheCount\":0,\n                \"NACKRetryCnt\": 8,\n                \"AccRetryCountWithoutSecret\":1\n            },\n            \"QUICMode\": {\n                \"Live\":2,\n                \"LinkMain\":2,\n                \"LinkSub\":2,\n                \"RTC\":2,\n                \"AVRoom\":0\n            },\n            \"ILiveRoom\": {\n               \"Live_FecRatioAudio\":0,\n               \"Live_FecRatioVideoI\":0,\n               \"Live_FecRatioVideoP\":0,\n               \"Chat_FecRatioAudio\":0,\n               \"Chat_FecRatioVideoI\":0,\n               \"Chat_FecRatioVideoP\":0,\n               \"Rtc_MinCacheTime\":300,\n               \"Rtc_MaxCacheTime\":1000,\n               \"MinCacheTime\":700,\n               \"MaxCacheTime\":2000\n           },\n           \"Video\": {\n               \"CheckVideoEncDownBps\":1\n           }\n       },\n       \"1252463788\":{\n            \"Network\": {\n                \"EnableRouteOptimize\":1,\n                \"RouteSamplingMaxCount\":100,\n                \"QualityDataCacheCount\":10\n            }\n       }\n    },\n    \"PlayModeConfig\":{\n        \"SmoothModeOffset\":300\n    },\n    \"UGCSWMuxerConfig\": {\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"HUAWEI\"\n            }\n        ]\n    },\n    \"UGCConfig\": {\n        \"PreGenerateALLSW\":0,\n        \"PreGenerateSW\": {\n                \"InfoList\": [\n                    {\n                        \"Manufacture\": \"OPPO\",\n                        \"Model\": \"OPPO A57\"\n                    }\n                ]\n            }\n         },\n    \"HWBlackConfig\": {\n        \"HWMiniSupportAPI\": 17,\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"P6-U06\"\n            },\n            {\n                \"Manufacture\": \"Samsung\",\n                \"Model\": \"SCH-I939(S3)\"\n            },\n            {\n                \"Manufacture\": \"VIVO\",\n                \"Model\": \"vivo X5Pro D\"\n            },\n            {\n                \"Manufacture\": \"金立\",\n                \"Model\": \"GN9006\"\n            },\n            {\n                \"Manufacture\": \"Samsung\",\n                \"Model\": \"A7000\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"HUAWEI NXT-AL10\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"HUAWEI MHA-AL00\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"EVA-AL00\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"EVA-AL10\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-L29\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-L00\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-TL00\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n             {\n                 \"Manufacture\": \"HUAWEI\",\n                 \"Model\": \"HUAWEI GRA-UL00\"\n             }\n        ]\n    },\n    \"ExposureWhiteConfig\": {\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"Meizu\",\n                \"Model\": \"MX4 Pro\",\n                \"ExposureCompensation\": 1\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"Model\": \"MI 3\",\n                \"ExposureCompensation\": 30\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"Model\": \"MI 3C\",\n                \"ExposureCompensation\": 30\n            }\n        ]\n    },\n    \"SystemAECConfig\": {\n        \"__comment__\":\"SceneType(开启系统aec的场景，1为连麦，2为通话)\",\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"vivo\",\n                \"WhiteList\": [{\"Model\":\"vivo X9\"}],\n                \"BlackList\": [],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"vivo\",\n                \"WhiteList\": [{\"Model\":\"vivo X9Plus\"},{\"Model\":\"vivo X7Plus\"},{\"Model\":\"vivo X7\"}],\n                \"BlackList\": [{\"Model\":\"vivo Y51A\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"WhiteList\": [{\"Model\":\"VTR-TL00\"},{\"Model\":\"HUAWEI GRA-UL00\"},{\"Model\":\"HUAWEI NXT-AL10\"},{\"Model\":\"PLK-AL10\"},{\"Model\":\"PLK-UL00\"},{\"Model\":\"EVA-AL10\"},{\"Model\":\"HUAWEI MT7-TL10\"}],\n                \"BlackList\": [{\"Model\":\"MHA-AL00\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"Redmi Note 2\"},{\"Model\":\"Redmi Note 4\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"Redmi Note 3\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"MI 4\"},{\"Model\":\"MI 3C\"},{\"Model\":\"Mi-4c\"}],\n                \"BlackList\": [{\"Model\":\"MI 6\"},{\"Model\":\"Redmi 4A\"},{\"Model\":\"MI 5X\"},{\"Model\":\"MI 5\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Google\",\n                \"WhiteList\": [{\"Model\":\"Pixel XL\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"samsung\",\n                \"WhiteList\": [{\"Model\":\"SM-G9350\"},{\"Model\":\"SM-G9500\"},{\"Model\":\"SM-G950U\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                 \"Manufacture\": \"LeMobile\",\n                 \"WhiteList\": [{\"Model\":\"X620\"}],\n                 \"SystemAEC\": 1,\n                 \"AGC\": 0,\n                 \"SampleRate\": \"48000|16000\",\n                 \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n             {\n                  \"Manufacture\": \"asus\",\n                  \"WhiteList\": [{\"Model\":\"ASUS_Z00ADB\"}],\n                  \"SystemAEC\": 1,\n                  \"AGC\": 0,\n                  \"SampleRate\": \"48000|16000\",\n                  \"HWAACCodec\": 1,\n                 \"SceneType\": \"1|2\"\n             }\n        ]\n    },\n    \"WeiXinConfig\": {\n        \"InfoList\":[\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"EVA-AL00\",\n                \"SampleRate\": \"16000\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"ALP-AL00\",\n                \"SampleRate\": \"16000\"\n            }\n        ]\n    },\n    \"HWWhiteList\": {\n        \"SWToHWThreshold\": {\n            \"CPU_MAX\": 80,\n            \"FPS_MIN\": 50,\n            \"CPU\": 20,\n            \"FPS\": 70,\n            \"CheckCount\": 10,\n            \"__comment__\": \"软编根据性能切硬编的阈值，avgTotalCPU >= CPU_MAX || avgFPS <= FPS_MIN || (avgAppCPU >= CPU && avgFPS <= FPS) 性能指标满足上述条件则切硬编。CheckCount表示需要做X次有效性能数据采集。\"\n\t\t}\n    },\n    \"TraeConfig\": {\n        \"InfoList\": [\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 90,\n            \"MachineType\": \"MI 4W\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 94,\n            \"MachineType\": \"MI 5\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 96,\n            \"MachineType\": \"PLK-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 97,\n            \"MachineType\": \"SM-G9350\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 98,\n            \"MachineType\": \"MX4 Pro\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 99,\n            \"MachineType\": \"A31\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 118,\n            \"MachineType\": \"MI 4LTE\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 132,\n            \"MachineType\": \"OPPO R9tm\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 156,\n            \"MachineType\": \"Mi-4c\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 166,\n            \"MachineType\": \"OPPO A33\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 174,\n            \"MachineType\": \"OPPO A33m\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 191,\n            \"MachineType\": \"m1\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 213,\n            \"MachineType\": \"vivo X6Plus D\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 226,\n            \"MachineType\": \"vivo X5Pro V\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 251,\n            \"MachineType\": \"vivo X5pro L\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 256,\n            \"MachineType\": \"EVA-DL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 257,\n            \"MachineType\": \"EVA-TL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 260,\n            \"MachineType\": \"EVA-CL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 270,\n            \"MachineType\": \"EVA-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 307,\n            \"MachineType\": \"SM-N9108V\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 500,\n            \"MachineType\": \"MI 5s Plus\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"PRO 7-H\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 989,\n            \"MachineType\": \"M10\"\n          },\n          {\n            \"Factory\": \"GiONEE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 388,\n            \"MachineType\": \"F103\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 394,\n            \"MachineType\": \"OPPO A33t\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 400,\n            \"MachineType\": \"OPPO R7\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 401,\n            \"MachineType\": \"OPPO R9m\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 406,\n            \"MachineType\": \"HUAWEI MT7-CL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 407,\n            \"MachineType\": \"HUAWEI MT7-TL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 421,\n            \"MachineType\": \"HUAWEI NXT-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 473,\n            \"MachineType\": \"SM-N9200\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 481,\n            \"MachineType\": \"MI 4C\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 485,\n            \"MachineType\": \"Redmi Note 3\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 518,\n            \"MachineType\": \"DOOV L5M\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 530,\n            \"MachineType\": \"MI 3\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 554,\n            \"MachineType\": \"MX6\"\n          },\n          {\n            \"Factory\": \"LENOVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1041,\n            \"MachineType\": \"Lenovo K900\"\n          },\n          {\n            \"Factory\": \"M5\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 985,\n            \"MachineType\": \"X5 R1\"\n          },\n          {\n            \"Factory\": \"ZTE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 983,\n            \"MachineType\": \"ZTE N928Dt\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 426\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 778,\n            \"MachineType\": \"OPPO R9s\"\n          },\n          {\n            \"Factory\": \"JTY\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 986,\n            \"MachineType\": \"KT096H\"\n          },\n          {\n            \"Factory\": \"TCL\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 984,\n            \"MachineType\": \"TCL P501M\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1050,\n            \"MachineType\": \"STF-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 857,\n            \"MachineType\": \"EVA-AL00\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 798,\n            \"MachineType\": \"OPPO R9km\"\n          },\n          {\n            \"Factory\": \"Haier\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 990,\n            \"MachineType\": \"HT-L700T\"\n          },\n          {\n            \"Factory\": \"Lenovo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 988,\n            \"MachineType\": \"Lenovo A916\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nplay {\\r\\nhw_sr 44100\\r\\nhw_ch 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 998,\n            \"MachineType\": \"em_ts809_p3mme\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 372\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 999,\n            \"MachineType\": \"vivo X5Pro D\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 858,\n            \"MachineType\": \"OPPO A59s\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 884,\n            \"MachineType\": \"Nexus 5\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 971,\n            \"MachineType\": \"Nexus 5X\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\nhevc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\nhevc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 975,\n            \"MachineType\": \"MI 6\"\n          },\n          {\n            \"Factory\": \"koobee\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 20.0\\r\\npreAGCvvolmax 30.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 991,\n            \"MachineType\": \"koobee M9 Plus\"\n          },\n          {\n            \"Factory\": \"\\u8054\\u60f3\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 992,\n            \"MachineType\": \"S6000\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1045,\n            \"MachineType\": \"DOOV L5\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"PRO 7 Plus\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -12.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"vivo Xplay6\"\n          },\n          {\n            \"Factory\": \"HTC\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1047,\n            \"MachineType\": \"HTC S720e\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1049,\n            \"MachineType\": \"A33w\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1051,\n            \"MachineType\": \"STF-AL10\"\n          },\n          {\n            \"Factory\": \"unknown\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1073,\n            \"MachineType\": \"msm8909\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1074,\n            \"MachineType\": \"OPPO A57\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"OPPO R11s\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1076,\n            \"MachineType\": \"OPPO R11\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1077,\n            \"MachineType\": \"OPPO A83\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"OPPO A73\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"SM-G9006V\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1081,\n            \"MachineType\": \"vivo Y83A\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1083,\n            \"MachineType\": \"OPPO R17\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1084,\n            \"MachineType\": \"OPPO R15\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1085,\n            \"MachineType\": \"OPPO A37M\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1086,\n            \"MachineType\": \"OPPO A7X\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1087,\n            \"MachineType\": \"OPPO A3\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1088,\n            \"MachineType\": \"OPPO A5\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1089,\n            \"MachineType\": \"OPPO A83T\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1090,\n            \"MachineType\": \"OPPO R11T\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1091,\n            \"MachineType\": \"OPPO R9S PLUS\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1092,\n            \"MachineType\": \"vivo Y51A\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1093,\n            \"MachineType\": \"vivo V1813A\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1095,\n            \"MachineType\": \"vivo Y67\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1097,\n            \"MachineType\": \"MHA-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1098,\n            \"MachineType\": \"ALP-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1099,\n            \"MachineType\": \"VTR-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1100,\n            \"MachineType\": \"BND-AL10\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1101,\n            \"MachineType\": \"COL-AL10\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1102,\n            \"MachineType\": \"BKL-AL20\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1103,\n            \"MachineType\": \"PRA-AL00X\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1104,\n            \"MachineType\": \"MI 6X\"\n          }\n        ]\n    }\n}\n"));
      if (locala != null)
      {
        this.j = locala;
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadDefaultConfig catch exception ");
      localStringBuilder.append(localJSONException);
      TXCLog.w("CloudConfig", localStringBuilder.toString());
      this.j = new c.a(null);
    }
  }
  
  public long a(String paramString1, String paramString2)
  {
    n();
    long l2 = a(TXCCommonUtil.getAppID(), paramString1, paramString2);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = a("Global", paramString1, paramString2);
    }
    return l1;
  }
  
  public void a(Context paramContext)
  {
    if (g == null)
    {
      g = paramContext.getApplicationContext();
      paramContext = g.getExternalFilesDir(null);
      if (paramContext != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getAbsolutePath());
        localStringBuilder.append("/txrtmp/");
        this.a = localStringBuilder.toString();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Context localContext = g;
    try
    {
      synchronized (this.m)
      {
        if ((this.l == null) && (localContext != null)) {
          this.l = localContext.getSharedPreferences("liteav_hw_encoder_config", 0);
        }
        this.l.edit().putBoolean("enable_high_profile", paramBoolean).commit();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("CloudConfig", "enableHWHighProfile: error.", localException);
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    n();
    return (paramFloat2 >= c.a.g(this.j)) || (paramFloat3 <= c.a.h(this.j)) || ((paramFloat1 >= c.a.i(this.j)) && (paramFloat3 <= c.a.j(this.j)));
  }
  
  public boolean a(String paramString)
  {
    n();
    if (c.a.q(this.j) != null)
    {
      Object localObject = c.a.q(this.j).optJSONObject("Global");
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optJSONObject("DNSWhiteList");
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optJSONArray("InfoList");
          if (localObject != null)
          {
            int n = 0;
            while (n < ((JSONArray)localObject).length()) {
              try
              {
                boolean bool = paramString.contains(((JSONArray)localObject).getString(n));
                if (bool) {
                  return true;
                }
              }
              catch (Exception localException)
              {
                TXCLog.e("CloudConfig", "get string from json failed.", localException);
                n += 1;
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public b b()
  {
    return a().k;
  }
  
  public void b(boolean paramBoolean)
  {
    Context localContext = g;
    try
    {
      synchronized (this.m)
      {
        if ((this.l == null) && (localContext != null)) {
          this.l = localContext.getSharedPreferences("liteav_hw_encoder_config", 0);
        }
        this.l.edit().putBoolean("enable_hw_hevc_encode", paramBoolean).commit();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("CloudConfig", "enableHWHevcEncode: error.", localException);
    }
  }
  
  public String c()
  {
    n();
    if (c.a.a(this.j).isEmpty()) {
      a("{\n        \"InfoList\": [\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 90,\n            \"MachineType\": \"MI 4W\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 94,\n            \"MachineType\": \"MI 5\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 96,\n            \"MachineType\": \"PLK-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 97,\n            \"MachineType\": \"SM-G9350\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 98,\n            \"MachineType\": \"MX4 Pro\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 99,\n            \"MachineType\": \"A31\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 118,\n            \"MachineType\": \"MI 4LTE\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 132,\n            \"MachineType\": \"OPPO R9tm\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 156,\n            \"MachineType\": \"Mi-4c\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 166,\n            \"MachineType\": \"OPPO A33\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 174,\n            \"MachineType\": \"OPPO A33m\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 191,\n            \"MachineType\": \"m1\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 213,\n            \"MachineType\": \"vivo X6Plus D\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 226,\n            \"MachineType\": \"vivo X5Pro V\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 251,\n            \"MachineType\": \"vivo X5pro L\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 256,\n            \"MachineType\": \"EVA-DL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 257,\n            \"MachineType\": \"EVA-TL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 260,\n            \"MachineType\": \"EVA-CL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 270,\n            \"MachineType\": \"EVA-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 307,\n            \"MachineType\": \"SM-N9108V\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 500,\n            \"MachineType\": \"MI 5s Plus\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"PRO 7-H\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 989,\n            \"MachineType\": \"M10\"\n          },\n          {\n            \"Factory\": \"GiONEE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 388,\n            \"MachineType\": \"F103\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 394,\n            \"MachineType\": \"OPPO A33t\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 400,\n            \"MachineType\": \"OPPO R7\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 401,\n            \"MachineType\": \"OPPO R9m\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 406,\n            \"MachineType\": \"HUAWEI MT7-CL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 407,\n            \"MachineType\": \"HUAWEI MT7-TL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 421,\n            \"MachineType\": \"HUAWEI NXT-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 473,\n            \"MachineType\": \"SM-N9200\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 481,\n            \"MachineType\": \"MI 4C\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 485,\n            \"MachineType\": \"Redmi Note 3\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 518,\n            \"MachineType\": \"DOOV L5M\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 530,\n            \"MachineType\": \"MI 3\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 554,\n            \"MachineType\": \"MX6\"\n          },\n          {\n            \"Factory\": \"LENOVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1041,\n            \"MachineType\": \"Lenovo K900\"\n          },\n          {\n            \"Factory\": \"M5\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 985,\n            \"MachineType\": \"X5 R1\"\n          },\n          {\n            \"Factory\": \"ZTE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 983,\n            \"MachineType\": \"ZTE N928Dt\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 426\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 778,\n            \"MachineType\": \"OPPO R9s\"\n          },\n          {\n            \"Factory\": \"JTY\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 986,\n            \"MachineType\": \"KT096H\"\n          },\n          {\n            \"Factory\": \"TCL\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 984,\n            \"MachineType\": \"TCL P501M\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1050,\n            \"MachineType\": \"STF-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 857,\n            \"MachineType\": \"EVA-AL00\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 798,\n            \"MachineType\": \"OPPO R9km\"\n          },\n          {\n            \"Factory\": \"Haier\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 990,\n            \"MachineType\": \"HT-L700T\"\n          },\n          {\n            \"Factory\": \"Lenovo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 988,\n            \"MachineType\": \"Lenovo A916\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nplay {\\r\\nhw_sr 44100\\r\\nhw_ch 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 998,\n            \"MachineType\": \"em_ts809_p3mme\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 372\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 999,\n            \"MachineType\": \"vivo X5Pro D\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 858,\n            \"MachineType\": \"OPPO A59s\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 884,\n            \"MachineType\": \"Nexus 5\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 971,\n            \"MachineType\": \"Nexus 5X\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\nhevc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\nhevc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 975,\n            \"MachineType\": \"MI 6\"\n          },\n          {\n            \"Factory\": \"koobee\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 20.0\\r\\npreAGCvvolmax 30.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 991,\n            \"MachineType\": \"koobee M9 Plus\"\n          },\n          {\n            \"Factory\": \"\\u8054\\u60f3\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 992,\n            \"MachineType\": \"S6000\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1045,\n            \"MachineType\": \"DOOV L5\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"PRO 7 Plus\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -12.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"vivo Xplay6\"\n          },\n          {\n            \"Factory\": \"HTC\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1047,\n            \"MachineType\": \"HTC S720e\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1049,\n            \"MachineType\": \"A33w\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1051,\n            \"MachineType\": \"STF-AL10\"\n          },\n          {\n            \"Factory\": \"unknown\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1073,\n            \"MachineType\": \"msm8909\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1074,\n            \"MachineType\": \"OPPO A57\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"OPPO R11s\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1076,\n            \"MachineType\": \"OPPO R11\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1077,\n            \"MachineType\": \"OPPO A83\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"OPPO A73\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"SM-G9006V\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1081,\n            \"MachineType\": \"vivo Y83A\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1083,\n            \"MachineType\": \"OPPO R17\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1084,\n            \"MachineType\": \"OPPO R15\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1085,\n            \"MachineType\": \"OPPO A37M\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1086,\n            \"MachineType\": \"OPPO A7X\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1087,\n            \"MachineType\": \"OPPO A3\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1088,\n            \"MachineType\": \"OPPO A5\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1089,\n            \"MachineType\": \"OPPO A83T\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1090,\n            \"MachineType\": \"OPPO R11T\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1091,\n            \"MachineType\": \"OPPO R9S PLUS\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1092,\n            \"MachineType\": \"vivo Y51A\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1093,\n            \"MachineType\": \"vivo V1813A\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1095,\n            \"MachineType\": \"vivo Y67\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1097,\n            \"MachineType\": \"MHA-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1098,\n            \"MachineType\": \"ALP-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1099,\n            \"MachineType\": \"VTR-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1100,\n            \"MachineType\": \"BND-AL10\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1101,\n            \"MachineType\": \"COL-AL10\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1102,\n            \"MachineType\": \"BKL-AL20\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1103,\n            \"MachineType\": \"PRA-AL00X\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1104,\n            \"MachineType\": \"MI 6X\"\n          }\n        ]    }", this.j);
    }
    return c.a.a(this.j);
  }
  
  public int d()
  {
    n();
    return c.a.b(this.j);
  }
  
  public int e()
  {
    n();
    return c.a.c(this.j);
  }
  
  public int f()
  {
    n();
    return c.a.d(this.j);
  }
  
  public int g()
  {
    n();
    return c.a.f(this.j);
  }
  
  public boolean h()
  {
    long l2 = a("Audio", "UseLowLatencySampleRate");
    TXCLog.i("CloudConfig", "defaultValueOfUseLowLatencySampleRate: %d", new Object[] { Long.valueOf(l2) });
    long l1 = l2;
    if (l2 == -1L) {
      l1 = 0L;
    }
    return 1L == b().a(".audio.use_low_latency_samplerate", l1);
  }
  
  public long i()
  {
    long l1 = a("Audio", "LowLatencySampleRateBlockTime");
    if (l1 == -1L) {
      return TimeUnit.DAYS.toMillis(7L);
    }
    return TimeUnit.SECONDS.toMillis(l1);
  }
  
  public boolean j()
  {
    n();
    boolean bool2 = b(TXCCommonUtil.getAppID());
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = b("Global");
    }
    return bool1;
  }
  
  public boolean k()
  {
    n();
    boolean bool2 = c(TXCCommonUtil.getAppID());
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = c("Global");
    }
    return bool1;
  }
  
  public void l()
  {
    if (p())
    {
      c(true);
      new c.1(this).start();
    }
  }
  
  public boolean m()
  {
    Context localContext = g;
    try
    {
      synchronized (this.m)
      {
        if ((this.l == null) && (localContext != null)) {
          this.l = localContext.getSharedPreferences("liteav_hw_encoder_config", 0);
        }
        boolean bool = this.l.getBoolean("enable_hw_hevc_encode", true);
        return bool;
      }
      return true;
    }
    catch (Exception localException)
    {
      TXCLog.e("CloudConfig", "isLocalEnableHWHevcEncode: error.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.d.c
 * JD-Core Version:    0.7.0.1
 */