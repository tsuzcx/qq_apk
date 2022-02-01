package com.tencent.luggage.wxa.su;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.xweb.e;
import com.tencent.xweb.f.a;
import com.tencent.xweb.f.b;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.i;
import com.tencent.xweb.v;
import java.io.File;
import java.lang.reflect.Method;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class m
  extends g
{
  protected Class a = null;
  protected Class b = null;
  protected int c = -1;
  ValueCallback<Pair<Integer, String>> d = new m.1(this);
  ValueCallback<Pair<Integer, String>> e = new m.2(this);
  
  private String a(ClassLoader paramClassLoader)
  {
    if (paramClassLoader != null) {}
    try
    {
      paramClassLoader = paramClassLoader.loadClass(B_());
      break label25;
      g();
      paramClassLoader = this.b;
      label25:
      paramClassLoader = paramClassLoader.getMethod("getSupportFormats", new Class[0]);
      paramClassLoader.setAccessible(true);
      paramClassLoader = (String)paramClassLoader.invoke(null, new Object[0]);
      if (paramClassLoader == null) {
        return "";
      }
      return paramClassLoader;
    }
    catch (Exception paramClassLoader)
    {
      String str = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadSupportFormatsFromPlugin error: ");
      localStringBuilder.append(paramClassLoader.getMessage());
      Log.e(str, localStringBuilder.toString());
    }
    return "";
  }
  
  private boolean a(String paramString)
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(a(), "saveSupportFormats, context is null");
      return false;
    }
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(a());
    if (localObject == null)
    {
      Log.e(a(), "saveSupportFormats, sp is null");
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("supportFormats", paramString);
    boolean bool = ((SharedPreferences.Editor)localObject).commit();
    localObject = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadSupportFormat, ret = ");
    localStringBuilder.append(bool);
    localStringBuilder.append(", formats: ");
    localStringBuilder.append(paramString);
    Log.i((String)localObject, localStringBuilder.toString());
    return bool;
  }
  
  public abstract String B_();
  
  public boolean C_()
  {
    return false;
  }
  
  public int a(com.tencent.xweb.xwalk.updater.c paramc)
  {
    String str = a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("performInstall version ");
    ((StringBuilder)localObject2).append(paramc.l);
    Log.i(str, ((StringBuilder)localObject2).toString());
    boolean bool1 = b(paramc);
    if (!bool1)
    {
      Log.e(a(), "performInstall unZipAndCheck failed");
      h.d(a(), paramc.f);
      return -1;
    }
    if (paramc.f)
    {
      try
      {
        boolean bool2 = c(paramc);
        bool1 = bool2;
      }
      catch (Exception localException1)
      {
        Log.e(a(), "performInstall doPatch error: ", localException1);
      }
      if (!bool1)
      {
        Log.e(a(), "performInstall doPatch failed, delete all");
        h.d(a());
        paramc = b(paramc.l);
        if (!paramc.isEmpty()) {
          com.tencent.xweb.util.c.b(paramc);
        }
        return -1;
      }
    }
    Object localObject1 = a(paramc.l);
    localObject2 = h(paramc.l);
    Object localObject3 = new File((String)localObject2);
    if (!((File)localObject3).exists())
    {
      ((File)localObject3).mkdirs();
    }
    else
    {
      localObject3 = ((File)localObject3).listFiles();
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        int j = localObject3.length;
        int i = 0;
        while (i < j)
        {
          Object localObject4 = localObject3[i];
          if ((localObject4 != null) && (localObject4.exists())) {
            localObject4.delete();
          }
          i += 1;
        }
      }
    }
    try
    {
      localObject1 = a(i.a((String)localObject1, (String)localObject2, null));
      a((String)localObject1);
      localObject1 = ((String)localObject1).split(",");
      v.a().a((String[])localObject1, f.a.a);
      v.a().a((String[])localObject1, f.b.a);
      e.a((String[])localObject1);
      f();
      localObject1 = c(paramc.l);
      if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
        com.tencent.xweb.util.c.b((String)localObject1);
      }
      b(paramc.l, true);
      localObject1 = a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("performInstall version ");
      ((StringBuilder)localObject2).append(e());
      ((StringBuilder)localObject2).append(" success");
      Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
      return 0;
    }
    catch (Exception localException2)
    {
      h.e(a(), paramc.f);
      paramc = a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("performInstall error: ");
      ((StringBuilder)localObject2).append(localException2.getMessage());
      Log.e(paramc, ((StringBuilder)localObject2).toString());
    }
    return -1;
  }
  
  public abstract String a(int paramInt);
  
  public String a(int paramInt, boolean paramBoolean)
  {
    String str = b(paramInt);
    if ((str != null) && (!str.isEmpty()))
    {
      if (!paramBoolean)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(a());
        localStringBuilder.append(".zip");
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(a());
      localStringBuilder.append(".patch");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public abstract String c();
  
  public void d()
  {
    int i = e();
    if (i < 0)
    {
      Log.i(a(), "checkFiles, not installed");
      return;
    }
    if (!c(i, true))
    {
      String str = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkFiles failed, abandon version ");
      localStringBuilder.append(i);
      Log.e(str, localStringBuilder.toString());
      h.e(a());
      str = b(i);
      b(-1, true);
      if ((str != null) && (!str.isEmpty())) {
        com.tencent.xweb.util.c.b(str);
      }
    }
  }
  
  protected void g()
  {
    try
    {
      int i = a(true);
      if ((this.a == null) || (this.b == null) || (this.c != i))
      {
        Object localObject1 = a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load class of version ");
        localStringBuilder.append(i);
        Log.i((String)localObject1, localStringBuilder.toString());
        localObject1 = i.a(a(i), h(i), null);
        this.a = ((ClassLoader)localObject1).loadClass(c());
        this.b = ((ClassLoader)localObject1).loadClass(B_());
        this.c = i;
      }
      return;
    }
    finally {}
  }
  
  public String h(int paramInt)
  {
    String str = b(paramInt);
    if ((str != null) && (!str.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("dex");
      return localStringBuilder.toString();
    }
    Log.e(a(), "getDexDir, versionDir is empty");
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.m
 * JD-Core Version:    0.7.0.1
 */