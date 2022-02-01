package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.AnimConfig;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.Char300Info;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.DecorateInfo;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketResInfo;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketTemplateInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
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
  public static int a;
  public static String a;
  public static String c;
  private static String jdField_d_of_type_JavaLangString = "IndividualRedPacketManager";
  public static int k = 0;
  public static int l = -1;
  public static int m = 0;
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
  Comparator<File> jdField_a_of_type_JavaUtilComparator = new IndividualRedPacketManager.3(this);
  LinkedList<String> jdField_a_of_type_JavaUtilLinkedList;
  public ConcurrentHashMap<String, CustomizeStrategyFactory.RedPacketInfo> a;
  public AtomicBoolean a;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int = 0;
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
    jdField_a_of_type_JavaLangString = AppConstants.SDCARD_PATH + "RedPacket/";
    jdField_a_of_type_Int = 10029;
    jdField_c_of_type_JavaLangString = "0";
  }
  
  public IndividualRedPacketManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
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
    ThreadManager.post(new IndividualRedPacketManager.1(this), 8, null, true);
  }
  
  /* Error */
  private Bitmap a(IndividualRedPacketManager.FontBitmap paramFontBitmap, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 240	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   4: aload_2
    //   5: iconst_1
    //   6: invokevirtual 245	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo;
    //   9: astore 9
    //   11: aload 9
    //   13: ifnull +27 -> 40
    //   16: aload 9
    //   18: getfield 250	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   21: ifnull +19 -> 40
    //   24: aload 9
    //   26: getfield 252	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   29: ifnull +11 -> 40
    //   32: aload 9
    //   34: getfield 254	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   37: ifnonnull +42 -> 79
    //   40: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +30 -> 73
    //   46: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   49: iconst_2
    //   50: new 47	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 262
    //   60: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_2
    //   64: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aconst_null
    //   74: astore 11
    //   76: aload 11
    //   78: areturn
    //   79: iload 4
    //   81: bipush 6
    //   83: if_icmpne +139 -> 222
    //   86: aload_2
    //   87: ldc_w 267
    //   90: iconst_2
    //   91: aload 9
    //   93: getfield 268	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_d_of_type_Int	I
    //   96: aload 9
    //   98: getfield 269	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_Int	I
    //   101: invokestatic 272	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   104: astore 10
    //   106: aload_0
    //   107: getfield 132	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   110: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   113: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   116: aload 9
    //   118: getfield 250	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   121: getfield 275	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_Int	I
    //   124: iconst_2
    //   125: idiv
    //   126: i2f
    //   127: invokestatic 280	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   130: istore 6
    //   132: aload_0
    //   133: getfield 88	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_b_of_type_Int	I
    //   136: istore 8
    //   138: aload_0
    //   139: getfield 90	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_c_of_type_Int	I
    //   142: istore 7
    //   144: new 282	android/graphics/Point
    //   147: dup
    //   148: aload_0
    //   149: getfield 132	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   152: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   155: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   158: aload 9
    //   160: getfield 250	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   163: getfield 285	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   166: getfield 290	android/graphics/Rect:left	I
    //   169: iconst_2
    //   170: idiv
    //   171: i2f
    //   172: invokestatic 280	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   175: aload_0
    //   176: getfield 132	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   179: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   182: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   185: aload 9
    //   187: getfield 250	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   190: getfield 285	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   193: getfield 293	android/graphics/Rect:top	I
    //   196: iconst_2
    //   197: idiv
    //   198: i2f
    //   199: invokestatic 280	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   202: invokespecial 296	android/graphics/Point:<init>	(II)V
    //   205: astore_2
    //   206: ldc_w 298
    //   209: astore 9
    //   211: aload 10
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: ifnonnull +276 -> 493
    //   220: aconst_null
    //   221: areturn
    //   222: iload 4
    //   224: bipush 7
    //   226: if_icmpne +131 -> 357
    //   229: aload_2
    //   230: ldc_w 267
    //   233: iconst_3
    //   234: aload 9
    //   236: getfield 268	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_d_of_type_Int	I
    //   239: aload 9
    //   241: getfield 269	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_Int	I
    //   244: invokestatic 272	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   247: astore 10
    //   249: aload_0
    //   250: getfield 132	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   253: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   256: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   259: aload 9
    //   261: getfield 252	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   264: getfield 275	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_Int	I
    //   267: iconst_2
    //   268: idiv
    //   269: i2f
    //   270: invokestatic 280	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   273: istore 6
    //   275: aload_0
    //   276: getfield 92	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_Int	I
    //   279: istore 8
    //   281: aload_0
    //   282: getfield 94	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_e_of_type_Int	I
    //   285: istore 7
    //   287: new 282	android/graphics/Point
    //   290: dup
    //   291: aload_0
    //   292: getfield 132	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   295: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   298: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   301: aload 9
    //   303: getfield 252	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   306: getfield 285	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   309: getfield 290	android/graphics/Rect:left	I
    //   312: iconst_2
    //   313: idiv
    //   314: i2f
    //   315: invokestatic 280	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   318: aload_0
    //   319: getfield 132	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   322: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   325: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   328: aload 9
    //   330: getfield 252	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   333: getfield 285	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   336: getfield 293	android/graphics/Rect:top	I
    //   339: iconst_2
    //   340: idiv
    //   341: i2f
    //   342: invokestatic 280	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   345: invokespecial 296	android/graphics/Point:<init>	(II)V
    //   348: astore_2
    //   349: ldc_w 300
    //   352: astore 9
    //   354: goto -143 -> 211
    //   357: iload 4
    //   359: bipush 15
    //   361: if_icmpne +666 -> 1027
    //   364: aload_2
    //   365: ldc_w 267
    //   368: bipush 14
    //   370: aload 9
    //   372: getfield 268	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_d_of_type_Int	I
    //   375: aload 9
    //   377: getfield 269	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_Int	I
    //   380: invokestatic 272	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   383: astore 10
    //   385: aload_0
    //   386: getfield 132	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   389: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   392: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   395: aload 9
    //   397: getfield 254	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   400: getfield 275	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_Int	I
    //   403: iconst_2
    //   404: idiv
    //   405: i2f
    //   406: invokestatic 280	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   409: istore 6
    //   411: aload_0
    //   412: getfield 96	com/tencent/mobileqq/app/IndividualRedPacketManager:f	I
    //   415: istore 8
    //   417: aload_0
    //   418: getfield 98	com/tencent/mobileqq/app/IndividualRedPacketManager:g	I
    //   421: istore 7
    //   423: new 282	android/graphics/Point
    //   426: dup
    //   427: aload_0
    //   428: getfield 132	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   431: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   434: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   437: aload 9
    //   439: getfield 254	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   442: getfield 285	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   445: getfield 290	android/graphics/Rect:left	I
    //   448: iconst_2
    //   449: idiv
    //   450: i2f
    //   451: invokestatic 280	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   454: aload_0
    //   455: getfield 132	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   458: invokevirtual 186	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   461: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   464: aload 9
    //   466: getfield 254	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo;
    //   469: getfield 285	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$DecorateInfo:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   472: getfield 293	android/graphics/Rect:top	I
    //   475: iconst_2
    //   476: idiv
    //   477: i2f
    //   478: invokestatic 280	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   481: invokespecial 296	android/graphics/Point:<init>	(II)V
    //   484: astore_2
    //   485: ldc_w 302
    //   488: astore 9
    //   490: goto -279 -> 211
    //   493: aload 10
    //   495: aconst_null
    //   496: invokestatic 305	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   499: astore 12
    //   501: aload_1
    //   502: getfield 310	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   505: astore 13
    //   507: aload 12
    //   509: ifnonnull +5 -> 514
    //   512: aconst_null
    //   513: areturn
    //   514: iload 8
    //   516: iload 7
    //   518: getstatic 316	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   521: invokestatic 322	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   524: astore 10
    //   526: aload 10
    //   528: astore 11
    //   530: aload 10
    //   532: ifnull -456 -> 76
    //   535: new 324	android/graphics/RectF
    //   538: dup
    //   539: invokespecial 325	android/graphics/RectF:<init>	()V
    //   542: astore 15
    //   544: new 287	android/graphics/Rect
    //   547: dup
    //   548: invokespecial 326	android/graphics/Rect:<init>	()V
    //   551: astore 16
    //   553: new 328	android/graphics/Paint
    //   556: dup
    //   557: invokespecial 329	android/graphics/Paint:<init>	()V
    //   560: astore 11
    //   562: aload 11
    //   564: iconst_1
    //   565: invokevirtual 332	android/graphics/Paint:setAntiAlias	(Z)V
    //   568: aload 11
    //   570: iconst_1
    //   571: invokevirtual 335	android/graphics/Paint:setDither	(Z)V
    //   574: aload 11
    //   576: iconst_1
    //   577: invokevirtual 338	android/graphics/Paint:setFilterBitmap	(Z)V
    //   580: new 340	android/graphics/Canvas
    //   583: dup
    //   584: aload 10
    //   586: invokespecial 343	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   589: astore 14
    //   591: aload 16
    //   593: iconst_0
    //   594: iconst_0
    //   595: aload 12
    //   597: invokevirtual 347	android/graphics/Bitmap:getWidth	()I
    //   600: aload 12
    //   602: invokevirtual 350	android/graphics/Bitmap:getHeight	()I
    //   605: invokevirtual 353	android/graphics/Rect:set	(IIII)V
    //   608: aload 15
    //   610: fconst_0
    //   611: fconst_0
    //   612: iload 8
    //   614: i2f
    //   615: iload 7
    //   617: i2f
    //   618: invokevirtual 356	android/graphics/RectF:set	(FFFF)V
    //   621: aload 14
    //   623: aload 12
    //   625: aload 16
    //   627: aload 15
    //   629: aload 11
    //   631: invokevirtual 360	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   634: aload 13
    //   636: ifnull +270 -> 906
    //   639: iload 4
    //   641: bipush 7
    //   643: if_icmpne +229 -> 872
    //   646: aload_1
    //   647: getfield 363	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_Boolean	Z
    //   650: ifne +222 -> 872
    //   653: aload 11
    //   655: new 365	android/graphics/LightingColorFilter
    //   658: dup
    //   659: iconst_0
    //   660: ldc_w 366
    //   663: invokespecial 367	android/graphics/LightingColorFilter:<init>	(II)V
    //   666: invokevirtual 371	android/graphics/Paint:setColorFilter	(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    //   669: pop
    //   670: aload 16
    //   672: iconst_0
    //   673: iconst_0
    //   674: aload 13
    //   676: invokevirtual 347	android/graphics/Bitmap:getWidth	()I
    //   679: aload 13
    //   681: invokevirtual 350	android/graphics/Bitmap:getHeight	()I
    //   684: invokevirtual 353	android/graphics/Rect:set	(IIII)V
    //   687: aload 15
    //   689: aload_2
    //   690: getfield 374	android/graphics/Point:x	I
    //   693: i2f
    //   694: aload_2
    //   695: getfield 377	android/graphics/Point:y	I
    //   698: i2f
    //   699: aload_2
    //   700: getfield 374	android/graphics/Point:x	I
    //   703: iload 6
    //   705: iadd
    //   706: i2f
    //   707: aload_2
    //   708: getfield 377	android/graphics/Point:y	I
    //   711: iload 6
    //   713: iadd
    //   714: i2f
    //   715: invokevirtual 356	android/graphics/RectF:set	(FFFF)V
    //   718: aload 14
    //   720: aload 13
    //   722: aload 16
    //   724: aload 15
    //   726: aload 11
    //   728: invokevirtual 360	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   731: aload 10
    //   733: areturn
    //   734: astore_1
    //   735: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   738: ifeq +33 -> 771
    //   741: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   744: iconst_2
    //   745: new 47	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   752: ldc_w 379
    //   755: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload_1
    //   759: invokevirtual 382	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   762: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   768: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   771: new 386	java/util/HashMap
    //   774: dup
    //   775: invokespecial 387	java/util/HashMap:<init>	()V
    //   778: astore_1
    //   779: aload_1
    //   780: ldc_w 389
    //   783: ldc_w 391
    //   786: invokevirtual 395	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   789: pop
    //   790: getstatic 401	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   793: invokevirtual 402	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   796: invokestatic 408	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   799: getstatic 401	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   802: invokevirtual 412	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   805: checkcast 182	com/tencent/mobileqq/app/QQAppInterface
    //   808: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   811: ldc_w 417
    //   814: iconst_0
    //   815: lconst_1
    //   816: lconst_0
    //   817: aload_1
    //   818: ldc_w 267
    //   821: iconst_0
    //   822: invokevirtual 421	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   825: aconst_null
    //   826: areturn
    //   827: astore 10
    //   829: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   832: ifeq +34 -> 866
    //   835: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   838: iconst_2
    //   839: new 47	java/lang/StringBuilder
    //   842: dup
    //   843: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   846: ldc_w 423
    //   849: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: aload 10
    //   854: invokevirtual 424	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   857: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: aconst_null
    //   867: astore 10
    //   869: goto -343 -> 526
    //   872: iload 4
    //   874: bipush 15
    //   876: if_icmpne -206 -> 670
    //   879: aload_1
    //   880: getfield 363	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_Boolean	Z
    //   883: ifne -213 -> 670
    //   886: aload 11
    //   888: new 365	android/graphics/LightingColorFilter
    //   891: dup
    //   892: iconst_0
    //   893: ldc_w 425
    //   896: invokespecial 367	android/graphics/LightingColorFilter:<init>	(II)V
    //   899: invokevirtual 371	android/graphics/Paint:setColorFilter	(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    //   902: pop
    //   903: goto -233 -> 670
    //   906: aload 11
    //   908: aload 9
    //   910: invokestatic 431	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   913: invokevirtual 435	android/graphics/Paint:setColor	(I)V
    //   916: aload 11
    //   918: iload 6
    //   920: i2f
    //   921: ldc_w 436
    //   924: fmul
    //   925: invokevirtual 440	android/graphics/Paint:setTextSize	(F)V
    //   928: iconst_1
    //   929: newarray float
    //   931: astore_1
    //   932: aload 11
    //   934: invokevirtual 444	android/graphics/Paint:getFontMetricsInt	()Landroid/graphics/Paint$FontMetricsInt;
    //   937: astore 9
    //   939: aload 11
    //   941: aload_3
    //   942: aload_1
    //   943: invokevirtual 448	android/graphics/Paint:getTextWidths	(Ljava/lang/String;[F)I
    //   946: pop
    //   947: aload_2
    //   948: getfield 374	android/graphics/Point:x	I
    //   951: i2f
    //   952: fstore 5
    //   954: iload 6
    //   956: i2f
    //   957: aload_1
    //   958: iconst_0
    //   959: faload
    //   960: fsub
    //   961: fconst_2
    //   962: fdiv
    //   963: fload 5
    //   965: fadd
    //   966: f2i
    //   967: istore 4
    //   969: aload_2
    //   970: getfield 377	android/graphics/Point:y	I
    //   973: istore 7
    //   975: aload 9
    //   977: getfield 453	android/graphics/Paint$FontMetricsInt:ascent	I
    //   980: istore 8
    //   982: iload 6
    //   984: aload 9
    //   986: getfield 456	android/graphics/Paint$FontMetricsInt:descent	I
    //   989: aload 9
    //   991: getfield 453	android/graphics/Paint$FontMetricsInt:ascent	I
    //   994: isub
    //   995: isub
    //   996: iconst_2
    //   997: idiv
    //   998: istore 6
    //   1000: aload 14
    //   1002: aload_3
    //   1003: iload 4
    //   1005: i2f
    //   1006: iload 7
    //   1008: iload 8
    //   1010: isub
    //   1011: iload 6
    //   1013: iadd
    //   1014: i2f
    //   1015: aload 11
    //   1017: invokevirtual 460	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1020: aload 10
    //   1022: areturn
    //   1023: astore_1
    //   1024: goto -199 -> 825
    //   1027: aconst_null
    //   1028: astore 10
    //   1030: iconst_0
    //   1031: istore 8
    //   1033: iconst_0
    //   1034: istore 7
    //   1036: iconst_0
    //   1037: istore 6
    //   1039: ldc_w 298
    //   1042: astore 9
    //   1044: aconst_null
    //   1045: astore_2
    //   1046: goto -835 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1049	0	this	IndividualRedPacketManager
    //   0	1049	1	paramFontBitmap	IndividualRedPacketManager.FontBitmap
    //   0	1049	2	paramString1	String
    //   0	1049	3	paramString2	String
    //   0	1049	4	paramInt	int
    //   952	12	5	f1	float
    //   130	908	6	i1	int
    //   142	893	7	i2	int
    //   136	896	8	i3	int
    //   9	1034	9	localObject1	Object
    //   104	628	10	localObject2	Object
    //   827	26	10	localException	Exception
    //   867	162	10	localBitmap1	Bitmap
    //   74	942	11	localObject3	Object
    //   499	125	12	localBitmap2	Bitmap
    //   505	216	13	localBitmap3	Bitmap
    //   589	412	14	localCanvas	android.graphics.Canvas
    //   542	183	15	localRectF	android.graphics.RectF
    //   551	172	16	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   514	526	734	java/lang/OutOfMemoryError
    //   514	526	827	java/lang/Exception
    //   771	825	1023	java/lang/Exception
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
    //   13: getstatic 468	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   16: aload_0
    //   17: invokevirtual 474	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: ifnull +375 -> 395
    //   23: aload 5
    //   25: astore_3
    //   26: aload 6
    //   28: astore 4
    //   30: getstatic 468	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   33: aload_0
    //   34: invokevirtual 474	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 318	android/graphics/Bitmap
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
    //   65: new 476	android/graphics/BitmapFactory$Options
    //   68: dup
    //   69: invokespecial 477	android/graphics/BitmapFactory$Options:<init>	()V
    //   72: astore 6
    //   74: aload_3
    //   75: astore 4
    //   77: aload_3
    //   78: astore 5
    //   80: aload 6
    //   82: getstatic 480	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   85: putfield 483	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   88: aload_3
    //   89: astore 4
    //   91: aload_3
    //   92: astore 5
    //   94: aload_0
    //   95: aload 6
    //   97: invokestatic 488	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   100: astore 7
    //   102: aload_3
    //   103: astore 4
    //   105: aload_3
    //   106: astore 5
    //   108: aload 7
    //   110: getfield 491	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   113: astore_1
    //   114: aload_1
    //   115: astore 4
    //   117: aload_1
    //   118: astore 5
    //   120: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +50 -> 173
    //   126: aload_1
    //   127: astore 4
    //   129: aload_1
    //   130: astore 5
    //   132: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   135: iconst_2
    //   136: new 47	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 493
    //   146: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 495
    //   156: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 7
    //   161: getfield 496	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   164: invokevirtual 499	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_1
    //   174: astore 4
    //   176: aload_1
    //   177: astore 5
    //   179: aload 7
    //   181: getfield 496	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
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
    //   211: putfield 502	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   214: aload_1
    //   215: astore_3
    //   216: aload_1
    //   217: astore 4
    //   219: aload_0
    //   220: aload 6
    //   222: invokestatic 488	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   225: astore 5
    //   227: aload_1
    //   228: astore_3
    //   229: aload_1
    //   230: astore 4
    //   232: aload 5
    //   234: getfield 491	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   237: astore_1
    //   238: aload_1
    //   239: astore_3
    //   240: aload_1
    //   241: astore 4
    //   243: aload 5
    //   245: getfield 496	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   248: iconst_1
    //   249: if_icmpeq +151 -> 400
    //   252: aload_1
    //   253: astore_3
    //   254: aload_1
    //   255: astore 4
    //   257: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +18 -> 278
    //   263: aload_1
    //   264: astore_3
    //   265: aload_1
    //   266: astore 4
    //   268: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   271: iconst_2
    //   272: ldc_w 504
    //   275: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload_1
    //   279: astore_3
    //   280: new 386	java/util/HashMap
    //   283: dup
    //   284: invokespecial 387	java/util/HashMap:<init>	()V
    //   287: astore 4
    //   289: aload_1
    //   290: astore_3
    //   291: getstatic 401	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   294: invokevirtual 402	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   297: invokestatic 408	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   300: getstatic 401	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   303: invokevirtual 412	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   306: checkcast 182	com/tencent/mobileqq/app/QQAppInterface
    //   309: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   312: ldc_w 506
    //   315: iconst_0
    //   316: lconst_1
    //   317: lconst_0
    //   318: aload 4
    //   320: ldc_w 267
    //   323: iconst_0
    //   324: invokevirtual 421	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   327: aload_1
    //   328: astore 4
    //   330: aload 4
    //   332: astore_3
    //   333: new 386	java/util/HashMap
    //   336: dup
    //   337: invokespecial 387	java/util/HashMap:<init>	()V
    //   340: astore_1
    //   341: aload 4
    //   343: astore_3
    //   344: aload_1
    //   345: ldc_w 389
    //   348: ldc 71
    //   350: invokevirtual 395	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   353: pop
    //   354: aload 4
    //   356: astore_3
    //   357: getstatic 401	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   360: invokevirtual 402	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   363: invokestatic 408	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   366: getstatic 401	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   369: invokevirtual 412	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   372: checkcast 182	com/tencent/mobileqq/app/QQAppInterface
    //   375: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   378: ldc_w 508
    //   381: iconst_0
    //   382: lconst_1
    //   383: lconst_0
    //   384: aload_1
    //   385: ldc_w 267
    //   388: iconst_0
    //   389: invokevirtual 421	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
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
    //   412: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +43 -> 458
    //   418: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   421: iconst_2
    //   422: new 47	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 493
    //   432: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_0
    //   436: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: ldc_w 510
    //   442: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_1
    //   446: invokevirtual 382	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   449: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: new 386	java/util/HashMap
    //   461: dup
    //   462: invokespecial 387	java/util/HashMap:<init>	()V
    //   465: astore_0
    //   466: aload_0
    //   467: ldc_w 389
    //   470: ldc_w 512
    //   473: invokevirtual 395	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: pop
    //   477: getstatic 401	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   480: invokevirtual 402	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   483: invokestatic 408	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   486: getstatic 401	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   489: invokevirtual 412	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   492: checkcast 182	com/tencent/mobileqq/app/QQAppInterface
    //   495: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   498: ldc_w 508
    //   501: iconst_0
    //   502: lconst_1
    //   503: lconst_0
    //   504: aload_0
    //   505: ldc_w 267
    //   508: iconst_0
    //   509: invokevirtual 421	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   512: aload_3
    //   513: areturn
    //   514: astore_1
    //   515: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq +43 -> 561
    //   521: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   524: iconst_2
    //   525: new 47	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 493
    //   535: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_0
    //   539: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: ldc_w 514
    //   545: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload_1
    //   549: invokevirtual 424	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   552: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: new 386	java/util/HashMap
    //   564: dup
    //   565: invokespecial 387	java/util/HashMap:<init>	()V
    //   568: astore_0
    //   569: aload_0
    //   570: ldc_w 389
    //   573: ldc_w 512
    //   576: invokevirtual 395	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: pop
    //   580: getstatic 401	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   583: invokevirtual 402	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   586: invokestatic 408	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   589: getstatic 401	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   592: invokevirtual 412	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   595: checkcast 182	com/tencent/mobileqq/app/QQAppInterface
    //   598: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   601: ldc_w 516
    //   604: iconst_0
    //   605: lconst_1
    //   606: lconst_0
    //   607: aload_0
    //   608: ldc_w 267
    //   611: iconst_0
    //   612: invokevirtual 421	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
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
  
  @Nullable
  private static IndividualRedPacketResDownloader.RedPacketTemplateInfo a(IndividualRedPacketManager arg0, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, String paramString1, String paramString2, IndividualRedPacketResDownloader paramIndividualRedPacketResDownloader)
  {
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo2 = paramIndividualRedPacketResDownloader.a(paramString1, true);
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo1;
    if ((localRedPacketTemplateInfo2 != null) && (localRedPacketTemplateInfo2.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo != null) && (localRedPacketTemplateInfo2.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo != null))
    {
      localRedPacketTemplateInfo1 = localRedPacketTemplateInfo2;
      if (localRedPacketTemplateInfo2.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo != null) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "VIPHBStrategy.get not in local map. Id = " + paramString1 + "content = " + paramString2 + "mTemplateInfoMap.size=" + paramIndividualRedPacketResDownloader.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.size());
      }
      ???.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(paramRedPacketInfo.jdField_b_of_type_JavaLangString, paramRedPacketInfo);
      ???.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(paramRedPacketInfo.jdField_b_of_type_JavaLangString + "_tp", paramRedPacketInfo);
    }
    synchronized (paramIndividualRedPacketResDownloader.jdField_a_of_type_JavaUtilMap)
    {
      if (!paramIndividualRedPacketResDownloader.jdField_a_of_type_JavaUtilMap.containsKey(paramString1))
      {
        paramString2 = new ArrayList();
        paramString2.add(paramRedPacketInfo.jdField_b_of_type_JavaLangString);
        paramIndividualRedPacketResDownloader.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
        paramIndividualRedPacketResDownloader.a(16L, paramString1, paramRedPacketInfo.jdField_b_of_type_JavaLangString);
        localRedPacketTemplateInfo1 = null;
        return localRedPacketTemplateInfo1;
      }
      ((List)paramIndividualRedPacketResDownloader.jdField_a_of_type_JavaUtilMap.get(paramString1)).add(paramRedPacketInfo.jdField_b_of_type_JavaLangString);
    }
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
      return VFSAssistantUtils.getSDKPrivatePath(new StringBuilder().append(AppConstants.SDCARD_PATH).append("pddata/vas/").toString()) + "RedPacket/packets/";
    case 2: 
      return VFSAssistantUtils.getSDKPrivatePath(new StringBuilder().append(AppConstants.SDCARD_PATH).append("pddata/vas/").toString()) + "RedPacket/specialFont/";
    case 3: 
      return VFSAssistantUtils.getSDKPrivatePath(new StringBuilder().append(AppConstants.SDCARD_PATH).append("pddata/vas/").toString()) + "RedPacket/font/";
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
          ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8006134", "0X8006134", 0, 0, localQQAppInterface, "1", "", "");
          localObject = paramQQAppInterface;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_d_of_type_JavaLangString, 2, "IndividualRedPacketManager.getMallURL=" + null + ", type:" + paramInt + ", url:" + paramQQAppInterface);
          return paramQQAppInterface;
          localIndividualRedPacketManager = (IndividualRedPacketManager)((QQAppInterface)localObject).getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
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
            ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8006136", "0X8006136", 0, 0, localQQAppInterface, "1", "", "");
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
      str1 = b(paramString2, "", 5);
      continue;
      str1 = b(paramString2, "", 4);
      continue;
      str1 = a(0) + "specialzip";
      continue;
      str1 = a(2) + "specialCharItem.zip";
      continue;
      str1 = a(2) + "config.json";
      continue;
      str1 = a(paramString2, "", "aio");
      continue;
      str1 = a(paramString2, "", "tp");
      continue;
      str1 = a(paramString2, "", "send");
      continue;
      str2 = "_s";
      str1 = a(paramString1, paramString2, paramInt3, "", str2, "aioimg", 6, "_aio_");
      continue;
      str3 = "_s";
      str1 = a(paramString1, paramString2, paramInt3, "", str3, "redenvelopeimg", 7, "_tp_");
      continue;
      str4 = "_s";
      str1 = a(paramString1, paramString2, paramInt3, "", str4, "sendimg", 8, "_send_");
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
  
  private static String a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6)
  {
    if (paramInt1 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int) {
      paramString5 = a(1) + paramString1 + File.separator + paramString5;
    }
    do
    {
      do
      {
        do
        {
          return paramString5;
          paramString5 = paramString3;
        } while (TextUtils.isEmpty(paramString2));
        paramString5 = paramString3;
      } while (paramInt1 != IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int);
      paramString1 = a(paramInt2) + paramString1 + paramString6 + Integer.toHexString(paramString2.charAt(0));
      paramString5 = paramString1;
    } while (paramString4 == null);
    return paramString1 + paramString4;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      paramString2 = a(2) + "images" + File.separator + paramString3 + File.separator + Integer.toHexString(paramString1.charAt(0));
    }
    return paramString2;
  }
  
  private void a(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    int i1;
    if (paramInt == 2) {
      i1 = 6;
    }
    Bitmap localBitmap;
    for (;;)
    {
      IndividualRedPacketManager.FontBitmap localFontBitmap = a(paramRedPacketInfo.jdField_a_of_type_JavaLangString, i1);
      localBitmap = a(localFontBitmap, paramRedPacketInfo, i1);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "onDoneDownloadBG type = " + i1);
      }
      if ((localFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localFontBitmap.jdField_a_of_type_Boolean)) {
        a(localFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap, "", paramRedPacketInfo.jdField_a_of_type_JavaLangString, 5);
      }
      if ((6 == i1) && (localFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap != null) && (localBitmap != null))
      {
        if (localFontBitmap.jdField_b_of_type_Boolean) {
          break;
        }
        a(localBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 6);
      }
      return;
      if (paramInt == 3)
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
    }
    a(localBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 12);
  }
  
  public static void a(AppInterface paramAppInterface, IndividualRedPacketManager paramIndividualRedPacketManager, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if ((paramIndividualRedPacketManager == null) || (paramRedPacketInfo == null)) {
      return;
    }
    for (;;)
    {
      String str1;
      IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo;
      try
      {
        str1 = paramRedPacketInfo.templateId;
        String str2 = paramRedPacketInfo.jdField_a_of_type_JavaLangString;
        paramAppInterface = paramIndividualRedPacketManager.a();
        localRedPacketTemplateInfo = a(paramIndividualRedPacketManager, paramRedPacketInfo, str1, str2, paramAppInterface);
        if (localRedPacketTemplateInfo == null) {
          break;
        }
        if ((!TextUtils.isEmpty(str2)) && (paramAppInterface.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.a().contains(str2)))
        {
          bool = true;
          if (localRedPacketTemplateInfo.jdField_a_of_type_Int != IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int) {
            break label338;
          }
          if (!bool) {
            break label406;
          }
          paramAppInterface = paramIndividualRedPacketManager.a(str1, str2, 12);
          localObject1 = paramAppInterface;
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
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label370;
          }
          if (localRedPacketTemplateInfo.jdField_e_of_type_Int == 1) {
            break label354;
          }
          paramAppInterface = paramIndividualRedPacketManager.a(str2, 6);
          localObject1 = paramIndividualRedPacketManager.a(paramAppInterface, paramRedPacketInfo, 6);
          localAppInterface = paramAppInterface;
          if ((localRedPacketTemplateInfo.jdField_a_of_type_Int != IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int) || (!bool)) {
            break label401;
          }
          paramAppInterface = paramIndividualRedPacketManager.a(str1, str2, 13);
          Object localObject2 = paramAppInterface;
          if (TextUtils.isEmpty(paramAppInterface)) {
            if (!TextUtils.isEmpty(str2))
            {
              localObject2 = paramAppInterface;
              if (!TextUtils.isEmpty(paramIndividualRedPacketManager.a("", str2, 10))) {}
            }
            else
            {
              localObject2 = paramIndividualRedPacketManager.a(str1, str2, 7);
            }
          }
          a(paramIndividualRedPacketManager, paramRedPacketInfo, str2, localRedPacketTemplateInfo, (String)localObject2, 7);
          if (localRedPacketTemplateInfo.jdField_a_of_type_Int != IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int) {
            break label396;
          }
          paramAppInterface = a(paramIndividualRedPacketManager, str1, str2, null, bool);
          a(paramIndividualRedPacketManager, paramRedPacketInfo, str2, localRedPacketTemplateInfo, paramAppInterface, 15);
          a(paramIndividualRedPacketManager, str1, str2, localAppInterface, (Bitmap)localObject1);
          break;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label338:
      if (a(paramIndividualRedPacketManager, paramRedPacketInfo, str1, paramAppInterface, localRedPacketTemplateInfo)) {
        break;
      }
      break label406;
      label354:
      paramAppInterface = new IndividualRedPacketManager.FontBitmap();
      paramAppInterface.c = true;
      continue;
      label370:
      paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = a((String)localObject1, null);
      CustomizeStrategyFactory.a().a(paramRedPacketInfo);
      Object localObject1 = null;
      AppInterface localAppInterface = null;
      continue;
      label396:
      paramAppInterface = null;
      continue;
      label401:
      paramAppInterface = null;
      continue;
      label406:
      paramAppInterface = null;
    }
  }
  
  private void a(IndividualRedPacketManager.FontBitmap paramFontBitmap, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, int paramInt, Bitmap paramBitmap)
  {
    if (paramInt == 6) {
      paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    }
    do
    {
      return;
      if (paramInt == 7)
      {
        if (paramFontBitmap.jdField_b_of_type_Boolean)
        {
          a(paramBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 13);
          return;
        }
        a(paramBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 7);
        return;
      }
    } while (paramInt != 15);
    if (paramFontBitmap.jdField_b_of_type_Boolean)
    {
      a(paramBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 18);
      return;
    }
    a(paramBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.jdField_a_of_type_JavaLangString, 15);
  }
  
  private static void a(IndividualRedPacketManager paramIndividualRedPacketManager, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, String paramString1, IndividualRedPacketResDownloader.RedPacketTemplateInfo paramRedPacketTemplateInfo, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramRedPacketTemplateInfo.jdField_e_of_type_Int == 1) {
        break label34;
      }
      paramString1 = paramIndividualRedPacketManager.a(paramString1, paramInt);
    }
    for (;;)
    {
      paramIndividualRedPacketManager.a(paramString1, paramRedPacketInfo, paramInt);
      return;
      label34:
      paramString1 = new IndividualRedPacketManager.FontBitmap();
      paramString1.c = true;
    }
  }
  
  private static void a(IndividualRedPacketManager paramIndividualRedPacketManager, String paramString1, String paramString2, IndividualRedPacketManager.FontBitmap paramFontBitmap, Bitmap paramBitmap)
  {
    if (paramFontBitmap == null) {}
    do
    {
      return;
      if ((paramFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!paramFontBitmap.jdField_a_of_type_Boolean) && (!paramFontBitmap.c)) {
        paramIndividualRedPacketManager.a(paramFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap, "", paramString2, 5);
      }
    } while ((paramBitmap == null) || ((paramFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap == null) && (!paramFontBitmap.c)));
    if (paramFontBitmap.jdField_b_of_type_Boolean)
    {
      paramIndividualRedPacketManager.a(paramBitmap, paramString1, paramString2, 12);
      return;
    }
    paramIndividualRedPacketManager.a(paramBitmap, paramString1, paramString2, 6);
  }
  
  private boolean a(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, IndividualRedPacketResDownloader.RedPacketTemplateInfo paramRedPacketTemplateInfo, boolean paramBoolean)
  {
    if (paramInt == 19)
    {
      Object localObject = paramRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
      boolean bool = paramBoolean;
      if (localObject != null)
      {
        bool = paramBoolean;
        if (((IndividualRedPacketResDownloader.DecorateInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig != null)
        {
          localObject = a(((IndividualRedPacketResDownloader.DecorateInfo)localObject).jdField_d_of_type_JavaLangString, null, ((IndividualRedPacketResDownloader.DecorateInfo)localObject).f, ((IndividualRedPacketResDownloader.DecorateInfo)localObject).jdField_d_of_type_Int, 0);
          File localFile = new File((String)localObject);
          if ((localFile != null) && (localFile.exists()) && (localFile.isFile())) {
            a(paramRedPacketTemplateInfo, paramRedPacketInfo, (String)localObject, false);
          }
          bool = paramBoolean;
          if (paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig != null) {
            bool = true;
          }
        }
      }
      return bool;
    }
    if (paramInt == 2) {
      paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = a(a(paramRedPacketTemplateInfo.jdField_a_of_type_JavaLangString, "", 6), null);
    }
    return true;
  }
  
  private static boolean a(IndividualRedPacketManager paramIndividualRedPacketManager, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, String paramString, IndividualRedPacketResDownloader paramIndividualRedPacketResDownloader, IndividualRedPacketResDownloader.RedPacketTemplateInfo paramRedPacketTemplateInfo)
  {
    File localFile = null;
    boolean bool2 = false;
    IndividualRedPacketResDownloader.DecorateInfo localDecorateInfo = paramRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
    if ((localDecorateInfo != null) && (localDecorateInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig != null))
    {
      if ((paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig != null) && (!TextUtils.isEmpty(paramRedPacketInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig.jdField_a_of_type_JavaLangString))) {
        CustomizeStrategyFactory.a().a(paramRedPacketInfo);
      }
      do
      {
        return true;
        String str = a(localDecorateInfo.jdField_d_of_type_JavaLangString, null, localDecorateInfo.f, localDecorateInfo.jdField_d_of_type_Int, 0);
        if (!TextUtils.isEmpty(str)) {
          localFile = new File(str);
        }
        if (localFile == null)
        {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "VIPHBStrategy.get animFolderPath file == null, zipPath=" + str);
          return true;
        }
        bool1 = bool2;
        if (!localFile.exists()) {
          break;
        }
        bool1 = bool2;
        if (!localFile.isFile()) {
          break;
        }
        bool1 = a(paramRedPacketTemplateInfo, paramRedPacketInfo, str, false);
        if ((QLog.isColorLevel()) || (!bool1)) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "VIPHBStrategy.get animFolderPath getPathOk=" + bool1 + ", zipPath=" + str);
        }
      } while (bool1);
      boolean bool1 = true;
      paramIndividualRedPacketManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(paramRedPacketInfo.jdField_b_of_type_JavaLangString, paramRedPacketInfo);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "wait animConfig id = " + paramString + ", exist = " + bool1 + ", name=" + localDecorateInfo.jdField_c_of_type_JavaLangString);
      }
      paramIndividualRedPacketResDownloader.a(16L, paramString, paramRedPacketInfo.jdField_b_of_type_JavaLangString);
      return true;
    }
    return false;
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
  
  private boolean a(String paramString, int paramInt, IndividualRedPacketManager.FontBitmap paramFontBitmap)
  {
    boolean bool = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getResources().getAssets();
    if (6 == paramInt) {}
    for (;;)
    {
      try
      {
        localObject = ((AssetManager)localObject).open("specialFont/aio/" + Integer.toHexString(paramString.charAt(0)));
        paramFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeStream((InputStream)localObject);
        paramFontBitmap.jdField_b_of_type_Boolean = true;
        ((InputStream)localObject).close();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg success! Special char = " + paramString);
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg assets oom:" + paramString.getMessage());
        return false;
      }
      catch (IOException paramString)
      {
        if (!QLog.isColorLevel()) {
          break label272;
        }
        QLog.d(jdField_d_of_type_JavaLangString, 2, paramString.getMessage());
        return false;
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          break label272;
        }
        QLog.d(jdField_d_of_type_JavaLangString, 2, paramString.getMessage());
        return false;
        bool = true;
      }
      if (7 == paramInt) {
        localObject = ((AssetManager)localObject).open("specialFont/tp/" + Integer.toHexString(paramString.charAt(0)));
      } else {
        localObject = ((AssetManager)localObject).open("specialFont/send/" + Integer.toHexString(paramString.charAt(0)));
      }
    }
    label272:
    return bool;
  }
  
  private static String b(String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      paramString2 = a(paramInt) + Integer.toHexString(paramString1.charAt(0));
    }
    return paramString2;
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
        break label619;
      }
      a(paramFontBitmap, paramRedPacketInfo, paramInt, (Bitmap)localObject);
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
      label619:
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
    //   9: getfield 167	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   12: astore 11
    //   14: aload 11
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 175	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   21: invokevirtual 982	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   24: ifne +118 -> 142
    //   27: aload_0
    //   28: getfield 175	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   31: iconst_1
    //   32: invokevirtual 173	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   35: invokestatic 951	java/lang/System:currentTimeMillis	()J
    //   38: lstore_3
    //   39: aload_0
    //   40: getfield 167	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   43: iconst_1
    //   44: ldc_w 983
    //   47: invokevirtual 987	com/etrump/mixlayout/ETEngine:initEngine	(II)Z
    //   50: ifeq +161 -> 211
    //   53: aload_0
    //   54: invokevirtual 240	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   57: getfield 990	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   60: invokestatic 960	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   63: ifeq +24 -> 87
    //   66: aload_0
    //   67: getfield 167	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   70: aconst_null
    //   71: aconst_null
    //   72: bipush 8
    //   74: iconst_0
    //   75: iconst_0
    //   76: invokestatic 272	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   79: getstatic 69	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_Int	I
    //   82: iconst_1
    //   83: invokevirtual 994	com/etrump/mixlayout/ETEngine:native_loadFont	(Ljava/lang/String;IZ)Z
    //   86: pop
    //   87: aload_0
    //   88: getfield 170	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   91: iconst_1
    //   92: invokevirtual 173	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   95: invokestatic 951	java/lang/System:currentTimeMillis	()J
    //   98: lstore 5
    //   100: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +39 -> 142
    //   106: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   109: iconst_2
    //   110: new 47	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 996
    //   120: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: lload 5
    //   125: lload_3
    //   126: lsub
    //   127: invokevirtual 999	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: ldc_w 1001
    //   133: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_0
    //   143: getfield 170	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   146: invokevirtual 982	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   149: ifeq +10 -> 159
    //   152: aload_1
    //   153: invokestatic 608	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifeq +150 -> 306
    //   159: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   162: iconst_1
    //   163: new 47	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 1003
    //   173: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 170	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   180: invokevirtual 982	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   183: invokevirtual 821	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: ldc_w 1005
    //   189: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_1
    //   193: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload 11
    //   204: monitorexit
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_1
    //   210: areturn
    //   211: aload_0
    //   212: getfield 167	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   215: getfield 1008	com/etrump/mixlayout/ETEngine:isEngineInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   218: iconst_0
    //   219: iconst_1
    //   220: invokevirtual 1012	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   223: ifeq +7 -> 230
    //   226: invokestatic 1016	com/etrump/mixlayout/FontSoLoader:c	()Z
    //   229: pop
    //   230: aload_0
    //   231: getfield 170	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   234: iconst_0
    //   235: invokevirtual 173	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   238: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   241: iconst_1
    //   242: ldc_w 1018
    //   245: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: goto -106 -> 142
    //   251: astore 7
    //   253: aload_0
    //   254: getfield 170	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   257: iconst_0
    //   258: invokevirtual 173	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   261: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   264: iconst_1
    //   265: new 47	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 1020
    //   275: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 7
    //   280: invokevirtual 1021	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   283: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   307: invokevirtual 240	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   310: getfield 990	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;
    //   313: invokestatic 960	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   316: ifne +21 -> 337
    //   319: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   322: iconst_1
    //   323: ldc_w 1023
    //   326: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload 11
    //   331: monitorexit
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -127 -> 207
    //   337: aload_0
    //   338: getfield 1025	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   341: ifnonnull +32 -> 373
    //   344: aload_0
    //   345: new 1027	com/etrump/mixlayout/ETFont
    //   348: dup
    //   349: getstatic 69	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_Int	I
    //   352: aconst_null
    //   353: ldc_w 267
    //   356: bipush 8
    //   358: iconst_0
    //   359: iconst_0
    //   360: invokestatic 272	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   363: aload_0
    //   364: getfield 86	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_Float	F
    //   367: invokespecial 1030	com/etrump/mixlayout/ETFont:<init>	(ILjava/lang/String;F)V
    //   370: putfield 1025	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   373: aload_0
    //   374: getfield 1025	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   377: ldc_w 1032
    //   380: invokestatic 431	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   383: invokevirtual 1033	com/etrump/mixlayout/ETFont:setColor	(I)V
    //   386: iload_2
    //   387: ifeq +41 -> 428
    //   390: ldc_w 267
    //   393: aload_1
    //   394: iconst_4
    //   395: iconst_0
    //   396: iconst_0
    //   397: invokestatic 272	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   400: astore 7
    //   402: aload 7
    //   404: invokestatic 608	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   407: ifeq +36 -> 443
    //   410: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   413: iconst_1
    //   414: ldc_w 1035
    //   417: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload 11
    //   422: monitorexit
    //   423: aconst_null
    //   424: astore_1
    //   425: goto -218 -> 207
    //   428: ldc_w 267
    //   431: aload_1
    //   432: iconst_5
    //   433: iconst_0
    //   434: iconst_0
    //   435: invokestatic 272	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   438: astore 7
    //   440: goto -38 -> 402
    //   443: new 717	java/io/File
    //   446: dup
    //   447: aload 7
    //   449: invokespecial 800	java/io/File:<init>	(Ljava/lang/String;)V
    //   452: astore 7
    //   454: aload_0
    //   455: getfield 86	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_Float	F
    //   458: f2i
    //   459: aload_0
    //   460: getfield 86	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_Float	F
    //   463: f2i
    //   464: getstatic 316	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   467: invokestatic 322	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   470: astore 8
    //   472: aload_0
    //   473: getfield 167	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   476: aload_1
    //   477: iconst_0
    //   478: invokevirtual 728	java/lang/String:charAt	(I)C
    //   481: aload_0
    //   482: getfield 1025	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   485: invokevirtual 1039	com/etrump/mixlayout/ETEngine:native_isPaintableChar	(CLcom/etrump/mixlayout/ETFont;)Z
    //   488: ifeq +22 -> 510
    //   491: aload_0
    //   492: getfield 167	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   495: aload_1
    //   496: aload 8
    //   498: iconst_0
    //   499: iconst_0
    //   500: aload_0
    //   501: getfield 1025	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComEtrumpMixlayoutETFont	Lcom/etrump/mixlayout/ETFont;
    //   504: invokevirtual 1043	com/etrump/mixlayout/ETEngine:native_drawText	(Ljava/lang/String;Landroid/graphics/Bitmap;IILcom/etrump/mixlayout/ETFont;)Z
    //   507: ifne +135 -> 642
    //   510: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   513: iconst_1
    //   514: new 47	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 1045
    //   524: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload_1
    //   528: iconst_0
    //   529: invokevirtual 728	java/lang/String:charAt	(I)C
    //   532: invokevirtual 1048	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   535: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: aload 11
    //   543: monitorexit
    //   544: aconst_null
    //   545: astore_1
    //   546: goto -339 -> 207
    //   549: astore_1
    //   550: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   553: iconst_1
    //   554: new 47	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 1050
    //   564: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload_1
    //   568: invokevirtual 382	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   571: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 384	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: new 386	java/util/HashMap
    //   583: dup
    //   584: invokespecial 387	java/util/HashMap:<init>	()V
    //   587: astore_1
    //   588: aload_1
    //   589: ldc_w 389
    //   592: ldc_w 1052
    //   595: invokevirtual 395	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   598: pop
    //   599: getstatic 401	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   602: invokevirtual 402	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   605: invokestatic 408	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   608: getstatic 401	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   611: invokevirtual 412	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   614: checkcast 182	com/tencent/mobileqq/app/QQAppInterface
    //   617: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   620: ldc_w 417
    //   623: iconst_0
    //   624: lconst_1
    //   625: lconst_0
    //   626: aload_1
    //   627: ldc_w 267
    //   630: iconst_0
    //   631: invokevirtual 421	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
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
    //   654: new 1054	java/io/BufferedOutputStream
    //   657: dup
    //   658: new 1056	java/io/FileOutputStream
    //   661: dup
    //   662: aload 7
    //   664: invokespecial 1059	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   667: invokespecial 1062	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   670: astore 7
    //   672: aload 8
    //   674: getstatic 1068	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   677: bipush 90
    //   679: aload 7
    //   681: invokevirtual 1072	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   684: pop
    //   685: aload 7
    //   687: invokevirtual 1075	java/io/BufferedOutputStream:flush	()V
    //   690: aload 7
    //   692: ifnull +8 -> 700
    //   695: aload 7
    //   697: invokevirtual 1076	java/io/BufferedOutputStream:close	()V
    //   700: aload 11
    //   702: monitorexit
    //   703: aload 8
    //   705: astore_1
    //   706: goto -499 -> 207
    //   709: astore_1
    //   710: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   713: iconst_1
    //   714: ldc_w 1078
    //   717: aload_1
    //   718: invokestatic 1081	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   721: goto -21 -> 700
    //   724: astore_1
    //   725: aload 9
    //   727: astore 7
    //   729: aload_1
    //   730: astore 9
    //   732: aload 7
    //   734: astore_1
    //   735: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   738: ifeq +37 -> 775
    //   741: aload 7
    //   743: astore_1
    //   744: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   747: iconst_2
    //   748: new 47	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   755: ldc_w 1083
    //   758: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: aload 9
    //   763: invokevirtual 424	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   766: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: aload 7
    //   777: ifnull -77 -> 700
    //   780: aload 7
    //   782: invokevirtual 1076	java/io/BufferedOutputStream:close	()V
    //   785: goto -85 -> 700
    //   788: astore_1
    //   789: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   792: iconst_1
    //   793: ldc_w 1078
    //   796: aload_1
    //   797: invokestatic 1081	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   800: goto -100 -> 700
    //   803: astore 8
    //   805: aload_1
    //   806: astore 7
    //   808: aload 8
    //   810: astore_1
    //   811: aload 7
    //   813: ifnull +8 -> 821
    //   816: aload 7
    //   818: invokevirtual 1076	java/io/BufferedOutputStream:close	()V
    //   821: aload_1
    //   822: athrow
    //   823: astore 7
    //   825: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   828: iconst_1
    //   829: ldc_w 1078
    //   832: aload 7
    //   834: invokestatic 1081	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    Object localObject3 = a("", paramString, 4, 0, 0);
    for (Object localObject2 = new File((String)localObject3);; localObject2 = localObject3)
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
        {
          if (((File)localObject2).exists())
          {
            localObject1 = localObject3;
            if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(localObject3)) {}
          }
          else
          {
            String str = a("", paramString, 5, 0, 0);
            localObject3 = new File(str);
            if (!((File)localObject3).exists()) {
              break label600;
            }
            localObject2 = localObject3;
            localObject1 = str;
            if (this.jdField_a_of_type_JavaUtilLinkedList.contains(str)) {
              break label600;
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            ((File)localObject2).setLastModified(System.currentTimeMillis());
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
            if ((!TextUtils.isEmpty("")) || (!"".contains(paramString)) || (!a(paramString, paramInt, localFontBitmap))) {
              break;
            }
            return localFontBitmap;
          }
        }
        localFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap = a(paramString, false);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "getPersonalFontImg create success time-consuming = " + (l2 - l1) + "ms");
        }
      }
      label600:
      localObject1 = null;
    }
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
    ThreadManager.post(new IndividualRedPacketManager.2(this), 2, null, true);
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
    //   7: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +13 -> 23
    //   13: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   16: iconst_2
    //   17: ldc_w 1224
    //   20: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: return
    //   24: aload_2
    //   25: invokestatic 608	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +445 -> 473
    //   31: aload_0
    //   32: invokevirtual 240	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   35: aload_2
    //   36: iconst_1
    //   37: invokevirtual 245	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo;
    //   40: astore 7
    //   42: aload 7
    //   44: ifnull +429 -> 473
    //   47: aload 7
    //   49: getfield 268	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_d_of_type_Int	I
    //   52: istore 6
    //   54: aload 7
    //   56: getfield 269	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketTemplateInfo:jdField_a_of_type_Int	I
    //   59: istore 5
    //   61: iload 4
    //   63: iconst_5
    //   64: if_icmpne +27 -> 91
    //   67: aload_3
    //   68: invokestatic 608	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +20 -> 91
    //   74: aload_0
    //   75: invokevirtual 240	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   78: getfield 758	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   81: invokevirtual 762	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:a	()Ljava/lang/String;
    //   84: aload_3
    //   85: invokevirtual 765	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   88: ifne -65 -> 23
    //   91: aload_2
    //   92: aload_3
    //   93: iload 4
    //   95: iload 6
    //   97: iload 5
    //   99: invokestatic 272	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   102: astore 8
    //   104: aload 8
    //   106: invokestatic 608	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifeq +19 -> 128
    //   112: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +13 -> 128
    //   118: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   121: iconst_2
    //   122: ldc_w 1226
    //   125: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: new 717	java/io/File
    //   131: dup
    //   132: aload 8
    //   134: invokespecial 800	java/io/File:<init>	(Ljava/lang/String;)V
    //   137: astore_2
    //   138: aload_2
    //   139: invokevirtual 803	java/io/File:exists	()Z
    //   142: ifeq +38 -> 180
    //   145: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq -125 -> 23
    //   151: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   154: iconst_2
    //   155: new 47	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 1228
    //   165: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 8
    //   170: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: return
    //   180: aload_0
    //   181: getfield 180	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   184: astore_3
    //   185: aload_3
    //   186: monitorenter
    //   187: aload_0
    //   188: getfield 180	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   191: aload 8
    //   193: invokevirtual 1229	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   196: pop
    //   197: aload_3
    //   198: monitorexit
    //   199: aconst_null
    //   200: astore_3
    //   201: aconst_null
    //   202: astore 7
    //   204: new 1054	java/io/BufferedOutputStream
    //   207: dup
    //   208: new 1056	java/io/FileOutputStream
    //   211: dup
    //   212: aload_2
    //   213: invokespecial 1059	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   216: invokespecial 1062	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   219: astore_2
    //   220: aload_2
    //   221: astore_3
    //   222: aload_1
    //   223: getstatic 1068	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   226: bipush 90
    //   228: aload_2
    //   229: invokevirtual 1072	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   232: pop
    //   233: aload_2
    //   234: astore_3
    //   235: aload_2
    //   236: invokevirtual 1075	java/io/BufferedOutputStream:flush	()V
    //   239: aload_2
    //   240: ifnull +7 -> 247
    //   243: aload_2
    //   244: invokevirtual 1076	java/io/BufferedOutputStream:close	()V
    //   247: aload_0
    //   248: getfield 180	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   251: astore_1
    //   252: aload_1
    //   253: monitorenter
    //   254: aload_0
    //   255: getfield 180	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   258: aload 8
    //   260: invokevirtual 1232	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
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
    //   278: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   281: iconst_1
    //   282: ldc_w 1234
    //   285: aload_1
    //   286: invokestatic 1081	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   289: goto -42 -> 247
    //   292: astore_1
    //   293: aconst_null
    //   294: astore_2
    //   295: aload_2
    //   296: astore_3
    //   297: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +35 -> 335
    //   303: aload_2
    //   304: astore_3
    //   305: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   308: iconst_2
    //   309: new 47	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 1236
    //   319: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_1
    //   323: invokevirtual 1237	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   326: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_2
    //   336: ifnull -89 -> 247
    //   339: aload_2
    //   340: invokevirtual 1076	java/io/BufferedOutputStream:close	()V
    //   343: goto -96 -> 247
    //   346: astore_1
    //   347: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   350: iconst_1
    //   351: ldc_w 1234
    //   354: aload_1
    //   355: invokestatic 1081	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: goto -111 -> 247
    //   361: astore_2
    //   362: aload 7
    //   364: astore_1
    //   365: aload_1
    //   366: astore_3
    //   367: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq +35 -> 405
    //   373: aload_1
    //   374: astore_3
    //   375: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   378: iconst_2
    //   379: new 47	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   386: ldc_w 1236
    //   389: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload_2
    //   393: invokevirtual 935	java/io/IOException:getMessage	()Ljava/lang/String;
    //   396: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: aload_1
    //   406: ifnull -159 -> 247
    //   409: aload_1
    //   410: invokevirtual 1076	java/io/BufferedOutputStream:close	()V
    //   413: goto -166 -> 247
    //   416: astore_1
    //   417: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   420: iconst_1
    //   421: ldc_w 1234
    //   424: aload_1
    //   425: invokestatic 1081	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   428: goto -181 -> 247
    //   431: astore_1
    //   432: aload_3
    //   433: ifnull +7 -> 440
    //   436: aload_3
    //   437: invokevirtual 1076	java/io/BufferedOutputStream:close	()V
    //   440: aload_1
    //   441: athrow
    //   442: astore_2
    //   443: getstatic 45	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   446: iconst_1
    //   447: ldc_w 1234
    //   450: aload_2
    //   451: invokestatic 1081	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    boolean bool = false;
    if (TextUtils.isEmpty(paramString)) {}
    CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo;
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo;
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
      localRedPacketTemplateInfo = a().a(localRedPacketInfo.templateId, true);
    } while (localRedPacketTemplateInfo == null);
    if (localRedPacketTemplateInfo.jdField_a_of_type_Int == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int) {
      a(paramInt, localRedPacketInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      if (!bool) {
        break;
      }
      CustomizeStrategyFactory.a().a(localRedPacketInfo);
      return;
      bool = a(paramInt, localRedPacketInfo, localRedPacketTemplateInfo, false);
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
    ThreadManager.post(new IndividualRedPacketManager.4(this, paramString1, paramString2, paramBundle, paramMessengerService), 8, null, true);
  }
  
  void a(boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager
 * JD-Core Version:    0.7.0.1
 */