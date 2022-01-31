package com.tencent.mobileqq.bubble;

import ablj;
import ablk;
import abll;
import ablm;
import abln;
import ablo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BubbleManager
  implements Manager
{
  public static volatile int a;
  public static long a;
  public static volatile boolean a;
  float jdField_a_of_type_Float = 1.0F;
  protected abln a;
  protected Context a;
  protected AppInterface a;
  public BubbleManager.LruLinkedHashMap a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new ablk(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  IPCDownloadListener jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new ablm(this);
  private final List jdField_a_of_type_JavaUtilList = new ArrayList();
  Map jdField_a_of_type_JavaUtilMap;
  protected Vector a;
  public ConcurrentHashMap a;
  public JSONArray a;
  private int b;
  public ConcurrentHashMap b;
  
  static
  {
    jdField_a_of_type_Long = 1000L;
  }
  
  public BubbleManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_OrgJsonJSONArray = null;
    this.jdField_b_of_type_Int = 2000000;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext();
    this.jdField_a_of_type_Abln = new abln(this, 2010, 50, 10);
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap = new BubbleManager.LruLinkedHashMap(this, 9);
    paramAppInterface = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    if (paramAppInterface.density == 160.0F) {}
    for (;;)
    {
      this.jdField_a_of_type_Float = f;
      this.jdField_a_of_type_OrgJsonJSONArray = a();
      this.jdField_a_of_type_JavaUtilVector = new Vector(16);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      return;
      f = paramAppInterface.density;
    }
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("T")) {
        if (paramBoolean) {}
      }
      do
      {
        return 3;
        return 4;
        if (paramString.equals("L"))
        {
          if (!paramBoolean) {
            return 2;
          }
          return 7;
        }
        if (paramString.equals("TL"))
        {
          if (!paramBoolean) {
            return 0;
          }
          return 5;
        }
        if (!paramString.equals("B")) {
          break;
        }
      } while (paramBoolean);
      return 4;
      if (paramString.equals("BL"))
      {
        if (!paramBoolean) {
          return 1;
        }
        return 6;
      }
      if (paramString.equals("R"))
      {
        if (!paramBoolean) {
          return 7;
        }
        return 2;
      }
      if (paramString.equals("TR"))
      {
        if (!paramBoolean) {
          return 5;
        }
        return 0;
      }
      if (paramString.equals("BR"))
      {
        if (!paramBoolean) {
          return 6;
        }
        return 1;
      }
    }
    return -1;
  }
  
  /* Error */
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 172	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 175	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: new 177	java/io/BufferedInputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 180	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore 5
    //   22: aload_1
    //   23: ifnull +43 -> 66
    //   26: aload_2
    //   27: astore 4
    //   29: aload 5
    //   31: astore_3
    //   32: aload 5
    //   34: aconst_null
    //   35: aload_1
    //   36: invokestatic 186	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   39: astore_1
    //   40: aload_1
    //   41: astore_0
    //   42: aload_2
    //   43: ifnull +7 -> 50
    //   46: aload_2
    //   47: invokevirtual 191	java/io/InputStream:close	()V
    //   50: aload_0
    //   51: astore_2
    //   52: aload 5
    //   54: ifnull +10 -> 64
    //   57: aload 5
    //   59: invokevirtual 191	java/io/InputStream:close	()V
    //   62: aload_0
    //   63: astore_2
    //   64: aload_2
    //   65: areturn
    //   66: aload_2
    //   67: astore 4
    //   69: aload 5
    //   71: astore_3
    //   72: aload 5
    //   74: invokestatic 194	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: goto -38 -> 42
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_2
    //   86: aconst_null
    //   87: astore_0
    //   88: aload_2
    //   89: astore 4
    //   91: aload_0
    //   92: astore_3
    //   93: ldc 196
    //   95: iconst_1
    //   96: new 198	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   103: ldc 201
    //   105: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_1
    //   109: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 218	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_2
    //   119: ifnull +7 -> 126
    //   122: aload_2
    //   123: invokevirtual 191	java/io/InputStream:close	()V
    //   126: aload 7
    //   128: astore_2
    //   129: aload_0
    //   130: ifnull -66 -> 64
    //   133: aload_0
    //   134: invokevirtual 191	java/io/InputStream:close	()V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: aconst_null
    //   141: areturn
    //   142: astore 6
    //   144: aconst_null
    //   145: astore_2
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_2
    //   149: astore 4
    //   151: aload_1
    //   152: astore_3
    //   153: ldc 196
    //   155: iconst_1
    //   156: new 198	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   163: ldc 220
    //   165: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_0
    //   169: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: aload 6
    //   177: invokestatic 223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 191	java/io/InputStream:close	()V
    //   188: aload 7
    //   190: astore_2
    //   191: aload_1
    //   192: ifnull -128 -> 64
    //   195: aload_1
    //   196: invokevirtual 191	java/io/InputStream:close	()V
    //   199: aconst_null
    //   200: areturn
    //   201: astore_0
    //   202: aconst_null
    //   203: areturn
    //   204: astore_0
    //   205: aconst_null
    //   206: astore_2
    //   207: aconst_null
    //   208: astore_3
    //   209: aload_2
    //   210: ifnull +7 -> 217
    //   213: aload_2
    //   214: invokevirtual 191	java/io/InputStream:close	()V
    //   217: aload_3
    //   218: ifnull +7 -> 225
    //   221: aload_3
    //   222: invokevirtual 191	java/io/InputStream:close	()V
    //   225: aload_0
    //   226: athrow
    //   227: astore_1
    //   228: goto -178 -> 50
    //   231: astore_1
    //   232: aload_0
    //   233: areturn
    //   234: astore_1
    //   235: goto -109 -> 126
    //   238: astore_0
    //   239: goto -51 -> 188
    //   242: astore_1
    //   243: goto -26 -> 217
    //   246: astore_1
    //   247: goto -22 -> 225
    //   250: astore_0
    //   251: aconst_null
    //   252: astore_3
    //   253: goto -44 -> 209
    //   256: astore_0
    //   257: aload 4
    //   259: astore_2
    //   260: goto -51 -> 209
    //   263: astore 6
    //   265: aconst_null
    //   266: astore_1
    //   267: goto -119 -> 148
    //   270: astore 6
    //   272: aload 5
    //   274: astore_1
    //   275: goto -127 -> 148
    //   278: astore_1
    //   279: aconst_null
    //   280: astore_0
    //   281: goto -193 -> 88
    //   284: astore_1
    //   285: aload 5
    //   287: astore_0
    //   288: goto -200 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	paramString	String
    //   0	291	1	paramOptions	BitmapFactory.Options
    //   11	249	2	localObject1	Object
    //   31	222	3	localObject2	Object
    //   27	231	4	localObject3	Object
    //   20	266	5	localBufferedInputStream	java.io.BufferedInputStream
    //   142	34	6	localOutOfMemoryError1	OutOfMemoryError
    //   263	1	6	localOutOfMemoryError2	OutOfMemoryError
    //   270	1	6	localOutOfMemoryError3	OutOfMemoryError
    //   1	188	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   3	12	83	java/lang/Exception
    //   133	137	139	java/io/IOException
    //   3	12	142	java/lang/OutOfMemoryError
    //   195	199	201	java/io/IOException
    //   3	12	204	finally
    //   46	50	227	java/io/IOException
    //   57	62	231	java/io/IOException
    //   122	126	234	java/io/IOException
    //   184	188	238	java/io/IOException
    //   213	217	242	java/io/IOException
    //   221	225	246	java/io/IOException
    //   12	22	250	finally
    //   32	40	256	finally
    //   72	78	256	finally
    //   93	118	256	finally
    //   153	180	256	finally
    //   12	22	263	java/lang/OutOfMemoryError
    //   32	40	270	java/lang/OutOfMemoryError
    //   72	78	270	java/lang/OutOfMemoryError
    //   12	22	278	java/lang/Exception
    //   32	40	284	java/lang/Exception
    //   72	78	284	java/lang/Exception
  }
  
  private Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect();
    localRect.set((int)(paramInt1 / 2.0F * this.jdField_a_of_type_Float), (int)(paramInt2 / 2.0F * this.jdField_a_of_type_Float), (int)(paramInt3 / 2.0F * this.jdField_a_of_type_Float), (int)(paramInt4 / 2.0F * this.jdField_a_of_type_Float));
    return localRect;
  }
  
  private AnimationConfig.AnimationStep a(String paramString, JSONObject paramJSONObject)
  {
    AnimationConfig.AnimationStep localAnimationStep = new AnimationConfig.AnimationStep();
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseEachStepAttrInPathAnim jsonObject = null");
      paramString = null;
    }
    do
    {
      return paramString;
      if (paramJSONObject.has("count")) {
        localAnimationStep.jdField_a_of_type_Int = paramJSONObject.getInt("count");
      }
      if (paramJSONObject.has("cycle_count")) {
        localAnimationStep.jdField_b_of_type_Int = paramJSONObject.getInt("cycle_count");
      }
      paramString = localAnimationStep;
    } while (!paramJSONObject.has("prefix_name"));
    localAnimationStep.jdField_a_of_type_JavaLangString = paramJSONObject.getString("prefix_name");
    return localAnimationStep;
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
    if (paramJSONObject.has("rect"))
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("rect");
      localAnimationConfig.jdField_a_of_type_ArrayOfInt = new int[4];
      paramInt = 0;
      while (paramInt < localJSONArray.length())
      {
        localAnimationConfig.jdField_a_of_type_ArrayOfInt[paramInt] = localJSONArray.getInt(paramInt);
        paramInt += 1;
      }
    }
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
    if ((!paramJSONObject.has("count_stiil")) || (paramJSONObject.has("alpha"))) {
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
    Object localObject;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseBubbleFrameAnimationConfig object = null");
      localObject = null;
    }
    AnimationConfig localAnimationConfig;
    do
    {
      return localObject;
      localAnimationConfig = new AnimationConfig();
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
      localObject = localAnimationConfig;
    } while (!paramJSONObject.has("time"));
    localAnimationConfig.jdField_d_of_type_Int = paramJSONObject.getInt("time");
    return localAnimationConfig;
  }
  
  private BubbleInfo.CommonAttrs a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "getAttrsByConfig, bubbleId = " + paramInt + " animName = " + paramString + " autoDown = " + paramBoolean1 + " reversion = " + paramBoolean2);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    AnimationConfig localAnimationConfig = a(paramInt, paramString);
    if (localAnimationConfig == null) {
      return null;
    }
    BubbleInfo.CommonAttrs localCommonAttrs = new BubbleInfo.CommonAttrs();
    localCommonAttrs.jdField_a_of_type_Int = localAnimationConfig.jdField_c_of_type_Int;
    localCommonAttrs.jdField_c_of_type_Int = localAnimationConfig.jdField_d_of_type_Int;
    localCommonAttrs.jdField_b_of_type_Int = localAnimationConfig.jdField_b_of_type_Int;
    localCommonAttrs.jdField_b_of_type_Boolean = localAnimationConfig.jdField_a_of_type_Boolean;
    localCommonAttrs.jdField_e_of_type_Int = localAnimationConfig.jdField_e_of_type_Int;
    localCommonAttrs.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig = localAnimationConfig;
    File localFile;
    String[] arrayOfString;
    int k;
    int i;
    Object localObject;
    label225:
    label228:
    int j;
    boolean bool;
    if (localCommonAttrs.jdField_b_of_type_Int <= 1)
    {
      localCommonAttrs.jdField_a_of_type_Boolean = true;
      localFile = new File(a(paramInt), localAnimationConfig.jdField_a_of_type_JavaLangString);
      arrayOfString = new String[localAnimationConfig.jdField_c_of_type_Int];
      k = 0;
      i = 0;
      if (localAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray != null) {
        break label422;
      }
      if (localAnimationConfig.jdField_a_of_type_Int != 4) {
        break label405;
      }
      localObject = "%04d.9.png";
      i = 0;
      j = k;
      if (i >= arrayOfString.length) {
        break label778;
      }
      arrayOfString[i] = (localFile.getAbsolutePath() + File.separatorChar + String.format((String)localObject, new Object[] { Integer.valueOf(i + 1) }));
      bool = new File(arrayOfString[i]).exists();
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "checkBubbleSource|pngs[" + i + "]=" + arrayOfString[i] + ",isFileExists=" + bool);
      }
      if (bool) {
        break label413;
      }
      i = 1;
    }
    for (;;)
    {
      label405:
      label413:
      label422:
      int m;
      if ((paramBoolean1) && (i != 0))
      {
        a(paramInt, "other.zip", "0");
        return null;
        localCommonAttrs.jdField_a_of_type_Boolean = false;
        break;
        localObject = "%04d.png";
        break label225;
        i += 1;
        break label228;
        int n = localAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.size();
        m = 0;
        k = 0;
        label438:
        j = i;
        if (m >= n) {
          break label778;
        }
        localObject = (AnimationConfig.AnimationStep)localAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.valueAt(m);
        j = 0;
        label467:
        if (j >= ((AnimationConfig.AnimationStep)localObject).jdField_a_of_type_Int) {
          break label775;
        }
        arrayOfString[(j + k)] = (localFile.getAbsolutePath() + File.separatorChar + ((AnimationConfig.AnimationStep)localObject).jdField_a_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(j + 1) }));
        bool = new File(arrayOfString[(j + k)]).exists();
        if (QLog.isColorLevel()) {
          QLog.d("BubbleManager", 2, "checkBubbleSource|pngs[" + j + "]=" + arrayOfString[j] + ",isFileExists=" + bool);
        }
        if (!bool) {
          i = 1;
        }
      }
      label775:
      for (;;)
      {
        if (i != 0)
        {
          break;
          j += 1;
          break label467;
        }
        j = ((AnimationConfig.AnimationStep)localObject).jdField_a_of_type_Int;
        m += 1;
        k += j;
        break label438;
        if (i != 0) {
          return null;
        }
        if (arrayOfString.length > 0) {}
        for (localObject = arrayOfString;; localObject = null)
        {
          localCommonAttrs.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
          localCommonAttrs.jdField_b_of_type_JavaLangString = paramString;
          localCommonAttrs.jdField_d_of_type_Int = a(localAnimationConfig.jdField_d_of_type_JavaLangString, paramBoolean2);
          if ((localAnimationConfig.jdField_a_of_type_ArrayOfInt != null) && (localAnimationConfig.jdField_a_of_type_ArrayOfInt.length > 0)) {
            localCommonAttrs.jdField_a_of_type_AndroidGraphicsRect = a(localAnimationConfig.jdField_a_of_type_ArrayOfInt[0], localAnimationConfig.jdField_a_of_type_ArrayOfInt[1], localAnimationConfig.jdField_a_of_type_ArrayOfInt[2], localAnimationConfig.jdField_a_of_type_ArrayOfInt[3]);
          }
          return localCommonAttrs;
        }
      }
      label778:
      i = j;
    }
  }
  
  private BubbleNewAnimConf a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "getPendantAnimConf object == null");
      localObject = null;
    }
    BubbleNewAnimConf.PendantAnimConf localPendantAnimConf;
    do
    {
      return localObject;
      localPendantAnimConf = new BubbleNewAnimConf.PendantAnimConf();
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
      localObject = localPendantAnimConf;
    } while (!paramJSONObject.has("play_with"));
    localPendantAnimConf.e = paramJSONObject.getString("play_with");
    return localPendantAnimConf;
  }
  
  /* Error */
  private Boolean a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 46	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   14: ifnonnull +10 -> 24
    //   17: iconst_0
    //   18: invokestatic 479	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   21: astore_1
    //   22: aload_1
    //   23: areturn
    //   24: new 374	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: invokevirtual 482	com/tencent/mobileqq/bubble/BubbleManager:a	()Ljava/io/File;
    //   32: ldc_w 484
    //   35: invokespecial 380	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   38: astore_2
    //   39: aload_2
    //   40: invokevirtual 409	java/io/File:exists	()Z
    //   43: ifeq +8 -> 51
    //   46: aload_2
    //   47: invokevirtual 487	java/io/File:delete	()Z
    //   50: pop
    //   51: new 489	java/io/RandomAccessFile
    //   54: dup
    //   55: aload_2
    //   56: ldc_w 491
    //   59: invokespecial 492	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   62: astore_2
    //   63: aload_0
    //   64: getfield 46	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   67: astore 4
    //   69: aload 4
    //   71: monitorenter
    //   72: aload_2
    //   73: aload_0
    //   74: getfield 46	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   77: invokevirtual 493	org/json/JSONArray:toString	()Ljava/lang/String;
    //   80: invokevirtual 497	java/lang/String:getBytes	()[B
    //   83: invokevirtual 501	java/io/RandomAccessFile:write	([B)V
    //   86: aload_2
    //   87: invokevirtual 502	java/io/RandomAccessFile:close	()V
    //   90: aload 5
    //   92: astore_3
    //   93: aload 4
    //   95: monitorexit
    //   96: iconst_1
    //   97: invokestatic 479	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   100: astore_2
    //   101: aload_2
    //   102: astore_1
    //   103: iconst_0
    //   104: ifeq -82 -> 22
    //   107: new 504	java/lang/NullPointerException
    //   110: dup
    //   111: invokespecial 505	java/lang/NullPointerException:<init>	()V
    //   114: athrow
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 508	java/io/IOException:printStackTrace	()V
    //   120: aload_2
    //   121: areturn
    //   122: astore_3
    //   123: aload_2
    //   124: astore_1
    //   125: aload_3
    //   126: astore_2
    //   127: aload_1
    //   128: astore_3
    //   129: aload 4
    //   131: monitorexit
    //   132: aload_1
    //   133: astore_3
    //   134: aload_1
    //   135: astore 4
    //   137: aload_2
    //   138: athrow
    //   139: astore_2
    //   140: aload_3
    //   141: astore_1
    //   142: aload_2
    //   143: invokevirtual 509	java/io/FileNotFoundException:printStackTrace	()V
    //   146: aload_3
    //   147: ifnull +7 -> 154
    //   150: aload_3
    //   151: invokevirtual 502	java/io/RandomAccessFile:close	()V
    //   154: iconst_0
    //   155: invokestatic 479	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   158: areturn
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 508	java/io/IOException:printStackTrace	()V
    //   164: goto -10 -> 154
    //   167: astore_2
    //   168: aload 4
    //   170: astore_1
    //   171: aload_2
    //   172: invokevirtual 508	java/io/IOException:printStackTrace	()V
    //   175: aload 4
    //   177: ifnull -23 -> 154
    //   180: aload 4
    //   182: invokevirtual 502	java/io/RandomAccessFile:close	()V
    //   185: goto -31 -> 154
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 508	java/io/IOException:printStackTrace	()V
    //   193: goto -39 -> 154
    //   196: astore_3
    //   197: aload_1
    //   198: astore_2
    //   199: aload_3
    //   200: astore_1
    //   201: aload_2
    //   202: ifnull +7 -> 209
    //   205: aload_2
    //   206: invokevirtual 502	java/io/RandomAccessFile:close	()V
    //   209: aload_1
    //   210: athrow
    //   211: astore_2
    //   212: aload_2
    //   213: invokevirtual 508	java/io/IOException:printStackTrace	()V
    //   216: goto -7 -> 209
    //   219: astore_1
    //   220: goto -19 -> 201
    //   223: astore_1
    //   224: aload_2
    //   225: astore 4
    //   227: aload_1
    //   228: astore_2
    //   229: goto -61 -> 168
    //   232: astore_1
    //   233: aload_2
    //   234: astore_3
    //   235: aload_1
    //   236: astore_2
    //   237: goto -97 -> 140
    //   240: astore_2
    //   241: aload_3
    //   242: astore_1
    //   243: goto -116 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	BubbleManager
    //   4	99	1	localObject1	Object
    //   115	2	1	localIOException1	IOException
    //   124	18	1	localObject2	Object
    //   159	2	1	localIOException2	IOException
    //   170	1	1	localObject3	Object
    //   188	10	1	localIOException3	IOException
    //   200	10	1	localObject4	Object
    //   219	1	1	localObject5	Object
    //   223	5	1	localIOException4	IOException
    //   232	4	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   242	1	1	localObject6	Object
    //   38	100	2	localObject7	Object
    //   139	4	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   167	5	2	localIOException5	IOException
    //   198	8	2	localIOException6	IOException
    //   211	14	2	localIOException7	IOException
    //   228	9	2	localObject8	Object
    //   240	1	2	localObject9	Object
    //   9	84	3	localObject10	Object
    //   122	4	3	localObject11	Object
    //   128	23	3	localObject12	Object
    //   196	4	3	localObject13	Object
    //   234	8	3	localObject14	Object
    //   1	225	4	localObject15	Object
    //   6	85	5	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   107	115	115	java/io/IOException
    //   72	90	122	finally
    //   51	63	139	java/io/FileNotFoundException
    //   137	139	139	java/io/FileNotFoundException
    //   150	154	159	java/io/IOException
    //   51	63	167	java/io/IOException
    //   137	139	167	java/io/IOException
    //   180	185	188	java/io/IOException
    //   51	63	196	finally
    //   137	139	196	finally
    //   142	146	196	finally
    //   171	175	196	finally
    //   205	209	211	java/io/IOException
    //   63	72	219	finally
    //   63	72	223	java/io/IOException
    //   63	72	232	java/io/FileNotFoundException
    //   93	96	240	finally
    //   129	132	240	finally
  }
  
  private ArrayList a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramJSONArray.length());
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.getJSONObject(i);
      if (((JSONObject)localObject).has("pendent_prefix")) {}
      for (localObject = a((JSONObject)localObject);; localObject = b((JSONObject)localObject))
      {
        localArrayList.add(localObject);
        i += 1;
        break;
      }
    }
    return localArrayList;
  }
  
  private JSONObject a(String paramString, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("animations")) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.getJSONObject("animations");
    } while (paramJSONObject == null);
    return paramJSONObject.getJSONObject(paramString);
  }
  
  private void a(AnimationConfig paramAnimationConfig, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      QLog.e("BubbleManager", 1, "parseAttrInPathAnimation animation = null");
    }
    do
    {
      Object localObject;
      do
      {
        return;
        if (paramJSONObject.has("type"))
        {
          localObject = paramJSONObject.getString("type");
          if ("line".equalsIgnoreCase((String)localObject)) {
            paramAnimationConfig.jdField_e_of_type_Int = 10;
          }
          if ("circle".equalsIgnoreCase((String)localObject)) {
            paramAnimationConfig.jdField_e_of_type_Int = 11;
          }
          if ("static".equalsIgnoreCase((String)localObject)) {
            paramAnimationConfig.jdField_e_of_type_Int = 1;
          }
        }
        if (paramJSONObject.has("padding"))
        {
          localObject = paramJSONObject.getJSONArray("padding");
          paramAnimationConfig.jdField_f_of_type_Int = ((JSONArray)localObject).getInt(0);
          paramAnimationConfig.jdField_h_of_type_Int = ((JSONArray)localObject).getInt(1);
          paramAnimationConfig.jdField_g_of_type_Int = ((JSONArray)localObject).getInt(2);
          paramAnimationConfig.i = ((JSONArray)localObject).getInt(3);
        }
      } while (!paramJSONObject.has("step"));
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
    } while (!paramJSONObject.has("turnback"));
    paramJSONObject = paramJSONObject.getJSONObject("turnback");
    paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.put(2, a("turnback", paramJSONObject));
  }
  
  private void a(BubbleConfig paramBubbleConfig, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString)
  {
    paramJSONObject2 = paramJSONObject2.optString(paramString);
    paramJSONObject1 = b(paramJSONObject2, paramJSONObject1);
    BubbleNewAnimConf.InterActiveAnimConf localInterActiveAnimConf = new BubbleNewAnimConf.InterActiveAnimConf();
    localInterActiveAnimConf.a(paramBubbleConfig.jdField_a_of_type_Int, paramJSONObject2, paramJSONObject1);
    paramBubbleConfig.jdField_b_of_type_JavaUtilHashMap.put(paramString, localInterActiveAnimConf);
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
    Object localObject1 = a(paramBubbleInfo.jdField_a_of_type_Int).getAbsolutePath() + File.separatorChar + "chartlet" + File.separatorChar;
    localObject1 = (String)localObject1 + "chartlet.png";
    boolean bool = new File((String)localObject1).exists();
    if (((!bool) || (!TextUtils.isEmpty(paramBubbleInfo.e))) && (!TextUtils.isEmpty(paramBubbleInfo.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramBubbleInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramBubbleInfo.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "checkBubbleStaticSource|bubbleId=" + paramBubbleInfo.jdField_a_of_type_Int + ",chkStaticSrcAndUpdate is ok | not empty");
      }
      return true;
    }
    String str3 = a(paramBubbleInfo.jdField_a_of_type_Int).getAbsolutePath() + File.separatorChar + "static" + File.separatorChar;
    String str1 = str3 + "aio_user_bg_nor.9.png";
    String str2 = str3 + "aio_user_pic_nor.9.png";
    str3 = str3 + "chat_bubble_thumbnail.png";
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(str1);
    ((List)localObject2).add(str2);
    ((List)localObject2).add(str3);
    if (bool) {
      ((List)localObject2).add(localObject1);
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str4 = (String)((Iterator)localObject2).next();
      if (!new File(str4).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("BubbleManager", 2, "checkBubbleStaticSource|file is not exists,bubbleId=" + paramBubbleInfo.jdField_a_of_type_Int + ",strFilePath=" + str4);
        }
        return false;
      }
    }
    paramBubbleInfo.jdField_d_of_type_JavaLangString = str3;
    paramBubbleInfo.jdField_a_of_type_JavaLangString = str1;
    paramBubbleInfo.jdField_b_of_type_JavaLangString = str2;
    paramBubbleInfo.e = ((String)localObject1);
    try
    {
      localObject1 = a(str3, null);
      if (localObject1 != null)
      {
        int i = ((Bitmap)localObject1).getPixel(((Bitmap)localObject1).getWidth() / 2, ((Bitmap)localObject1).getHeight() / 2);
        if (paramBubbleInfo.jdField_b_of_type_Int == i)
        {
          paramBubbleInfo.jdField_b_of_type_Int = Color.rgb(255 - Color.red(i), 255 - Color.green(i), 255 - Color.blue(i));
          if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, "text color:" + Integer.toHexString(i) + ",  now chage to " + Integer.toHexString(paramBubbleInfo.jdField_b_of_type_Int));
          }
        }
        if (paramBubbleInfo.jdField_c_of_type_Int == i)
        {
          paramBubbleInfo.jdField_c_of_type_Int = Color.rgb(255 - Color.red(i), 255 - Color.green(i), 255 - Color.blue(i));
          if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, "mLinkColor :" + Integer.toHexString(i) + ",  now chage to " + Integer.toHexString(paramBubbleInfo.jdField_c_of_type_Int));
          }
        }
      }
    }
    catch (OutOfMemoryError paramBubbleInfo)
    {
      for (;;)
      {
        QLog.e("BubbleManager", 2, "bubble change color out of memory error!", paramBubbleInfo);
      }
    }
    catch (Exception paramBubbleInfo)
    {
      for (;;)
      {
        QLog.e("BubbleManager", 2, "bubble change color throws exception!", paramBubbleInfo);
      }
    }
    return true;
  }
  
  private AnimationConfig b(JSONObject paramJSONObject)
  {
    int i = 0;
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
        localAnimationConfig.jdField_f_of_type_Int = AIOUtils.a(localJSONArray.getInt(0) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
        localAnimationConfig.jdField_h_of_type_Int = AIOUtils.a(localJSONArray.getInt(1) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
        localAnimationConfig.jdField_g_of_type_Int = AIOUtils.a(localJSONArray.getInt(2) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
        localAnimationConfig.i = AIOUtils.a(localJSONArray.getInt(3) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
    }
    if (paramJSONObject.has("cut_array"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("cut_array");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        localAnimationConfig.jdField_c_of_type_ArrayOfInt = new int[paramJSONObject.length()];
        while (i < paramJSONObject.length())
        {
          localAnimationConfig.jdField_c_of_type_ArrayOfInt[i] = paramJSONObject.getInt(i);
          i += 1;
        }
        Arrays.sort(localAnimationConfig.jdField_c_of_type_ArrayOfInt);
      }
    }
    return localAnimationConfig;
  }
  
  private BubbleNewAnimConf b(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "getPathAnimConf object == null");
      localObject = null;
    }
    BubbleNewAnimConf.PathAnimConf localPathAnimConf;
    do
    {
      return localObject;
      localPathAnimConf = new BubbleNewAnimConf.PathAnimConf();
      if (paramJSONObject.has("key")) {
        localPathAnimConf.jdField_a_of_type_JavaLangString = paramJSONObject.getString("key");
      }
      if (paramJSONObject.has("start_end"))
      {
        localObject = paramJSONObject.getJSONArray("start_end");
        localPathAnimConf.jdField_a_of_type_Float = ((float)((JSONArray)localObject).getDouble(0));
        localPathAnimConf.jdField_b_of_type_Float = ((float)((JSONArray)localObject).getDouble(1));
        localPathAnimConf.jdField_c_of_type_Float = ((float)((JSONArray)localObject).getDouble(2));
        localPathAnimConf.d = ((float)((JSONArray)localObject).getDouble(3));
      }
      if (paramJSONObject.has("bezier"))
      {
        localObject = paramJSONObject.getJSONArray("bezier");
        localPathAnimConf.jdField_e_of_type_Float = ((float)((JSONArray)localObject).getDouble(0));
        localPathAnimConf.jdField_f_of_type_Float = ((float)((JSONArray)localObject).getDouble(1));
        localPathAnimConf.jdField_g_of_type_Float = ((float)((JSONArray)localObject).getDouble(2));
        localPathAnimConf.jdField_h_of_type_Float = ((float)((JSONArray)localObject).getDouble(3));
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
      if (paramJSONObject.has("img_alpha"))
      {
        localObject = paramJSONObject.getJSONArray("img_alpha");
        localPathAnimConf.jdField_f_of_type_Int = ((JSONArray)localObject).getInt(0);
        localPathAnimConf.jdField_g_of_type_Int = ((JSONArray)localObject).getInt(1);
      }
      if (paramJSONObject.has("repeat")) {
        localPathAnimConf.jdField_a_of_type_Int = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("img_rotate"))
      {
        localObject = paramJSONObject.getJSONArray("img_rotate");
        localPathAnimConf.jdField_h_of_type_Int = ((JSONArray)localObject).getInt(0);
        localPathAnimConf.i = ((JSONArray)localObject).getInt(1);
      }
      if (paramJSONObject.has("img_count")) {
        localPathAnimConf.jdField_b_of_type_Int = paramJSONObject.getInt("img_count");
      }
      if (paramJSONObject.has("periodical")) {
        localPathAnimConf.jdField_c_of_type_Boolean = paramJSONObject.getBoolean("periodical");
      }
      localObject = localPathAnimConf;
    } while (!paramJSONObject.has("period_length"));
    localPathAnimConf.j = paramJSONObject.getInt("period_length");
    return localPathAnimConf;
  }
  
  private JSONObject b(String paramString, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("animation_sets")) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.getJSONObject("animation_sets");
    } while (paramJSONObject == null);
    return paramJSONObject.getJSONObject(paramString);
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
    switch (paramInt2)
    {
    case 4: 
    default: 
      localObject = null;
    }
    int i;
    for (;;)
    {
      if (localObject != null) {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(((AnimationConfig)localObject).jdField_b_of_type_JavaLangString))
        {
          return localObject;
          localObject = ((BubbleConfig)localObject).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig;
          AnimationConfig.a((AnimationConfig)localObject);
          continue;
          localObject = ((BubbleConfig)localObject).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig;
          continue;
          localObject = ((BubbleConfig)localObject).jdField_f_of_type_ComTencentMobileqqBubbleAnimationConfig;
        }
        else if ((localObject != null) && (((AnimationConfig)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (((AnimationConfig)localObject).jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          Iterator localIterator = ((AnimationConfig)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
          paramInt2 = 1;
          if (!localIterator.hasNext()) {
            break label315;
          }
          BubbleNewAnimConf localBubbleNewAnimConf = (BubbleNewAnimConf)localIterator.next();
          File localFile = new File(a(paramInt1), ((AnimationConfig)localObject).jdField_a_of_type_JavaLangString);
          i = 0;
          label188:
          if (i >= localBubbleNewAnimConf.jdField_b_of_type_Int) {
            break label350;
          }
          String str = localFile.getAbsolutePath() + File.separatorChar + localBubbleNewAnimConf.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
          if (!new File(str).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("BubbleManager", 2, "pendent anim conf, file is not exit, " + str);
            }
            paramInt2 = 0;
          }
        }
      }
    }
    label315:
    label350:
    for (;;)
    {
      break;
      i += 1;
      break label188;
      return null;
      if (paramInt2 == 0)
      {
        a(paramInt1, "other.zip", "0");
        return null;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((AnimationConfig)localObject).jdField_b_of_type_JavaLangString, localObject);
      return localObject;
    }
  }
  
  AnimationConfig a(int paramInt, String paramString)
  {
    Object localObject = a(paramInt, true);
    if (localObject == null)
    {
      QLog.e("BubbleManager", 1, "findAnimConfig bubbleId = " + paramInt + " bubbleConfig = null");
      return null;
    }
    if ((((BubbleConfig)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig != null) && (((BubbleConfig)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((BubbleConfig)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if ((((BubbleConfig)localObject).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig != null) && (((BubbleConfig)localObject).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((BubbleConfig)localObject).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if ((((BubbleConfig)localObject).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig != null) && (((BubbleConfig)localObject).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((BubbleConfig)localObject).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if ((((BubbleConfig)localObject).jdField_d_of_type_ComTencentMobileqqBubbleAnimationConfig != null) && (((BubbleConfig)localObject).jdField_d_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((BubbleConfig)localObject).jdField_d_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if ((((BubbleConfig)localObject).jdField_e_of_type_ComTencentMobileqqBubbleAnimationConfig != null) && (((BubbleConfig)localObject).jdField_e_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString))) {
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
  
  /* Error */
  public BubbleConfig a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 196
    //   8: iconst_2
    //   9: new 198	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 815
    //   19: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 817
    //   29: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 357	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_2
    //   43: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifeq +5 -> 51
    //   49: aconst_null
    //   50: areturn
    //   51: aload_0
    //   52: aload_2
    //   53: invokevirtual 819	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 8
    //   58: aload 8
    //   60: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +5 -> 68
    //   66: aconst_null
    //   67: areturn
    //   68: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +30 -> 101
    //   74: ldc 196
    //   76: iconst_2
    //   77: new 198	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 821
    //   87: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 8
    //   92: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload 8
    //   103: astore_2
    //   104: getstatic 826	android/os/Build$VERSION:SDK_INT	I
    //   107: bipush 10
    //   109: if_icmpgt +37 -> 146
    //   112: aload 8
    //   114: astore_2
    //   115: aload 8
    //   117: invokevirtual 827	java/lang/String:length	()I
    //   120: iconst_1
    //   121: if_icmple +25 -> 146
    //   124: aload 8
    //   126: astore_2
    //   127: aload 8
    //   129: iconst_0
    //   130: invokevirtual 831	java/lang/String:charAt	(I)C
    //   133: ldc_w 832
    //   136: if_icmpne +10 -> 146
    //   139: aload 8
    //   141: iconst_1
    //   142: invokevirtual 835	java/lang/String:substring	(I)Ljava/lang/String;
    //   145: astore_2
    //   146: new 578	com/tencent/mobileqq/bubble/BubbleConfig
    //   149: dup
    //   150: iload_1
    //   151: invokespecial 836	com/tencent/mobileqq/bubble/BubbleConfig:<init>	(I)V
    //   154: astore 9
    //   156: new 241	org/json/JSONObject
    //   159: dup
    //   160: aload_2
    //   161: invokespecial 837	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   164: astore 10
    //   166: aload 9
    //   168: aload 10
    //   170: ldc_w 839
    //   173: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: putfield 840	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   179: aload 10
    //   181: ldc_w 842
    //   184: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   187: istore 7
    //   189: iload 7
    //   191: ifeq +122 -> 313
    //   194: aload 10
    //   196: ldc_w 842
    //   199: invokevirtual 276	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull +109 -> 313
    //   207: aload_2
    //   208: invokevirtual 285	org/json/JSONArray:length	()I
    //   211: ifle +102 -> 313
    //   214: aload 9
    //   216: new 37	java/util/ArrayList
    //   219: dup
    //   220: invokespecial 38	java/util/ArrayList:<init>	()V
    //   223: putfield 844	com/tencent/mobileqq/bubble/BubbleConfig:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   226: aload 9
    //   228: iconst_0
    //   229: putfield 845	com/tencent/mobileqq/bubble/BubbleConfig:jdField_e_of_type_Int	I
    //   232: iconst_0
    //   233: istore 5
    //   235: iload 5
    //   237: aload_2
    //   238: invokevirtual 285	org/json/JSONArray:length	()I
    //   241: if_icmpge +30 -> 271
    //   244: aload 9
    //   246: getfield 844	com/tencent/mobileqq/bubble/BubbleConfig:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   249: aload_2
    //   250: iload 5
    //   252: invokevirtual 288	org/json/JSONArray:getInt	(I)I
    //   255: invokestatic 401	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: invokevirtual 520	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   261: pop
    //   262: iload 5
    //   264: iconst_1
    //   265: iadd
    //   266: istore 5
    //   268: goto -33 -> 235
    //   271: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +39 -> 313
    //   277: ldc 196
    //   279: iconst_2
    //   280: new 198	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 847
    //   290: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 849
    //   296: aload 9
    //   298: getfield 844	com/tencent/mobileqq/bubble/BubbleConfig:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   301: invokestatic 853	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   304: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 357	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload 10
    //   315: ldc_w 855
    //   318: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   321: ifeq +62 -> 383
    //   324: aload 10
    //   326: ldc_w 855
    //   329: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   332: astore 8
    //   334: aload 8
    //   336: astore_2
    //   337: aload 8
    //   339: ldc_w 857
    //   342: invokevirtual 860	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   345: ifeq +10 -> 355
    //   348: aload 8
    //   350: iconst_2
    //   351: invokevirtual 835	java/lang/String:substring	(I)Ljava/lang/String;
    //   354: astore_2
    //   355: aload 9
    //   357: new 198	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   364: ldc_w 862
    //   367: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_2
    //   371: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 865	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   380: putfield 866	com/tencent/mobileqq/bubble/BubbleConfig:jdField_b_of_type_Int	I
    //   383: aload 10
    //   385: ldc_w 868
    //   388: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   391: ifeq +62 -> 453
    //   394: aload 10
    //   396: ldc_w 868
    //   399: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   402: astore 8
    //   404: aload 8
    //   406: astore_2
    //   407: aload 8
    //   409: ldc_w 857
    //   412: invokevirtual 860	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   415: ifeq +10 -> 425
    //   418: aload 8
    //   420: iconst_2
    //   421: invokevirtual 835	java/lang/String:substring	(I)Ljava/lang/String;
    //   424: astore_2
    //   425: aload 9
    //   427: new 198	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   434: ldc_w 862
    //   437: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_2
    //   441: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 865	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   450: putfield 869	com/tencent/mobileqq/bubble/BubbleConfig:jdField_c_of_type_Int	I
    //   453: aload 10
    //   455: ldc_w 871
    //   458: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   461: ifeq +943 -> 1404
    //   464: aload 9
    //   466: iconst_1
    //   467: putfield 872	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_Boolean	Z
    //   470: aload 10
    //   472: ldc_w 871
    //   475: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: astore 8
    //   480: aload 8
    //   482: astore_2
    //   483: aload 8
    //   485: ldc_w 857
    //   488: invokevirtual 860	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   491: ifeq +10 -> 501
    //   494: aload 8
    //   496: iconst_2
    //   497: invokevirtual 835	java/lang/String:substring	(I)Ljava/lang/String;
    //   500: astore_2
    //   501: aload 9
    //   503: new 198	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 862
    //   513: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_2
    //   517: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 865	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   526: putfield 873	com/tencent/mobileqq/bubble/BubbleConfig:jdField_d_of_type_Int	I
    //   529: aload 9
    //   531: aload 10
    //   533: ldc_w 875
    //   536: dconst_1
    //   537: invokevirtual 879	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   540: putfield 882	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_Double	D
    //   543: aload 10
    //   545: ldc_w 884
    //   548: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   551: ifeq +36 -> 587
    //   554: aload 10
    //   556: ldc_w 884
    //   559: invokevirtual 276	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   562: astore_2
    //   563: aload 9
    //   565: iconst_2
    //   566: newarray int
    //   568: dup
    //   569: iconst_0
    //   570: aload_2
    //   571: iconst_0
    //   572: invokevirtual 288	org/json/JSONArray:getInt	(I)I
    //   575: iastore
    //   576: dup
    //   577: iconst_1
    //   578: aload_2
    //   579: iconst_1
    //   580: invokevirtual 288	org/json/JSONArray:getInt	(I)I
    //   583: iastore
    //   584: putfield 885	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ArrayOfInt	[I
    //   587: aload 10
    //   589: ldc_w 887
    //   592: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   595: ifeq +95 -> 690
    //   598: aload 10
    //   600: ldc_w 887
    //   603: invokevirtual 528	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   606: astore_2
    //   607: aload_2
    //   608: ldc_w 889
    //   611: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   614: ifeq +76 -> 690
    //   617: aload_0
    //   618: aload_2
    //   619: ldc_w 889
    //   622: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   625: aload 10
    //   627: invokespecial 891	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   630: astore 8
    //   632: aload 8
    //   634: ifnull +56 -> 690
    //   637: aload_0
    //   638: iconst_0
    //   639: aload 8
    //   641: invokespecial 893	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   644: astore 8
    //   646: aload 8
    //   648: aload_2
    //   649: ldc_w 889
    //   652: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   655: putfield 776	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   658: aload 9
    //   660: aload 8
    //   662: putfield 805	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   665: aload 8
    //   667: getfield 295	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   670: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   673: ifne +17 -> 690
    //   676: aload 9
    //   678: getfield 896	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   681: aload 8
    //   683: getfield 295	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   686: invokevirtual 899	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   689: pop
    //   690: aload 10
    //   692: ldc_w 901
    //   695: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   698: ifeq +131 -> 829
    //   701: aload 10
    //   703: ldc_w 901
    //   706: invokevirtual 528	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   709: astore_2
    //   710: aload_2
    //   711: ldc_w 889
    //   714: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   717: ifeq +112 -> 829
    //   720: aload_0
    //   721: aload_2
    //   722: ldc_w 889
    //   725: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   728: aload 10
    //   730: invokespecial 891	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   733: astore 11
    //   735: aload 11
    //   737: ifnull +92 -> 829
    //   740: aload_0
    //   741: iconst_2
    //   742: aload 11
    //   744: invokespecial 893	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   747: astore 8
    //   749: aload 11
    //   751: ldc_w 903
    //   754: invokevirtual 276	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   757: astore 11
    //   759: aload 8
    //   761: iconst_2
    //   762: newarray int
    //   764: dup
    //   765: iconst_0
    //   766: aload 11
    //   768: iconst_0
    //   769: invokevirtual 288	org/json/JSONArray:getInt	(I)I
    //   772: iastore
    //   773: dup
    //   774: iconst_1
    //   775: aload 11
    //   777: iconst_1
    //   778: invokevirtual 288	org/json/JSONArray:getInt	(I)I
    //   781: iastore
    //   782: putfield 905	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_ArrayOfInt	[I
    //   785: aload 8
    //   787: aload_2
    //   788: ldc_w 889
    //   791: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   794: putfield 776	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   797: aload 9
    //   799: aload 8
    //   801: putfield 786	com/tencent/mobileqq/bubble/BubbleConfig:jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   804: aload 8
    //   806: getfield 295	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   809: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   812: ifne +17 -> 829
    //   815: aload 9
    //   817: getfield 896	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   820: aload 8
    //   822: getfield 295	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   825: invokevirtual 899	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   828: pop
    //   829: aload 10
    //   831: ldc_w 907
    //   834: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   837: ifeq +152 -> 989
    //   840: aload 10
    //   842: ldc_w 907
    //   845: invokevirtual 528	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   848: astore_2
    //   849: aload_2
    //   850: ldc_w 889
    //   853: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   856: ifeq +133 -> 989
    //   859: aload_0
    //   860: aload_2
    //   861: ldc_w 889
    //   864: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   867: aload 10
    //   869: invokespecial 891	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   872: astore 8
    //   874: aload 8
    //   876: ifnull +113 -> 989
    //   879: aload_0
    //   880: iconst_3
    //   881: aload 8
    //   883: invokespecial 893	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   886: astore 8
    //   888: aload 8
    //   890: aload_2
    //   891: ldc_w 889
    //   894: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   897: putfield 776	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   900: aload_2
    //   901: ldc_w 909
    //   904: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   907: ifeq +50 -> 957
    //   910: aload_2
    //   911: ldc_w 909
    //   914: invokevirtual 249	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   917: istore 5
    //   919: aload_0
    //   920: getfield 90	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   923: ldc_w 911
    //   926: invokevirtual 915	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   929: checkcast 917	android/view/WindowManager
    //   932: invokeinterface 921 1 0
    //   937: invokevirtual 924	android/view/Display:getWidth	()I
    //   940: i2d
    //   941: dstore_3
    //   942: aload 8
    //   944: iload 5
    //   946: i2d
    //   947: ldc2_w 925
    //   950: ddiv
    //   951: dload_3
    //   952: dmul
    //   953: d2i
    //   954: putfield 927	com/tencent/mobileqq/bubble/AnimationConfig:j	I
    //   957: aload 9
    //   959: aload 8
    //   961: putfield 781	com/tencent/mobileqq/bubble/BubbleConfig:jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   964: aload 8
    //   966: getfield 295	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   969: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   972: ifne +17 -> 989
    //   975: aload 9
    //   977: getfield 896	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   980: aload 8
    //   982: getfield 295	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   985: invokevirtual 899	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   988: pop
    //   989: aload 10
    //   991: ldc_w 929
    //   994: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   997: ifeq +94 -> 1091
    //   1000: aload 10
    //   1002: ldc_w 929
    //   1005: invokevirtual 528	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1008: astore_2
    //   1009: aload_2
    //   1010: ldc_w 931
    //   1013: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1016: ifeq +75 -> 1091
    //   1019: aload_0
    //   1020: aload_2
    //   1021: ldc_w 931
    //   1024: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1027: aload 10
    //   1029: invokespecial 573	com/tencent/mobileqq/bubble/BubbleManager:b	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1032: astore 8
    //   1034: aload 8
    //   1036: ifnull +55 -> 1091
    //   1039: aload_0
    //   1040: aload 8
    //   1042: invokespecial 933	com/tencent/mobileqq/bubble/BubbleManager:a	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   1045: astore 8
    //   1047: aload 8
    //   1049: aload_2
    //   1050: ldc_w 931
    //   1053: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1056: putfield 776	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1059: aload 9
    //   1061: aload 8
    //   1063: putfield 807	com/tencent/mobileqq/bubble/BubbleConfig:jdField_d_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   1066: aload 8
    //   1068: getfield 295	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1071: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1074: ifne +17 -> 1091
    //   1077: aload 9
    //   1079: getfield 896	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1082: aload 8
    //   1084: getfield 295	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1087: invokevirtual 899	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1090: pop
    //   1091: aload 10
    //   1093: ldc_w 935
    //   1096: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1099: ifeq +94 -> 1193
    //   1102: aload 10
    //   1104: ldc_w 935
    //   1107: invokevirtual 528	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1110: astore_2
    //   1111: aload_2
    //   1112: ldc_w 931
    //   1115: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1118: ifeq +75 -> 1193
    //   1121: aload_0
    //   1122: aload_2
    //   1123: ldc_w 931
    //   1126: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1129: aload 10
    //   1131: invokespecial 573	com/tencent/mobileqq/bubble/BubbleManager:b	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1134: astore 8
    //   1136: aload 8
    //   1138: ifnull +55 -> 1193
    //   1141: aload_0
    //   1142: aload 8
    //   1144: invokespecial 937	com/tencent/mobileqq/bubble/BubbleManager:b	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   1147: astore 8
    //   1149: aload 8
    //   1151: aload_2
    //   1152: ldc_w 931
    //   1155: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1158: putfield 776	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1161: aload 9
    //   1163: aload 8
    //   1165: putfield 809	com/tencent/mobileqq/bubble/BubbleConfig:jdField_e_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   1168: aload 8
    //   1170: getfield 295	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1173: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1176: ifne +17 -> 1193
    //   1179: aload 9
    //   1181: getfield 896	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1184: aload 8
    //   1186: getfield 295	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1189: invokevirtual 899	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1192: pop
    //   1193: aload 10
    //   1195: ldc_w 939
    //   1198: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1201: ifeq +426 -> 1627
    //   1204: aload 10
    //   1206: ldc_w 939
    //   1209: invokevirtual 276	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1212: astore_2
    //   1213: new 37	java/util/ArrayList
    //   1216: dup
    //   1217: invokespecial 38	java/util/ArrayList:<init>	()V
    //   1220: astore 8
    //   1222: iconst_0
    //   1223: istore 5
    //   1225: iload 5
    //   1227: aload_2
    //   1228: invokevirtual 285	org/json/JSONArray:length	()I
    //   1231: if_icmpge +389 -> 1620
    //   1234: aload_2
    //   1235: iload 5
    //   1237: invokevirtual 515	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1240: astore 11
    //   1242: aload 11
    //   1244: ldc_w 889
    //   1247: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1250: ifeq +818 -> 2068
    //   1253: aload_0
    //   1254: aload 11
    //   1256: ldc_w 889
    //   1259: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1262: aload 10
    //   1264: invokespecial 891	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1267: astore 12
    //   1269: aload 12
    //   1271: ifnonnull +231 -> 1502
    //   1274: goto +794 -> 2068
    //   1277: astore_2
    //   1278: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1281: ifeq -968 -> 313
    //   1284: ldc 196
    //   1286: iconst_2
    //   1287: ldc_w 941
    //   1290: aload_2
    //   1291: invokestatic 223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1294: goto -981 -> 313
    //   1297: astore_2
    //   1298: ldc 196
    //   1300: iconst_1
    //   1301: new 198	java/lang/StringBuilder
    //   1304: dup
    //   1305: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1308: ldc_w 943
    //   1311: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: iload_1
    //   1315: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1318: ldc_w 945
    //   1321: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: aload_2
    //   1328: invokestatic 223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1331: aconst_null
    //   1332: areturn
    //   1333: astore_2
    //   1334: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1337: ifeq -954 -> 383
    //   1340: ldc 196
    //   1342: iconst_2
    //   1343: ldc_w 947
    //   1346: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1349: goto -966 -> 383
    //   1352: astore_2
    //   1353: ldc 196
    //   1355: iconst_1
    //   1356: ldc_w 949
    //   1359: aload_2
    //   1360: invokestatic 223	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1363: goto -32 -> 1331
    //   1366: astore_2
    //   1367: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1370: ifeq -917 -> 453
    //   1373: ldc 196
    //   1375: iconst_2
    //   1376: ldc_w 951
    //   1379: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1382: goto -929 -> 453
    //   1385: astore_2
    //   1386: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1389: ifeq -860 -> 529
    //   1392: ldc 196
    //   1394: iconst_2
    //   1395: ldc_w 953
    //   1398: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1401: goto -872 -> 529
    //   1404: aload 10
    //   1406: ldc_w 955
    //   1409: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1412: ifeq -883 -> 529
    //   1415: aload 9
    //   1417: iconst_1
    //   1418: putfield 956	com/tencent/mobileqq/bubble/BubbleConfig:jdField_b_of_type_Boolean	Z
    //   1421: aload 10
    //   1423: ldc_w 955
    //   1426: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1429: astore 8
    //   1431: aload 8
    //   1433: astore_2
    //   1434: aload 8
    //   1436: ldc_w 857
    //   1439: invokevirtual 860	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1442: ifeq +10 -> 1452
    //   1445: aload 8
    //   1447: iconst_2
    //   1448: invokevirtual 835	java/lang/String:substring	(I)Ljava/lang/String;
    //   1451: astore_2
    //   1452: aload 9
    //   1454: new 198	java/lang/StringBuilder
    //   1457: dup
    //   1458: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1461: ldc_w 862
    //   1464: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: aload_2
    //   1468: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1474: invokestatic 865	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1477: putfield 873	com/tencent/mobileqq/bubble/BubbleConfig:jdField_d_of_type_Int	I
    //   1480: goto -951 -> 529
    //   1483: astore_2
    //   1484: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1487: ifeq -958 -> 529
    //   1490: ldc 196
    //   1492: iconst_2
    //   1493: ldc_w 953
    //   1496: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1499: goto -970 -> 529
    //   1502: aload_0
    //   1503: iconst_1
    //   1504: aload 12
    //   1506: invokespecial 893	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   1509: astore 12
    //   1511: aload 11
    //   1513: ldc_w 958
    //   1516: invokevirtual 276	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1519: astore 13
    //   1521: aload 12
    //   1523: aload 13
    //   1525: invokevirtual 285	org/json/JSONArray:length	()I
    //   1528: anewarray 145	java/lang/String
    //   1531: putfield 959	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1534: iconst_0
    //   1535: istore 6
    //   1537: iload 6
    //   1539: aload 13
    //   1541: invokevirtual 285	org/json/JSONArray:length	()I
    //   1544: if_icmpge +27 -> 1571
    //   1547: aload 12
    //   1549: getfield 959	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1552: iload 6
    //   1554: aload 13
    //   1556: iload 6
    //   1558: invokevirtual 961	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1561: aastore
    //   1562: iload 6
    //   1564: iconst_1
    //   1565: iadd
    //   1566: istore 6
    //   1568: goto -31 -> 1537
    //   1571: aload 12
    //   1573: aload 11
    //   1575: ldc_w 889
    //   1578: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1581: putfield 776	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1584: aload 8
    //   1586: aload 12
    //   1588: invokevirtual 520	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1591: pop
    //   1592: aload 12
    //   1594: getfield 295	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1597: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1600: ifne +468 -> 2068
    //   1603: aload 9
    //   1605: getfield 896	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1608: aload 12
    //   1610: getfield 295	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1613: invokevirtual 899	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1616: pop
    //   1617: goto +451 -> 2068
    //   1620: aload 9
    //   1622: aload 8
    //   1624: putfield 810	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1627: aload 9
    //   1629: iload_1
    //   1630: aload 10
    //   1632: invokestatic 966	com/tencent/mobileqq/bubble/DiyBubbleConfig:a	(ILorg/json/JSONObject;)Ljava/util/HashMap;
    //   1635: putfield 968	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1638: aload 10
    //   1640: ldc_w 970
    //   1643: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1646: ifeq +211 -> 1857
    //   1649: aload 10
    //   1651: ldc_w 970
    //   1654: invokevirtual 528	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1657: astore 8
    //   1659: new 266	com/tencent/mobileqq/bubble/AnimationConfig
    //   1662: dup
    //   1663: invokespecial 267	com/tencent/mobileqq/bubble/AnimationConfig:<init>	()V
    //   1666: astore_2
    //   1667: aload 8
    //   1669: ldc_w 972
    //   1672: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1675: ifeq +15 -> 1690
    //   1678: aload_2
    //   1679: aload 8
    //   1681: ldc_w 972
    //   1684: invokevirtual 249	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1687: putfield 975	com/tencent/mobileqq/bubble/AnimationConfig:k	I
    //   1690: aload 8
    //   1692: ldc_w 931
    //   1695: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1698: ifeq +159 -> 1857
    //   1701: aload 8
    //   1703: ldc_w 931
    //   1706: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1709: astore 8
    //   1711: aload_2
    //   1712: aload 8
    //   1714: putfield 776	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1717: aload_0
    //   1718: aload 8
    //   1720: aload 10
    //   1722: invokespecial 573	com/tencent/mobileqq/bubble/BubbleManager:b	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1725: astore 11
    //   1727: aload 11
    //   1729: ifnull +128 -> 1857
    //   1732: aload_2
    //   1733: aload 11
    //   1735: ldc_w 294
    //   1738: invokevirtual 260	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1741: putfield 295	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1744: aload 11
    //   1746: ldc_w 977
    //   1749: invokevirtual 276	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1752: astore 8
    //   1754: aload 11
    //   1756: ldc_w 543
    //   1759: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1762: ifeq +66 -> 1828
    //   1765: aload 11
    //   1767: ldc_w 543
    //   1770: invokevirtual 276	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1773: astore 11
    //   1775: aload 11
    //   1777: ifnull +51 -> 1828
    //   1780: aload 11
    //   1782: invokevirtual 285	org/json/JSONArray:length	()I
    //   1785: ifle +43 -> 1828
    //   1788: aload_2
    //   1789: aload 11
    //   1791: iconst_0
    //   1792: invokevirtual 288	org/json/JSONArray:getInt	(I)I
    //   1795: putfield 546	com/tencent/mobileqq/bubble/AnimationConfig:jdField_f_of_type_Int	I
    //   1798: aload_2
    //   1799: aload 11
    //   1801: iconst_1
    //   1802: invokevirtual 288	org/json/JSONArray:getInt	(I)I
    //   1805: putfield 549	com/tencent/mobileqq/bubble/AnimationConfig:jdField_h_of_type_Int	I
    //   1808: aload_2
    //   1809: aload 11
    //   1811: iconst_2
    //   1812: invokevirtual 288	org/json/JSONArray:getInt	(I)I
    //   1815: putfield 552	com/tencent/mobileqq/bubble/AnimationConfig:jdField_g_of_type_Int	I
    //   1818: aload_2
    //   1819: aload 11
    //   1821: iconst_3
    //   1822: invokevirtual 288	org/json/JSONArray:getInt	(I)I
    //   1825: putfield 554	com/tencent/mobileqq/bubble/AnimationConfig:i	I
    //   1828: aload 8
    //   1830: ifnull +21 -> 1851
    //   1833: aload 8
    //   1835: invokevirtual 285	org/json/JSONArray:length	()I
    //   1838: ifle +13 -> 1851
    //   1841: aload_2
    //   1842: aload_0
    //   1843: aload 8
    //   1845: invokespecial 979	com/tencent/mobileqq/bubble/BubbleManager:a	(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    //   1848: putfield 791	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1851: aload 9
    //   1853: aload_2
    //   1854: putfield 788	com/tencent/mobileqq/bubble/BubbleConfig:jdField_f_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   1857: aload 10
    //   1859: ldc_w 981
    //   1862: invokevirtual 245	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1865: ifeq +200 -> 2065
    //   1868: aload 10
    //   1870: ldc_w 981
    //   1873: invokevirtual 528	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1876: astore_2
    //   1877: aload_2
    //   1878: ldc_w 958
    //   1881: invokevirtual 984	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1884: astore 8
    //   1886: aload 9
    //   1888: new 587	java/util/HashMap
    //   1891: dup
    //   1892: invokespecial 985	java/util/HashMap:<init>	()V
    //   1895: putfield 585	com/tencent/mobileqq/bubble/BubbleConfig:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1898: aload 8
    //   1900: ifnull +66 -> 1966
    //   1903: aload 8
    //   1905: invokevirtual 285	org/json/JSONArray:length	()I
    //   1908: ifle +58 -> 1966
    //   1911: aload 9
    //   1913: new 37	java/util/ArrayList
    //   1916: dup
    //   1917: aload 8
    //   1919: invokevirtual 285	org/json/JSONArray:length	()I
    //   1922: invokespecial 511	java/util/ArrayList:<init>	(I)V
    //   1925: putfield 987	com/tencent/mobileqq/bubble/BubbleConfig:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1928: iconst_0
    //   1929: istore 5
    //   1931: iload 5
    //   1933: aload 8
    //   1935: invokevirtual 285	org/json/JSONArray:length	()I
    //   1938: if_icmpge +28 -> 1966
    //   1941: aload 9
    //   1943: getfield 987	com/tencent/mobileqq/bubble/BubbleConfig:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1946: aload 8
    //   1948: iload 5
    //   1950: invokevirtual 961	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1953: invokevirtual 520	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1956: pop
    //   1957: iload 5
    //   1959: iconst_1
    //   1960: iadd
    //   1961: istore 5
    //   1963: goto -32 -> 1931
    //   1966: aload 9
    //   1968: aload 10
    //   1970: ldc_w 989
    //   1973: iconst_m1
    //   1974: invokevirtual 993	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1977: putfield 994	com/tencent/mobileqq/bubble/BubbleConfig:jdField_f_of_type_Int	I
    //   1980: aload 9
    //   1982: getfield 994	com/tencent/mobileqq/bubble/BubbleConfig:jdField_f_of_type_Int	I
    //   1985: iconst_m1
    //   1986: if_icmpne +17 -> 2003
    //   1989: aload 9
    //   1991: aload 10
    //   1993: ldc_w 996
    //   1996: iconst_m1
    //   1997: invokevirtual 993	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2000: putfield 994	com/tencent/mobileqq/bubble/BubbleConfig:jdField_f_of_type_Int	I
    //   2003: aload 9
    //   2005: aload 10
    //   2007: ldc_w 998
    //   2010: iconst_2
    //   2011: invokevirtual 993	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2014: putfield 999	com/tencent/mobileqq/bubble/BubbleConfig:jdField_g_of_type_Int	I
    //   2017: aload_0
    //   2018: aload 9
    //   2020: aload 10
    //   2022: aload_2
    //   2023: ldc_w 1001
    //   2026: invokespecial 1003	com/tencent/mobileqq/bubble/BubbleManager:a	(Lcom/tencent/mobileqq/bubble/BubbleConfig;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   2029: aload_0
    //   2030: aload 9
    //   2032: aload 10
    //   2034: aload_2
    //   2035: ldc_w 1005
    //   2038: invokespecial 1003	com/tencent/mobileqq/bubble/BubbleManager:a	(Lcom/tencent/mobileqq/bubble/BubbleConfig;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   2041: aload_0
    //   2042: aload 9
    //   2044: aload 10
    //   2046: aload_2
    //   2047: ldc_w 1007
    //   2050: invokespecial 1003	com/tencent/mobileqq/bubble/BubbleManager:a	(Lcom/tencent/mobileqq/bubble/BubbleConfig;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   2053: aload_0
    //   2054: aload 9
    //   2056: aload 10
    //   2058: aload_2
    //   2059: ldc_w 1009
    //   2062: invokespecial 1003	com/tencent/mobileqq/bubble/BubbleManager:a	(Lcom/tencent/mobileqq/bubble/BubbleConfig;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   2065: aload 9
    //   2067: areturn
    //   2068: iload 5
    //   2070: iconst_1
    //   2071: iadd
    //   2072: istore 5
    //   2074: goto -849 -> 1225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2077	0	this	BubbleManager
    //   0	2077	1	paramInt	int
    //   0	2077	2	paramString	String
    //   941	11	3	d	double
    //   233	1840	5	i	int
    //   1535	32	6	j	int
    //   187	3	7	bool	boolean
    //   56	1891	8	localObject1	Object
    //   154	1912	9	localBubbleConfig	BubbleConfig
    //   164	1893	10	localJSONObject	JSONObject
    //   733	1087	11	localObject2	Object
    //   1267	342	12	localObject3	Object
    //   1519	36	13	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   194	203	1277	java/lang/Exception
    //   207	232	1277	java/lang/Exception
    //   235	262	1277	java/lang/Exception
    //   271	313	1277	java/lang/Exception
    //   51	66	1297	org/json/JSONException
    //   68	101	1297	org/json/JSONException
    //   104	112	1297	org/json/JSONException
    //   115	124	1297	org/json/JSONException
    //   127	146	1297	org/json/JSONException
    //   146	189	1297	org/json/JSONException
    //   194	203	1297	org/json/JSONException
    //   207	232	1297	org/json/JSONException
    //   235	262	1297	org/json/JSONException
    //   271	313	1297	org/json/JSONException
    //   313	334	1297	org/json/JSONException
    //   337	355	1297	org/json/JSONException
    //   355	383	1297	org/json/JSONException
    //   383	404	1297	org/json/JSONException
    //   407	425	1297	org/json/JSONException
    //   425	453	1297	org/json/JSONException
    //   453	480	1297	org/json/JSONException
    //   483	501	1297	org/json/JSONException
    //   501	529	1297	org/json/JSONException
    //   529	587	1297	org/json/JSONException
    //   587	632	1297	org/json/JSONException
    //   637	690	1297	org/json/JSONException
    //   690	735	1297	org/json/JSONException
    //   740	829	1297	org/json/JSONException
    //   829	874	1297	org/json/JSONException
    //   879	957	1297	org/json/JSONException
    //   957	989	1297	org/json/JSONException
    //   989	1034	1297	org/json/JSONException
    //   1039	1091	1297	org/json/JSONException
    //   1091	1136	1297	org/json/JSONException
    //   1141	1193	1297	org/json/JSONException
    //   1193	1222	1297	org/json/JSONException
    //   1225	1269	1297	org/json/JSONException
    //   1278	1294	1297	org/json/JSONException
    //   1334	1349	1297	org/json/JSONException
    //   1367	1382	1297	org/json/JSONException
    //   1386	1401	1297	org/json/JSONException
    //   1404	1431	1297	org/json/JSONException
    //   1434	1452	1297	org/json/JSONException
    //   1452	1480	1297	org/json/JSONException
    //   1484	1499	1297	org/json/JSONException
    //   1502	1534	1297	org/json/JSONException
    //   1537	1562	1297	org/json/JSONException
    //   1571	1617	1297	org/json/JSONException
    //   1620	1627	1297	org/json/JSONException
    //   1627	1690	1297	org/json/JSONException
    //   1690	1727	1297	org/json/JSONException
    //   1732	1775	1297	org/json/JSONException
    //   1780	1828	1297	org/json/JSONException
    //   1833	1851	1297	org/json/JSONException
    //   1851	1857	1297	org/json/JSONException
    //   1857	1898	1297	org/json/JSONException
    //   1903	1928	1297	org/json/JSONException
    //   1931	1957	1297	org/json/JSONException
    //   1966	2003	1297	org/json/JSONException
    //   2003	2065	1297	org/json/JSONException
    //   355	383	1333	java/lang/Exception
    //   51	66	1352	java/lang/Exception
    //   68	101	1352	java/lang/Exception
    //   104	112	1352	java/lang/Exception
    //   115	124	1352	java/lang/Exception
    //   127	146	1352	java/lang/Exception
    //   146	189	1352	java/lang/Exception
    //   313	334	1352	java/lang/Exception
    //   337	355	1352	java/lang/Exception
    //   383	404	1352	java/lang/Exception
    //   407	425	1352	java/lang/Exception
    //   453	480	1352	java/lang/Exception
    //   483	501	1352	java/lang/Exception
    //   529	587	1352	java/lang/Exception
    //   587	632	1352	java/lang/Exception
    //   637	690	1352	java/lang/Exception
    //   690	735	1352	java/lang/Exception
    //   740	829	1352	java/lang/Exception
    //   829	874	1352	java/lang/Exception
    //   879	957	1352	java/lang/Exception
    //   957	989	1352	java/lang/Exception
    //   989	1034	1352	java/lang/Exception
    //   1039	1091	1352	java/lang/Exception
    //   1091	1136	1352	java/lang/Exception
    //   1141	1193	1352	java/lang/Exception
    //   1193	1222	1352	java/lang/Exception
    //   1225	1269	1352	java/lang/Exception
    //   1278	1294	1352	java/lang/Exception
    //   1334	1349	1352	java/lang/Exception
    //   1367	1382	1352	java/lang/Exception
    //   1386	1401	1352	java/lang/Exception
    //   1404	1431	1352	java/lang/Exception
    //   1434	1452	1352	java/lang/Exception
    //   1484	1499	1352	java/lang/Exception
    //   1502	1534	1352	java/lang/Exception
    //   1537	1562	1352	java/lang/Exception
    //   1571	1617	1352	java/lang/Exception
    //   1620	1627	1352	java/lang/Exception
    //   1627	1690	1352	java/lang/Exception
    //   1690	1727	1352	java/lang/Exception
    //   1732	1775	1352	java/lang/Exception
    //   1780	1828	1352	java/lang/Exception
    //   1833	1851	1352	java/lang/Exception
    //   1851	1857	1352	java/lang/Exception
    //   1857	1898	1352	java/lang/Exception
    //   1903	1928	1352	java/lang/Exception
    //   1931	1957	1352	java/lang/Exception
    //   1966	2003	1352	java/lang/Exception
    //   2003	2065	1352	java/lang/Exception
    //   425	453	1366	java/lang/Exception
    //   501	529	1385	java/lang/Exception
    //   1452	1480	1483	java/lang/Exception
  }
  
  public BubbleConfig a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = null;
      return localObject;
    }
    BubbleConfig localBubbleConfig = (BubbleConfig)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.get(Integer.valueOf(paramInt));
    if (localBubbleConfig == null)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label116;
      }
      ThreadManager.post(new ablo(this, paramInt, paramBoolean), 5, null, true);
    }
    for (;;)
    {
      localObject = localBubbleConfig;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BubbleManager", 2, "getBubbleConfig bubbleId=" + paramInt + ",autoDownload=" + paramBoolean + ",bubbleConfig=" + localBubbleConfig);
      return localBubbleConfig;
      label116:
      new ablo(this, paramInt, paramBoolean).run();
    }
  }
  
  public BubbleInfo a(int paramInt, boolean paramBoolean)
  {
    if (paramInt < 1) {
      ??? = null;
    }
    Object localObject2;
    do
    {
      return ???;
      localObject2 = (BubbleInfo)this.jdField_a_of_type_Abln.get(Integer.valueOf(paramInt));
      if (localObject2 == null) {
        break;
      }
      ??? = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("BubbleManager", 2, "getBubbleInfo, from cache, bubbleId=" + paramInt);
    return localObject2;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))) {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        localObject2 = new abll(this, paramInt);
        this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(paramInt));
        ThreadManager.post((Runnable)localObject2, 8, null, true);
      }
    }
    return null;
  }
  
  public Pair a(int paramInt, AnimationConfig paramAnimationConfig, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramAnimationConfig == null) || (TextUtils.isEmpty(paramAnimationConfig.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramAnimationConfig.jdField_b_of_type_JavaLangString))) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "parseAnimToCommonAttrs, bubbleId = " + paramInt + " autoDown = " + paramBoolean);
    }
    BubbleInfo.CommonAttrs localCommonAttrs = a(paramInt, paramAnimationConfig.jdField_b_of_type_JavaLangString, paramBoolean, false);
    if (localCommonAttrs == null) {
      return null;
    }
    if (paramAnimationConfig.jdField_a_of_type_JavaLangString.equals(paramAnimationConfig.jdField_c_of_type_JavaLangString)) {
      bool = true;
    }
    return new Pair(localCommonAttrs, a(paramInt, paramAnimationConfig.jdField_c_of_type_JavaLangString, paramBoolean, bool));
  }
  
  public Pair a(int paramInt, String paramString, Pair paramPair)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("chkAnimCommAttrs, bubbleId = ").append(paramInt).append(" animName = ").append(paramString).append(" commonAttrs is null ? ");
      if (paramPair != null) {
        break label133;
      }
    }
    label133:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("BubbleManager", 2, String.valueOf(bool));
      localObject = paramPair;
      if (paramPair == null)
      {
        paramString = a(paramInt, a(paramInt, paramString), true);
        localObject = paramString;
        if (paramString != null)
        {
          paramPair = (BubbleInfo)this.jdField_a_of_type_Abln.get(Integer.valueOf(paramInt));
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
    String str = a().getAbsolutePath();
    Object localObject = str;
    if (paramBoolean) {
      localObject = str + "/temp";
    }
    localObject = new File((String)localObject + File.separatorChar + paramInt);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  /* Error */
  public Boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   4: ifnonnull +23 -> 27
    //   7: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +12 -> 22
    //   13: ldc 196
    //   15: iconst_2
    //   16: ldc_w 1094
    //   19: invokestatic 357	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: iconst_0
    //   23: invokestatic 479	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   26: areturn
    //   27: new 374	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokevirtual 482	com/tencent/mobileqq/bubble/BubbleManager:a	()Ljava/io/File;
    //   35: iload_1
    //   36: invokestatic 1096	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   39: invokespecial 380	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   42: invokevirtual 409	java/io/File:exists	()Z
    //   45: ifne +40 -> 85
    //   48: invokestatic 340	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +29 -> 80
    //   54: ldc 196
    //   56: iconst_2
    //   57: new 198	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   64: ldc_w 1098
    //   67: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload_1
    //   71: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 417	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: iconst_0
    //   81: invokestatic 479	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   84: areturn
    //   85: aload_0
    //   86: getfield 46	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   89: astore 5
    //   91: aload 5
    //   93: monitorenter
    //   94: iconst_0
    //   95: istore_2
    //   96: aload_0
    //   97: getfield 46	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   100: invokevirtual 285	org/json/JSONArray:length	()I
    //   103: istore_3
    //   104: iload_2
    //   105: iload_3
    //   106: if_icmpge +73 -> 179
    //   109: aload_0
    //   110: getfield 46	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   113: iload_2
    //   114: invokevirtual 515	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   117: astore 6
    //   119: aload 6
    //   121: ldc_w 1100
    //   124: invokevirtual 249	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   127: iload_1
    //   128: if_icmpne +59 -> 187
    //   131: aload 6
    //   133: ldc_w 1102
    //   136: invokevirtual 249	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   139: iconst_1
    //   140: if_icmpne +23 -> 163
    //   143: iconst_1
    //   144: istore 4
    //   146: aload 5
    //   148: monitorexit
    //   149: iload 4
    //   151: invokestatic 479	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   154: areturn
    //   155: astore 6
    //   157: aload 5
    //   159: monitorexit
    //   160: aload 6
    //   162: athrow
    //   163: iconst_0
    //   164: istore 4
    //   166: goto -20 -> 146
    //   169: astore 6
    //   171: aload 6
    //   173: invokevirtual 1103	java/lang/Exception:printStackTrace	()V
    //   176: goto +11 -> 187
    //   179: aload 5
    //   181: monitorexit
    //   182: iconst_0
    //   183: invokestatic 479	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   186: areturn
    //   187: iload_2
    //   188: iconst_1
    //   189: iadd
    //   190: istore_2
    //   191: goto -95 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	BubbleManager
    //   0	194	1	paramInt	int
    //   95	96	2	i	int
    //   103	4	3	j	int
    //   144	21	4	bool	boolean
    //   89	91	5	localJSONArray	JSONArray
    //   117	15	6	localJSONObject	JSONObject
    //   155	6	6	localObject	Object
    //   169	3	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   96	104	155	finally
    //   109	143	155	finally
    //   146	155	155	finally
    //   157	160	155	finally
    //   171	176	155	finally
    //   179	182	155	finally
    //   109	143	169	java/lang/Exception
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = FileUtils.b(new File(paramString));
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("BubbleManager", 2, paramString, new Object[0]);
      return null;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        QLog.e("BubbleManager", 1, paramString, new Object[0]);
      }
    }
  }
  
  public JSONArray a()
  {
    if ((this.jdField_a_of_type_OrgJsonJSONArray != null) && (this.jdField_a_of_type_OrgJsonJSONArray.length() > 0)) {
      return this.jdField_a_of_type_OrgJsonJSONArray;
    }
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
    return null;
  }
  
  public JSONObject a(int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (a(paramInt).booleanValue())
      {
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "已经下载");
      }
      for (;;)
      {
        localJSONObject2.put("id", paramInt);
        localJSONObject1.put("data", localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.d("BubbleManager", 2, "queryInfo bubbleId=" + paramInt + ",json=" + localJSONObject1.toString());
        }
        return localJSONObject1;
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
          break label333;
        }
        f = ((Float)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).floatValue();
        if (f != 1.0F) {
          break;
        }
        localJSONObject2.put("status", 3);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "下载完毕");
        break label378;
        localJSONObject2.put("canceling", i);
        localJSONObject2.put("progress", 100.0F * f);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        float f;
        int i;
        localJSONException.printStackTrace();
        continue;
        if (f == 2.0F)
        {
          localJSONException.put("status", 1);
          localJSONObject1.put("result", -1);
          localJSONObject1.put("message", "下载失败");
        }
        else
        {
          localJSONException.put("status", 2);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", "下载中");
          break label378;
          label333:
          localJSONException.put("status", 1);
          localJSONException.put("progress", 0);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", "未知状态");
          continue;
        }
        label378:
        if (f == 3.0F) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: new 241	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 1112	org/json/JSONObject:<init>	()V
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 46	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   20: astore 5
    //   22: aload 5
    //   24: monitorenter
    //   25: iconst_0
    //   26: istore_2
    //   27: iload_2
    //   28: aload_0
    //   29: getfield 46	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   32: invokevirtual 285	org/json/JSONArray:length	()I
    //   35: if_icmpge +103 -> 138
    //   38: aload_0
    //   39: getfield 46	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   42: iload_2
    //   43: invokevirtual 515	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   46: astore 4
    //   48: aload 4
    //   50: ldc_w 1100
    //   53: invokevirtual 249	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   56: iload_1
    //   57: if_icmpne +48 -> 105
    //   60: aload 4
    //   62: astore_3
    //   63: aload_3
    //   64: ldc_w 1102
    //   67: iconst_1
    //   68: invokevirtual 1122	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   71: pop
    //   72: aload_3
    //   73: ldc_w 1100
    //   76: iload_1
    //   77: invokevirtual 1122	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   80: pop
    //   81: iload_2
    //   82: iconst_m1
    //   83: if_icmpeq +29 -> 112
    //   86: aload_0
    //   87: getfield 46	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   90: iload_2
    //   91: aload_3
    //   92: invokevirtual 1171	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   95: pop
    //   96: aload 5
    //   98: monitorexit
    //   99: aload_0
    //   100: invokespecial 1173	com/tencent/mobileqq/bubble/BubbleManager:a	()Ljava/lang/Boolean;
    //   103: pop
    //   104: return
    //   105: iload_2
    //   106: iconst_1
    //   107: iadd
    //   108: istore_2
    //   109: goto -82 -> 27
    //   112: aload_0
    //   113: getfield 46	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   116: aload_3
    //   117: invokevirtual 1176	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   120: pop
    //   121: goto -25 -> 96
    //   124: astore_3
    //   125: aload 5
    //   127: monitorexit
    //   128: aload_3
    //   129: athrow
    //   130: astore_3
    //   131: aload_3
    //   132: invokevirtual 1103	java/lang/Exception:printStackTrace	()V
    //   135: goto -36 -> 99
    //   138: iconst_m1
    //   139: istore_2
    //   140: goto -77 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	BubbleManager
    //   0	143	1	paramInt	int
    //   26	114	2	i	int
    //   15	102	3	localObject1	Object
    //   124	5	3	localObject2	Object
    //   130	2	3	localException	Exception
    //   46	15	4	localJSONObject	JSONObject
    //   20	106	5	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   27	60	124	finally
    //   63	81	124	finally
    //   86	96	124	finally
    //   96	99	124	finally
    //   112	121	124	finally
    //   125	128	124	finally
    //   16	25	130	java/lang/Exception
    //   128	130	130	java/lang/Exception
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "startDownload id=" + paramInt + " callbackId = " + paramString);
    }
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      localBundle.putInt("srcType", 3);
      localBundle.putString("callbackId", paramString);
    }
    if (a(paramInt).booleanValue()) {
      if ((this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramString != null)) {
        this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(paramInt, 3, localBundle);
      }
    }
    do
    {
      return;
      if (NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener == null) || (paramString == null));
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(paramInt, -1, localBundle);
    return;
    a(paramInt, null, paramString);
  }
  
  public void a(int paramInt, String arg2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "downloadBubble, bubbleId = " + paramInt + " pkgName = " + ??? + " from = " + paramString2);
    }
    if (paramInt == 0) {}
    String str;
    VasQuickUpdateManager localVasQuickUpdateManager;
    do
    {
      return;
      str = "bubble.android." + paramInt + "." + ???;
      localVasQuickUpdateManager = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(183);
    } while (localVasQuickUpdateManager == null);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BubbleManager", 2, str + " is downloading, remove duplicate download.");
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, str + " is downloading, remove duplicate download.");
    }
    this.jdField_a_of_type_JavaUtilList.add(str);
    localVasQuickUpdateManager.a(2L, str, paramString2);
  }
  
  public void a(int paramInt, String[] paramArrayOfString, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "downloadBubbleGather, bubbleId = " + paramInt + " pkgName[]= " + paramArrayOfString + " from = " + paramString);
    }
    if (paramInt == 0) {}
    VasQuickUpdateManager localVasQuickUpdateManager;
    do
    {
      return;
      localVasQuickUpdateManager = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(183);
    } while (localVasQuickUpdateManager == null);
    String str = "bubble.android." + paramInt + "." + "all.zip";
    if ("0".equals(paramString))
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.contains(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BubbleManager", 2, str + " is downloading, remove duplicate download.");
          }
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, str + " add download queue.");
      }
      this.jdField_a_of_type_JavaUtilList.add(str);
    }
    if (paramArrayOfString == null)
    {
      paramArrayOfString = new String[3];
      paramArrayOfString[0] = ("bubble.android." + paramInt + "." + "config.json");
      paramArrayOfString[1] = ("bubble.android." + paramInt + "." + "static.zip");
      paramArrayOfString[2] = ("bubble.android." + paramInt + "." + "other.zip");
    }
    for (;;)
    {
      localVasQuickUpdateManager.a(2L, str, paramArrayOfString, paramString);
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Float.valueOf(0.0F));
      return;
    }
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public void a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    int i = NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext);
    String str = "0";
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      str = VipUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    }
    ReportController.b(null, "CliOper", "", "", "Bubble", paramString1, 0, (int)paramLong, String.valueOf(paramInt), str, Integer.toString(i), paramString2);
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!paramString1.startsWith("bubble.android."))) {}
    while (!paramString1.endsWith("all.zip")) {
      return;
    }
    int i = a(paramString1);
    float f = (float)paramLong1 / (float)paramLong2;
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), Float.valueOf(f));
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
    boolean bool2 = false;
    boolean bool3 = DownloaderFactory.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext());
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!a(paramInt).booleanValue()) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "bubbleId=" + paramInt + ",isQualityNetwork=" + bool3 + ",canFullDown=" + bool1);
    }
    return bool1;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    Object localObject2 = a(paramInt1, false);
    if (localObject2 == null) {}
    label44:
    while (((List)localObject1).size() <= 0)
    {
      return false;
      localObject1 = new ArrayList();
      switch (paramInt2)
      {
      }
    }
    Object localObject1 = ((List)localObject1).iterator();
    paramInt2 = 1;
    label65:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BubbleNewAnimConf)((Iterator)localObject1).next();
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((BubbleNewAnimConf)localObject2).jdField_a_of_type_JavaLangString))
      {
        File localFile = new File(a(paramInt1), ((BubbleNewAnimConf)localObject2).jdField_d_of_type_JavaLangString);
        int i = 0;
        for (;;)
        {
          int j = paramInt2;
          if (i < ((BubbleNewAnimConf)localObject2).jdField_b_of_type_Int)
          {
            String str = localFile.getAbsolutePath() + File.separatorChar + ((BubbleNewAnimConf)localObject2).jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
            if (!new File(str).exists())
            {
              QLog.e("BubbleManager", 2, "anim conf, file is not exit, " + str);
              j = 0;
            }
          }
          else
          {
            paramInt2 = j;
            if (j == 0) {
              break label65;
            }
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((BubbleNewAnimConf)localObject2).jdField_a_of_type_JavaLangString, localObject2);
            paramInt2 = j;
            break label65;
            if ((((BubbleConfig)localObject2).jdField_b_of_type_JavaUtilHashMap == null) || (((BubbleConfig)localObject2).jdField_b_of_type_JavaUtilHashMap.size() <= 0)) {
              break;
            }
            localObject2 = ((BubbleConfig)localObject2).jdField_b_of_type_JavaUtilHashMap.values().iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((List)localObject1).add(((Iterator)localObject2).next());
            }
            break label44;
          }
          i += 1;
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
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "createBubbleInfo, bubbleId=" + paramInt + ", autoAsyncDownload=" + paramBoolean);
    }
    BubbleConfig localBubbleConfig = a(paramInt, paramBoolean);
    if (localBubbleConfig == null)
    {
      QLog.e("BubbleManager", 1, "createBubbleInfo, no config, bubbleId=" + paramInt);
      this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
      return false;
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    int j;
    Object localObject5;
    try
    {
      localObject2 = new ArrayList();
      localObject3 = new HashMap();
      if (localBubbleConfig.jdField_a_of_type_JavaUtilArrayList != null)
      {
        i = 0;
        if (i < localBubbleConfig.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject4 = (AnimationConfig)localBubbleConfig.jdField_a_of_type_JavaUtilArrayList.get(i);
          j = 0;
          while (j < ((AnimationConfig)localObject4).jdField_a_of_type_ArrayOfJavaLangString.length)
          {
            localObject5 = localObject4.jdField_a_of_type_ArrayOfJavaLangString[j];
            ((ArrayList)localObject2).add(localObject5);
            ((HashMap)localObject3).put(localObject5, ((AnimationConfig)localObject4).jdField_b_of_type_JavaLangString);
            j += 1;
          }
        }
      }
      localObject3 = new BubbleInfo(paramInt, "", "", "", "", localBubbleConfig.jdField_a_of_type_ComTencentMobileqqBubbleDiyBubbleConfig$DiyBubblePasterConfig, localBubbleConfig.jdField_b_of_type_Int, localBubbleConfig.jdField_c_of_type_Int, localBubbleConfig.jdField_d_of_type_Int, localBubbleConfig.jdField_a_of_type_Boolean, localBubbleConfig.jdField_b_of_type_Boolean, localBubbleConfig.jdField_a_of_type_Double, (String[])((ArrayList)localObject2).toArray(new String[0]), null, 0, 0, null, null, (HashMap)localObject3);
      boolean bool = a((BubbleInfo)localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "createBubbleInfo, isCheckOk=" + bool + ", bubbleId=" + paramInt);
      }
      if (!bool)
      {
        if (paramBoolean)
        {
          if (!a(paramInt)) {
            break label480;
          }
          a(paramInt, new String[] { "bubble.android." + paramInt + "." + "static.zip", "bubble.android." + paramInt + "." + "other.zip" }, "0");
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BubbleManager", 2, "createBubbleInfo, download bubble resource, bubbleId=" + paramInt);
          }
          this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
          return false;
          label480:
          a(paramInt, "static.zip", "0");
        }
      }
      if (TextUtils.isEmpty(((BubbleInfo)localObject3).jdField_a_of_type_JavaLangString)) {
        break label1137;
      }
    }
    catch (Exception localException)
    {
      QLog.e("BubbleManager", 1, "createBubbleInfo failed", localException);
      return false;
    }
    int i = 1;
    label539:
    Object localObject1;
    if (!TextUtils.isEmpty(((BubbleInfo)localObject3).jdField_b_of_type_JavaLangString))
    {
      j = 1;
      break label1119;
      localObject2 = null;
      localObject4 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject4).inDensity = 320;
      ((BitmapFactory.Options)localObject4).inTargetDensity = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
      localObject1 = localObject2;
      i = j;
      if (j != 0)
      {
        localObject1 = a(((BubbleInfo)localObject3).jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject4);
        if (localObject1 == null) {
          break label861;
        }
        localObject5 = ((Bitmap)localObject1).getNinePatchChunk();
        if ((localObject5 != null) && (NinePatch.isNinePatchChunk((byte[])localObject5)))
        {
          ((BubbleInfo)localObject3).jdField_a_of_type_AndroidGraphicsNinePatch = new NinePatch((Bitmap)localObject1, (byte[])localObject5, null);
          i = j;
          localObject1 = localObject2;
        }
      }
      else
      {
        label650:
        localObject2 = localObject1;
        j = i;
        if (i == 0) {
          break label1154;
        }
        localObject4 = a(((BubbleInfo)localObject3).jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject4);
        if (localObject4 == null) {
          break label944;
        }
        localObject2 = ((Bitmap)localObject4).getNinePatchChunk();
        if ((localObject2 == null) || (!NinePatch.isNinePatchChunk((byte[])localObject2))) {
          break label897;
        }
        ((BubbleInfo)localObject3).jdField_b_of_type_AndroidGraphicsNinePatch = new NinePatch((Bitmap)localObject4, (byte[])localObject2, null);
        break label1134;
      }
    }
    for (;;)
    {
      label718:
      if (i == 0)
      {
        QLog.e("BubbleManager", 1, "createBubbleInfo, load nine patch failed, abort, bubbleId=" + paramInt);
        VasMonitorHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "individual_v2_bubble_9png_err", (String)localObject1, "norPath:" + ((BubbleInfo)localObject3).jdField_a_of_type_JavaLangString + ", animatePath:" + ((BubbleInfo)localObject3).jdField_b_of_type_JavaLangString, null, 0.0F);
        this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
        return false;
        i = 0;
        localObject1 = "nor9pngErr";
        QLog.e("BubbleManager", 1, "createBubbleInfo, normal bg chunk null or not nine patch, chunk=" + localObject5 + ", bubbleId=" + paramInt);
        break label650;
        label861:
        i = 0;
        localObject1 = "norDecodeErr";
        QLog.e("BubbleManager", 1, "createBubbleInfo, decode normal bg null, bubbleId=" + paramInt);
        break label650;
        i = 0;
        localObject1 = "9pngErr";
        QLog.e("BubbleManager", 1, "createBubbleInfo, animation bg chunk null or not nine patch, chunk=" + localObject2 + ", bubbleId=" + paramInt);
        break label1134;
        j = 0;
        localObject2 = "decodeErr";
        QLog.e("BubbleManager", 1, "createBubbleInfo, decode animation bg null, bubbleId=" + paramInt);
        break label1154;
      }
      label897:
      label944:
      this.jdField_a_of_type_Abln.put(Integer.valueOf(paramInt), localObject3);
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
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "createBubbleInfo, duration=" + (SystemClock.uptimeMillis() - l) + ", bubbleId=" + paramInt);
      }
      return true;
      i += 1;
      break;
      for (;;)
      {
        label1119:
        if ((i == 0) || (j == 0)) {
          break label1148;
        }
        j = 1;
        break label539;
        label1134:
        break label718;
        label1137:
        i = 0;
        break;
        j = 0;
      }
      label1148:
      j = 0;
      break label539;
      label1154:
      i = j;
      localObject1 = localObject2;
    }
  }
  
  public boolean a(long paramLong)
  {
    return (this.jdField_a_of_type_Abln != null) && (this.jdField_a_of_type_Abln.a((int)paramLong));
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "isBubblePasterExists scid: " + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("bubble.paster.")))
    {
      paramString = paramString.replace("bubble.paster.", "");
      paramString = new File(a(), paramString);
      if (QLog.isColorLevel()) {
        QLog.i("BubbleManager", 2, "isBubblePasterExists file is Exits: " + paramString.exists() + ", path:" + paramString.getAbsolutePath());
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
    Object localObject = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(183);
    if (localObject != null) {
      ((VasQuickUpdateManager)localObject).a(2L, "bubble.android." + paramInt + "." + "all.zip");
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("status", 0);
      ((JSONObject)localObject).put("message", "设置成功");
      ((JSONObject)localObject).put("id", paramInt);
      ((JSONObject)localObject).put("result", 0);
      label103:
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "stopDownload id=" + paramInt + ",status=" + 0);
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Float.valueOf(3.0F));
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      break label103;
    }
  }
  
  public void b(String paramString1, String arg2, String paramString3, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, String.format("onDownloadComplete, scid %s, errorcode %d, from %s, httpCode %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString3, Integer.valueOf(paramInt2) }));
    }
    if ((TextUtils.isEmpty(paramString1)) || (!paramString1.startsWith("bubble.android."))) {}
    label344:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                paramInt2 = a(paramString1);
                if (paramInt1 == 0) {
                  this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt2), Float.valueOf(1.0F));
                }
                synchronized (this.jdField_a_of_type_JavaUtilList)
                {
                  if (this.jdField_a_of_type_JavaUtilList.contains(paramString1))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("BubbleManager", 2, paramString1 + " download completed, remove from download queue.");
                    }
                    this.jdField_a_of_type_JavaUtilList.remove(paramString1);
                  }
                  if (!paramString1.endsWith("config.json")) {
                    break label344;
                  }
                  if (paramInt1 == 0)
                  {
                    paramString1 = new File(a(paramInt2), "config.json");
                    if (paramString1.exists())
                    {
                      paramString1 = a(paramInt2, paramString1.getAbsolutePath());
                      if (QLog.isColorLevel()) {
                        QLog.d("BubbleManager", 2, "onDownloadComplete|bubbleId=" + paramInt2 + ",createBubbleConfig bubbleConfig=" + paramString1);
                      }
                      if (paramString1 == null) {
                        continue;
                      }
                      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.put(Integer.valueOf(paramInt2), paramString1);
                      return;
                      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt2), Float.valueOf(2.0F));
                    }
                  }
                }
              }
            } while (!QLog.isColorLevel());
            QLog.d("BubbleManager", 2, "onDownloadComplete|" + paramString1.getAbsolutePath() + " not exist");
            return;
            if (paramString1.endsWith("all.zip"))
            {
              long l;
              if (paramInt1 == 0)
              {
                if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
                  ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, new ablj(this, paramInt2), true);
                }
              }
              else
              {
                if ((paramString3.equals("0")) || (this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener == null)) {
                  break label462;
                }
                paramString1 = new Bundle();
                paramString1.putInt("srcType", 3);
                paramString1.putString("callbackId", paramString3);
                ??? = this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener;
                l = paramInt2;
                if (paramInt1 != 0) {
                  break label464;
                }
              }
              for (paramInt1 = i;; paramInt1 = -1)
              {
                ???.a(l, paramInt1, paramString1);
                return;
                a(paramInt2);
                break label385;
                break;
              }
            }
            if (!paramString1.endsWith("static.zip")) {
              break;
            }
          } while (paramInt1 != 0);
          a(paramInt2, false);
          paramString1 = a(paramInt2, a(paramInt2, "static"), false);
        } while (paramString1 == null);
        ??? = (BubbleInfo)this.jdField_a_of_type_Abln.get(Integer.valueOf(paramInt2));
      } while (??? == null);
      ???.jdField_a_of_type_JavaUtilList.add(paramString1);
      return;
    } while ((!paramString1.endsWith("other.zip")) || (paramInt1 != 0));
    label385:
    label462:
    label464:
    a(paramInt2, false);
  }
  
  public boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "scid isFileExists: " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("bubble.android."))) {}
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                i = a(paramString);
              } while (i <= 0);
              if (paramString.endsWith("config.json")) {
                return new File(a(i), "config.json").exists();
              }
              if (!paramString.endsWith("static.zip")) {
                break;
              }
              paramString = new File(a(i), "static");
            } while ((!paramString.exists()) || (!paramString.isDirectory()));
            paramString = paramString.list();
          } while ((paramString == null) || (paramString.length < 3));
          paramString = Arrays.asList(paramString);
        } while ((!paramString.contains("aio_user_bg_nor.9.png")) || (!paramString.contains("aio_user_pic_nor.9.png")) || (!paramString.contains("chat_bubble_thumbnail.png")));
        return true;
      } while ((!paramString.endsWith("other.zip")) || (!new File(a(i), "config.json").exists()));
      paramString = a(i, false);
    } while (paramString == null);
    return paramString.a(a(i));
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "onDestroy...");
    }
    this.jdField_a_of_type_Abln.a();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.clear();
    jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager
 * JD-Core Version:    0.7.0.1
 */