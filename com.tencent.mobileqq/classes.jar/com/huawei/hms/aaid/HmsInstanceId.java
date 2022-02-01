package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.a;
import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.d;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.j;
import com.huawei.hms.opendevice.k;
import com.huawei.hms.opendevice.m;
import com.huawei.hms.opendevice.n;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;

public class HmsInstanceId
{
  public static final String TAG = HmsInstanceId.class.getSimpleName();
  private static final byte[] a = new byte[0];
  private static final byte[] b = new byte[0];
  private Context c = null;
  private q d = null;
  private HuaweiApi<Api.ApiOptions.NoOptions> e;
  
  private HmsInstanceId(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.d = new q(paramContext, "aaid");
    Api localApi = new Api("HuaweiPush.API");
    if ((paramContext instanceof Activity)) {}
    for (this.e = new HuaweiApi((Activity)paramContext, localApi, null, new m());; this.e = new HuaweiApi(paramContext, localApi, null, new m()))
    {
      this.e.setKitSdkVersion(50002300);
      return;
    }
  }
  
  public static HmsInstanceId getInstance(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    d.b(paramContext);
    return new HmsInstanceId(paramContext);
  }
  
  public void deleteAAID()
  {
    try
    {
      if (this.d.d("aaid"))
      {
        this.d.e("aaid");
        this.d.e("creationTime");
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw a.a(a.w);
    }
    catch (Exception localException)
    {
      throw a.a(a.w);
    }
  }
  
  public void deleteToken(String paramString1, String paramString2)
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw a.a(a.O);
    }
    if (ProxyCenter.getInstance().getProxy() != null)
    {
      HMSLog.i(TAG, "use proxy delete token");
      ProxyCenter.getInstance().getProxy().deleteToken(this.c);
      return;
    }
    String str = p.a(this.c, "push.deletetoken");
    try
    {
      DeleteTokenReq localDeleteTokenReq = new DeleteTokenReq();
      localDeleteTokenReq.setAppId(paramString1);
      localDeleteTokenReq.setScope(paramString2);
      localDeleteTokenReq.setPkgName(this.c.getPackageName());
      if (TextUtils.isEmpty(paramString1)) {
        localDeleteTokenReq.setAppId(Util.getAppId(this.c));
      }
      if (TextUtils.isEmpty(paramString2)) {
        localDeleteTokenReq.setScope("HCM");
      }
      paramString1 = c.a(this.c, "push_client_self_info");
      if (!TextUtils.isEmpty(paramString1)) {
        localDeleteTokenReq.setToken(paramString1);
      }
      Tasks.await(this.e.doWrite(new j("push.deletetoken", JsonUtil.createJsonString(localDeleteTokenReq), str)));
      c.b(this.c, "push_client_self_info");
      return;
    }
    catch (Exception paramString1)
    {
      if ((paramString1.getCause() instanceof ApiException))
      {
        paramString1 = (ApiException)paramString1.getCause();
        p.a(this.c, "push.deletetoken", str, paramString1.getStatusCode());
        throw paramString1;
      }
      p.a(this.c, "push.deletetoken", str, a.w);
      throw a.a(a.w);
    }
  }
  
  public Task<AAIDResult> getAAID()
  {
    try
    {
      Task localTask = Tasks.callInBackground(new i(this.c.getApplicationContext()));
      return localTask;
    }
    catch (Exception localException)
    {
      TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
      localTaskCompletionSource.setException(a.a(a.w));
      return localTaskCompletionSource.getTask();
    }
  }
  
  public long getCreationTime()
  {
    try
    {
      if (!this.d.d("creationTime")) {
        getAAID();
      }
      long l = this.d.c("creationTime");
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public String getId()
  {
    return n.b(this.c);
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
  
  public String getToken(String paramString1, String paramString2)
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw a.a(a.O);
    }
    if (ProxyCenter.getInstance().getProxy() != null)
    {
      ProxyCenter.getInstance().getProxy().getToken(this.c);
      HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
      return null;
    }
    String str = p.a(this.c, "push.gettoken");
    try
    {
      paramString1 = n.a(paramString1, paramString2, this.c);
      paramString1.setAaid(getId());
      HMSLog.d(TAG, "getToken req :" + paramString1.toString());
      paramString1 = ((TokenResult)Tasks.await(this.e.doWrite(new k("push.gettoken", JsonUtil.createJsonString(paramString1), this.c, str)))).getToken();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if ((paramString1.getCause() instanceof ApiException))
      {
        paramString1 = (ApiException)paramString1.getCause();
        p.a(this.c, "push.gettoken", str, paramString1.getStatusCode());
        throw paramString1;
      }
      p.a(this.c, "push.gettoken", str, a.w);
      throw a.a(a.w);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.aaid.HmsInstanceId
 * JD-Core Version:    0.7.0.1
 */