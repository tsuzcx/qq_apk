package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks;
import com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;

public class OpenDeviceHmsClient
  extends HmsClient
{
  public OpenDeviceHmsClient(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    super(paramContext, paramClientSettings, paramOnConnectionFailedListener, paramConnectionCallbacks);
  }
  
  public int getMinApkVersion()
  {
    return 30000000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.opendevice.OpenDeviceHmsClient
 * JD-Core Version:    0.7.0.1
 */