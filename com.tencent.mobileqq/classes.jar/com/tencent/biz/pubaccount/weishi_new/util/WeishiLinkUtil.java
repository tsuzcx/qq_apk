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
  private static int a()
  {
    if (!a(b(), c(), 0)) {
      return 0;
    }
    return WSSharePreferencesUtil.a(b(), 0);
  }
  
  public static stLinkStragegyArgs a()
  {
    stLinkStragegyArgs localstLinkStragegyArgs = new stLinkStragegyArgs();
    localstLinkStragegyArgs.hasInstalledWeish = WeishiGuideUtils.a(BaseApplicationImpl.getApplication().getApplicationContext());
    localstLinkStragegyArgs.todayClickCount = b();
    localstLinkStragegyArgs.todayEnterCount = a();
    localstLinkStragegyArgs.todayLastLinkId = c();
    return localstLinkStragegyArgs;
  }
  
  public static void a()
  {
    a(b(), c());
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
    long l = WSSharePreferencesUtil.a(paramString2, 0L);
    boolean bool = DateUtils.isSameDay(System.currentTimeMillis(), l);
    if (!bool) {
      ThreadManager.getSubThreadHandler().post(new WeishiLinkUtil.3(paramString1, paramInt, paramString2));
    }
    return bool;
  }
  
  private static int b()
  {
    if (!a(d(), e(), 0)) {
      return 0;
    }
    return WSSharePreferencesUtil.a(d(), 0);
  }
  
  private static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_open_recommend_page_count_");
    localStringBuilder.append(h());
    return localStringBuilder.toString();
  }
  
  public static void b()
  {
    a(d(), e());
  }
  
  private static int c()
  {
    if (!a(f(), g(), -1)) {
      return -1;
    }
    return WSSharePreferencesUtil.a(f(), -1);
  }
  
  private static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_open_recommend_page_time_");
    localStringBuilder.append(h());
    return localStringBuilder.toString();
  }
  
  private static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_click_recommend_card_count_");
    localStringBuilder.append(h());
    return localStringBuilder.toString();
  }
  
  private static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_click_recommend_card_time_");
    localStringBuilder.append(h());
    return localStringBuilder.toString();
  }
  
  private static String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_last_link_type_");
    localStringBuilder.append(h());
    return localStringBuilder.toString();
  }
  
  private static String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_last_link_time_");
    localStringBuilder.append(h());
    return localStringBuilder.toString();
  }
  
  private static String h()
  {
    String str = WSDeviceUtils.a(BaseApplicationImpl.getContext());
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (!TextUtils.isEmpty(((AppRuntime)localObject).getAccount()))) {
      localObject = MD5.a(((AppRuntime)localObject).getAccount());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil
 * JD-Core Version:    0.7.0.1
 */