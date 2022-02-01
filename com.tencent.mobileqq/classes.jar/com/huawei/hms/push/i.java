package com.huawei.hms.push;

import android.content.Context;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks;
import com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener;
import com.huawei.hms.common.internal.ClientSettings;
import java.util.Arrays;

public class i
  extends AbstractClientBuilder<h, Api.ApiOptions.NoOptions>
{
  public h buildClient(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    paramClientSettings.setApiName(Arrays.asList(new String[] { "HuaweiPush.API", "Core.API" }));
    return new h(paramContext, paramClientSettings, paramOnConnectionFailedListener, paramConnectionCallbacks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.i
 * JD-Core Version:    0.7.0.1
 */