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
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseAdapter
{
  private static final String TAG = "BaseAdapter";
  private WeakReference<Activity> activityWeakReference;
  private WeakReference<ApiClient> api;
  private Context appContext;
  private BaseAdapter.BaseCallBack baseCallBackReplay;
  private BaseAdapter.BaseCallBack callback;
  private String jsonHeaderReplay;
  private String jsonObjectReplay;
  private SystemObserver observer;
  private Parcelable parcelableReplay;
  private RequestHeader requestHeader = new RequestHeader();
  private ResponseHeader responseHeader = new ResponseHeader();
  private String transactionId;
  
  public BaseAdapter(ApiClient paramApiClient)
  {
    this.api = new WeakReference(paramApiClient);
  }
  
  public BaseAdapter(ApiClient paramApiClient, Activity paramActivity)
  {
    this.api = new WeakReference(paramApiClient);
    this.activityWeakReference = new WeakReference(paramActivity);
    this.appContext = paramActivity.getApplicationContext();
  }
  
  private PendingResult<ResolveResult<CoreBaseResponse>> baseRequest(ApiClient paramApiClient, String paramString, CoreBaseRequest paramCoreBaseRequest)
  {
    return new BaseAdapter.MPendingResultImpl(paramApiClient, paramString, paramCoreBaseRequest);
  }
  
  private void biReportRequestEntryIpc(Context paramContext, RequestHeader paramRequestHeader)
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(paramRequestHeader);
    localMap.put("direction", "req");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(paramRequestHeader.getKitSdkVersion())));
    localMap.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_CALL_AIDL", localMap);
  }
  
  private void biReportRequestEntrySolution(Context paramContext, RequestHeader paramRequestHeader)
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(paramRequestHeader);
    localMap.put("direction", "req");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(paramRequestHeader.getKitSdkVersion())));
    localMap.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_START_RESOLUTION", localMap);
  }
  
  private void biReportRequestReturnIpc(Context paramContext, ResponseHeader paramResponseHeader)
  {
    HiAnalyticsUtil.getInstance();
    paramResponseHeader = HiAnalyticsUtil.getMapFromRequestHeader(paramResponseHeader);
    paramResponseHeader.put("direction", "rsp");
    paramResponseHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion())));
    paramResponseHeader.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_CALL_AIDL", paramResponseHeader);
  }
  
  private void biReportRequestReturnSolution(Context paramContext, ResponseHeader paramResponseHeader, long paramLong)
  {
    HiAnalyticsUtil.getInstance();
    paramResponseHeader = HiAnalyticsUtil.getMapFromRequestHeader(paramResponseHeader);
    paramResponseHeader.put("direction", "rsp");
    paramResponseHeader.put("waitTime", String.valueOf(paramLong));
    paramResponseHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion())));
    paramResponseHeader.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_START_RESOLUTION", paramResponseHeader);
  }
  
  private String buildBodyStr(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errorCode", paramInt);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buildBodyStr failed: ");
      localStringBuilder.append(localJSONException.getMessage());
      HMSLog.e("BaseAdapter", localStringBuilder.toString());
    }
    return localJSONObject.toString();
  }
  
  private ResponseWrap buildResponseWrap(int paramInt, String paramString)
  {
    setResponseHeader(paramInt);
    ResponseWrap localResponseWrap = new ResponseWrap(this.responseHeader);
    localResponseWrap.setBody(paramString);
    return localResponseWrap;
  }
  
  private BaseAdapter.BaseCallBack getBaseCallBackReplay()
  {
    return this.baseCallBackReplay;
  }
  
  private BaseAdapter.BaseCallBack getCallBack()
  {
    BaseAdapter.BaseCallBack localBaseCallBack2 = this.callback;
    BaseAdapter.BaseCallBack localBaseCallBack1 = localBaseCallBack2;
    if (localBaseCallBack2 == null)
    {
      HMSLog.e("BaseAdapter", "callback null");
      localBaseCallBack1 = null;
    }
    return localBaseCallBack1;
  }
  
  private Activity getCpActivity()
  {
    if (this.activityWeakReference == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("activityWeakReference is ");
      ((StringBuilder)localObject).append(this.activityWeakReference);
      HMSLog.i("BaseAdapter", ((StringBuilder)localObject).toString());
      return null;
    }
    Object localObject = (ApiClient)this.api.get();
    if (localObject == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("tmpApi is ");
      localStringBuilder.append(localObject);
      HMSLog.i("BaseAdapter", localStringBuilder.toString());
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activityWeakReference has ");
    localStringBuilder.append(this.activityWeakReference.get());
    HMSLog.i("BaseAdapter", localStringBuilder.toString());
    return Util.getActiveActivity((Activity)this.activityWeakReference.get(), ((ApiClient)localObject).getContext());
  }
  
  private String getJsonHeaderReplay()
  {
    return this.jsonHeaderReplay;
  }
  
  private String getJsonObjectReplay()
  {
    return this.jsonObjectReplay;
  }
  
  private Parcelable getParcelableReplay()
  {
    return this.parcelableReplay;
  }
  
  private String getResponseHeaderForError(int paramInt)
  {
    setResponseHeader(paramInt);
    return this.responseHeader.toJson();
  }
  
  private void initObserver()
  {
    this.observer = new BaseAdapter.1(this);
  }
  
  private void replayRequest()
  {
    if (this.jsonHeaderReplay != null)
    {
      if (this.baseCallBackReplay == null) {
        return;
      }
      this.responseHeader = null;
      this.responseHeader = new ResponseHeader();
      baseRequest(getJsonHeaderReplay(), getJsonObjectReplay(), getParcelableReplay(), getBaseCallBackReplay());
    }
  }
  
  private void setBaseCallBackReplay(BaseAdapter.BaseCallBack paramBaseCallBack)
  {
    this.baseCallBackReplay = paramBaseCallBack;
  }
  
  private void setJsonHeaderReplay(String paramString)
  {
    this.jsonHeaderReplay = paramString;
  }
  
  private void setJsonObjectReplay(String paramString)
  {
    this.jsonObjectReplay = paramString;
  }
  
  private void setParcelableReplay(Parcelable paramParcelable)
  {
    this.parcelableReplay = paramParcelable;
  }
  
  private void setReplayData(String paramString1, String paramString2, Parcelable paramParcelable, BaseAdapter.BaseCallBack paramBaseCallBack)
  {
    setJsonHeaderReplay(paramString1);
    setJsonObjectReplay(paramString2);
    setParcelableReplay(paramParcelable);
    setBaseCallBackReplay(paramBaseCallBack);
  }
  
  private void setResponseHeader(int paramInt)
  {
    this.responseHeader.setTransactionId(this.requestHeader.getTransactionId());
    this.responseHeader.setAppID(this.requestHeader.getAppID());
    this.responseHeader.setApiName(this.requestHeader.getApiName());
    this.responseHeader.setSrvName(this.requestHeader.getSrvName());
    this.responseHeader.setPkgName(this.requestHeader.getPkgName());
    this.responseHeader.setStatusCode(1);
    this.responseHeader.setErrorCode(paramInt);
    this.responseHeader.setErrorReason("Core error");
  }
  
  private void startResolution(Activity paramActivity, Parcelable paramParcelable)
  {
    HMSLog.i("BaseAdapter", "startResolution");
    Object localObject = this.requestHeader;
    if (localObject != null) {
      biReportRequestEntrySolution(this.appContext, (RequestHeader)localObject);
    }
    if (this.observer == null) {
      initObserver();
    }
    SystemManager.getSystemNotifier().registerObserver(this.observer);
    localObject = BridgeActivity.getIntentStartBridgeActivity(paramActivity, BaseResolutionAdapter.class.getName());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("resolution", paramParcelable);
    ((Intent)localObject).putExtras(localBundle);
    ((Intent)localObject).putExtra("transaction_id", this.transactionId);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public void baseRequest(String paramString1, String paramString2, Parcelable paramParcelable, BaseAdapter.BaseCallBack paramBaseCallBack)
  {
    setReplayData(paramString1, paramString2, paramParcelable, paramBaseCallBack);
    if (this.api == null)
    {
      HMSLog.e("BaseAdapter", "client is null");
      paramBaseCallBack.onError(getResponseHeaderForError(-2));
      return;
    }
    this.callback = paramBaseCallBack;
    JsonUtil.jsonToEntity(paramString1, this.requestHeader);
    CoreBaseRequest localCoreBaseRequest = new CoreBaseRequest();
    localCoreBaseRequest.setJsonObject(paramString2);
    localCoreBaseRequest.setJsonHeader(paramString1);
    localCoreBaseRequest.setParcelable(paramParcelable);
    paramString1 = this.requestHeader.getApiName();
    if (TextUtils.isEmpty(paramString1))
    {
      HMSLog.e("BaseAdapter", "get uri null");
      paramBaseCallBack.onError(getResponseHeaderForError(-5));
      return;
    }
    this.transactionId = this.requestHeader.getTransactionId();
    if (TextUtils.isEmpty(this.transactionId))
    {
      HMSLog.e("BaseAdapter", "get transactionId null");
      paramBaseCallBack.onError(getResponseHeaderForError(-6));
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("in baseRequest + uri is :");
    paramString2.append(paramString1);
    paramString2.append(", transactionId is : ");
    paramString2.append(this.transactionId);
    HMSLog.i("BaseAdapter", paramString2.toString());
    biReportRequestEntryIpc(this.appContext, this.requestHeader);
    baseRequest((ApiClient)this.api.get(), paramString1, localCoreBaseRequest).setResultCallback(new BaseAdapter.BaseRequestResultCallback(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.adapter.BaseAdapter
 * JD-Core Version:    0.7.0.1
 */