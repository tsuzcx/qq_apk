package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.a;
import com.huawei.hms.stats.c;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class HMSBIInitializer
{
  public static final Object d = new Object();
  public static HMSBIInitializer e;
  public static HiAnalyticsInstance f;
  public final Context a;
  public AtomicBoolean b = new AtomicBoolean(false);
  public boolean c;
  
  public HMSBIInitializer(Context paramContext)
  {
    this.a = paramContext;
    this.c = c.a();
  }
  
  public static HMSBIInitializer getInstance(Context paramContext)
  {
    synchronized (d)
    {
      if (e == null)
      {
        Context localContext = paramContext.getApplicationContext();
        if (localContext != null) {
          e = new HMSBIInitializer(localContext);
        } else {
          e = new HMSBIInitializer(paramContext);
        }
      }
      return e;
    }
  }
  
  public final void a(String paramString)
  {
    HMSLog.i("HMSBIInitializer", "Start to query GRS");
    GrsBaseInfo localGrsBaseInfo = new GrsBaseInfo();
    localGrsBaseInfo.setIssueCountry(paramString);
    new GrsClient(this.a, localGrsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOT", new HMSBIInitializer.a(this));
  }
  
  public HiAnalyticsInstance getAnalyticsInstance()
  {
    return f;
  }
  
  public void initBI()
  {
    boolean bool;
    if (!this.c) {
      bool = HmsHiAnalyticsUtils.getInitFlag();
    } else {
      bool = HiAnalyticsManager.getInitFlag("hms_config_tag");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Builder->biInitFlag :");
    ((StringBuilder)localObject).append(bool);
    HMSLog.i("HMSBIInitializer", ((StringBuilder)localObject).toString());
    if (bool) {
      return;
    }
    if (a.c(this.a)) {
      return;
    }
    if (this.b.compareAndSet(false, true))
    {
      String str = GrsApp.getInstance().getIssueCountryCode(this.a);
      localObject = str;
      if (!TextUtils.isEmpty(str)) {
        localObject = str.toUpperCase(Locale.ENGLISH);
      }
      if ((!"UNKNOWN".equalsIgnoreCase((String)localObject)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        new HMSBIInitializer.b(this, null).execute(new String[] { localObject });
        return;
      }
      HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
      this.b.set(false);
    }
  }
  
  public boolean isInit()
  {
    if (!this.c) {
      return HmsHiAnalyticsUtils.getInitFlag();
    }
    return HiAnalyticsManager.getInitFlag("hms_config_tag");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.HMSBIInitializer
 * JD-Core Version:    0.7.0.1
 */