package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.stats.bs;
import com.huawei.hms.stats.bt.a;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.countrycode.CountryCodeBean;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class HMSBIInitializer
{
  private static final Object a = new Object();
  private static HMSBIInitializer b;
  private final Context c;
  private bt.a d;
  private AtomicBoolean e = new AtomicBoolean(false);
  
  private HMSBIInitializer(Context paramContext)
  {
    this.c = paramContext;
    this.d = new bt.a(this.c);
  }
  
  private void a(String paramString)
  {
    HMSLog.i("HMSBIInitializer", "Start to query GRS");
    GrsBaseInfo localGrsBaseInfo = new GrsBaseInfo();
    localGrsBaseInfo.setIssueCountry(paramString);
    new GrsClient(this.c, localGrsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOT", new HMSBIInitializer.1(this));
  }
  
  public static boolean getBiSetting(Context paramContext)
  {
    if (paramContext == null)
    {
      HMSLog.e("HMSBIInitializer", "In getBiSetting, context is null.");
      return false;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      HMSLog.e("HMSBIInitializer", "In getBiSetting, Failed to get 'PackageManager' instance.");
      return false;
    }
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 128).applicationInfo;
      if ((paramContext != null) && (paramContext.metaData != null)) {
        return paramContext.metaData.getBoolean("com.huawei.hms.client.bi.setting");
      }
      HMSLog.i("HMSBIInitializer", "In getBiSetting, Failed to read meta data bisetting.");
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      HMSLog.e("HMSBIInitializer", "In getBiSetting, Failed to read meta data bisetting.");
    }
    return false;
  }
  
  public static HMSBIInitializer getInstance(Context paramContext)
  {
    synchronized (a)
    {
      if (b == null) {
        b = new HMSBIInitializer(paramContext);
      }
      return b;
    }
  }
  
  public void initBI()
  {
    boolean bool = bs.b();
    HMSLog.i("HMSBIInitializer", "Builder->biInitFlag :" + bool);
    if (bool) {}
    do
    {
      return;
      bool = getBiSetting(this.c);
      HMSLog.i("HMSBIInitializer", "Builder->biSetting :" + bool);
    } while ((bool) || (!this.e.compareAndSet(false, true)));
    String str = new CountryCodeBean(this.c, false).a();
    if (TextUtils.isEmpty(str)) {}
    for (str = "CN"; "UNKNOWN".equalsIgnoreCase(str); str = str.toUpperCase(Locale.ENGLISH))
    {
      HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
      this.e.set(false);
      return;
    }
    new HMSBIInitializer.a(this, null).execute(new String[] { str });
  }
  
  public boolean isInit()
  {
    return bs.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.HMSBIInitializer
 * JD-Core Version:    0.7.0.1
 */