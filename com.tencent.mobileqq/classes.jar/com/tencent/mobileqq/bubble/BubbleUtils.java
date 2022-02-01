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
  public static BubbleInfo b = new BubbleInfo(100000, 2130847388, 2130847389);
  public static BubbleInfo c = new BubbleInfo(100001, 2130847388, 2130847388);
  
  public static BubbleInfo a(int paramInt, AppRuntime paramAppRuntime, Resources paramResources, BaseAdapter paramBaseAdapter)
  {
    return a(paramInt, paramAppRuntime, paramResources, paramBaseAdapter, true);
  }
  
  @NonNull
  public static BubbleInfo a(int paramInt, AppRuntime paramAppRuntime, Resources paramResources, BaseAdapter paramBaseAdapter, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleUtils", 2, "getBubbleInfo, bubbleId=" + paramInt + ", shouldDownload=" + paramBoolean);
    }
    long l = SystemClock.elapsedRealtime();
    if (paramInt == 100000) {
      paramAppRuntime = c;
    }
    do
    {
      return paramAppRuntime;
      if (paramInt == 100001) {
        return b;
      }
      if (paramInt < 1) {
        return a;
      }
      paramResources = ((BubbleManager)paramAppRuntime.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER)).a(paramInt, paramBoolean);
      if (paramResources == null) {
        break;
      }
      paramAppRuntime = paramResources;
    } while (!QLog.isColorLevel());
    QLog.d("bubble_performance", 2, "getBubbleInfo time " + (SystemClock.elapsedRealtime() - l));
    return paramResources;
    if (QLog.isColorLevel()) {
      QLog.d("bubble_performance", 2, "getBubbleInfo time default" + (SystemClock.elapsedRealtime() - l));
    }
    return a;
  }
  
  public static BubbleInfo a(int paramInt, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    return a(paramInt, paramAppRuntime, null, null, paramBoolean);
  }
  
  public static boolean a(View paramView)
  {
    Object localObject = AIOUtils.a(paramView);
    if (localObject == null) {}
    while (!(localObject instanceof BaseBubbleBuilder.ViewHolder)) {
      return false;
    }
    paramView = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramView);
    if ((paramView.a == null) || (paramView.a.a <= 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleUtils
 * JD-Core Version:    0.7.0.1
 */