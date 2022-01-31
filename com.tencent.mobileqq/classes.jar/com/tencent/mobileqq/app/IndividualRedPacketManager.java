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
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import zfp;
import zfq;
import zfr;
import zfs;

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
  public Map a;
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
    jdField_a_of_type_JavaLangString = AppConstants.aJ + "RedPacket/";
    jdField_a_of_type_Int = 10029;
    jdField_c_of_type_JavaLangString = "0";
  }
  
  public IndividualRedPacketManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilComparator = new zfr(this);
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
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    ThreadManager.post(new zfp(this), 8, null, true);
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
    //   13: getstatic 455	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   16: aload_0
    //   17: invokevirtual 461	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: ifnull +375 -> 395
    //   23: aload 5
    //   25: astore_3
    //   26: aload 6
    //   28: astore 4
    //   30: getstatic 455	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   33: aload_0
    //   34: invokevirtual 461	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
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
    //   65: new 463	android/graphics/BitmapFactory$Options
    //   68: dup
    //   69: invokespecial 464	android/graphics/BitmapFactory$Options:<init>	()V
    //   72: astore 6
    //   74: aload_3
    //   75: astore 4
    //   77: aload_3
    //   78: astore 5
    //   80: aload 6
    //   82: getstatic 467	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   85: putfield 470	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   88: aload_3
    //   89: astore 4
    //   91: aload_3
    //   92: astore 5
    //   94: aload_0
    //   95: aload 6
    //   97: invokestatic 475	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   100: astore 7
    //   102: aload_3
    //   103: astore 4
    //   105: aload_3
    //   106: astore 5
    //   108: aload 7
    //   110: getfield 478	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
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
    //   143: ldc_w 480
    //   146: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 482
    //   156: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 7
    //   161: getfield 483	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   164: invokevirtual 486	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_1
    //   174: astore 4
    //   176: aload_1
    //   177: astore 5
    //   179: aload 7
    //   181: getfield 483	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
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
    //   211: putfield 489	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   214: aload_1
    //   215: astore_3
    //   216: aload_1
    //   217: astore 4
    //   219: aload_0
    //   220: aload 6
    //   222: invokestatic 475	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   225: astore 5
    //   227: aload_1
    //   228: astore_3
    //   229: aload_1
    //   230: astore 4
    //   232: aload 5
    //   234: getfield 478	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   237: astore_1
    //   238: aload_1
    //   239: astore_3
    //   240: aload_1
    //   241: astore 4
    //   243: aload 5
    //   245: getfield 483	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
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
    //   272: ldc_w 491
    //   275: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload_1
    //   279: astore_3
    //   280: new 213	java/util/HashMap
    //   283: dup
    //   284: invokespecial 214	java/util/HashMap:<init>	()V
    //   287: astore 4
    //   289: aload_1
    //   290: astore_3
    //   291: getstatic 336	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   294: invokevirtual 337	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   297: invokestatic 342	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   300: getstatic 336	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   303: invokevirtual 346	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   306: checkcast 175	com/tencent/mobileqq/app/QQAppInterface
    //   309: invokevirtual 349	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   312: ldc_w 493
    //   315: iconst_0
    //   316: lconst_1
    //   317: lconst_0
    //   318: aload 4
    //   320: ldc_w 262
    //   323: iconst_0
    //   324: invokevirtual 354	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   327: aload_1
    //   328: astore 4
    //   330: aload 4
    //   332: astore_3
    //   333: new 213	java/util/HashMap
    //   336: dup
    //   337: invokespecial 214	java/util/HashMap:<init>	()V
    //   340: astore_1
    //   341: aload 4
    //   343: astore_3
    //   344: aload_1
    //   345: ldc_w 324
    //   348: ldc 68
    //   350: invokevirtual 330	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   353: pop
    //   354: aload 4
    //   356: astore_3
    //   357: getstatic 336	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   360: invokevirtual 337	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   363: invokestatic 342	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   366: getstatic 336	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   369: invokevirtual 346	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   372: checkcast 175	com/tencent/mobileqq/app/QQAppInterface
    //   375: invokevirtual 349	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   378: ldc_w 495
    //   381: iconst_0
    //   382: lconst_1
    //   383: lconst_0
    //   384: aload_1
    //   385: ldc_w 262
    //   388: iconst_0
    //   389: invokevirtual 354	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
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
    //   429: ldc_w 480
    //   432: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_0
    //   436: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: ldc_w 497
    //   442: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_1
    //   446: invokevirtual 320	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   449: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: new 213	java/util/HashMap
    //   461: dup
    //   462: invokespecial 214	java/util/HashMap:<init>	()V
    //   465: astore_0
    //   466: aload_0
    //   467: ldc_w 324
    //   470: ldc_w 499
    //   473: invokevirtual 330	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: pop
    //   477: getstatic 336	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   480: invokevirtual 337	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   483: invokestatic 342	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   486: getstatic 336	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   489: invokevirtual 346	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   492: checkcast 175	com/tencent/mobileqq/app/QQAppInterface
    //   495: invokevirtual 349	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   498: ldc_w 495
    //   501: iconst_0
    //   502: lconst_1
    //   503: lconst_0
    //   504: aload_0
    //   505: ldc_w 262
    //   508: iconst_0
    //   509: invokevirtual 354	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
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
    //   532: ldc_w 480
    //   535: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_0
    //   539: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: ldc_w 501
    //   545: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload_1
    //   549: invokevirtual 357	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   552: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: new 213	java/util/HashMap
    //   564: dup
    //   565: invokespecial 214	java/util/HashMap:<init>	()V
    //   568: astore_0
    //   569: aload_0
    //   570: ldc_w 324
    //   573: ldc_w 499
    //   576: invokevirtual 330	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: pop
    //   580: getstatic 336	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   583: invokevirtual 337	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   586: invokestatic 342	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   589: getstatic 336	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   592: invokevirtual 346	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   595: checkcast 175	com/tencent/mobileqq/app/QQAppInterface
    //   598: invokevirtual 349	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   601: ldc_w 503
    //   604: iconst_0
    //   605: lconst_1
    //   606: lconst_0
    //   607: aload_0
    //   608: ldc_w 262
    //   611: iconst_0
    //   612: invokevirtual 354	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
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
      return AppConstants.aJ + "pddata/vas/RedPacket/packets/";
    case 2: 
      return AppConstants.aJ + "pddata/vas/RedPacket/specialFont/";
    case 3: 
      return AppConstants.aJ + "pddata/vas/RedPacket/font/";
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
    //   24: getfield 653	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:templateId	Ljava/lang/String;
    //   27: astore 10
    //   29: aload_2
    //   30: getfield 654	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   77: ifnonnull +293 -> 370
    //   80: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +61 -> 144
    //   86: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   89: iconst_2
    //   90: new 44	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 656
    //   100: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload 10
    //   105: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc_w 658
    //   111: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 11
    //   116: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc_w 660
    //   122: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 5
    //   127: getfield 662	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   130: invokeinterface 667 1 0
    //   135: invokevirtual 486	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_1
    //   145: getfield 216	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   148: astore_0
    //   149: aload_0
    //   150: monitorenter
    //   151: aload_1
    //   152: getfield 216	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   155: aload_2
    //   156: getfield 669	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   159: invokeinterface 673 2 0
    //   164: ifne +18 -> 182
    //   167: aload_1
    //   168: getfield 216	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   171: aload_2
    //   172: getfield 669	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   175: aload_2
    //   176: invokeinterface 674 3 0
    //   181: pop
    //   182: aload_1
    //   183: getfield 216	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   186: new 44	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   193: aload_2
    //   194: getfield 669	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   197: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 676
    //   203: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokeinterface 673 2 0
    //   214: ifne +37 -> 251
    //   217: aload_1
    //   218: getfield 216	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   221: new 44	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   228: aload_2
    //   229: getfield 669	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   232: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 676
    //   238: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: aload_2
    //   245: invokeinterface 674 3 0
    //   250: pop
    //   251: aload_0
    //   252: monitorexit
    //   253: aload 5
    //   255: getfield 678	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:c	Ljava/util/Map;
    //   258: astore_0
    //   259: aload_0
    //   260: monitorenter
    //   261: aload 5
    //   263: getfield 678	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:c	Ljava/util/Map;
    //   266: aload 10
    //   268: invokeinterface 673 2 0
    //   273: ifne +64 -> 337
    //   276: new 680	java/util/ArrayList
    //   279: dup
    //   280: invokespecial 681	java/util/ArrayList:<init>	()V
    //   283: astore_1
    //   284: aload_1
    //   285: aload_2
    //   286: getfield 669	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   289: invokevirtual 684	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   292: pop
    //   293: aload 5
    //   295: getfield 678	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:c	Ljava/util/Map;
    //   298: aload 10
    //   300: aload_1
    //   301: invokeinterface 674 3 0
    //   306: pop
    //   307: aload_0
    //   308: monitorexit
    //   309: aload 5
    //   311: ldc2_w 685
    //   314: aload 10
    //   316: aload_2
    //   317: getfield 669	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   320: invokevirtual 689	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(JLjava/lang/String;Ljava/lang/String;)V
    //   323: goto -304 -> 19
    //   326: astore_0
    //   327: ldc 2
    //   329: monitorexit
    //   330: aload_0
    //   331: athrow
    //   332: astore_1
    //   333: aload_0
    //   334: monitorexit
    //   335: aload_1
    //   336: athrow
    //   337: aload 5
    //   339: getfield 678	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:c	Ljava/util/Map;
    //   342: aload 10
    //   344: invokeinterface 690 2 0
    //   349: checkcast 692	java/util/List
    //   352: aload_2
    //   353: getfield 669	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   356: invokeinterface 693 2 0
    //   361: pop
    //   362: goto -55 -> 307
    //   365: astore_1
    //   366: aload_0
    //   367: monitorexit
    //   368: aload_1
    //   369: athrow
    //   370: aload 11
    //   372: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   375: ifne +882 -> 1257
    //   378: aload 5
    //   380: getfield 696	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   383: invokevirtual 700	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:a	()Ljava/lang/String;
    //   386: aload 11
    //   388: invokevirtual 703	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   391: ifeq +866 -> 1257
    //   394: iconst_1
    //   395: istore_3
    //   396: aload 12
    //   398: getfield 264	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_Int	I
    //   401: getstatic 635	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_Int	I
    //   404: if_icmpne +424 -> 828
    //   407: iload_3
    //   408: ifeq +844 -> 1252
    //   411: aload_1
    //   412: aload 10
    //   414: aload 11
    //   416: bipush 12
    //   418: invokevirtual 706	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   421: astore_0
    //   422: aload_0
    //   423: astore 5
    //   425: aload_0
    //   426: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   429: ifeq +43 -> 472
    //   432: aload 11
    //   434: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   437: ifne +23 -> 460
    //   440: aload_0
    //   441: astore 5
    //   443: aload_1
    //   444: ldc_w 262
    //   447: aload 11
    //   449: bipush 9
    //   451: invokevirtual 706	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   454: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   457: ifeq +15 -> 472
    //   460: aload_1
    //   461: aload 10
    //   463: aload 11
    //   465: bipush 6
    //   467: invokevirtual 706	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   470: astore 5
    //   472: aload 5
    //   474: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   477: ifeq +691 -> 1168
    //   480: aload 12
    //   482: getfield 707	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_e_of_type_Int	I
    //   485: iconst_1
    //   486: if_icmpeq +666 -> 1152
    //   489: aload_1
    //   490: aload 11
    //   492: bipush 6
    //   494: invokevirtual 710	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap;
    //   497: astore_0
    //   498: aload_1
    //   499: aload_0
    //   500: aload_2
    //   501: bipush 6
    //   503: invokevirtual 713	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Lcom/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap;Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;I)Landroid/graphics/Bitmap;
    //   506: astore 6
    //   508: aload_0
    //   509: astore 7
    //   511: aload 12
    //   513: getfield 264	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_Int	I
    //   516: getstatic 635	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_Int	I
    //   519: if_icmpne +722 -> 1241
    //   522: iload_3
    //   523: ifeq +718 -> 1241
    //   526: aload_1
    //   527: aload 10
    //   529: aload 11
    //   531: bipush 13
    //   533: invokevirtual 706	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   536: astore_0
    //   537: aload_0
    //   538: astore 5
    //   540: aload_0
    //   541: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   544: ifeq +43 -> 587
    //   547: aload 11
    //   549: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   552: ifne +23 -> 575
    //   555: aload_0
    //   556: astore 5
    //   558: aload_1
    //   559: ldc_w 262
    //   562: aload 11
    //   564: bipush 10
    //   566: invokevirtual 706	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   569: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   572: ifeq +15 -> 587
    //   575: aload_1
    //   576: aload 10
    //   578: aload 11
    //   580: bipush 7
    //   582: invokevirtual 706	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   585: astore 5
    //   587: aload 5
    //   589: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   592: ifeq +30 -> 622
    //   595: aload 12
    //   597: getfield 707	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_e_of_type_Int	I
    //   600: iconst_1
    //   601: if_icmpeq +593 -> 1194
    //   604: aload_1
    //   605: aload 11
    //   607: bipush 7
    //   609: invokevirtual 710	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap;
    //   612: astore_0
    //   613: aload_1
    //   614: aload_0
    //   615: aload_2
    //   616: bipush 7
    //   618: invokevirtual 713	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Lcom/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap;Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;I)Landroid/graphics/Bitmap;
    //   621: pop
    //   622: aload 9
    //   624: astore_0
    //   625: aload 12
    //   627: getfield 264	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_Int	I
    //   630: getstatic 635	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_Int	I
    //   633: if_icmpne +73 -> 706
    //   636: aload 8
    //   638: astore 5
    //   640: iload_3
    //   641: ifeq +15 -> 656
    //   644: aload_1
    //   645: aload 10
    //   647: aload 11
    //   649: bipush 18
    //   651: invokevirtual 706	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   654: astore 5
    //   656: aload 5
    //   658: astore_0
    //   659: aload 5
    //   661: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   664: ifeq +42 -> 706
    //   667: aload 11
    //   669: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   672: ifne +23 -> 695
    //   675: aload 5
    //   677: astore_0
    //   678: aload_1
    //   679: ldc_w 262
    //   682: aload 11
    //   684: bipush 16
    //   686: invokevirtual 706	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   689: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   692: ifeq +14 -> 706
    //   695: aload_1
    //   696: aload 10
    //   698: aload 11
    //   700: bipush 15
    //   702: invokevirtual 706	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   705: astore_0
    //   706: aload_0
    //   707: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   710: ifeq +30 -> 740
    //   713: aload 12
    //   715: getfield 707	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_e_of_type_Int	I
    //   718: iconst_1
    //   719: if_icmpeq +491 -> 1210
    //   722: aload_1
    //   723: aload 11
    //   725: bipush 15
    //   727: invokevirtual 710	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap;
    //   730: astore_0
    //   731: aload_1
    //   732: aload_0
    //   733: aload_2
    //   734: bipush 15
    //   736: invokevirtual 713	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Lcom/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap;Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;I)Landroid/graphics/Bitmap;
    //   739: pop
    //   740: aload 7
    //   742: ifnull +42 -> 784
    //   745: aload 7
    //   747: getfield 299	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   750: ifnull +34 -> 784
    //   753: aload 7
    //   755: getfield 398	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_Boolean	Z
    //   758: ifne +26 -> 784
    //   761: aload 7
    //   763: getfield 715	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:c	Z
    //   766: ifne +18 -> 784
    //   769: aload_1
    //   770: aload 7
    //   772: getfield 299	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   775: ldc_w 262
    //   778: aload 11
    //   780: iconst_5
    //   781: invokevirtual 718	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)V
    //   784: aload 6
    //   786: ifnull -767 -> 19
    //   789: aload 7
    //   791: getfield 299	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   794: ifnonnull +11 -> 805
    //   797: aload 7
    //   799: getfield 715	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:c	Z
    //   802: ifeq -783 -> 19
    //   805: aload 7
    //   807: getfield 719	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_b_of_type_Boolean	Z
    //   810: ifeq +416 -> 1226
    //   813: aload_1
    //   814: aload 6
    //   816: aload 10
    //   818: aload 11
    //   820: bipush 12
    //   822: invokevirtual 718	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)V
    //   825: goto -806 -> 19
    //   828: aload 12
    //   830: getfield 243	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   833: astore 6
    //   835: aload 6
    //   837: ifnull +415 -> 1252
    //   840: aload 6
    //   842: getfield 722	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig	Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$AnimConfig;
    //   845: ifnull +407 -> 1252
    //   848: aload_2
    //   849: getfield 723	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig	Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$AnimConfig;
    //   852: ifnull +26 -> 878
    //   855: aload_2
    //   856: getfield 723	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig	Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$AnimConfig;
    //   859: getfield 726	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$AnimConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   862: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   865: ifne +13 -> 878
    //   868: invokestatic 731	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	()Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory;
    //   871: aload_2
    //   872: invokevirtual 734	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	(Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;)V
    //   875: goto -856 -> 19
    //   878: aload 6
    //   880: getfield 735	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   883: aconst_null
    //   884: aload 6
    //   886: getfield 736	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:f	I
    //   889: aload 6
    //   891: getfield 737	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_d_of_type_Int	I
    //   894: iconst_0
    //   895: invokestatic 267	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   898: astore 7
    //   900: aload 7
    //   902: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   905: ifne +13 -> 918
    //   908: new 620	java/io/File
    //   911: dup
    //   912: aload 7
    //   914: invokespecial 740	java/io/File:<init>	(Ljava/lang/String;)V
    //   917: astore_0
    //   918: aload_0
    //   919: ifnonnull +34 -> 953
    //   922: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   925: iconst_2
    //   926: new 44	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   933: ldc_w 742
    //   936: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: aload 7
    //   941: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   947: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   950: goto -931 -> 19
    //   953: aload_0
    //   954: invokevirtual 745	java/io/File:exists	()Z
    //   957: ifeq +289 -> 1246
    //   960: aload_0
    //   961: invokevirtual 748	java/io/File:isFile	()Z
    //   964: ifeq +282 -> 1246
    //   967: aload 12
    //   969: aload_2
    //   970: aload 7
    //   972: iconst_0
    //   973: invokestatic 751	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo;Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;Ljava/lang/String;Z)Z
    //   976: istore 4
    //   978: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   981: ifne +8 -> 989
    //   984: iload 4
    //   986: ifne +276 -> 1262
    //   989: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   992: iconst_2
    //   993: new 44	java/lang/StringBuilder
    //   996: dup
    //   997: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   1000: ldc_w 753
    //   1003: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: iload 4
    //   1008: invokevirtual 756	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1011: ldc_w 758
    //   1014: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: aload 7
    //   1019: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1025: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1028: goto +234 -> 1262
    //   1031: aload_1
    //   1032: getfield 216	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1035: astore_0
    //   1036: aload_0
    //   1037: monitorenter
    //   1038: aload_1
    //   1039: getfield 216	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1042: aload_2
    //   1043: getfield 669	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1046: invokeinterface 673 2 0
    //   1051: ifne +18 -> 1069
    //   1054: aload_1
    //   1055: getfield 216	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1058: aload_2
    //   1059: getfield 669	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1062: aload_2
    //   1063: invokeinterface 674 3 0
    //   1068: pop
    //   1069: aload_0
    //   1070: monitorexit
    //   1071: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1074: ifeq +56 -> 1130
    //   1077: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1080: iconst_2
    //   1081: new 44	java/lang/StringBuilder
    //   1084: dup
    //   1085: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   1088: ldc_w 760
    //   1091: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: aload 10
    //   1096: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: ldc_w 762
    //   1102: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: iload 4
    //   1107: invokevirtual 756	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1110: ldc_w 764
    //   1113: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: aload 6
    //   1118: getfield 765	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1121: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1127: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1130: aload 5
    //   1132: ldc2_w 685
    //   1135: aload 10
    //   1137: aload_2
    //   1138: getfield 669	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1141: invokevirtual 689	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(JLjava/lang/String;Ljava/lang/String;)V
    //   1144: goto -1125 -> 19
    //   1147: astore_1
    //   1148: aload_0
    //   1149: monitorexit
    //   1150: aload_1
    //   1151: athrow
    //   1152: new 296	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap
    //   1155: dup
    //   1156: invokespecial 766	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:<init>	()V
    //   1159: astore_0
    //   1160: aload_0
    //   1161: iconst_1
    //   1162: putfield 715	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:c	Z
    //   1165: goto -667 -> 498
    //   1168: aload_2
    //   1169: aload 5
    //   1171: aconst_null
    //   1172: invokestatic 294	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1175: putfield 767	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1178: invokestatic 731	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	()Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory;
    //   1181: aload_2
    //   1182: invokevirtual 734	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	(Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;)V
    //   1185: aconst_null
    //   1186: astore 6
    //   1188: aconst_null
    //   1189: astore 7
    //   1191: goto -680 -> 511
    //   1194: new 296	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap
    //   1197: dup
    //   1198: invokespecial 766	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:<init>	()V
    //   1201: astore_0
    //   1202: aload_0
    //   1203: iconst_1
    //   1204: putfield 715	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:c	Z
    //   1207: goto -594 -> 613
    //   1210: new 296	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap
    //   1213: dup
    //   1214: invokespecial 766	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:<init>	()V
    //   1217: astore_0
    //   1218: aload_0
    //   1219: iconst_1
    //   1220: putfield 715	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:c	Z
    //   1223: goto -492 -> 731
    //   1226: aload_1
    //   1227: aload 6
    //   1229: aload 10
    //   1231: aload 11
    //   1233: bipush 6
    //   1235: invokevirtual 718	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)V
    //   1238: goto -1219 -> 19
    //   1241: aconst_null
    //   1242: astore_0
    //   1243: goto -706 -> 537
    //   1246: iconst_0
    //   1247: istore 4
    //   1249: goto -218 -> 1031
    //   1252: aconst_null
    //   1253: astore_0
    //   1254: goto -832 -> 422
    //   1257: iconst_0
    //   1258: istore_3
    //   1259: goto -863 -> 396
    //   1262: iload 4
    //   1264: ifne -1245 -> 19
    //   1267: iconst_1
    //   1268: istore 4
    //   1270: goto -239 -> 1031
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1273	1	paramIndividualRedPacketManager	IndividualRedPacketManager
    //   0	1273	2	paramRedPacketInfo	CustomizeStrategyFactory.RedPacketInfo
    //   395	864	3	i1	int
    //   976	293	4	bool	boolean
    //   39	1131	5	localObject1	Object
    //   506	722	6	localObject2	Object
    //   509	681	7	localObject3	Object
    //   6	631	8	localObject4	Object
    //   1	622	9	localObject5	Object
    //   27	1203	10	str1	String
    //   33	1199	11	str2	String
    //   49	919	12	localRedPacketTemplateInfo	IndividualRedPacketResDownloader.RedPacketTemplateInfo
    // Exception table:
    //   from	to	target	type
    //   23	51	326	finally
    //   56	80	326	finally
    //   80	144	326	finally
    //   144	151	326	finally
    //   253	261	326	finally
    //   309	323	326	finally
    //   335	337	326	finally
    //   368	370	326	finally
    //   370	394	326	finally
    //   396	407	326	finally
    //   411	422	326	finally
    //   425	440	326	finally
    //   443	460	326	finally
    //   460	472	326	finally
    //   472	498	326	finally
    //   498	508	326	finally
    //   511	522	326	finally
    //   526	537	326	finally
    //   540	555	326	finally
    //   558	575	326	finally
    //   575	587	326	finally
    //   587	613	326	finally
    //   613	622	326	finally
    //   625	636	326	finally
    //   644	656	326	finally
    //   659	675	326	finally
    //   678	695	326	finally
    //   695	706	326	finally
    //   706	731	326	finally
    //   731	740	326	finally
    //   745	784	326	finally
    //   789	805	326	finally
    //   805	825	326	finally
    //   828	835	326	finally
    //   840	875	326	finally
    //   878	900	326	finally
    //   900	918	326	finally
    //   922	950	326	finally
    //   953	984	326	finally
    //   989	1028	326	finally
    //   1031	1038	326	finally
    //   1071	1130	326	finally
    //   1130	1144	326	finally
    //   1150	1152	326	finally
    //   1152	1165	326	finally
    //   1168	1185	326	finally
    //   1194	1207	326	finally
    //   1210	1223	326	finally
    //   1226	1238	326	finally
    //   151	182	332	finally
    //   182	251	332	finally
    //   251	253	332	finally
    //   333	335	332	finally
    //   261	307	365	finally
    //   307	309	365	finally
    //   337	362	365	finally
    //   366	368	365	finally
    //   1038	1069	1147	finally
    //   1069	1071	1147	finally
    //   1148	1150	1147	finally
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
    for (;;)
    {
      str3 = "0";
      if (a()) {
        str3 = "1";
      }
      l1 = System.currentTimeMillis();
      ??? = a().a(paramRedPacketInfo.templateId, true);
      if (??? != null) {
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
    Object localObject1;
    if (6 == paramInt) {
      localObject1 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
    }
    while (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg decorateInfo = null");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
      return null;
      if (7 == paramInt) {
        localObject1 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
      } else {
        localObject1 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
      }
    }
    if (!IndividualRedPacketResDownloader.a((IndividualRedPacketResDownloader.RedPacketResInfo)localObject1))
    {
      if (((IndividualRedPacketResDownloader.DecorateInfo)localObject1).f == 2) {
        paramFontBitmap = paramRedPacketInfo.jdField_b_of_type_JavaLangString;
      }
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        for (;;)
        {
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramFontBitmap)) {
            this.jdField_a_of_type_JavaUtilMap.put(paramFontBitmap, paramRedPacketInfo);
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg id = " + paramRedPacketInfo.templateId + " content = " + paramRedPacketInfo.jdField_a_of_type_JavaLangString + " not exists!");
          }
          a().a(16L, ((IndividualRedPacketResDownloader.DecorateInfo)localObject1).jdField_d_of_type_JavaLangString, paramRedPacketInfo.jdField_b_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg BG not found,start download url : " + ((IndividualRedPacketResDownloader.DecorateInfo)localObject1).f + ", id=" + ((IndividualRedPacketResDownloader.DecorateInfo)localObject1).jdField_d_of_type_JavaLangString);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
          return null;
          if (((IndividualRedPacketResDownloader.DecorateInfo)localObject1).f != 3) {
            break;
          }
          paramFontBitmap = paramRedPacketInfo.jdField_b_of_type_JavaLangString + "_tp";
        }
        paramFontBitmap = paramRedPacketInfo.jdField_b_of_type_JavaLangString + "_send";
      }
    }
    label546:
    long l2;
    if (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_a_of_type_Int == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int)
    {
      localObject1 = a(paramFontBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, paramInt);
      l2 = System.currentTimeMillis();
      if (localObject1 == null) {
        break label757;
      }
      if (paramInt != 6) {
        break label655;
      }
      paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
      label568:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "1", String.valueOf(l2 - l1), str2);
    }
    for (;;)
    {
      paramFontBitmap = (IndividualRedPacketManager.FontBitmap)localObject1;
      if (paramInt != 6) {
        break;
      }
      CustomizeStrategyFactory.a().a(paramRedPacketInfo);
      return localObject1;
      localObject1 = a(a(paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, paramInt, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_d_of_type_Int, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_a_of_type_Int), null);
      break label546;
      label655:
      if (paramInt == 7)
      {
        if (paramFontBitmap.jdField_b_of_type_Boolean)
        {
          a((Bitmap)localObject1, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 13);
          break label568;
        }
        a((Bitmap)localObject1, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 7);
        break label568;
      }
      if (paramInt != 15) {
        break label568;
      }
      if (paramFontBitmap.jdField_b_of_type_Boolean)
      {
        a((Bitmap)localObject1, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 18);
        break label568;
      }
      a((Bitmap)localObject1, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 15);
      break label568;
      label757:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "createRedPacketImg BG combine == null, templateinfo.type = " + ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_a_of_type_Int);
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
    //   21: invokevirtual 882	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   24: ifne +118 -> 142
    //   27: aload_0
    //   28: getfield 168	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   31: iconst_1
    //   32: invokevirtual 166	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   35: invokestatic 853	java/lang/System:currentTimeMillis	()J
    //   38: lstore_3
    //   39: aload_0
    //   40: getfield 160	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   43: iconst_1
    //   44: ldc_w 883
    //   47: invokevirtual 887	com/etrump/mixlayout/ETEngine:initEngine	(II)Z
    //   50: ifeq +161 -> 211
    //   53: aload_0
    //   54: invokevirtual 233	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   57: getfield 890	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   60: invokestatic 862	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
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
    //   83: invokevirtual 894	com/etrump/mixlayout/ETEngine:native_loadFont	(Ljava/lang/String;IZ)Z
    //   86: pop
    //   87: aload_0
    //   88: getfield 163	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   91: iconst_1
    //   92: invokevirtual 166	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   95: invokestatic 853	java/lang/System:currentTimeMillis	()J
    //   98: lstore 5
    //   100: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +39 -> 142
    //   106: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   109: iconst_2
    //   110: new 44	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 896
    //   120: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: lload 5
    //   125: lload_3
    //   126: lsub
    //   127: invokevirtual 899	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: ldc_w 901
    //   133: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_0
    //   143: getfield 163	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   146: invokevirtual 882	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   149: ifeq +10 -> 159
    //   152: aload_1
    //   153: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifeq +150 -> 306
    //   159: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   162: iconst_1
    //   163: new 44	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 903
    //   173: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 163	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   180: invokevirtual 882	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   183: invokevirtual 756	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: ldc_w 905
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
    //   215: getfield 908	com/etrump/mixlayout/ETEngine:isEngineInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   218: iconst_0
    //   219: iconst_1
    //   220: invokevirtual 912	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   223: ifeq +7 -> 230
    //   226: invokestatic 916	com/etrump/mixlayout/FontSoLoader:c	()Z
    //   229: pop
    //   230: aload_0
    //   231: getfield 163	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   234: iconst_0
    //   235: invokevirtual 166	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   238: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   241: iconst_1
    //   242: ldc_w 918
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
    //   272: ldc_w 920
    //   275: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 7
    //   280: invokevirtual 921	java/lang/Throwable:getMessage	()Ljava/lang/String;
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
    //   310: getfield 890	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   313: invokestatic 862	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   316: ifne +21 -> 337
    //   319: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   322: iconst_1
    //   323: ldc_w 923
    //   326: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload 11
    //   331: monitorexit
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -127 -> 207
    //   337: aload_0
    //   338: getfield 925	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   341: ifnonnull +32 -> 373
    //   344: aload_0
    //   345: new 927	com/etrump/mixlayout/ETFont
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
    //   367: invokespecial 930	com/etrump/mixlayout/ETFont:<init>	(ILjava/lang/String;F)V
    //   370: putfield 925	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   373: aload_0
    //   374: getfield 925	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   377: ldc_w 932
    //   380: invokestatic 419	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   383: invokevirtual 933	com/etrump/mixlayout/ETFont:setColor	(I)V
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
    //   404: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   407: ifeq +36 -> 443
    //   410: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   413: iconst_1
    //   414: ldc_w 935
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
    //   443: new 620	java/io/File
    //   446: dup
    //   447: aload 7
    //   449: invokespecial 740	java/io/File:<init>	(Ljava/lang/String;)V
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
    //   478: invokevirtual 607	java/lang/String:charAt	(I)C
    //   481: aload_0
    //   482: getfield 925	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   485: invokevirtual 939	com/etrump/mixlayout/ETEngine:native_isPaintableChar	(CLcom/etrump/mixlayout/ETFont;)Z
    //   488: ifeq +22 -> 510
    //   491: aload_0
    //   492: getfield 160	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   495: aload_1
    //   496: aload 8
    //   498: iconst_0
    //   499: iconst_0
    //   500: aload_0
    //   501: getfield 925	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   504: invokevirtual 943	com/etrump/mixlayout/ETEngine:native_drawText	(Ljava/lang/String;Landroid/graphics/Bitmap;IILcom/etrump/mixlayout/ETFont;)Z
    //   507: ifne +135 -> 642
    //   510: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   513: iconst_1
    //   514: new 44	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 945
    //   524: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload_1
    //   528: iconst_0
    //   529: invokevirtual 607	java/lang/String:charAt	(I)C
    //   532: invokevirtual 948	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
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
    //   561: ldc_w 950
    //   564: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload_1
    //   568: invokevirtual 320	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   571: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: new 213	java/util/HashMap
    //   583: dup
    //   584: invokespecial 214	java/util/HashMap:<init>	()V
    //   587: astore_1
    //   588: aload_1
    //   589: ldc_w 324
    //   592: ldc_w 952
    //   595: invokevirtual 330	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   598: pop
    //   599: getstatic 336	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   602: invokevirtual 337	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   605: invokestatic 342	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   608: getstatic 336	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   611: invokevirtual 346	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   614: checkcast 175	com/tencent/mobileqq/app/QQAppInterface
    //   617: invokevirtual 349	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   620: ldc_w 351
    //   623: iconst_0
    //   624: lconst_1
    //   625: lconst_0
    //   626: aload_1
    //   627: ldc_w 262
    //   630: iconst_0
    //   631: invokevirtual 354	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
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
    //   654: new 954	java/io/BufferedOutputStream
    //   657: dup
    //   658: new 956	java/io/FileOutputStream
    //   661: dup
    //   662: aload 7
    //   664: invokespecial 959	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   667: invokespecial 962	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   670: astore 7
    //   672: aload 8
    //   674: getstatic 968	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   677: bipush 90
    //   679: aload 7
    //   681: invokevirtual 972	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   684: pop
    //   685: aload 7
    //   687: invokevirtual 975	java/io/BufferedOutputStream:flush	()V
    //   690: aload 7
    //   692: ifnull +8 -> 700
    //   695: aload 7
    //   697: invokevirtual 978	java/io/BufferedOutputStream:close	()V
    //   700: aload 11
    //   702: monitorexit
    //   703: aload 8
    //   705: astore_1
    //   706: goto -499 -> 207
    //   709: astore_1
    //   710: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   713: iconst_1
    //   714: ldc_w 980
    //   717: aload_1
    //   718: invokestatic 983	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   755: ldc_w 985
    //   758: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: aload 9
    //   763: invokevirtual 357	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   766: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: aload 7
    //   777: ifnull -77 -> 700
    //   780: aload 7
    //   782: invokevirtual 978	java/io/BufferedOutputStream:close	()V
    //   785: goto -85 -> 700
    //   788: astore_1
    //   789: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   792: iconst_1
    //   793: ldc_w 980
    //   796: aload_1
    //   797: invokestatic 983	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   800: goto -100 -> 700
    //   803: astore 8
    //   805: aload_1
    //   806: astore 7
    //   808: aload 8
    //   810: astore_1
    //   811: aload 7
    //   813: ifnull +8 -> 821
    //   816: aload 7
    //   818: invokevirtual 978	java/io/BufferedOutputStream:close	()V
    //   821: aload_1
    //   822: athrow
    //   823: astore 7
    //   825: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   828: iconst_1
    //   829: ldc_w 980
    //   832: aload 7
    //   834: invokestatic 983	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    ThreadManager.post(new zfq(this), 2, null, true);
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
    //   17: ldc_w 1156
    //   20: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: return
    //   24: aload_2
    //   25: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   68: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +20 -> 91
    //   74: aload_0
    //   75: invokevirtual 233	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   78: getfield 696	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   81: invokevirtual 700	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:a	()Ljava/lang/String;
    //   84: aload_3
    //   85: invokevirtual 703	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   88: ifne -65 -> 23
    //   91: aload_2
    //   92: aload_3
    //   93: iload 4
    //   95: iload 6
    //   97: iload 5
    //   99: invokestatic 267	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   102: astore 8
    //   104: aload 8
    //   106: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifeq +19 -> 128
    //   112: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +13 -> 128
    //   118: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   121: iconst_2
    //   122: ldc_w 1158
    //   125: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: new 620	java/io/File
    //   131: dup
    //   132: aload 8
    //   134: invokespecial 740	java/io/File:<init>	(Ljava/lang/String;)V
    //   137: astore_2
    //   138: aload_2
    //   139: invokevirtual 745	java/io/File:exists	()Z
    //   142: ifeq +38 -> 180
    //   145: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq -125 -> 23
    //   151: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   154: iconst_2
    //   155: new 44	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 1160
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
    //   193: invokevirtual 1161	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   196: pop
    //   197: aload_3
    //   198: monitorexit
    //   199: aconst_null
    //   200: astore_3
    //   201: aconst_null
    //   202: astore 7
    //   204: new 954	java/io/BufferedOutputStream
    //   207: dup
    //   208: new 956	java/io/FileOutputStream
    //   211: dup
    //   212: aload_2
    //   213: invokespecial 959	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   216: invokespecial 962	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   219: astore_2
    //   220: aload_2
    //   221: astore_3
    //   222: aload_1
    //   223: getstatic 968	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   226: bipush 90
    //   228: aload_2
    //   229: invokevirtual 972	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   232: pop
    //   233: aload_2
    //   234: astore_3
    //   235: aload_2
    //   236: invokevirtual 975	java/io/BufferedOutputStream:flush	()V
    //   239: aload_2
    //   240: ifnull +7 -> 247
    //   243: aload_2
    //   244: invokevirtual 978	java/io/BufferedOutputStream:close	()V
    //   247: aload_0
    //   248: getfield 173	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   251: astore_1
    //   252: aload_1
    //   253: monitorenter
    //   254: aload_0
    //   255: getfield 173	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   258: aload 8
    //   260: invokevirtual 1164	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
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
    //   282: ldc_w 1166
    //   285: aload_1
    //   286: invokestatic 983	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   316: ldc_w 1168
    //   319: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_1
    //   323: invokevirtual 1169	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   326: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_2
    //   336: ifnull -89 -> 247
    //   339: aload_2
    //   340: invokevirtual 978	java/io/BufferedOutputStream:close	()V
    //   343: goto -96 -> 247
    //   346: astore_1
    //   347: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   350: iconst_1
    //   351: ldc_w 1166
    //   354: aload_1
    //   355: invokestatic 983	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   386: ldc_w 1168
    //   389: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload_2
    //   393: invokevirtual 1049	java/io/IOException:getMessage	()Ljava/lang/String;
    //   396: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: aload_1
    //   406: ifnull -159 -> 247
    //   409: aload_1
    //   410: invokevirtual 978	java/io/BufferedOutputStream:close	()V
    //   413: goto -166 -> 247
    //   416: astore_1
    //   417: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   420: iconst_1
    //   421: ldc_w 1166
    //   424: aload_1
    //   425: invokestatic 983	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   428: goto -181 -> 247
    //   431: astore_1
    //   432: aload_3
    //   433: ifnull +7 -> 440
    //   436: aload_3
    //   437: invokevirtual 978	java/io/BufferedOutputStream:close	()V
    //   440: aload_1
    //   441: athrow
    //   442: astore_2
    //   443: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   446: iconst_1
    //   447: ldc_w 1166
    //   450: aload_2
    //   451: invokestatic 983	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
        localRedPacketInfo = (CustomizeStrategyFactory.RedPacketInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      } while (localRedPacketInfo == null);
      localObject1 = a().a(localRedPacketInfo.templateId, true);
    } while (localObject1 == null);
    label113:
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
                break label309;
              }
              a((Bitmap)localObject2, localRedPacketInfo.templateId, localRedPacketInfo.jdField_a_of_type_JavaLangString, 6);
            }
          }
        }
      }
      for (paramInt = i2;; paramInt = i2)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        if (paramInt == 0) {
          break;
        }
        CustomizeStrategyFactory.a().a(localRedPacketInfo);
        return;
        if (paramInt == 3)
        {
          i1 = 7;
          break label113;
        }
        i1 = paramInt;
        if (paramInt != 14) {
          break label113;
        }
        i1 = 15;
        break label113;
        label309:
        a((Bitmap)localObject2, localRedPacketInfo.templateId, localRedPacketInfo.jdField_a_of_type_JavaLangString, 12);
      }
    }
    if (paramInt == 19)
    {
      localObject2 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
      if ((localObject2 == null) || (((IndividualRedPacketResDownloader.DecorateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig == null)) {
        break label470;
      }
      localObject2 = a(((IndividualRedPacketResDownloader.DecorateInfo)localObject2).jdField_d_of_type_JavaLangString, null, ((IndividualRedPacketResDownloader.DecorateInfo)localObject2).f, ((IndividualRedPacketResDownloader.DecorateInfo)localObject2).jdField_d_of_type_Int, 0);
      File localFile = new File((String)localObject2);
      if ((localFile != null) && (localFile.exists()) && (localFile.isFile())) {
        a((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1, localRedPacketInfo, (String)localObject2, false);
      }
      if (localRedPacketInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig == null) {
        break label470;
      }
    }
    label470:
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
    ThreadManager.post(new zfs(this, paramString1, paramString2, paramBundle, paramMessengerService), 8, null, true);
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