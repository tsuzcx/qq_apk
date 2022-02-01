package com.tencent.commonsdk.util.notification;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class QQPendingIntent
{
  public static PendingIntent getActivities(Context paramContext, int paramInt1, Intent[] paramArrayOfIntent, int paramInt2)
  {
    return PendingIntent.getActivities(paramContext, paramInt1, paramArrayOfIntent, paramInt2);
  }
  
  @TargetApi(16)
  public static PendingIntent getActivities(Context paramContext, int paramInt1, Intent[] paramArrayOfIntent, int paramInt2, Bundle paramBundle)
  {
    return PendingIntent.getActivities(paramContext, paramInt1, paramArrayOfIntent, paramInt2, paramBundle);
  }
  
  public static PendingIntent getActivity(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    return PendingIntent.getActivity(paramContext, paramInt1, paramIntent, paramInt2);
  }
  
  @TargetApi(16)
  public static PendingIntent getActivity(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, Bundle paramBundle)
  {
    return PendingIntent.getActivity(paramContext, paramInt1, paramIntent, paramInt2, paramBundle);
  }
  
  public static PendingIntent getBroadcast(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    return PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt2);
  }
  
  @TargetApi(26)
  public static PendingIntent getForegroundService(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    return PendingIntent.getForegroundService(paramContext, paramInt1, paramIntent, paramInt2);
  }
  
  public static PendingIntent getService(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    return PendingIntent.getService(paramContext, paramInt1, paramIntent, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.util.notification.QQPendingIntent
 * JD-Core Version:    0.7.0.1
 */