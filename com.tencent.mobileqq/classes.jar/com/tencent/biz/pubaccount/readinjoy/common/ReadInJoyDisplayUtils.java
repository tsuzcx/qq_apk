package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.List;
import mqq.app.AppRuntime;

public class ReadInJoyDisplayUtils
{
  private static Drawable a = new ColorDrawable(Color.parseColor("#E9E9E9"));
  
  public static float a(int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramInt1, paramInt2);
    if (paramInt1 == 1) {
      return 0.5625F;
    }
    if (paramInt1 == 2) {
      return 1.333F;
    }
    return 1.0F;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return 1;
  }
  
  public static Pair a()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    return new Pair(Integer.valueOf((localResources.getDisplayMetrics().widthPixels - AIOUtils.a(3.0F, localResources)) / 3), Integer.valueOf(localResources.getDimensionPixelSize(2131559686)));
  }
  
  public static Pair a(int paramInt1, int paramInt2)
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = AIOUtils.a(4.5F, localResources);
    if (paramInt2 == 56) {
      paramInt2 = AIOUtils.a(3.0F, localResources);
    }
    int j;
    for (i = 6;; i = j)
    {
      switch (paramInt1)
      {
      default: 
        paramInt2 = (int)((localResources.getDisplayMetrics().widthPixels - AIOUtils.a(i, localResources) - paramInt2 * 2) / 2.5F);
        paramInt1 = (int)(paramInt2 * 1.3356F);
      }
      for (;;)
      {
        return new Pair(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
        j = localResources.getDisplayMetrics().widthPixels - AIOUtils.a(i * 2, localResources);
        paramInt1 = (int)((localResources.getDisplayMetrics().widthPixels - AIOUtils.a(i, localResources) - paramInt2 * 2) / 2.5F * 1.3356F);
        paramInt2 = j;
        continue;
        paramInt2 = (int)((localResources.getDisplayMetrics().widthPixels - AIOUtils.a(i * 2, localResources) - paramInt2) * 0.5F);
        paramInt1 = (int)(paramInt2 * 1.3314F);
      }
      j = 12;
      paramInt2 = i;
    }
  }
  
  public static String a(int paramInt)
  {
    int i = paramInt / 3600;
    int j = (paramInt - i * 60) / 60;
    paramInt %= 60;
    String str1;
    String str2;
    if (j >= 10)
    {
      str1 = String.valueOf(j);
      if (paramInt < 10) {
        break label104;
      }
      str2 = String.valueOf(paramInt);
      label44:
      if (i <= 0) {
        break label146;
      }
      if (i < 10) {
        break label125;
      }
    }
    label104:
    label125:
    for (String str3 = String.valueOf(i);; str3 = String.format("0%d", new Object[] { Integer.valueOf(i) }))
    {
      return String.format("%s:%s:%s", new Object[] { str3, str1, str2 });
      str1 = String.format("0%d", new Object[] { Integer.valueOf(j) });
      break;
      str2 = String.format("0%d", new Object[] { Integer.valueOf(paramInt) });
      break label44;
    }
    label146:
    return String.format("%s:%s", new Object[] { str1, str2 });
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString.length() > paramInt) {
      str = paramString.substring(0, paramInt - 1) + "…";
    }
    return str;
  }
  
  public static void a()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      BaseApplicationImpl.sImageCache.evict(0);
      return;
    }
    BaseApplicationImpl.sImageCache.evictAll();
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, Context paramContext)
  {
    a(paramKandianUrlImageView, paramURL, paramContext, false);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, Context paramContext, boolean paramBoolean)
  {
    if (paramURL == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "configImage url is empty! use default preload image");
      }
      paramKandianUrlImageView.setImageResource(2130839721);
      return;
    }
    if ((paramContext instanceof BaseActivity)) {}
    for (BaseActivity localBaseActivity = (BaseActivity)paramContext;; localBaseActivity = null)
    {
      if (localBaseActivity != null) {}
      for (boolean bool = SettingCloneUtil.readValue(localBaseActivity, localBaseActivity.app.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);; bool = false)
      {
        if ((!NetworkUtil.h(paramContext)) && (bool) && (!ImageManager.a().a(paramURL)))
        {
          if (!paramBoolean)
          {
            paramKandianUrlImageView.setImageResource(2130839721);
            return;
          }
          paramKandianUrlImageView.setImageDrawable(new ColorDrawable(paramContext.getResources().getColor(2131492971)));
          return;
        }
        if (!paramBoolean)
        {
          if (paramKandianUrlImageView.a())
          {
            paramKandianUrlImageView.a(paramContext.getResources().getDrawable(2130839230)).a(paramURL);
            return;
          }
          paramKandianUrlImageView.a(paramContext.getResources().getDrawable(2130839721)).a(paramURL);
          return;
        }
        paramKandianUrlImageView.setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(2131492971)));
        paramKandianUrlImageView.a(new ColorDrawable(paramContext.getResources().getColor(2131492971))).a(paramURL);
        return;
      }
    }
  }
  
  public static void a(List paramList1, List paramList2, Context paramContext)
  {
    int j = paramList1.size();
    if (j != paramList2.size()) {
      throw new IllegalArgumentException("imageViewListSize != urlListSize");
    }
    if (paramContext != null) {}
    for (boolean bool = SettingCloneUtil.readValue(paramContext, BaseApplicationImpl.getApplication().getRuntime().getAccount(), null, "qqsetting_kandian_download_pic_flag", false);; bool = false)
    {
      int i;
      if ((!bool) || (NetworkUtil.h(paramContext))) {
        i = 0;
      }
      while (i < j)
      {
        ((KandianUrlImageView)paramList1.get(i)).a(a).a((URL)paramList2.get(i));
        i += 1;
        continue;
        i = 0;
        while (i < j)
        {
          ((KandianUrlImageView)paramList1.get(i)).setImageDrawable(a);
          i += 1;
        }
      }
      return;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    while (paramInt1 > paramInt2) {
      return false;
    }
    return true;
  }
  
  public static Pair b()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.562F)));
  }
  
  public static Pair c()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.5625F)));
  }
  
  public static Pair d()
  {
    int i = (int)(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels * 0.5F);
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 1.3333F)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils
 * JD-Core Version:    0.7.0.1
 */