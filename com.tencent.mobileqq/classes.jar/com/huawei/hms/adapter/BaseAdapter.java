package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemNotifier;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.BaseResolutionAdapter;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

public class BaseAdapter
{
  private WeakReference<ApiClient> a;
  private WeakReference<Activity> b;
  private BaseAdapter.BaseCallBack c;
  private String d;
  private String e;
  private Parcelable f;
  private BaseAdapter.BaseCallBack g;
  private String h;
  private Context i;
  private RequestHeader j = new RequestHeader();
  private ResponseHeader k = new ResponseHeader();
  private SystemObserver l;
  
  public BaseAdapter(ApiClient paramApiClient)
  {
    this.a = new WeakReference(paramApiClient);
  }
  
  public BaseAdapter(ApiClient paramApiClient, Activity paramActivity)
  {
    this.a = new WeakReference(paramApiClient);
    this.b = new WeakReference(paramActivity);
    this.i = paramActivity.getApplicationContext();
  }
  
  private Activity a()
  {
    if (this.b == null)
    {
      HMSLog.i("BaseAdapter", "activityWeakReference is " + this.b);
      return null;
    }
    ApiClient localApiClient = (ApiClient)this.a.get();
    if (localApiClient == null)
    {
      HMSLog.i("BaseAdapter", "tmpApi is " + localApiClient);
      return null;
    }
    HMSLog.i("BaseAdapter", "activityWeakReference has " + this.b.get());
    return Util.getActiveActivity((Activity)this.b.get(), localApiClient.getContext());
  }
  
  private PendingResult<ResolveResult<CoreBaseResponse>> a(ApiClient paramApiClient, String paramString, CoreBaseRequest paramCoreBaseRequest)
  {
    return new BaseAdapter.a(paramApiClient, paramString, paramCoreBaseRequest);
  }
  
  private String a(int paramInt)
  {
    this.k.setTransactionId(this.j.getTransactionId());
    this.k.setAppID(this.j.getAppID());
    this.k.setApiName(this.j.getApiName());
    this.k.setSrvName(this.j.getSrvName());
    this.k.setPkgName(this.j.getPkgName());
    this.k.setStatusCode(1);
    this.k.setErrorCode(paramInt);
    this.k.setErrorReason("Core error");
    return this.k.toJson();
  }
  
  private void a(Activity paramActivity, Parcelable paramParcelable)
  {
    HMSLog.i("BaseAdapter", "startResolution");
    if (this.j != null) {
      b(this.i, this.j);
    }
    if (this.l == null) {
      i();
    }
    SystemManager.getSystemNotifier().registerObserver(this.l);
    Intent localIntent = BridgeActivity.getIntentStartBridgeActivity(paramActivity, BaseResolutionAdapter.class.getName());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("resolution", paramParcelable);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("transaction_id", this.h);
    paramActivity.startActivity(localIntent);
  }
  
  private void a(Context paramContext, RequestHeader paramRequestHeader)
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(paramRequestHeader);
    localMap.put("direction", "req");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(paramRequestHeader.getKitSdkVersion())));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_CALL_AIDL", localMap);
  }
  
  private void a(Context paramContext, ResponseHeader paramResponseHeader)
  {
    HiAnalyticsUtil.getInstance();
    paramResponseHeader = HiAnalyticsUtil.getMapFromRequestHeader(paramResponseHeader);
    paramResponseHeader.put("direction", "rsp");
    paramResponseHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.j.getKitSdkVersion())));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_CALL_AIDL", paramResponseHeader);
  }
  
  private void a(Context paramContext, ResponseHeader paramResponseHeader, long paramLong)
  {
    HiAnalyticsUtil.getInstance();
    paramResponseHeader = HiAnalyticsUtil.getMapFromRequestHeader(paramResponseHeader);
    paramResponseHeader.put("direction", "rsp");
    paramResponseHeader.put("waitTime", String.valueOf(paramLong));
    paramResponseHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.j.getKitSdkVersion())));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_START_RESOLUTION", paramResponseHeader);
  }
  
  private void a(Parcelable paramParcelable)
  {
    this.f = paramParcelable;
  }
  
  private void a(BaseAdapter.BaseCallBack paramBaseCallBack)
  {
    this.g = paramBaseCallBack;
  }
  
  private void a(String paramString)
  {
    this.d = paramString;
  }
  
  private void a(String paramString1, String paramString2, Parcelable paramParcelable, BaseAdapter.BaseCallBack paramBaseCallBack)
  {
    a(paramString1);
    b(paramString2);
    a(paramParcelable);
    a(paramBaseCallBack);
  }
  
  private BaseAdapter.BaseCallBack b()
  {
    if (this.c == null)
    {
      HMSLog.e("BaseAdapter", "callback null");
      return null;
    }
    return this.c;
  }
  
  private void b(Context paramContext, RequestHeader paramRequestHeader)
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(paramRequestHeader);
    localMap.put("direction", "req");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(paramRequestHeader.getKitSdkVersion())));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_START_RESOLUTION", localMap);
  }
  
  private void b(String paramString)
  {
    this.e = paramString;
  }
  
  private String c()
  {
    return this.d;
  }
  
  private String d()
  {
    return this.e;
  }
  
  private Parcelable e()
  {
    return this.f;
  }
  
  private BaseAdapter.BaseCallBack f()
  {
    return this.g;
  }
  
  private void g()
  {
    this.k = null;
    this.k = new ResponseHeader();
    baseRequest(c(), d(), e(), f());
    h();
  }
  
  private void h()
  {
    a(null);
    b(null);
    a(null);
    a(null);
  }
  
  private void i()
  {
    this.l = new BaseAdapter.1(this);
  }
  
  public void baseRequest(String paramString1, String paramString2, Parcelable paramParcelable, BaseAdapter.BaseCallBack paramBaseCallBack)
  {
    a(paramString1, paramString2, paramParcelable, paramBaseCallBack);
    if (this.a == null)
    {
      HMSLog.e("BaseAdapter", "client is null");
      h();
      paramBaseCallBack.onError(a(-2));
      return;
    }
    ApiClient localApiClient = (ApiClient)this.a.get();
    this.c = paramBaseCallBack;
    JsonUtil.jsonToEntity(paramString1, this.j);
    CoreBaseRequest localCoreBaseRequest = new CoreBaseRequest();
    localCoreBaseRequest.setJsonObject(paramString2);
    localCoreBaseRequest.setJsonHeader(paramString1);
    localCoreBaseRequest.setParcelable(paramParcelable);
    paramString1 = this.j.getApiName();
    if (TextUtils.isEmpty(paramString1))
    {
      HMSLog.e("BaseAdapter", "get uri null");
      h();
      paramBaseCallBack.onError(a(-5));
      return;
    }
    this.h = this.j.getTransactionId();
    if (TextUtils.isEmpty(this.h))
    {
      HMSLog.e("BaseAdapter", "get transactionId null");
      h();
      paramBaseCallBack.onError(a(-6));
      return;
    }
    HMSLog.i("BaseAdapter", "in baseRequest + uri is :" + paramString1 + ", transactionId is : " + this.h);
    a(this.i, this.j);
    a(localApiClient, paramString1, localCoreBaseRequest).setResultCallback(new BaseAdapter.BaseRequestResultCallback(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.adapter.BaseAdapter
 * JD-Core Version:    0.7.0.1
 */