package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.j;
import com.huawei.hms.opendevice.k;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;

public class HmsInstanceId
{
  public static final String TAG = "HmsInstanceId";
  public Context a;
  public PushPreferences b;
  public HuaweiApi<Api.ApiOptions.NoOptions> c;
  
  public HmsInstanceId(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = new PushPreferences(paramContext, "aaid");
    Api localApi = new Api("HuaweiPush.API");
    if ((paramContext instanceof Activity)) {
      this.c = new HuaweiApi((Activity)paramContext, localApi, null, new PushClientBuilder());
    } else {
      this.c = new HuaweiApi(paramContext, localApi, null, new PushClientBuilder());
    }
    this.c.setKitSdkVersion(50101300);
  }
  
  public static HmsInstanceId getInstance(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    c.d(paramContext);
    return new HmsInstanceId(paramContext);
  }
  
  public final String a(TokenReq paramTokenReq, int paramInt)
  {
    if (ProxyCenter.getProxy() != null)
    {
      HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
      ProxyCenter.getProxy().getToken(this.a, paramTokenReq.getSubjectId(), null);
      return null;
    }
    a(paramTokenReq.getSubjectId());
    String str1 = q.a(this.a, "push.gettoken");
    try
    {
      String str2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getToken req :");
      localStringBuilder.append(paramTokenReq.toString());
      HMSLog.d(str2, localStringBuilder.toString());
      paramTokenReq = new l("push.gettoken", paramTokenReq, this.a, str1);
      paramTokenReq.setApiLevel(paramInt);
      paramTokenReq = ((TokenResult)Tasks.await(this.c.doWrite(paramTokenReq))).getToken();
      return paramTokenReq;
    }
    catch (Exception paramTokenReq)
    {
      if ((paramTokenReq.getCause() instanceof ApiException))
      {
        paramTokenReq = (ApiException)paramTokenReq.getCause();
        q.a(this.a, "push.gettoken", str1, paramTokenReq.getStatusCode());
        throw paramTokenReq;
      }
      q.a(this.a, "push.gettoken", str1, ErrorEnum.ERROR_INTERNAL_ERROR);
      throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
    }
  }
  
  public final void a()
  {
    if ((BaseUtils.getProxyInit(this.a)) && (ProxyCenter.getProxy() == null))
    {
      if (BaseUtils.isMainProc(this.a)) {
        return;
      }
      HMSLog.e(TAG, "Operations in child processes are not supported.");
      throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
    }
  }
  
  public final void a(DeleteTokenReq paramDeleteTokenReq, int paramInt)
  {
    String str2 = paramDeleteTokenReq.getSubjectId();
    if (ProxyCenter.getProxy() != null)
    {
      HMSLog.i(TAG, "use proxy delete token");
      ProxyCenter.getProxy().deleteToken(this.a, str2, null);
      return;
    }
    String str1 = q.a(this.a, "push.deletetoken");
    try
    {
      String str3 = i.a(this.a).b(str2);
      if ((paramDeleteTokenReq.isMultiSender()) && ((TextUtils.isEmpty(str3)) || (str3.equals(i.a(this.a).b(null)))))
      {
        i.a(this.a).removeKey(str2);
        paramDeleteTokenReq = TAG;
        HMSLog.i(paramDeleteTokenReq, "The local subject token is null");
        return;
      }
      paramDeleteTokenReq.setToken(str3);
      paramDeleteTokenReq = new k("push.deletetoken", paramDeleteTokenReq, str1);
      paramDeleteTokenReq.setApiLevel(paramInt);
      Tasks.await(this.c.doWrite(paramDeleteTokenReq));
      i.a(this.a).c(str2);
      return;
    }
    catch (Exception paramDeleteTokenReq)
    {
      if ((paramDeleteTokenReq.getCause() instanceof ApiException))
      {
        paramDeleteTokenReq = (ApiException)paramDeleteTokenReq.getCause();
        q.a(this.a, "push.deletetoken", str1, paramDeleteTokenReq.getStatusCode());
        throw paramDeleteTokenReq;
      }
      q.a(this.a, "push.deletetoken", str1, ErrorEnum.ERROR_INTERNAL_ERROR);
      throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
    }
  }
  
  public final void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (p.c(this.a))
    {
      String str = i.a(this.a).getString("subjectId");
      if (TextUtils.isEmpty(str))
      {
        i.a(this.a).saveString("subjectId", paramString);
        return;
      }
      if (!str.contains(paramString))
      {
        i locali = i.a(this.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(",");
        localStringBuilder.append(paramString);
        locali.saveString("subjectId", localStringBuilder.toString());
      }
    }
    else
    {
      i.a(this.a).removeKey("subjectId");
    }
  }
  
  public final void b()
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      return;
    }
    throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
  }
  
  public void deleteAAID()
  {
    b();
    try
    {
      if (!this.b.containsKey("aaid")) {
        return;
      }
      this.b.removeKey("aaid");
      Object localObject = this.b;
      ((PushPreferences)localObject).removeKey("creationTime");
      if (!o.e(this.a)) {
        return;
      }
      if (ProxyCenter.getProxy() != null)
      {
        localObject = TAG;
        HMSLog.i((String)localObject, "use proxy delete all token after delete AaId.");
        ProxyCenter.getProxy().deleteAllToken(this.a);
        return;
      }
      localObject = o.b(this.a);
      ((DeleteTokenReq)localObject).setDeleteType(1);
      ((DeleteTokenReq)localObject).setMultiSender(false);
      a((DeleteTokenReq)localObject, 1);
      BaseUtils.deleteAllTokenCache(this.a);
      return;
    }
    catch (ApiException localApiException)
    {
      throw localApiException;
    }
    catch (Exception localException)
    {
      label113:
      break label113;
    }
    throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
  }
  
  public void deleteToken(String paramString)
  {
    b();
    a();
    if (!TextUtils.isEmpty(paramString))
    {
      String str = o.d(this.a);
      if (!TextUtils.isEmpty(str))
      {
        if (paramString.equals(str))
        {
          deleteToken(null, null);
          return;
        }
        paramString = o.a(this.a, paramString);
        paramString.setMultiSender(true);
        a(paramString, 2);
        return;
      }
      throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
    }
    throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
  }
  
  public void deleteToken(String paramString1, String paramString2)
  {
    b();
    a();
    paramString1 = o.a(this.a, paramString1, paramString2);
    paramString1.setMultiSender(false);
    a(paramString1, 1);
  }
  
  public Task<AAIDResult> getAAID()
  {
    try
    {
      localObject = Tasks.callInBackground(new j(this.a.getApplicationContext()));
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      label20:
      break label20;
    }
    localObject = new TaskCompletionSource();
    ((TaskCompletionSource)localObject).setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
    return ((TaskCompletionSource)localObject).getTask();
  }
  
  public long getCreationTime()
  {
    try
    {
      if (!this.b.containsKey("creationTime")) {
        getAAID();
      }
      long l = this.b.getLong("creationTime");
      return l;
    }
    catch (Exception localException)
    {
      label31:
      break label31;
    }
    return 0L;
  }
  
  public String getId()
  {
    return o.c(this.a);
  }
  
  @Deprecated
  public String getToken()
  {
    try
    {
      String str = getToken(null, null);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String getToken(String paramString)
  {
    b();
    a();
    if (!TextUtils.isEmpty(paramString))
    {
      String str = o.d(this.a);
      if (!TextUtils.isEmpty(str))
      {
        if (paramString.equals(str)) {
          return getToken(null, null);
        }
        paramString = o.b(this.a, paramString);
        paramString.setAaid(getId());
        paramString.setMultiSender(true);
        return a(paramString, 2);
      }
      throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
    }
    throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
  }
  
  public String getToken(String paramString1, String paramString2)
  {
    b();
    a();
    paramString1 = o.b(this.a, paramString1, paramString2);
    paramString1.setAaid(getId());
    paramString1.setMultiSender(false);
    i.a(this.a).saveString(this.a.getPackageName(), "1");
    return a(paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.aaid.HmsInstanceId
 * JD-Core Version:    0.7.0.1
 */