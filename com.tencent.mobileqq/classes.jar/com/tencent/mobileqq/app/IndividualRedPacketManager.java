package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.AnimConfig;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.Char300Info;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.DecorateInfo;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketResInfo;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketTemplateInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;

public class IndividualRedPacketManager
  implements Manager
{
  public static String G = "0";
  public static int H = 0;
  public static int I = -1;
  public static int J = 0;
  public static int K = -1;
  private static String L = "IndividualRedPacketManager";
  public static String a;
  public static int b;
  IndividualRedPacketManager.PrecreateRunnable A;
  public Handler B;
  public int C = 0;
  public int D = 0;
  public int E = -1;
  public String F;
  float c = 0.0F;
  int d = 0;
  int e = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  int i = 0;
  float j;
  public AtomicBoolean k;
  public AtomicBoolean l;
  public AtomicBoolean m = new AtomicBoolean(false);
  ETFont n;
  QQAppInterface o;
  ETEngine p;
  public ConcurrentHashMap<String, RedPacketInfo> q;
  LinkedList<String> r;
  public IndividualRedPacketResDownloader s;
  SharedPreferences t;
  SharedPreferences u;
  Comparator<File> v = new IndividualRedPacketManager.3(this);
  Boolean w = Boolean.valueOf(false);
  AtomicBoolean x = new AtomicBoolean(false);
  AtomicBoolean y = new AtomicBoolean(false);
  HandlerThread z;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("RedPacket/");
    a = localStringBuilder.toString();
    b = 10029;
  }
  
  public IndividualRedPacketManager(QQAppInterface paramQQAppInterface)
  {
    this.o = paramQQAppInterface;
    SharedPreferences localSharedPreferences = b();
    a(localSharedPreferences.getInt("sp_vip_info_can_use_packet", 0), localSharedPreferences.getInt("sp_vip_info_red_packet_disable", 0), false);
    a(localSharedPreferences.getInt("sp_vip_info_red_packet_id", -1), localSharedPreferences.getString("sp_vip_info_red_packet_text", null));
    this.p = ETEngine.getInstanceForRedPacket();
    this.k = new AtomicBoolean();
    this.k.set(false);
    this.l = new AtomicBoolean();
    this.l.set(false);
    this.r = new LinkedList();
    this.j = paramQQAppInterface.getApp().getApplicationContext().getResources().getDisplayMetrics().density;
    float f1 = this.j;
    double d1 = 138.0F * f1;
    Double.isNaN(d1);
    this.d = ((int)(d1 + 0.5D));
    d1 = 115.0F * f1;
    Double.isNaN(d1);
    this.e = ((int)(d1 + 0.5D));
    d1 = f1 * 280.0F;
    Double.isNaN(d1);
    this.g = ((int)(d1 + 0.5D));
    d1 = 280.0F * f1;
    Double.isNaN(d1);
    this.f = ((int)(d1 + 0.5D));
    d1 = f1 * 104.0F;
    Double.isNaN(d1);
    this.i = ((int)(d1 + 0.5D));
    d1 = 320.0F * f1;
    Double.isNaN(d1);
    this.h = ((int)(d1 + 0.5D));
    d1 = f1 * 104.0F;
    Double.isNaN(d1);
    this.c = ((int)(d1 + 0.5D));
    this.q = new ConcurrentHashMap();
    ThreadManager.post(new IndividualRedPacketManager.1(this), 8, null, true);
  }
  
  private Bitmap a(IndividualRedPacketManager.FontBitmap paramFontBitmap, String paramString1, String paramString2, int paramInt)
  {
    Object localObject3 = a().a(paramString1, true);
    if ((localObject3 != null) && (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).b != null) && (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).c != null) && (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).d != null))
    {
      Object localObject2 = "#ffe589";
      Object localObject1;
      int i2;
      int i1;
      int i3;
      if (paramInt == 6)
      {
        localObject1 = a(paramString1, "", 2, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).h, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).e);
        i2 = DisplayUtil.a(this.o.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).b.a / 2);
        i1 = this.d;
        i3 = this.e;
        paramString1 = new Point(DisplayUtil.a(this.o.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).b.b.left / 2), DisplayUtil.a(this.o.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).b.b.top / 2));
      }
      else if (paramInt == 7)
      {
        localObject1 = a(paramString1, "", 3, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).h, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).e);
        i2 = DisplayUtil.a(this.o.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).c.a / 2);
        i1 = this.f;
        i3 = this.g;
        paramString1 = new Point(DisplayUtil.a(this.o.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).c.b.left / 2), DisplayUtil.a(this.o.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).c.b.top / 2));
        localObject2 = "#d13d4b";
      }
      else if (paramInt == 15)
      {
        localObject1 = a(paramString1, "", 14, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).h, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).e);
        i2 = DisplayUtil.a(this.o.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).d.a / 2);
        i1 = this.h;
        i3 = this.i;
        paramString1 = new Point(DisplayUtil.a(this.o.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).d.b.left / 2), DisplayUtil.a(this.o.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).d.b.top / 2));
        localObject2 = "#edd4d8";
      }
      else
      {
        localObject1 = null;
        paramString1 = (String)localObject1;
        i1 = 0;
        i3 = 0;
        i2 = 0;
      }
      if ((localObject1 != null) && (paramString1 != null))
      {
        localObject3 = a((String)localObject1, null);
        Bitmap localBitmap2 = paramFontBitmap.a;
        if (localObject3 == null) {
          return null;
        }
        try
        {
          Bitmap localBitmap1;
          try
          {
            localObject1 = Bitmap.createBitmap(i1, i3, Bitmap.Config.ARGB_8888);
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel())
            {
              localObject4 = L;
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("combineFinalImage Bitmap.createBitmap Error: ");
              ((StringBuilder)localObject5).append(localException.getMessage());
              QLog.d((String)localObject4, 2, ((StringBuilder)localObject5).toString());
            }
            localBitmap1 = null;
          }
          if (localBitmap1 == null) {
            return localBitmap1;
          }
          RectF localRectF = new RectF();
          Rect localRect = new Rect();
          Object localObject4 = new Paint();
          ((Paint)localObject4).setAntiAlias(true);
          ((Paint)localObject4).setDither(true);
          ((Paint)localObject4).setFilterBitmap(true);
          Object localObject5 = new Canvas(localBitmap1);
          localRect.set(0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
          localRectF.set(0.0F, 0.0F, i1, i3);
          ((Canvas)localObject5).drawBitmap((Bitmap)localObject3, localRect, localRectF, (Paint)localObject4);
          if (localBitmap2 != null)
          {
            if ((paramInt == 7) && (!paramFontBitmap.b)) {
              ((Paint)localObject4).setColorFilter(new LightingColorFilter(0, 13712715));
            } else if ((paramInt == 15) && (!paramFontBitmap.b)) {
              ((Paint)localObject4).setColorFilter(new LightingColorFilter(0, 15586520));
            }
            localRect.set(0, 0, localBitmap2.getWidth(), localBitmap2.getHeight());
            localRectF.set(paramString1.x, paramString1.y, paramString1.x + i2, paramString1.y + i2);
            ((Canvas)localObject5).drawBitmap(localBitmap2, localRect, localRectF, (Paint)localObject4);
            return localBitmap1;
          }
          ((Paint)localObject4).setColor(Color.parseColor((String)localObject2));
          float f1 = i2;
          ((Paint)localObject4).setTextSize(0.7F * f1);
          paramFontBitmap = new float[1];
          localObject2 = ((Paint)localObject4).getFontMetricsInt();
          ((Paint)localObject4).getTextWidths(paramString2, paramFontBitmap);
          paramInt = (int)(paramString1.x + (f1 - paramFontBitmap[0]) / 2.0F);
          i1 = paramString1.y;
          i3 = ((Paint.FontMetricsInt)localObject2).ascent;
          i2 = (i2 - (((Paint.FontMetricsInt)localObject2).descent - ((Paint.FontMetricsInt)localObject2).ascent)) / 2;
          ((Canvas)localObject5).drawText(paramString2, paramInt, i1 - i3 + i2, (Paint)localObject4);
          return localBitmap1;
        }
        catch (OutOfMemoryError paramFontBitmap)
        {
          if (QLog.isColorLevel())
          {
            paramString1 = L;
            paramString2 = new StringBuilder();
            paramString2.append("combineFinalImage Bitmap.createBitmap OutOfMemoryError: ");
            paramString2.append(paramFontBitmap.getMessage());
            QLog.d(paramString1, 2, paramString2.toString());
          }
        }
      }
    }
    try
    {
      paramFontBitmap = new HashMap();
      paramFontBitmap.put("param_FailCode", "combineFinalImage");
      StatisticCollector.getInstance(BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedpacketCreateBitmapError", false, 1L, 0L, paramFontBitmap, "", false);
      label1024:
      return null;
      return null;
      if (QLog.isColorLevel())
      {
        paramFontBitmap = L;
        paramString2 = new StringBuilder();
        paramString2.append("combineFinalImage init json fail, templateId:");
        paramString2.append(paramString1);
        QLog.e(paramFontBitmap, 2, paramString2.toString());
      }
      return null;
    }
    catch (Exception paramFontBitmap)
    {
      break label1024;
    }
  }
  
  static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    BitmapFactory.Options localOptions = null;
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = null;
    Object localObject2 = null;
    Object localObject3 = localOptions;
    Object localObject1 = localBitmapDecodeResult;
    for (;;)
    {
      try
      {
        if (GlobalImageCache.a.get(paramString) != null)
        {
          localObject3 = localOptions;
          localObject1 = localBitmapDecodeResult;
          localObject2 = (Bitmap)GlobalImageCache.a.get(paramString);
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (paramOptions != null) {
            break label750;
          }
          localObject3 = localObject2;
          localObject1 = localObject2;
          localOptions = new BitmapFactory.Options();
          localObject3 = localObject2;
          localObject1 = localObject2;
          localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
          localObject3 = localObject2;
          localObject1 = localObject2;
          localBitmapDecodeResult = BitmapManager.b(paramString, localOptions);
          localObject3 = localObject2;
          localObject1 = localObject2;
          paramOptions = localBitmapDecodeResult.a;
          localObject3 = paramOptions;
          localObject1 = paramOptions;
          if (QLog.isColorLevel())
          {
            localObject3 = paramOptions;
            localObject1 = paramOptions;
            localObject2 = L;
            localObject3 = paramOptions;
            localObject1 = paramOptions;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject3 = paramOptions;
            localObject1 = paramOptions;
            localStringBuilder.append("redpacket decodeBitmap, path=");
            localObject3 = paramOptions;
            localObject1 = paramOptions;
            localStringBuilder.append(paramString);
            localObject3 = paramOptions;
            localObject1 = paramOptions;
            localStringBuilder.append(", result:");
            localObject3 = paramOptions;
            localObject1 = paramOptions;
            localStringBuilder.append(localBitmapDecodeResult.b);
            localObject3 = paramOptions;
            localObject1 = paramOptions;
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
          }
          localObject3 = paramOptions;
          localObject1 = paramOptions;
          int i1 = localBitmapDecodeResult.b;
          localObject1 = paramOptions;
          if (i1 == 1)
          {
            i1 = 2;
            localObject2 = paramOptions;
            if (i1 <= 4)
            {
              localObject2 = paramOptions;
              localObject1 = paramOptions;
              try
              {
                localOptions.inSampleSize = i1;
                localObject2 = paramOptions;
                localObject1 = paramOptions;
                localObject3 = BitmapManager.b(paramString, localOptions);
                localObject2 = paramOptions;
                localObject1 = paramOptions;
                paramOptions = ((BitmapManager.BitmapDecodeResult)localObject3).a;
                localObject2 = paramOptions;
                localObject1 = paramOptions;
                if (((BitmapManager.BitmapDecodeResult)localObject3).b != 1)
                {
                  localObject2 = paramOptions;
                  localObject1 = paramOptions;
                  if (QLog.isColorLevel())
                  {
                    localObject2 = paramOptions;
                    localObject1 = paramOptions;
                    QLog.d(L, 2, "redpacket decodeBitmap, oom to ok");
                  }
                  localObject1 = paramOptions;
                }
              }
              catch (Exception paramOptions)
              {
                localObject3 = localObject2;
              }
              catch (OutOfMemoryError paramOptions) {}
            }
          }
        }
      }
      catch (Exception paramOptions)
      {
        try
        {
          localObject3 = new HashMap();
          localObject1 = localObject2;
          paramOptions = (BitmapFactory.Options)localObject2;
          ((HashMap)localObject3).put("param_FailCode", "0");
          localObject1 = localObject2;
          paramOptions = (BitmapFactory.Options)localObject2;
          StatisticCollector.getInstance(BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedPacketDecodeBitmapOOM", false, 1L, 0L, (HashMap)localObject3, "", false);
          return localObject2;
        }
        catch (Exception paramString)
        {
          return paramOptions;
        }
        paramOptions = paramOptions;
        if (QLog.isColorLevel())
        {
          localObject1 = L;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("redpacket decodeBitmap, path=");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(", error:");
          ((StringBuilder)localObject2).append(paramOptions.getMessage());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        paramOptions = (BitmapFactory.Options)localObject3;
        paramString = new HashMap();
        paramOptions = (BitmapFactory.Options)localObject3;
        paramString.put("param_FailCode", "1");
        paramOptions = (BitmapFactory.Options)localObject3;
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedPacketDecodeBitmapError", false, 1L, 0L, paramString, "", false);
        return localObject3;
      }
      catch (OutOfMemoryError paramOptions)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = L;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("redpacket decodeBitmap, path=");
          ((StringBuilder)localObject3).append(paramString);
          ((StringBuilder)localObject3).append(", oom result:");
          ((StringBuilder)localObject3).append(paramOptions.getMessage());
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
        paramOptions = (BitmapFactory.Options)localObject1;
        paramString = new HashMap();
        paramOptions = (BitmapFactory.Options)localObject1;
        paramString.put("param_FailCode", "1");
        paramOptions = (BitmapFactory.Options)localObject1;
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedPacketDecodeBitmapOOM", false, 1L, 0L, paramString, "", false);
      }
      try
      {
        localObject2 = new HashMap();
        localObject1 = paramOptions;
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedPacketDecodeBitmapOOM_To_OK", false, 1L, 0L, (HashMap)localObject2, "", false);
        localObject2 = paramOptions;
      }
      catch (Exception localException)
      {
        localObject2 = paramOptions;
        continue;
      }
      i1 *= 2;
      continue;
      localObject1 = localObject2;
      paramOptions = (BitmapFactory.Options)localObject2;
      return localObject1;
      label750:
      localOptions = paramOptions;
    }
  }
  
  @Nullable
  private static IndividualRedPacketResDownloader.RedPacketTemplateInfo a(IndividualRedPacketManager arg0, RedPacketInfo paramRedPacketInfo, String paramString1, String paramString2, IndividualRedPacketResDownloader paramIndividualRedPacketResDownloader)
  {
    Object localObject = paramIndividualRedPacketResDownloader.a(paramString1, true);
    if ((localObject != null) && (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject).b != null) && (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject).c != null) && (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject).d != null)) {
      return localObject;
    }
    if (QLog.isColorLevel())
    {
      localObject = L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VIPHBStrategy.get not in local map. Id = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("content = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("mTemplateInfoMap.size=");
      localStringBuilder.append(paramIndividualRedPacketResDownloader.b.size());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    ???.q.putIfAbsent(paramRedPacketInfo.k, paramRedPacketInfo);
    ??? = ???.q;
    paramString2 = new StringBuilder();
    paramString2.append(paramRedPacketInfo.k);
    paramString2.append("_tp");
    ???.putIfAbsent(paramString2.toString(), paramRedPacketInfo);
    synchronized (paramIndividualRedPacketResDownloader.l)
    {
      if (!paramIndividualRedPacketResDownloader.l.containsKey(paramString1))
      {
        paramString2 = new ArrayList();
        paramString2.add(paramRedPacketInfo.k);
        paramIndividualRedPacketResDownloader.l.put(paramString1, paramString2);
      }
      else
      {
        ((List)paramIndividualRedPacketResDownloader.l.get(paramString1)).add(paramRedPacketInfo.k);
      }
      paramIndividualRedPacketResDownloader.a(16L, paramString1, paramRedPacketInfo.k);
      return null;
    }
  }
  
  public static String a(int paramInt)
  {
    Object localObject2 = a;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      return localObject2;
    case 8: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("SENDfinalimg/");
      return ((StringBuilder)localObject1).toString();
    case 7: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("TENPAYfinalimg/");
      return ((StringBuilder)localObject1).toString();
    case 6: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("AIOfinalimg/");
      return ((StringBuilder)localObject1).toString();
    case 5: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("personalfontimg/");
      return ((StringBuilder)localObject1).toString();
    case 4: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("fontimgprecreate/");
      return ((StringBuilder)localObject1).toString();
    case 3: 
      localObject1 = new StringBuilder();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject2).append("pddata/vas/");
      ((StringBuilder)localObject1).append(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject2).toString()));
      ((StringBuilder)localObject1).append("RedPacket/font/");
      return ((StringBuilder)localObject1).toString();
    case 2: 
      localObject1 = new StringBuilder();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject2).append("pddata/vas/");
      ((StringBuilder)localObject1).append(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject2).toString()));
      ((StringBuilder)localObject1).append("RedPacket/specialFont/");
      return ((StringBuilder)localObject1).toString();
    case 1: 
      localObject1 = new StringBuilder();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject2).append("pddata/vas/");
      ((StringBuilder)localObject1).append(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject2).toString()));
      ((StringBuilder)localObject1).append("RedPacket/packets/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  public static String a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localObject1 = paramQQAppInterface;
      if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
        localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      }
    }
    if (localObject1 == null) {
      return "";
    }
    IndividualRedPacketManager localIndividualRedPacketManager;
    if (localObject1 == null) {
      localIndividualRedPacketManager = null;
    } else {
      localIndividualRedPacketManager = (IndividualRedPacketManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
    }
    Object localObject2;
    if (localIndividualRedPacketManager != null)
    {
      if (localIndividualRedPacketManager.f()) {
        paramQQAppInterface = "1";
      } else {
        paramQQAppInterface = "0";
      }
      localObject2 = paramQQAppInterface;
    }
    else
    {
      localObject2 = null;
    }
    paramQQAppInterface = IndividuationUrlHelper.a(((QQAppInterface)localObject1).getApp().getApplicationContext(), "hongbao", "");
    if (1 == paramInt)
    {
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        paramQQAppInterface = paramQQAppInterface.replace("[from]", "1");
      }
      ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8006134", "0X8006134", 0, 0, (String)localObject2, "1", "", "");
    }
    else if (3 == paramInt)
    {
      if ((localIndividualRedPacketManager != null) && (localIndividualRedPacketManager.g()) && (localIndividualRedPacketManager.a().k))
      {
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          paramQQAppInterface = paramQQAppInterface.replace("[from]", "3");
        }
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8006136", "0X8006136", 0, 0, (String)localObject2, "1", "", "");
      }
      else
      {
        paramQQAppInterface = null;
      }
    }
    else
    {
      localObject1 = IndividuationUrlHelper.a(((QQAppInterface)localObject1).getApp().getApplicationContext(), "hongbao", "");
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramQQAppInterface = ((String)localObject1).replace("[from]", "2");
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = L;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("IndividualRedPacketManager.getMallURL=");
      ((StringBuilder)localObject2).append(null);
      ((StringBuilder)localObject2).append(", type:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", url:");
      ((StringBuilder)localObject2).append(paramQQAppInterface);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return paramQQAppInterface;
  }
  
  private static String a(IndividualRedPacketManager paramIndividualRedPacketManager, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramString3 = paramIndividualRedPacketManager.a(paramString1, paramString2, 18);
    }
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      if (!TextUtils.isEmpty(paramString2))
      {
        str = paramString3;
        if (!TextUtils.isEmpty(paramIndividualRedPacketManager.a("", paramString2, 16))) {}
      }
      else
      {
        str = paramIndividualRedPacketManager.a(paramString1, paramString2, 15);
      }
    }
    return str;
  }
  
  public static String a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool)
    {
      localObject1 = L;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getIDFromSCID error null: zipName=");
      ((StringBuilder)localObject2).append(paramString);
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return null;
    }
    Object localObject1 = localObject2;
    if (paramString.length() > 16)
    {
      localObject1 = localObject2;
      if (paramString.indexOf("luckyMoney.item.") >= 0) {
        localObject1 = paramString.substring(16);
      }
    }
    if ((QLog.isColorLevel()) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      localObject2 = L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIDFromSCID ok, scid = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", redPacketid=");
      localStringBuilder.append((String)localObject1);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    return localObject1;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    String str2 = "";
    String str1 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    case 1: 
    case 17: 
    case 20: 
    case 22: 
    case 23: 
    default: 
      localObject1 = str2;
      break;
    case 26: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(2));
      ((StringBuilder)localObject1).append("specialCharItem.zip");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 25: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(2));
      ((StringBuilder)localObject1).append("config.json");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 24: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(1));
      ((StringBuilder)localObject1).append(paramString1);
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 21: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(3));
      ((StringBuilder)localObject1).append("config.json");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 19: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(1));
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("aiopng.zip");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 18: 
      localObject1 = "_s";
      break;
    case 16: 
      localObject1 = a(paramString2, "", "send");
      break;
    case 15: 
      localObject1 = a(paramString1, paramString2, paramInt3, "", (String)localObject1, "sendimg", 8, "_send_");
      break;
    case 14: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(1));
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("sendimg");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 13: 
      str1 = "_s";
      break;
    case 12: 
      localObject2 = "_s";
      break;
    case 11: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(0));
      ((StringBuilder)localObject1).append("specialzip");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 10: 
      localObject1 = a(paramString2, "", "tp");
      break;
    case 9: 
      localObject1 = a(paramString2, "", "aio");
      break;
    case 8: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(3));
      ((StringBuilder)localObject1).append("font.ttf");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 7: 
      localObject1 = a(paramString1, paramString2, paramInt3, "", str1, "redenvelopeimg", 7, "_tp_");
      break;
    case 6: 
      localObject1 = a(paramString1, paramString2, paramInt3, "", (String)localObject2, "aioimg", 6, "_aio_");
      break;
    case 5: 
      localObject1 = b(paramString2, "", 5);
      break;
    case 4: 
      localObject1 = b(paramString2, "", 4);
      break;
    case 3: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(1));
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("redenvelopeimg");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 2: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(1));
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("aioimg");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(a(1));
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("config.json");
    localObject1 = ((StringBuilder)localObject1).toString();
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (QLog.isColorLevel()))
    {
      str1 = L;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getLocalImgAddress Error templateId: ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(", name:");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(", type:");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(", filename:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d(str1, 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  private static String a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6)
  {
    if (paramInt1 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.g)
    {
      paramString2 = new StringBuilder();
      paramString2.append(a(1));
      paramString2.append(paramString1);
      paramString2.append(File.separator);
      paramString2.append(paramString5);
      return paramString2.toString();
    }
    paramString5 = paramString3;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString5 = paramString3;
      if (paramInt1 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.f)
      {
        paramString3 = new StringBuilder();
        paramString3.append(a(paramInt2));
        paramString3.append(paramString1);
        paramString3.append(paramString6);
        paramString3.append(Integer.toHexString(paramString2.charAt(0)));
        paramString1 = paramString3.toString();
        paramString5 = paramString1;
        if (paramString4 != null)
        {
          paramString2 = new StringBuilder();
          paramString2.append(paramString1);
          paramString2.append(paramString4);
          paramString5 = paramString2.toString();
        }
      }
    }
    return paramString5;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = new StringBuilder();
      paramString2.append(a(2));
      paramString2.append("images");
      paramString2.append(File.separator);
      paramString2.append(paramString3);
      paramString2.append(File.separator);
      paramString2.append(Integer.toHexString(paramString1.charAt(0)));
      paramString2 = paramString2.toString();
    }
    return paramString2;
  }
  
  private void a(int paramInt, RedPacketInfo paramRedPacketInfo)
  {
    int i1;
    if (paramInt == 2)
    {
      i1 = 6;
    }
    else if (paramInt == 3)
    {
      i1 = 7;
    }
    else
    {
      i1 = paramInt;
      if (paramInt == 14) {
        i1 = 15;
      }
    }
    IndividualRedPacketManager.FontBitmap localFontBitmap = b(paramRedPacketInfo.d, i1);
    Bitmap localBitmap = a(localFontBitmap, paramRedPacketInfo, i1);
    if (QLog.isColorLevel())
    {
      String str = L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDoneDownloadBG type = ");
      localStringBuilder.append(i1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((localFontBitmap.a != null) && (!localFontBitmap.b)) {
      a(localFontBitmap.a, "", paramRedPacketInfo.d, 5);
    }
    if ((6 == i1) && (localFontBitmap.a != null) && (localBitmap != null))
    {
      if (!localFontBitmap.c)
      {
        a(localBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.d, 6);
        return;
      }
      a(localBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.d, 12);
    }
  }
  
  public static void a(AppInterface paramAppInterface, IndividualRedPacketManager paramIndividualRedPacketManager, RedPacketInfo paramRedPacketInfo)
  {
    if ((paramIndividualRedPacketManager != null) && (paramRedPacketInfo != null)) {}
    for (;;)
    {
      try
      {
        String str1 = paramRedPacketInfo.templateId;
        String str2 = paramRedPacketInfo.d;
        paramAppInterface = paramIndividualRedPacketManager.a();
        IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo = a(paramIndividualRedPacketManager, paramRedPacketInfo, str1, str2, paramAppInterface);
        if (localRedPacketTemplateInfo == null) {
          return;
        }
        if ((TextUtils.isEmpty(str2)) || (!paramAppInterface.d.a().contains(str2))) {
          break label432;
        }
        bool1 = true;
        if (localRedPacketTemplateInfo.e == IndividualRedPacketResDownloader.RedPacketTemplateInfo.f)
        {
          if (bool1)
          {
            paramAppInterface = paramIndividualRedPacketManager.a(str1, str2, 12);
            continue;
          }
        }
        else
        {
          boolean bool2 = a(paramIndividualRedPacketManager, paramRedPacketInfo, str1, paramAppInterface, localRedPacketTemplateInfo);
          if (bool2) {
            return;
          }
        }
        paramAppInterface = null;
        Object localObject1 = paramAppInterface;
        if (TextUtils.isEmpty(paramAppInterface)) {
          if (!TextUtils.isEmpty(str2))
          {
            localObject1 = paramAppInterface;
            if (!TextUtils.isEmpty(paramIndividualRedPacketManager.a("", str2, 9))) {}
          }
          else
          {
            localObject1 = paramIndividualRedPacketManager.a(str1, str2, 6);
          }
        }
        Object localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (localRedPacketTemplateInfo.i != 1)
          {
            paramAppInterface = paramIndividualRedPacketManager.b(str2, 6);
          }
          else
          {
            paramAppInterface = new IndividualRedPacketManager.FontBitmap();
            paramAppInterface.d = true;
          }
          localObject2 = paramIndividualRedPacketManager.a(paramAppInterface, paramRedPacketInfo, 6);
          localObject1 = paramAppInterface;
        }
        else
        {
          paramRedPacketInfo.e = a((String)localObject1, null);
          ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(paramRedPacketInfo);
          localObject1 = null;
          localObject2 = localObject1;
        }
        if ((localRedPacketTemplateInfo.e != IndividualRedPacketResDownloader.RedPacketTemplateInfo.f) || (!bool1)) {
          break label437;
        }
        paramAppInterface = paramIndividualRedPacketManager.a(str1, str2, 13);
        Object localObject3 = paramAppInterface;
        if (TextUtils.isEmpty(paramAppInterface)) {
          if (!TextUtils.isEmpty(str2))
          {
            localObject3 = paramAppInterface;
            if (!TextUtils.isEmpty(paramIndividualRedPacketManager.a("", str2, 10))) {}
          }
          else
          {
            localObject3 = paramIndividualRedPacketManager.a(str1, str2, 7);
          }
        }
        a(paramIndividualRedPacketManager, paramRedPacketInfo, str2, localRedPacketTemplateInfo, (String)localObject3, 7);
        if (localRedPacketTemplateInfo.e != IndividualRedPacketResDownloader.RedPacketTemplateInfo.f) {
          break label442;
        }
        paramAppInterface = a(paramIndividualRedPacketManager, str1, str2, null, bool1);
        a(paramIndividualRedPacketManager, paramRedPacketInfo, str2, localRedPacketTemplateInfo, paramAppInterface, 15);
        a(paramIndividualRedPacketManager, str1, str2, (IndividualRedPacketManager.FontBitmap)localObject1, (Bitmap)localObject2);
        return;
      }
      finally {}
      return;
      label432:
      boolean bool1 = false;
      continue;
      label437:
      paramAppInterface = null;
      continue;
      label442:
      paramAppInterface = null;
    }
  }
  
  private void a(IndividualRedPacketManager.FontBitmap paramFontBitmap, RedPacketInfo paramRedPacketInfo, int paramInt, Bitmap paramBitmap)
  {
    if (paramInt == 6)
    {
      paramRedPacketInfo.e = paramBitmap;
      return;
    }
    if (paramInt == 7)
    {
      if (paramFontBitmap.c)
      {
        a(paramBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.d, 13);
        return;
      }
      a(paramBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.d, 7);
      return;
    }
    if (paramInt == 15)
    {
      if (paramFontBitmap.c)
      {
        a(paramBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.d, 18);
        return;
      }
      a(paramBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.d, 15);
    }
  }
  
  private static void a(IndividualRedPacketManager paramIndividualRedPacketManager, RedPacketInfo paramRedPacketInfo, String paramString1, IndividualRedPacketResDownloader.RedPacketTemplateInfo paramRedPacketTemplateInfo, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramRedPacketTemplateInfo.i != 1)
      {
        paramString1 = paramIndividualRedPacketManager.b(paramString1, paramInt);
      }
      else
      {
        paramString1 = new IndividualRedPacketManager.FontBitmap();
        paramString1.d = true;
      }
      paramIndividualRedPacketManager.a(paramString1, paramRedPacketInfo, paramInt);
    }
  }
  
  private static void a(IndividualRedPacketManager paramIndividualRedPacketManager, String paramString1, String paramString2, IndividualRedPacketManager.FontBitmap paramFontBitmap, Bitmap paramBitmap)
  {
    if (paramFontBitmap == null) {
      return;
    }
    if ((paramFontBitmap.a != null) && (!paramFontBitmap.b) && (!paramFontBitmap.d)) {
      paramIndividualRedPacketManager.a(paramFontBitmap.a, "", paramString2, 5);
    }
    if ((paramBitmap != null) && ((paramFontBitmap.a != null) || (paramFontBitmap.d)))
    {
      if (paramFontBitmap.c)
      {
        paramIndividualRedPacketManager.a(paramBitmap, paramString1, paramString2, 12);
        return;
      }
      paramIndividualRedPacketManager.a(paramBitmap, paramString1, paramString2, 6);
    }
  }
  
  private boolean a(int paramInt, RedPacketInfo paramRedPacketInfo, IndividualRedPacketResDownloader.RedPacketTemplateInfo paramRedPacketTemplateInfo, boolean paramBoolean)
  {
    if (paramInt == 19)
    {
      Object localObject = paramRedPacketTemplateInfo.b;
      if ((localObject != null) && (((IndividualRedPacketResDownloader.DecorateInfo)localObject).c != null))
      {
        localObject = a(((IndividualRedPacketResDownloader.DecorateInfo)localObject).g, null, ((IndividualRedPacketResDownloader.DecorateInfo)localObject).k, ((IndividualRedPacketResDownloader.DecorateInfo)localObject).i, 0);
        File localFile = new File((String)localObject);
        if ((localFile.exists()) && (localFile.isFile())) {
          a(paramRedPacketTemplateInfo, paramRedPacketInfo, (String)localObject, false);
        }
        if (paramRedPacketInfo.h != null) {
          return true;
        }
      }
      return paramBoolean;
    }
    if (paramInt == 2) {
      paramRedPacketInfo.e = a(a(paramRedPacketTemplateInfo.a, "", 6), null);
    }
    return true;
  }
  
  private static boolean a(IndividualRedPacketManager paramIndividualRedPacketManager, RedPacketInfo paramRedPacketInfo, String paramString, IndividualRedPacketResDownloader paramIndividualRedPacketResDownloader, IndividualRedPacketResDownloader.RedPacketTemplateInfo paramRedPacketTemplateInfo)
  {
    IndividualRedPacketResDownloader.DecorateInfo localDecorateInfo = paramRedPacketTemplateInfo.b;
    boolean bool2 = false;
    if ((localDecorateInfo != null) && (localDecorateInfo.c != null))
    {
      if ((paramRedPacketInfo.h != null) && (!TextUtils.isEmpty(paramRedPacketInfo.h.a)))
      {
        ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(paramRedPacketInfo);
        return true;
      }
      String str = localDecorateInfo.g;
      int i1 = localDecorateInfo.k;
      int i2 = localDecorateInfo.i;
      Object localObject = null;
      str = a(str, null, i1, i2, 0);
      if (!TextUtils.isEmpty(str)) {
        localObject = new File(str);
      }
      if (localObject == null)
      {
        paramIndividualRedPacketManager = L;
        paramRedPacketInfo = new StringBuilder();
        paramRedPacketInfo.append("VIPHBStrategy.get animFolderPath file == null, zipPath=");
        paramRedPacketInfo.append(str);
        QLog.d(paramIndividualRedPacketManager, 2, paramRedPacketInfo.toString());
        return true;
      }
      boolean bool1 = bool2;
      if (((File)localObject).exists())
      {
        bool1 = bool2;
        if (((File)localObject).isFile())
        {
          bool1 = a(paramRedPacketTemplateInfo, paramRedPacketInfo, str, false);
          if ((QLog.isColorLevel()) || (!bool1))
          {
            paramRedPacketTemplateInfo = L;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("VIPHBStrategy.get animFolderPath getPathOk=");
            ((StringBuilder)localObject).append(bool1);
            ((StringBuilder)localObject).append(", zipPath=");
            ((StringBuilder)localObject).append(str);
            QLog.d(paramRedPacketTemplateInfo, 2, ((StringBuilder)localObject).toString());
          }
          if (bool1) {
            return true;
          }
          bool1 = true;
        }
      }
      paramIndividualRedPacketManager.q.putIfAbsent(paramRedPacketInfo.k, paramRedPacketInfo);
      if (QLog.isColorLevel())
      {
        paramIndividualRedPacketManager = L;
        paramRedPacketTemplateInfo = new StringBuilder();
        paramRedPacketTemplateInfo.append("wait animConfig id = ");
        paramRedPacketTemplateInfo.append(paramString);
        paramRedPacketTemplateInfo.append(", exist = ");
        paramRedPacketTemplateInfo.append(bool1);
        paramRedPacketTemplateInfo.append(", name=");
        paramRedPacketTemplateInfo.append(localDecorateInfo.f);
        QLog.d(paramIndividualRedPacketManager, 2, paramRedPacketTemplateInfo.toString());
      }
      paramIndividualRedPacketResDownloader.a(16L, paramString, paramRedPacketInfo.k);
      return true;
    }
    return false;
  }
  
  static boolean a(IndividualRedPacketResDownloader.RedPacketTemplateInfo paramRedPacketTemplateInfo, RedPacketInfo paramRedPacketInfo, String paramString, boolean paramBoolean)
  {
    IndividualRedPacketResDownloader.DecorateInfo localDecorateInfo;
    if ((paramRedPacketTemplateInfo != null) && (paramRedPacketTemplateInfo.b != null) && (paramRedPacketInfo != null) && (!TextUtils.isEmpty(paramString))) {
      localDecorateInfo = paramRedPacketTemplateInfo.b;
    }
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("_dir2");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject3 = new File((String)localObject1);
      bool1 = ((File)localObject3).exists();
      if ((!bool1) || (!((File)localObject3).isDirectory())) {
        break label968;
      }
      arrayOfString = ((File)localObject3).list();
      if (arrayOfString.length <= 0) {
        break label959;
      }
      i1 = 0;
    }
    catch (Exception paramRedPacketTemplateInfo)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        String[] arrayOfString;
        Object localObject4;
        StringBuilder localStringBuilder;
        continue;
        i1 += 1;
        continue;
        int i1 = 0;
        label953:
        boolean bool2 = true;
        continue;
        label959:
        i1 = 0;
        bool2 = false;
        continue;
        label968:
        int i2 = 0;
        boolean bool1 = false;
        Object localObject2 = localObject1;
      }
    }
    if (i1 < arrayOfString.length)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject3).getAbsolutePath());
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(arrayOfString[i1]);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject4 = new File((String)localObject2);
      if (((File)localObject4).exists()) {
        if (((File)localObject4).isDirectory())
        {
          localObject4 = ((File)localObject4).list();
          if (localObject4.length > 0)
          {
            i1 = localObject4.length;
            localObject1 = localObject2;
            break label953;
          }
          if (QLog.isColorLevel())
          {
            localObject4 = L;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getAnimatePath Err_path id:");
            localStringBuilder.append(paramRedPacketInfo.templateId);
            localStringBuilder.append(", path=");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(", name=");
            localStringBuilder.append(localDecorateInfo.f);
            QLog.d((String)localObject4, 2, localStringBuilder.toString());
          }
        }
        else
        {
          i1 = arrayOfString.length;
          break label953;
          if ((QLog.isColorLevel()) || (i1 == 0))
          {
            localObject2 = L;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getAnimatePath picNum Err id:");
            ((StringBuilder)localObject3).append(paramRedPacketInfo.templateId);
            ((StringBuilder)localObject3).append(", fileNames=");
            ((StringBuilder)localObject3).append(arrayOfString);
            ((StringBuilder)localObject3).append(", unZipDir=");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(", picNum=");
            ((StringBuilder)localObject3).append(i1);
            ((StringBuilder)localObject3).append(", size=");
            ((StringBuilder)localObject3).append(localDecorateInfo.c.b);
            QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
          }
          i2 = i1;
          localObject2 = localObject1;
          bool1 = bool2;
          if (paramBoolean) {
            if (i1 == localDecorateInfo.c.b)
            {
              i2 = i1;
              localObject2 = localObject1;
              bool1 = bool2;
              if (i1 != 0) {}
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("animConfig_size_err, id=");
              ((StringBuilder)localObject2).append(paramRedPacketInfo.templateId);
              VasMonitorHandler.a(null, "individual_v2_redpacket_json_err", "animConfig_size_err", ((StringBuilder)localObject2).toString(), null, 0.0F);
              i2 = i1;
              localObject2 = localObject1;
              bool1 = bool2;
            }
          }
          bool2 = bool1;
          if (!paramBoolean)
          {
            bool2 = bool1;
            if (!bool1)
            {
              bool1 = IndividualRedPacketResDownloader.a(paramString, (String)localObject2);
              bool2 = bool1;
              if (bool1)
              {
                paramBoolean = a(paramRedPacketTemplateInfo, paramRedPacketInfo, paramString, true);
                if (!QLog.isColorLevel()) {
                  return paramBoolean;
                }
                paramRedPacketTemplateInfo = L;
                paramString = new StringBuilder();
                paramString.append("set animConfig id:");
                paramString.append(paramRedPacketInfo.templateId);
                paramString.append(", name=");
                paramString.append(localDecorateInfo.f);
                paramString.append(" isRegetOk=");
                paramString.append(paramBoolean);
                QLog.d(paramRedPacketTemplateInfo, 2, paramString.toString());
                return paramBoolean;
              }
            }
          }
          if (QLog.isColorLevel())
          {
            paramRedPacketTemplateInfo = L;
            paramString = new StringBuilder();
            paramString.append("set animConfig end name=");
            paramString.append(localDecorateInfo.f);
            paramString.append(", id=");
            paramString.append(paramRedPacketInfo.templateId);
            paramString.append(", picNum=");
            paramString.append(i2);
            paramString.append(", fileExist=");
            paramString.append(bool2);
            paramString.append(", isUnZipBack=");
            paramString.append(paramBoolean);
            paramString.append(", unZipDir = ");
            paramString.append((String)localObject2);
            QLog.d(paramRedPacketTemplateInfo, 2, paramString.toString());
          }
          if (bool2)
          {
            localDecorateInfo.c.a = ((String)localObject2);
            paramRedPacketInfo.h = localDecorateInfo.c;
            paramRedPacketInfo.g = true;
            ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(paramRedPacketInfo);
            return true;
            paramRedPacketTemplateInfo = L;
            paramString = new StringBuilder();
            paramString.append("getAnimatePath Exception id:");
            paramString.append(paramRedPacketInfo.templateId);
            paramString.append(", name=");
            paramString.append(localDecorateInfo.f);
            QLog.e(paramRedPacketTemplateInfo, 2, paramString.toString());
          }
          return false;
          paramRedPacketTemplateInfo = L;
          paramRedPacketInfo = new StringBuilder();
          paramRedPacketInfo.append("getAnimatePath Exception 0.zipPath=");
          paramRedPacketInfo.append(paramString);
          QLog.e(paramRedPacketTemplateInfo, 2, paramRedPacketInfo.toString());
          return false;
        }
      }
    }
    return paramBoolean;
  }
  
  private boolean a(String paramString, int paramInt, IndividualRedPacketManager.FontBitmap paramFontBitmap)
  {
    Object localObject = this.o.getApplication().getApplicationContext().getResources().getAssets();
    if (6 == paramInt) {}
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("specialFont/aio/");
      localStringBuilder.append(Integer.toHexString(paramString.charAt(0)));
      localObject = ((AssetManager)localObject).open(localStringBuilder.toString());
      break label168;
      if (7 == paramInt)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("specialFont/tp/");
        localStringBuilder.append(Integer.toHexString(paramString.charAt(0)));
        localObject = ((AssetManager)localObject).open(localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("specialFont/send/");
        localStringBuilder.append(Integer.toHexString(paramString.charAt(0)));
        localObject = ((AssetManager)localObject).open(localStringBuilder.toString());
      }
      label168:
      paramFontBitmap.a = BitmapFactory.decodeStream((InputStream)localObject);
      paramFontBitmap.c = true;
      ((InputStream)localObject).close();
      if (QLog.isColorLevel())
      {
        paramFontBitmap = L;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getPersonalFontImg success! Special char = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d(paramFontBitmap, 2, ((StringBuilder)localObject).toString());
      }
      return true;
    }
    catch (Exception paramString)
    {
      break label234;
    }
    catch (IOException paramString)
    {
      label272:
      break label253;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label234:
      label253:
      break label272;
    }
    if (QLog.isColorLevel())
    {
      QLog.d(L, 2, paramString.getMessage());
      return false;
      if (QLog.isColorLevel())
      {
        QLog.d(L, 2, paramString.getMessage());
        return false;
        paramString = L;
        paramFontBitmap = new StringBuilder();
        paramFontBitmap.append("getPersonalFontImg assets oom:");
        paramFontBitmap.append(((OutOfMemoryError)localObject).getMessage());
        QLog.d(paramString, 2, paramFontBitmap.toString());
      }
    }
    return false;
  }
  
  private static String b(String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = new StringBuilder();
      paramString2.append(a(paramInt));
      paramString2.append(Integer.toHexString(paramString1.charAt(0)));
      paramString2 = paramString2.toString();
    }
    return paramString2;
  }
  
  public Bitmap a(IndividualRedPacketManager.FontBitmap paramFontBitmap, RedPacketInfo paramRedPacketInfo, int paramInt)
  {
    String str1 = "";
    String str2 = "0X800613F";
    if (paramInt == 6)
    {
      str1 = paramRedPacketInfo.d;
      str2 = "0X800612F";
    }
    String str3;
    if (f()) {
      str3 = "1";
    } else {
      str3 = "0";
    }
    long l1 = System.currentTimeMillis();
    Object localObject2 = a().a(paramRedPacketInfo.templateId, true);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(L, 2, "createRedPacketImg init json fail");
      }
      ReportController.b(this.o, "CliOper", "", "", str2, str2, 0, 0, str3, "0", "", str1);
      return null;
    }
    Object localObject1;
    if (6 == paramInt) {
      localObject1 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).b;
    } else if (7 == paramInt) {
      localObject1 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).c;
    } else {
      localObject1 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).d;
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(L, 2, "createRedPacketImg decorateInfo = null");
      }
      ReportController.b(this.o, "CliOper", "", "", str2, str2, 0, 0, str3, "0", "", str1);
      return null;
    }
    if (!IndividualRedPacketResDownloader.a((IndividualRedPacketResDownloader.RedPacketResInfo)localObject1))
    {
      if (((IndividualRedPacketResDownloader.DecorateInfo)localObject1).k == 2)
      {
        paramFontBitmap = paramRedPacketInfo.k;
      }
      else if (((IndividualRedPacketResDownloader.DecorateInfo)localObject1).k == 3)
      {
        paramFontBitmap = new StringBuilder();
        paramFontBitmap.append(paramRedPacketInfo.k);
        paramFontBitmap.append("_tp");
        paramFontBitmap = paramFontBitmap.toString();
      }
      else
      {
        paramFontBitmap = new StringBuilder();
        paramFontBitmap.append(paramRedPacketInfo.k);
        paramFontBitmap.append("_send");
        paramFontBitmap = paramFontBitmap.toString();
      }
      this.q.putIfAbsent(paramFontBitmap, paramRedPacketInfo);
      if (QLog.isColorLevel())
      {
        paramFontBitmap = L;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("createRedPacketImg id = ");
        ((StringBuilder)localObject2).append(paramRedPacketInfo.templateId);
        ((StringBuilder)localObject2).append(" content = ");
        ((StringBuilder)localObject2).append(paramRedPacketInfo.d);
        ((StringBuilder)localObject2).append(" not exists!");
        QLog.d(paramFontBitmap, 2, ((StringBuilder)localObject2).toString());
      }
      a().a(16L, ((IndividualRedPacketResDownloader.DecorateInfo)localObject1).g, paramRedPacketInfo.k);
      if (QLog.isColorLevel())
      {
        paramFontBitmap = L;
        paramRedPacketInfo = new StringBuilder();
        paramRedPacketInfo.append("createRedPacketImg BG not found,start download url : ");
        paramRedPacketInfo.append(((IndividualRedPacketResDownloader.DecorateInfo)localObject1).k);
        paramRedPacketInfo.append(", id=");
        paramRedPacketInfo.append(((IndividualRedPacketResDownloader.DecorateInfo)localObject1).g);
        QLog.d(paramFontBitmap, 2, paramRedPacketInfo.toString());
      }
      ReportController.b(this.o, "CliOper", "", "", str2, str2, 0, 0, str3, "0", "", str1);
      return null;
    }
    if (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).e == IndividualRedPacketResDownloader.RedPacketTemplateInfo.f) {
      localObject1 = a(paramFontBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.d, paramInt);
    } else {
      localObject1 = a(a(paramRedPacketInfo.templateId, paramRedPacketInfo.d, paramInt, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).h, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).e), null);
    }
    long l2 = System.currentTimeMillis();
    if (localObject1 != null)
    {
      a(paramFontBitmap, paramRedPacketInfo, paramInt, (Bitmap)localObject1);
      ReportController.b(this.o, "CliOper", "", "", str2, str2, 0, 0, str3, "1", String.valueOf(l2 - l1), str1);
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramFontBitmap = L;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("createRedPacketImg BG combine == null, templateinfo.type = ");
        localStringBuilder.append(((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).e);
        QLog.d(paramFontBitmap, 2, localStringBuilder.toString());
      }
      ReportController.b(this.o, "CliOper", "", "", str2, str2, 0, 0, str3, "0", String.valueOf(l2 - l1), str1);
    }
    if (paramInt == 6) {
      ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(paramRedPacketInfo);
    }
    return localObject1;
  }
  
  /* Error */
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 188	com/tencent/mobileqq/app/IndividualRedPacketManager:p	Lcom/etrump/mixlayout/ETEngine;
    //   6: astore 11
    //   8: aload 11
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 196	com/tencent/mobileqq/app/IndividualRedPacketManager:l	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   15: invokevirtual 1019	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   18: istore_3
    //   19: aconst_null
    //   20: astore 9
    //   22: aconst_null
    //   23: astore 10
    //   25: iload_3
    //   26: ifne +235 -> 261
    //   29: aload_0
    //   30: getfield 196	com/tencent/mobileqq/app/IndividualRedPacketManager:l	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   33: iconst_1
    //   34: invokevirtual 194	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   37: invokestatic 990	java/lang/System:currentTimeMillis	()J
    //   40: lstore 4
    //   42: aload_0
    //   43: getfield 188	com/tencent/mobileqq/app/IndividualRedPacketManager:p	Lcom/etrump/mixlayout/ETEngine;
    //   46: iconst_1
    //   47: ldc_w 1020
    //   50: invokevirtual 1024	com/etrump/mixlayout/ETEngine:initEngine	(II)Z
    //   53: ifeq +113 -> 166
    //   56: aload_0
    //   57: invokevirtual 267	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   60: getfield 1027	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:e	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   63: invokestatic 997	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   66: ifeq +24 -> 90
    //   69: aload_0
    //   70: getfield 188	com/tencent/mobileqq/app/IndividualRedPacketManager:p	Lcom/etrump/mixlayout/ETEngine;
    //   73: aconst_null
    //   74: aconst_null
    //   75: bipush 8
    //   77: iconst_0
    //   78: iconst_0
    //   79: invokestatic 290	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   82: getstatic 90	com/tencent/mobileqq/app/IndividualRedPacketManager:b	I
    //   85: iconst_1
    //   86: invokevirtual 1031	com/etrump/mixlayout/ETEngine:native_loadFont	(Ljava/lang/String;IZ)Z
    //   89: pop
    //   90: aload_0
    //   91: getfield 191	com/tencent/mobileqq/app/IndividualRedPacketManager:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   94: iconst_1
    //   95: invokevirtual 194	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   98: invokestatic 990	java/lang/System:currentTimeMillis	()J
    //   101: lstore 6
    //   103: invokestatic 345	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +155 -> 261
    //   109: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   112: astore 8
    //   114: new 68	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   121: astore 12
    //   123: aload 12
    //   125: ldc_w 1033
    //   128: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 12
    //   134: lload 6
    //   136: lload 4
    //   138: lsub
    //   139: invokevirtual 1036	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 12
    //   145: ldc_w 1038
    //   148: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 8
    //   154: iconst_2
    //   155: aload 12
    //   157: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: goto +98 -> 261
    //   166: aload_0
    //   167: getfield 188	com/tencent/mobileqq/app/IndividualRedPacketManager:p	Lcom/etrump/mixlayout/ETEngine;
    //   170: getfield 1041	com/etrump/mixlayout/ETEngine:isEngineInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   173: iconst_0
    //   174: iconst_1
    //   175: invokevirtual 1045	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   178: ifeq +7 -> 185
    //   181: invokestatic 1049	com/etrump/mixlayout/FontSoLoader:c	()Z
    //   184: pop
    //   185: aload_0
    //   186: getfield 191	com/tencent/mobileqq/app/IndividualRedPacketManager:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   189: iconst_0
    //   190: invokevirtual 194	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   193: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   196: iconst_1
    //   197: ldc_w 1051
    //   200: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: goto +58 -> 261
    //   206: astore 8
    //   208: aload_0
    //   209: getfield 191	com/tencent/mobileqq/app/IndividualRedPacketManager:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   212: iconst_0
    //   213: invokevirtual 194	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   216: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   219: astore 12
    //   221: new 68	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   228: astore 13
    //   230: aload 13
    //   232: ldc_w 1053
    //   235: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 13
    //   241: aload 8
    //   243: invokevirtual 1054	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 12
    //   252: iconst_1
    //   253: aload 13
    //   255: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_0
    //   262: getfield 191	com/tencent/mobileqq/app/IndividualRedPacketManager:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   265: invokevirtual 1019	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   268: ifeq +609 -> 877
    //   271: aload_1
    //   272: invokestatic 645	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   275: ifeq +6 -> 281
    //   278: goto +599 -> 877
    //   281: aload_0
    //   282: invokevirtual 267	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   285: getfield 1027	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:e	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   288: invokestatic 997	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   291: ifne +20 -> 311
    //   294: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   297: iconst_1
    //   298: ldc_w 1056
    //   301: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload 11
    //   306: monitorexit
    //   307: aload_0
    //   308: monitorexit
    //   309: aconst_null
    //   310: areturn
    //   311: aload_0
    //   312: getfield 1058	com/tencent/mobileqq/app/IndividualRedPacketManager:n	Lcom/etrump/mixlayout/ETFont;
    //   315: ifnonnull +32 -> 347
    //   318: aload_0
    //   319: new 1060	com/etrump/mixlayout/ETFont
    //   322: dup
    //   323: getstatic 90	com/tencent/mobileqq/app/IndividualRedPacketManager:b	I
    //   326: aconst_null
    //   327: ldc_w 285
    //   330: bipush 8
    //   332: iconst_0
    //   333: iconst_0
    //   334: invokestatic 290	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   337: aload_0
    //   338: getfield 107	com/tencent/mobileqq/app/IndividualRedPacketManager:c	F
    //   341: invokespecial 1063	com/etrump/mixlayout/ETFont:<init>	(ILjava/lang/String;F)V
    //   344: putfield 1058	com/tencent/mobileqq/app/IndividualRedPacketManager:n	Lcom/etrump/mixlayout/ETFont;
    //   347: aload_0
    //   348: getfield 1058	com/tencent/mobileqq/app/IndividualRedPacketManager:n	Lcom/etrump/mixlayout/ETFont;
    //   351: ldc_w 1065
    //   354: invokestatic 415	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   357: invokevirtual 1066	com/etrump/mixlayout/ETFont:setColor	(I)V
    //   360: iload_2
    //   361: ifeq +18 -> 379
    //   364: ldc_w 285
    //   367: aload_1
    //   368: iconst_4
    //   369: iconst_0
    //   370: iconst_0
    //   371: invokestatic 290	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   374: astore 8
    //   376: goto +15 -> 391
    //   379: ldc_w 285
    //   382: aload_1
    //   383: iconst_5
    //   384: iconst_0
    //   385: iconst_0
    //   386: invokestatic 290	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   389: astore 8
    //   391: aload 8
    //   393: invokestatic 645	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   396: ifeq +20 -> 416
    //   399: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   402: iconst_1
    //   403: ldc_w 1068
    //   406: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: aload 11
    //   411: monitorexit
    //   412: aload_0
    //   413: monitorexit
    //   414: aconst_null
    //   415: areturn
    //   416: new 707	java/io/File
    //   419: dup
    //   420: aload 8
    //   422: invokespecial 842	java/io/File:<init>	(Ljava/lang/String;)V
    //   425: astore 8
    //   427: aload_0
    //   428: getfield 107	com/tencent/mobileqq/app/IndividualRedPacketManager:c	F
    //   431: f2i
    //   432: aload_0
    //   433: getfield 107	com/tencent/mobileqq/app/IndividualRedPacketManager:c	F
    //   436: f2i
    //   437: getstatic 333	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   440: invokestatic 339	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   443: astore 12
    //   445: aload_0
    //   446: getfield 188	com/tencent/mobileqq/app/IndividualRedPacketManager:p	Lcom/etrump/mixlayout/ETEngine;
    //   449: aload_1
    //   450: iconst_0
    //   451: invokevirtual 756	java/lang/String:charAt	(I)C
    //   454: aload_0
    //   455: getfield 1058	com/tencent/mobileqq/app/IndividualRedPacketManager:n	Lcom/etrump/mixlayout/ETFont;
    //   458: invokevirtual 1072	com/etrump/mixlayout/ETEngine:native_isPaintableChar	(CLcom/etrump/mixlayout/ETFont;)Z
    //   461: ifeq +258 -> 719
    //   464: aload_0
    //   465: getfield 188	com/tencent/mobileqq/app/IndividualRedPacketManager:p	Lcom/etrump/mixlayout/ETEngine;
    //   468: aload_1
    //   469: aload 12
    //   471: iconst_0
    //   472: iconst_0
    //   473: aload_0
    //   474: getfield 1058	com/tencent/mobileqq/app/IndividualRedPacketManager:n	Lcom/etrump/mixlayout/ETFont;
    //   477: invokevirtual 1076	com/etrump/mixlayout/ETEngine:native_drawText	(Ljava/lang/String;Landroid/graphics/Bitmap;IILcom/etrump/mixlayout/ETFont;)Z
    //   480: istore_3
    //   481: iload_3
    //   482: ifne +6 -> 488
    //   485: goto +234 -> 719
    //   488: iload_2
    //   489: ifeq +222 -> 711
    //   492: aload 12
    //   494: ifnull +217 -> 711
    //   497: aload 10
    //   499: astore_1
    //   500: new 1078	java/io/BufferedOutputStream
    //   503: dup
    //   504: new 1080	java/io/FileOutputStream
    //   507: dup
    //   508: aload 8
    //   510: invokespecial 1083	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   513: invokespecial 1086	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   516: astore 8
    //   518: aload 12
    //   520: getstatic 1092	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   523: bipush 90
    //   525: aload 8
    //   527: invokevirtual 1096	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   530: pop
    //   531: aload 8
    //   533: invokevirtual 1099	java/io/BufferedOutputStream:flush	()V
    //   536: aload 8
    //   538: invokevirtual 1100	java/io/BufferedOutputStream:close	()V
    //   541: goto +170 -> 711
    //   544: astore 8
    //   546: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   549: astore_1
    //   550: aload_1
    //   551: iconst_1
    //   552: ldc_w 1102
    //   555: aload 8
    //   557: invokestatic 1105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   560: goto +151 -> 711
    //   563: astore_1
    //   564: goto +16 -> 580
    //   567: astore 9
    //   569: goto +22 -> 591
    //   572: astore 9
    //   574: aload_1
    //   575: astore 8
    //   577: aload 9
    //   579: astore_1
    //   580: goto +102 -> 682
    //   583: astore_1
    //   584: aload 9
    //   586: astore 8
    //   588: aload_1
    //   589: astore 9
    //   591: aload 8
    //   593: astore_1
    //   594: invokestatic 345	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +63 -> 660
    //   600: aload 8
    //   602: astore_1
    //   603: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   606: astore 10
    //   608: aload 8
    //   610: astore_1
    //   611: new 68	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   618: astore 13
    //   620: aload 8
    //   622: astore_1
    //   623: aload 13
    //   625: ldc_w 1107
    //   628: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 8
    //   634: astore_1
    //   635: aload 13
    //   637: aload 9
    //   639: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   642: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: aload 8
    //   648: astore_1
    //   649: aload 10
    //   651: iconst_2
    //   652: aload 13
    //   654: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   660: aload 8
    //   662: ifnull +49 -> 711
    //   665: aload 8
    //   667: invokevirtual 1100	java/io/BufferedOutputStream:close	()V
    //   670: goto +41 -> 711
    //   673: astore 8
    //   675: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   678: astore_1
    //   679: goto -129 -> 550
    //   682: aload 8
    //   684: ifnull +25 -> 709
    //   687: aload 8
    //   689: invokevirtual 1100	java/io/BufferedOutputStream:close	()V
    //   692: goto +17 -> 709
    //   695: astore 8
    //   697: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   700: iconst_1
    //   701: ldc_w 1102
    //   704: aload 8
    //   706: invokestatic 1105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   709: aload_1
    //   710: athrow
    //   711: aload 11
    //   713: monitorexit
    //   714: aload_0
    //   715: monitorexit
    //   716: aload 12
    //   718: areturn
    //   719: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   722: astore 8
    //   724: new 68	java/lang/StringBuilder
    //   727: dup
    //   728: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   731: astore 9
    //   733: aload 9
    //   735: ldc_w 1109
    //   738: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload 9
    //   744: aload_1
    //   745: iconst_0
    //   746: invokevirtual 756	java/lang/String:charAt	(I)C
    //   749: invokevirtual 1112	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   752: pop
    //   753: aload 8
    //   755: iconst_1
    //   756: aload 9
    //   758: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   764: aload 11
    //   766: monitorexit
    //   767: aload_0
    //   768: monitorexit
    //   769: aconst_null
    //   770: areturn
    //   771: astore_1
    //   772: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   775: astore 8
    //   777: new 68	java/lang/StringBuilder
    //   780: dup
    //   781: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   784: astore 9
    //   786: aload 9
    //   788: ldc_w 1114
    //   791: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: aload 9
    //   797: aload_1
    //   798: invokevirtual 447	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   801: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload 8
    //   807: iconst_1
    //   808: aload 9
    //   810: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: new 449	java/util/HashMap
    //   819: dup
    //   820: invokespecial 450	java/util/HashMap:<init>	()V
    //   823: astore_1
    //   824: aload_1
    //   825: ldc_w 452
    //   828: ldc_w 1116
    //   831: invokevirtual 458	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   834: pop
    //   835: getstatic 464	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   838: invokevirtual 465	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   841: invokestatic 471	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   844: getstatic 464	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   847: invokevirtual 475	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   850: checkcast 203	com/tencent/mobileqq/app/QQAppInterface
    //   853: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   856: ldc_w 480
    //   859: iconst_0
    //   860: lconst_1
    //   861: lconst_0
    //   862: aload_1
    //   863: ldc_w 285
    //   866: iconst_0
    //   867: invokevirtual 484	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   870: aload 11
    //   872: monitorexit
    //   873: aload_0
    //   874: monitorexit
    //   875: aconst_null
    //   876: areturn
    //   877: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   880: astore 8
    //   882: new 68	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   889: astore 9
    //   891: aload 9
    //   893: ldc_w 1118
    //   896: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: pop
    //   900: aload 9
    //   902: aload_0
    //   903: getfield 191	com/tencent/mobileqq/app/IndividualRedPacketManager:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   906: invokevirtual 1019	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   909: invokevirtual 864	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   912: pop
    //   913: aload 9
    //   915: ldc_w 1120
    //   918: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 9
    //   924: aload_1
    //   925: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload 8
    //   931: iconst_1
    //   932: aload 9
    //   934: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   937: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   940: aload 11
    //   942: monitorexit
    //   943: aload_0
    //   944: monitorexit
    //   945: aconst_null
    //   946: areturn
    //   947: astore_1
    //   948: aload 11
    //   950: monitorexit
    //   951: aload_1
    //   952: athrow
    //   953: astore_1
    //   954: aload_0
    //   955: monitorexit
    //   956: goto +5 -> 961
    //   959: aload_1
    //   960: athrow
    //   961: goto -2 -> 959
    //   964: astore_1
    //   965: goto -95 -> 870
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	968	0	this	IndividualRedPacketManager
    //   0	968	1	paramString	String
    //   0	968	2	paramBoolean	boolean
    //   18	464	3	bool	boolean
    //   40	97	4	l1	long
    //   101	34	6	l2	long
    //   112	41	8	str1	String
    //   206	36	8	localThrowable	java.lang.Throwable
    //   374	163	8	localObject1	Object
    //   544	12	8	localException1	Exception
    //   575	91	8	localObject2	Object
    //   673	15	8	localException2	Exception
    //   695	10	8	localException3	Exception
    //   722	208	8	str2	String
    //   20	1	9	localObject3	Object
    //   567	1	9	localException4	Exception
    //   572	13	9	localObject4	Object
    //   589	344	9	localObject5	Object
    //   23	627	10	str3	String
    //   6	943	11	localETEngine	ETEngine
    //   121	596	12	localObject6	Object
    //   228	425	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   42	90	206	java/lang/Throwable
    //   90	163	206	java/lang/Throwable
    //   166	185	206	java/lang/Throwable
    //   185	203	206	java/lang/Throwable
    //   536	541	544	java/lang/Exception
    //   518	536	563	finally
    //   518	536	567	java/lang/Exception
    //   500	518	572	finally
    //   594	600	572	finally
    //   603	608	572	finally
    //   611	620	572	finally
    //   623	632	572	finally
    //   635	646	572	finally
    //   649	660	572	finally
    //   500	518	583	java/lang/Exception
    //   665	670	673	java/lang/Exception
    //   687	692	695	java/lang/Exception
    //   427	445	771	java/lang/OutOfMemoryError
    //   11	19	947	finally
    //   29	42	947	finally
    //   42	90	947	finally
    //   90	163	947	finally
    //   166	185	947	finally
    //   185	203	947	finally
    //   208	261	947	finally
    //   261	278	947	finally
    //   281	307	947	finally
    //   311	347	947	finally
    //   347	360	947	finally
    //   364	376	947	finally
    //   379	391	947	finally
    //   391	412	947	finally
    //   416	427	947	finally
    //   427	445	947	finally
    //   445	481	947	finally
    //   536	541	947	finally
    //   546	550	947	finally
    //   550	560	947	finally
    //   665	670	947	finally
    //   675	679	947	finally
    //   687	692	947	finally
    //   697	709	947	finally
    //   709	711	947	finally
    //   711	714	947	finally
    //   719	767	947	finally
    //   772	816	947	finally
    //   816	870	947	finally
    //   870	873	947	finally
    //   877	943	947	finally
    //   948	951	947	finally
    //   2	11	953	finally
    //   951	953	953	finally
    //   816	870	964	java/lang/Exception
  }
  
  public IndividualRedPacketResDownloader a()
  {
    if (this.s == null) {
      this.s = new IndividualRedPacketResDownloader(this.o, this);
    }
    return this.s;
  }
  
  public String a(String paramString1, String paramString2)
  {
    boolean bool = h();
    Object localObject2 = null;
    if (!bool)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = L;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getTenpayCombineImg: isAllowShowRedpacket = false templateId = ");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append(";name = ");
        ((StringBuilder)localObject2).append(paramString2);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return null;
    }
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject1 = localObject2;
      if (a().d.a().contains(paramString2)) {
        localObject1 = a(paramString1, paramString2, 13);
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = a(paramString1, paramString2, 7);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTenpayCombineImg: templateId = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(";name = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", path = ");
      localStringBuilder.append((String)localObject2);
      QLog.d((String)localObject1, 2, localStringBuilder.toString());
    }
    return localObject2;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject1 = a().a(paramString1, true);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = L;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getLocalImg fail! can't find template templateId = ");
          ((StringBuilder)localObject2).append(paramString1);
          ((StringBuilder)localObject2).append(" name = ");
          ((StringBuilder)localObject2).append(paramString2);
          ((StringBuilder)localObject2).append("type = ");
          ((StringBuilder)localObject2).append(paramInt);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
      localObject1 = a(paramString1, paramString2, paramInt, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).h, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).e);
    }
    else
    {
      localObject1 = a("", paramString2, paramInt, 0, 0);
    }
    Object localObject2 = this.r;
    if (localObject1 != null) {}
    try
    {
      StringBuilder localStringBuilder;
      if (!this.r.contains(localObject1))
      {
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          ((File)localObject2).setLastModified(NetConnInfoCenter.getServerTimeMillis());
          if (QLog.isColorLevel())
          {
            localObject2 = L;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getLocalImg success! templateId = ");
            localStringBuilder.append(paramString1);
            localStringBuilder.append(" name = ");
            localStringBuilder.append(paramString2);
            localStringBuilder.append("type = ");
            localStringBuilder.append(paramInt);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
          }
          return localObject1;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = L;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getLocalImg fail! file not exists! templateId = ");
          ((StringBuilder)localObject2).append(paramString1);
          ((StringBuilder)localObject2).append(" name = ");
          ((StringBuilder)localObject2).append(paramString2);
          ((StringBuilder)localObject2).append("type = ");
          ((StringBuilder)localObject2).append(paramInt);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        return null;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = L;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getLocalImg fail! file Saving! templateId = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" name = ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("type = ");
        localStringBuilder.append(paramInt);
        QLog.d((String)localObject1, 2, localStringBuilder.toString());
      }
      return null;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IndividualRedPacketManager.setRedPacketFlags iCanUseRed:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", iRedDisable:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", isUpdate:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", this.iCanUseRed:");
      localStringBuilder.append(this.C);
      localStringBuilder.append(", this.iRedDisable:");
      localStringBuilder.append(this.D);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    int i1 = paramInt1;
    if (paramInt1 < 0) {
      i1 = this.C;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = this.D;
    }
    if ((this.C != i1) || (this.D != paramInt1))
    {
      this.C = i1;
      this.D = paramInt1;
      if (paramBoolean)
      {
        localObject = b();
        ((SharedPreferences)localObject).edit().putInt("sp_vip_info_can_use_packet", i1);
        ((SharedPreferences)localObject).edit().putInt("sp_vip_info_red_packet_disable", paramInt1);
        ((SharedPreferences)localObject).edit().commit();
      }
      if ((i1 == 1) && (paramInt1 == 0))
      {
        G = "1";
        return;
      }
      G = "0";
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRedpacketInfo redpacketId = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("; redpacketText = ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.E = paramInt;
    this.F = paramString;
    Object localObject = b();
    ((SharedPreferences)localObject).edit().putInt("sp_vip_info_red_packet_id", paramInt);
    ((SharedPreferences)localObject).edit().putString("sp_vip_info_red_packet_text", paramString);
    ((SharedPreferences)localObject).edit().commit();
  }
  
  /* Error */
  public void a(Bitmap paramBitmap, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +20 -> 21
    //   4: invokestatic 345	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +13 -> 20
    //   10: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   13: iconst_2
    //   14: ldc_w 1195
    //   17: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: return
    //   21: aload_2
    //   22: invokestatic 645	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: istore 7
    //   27: iconst_0
    //   28: istore 6
    //   30: iload 7
    //   32: ifne +36 -> 68
    //   35: aload_0
    //   36: invokevirtual 267	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   39: aload_2
    //   40: iconst_1
    //   41: invokevirtual 272	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo;
    //   44: astore 8
    //   46: aload 8
    //   48: ifnull +20 -> 68
    //   51: aload 8
    //   53: getfield 286	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:h	I
    //   56: istore 6
    //   58: aload 8
    //   60: getfield 287	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:e	I
    //   63: istore 5
    //   65: goto +6 -> 71
    //   68: iconst_0
    //   69: istore 5
    //   71: iload 4
    //   73: iconst_5
    //   74: if_icmpne +28 -> 102
    //   77: aload_3
    //   78: invokestatic 645	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifne +21 -> 102
    //   84: aload_0
    //   85: invokevirtual 267	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   88: getfield 788	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:d	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   91: invokevirtual 792	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:a	()Ljava/lang/String;
    //   94: aload_3
    //   95: invokevirtual 795	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   98: ifeq +4 -> 102
    //   101: return
    //   102: aload_2
    //   103: aload_3
    //   104: iload 4
    //   106: iload 6
    //   108: iload 5
    //   110: invokestatic 290	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   113: astore 10
    //   115: aload 10
    //   117: invokestatic 645	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: ifeq +19 -> 139
    //   123: invokestatic 345	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +13 -> 139
    //   129: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   132: iconst_2
    //   133: ldc_w 1197
    //   136: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: new 707	java/io/File
    //   142: dup
    //   143: aload 10
    //   145: invokespecial 842	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: astore_3
    //   149: aload_3
    //   150: invokevirtual 845	java/io/File:exists	()Z
    //   153: ifeq +46 -> 199
    //   156: invokestatic 345	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +39 -> 198
    //   162: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   165: astore_1
    //   166: new 68	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   173: astore_2
    //   174: aload_2
    //   175: ldc_w 1199
    //   178: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_2
    //   183: aload 10
    //   185: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_1
    //   190: iconst_2
    //   191: aload_2
    //   192: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: return
    //   199: aload_0
    //   200: getfield 201	com/tencent/mobileqq/app/IndividualRedPacketManager:r	Ljava/util/LinkedList;
    //   203: astore_2
    //   204: aload_2
    //   205: monitorenter
    //   206: aload_0
    //   207: getfield 201	com/tencent/mobileqq/app/IndividualRedPacketManager:r	Ljava/util/LinkedList;
    //   210: aload 10
    //   212: invokevirtual 1200	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   215: pop
    //   216: aload_2
    //   217: monitorexit
    //   218: aconst_null
    //   219: astore 8
    //   221: aconst_null
    //   222: astore 9
    //   224: aconst_null
    //   225: astore_2
    //   226: new 1078	java/io/BufferedOutputStream
    //   229: dup
    //   230: new 1080	java/io/FileOutputStream
    //   233: dup
    //   234: aload_3
    //   235: invokespecial 1083	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   238: invokespecial 1086	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   241: astore_3
    //   242: aload_1
    //   243: getstatic 1092	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   246: bipush 90
    //   248: aload_3
    //   249: invokevirtual 1096	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   252: pop
    //   253: aload_3
    //   254: invokevirtual 1099	java/io/BufferedOutputStream:flush	()V
    //   257: aload_3
    //   258: invokevirtual 1100	java/io/BufferedOutputStream:close	()V
    //   261: goto +195 -> 456
    //   264: astore_1
    //   265: aload_3
    //   266: astore_2
    //   267: goto +214 -> 481
    //   270: astore_2
    //   271: aload_3
    //   272: astore_1
    //   273: aload_2
    //   274: astore_3
    //   275: goto +19 -> 294
    //   278: astore_2
    //   279: aload_3
    //   280: astore_1
    //   281: aload_2
    //   282: astore_3
    //   283: goto +88 -> 371
    //   286: astore_1
    //   287: goto +194 -> 481
    //   290: astore_3
    //   291: aload 8
    //   293: astore_1
    //   294: aload_1
    //   295: astore_2
    //   296: invokestatic 345	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +57 -> 356
    //   302: aload_1
    //   303: astore_2
    //   304: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   307: astore 8
    //   309: aload_1
    //   310: astore_2
    //   311: new 68	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   318: astore 9
    //   320: aload_1
    //   321: astore_2
    //   322: aload 9
    //   324: ldc_w 1202
    //   327: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_1
    //   332: astore_2
    //   333: aload 9
    //   335: aload_3
    //   336: invokevirtual 978	java/io/IOException:getMessage	()Ljava/lang/String;
    //   339: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload_1
    //   344: astore_2
    //   345: aload 8
    //   347: iconst_2
    //   348: aload 9
    //   350: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: aload_1
    //   357: ifnull +99 -> 456
    //   360: aload_1
    //   361: invokevirtual 1100	java/io/BufferedOutputStream:close	()V
    //   364: goto +92 -> 456
    //   367: astore_3
    //   368: aload 9
    //   370: astore_1
    //   371: aload_1
    //   372: astore_2
    //   373: invokestatic 345	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   376: ifeq +57 -> 433
    //   379: aload_1
    //   380: astore_2
    //   381: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   384: astore 8
    //   386: aload_1
    //   387: astore_2
    //   388: new 68	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   395: astore 9
    //   397: aload_1
    //   398: astore_2
    //   399: aload 9
    //   401: ldc_w 1202
    //   404: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload_1
    //   409: astore_2
    //   410: aload 9
    //   412: aload_3
    //   413: invokevirtual 1203	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   416: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload_1
    //   421: astore_2
    //   422: aload 8
    //   424: iconst_2
    //   425: aload 9
    //   427: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 488	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_1
    //   434: ifnull +22 -> 456
    //   437: aload_1
    //   438: invokevirtual 1100	java/io/BufferedOutputStream:close	()V
    //   441: goto +15 -> 456
    //   444: astore_1
    //   445: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   448: iconst_1
    //   449: ldc_w 1205
    //   452: aload_1
    //   453: invokestatic 1105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   456: aload_0
    //   457: getfield 201	com/tencent/mobileqq/app/IndividualRedPacketManager:r	Ljava/util/LinkedList;
    //   460: astore_1
    //   461: aload_1
    //   462: monitorenter
    //   463: aload_0
    //   464: getfield 201	com/tencent/mobileqq/app/IndividualRedPacketManager:r	Ljava/util/LinkedList;
    //   467: aload 10
    //   469: invokevirtual 1208	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   472: pop
    //   473: aload_1
    //   474: monitorexit
    //   475: return
    //   476: astore_2
    //   477: aload_1
    //   478: monitorexit
    //   479: aload_2
    //   480: athrow
    //   481: aload_2
    //   482: ifnull +22 -> 504
    //   485: aload_2
    //   486: invokevirtual 1100	java/io/BufferedOutputStream:close	()V
    //   489: goto +15 -> 504
    //   492: astore_2
    //   493: getstatic 347	com/tencent/mobileqq/app/IndividualRedPacketManager:L	Ljava/lang/String;
    //   496: iconst_1
    //   497: ldc_w 1205
    //   500: aload_2
    //   501: invokestatic 1105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   504: aload_1
    //   505: athrow
    //   506: astore_1
    //   507: aload_2
    //   508: monitorexit
    //   509: aload_1
    //   510: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	IndividualRedPacketManager
    //   0	511	1	paramBitmap	Bitmap
    //   0	511	2	paramString1	String
    //   0	511	3	paramString2	String
    //   0	511	4	paramInt	int
    //   63	46	5	i1	int
    //   28	79	6	i2	int
    //   25	6	7	bool	boolean
    //   44	379	8	localObject	Object
    //   222	204	9	localStringBuilder	StringBuilder
    //   113	355	10	str	String
    // Exception table:
    //   from	to	target	type
    //   242	257	264	finally
    //   242	257	270	java/io/IOException
    //   242	257	278	java/io/FileNotFoundException
    //   226	242	286	finally
    //   296	302	286	finally
    //   304	309	286	finally
    //   311	320	286	finally
    //   322	331	286	finally
    //   333	343	286	finally
    //   345	356	286	finally
    //   373	379	286	finally
    //   381	386	286	finally
    //   388	397	286	finally
    //   399	408	286	finally
    //   410	420	286	finally
    //   422	433	286	finally
    //   226	242	290	java/io/IOException
    //   226	242	367	java/io/FileNotFoundException
    //   257	261	444	java/lang/Exception
    //   360	364	444	java/lang/Exception
    //   437	441	444	java/lang/Exception
    //   463	475	476	finally
    //   477	479	476	finally
    //   485	489	492	java/lang/Exception
    //   206	218	506	finally
    //   507	509	506	finally
  }
  
  public void a(IndividualRedPacketResDownloader.Char300Info paramChar300Info)
  {
    Object localObject;
    if (this.m.get())
    {
      paramChar300Info = L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preCreatePersonalFontImg mIsSDCardError:");
      ((StringBuilder)localObject).append(this.m.get());
      QLog.e(paramChar300Info, 1, ((StringBuilder)localObject).toString());
      return;
    }
    if ((!this.x.get()) && (this.w.booleanValue()))
    {
      if (paramChar300Info.c == 0) {
        return;
      }
      if (!TextUtils.isEmpty(paramChar300Info.a()))
      {
        if (!IndividualRedPacketResDownloader.a(a().e)) {
          return;
        }
        if (c().getInt("font_precreate_count", 0) >= paramChar300Info.e)
        {
          localObject = L;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("preCreatePersonalFontImg count >= ");
          localStringBuilder.append(paramChar300Info.e);
          QLog.d((String)localObject, 1, localStringBuilder.toString());
          return;
        }
        if ((g()) && (this.x.compareAndSet(false, true)))
        {
          this.z = ThreadManager.newFreeHandlerThread("RedPacketPrecreate", 19);
          this.z.start();
          this.A = new IndividualRedPacketManager.PrecreateRunnable(this, this.o, paramChar300Info);
          this.B = new Handler(this.z.getLooper(), this.A);
          this.A.a();
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = L;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onDoneDownloadBG id = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", resType:");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = (RedPacketInfo)this.q.get(paramString);
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = a().a(((RedPacketInfo)localObject1).templateId, true);
    if (localObject2 == null) {
      return;
    }
    int i1 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).e;
    int i2 = IndividualRedPacketResDownloader.RedPacketTemplateInfo.f;
    boolean bool = false;
    if (i1 == i2) {
      a(paramInt, (RedPacketInfo)localObject1);
    } else {
      bool = a(paramInt, (RedPacketInfo)localObject1, (IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2, false);
    }
    this.q.remove(paramString);
    if (bool) {
      ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a((RedPacketInfo)localObject1);
    }
  }
  
  public void a(String paramString, Bundle paramBundle, MessengerService paramMessengerService)
  {
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo = a().a(paramString, true);
    int i2 = K;
    int i1 = i2;
    if (localRedPacketTemplateInfo != null)
    {
      i1 = i2;
      if (!TextUtils.isEmpty(paramString))
      {
        if (localRedPacketTemplateInfo.b != null) {
          i1 = localRedPacketTemplateInfo.b.k;
        }
        if (new File(a(paramString, "", 2, localRedPacketTemplateInfo.h, localRedPacketTemplateInfo.e)).exists()) {
          i1 = J;
        } else {
          i1 = K;
        }
      }
    }
    if (i1 != J) {
      a().a(16L, paramString, null);
    }
    paramString = new Bundle();
    paramString.putInt("result", i1);
    paramBundle.putBundle("response", paramString);
    paramMessengerService.a(paramBundle);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, MessengerService paramMessengerService)
  {
    ThreadManager.post(new IndividualRedPacketManager.4(this, paramString1, paramString2, paramBundle, paramMessengerService), 8, null, true);
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject1 = new String[9];
    int i5 = 1;
    localObject1[0] = a(1);
    localObject1[1] = a(3);
    localObject1[2] = a(1);
    localObject1[3] = a(5);
    localObject1[4] = a(4);
    localObject1[5] = a(6);
    localObject1[6] = a(7);
    localObject1[7] = a(8);
    localObject1[8] = a(2);
    int i3 = 0;
    Object localObject2;
    int i4;
    boolean bool;
    int i2;
    for (int i1 = 0; i3 < localObject1.length; i1 = i4)
    {
      localObject2 = new File(localObject1[i3]);
      if (((File)localObject2).exists())
      {
        i4 = i1;
        if (((File)localObject2).isDirectory()) {}
      }
      else
      {
        bool = ((File)localObject2).mkdirs();
        i2 = i1;
        if (!bool) {
          i2 = i1 + 1;
        }
        i4 = i2;
        if (QLog.isColorLevel())
        {
          localObject2 = L;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initDir path:");
          localStringBuilder.append(localObject1[i3]);
          localStringBuilder.append(", mkdirs:");
          localStringBuilder.append(bool);
          localStringBuilder.append(", errCode:");
          localStringBuilder.append(i2);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
          i4 = i2;
        }
      }
      i3 += 1;
    }
    if (i1 <= 0) {
      i2 = i5;
    } else {
      i2 = 0;
    }
    if (i2 == 0)
    {
      bool = VipFunCallUtil.a(this.o.getApplication(), L, false);
      this.m.set(bool ^ true);
      localObject1 = L;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initDir Err haveSDCard:");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", mIsSDCardError:");
      ((StringBuilder)localObject2).append(this.m.get());
      ((StringBuilder)localObject2).append(", errCode:");
      ((StringBuilder)localObject2).append(i1);
      QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((this.m.get()) && (paramBoolean))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.o.getApplication().getFilesDir());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("dRedPacket/");
      a = ((StringBuilder)localObject1).toString();
      a(false);
    }
  }
  
  public SharedPreferences b()
  {
    if (this.t == null)
    {
      Context localContext = this.o.getApplication().getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("individRedPacket_");
      localStringBuilder.append(this.o.getAccount());
      this.t = localContext.getSharedPreferences(localStringBuilder.toString(), 0);
    }
    return this.t;
  }
  
  public IndividualRedPacketManager.FontBitmap b(String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    IndividualRedPacketManager.FontBitmap localFontBitmap = new IndividualRedPacketManager.FontBitmap();
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString)) && (a().d.a().contains(paramString)))
    {
      localFontBitmap.b = true;
      if ((!TextUtils.isEmpty(a().d.b)) && (a().d.b.contains(paramString)))
      {
        int i1 = 16;
        if (6 == paramInt) {
          i1 = 9;
        } else if (7 == paramInt) {
          i1 = 10;
        }
        localObject1 = a(null, paramString, i1, 0, 0);
        a("", paramString, i1);
        if (new File((String)localObject1).exists())
        {
          localFontBitmap.a = a((String)localObject1, null);
          localFontBitmap.c = true;
          if (QLog.isColorLevel())
          {
            localObject1 = L;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getPersonalFontImg success! Special char = ");
            ((StringBuilder)localObject2).append(paramString);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
          return localFontBitmap;
        }
        if (!TextUtils.isEmpty(c().getString("special_unzip_version_key", ""))) {
          c().edit().putString("special_unzip_version_key", "").commit();
        }
      }
      else if ((TextUtils.isEmpty("")) && ("".contains(paramString)) && (a(paramString, paramInt, localFontBitmap)))
      {
        return localFontBitmap;
      }
    }
    Object localObject3 = a("", paramString, 4, 0, 0);
    for (Object localObject2 = new File((String)localObject3);; localObject2 = localObject3)
    {
      synchronized (this.r)
      {
        if (((File)localObject2).exists())
        {
          localObject1 = localObject3;
          if (!this.r.contains(localObject3)) {}
        }
        else
        {
          String str = a("", paramString, 5, 0, 0);
          localObject3 = new File(str);
          if (!((File)localObject3).exists()) {
            break label671;
          }
          localObject2 = localObject3;
          localObject1 = str;
          if (this.r.contains(str)) {
            break label671;
          }
        }
        long l2;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          ((File)localObject2).setLastModified(System.currentTimeMillis());
          localFontBitmap.a = a((String)localObject1, null);
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel())
          {
            paramString = L;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getPersonalFontImg from file success time-consuming = ");
            ((StringBuilder)localObject1).append(l2 - l1);
            ((StringBuilder)localObject1).append("ms");
            QLog.d(paramString, 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          localFontBitmap.a = a(paramString, false);
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel())
          {
            paramString = L;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getPersonalFontImg create success time-consuming = ");
            ((StringBuilder)localObject1).append(l2 - l1);
            ((StringBuilder)localObject1).append("ms");
            QLog.d(paramString, 2, ((StringBuilder)localObject1).toString());
          }
        }
        localFontBitmap.c = false;
        if (QLog.isColorLevel())
        {
          paramString = L;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getPersonalFontImg fontImage = ");
          ((StringBuilder)localObject1).append(localFontBitmap.a);
          ((StringBuilder)localObject1).append("Special Char = ");
          ((StringBuilder)localObject1).append(localFontBitmap.b);
          ((StringBuilder)localObject1).append("Special image = ");
          ((StringBuilder)localObject1).append(localFontBitmap.c);
          QLog.d(paramString, 2, ((StringBuilder)localObject1).toString());
        }
        return localFontBitmap;
      }
      label671:
      localObject1 = null;
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = c().getString("cach_font_id", "");
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(a().e.g)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(L, 2, "Clear SDCard Cache Start!");
      }
      localObject1 = new String[5];
      localObject1[0] = a(4);
      localObject1[1] = a(5);
      localObject1[2] = a(6);
      localObject1[3] = a(7);
      localObject1[4] = a(8);
      int i1 = 0;
      while (i1 < localObject1.length)
      {
        File localFile = new File(localObject1[i1]);
        if ((localFile.exists()) && (localFile.isDirectory()))
        {
          Object localObject2 = localFile.listFiles();
          int i2 = 0;
          Object localObject3;
          while (i2 < localObject2.length)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(localObject2[i2].getParent());
            ((StringBuilder)localObject3).append(File.separator);
            ((StringBuilder)localObject3).append(System.currentTimeMillis());
            localObject3 = new File(((StringBuilder)localObject3).toString());
            localObject2[i2].renameTo((File)localObject3);
            ((File)localObject3).delete();
            i2 += 1;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = L;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("Clear ");
            ((StringBuilder)localObject3).append(localFile.getAbsolutePath());
            ((StringBuilder)localObject3).append(" done!");
            QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
          }
        }
        i1 += 1;
      }
    }
    c().edit().putString("cach_font_id", paramString).commit();
  }
  
  public SharedPreferences c()
  {
    if (this.u == null)
    {
      QQAppInterface localQQAppInterface = this.o;
      Object localObject = localQQAppInterface;
      if (localQQAppInterface == null) {
        localObject = BaseApplicationImpl.sApplication.getRuntime();
      }
      this.u = ((AppRuntime)localObject).getApplication().getApplicationContext().getSharedPreferences("individRedPacket_common", 0);
    }
    return this.u;
  }
  
  public String d()
  {
    String str1 = String.valueOf(this.E);
    String str2 = this.F;
    if (QLog.isColorLevel())
    {
      localObject1 = L;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getSendCombineImg: templateId = ");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(";name = ");
      ((StringBuilder)localObject2).append(str2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (h())
    {
      localObject2 = a(str1, str2, 15);
      Object localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = L;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getSendCombineImg templateId = ");
          ((StringBuilder)localObject3).append(str1);
          ((StringBuilder)localObject3).append("; name = ");
          ((StringBuilder)localObject3).append(str2);
          ((StringBuilder)localObject3).append("; combinefilename = ");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
        }
        return localObject2;
      }
      localObject1 = a().a(str1, true);
      if ((localObject1 != null) && (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).d != null))
      {
        localObject3 = a(str1, "", 14, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).h, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).e);
        Object localObject4 = new File((String)localObject3);
        if (!((File)localObject4).exists())
        {
          Object localObject5 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).d;
          if (localObject5 == null)
          {
            localObject1 = L;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getSendCombineImg filenot exists senddecorate = null; templateId = ");
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).append(";name = ");
            ((StringBuilder)localObject2).append(str2);
            QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            return null;
          }
          localObject5 = ((IndividualRedPacketResDownloader.DecorateInfo)localObject5).h;
          if (TextUtils.isEmpty((CharSequence)localObject5))
          {
            localObject1 = L;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getSendCombineImg filenot exists url is empty; templateId = ");
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).append(";name = ");
            ((StringBuilder)localObject2).append(str2);
            QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            return null;
          }
          int i1 = DownloaderFactory.a(new DownloadTask((String)localObject5, (File)localObject4), null);
          if (i1 != 0)
          {
            localObject1 = L;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getSendCombineImg filenot exists download bg faile; templateId = ");
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).append(";name = ");
            ((StringBuilder)localObject2).append(str2);
            ((StringBuilder)localObject2).append("; downloadresult = ");
            ((StringBuilder)localObject2).append(i1);
            QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            return null;
          }
        }
        if (!((File)localObject4).exists())
        {
          localObject1 = L;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getSendCombineImg filenot exists file not exists 2222; templateId = ");
          ((StringBuilder)localObject2).append(str1);
          ((StringBuilder)localObject2).append(";name = ");
          ((StringBuilder)localObject2).append(str2);
          QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          return null;
        }
        if ((((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).e != IndividualRedPacketResDownloader.RedPacketTemplateInfo.g) && (!TextUtils.isEmpty(str2)))
        {
          localObject3 = b(str2, 15);
          if (localObject3 == null)
          {
            localObject1 = L;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getSendCombineImg fontImg = null ; templateId = ");
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).append("; name = ");
            ((StringBuilder)localObject2).append(str2);
            QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            return null;
          }
          if (((IndividualRedPacketManager.FontBitmap)localObject3).a != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(L, 2, "getSendCombineImg savefontimg");
            }
            a(((IndividualRedPacketManager.FontBitmap)localObject3).a, str1, str2, 4);
          }
          localObject4 = a((IndividualRedPacketManager.FontBitmap)localObject3, str1, str2, 15);
          if (localObject4 != null)
          {
            if (((IndividualRedPacketManager.FontBitmap)localObject3).c)
            {
              a((Bitmap)localObject4, str1, str2, 18);
              localObject1 = a(str1, str2, 18, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).h, IndividualRedPacketResDownloader.RedPacketTemplateInfo.f);
            }
            else
            {
              a((Bitmap)localObject4, str1, str2, 15);
              localObject1 = a(str1, str2, 15, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).h, IndividualRedPacketResDownloader.RedPacketTemplateInfo.f);
            }
            if (QLog.isColorLevel())
            {
              localObject3 = L;
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("getSendCombineImg2 templateId = ");
              ((StringBuilder)localObject4).append(str1);
              ((StringBuilder)localObject4).append("; name = ");
              ((StringBuilder)localObject4).append(str2);
              ((StringBuilder)localObject4).append("; combinefilename = ");
              ((StringBuilder)localObject4).append((String)localObject2);
              QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
            }
            return localObject1;
          }
          localObject1 = L;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getSendCombineImg3 null allowshowredpacket templateId =");
          ((StringBuilder)localObject2).append(str1);
          ((StringBuilder)localObject2).append(";name = ");
          ((StringBuilder)localObject2).append(str2);
          QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          return null;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = L;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("getSendCombineImg1 templateId = ");
          ((StringBuilder)localObject4).append(str1);
          ((StringBuilder)localObject4).append("; name = ");
          ((StringBuilder)localObject4).append(str2);
          ((StringBuilder)localObject4).append("; combinefilename = ");
          ((StringBuilder)localObject4).append((String)localObject2);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject4).toString());
        }
        return localObject3;
      }
      localObject1 = L;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getSendCombineImg info = null ; templateId = ");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append("; name = ");
      ((StringBuilder)localObject2).append(str2);
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      a().a(16L, str1, null);
      return null;
    }
    Object localObject1 = L;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getSendCombineImg not allowshowredpacket templateId =");
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append(";name = ");
    ((StringBuilder)localObject2).append(str2);
    QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    return null;
  }
  
  public void e()
  {
    ThreadManager.post(new IndividualRedPacketManager.2(this), 2, null, true);
  }
  
  public boolean f()
  {
    return (this.C == 1) && (this.D == 0);
  }
  
  public boolean g()
  {
    return this.D == 0;
  }
  
  public boolean h()
  {
    return (g()) && (a().j);
  }
  
  public void onDestroy()
  {
    Object localObject = this.z;
    if (localObject != null)
    {
      ((HandlerThread)localObject).interrupt();
      this.z.quit();
      this.z = null;
    }
    if (this.A != null) {
      this.B.removeCallbacksAndMessages(null);
    }
    localObject = this.s;
    if (localObject != null)
    {
      ((IndividualRedPacketResDownloader)localObject).b();
      this.s = null;
    }
    this.y.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager
 * JD-Core Version:    0.7.0.1
 */