package com.tencent.biz.pubaccount.weishi_new.main;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionAnimUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;

public class WSLauncher$VerticalPageLauncher
{
  public static String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(WSLauncher.a);
    localStringBuilder.append("VerticalPageLauncher");
    a = localStringBuilder.toString();
  }
  
  private static void a(Activity paramActivity, WSVerticalPageOpenParams paramWSVerticalPageOpenParams)
  {
    int i;
    if (paramWSVerticalPageOpenParams.x() != 2) {
      i = 2130772310;
    } else {
      i = 2130772028;
    }
    paramActivity.overridePendingTransition(i, 2130772309);
  }
  
  public static void a(WSVerticalPageOpenParams paramWSVerticalPageOpenParams)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[WSVerticalMainFragment.java][start] params:");
    ((StringBuilder)localObject2).append(paramWSVerticalPageOpenParams);
    WSLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = paramWSVerticalPageOpenParams.v();
    if (paramWSVerticalPageOpenParams.l()) {
      ((Intent)localObject1).setFlags(67108864);
    }
    localObject2 = paramWSVerticalPageOpenParams.c();
    boolean bool = WSVideoTransitionAnimUtil.a(paramWSVerticalPageOpenParams, (Intent)localObject1, a(paramWSVerticalPageOpenParams.a()));
    if (((localObject2 instanceof Activity)) && (!bool)) {
      a((Activity)localObject2, paramWSVerticalPageOpenParams);
    }
  }
  
  private static boolean a(@Nullable String paramString)
  {
    return (TextUtils.equals(paramString, "aio_enter_c_link")) || (TextUtils.equals(paramString, "open_home_then_video"));
  }
  
  public static void b(WSVerticalPageOpenParams paramWSVerticalPageOpenParams)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[WSVerticalMainFragment.java][startForResult] params:");
    ((StringBuilder)localObject2).append(paramWSVerticalPageOpenParams);
    WSLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = paramWSVerticalPageOpenParams.v();
    localObject2 = paramWSVerticalPageOpenParams.c();
    if ((localObject2 instanceof Activity))
    {
      localObject2 = (Activity)localObject2;
      PublicFragmentActivity.Launcher.a((Activity)localObject2, (Intent)localObject1, PublicFragmentActivity.class, WSMainContainerFragment.class, paramWSVerticalPageOpenParams.j());
      a((Activity)localObject2, paramWSVerticalPageOpenParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.VerticalPageLauncher
 * JD-Core Version:    0.7.0.1
 */