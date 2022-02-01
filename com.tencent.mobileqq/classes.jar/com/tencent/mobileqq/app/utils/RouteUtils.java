package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;

public class RouteUtils
{
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    QLog.d("RouteUtils", 1, new Object[] { "startActivity, path : ", paramString });
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramContext, paramString);
    if (paramIntent != null)
    {
      paramString = paramIntent.getExtras();
      Bundle localBundle = localActivityURIRequest.extra();
      paramContext = paramString;
      if (paramString == null) {
        paramContext = new Bundle();
      }
      localBundle.putAll(paramContext);
      localActivityURIRequest.setFlags(paramIntent.getFlags());
      localActivityURIRequest.setData(paramIntent.getData());
      localActivityURIRequest.setType(paramIntent.getType());
      localActivityURIRequest.setIntentAction(paramIntent.getAction());
    }
    QRoute.startUri(localActivityURIRequest, null);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString, int paramInt)
  {
    QLog.d("RouteUtils", 1, new Object[] { "startActivityForResult, path : ", paramString, " code : ", Integer.valueOf(paramInt) });
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramContext, paramString);
    if (paramIntent != null)
    {
      paramString = paramIntent.getExtras();
      Bundle localBundle = localActivityURIRequest.extra();
      paramContext = paramString;
      if (paramString == null) {
        paramContext = new Bundle();
      }
      localBundle.putAll(paramContext);
      localActivityURIRequest.setFlags(paramIntent.getFlags());
      localActivityURIRequest.setData(paramIntent.getData());
      localActivityURIRequest.setType(paramIntent.getType());
      localActivityURIRequest.setIntentAction(paramIntent.getAction());
    }
    localActivityURIRequest.setRequestCode(paramInt);
    QRoute.startUri(localActivityURIRequest, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.RouteUtils
 * JD-Core Version:    0.7.0.1
 */