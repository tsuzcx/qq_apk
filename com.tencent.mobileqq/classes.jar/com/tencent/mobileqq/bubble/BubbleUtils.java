package com.tencent.mobileqq.bubble;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class BubbleUtils
{
  public static BubbleInfo a = new BubbleInfo(0);
  public static BubbleInfo b = new BubbleInfo(100000, 2130848843, 2130848844);
  public static BubbleInfo c = new BubbleInfo(100001, 2130848843, 2130848843);
  
  public static BubbleInfo a(int paramInt, AppRuntime paramAppRuntime, Resources paramResources, BaseAdapter paramBaseAdapter)
  {
    return a(paramInt, paramAppRuntime, paramResources, paramBaseAdapter, true);
  }
  
  @NonNull
  public static BubbleInfo a(int paramInt, AppRuntime paramAppRuntime, Resources paramResources, BaseAdapter paramBaseAdapter, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      paramResources = new StringBuilder();
      paramResources.append("getBubbleInfo, bubbleId=");
      paramResources.append(paramInt);
      paramResources.append(", shouldDownload=");
      paramResources.append(paramBoolean);
      QLog.d("BubbleUtils", 2, paramResources.toString());
    }
    long l = SystemClock.elapsedRealtime();
    if (paramInt == 100000) {
      return c;
    }
    if (paramInt == 100001) {
      return b;
    }
    if (paramInt < 1) {
      return a;
    }
    paramAppRuntime = ((BubbleManager)paramAppRuntime.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER)).c(paramInt, paramBoolean);
    if (paramAppRuntime != null)
    {
      if (QLog.isColorLevel())
      {
        paramResources = new StringBuilder();
        paramResources.append("getBubbleInfo time ");
        paramResources.append(SystemClock.elapsedRealtime() - l);
        QLog.d("bubble_performance", 2, paramResources.toString());
      }
      return paramAppRuntime;
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("getBubbleInfo time default");
      paramAppRuntime.append(SystemClock.elapsedRealtime() - l);
      QLog.d("bubble_performance", 2, paramAppRuntime.toString());
    }
    return a;
  }
  
  public static BubbleInfo a(int paramInt, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    return a(paramInt, paramAppRuntime, null, null, paramBoolean);
  }
  
  public static boolean a(View paramView)
  {
    Object localObject = AIOUtils.b(paramView);
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    boolean bool1 = bool2;
    if ((localObject instanceof BaseBubbleBuilder.ViewHolder))
    {
      paramView = (BaseBubbleBuilder.ViewHolder)AIOUtils.b(paramView);
      if (paramView.i != null)
      {
        bool1 = bool2;
        if (paramView.i.a > 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleUtils
 * JD-Core Version:    0.7.0.1
 */