package com.tencent.map.sdk.service.protocol;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.map.sdk.a.my;
import com.tencent.map.sdk.a.mz;
import com.tencent.map.sdk.a.na;
import com.tencent.map.sdk.a.nb;
import com.tencent.map.sdk.a.nc;
import com.tencent.map.sdk.a.nd;
import com.tencent.map.sdk.a.ne;
import com.tencent.map.sdk.a.nf;
import com.tencent.map.sdk.a.ng;
import com.tencent.map.sdk.a.nh;
import com.tencent.map.sdk.a.ni;
import com.tencent.map.sdk.a.nj;
import com.tencent.map.sdk.a.nk;
import com.tencent.map.sdk.a.pz;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ServiceProtocol
{
  private static Set<ServiceProtocol.a> a = new LinkedHashSet();
  
  static
  {
    try
    {
      Method localMethod = ServiceProtocol.class.getDeclaredMethod("a", new Class[] { String.class });
      a.add(new ServiceProtocol.a("authorization", my.class, localMethod));
      a.add(new ServiceProtocol.a("indoordata", nd.class, localMethod));
      a.add(new ServiceProtocol.a("mapdata", ng.class, localMethod));
      a.add(new ServiceProtocol.a("blockroutedata", na.class, localMethod));
      a.add(new ServiceProtocol.a("rttdata", ni.class, localMethod));
      a.add(new ServiceProtocol.a("sketchdata", nj.class, localMethod));
      a.add(new ServiceProtocol.a("overseadata", nh.class, localMethod));
      a.add(new ServiceProtocol.a("statistic", nk.class, localMethod));
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
  }
  
  private static ServiceProtocol a(Context paramContext, InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      try
      {
        byte[] arrayOfByte = new byte[1024];
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (-1 == i) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        paramContext = buildFromJson(paramContext, new String(localByteArrayOutputStream.toByteArray(), Charset.forName("UTF-8")));
        return paramContext;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return new nb();
  }
  
  private static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    String str = paramContext.getPackageName();
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      paramContext = localObject;
    }
    if (paramContext != null)
    {
      if (paramContext.metaData == null) {
        return "";
      }
      return paramContext.metaData.getString("TencentMapSDK");
    }
    return "";
  }
  
  public static <S extends nc> boolean allow(Class<S> paramClass)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      ServiceProtocol.a locala = (ServiceProtocol.a)localIterator.next();
      if (locala.b == paramClass) {
        return locala.d;
      }
    }
    return false;
  }
  
  public static ServiceProtocol buildFromAssets(Context paramContext, String paramString)
  {
    try
    {
      paramContext = a(paramContext, paramContext.getResources().getAssets().open(paramString));
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return new nb();
  }
  
  public static ServiceProtocol buildFromJson(Context paramContext, String paramString)
  {
    for (;;)
    {
      boolean bool2;
      int j;
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject1 = paramString.optString("sdk_protocol", "-1");
        Object localObject2 = paramString.optString("_private_partner", "_unknown");
        if (pz.a == null)
        {
          paramContext = a(paramContext);
          pz.a = paramContext;
          if (paramContext == null) {
            pz.a = "-1";
          }
        }
        if ((!"-1".equals(localObject1)) && (pz.a.equals(localObject2)))
        {
          paramContext = new nf();
          paramString = paramString.optJSONArray("services");
          if (paramString.length() > 0)
          {
            int i = 0;
            if (i < paramString.length())
            {
              localObject1 = paramString.getJSONObject(i);
              if (localObject1 != null)
              {
                localObject2 = ((JSONObject)localObject1).optString("name", null);
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  localObject2 = (ne)paramContext.a.get(localObject2);
                  if (localObject2 != null)
                  {
                    bool2 = true;
                    j = ((JSONObject)localObject1).optInt("status", 1);
                    String str = ((JSONObject)localObject1).optString("host", null);
                    localObject1 = ((JSONObject)localObject1).optString("host_test", null);
                    if (j == 0) {
                      break label271;
                    }
                    bool1 = true;
                    ((mz)localObject2).b = bool1;
                    if (!TextUtils.isEmpty(str)) {
                      ((ne)localObject2).c = str;
                    }
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {
                      break label277;
                    }
                    ((ne)localObject2).d = ((String)localObject1);
                    break label277;
                    ((mz)localObject2).a = bool1;
                  }
                }
              }
              i += 1;
              continue;
            }
          }
          return paramContext;
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
      }
      return new nb();
      label271:
      boolean bool1 = false;
      continue;
      label277:
      if (j == 2) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
  }
  
  public static ServiceProtocol buildFromRaw(Context paramContext, int paramInt)
  {
    return a(paramContext, paramContext.getResources().openRawResource(paramInt));
  }
  
  protected abstract <S extends nc> S a(String paramString);
  
  public final <S extends nc> S newService(Class<S> paramClass)
  {
    Object localObject = a.iterator();
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        ServiceProtocol.a locala = (ServiceProtocol.a)((Iterator)localObject).next();
        if (locala.b == paramClass)
        {
          localObject = locala.c;
          if (localObject != null) {
            try
            {
              ((Method)localObject).setAccessible(true);
              localObject = ((Method)localObject).invoke(this, new Object[] { locala.a });
              if (localObject.getClass() == paramClass)
              {
                paramClass = (nc)localObject;
                locala.d = paramClass.a();
                return paramClass;
              }
            }
            catch (InvocationTargetException paramClass)
            {
              paramClass.printStackTrace();
            }
            catch (IllegalAccessException paramClass)
            {
              paramClass.printStackTrace();
            }
          }
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.ServiceProtocol
 * JD-Core Version:    0.7.0.1
 */