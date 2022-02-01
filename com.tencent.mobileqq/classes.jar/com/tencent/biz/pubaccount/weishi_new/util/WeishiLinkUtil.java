package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stLinkStragegyArgs;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.MD5;
import cooperation.qzone.util.DateUtils;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class WeishiLinkUtil
{
  public static stLinkStragegyArgs a()
  {
    stLinkStragegyArgs localstLinkStragegyArgs = new stLinkStragegyArgs();
    localstLinkStragegyArgs.hasInstalledWeish = WeishiGuideUtils.a(BaseApplicationImpl.getApplication().getApplicationContext());
    localstLinkStragegyArgs.todayClickCount = f();
    localstLinkStragegyArgs.todayEnterCount = e();
    localstLinkStragegyArgs.todayLastLinkId = g();
    return localstLinkStragegyArgs;
  }
  
  public static void a(int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new WeishiLinkUtil.1(paramInt));
  }
  
  private static void a(String paramString1, String paramString2)
  {
    ThreadManager.getSubThreadHandler().post(new WeishiLinkUtil.2(paramString1, paramString2));
  }
  
  private static boolean a(String paramString1, String paramString2, int paramInt)
  {
    long l = WSSharePreferencesUtil.b(paramString2, 0L);
    boolean bool = DateUtils.isSameDay(System.currentTimeMillis(), l);
    if (!bool) {
      ThreadManager.getSubThreadHandler().post(new WeishiLinkUtil.3(paramString1, paramInt, paramString2));
    }
    return bool;
  }
  
  public static void b()
  {
    a(h(), i());
  }
  
  public static void c()
  {
    a(j(), k());
  }
  
  private static int e()
  {
    if (!a(h(), i(), 0)) {
      return 0;
    }
    return WSSharePreferencesUtil.b(h(), 0);
  }
  
  private static int f()
  {
    if (!a(j(), k(), 0)) {
      return 0;
    }
    return WSSharePreferencesUtil.b(j(), 0);
  }
  
  private static int g()
  {
    if (!a(l(), m(), -1)) {
      return -1;
    }
    return WSSharePreferencesUtil.b(l(), -1);
  }
  
  private static String h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_open_recommend_page_count_");
    localStringBuilder.append(n());
    return localStringBuilder.toString();
  }
  
  private static String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_open_recommend_page_time_");
    localStringBuilder.append(n());
    return localStringBuilder.toString();
  }
  
  private static String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_click_recommend_card_count_");
    localStringBuilder.append(n());
    return localStringBuilder.toString();
  }
  
  private static String k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_click_recommend_card_time_");
    localStringBuilder.append(n());
    return localStringBuilder.toString();
  }
  
  private static String l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_last_link_type_");
    localStringBuilder.append(n());
    return localStringBuilder.toString();
  }
  
  private static String m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_last_link_time_");
    localStringBuilder.append(n());
    return localStringBuilder.toString();
  }
  
  private static String n()
  {
    String str = WSDeviceUtils.a(BaseApplicationImpl.getContext());
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (!TextUtils.isEmpty(((AppRuntime)localObject).getAccount()))) {
      localObject = MD5.b(((AppRuntime)localObject).getAccount());
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil
 * JD-Core Version:    0.7.0.1
 */