package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.opendevice.a;
import com.huawei.hms.opendevice.k;
import com.huawei.hms.opendevice.m;
import com.huawei.hms.opendevice.n;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class HmsInstanceIdEx
{
  public static final String TAG = HmsInstanceIdEx.class.getSimpleName();
  private static final byte[] a = new byte[0];
  private Context b = null;
  private q c = null;
  private HuaweiApi<Api.ApiOptions.NoOptions> d;
  
  private HmsInstanceIdEx(Context paramContext)
  {
    this.b = paramContext;
    this.c = new q(paramContext, "aaid");
    Api localApi = new Api("HuaweiPush.API");
    if ((paramContext instanceof Activity)) {}
    for (this.d = new HuaweiApi((Activity)paramContext, localApi, null, new m());; this.d = new HuaweiApi(paramContext, localApi, null, new m()))
    {
      this.d.setKitSdkVersion(50002300);
      return;
    }
  }
  
  private Task<TokenResult> a(Exception paramException)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    localTaskCompletionSource.setException(paramException);
    return localTaskCompletionSource.getTask();
  }
  
  private String a(String paramString)
  {
    return "creationTime" + paramString;
  }
  
  public static HmsInstanceIdEx getInstance(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    return new HmsInstanceIdEx(paramContext);
  }
  
  public void deleteAAID(String paramString)
  {
    if (paramString == null) {
      throw a.a(a.v);
    }
    try
    {
      if (this.c.d(paramString))
      {
        this.c.e(paramString);
        this.c.e(a(paramString));
      }
      return;
    }
    catch (RuntimeException paramString)
    {
      throw a.a(a.w);
    }
    catch (Exception paramString)
    {
      throw a.a(a.w);
    }
  }
  
  public String getAAId(String paramString)
  {
    if (paramString == null) {
      throw a.a(a.v);
    }
    try
    {
      if (this.c.d(paramString)) {
        return this.c.b(paramString);
      }
      String str = n.a(this.b);
      str = n.a(paramString + str);
      this.c.a(paramString, str);
      this.c.a(a(paramString), Long.valueOf(System.currentTimeMillis()));
      return str;
    }
    catch (RuntimeException paramString)
    {
      throw a.a(a.w);
    }
    catch (Exception paramString)
    {
      throw a.a(a.w);
    }
  }
  
  public long getCreationTime(String paramString)
  {
    if (paramString == null) {
      throw a.a(a.v);
    }
    try
    {
      if (!this.c.d(a(paramString))) {
        getAAId(paramString);
      }
      long l = this.c.c(a(paramString));
      return l;
    }
    catch (RuntimeException paramString)
    {
      throw a.a(a.w);
    }
    catch (Exception paramString)
    {
      throw a.a(a.w);
    }
  }
  
  public Task<TokenResult> getToken()
  {
    if (ProxyCenter.getInstance().getProxy() != null) {
      try
      {
        HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
        ProxyCenter.getInstance().getProxy().getToken(this.b);
        Object localObject1 = new TaskCompletionSource();
        ((TaskCompletionSource)localObject1).setResult(new TokenResult());
        localObject1 = ((TaskCompletionSource)localObject1).getTask();
        return localObject1;
      }
      catch (ApiException localApiException)
      {
        return a(localApiException);
      }
      catch (Exception localException1)
      {
        return a(a.a(a.w));
      }
    }
    String str = p.a(this.b, "push.gettoken");
    try
    {
      Object localObject2 = n.a(null, null, this.b);
      ((TokenReq)localObject2).setAaid(HmsInstanceId.getInstance(this.b).getId());
      localObject2 = this.d.doWrite(new k("push.gettoken", JsonUtil.createJsonString((IMessageEntity)localObject2), this.b, str));
      return localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      p.a(this.b, "push.gettoken", str, a.w);
      return a(a.a(a.w));
    }
    catch (Exception localException2)
    {
      p.a(this.b, "push.gettoken", str, a.w);
    }
    return a(a.a(a.w));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.aaid.HmsInstanceIdEx
 * JD-Core Version:    0.7.0.1
 */