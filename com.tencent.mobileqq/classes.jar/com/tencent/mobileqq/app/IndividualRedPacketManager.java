package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.AnimConfig;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.Char300Info;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.DecorateInfo;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketResInfo;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketTemplateInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import zmq;
import zmr;
import zms;
import zmt;

public class IndividualRedPacketManager
  implements Manager
{
  public static int a;
  public static String a;
  public static String c;
  private static String jdField_d_of_type_JavaLangString = "IndividualRedPacketManager";
  public static int k;
  public static int l = -1;
  public static int m;
  public static int n = -1;
  float jdField_a_of_type_Float = 0.0F;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public Handler a;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine;
  ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  IndividualRedPacketManager.PrecreateRunnable jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$PrecreateRunnable;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public IndividualRedPacketResDownloader a;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  public Comparator a;
  public LinkedList a;
  public ConcurrentHashMap a;
  public AtomicBoolean a;
  float jdField_b_of_type_Float;
  public int b;
  SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  public String b;
  public AtomicBoolean b;
  int c;
  public AtomicBoolean c;
  int jdField_d_of_type_Int = 0;
  AtomicBoolean jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  int jdField_e_of_type_Int = 0;
  AtomicBoolean jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  int f = 0;
  int g = 0;
  public int h = 0;
  public int i = 0;
  public int j = -1;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aK + "RedPacket/";
    jdField_a_of_type_Int = 10029;
    jdField_c_of_type_JavaLangString = "0";
  }
  
  public IndividualRedPacketManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilComparator = new zms(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    SharedPreferences localSharedPreferences = a();
    a(localSharedPreferences.getInt("sp_vip_info_can_use_packet", 0), localSharedPreferences.getInt("sp_vip_info_red_packet_disable", 0), false);
    a(localSharedPreferences.getInt("sp_vip_info_red_packet_id", -1), localSharedPreferences.getString("sp_vip_info_red_packet_text", null));
    this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstanceForRedPacket();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_b_of_type_Float = paramQQAppInterface.getApp().getApplicationContext().getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = ((int)(138.0F * this.jdField_b_of_type_Float + 0.5D));
    this.jdField_c_of_type_Int = ((int)(115.0F * this.jdField_b_of_type_Float + 0.5D));
    this.jdField_e_of_type_Int = ((int)(this.jdField_b_of_type_Float * 280.0F + 0.5D));
    this.jdField_d_of_type_Int = ((int)(this.jdField_b_of_type_Float * 280.0F + 0.5D));
    this.g = ((int)(this.jdField_b_of_type_Float * 104.0F + 0.5D));
    this.f = ((int)(320.0F * this.jdField_b_of_type_Float + 0.5D));
    this.jdField_a_of_type_Float = ((int)(this.jdField_b_of_type_Float * 104.0F + 0.5D));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    ThreadManager.post(new zmq(this), 8, null, true);
  }
  
  private Bitmap a(IndividualRedPacketManager.FontBitmap paramFontBitmap, String paramString1, String paramString2, int paramInt)
  {
    Object localObject3 = a().a(paramString1, true);
    if ((localObject3 == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_d_of_type_JavaLangString, 2, "combineFinalImage init json fail, templateId:" + paramString1);
      }
      return null;
    }
    Object localObject2 = null;
    int i3 = 0;
    int i2 = 0;
    int i1 = 0;
    Object localObject1 = "#ffe589";
    Point localPoint = null;
    if (paramInt == 6)
    {
      localObject2 = a(paramString1, "", 2, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_d_of_type_Int, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_a_of_type_Int);
      i1 = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_Int / 2);
      i3 = this.jdField_b_of_type_Int;
      i2 = this.jdField_c_of_type_Int;
      localPoint = new Point(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect.left / 2), DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect.top / 2));
      localObject1 = "#ffe589";
    }
    for (;;)
    {
      localObject2 = a((String)localObject2, null);
      localObject3 = paramFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject2 != null) {
        break;
      }
      return null;
      if (paramInt == 7)
      {
        localObject2 = a(paramString1, "", 3, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_d_of_type_Int, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_a_of_type_Int);
        i1 = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_Int / 2);
        i3 = this.jdField_d_of_type_Int;
        i2 = this.jdField_e_of_type_Int;
        localPoint = new Point(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect.left / 2), DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect.top / 2));
        localObject1 = "#d13d4b";
      }
      else if (paramInt == 15)
      {
        localObject2 = a(paramString1, "", 14, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_d_of_type_Int, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_a_of_type_Int);
        i1 = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_Int / 2);
        i3 = this.f;
        i2 = this.g;
        localPoint = new Point(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect.left / 2), DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect.top / 2));
        localObject1 = "#edd4d8";
      }
    }
    try
    {
      paramString1 = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
      if (paramString1 == null) {
        return paramString1;
      }
    }
    catch (OutOfMemoryError paramFontBitmap)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "combineFinalImage Bitmap.createBitmap OutOfMemoryError: " + paramFontBitmap.getMessage());
      }
    }
    catch (Exception paramString1)
    {
      try
      {
        for (;;)
        {
          paramFontBitmap = new HashMap();
          paramFontBitmap.put("param_FailCode", "combineFinalImage");
          StatisticCollector.a(BaseApplicationImpl.sApplication.getApplicationContext()).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedpacketCreateBitmapError", false, 1L, 0L, paramFontBitmap, "", false);
          label629:
          return null;
          paramString1 = paramString1;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_d_of_type_JavaLangString, 2, "combineFinalImage Bitmap.createBitmap Error: " + paramString1.getMessage());
          }
          paramString1 = null;
        }
        RectF localRectF = new RectF();
        Rect localRect = new Rect();
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        localPaint.setDither(true);
        localPaint.setFilterBitmap(true);
        Canvas localCanvas = new Canvas(paramString1);
        localRect.set(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
        localRectF.set(0.0F, 0.0F, i3, i2);
        localCanvas.drawBitmap((Bitmap)localObject2, localRect, localRectF, localPaint);
        if (localObject3 != null) {
          if ((paramInt == 7) && (!paramFontBitmap.jdField_a_of_type_Boolean))
          {
            localPaint.setColorFilter(new LightingColorFilter(0, 13712715));
            localRect.set(0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
            localRectF.set(localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i1);
            localCanvas.drawBitmap((Bitmap)localObject3, localRect, localRectF, localPaint);
          }
        }
        for (;;)
        {
          return paramString1;
          if ((paramInt != 15) || (paramFontBitmap.jdField_a_of_type_Boolean)) {
            break;
          }
          localPaint.setColorFilter(new LightingColorFilter(0, 15586520));
          break;
          localPaint.setColor(Color.parseColor((String)localObject1));
          localPaint.setTextSize(i1 * 0.7F);
          paramFontBitmap = new float[1];
          localObject1 = localPaint.getFontMetricsInt();
          localPaint.getTextWidths(paramString2, paramFontBitmap);
          float f1 = localPoint.x;
          paramInt = (int)((i1 - paramFontBitmap[0]) / 2.0F + f1);
          i2 = localPoint.y;
          i3 = ((Paint.FontMetricsInt)localObject1).ascent;
          i1 = (i1 - (((Paint.FontMetricsInt)localObject1).descent - ((Paint.FontMetricsInt)localObject1).ascent)) / 2;
          localCanvas.drawText(paramString2, paramInt, i2 - i3 + i1, localPaint);
        }
      }
      catch (Exception paramFontBitmap)
      {
        break label629;
      }
    }
  }
  
  /* Error */
  static Bitmap a(String paramString, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore_3
    //   9: aload 6
    //   11: astore 4
    //   13: getstatic 458	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   16: aload_0
    //   17: invokevirtual 464	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: ifnull +375 -> 395
    //   23: aload 5
    //   25: astore_3
    //   26: aload 6
    //   28: astore 4
    //   30: getstatic 458	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   33: aload_0
    //   34: invokevirtual 464	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 311	android/graphics/Bitmap
    //   40: astore 5
    //   42: aload 5
    //   44: astore_3
    //   45: aload_3
    //   46: astore 4
    //   48: aload_3
    //   49: ifnonnull +343 -> 392
    //   52: aload_1
    //   53: astore 6
    //   55: aload_1
    //   56: ifnonnull +32 -> 88
    //   59: aload_3
    //   60: astore 4
    //   62: aload_3
    //   63: astore 5
    //   65: new 466	android/graphics/BitmapFactory$Options
    //   68: dup
    //   69: invokespecial 467	android/graphics/BitmapFactory$Options:<init>	()V
    //   72: astore 6
    //   74: aload_3
    //   75: astore 4
    //   77: aload_3
    //   78: astore 5
    //   80: aload 6
    //   82: getstatic 470	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   85: putfield 473	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   88: aload_3
    //   89: astore 4
    //   91: aload_3
    //   92: astore 5
    //   94: aload_0
    //   95: aload 6
    //   97: invokestatic 478	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   100: astore 7
    //   102: aload_3
    //   103: astore 4
    //   105: aload_3
    //   106: astore 5
    //   108: aload 7
    //   110: getfield 481	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   113: astore_1
    //   114: aload_1
    //   115: astore 4
    //   117: aload_1
    //   118: astore 5
    //   120: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +50 -> 173
    //   126: aload_1
    //   127: astore 4
    //   129: aload_1
    //   130: astore 5
    //   132: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   135: iconst_2
    //   136: new 44	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 483
    //   146: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 485
    //   156: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 7
    //   161: getfield 486	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   164: invokevirtual 489	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_1
    //   174: astore 4
    //   176: aload_1
    //   177: astore 5
    //   179: aload 7
    //   181: getfield 486	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   184: istore_2
    //   185: aload_1
    //   186: astore 4
    //   188: iload_2
    //   189: iconst_1
    //   190: if_icmpne +202 -> 392
    //   193: iconst_2
    //   194: istore_2
    //   195: aload_1
    //   196: astore 4
    //   198: iload_2
    //   199: iconst_4
    //   200: if_icmpgt +130 -> 330
    //   203: aload_1
    //   204: astore_3
    //   205: aload_1
    //   206: astore 4
    //   208: aload 6
    //   210: iload_2
    //   211: putfield 492	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   214: aload_1
    //   215: astore_3
    //   216: aload_1
    //   217: astore 4
    //   219: aload_0
    //   220: aload 6
    //   222: invokestatic 478	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   225: astore 5
    //   227: aload_1
    //   228: astore_3
    //   229: aload_1
    //   230: astore 4
    //   232: aload 5
    //   234: getfield 481	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   237: astore_1
    //   238: aload_1
    //   239: astore_3
    //   240: aload_1
    //   241: astore 4
    //   243: aload 5
    //   245: getfield 486	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   248: iconst_1
    //   249: if_icmpeq +151 -> 400
    //   252: aload_1
    //   253: astore_3
    //   254: aload_1
    //   255: astore 4
    //   257: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +18 -> 278
    //   263: aload_1
    //   264: astore_3
    //   265: aload_1
    //   266: astore 4
    //   268: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   271: iconst_2
    //   272: ldc_w 494
    //   275: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload_1
    //   279: astore_3
    //   280: new 324	java/util/HashMap
    //   283: dup
    //   284: invokespecial 325	java/util/HashMap:<init>	()V
    //   287: astore 4
    //   289: aload_1
    //   290: astore_3
    //   291: getstatic 339	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   294: invokevirtual 340	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   297: invokestatic 345	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   300: getstatic 339	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   303: invokevirtual 349	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   306: checkcast 175	com/tencent/mobileqq/app/QQAppInterface
    //   309: invokevirtual 352	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   312: ldc_w 496
    //   315: iconst_0
    //   316: lconst_1
    //   317: lconst_0
    //   318: aload 4
    //   320: ldc_w 262
    //   323: iconst_0
    //   324: invokevirtual 357	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   327: aload_1
    //   328: astore 4
    //   330: aload 4
    //   332: astore_3
    //   333: new 324	java/util/HashMap
    //   336: dup
    //   337: invokespecial 325	java/util/HashMap:<init>	()V
    //   340: astore_1
    //   341: aload 4
    //   343: astore_3
    //   344: aload_1
    //   345: ldc_w 327
    //   348: ldc 68
    //   350: invokevirtual 333	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   353: pop
    //   354: aload 4
    //   356: astore_3
    //   357: getstatic 339	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   360: invokevirtual 340	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   363: invokestatic 345	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   366: getstatic 339	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   369: invokevirtual 349	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   372: checkcast 175	com/tencent/mobileqq/app/QQAppInterface
    //   375: invokevirtual 352	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   378: ldc_w 498
    //   381: iconst_0
    //   382: lconst_1
    //   383: lconst_0
    //   384: aload_1
    //   385: ldc_w 262
    //   388: iconst_0
    //   389: invokevirtual 357	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   392: aload 4
    //   394: areturn
    //   395: aconst_null
    //   396: astore_3
    //   397: goto -352 -> 45
    //   400: iload_2
    //   401: iconst_2
    //   402: imul
    //   403: istore_2
    //   404: goto -209 -> 195
    //   407: astore_0
    //   408: aload 4
    //   410: areturn
    //   411: astore_1
    //   412: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +43 -> 458
    //   418: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   421: iconst_2
    //   422: new 44	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 483
    //   432: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_0
    //   436: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: ldc_w 500
    //   442: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_1
    //   446: invokevirtual 320	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   449: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: new 324	java/util/HashMap
    //   461: dup
    //   462: invokespecial 325	java/util/HashMap:<init>	()V
    //   465: astore_0
    //   466: aload_0
    //   467: ldc_w 327
    //   470: ldc_w 502
    //   473: invokevirtual 333	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: pop
    //   477: getstatic 339	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   480: invokevirtual 340	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   483: invokestatic 345	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   486: getstatic 339	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   489: invokevirtual 349	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   492: checkcast 175	com/tencent/mobileqq/app/QQAppInterface
    //   495: invokevirtual 352	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   498: ldc_w 498
    //   501: iconst_0
    //   502: lconst_1
    //   503: lconst_0
    //   504: aload_0
    //   505: ldc_w 262
    //   508: iconst_0
    //   509: invokevirtual 357	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   512: aload_3
    //   513: areturn
    //   514: astore_1
    //   515: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq +43 -> 561
    //   521: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   524: iconst_2
    //   525: new 44	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 483
    //   535: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_0
    //   539: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: ldc_w 504
    //   545: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload_1
    //   549: invokevirtual 360	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   552: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: new 324	java/util/HashMap
    //   564: dup
    //   565: invokespecial 325	java/util/HashMap:<init>	()V
    //   568: astore_0
    //   569: aload_0
    //   570: ldc_w 327
    //   573: ldc_w 502
    //   576: invokevirtual 333	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: pop
    //   580: getstatic 339	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   583: invokevirtual 340	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   586: invokestatic 345	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   589: getstatic 339	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   592: invokevirtual 349	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   595: checkcast 175	com/tencent/mobileqq/app/QQAppInterface
    //   598: invokevirtual 352	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   601: ldc_w 506
    //   604: iconst_0
    //   605: lconst_1
    //   606: lconst_0
    //   607: aload_0
    //   608: ldc_w 262
    //   611: iconst_0
    //   612: invokevirtual 357	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   615: aload 4
    //   617: areturn
    //   618: astore_0
    //   619: aload 4
    //   621: areturn
    //   622: astore_1
    //   623: goto -108 -> 515
    //   626: astore_0
    //   627: goto -115 -> 512
    //   630: astore_1
    //   631: aload 5
    //   633: astore_3
    //   634: goto -222 -> 412
    //   637: astore_3
    //   638: aload_1
    //   639: astore 4
    //   641: goto -311 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	paramString	String
    //   0	644	1	paramOptions	android.graphics.BitmapFactory.Options
    //   184	220	2	i1	int
    //   8	626	3	localObject1	Object
    //   637	1	3	localException	Exception
    //   11	629	4	localObject2	Object
    //   4	628	5	localObject3	Object
    //   1	220	6	localOptions	android.graphics.BitmapFactory.Options
    //   100	80	7	localBitmapDecodeResult	com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult
    // Exception table:
    //   from	to	target	type
    //   333	341	407	java/lang/Exception
    //   344	354	407	java/lang/Exception
    //   357	392	407	java/lang/Exception
    //   13	23	411	java/lang/OutOfMemoryError
    //   30	42	411	java/lang/OutOfMemoryError
    //   208	214	411	java/lang/OutOfMemoryError
    //   219	227	411	java/lang/OutOfMemoryError
    //   232	238	411	java/lang/OutOfMemoryError
    //   243	252	411	java/lang/OutOfMemoryError
    //   257	263	411	java/lang/OutOfMemoryError
    //   268	278	411	java/lang/OutOfMemoryError
    //   280	289	411	java/lang/OutOfMemoryError
    //   291	327	411	java/lang/OutOfMemoryError
    //   333	341	411	java/lang/OutOfMemoryError
    //   344	354	411	java/lang/OutOfMemoryError
    //   357	392	411	java/lang/OutOfMemoryError
    //   13	23	514	java/lang/Exception
    //   30	42	514	java/lang/Exception
    //   208	214	514	java/lang/Exception
    //   219	227	514	java/lang/Exception
    //   232	238	514	java/lang/Exception
    //   243	252	514	java/lang/Exception
    //   257	263	514	java/lang/Exception
    //   268	278	514	java/lang/Exception
    //   561	615	618	java/lang/Exception
    //   65	74	622	java/lang/Exception
    //   80	88	622	java/lang/Exception
    //   94	102	622	java/lang/Exception
    //   108	114	622	java/lang/Exception
    //   120	126	622	java/lang/Exception
    //   132	173	622	java/lang/Exception
    //   179	185	622	java/lang/Exception
    //   458	512	626	java/lang/Exception
    //   65	74	630	java/lang/OutOfMemoryError
    //   80	88	630	java/lang/OutOfMemoryError
    //   94	102	630	java/lang/OutOfMemoryError
    //   108	114	630	java/lang/OutOfMemoryError
    //   120	126	630	java/lang/OutOfMemoryError
    //   132	173	630	java/lang/OutOfMemoryError
    //   179	185	630	java/lang/OutOfMemoryError
    //   280	289	637	java/lang/Exception
    //   291	327	637	java/lang/Exception
  }
  
  public static String a(int paramInt)
  {
    String str = jdField_a_of_type_JavaLangString;
    switch (paramInt)
    {
    case 0: 
    default: 
      return str;
    case 1: 
      return AppConstants.aK + "pddata/vas/RedPacket/packets/";
    case 2: 
      return AppConstants.aK + "pddata/vas/RedPacket/specialFont/";
    case 3: 
      return AppConstants.aK + "pddata/vas/RedPacket/font/";
    case 4: 
      return str + "fontimgprecreate/";
    case 5: 
      return str + "personalfontimg/";
    case 6: 
      return str + "AIOfinalimg/";
    case 7: 
      return str + "TENPAYfinalimg/";
    }
    return str + "SENDfinalimg/";
  }
  
  public static String a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) && ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();; localObject = paramQQAppInterface)
    {
      if (localObject == null)
      {
        localObject = "";
        return localObject;
      }
      IndividualRedPacketManager localIndividualRedPacketManager;
      if (localObject == null)
      {
        localIndividualRedPacketManager = null;
        label43:
        if (localIndividualRedPacketManager == null) {
          break label343;
        }
        if (!localIndividualRedPacketManager.a()) {
          break label205;
        }
        paramQQAppInterface = "1";
      }
      label60:
      label205:
      label337:
      label340:
      label343:
      for (QQAppInterface localQQAppInterface = paramQQAppInterface;; localQQAppInterface = null)
      {
        paramQQAppInterface = IndividuationUrlHelper.a(((QQAppInterface)localObject).getApp().getApplicationContext(), "hongbao", "");
        if (1 == paramInt)
        {
          if (TextUtils.isEmpty(paramQQAppInterface)) {
            break label340;
          }
          paramQQAppInterface = paramQQAppInterface.replace("[from]", "1");
        }
        for (;;)
        {
          ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8006134", "0X8006134", 0, 0, localQQAppInterface, "1", "", "");
          localObject = paramQQAppInterface;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_d_of_type_JavaLangString, 2, "IndividualRedPacketManager.getMallURL=" + null + ", type:" + paramInt + ", url:" + paramQQAppInterface);
          return paramQQAppInterface;
          localIndividualRedPacketManager = (IndividualRedPacketManager)((QQAppInterface)localObject).getManager(130);
          break label43;
          paramQQAppInterface = "0";
          break label60;
          if (3 == paramInt) {
            if ((localIndividualRedPacketManager != null) && (localIndividualRedPacketManager.b()) && (localIndividualRedPacketManager.a().jdField_b_of_type_Boolean))
            {
              if (TextUtils.isEmpty(paramQQAppInterface)) {
                break label337;
              }
              paramQQAppInterface = paramQQAppInterface.replace("[from]", "3");
            }
          }
          for (;;)
          {
            ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8006136", "0X8006136", 0, 0, localQQAppInterface, "1", "", "");
            break;
            paramQQAppInterface = null;
            break;
            localObject = IndividuationUrlHelper.a(((QQAppInterface)localObject).getApp().getApplicationContext(), "hongbao", "");
            paramQQAppInterface = (QQAppInterface)localObject;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            paramQQAppInterface = ((String)localObject).replace("[from]", "2");
            break;
          }
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(jdField_d_of_type_JavaLangString, 1, "getIDFromSCID error null: zipName=" + paramString);
      localObject2 = localObject1;
    }
    do
    {
      return localObject2;
      localObject1 = localObject2;
      if (paramString.length() > "luckyMoney.item.".length())
      {
        localObject1 = localObject2;
        if (paramString.indexOf("luckyMoney.item.") >= 0) {
          localObject1 = paramString.substring("luckyMoney.item.".length());
        }
      }
      if (QLog.isColorLevel()) {
        break;
      }
      localObject2 = localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    QLog.d(jdField_d_of_type_JavaLangString, 2, "getIDFromSCID ok, scid = " + paramString + ", redPacketid=" + (String)localObject1);
    return localObject1;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    String str5 = "";
    String str3 = null;
    String str4 = null;
    String str2 = null;
    String str1 = str5;
    switch (paramInt1)
    {
    default: 
      str1 = str5;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "getLocalImgAddress Error templateId: " + paramString1 + ", name:" + paramString2 + ", type:" + paramInt1 + ", filename:" + str1);
      }
      return str1;
      str1 = a(3) + "font.ttf";
      continue;
      str1 = a(3) + "config.json";
      continue;
      str1 = str5;
      if (!TextUtils.isEmpty(paramString2))
      {
        str1 = a(5) + Integer.toHexString(paramString2.charAt(0));
        continue;
        str1 = str5;
        if (!TextUtils.isEmpty(paramString2))
        {
          str1 = a(4) + Integer.toHexString(paramString2.charAt(0));
          continue;
          str1 = a(0) + "specialzip";
          continue;
          str1 = a(2) + "specialCharItem.zip";
          continue;
          str1 = a(2) + "config.json";
          continue;
          str1 = str5;
          if (!TextUtils.isEmpty(paramString2))
          {
            str1 = a(2) + "images" + File.separator + "aio" + File.separator + Integer.toHexString(paramString2.charAt(0));
            continue;
            str1 = str5;
            if (!TextUtils.isEmpty(paramString2))
            {
              str1 = a(2) + "images" + File.separator + "tp" + File.separator + Integer.toHexString(paramString2.charAt(0));
              continue;
              str1 = str5;
              if (!TextUtils.isEmpty(paramString2))
              {
                str1 = a(2) + "images" + File.separator + "send" + File.separator + Integer.toHexString(paramString2.charAt(0));
                continue;
                str2 = "_s";
                if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int)
                {
                  str1 = a(1) + paramString1 + File.separator + "aioimg";
                }
                else
                {
                  str1 = str5;
                  if (!TextUtils.isEmpty(paramString2))
                  {
                    str1 = str5;
                    if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int)
                    {
                      str3 = a(6) + paramString1 + "_aio_" + Integer.toHexString(paramString2.charAt(0));
                      str1 = str3;
                      if (str2 != null)
                      {
                        str1 = str3 + str2;
                        continue;
                        str3 = "_s";
                        if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int)
                        {
                          str1 = a(1) + paramString1 + File.separator + "redenvelopeimg";
                        }
                        else
                        {
                          str1 = str5;
                          if (!TextUtils.isEmpty(paramString2))
                          {
                            str1 = str5;
                            if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int)
                            {
                              str2 = a(7) + paramString1 + "_tp_" + Integer.toHexString(paramString2.charAt(0));
                              str1 = str2;
                              if (str3 != null)
                              {
                                str1 = str2 + str3;
                                continue;
                                str4 = "_s";
                                if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int)
                                {
                                  str1 = a(1) + paramString1 + File.separator + "sendimg";
                                }
                                else
                                {
                                  str1 = str5;
                                  if (!TextUtils.isEmpty(paramString2))
                                  {
                                    str1 = str5;
                                    if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int)
                                    {
                                      str2 = a(8) + paramString1 + "_send_" + Integer.toHexString(paramString2.charAt(0));
                                      str1 = str2;
                                      if (str4 != null)
                                      {
                                        str1 = str2 + str4;
                                        continue;
                                        str1 = a(1) + paramString1;
                                        continue;
                                        str1 = a(1) + paramString1 + File.separator + "aioimg";
                                        continue;
                                        str1 = a(1) + paramString1 + File.separator + "redenvelopeimg";
                                        continue;
                                        str1 = a(1) + paramString1 + File.separator + "sendimg";
                                        continue;
                                        str1 = a(1) + paramString1 + File.separator + "aiopng.zip";
                                        continue;
                                        str1 = a(1) + paramString1 + File.separator + "config.json";
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public static void a(com.tencent.common.app.AppInterface arg0, IndividualRedPacketManager paramIndividualRedPacketManager, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore_0
    //   5: aconst_null
    //   6: astore 8
    //   8: ldc 2
    //   10: monitorenter
    //   11: aload_1
    //   12: ifnull +7 -> 19
    //   15: aload_2
    //   16: ifnonnull +7 -> 23
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: aload_2
    //   24: getfield 656	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:templateId	Ljava/lang/String;
    //   27: astore 10
    //   29: aload_2
    //   30: getfield 657	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: astore 11
    //   35: aload_1
    //   36: invokevirtual 233	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   39: astore 5
    //   41: aload 5
    //   43: aload 10
    //   45: iconst_1
    //   46: invokevirtual 238	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo;
    //   49: astore 12
    //   51: aload 12
    //   53: ifnull +27 -> 80
    //   56: aload 12
    //   58: getfield 243	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   61: ifnull +19 -> 80
    //   64: aload 12
    //   66: getfield 245	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   69: ifnull +11 -> 80
    //   72: aload 12
    //   74: getfield 247	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   77: ifnonnull +224 -> 301
    //   80: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +61 -> 144
    //   86: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   89: iconst_2
    //   90: new 44	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 659
    //   100: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload 10
    //   105: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc_w 661
    //   111: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 11
    //   116: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc_w 663
    //   122: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 5
    //   127: getfield 666	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   130: invokeinterface 671 1 0
    //   135: invokevirtual 489	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_1
    //   145: getfield 216	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   148: aload_2
    //   149: getfield 673	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   152: aload_2
    //   153: invokevirtual 676	java/util/concurrent/ConcurrentHashMap:putIfAbsent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: pop
    //   157: aload_1
    //   158: getfield 216	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   161: new 44	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   168: aload_2
    //   169: getfield 673	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   172: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc_w 678
    //   178: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: aload_2
    //   185: invokevirtual 676	java/util/concurrent/ConcurrentHashMap:putIfAbsent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: aload 5
    //   191: getfield 680	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:c	Ljava/util/Map;
    //   194: astore_0
    //   195: aload_0
    //   196: monitorenter
    //   197: aload 5
    //   199: getfield 680	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:c	Ljava/util/Map;
    //   202: aload 10
    //   204: invokeinterface 684 2 0
    //   209: ifne +59 -> 268
    //   212: new 686	java/util/ArrayList
    //   215: dup
    //   216: invokespecial 687	java/util/ArrayList:<init>	()V
    //   219: astore_1
    //   220: aload_1
    //   221: aload_2
    //   222: getfield 673	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   225: invokevirtual 690	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   228: pop
    //   229: aload 5
    //   231: getfield 680	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:c	Ljava/util/Map;
    //   234: aload 10
    //   236: aload_1
    //   237: invokeinterface 691 3 0
    //   242: pop
    //   243: aload_0
    //   244: monitorexit
    //   245: aload 5
    //   247: ldc2_w 692
    //   250: aload 10
    //   252: aload_2
    //   253: getfield 673	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   256: invokevirtual 696	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(JLjava/lang/String;Ljava/lang/String;)V
    //   259: goto -240 -> 19
    //   262: astore_0
    //   263: ldc 2
    //   265: monitorexit
    //   266: aload_0
    //   267: athrow
    //   268: aload 5
    //   270: getfield 680	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:c	Ljava/util/Map;
    //   273: aload 10
    //   275: invokeinterface 697 2 0
    //   280: checkcast 699	java/util/List
    //   283: aload_2
    //   284: getfield 673	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   287: invokeinterface 700 2 0
    //   292: pop
    //   293: goto -50 -> 243
    //   296: astore_1
    //   297: aload_0
    //   298: monitorexit
    //   299: aload_1
    //   300: athrow
    //   301: aload 11
    //   303: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   306: ifne +850 -> 1156
    //   309: aload 5
    //   311: getfield 703	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   314: invokevirtual 707	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:a	()Ljava/lang/String;
    //   317: aload 11
    //   319: invokevirtual 710	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   322: ifeq +834 -> 1156
    //   325: iconst_1
    //   326: istore_3
    //   327: aload 12
    //   329: getfield 264	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_Int	I
    //   332: getstatic 638	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_Int	I
    //   335: if_icmpne +424 -> 759
    //   338: iload_3
    //   339: ifeq +812 -> 1151
    //   342: aload_1
    //   343: aload 10
    //   345: aload 11
    //   347: bipush 12
    //   349: invokevirtual 713	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   352: astore_0
    //   353: aload_0
    //   354: astore 5
    //   356: aload_0
    //   357: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   360: ifeq +43 -> 403
    //   363: aload 11
    //   365: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   368: ifne +23 -> 391
    //   371: aload_0
    //   372: astore 5
    //   374: aload_1
    //   375: ldc_w 262
    //   378: aload 11
    //   380: bipush 9
    //   382: invokevirtual 713	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   385: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   388: ifeq +15 -> 403
    //   391: aload_1
    //   392: aload 10
    //   394: aload 11
    //   396: bipush 6
    //   398: invokevirtual 713	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   401: astore 5
    //   403: aload 5
    //   405: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   408: ifeq +659 -> 1067
    //   411: aload 12
    //   413: getfield 714	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_e_of_type_Int	I
    //   416: iconst_1
    //   417: if_icmpeq +634 -> 1051
    //   420: aload_1
    //   421: aload 11
    //   423: bipush 6
    //   425: invokevirtual 717	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap;
    //   428: astore_0
    //   429: aload_1
    //   430: aload_0
    //   431: aload_2
    //   432: bipush 6
    //   434: invokevirtual 720	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Lcom/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap;Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;I)Landroid/graphics/Bitmap;
    //   437: astore 6
    //   439: aload_0
    //   440: astore 7
    //   442: aload 12
    //   444: getfield 264	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_Int	I
    //   447: getstatic 638	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_Int	I
    //   450: if_icmpne +690 -> 1140
    //   453: iload_3
    //   454: ifeq +686 -> 1140
    //   457: aload_1
    //   458: aload 10
    //   460: aload 11
    //   462: bipush 13
    //   464: invokevirtual 713	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   467: astore_0
    //   468: aload_0
    //   469: astore 5
    //   471: aload_0
    //   472: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   475: ifeq +43 -> 518
    //   478: aload 11
    //   480: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: ifne +23 -> 506
    //   486: aload_0
    //   487: astore 5
    //   489: aload_1
    //   490: ldc_w 262
    //   493: aload 11
    //   495: bipush 10
    //   497: invokevirtual 713	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   500: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   503: ifeq +15 -> 518
    //   506: aload_1
    //   507: aload 10
    //   509: aload 11
    //   511: bipush 7
    //   513: invokevirtual 713	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   516: astore 5
    //   518: aload 5
    //   520: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   523: ifeq +30 -> 553
    //   526: aload 12
    //   528: getfield 714	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_e_of_type_Int	I
    //   531: iconst_1
    //   532: if_icmpeq +561 -> 1093
    //   535: aload_1
    //   536: aload 11
    //   538: bipush 7
    //   540: invokevirtual 717	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap;
    //   543: astore_0
    //   544: aload_1
    //   545: aload_0
    //   546: aload_2
    //   547: bipush 7
    //   549: invokevirtual 720	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Lcom/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap;Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;I)Landroid/graphics/Bitmap;
    //   552: pop
    //   553: aload 9
    //   555: astore_0
    //   556: aload 12
    //   558: getfield 264	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_Int	I
    //   561: getstatic 638	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_Int	I
    //   564: if_icmpne +73 -> 637
    //   567: aload 8
    //   569: astore 5
    //   571: iload_3
    //   572: ifeq +15 -> 587
    //   575: aload_1
    //   576: aload 10
    //   578: aload 11
    //   580: bipush 18
    //   582: invokevirtual 713	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   585: astore 5
    //   587: aload 5
    //   589: astore_0
    //   590: aload 5
    //   592: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   595: ifeq +42 -> 637
    //   598: aload 11
    //   600: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   603: ifne +23 -> 626
    //   606: aload 5
    //   608: astore_0
    //   609: aload_1
    //   610: ldc_w 262
    //   613: aload 11
    //   615: bipush 16
    //   617: invokevirtual 713	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   620: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   623: ifeq +14 -> 637
    //   626: aload_1
    //   627: aload 10
    //   629: aload 11
    //   631: bipush 15
    //   633: invokevirtual 713	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   636: astore_0
    //   637: aload_0
    //   638: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   641: ifeq +30 -> 671
    //   644: aload 12
    //   646: getfield 714	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_e_of_type_Int	I
    //   649: iconst_1
    //   650: if_icmpeq +459 -> 1109
    //   653: aload_1
    //   654: aload 11
    //   656: bipush 15
    //   658: invokevirtual 717	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap;
    //   661: astore_0
    //   662: aload_1
    //   663: aload_0
    //   664: aload_2
    //   665: bipush 15
    //   667: invokevirtual 720	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Lcom/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap;Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;I)Landroid/graphics/Bitmap;
    //   670: pop
    //   671: aload 7
    //   673: ifnull +42 -> 715
    //   676: aload 7
    //   678: getfield 299	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   681: ifnull +34 -> 715
    //   684: aload 7
    //   686: getfield 401	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_Boolean	Z
    //   689: ifne +26 -> 715
    //   692: aload 7
    //   694: getfield 722	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:c	Z
    //   697: ifne +18 -> 715
    //   700: aload_1
    //   701: aload 7
    //   703: getfield 299	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   706: ldc_w 262
    //   709: aload 11
    //   711: iconst_5
    //   712: invokevirtual 725	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)V
    //   715: aload 6
    //   717: ifnull -698 -> 19
    //   720: aload 7
    //   722: getfield 299	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   725: ifnonnull +11 -> 736
    //   728: aload 7
    //   730: getfield 722	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:c	Z
    //   733: ifeq -714 -> 19
    //   736: aload 7
    //   738: getfield 726	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_b_of_type_Boolean	Z
    //   741: ifeq +384 -> 1125
    //   744: aload_1
    //   745: aload 6
    //   747: aload 10
    //   749: aload 11
    //   751: bipush 12
    //   753: invokevirtual 725	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)V
    //   756: goto -737 -> 19
    //   759: aload 12
    //   761: getfield 243	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   764: astore 6
    //   766: aload 6
    //   768: ifnull +383 -> 1151
    //   771: aload 6
    //   773: getfield 729	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig	Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$AnimConfig;
    //   776: ifnull +375 -> 1151
    //   779: aload_2
    //   780: getfield 730	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig	Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$AnimConfig;
    //   783: ifnull +26 -> 809
    //   786: aload_2
    //   787: getfield 730	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig	Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$AnimConfig;
    //   790: getfield 733	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$AnimConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   793: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   796: ifne +13 -> 809
    //   799: invokestatic 738	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	()Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory;
    //   802: aload_2
    //   803: invokevirtual 741	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	(Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;)V
    //   806: goto -787 -> 19
    //   809: aload 6
    //   811: getfield 742	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   814: aconst_null
    //   815: aload 6
    //   817: getfield 743	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:f	I
    //   820: aload 6
    //   822: getfield 744	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_d_of_type_Int	I
    //   825: iconst_0
    //   826: invokestatic 267	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   829: astore 7
    //   831: aload 7
    //   833: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   836: ifne +13 -> 849
    //   839: new 623	java/io/File
    //   842: dup
    //   843: aload 7
    //   845: invokespecial 747	java/io/File:<init>	(Ljava/lang/String;)V
    //   848: astore_0
    //   849: aload_0
    //   850: ifnonnull +34 -> 884
    //   853: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   856: iconst_2
    //   857: new 44	java/lang/StringBuilder
    //   860: dup
    //   861: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   864: ldc_w 749
    //   867: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: aload 7
    //   872: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: goto -862 -> 19
    //   884: aload_0
    //   885: invokevirtual 752	java/io/File:exists	()Z
    //   888: ifeq +257 -> 1145
    //   891: aload_0
    //   892: invokevirtual 755	java/io/File:isFile	()Z
    //   895: ifeq +250 -> 1145
    //   898: aload 12
    //   900: aload_2
    //   901: aload 7
    //   903: iconst_0
    //   904: invokestatic 758	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo;Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;Ljava/lang/String;Z)Z
    //   907: istore 4
    //   909: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   912: ifne +8 -> 920
    //   915: iload 4
    //   917: ifne +244 -> 1161
    //   920: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   923: iconst_2
    //   924: new 44	java/lang/StringBuilder
    //   927: dup
    //   928: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   931: ldc_w 760
    //   934: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: iload 4
    //   939: invokevirtual 763	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   942: ldc_w 765
    //   945: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: aload 7
    //   950: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   959: goto +202 -> 1161
    //   962: aload_1
    //   963: getfield 216	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   966: aload_2
    //   967: getfield 673	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   970: aload_2
    //   971: invokevirtual 676	java/util/concurrent/ConcurrentHashMap:putIfAbsent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   974: pop
    //   975: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   978: ifeq +56 -> 1034
    //   981: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   984: iconst_2
    //   985: new 44	java/lang/StringBuilder
    //   988: dup
    //   989: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   992: ldc_w 767
    //   995: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: aload 10
    //   1000: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: ldc_w 769
    //   1006: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: iload 4
    //   1011: invokevirtual 763	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1014: ldc_w 771
    //   1017: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: aload 6
    //   1022: getfield 772	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1025: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1031: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1034: aload 5
    //   1036: ldc2_w 692
    //   1039: aload 10
    //   1041: aload_2
    //   1042: getfield 673	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1045: invokevirtual 696	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(JLjava/lang/String;Ljava/lang/String;)V
    //   1048: goto -1029 -> 19
    //   1051: new 296	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap
    //   1054: dup
    //   1055: invokespecial 773	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:<init>	()V
    //   1058: astore_0
    //   1059: aload_0
    //   1060: iconst_1
    //   1061: putfield 722	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:c	Z
    //   1064: goto -635 -> 429
    //   1067: aload_2
    //   1068: aload 5
    //   1070: aconst_null
    //   1071: invokestatic 294	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1074: putfield 774	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1077: invokestatic 738	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	()Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory;
    //   1080: aload_2
    //   1081: invokevirtual 741	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	(Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;)V
    //   1084: aconst_null
    //   1085: astore 6
    //   1087: aconst_null
    //   1088: astore 7
    //   1090: goto -648 -> 442
    //   1093: new 296	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap
    //   1096: dup
    //   1097: invokespecial 773	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:<init>	()V
    //   1100: astore_0
    //   1101: aload_0
    //   1102: iconst_1
    //   1103: putfield 722	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:c	Z
    //   1106: goto -562 -> 544
    //   1109: new 296	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap
    //   1112: dup
    //   1113: invokespecial 773	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:<init>	()V
    //   1116: astore_0
    //   1117: aload_0
    //   1118: iconst_1
    //   1119: putfield 722	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:c	Z
    //   1122: goto -460 -> 662
    //   1125: aload_1
    //   1126: aload 6
    //   1128: aload 10
    //   1130: aload 11
    //   1132: bipush 6
    //   1134: invokevirtual 725	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)V
    //   1137: goto -1118 -> 19
    //   1140: aconst_null
    //   1141: astore_0
    //   1142: goto -674 -> 468
    //   1145: iconst_0
    //   1146: istore 4
    //   1148: goto -186 -> 962
    //   1151: aconst_null
    //   1152: astore_0
    //   1153: goto -800 -> 353
    //   1156: iconst_0
    //   1157: istore_3
    //   1158: goto -831 -> 327
    //   1161: iload 4
    //   1163: ifne -1144 -> 19
    //   1166: iconst_1
    //   1167: istore 4
    //   1169: goto -207 -> 962
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1172	1	paramIndividualRedPacketManager	IndividualRedPacketManager
    //   0	1172	2	paramRedPacketInfo	CustomizeStrategyFactory.RedPacketInfo
    //   326	832	3	i1	int
    //   907	261	4	bool	boolean
    //   39	1030	5	localObject1	Object
    //   437	690	6	localObject2	Object
    //   440	649	7	localObject3	Object
    //   6	562	8	localObject4	Object
    //   1	553	9	localObject5	Object
    //   27	1102	10	str1	String
    //   33	1098	11	str2	String
    //   49	850	12	localRedPacketTemplateInfo	IndividualRedPacketResDownloader.RedPacketTemplateInfo
    // Exception table:
    //   from	to	target	type
    //   23	51	262	finally
    //   56	80	262	finally
    //   80	144	262	finally
    //   144	197	262	finally
    //   245	259	262	finally
    //   299	301	262	finally
    //   301	325	262	finally
    //   327	338	262	finally
    //   342	353	262	finally
    //   356	371	262	finally
    //   374	391	262	finally
    //   391	403	262	finally
    //   403	429	262	finally
    //   429	439	262	finally
    //   442	453	262	finally
    //   457	468	262	finally
    //   471	486	262	finally
    //   489	506	262	finally
    //   506	518	262	finally
    //   518	544	262	finally
    //   544	553	262	finally
    //   556	567	262	finally
    //   575	587	262	finally
    //   590	606	262	finally
    //   609	626	262	finally
    //   626	637	262	finally
    //   637	662	262	finally
    //   662	671	262	finally
    //   676	715	262	finally
    //   720	736	262	finally
    //   736	756	262	finally
    //   759	766	262	finally
    //   771	806	262	finally
    //   809	831	262	finally
    //   831	849	262	finally
    //   853	881	262	finally
    //   884	915	262	finally
    //   920	959	262	finally
    //   962	1034	262	finally
    //   1034	1048	262	finally
    //   1051	1064	262	finally
    //   1067	1084	262	finally
    //   1093	1106	262	finally
    //   1109	1122	262	finally
    //   1125	1137	262	finally
    //   197	243	296	finally
    //   243	245	296	finally
    //   268	293	296	finally
    //   297	299	296	finally
  }
  
  static boolean a(IndividualRedPacketResDownloader.RedPacketTemplateInfo paramRedPacketTemplateInfo, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, String paramString, boolean paramBoolean)
  {
    if ((paramRedPacketTemplateInfo == null) || (paramRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null) || (paramRedPacketInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e(jdField_d_of_type_JavaLangString, 2, "getAnimatePath Exception 0.zipPath=" + paramString);
      paramBoolean = false;
      return paramBoolean;
    }
    IndividualRedPacketResDownloader.DecorateInfo localDecorateInfo = paramRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
    for (;;)
    {
      Object localObject1;
      String[] arrayOfString;
      boolean bool1;
      int i1;
      String str;
      try
      {
        localObject1 = paramString + "_dir2";
        File localFile = new File((String)localObject1);
        if ((!localFile.exists()) || (!localFile.isDirectory())) {
          break label744;
        }
        arrayOfString = localFile.list();
        if (arrayOfString.length <= 0) {
          break label735;
        }
        bool1 = true;
        i1 = 0;
        if (i1 >= arrayOfString.length) {
          break label729;
        }
        str = localFile.getAbsolutePath() + File.separator + arrayOfString[i1];
        Object localObject2 = new File(str);
        if (!((File)localObject2).exists()) {
          break label756;
        }
        if (!((File)localObject2).isDirectory()) {
          break label590;
        }
        localObject2 = ((File)localObject2).list();
        if (localObject2.length <= 0) {
          break label526;
        }
        i1 = localObject2.length;
        localObject1 = str;
        if ((QLog.isColorLevel()) || (i1 == 0)) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getAnimatePath picNum Err id:" + paramRedPacketInfo.templateId + ", fileNames=" + arrayOfString + ", unZipDir=" + (String)localObject1 + ", picNum=" + i1 + ", size=" + localDecorateInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig.jdField_a_of_type_Int);
        }
        if ((!paramBoolean) || ((i1 == localDecorateInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig.jdField_a_of_type_Int) && (i1 != 0))) {
          break label753;
        }
        VasMonitorHandler.a(null, "individual_v2_redpacket_json_err", "animConfig_size_err", "animConfig_size_err, id=" + paramRedPacketInfo.templateId, null, 0.0F);
      }
      catch (Exception paramRedPacketTemplateInfo)
      {
        QLog.e(jdField_d_of_type_JavaLangString, 2, "getAnimatePath Exception id:" + paramRedPacketInfo.templateId + ", name=" + localDecorateInfo.jdField_c_of_type_JavaLangString);
        return false;
      }
      boolean bool2 = bool1;
      if (!paramBoolean)
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool1 = IndividualRedPacketResDownloader.a(paramString, (String)localObject1);
          bool2 = bool1;
          if (bool1)
          {
            bool1 = a(paramRedPacketTemplateInfo, paramRedPacketInfo, paramString, true);
            paramBoolean = bool1;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_d_of_type_JavaLangString, 2, "set animConfig id:" + paramRedPacketInfo.templateId + ", name=" + localDecorateInfo.jdField_c_of_type_JavaLangString + " isRegetOk=" + bool1);
            return bool1;
            label526:
            if (!QLog.isColorLevel()) {
              break label756;
            }
            QLog.d(jdField_d_of_type_JavaLangString, 2, "getAnimatePath Err_path id:" + paramRedPacketInfo.templateId + ", path=" + str + ", name=" + localDecorateInfo.jdField_c_of_type_JavaLangString);
            break label756;
            label590:
            i1 = arrayOfString.length;
            continue;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "set animConfig end name=" + localDecorateInfo.jdField_c_of_type_JavaLangString + ", id=" + paramRedPacketInfo.templateId + ", picNum=" + i1 + ", fileExist=" + bool2 + ", isUnZipBack=" + paramBoolean + ", unZipDir = " + (String)localObject1);
      }
      if (bool2)
      {
        localDecorateInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig.jdField_a_of_type_JavaLangString = ((String)localObject1);
        paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig = localDecorateInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig;
        paramRedPacketInfo.jdField_b_of_type_Boolean = true;
        CustomizeStrategyFactory.a().a(paramRedPacketInfo);
        return true;
        label729:
        i1 = 0;
        continue;
        label735:
        i1 = 0;
        bool1 = false;
        continue;
        label744:
        bool1 = false;
        i1 = 0;
        continue;
        label753:
        continue;
        label756:
        i1 += 1;
      }
    }
  }
  
  public SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences("individRedPacket_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  public Bitmap a(IndividualRedPacketManager.FontBitmap paramFontBitmap, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, int paramInt)
  {
    String str1;
    String str2;
    if (paramInt == 6)
    {
      str1 = "0X800612F";
      str2 = paramRedPacketInfo.jdField_a_of_type_JavaLangString;
    }
    String str3;
    long l1;
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo;
    for (;;)
    {
      str3 = "0";
      if (a()) {
        str3 = "1";
      }
      l1 = System.currentTimeMillis();
      localRedPacketTemplateInfo = a().a(paramRedPacketInfo.templateId, true);
      if (localRedPacketTemplateInfo != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg init json fail");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
      paramFontBitmap = null;
      return paramFontBitmap;
      if (paramInt == 7)
      {
        str1 = "0X800613F";
        str2 = "";
      }
      else
      {
        str1 = "0X800613F";
        str2 = "";
      }
    }
    Object localObject;
    if (6 == paramInt) {
      localObject = localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
    }
    while (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg decorateInfo = null");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
      return null;
      if (7 == paramInt) {
        localObject = localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
      } else {
        localObject = localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
      }
    }
    if (!IndividualRedPacketResDownloader.a((IndividualRedPacketResDownloader.RedPacketResInfo)localObject))
    {
      if (((IndividualRedPacketResDownloader.DecorateInfo)localObject).f == 2) {
        paramFontBitmap = paramRedPacketInfo.jdField_b_of_type_JavaLangString;
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(paramFontBitmap, paramRedPacketInfo);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg id = " + paramRedPacketInfo.templateId + " content = " + paramRedPacketInfo.jdField_a_of_type_JavaLangString + " not exists!");
        }
        a().a(16L, ((IndividualRedPacketResDownloader.DecorateInfo)localObject).jdField_d_of_type_JavaLangString, paramRedPacketInfo.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg BG not found,start download url : " + ((IndividualRedPacketResDownloader.DecorateInfo)localObject).f + ", id=" + ((IndividualRedPacketResDownloader.DecorateInfo)localObject).jdField_d_of_type_JavaLangString);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
        return null;
        if (((IndividualRedPacketResDownloader.DecorateInfo)localObject).f == 3) {
          paramFontBitmap = paramRedPacketInfo.jdField_b_of_type_JavaLangString + "_tp";
        } else {
          paramFontBitmap = paramRedPacketInfo.jdField_b_of_type_JavaLangString + "_send";
        }
      }
    }
    label513:
    long l2;
    if (localRedPacketTemplateInfo.jdField_a_of_type_Int == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int)
    {
      localObject = a(paramFontBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, paramInt);
      l2 = System.currentTimeMillis();
      if (localObject == null) {
        break label724;
      }
      if (paramInt != 6) {
        break label622;
      }
      paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
      label535:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "1", String.valueOf(l2 - l1), str2);
    }
    for (;;)
    {
      paramFontBitmap = (IndividualRedPacketManager.FontBitmap)localObject;
      if (paramInt != 6) {
        break;
      }
      CustomizeStrategyFactory.a().a(paramRedPacketInfo);
      return localObject;
      localObject = a(a(paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, paramInt, localRedPacketTemplateInfo.jdField_d_of_type_Int, localRedPacketTemplateInfo.jdField_a_of_type_Int), null);
      break label513;
      label622:
      if (paramInt == 7)
      {
        if (paramFontBitmap.jdField_b_of_type_Boolean)
        {
          a((Bitmap)localObject, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 13);
          break label535;
        }
        a((Bitmap)localObject, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 7);
        break label535;
      }
      if (paramInt != 15) {
        break label535;
      }
      if (paramFontBitmap.jdField_b_of_type_Boolean)
      {
        a((Bitmap)localObject, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 18);
        break label535;
      }
      a((Bitmap)localObject, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 15);
      break label535;
      label724:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg BG combine == null, templateinfo.type = " + localRedPacketTemplateInfo.jdField_a_of_type_Int);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", String.valueOf(l2 - l1), str2);
    }
  }
  
  /* Error */
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 160	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   12: astore 11
    //   14: aload 11
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 168	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   21: invokevirtual 889	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   24: ifne +118 -> 142
    //   27: aload_0
    //   28: getfield 168	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   31: iconst_1
    //   32: invokevirtual 166	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   35: invokestatic 860	java/lang/System:currentTimeMillis	()J
    //   38: lstore_3
    //   39: aload_0
    //   40: getfield 160	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   43: iconst_1
    //   44: ldc_w 890
    //   47: invokevirtual 894	com/etrump/mixlayout/ETEngine:initEngine	(II)Z
    //   50: ifeq +161 -> 211
    //   53: aload_0
    //   54: invokevirtual 233	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   57: getfield 897	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   60: invokestatic 869	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   63: ifeq +24 -> 87
    //   66: aload_0
    //   67: getfield 160	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   70: aconst_null
    //   71: aconst_null
    //   72: bipush 8
    //   74: iconst_0
    //   75: iconst_0
    //   76: invokestatic 267	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   79: getstatic 66	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_Int	I
    //   82: iconst_1
    //   83: invokevirtual 901	com/etrump/mixlayout/ETEngine:native_loadFont	(Ljava/lang/String;IZ)Z
    //   86: pop
    //   87: aload_0
    //   88: getfield 163	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   91: iconst_1
    //   92: invokevirtual 166	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   95: invokestatic 860	java/lang/System:currentTimeMillis	()J
    //   98: lstore 5
    //   100: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +39 -> 142
    //   106: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   109: iconst_2
    //   110: new 44	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 903
    //   120: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: lload 5
    //   125: lload_3
    //   126: lsub
    //   127: invokevirtual 906	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: ldc_w 908
    //   133: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_0
    //   143: getfield 163	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   146: invokevirtual 889	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   149: ifeq +10 -> 159
    //   152: aload_1
    //   153: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifeq +150 -> 306
    //   159: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   162: iconst_1
    //   163: new 44	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 910
    //   173: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 163	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   180: invokevirtual 889	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   183: invokevirtual 763	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: ldc_w 912
    //   189: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_1
    //   193: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload 11
    //   204: monitorexit
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_1
    //   210: areturn
    //   211: aload_0
    //   212: getfield 160	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   215: getfield 915	com/etrump/mixlayout/ETEngine:isEngineInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   218: iconst_0
    //   219: iconst_1
    //   220: invokevirtual 919	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   223: ifeq +7 -> 230
    //   226: invokestatic 923	com/etrump/mixlayout/FontSoLoader:c	()Z
    //   229: pop
    //   230: aload_0
    //   231: getfield 163	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   234: iconst_0
    //   235: invokevirtual 166	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   238: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   241: iconst_1
    //   242: ldc_w 925
    //   245: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: goto -106 -> 142
    //   251: astore 7
    //   253: aload_0
    //   254: getfield 163	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   257: iconst_0
    //   258: invokevirtual 166	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   261: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   264: iconst_1
    //   265: new 44	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 927
    //   275: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 7
    //   280: invokevirtual 928	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   283: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: goto -150 -> 142
    //   295: astore_1
    //   296: aload 11
    //   298: monitorexit
    //   299: aload_1
    //   300: athrow
    //   301: astore_1
    //   302: aload_0
    //   303: monitorexit
    //   304: aload_1
    //   305: athrow
    //   306: aload_0
    //   307: invokevirtual 233	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   310: getfield 897	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   313: invokestatic 869	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   316: ifne +21 -> 337
    //   319: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   322: iconst_1
    //   323: ldc_w 930
    //   326: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload 11
    //   331: monitorexit
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -127 -> 207
    //   337: aload_0
    //   338: getfield 932	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   341: ifnonnull +32 -> 373
    //   344: aload_0
    //   345: new 934	com/etrump/mixlayout/ETFont
    //   348: dup
    //   349: getstatic 66	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_Int	I
    //   352: aconst_null
    //   353: ldc_w 262
    //   356: bipush 8
    //   358: iconst_0
    //   359: iconst_0
    //   360: invokestatic 267	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   363: aload_0
    //   364: getfield 79	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_Float	F
    //   367: invokespecial 937	com/etrump/mixlayout/ETFont:<init>	(ILjava/lang/String;F)V
    //   370: putfield 932	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   373: aload_0
    //   374: getfield 932	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   377: ldc_w 939
    //   380: invokestatic 422	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   383: invokevirtual 940	com/etrump/mixlayout/ETFont:setColor	(I)V
    //   386: iload_2
    //   387: ifeq +41 -> 428
    //   390: ldc_w 262
    //   393: aload_1
    //   394: iconst_4
    //   395: iconst_0
    //   396: iconst_0
    //   397: invokestatic 267	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   400: astore 7
    //   402: aload 7
    //   404: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   407: ifeq +36 -> 443
    //   410: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   413: iconst_1
    //   414: ldc_w 942
    //   417: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload 11
    //   422: monitorexit
    //   423: aconst_null
    //   424: astore_1
    //   425: goto -218 -> 207
    //   428: ldc_w 262
    //   431: aload_1
    //   432: iconst_5
    //   433: iconst_0
    //   434: iconst_0
    //   435: invokestatic 267	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   438: astore 7
    //   440: goto -38 -> 402
    //   443: new 623	java/io/File
    //   446: dup
    //   447: aload 7
    //   449: invokespecial 747	java/io/File:<init>	(Ljava/lang/String;)V
    //   452: astore 7
    //   454: aload_0
    //   455: getfield 79	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_Float	F
    //   458: f2i
    //   459: aload_0
    //   460: getfield 79	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_Float	F
    //   463: f2i
    //   464: getstatic 309	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   467: invokestatic 315	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   470: astore 8
    //   472: aload_0
    //   473: getfield 160	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   476: aload_1
    //   477: iconst_0
    //   478: invokevirtual 610	java/lang/String:charAt	(I)C
    //   481: aload_0
    //   482: getfield 932	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   485: invokevirtual 946	com/etrump/mixlayout/ETEngine:native_isPaintableChar	(CLcom/etrump/mixlayout/ETFont;)Z
    //   488: ifeq +22 -> 510
    //   491: aload_0
    //   492: getfield 160	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   495: aload_1
    //   496: aload 8
    //   498: iconst_0
    //   499: iconst_0
    //   500: aload_0
    //   501: getfield 932	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   504: invokevirtual 950	com/etrump/mixlayout/ETEngine:native_drawText	(Ljava/lang/String;Landroid/graphics/Bitmap;IILcom/etrump/mixlayout/ETFont;)Z
    //   507: ifne +135 -> 642
    //   510: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   513: iconst_1
    //   514: new 44	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 952
    //   524: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload_1
    //   528: iconst_0
    //   529: invokevirtual 610	java/lang/String:charAt	(I)C
    //   532: invokevirtual 955	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   535: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: aload 11
    //   543: monitorexit
    //   544: aconst_null
    //   545: astore_1
    //   546: goto -339 -> 207
    //   549: astore_1
    //   550: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   553: iconst_1
    //   554: new 44	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 957
    //   564: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload_1
    //   568: invokevirtual 320	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   571: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: new 324	java/util/HashMap
    //   583: dup
    //   584: invokespecial 325	java/util/HashMap:<init>	()V
    //   587: astore_1
    //   588: aload_1
    //   589: ldc_w 327
    //   592: ldc_w 959
    //   595: invokevirtual 333	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   598: pop
    //   599: getstatic 339	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   602: invokevirtual 340	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   605: invokestatic 345	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   608: getstatic 339	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   611: invokevirtual 349	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   614: checkcast 175	com/tencent/mobileqq/app/QQAppInterface
    //   617: invokevirtual 352	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   620: ldc_w 354
    //   623: iconst_0
    //   624: lconst_1
    //   625: lconst_0
    //   626: aload_1
    //   627: ldc_w 262
    //   630: iconst_0
    //   631: invokevirtual 357	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   634: aload 11
    //   636: monitorexit
    //   637: aconst_null
    //   638: astore_1
    //   639: goto -432 -> 207
    //   642: iload_2
    //   643: ifeq +57 -> 700
    //   646: aload 8
    //   648: ifnull +52 -> 700
    //   651: aload 10
    //   653: astore_1
    //   654: new 961	java/io/BufferedOutputStream
    //   657: dup
    //   658: new 963	java/io/FileOutputStream
    //   661: dup
    //   662: aload 7
    //   664: invokespecial 966	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   667: invokespecial 969	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   670: astore 7
    //   672: aload 8
    //   674: getstatic 975	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   677: bipush 90
    //   679: aload 7
    //   681: invokevirtual 979	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   684: pop
    //   685: aload 7
    //   687: invokevirtual 982	java/io/BufferedOutputStream:flush	()V
    //   690: aload 7
    //   692: ifnull +8 -> 700
    //   695: aload 7
    //   697: invokevirtual 985	java/io/BufferedOutputStream:close	()V
    //   700: aload 11
    //   702: monitorexit
    //   703: aload 8
    //   705: astore_1
    //   706: goto -499 -> 207
    //   709: astore_1
    //   710: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   713: iconst_1
    //   714: ldc_w 987
    //   717: aload_1
    //   718: invokestatic 990	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   721: goto -21 -> 700
    //   724: astore_1
    //   725: aload 9
    //   727: astore 7
    //   729: aload_1
    //   730: astore 9
    //   732: aload 7
    //   734: astore_1
    //   735: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   738: ifeq +37 -> 775
    //   741: aload 7
    //   743: astore_1
    //   744: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   747: iconst_2
    //   748: new 44	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   755: ldc_w 992
    //   758: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: aload 9
    //   763: invokevirtual 360	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   766: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: aload 7
    //   777: ifnull -77 -> 700
    //   780: aload 7
    //   782: invokevirtual 985	java/io/BufferedOutputStream:close	()V
    //   785: goto -85 -> 700
    //   788: astore_1
    //   789: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   792: iconst_1
    //   793: ldc_w 987
    //   796: aload_1
    //   797: invokestatic 990	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   800: goto -100 -> 700
    //   803: astore 8
    //   805: aload_1
    //   806: astore 7
    //   808: aload 8
    //   810: astore_1
    //   811: aload 7
    //   813: ifnull +8 -> 821
    //   816: aload 7
    //   818: invokevirtual 985	java/io/BufferedOutputStream:close	()V
    //   821: aload_1
    //   822: athrow
    //   823: astore 7
    //   825: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   828: iconst_1
    //   829: ldc_w 987
    //   832: aload 7
    //   834: invokestatic 990	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   837: goto -16 -> 821
    //   840: astore_1
    //   841: goto -30 -> 811
    //   844: astore 9
    //   846: goto -114 -> 732
    //   849: astore_1
    //   850: goto -216 -> 634
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	853	0	this	IndividualRedPacketManager
    //   0	853	1	paramString	String
    //   0	853	2	paramBoolean	boolean
    //   38	88	3	l1	long
    //   98	26	5	l2	long
    //   251	28	7	localThrowable	java.lang.Throwable
    //   400	417	7	localObject1	Object
    //   823	10	7	localException1	Exception
    //   470	234	8	localBitmap	Bitmap
    //   803	6	8	localObject2	Object
    //   4	758	9	str	String
    //   844	1	9	localException2	Exception
    //   1	651	10	localObject3	Object
    //   12	689	11	localETEngine	ETEngine
    // Exception table:
    //   from	to	target	type
    //   39	87	251	java/lang/Throwable
    //   87	142	251	java/lang/Throwable
    //   211	230	251	java/lang/Throwable
    //   230	248	251	java/lang/Throwable
    //   17	39	295	finally
    //   39	87	295	finally
    //   87	142	295	finally
    //   142	159	295	finally
    //   159	205	295	finally
    //   211	230	295	finally
    //   230	248	295	finally
    //   253	292	295	finally
    //   296	299	295	finally
    //   306	332	295	finally
    //   337	373	295	finally
    //   373	386	295	finally
    //   390	402	295	finally
    //   402	423	295	finally
    //   428	440	295	finally
    //   443	454	295	finally
    //   454	472	295	finally
    //   472	510	295	finally
    //   510	544	295	finally
    //   550	580	295	finally
    //   580	634	295	finally
    //   634	637	295	finally
    //   695	700	295	finally
    //   700	703	295	finally
    //   710	721	295	finally
    //   780	785	295	finally
    //   789	800	295	finally
    //   816	821	295	finally
    //   821	823	295	finally
    //   825	837	295	finally
    //   8	17	301	finally
    //   299	301	301	finally
    //   454	472	549	java/lang/OutOfMemoryError
    //   695	700	709	java/lang/Exception
    //   654	672	724	java/lang/Exception
    //   780	785	788	java/lang/Exception
    //   654	672	803	finally
    //   735	741	803	finally
    //   744	775	803	finally
    //   816	821	823	java/lang/Exception
    //   672	690	840	finally
    //   672	690	844	java/lang/Exception
    //   580	634	849	java/lang/Exception
  }
  
  public IndividualRedPacketManager.FontBitmap a(String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    IndividualRedPacketManager.FontBitmap localFontBitmap = new IndividualRedPacketManager.FontBitmap();
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString)) && (a().jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.a().contains(paramString)))
    {
      localFontBitmap.jdField_a_of_type_Boolean = true;
      if ((TextUtils.isEmpty(a().jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_b_of_type_JavaLangString)) || (!a().jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_b_of_type_JavaLangString.contains(paramString))) {
        break label499;
      }
      int i1 = 16;
      if (6 == paramInt) {
        i1 = 9;
      }
      for (;;)
      {
        localObject1 = a(null, paramString, i1, 0, 0);
        a("", paramString, i1);
        if (!new File((String)localObject1).exists()) {
          break;
        }
        localFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap = a((String)localObject1, null);
        localFontBitmap.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg success! Special char = " + paramString);
        }
        return localFontBitmap;
        if (7 == paramInt) {
          i1 = 10;
        }
      }
      if (!TextUtils.isEmpty(b().getString("special_unzip_version_key", ""))) {
        b().edit().putString("special_unzip_version_key", "").commit();
      }
    }
    Object localObject4 = a("", paramString, 4, 0, 0);
    for (Object localObject3 = new File((String)localObject4);; localObject3 = localObject4)
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
        {
          for (;;)
          {
            if (((File)localObject3).exists())
            {
              localObject1 = localObject4;
              if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(localObject4)) {}
            }
            else
            {
              String str = a("", paramString, 5, 0, 0);
              localObject4 = new File(str);
              if (!((File)localObject4).exists()) {
                break label863;
              }
              localObject3 = localObject4;
              localObject1 = str;
              if (this.jdField_a_of_type_JavaUtilLinkedList.contains(str)) {
                break label863;
              }
            }
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label801;
            }
            ((File)localObject3).setLastModified(System.currentTimeMillis());
            localFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap = a((String)localObject1, null);
            l2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg from file success time-consuming = " + (l2 - l1) + "ms");
            }
            localFontBitmap.jdField_b_of_type_Boolean = false;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg fontImage = " + localFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap + "Special Char = " + localFontBitmap.jdField_a_of_type_Boolean + "Special image = " + localFontBitmap.jdField_b_of_type_Boolean);
            }
            return localFontBitmap;
            label499:
            if ((!TextUtils.isEmpty("")) || (!"".contains(paramString))) {
              break;
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getResources().getAssets();
            if (6 == paramInt) {}
            try
            {
              localObject1 = ((AssetManager)localObject1).open("specialFont/aio/" + Integer.toHexString(paramString.charAt(0)));
              for (;;)
              {
                localFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeStream((InputStream)localObject1);
                localFontBitmap.jdField_b_of_type_Boolean = true;
                ((InputStream)localObject1).close();
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg success! Special char = " + paramString);
                break;
                if (7 == paramInt) {
                  localObject1 = ((AssetManager)localObject1).open("specialFont/tp/" + Integer.toHexString(paramString.charAt(0)));
                } else {
                  localObject1 = ((AssetManager)localObject1).open("specialFont/send/" + Integer.toHexString(paramString.charAt(0)));
                }
              }
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg assets oom:" + localOutOfMemoryError.getMessage());
            }
            catch (IOException localIOException)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d(jdField_d_of_type_JavaLangString, 2, localIOException.getMessage());
            }
            catch (Exception localException) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_d_of_type_JavaLangString, 2, localException.getMessage());
        }
        label801:
        localFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap = a(paramString, false);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg create success time-consuming = " + (l2 - l1) + "ms");
        }
      }
      label863:
      Object localObject2 = null;
    }
    return localFontBitmap;
  }
  
  public IndividualRedPacketResDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader = new IndividualRedPacketResDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader;
  }
  
  public String a()
  {
    String str2 = String.valueOf(this.j);
    String str3 = this.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_d_of_type_JavaLangString, 2, "getSendCombineImg: templateId = " + str2 + ";name = " + str3);
    }
    if (c())
    {
      String str1 = a(str2, str3, 15);
      if (!TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getSendCombineImg templateId = " + str2 + "; name = " + str3 + "; combinefilename = " + str1);
        }
        localObject2 = str1;
        return localObject2;
      }
      Object localObject1 = a().a(str2, true);
      if ((localObject1 == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null))
      {
        QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg info = null ; templateId = " + str2 + "; name = " + str3);
        a().a(16L, str2, null);
        return null;
      }
      Object localObject2 = a(str2, "", 14, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_d_of_type_Int, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_Int);
      Object localObject3 = new File((String)localObject2);
      if (!((File)localObject3).exists())
      {
        Object localObject4 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
        if (localObject4 == null)
        {
          QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg filenot exists senddecorate = null; templateId = " + str2 + ";name = " + str3);
          return null;
        }
        localObject4 = ((IndividualRedPacketResDownloader.DecorateInfo)localObject4).e;
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg filenot exists url is empty; templateId = " + str2 + ";name = " + str3);
          return null;
        }
        int i1 = DownloaderFactory.a(new DownloadTask((String)localObject4, (File)localObject3), null);
        if (i1 != 0)
        {
          QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg filenot exists download bg faile; templateId = " + str2 + ";name = " + str3 + "; downloadresult = " + i1);
          return null;
        }
      }
      if (!((File)localObject3).exists())
      {
        QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg filenot exists file not exists 2222; templateId = " + str2 + ";name = " + str3);
        return null;
      }
      if ((((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_Int == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int) || (TextUtils.isEmpty(str3)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getSendCombineImg1 templateId = " + str2 + "; name = " + str3 + "; combinefilename = " + str1);
        }
        return localObject2;
      }
      localObject2 = a(str3, 15);
      if (localObject2 == null)
      {
        QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg fontImg = null ; templateId = " + str2 + "; name = " + str3);
        return null;
      }
      if (((IndividualRedPacketManager.FontBitmap)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getSendCombineImg savefontimg");
        }
        a(((IndividualRedPacketManager.FontBitmap)localObject2).jdField_a_of_type_AndroidGraphicsBitmap, str2, str3, 4);
      }
      localObject3 = a((IndividualRedPacketManager.FontBitmap)localObject2, str2, str3, 15);
      if (localObject3 != null)
      {
        if (((IndividualRedPacketManager.FontBitmap)localObject2).jdField_b_of_type_Boolean) {
          a((Bitmap)localObject3, str2, str3, 18);
        }
        for (localObject1 = a(str2, str3, 18, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_d_of_type_Int, IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int);; localObject1 = a(str2, str3, 15, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_d_of_type_Int, IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int))
        {
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getSendCombineImg2 templateId = " + str2 + "; name = " + str3 + "; combinefilename = " + str1);
          return localObject1;
          a((Bitmap)localObject3, str2, str3, 15);
        }
      }
      QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg3 null allowshowredpacket templateId =" + str2 + ";name = " + str3);
      return null;
    }
    QLog.e(jdField_d_of_type_JavaLangString, 1, "getSendCombineImg not allowshowredpacket templateId =" + str2 + ";name = " + str3);
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if (!c())
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "getTenpayCombineImg: isAllowShowRedpacket = false templateId = " + paramString1 + ";name = " + paramString2);
        localObject1 = localObject2;
      }
    }
    do
    {
      return localObject1;
      localObject1 = localObject3;
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject1 = localObject3;
        if (a().jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.a().contains(paramString2)) {
          localObject1 = a(paramString1, paramString2, 13);
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = a(paramString1, paramString2, 7);
      }
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_d_of_type_JavaLangString, 2, "getTenpayCombineImg: templateId = " + paramString1 + ";name = " + paramString2 + ", path = " + (String)localObject2);
    return localObject2;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject1 = a().a(paramString1, true);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getLocalImg fail! can't find template templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
        }
        localObject2 = null;
      }
    }
    for (;;)
    {
      return localObject2;
      localObject1 = a(paramString1, paramString2, paramInt, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_d_of_type_Int, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_Int);
      label100:
      localObject2 = this.jdField_a_of_type_JavaUtilLinkedList;
      if (localObject1 != null) {}
      try
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.contains(localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_d_of_type_JavaLangString, 2, "getLocalImg fail! file Saving! templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
          }
          return null;
          localObject1 = a("", paramString2, paramInt, 0, 0);
          break label100;
        }
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          ((File)localObject2).setLastModified(NetConnInfoCenter.getServerTimeMillis());
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getLocalImg success! templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
          return localObject1;
        }
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_d_of_type_JavaLangString, 2, "getLocalImg fail! file not exists! templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
    }
    return null;
  }
  
  public void a()
  {
    ThreadManager.post(new zmr(this), 2, null, true);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_d_of_type_JavaLangString, 2, "IndividualRedPacketManager.setRedPacketFlags iCanUseRed:" + paramInt1 + ", iRedDisable:" + paramInt2 + ", isUpdate:" + paramBoolean + ", this.iCanUseRed:" + this.h + ", this.iRedDisable:" + this.i);
    }
    int i1 = paramInt1;
    if (paramInt1 < 0) {
      i1 = this.h;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = this.i;
    }
    if ((this.h != i1) || (this.i != paramInt1))
    {
      this.h = i1;
      this.i = paramInt1;
      if (paramBoolean)
      {
        SharedPreferences localSharedPreferences = a();
        localSharedPreferences.edit().putInt("sp_vip_info_can_use_packet", i1);
        localSharedPreferences.edit().putInt("sp_vip_info_red_packet_disable", paramInt1);
        localSharedPreferences.edit().commit();
      }
      if ((i1 == 1) && (paramInt1 == 0)) {
        jdField_c_of_type_JavaLangString = "1";
      }
    }
    else
    {
      return;
    }
    jdField_c_of_type_JavaLangString = "0";
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_d_of_type_JavaLangString, 2, "setRedpacketInfo redpacketId = " + paramInt + "; redpacketText = " + paramString);
    }
    this.j = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
    SharedPreferences localSharedPreferences = a();
    localSharedPreferences.edit().putInt("sp_vip_info_red_packet_id", paramInt);
    localSharedPreferences.edit().putString("sp_vip_info_red_packet_text", paramString);
    localSharedPreferences.edit().commit();
  }
  
  /* Error */
  public void a(Bitmap arg1, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ifnonnull +20 -> 24
    //   7: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +13 -> 23
    //   13: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   16: iconst_2
    //   17: ldc_w 1163
    //   20: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: return
    //   24: aload_2
    //   25: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +445 -> 473
    //   31: aload_0
    //   32: invokevirtual 233	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   35: aload_2
    //   36: iconst_1
    //   37: invokevirtual 238	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo;
    //   40: astore 7
    //   42: aload 7
    //   44: ifnull +429 -> 473
    //   47: aload 7
    //   49: getfield 263	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_d_of_type_Int	I
    //   52: istore 6
    //   54: aload 7
    //   56: getfield 264	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_Int	I
    //   59: istore 5
    //   61: iload 4
    //   63: iconst_5
    //   64: if_icmpne +27 -> 91
    //   67: aload_3
    //   68: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +20 -> 91
    //   74: aload_0
    //   75: invokevirtual 233	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   78: getfield 703	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   81: invokevirtual 707	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:a	()Ljava/lang/String;
    //   84: aload_3
    //   85: invokevirtual 710	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   88: ifne -65 -> 23
    //   91: aload_2
    //   92: aload_3
    //   93: iload 4
    //   95: iload 6
    //   97: iload 5
    //   99: invokestatic 267	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   102: astore 8
    //   104: aload 8
    //   106: invokestatic 539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifeq +19 -> 128
    //   112: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +13 -> 128
    //   118: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   121: iconst_2
    //   122: ldc_w 1165
    //   125: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: new 623	java/io/File
    //   131: dup
    //   132: aload 8
    //   134: invokespecial 747	java/io/File:<init>	(Ljava/lang/String;)V
    //   137: astore_2
    //   138: aload_2
    //   139: invokevirtual 752	java/io/File:exists	()Z
    //   142: ifeq +38 -> 180
    //   145: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq -125 -> 23
    //   151: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   154: iconst_2
    //   155: new 44	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 1167
    //   165: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 8
    //   170: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: return
    //   180: aload_0
    //   181: getfield 173	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   184: astore_3
    //   185: aload_3
    //   186: monitorenter
    //   187: aload_0
    //   188: getfield 173	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   191: aload 8
    //   193: invokevirtual 1168	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   196: pop
    //   197: aload_3
    //   198: monitorexit
    //   199: aconst_null
    //   200: astore_3
    //   201: aconst_null
    //   202: astore 7
    //   204: new 961	java/io/BufferedOutputStream
    //   207: dup
    //   208: new 963	java/io/FileOutputStream
    //   211: dup
    //   212: aload_2
    //   213: invokespecial 966	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   216: invokespecial 969	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   219: astore_2
    //   220: aload_2
    //   221: astore_3
    //   222: aload_1
    //   223: getstatic 975	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   226: bipush 90
    //   228: aload_2
    //   229: invokevirtual 979	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   232: pop
    //   233: aload_2
    //   234: astore_3
    //   235: aload_2
    //   236: invokevirtual 982	java/io/BufferedOutputStream:flush	()V
    //   239: aload_2
    //   240: ifnull +7 -> 247
    //   243: aload_2
    //   244: invokevirtual 985	java/io/BufferedOutputStream:close	()V
    //   247: aload_0
    //   248: getfield 173	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   251: astore_1
    //   252: aload_1
    //   253: monitorenter
    //   254: aload_0
    //   255: getfield 173	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   258: aload 8
    //   260: invokevirtual 1171	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   263: pop
    //   264: aload_1
    //   265: monitorexit
    //   266: return
    //   267: astore_2
    //   268: aload_1
    //   269: monitorexit
    //   270: aload_2
    //   271: athrow
    //   272: astore_1
    //   273: aload_3
    //   274: monitorexit
    //   275: aload_1
    //   276: athrow
    //   277: astore_1
    //   278: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   281: iconst_1
    //   282: ldc_w 1173
    //   285: aload_1
    //   286: invokestatic 990	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   289: goto -42 -> 247
    //   292: astore_1
    //   293: aconst_null
    //   294: astore_2
    //   295: aload_2
    //   296: astore_3
    //   297: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +35 -> 335
    //   303: aload_2
    //   304: astore_3
    //   305: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   308: iconst_2
    //   309: new 44	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 1175
    //   319: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_1
    //   323: invokevirtual 1176	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   326: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_2
    //   336: ifnull -89 -> 247
    //   339: aload_2
    //   340: invokevirtual 985	java/io/BufferedOutputStream:close	()V
    //   343: goto -96 -> 247
    //   346: astore_1
    //   347: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   350: iconst_1
    //   351: ldc_w 1173
    //   354: aload_1
    //   355: invokestatic 990	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: goto -111 -> 247
    //   361: astore_2
    //   362: aload 7
    //   364: astore_1
    //   365: aload_1
    //   366: astore_3
    //   367: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq +35 -> 405
    //   373: aload_1
    //   374: astore_3
    //   375: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   378: iconst_2
    //   379: new 44	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   386: ldc_w 1175
    //   389: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload_2
    //   393: invokevirtual 1056	java/io/IOException:getMessage	()Ljava/lang/String;
    //   396: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: aload_1
    //   406: ifnull -159 -> 247
    //   409: aload_1
    //   410: invokevirtual 985	java/io/BufferedOutputStream:close	()V
    //   413: goto -166 -> 247
    //   416: astore_1
    //   417: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   420: iconst_1
    //   421: ldc_w 1173
    //   424: aload_1
    //   425: invokestatic 990	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   428: goto -181 -> 247
    //   431: astore_1
    //   432: aload_3
    //   433: ifnull +7 -> 440
    //   436: aload_3
    //   437: invokevirtual 985	java/io/BufferedOutputStream:close	()V
    //   440: aload_1
    //   441: athrow
    //   442: astore_2
    //   443: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   446: iconst_1
    //   447: ldc_w 1173
    //   450: aload_2
    //   451: invokestatic 990	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   454: goto -14 -> 440
    //   457: astore_1
    //   458: goto -26 -> 432
    //   461: astore_3
    //   462: aload_2
    //   463: astore_1
    //   464: aload_3
    //   465: astore_2
    //   466: goto -101 -> 365
    //   469: astore_1
    //   470: goto -175 -> 295
    //   473: iconst_0
    //   474: istore 6
    //   476: goto -415 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	IndividualRedPacketManager
    //   0	479	2	paramString1	String
    //   0	479	3	paramString2	String
    //   0	479	4	paramInt	int
    //   1	97	5	i1	int
    //   52	423	6	i2	int
    //   40	323	7	localRedPacketTemplateInfo	IndividualRedPacketResDownloader.RedPacketTemplateInfo
    //   102	157	8	str	String
    // Exception table:
    //   from	to	target	type
    //   254	266	267	finally
    //   268	270	267	finally
    //   187	199	272	finally
    //   273	275	272	finally
    //   243	247	277	java/lang/Exception
    //   204	220	292	java/io/FileNotFoundException
    //   339	343	346	java/lang/Exception
    //   204	220	361	java/io/IOException
    //   409	413	416	java/lang/Exception
    //   204	220	431	finally
    //   367	373	431	finally
    //   375	405	431	finally
    //   436	440	442	java/lang/Exception
    //   222	233	457	finally
    //   235	239	457	finally
    //   297	303	457	finally
    //   305	335	457	finally
    //   222	233	461	java/io/IOException
    //   235	239	461	java/io/IOException
    //   222	233	469	java/io/FileNotFoundException
    //   235	239	469	java/io/FileNotFoundException
  }
  
  public void a(IndividualRedPacketResDownloader.Char300Info paramChar300Info)
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      QLog.e(jdField_d_of_type_JavaLangString, 1, "preCreatePersonalFontImg mIsSDCardError:" + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) || (paramChar300Info.jdField_a_of_type_Int == 0) || (TextUtils.isEmpty(paramChar300Info.a())) || (!IndividualRedPacketResDownloader.a(a().jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo)));
      if (b().getInt("font_precreate_count", 0) >= paramChar300Info.jdField_c_of_type_Int)
      {
        QLog.d(jdField_d_of_type_JavaLangString, 1, "preCreatePersonalFontImg count >= " + paramChar300Info.jdField_c_of_type_Int);
        return;
      }
    } while ((!b()) || (!this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)));
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("RedPacketPrecreate", 19);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$PrecreateRunnable = new IndividualRedPacketManager.PrecreateRunnable(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChar300Info);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$PrecreateRunnable);
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$PrecreateRunnable.a();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = b().getString("cach_font_id", "");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(a().jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.jdField_d_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "Clear SDCard Cache Start!");
      }
      localObject = new String[5];
      localObject[0] = a(4);
      localObject[1] = a(5);
      localObject[2] = a(6);
      localObject[3] = a(7);
      localObject[4] = a(8);
      int i1 = 0;
      while (i1 < localObject.length)
      {
        File localFile1 = new File(localObject[i1]);
        if ((localFile1.exists()) && (localFile1.isDirectory()))
        {
          File[] arrayOfFile = localFile1.listFiles();
          int i2 = 0;
          while (i2 < arrayOfFile.length)
          {
            File localFile2 = new File(arrayOfFile[i2].getParent() + File.separator + System.currentTimeMillis());
            arrayOfFile[i2].renameTo(localFile2);
            localFile2.delete();
            i2 += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_d_of_type_JavaLangString, 2, "Clear " + localFile1.getAbsolutePath() + " done!");
          }
        }
        i1 += 1;
      }
    }
    b().edit().putString("cach_font_id", paramString).commit();
  }
  
  public void a(String paramString, int paramInt)
  {
    int i2 = 0;
    if (TextUtils.isEmpty(paramString)) {}
    CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo;
    Object localObject1;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "onDoneDownloadBG id = " + paramString + ", resType:" + paramInt);
        }
        localRedPacketInfo = (CustomizeStrategyFactory.RedPacketInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      } while (localRedPacketInfo == null);
      localObject1 = a().a(localRedPacketInfo.templateId, true);
    } while (localObject1 == null);
    label111:
    Object localObject2;
    if (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_Int == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int)
    {
      int i1;
      if (paramInt == 2)
      {
        i1 = 6;
        localObject1 = a(localRedPacketInfo.jdField_a_of_type_JavaLangString, i1);
        localObject2 = a((IndividualRedPacketManager.FontBitmap)localObject1, localRedPacketInfo, i1);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "onDoneDownloadBG type = " + i1);
        }
        if ((((IndividualRedPacketManager.FontBitmap)localObject1).jdField_a_of_type_AndroidGraphicsBitmap != null) && (!((IndividualRedPacketManager.FontBitmap)localObject1).jdField_a_of_type_Boolean)) {
          a(((IndividualRedPacketManager.FontBitmap)localObject1).jdField_a_of_type_AndroidGraphicsBitmap, "", localRedPacketInfo.jdField_a_of_type_JavaLangString, 5);
        }
        paramInt = i2;
        if (6 == i1)
        {
          paramInt = i2;
          if (((IndividualRedPacketManager.FontBitmap)localObject1).jdField_a_of_type_AndroidGraphicsBitmap != null)
          {
            paramInt = i2;
            if (localObject2 != null)
            {
              if (((IndividualRedPacketManager.FontBitmap)localObject1).jdField_b_of_type_Boolean) {
                break label305;
              }
              a((Bitmap)localObject2, localRedPacketInfo.templateId, localRedPacketInfo.jdField_a_of_type_JavaLangString, 6);
            }
          }
        }
      }
      for (paramInt = i2;; paramInt = i2)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        if (paramInt == 0) {
          break;
        }
        CustomizeStrategyFactory.a().a(localRedPacketInfo);
        return;
        if (paramInt == 3)
        {
          i1 = 7;
          break label111;
        }
        i1 = paramInt;
        if (paramInt != 14) {
          break label111;
        }
        i1 = 15;
        break label111;
        label305:
        a((Bitmap)localObject2, localRedPacketInfo.templateId, localRedPacketInfo.jdField_a_of_type_JavaLangString, 12);
      }
    }
    if (paramInt == 19)
    {
      localObject2 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
      if ((localObject2 == null) || (((IndividualRedPacketResDownloader.DecorateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig == null)) {
        break label466;
      }
      localObject2 = a(((IndividualRedPacketResDownloader.DecorateInfo)localObject2).jdField_d_of_type_JavaLangString, null, ((IndividualRedPacketResDownloader.DecorateInfo)localObject2).f, ((IndividualRedPacketResDownloader.DecorateInfo)localObject2).jdField_d_of_type_Int, 0);
      File localFile = new File((String)localObject2);
      if ((localFile != null) && (localFile.exists()) && (localFile.isFile())) {
        a((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1, localRedPacketInfo, (String)localObject2, false);
      }
      if (localRedPacketInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = 1;; paramInt = 0)
    {
      break;
      if (paramInt == 2) {
        localRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = a(a(((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_JavaLangString, "", 6), null);
      }
      paramInt = 1;
      break;
    }
  }
  
  public void a(String paramString, Bundle paramBundle, MessengerService paramMessengerService)
  {
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo = a().a(paramString, true);
    int i2 = n;
    int i1 = i2;
    if (localRedPacketTemplateInfo != null)
    {
      i1 = i2;
      if (!TextUtils.isEmpty(paramString))
      {
        if (localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo != null) {
          i1 = localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f;
        }
        if (!new File(a(paramString, "", 2, localRedPacketTemplateInfo.jdField_d_of_type_Int, localRedPacketTemplateInfo.jdField_a_of_type_Int)).exists()) {
          break label141;
        }
      }
    }
    label141:
    for (i1 = m;; i1 = n)
    {
      if (i1 != m) {
        a().a(16L, paramString, null);
      }
      paramString = new Bundle();
      paramString.putInt("result", i1);
      paramBundle.putBundle("response", paramString);
      paramMessengerService.a(paramBundle);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, MessengerService paramMessengerService)
  {
    ThreadManager.post(new zmt(this, paramString1, paramString2, paramBundle, paramMessengerService), 8, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new String[9];
    localObject[0] = a(1);
    localObject[1] = a(3);
    localObject[2] = a(1);
    localObject[3] = a(5);
    localObject[4] = a(4);
    localObject[5] = a(6);
    localObject[6] = a(7);
    localObject[7] = a(8);
    localObject[8] = a(2);
    int i3 = 0;
    int i4;
    int i2;
    for (int i1 = 0; i3 < localObject.length; i1 = i4)
    {
      File localFile = new File(localObject[i3]);
      if (localFile.exists())
      {
        i4 = i1;
        if (localFile.isDirectory()) {}
      }
      else
      {
        bool1 = localFile.mkdirs();
        i2 = i1;
        if (!bool1) {
          i2 = i1 + 1;
        }
        i4 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "initDir path:" + localObject[i3] + ", mkdirs:" + bool1 + ", errCode:" + i2);
          i4 = i2;
        }
      }
      i3 += 1;
    }
    boolean bool2;
    if (i1 <= 0)
    {
      i2 = 1;
      if (i2 == 0)
      {
        bool2 = VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), jdField_d_of_type_JavaLangString, false);
        localObject = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if (bool2) {
          break label389;
        }
      }
    }
    label389:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((AtomicBoolean)localObject).set(bool1);
      QLog.e(jdField_d_of_type_JavaLangString, 2, "initDir Err haveSDCard:" + bool2 + ", mIsSDCardError:" + this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", errCode:" + i1);
      if ((this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramBoolean))
      {
        jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir() + File.separator + "dRedPacket/";
        a(false);
      }
      return;
      i2 = 0;
      break;
    }
  }
  
  public boolean a()
  {
    return (this.h == 1) && (this.i == 0);
  }
  
  public SharedPreferences b()
  {
    if (this.jdField_b_of_type_AndroidContentSharedPreferences == null)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Object localObject = localQQAppInterface;
      if (localQQAppInterface == null) {
        localObject = BaseApplicationImpl.sApplication.getRuntime();
      }
      this.jdField_b_of_type_AndroidContentSharedPreferences = ((AppRuntime)localObject).getApplication().getApplicationContext().getSharedPreferences("individRedPacket_common", 0);
    }
    return this.jdField_b_of_type_AndroidContentSharedPreferences;
  }
  
  public boolean b()
  {
    return this.i == 0;
  }
  
  public boolean c()
  {
    return (b()) && (a().jdField_a_of_type_Boolean);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.interrupt();
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$PrecreateRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader.b();
      this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader = null;
    }
    this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager
 * JD-Core Version:    0.7.0.1
 */