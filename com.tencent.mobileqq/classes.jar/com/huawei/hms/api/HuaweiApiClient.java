package com.huawei.hms.api;

import android.app.Activity;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class HuaweiApiClient
  implements AidlApiClient
{
  public abstract void checkUpdate(Activity paramActivity, CheckUpdatelistener paramCheckUpdatelistener);
  
  public void connect(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void connect(Activity paramActivity);
  
  public abstract void connectForeground();
  
  public abstract void disableLifeCycleManagement(Activity paramActivity);
  
  public abstract PendingResult<Status> discardAndReconnect();
  
  public abstract void disconnect();
  
  public abstract Map<Api<?>, Api.ApiOptions> getApiMap();
  
  public abstract ConnectionResult getConnectionResult(Api<?> paramApi);
  
  public abstract List<PermissionInfo> getPermissionInfos();
  
  public abstract List<Scope> getScopes();
  
  public abstract Activity getTopActivity();
  
  public abstract boolean hasConnectedApi(Api<?> paramApi);
  
  public abstract boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract ConnectionResult holdUpConnect();
  
  public abstract ConnectionResult holdUpConnect(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract void onPause(Activity paramActivity);
  
  public abstract void onResume(Activity paramActivity);
  
  public abstract void print(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract void reconnect();
  
  public abstract void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract boolean setSubAppInfo(SubAppInfo paramSubAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClient
 * JD-Core Version:    0.7.0.1
 */