package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;
import java.util.UUID;

@Deprecated
public class HmsInstanceIdEx
{
  public static final String TAG = "HmsInstanceIdEx";
  public Context a = null;
  public PushPreferences b = null;
  public HuaweiApi<Api.ApiOptions.NoOptions> c;
  
  public HmsInstanceIdEx(Context paramContext)
  {
    this.a = paramContext;
    this.b = new PushPreferences(paramContext, "aaid");
    Api localApi = new Api("HuaweiPush.API");
    if ((paramContext instanceof Activity)) {
      this.c = new HuaweiApi((Activity)paramContext, localApi, null, new PushClientBuilder());
    } else {
      this.c = new HuaweiApi(paramContext, localApi, null, new PushClientBuilder());
    }
    this.c.setKitSdkVersion(50101300);
  }
  
  public static HmsInstanceIdEx getInstance(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    return new HmsInstanceIdEx(paramContext);
  }
  
  public final Task<TokenResult> a(Exception paramException)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    localTaskCompletionSource.setException(paramException);
    return localTaskCompletionSource.getTask();
  }
  
  public final String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("creationTime");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void deleteAAID(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (this.b.containsKey(paramString))
      {
        this.b.removeKey(paramString);
        this.b.removeKey(a(paramString));
      }
      return;
    }
    catch (RuntimeException paramString)
    {
      break label45;
    }
    catch (Exception paramString)
    {
      label38:
      break label38;
    }
    throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
    label45:
    throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
    throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
  }
  
  public String getAAId(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (this.b.containsKey(paramString)) {
        return this.b.getString(paramString);
      }
      String str = UUID.randomUUID().toString();
      this.b.saveString(paramString, str);
      this.b.saveLong(a(paramString), Long.valueOf(System.currentTimeMillis()));
      return str;
    }
    catch (RuntimeException paramString)
    {
      break label68;
    }
    catch (Exception paramString)
    {
      label61:
      break label61;
    }
    throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
    label68:
    throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
    throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
  }
  
  public long getCreationTime(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!this.b.containsKey(a(paramString))) {
        getAAId(paramString);
      }
      long l = this.b.getLong(a(paramString));
      return l;
    }
    catch (RuntimeException paramString)
    {
      break label47;
    }
    catch (Exception paramString)
    {
      label40:
      break label40;
    }
    throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
    label47:
    throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
    throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
  }
  
  public Task<TokenResult> getToken()
  {
    if (ProxyCenter.getProxy() != null) {}
    try
    {
      Object localObject1 = TAG;
      HMSLog.i((String)localObject1, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
      ProxyCenter.getProxy().getToken(this.a, null, null);
      localObject1 = new TaskCompletionSource();
      ((TaskCompletionSource)localObject1).setResult(new TokenResult());
      localObject1 = ((TaskCompletionSource)localObject1).getTask();
      return localObject1;
    }
    catch (ApiException localApiException)
    {
      return a(localApiException);
      String str = q.a(this.a, "push.gettoken");
      try
      {
        Object localObject2 = o.b(this.a, null, null);
        ((TokenReq)localObject2).setAaid(HmsInstanceId.getInstance(this.a).getId());
        localObject2 = this.c.doWrite(new l("push.gettoken", (TokenReq)localObject2, this.a, str));
        return localObject2;
      }
      catch (RuntimeException localRuntimeException)
      {
        break label157;
      }
      catch (Exception localException2)
      {
        break label133;
      }
      q.a(this.a, "push.gettoken", str, ErrorEnum.ERROR_INTERNAL_ERROR);
      return a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
      q.a(this.a, "push.gettoken", str, ErrorEnum.ERROR_INTERNAL_ERROR);
      return a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
    }
    catch (Exception localException1)
    {
      label56:
      break label56;
    }
    return a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.aaid.HmsInstanceIdEx
 * JD-Core Version:    0.7.0.1
 */