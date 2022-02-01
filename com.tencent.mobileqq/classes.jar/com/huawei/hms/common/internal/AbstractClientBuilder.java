package com.huawei.hms.common.internal;

import android.content.Context;

public abstract class AbstractClientBuilder<TClient extends AnyClient, TOption>
{
  public abstract TClient buildClient(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.internal.AbstractClientBuilder
 * JD-Core Version:    0.7.0.1
 */