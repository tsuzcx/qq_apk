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
  private Activity activity;
  private String foregroundBody;
  private RequestHeader foregroundHeader;
  private ForegroundInnerHeader innerHeader;
  
  public ForegroundIntentBuilder(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      this.activity = paramActivity;
      this.foregroundHeader = new RequestHeader();
      this.foregroundHeader.setPkgName(paramActivity.getPackageName());
      this.foregroundHeader.setSdkVersion(50200300);
      this.foregroundBody = "";
      this.innerHeader = new ForegroundInnerHeader();
      this.innerHeader.setApkVersion(30000000);
      return;
    }
    throw new IllegalArgumentException("listener must not be null.");
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
    Intent localIntent = BridgeActivity.getIntentStartBridgeActivity(this.activity, ForegroundBusDelegate.class.getName());
    RequestHeader localRequestHeader;
    StringBuilder localStringBuilder;
    if (this.foregroundHeader.getAppID() == null)
    {
      localRequestHeader = this.foregroundHeader;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Util.getAppId(this.activity));
      localStringBuilder.append("|");
      localRequestHeader.setAppID(localStringBuilder.toString());
    }
    else
    {
      localRequestHeader = this.foregroundHeader;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Util.getAppId(this.activity));
      localStringBuilder.append("|");
      localStringBuilder.append(this.foregroundHeader.getAppID());
      localRequestHeader.setAppID(localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(this.foregroundHeader.getTransactionId()))
    {
      localRequestHeader = this.foregroundHeader;
      localRequestHeader.setTransactionId(TransactionIdCreater.getId(localRequestHeader.getAppID(), "hub.request"));
    }
    localIntent.putExtra("HMS_FOREGROUND_REQ_HEADER", this.foregroundHeader.toJson());
    localIntent.putExtra("HMS_FOREGROUND_REQ_BODY", this.foregroundBody);
    localIntent.putExtra("HMS_FOREGROUND_REQ_INNER", this.innerHeader.toJson());
    return localIntent;
  }
  
  public ForegroundIntentBuilder setAction(String paramString)
  {
    this.foregroundHeader.setApiName(paramString);
    return this;
  }
  
  public ForegroundIntentBuilder setApiLevel(int paramInt)
  {
    this.foregroundHeader.setApiLevel(paramInt);
    return this;
  }
  
  public ForegroundIntentBuilder setKitSdkVersion(int paramInt)
  {
    this.foregroundHeader.setKitSdkVersion(paramInt);
    return this;
  }
  
  public ForegroundIntentBuilder setMinApkVersion(int paramInt)
  {
    this.innerHeader.setApkVersion(paramInt);
    return this;
  }
  
  public ForegroundIntentBuilder setRequestBody(String paramString)
  {
    this.foregroundBody = paramString;
    return this;
  }
  
  public ForegroundIntentBuilder setResponseCallback(String paramString)
  {
    this.innerHeader.setResponseCallbackKey(paramString);
    return this;
  }
  
  public ForegroundIntentBuilder setResponseCallback(String paramString, BusResponseCallback paramBusResponseCallback)
  {
    this.innerHeader.setResponseCallbackKey(paramString);
    ForegroundBusResponseMgr.getInstance().registerObserver(paramString, paramBusResponseCallback);
    return this;
  }
  
  public ForegroundIntentBuilder setServiceName(String paramString)
  {
    this.foregroundHeader.setSrvName(paramString);
    return this;
  }
  
  public ForegroundIntentBuilder setSubAppId(String paramString)
  {
    this.foregroundHeader.setAppID(paramString);
    return this;
  }
  
  public ForegroundIntentBuilder setTransactionId(String paramString)
  {
    this.foregroundHeader.setTransactionId(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.activity.ForegroundIntentBuilder
 * JD-Core Version:    0.7.0.1
 */