package com.sixgod.pluginsdk.apkmanager;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.sixgod.pluginsdk.a.e;
import com.sixgod.pluginsdk.a.f;
import com.sixgod.pluginsdk.a.g;
import com.sixgod.pluginsdk.common.Constants;
import com.sixgod.pluginsdk.exception.SixGodException;
import com.sixgod.pluginsdk.log.SGLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
{
  Context a;
  com.sixgod.pluginsdk.a.a b;
  HashMap c;
  HashMap d;
  public HashMap e;
  public HashMap f;
  Object g;
  protected ClassLoader h;
  
  public a(Context paramContext, com.sixgod.pluginsdk.a.a parama, ClassLoader paramClassLoader)
  {
    this.a = paramContext;
    this.b = parama;
    this.c = new HashMap();
    this.d = new HashMap();
    this.e = new HashMap();
    this.f = new HashMap();
    this.h = paramClassLoader;
  }
  
  private Application a(ApplicationInfo paramApplicationInfo, ClassLoader paramClassLoader, Object paramObject)
  {
    if (paramApplicationInfo.className == null) {
      paramApplicationInfo.className = "android.app.Application";
    }
    boolean bool = false;
    Object localObject1 = this.b.at.a(null);
    if (localObject1 != null)
    {
      localObject2 = this.b.O.a(localObject1, new Object[] { paramObject, null, this.g });
      if ((localObject2 instanceof Exception)) {
        bool = false;
      }
    }
    for (Object localObject2 = "result = " + localObject2 + " contextObj = " + localObject1;; localObject2 = "")
    {
      if ((localObject1 == null) || (!bool))
      {
        localObject1 = this.b.T.a(null, new Object[] { this.g, paramObject });
        localObject2 = (String)localObject2 + "createAppContext";
        new StringBuilder().append((String)localObject2).append(" & ContextImpl.class constructor = ").append(e.a(this.b.j.b));
      }
      if ((localObject1 == null) || ((localObject1 instanceof Exception)) || ((localObject1 instanceof Boolean))) {
        localObject1 = this.b.aX.a(this.a);
      }
      for (int i = 1;; i = 0)
      {
        if ((Constants.ANDROID_VERSION > 10) && (i == 0)) {
          this.b.bi.a(localObject1, this.a.getPackageName());
        }
        if (i != 0)
        {
          localObject2 = paramApplicationInfo.packageName;
          localObject2 = (c)this.e.get(localObject2);
          localObject2 = new SixGodAppContext((Context)localObject1, paramApplicationInfo.packageName, paramClassLoader, ((c)localObject2).k.a(), ((c)localObject2).k.b(), this.a);
        }
        for (;;)
        {
          try
          {
            paramApplicationInfo = (Application)paramClassLoader.loadClass(paramApplicationInfo.className).newInstance();
          }
          catch (Exception paramClassLoader)
          {
            paramApplicationInfo = null;
          }
          try
          {
            this.b.S.a(paramApplicationInfo, new Object[] { localObject2 });
            if (paramApplicationInfo != null) {
              break label443;
            }
            throw new SixGodException("app null");
          }
          catch (Exception paramClassLoader)
          {
            break label436;
          }
          if (!(localObject2 instanceof Boolean)) {
            break;
          }
          bool = ((Boolean)localObject2).booleanValue();
          break;
          localObject2 = new SixGodAppContext((Context)localObject1, paramApplicationInfo.packageName, this.a);
          continue;
          label436:
          paramClassLoader.printStackTrace();
        }
        label443:
        this.b.aX.a(paramApplicationInfo, localObject2);
        this.b.bl.a(paramApplicationInfo, paramObject);
        if (i == 0) {
          this.b.P.a(localObject1, new Object[] { paramApplicationInfo });
        }
        this.b.bl.a(localObject2, paramObject);
        ((ArrayList)this.b.aV.a(this.g)).add(paramApplicationInfo);
        return paramApplicationInfo;
      }
      bool = false;
    }
  }
  
  private PackageInfo a(String paramString, Object paramObject, ApplicationInfo paramApplicationInfo, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    int j = 0;
    PackageInfo localPackageInfo = new PackageInfo();
    localPackageInfo.applicationInfo = paramApplicationInfo;
    localPackageInfo.packageName = paramString;
    paramString = (Integer)this.b.aH.a(paramObject);
    if (paramString != null) {
      localPackageInfo.versionCode = paramString.intValue();
    }
    localPackageInfo.versionName = ((String)this.b.aI.a(paramObject));
    localPackageInfo.sharedUserId = ((String)this.b.aJ.a(paramObject));
    paramString = (Integer)this.b.aK.a(paramObject);
    if (paramString != null) {
      localPackageInfo.sharedUserLabel = paramString.intValue();
    }
    int i;
    if (paramArrayList1.size() > 0)
    {
      paramString = new ActivityInfo[paramArrayList1.size()];
      i = 0;
      while (i < paramArrayList1.size())
      {
        paramString[i] = ((ActivityInfo)paramArrayList1.get(i));
        i += 1;
      }
      localPackageInfo.activities = paramString;
    }
    paramString = (ArrayList)this.b.bc.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramApplicationInfo = new ActivityInfo[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        paramArrayList1 = paramString.get(i);
        paramApplicationInfo[i] = ((ActivityInfo)this.b.aF.a(paramArrayList1));
        i += 1;
      }
      localPackageInfo.receivers = paramApplicationInfo;
    }
    if (paramArrayList2.size() > 0)
    {
      paramString = new ServiceInfo[paramArrayList2.size()];
      i = 0;
      while (i < paramArrayList2.size())
      {
        paramString[i] = ((ServiceInfo)paramArrayList2.get(i));
        i += 1;
      }
      localPackageInfo.services = paramString;
    }
    paramString = (ArrayList)this.b.aD.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramApplicationInfo = new ProviderInfo[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        paramApplicationInfo[i] = ((ProviderInfo)this.b.bm.a(paramString.get(i)));
        i += 1;
      }
      localPackageInfo.providers = paramApplicationInfo;
    }
    paramString = (ArrayList)this.b.aM.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramApplicationInfo = new InstrumentationInfo[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        paramApplicationInfo[i] = ((InstrumentationInfo)this.b.bn.a(paramString.get(i)));
        i += 1;
      }
      localPackageInfo.instrumentation = paramApplicationInfo;
    }
    paramString = (ArrayList)this.b.aO.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramApplicationInfo = new ConfigurationInfo[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        paramApplicationInfo[i] = ((ConfigurationInfo)paramString.get(i));
        i += 1;
      }
      localPackageInfo.configPreferences = paramApplicationInfo;
    }
    paramString = (ArrayList)this.b.aP.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramApplicationInfo = new FeatureInfo[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        paramApplicationInfo[i] = ((FeatureInfo)paramString.get(i));
        i += 1;
      }
      localPackageInfo.reqFeatures = paramApplicationInfo;
    }
    paramString = (ArrayList)this.b.aE.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramApplicationInfo = new PermissionInfo[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        paramApplicationInfo[i] = ((PermissionInfo)this.b.bo.a(paramString.get(i)));
        i += 1;
      }
      localPackageInfo.permissions = paramApplicationInfo;
    }
    paramString = (List)this.b.aN.a(paramObject);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramObject = new String[paramString.size()];
      i = j;
      while (i < paramString.size())
      {
        paramObject[i] = ((String)paramString.get(i));
        i += 1;
      }
      localPackageInfo.requestedPermissions = paramObject;
    }
    localPackageInfo.signatures = c();
    return localPackageInfo;
  }
  
  private c a(String paramString1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    SGLog.a("loadApkV2 :apkPath = " + paramString1 + " resourceFlags = " + paramInt + "needLibs = " + paramBoolean1 + "defaultUseActionBar = " + paramBoolean2 + ", verName=" + paramString2);
    long l = System.currentTimeMillis();
    PackageInfo localPackageInfo = this.a.getPackageManager().getPackageArchiveInfo(paramString1, 20885);
    if (localPackageInfo == null)
    {
      paramString2 = b(new File(paramString1));
      SGLog.b("PackageInfo null! " + paramString2);
      throw new SixGodException("parsepackage failed! + apkPath = " + paramString1 + ";" + paramString2);
    }
    localPackageInfo.signatures = c();
    Object localObject1 = null;
    Object localObject3 = localPackageInfo.activities;
    int k = localObject3.length;
    int i = 0;
    int j = 0;
    Object localObject4;
    Object localObject2;
    if (i < k)
    {
      localObject4 = localObject3[i];
      SGLog.a("load apk parse activity pkg = " + ((ActivityInfo)localObject4).packageName + " className = " + ((ActivityInfo)localObject4).name);
      localObject2 = new ComponentName(((ActivityInfo)localObject4).packageName, ((ActivityInfo)localObject4).name);
      this.c.put(localObject2, localObject4);
      if (j != 0) {
        break label1020;
      }
      j = 1;
      localObject1 = localObject2;
    }
    label1020:
    for (;;)
    {
      i += 1;
      break;
      localObject2 = localPackageInfo.services;
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject2[i];
        SGLog.a("load apk parse service pkg = " + ((ServiceInfo)localObject3).packageName + " className = " + ((ServiceInfo)localObject3).name);
        localObject4 = new ComponentName(((ServiceInfo)localObject3).packageName, ((ServiceInfo)localObject3).name);
        this.d.put(localObject4, localObject3);
        i += 1;
      }
      ApplicationInfo localApplicationInfo = localPackageInfo.applicationInfo;
      localApplicationInfo.sourceDir = paramString1;
      localApplicationInfo.uid = this.a.getApplicationInfo().uid;
      localApplicationInfo.dataDir = com.sixgod.pluginsdk.common.a.b(this.a, localApplicationInfo.packageName);
      localApplicationInfo.publicSourceDir = paramString1;
      localApplicationInfo.processName = this.a.getApplicationInfo().processName;
      if (this.g == null) {
        this.g = this.b.t.a(null, null);
      }
      SGLog.a("sixgod_perf", "loadedApk.parseApk dtime =  " + (System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
      localObject4 = a(localApplicationInfo);
      SGLog.a("sixgod_perf", "loadedApk.newLoadedApk dtime = " + (System.currentTimeMillis() - l));
      String str1 = (String)this.b.az.a(localObject4);
      if (this.e.containsKey(str1)) {
        return null;
      }
      l = System.currentTimeMillis();
      String str2 = com.sixgod.pluginsdk.common.a.d(this.a, str1, paramString2);
      localObject3 = (DexClassLoader)com.sixgod.pluginsdk.a.a(str1);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = str2 + File.pathSeparator + this.a.getApplicationInfo().dataDir + "/lib";
        paramString2 = com.sixgod.pluginsdk.common.a.c(this.a, str1, paramString2);
        localObject3 = new File(paramString2);
        if (!((File)localObject3).exists()) {
          ((File)localObject3).mkdirs();
        }
        localObject2 = new DexClassLoader(paramString1, paramString2, (String)localObject2, this.h);
        com.sixgod.pluginsdk.a.a(str1, (ClassLoader)localObject2);
      }
      this.b.ax.a(localObject4, localObject2);
      SGLog.a("sixgod_perf", "loadedApk.classLoader dtime = " + (System.currentTimeMillis() - l));
      paramString2 = new PluginResources(this.a, paramInt, paramString1);
      this.b.aQ.a(localObject4, paramString2.a());
      if (Build.VERSION.SDK_INT >= 9)
      {
        localApplicationInfo.nativeLibraryDir = str2;
        SGLog.a("after nativeLibraryDir = " + localApplicationInfo.nativeLibraryDir);
      }
      localObject3 = new c(this);
      ((c)localObject3).h = null;
      ((c)localObject3).c = localApplicationInfo;
      ((c)localObject3).b = ((ClassLoader)localObject2);
      ((c)localObject3).d = localObject4;
      ((c)localObject3).f = localObject1;
      ((c)localObject3).g = paramBoolean2;
      ((c)localObject3).i = paramString1;
      ((c)localObject3).j = localPackageInfo;
      ((c)localObject3).k = paramString2;
      ((c)localObject3).a = str1;
      SGLog.a("insert pluginAppInfo pkg = " + str1);
      this.e.put(str1, localObject3);
      l = System.currentTimeMillis();
      paramString1 = a(localApplicationInfo, (ClassLoader)localObject2, localObject4);
      this.b.bj.a(localObject4, paramString1);
      SGLog.a("sixgod_perf", "loadedApk.createApp dtime = " + (System.currentTimeMillis() - l));
      ((c)localObject3).e = paramString1;
      return localObject3;
    }
  }
  
  private Object a(ApplicationInfo paramApplicationInfo)
  {
    Object localObject1;
    Object localObject2;
    if (this.b.am.a())
    {
      localObject1 = this.g;
      localObject2 = this.g;
      paramApplicationInfo = this.b.am.a(new Object[] { localObject1, paramApplicationInfo, localObject2, null, Boolean.valueOf(false), Boolean.valueOf(true) });
      SGLog.a("use conLoadedApkV10");
      return paramApplicationInfo;
    }
    if (this.b.an.a())
    {
      localObject1 = this.g;
      paramApplicationInfo = this.b.an.a(new Object[] { localObject1, paramApplicationInfo, null, null, Boolean.valueOf(true), Boolean.valueOf(false) });
      SGLog.a("use conLoadedApkV19s");
      return paramApplicationInfo;
    }
    if (this.b.ao.a())
    {
      localObject1 = this.g;
      localObject2 = this.g;
      paramApplicationInfo = this.b.ao.a(new Object[] { localObject1, paramApplicationInfo, null, localObject2, null, Boolean.valueOf(false), Boolean.valueOf(true) });
      SGLog.a("use conLoadedApkV19");
      return paramApplicationInfo;
    }
    if (this.b.ap.a())
    {
      localObject1 = this.g;
      paramApplicationInfo = this.b.ap.a(new Object[] { localObject1, paramApplicationInfo, null, null, Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false) });
      SGLog.a("use conLoadedApkV20");
      return paramApplicationInfo;
    }
    Object localObject3;
    if (this.b.aq.a())
    {
      localObject1 = this.g;
      localObject2 = paramApplicationInfo.packageName;
      localObject3 = this.a.getApplicationContext();
      localObject1 = this.b.aq.a(new Object[] { localObject1, localObject2, localObject3, paramApplicationInfo });
      SGLog.a("use conLoadedApkV10a");
    }
    for (;;)
    {
      this.b.br.a(localObject1, paramApplicationInfo.sourceDir);
      this.b.bv.a(localObject1, paramApplicationInfo);
      this.b.az.a(localObject1, paramApplicationInfo.packageName);
      this.b.ay.a(localObject1, paramApplicationInfo.sourceDir);
      this.b.bs.a(localObject1, paramApplicationInfo.dataDir);
      if (paramApplicationInfo.dataDir != null) {
        this.b.bt.a(localObject1, new File(paramApplicationInfo.dataDir));
      }
      this.b.bu.a(localObject1, paramApplicationInfo.nativeLibraryDir);
      return localObject1;
      if (this.b.as.a())
      {
        localObject1 = this.g;
        localObject2 = this.a.getApplicationContext();
        localObject3 = paramApplicationInfo.packageName;
        localObject1 = this.b.as.a(new Object[] { localObject1, localObject2, localObject3, paramApplicationInfo, null });
        SGLog.a("use conLoadedApkV19a");
      }
      else
      {
        if (!this.b.ar.a()) {
          break;
        }
        localObject1 = this.g;
        localObject1 = this.b.ar.a(new Object[] { localObject1 });
        SGLog.a("use conLoadedApkV19sa");
      }
    }
    SGLog.b("new LoadedApk failed!");
    return null;
  }
  
  /* Error */
  private static String b(File paramFile)
  {
    // Byte code:
    //   0: new 633	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 634	java/lang/StringBuffer:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: new 75	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 636
    //   16: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 639	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   23: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 642	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   32: pop
    //   33: aload_3
    //   34: new 75	java/lang/StringBuilder
    //   37: dup
    //   38: ldc_w 644
    //   41: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: aload_0
    //   45: invokevirtual 647	java/io/File:length	()J
    //   48: invokevirtual 461	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   51: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokevirtual 642	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   57: pop
    //   58: aload_3
    //   59: new 75	java/lang/StringBuilder
    //   62: dup
    //   63: ldc_w 649
    //   66: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_0
    //   70: invokestatic 653	com/sixgod/pluginsdk/b/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   73: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokevirtual 642	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   82: pop
    //   83: aload_3
    //   84: new 75	java/lang/StringBuilder
    //   87: dup
    //   88: ldc_w 655
    //   91: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_0
    //   95: invokestatic 656	com/sixgod/pluginsdk/b/a:b	(Ljava/io/File;)Ljava/lang/String;
    //   98: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokevirtual 642	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   107: pop
    //   108: new 658	java/util/zip/ZipFile
    //   111: dup
    //   112: aload_0
    //   113: invokespecial 661	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   116: astore_1
    //   117: aload_1
    //   118: astore_0
    //   119: aload_3
    //   120: new 75	java/lang/StringBuilder
    //   123: dup
    //   124: ldc_w 663
    //   127: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   130: aload_1
    //   131: invokevirtual 664	java/util/zip/ZipFile:size	()I
    //   134: invokevirtual 363	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokevirtual 642	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   143: pop
    //   144: aload_1
    //   145: invokevirtual 667	java/util/zip/ZipFile:close	()V
    //   148: new 75	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 669
    //   155: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload_3
    //   159: invokevirtual 670	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   162: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: astore_0
    //   169: aload_0
    //   170: invokestatic 376	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: areturn
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   180: goto -72 -> 108
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   188: goto -40 -> 148
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_1
    //   194: aload_1
    //   195: astore_0
    //   196: aload_2
    //   197: invokevirtual 672	java/util/zip/ZipException:printStackTrace	()V
    //   200: aload_1
    //   201: ifnull -53 -> 148
    //   204: aload_1
    //   205: invokevirtual 667	java/util/zip/ZipFile:close	()V
    //   208: goto -60 -> 148
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   216: goto -68 -> 148
    //   219: astore_2
    //   220: aconst_null
    //   221: astore_1
    //   222: aload_1
    //   223: astore_0
    //   224: aload_2
    //   225: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   228: aload_1
    //   229: ifnull -81 -> 148
    //   232: aload_1
    //   233: invokevirtual 667	java/util/zip/ZipFile:close	()V
    //   236: goto -88 -> 148
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   244: goto -96 -> 148
    //   247: astore_1
    //   248: aconst_null
    //   249: astore_0
    //   250: aload_0
    //   251: ifnull +7 -> 258
    //   254: aload_0
    //   255: invokevirtual 667	java/util/zip/ZipFile:close	()V
    //   258: aload_1
    //   259: athrow
    //   260: astore_0
    //   261: aload_0
    //   262: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   265: goto -7 -> 258
    //   268: astore_1
    //   269: goto -19 -> 250
    //   272: astore_2
    //   273: goto -51 -> 222
    //   276: astore_2
    //   277: goto -83 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramFile	File
    //   116	29	1	localZipFile	java.util.zip.ZipFile
    //   175	2	1	localIOException1	java.io.IOException
    //   193	40	1	localObject1	Object
    //   247	12	1	localObject2	Object
    //   268	1	1	localObject3	Object
    //   191	6	2	localZipException1	java.util.zip.ZipException
    //   219	6	2	localIOException2	java.io.IOException
    //   272	1	2	localIOException3	java.io.IOException
    //   276	1	2	localZipException2	java.util.zip.ZipException
    //   7	152	3	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   83	108	175	java/io/IOException
    //   144	148	183	java/io/IOException
    //   108	117	191	java/util/zip/ZipException
    //   204	208	211	java/io/IOException
    //   108	117	219	java/io/IOException
    //   232	236	239	java/io/IOException
    //   108	117	247	finally
    //   254	258	260	java/io/IOException
    //   119	144	268	finally
    //   196	200	268	finally
    //   224	228	268	finally
    //   119	144	272	java/io/IOException
    //   119	144	276	java/util/zip/ZipException
  }
  
  private Signature[] c()
  {
    Object localObject = this.a.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(this.a.getPackageName(), 64).signatures;
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public final android.app.Activity a(ActivityInfo paramActivityInfo, android.content.Intent paramIntent, Bundle paramBundle, ClassLoader paramClassLoader, android.os.IBinder paramIBinder, android.app.Activity paramActivity)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 685	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   4: astore 10
    //   6: aload 10
    //   8: invokevirtual 686	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   11: astore 12
    //   13: aload_0
    //   14: getfield 35	com/sixgod/pluginsdk/apkmanager/a:e	Ljava/util/HashMap;
    //   17: aload 12
    //   19: invokevirtual 147	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 149	com/sixgod/pluginsdk/apkmanager/c
    //   25: astore 14
    //   27: aload_0
    //   28: getfield 35	com/sixgod/pluginsdk/apkmanager/a:e	Ljava/util/HashMap;
    //   31: aload 12
    //   33: invokevirtual 147	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 149	com/sixgod/pluginsdk/apkmanager/c
    //   39: astore 9
    //   41: aload 9
    //   43: ifnonnull +605 -> 648
    //   46: aconst_null
    //   47: astore 9
    //   49: aload_0
    //   50: getfield 68	com/sixgod/pluginsdk/apkmanager/a:g	Ljava/lang/Object;
    //   53: astore 15
    //   55: aload_0
    //   56: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   59: getfield 689	com/sixgod/pluginsdk/a/a:aW	Lcom/sixgod/pluginsdk/a/f;
    //   62: aload 15
    //   64: invokevirtual 124	com/sixgod/pluginsdk/a/f:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: astore 13
    //   69: aload_0
    //   70: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   73: getfield 692	com/sixgod/pluginsdk/a/a:X	Lcom/sixgod/pluginsdk/a/g;
    //   76: aload 13
    //   78: iconst_3
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload 4
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: aload 10
    //   91: invokevirtual 695	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   94: aastore
    //   95: dup
    //   96: iconst_2
    //   97: aload_2
    //   98: aastore
    //   99: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 697	android/app/Activity
    //   105: astore 11
    //   107: aload 14
    //   109: getfield 562	com/sixgod/pluginsdk/apkmanager/c:e	Landroid/app/Application;
    //   112: astore 16
    //   114: aload 11
    //   116: astore 10
    //   118: aload 11
    //   120: ifnull +1375 -> 1495
    //   123: aload_0
    //   124: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   127: getfield 57	com/sixgod/pluginsdk/a/a:at	Lcom/sixgod/pluginsdk/a/e;
    //   130: aconst_null
    //   131: invokevirtual 62	com/sixgod/pluginsdk/a/e:a	([Ljava/lang/Object;)Ljava/lang/Object;
    //   134: astore 10
    //   136: aload 10
    //   138: ifnull +1512 -> 1650
    //   141: aload_0
    //   142: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   145: getfield 66	com/sixgod/pluginsdk/a/a:O	Lcom/sixgod/pluginsdk/a/g;
    //   148: aload 10
    //   150: iconst_3
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload 9
    //   158: aastore
    //   159: dup
    //   160: iconst_1
    //   161: aconst_null
    //   162: aastore
    //   163: dup
    //   164: iconst_2
    //   165: aload 15
    //   167: aastore
    //   168: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   171: astore 17
    //   173: aload 17
    //   175: instanceof 43
    //   178: ifeq +509 -> 687
    //   181: iconst_0
    //   182: istore 8
    //   184: aload 10
    //   186: ifnull +8 -> 194
    //   189: iload 8
    //   191: ifne +636 -> 827
    //   194: aload_0
    //   195: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   198: getfield 700	com/sixgod/pluginsdk/a/a:U	Lcom/sixgod/pluginsdk/a/g;
    //   201: invokevirtual 701	com/sixgod/pluginsdk/a/g:a	()Z
    //   204: ifeq +504 -> 708
    //   207: aload_0
    //   208: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   211: getfield 700	com/sixgod/pluginsdk/a/a:U	Lcom/sixgod/pluginsdk/a/g;
    //   214: aconst_null
    //   215: iconst_3
    //   216: anewarray 4	java/lang/Object
    //   219: dup
    //   220: iconst_0
    //   221: aload 15
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: aload 9
    //   228: aastore
    //   229: dup
    //   230: iconst_2
    //   231: aload 5
    //   233: aastore
    //   234: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   237: astore 9
    //   239: aload 9
    //   241: ifnull +19 -> 260
    //   244: aload 9
    //   246: instanceof 43
    //   249: ifne +11 -> 260
    //   252: aload 9
    //   254: instanceof 115
    //   257: ifeq +577 -> 834
    //   260: aload 6
    //   262: invokevirtual 704	android/app/Activity:getBaseContext	()Landroid/content/Context;
    //   265: astore 9
    //   267: ldc_w 706
    //   270: invokestatic 376	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   273: iconst_1
    //   274: istore 7
    //   276: aload_1
    //   277: aload_0
    //   278: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   281: getfield 709	com/sixgod/pluginsdk/a/a:Y	Lcom/sixgod/pluginsdk/a/g;
    //   284: aload 9
    //   286: aconst_null
    //   287: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   290: checkcast 388	android/content/pm/PackageManager
    //   293: invokevirtual 713	android/content/pm/ActivityInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   296: astore 10
    //   298: new 715	android/content/res/Configuration
    //   301: dup
    //   302: aload_0
    //   303: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   306: getfield 718	com/sixgod/pluginsdk/a/a:bf	Lcom/sixgod/pluginsdk/a/f;
    //   309: aload 15
    //   311: invokevirtual 124	com/sixgod/pluginsdk/a/f:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   314: checkcast 715	android/content/res/Configuration
    //   317: invokespecial 721	android/content/res/Configuration:<init>	(Landroid/content/res/Configuration;)V
    //   320: astore 17
    //   322: new 75	java/lang/StringBuilder
    //   325: dup
    //   326: ldc_w 723
    //   329: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   332: aload 9
    //   334: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 376	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   343: iload 7
    //   345: ifeq +517 -> 862
    //   348: ldc_w 725
    //   351: invokestatic 376	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   354: new 727	com/sixgod/pluginsdk/apkmanager/SixGodContext
    //   357: dup
    //   358: aload 9
    //   360: checkcast 135	android/content/Context
    //   363: aload 12
    //   365: aload 4
    //   367: aload 14
    //   369: getfield 155	com/sixgod/pluginsdk/apkmanager/c:k	Lcom/sixgod/pluginsdk/apkmanager/PluginResources;
    //   372: invokevirtual 160	com/sixgod/pluginsdk/apkmanager/PluginResources:a	()Landroid/content/res/Resources;
    //   375: aload 14
    //   377: getfield 155	com/sixgod/pluginsdk/apkmanager/c:k	Lcom/sixgod/pluginsdk/apkmanager/PluginResources;
    //   380: invokevirtual 163	com/sixgod/pluginsdk/apkmanager/PluginResources:b	()Landroid/content/res/AssetManager;
    //   383: aload_0
    //   384: aload_0
    //   385: getfield 24	com/sixgod/pluginsdk/apkmanager/a:a	Landroid/content/Context;
    //   388: invokespecial 730	com/sixgod/pluginsdk/apkmanager/SixGodContext:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/ClassLoader;Landroid/content/res/Resources;Landroid/content/res/AssetManager;Lcom/sixgod/pluginsdk/apkmanager/a;Landroid/content/Context;)V
    //   391: astore 4
    //   393: aload_0
    //   394: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   397: getfield 732	com/sixgod/pluginsdk/a/a:Z	Lcom/sixgod/pluginsdk/a/g;
    //   400: invokevirtual 701	com/sixgod/pluginsdk/a/g:a	()Z
    //   403: ifeq +483 -> 886
    //   406: aload_0
    //   407: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   410: getfield 732	com/sixgod/pluginsdk/a/a:Z	Lcom/sixgod/pluginsdk/a/g;
    //   413: aload 11
    //   415: bipush 12
    //   417: anewarray 4	java/lang/Object
    //   420: dup
    //   421: iconst_0
    //   422: aload 4
    //   424: aastore
    //   425: dup
    //   426: iconst_1
    //   427: aload 15
    //   429: aastore
    //   430: dup
    //   431: iconst_2
    //   432: aload 13
    //   434: aastore
    //   435: dup
    //   436: iconst_3
    //   437: aload 5
    //   439: aastore
    //   440: dup
    //   441: iconst_4
    //   442: aload 16
    //   444: aastore
    //   445: dup
    //   446: iconst_5
    //   447: aload_2
    //   448: aastore
    //   449: dup
    //   450: bipush 6
    //   452: aload_1
    //   453: aastore
    //   454: dup
    //   455: bipush 7
    //   457: aload 10
    //   459: aastore
    //   460: dup
    //   461: bipush 8
    //   463: aconst_null
    //   464: aastore
    //   465: dup
    //   466: bipush 9
    //   468: aload_1
    //   469: getfield 735	android/content/pm/ActivityInfo:targetActivity	Ljava/lang/String;
    //   472: aastore
    //   473: dup
    //   474: bipush 10
    //   476: aconst_null
    //   477: aastore
    //   478: dup
    //   479: bipush 11
    //   481: aload 17
    //   483: aastore
    //   484: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   487: pop
    //   488: aload_0
    //   489: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   492: getfield 119	com/sixgod/pluginsdk/a/a:aX	Lcom/sixgod/pluginsdk/a/f;
    //   495: aload 11
    //   497: aload 4
    //   499: invokevirtual 141	com/sixgod/pluginsdk/a/f:a	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   502: aload_0
    //   503: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   506: getfield 738	com/sixgod/pluginsdk/a/a:aY	Lcom/sixgod/pluginsdk/a/f;
    //   509: aload 11
    //   511: aload 4
    //   513: invokevirtual 141	com/sixgod/pluginsdk/a/f:a	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   516: aload_0
    //   517: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   520: getfield 741	com/sixgod/pluginsdk/a/a:bg	Lcom/sixgod/pluginsdk/a/f;
    //   523: aload 11
    //   525: iconst_0
    //   526: invokestatic 571	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   529: invokevirtual 141	com/sixgod/pluginsdk/a/f:a	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   532: aload_1
    //   533: invokevirtual 744	android/content/pm/ActivityInfo:getThemeResource	()I
    //   536: istore 7
    //   538: iload 7
    //   540: ifeq +10 -> 550
    //   543: aload 11
    //   545: iload 7
    //   547: invokevirtual 748	android/app/Activity:setTheme	(I)V
    //   550: aload_0
    //   551: getfield 35	com/sixgod/pluginsdk/apkmanager/a:e	Ljava/util/HashMap;
    //   554: aload 12
    //   556: invokevirtual 147	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   559: checkcast 149	com/sixgod/pluginsdk/apkmanager/c
    //   562: getfield 542	com/sixgod/pluginsdk/apkmanager/c:g	Z
    //   565: istore 8
    //   567: iload 8
    //   569: ifne +25 -> 594
    //   572: aload_0
    //   573: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   576: getfield 751	com/sixgod/pluginsdk/a/a:N	Lcom/sixgod/pluginsdk/a/g;
    //   579: aload 11
    //   581: iconst_1
    //   582: anewarray 4	java/lang/Object
    //   585: dup
    //   586: iconst_0
    //   587: aload 6
    //   589: aastore
    //   590: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   593: pop
    //   594: aload_0
    //   595: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   598: getfield 754	com/sixgod/pluginsdk/a/a:bh	Lcom/sixgod/pluginsdk/a/f;
    //   601: aload 11
    //   603: iconst_0
    //   604: invokestatic 571	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   607: invokevirtual 141	com/sixgod/pluginsdk/a/f:a	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   610: aload_0
    //   611: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   614: getfield 757	com/sixgod/pluginsdk/a/a:ag	Lcom/sixgod/pluginsdk/a/g;
    //   617: aload 13
    //   619: iconst_2
    //   620: anewarray 4	java/lang/Object
    //   623: dup
    //   624: iconst_0
    //   625: aload 11
    //   627: aastore
    //   628: dup
    //   629: iconst_1
    //   630: aload_3
    //   631: aastore
    //   632: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   635: astore_1
    //   636: aload_1
    //   637: instanceof 43
    //   640: ifeq +835 -> 1475
    //   643: aload_1
    //   644: checkcast 43	java/lang/Exception
    //   647: athrow
    //   648: aload 9
    //   650: getfield 536	com/sixgod/pluginsdk/apkmanager/c:d	Ljava/lang/Object;
    //   653: astore 9
    //   655: goto -606 -> 49
    //   658: astore_1
    //   659: new 185	com/sixgod/pluginsdk/exception/SixGodException
    //   662: dup
    //   663: new 75	java/lang/StringBuilder
    //   666: dup
    //   667: ldc_w 759
    //   670: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   673: aload_1
    //   674: invokevirtual 762	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   677: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokespecial 188	com/sixgod/pluginsdk/exception/SixGodException:<init>	(Ljava/lang/String;)V
    //   686: athrow
    //   687: aload 17
    //   689: instanceof 115
    //   692: ifeq +958 -> 1650
    //   695: aload 17
    //   697: checkcast 115	java/lang/Boolean
    //   700: invokevirtual 192	java/lang/Boolean:booleanValue	()Z
    //   703: istore 8
    //   705: goto -521 -> 184
    //   708: aload_0
    //   709: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   712: getfield 765	com/sixgod/pluginsdk/a/a:V	Lcom/sixgod/pluginsdk/a/g;
    //   715: invokevirtual 701	com/sixgod/pluginsdk/a/g:a	()Z
    //   718: ifeq +44 -> 762
    //   721: aload_0
    //   722: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   725: getfield 765	com/sixgod/pluginsdk/a/a:V	Lcom/sixgod/pluginsdk/a/g;
    //   728: aconst_null
    //   729: iconst_4
    //   730: anewarray 4	java/lang/Object
    //   733: dup
    //   734: iconst_0
    //   735: aload 15
    //   737: aastore
    //   738: dup
    //   739: iconst_1
    //   740: aload 9
    //   742: aastore
    //   743: dup
    //   744: iconst_2
    //   745: iconst_0
    //   746: invokestatic 768	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   749: aastore
    //   750: dup
    //   751: iconst_3
    //   752: aconst_null
    //   753: aastore
    //   754: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   757: astore 9
    //   759: goto -520 -> 239
    //   762: aload_0
    //   763: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   766: getfield 771	com/sixgod/pluginsdk/a/a:W	Lcom/sixgod/pluginsdk/a/g;
    //   769: invokevirtual 701	com/sixgod/pluginsdk/a/g:a	()Z
    //   772: ifeq +49 -> 821
    //   775: aload_0
    //   776: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   779: getfield 771	com/sixgod/pluginsdk/a/a:W	Lcom/sixgod/pluginsdk/a/g;
    //   782: aconst_null
    //   783: iconst_5
    //   784: anewarray 4	java/lang/Object
    //   787: dup
    //   788: iconst_0
    //   789: aload 15
    //   791: aastore
    //   792: dup
    //   793: iconst_1
    //   794: aload 9
    //   796: aastore
    //   797: dup
    //   798: iconst_2
    //   799: aload 5
    //   801: aastore
    //   802: dup
    //   803: iconst_3
    //   804: iconst_0
    //   805: invokestatic 768	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   808: aastore
    //   809: dup
    //   810: iconst_4
    //   811: aconst_null
    //   812: aastore
    //   813: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   816: astore 9
    //   818: goto -579 -> 239
    //   821: ldc_w 773
    //   824: invokestatic 376	com/sixgod/pluginsdk/log/SGLog:a	(Ljava/lang/String;)V
    //   827: aload 10
    //   829: astore 9
    //   831: goto -592 -> 239
    //   834: aload_0
    //   835: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   838: getfield 204	com/sixgod/pluginsdk/a/a:P	Lcom/sixgod/pluginsdk/a/g;
    //   841: aload 9
    //   843: iconst_1
    //   844: anewarray 4	java/lang/Object
    //   847: dup
    //   848: iconst_0
    //   849: aload 11
    //   851: aastore
    //   852: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   855: pop
    //   856: iconst_0
    //   857: istore 7
    //   859: goto -583 -> 276
    //   862: new 727	com/sixgod/pluginsdk/apkmanager/SixGodContext
    //   865: dup
    //   866: aload 9
    //   868: checkcast 135	android/content/Context
    //   871: aload 12
    //   873: aload_0
    //   874: aload_0
    //   875: getfield 24	com/sixgod/pluginsdk/apkmanager/a:a	Landroid/content/Context;
    //   878: invokespecial 776	com/sixgod/pluginsdk/apkmanager/SixGodContext:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/sixgod/pluginsdk/apkmanager/a;Landroid/content/Context;)V
    //   881: astore 4
    //   883: goto -490 -> 393
    //   886: aload_0
    //   887: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   890: getfield 779	com/sixgod/pluginsdk/a/a:aa	Lcom/sixgod/pluginsdk/a/g;
    //   893: invokevirtual 701	com/sixgod/pluginsdk/a/g:a	()Z
    //   896: ifeq +88 -> 984
    //   899: aload_0
    //   900: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   903: getfield 779	com/sixgod/pluginsdk/a/a:aa	Lcom/sixgod/pluginsdk/a/g;
    //   906: aload 11
    //   908: bipush 12
    //   910: anewarray 4	java/lang/Object
    //   913: dup
    //   914: iconst_0
    //   915: aload 4
    //   917: aastore
    //   918: dup
    //   919: iconst_1
    //   920: aload 15
    //   922: aastore
    //   923: dup
    //   924: iconst_2
    //   925: aload 13
    //   927: aastore
    //   928: dup
    //   929: iconst_3
    //   930: aload 5
    //   932: aastore
    //   933: dup
    //   934: iconst_4
    //   935: aload 16
    //   937: aastore
    //   938: dup
    //   939: iconst_5
    //   940: aload_2
    //   941: aastore
    //   942: dup
    //   943: bipush 6
    //   945: aload_1
    //   946: aastore
    //   947: dup
    //   948: bipush 7
    //   950: aload 10
    //   952: aastore
    //   953: dup
    //   954: bipush 8
    //   956: aconst_null
    //   957: aastore
    //   958: dup
    //   959: bipush 9
    //   961: aload_1
    //   962: getfield 735	android/content/pm/ActivityInfo:targetActivity	Ljava/lang/String;
    //   965: aastore
    //   966: dup
    //   967: bipush 10
    //   969: aconst_null
    //   970: aastore
    //   971: dup
    //   972: bipush 11
    //   974: aload 17
    //   976: aastore
    //   977: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   980: pop
    //   981: goto -493 -> 488
    //   984: aload_0
    //   985: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   988: getfield 782	com/sixgod/pluginsdk/a/a:ab	Lcom/sixgod/pluginsdk/a/g;
    //   991: invokevirtual 701	com/sixgod/pluginsdk/a/g:a	()Z
    //   994: ifeq +101 -> 1095
    //   997: aload_0
    //   998: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   1001: getfield 782	com/sixgod/pluginsdk/a/a:ab	Lcom/sixgod/pluginsdk/a/g;
    //   1004: aload 11
    //   1006: bipush 14
    //   1008: anewarray 4	java/lang/Object
    //   1011: dup
    //   1012: iconst_0
    //   1013: aload 4
    //   1015: aastore
    //   1016: dup
    //   1017: iconst_1
    //   1018: aload 15
    //   1020: aastore
    //   1021: dup
    //   1022: iconst_2
    //   1023: aload 13
    //   1025: aastore
    //   1026: dup
    //   1027: iconst_3
    //   1028: aload 5
    //   1030: aastore
    //   1031: dup
    //   1032: iconst_4
    //   1033: iconst_0
    //   1034: invokestatic 768	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1037: aastore
    //   1038: dup
    //   1039: iconst_5
    //   1040: aload 16
    //   1042: aastore
    //   1043: dup
    //   1044: bipush 6
    //   1046: aload_2
    //   1047: aastore
    //   1048: dup
    //   1049: bipush 7
    //   1051: aload_1
    //   1052: aastore
    //   1053: dup
    //   1054: bipush 8
    //   1056: aload 10
    //   1058: aastore
    //   1059: dup
    //   1060: bipush 9
    //   1062: aconst_null
    //   1063: aastore
    //   1064: dup
    //   1065: bipush 10
    //   1067: aload_1
    //   1068: getfield 735	android/content/pm/ActivityInfo:targetActivity	Ljava/lang/String;
    //   1071: aastore
    //   1072: dup
    //   1073: bipush 11
    //   1075: aconst_null
    //   1076: aastore
    //   1077: dup
    //   1078: bipush 12
    //   1080: aload 17
    //   1082: aastore
    //   1083: dup
    //   1084: bipush 13
    //   1086: aconst_null
    //   1087: aastore
    //   1088: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1091: pop
    //   1092: goto -604 -> 488
    //   1095: aload_0
    //   1096: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   1099: getfield 785	com/sixgod/pluginsdk/a/a:ac	Lcom/sixgod/pluginsdk/a/g;
    //   1102: invokevirtual 701	com/sixgod/pluginsdk/a/g:a	()Z
    //   1105: ifeq +106 -> 1211
    //   1108: aload_0
    //   1109: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   1112: getfield 785	com/sixgod/pluginsdk/a/a:ac	Lcom/sixgod/pluginsdk/a/g;
    //   1115: aload 11
    //   1117: bipush 15
    //   1119: anewarray 4	java/lang/Object
    //   1122: dup
    //   1123: iconst_0
    //   1124: aload 4
    //   1126: aastore
    //   1127: dup
    //   1128: iconst_1
    //   1129: aload 15
    //   1131: aastore
    //   1132: dup
    //   1133: iconst_2
    //   1134: aload 13
    //   1136: aastore
    //   1137: dup
    //   1138: iconst_3
    //   1139: aload 5
    //   1141: aastore
    //   1142: dup
    //   1143: iconst_4
    //   1144: iconst_0
    //   1145: invokestatic 768	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1148: aastore
    //   1149: dup
    //   1150: iconst_5
    //   1151: aload 16
    //   1153: aastore
    //   1154: dup
    //   1155: bipush 6
    //   1157: aload_2
    //   1158: aastore
    //   1159: dup
    //   1160: bipush 7
    //   1162: aload_1
    //   1163: aastore
    //   1164: dup
    //   1165: bipush 8
    //   1167: aload 10
    //   1169: aastore
    //   1170: dup
    //   1171: bipush 9
    //   1173: aconst_null
    //   1174: aastore
    //   1175: dup
    //   1176: bipush 10
    //   1178: aload_1
    //   1179: getfield 735	android/content/pm/ActivityInfo:targetActivity	Ljava/lang/String;
    //   1182: aastore
    //   1183: dup
    //   1184: bipush 11
    //   1186: aconst_null
    //   1187: aastore
    //   1188: dup
    //   1189: bipush 12
    //   1191: aload 17
    //   1193: aastore
    //   1194: dup
    //   1195: bipush 13
    //   1197: aconst_null
    //   1198: aastore
    //   1199: dup
    //   1200: bipush 14
    //   1202: aconst_null
    //   1203: aastore
    //   1204: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1207: pop
    //   1208: goto -720 -> 488
    //   1211: aload_0
    //   1212: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   1215: getfield 788	com/sixgod/pluginsdk/a/a:ad	Lcom/sixgod/pluginsdk/a/g;
    //   1218: invokevirtual 701	com/sixgod/pluginsdk/a/g:a	()Z
    //   1221: ifeq +111 -> 1332
    //   1224: aload_0
    //   1225: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   1228: getfield 788	com/sixgod/pluginsdk/a/a:ad	Lcom/sixgod/pluginsdk/a/g;
    //   1231: aload 11
    //   1233: bipush 16
    //   1235: anewarray 4	java/lang/Object
    //   1238: dup
    //   1239: iconst_0
    //   1240: aload 4
    //   1242: aastore
    //   1243: dup
    //   1244: iconst_1
    //   1245: aload 15
    //   1247: aastore
    //   1248: dup
    //   1249: iconst_2
    //   1250: aload 13
    //   1252: aastore
    //   1253: dup
    //   1254: iconst_3
    //   1255: aload 5
    //   1257: aastore
    //   1258: dup
    //   1259: iconst_4
    //   1260: iconst_0
    //   1261: invokestatic 768	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1264: aastore
    //   1265: dup
    //   1266: iconst_5
    //   1267: aload 16
    //   1269: aastore
    //   1270: dup
    //   1271: bipush 6
    //   1273: aload_2
    //   1274: aastore
    //   1275: dup
    //   1276: bipush 7
    //   1278: aload_1
    //   1279: aastore
    //   1280: dup
    //   1281: bipush 8
    //   1283: aload 10
    //   1285: aastore
    //   1286: dup
    //   1287: bipush 9
    //   1289: aconst_null
    //   1290: aastore
    //   1291: dup
    //   1292: bipush 10
    //   1294: aload_1
    //   1295: getfield 735	android/content/pm/ActivityInfo:targetActivity	Ljava/lang/String;
    //   1298: aastore
    //   1299: dup
    //   1300: bipush 11
    //   1302: aconst_null
    //   1303: aastore
    //   1304: dup
    //   1305: bipush 12
    //   1307: aload 17
    //   1309: aastore
    //   1310: dup
    //   1311: bipush 13
    //   1313: aconst_null
    //   1314: aastore
    //   1315: dup
    //   1316: bipush 14
    //   1318: aconst_null
    //   1319: aastore
    //   1320: dup
    //   1321: bipush 15
    //   1323: aconst_null
    //   1324: aastore
    //   1325: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1328: pop
    //   1329: goto -841 -> 488
    //   1332: aload_0
    //   1333: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   1336: getfield 791	com/sixgod/pluginsdk/a/a:ae	Lcom/sixgod/pluginsdk/a/g;
    //   1339: invokevirtual 701	com/sixgod/pluginsdk/a/g:a	()Z
    //   1342: ifeq +116 -> 1458
    //   1345: aload_0
    //   1346: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   1349: getfield 791	com/sixgod/pluginsdk/a/a:ae	Lcom/sixgod/pluginsdk/a/g;
    //   1352: aload 11
    //   1354: bipush 17
    //   1356: anewarray 4	java/lang/Object
    //   1359: dup
    //   1360: iconst_0
    //   1361: aload 4
    //   1363: aastore
    //   1364: dup
    //   1365: iconst_1
    //   1366: aload 15
    //   1368: aastore
    //   1369: dup
    //   1370: iconst_2
    //   1371: aload 13
    //   1373: aastore
    //   1374: dup
    //   1375: iconst_3
    //   1376: aload 5
    //   1378: aastore
    //   1379: dup
    //   1380: iconst_4
    //   1381: iconst_0
    //   1382: invokestatic 768	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1385: aastore
    //   1386: dup
    //   1387: iconst_5
    //   1388: aload 16
    //   1390: aastore
    //   1391: dup
    //   1392: bipush 6
    //   1394: aload_2
    //   1395: aastore
    //   1396: dup
    //   1397: bipush 7
    //   1399: aload_1
    //   1400: aastore
    //   1401: dup
    //   1402: bipush 8
    //   1404: aload 10
    //   1406: aastore
    //   1407: dup
    //   1408: bipush 9
    //   1410: aconst_null
    //   1411: aastore
    //   1412: dup
    //   1413: bipush 10
    //   1415: aload_1
    //   1416: getfield 735	android/content/pm/ActivityInfo:targetActivity	Ljava/lang/String;
    //   1419: aastore
    //   1420: dup
    //   1421: bipush 11
    //   1423: aconst_null
    //   1424: aastore
    //   1425: dup
    //   1426: bipush 12
    //   1428: aload 17
    //   1430: aastore
    //   1431: dup
    //   1432: bipush 13
    //   1434: aconst_null
    //   1435: aastore
    //   1436: dup
    //   1437: bipush 14
    //   1439: aconst_null
    //   1440: aastore
    //   1441: dup
    //   1442: bipush 15
    //   1444: aconst_null
    //   1445: aastore
    //   1446: dup
    //   1447: bipush 16
    //   1449: aconst_null
    //   1450: aastore
    //   1451: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1454: pop
    //   1455: goto -967 -> 488
    //   1458: ldc_w 793
    //   1461: invokestatic 402	com/sixgod/pluginsdk/log/SGLog:b	(Ljava/lang/String;)V
    //   1464: goto -976 -> 488
    //   1467: astore_1
    //   1468: aload_1
    //   1469: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   1472: goto -922 -> 550
    //   1475: aload_1
    //   1476: instanceof 115
    //   1479: ifeq +19 -> 1498
    //   1482: aload_1
    //   1483: checkcast 115	java/lang/Boolean
    //   1486: invokevirtual 192	java/lang/Boolean:booleanValue	()Z
    //   1489: ifne +9 -> 1498
    //   1492: aconst_null
    //   1493: astore 10
    //   1495: aload 10
    //   1497: areturn
    //   1498: getstatic 130	com/sixgod/pluginsdk/common/Constants:ANDROID_VERSION	I
    //   1501: bipush 20
    //   1503: if_icmpgt +90 -> 1593
    //   1506: getstatic 130	com/sixgod/pluginsdk/common/Constants:ANDROID_VERSION	I
    //   1509: bipush 11
    //   1511: if_icmplt +82 -> 1593
    //   1514: aload 11
    //   1516: invokevirtual 797	android/app/Activity:getWindow	()Landroid/view/Window;
    //   1519: bipush 8
    //   1521: invokevirtual 803	android/view/Window:hasFeature	(I)Z
    //   1524: ifeq +25 -> 1549
    //   1527: aload 11
    //   1529: invokevirtual 807	android/app/Activity:getActionBar	()Landroid/app/ActionBar;
    //   1532: ifnonnull +17 -> 1549
    //   1535: aload_0
    //   1536: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   1539: getfield 810	com/sixgod/pluginsdk/a/a:ai	Lcom/sixgod/pluginsdk/a/g;
    //   1542: aload 11
    //   1544: aconst_null
    //   1545: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1548: pop
    //   1549: iload 8
    //   1551: ifeq +25 -> 1576
    //   1554: aload_0
    //   1555: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   1558: getfield 751	com/sixgod/pluginsdk/a/a:N	Lcom/sixgod/pluginsdk/a/g;
    //   1561: aload 11
    //   1563: iconst_1
    //   1564: anewarray 4	java/lang/Object
    //   1567: dup
    //   1568: iconst_0
    //   1569: aload 6
    //   1571: aastore
    //   1572: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1575: pop
    //   1576: aload_0
    //   1577: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   1580: getfield 813	com/sixgod/pluginsdk/a/a:u	Lcom/sixgod/pluginsdk/a/g;
    //   1583: aload 11
    //   1585: aconst_null
    //   1586: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1589: pop
    //   1590: aload 11
    //   1592: areturn
    //   1593: getstatic 130	com/sixgod/pluginsdk/common/Constants:ANDROID_VERSION	I
    //   1596: bipush 20
    //   1598: if_icmple -49 -> 1549
    //   1601: aload 11
    //   1603: invokevirtual 797	android/app/Activity:getWindow	()Landroid/view/Window;
    //   1606: bipush 8
    //   1608: invokevirtual 803	android/view/Window:hasFeature	(I)Z
    //   1611: ifeq -62 -> 1549
    //   1614: aload 11
    //   1616: invokevirtual 807	android/app/Activity:getActionBar	()Landroid/app/ActionBar;
    //   1619: ifnonnull -70 -> 1549
    //   1622: aload_0
    //   1623: getfield 26	com/sixgod/pluginsdk/apkmanager/a:b	Lcom/sixgod/pluginsdk/a/a;
    //   1626: getfield 816	com/sixgod/pluginsdk/a/a:aj	Lcom/sixgod/pluginsdk/a/g;
    //   1629: aload 11
    //   1631: aconst_null
    //   1632: invokevirtual 73	com/sixgod/pluginsdk/a/g:a	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1635: pop
    //   1636: goto -87 -> 1549
    //   1639: astore_1
    //   1640: aload_1
    //   1641: invokevirtual 762	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1644: invokestatic 402	com/sixgod/pluginsdk/log/SGLog:b	(Ljava/lang/String;)V
    //   1647: goto -98 -> 1549
    //   1650: iconst_0
    //   1651: istore 8
    //   1653: goto -1469 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1656	0	this	a
    //   0	1656	1	paramActivityInfo	ActivityInfo
    //   0	1656	2	paramIntent	android.content.Intent
    //   0	1656	3	paramBundle	Bundle
    //   0	1656	4	paramClassLoader	ClassLoader
    //   0	1656	5	paramIBinder	android.os.IBinder
    //   0	1656	6	paramActivity	android.app.Activity
    //   274	584	7	i	int
    //   182	1470	8	bool	boolean
    //   39	828	9	localObject1	Object
    //   4	1492	10	localObject2	Object
    //   105	1525	11	localActivity	android.app.Activity
    //   11	861	12	str	String
    //   67	1305	13	localObject3	Object
    //   25	351	14	localc	c
    //   53	1314	15	localObject4	Object
    //   112	1277	16	localApplication	Application
    //   171	1258	17	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   55	107	658	java/lang/Exception
    //   543	550	1467	java/lang/Exception
    //   1498	1549	1639	java/lang/Exception
    //   1593	1636	1639	java/lang/Exception
  }
  
  public final ActivityInfo a(ComponentName paramComponentName)
  {
    return (ActivityInfo)this.c.get(paramComponentName);
  }
  
  public final c a(String paramString1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3, boolean paramBoolean4)
  {
    SGLog.a("loadApk :apkPath = " + paramString1 + " resourceFlags = " + paramInt + ", needLibs = " + paramBoolean1 + "defaultUseActionBar = " + paramBoolean2 + ", verName=" + paramString2 + " supportMultidex" + paramBoolean3);
    Object localObject1 = new File(paramString1);
    if (!((File)localObject1).exists()) {
      throw new SixGodException("apk file not exists! apkPath = " + paramString1);
    }
    new b(this, (File)localObject1).start();
    long l1 = System.currentTimeMillis();
    localObject1 = null;
    if (this.b.ak.a())
    {
      localObject1 = this.b.ak.a(new Object[] { paramString1 });
      localObject2 = null;
      if (localObject1 == null) {
        break label380;
      }
      if (!this.b.r.a()) {
        break label315;
      }
      localObject1 = this.b.r.a(localObject1, new Object[] { new File(paramString1), null, this.a.getResources().getDisplayMetrics(), Integer.valueOf(2) });
    }
    for (;;)
    {
      if ((localObject1 != null) && (!(localObject1 instanceof Exception)) && (!(localObject1 instanceof Boolean))) {
        break label393;
      }
      return a(paramString1, paramInt, paramBoolean1, paramBoolean2, paramString2);
      if (this.b.al.a())
      {
        localObject1 = this.b.al.a(null);
        break;
      }
      SGLog.b("new PackageParser failed!");
      break;
      label315:
      if (this.b.s.a())
      {
        localObject1 = this.b.s.a(localObject1, new Object[] { new File(paramString1), Integer.valueOf(2) });
      }
      else
      {
        SGLog.b("reflect failed!");
        localObject1 = localObject2;
        continue;
        label380:
        SGLog.b("packageParserObj null");
        localObject1 = localObject2;
      }
    }
    label393:
    Object localObject3 = (ArrayList)this.b.aB.a(localObject1);
    Object localObject5 = new ArrayList();
    Object localObject2 = null;
    Object localObject4 = ((ArrayList)localObject3).iterator();
    Object localObject6;
    Object localObject7;
    Object localObject8;
    if (((Iterator)localObject4).hasNext())
    {
      localObject6 = ((Iterator)localObject4).next();
      localObject7 = (ActivityInfo)this.b.aF.a(localObject6);
      SGLog.a("load apk parse activity pkg = " + ((ActivityInfo)localObject7).packageName + " className = " + ((ActivityInfo)localObject7).name);
      localObject3 = new ComponentName(((ActivityInfo)localObject7).packageName, ((ActivityInfo)localObject7).name);
      this.c.put(localObject3, localObject7);
      ((ArrayList)localObject5).add(localObject7);
      localObject6 = (ArrayList)this.b.aZ.a(localObject6);
      if ((localObject2 != null) || (localObject6 == null) || (((ArrayList)localObject6).size() <= 0)) {
        break label1744;
      }
      localObject7 = ((ArrayList)localObject6).iterator();
      while (((Iterator)localObject7).hasNext())
      {
        localObject8 = (IntentFilter)((Iterator)localObject7).next();
        localObject8 = (ArrayList)this.b.ba.a(localObject8);
        if ((localObject8 != null) && (((ArrayList)localObject8).contains("android.intent.category.LAUNCHER"))) {
          localObject2 = localObject3;
        }
      }
    }
    label1352:
    label1744:
    for (;;)
    {
      this.f.put(localObject3, localObject6);
      break;
      localObject6 = new ArrayList();
      localObject3 = ((ArrayList)this.b.aC.a(localObject1)).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        localObject4 = (ServiceInfo)this.b.aG.a(localObject4);
        SGLog.a("load apk parse service pkg = " + ((ServiceInfo)localObject4).packageName + " className = " + ((ServiceInfo)localObject4).name);
        localObject7 = new ComponentName(((ServiceInfo)localObject4).packageName, ((ServiceInfo)localObject4).name);
        this.d.put(localObject7, localObject4);
        ((ArrayList)localObject6).add(localObject4);
      }
      localObject8 = (ApplicationInfo)this.b.au.a(localObject1);
      ((ApplicationInfo)localObject8).sourceDir = paramString1;
      ((ApplicationInfo)localObject8).uid = this.a.getApplicationInfo().uid;
      ((ApplicationInfo)localObject8).dataDir = com.sixgod.pluginsdk.common.a.b(this.a, ((ApplicationInfo)localObject8).packageName);
      ((ApplicationInfo)localObject8).publicSourceDir = paramString1;
      ((ApplicationInfo)localObject8).metaData = ((Bundle)this.b.aL.a(localObject1));
      ((ApplicationInfo)localObject8).processName = this.a.getApplicationInfo().processName;
      if (this.g == null) {
        this.g = this.b.t.a(null, null);
      }
      SGLog.a("sixgod_perf", "loadedApk.parseApk dtime =  " + (System.currentTimeMillis() - l1));
      l1 = System.currentTimeMillis();
      localObject7 = a((ApplicationInfo)localObject8);
      SGLog.a("sixgod_perf", "loadedApk.newLoadedApk dtime = " + (System.currentTimeMillis() - l1));
      localObject3 = (String)this.b.az.a(localObject7);
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        if ((TextUtils.isEmpty(((ApplicationInfo)localObject8).packageName)) && (localObject2 != null))
        {
          ((ApplicationInfo)localObject8).packageName = localObject2.getPackageName();
          localObject3 = localObject2.getPackageName();
        }
      }
      while (this.e.containsKey(localObject3))
      {
        return null;
        localObject3 = ((ApplicationInfo)localObject8).packageName;
        continue;
        if (TextUtils.isEmpty(((ApplicationInfo)localObject8).packageName)) {
          ((ApplicationInfo)localObject8).packageName = ((String)localObject3);
        }
      }
      l1 = System.currentTimeMillis();
      String str1 = com.sixgod.pluginsdk.common.a.d(this.a, (String)localObject3, paramString2);
      localObject4 = (DexClassLoader)com.sixgod.pluginsdk.a.a((String)localObject3);
      String str2;
      long l2;
      if (localObject4 == null)
      {
        localObject4 = str1 + File.pathSeparator + this.a.getApplicationInfo().dataDir + "/lib";
        str2 = com.sixgod.pluginsdk.common.a.c(this.a, (String)localObject3, paramString2);
        new File(str2).listFiles();
        SGLog.a("supportMultidex = " + paramBoolean3);
        if (paramBoolean3)
        {
          paramString2 = paramString1 + File.pathSeparator + com.sixgod.pluginsdk.common.a.a(this.a, ((ApplicationInfo)localObject8).packageName, paramString2);
          SGLog.a("dexPath = " + paramString2 + " optPth = " + str2);
          if ((paramBoolean4) && (Build.VERSION.SDK_INT >= 21))
          {
            l2 = System.currentTimeMillis();
            paramString2 = new d(paramString2, (String)localObject4, this.h);
            SGLog.a("SpeedyDexClassloader finish time = " + (System.currentTimeMillis() - l2));
            com.sixgod.pluginsdk.a.a((String)localObject3, paramString2);
          }
        }
      }
      for (;;)
      {
        this.b.ax.a(localObject7, paramString2);
        SGLog.a("sixgod_perf", "loadedApk.classLoader dtime = " + (System.currentTimeMillis() - l1));
        localObject4 = new PluginResources(this.a, paramInt, paramString1);
        this.b.aQ.a(localObject7, ((PluginResources)localObject4).a());
        if (Build.VERSION.SDK_INT >= 9)
        {
          ((ApplicationInfo)localObject8).nativeLibraryDir = str1;
          SGLog.a("nativeLibraryDir = " + ((ApplicationInfo)localObject8).nativeLibraryDir);
        }
        localObject6 = a((String)localObject3, localObject1, (ApplicationInfo)localObject8, (ArrayList)localObject5, (ArrayList)localObject6);
        localObject5 = new c(this);
        ((c)localObject5).h = ((ArrayList)this.b.bc.a(localObject1));
        ((c)localObject5).c = ((ApplicationInfo)localObject8);
        ((c)localObject5).b = paramString2;
        ((c)localObject5).d = localObject7;
        ((c)localObject5).f = localObject2;
        ((c)localObject5).g = paramBoolean2;
        ((c)localObject5).i = paramString1;
        ((c)localObject5).j = ((PackageInfo)localObject6);
        ((c)localObject5).k = ((PluginResources)localObject4);
        ((c)localObject5).a = ((String)localObject3);
        SGLog.a("insert pluginAppInfo pkg = " + (String)localObject3);
        this.e.put(localObject3, localObject5);
        l1 = System.currentTimeMillis();
        paramString1 = a((ApplicationInfo)localObject8, paramString2, localObject7);
        this.b.bj.a(localObject7, paramString1);
        SGLog.a("sixgod_perf", "loadedApk.createApp dtime = " + (System.currentTimeMillis() - l1));
        ((c)localObject5).e = paramString1;
        return localObject5;
        l2 = System.currentTimeMillis();
        paramString2 = new DexClassLoader(paramString2, str2, (String)localObject4, this.h);
        SGLog.a("DexClassLoader finish time = " + (System.currentTimeMillis() - l2));
        break label1352;
        paramString2 = paramString1;
        break;
        paramString2 = (String)localObject4;
      }
    }
  }
  
  public final Object a()
  {
    return this.g;
  }
  
  public final void a(String paramString)
  {
    SGLog.a("unLaunch");
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = (c)this.e.remove(paramString);
      if (localObject != null)
      {
        SGLog.a("unLaunch appInfo call onTerminate!");
        ((c)localObject).e.onTerminate();
      }
      localObject = new ArrayList();
      Iterator localIterator = this.c.keySet().iterator();
      ComponentName localComponentName;
      while (localIterator.hasNext())
      {
        localComponentName = (ComponentName)localIterator.next();
        if (localComponentName.getPackageName().equals(paramString)) {
          ((List)localObject).add(localComponentName);
        }
      }
      localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localComponentName = (ComponentName)localIterator.next();
        this.c.remove(localComponentName);
      }
      ((List)localObject).clear();
      localIterator = this.d.keySet().iterator();
      while (localIterator.hasNext())
      {
        localComponentName = (ComponentName)localIterator.next();
        if (localComponentName.getPackageName().equals(paramString)) {
          ((List)localObject).add(localComponentName);
        }
      }
      localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localComponentName = (ComponentName)localIterator.next();
        this.d.remove(localComponentName);
      }
      ((List)localObject).clear();
      localIterator = this.f.keySet().iterator();
      while (localIterator.hasNext())
      {
        localComponentName = (ComponentName)localIterator.next();
        if (localComponentName.getPackageName().equals(paramString)) {
          ((List)localObject).add(localComponentName);
        }
      }
      paramString = ((List)localObject).iterator();
      while (paramString.hasNext())
      {
        localObject = (ComponentName)paramString.next();
        this.f.remove(localObject);
      }
    }
  }
  
  public final void b()
  {
    if (this.g == null) {
      this.g = this.b.t.a(null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.apkmanager.a
 * JD-Core Version:    0.7.0.1
 */