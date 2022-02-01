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

public class ForegroundBusDelegate
  implements IBridgeActivityDelegate
{
  private static final String EXTRA_DELEGATE_NAME = "intent.extra.hms.core.DELEGATE_NAME";
  private static final String EXTRA_DELEGATE_VALUE = "com.huawei.hms.core.activity.ForegroundBus";
  public static final String HMS_FOREGROUND_REQ_BODY = "HMS_FOREGROUND_REQ_BODY";
  public static final String HMS_FOREGROUND_REQ_HEADER = "HMS_FOREGROUND_REQ_HEADER";
  public static final String HMS_FOREGROUND_REQ_INNER = "HMS_FOREGROUND_REQ_INNER";
  public static final String HMS_FOREGROUND_RESP_HEADER = "HMS_FOREGROUND_RESP_HEADER";
  private static final int REQUEST_CODE_BUS = 431057;
  private static final String TAG = "ForegroundBusDelegate";
  private static final String UI_JUMP_ACTIVITY_NAME = "com.huawei.hms.core.activity.UiJumpActivity";
  private String foregroundBody;
  private RequestHeader foregroundHeader;
  private ForegroundInnerHeader innerHeader = new ForegroundInnerHeader();
  private WeakReference<Activity> mThisWeakRef;
  private ResponseHeader responseHeader;
  
  private void biReportRequestEntryForegroundBus()
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
    localMap.put("direction", "req");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
    if (getActivity() != null) {
      HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), "HMS_SDK_BASE_ACTIVITY_STARTED", localMap);
    }
  }
  
  private void biReportRequestEntryStartCore()
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
    localMap.put("direction", "req");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
    if (getActivity() != null) {
      HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), "HMS_SDK_BASE_START_CORE_ACTIVITY", localMap);
    }
  }
  
  private void biReportRequestReturnForegroundBus()
  {
    if (this.foregroundHeader != null)
    {
      Map localMap = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
      localMap.put("direction", "rsp");
      localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
      ResponseHeader localResponseHeader = this.responseHeader;
      if (localResponseHeader != null)
      {
        localMap.put("statusCode", String.valueOf(localResponseHeader.getStatusCode()));
        localMap.put("result", String.valueOf(this.responseHeader.getErrorCode()));
      }
      if (getActivity() != null) {
        HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), "HMS_SDK_BASE_ACTIVITY_STARTED", localMap);
      }
    }
  }
  
  private void biReportRequestReturnStartCore()
  {
    Map localMap = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
    localMap.put("direction", "rsp");
    localMap.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
    ResponseHeader localResponseHeader = this.responseHeader;
    if (localResponseHeader != null)
    {
      localMap.put("statusCode", String.valueOf(localResponseHeader.getStatusCode()));
      localMap.put("result", String.valueOf(this.responseHeader.getErrorCode()));
    }
    if (getActivity() != null) {
      HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), "HMS_SDK_BASE_START_CORE_ACTIVITY", localMap);
    }
  }
  
  private void checkMinVersion()
  {
    if (getActivity() == null)
    {
      HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, activity must not be null.");
      return;
    }
    if (!Util.isAvailableLibExist(getActivity().getApplicationContext()))
    {
      if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(getActivity().getApplicationContext(), this.innerHeader.getApkVersion()) != 0)
      {
        HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, and no available lib exists.");
        return;
      }
      startApkHubActivity();
      return;
    }
    ForegroundBusDelegate.MyAvailableCallBack localMyAvailableCallBack = new ForegroundBusDelegate.MyAvailableCallBack(this, null);
    AvailableAdapter localAvailableAdapter = new AvailableAdapter(this.innerHeader.getApkVersion());
    int i = localAvailableAdapter.isHuaweiMobileServicesAvailable(getActivity());
    if (i == 0)
    {
      localMyAvailableCallBack.onComplete(i);
      return;
    }
    if (localAvailableAdapter.isUserResolvableError(i))
    {
      resolution(getActivity(), localAvailableAdapter, localMyAvailableCallBack);
      return;
    }
    localMyAvailableCallBack.onComplete(i);
  }
  
  private void errorReturn(int paramInt, String paramString)
  {
    HMSLog.e("ForegroundBusDelegate", paramString);
    Activity localActivity = getActivity();
    if (localActivity == null) {
      return;
    }
    BusResponseCallback localBusResponseCallback = getResponseCallback(this.innerHeader.getResponseCallbackKey());
    if (localBusResponseCallback != null)
    {
      paramString = localBusResponseCallback.innerError((Activity)this.mThisWeakRef.get(), paramInt, paramString);
      if (paramString == null) {
        localActivity.setResult(0);
      } else {
        localActivity.setResult(paramString.getCode(), paramString.getIntent());
      }
    }
    else
    {
      localActivity.setResult(0);
    }
    finishBridgeActivity();
  }
  
  private void finishBridgeActivity()
  {
    Activity localActivity = getActivity();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      localActivity.finish();
    }
  }
  
  private Activity getActivity()
  {
    WeakReference localWeakReference = this.mThisWeakRef;
    if (localWeakReference == null) {
      return null;
    }
    return (Activity)localWeakReference.get();
  }
  
  private BusResponseCallback getResponseCallback(String paramString)
  {
    return ForegroundBusResponseMgr.getInstance().get(paramString);
  }
  
  private static void resolution(Activity paramActivity, AvailableAdapter paramAvailableAdapter, AvailableAdapter.AvailableCallBack paramAvailableCallBack)
  {
    if (paramActivity == null) {
      HMSLog.i("ForegroundBusDelegate", "null activity, could not start resolution intent");
    }
    paramAvailableAdapter.startResolution(paramActivity, paramAvailableCallBack);
  }
  
  private void startApkHubActivity()
  {
    HMSLog.i("ForegroundBusDelegate", "startApkHubActivity");
    Activity localActivity = getActivity();
    if (localActivity == null)
    {
      HMSLog.e("ForegroundBusDelegate", "startApkHubActivity but activity is null");
      return;
    }
    String str = HMSPackageManager.getInstance(localActivity.getApplicationContext()).getHMSPackageName();
    Intent localIntent = new Intent(this.innerHeader.getAction());
    localIntent.putExtra("HMS_FOREGROUND_REQ_BODY", this.foregroundBody);
    localIntent.setPackage(str);
    localIntent.setClassName(str, "com.huawei.hms.core.activity.UiJumpActivity");
    localIntent.putExtra("HMS_FOREGROUND_REQ_HEADER", this.foregroundHeader.toJson());
    localIntent.putExtra("intent.extra.hms.core.DELEGATE_NAME", "com.huawei.hms.core.activity.ForegroundBus");
    try
    {
      biReportRequestEntryStartCore();
      localActivity.startActivityForResult(localIntent, 431057);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      HMSLog.e("ForegroundBusDelegate", "Launch sign in Intent failed. hms is probably being updated：", localActivityNotFoundException);
      errorReturn(0, "launch bus intent failed");
    }
  }
  
  private void succeedReturn(int paramInt, Intent paramIntent)
  {
    HMSLog.i("ForegroundBusDelegate", "succeedReturn");
    Activity localActivity = getActivity();
    if (localActivity == null) {
      return;
    }
    localActivity.setResult(paramInt, paramIntent);
    finishBridgeActivity();
  }
  
  public int getRequestCode()
  {
    return 431057;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    this.mThisWeakRef = new WeakReference(paramActivity);
    paramActivity = paramActivity.getIntent();
    String str = paramActivity.getStringExtra("HMS_FOREGROUND_REQ_HEADER");
    this.foregroundHeader = new RequestHeader();
    if (!this.foregroundHeader.fromJson(str))
    {
      errorReturn(0, "header is invalid");
      return;
    }
    this.foregroundBody = paramActivity.getStringExtra("HMS_FOREGROUND_REQ_BODY");
    this.innerHeader.fromJson(paramActivity.getStringExtra("HMS_FOREGROUND_REQ_INNER"));
    if (this.innerHeader == null)
    {
      errorReturn(0, "inner header is invalid");
      return;
    }
    if (TextUtils.isEmpty(this.foregroundHeader.getApiName()))
    {
      errorReturn(0, "action is invalid");
      return;
    }
    biReportRequestEntryForegroundBus();
    checkMinVersion();
  }
  
  public void onBridgeActivityDestroy()
  {
    biReportRequestReturnForegroundBus();
    this.mThisWeakRef = null;
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 431057)
    {
      if ((paramIntent != null) && (paramIntent.hasExtra("HMS_FOREGROUND_RESP_HEADER")))
      {
        localObject = paramIntent.getStringExtra("HMS_FOREGROUND_RESP_HEADER");
        this.responseHeader = new ResponseHeader();
        JsonUtil.jsonToEntity((String)localObject, this.responseHeader);
      }
      biReportRequestReturnStartCore();
      Object localObject = getResponseCallback(this.innerHeader.getResponseCallbackKey());
      if (localObject == null)
      {
        succeedReturn(paramInt2, paramIntent);
      }
      else
      {
        localObject = ((BusResponseCallback)localObject).succeedReturn((Activity)this.mThisWeakRef.get(), paramInt2, paramIntent);
        if (localObject == null) {
          succeedReturn(paramInt2, paramIntent);
        } else {
          succeedReturn(((BusResponseResult)localObject).getCode(), ((BusResponseResult)localObject).getIntent());
        }
      }
      return true;
    }
    return false;
  }
  
  public void onBridgeConfigurationChanged() {}
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.activity.ForegroundBusDelegate
 * JD-Core Version:    0.7.0.1
 */