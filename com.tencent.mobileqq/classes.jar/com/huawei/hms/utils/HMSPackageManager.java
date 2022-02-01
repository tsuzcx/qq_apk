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
import com.huawei.hms.device.a;
import com.huawei.hms.support.log.HMSLog;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;

public class HMSPackageManager
{
  public static HMSPackageManager f;
  public static final Object g = new Object();
  public static final Object h = new Object();
  public final Context a;
  public final PackageManagerHelper b;
  public String c;
  public String d;
  public int e;
  
  public HMSPackageManager(Context paramContext)
  {
    this.a = paramContext;
    this.b = new PackageManagerHelper(paramContext);
  }
  
  public static HMSPackageManager getInstance(Context paramContext)
  {
    synchronized (g)
    {
      if (f == null)
      {
        if (paramContext.getApplicationContext() != null) {
          f = new HMSPackageManager(paramContext.getApplicationContext());
        } else {
          f = new HMSPackageManager(paramContext);
        }
        f.b();
      }
      return f;
    }
  }
  
  public final Pair<String, String> a()
  {
    Object localObject1 = this.a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
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
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("skip package ");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(" for metadata is null");
        HMSLog.e("HMSPackageManager", ((StringBuilder)localObject2).toString());
      }
      else if (!((Bundle)localObject2).containsKey("hms_app_signer"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("skip package ");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(" for no signer");
        HMSLog.e("HMSPackageManager", ((StringBuilder)localObject2).toString());
      }
      else if (!((Bundle)localObject2).containsKey("hms_app_cert_chain"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("skip package ");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(" for no cert chain");
        HMSLog.e("HMSPackageManager", ((StringBuilder)localObject2).toString());
      }
      else
      {
        String str2 = this.b.getPackageSignature(str1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append("&");
        localStringBuilder.append(str2);
        if (!a(localStringBuilder.toString(), ((Bundle)localObject2).getString("hms_app_signer"), ((Bundle)localObject2).getString("hms_app_cert_chain"))) {
          HMSLog.e("HMSPackageManager", "checkSinger failed");
        } else {
          return new Pair(str1, str2);
        }
      }
    }
    return null;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramString3 = a.b(paramString3);
      if (paramString3.size() == 0)
      {
        HMSLog.e("HMSPackageManager", "certChain is empty");
        return false;
      }
      if (!a.a(a.a(this.a), paramString3))
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
      if (!a.a(paramString3, paramString1, paramString2))
      {
        paramString2 = new StringBuilder();
        paramString2.append("signature is invalid: ");
        paramString2.append(paramString1);
        HMSLog.e("HMSPackageManager", paramString2.toString());
        return false;
      }
      return true;
    }
    HMSLog.e("HMSPackageManager", "args is invalid");
    return false;
  }
  
  public final void b()
  {
    synchronized (h)
    {
      Object localObject2 = a();
      if (localObject2 == null)
      {
        HMSLog.e("HMSPackageManager", "Failed to find HMS apk");
        this.c = null;
        this.d = null;
        this.e = 0;
        return;
      }
      this.c = ((String)((Pair)localObject2).first);
      this.d = ((String)((Pair)localObject2).second);
      this.e = this.b.getPackageVersionCode(getHMSPackageName());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Succeed to find HMS apk: ");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(" version: ");
      ((StringBuilder)localObject2).append(this.e);
      HMSLog.i("HMSPackageManager", ((StringBuilder)localObject2).toString());
      return;
    }
  }
  
  public final boolean c()
  {
    Object localObject = this.a.getPackageManager();
    if (localObject == null)
    {
      HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
      return true;
    }
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(getHMSPackageName(), 128).applicationInfo;
      if ((localObject == null) || (((ApplicationInfo)localObject).metaData == null) || (!((ApplicationInfo)localObject).metaData.containsKey("com.huawei.hms.kit.api_level:hmscore")) || ((getHmsVersionCode() < 50000000) && (getHmsVersionCode() > 19999999))) {
        break label98;
      }
      HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label90:
      label98:
      break label90;
    }
    HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
    return true;
  }
  
  public String getHMSFingerprint()
  {
    String str2 = this.d;
    String str1 = str2;
    if (str2 == null) {
      str1 = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    }
    return str1;
  }
  
  public String getHMSPackageName()
  {
    refresh();
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = this.b.getPackageStates((String)localObject);
      if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(localObject))
      {
        HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
        b();
      }
      localObject = this.c;
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = this.b.getPackageStates("com.huawei.hwid");
    if ((!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(localObject)) && (this.b.getPackageSignature("com.huawei.hwid").equalsIgnoreCase("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05"))) {}
    return "com.huawei.hwid";
  }
  
  public PackageManagerHelper.PackageStates getHMSPackageStates()
  {
    if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.d)))
    {
      PackageManagerHelper.PackageStates localPackageStates2 = this.b.getPackageStates(this.c);
      PackageManagerHelper.PackageStates localPackageStates1 = localPackageStates2;
      if (localPackageStates2 == PackageManagerHelper.PackageStates.ENABLED)
      {
        localPackageStates1 = localPackageStates2;
        if (!this.d.equals(this.b.getPackageSignature(this.c))) {
          localPackageStates1 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
        }
      }
      return localPackageStates1;
    }
    b();
    return this.b.getPackageStates(this.c);
  }
  
  public int getHmsVersionCode()
  {
    return this.b.getPackageVersionCode(getHMSPackageName());
  }
  
  public boolean hmsVerHigherThan(int paramInt)
  {
    int i = this.e;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i < paramInt)
    {
      bool1 = bool2;
      if (c())
      {
        this.e = this.b.getPackageVersionCode(getHMSPackageName());
        if (this.e >= paramInt) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean isApkUpdateNecessary(int paramInt)
  {
    int i = getHmsVersionCode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("current versionCode:");
    localStringBuilder.append(i);
    localStringBuilder.append(", minimum version requirements: ");
    localStringBuilder.append(paramInt);
    HMSLog.i("HMSPackageManager", localStringBuilder.toString());
    return (c()) && (i < paramInt);
  }
  
  public void refresh()
  {
    if ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.d))) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.HMSPackageManager
 * JD-Core Version:    0.7.0.1
 */