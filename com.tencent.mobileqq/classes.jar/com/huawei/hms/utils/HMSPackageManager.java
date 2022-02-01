package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.a.a;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;

public class HMSPackageManager
{
  private static HMSPackageManager a;
  private static final Object b = new Object();
  private final Context c;
  private final PackageManagerHelper d;
  private String e;
  private String f;
  private int g;
  
  private HMSPackageManager(Context paramContext)
  {
    this.c = paramContext;
    this.d = new PackageManagerHelper(paramContext);
  }
  
  private void a()
  {
    Pair localPair = b();
    if (localPair == null)
    {
      HMSLog.e("HMSPackageManager", "Failed to find HMS apk");
      return;
    }
    this.e = ((String)localPair.first);
    this.f = ((String)localPair.second);
    this.g = this.d.getPackageVersionCode(getHMSPackageName());
    HMSLog.i("HMSPackageManager", "Succeed to find HMS apk: " + this.e + " version: " + this.g);
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      HMSLog.e("HMSPackageManager", "args is invalid");
      return false;
    }
    paramString3 = a.b(paramString3);
    if (paramString3.size() == 0)
    {
      HMSLog.e("HMSPackageManager", "certChain is empty");
      return false;
    }
    if (!a.a(a.a(this.c), paramString3))
    {
      HMSLog.e("HMSPackageManager", "failed to verify cert chain");
      return false;
    }
    paramString3 = (X509Certificate)paramString3.get(paramString3.size() - 1);
    if (!a.a(paramString3, "Huawei CBG HMS"))
    {
      HMSLog.e("HMSPackageManager", "CN is invalid");
      return false;
    }
    if (!a.b(paramString3, "Huawei CBG Cloud Security Signer"))
    {
      HMSLog.e("HMSPackageManager", "OU is invalid");
      return false;
    }
    if (!a.b(paramString3, paramString1, paramString2))
    {
      HMSLog.e("HMSPackageManager", "signature is invalid: " + paramString1);
      return false;
    }
    return true;
  }
  
  private Pair<String, String> b()
  {
    Object localObject1 = this.c.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
    if (((List)localObject1).size() == 0) {
      return null;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ResolveInfo)((Iterator)localObject1).next();
      String str1 = ((ResolveInfo)localObject2).serviceInfo.applicationInfo.packageName;
      localObject2 = ((ResolveInfo)localObject2).serviceInfo.metaData;
      if (localObject2 == null)
      {
        HMSLog.e("HMSPackageManager", "skip package " + str1 + " for metadata is null");
      }
      else if (!((Bundle)localObject2).containsKey("hms_app_signer"))
      {
        HMSLog.e("HMSPackageManager", "skip package " + str1 + " for no signer");
      }
      else if (!((Bundle)localObject2).containsKey("hms_app_cert_chain"))
      {
        HMSLog.e("HMSPackageManager", "skip package " + str1 + " for no cert chain");
      }
      else
      {
        String str2 = this.d.getPackageSignature(str1);
        if (!a(str1 + "&" + str2, ((Bundle)localObject2).getString("hms_app_signer"), ((Bundle)localObject2).getString("hms_app_cert_chain"))) {
          HMSLog.e("HMSPackageManager", "checkSinger failed");
        } else {
          return new Pair(str1, str2);
        }
      }
    }
    return null;
  }
  
  private boolean c()
  {
    Object localObject = this.c.getPackageManager();
    if (localObject == null) {
      HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
    }
    for (;;)
    {
      return true;
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo(getHMSPackageName(), 128).applicationInfo;
        if ((localObject != null) && (((ApplicationInfo)localObject).metaData != null) && (((ApplicationInfo)localObject).metaData.containsKey("com.huawei.hms.kit.api_level:hmscore")) && ((getHmsVersionCode() >= 50000000) || (getHmsVersionCode() <= 19999999)))
        {
          HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
          return false;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
      }
    }
    return true;
  }
  
  public static HMSPackageManager getInstance(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null)
      {
        if (paramContext.getApplicationContext() != null)
        {
          a = new HMSPackageManager(paramContext.getApplicationContext());
          a.a();
        }
      }
      else {
        return a;
      }
      a = new HMSPackageManager(paramContext);
    }
  }
  
  public String getHMSFingerprint()
  {
    if (this.f == null) {
      return "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    }
    return this.f;
  }
  
  public String getHMSPackageName()
  {
    if (this.e != null) {
      return this.e;
    }
    PackageManagerHelper.PackageStates localPackageStates = this.d.getPackageStates("com.huawei.hwid");
    if ((!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(localPackageStates)) && (this.d.getPackageSignature("com.huawei.hwid").equalsIgnoreCase("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05"))) {
      return "com.huawei.hwid";
    }
    return "com.huawei.hms";
  }
  
  public PackageManagerHelper.PackageStates getHMSPackageStates()
  {
    Object localObject;
    if ((TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.f)))
    {
      a();
      localObject = this.d.getPackageStates(this.e);
    }
    do
    {
      PackageManagerHelper.PackageStates localPackageStates;
      do
      {
        return localObject;
        localPackageStates = this.d.getPackageStates(this.e);
        localObject = localPackageStates;
      } while (localPackageStates != PackageManagerHelper.PackageStates.ENABLED);
      localObject = localPackageStates;
    } while (this.f.equals(this.d.getPackageSignature(this.e)));
    return PackageManagerHelper.PackageStates.NOT_INSTALLED;
  }
  
  public int getHmsVersionCode()
  {
    return this.d.getPackageVersionCode(getHMSPackageName());
  }
  
  public boolean hmsVerHigherThan(int paramInt)
  {
    if (this.g >= paramInt) {}
    do
    {
      return true;
      this.g = this.d.getPackageVersionCode(getHMSPackageName());
    } while (this.g >= paramInt);
    return false;
  }
  
  public boolean isApkUpdateNecessary(int paramInt)
  {
    int i = getHmsVersionCode();
    HMSLog.i("HMSPackageManager", "current versionCode:" + i + ", minimum version requirements: " + paramInt);
    return (c()) && (i < paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.utils.HMSPackageManager
 * JD-Core Version:    0.7.0.1
 */