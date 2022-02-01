package com.tencent.gdtad.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.hippy.GdtTangramModule;
import com.tencent.gdtad.inject.IGdtThirdProcessor;
import com.tencent.gdtad.jsbridge.GdtAdPluginFactory;
import com.tencent.gdtad.jsbridge.GdtOpenMvPageHandler;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.statistics.FightReporter;
import com.tencent.mobileqq.statistics.cpu.CPUReport;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.component.TxchPage;
import com.tencent.raft.raftframework.RAApplicationContext;
import java.util.HashMap;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtThirdProcessorImpl
  implements IGdtThirdProcessor
{
  private URLDrawable a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    paramContext = paramContext.getResources();
    localURLDrawableOptions.mLoadingDrawable = paramContext.getDrawable(2130845650);
    localURLDrawableOptions.mFailedDrawable = paramContext.getDrawable(2130845650);
    paramContext = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramContext.setTag(URLDrawableDecodeHandler.b(paramInt1, paramInt1, paramInt2));
    paramContext.setDecodeHandler(URLDrawableDecodeHandler.c);
    return paramContext;
  }
  
  private void b(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramGdtMotiveVideoPageData == null)
    {
      QLog.i("GdtThirdProcessorImpl", 1, "onHippyCallback data is null");
      return;
    }
    paramGdtMotiveVideoPageData = paramGdtMotiveVideoPageData.getHippyAsyncCallbackId();
    if (TextUtils.isEmpty(paramGdtMotiveVideoPageData))
    {
      QLog.i("GdtThirdProcessorImpl", 1, "onHippyCallback id is null");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("elapsedTime", Long.valueOf(paramLong1));
    localHashMap.put("totalTime", Long.valueOf(paramLong2));
    localHashMap.put("isEnd", Boolean.valueOf(paramBoolean));
    GdtTangramModule.onHippyAsyncCallback(paramGdtMotiveVideoPageData, localHashMap);
  }
  
  public Drawable a(Context paramContext, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, int paramInt1, int paramInt2)
  {
    if ((paramGdtMotiveVideoPageData != null) && (!TextUtils.isEmpty(paramGdtMotiveVideoPageData.bannerLogo))) {
      return a(paramContext, paramGdtMotiveVideoPageData.bannerLogo, paramInt1, paramInt2);
    }
    return paramContext.getResources().getDrawable(2130845650);
  }
  
  public Drawable a(Context paramContext, String paramString)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    int i = ViewUtils.b(65.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramContext.getResources().getDrawable(2130841201);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramContext.getResources().getDrawable(2130841201);
    try
    {
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      try
      {
        ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.b(i, i, ViewUtils.b(9.0F)));
        ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.i);
        return localObject;
      }
      catch (Exception paramContext) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Exception paramContext)
    {
      localObject = null;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("gdtADBoxItemDrawable url=");
    localStringBuilder.append(paramString);
    QLog.e("GdtThirdProcessorImpl", 1, localStringBuilder.toString(), paramContext);
    return localObject;
  }
  
  public String a(Context paramContext)
  {
    RAApplicationContext localRAApplicationContext = RAApplicationContext.getGlobalContext();
    if (!localRAApplicationContext.hasStartUp()) {
      localRAApplicationContext.startup(paramContext);
    }
    paramContext = (TxchPage)localRAApplicationContext.getService(TxchPage.class);
    if (paramContext != null) {
      paramContext = paramContext.productId;
    } else {
      paramContext = "36028";
    }
    localRAApplicationContext.shutdown();
    return paramContext;
  }
  
  public void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    GdtC2SReporter.a(paramInt1, paramInt2, paramAdInfo);
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramIntent.putExtra("arg_callback", paramString);
    }
  }
  
  public void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    GdtOpenMvPageHandler localGdtOpenMvPageHandler = (GdtOpenMvPageHandler)GdtAdPluginFactory.a().a(16);
    if (localGdtOpenMvPageHandler != null) {
      localGdtOpenMvPageHandler.a(paramGdtMotiveVideoPageData, String.valueOf(paramLong1), String.valueOf(paramLong2), String.valueOf(paramBoolean));
    }
    b(paramGdtMotiveVideoPageData, paramLong1, paramLong2, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2)
  {
    FightReporter.a(paramString1, paramString2);
  }
  
  public boolean a()
  {
    return CPUReport.b();
  }
  
  public Drawable b(Context paramContext, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramContext.getResources().getDrawable(2130851078);
    localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130851078);
    paramContext = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramContext.setDecodeHandler(URLDrawableDecodeHandler.m);
    paramContext.setTag(new int[] { 50 });
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.impl.GdtThirdProcessorImpl
 * JD-Core Version:    0.7.0.1
 */