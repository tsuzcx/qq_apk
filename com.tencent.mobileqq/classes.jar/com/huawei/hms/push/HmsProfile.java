package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.push.task.ProfileTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.ProfileReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.secure.android.common.encrypt.hash.SHA;

public class HmsProfile
{
  public static final int CUSTOM_PROFILE = 2;
  public static final int HUAWEI_PROFILE = 1;
  public static final String a = "HmsProfile";
  public Context b = null;
  public HuaweiApi<Api.ApiOptions.NoOptions> c;
  
  public HmsProfile(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    this.b = paramContext;
    Api localApi = new Api("HuaweiPush.API");
    if ((paramContext instanceof Activity)) {
      this.c = new HuaweiApi((Activity)paramContext, localApi, null, new PushClientBuilder());
    } else {
      this.c = new HuaweiApi(paramContext, localApi, null, new PushClientBuilder());
    }
    this.c.setKitSdkVersion(50101300);
  }
  
  public static String a(Context paramContext)
  {
    return AGConnectServicesConfig.fromContext(paramContext).getString("client/project_id");
  }
  
  public static HmsProfile getInstance(Context paramContext)
  {
    return new HmsProfile(paramContext);
  }
  
  public final Task<Void> a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (!isSupportProfile())
    {
      paramString1 = new TaskCompletionSource();
      paramString1.setException(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
      return paramString1.getTask();
    }
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = a(this.b);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        HMSLog.i(a, "agc connect services config missing project id.");
        paramString1 = new TaskCompletionSource();
        paramString1.setException(ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException());
        return paramString1.getTask();
      }
      str = paramString1;
      if (paramString1.equals(localObject)) {
        str = "";
      }
    }
    Object localObject = new ProfileReq();
    if (paramInt1 == 0)
    {
      ((ProfileReq)localObject).setOperation(0);
      ((ProfileReq)localObject).setType(paramInt2);
    }
    else
    {
      ((ProfileReq)localObject).setOperation(1);
    }
    paramString1 = PushBiUtil.reportEntry(this.b, "push.profile");
    try
    {
      ((ProfileReq)localObject).setSubjectId(str);
      ((ProfileReq)localObject).setProfileId(SHA.sha256Encrypt(paramString2));
      ((ProfileReq)localObject).setPkgName(this.b.getPackageName());
      paramString2 = this.c.doWrite(new ProfileTask("push.profile", JsonUtil.createJsonString((IMessageEntity)localObject), paramString1));
      return paramString2;
    }
    catch (Exception localException)
    {
      if ((localException.getCause() instanceof ApiException))
      {
        paramString2 = new TaskCompletionSource();
        ApiException localApiException = (ApiException)localException.getCause();
        paramString2.setException(localApiException);
        PushBiUtil.reportExit(this.b, "push.profile", paramString1, localApiException.getStatusCode());
        return paramString2.getTask();
      }
      paramString2 = new TaskCompletionSource();
      PushBiUtil.reportExit(this.b, "push.profile", paramString1, ErrorEnum.ERROR_INTERNAL_ERROR);
      paramString2.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
    }
    return paramString2.getTask();
  }
  
  public Task<Void> addProfile(int paramInt, String paramString)
  {
    return addProfile("", paramInt, paramString);
  }
  
  public Task<Void> addProfile(String paramString1, int paramInt, String paramString2)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      HMSLog.i(a, "add profile type undefined.");
      paramString1 = new TaskCompletionSource();
      paramString1.setException(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
      return paramString1.getTask();
    }
    if (TextUtils.isEmpty(paramString2))
    {
      HMSLog.i(a, "add profile params is empty.");
      paramString1 = new TaskCompletionSource();
      paramString1.setException(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
      return paramString1.getTask();
    }
    return a(0, paramString1, paramInt, paramString2);
  }
  
  public final boolean b(Context paramContext)
  {
    return s.b(paramContext) >= 110001400L;
  }
  
  public Task<Void> deleteProfile(String paramString)
  {
    return deleteProfile("", paramString);
  }
  
  public Task<Void> deleteProfile(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      HMSLog.e(a, "del profile params is empty.");
      paramString1 = new TaskCompletionSource();
      paramString1.setException(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
      return paramString1.getTask();
    }
    return a(1, paramString1, -1, paramString2);
  }
  
  public boolean isSupportProfile()
  {
    if (s.d(this.b))
    {
      if (s.c())
      {
        HMSLog.i(a, "current EMUI version below 9.1, not support profile operation.");
        return false;
      }
      if (!b(this.b))
      {
        HMSLog.i(a, "current HwPushService.apk version below 11.0.1.400,please upgrade your HwPushService.apk version.");
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.HmsProfile
 * JD-Core Version:    0.7.0.1
 */