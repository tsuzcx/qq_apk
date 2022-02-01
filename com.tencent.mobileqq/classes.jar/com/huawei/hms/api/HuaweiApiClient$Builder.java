package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class HuaweiApiClient$Builder
{
  private final Context a;
  private final List<Scope> b = new ArrayList();
  private final List<PermissionInfo> c = new ArrayList();
  private final Map<Api<?>, Api.ApiOptions> d = new HashMap();
  private HuaweiApiClient.OnConnectionFailedListener e;
  private HuaweiApiClient.ConnectionCallbacks f;
  private int g;
  private Activity h;
  
  public HuaweiApiClient$Builder(Context paramContext)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    this.a = paramContext.getApplicationContext();
    this.g = -1;
    ResourceLoaderUtil.setmContext(this.a);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    HMSBIInitializer.getInstance(paramContext).initBI();
  }
  
  private void a(HuaweiApiClient paramHuaweiApiClient)
  {
    AutoLifecycleFragment localAutoLifecycleFragment = AutoLifecycleFragment.getInstance(this.h);
    if (localAutoLifecycleFragment == null)
    {
      HMSLog.e("HuaweiApiClient.builder", "lifecycleFragment must not be NULL here");
      return;
    }
    localAutoLifecycleFragment.startAutoMange(this.g, paramHuaweiApiClient);
  }
  
  public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
  {
    this.d.put(paramApi, null);
    if ("HuaweiGame.API".equals(paramApi.getApiName())) {
      HiAnalyticsUtil.getInstance().onEvent(this.a.getApplicationContext(), "15060106", "|" + System.currentTimeMillis());
    }
    return this;
  }
  
  public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO)
  {
    Checker.checkNonNull(paramApi, "Api must not be null");
    Checker.checkNonNull(paramO, "Null options are not permitted for this Api");
    this.d.put(paramApi, paramO);
    if (paramApi.getOptions() != null)
    {
      List localList = paramApi.getOptions().getScopeList(paramO);
      this.b.addAll(localList);
      paramApi = paramApi.getOptions().getPermissionInfoList(paramO);
      this.c.addAll(paramApi);
    }
    return this;
  }
  
  public <O extends Api.ApiOptions.HasOptions> Builder addApiWithScope(Api<O> paramApi, O paramO, Scope... paramVarArgs)
  {
    Checker.checkNonNull(paramApi, "Api must not be null");
    Checker.checkNonNull(paramO, "Null options are not permitted for this Api");
    Checker.checkNonNull(paramVarArgs, "Scopes must not be null");
    this.d.put(paramApi, paramO);
    if (paramApi.getOptions() != null)
    {
      List localList = paramApi.getOptions().getScopeList(paramO);
      this.b.addAll(localList);
      paramApi = paramApi.getOptions().getPermissionInfoList(paramO);
      this.c.addAll(paramApi);
    }
    paramApi = new ArrayList(Arrays.asList(paramVarArgs));
    this.b.addAll(paramApi);
    return this;
  }
  
  public Builder addApiWithScope(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi, Scope... paramVarArgs)
  {
    Checker.checkNonNull(paramApi, "Api must not be null");
    Checker.checkNonNull(paramVarArgs, "Scopes must not be null");
    this.d.put(paramApi, null);
    paramApi = new ArrayList(Arrays.asList(paramVarArgs));
    this.b.addAll(paramApi);
    return this;
  }
  
  public Builder addConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Checker.checkNonNull(paramConnectionCallbacks, "listener must not be null.");
    this.f = paramConnectionCallbacks;
    return this;
  }
  
  public Builder addOnConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Checker.checkNonNull(paramOnConnectionFailedListener, "listener must not be null.");
    this.e = paramOnConnectionFailedListener;
    return this;
  }
  
  public Builder addScope(Scope paramScope)
  {
    Checker.checkNonNull(paramScope, "scope must not be null.");
    this.b.add(paramScope);
    return this;
  }
  
  public Builder allowLifeCycleManagement(Activity paramActivity, int paramInt, HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("allowLifeCycleManagement id should be positive");
    }
    this.g = paramInt;
    this.h = ((Activity)Preconditions.checkNotNull(paramActivity, "activity must not be Null."));
    return this;
  }
  
  public Builder allowLifeCycleManagement(Activity paramActivity, HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return allowLifeCycleManagement(paramActivity, 0, paramOnConnectionFailedListener);
  }
  
  public Builder applyDefaultAccount()
  {
    return this;
  }
  
  public HuaweiApiClient build()
  {
    addApi(new Api("Core.API"));
    HuaweiApiClientImpl localHuaweiApiClientImpl = new HuaweiApiClientImpl(this.a);
    localHuaweiApiClientImpl.setScopes(this.b);
    localHuaweiApiClientImpl.setPermissionInfos(this.c);
    localHuaweiApiClientImpl.setApiMap(this.d);
    localHuaweiApiClientImpl.setConnectionCallbacks(this.f);
    localHuaweiApiClientImpl.setConnectionFailedListener(this.e);
    localHuaweiApiClientImpl.setAutoLifecycleClientId(this.g);
    if (this.g >= 0) {
      a(localHuaweiApiClientImpl);
    }
    return localHuaweiApiClientImpl;
  }
  
  public Builder setAccountName(String paramString)
  {
    return this;
  }
  
  public Builder setHandler(Handler paramHandler)
  {
    return this;
  }
  
  public Builder setPopupsGravity(int paramInt)
  {
    return this;
  }
  
  public Builder setViewForPopups(View paramView)
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClient.Builder
 * JD-Core Version:    0.7.0.1
 */