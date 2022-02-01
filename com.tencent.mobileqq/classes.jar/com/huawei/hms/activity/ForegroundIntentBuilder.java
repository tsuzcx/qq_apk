package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.utils.Util;

public class ForegroundIntentBuilder
{
  private Activity a;
  private RequestHeader b;
  private String c;
  private ForegroundInnerHeader d;
  
  public ForegroundIntentBuilder(Activity paramActivity)
  {
    if (paramActivity == null) {
      throw new IllegalArgumentException("listener must not be null.");
    }
    this.a = paramActivity;
    this.b = new RequestHeader();
    this.b.setPkgName(paramActivity.getPackageName());
    this.b.setSdkVersion(50000301);
    this.c = "";
    this.d = new ForegroundInnerHeader();
    this.d.setApkVersion(30000000);
  }
  
  public static void registerResponseCallback(String paramString, BusResponseCallback paramBusResponseCallback)
  {
    ForegroundBusResponseMgr.getInstance().registerObserver(paramString, paramBusResponseCallback);
  }
  
  public static void unregisterResponseCallback(String paramString)
  {
    ForegroundBusResponseMgr.getInstance().unRegisterObserver(paramString);
  }
  
  public Intent build()
  {
    Intent localIntent = BridgeActivity.getIntentStartBridgeActivity(this.a, a.class.getName());
    if (this.b.getAppID() == null) {
      this.b.setAppID(Util.getAppId(this.a) + "|");
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.b.getTransactionId())) {
        this.b.setTransactionId(TransactionIdCreater.getId(this.b.getAppID(), "hub.request"));
      }
      localIntent.putExtra("HMS_FOREGROUND_REQ_HEADER", this.b.toJson());
      localIntent.putExtra("HMS_FOREGROUND_REQ_BODY", this.c);
      localIntent.putExtra("HMS_FOREGROUND_REQ_INNER", this.d.toJson());
      return localIntent;
      this.b.setAppID(Util.getAppId(this.a) + "|" + this.b.getAppID());
    }
  }
  
  public ForegroundIntentBuilder setAction(String paramString)
  {
    this.b.setApiName(paramString);
    return this;
  }
  
  public ForegroundIntentBuilder setKitSdkVersion(int paramInt)
  {
    this.b.setKitSdkVersion(paramInt);
    return this;
  }
  
  public ForegroundIntentBuilder setMinApkVersion(int paramInt)
  {
    this.d.setApkVersion(paramInt);
    return this;
  }
  
  public ForegroundIntentBuilder setRequestBody(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public ForegroundIntentBuilder setResponseCallback(String paramString)
  {
    this.d.setResponseCallbackKey(paramString);
    return this;
  }
  
  public ForegroundIntentBuilder setResponseCallback(String paramString, BusResponseCallback paramBusResponseCallback)
  {
    this.d.setResponseCallbackKey(paramString);
    ForegroundBusResponseMgr.getInstance().registerObserver(paramString, paramBusResponseCallback);
    return this;
  }
  
  public ForegroundIntentBuilder setServiceName(String paramString)
  {
    this.b.setSrvName(paramString);
    return this;
  }
  
  public ForegroundIntentBuilder setSubAppId(String paramString)
  {
    this.b.setAppID(paramString);
    return this;
  }
  
  public ForegroundIntentBuilder setTransactionId(String paramString)
  {
    this.b.setTransactionId(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.activity.ForegroundIntentBuilder
 * JD-Core Version:    0.7.0.1
 */