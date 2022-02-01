package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

public class a
  implements IBridgeActivityDelegate
{
  private RequestHeader a;
  private String b;
  private ForegroundInnerHeader c = new ForegroundInnerHeader();
  private ResponseHeader d;
  private WeakReference<Activity> e;
  
  private BusResponseCallback a(String paramString)
  {
    return ForegroundBusResponseMgr.getInstance().get(paramString);
  }
  
  private void a()
  {
    Activity localActivity = b();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    localActivity.finish();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    HMSLog.i("ForegroundBusDelegate", "succeedReturn");
    Activity localActivity = b();
    if (localActivity == null) {
      return;
    }
    localActivity.setResult(paramInt, paramIntent);
    a();
  }
  
  private void a(int paramInt, String paramString)
  {
    HMSLog.e("ForegroundBusDelegate", paramString);
    Activity localActivity = b();
    if (localActivity == null) {
      return;
    }
    BusResponseCallback localBusResponseCallback = a(this.c.getResponseCallbackKey());
    if (localBusResponseCallback != null)
    {
      paramString = localBusResponseCallback.innerError((Activity)this.e.get(), paramInt, paramString);
      if (paramString == null) {
        localActivity.setResult(0);
      }
    }
    for (;;)
    {
      a();
      return;
      localActivity.setResult(paramString.getCode(), paramString.getIntent());
      continue;
      localActivity.setResult(0);
    }
  }
  
  private static void a(Activity paramActivity, AvailableAdapter paramAvailableAdapter, AvailableAdapter.AvailableCallBack paramAvailableCallBack)
  {
    if (paramActivity == null) {
      HMSLog.i("ForegroundBusDelegate", "null activity, could not start resolution intent");
    }
    paramAvailableAdapter.startResolution(paramActivity, paramAvailableCallBack);
  }
  
  private Activity b()
  {
    if (this.e == null) {
      return null;
    }
    return (Activity)this.e.get();
  }
  
  private void c()
  {
    if (b() == null)
    {
      HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, activity must not be null.");
      return;
    }
    if (!Util.isAvailableLibExist(b().getApplicationContext()))
    {
      if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(b().getApplicationContext(), this.c.getApkVersion()) != 0)
      {
        HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, and no available lib exists.");
        return;
      }
      d();
      return;
    }
    a.a locala = new a.a(this, null);
    AvailableAdapter localAvailableAdapter = new AvailableAdapter(this.c.getApkVersion());
    int i = localAvailableAdapter.isHuaweiMobileServicesAvailable(b());
    if (i == 0)
    {
      locala.onComplete(i);
      return;
    }
    if (localAvailableAdapter.isUserResolvableError(i))
    {
      a(b(), localAvailableAdapter, locala);
      return;
    }
    locala.onComplete(i);
  }
  
  private void d()
  {
    HMSLog.i("ForegroundBusDelegate", "startApkHubActivity");
    Activity localActivity = b();
    if (localActivity == null)
    {
      HMSLog.e("ForegroundBusDelegate", "startApkHubActivity but activity is null");
      return;
    }
    String str = HMSPackageManager.getInstance(localActivity.getApplicationContext()).getHMSPackageName();
    Intent localIntent = new Intent(this.c.getAction());
    localIntent.putExtra("HMS_FOREGROUND_REQ_BODY", this.b);
    localIntent.setPackage(str);
    localIntent.setClassName(str, "com.huawei.hms.core.activity.UiJumpActivity");
    localIntent.putExtra("HMS_FOREGROUND_REQ_HEADER", this.a.toJson());
    localIntent.putExtra("intent.extra.hms.core.DELEGATE_NAME", "com.huawei.hms.core.activity.ForegroundBus");
    try
    {
      f();
      localActivity.startActivityForResult(localIntent, 431057);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      HMSLog.e("ForegroundBusDelegate", "Launch sign in Intent failed. hms is probably being updated：", localActivityNotFoundException);
      a(0, "launch bus intent failed");
    }
  }
  
  private void e()
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.a);
    localMap.put("direction", "req");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.a.getKitSdkVersion())));
    if (b() != null) {
      HiAnalyticsUtil.getInstance().onNewEvent(b().getApplicationContext(), "HMS_SDK_BASE_ACTIVITY_STARTED", localMap);
    }
  }
  
  private void f()
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.a);
    localMap.put("direction", "req");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.a.getKitSdkVersion())));
    if (b() != null) {
      HiAnalyticsUtil.getInstance().onNewEvent(b().getApplicationContext(), "HMS_SDK_BASE_START_CORE_ACTIVITY", localMap);
    }
  }
  
  private void g()
  {
    if (this.a != null)
    {
      Map localMap = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.a);
      localMap.put("direction", "rsp");
      localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.a.getKitSdkVersion())));
      if (this.d != null)
      {
        localMap.put("statusCode", String.valueOf(this.d.getStatusCode()));
        localMap.put("result", String.valueOf(this.d.getErrorCode()));
      }
      if (b() != null) {
        HiAnalyticsUtil.getInstance().onNewEvent(b().getApplicationContext(), "HMS_SDK_BASE_ACTIVITY_STARTED", localMap);
      }
    }
  }
  
  private void h()
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.a);
    localMap.put("direction", "rsp");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.a.getKitSdkVersion())));
    if (this.d != null)
    {
      localMap.put("statusCode", String.valueOf(this.d.getStatusCode()));
      localMap.put("result", String.valueOf(this.d.getErrorCode()));
    }
    if (b() != null) {
      HiAnalyticsUtil.getInstance().onNewEvent(b().getApplicationContext(), "HMS_SDK_BASE_START_CORE_ACTIVITY", localMap);
    }
  }
  
  public int getRequestCode()
  {
    return 431057;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    this.e = new WeakReference(paramActivity);
    paramActivity = paramActivity.getIntent();
    String str = paramActivity.getStringExtra("HMS_FOREGROUND_REQ_HEADER");
    this.a = new RequestHeader();
    if (!this.a.fromJson(str))
    {
      a(0, "header is invalid");
      return;
    }
    this.b = paramActivity.getStringExtra("HMS_FOREGROUND_REQ_BODY");
    this.c.fromJson(paramActivity.getStringExtra("HMS_FOREGROUND_REQ_INNER"));
    if (this.c == null)
    {
      a(0, "inner header is invalid");
      return;
    }
    if (TextUtils.isEmpty(this.a.getApiName()))
    {
      a(0, "action is invalid");
      return;
    }
    e();
    c();
  }
  
  public void onBridgeActivityDestroy()
  {
    g();
    this.e = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 431057)
    {
      if ((paramIntent != null) && (paramIntent.hasExtra("HMS_FOREGROUND_RESP_HEADER")))
      {
        localObject = paramIntent.getStringExtra("HMS_FOREGROUND_RESP_HEADER");
        this.d = new ResponseHeader();
        JsonUtil.jsonToEntity((String)localObject, this.d);
      }
      h();
      Object localObject = a(this.c.getResponseCallbackKey());
      if (localObject == null) {
        a(paramInt2, paramIntent);
      }
      for (;;)
      {
        return true;
        localObject = ((BusResponseCallback)localObject).succeedReturn((Activity)this.e.get(), paramInt2, paramIntent);
        if (localObject == null) {
          a(paramInt2, paramIntent);
        } else {
          a(((BusResponseResult)localObject).getCode(), ((BusResponseResult)localObject).getIntent());
        }
      }
    }
    return false;
  }
  
  public void onBridgeConfigurationChanged() {}
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.activity.a
 * JD-Core Version:    0.7.0.1
 */