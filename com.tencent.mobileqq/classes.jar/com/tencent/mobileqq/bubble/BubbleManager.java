package com.tencent.mobileqq.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BubbleManager
  implements Manager
{
  public static volatile int a = 0;
  public static long a = 1000L;
  public static volatile boolean a;
  float jdField_a_of_type_Float;
  protected Context a;
  protected AppInterface a;
  QQLruCache<Integer, JSONObject> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache;
  protected BubbleManager.BubbleInfoLruCache a;
  public BubbleManager.LruLinkedHashMap<Integer, BubbleConfig> a;
  public final BubbleUnRead a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  IPCDownloadListener jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  Map<Integer, Float> jdField_a_of_type_JavaUtilMap;
  protected Vector<Integer> a;
  public ConcurrentHashMap<String, AnimationConfig> a;
  private int b;
  public ConcurrentHashMap<String, BubbleNewAnimConf> b;
  
  public BubbleManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache = null;
    this.jdField_a_of_type_JavaUtilVector = null;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap = null;
    float f = 1.0F;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2015, 100);
    this.jdField_b_of_type_Int = 2000000;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleUnRead = new BubbleUnRead(this);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new BubbleManager.1(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache = new BubbleManager.BubbleInfoLruCache(this, 2010, 50, 10);
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap = new BubbleManager.LruLinkedHashMap(this, 9);
    paramAppInterface = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    if (paramAppInterface.density != 160.0F) {
      f = paramAppInterface.density;
    }
    this.jdField_a_of_type_Float = f;
    this.jdField_a_of_type_JavaUtilVector = new Vector(16);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  private int a(String paramString, int paramInt)
  {
    int i = a(paramString);
    if (paramInt == 0) {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), Float.valueOf(1.0F));
    } else {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), Float.valueOf(2.0F));
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramString))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(" download completed, remove from download queue.");
          QLog.d("BubbleManager", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
      }
      return i;
    }
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("T")) {
        return a(paramBoolean, 3, 4);
      }
      if (paramString.equals("L")) {
        return a(paramBoolean, 2, 7);
      }
      if (paramString.equals("TL")) {
        return a(paramBoolean, 0, 5);
      }
      if (paramString.equals("B")) {
        return a(paramBoolean, 4, 3);
      }
      if (paramString.equals("BL")) {
        return a(paramBoolean, 1, 6);
      }
      if (paramString.equals("R")) {
        return a(paramBoolean, 7, 2);
      }
      if (paramString.equals("TR")) {
        return a(paramBoolean, 5, 0);
      }
      if (paramString.equals("BR")) {
        return a(paramBoolean, 6, 1);
      }
    }
    return -1;
  }
  
  private int a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  /* Error */
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 237	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 240	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: new 242	java/io/BufferedInputStream
    //   15: dup
    //   16: aload_3
    //   17: invokespecial 245	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore 5
    //   22: aload_1
    //   23: ifnull +22 -> 45
    //   26: aload_3
    //   27: astore_2
    //   28: aload 5
    //   30: astore 4
    //   32: aload 5
    //   34: aconst_null
    //   35: aload_1
    //   36: invokestatic 251	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   39: astore_1
    //   40: aload_1
    //   41: astore_0
    //   42: goto +17 -> 59
    //   45: aload_3
    //   46: astore_2
    //   47: aload 5
    //   49: astore 4
    //   51: aload 5
    //   53: invokestatic 254	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   56: astore_1
    //   57: aload_1
    //   58: astore_0
    //   59: aload_0
    //   60: astore_2
    //   61: aload_3
    //   62: invokevirtual 259	java/io/InputStream:close	()V
    //   65: aload 5
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 259	java/io/InputStream:close	()V
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: aload 5
    //   77: astore_1
    //   78: aload_2
    //   79: astore 5
    //   81: goto +47 -> 128
    //   84: astore_1
    //   85: aload 5
    //   87: astore_0
    //   88: goto +126 -> 214
    //   91: astore_0
    //   92: aconst_null
    //   93: astore 4
    //   95: aload_3
    //   96: astore_2
    //   97: goto +197 -> 294
    //   100: astore 5
    //   102: aconst_null
    //   103: astore_1
    //   104: goto +24 -> 128
    //   107: astore_1
    //   108: aconst_null
    //   109: astore_0
    //   110: goto +104 -> 214
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_2
    //   116: aload_2
    //   117: astore 4
    //   119: goto +175 -> 294
    //   122: astore 5
    //   124: aconst_null
    //   125: astore_3
    //   126: aload_3
    //   127: astore_1
    //   128: aload_3
    //   129: astore_2
    //   130: aload_1
    //   131: astore 4
    //   133: new 177	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   140: astore 7
    //   142: aload_3
    //   143: astore_2
    //   144: aload_1
    //   145: astore 4
    //   147: aload 7
    //   149: ldc_w 261
    //   152: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_3
    //   157: astore_2
    //   158: aload_1
    //   159: astore 4
    //   161: aload 7
    //   163: aload_0
    //   164: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_3
    //   169: astore_2
    //   170: aload_1
    //   171: astore 4
    //   173: ldc 186
    //   175: iconst_1
    //   176: aload 7
    //   178: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: aload 5
    //   183: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   186: aload_3
    //   187: ifnull +10 -> 197
    //   190: aload_3
    //   191: invokevirtual 259	java/io/InputStream:close	()V
    //   194: goto +3 -> 197
    //   197: aload_1
    //   198: ifnull +93 -> 291
    //   201: aload 6
    //   203: astore_2
    //   204: aload_1
    //   205: astore_0
    //   206: goto -138 -> 68
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_3
    //   212: aload_3
    //   213: astore_0
    //   214: aload_3
    //   215: astore_2
    //   216: aload_0
    //   217: astore 4
    //   219: new 177	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   226: astore 5
    //   228: aload_3
    //   229: astore_2
    //   230: aload_0
    //   231: astore 4
    //   233: aload 5
    //   235: ldc_w 267
    //   238: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_3
    //   243: astore_2
    //   244: aload_0
    //   245: astore 4
    //   247: aload 5
    //   249: aload_1
    //   250: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_3
    //   255: astore_2
    //   256: aload_0
    //   257: astore 4
    //   259: ldc 186
    //   261: iconst_1
    //   262: aload 5
    //   264: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aload_3
    //   271: ifnull +10 -> 281
    //   274: aload_3
    //   275: invokevirtual 259	java/io/InputStream:close	()V
    //   278: goto +3 -> 281
    //   281: aload_0
    //   282: ifnull +9 -> 291
    //   285: aload 6
    //   287: astore_2
    //   288: goto -220 -> 68
    //   291: aconst_null
    //   292: areturn
    //   293: astore_0
    //   294: aload_2
    //   295: ifnull +10 -> 305
    //   298: aload_2
    //   299: invokevirtual 259	java/io/InputStream:close	()V
    //   302: goto +3 -> 305
    //   305: aload 4
    //   307: ifnull +8 -> 315
    //   310: aload 4
    //   312: invokevirtual 259	java/io/InputStream:close	()V
    //   315: goto +5 -> 320
    //   318: aload_0
    //   319: athrow
    //   320: goto -2 -> 318
    //   323: astore_0
    //   324: aload 5
    //   326: astore_0
    //   327: goto -259 -> 68
    //   330: astore_0
    //   331: aload_2
    //   332: areturn
    //   333: astore_0
    //   334: goto -137 -> 197
    //   337: astore_1
    //   338: goto -57 -> 281
    //   341: astore_1
    //   342: goto -37 -> 305
    //   345: astore_1
    //   346: goto -31 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramString	String
    //   0	349	1	paramOptions	BitmapFactory.Options
    //   27	46	2	localObject1	Object
    //   74	5	2	localOutOfMemoryError1	OutOfMemoryError
    //   96	236	2	localObject2	Object
    //   11	264	3	localFileInputStream	java.io.FileInputStream
    //   30	281	4	localObject3	Object
    //   20	66	5	localObject4	Object
    //   100	1	5	localOutOfMemoryError2	OutOfMemoryError
    //   122	60	5	localOutOfMemoryError3	OutOfMemoryError
    //   226	99	5	localStringBuilder1	StringBuilder
    //   1	285	6	localObject5	Object
    //   140	37	7	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   32	40	74	java/lang/OutOfMemoryError
    //   51	57	74	java/lang/OutOfMemoryError
    //   32	40	84	java/lang/Exception
    //   51	57	84	java/lang/Exception
    //   12	22	91	finally
    //   12	22	100	java/lang/OutOfMemoryError
    //   12	22	107	java/lang/Exception
    //   3	12	113	finally
    //   3	12	122	java/lang/OutOfMemoryError
    //   3	12	209	java/lang/Exception
    //   32	40	293	finally
    //   51	57	293	finally
    //   133	142	293	finally
    //   147	156	293	finally
    //   161	168	293	finally
    //   173	186	293	finally
    //   219	228	293	finally
    //   233	242	293	finally
    //   247	254	293	finally
    //   259	270	293	finally
    //   61	65	323	java/io/IOException
    //   68	72	330	java/io/IOException
    //   190	194	333	java/io/IOException
    //   274	278	337	java/io/IOException
    //   298	302	341	java/io/IOException
    //   310	315	345	java/io/IOException
  }
  
  private Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect();
    float f1 = paramInt1 / 2.0F;
    float f2 = this.jdField_a_of_type_Float;
    localRect.set((int)(f1 * f2), (int)(paramInt2 / 2.0F * f2), (int)(paramInt3 / 2.0F * f2), (int)(paramInt4 / 2.0F * f2));
    return localRect;
  }
  
  private AnimationConfig.AnimationStep a(String paramString, JSONObject paramJSONObject)
  {
    paramString = new AnimationConfig.AnimationStep();
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseEachStepAttrInPathAnim jsonObject = null");
      return null;
    }
    if (paramJSONObject.has("count")) {
      paramString.jdField_a_of_type_Int = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("cycle_count")) {
      paramString.jdField_b_of_type_Int = paramJSONObject.getInt("cycle_count");
    }
    if (paramJSONObject.has("prefix_name")) {
      paramString.jdField_a_of_type_JavaLangString = paramJSONObject.getString("prefix_name");
    }
    return paramString;
  }
  
  private AnimationConfig a(int paramInt, BubbleConfig paramBubbleConfig, AnimationConfig paramAnimationConfig)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 5) {
          return paramAnimationConfig;
        }
        return paramBubbleConfig.jdField_f_of_type_ComTencentMobileqqBubbleAnimationConfig;
      }
      paramBubbleConfig = paramBubbleConfig.jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig;
      AnimationConfig.a(paramBubbleConfig);
      return paramBubbleConfig;
    }
    return paramBubbleConfig.jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig;
  }
  
  private AnimationConfig a(int paramInt, JSONObject paramJSONObject)
  {
    AnimationConfig localAnimationConfig = new AnimationConfig();
    localAnimationConfig.jdField_a_of_type_Int = paramInt;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseCommonAnimationConfig animation = null");
      return null;
    }
    b(paramJSONObject, localAnimationConfig);
    if (paramJSONObject.has("cycle_count")) {
      localAnimationConfig.jdField_b_of_type_Int = paramJSONObject.getInt("cycle_count");
    }
    if (paramJSONObject.has("count")) {
      localAnimationConfig.jdField_c_of_type_Int = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("zip_name")) {
      localAnimationConfig.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zip_name");
    }
    if (paramJSONObject.has("second_zip_name")) {
      localAnimationConfig.jdField_c_of_type_JavaLangString = paramJSONObject.getString("second_zip_name");
    }
    if (paramJSONObject.has("align")) {
      localAnimationConfig.jdField_d_of_type_JavaLangString = paramJSONObject.getString("align");
    }
    if (paramJSONObject.has("alpha")) {
      localAnimationConfig.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("alpha");
    }
    if (paramJSONObject.has("displayChartlet")) {
      localAnimationConfig.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("displayChartlet");
    }
    if (paramJSONObject.has("mirror")) {
      localAnimationConfig.jdField_c_of_type_Boolean = paramJSONObject.getBoolean("mirror");
    }
    a(localAnimationConfig, paramJSONObject);
    localAnimationConfig.jdField_d_of_type_Int = paramJSONObject.getInt("time");
    return localAnimationConfig;
  }
  
  private AnimationConfig a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseBubbleFrameAnimationConfig object = null");
      return null;
    }
    AnimationConfig localAnimationConfig = new AnimationConfig();
    localAnimationConfig.jdField_a_of_type_Int = 4;
    localAnimationConfig.jdField_e_of_type_Int = 1;
    if (paramJSONObject.has("repeat")) {
      localAnimationConfig.jdField_b_of_type_Int = paramJSONObject.getInt("repeat");
    }
    if (paramJSONObject.has("count")) {
      localAnimationConfig.jdField_c_of_type_Int = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("zip_name")) {
      localAnimationConfig.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zip_name");
    }
    if (paramJSONObject.has("time")) {
      localAnimationConfig.jdField_d_of_type_Int = paramJSONObject.getInt("time");
    }
    return localAnimationConfig;
  }
  
  private BubbleInfo.CommonAttrs a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramString, paramBoolean1, paramBoolean2);
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    AnimationConfig localAnimationConfig = a(paramInt, paramString);
    if (localAnimationConfig == null) {
      return null;
    }
    BubbleInfo.CommonAttrs localCommonAttrs = new BubbleInfo.CommonAttrs();
    a(localAnimationConfig, localCommonAttrs);
    File localFile = new File(a(paramInt), localAnimationConfig.jdField_a_of_type_JavaLangString);
    String[] arrayOfString = new String[localAnimationConfig.jdField_c_of_type_Int];
    if (localAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray == null) {
      bool = b(localAnimationConfig, localFile, arrayOfString, false);
    } else {
      bool = a(localAnimationConfig, localFile, arrayOfString, false);
    }
    if ((paramBoolean1) && (bool))
    {
      a(paramInt, "other.zip", "0");
      return null;
    }
    if (bool) {
      return null;
    }
    if (arrayOfString.length > 0) {
      localObject = arrayOfString;
    }
    localCommonAttrs.jdField_a_of_type_ArrayOfJavaLangString = localObject;
    localCommonAttrs.jdField_b_of_type_JavaLangString = paramString;
    localCommonAttrs.jdField_d_of_type_Int = a(localAnimationConfig.jdField_d_of_type_JavaLangString, paramBoolean2);
    if ((localAnimationConfig.jdField_a_of_type_ArrayOfInt != null) && (localAnimationConfig.jdField_a_of_type_ArrayOfInt.length > 0)) {
      localCommonAttrs.jdField_a_of_type_AndroidGraphicsRect = a(localAnimationConfig.jdField_a_of_type_ArrayOfInt[0], localAnimationConfig.jdField_a_of_type_ArrayOfInt[1], localAnimationConfig.jdField_a_of_type_ArrayOfInt[2], localAnimationConfig.jdField_a_of_type_ArrayOfInt[3]);
    }
    return localCommonAttrs;
  }
  
  @NotNull
  private BubbleInfo a(int paramInt, BubbleConfig paramBubbleConfig)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    if (paramBubbleConfig.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < paramBubbleConfig.jdField_a_of_type_JavaUtilArrayList.size())
      {
        AnimationConfig localAnimationConfig = (AnimationConfig)paramBubbleConfig.jdField_a_of_type_JavaUtilArrayList.get(i);
        int j = 0;
        while (j < localAnimationConfig.jdField_a_of_type_ArrayOfJavaLangString.length)
        {
          String str = localAnimationConfig.jdField_a_of_type_ArrayOfJavaLangString[j];
          localArrayList.add(str);
          localHashMap.put(str, localAnimationConfig.jdField_b_of_type_JavaLangString);
          j += 1;
        }
        i += 1;
      }
    }
    return new BubbleInfo(paramInt, "", "", "", "", paramBubbleConfig.jdField_a_of_type_ComTencentMobileqqBubbleDiyBubbleConfig$DiyBubblePasterConfig, paramBubbleConfig.jdField_b_of_type_Int, paramBubbleConfig.jdField_c_of_type_Int, paramBubbleConfig.jdField_d_of_type_Int, paramBubbleConfig.jdField_a_of_type_Boolean, paramBubbleConfig.jdField_b_of_type_Boolean, paramBubbleConfig.jdField_a_of_type_Double, (String[])localArrayList.toArray(new String[0]), null, 0, 0, null, null, localHashMap);
  }
  
  private BubbleNewAnimConf a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "getPendantAnimConf object == null");
      return null;
    }
    BubbleNewAnimConf.PendantAnimConf localPendantAnimConf = new BubbleNewAnimConf.PendantAnimConf();
    if (paramJSONObject.has("key")) {
      localPendantAnimConf.jdField_a_of_type_JavaLangString = paramJSONObject.getString("key");
    }
    if (paramJSONObject.has("duration")) {
      localPendantAnimConf.jdField_a_of_type_Long = paramJSONObject.getInt("duration");
    }
    if (paramJSONObject.has("repeat")) {
      localPendantAnimConf.jdField_a_of_type_Int = paramJSONObject.getInt("repeat");
    }
    if (paramJSONObject.has("pendent_prefix")) {
      localPendantAnimConf.jdField_b_of_type_JavaLangString = paramJSONObject.getString("pendent_prefix");
    }
    if (paramJSONObject.has("img_count")) {
      localPendantAnimConf.jdField_b_of_type_Int = paramJSONObject.getInt("img_count");
    }
    if (paramJSONObject.has("play_with")) {
      localPendantAnimConf.e = paramJSONObject.getString("play_with");
    }
    return localPendantAnimConf;
  }
  
  /* Error */
  private Boolean a(int paramInt, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 507	com/tencent/mobileqq/bubble/BubbleManager:c	()Ljava/io/File;
    //   4: astore_3
    //   5: new 177	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: iload_1
    //   17: invokevirtual 510	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 4
    //   23: ldc_w 512
    //   26: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: new 394	java/io/File
    //   33: dup
    //   34: aload_3
    //   35: aload 4
    //   37: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 400	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: astore 4
    //   45: aload 4
    //   47: invokevirtual 515	java/io/File:exists	()Z
    //   50: ifeq +9 -> 59
    //   53: aload 4
    //   55: invokevirtual 518	java/io/File:delete	()Z
    //   58: pop
    //   59: aconst_null
    //   60: astore 5
    //   62: aconst_null
    //   63: astore 6
    //   65: aconst_null
    //   66: astore_3
    //   67: new 520	java/io/RandomAccessFile
    //   70: dup
    //   71: aload 4
    //   73: ldc_w 522
    //   76: invokespecial 523	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   79: astore 4
    //   81: aload 4
    //   83: aload_2
    //   84: invokevirtual 524	org/json/JSONObject:toString	()Ljava/lang/String;
    //   87: invokevirtual 528	java/lang/String:getBytes	()[B
    //   90: invokevirtual 532	java/io/RandomAccessFile:write	([B)V
    //   93: aload 4
    //   95: invokevirtual 533	java/io/RandomAccessFile:close	()V
    //   98: iconst_1
    //   99: invokestatic 538	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   102: areturn
    //   103: astore_2
    //   104: aload 4
    //   106: astore_3
    //   107: goto +83 -> 190
    //   110: astore_3
    //   111: aload 4
    //   113: astore_2
    //   114: aload_3
    //   115: astore 4
    //   117: goto +22 -> 139
    //   120: astore_3
    //   121: aload 4
    //   123: astore_2
    //   124: aload_3
    //   125: astore 4
    //   127: goto +35 -> 162
    //   130: astore_2
    //   131: goto +59 -> 190
    //   134: astore 4
    //   136: aload 5
    //   138: astore_2
    //   139: aload_2
    //   140: astore_3
    //   141: aload 4
    //   143: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   146: aload_2
    //   147: ifnull +38 -> 185
    //   150: aload_2
    //   151: invokevirtual 533	java/io/RandomAccessFile:close	()V
    //   154: goto +31 -> 185
    //   157: astore 4
    //   159: aload 6
    //   161: astore_2
    //   162: aload_2
    //   163: astore_3
    //   164: aload 4
    //   166: invokevirtual 542	java/io/FileNotFoundException:printStackTrace	()V
    //   169: aload_2
    //   170: ifnull +15 -> 185
    //   173: aload_2
    //   174: invokevirtual 533	java/io/RandomAccessFile:close	()V
    //   177: goto +8 -> 185
    //   180: astore_2
    //   181: aload_2
    //   182: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   185: iconst_0
    //   186: invokestatic 538	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   189: areturn
    //   190: aload_3
    //   191: ifnull +15 -> 206
    //   194: aload_3
    //   195: invokevirtual 533	java/io/RandomAccessFile:close	()V
    //   198: goto +8 -> 206
    //   201: astore_3
    //   202: aload_3
    //   203: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   206: aload_2
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	BubbleManager
    //   0	208	1	paramInt	int
    //   0	208	2	paramJSONObject	JSONObject
    //   4	103	3	localObject1	Object
    //   110	5	3	localIOException1	IOException
    //   120	5	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   140	55	3	localJSONObject	JSONObject
    //   201	2	3	localIOException2	IOException
    //   12	114	4	localObject2	Object
    //   134	8	4	localIOException3	IOException
    //   157	8	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   60	77	5	localObject3	Object
    //   63	97	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   81	98	103	finally
    //   81	98	110	java/io/IOException
    //   81	98	120	java/io/FileNotFoundException
    //   67	81	130	finally
    //   141	146	130	finally
    //   164	169	130	finally
    //   67	81	134	java/io/IOException
    //   67	81	157	java/io/FileNotFoundException
    //   150	154	180	java/io/IOException
    //   173	177	180	java/io/IOException
    //   194	198	201	java/io/IOException
  }
  
  private ArrayList<BubbleNewAnimConf> a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      ArrayList localArrayList = new ArrayList(paramJSONArray.length());
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.getJSONObject(i);
        if (((JSONObject)localObject).has("pendent_prefix")) {
          localObject = a((JSONObject)localObject);
        } else {
          localObject = b((JSONObject)localObject);
        }
        localArrayList.add(localObject);
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private JSONObject a(String paramString, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("animations")) {
      return null;
    }
    paramJSONObject = paramJSONObject.getJSONObject("animations");
    if (paramJSONObject != null) {
      return paramJSONObject.getJSONObject(paramString);
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      Object localObject = new File(a(paramInt2), "config.json");
      StringBuilder localStringBuilder;
      if (((File)localObject).exists())
      {
        localObject = a(paramInt2, ((File)localObject).getAbsolutePath());
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDownloadComplete|bubbleId=");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(",createBubbleConfig bubbleConfig=");
          localStringBuilder.append(localObject);
          QLog.d("BubbleManager", 2, localStringBuilder.toString());
        }
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.put(Integer.valueOf(paramInt2), localObject);
        }
      }
      else if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDownloadComplete|");
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append(" not exist");
        QLog.d("BubbleManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void a(int paramInt, BubbleConfig paramBubbleConfig, List<BubbleNewAnimConf> paramList)
  {
    if (paramInt != 8) {
      return;
    }
    if ((paramBubbleConfig.jdField_b_of_type_JavaUtilHashMap != null) && (paramBubbleConfig.jdField_b_of_type_JavaUtilHashMap.size() > 0))
    {
      paramBubbleConfig = paramBubbleConfig.jdField_b_of_type_JavaUtilHashMap.values().iterator();
      while (paramBubbleConfig.hasNext()) {
        paramList.add(paramBubbleConfig.next());
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(Integer.toHexString(paramInt1));
      localStringBuilder.append(",  now chage to ");
      localStringBuilder.append(Integer.toHexString(paramInt2));
      QLog.i("BubbleManager", 2, localStringBuilder.toString());
    }
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAttrsByConfig, bubbleId = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" animName = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" autoDown = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" reversion = ");
      localStringBuilder.append(paramBoolean2);
      QLog.i("BubbleManager", 2, localStringBuilder.toString());
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createBubbleInfo, isCheckOk=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", bubbleId=");
      localStringBuilder.append(paramInt);
      QLog.d("BubbleManager", 2, localStringBuilder.toString());
    }
  }
  
  private void a(AnimationConfig paramAnimationConfig, BubbleInfo.CommonAttrs paramCommonAttrs)
  {
    paramCommonAttrs.jdField_a_of_type_Int = paramAnimationConfig.jdField_c_of_type_Int;
    paramCommonAttrs.jdField_c_of_type_Int = paramAnimationConfig.jdField_d_of_type_Int;
    paramCommonAttrs.jdField_b_of_type_Int = paramAnimationConfig.jdField_b_of_type_Int;
    paramCommonAttrs.jdField_b_of_type_Boolean = paramAnimationConfig.jdField_a_of_type_Boolean;
    paramCommonAttrs.jdField_e_of_type_Int = paramAnimationConfig.jdField_e_of_type_Int;
    paramCommonAttrs.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig = paramAnimationConfig;
    if (paramCommonAttrs.jdField_b_of_type_Int <= 1)
    {
      paramCommonAttrs.jdField_a_of_type_Boolean = true;
      return;
    }
    paramCommonAttrs.jdField_a_of_type_Boolean = false;
  }
  
  private void a(AnimationConfig paramAnimationConfig, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseAttrInPathAnimation animation = null");
      return;
    }
    b(paramAnimationConfig, paramJSONObject);
    Object localObject;
    if (paramJSONObject.has("padding"))
    {
      localObject = paramJSONObject.getJSONArray("padding");
      paramAnimationConfig.jdField_f_of_type_Int = ((JSONArray)localObject).getInt(0);
      paramAnimationConfig.jdField_h_of_type_Int = ((JSONArray)localObject).getInt(1);
      paramAnimationConfig.jdField_g_of_type_Int = ((JSONArray)localObject).getInt(2);
      paramAnimationConfig.i = ((JSONArray)localObject).getInt(3);
    }
    if (!paramJSONObject.has("step")) {
      return;
    }
    if (paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray == null) {
      paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    }
    paramJSONObject = paramJSONObject.getJSONObject("step");
    if (paramJSONObject.has("static"))
    {
      localObject = paramJSONObject.getJSONObject("static");
      paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.put(0, a("static", (JSONObject)localObject));
    }
    if (paramJSONObject.has("moving"))
    {
      localObject = paramJSONObject.getJSONObject("moving");
      paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.put(1, a("moving", (JSONObject)localObject));
    }
    if (paramJSONObject.has("turnback"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("turnback");
      paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.put(2, a("turnback", paramJSONObject));
    }
  }
  
  private void a(BubbleConfig paramBubbleConfig, JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      paramBubbleConfig.jdField_c_of_type_JavaUtilArrayList = new ArrayList(paramJSONArray.length());
      int i = 0;
      while (i < paramJSONArray.length())
      {
        paramBubbleConfig.jdField_c_of_type_JavaUtilArrayList.add(paramJSONArray.getString(i));
        i += 1;
      }
    }
  }
  
  private void a(BubbleConfig paramBubbleConfig, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("bubbleframe_animation"))
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("bubbleframe_animation");
      if (!localJSONObject.has("animation_set")) {
        return;
      }
      paramJSONObject = b(localJSONObject.getString("animation_set"), paramJSONObject);
      if (paramJSONObject == null) {
        return;
      }
      paramJSONObject = a(paramJSONObject);
      paramJSONObject.jdField_b_of_type_JavaLangString = localJSONObject.getString("animation_set");
      paramBubbleConfig.jdField_d_of_type_ComTencentMobileqqBubbleAnimationConfig = paramJSONObject;
      if (!TextUtils.isEmpty(paramJSONObject.jdField_a_of_type_JavaLangString)) {
        paramBubbleConfig.jdField_a_of_type_JavaUtilHashSet.add(paramJSONObject.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void a(BubbleConfig paramBubbleConfig, JSONObject paramJSONObject, JSONArray paramJSONArray, ArrayList<AnimationConfig> paramArrayList, int paramInt)
  {
    paramJSONArray = paramJSONArray.getJSONObject(paramInt);
    if (paramJSONArray.has("animation"))
    {
      paramJSONObject = a(paramJSONArray.getString("animation"), paramJSONObject);
      if (paramJSONObject == null) {
        return;
      }
      paramJSONObject = a(1, paramJSONObject);
      JSONArray localJSONArray = paramJSONArray.getJSONArray("key_word");
      paramJSONObject.jdField_a_of_type_ArrayOfJavaLangString = new String[localJSONArray.length()];
      paramInt = 0;
      while (paramInt < localJSONArray.length())
      {
        paramJSONObject.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = localJSONArray.getString(paramInt);
        paramInt += 1;
      }
      paramJSONObject.jdField_b_of_type_JavaLangString = paramJSONArray.getString("animation");
      paramArrayList.add(paramJSONObject);
      if (!TextUtils.isEmpty(paramJSONObject.jdField_a_of_type_JavaLangString)) {
        paramBubbleConfig.jdField_a_of_type_JavaUtilHashSet.add(paramJSONObject.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void a(BubbleConfig paramBubbleConfig, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString)
  {
    paramJSONObject2 = paramJSONObject2.optString(paramString);
    paramJSONObject1 = b(paramJSONObject2, paramJSONObject1);
    BubbleNewAnimConf.InterActiveAnimConf localInterActiveAnimConf = new BubbleNewAnimConf.InterActiveAnimConf();
    localInterActiveAnimConf.a(paramBubbleConfig.jdField_a_of_type_Int, paramJSONObject2, paramJSONObject1);
    paramBubbleConfig.jdField_b_of_type_JavaUtilHashMap.put(paramString, localInterActiveAnimConf);
  }
  
  private void a(BubbleInfo paramBubbleInfo, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int i = paramBitmap.getPixel(paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
      if (paramBubbleInfo.jdField_b_of_type_Int == i)
      {
        paramBubbleInfo.jdField_b_of_type_Int = Color.rgb(255 - Color.red(i), 255 - Color.green(i), 255 - Color.blue(i));
        a(i, "text color:", paramBubbleInfo.jdField_b_of_type_Int);
      }
      if (paramBubbleInfo.jdField_c_of_type_Int == i)
      {
        paramBubbleInfo.jdField_c_of_type_Int = Color.rgb(255 - Color.red(i), 255 - Color.green(i), 255 - Color.blue(i));
        a(i, "mLinkColor :", paramBubbleInfo.jdField_c_of_type_Int);
      }
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, paramString);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject;
    if (paramInt1 == 0)
    {
      a(paramInt2, false);
      localObject = a(paramInt2, a(paramInt2, "static"), false);
      if (localObject != null)
      {
        BubbleInfo localBubbleInfo = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt2));
        if (localBubbleInfo != null) {
          localBubbleInfo.jdField_a_of_type_JavaUtilList.add(localObject);
        }
      }
    }
    if ((!paramString.equals("0")) && (this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("srcType", 3);
      ((Bundle)localObject).putString("callbackId", paramString);
      paramString = this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener;
      long l = paramInt2;
      if (paramInt1 == 0) {
        paramInt1 = i;
      } else {
        paramInt1 = -1;
      }
      paramString.a(l, paramInt1, (Bundle)localObject);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      QLog.i("BubbleManager", 2, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, String.format("onDownloadComplete, scid %s, errorcode %d, from %s, httpCode %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2) }));
    }
  }
  
  private void a(JSONObject paramJSONObject, AnimationConfig paramAnimationConfig)
  {
    if (paramJSONObject.has("cut_array"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("cut_array");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        paramAnimationConfig.jdField_c_of_type_ArrayOfInt = new int[paramJSONObject.length()];
        int i = 0;
        while (i < paramJSONObject.length())
        {
          paramAnimationConfig.jdField_c_of_type_ArrayOfInt[i] = paramJSONObject.getInt(i);
          i += 1;
        }
        Arrays.sort(paramAnimationConfig.jdField_c_of_type_ArrayOfInt);
      }
    }
  }
  
  private void a(JSONObject paramJSONObject, BubbleNewAnimConf.PathAnimConf paramPathAnimConf)
  {
    JSONArray localJSONArray;
    if (paramJSONObject.has("img_alpha"))
    {
      localJSONArray = paramJSONObject.getJSONArray("img_alpha");
      paramPathAnimConf.jdField_f_of_type_Int = localJSONArray.getInt(0);
      paramPathAnimConf.jdField_g_of_type_Int = localJSONArray.getInt(1);
    }
    if (paramJSONObject.has("repeat")) {
      paramPathAnimConf.jdField_a_of_type_Int = paramJSONObject.getInt("repeat");
    }
    if (paramJSONObject.has("img_rotate"))
    {
      localJSONArray = paramJSONObject.getJSONArray("img_rotate");
      paramPathAnimConf.jdField_h_of_type_Int = localJSONArray.getInt(0);
      paramPathAnimConf.i = localJSONArray.getInt(1);
    }
    if (paramJSONObject.has("img_count")) {
      paramPathAnimConf.jdField_b_of_type_Int = paramJSONObject.getInt("img_count");
    }
    if (paramJSONObject.has("periodical")) {
      paramPathAnimConf.jdField_c_of_type_Boolean = paramJSONObject.getBoolean("periodical");
    }
    if (paramJSONObject.has("period_length")) {
      paramPathAnimConf.j = paramJSONObject.getInt("period_length");
    }
  }
  
  private boolean a(int paramInt, AnimationConfig paramAnimationConfig, boolean paramBoolean)
  {
    Iterator localIterator = paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return paramBoolean;
      }
      Object localObject1 = (BubbleNewAnimConf)localIterator.next();
      File localFile = new File(a(paramInt), paramAnimationConfig.jdField_a_of_type_JavaLangString);
      int i = 0;
      if (i < ((BubbleNewAnimConf)localObject1).jdField_b_of_type_Int)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
        ((StringBuilder)localObject2).append(File.separatorChar);
        ((StringBuilder)localObject2).append(((BubbleNewAnimConf)localObject1).jdField_b_of_type_JavaLangString);
        i += 1;
        ((StringBuilder)localObject2).append(String.format("%04d.png", new Object[] { Integer.valueOf(i) }));
        localObject2 = ((StringBuilder)localObject2).toString();
        if (new File((String)localObject2).exists()) {
          break;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("pendent anim conf, file is not exit, ");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("BubbleManager", 2, ((StringBuilder)localObject1).toString());
        }
        paramBoolean = false;
      }
    }
    return paramBoolean;
  }
  
  private boolean a(AnimationConfig paramAnimationConfig)
  {
    return (paramAnimationConfig != null) && (paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList != null) && (paramAnimationConfig.jdField_a_of_type_JavaUtilArrayList.size() > 0);
  }
  
  private boolean a(AnimationConfig paramAnimationConfig, File paramFile, String[] paramArrayOfString, boolean paramBoolean)
  {
    int n = paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.size();
    int i = 0;
    int j = 0;
    while (i < n)
    {
      AnimationConfig.AnimationStep localAnimationStep = (AnimationConfig.AnimationStep)paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      boolean bool;
      int m;
      for (int k = 0;; k = m)
      {
        bool = paramBoolean;
        if (k >= localAnimationStep.jdField_a_of_type_Int) {
          break;
        }
        int i1 = k + j;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFile.getAbsolutePath());
        localStringBuilder.append(File.separatorChar);
        localStringBuilder.append(localAnimationStep.jdField_a_of_type_JavaLangString);
        m = k + 1;
        localStringBuilder.append(String.format("%04d.png", new Object[] { Integer.valueOf(m) }));
        paramArrayOfString[i1] = localStringBuilder.toString();
        bool = new File(paramArrayOfString[i1]).exists();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkBubbleSource|pngs[");
          localStringBuilder.append(k);
          localStringBuilder.append("]=");
          localStringBuilder.append(paramArrayOfString[k]);
          localStringBuilder.append(",isFileExists=");
          localStringBuilder.append(bool);
          QLog.d("BubbleManager", 2, localStringBuilder.toString());
        }
        if (!bool)
        {
          bool = true;
          break;
        }
      }
      if (bool) {
        return bool;
      }
      j += localAnimationStep.jdField_a_of_type_Int;
      i += 1;
      paramBoolean = bool;
    }
    return paramBoolean;
  }
  
  private boolean a(BubbleInfo paramBubbleInfo)
  {
    if (paramBubbleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "checkBubbleStaticSource|bubbleInfo is null");
      }
      return false;
    }
    Object localObject1 = AIOUtils.a();
    ((StringBuilder)localObject1).append(a(paramBubbleInfo.jdField_a_of_type_Int).getAbsolutePath());
    ((StringBuilder)localObject1).append(File.separatorChar);
    ((StringBuilder)localObject1).append("chartlet");
    ((StringBuilder)localObject1).append(File.separatorChar);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = AIOUtils.a();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("chartlet.png");
    localObject1 = ((StringBuilder)localObject2).toString();
    boolean bool = new File((String)localObject1).exists();
    if (!a(paramBubbleInfo, bool)) {
      return true;
    }
    localObject2 = AIOUtils.a();
    ((StringBuilder)localObject2).append(a(paramBubbleInfo.jdField_a_of_type_Int).getAbsolutePath());
    ((StringBuilder)localObject2).append(File.separatorChar);
    ((StringBuilder)localObject2).append("static");
    ((StringBuilder)localObject2).append(File.separatorChar);
    String str = ((StringBuilder)localObject2).toString();
    localObject2 = AIOUtils.a();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("aio_user_bg_nor.9.png");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = AIOUtils.a();
    ((StringBuilder)localObject3).append(str);
    ((StringBuilder)localObject3).append("aio_user_pic_nor.9.png");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = AIOUtils.a();
    ((StringBuilder)localObject4).append(str);
    ((StringBuilder)localObject4).append("chat_bubble_thumbnail.png");
    str = ((StringBuilder)localObject4).toString();
    localObject4 = new ArrayList();
    ((List)localObject4).add(localObject2);
    ((List)localObject4).add(localObject3);
    ((List)localObject4).add(str);
    if (bool) {
      ((List)localObject4).add(localObject1);
    }
    if (a(paramBubbleInfo, (List)localObject4)) {
      return false;
    }
    paramBubbleInfo.jdField_d_of_type_JavaLangString = str;
    paramBubbleInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
    paramBubbleInfo.jdField_b_of_type_JavaLangString = ((String)localObject3);
    paramBubbleInfo.e = ((String)localObject1);
    paramBubbleInfo.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleUnRead.a(paramBubbleInfo.jdField_a_of_type_Int);
    try
    {
      a(paramBubbleInfo, a(str, null));
      return true;
    }
    catch (Exception paramBubbleInfo)
    {
      QLog.e("BubbleManager", 2, "bubble change color throws exception!", paramBubbleInfo);
      return true;
    }
    catch (OutOfMemoryError paramBubbleInfo)
    {
      QLog.e("BubbleManager", 2, "bubble change color out of memory error!", paramBubbleInfo);
    }
    return true;
  }
  
  private boolean a(BubbleInfo paramBubbleInfo, List<String> paramList)
  {
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (String)((Iterator)localObject).next();
      if (!new File(paramList).exists())
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkBubbleStaticSource|file is not exists,bubbleId=");
          ((StringBuilder)localObject).append(paramBubbleInfo.jdField_a_of_type_Int);
          ((StringBuilder)localObject).append(",strFilePath=");
          ((StringBuilder)localObject).append(paramList);
          QLog.d("BubbleManager", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean a(BubbleInfo paramBubbleInfo, boolean paramBoolean)
  {
    if (((!paramBoolean) || (!TextUtils.isEmpty(paramBubbleInfo.e))) && (!TextUtils.isEmpty(paramBubbleInfo.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramBubbleInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramBubbleInfo.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkBubbleStaticSource|bubbleId=");
        localStringBuilder.append(paramBubbleInfo.jdField_a_of_type_Int);
        localStringBuilder.append(",chkStaticSrcAndUpdate is ok | not empty");
        QLog.d("BubbleManager", 2, localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString, BubbleConfig paramBubbleConfig, AnimationConfig paramAnimationConfig)
  {
    return (paramAnimationConfig != null) && (paramAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString));
  }
  
  private AnimationConfig b(JSONObject paramJSONObject)
  {
    AnimationConfig localAnimationConfig = new AnimationConfig();
    localAnimationConfig.jdField_a_of_type_Int = 5;
    localAnimationConfig.jdField_e_of_type_Int = 1;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseVoicePrintAnimationConfig object = null");
      return null;
    }
    if (paramJSONObject.has("align")) {
      localAnimationConfig.jdField_d_of_type_JavaLangString = paramJSONObject.getString("align");
    }
    if (paramJSONObject.has("repeat")) {
      localAnimationConfig.jdField_b_of_type_Int = paramJSONObject.getInt("repeat");
    }
    if (paramJSONObject.has("count")) {
      localAnimationConfig.jdField_c_of_type_Int = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("zip_name")) {
      localAnimationConfig.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zip_name");
    }
    if (paramJSONObject.has("time")) {
      localAnimationConfig.jdField_d_of_type_Int = paramJSONObject.getInt("time");
    }
    if (paramJSONObject.has("padding"))
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("padding");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        localAnimationConfig.jdField_f_of_type_Int = AIOUtils.b(localJSONArray.getInt(0) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
        localAnimationConfig.jdField_h_of_type_Int = AIOUtils.b(localJSONArray.getInt(1) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
        localAnimationConfig.jdField_g_of_type_Int = AIOUtils.b(localJSONArray.getInt(2) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
        localAnimationConfig.i = AIOUtils.b(localJSONArray.getInt(3) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
    }
    a(paramJSONObject, localAnimationConfig);
    return localAnimationConfig;
  }
  
  private BubbleNewAnimConf b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "getPathAnimConf object == null");
      return null;
    }
    BubbleNewAnimConf.PathAnimConf localPathAnimConf = new BubbleNewAnimConf.PathAnimConf();
    if (paramJSONObject.has("key")) {
      localPathAnimConf.jdField_a_of_type_JavaLangString = paramJSONObject.getString("key");
    }
    JSONArray localJSONArray;
    if (paramJSONObject.has("start_end"))
    {
      localJSONArray = paramJSONObject.getJSONArray("start_end");
      localPathAnimConf.jdField_a_of_type_Float = ((float)localJSONArray.getDouble(0));
      localPathAnimConf.jdField_b_of_type_Float = ((float)localJSONArray.getDouble(1));
      localPathAnimConf.jdField_c_of_type_Float = ((float)localJSONArray.getDouble(2));
      localPathAnimConf.d = ((float)localJSONArray.getDouble(3));
    }
    if (paramJSONObject.has("bezier"))
    {
      localJSONArray = paramJSONObject.getJSONArray("bezier");
      localPathAnimConf.jdField_e_of_type_Float = ((float)localJSONArray.getDouble(0));
      localPathAnimConf.jdField_f_of_type_Float = ((float)localJSONArray.getDouble(1));
      localPathAnimConf.jdField_g_of_type_Float = ((float)localJSONArray.getDouble(2));
      localPathAnimConf.jdField_h_of_type_Float = ((float)localJSONArray.getDouble(3));
    }
    if (paramJSONObject.has("duration")) {
      localPathAnimConf.jdField_a_of_type_Long = paramJSONObject.getInt("duration");
    }
    if (paramJSONObject.has("speed")) {
      localPathAnimConf.jdField_e_of_type_Int = paramJSONObject.getInt("speed");
    }
    if (paramJSONObject.has("img_prefix")) {
      localPathAnimConf.jdField_b_of_type_JavaLangString = paramJSONObject.getString("img_prefix");
    }
    if (paramJSONObject.has("img_reverse")) {
      localPathAnimConf.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("img_reverse");
    }
    a(paramJSONObject, localPathAnimConf);
    return localPathAnimConf;
  }
  
  @Nullable
  private Boolean b(int paramInt)
  {
    if (new File(a(paramInt), "config.json").exists())
    {
      BubbleConfig localBubbleConfig = a(paramInt, false);
      if (localBubbleConfig != null) {
        return Boolean.valueOf(localBubbleConfig.a(a(paramInt)));
      }
    }
    return null;
  }
  
  private String b(String paramString)
  {
    String str = paramString;
    if (Build.VERSION.SDK_INT <= 10)
    {
      str = paramString;
      if (paramString.length() > 1)
      {
        str = paramString;
        if (paramString.charAt(0) == 65279) {
          str = paramString.substring(1);
        }
      }
    }
    return str;
  }
  
  private JSONObject b(String paramString, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("animation_sets")) {
      return null;
    }
    paramJSONObject = paramJSONObject.getJSONObject("animation_sets");
    if (paramJSONObject != null) {
      return paramJSONObject.getJSONObject(paramString);
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bubble.android.");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append("static.zip");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bubble.android.");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(".");
      localStringBuilder.append("other.zip");
      a(paramInt, new String[] { localObject, localStringBuilder.toString() }, "0");
    }
    else
    {
      a(paramInt, "static.zip", "0");
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createBubbleInfo, download bubble resource, bubbleId=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("BubbleManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createBubbleInfo, bubbleId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", autoAsyncDownload=");
      localStringBuilder.append(paramBoolean);
      QLog.d("BubbleManager", 2, localStringBuilder.toString());
    }
  }
  
  private void b(AnimationConfig paramAnimationConfig, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("type"))
    {
      paramJSONObject = paramJSONObject.getString("type");
      if ("line".equalsIgnoreCase(paramJSONObject)) {
        paramAnimationConfig.jdField_e_of_type_Int = 10;
      }
      if ("circle".equalsIgnoreCase(paramJSONObject)) {
        paramAnimationConfig.jdField_e_of_type_Int = 11;
      }
      if ("static".equalsIgnoreCase(paramJSONObject)) {
        paramAnimationConfig.jdField_e_of_type_Int = 1;
      }
    }
  }
  
  private void b(BubbleConfig paramBubbleConfig, JSONObject paramJSONObject)
  {
    Object localObject1;
    Object localObject2;
    if (paramJSONObject.has("voiceprint_animation"))
    {
      localObject1 = paramJSONObject.getJSONObject("voiceprint_animation");
      if (((JSONObject)localObject1).has("animation_set"))
      {
        localObject2 = b(((JSONObject)localObject1).getString("animation_set"), paramJSONObject);
        if (localObject2 != null)
        {
          localObject2 = b((JSONObject)localObject2);
          ((AnimationConfig)localObject2).jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).getString("animation_set");
          paramBubbleConfig.jdField_e_of_type_ComTencentMobileqqBubbleAnimationConfig = ((AnimationConfig)localObject2);
          if (!TextUtils.isEmpty(((AnimationConfig)localObject2).jdField_a_of_type_JavaLangString)) {
            paramBubbleConfig.jdField_a_of_type_JavaUtilHashSet.add(((AnimationConfig)localObject2).jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
    if (paramJSONObject.has("key_animations"))
    {
      localObject1 = paramJSONObject.getJSONArray("key_animations");
      localObject2 = new ArrayList();
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        a(paramBubbleConfig, paramJSONObject, (JSONArray)localObject1, (ArrayList)localObject2, i);
        i += 1;
      }
      paramBubbleConfig.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, paramString);
    }
  }
  
  private void b(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      a(paramInt2);
    }
    if ((!paramString.equals("0")) && (this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("srcType", 3);
      localBundle.putString("callbackId", paramString);
      paramString = this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener;
      long l = paramInt2;
      if (paramInt1 == 0) {
        paramInt1 = 0;
      } else {
        paramInt1 = -1;
      }
      paramString.a(l, paramInt1, localBundle);
    }
  }
  
  private void b(JSONObject paramJSONObject, AnimationConfig paramAnimationConfig)
  {
    if (paramJSONObject.has("rect"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("rect");
      paramAnimationConfig.jdField_a_of_type_ArrayOfInt = new int[4];
      int i = 0;
      while (i < paramJSONObject.length())
      {
        paramAnimationConfig.jdField_a_of_type_ArrayOfInt[i] = paramJSONObject.getInt(i);
        i += 1;
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    ??? = c();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(".cfg");
    ??? = new File((File)???, ((StringBuilder)localObject2).toString());
    if (!((File)???).exists())
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("readLocalVersionInfo local info not exist id = ");
        ((StringBuilder)???).append(paramInt);
        QLog.d("BubbleManager", 2, ((StringBuilder)???).toString());
      }
      return false;
    }
    ??? = FileUtils.readFileToStringEx((File)???, -1);
    if (TextUtils.isEmpty((CharSequence)???))
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("readLocalVersionInfo read local info fail id = ");
        ((StringBuilder)???).append(paramInt);
        QLog.d("BubbleManager", 2, ((StringBuilder)???).toString());
      }
      return false;
    }
    try
    {
      localObject2 = new JSONObject((String)???);
      synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
      {
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(Integer.valueOf(paramInt), localObject2);
        int i = ((JSONObject)localObject2).optInt("full_download");
        return i == 1;
      }
      StringBuilder localStringBuilder;
      return false;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("readLocalVersionInfo id = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" error: ");
      QLog.e("BubbleManager", 1, localStringBuilder.toString(), localException);
    }
  }
  
  private boolean b(AnimationConfig paramAnimationConfig, File paramFile, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramAnimationConfig.jdField_a_of_type_Int == 4) {
      paramAnimationConfig = "%04d.9.png";
    } else {
      paramAnimationConfig = "%04d.png";
    }
    int j;
    for (int i = 0; i < paramArrayOfString.length; i = j)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append(File.separatorChar);
      j = i + 1;
      localStringBuilder.append(String.format(paramAnimationConfig, new Object[] { Integer.valueOf(j) }));
      paramArrayOfString[i] = localStringBuilder.toString();
      boolean bool = new File(paramArrayOfString[i]).exists();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkBubbleSource|pngs[");
        localStringBuilder.append(i);
        localStringBuilder.append("]=");
        localStringBuilder.append(paramArrayOfString[i]);
        localStringBuilder.append(",isFileExists=");
        localStringBuilder.append(bool);
        QLog.d("BubbleManager", 2, localStringBuilder.toString());
      }
      if (!bool) {
        return true;
      }
    }
    return paramBoolean;
  }
  
  @Nullable
  private Boolean c(int paramInt)
  {
    Object localObject = new File(a(paramInt), "static");
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).list();
      if ((localObject != null) && (localObject.length >= 3))
      {
        localObject = Arrays.asList((Object[])localObject);
        boolean bool;
        if ((((List)localObject).contains("aio_user_bg_nor.9.png")) && (((List)localObject).contains("aio_user_pic_nor.9.png")) && (((List)localObject).contains("chat_bubble_thumbnail.png"))) {
          bool = true;
        } else {
          bool = false;
        }
        return Boolean.valueOf(bool);
      }
    }
    return null;
  }
  
  private void c(BubbleConfig paramBubbleConfig, JSONObject paramJSONObject)
  {
    d(paramBubbleConfig, paramJSONObject);
    JSONObject localJSONObject;
    if (paramJSONObject.has("height_animation"))
    {
      localJSONObject = paramJSONObject.getJSONObject("height_animation");
      if (localJSONObject.has("animation"))
      {
        Object localObject = a(localJSONObject.getString("animation"), paramJSONObject);
        if (localObject != null)
        {
          AnimationConfig localAnimationConfig = a(2, (JSONObject)localObject);
          localObject = ((JSONObject)localObject).getJSONArray("height_interval");
          localAnimationConfig.jdField_b_of_type_ArrayOfInt = new int[] { ((JSONArray)localObject).getInt(0), ((JSONArray)localObject).getInt(1) };
          localAnimationConfig.jdField_b_of_type_JavaLangString = localJSONObject.getString("animation");
          paramBubbleConfig.jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig = localAnimationConfig;
          if (!TextUtils.isEmpty(localAnimationConfig.jdField_a_of_type_JavaLangString)) {
            paramBubbleConfig.jdField_a_of_type_JavaUtilHashSet.add(localAnimationConfig.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
    if (paramJSONObject.has("width_animation"))
    {
      localJSONObject = paramJSONObject.getJSONObject("width_animation");
      if (localJSONObject.has("animation"))
      {
        paramJSONObject = a(localJSONObject.getString("animation"), paramJSONObject);
        if (paramJSONObject != null)
        {
          paramJSONObject = a(3, paramJSONObject);
          paramJSONObject.jdField_b_of_type_JavaLangString = localJSONObject.getString("animation");
          if (localJSONObject.has("width"))
          {
            int i = localJSONObject.getInt("width");
            double d1 = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay().getWidth();
            double d2 = i;
            Double.isNaN(d2);
            d2 /= 100.0D;
            Double.isNaN(d1);
            paramJSONObject.j = ((int)(d1 * d2));
          }
          paramBubbleConfig.jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig = paramJSONObject;
          if (!TextUtils.isEmpty(paramJSONObject.jdField_a_of_type_JavaLangString)) {
            paramBubbleConfig.jdField_a_of_type_JavaUtilHashSet.add(paramJSONObject.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  private void d(BubbleConfig paramBubbleConfig, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("voice_animation"))
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("voice_animation");
      if (!localJSONObject.has("animation")) {
        return;
      }
      paramJSONObject = a(localJSONObject.getString("animation"), paramJSONObject);
      if (paramJSONObject == null) {
        return;
      }
      paramJSONObject = a(0, paramJSONObject);
      paramJSONObject.jdField_b_of_type_JavaLangString = localJSONObject.getString("animation");
      paramBubbleConfig.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig = paramJSONObject;
      if (!TextUtils.isEmpty(paramJSONObject.jdField_a_of_type_JavaLangString)) {
        paramBubbleConfig.jdField_a_of_type_JavaUtilHashSet.add(paramJSONObject.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void e(BubbleConfig paramBubbleConfig, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("pendant_animation"))
    {
      Object localObject = paramJSONObject.getJSONObject("pendant_animation");
      AnimationConfig localAnimationConfig = new AnimationConfig();
      if (((JSONObject)localObject).has("pendant_id")) {
        localAnimationConfig.k = ((JSONObject)localObject).getInt("pendant_id");
      }
      if (((JSONObject)localObject).has("animation_set"))
      {
        localObject = ((JSONObject)localObject).getString("animation_set");
        localAnimationConfig.jdField_b_of_type_JavaLangString = ((String)localObject);
        localObject = b((String)localObject, paramJSONObject);
        if (localObject != null)
        {
          localAnimationConfig.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("zip_name");
          paramJSONObject = ((JSONObject)localObject).getJSONArray("anim_sets");
          if (((JSONObject)localObject).has("padding"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("padding");
            if ((localObject != null) && (((JSONArray)localObject).length() > 0))
            {
              localAnimationConfig.jdField_f_of_type_Int = ((JSONArray)localObject).getInt(0);
              localAnimationConfig.jdField_h_of_type_Int = ((JSONArray)localObject).getInt(1);
              localAnimationConfig.jdField_g_of_type_Int = ((JSONArray)localObject).getInt(2);
              localAnimationConfig.i = ((JSONArray)localObject).getInt(3);
            }
          }
          if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
            localAnimationConfig.jdField_a_of_type_JavaUtilArrayList = a(paramJSONObject);
          }
          paramBubbleConfig.jdField_f_of_type_ComTencentMobileqqBubbleAnimationConfig = localAnimationConfig;
        }
      }
    }
  }
  
  private void f(BubbleConfig paramBubbleConfig, JSONObject paramJSONObject)
  {
    h(paramBubbleConfig, paramJSONObject);
    g(paramBubbleConfig, paramJSONObject);
    Object localObject;
    if (paramJSONObject.has("shadow_blur_color"))
    {
      paramBubbleConfig.jdField_a_of_type_Boolean = true;
      localObject = paramJSONObject.getString("shadow_blur_color");
      paramJSONObject = (JSONObject)localObject;
      if (((String)localObject).startsWith("0x")) {
        paramJSONObject = ((String)localObject).substring(2);
      }
    }
    label178:
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramJSONObject);
      paramBubbleConfig.jdField_d_of_type_Int = Color.parseColor(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramBubbleConfig)
    {
      label87:
      break label87;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("BubbleManager", 2, "strokeColor invalid");
      return;
      if (paramJSONObject.has("shadow_color"))
      {
        paramBubbleConfig.jdField_b_of_type_Boolean = true;
        localObject = paramJSONObject.getString("shadow_color");
        paramJSONObject = (JSONObject)localObject;
        if (((String)localObject).startsWith("0x")) {
          paramJSONObject = ((String)localObject).substring(2);
        }
      }
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramJSONObject);
      paramBubbleConfig.jdField_d_of_type_Int = Color.parseColor(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramBubbleConfig)
    {
      break label178;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "strokeColor invalid");
    }
  }
  
  private void g(BubbleConfig paramBubbleConfig, JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject.has("link_color"))
    {
      localObject = paramJSONObject.getString("link_color");
      paramJSONObject = (JSONObject)localObject;
      if (((String)localObject).startsWith("0x")) {
        paramJSONObject = ((String)localObject).substring(2);
      }
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramJSONObject);
      paramBubbleConfig.jdField_c_of_type_Int = Color.parseColor(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramBubbleConfig)
    {
      label70:
      break label70;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "linkcolor invalid");
    }
  }
  
  private void h(BubbleConfig paramBubbleConfig, JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject.has("color"))
    {
      localObject = paramJSONObject.getString("color");
      paramJSONObject = (JSONObject)localObject;
      if (((String)localObject).startsWith("0x")) {
        paramJSONObject = ((String)localObject).substring(2);
      }
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramJSONObject);
      paramBubbleConfig.jdField_b_of_type_Int = Color.parseColor(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramBubbleConfig)
    {
      label70:
      break label70;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "color invalid");
    }
  }
  
  private void i(BubbleConfig paramBubbleConfig, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("loopList")) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("loopList");
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
        {
          paramBubbleConfig.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          int i = 0;
          paramBubbleConfig.jdField_e_of_type_Int = 0;
          while (i < paramJSONObject.length())
          {
            paramBubbleConfig.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(paramJSONObject.getInt(i)));
            i += 1;
          }
          a(TextUtils.join(",", paramBubbleConfig.jdField_b_of_type_JavaUtilArrayList), "bubble loopList: ");
          return;
        }
      }
      catch (Exception paramBubbleConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BubbleManager", 2, "", paramBubbleConfig);
        }
      }
    }
  }
  
  public int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\.");
      if (paramString.length == 5)
      {
        paramString = paramString[2];
        try
        {
          int i = Integer.parseInt(paramString);
          return i;
        }
        catch (NumberFormatException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("BubbleManager", 2, "getBubbleIdFromScid: parse bubbleId error", paramString);
          }
        }
      }
    }
    return 0;
  }
  
  public AnimationConfig a(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt1, false);
    if (localObject == null) {
      return null;
    }
    localObject = a(paramInt2, (BubbleConfig)localObject, null);
    if (localObject != null)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(((AnimationConfig)localObject).jdField_b_of_type_JavaLangString)) {
        return localObject;
      }
      if (a((AnimationConfig)localObject))
      {
        if (!a(paramInt1, (AnimationConfig)localObject, true))
        {
          a(paramInt1, "other.zip", "0");
          return null;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((AnimationConfig)localObject).jdField_b_of_type_JavaLangString, localObject);
        return localObject;
      }
      return null;
    }
    return localObject;
  }
  
  AnimationConfig a(int paramInt, String paramString)
  {
    Object localObject = a(paramInt, true);
    if (localObject == null)
    {
      paramString = new StringBuilder();
      paramString.append("findAnimConfig bubbleId = ");
      paramString.append(paramInt);
      paramString.append(" bubbleConfig = null");
      QLog.e("BubbleManager", 1, paramString.toString());
      return null;
    }
    if (a(paramString, (BubbleConfig)localObject, ((BubbleConfig)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig)) {
      return ((BubbleConfig)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if (a(paramString, (BubbleConfig)localObject, ((BubbleConfig)localObject).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig)) {
      return ((BubbleConfig)localObject).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if (a(paramString, (BubbleConfig)localObject, ((BubbleConfig)localObject).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig)) {
      return ((BubbleConfig)localObject).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if (a(paramString, (BubbleConfig)localObject, ((BubbleConfig)localObject).jdField_d_of_type_ComTencentMobileqqBubbleAnimationConfig)) {
      return ((BubbleConfig)localObject).jdField_d_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if (a(paramString, (BubbleConfig)localObject, ((BubbleConfig)localObject).jdField_e_of_type_ComTencentMobileqqBubbleAnimationConfig)) {
      return ((BubbleConfig)localObject).jdField_e_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if (((BubbleConfig)localObject).jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = ((BubbleConfig)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AnimationConfig localAnimationConfig = (AnimationConfig)((Iterator)localObject).next();
        if (localAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString)) {
          return localAnimationConfig;
        }
      }
    }
    return null;
  }
  
  BubbleConfig a(int paramInt, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("createBubbleConfig, bubbleId = ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(" path = ");
    ((StringBuilder)localObject1).append(paramString);
    b(((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = a(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("content:");
      ((StringBuilder)localObject1).append(paramString);
      a(((StringBuilder)localObject1).toString());
      localObject1 = b(paramString);
      paramString = new BubbleConfig(paramInt);
      localObject1 = new JSONObject((String)localObject1);
      paramString.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).getString("name");
      i(paramString, (JSONObject)localObject1);
      f(paramString, (JSONObject)localObject1);
      paramString.jdField_a_of_type_Double = ((JSONObject)localObject1).optDouble("color_threshold_factor", 1.0D);
      Object localObject2;
      if (((JSONObject)localObject1).has("zoom_point"))
      {
        localObject2 = ((JSONObject)localObject1).getJSONArray("zoom_point");
        paramString.jdField_a_of_type_ArrayOfInt = new int[] { ((JSONArray)localObject2).getInt(0), ((JSONArray)localObject2).getInt(1) };
      }
      c(paramString, (JSONObject)localObject1);
      a(paramString, (JSONObject)localObject1);
      b(paramString, (JSONObject)localObject1);
      paramString.jdField_a_of_type_JavaUtilHashMap = DiyBubbleConfig.a(paramInt, (JSONObject)localObject1);
      e(paramString, (JSONObject)localObject1);
      if (((JSONObject)localObject1).has("interaction_animation"))
      {
        localObject2 = ((JSONObject)localObject1).getJSONObject("interaction_animation");
        JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("key_word");
        paramString.jdField_b_of_type_JavaUtilHashMap = new HashMap();
        a(paramString, localJSONArray);
        paramString.jdField_f_of_type_Int = ((JSONObject)localObject1).optInt("package_id", -1);
        if (paramString.jdField_f_of_type_Int == -1) {
          paramString.jdField_f_of_type_Int = ((JSONObject)localObject1).optInt("groupId", -1);
        }
        paramString.jdField_g_of_type_Int = ((JSONObject)localObject1).optInt("groupType", 2);
        a(paramString, (JSONObject)localObject1, (JSONObject)localObject2, "animation_start");
        a(paramString, (JSONObject)localObject1, (JSONObject)localObject2, "animation_running");
        a(paramString, (JSONObject)localObject1, (JSONObject)localObject2, "animation_end");
        a(paramString, (JSONObject)localObject1, (JSONObject)localObject2, "passive_animation");
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("BubbleManager", 1, "null pointer or index out of range or other error", paramString);
      return null;
    }
    catch (JSONException paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bubble ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" json file invalidate exception=");
      QLog.e("BubbleManager", 1, ((StringBuilder)localObject1).toString(), paramString);
    }
    return null;
  }
  
  public BubbleConfig a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      return null;
    }
    BubbleConfig localBubbleConfig = (BubbleConfig)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.get(Integer.valueOf(paramInt));
    if (localBubbleConfig == null) {
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        ThreadManager.post(new BubbleManager.HandleBubbleConfigRunnable(this, paramInt, paramBoolean), 5, null, true);
      } else {
        new BubbleManager.HandleBubbleConfigRunnable(this, paramInt, paramBoolean).run();
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBubbleConfig bubbleId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",autoDownload=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",bubbleConfig=");
      localStringBuilder.append(localBubbleConfig);
      QLog.d("BubbleManager", 2, localStringBuilder.toString());
    }
    return localBubbleConfig;
  }
  
  public BubbleInfo a(int paramInt, boolean paramBoolean)
  {
    if (paramInt < 1) {
      return null;
    }
    ??? = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
    Object localObject2;
    if (??? != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getBubbleInfo, from cache, bubbleId=");
        ((StringBuilder)localObject2).append(paramInt);
        QLog.d("BubbleManager", 2, ((StringBuilder)localObject2).toString());
      }
      return ???;
    }
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))) {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        localObject2 = new BubbleManager.2(this, paramInt);
        this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(paramInt));
        ThreadManager.post((Runnable)localObject2, 8, null, true);
        return null;
      }
    }
    return null;
  }
  
  public Pair<BubbleInfo.CommonAttrs, BubbleInfo.CommonAttrs> a(int paramInt, AnimationConfig paramAnimationConfig, boolean paramBoolean)
  {
    if ((paramAnimationConfig != null) && (!TextUtils.isEmpty(paramAnimationConfig.jdField_a_of_type_JavaLangString)))
    {
      if (TextUtils.isEmpty(paramAnimationConfig.jdField_b_of_type_JavaLangString)) {
        return null;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseAnimToCommonAttrs, bubbleId = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" autoDown = ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.i("BubbleManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = a(paramInt, paramAnimationConfig.jdField_b_of_type_JavaLangString, paramBoolean, false);
      if (localObject == null) {
        return null;
      }
      boolean bool = paramAnimationConfig.jdField_a_of_type_JavaLangString.equals(paramAnimationConfig.jdField_c_of_type_JavaLangString);
      return new Pair(localObject, a(paramInt, paramAnimationConfig.jdField_c_of_type_JavaLangString, paramBoolean, bool));
    }
    return null;
  }
  
  public Pair<BubbleInfo.CommonAttrs, BubbleInfo.CommonAttrs> a(int paramInt, String paramString, Pair<BubbleInfo.CommonAttrs, BubbleInfo.CommonAttrs> paramPair)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("chkAnimCommAttrs, bubbleId = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" animName = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" commonAttrs is null ? ");
      boolean bool;
      if (paramPair == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(String.valueOf(bool));
      QLog.i("BubbleManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramPair;
    if (paramPair == null)
    {
      paramString = a(paramInt, a(paramInt, paramString), true);
      localObject = paramString;
      if (paramString != null)
      {
        paramPair = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
        localObject = paramString;
        if (paramPair != null)
        {
          paramPair.jdField_a_of_type_JavaUtilList.add(paramString);
          localObject = paramString;
        }
      }
    }
    return localObject;
  }
  
  public File a()
  {
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "bubble_info");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public File a(int paramInt)
  {
    File localFile = new File(a(), String.valueOf(paramInt));
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public File a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = a().getAbsolutePath();
    Object localObject1 = localObject2;
    if (paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/temp");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = AIOUtils.a();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separatorChar);
    ((StringBuilder)localObject2).append(paramInt);
    localObject1 = new File(((StringBuilder)localObject2).toString());
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    return localObject1;
  }
  
  public Boolean a(int paramInt)
  {
    boolean bool2 = new File(a(), Integer.toString(paramInt)).exists();
    boolean bool1 = false;
    if (!bool2)
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("bubble dir does not exist id:");
        ((StringBuilder)???).append(paramInt);
        QLog.d("BubbleManager", 2, ((StringBuilder)???).toString());
      }
      return Boolean.valueOf(false);
    }
    synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
    {
      JSONObject localJSONObject = (JSONObject)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(Integer.valueOf(paramInt));
      if (localJSONObject != null)
      {
        if (localJSONObject.optInt("full_download") == 1) {
          bool1 = true;
        }
        return Boolean.valueOf(bool1);
      }
      bool1 = b(paramInt);
      return Boolean.valueOf(bool1);
    }
  }
  
  public String a(String paramString)
  {
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getConfigContent file not exist : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("BubbleManager", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    try
    {
      paramString = FileUtils.readFileToString((File)localObject);
      return paramString;
    }
    catch (IOException paramString)
    {
      QLog.e("BubbleManager", 1, paramString, new Object[0]);
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("BubbleManager", 2, paramString, new Object[0]);
    }
    return null;
  }
  
  public JSONObject a(int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      int i;
      float f;
      try
      {
        boolean bool = a(paramInt).booleanValue();
        i = 0;
        if (bool)
        {
          localJSONObject2.put("status", 3);
          localJSONObject2.put("progress", 100);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", HardCodeUtil.a(2131701430));
        }
        else if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
        {
          f = ((Float)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).floatValue();
          if (f == 1.0F)
          {
            localJSONObject2.put("status", 3);
            localJSONObject1.put("result", 0);
            localJSONObject1.put("message", HardCodeUtil.a(2131701433));
            break label415;
          }
          if (f == 2.0F)
          {
            localJSONObject2.put("status", 1);
            localJSONObject1.put("result", -1);
            localJSONObject1.put("message", HardCodeUtil.a(2131701431));
            break label415;
          }
          localJSONObject2.put("status", 2);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", HardCodeUtil.a(2131701429));
          break label415;
          localJSONObject2.put("canceling", i);
          localJSONObject2.put("progress", f * 100.0F);
        }
        else
        {
          localJSONObject2.put("status", 1);
          localJSONObject2.put("progress", 0);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", HardCodeUtil.a(2131701428));
        }
        localJSONObject2.put("id", paramInt);
        localJSONObject1.put("data", localJSONObject2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryInfo bubbleId=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(",json=");
        localStringBuilder.append(localJSONObject1.toString());
        QLog.d("BubbleManager", 2, localStringBuilder.toString());
      }
      return localJSONObject1;
      label415:
      if (f == 3.0F) {
        i = 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
      {
        JSONObject localJSONObject2 = (JSONObject)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(Integer.valueOf(paramInt));
        JSONObject localJSONObject1 = localJSONObject2;
        if (localJSONObject2 == null) {
          localJSONObject1 = new JSONObject();
        }
        localJSONObject1.put("full_download", 1);
        localJSONObject1.put("id", paramInt);
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(Integer.valueOf(paramInt), localJSONObject1);
        a(paramInt, localJSONObject1);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownload id=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" callbackId = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("BubbleManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    if (paramString != null)
    {
      ((Bundle)localObject).putInt("srcType", 3);
      ((Bundle)localObject).putString("callbackId", paramString);
    }
    IPCDownloadListener localIPCDownloadListener;
    if (a(paramInt).booleanValue())
    {
      localIPCDownloadListener = this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener;
      if ((localIPCDownloadListener != null) && (paramString != null)) {
        localIPCDownloadListener.a(paramInt, 3, (Bundle)localObject);
      }
      return;
    }
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      localIPCDownloadListener = this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener;
      if ((localIPCDownloadListener != null) && (paramString != null)) {
        localIPCDownloadListener.a(paramInt, -1, (Bundle)localObject);
      }
      return;
    }
    a(paramInt, null, paramString);
  }
  
  public void a(int paramInt, String arg2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadBubble, bubbleId = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" pkgName = ");
      ((StringBuilder)localObject).append(???);
      ((StringBuilder)localObject).append(" from = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("BubbleManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bubble.android.");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(???);
    localObject = ((StringBuilder)localObject).toString();
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    if (localIVasQuickUpdateService != null) {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.contains(localObject))
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append((String)localObject);
            paramString2.append(" is downloading, remove duplicate download.");
            QLog.d("BubbleManager", 2, paramString2.toString());
          }
          return;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" is downloading, remove duplicate download.");
          QLog.d("BubbleManager", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        localIVasQuickUpdateService.downloadItem(2L, (String)localObject, paramString2);
        return;
      }
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString, String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("downloadBubbleGather, bubbleId = ");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(" pkgName[]= ");
      ((StringBuilder)???).append(paramArrayOfString);
      ((StringBuilder)???).append(" from = ");
      ((StringBuilder)???).append(paramString);
      QLog.i("BubbleManager", 2, ((StringBuilder)???).toString());
    }
    if (paramInt == 0) {
      return;
    }
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    if (localIVasQuickUpdateService != null)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("bubble.android.");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(".");
      ((StringBuilder)???).append("all.zip");
      String str = ((StringBuilder)???).toString();
      if ("0".equals(paramString)) {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          if (this.jdField_a_of_type_JavaUtilList.contains(str))
          {
            if (QLog.isColorLevel())
            {
              paramArrayOfString = new StringBuilder();
              paramArrayOfString.append(str);
              paramArrayOfString.append(" is downloading, remove duplicate download.");
              QLog.d("BubbleManager", 2, paramArrayOfString.toString());
            }
            return;
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append(" add download queue.");
            QLog.d("BubbleManager", 2, localStringBuilder.toString());
          }
          this.jdField_a_of_type_JavaUtilList.add(str);
        }
      }
      ??? = paramArrayOfString;
      if (paramArrayOfString == null)
      {
        ??? = new String[3];
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("bubble.android.");
        paramArrayOfString.append(paramInt);
        paramArrayOfString.append(".");
        paramArrayOfString.append("config.json");
        ???[0] = paramArrayOfString.toString();
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("bubble.android.");
        paramArrayOfString.append(paramInt);
        paramArrayOfString.append(".");
        paramArrayOfString.append("static.zip");
        ???[1] = paramArrayOfString.toString();
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("bubble.android.");
        paramArrayOfString.append(paramInt);
        paramArrayOfString.append(".");
        paramArrayOfString.append("other.zip");
        ???[2] = paramArrayOfString.toString();
      }
      localIVasQuickUpdateService.downloadGatherItem(2L, str, (String[])???, paramString);
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Float.valueOf(0.0F));
    }
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  void a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    int i = NetworkUtil.getSystemNetwork(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject != null) {
      localObject = VipUtils.a((AppInterface)localObject, ((AppInterface)localObject).getCurrentAccountUin());
    } else {
      localObject = "0";
    }
    ReportController.b(null, "CliOper", "", "", "Bubble", paramString1, 0, (int)paramLong, String.valueOf(paramInt), (String)localObject, Integer.toString(i), paramString2);
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!paramString1.startsWith("bubble.android.")) {
        return;
      }
      if (paramString1.endsWith("all.zip"))
      {
        int i = a(paramString1);
        float f = (float)paramLong1 / (float)paramLong2;
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), Float.valueOf(f));
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, String.format("onPasterDownloadComplete, scid %s, errorcode %d", new Object[] { paramString1, Integer.valueOf(paramInt1) }));
    }
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("bubble.paster.")))
    {
      paramString1 = paramString1.replace("bubble.paster.", "").replace(".png", "");
      BubbleDiyFetcher.a().b(paramString1);
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = DownloaderFactory.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext());
    boolean bool1;
    if ((bool2) && (!a(paramInt).booleanValue())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bubbleId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",isQualityNetwork=");
      localStringBuilder.append(bool2);
      localStringBuilder.append(",canFullDown=");
      localStringBuilder.append(bool1);
      QLog.d("BubbleManager", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    Object localObject1 = a(paramInt1, false);
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = new ArrayList();
    a(paramInt2, (BubbleConfig)localObject1, (List)localObject2);
    if (((List)localObject2).size() > 0)
    {
      localObject1 = ((List)localObject2).iterator();
      paramInt2 = 1;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BubbleNewAnimConf)((Iterator)localObject1).next();
        if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((BubbleNewAnimConf)localObject2).jdField_a_of_type_JavaLangString))
        {
          Object localObject3 = new File(a(paramInt1), ((BubbleNewAnimConf)localObject2).jdField_d_of_type_JavaLangString);
          int i = 0;
          Object localObject4;
          do
          {
            j = paramInt2;
            if (i >= ((BubbleNewAnimConf)localObject2).jdField_b_of_type_Int) {
              break;
            }
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(((File)localObject3).getAbsolutePath());
            ((StringBuilder)localObject4).append(File.separatorChar);
            ((StringBuilder)localObject4).append(((BubbleNewAnimConf)localObject2).jdField_b_of_type_JavaLangString);
            i += 1;
            ((StringBuilder)localObject4).append(String.format("%04d.png", new Object[] { Integer.valueOf(i) }));
            localObject4 = ((StringBuilder)localObject4).toString();
          } while (new File((String)localObject4).exists());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("anim conf, file is not exit, ");
          ((StringBuilder)localObject3).append((String)localObject4);
          QLog.e("BubbleManager", 2, ((StringBuilder)localObject3).toString());
          int j = 0;
          paramInt2 = j;
          if (j != 0)
          {
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((BubbleNewAnimConf)localObject2).jdField_a_of_type_JavaLangString, localObject2);
            paramInt2 = j;
          }
        }
      }
      if (paramInt2 == 0)
      {
        a(paramInt1, "other.zip", "0");
        return false;
      }
      return true;
    }
    return false;
  }
  
  boolean a(int paramInt, boolean paramBoolean)
  {
    long l = SystemClock.uptimeMillis();
    b(paramInt, paramBoolean);
    Object localObject1 = a(paramInt, paramBoolean);
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createBubbleInfo, no config, bubbleId=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.e("BubbleManager", 1, ((StringBuilder)localObject1).toString());
      this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
      return false;
    }
    for (;;)
    {
      try
      {
        localObject1 = a(paramInt, (BubbleConfig)localObject1);
        boolean bool = a((BubbleInfo)localObject1);
        a(paramInt, bool);
        if (!bool)
        {
          if (paramBoolean) {
            b(paramInt);
          }
          this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
          return false;
        }
        if (!TextUtils.isEmpty(((BubbleInfo)localObject1).jdField_a_of_type_JavaLangString))
        {
          i = 1;
          paramBoolean = TextUtils.isEmpty(((BubbleInfo)localObject1).jdField_b_of_type_JavaLangString);
          if ((i == 0) || (!(paramBoolean ^ true))) {
            break label535;
          }
          paramBoolean = true;
          Object localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inDensity = 320;
          ((BitmapFactory.Options)localObject2).inTargetDensity = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
          localObject2 = new BubbleManager.NineBiitmapLoad(this, paramInt, (BubbleInfo)localObject1, paramBoolean, null, (BitmapFactory.Options)localObject2).a();
          paramBoolean = ((BubbleManager.NineBiitmapLoad)localObject2).a();
          localObject2 = ((BubbleManager.NineBiitmapLoad)localObject2).a();
          if (!paramBoolean)
          {
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("createBubbleInfo, load nine patch failed, abort, bubbleId=");
            ((StringBuilder)localObject3).append(paramInt);
            QLog.e("BubbleManager", 1, ((StringBuilder)localObject3).toString());
            localObject3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("norPath:");
            localStringBuilder.append(((BubbleInfo)localObject1).jdField_a_of_type_JavaLangString);
            localStringBuilder.append(", animatePath:");
            localStringBuilder.append(((BubbleInfo)localObject1).jdField_b_of_type_JavaLangString);
            VasMonitorHandler.a((AppRuntime)localObject3, "individual_v2_bubble_9png_err", (String)localObject2, localStringBuilder.toString(), null, 0.0F);
            VasMonitorDT.a("individual_v2_bubble_9png_err", (String)localObject2);
            this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
            return false;
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.put(Integer.valueOf(paramInt), localObject1);
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
          {
            VasUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
            localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(FontSettingActivity.class);
            if (localObject1 != null)
            {
              ((MqqHandler)localObject1).removeMessages(16711697);
              ((MqqHandler)localObject1).sendMessageDelayed(((MqqHandler)localObject1).obtainMessage(16711697), jdField_a_of_type_Long);
            }
          }
          this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("createBubbleInfo, duration=");
            ((StringBuilder)localObject1).append(SystemClock.uptimeMillis() - l);
            ((StringBuilder)localObject1).append(", bubbleId=");
            ((StringBuilder)localObject1).append(paramInt);
            QLog.d("BubbleManager", 2, ((StringBuilder)localObject1).toString());
          }
          return true;
        }
      }
      catch (Exception localException)
      {
        QLog.e("BubbleManager", 1, "createBubbleInfo failed", localException);
        return false;
      }
      int i = 0;
      continue;
      label535:
      paramBoolean = false;
    }
  }
  
  public boolean a(long paramLong)
  {
    BubbleManager.BubbleInfoLruCache localBubbleInfoLruCache = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache;
    return (localBubbleInfoLruCache != null) && (localBubbleInfoLruCache.a((int)paramLong));
  }
  
  public boolean a(String paramString)
  {
    a(paramString, "isBubblePasterExists scid: ");
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("bubble.paster.")))
    {
      paramString = paramString.replace("bubble.paster.", "");
      paramString = new File(a(), paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isBubblePasterExists file is Exits: ");
        localStringBuilder.append(paramString.exists());
        localStringBuilder.append(", path:");
        localStringBuilder.append(paramString.getAbsolutePath());
        QLog.i("BubbleManager", 2, localStringBuilder.toString());
      }
      return paramString.exists();
    }
    return false;
  }
  
  public File b()
  {
    File localFile = new File(a(), "bubble_paster");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public JSONObject b(int paramInt)
  {
    Object localObject = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    StringBuilder localStringBuilder;
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bubble.android.");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(".");
      localStringBuilder.append("all.zip");
      ((IVasQuickUpdateService)localObject).cancelDwonloadItem(2L, localStringBuilder.toString());
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("status", 0);
      ((JSONObject)localObject).put("message", HardCodeUtil.a(2131701432));
      ((JSONObject)localObject).put("id", paramInt);
      ((JSONObject)localObject).put("result", 0);
      label121:
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopDownload id=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(",status=");
        localStringBuilder.append(0);
        QLog.d("BubbleManager", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Float.valueOf(3.0F));
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      break label121;
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString3, paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!paramString1.startsWith("bubble.android.")) {
        return;
      }
      paramInt2 = a(paramString1, paramInt1);
      if (paramString1.endsWith("config.json"))
      {
        a(paramInt1, paramInt2);
        return;
      }
      if (paramString1.endsWith("all.zip"))
      {
        b(paramString3, paramInt1, paramInt2);
        return;
      }
      if (paramString1.endsWith("static.zip"))
      {
        a(paramString3, paramInt1, paramInt2);
        return;
      }
      if ((paramString1.endsWith("other.zip")) && (paramInt1 == 0)) {
        a(paramInt2, false);
      }
    }
  }
  
  public boolean b(String paramString)
  {
    a(paramString, "scid isFileExists: ");
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("bubble.android.")) {
        return false;
      }
      int i = a(paramString);
      if (i > 0)
      {
        if (paramString.endsWith("config.json")) {
          return new File(a(i), "config.json").exists();
        }
        if (paramString.endsWith("static.zip"))
        {
          paramString = c(i);
          if (paramString != null) {
            return paramString.booleanValue();
          }
        }
        else if (paramString.endsWith("other.zip"))
        {
          paramString = b(i);
          if (paramString != null) {
            return paramString.booleanValue();
          }
        }
      }
    }
    return false;
  }
  
  public File c()
  {
    File localFile = new File(a(), "bubble_local/");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "onDestroy...");
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.a();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.clear();
    jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager
 * JD-Core Version:    0.7.0.1
 */