package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks;
import com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener;
import com.huawei.hms.common.internal.ClientSettings;
import java.util.Arrays;

public class m
  extends AbstractClientBuilder<l, Api.ApiOptions.NoOptions>
{
  public l buildClient(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    paramClientSettings.setApiName(Arrays.asList(new String[] { "HuaweiPush.API", "Core.API" }));
    return new l(paramContext, paramClientSettings, paramOnConnectionFailedListener, paramConnectionCallbacks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.opendevice.m
 * JD-Core Version:    0.7.0.1
 */