package com.tencent.falco.base.libapi.hostproxy;

import androidx.core.app.NotificationCompat.Builder;

public abstract interface HostAppResInterface
{
  public abstract NotificationCompat.Builder getBackgroundPlayNotificationBuilder();
  
  public abstract int getHostAppIconId();
  
  public abstract String getHostAppName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.hostproxy.HostAppResInterface
 * JD-Core Version:    0.7.0.1
 */