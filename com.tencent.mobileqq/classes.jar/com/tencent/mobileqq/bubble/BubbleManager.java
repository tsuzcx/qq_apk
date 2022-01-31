package com.tencent.mobileqq.bubble;

import aekt;
import alpo;
import ambd;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.util.SparseArray;
import android.widget.TextView;
import anrz;
import ansa;
import ansc;
import ansd;
import ansf;
import ansg;
import ansr;
import anss;
import anst;
import antb;
import antc;
import antd;
import ante;
import antf;
import azmj;
import bdcs;
import bdee;
import bdkd;
import bdqj;
import bdqk;
import bdvu;
import bdvx;
import bdwb;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
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
  protected Context a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private LruCache<String, Bitmap> jdField_a_of_type_AndroidUtilLruCache = new LruCache(10);
  protected anss a;
  bdvu jdField_a_of_type_Bdvu = new ansr(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  bdwb jdField_a_of_type_Bdwb = null;
  protected AppInterface a;
  QQLruCache<Integer, JSONObject> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2015, 100);
  public BubbleManager.LruLinkedHashMap<Integer, ansc> a;
  private String jdField_a_of_type_JavaLangString;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  Map<Integer, Float> jdField_a_of_type_JavaUtilMap;
  protected Vector<Integer> a;
  public ConcurrentHashMap<String, anrz> a;
  private int b;
  public ConcurrentHashMap<String, antb> b;
  private int c;
  
  static
  {
    jdField_a_of_type_Long = 1000L;
  }
  
  public BubbleManager(AppInterface paramAppInterface)
  {
    this.jdField_b_of_type_Int = 2000000;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext();
    this.jdField_a_of_type_Anss = new anss(this, 2010, 50, 10);
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap = new BubbleManager.LruLinkedHashMap(this, 9);
    paramAppInterface = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    if (paramAppInterface.density == 160.0F) {}
    for (;;)
    {
      this.jdField_a_of_type_Float = f;
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
    //   3: new 183	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 186	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: new 188	java/io/BufferedInputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 191	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
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
    //   36: invokestatic 197	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   39: astore_1
    //   40: aload_1
    //   41: astore_0
    //   42: aload_2
    //   43: ifnull +7 -> 50
    //   46: aload_2
    //   47: invokevirtual 202	java/io/InputStream:close	()V
    //   50: aload_0
    //   51: astore_2
    //   52: aload 5
    //   54: ifnull +10 -> 64
    //   57: aload 5
    //   59: invokevirtual 202	java/io/InputStream:close	()V
    //   62: aload_0
    //   63: astore_2
    //   64: aload_2
    //   65: areturn
    //   66: aload_2
    //   67: astore 4
    //   69: aload 5
    //   71: astore_3
    //   72: aload 5
    //   74: invokestatic 205	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
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
    //   93: ldc 207
    //   95: iconst_1
    //   96: new 209	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   103: ldc 212
    //   105: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_1
    //   109: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_2
    //   119: ifnull +7 -> 126
    //   122: aload_2
    //   123: invokevirtual 202	java/io/InputStream:close	()V
    //   126: aload 7
    //   128: astore_2
    //   129: aload_0
    //   130: ifnull -66 -> 64
    //   133: aload_0
    //   134: invokevirtual 202	java/io/InputStream:close	()V
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
    //   153: ldc 207
    //   155: iconst_1
    //   156: new 209	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   163: ldc 231
    //   165: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_0
    //   169: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: aload 6
    //   177: invokestatic 234	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 202	java/io/InputStream:close	()V
    //   188: aload 7
    //   190: astore_2
    //   191: aload_1
    //   192: ifnull -128 -> 64
    //   195: aload_1
    //   196: invokevirtual 202	java/io/InputStream:close	()V
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
    //   214: invokevirtual 202	java/io/InputStream:close	()V
    //   217: aload_3
    //   218: ifnull +7 -> 225
    //   221: aload_3
    //   222: invokevirtual 202	java/io/InputStream:close	()V
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
  
  private anrz a(int paramInt, JSONObject paramJSONObject)
  {
    anrz localanrz = new anrz();
    localanrz.jdField_a_of_type_Int = paramInt;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseCommonAnimationConfig animation = null");
      return null;
    }
    if (paramJSONObject.has("rect"))
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("rect");
      localanrz.jdField_a_of_type_ArrayOfInt = new int[4];
      paramInt = 0;
      while (paramInt < localJSONArray.length())
      {
        localanrz.jdField_a_of_type_ArrayOfInt[paramInt] = localJSONArray.getInt(paramInt);
        paramInt += 1;
      }
    }
    if (paramJSONObject.has("cycle_count")) {
      localanrz.jdField_b_of_type_Int = paramJSONObject.getInt("cycle_count");
    }
    if (paramJSONObject.has("count")) {
      localanrz.jdField_c_of_type_Int = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("zip_name")) {
      localanrz.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zip_name");
    }
    if (paramJSONObject.has("second_zip_name")) {
      localanrz.jdField_c_of_type_JavaLangString = paramJSONObject.getString("second_zip_name");
    }
    if (paramJSONObject.has("align")) {
      localanrz.jdField_d_of_type_JavaLangString = paramJSONObject.getString("align");
    }
    if ((!paramJSONObject.has("count_stiil")) || (paramJSONObject.has("alpha"))) {
      localanrz.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("alpha");
    }
    if (paramJSONObject.has("displayChartlet")) {
      localanrz.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("displayChartlet");
    }
    if (paramJSONObject.has("mirror")) {
      localanrz.jdField_c_of_type_Boolean = paramJSONObject.getBoolean("mirror");
    }
    a(localanrz, paramJSONObject);
    localanrz.jdField_d_of_type_Int = paramJSONObject.getInt("time");
    return localanrz;
  }
  
  private anrz a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseBubbleFrameAnimationConfig object = null");
      localObject = null;
    }
    anrz localanrz;
    do
    {
      return localObject;
      localanrz = new anrz();
      localanrz.jdField_a_of_type_Int = 4;
      localanrz.jdField_e_of_type_Int = 1;
      if (paramJSONObject.has("repeat")) {
        localanrz.jdField_b_of_type_Int = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("count")) {
        localanrz.jdField_c_of_type_Int = paramJSONObject.getInt("count");
      }
      if (paramJSONObject.has("zip_name")) {
        localanrz.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zip_name");
      }
      localObject = localanrz;
    } while (!paramJSONObject.has("time"));
    localanrz.jdField_d_of_type_Int = paramJSONObject.getInt("time");
    return localanrz;
  }
  
  private ansa a(String paramString, JSONObject paramJSONObject)
  {
    ansa localansa = new ansa();
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseEachStepAttrInPathAnim jsonObject = null");
      paramString = null;
    }
    do
    {
      return paramString;
      if (paramJSONObject.has("count")) {
        localansa.jdField_a_of_type_Int = paramJSONObject.getInt("count");
      }
      if (paramJSONObject.has("cycle_count")) {
        localansa.jdField_b_of_type_Int = paramJSONObject.getInt("cycle_count");
      }
      paramString = localansa;
    } while (!paramJSONObject.has("prefix_name"));
    localansa.jdField_a_of_type_JavaLangString = paramJSONObject.getString("prefix_name");
    return localansa;
  }
  
  private ansg a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "getAttrsByConfig, bubbleId = " + paramInt + " animName = " + paramString + " autoDown = " + paramBoolean1 + " reversion = " + paramBoolean2);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    anrz localanrz = a(paramInt, paramString);
    if (localanrz == null) {
      return null;
    }
    ansg localansg = new ansg();
    localansg.jdField_a_of_type_Int = localanrz.jdField_c_of_type_Int;
    localansg.jdField_c_of_type_Int = localanrz.jdField_d_of_type_Int;
    localansg.jdField_b_of_type_Int = localanrz.jdField_b_of_type_Int;
    localansg.jdField_b_of_type_Boolean = localanrz.jdField_a_of_type_Boolean;
    localansg.jdField_e_of_type_Int = localanrz.jdField_e_of_type_Int;
    localansg.jdField_a_of_type_Anrz = localanrz;
    File localFile;
    String[] arrayOfString;
    int k;
    int i;
    Object localObject;
    label225:
    label228:
    int j;
    boolean bool;
    if (localansg.jdField_b_of_type_Int <= 1)
    {
      localansg.jdField_a_of_type_Boolean = true;
      localFile = new File(a(paramInt), localanrz.jdField_a_of_type_JavaLangString);
      arrayOfString = new String[localanrz.jdField_c_of_type_Int];
      k = 0;
      i = 0;
      if (localanrz.jdField_a_of_type_AndroidUtilSparseArray != null) {
        break label422;
      }
      if (localanrz.jdField_a_of_type_Int != 4) {
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
        localansg.jdField_a_of_type_Boolean = false;
        break;
        localObject = "%04d.png";
        break label225;
        i += 1;
        break label228;
        int n = localanrz.jdField_a_of_type_AndroidUtilSparseArray.size();
        m = 0;
        k = 0;
        label438:
        j = i;
        if (m >= n) {
          break label778;
        }
        localObject = (ansa)localanrz.jdField_a_of_type_AndroidUtilSparseArray.valueAt(m);
        j = 0;
        label467:
        if (j >= ((ansa)localObject).jdField_a_of_type_Int) {
          break label775;
        }
        arrayOfString[(j + k)] = (localFile.getAbsolutePath() + File.separatorChar + ((ansa)localObject).jdField_a_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(j + 1) }));
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
        j = ((ansa)localObject).jdField_a_of_type_Int;
        m += 1;
        k += j;
        break label438;
        if (i != 0) {
          return null;
        }
        if (arrayOfString.length > 0) {}
        for (localObject = arrayOfString;; localObject = null)
        {
          localansg.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
          localansg.jdField_b_of_type_JavaLangString = paramString;
          localansg.jdField_d_of_type_Int = a(localanrz.jdField_d_of_type_JavaLangString, paramBoolean2);
          if ((localanrz.jdField_a_of_type_ArrayOfInt != null) && (localanrz.jdField_a_of_type_ArrayOfInt.length > 0)) {
            localansg.jdField_a_of_type_AndroidGraphicsRect = a(localanrz.jdField_a_of_type_ArrayOfInt[0], localanrz.jdField_a_of_type_ArrayOfInt[1], localanrz.jdField_a_of_type_ArrayOfInt[2], localanrz.jdField_a_of_type_ArrayOfInt[3]);
          }
          return localansg;
        }
      }
      label778:
      i = j;
    }
  }
  
  private antb a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "getPendantAnimConf object == null");
      localObject = null;
    }
    ante localante;
    do
    {
      return localObject;
      localante = new ante();
      if (paramJSONObject.has("key")) {
        localante.jdField_a_of_type_JavaLangString = paramJSONObject.getString("key");
      }
      if (paramJSONObject.has("duration")) {
        localante.jdField_a_of_type_Long = paramJSONObject.getInt("duration");
      }
      if (paramJSONObject.has("repeat")) {
        localante.jdField_a_of_type_Int = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("pendent_prefix")) {
        localante.jdField_b_of_type_JavaLangString = paramJSONObject.getString("pendent_prefix");
      }
      if (paramJSONObject.has("img_count")) {
        localante.jdField_b_of_type_Int = paramJSONObject.getInt("img_count");
      }
      localObject = localante;
    } while (!paramJSONObject.has("play_with"));
    localante.e = paramJSONObject.getString("play_with");
    return localante;
  }
  
  /* Error */
  private Boolean a(int paramInt, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: new 383	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokevirtual 485	com/tencent/mobileqq/bubble/BubbleManager:c	()Ljava/io/File;
    //   17: new 209	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   24: iload_1
    //   25: invokevirtual 354	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: ldc_w 487
    //   31: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 389	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore 4
    //   42: aload 4
    //   44: invokevirtual 418	java/io/File:exists	()Z
    //   47: ifeq +9 -> 56
    //   50: aload 4
    //   52: invokevirtual 490	java/io/File:delete	()Z
    //   55: pop
    //   56: aload 7
    //   58: astore_3
    //   59: new 492	java/io/RandomAccessFile
    //   62: dup
    //   63: aload 4
    //   65: ldc_w 494
    //   68: invokespecial 495	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: astore 4
    //   73: aload 4
    //   75: aload_2
    //   76: invokevirtual 496	org/json/JSONObject:toString	()Ljava/lang/String;
    //   79: invokevirtual 500	java/lang/String:getBytes	()[B
    //   82: invokevirtual 504	java/io/RandomAccessFile:write	([B)V
    //   85: aload 4
    //   87: invokevirtual 505	java/io/RandomAccessFile:close	()V
    //   90: aload 7
    //   92: astore_3
    //   93: iconst_1
    //   94: invokestatic 510	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   97: astore_2
    //   98: iconst_0
    //   99: ifeq +11 -> 110
    //   102: new 512	java/lang/NullPointerException
    //   105: dup
    //   106: invokespecial 513	java/lang/NullPointerException:<init>	()V
    //   109: athrow
    //   110: aload_2
    //   111: areturn
    //   112: astore_3
    //   113: aload_3
    //   114: invokevirtual 516	java/io/IOException:printStackTrace	()V
    //   117: aload_2
    //   118: areturn
    //   119: astore 4
    //   121: aload 6
    //   123: astore_2
    //   124: aload_2
    //   125: astore_3
    //   126: aload 4
    //   128: invokevirtual 517	java/io/FileNotFoundException:printStackTrace	()V
    //   131: aload_2
    //   132: ifnull +7 -> 139
    //   135: aload_2
    //   136: invokevirtual 505	java/io/RandomAccessFile:close	()V
    //   139: iconst_0
    //   140: invokestatic 510	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   143: areturn
    //   144: astore_2
    //   145: aload_2
    //   146: invokevirtual 516	java/io/IOException:printStackTrace	()V
    //   149: goto -10 -> 139
    //   152: astore 4
    //   154: aload 5
    //   156: astore_2
    //   157: aload_2
    //   158: astore_3
    //   159: aload 4
    //   161: invokevirtual 516	java/io/IOException:printStackTrace	()V
    //   164: aload_2
    //   165: ifnull -26 -> 139
    //   168: aload_2
    //   169: invokevirtual 505	java/io/RandomAccessFile:close	()V
    //   172: goto -33 -> 139
    //   175: astore_2
    //   176: aload_2
    //   177: invokevirtual 516	java/io/IOException:printStackTrace	()V
    //   180: goto -41 -> 139
    //   183: astore_2
    //   184: aload_3
    //   185: ifnull +7 -> 192
    //   188: aload_3
    //   189: invokevirtual 505	java/io/RandomAccessFile:close	()V
    //   192: aload_2
    //   193: athrow
    //   194: astore_3
    //   195: aload_3
    //   196: invokevirtual 516	java/io/IOException:printStackTrace	()V
    //   199: goto -7 -> 192
    //   202: astore_2
    //   203: aload 4
    //   205: astore_3
    //   206: goto -22 -> 184
    //   209: astore_3
    //   210: aload 4
    //   212: astore_2
    //   213: aload_3
    //   214: astore 4
    //   216: goto -59 -> 157
    //   219: astore_3
    //   220: aload 4
    //   222: astore_2
    //   223: aload_3
    //   224: astore 4
    //   226: goto -102 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	BubbleManager
    //   0	229	1	paramInt	int
    //   0	229	2	paramJSONObject	JSONObject
    //   58	35	3	localObject1	Object
    //   112	2	3	localIOException1	IOException
    //   125	64	3	localJSONObject	JSONObject
    //   194	2	3	localIOException2	IOException
    //   205	1	3	localIOException3	IOException
    //   209	5	3	localIOException4	IOException
    //   219	5	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   40	46	4	localObject2	Object
    //   119	8	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   152	59	4	localIOException5	IOException
    //   214	11	4	localObject3	Object
    //   1	154	5	localObject4	Object
    //   7	115	6	localObject5	Object
    //   4	87	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   102	110	112	java/io/IOException
    //   59	73	119	java/io/FileNotFoundException
    //   93	98	119	java/io/FileNotFoundException
    //   135	139	144	java/io/IOException
    //   59	73	152	java/io/IOException
    //   93	98	152	java/io/IOException
    //   168	172	175	java/io/IOException
    //   59	73	183	finally
    //   93	98	183	finally
    //   126	131	183	finally
    //   159	164	183	finally
    //   188	192	194	java/io/IOException
    //   73	90	202	finally
    //   73	90	209	java/io/IOException
    //   73	90	219	java/io/FileNotFoundException
  }
  
  private ArrayList<antb> a(JSONArray paramJSONArray)
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
  
  private void a(anrz paramanrz, JSONObject paramJSONObject)
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
            paramanrz.jdField_e_of_type_Int = 10;
          }
          if ("circle".equalsIgnoreCase((String)localObject)) {
            paramanrz.jdField_e_of_type_Int = 11;
          }
          if ("static".equalsIgnoreCase((String)localObject)) {
            paramanrz.jdField_e_of_type_Int = 1;
          }
        }
        if (paramJSONObject.has("padding"))
        {
          localObject = paramJSONObject.getJSONArray("padding");
          paramanrz.jdField_f_of_type_Int = ((JSONArray)localObject).getInt(0);
          paramanrz.jdField_h_of_type_Int = ((JSONArray)localObject).getInt(1);
          paramanrz.jdField_g_of_type_Int = ((JSONArray)localObject).getInt(2);
          paramanrz.i = ((JSONArray)localObject).getInt(3);
        }
      } while (!paramJSONObject.has("step"));
      if (paramanrz.jdField_a_of_type_AndroidUtilSparseArray == null) {
        paramanrz.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
      }
      paramJSONObject = paramJSONObject.getJSONObject("step");
      if (paramJSONObject.has("static"))
      {
        localObject = paramJSONObject.getJSONObject("static");
        paramanrz.jdField_a_of_type_AndroidUtilSparseArray.put(0, a("static", (JSONObject)localObject));
      }
      if (paramJSONObject.has("moving"))
      {
        localObject = paramJSONObject.getJSONObject("moving");
        paramanrz.jdField_a_of_type_AndroidUtilSparseArray.put(1, a("moving", (JSONObject)localObject));
      }
    } while (!paramJSONObject.has("turnback"));
    paramJSONObject = paramJSONObject.getJSONObject("turnback");
    paramanrz.jdField_a_of_type_AndroidUtilSparseArray.put(2, a("turnback", paramJSONObject));
  }
  
  private void a(ansc paramansc, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString)
  {
    paramJSONObject2 = paramJSONObject2.optString(paramString);
    paramJSONObject1 = b(paramJSONObject2, paramJSONObject1);
    antc localantc = new antc();
    localantc.a(paramansc.jdField_a_of_type_Int, paramJSONObject2, paramJSONObject1);
    paramansc.jdField_b_of_type_JavaUtilHashMap.put(paramString, localantc);
  }
  
  private boolean a(ansf paramansf)
  {
    if (paramansf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "checkBubbleStaticSource|bubbleInfo is null");
      }
      return false;
    }
    Object localObject1 = a(paramansf.jdField_a_of_type_Int).getAbsolutePath() + File.separatorChar + "chartlet" + File.separatorChar;
    localObject1 = (String)localObject1 + "chartlet.png";
    boolean bool = new File((String)localObject1).exists();
    if (((!bool) || (!TextUtils.isEmpty(paramansf.e))) && (!TextUtils.isEmpty(paramansf.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramansf.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramansf.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "checkBubbleStaticSource|bubbleId=" + paramansf.jdField_a_of_type_Int + ",chkStaticSrcAndUpdate is ok | not empty");
      }
      return true;
    }
    String str3 = a(paramansf.jdField_a_of_type_Int).getAbsolutePath() + File.separatorChar + "static" + File.separatorChar;
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
          QLog.d("BubbleManager", 2, "checkBubbleStaticSource|file is not exists,bubbleId=" + paramansf.jdField_a_of_type_Int + ",strFilePath=" + str4);
        }
        return false;
      }
    }
    paramansf.jdField_d_of_type_JavaLangString = str3;
    paramansf.jdField_a_of_type_JavaLangString = str1;
    paramansf.jdField_b_of_type_JavaLangString = str2;
    paramansf.e = ((String)localObject1);
    paramansf.jdField_a_of_type_ArrayOfJavaLangString = a(paramansf.jdField_a_of_type_Int);
    try
    {
      localObject1 = a(str3, null);
      if (localObject1 != null)
      {
        int i = ((Bitmap)localObject1).getPixel(((Bitmap)localObject1).getWidth() / 2, ((Bitmap)localObject1).getHeight() / 2);
        if (paramansf.jdField_b_of_type_Int == i)
        {
          paramansf.jdField_b_of_type_Int = Color.rgb(255 - Color.red(i), 255 - Color.green(i), 255 - Color.blue(i));
          if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, "text color:" + Integer.toHexString(i) + ",  now chage to " + Integer.toHexString(paramansf.jdField_b_of_type_Int));
          }
        }
        if (paramansf.jdField_c_of_type_Int == i)
        {
          paramansf.jdField_c_of_type_Int = Color.rgb(255 - Color.red(i), 255 - Color.green(i), 255 - Color.blue(i));
          if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, "mLinkColor :" + Integer.toHexString(i) + ",  now chage to " + Integer.toHexString(paramansf.jdField_c_of_type_Int));
          }
        }
      }
    }
    catch (OutOfMemoryError paramansf)
    {
      for (;;)
      {
        QLog.e("BubbleManager", 2, "bubble change color out of memory error!", paramansf);
      }
    }
    catch (Exception paramansf)
    {
      for (;;)
      {
        QLog.e("BubbleManager", 2, "bubble change color throws exception!", paramansf);
      }
    }
    return true;
  }
  
  private anrz b(JSONObject paramJSONObject)
  {
    int i = 0;
    anrz localanrz = new anrz();
    localanrz.jdField_a_of_type_Int = 5;
    localanrz.jdField_e_of_type_Int = 1;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseVoicePrintAnimationConfig object = null");
      return null;
    }
    if (paramJSONObject.has("align")) {
      localanrz.jdField_d_of_type_JavaLangString = paramJSONObject.getString("align");
    }
    if (paramJSONObject.has("repeat")) {
      localanrz.jdField_b_of_type_Int = paramJSONObject.getInt("repeat");
    }
    if (paramJSONObject.has("count")) {
      localanrz.jdField_c_of_type_Int = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("zip_name")) {
      localanrz.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zip_name");
    }
    if (paramJSONObject.has("time")) {
      localanrz.jdField_d_of_type_Int = paramJSONObject.getInt("time");
    }
    if (paramJSONObject.has("padding"))
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("padding");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        localanrz.jdField_f_of_type_Int = aekt.a(localJSONArray.getInt(0) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
        localanrz.jdField_h_of_type_Int = aekt.a(localJSONArray.getInt(1) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
        localanrz.jdField_g_of_type_Int = aekt.a(localJSONArray.getInt(2) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
        localanrz.i = aekt.a(localJSONArray.getInt(3) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
    }
    if (paramJSONObject.has("cut_array"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("cut_array");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        localanrz.jdField_c_of_type_ArrayOfInt = new int[paramJSONObject.length()];
        while (i < paramJSONObject.length())
        {
          localanrz.jdField_c_of_type_ArrayOfInt[i] = paramJSONObject.getInt(i);
          i += 1;
        }
        Arrays.sort(localanrz.jdField_c_of_type_ArrayOfInt);
      }
    }
    return localanrz;
  }
  
  private antb b(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "getPathAnimConf object == null");
      localObject = null;
    }
    antd localantd;
    do
    {
      return localObject;
      localantd = new antd();
      if (paramJSONObject.has("key")) {
        localantd.jdField_a_of_type_JavaLangString = paramJSONObject.getString("key");
      }
      if (paramJSONObject.has("start_end"))
      {
        localObject = paramJSONObject.getJSONArray("start_end");
        localantd.jdField_a_of_type_Float = ((float)((JSONArray)localObject).getDouble(0));
        localantd.jdField_b_of_type_Float = ((float)((JSONArray)localObject).getDouble(1));
        localantd.jdField_c_of_type_Float = ((float)((JSONArray)localObject).getDouble(2));
        localantd.d = ((float)((JSONArray)localObject).getDouble(3));
      }
      if (paramJSONObject.has("bezier"))
      {
        localObject = paramJSONObject.getJSONArray("bezier");
        localantd.jdField_e_of_type_Float = ((float)((JSONArray)localObject).getDouble(0));
        localantd.jdField_f_of_type_Float = ((float)((JSONArray)localObject).getDouble(1));
        localantd.jdField_g_of_type_Float = ((float)((JSONArray)localObject).getDouble(2));
        localantd.jdField_h_of_type_Float = ((float)((JSONArray)localObject).getDouble(3));
      }
      if (paramJSONObject.has("duration")) {
        localantd.jdField_a_of_type_Long = paramJSONObject.getInt("duration");
      }
      if (paramJSONObject.has("speed")) {
        localantd.jdField_e_of_type_Int = paramJSONObject.getInt("speed");
      }
      if (paramJSONObject.has("img_prefix")) {
        localantd.jdField_b_of_type_JavaLangString = paramJSONObject.getString("img_prefix");
      }
      if (paramJSONObject.has("img_reverse")) {
        localantd.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("img_reverse");
      }
      if (paramJSONObject.has("img_alpha"))
      {
        localObject = paramJSONObject.getJSONArray("img_alpha");
        localantd.jdField_f_of_type_Int = ((JSONArray)localObject).getInt(0);
        localantd.jdField_g_of_type_Int = ((JSONArray)localObject).getInt(1);
      }
      if (paramJSONObject.has("repeat")) {
        localantd.jdField_a_of_type_Int = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("img_rotate"))
      {
        localObject = paramJSONObject.getJSONArray("img_rotate");
        localantd.jdField_h_of_type_Int = ((JSONArray)localObject).getInt(0);
        localantd.i = ((JSONArray)localObject).getInt(1);
      }
      if (paramJSONObject.has("img_count")) {
        localantd.jdField_b_of_type_Int = paramJSONObject.getInt("img_count");
      }
      if (paramJSONObject.has("periodical")) {
        localantd.jdField_c_of_type_Boolean = paramJSONObject.getBoolean("periodical");
      }
      localObject = localantd;
    } while (!paramJSONObject.has("period_length"));
    localantd.j = paramJSONObject.getInt("period_length");
    return localantd;
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
  
  private void b(int paramInt)
  {
    if (a(paramInt)) {
      a(paramInt, new String[] { "bubble.android." + paramInt + "." + "static.zip", "bubble.android." + paramInt + "." + "other.zip" }, "0");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "createBubbleInfo, download bubble resource, bubbleId=" + paramInt);
      }
      return;
      a(paramInt, "static.zip", "0");
    }
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = true;
    ??? = new File(c(), paramInt + ".cfg");
    if (!((File)???).exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "readLocalVersionInfo local info not exist id = " + paramInt);
      }
    }
    do
    {
      return false;
      ??? = bdcs.a((File)???, -1);
      if (!TextUtils.isEmpty((CharSequence)???)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BubbleManager", 2, "readLocalVersionInfo read local info fail id = " + paramInt);
    return false;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)???);
        synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
        {
          this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(Integer.valueOf(paramInt), localJSONObject);
          int i = localJSONObject.optInt("full_download");
          if (i == 1) {
            return bool;
          }
        }
        bool = false;
      }
      catch (Exception localException)
      {
        QLog.e("BubbleManager", 1, "readLocalVersionInfo id = " + paramInt + " error: ", localException);
        return false;
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
  
  public anrz a(int paramInt1, int paramInt2)
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
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(((anrz)localObject).jdField_b_of_type_JavaLangString))
        {
          return localObject;
          localObject = ((ansc)localObject).jdField_c_of_type_Anrz;
          anrz.a((anrz)localObject);
          continue;
          localObject = ((ansc)localObject).jdField_b_of_type_Anrz;
          continue;
          localObject = ((ansc)localObject).jdField_f_of_type_Anrz;
        }
        else if ((localObject != null) && (((anrz)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (((anrz)localObject).jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          Iterator localIterator = ((anrz)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
          paramInt2 = 1;
          if (!localIterator.hasNext()) {
            break label315;
          }
          antb localantb = (antb)localIterator.next();
          File localFile = new File(a(paramInt1), ((anrz)localObject).jdField_a_of_type_JavaLangString);
          i = 0;
          label188:
          if (i >= localantb.jdField_b_of_type_Int) {
            break label350;
          }
          String str = localFile.getAbsolutePath() + File.separatorChar + localantb.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
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
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((anrz)localObject).jdField_b_of_type_JavaLangString, localObject);
      return localObject;
    }
  }
  
  anrz a(int paramInt, String paramString)
  {
    Object localObject = a(paramInt, true);
    if (localObject == null)
    {
      QLog.e("BubbleManager", 1, "findAnimConfig bubbleId = " + paramInt + " bubbleConfig = null");
      return null;
    }
    if ((((ansc)localObject).jdField_a_of_type_Anrz != null) && (((ansc)localObject).jdField_a_of_type_Anrz.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((ansc)localObject).jdField_a_of_type_Anrz;
    }
    if ((((ansc)localObject).jdField_b_of_type_Anrz != null) && (((ansc)localObject).jdField_b_of_type_Anrz.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((ansc)localObject).jdField_b_of_type_Anrz;
    }
    if ((((ansc)localObject).jdField_c_of_type_Anrz != null) && (((ansc)localObject).jdField_c_of_type_Anrz.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((ansc)localObject).jdField_c_of_type_Anrz;
    }
    if ((((ansc)localObject).jdField_d_of_type_Anrz != null) && (((ansc)localObject).jdField_d_of_type_Anrz.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((ansc)localObject).jdField_d_of_type_Anrz;
    }
    if ((((ansc)localObject).jdField_e_of_type_Anrz != null) && (((ansc)localObject).jdField_e_of_type_Anrz.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((ansc)localObject).jdField_e_of_type_Anrz;
    }
    if (((ansc)localObject).jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = ((ansc)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        anrz localanrz = (anrz)((Iterator)localObject).next();
        if (localanrz.jdField_b_of_type_JavaLangString.equals(paramString)) {
          return localanrz;
        }
      }
    }
    return null;
  }
  
  /* Error */
  ansc a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: invokestatic 349	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 207
    //   8: iconst_2
    //   9: new 209	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 865
    //   19: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 354	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 867
    //   29: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 366	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_2
    //   43: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifeq +5 -> 51
    //   49: aconst_null
    //   50: areturn
    //   51: aload_0
    //   52: aload_2
    //   53: invokevirtual 869	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 8
    //   58: aload 8
    //   60: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +5 -> 68
    //   66: aconst_null
    //   67: areturn
    //   68: invokestatic 349	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +30 -> 101
    //   74: ldc 207
    //   76: iconst_2
    //   77: new 209	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 871
    //   87: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 8
    //   92: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 426	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload 8
    //   103: astore_2
    //   104: getstatic 876	android/os/Build$VERSION:SDK_INT	I
    //   107: bipush 10
    //   109: if_icmpgt +37 -> 146
    //   112: aload 8
    //   114: astore_2
    //   115: aload 8
    //   117: invokevirtual 877	java/lang/String:length	()I
    //   120: iconst_1
    //   121: if_icmple +25 -> 146
    //   124: aload 8
    //   126: astore_2
    //   127: aload 8
    //   129: iconst_0
    //   130: invokevirtual 881	java/lang/String:charAt	(I)C
    //   133: ldc_w 882
    //   136: if_icmpne +10 -> 146
    //   139: aload 8
    //   141: iconst_1
    //   142: invokevirtual 885	java/lang/String:substring	(I)Ljava/lang/String;
    //   145: astore_2
    //   146: new 588	ansc
    //   149: dup
    //   150: iload_1
    //   151: invokespecial 886	ansc:<init>	(I)V
    //   154: astore 9
    //   156: new 254	org/json/JSONObject
    //   159: dup
    //   160: aload_2
    //   161: invokespecial 798	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   164: astore 10
    //   166: aload 9
    //   168: aload 10
    //   170: ldc_w 888
    //   173: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: putfield 889	ansc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   179: aload 10
    //   181: ldc_w 891
    //   184: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   187: istore 7
    //   189: iload 7
    //   191: ifeq +122 -> 313
    //   194: aload 10
    //   196: ldc_w 891
    //   199: invokevirtual 262	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull +109 -> 313
    //   207: aload_2
    //   208: invokevirtual 271	org/json/JSONArray:length	()I
    //   211: ifle +102 -> 313
    //   214: aload 9
    //   216: new 48	java/util/ArrayList
    //   219: dup
    //   220: invokespecial 49	java/util/ArrayList:<init>	()V
    //   223: putfield 893	ansc:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   226: aload 9
    //   228: iconst_0
    //   229: putfield 894	ansc:jdField_e_of_type_Int	I
    //   232: iconst_0
    //   233: istore 5
    //   235: iload 5
    //   237: aload_2
    //   238: invokevirtual 271	org/json/JSONArray:length	()I
    //   241: if_icmpge +30 -> 271
    //   244: aload 9
    //   246: getfield 893	ansc:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   249: aload_2
    //   250: iload 5
    //   252: invokevirtual 275	org/json/JSONArray:getInt	(I)I
    //   255: invokestatic 410	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: invokevirtual 528	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   261: pop
    //   262: iload 5
    //   264: iconst_1
    //   265: iadd
    //   266: istore 5
    //   268: goto -33 -> 235
    //   271: invokestatic 349	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +39 -> 313
    //   277: ldc 207
    //   279: iconst_2
    //   280: new 209	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 896
    //   290: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 898
    //   296: aload 9
    //   298: getfield 893	ansc:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   301: invokestatic 902	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   304: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 366	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload 10
    //   315: ldc_w 904
    //   318: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   321: ifeq +62 -> 383
    //   324: aload 10
    //   326: ldc_w 904
    //   329: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   332: astore 8
    //   334: aload 8
    //   336: astore_2
    //   337: aload 8
    //   339: ldc_w 906
    //   342: invokevirtual 909	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   345: ifeq +10 -> 355
    //   348: aload 8
    //   350: iconst_2
    //   351: invokevirtual 885	java/lang/String:substring	(I)Ljava/lang/String;
    //   354: astore_2
    //   355: aload 9
    //   357: new 209	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   364: ldc_w 911
    //   367: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_2
    //   371: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 914	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   380: putfield 915	ansc:jdField_b_of_type_Int	I
    //   383: aload 10
    //   385: ldc_w 917
    //   388: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   391: ifeq +62 -> 453
    //   394: aload 10
    //   396: ldc_w 917
    //   399: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   402: astore 8
    //   404: aload 8
    //   406: astore_2
    //   407: aload 8
    //   409: ldc_w 906
    //   412: invokevirtual 909	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   415: ifeq +10 -> 425
    //   418: aload 8
    //   420: iconst_2
    //   421: invokevirtual 885	java/lang/String:substring	(I)Ljava/lang/String;
    //   424: astore_2
    //   425: aload 9
    //   427: new 209	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   434: ldc_w 911
    //   437: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_2
    //   441: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 914	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   450: putfield 918	ansc:jdField_c_of_type_Int	I
    //   453: aload 10
    //   455: ldc_w 920
    //   458: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   461: ifeq +943 -> 1404
    //   464: aload 9
    //   466: iconst_1
    //   467: putfield 921	ansc:jdField_a_of_type_Boolean	Z
    //   470: aload 10
    //   472: ldc_w 920
    //   475: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: astore 8
    //   480: aload 8
    //   482: astore_2
    //   483: aload 8
    //   485: ldc_w 906
    //   488: invokevirtual 909	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   491: ifeq +10 -> 501
    //   494: aload 8
    //   496: iconst_2
    //   497: invokevirtual 885	java/lang/String:substring	(I)Ljava/lang/String;
    //   500: astore_2
    //   501: aload 9
    //   503: new 209	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 911
    //   513: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_2
    //   517: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 914	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   526: putfield 922	ansc:jdField_d_of_type_Int	I
    //   529: aload 9
    //   531: aload 10
    //   533: ldc_w 924
    //   536: dconst_1
    //   537: invokevirtual 928	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   540: putfield 931	ansc:jdField_a_of_type_Double	D
    //   543: aload 10
    //   545: ldc_w 933
    //   548: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   551: ifeq +36 -> 587
    //   554: aload 10
    //   556: ldc_w 933
    //   559: invokevirtual 262	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   562: astore_2
    //   563: aload 9
    //   565: iconst_2
    //   566: newarray int
    //   568: dup
    //   569: iconst_0
    //   570: aload_2
    //   571: iconst_0
    //   572: invokevirtual 275	org/json/JSONArray:getInt	(I)I
    //   575: iastore
    //   576: dup
    //   577: iconst_1
    //   578: aload_2
    //   579: iconst_1
    //   580: invokevirtual 275	org/json/JSONArray:getInt	(I)I
    //   583: iastore
    //   584: putfield 934	ansc:jdField_a_of_type_ArrayOfInt	[I
    //   587: aload 10
    //   589: ldc_w 936
    //   592: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   595: ifeq +95 -> 690
    //   598: aload 10
    //   600: ldc_w 936
    //   603: invokevirtual 538	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   606: astore_2
    //   607: aload_2
    //   608: ldc_w 938
    //   611: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   614: ifeq +76 -> 690
    //   617: aload_0
    //   618: aload_2
    //   619: ldc_w 938
    //   622: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   625: aload 10
    //   627: invokespecial 940	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   630: astore 8
    //   632: aload 8
    //   634: ifnull +56 -> 690
    //   637: aload_0
    //   638: iconst_0
    //   639: aload 8
    //   641: invokespecial 942	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lanrz;
    //   644: astore 8
    //   646: aload 8
    //   648: aload_2
    //   649: ldc_w 938
    //   652: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   655: putfield 826	anrz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   658: aload 9
    //   660: aload 8
    //   662: putfield 855	ansc:jdField_a_of_type_Anrz	Lanrz;
    //   665: aload 8
    //   667: getfield 293	anrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   670: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   673: ifne +17 -> 690
    //   676: aload 9
    //   678: getfield 945	ansc:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   681: aload 8
    //   683: getfield 293	anrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   686: invokevirtual 948	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   689: pop
    //   690: aload 10
    //   692: ldc_w 950
    //   695: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   698: ifeq +131 -> 829
    //   701: aload 10
    //   703: ldc_w 950
    //   706: invokevirtual 538	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   709: astore_2
    //   710: aload_2
    //   711: ldc_w 938
    //   714: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   717: ifeq +112 -> 829
    //   720: aload_0
    //   721: aload_2
    //   722: ldc_w 938
    //   725: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   728: aload 10
    //   730: invokespecial 940	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   733: astore 11
    //   735: aload 11
    //   737: ifnull +92 -> 829
    //   740: aload_0
    //   741: iconst_2
    //   742: aload 11
    //   744: invokespecial 942	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lanrz;
    //   747: astore 8
    //   749: aload 11
    //   751: ldc_w 952
    //   754: invokevirtual 262	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   757: astore 11
    //   759: aload 8
    //   761: iconst_2
    //   762: newarray int
    //   764: dup
    //   765: iconst_0
    //   766: aload 11
    //   768: iconst_0
    //   769: invokevirtual 275	org/json/JSONArray:getInt	(I)I
    //   772: iastore
    //   773: dup
    //   774: iconst_1
    //   775: aload 11
    //   777: iconst_1
    //   778: invokevirtual 275	org/json/JSONArray:getInt	(I)I
    //   781: iastore
    //   782: putfield 954	anrz:jdField_b_of_type_ArrayOfInt	[I
    //   785: aload 8
    //   787: aload_2
    //   788: ldc_w 938
    //   791: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   794: putfield 826	anrz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   797: aload 9
    //   799: aload 8
    //   801: putfield 836	ansc:jdField_b_of_type_Anrz	Lanrz;
    //   804: aload 8
    //   806: getfield 293	anrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   809: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   812: ifne +17 -> 829
    //   815: aload 9
    //   817: getfield 945	ansc:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   820: aload 8
    //   822: getfield 293	anrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   825: invokevirtual 948	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   828: pop
    //   829: aload 10
    //   831: ldc_w 956
    //   834: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   837: ifeq +152 -> 989
    //   840: aload 10
    //   842: ldc_w 956
    //   845: invokevirtual 538	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   848: astore_2
    //   849: aload_2
    //   850: ldc_w 938
    //   853: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   856: ifeq +133 -> 989
    //   859: aload_0
    //   860: aload_2
    //   861: ldc_w 938
    //   864: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   867: aload 10
    //   869: invokespecial 940	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   872: astore 8
    //   874: aload 8
    //   876: ifnull +113 -> 989
    //   879: aload_0
    //   880: iconst_3
    //   881: aload 8
    //   883: invokespecial 942	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lanrz;
    //   886: astore 8
    //   888: aload 8
    //   890: aload_2
    //   891: ldc_w 938
    //   894: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   897: putfield 826	anrz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   900: aload_2
    //   901: ldc_w 958
    //   904: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   907: ifeq +50 -> 957
    //   910: aload_2
    //   911: ldc_w 958
    //   914: invokevirtual 280	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   917: istore 5
    //   919: aload_0
    //   920: getfield 106	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   923: ldc_w 960
    //   926: invokevirtual 964	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   929: checkcast 966	android/view/WindowManager
    //   932: invokeinterface 970 1 0
    //   937: invokevirtual 973	android/view/Display:getWidth	()I
    //   940: i2d
    //   941: dstore_3
    //   942: aload 8
    //   944: iload 5
    //   946: i2d
    //   947: ldc2_w 974
    //   950: ddiv
    //   951: dload_3
    //   952: dmul
    //   953: d2i
    //   954: putfield 976	anrz:j	I
    //   957: aload 9
    //   959: aload 8
    //   961: putfield 831	ansc:jdField_c_of_type_Anrz	Lanrz;
    //   964: aload 8
    //   966: getfield 293	anrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   969: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   972: ifne +17 -> 989
    //   975: aload 9
    //   977: getfield 945	ansc:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   980: aload 8
    //   982: getfield 293	anrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   985: invokevirtual 948	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   988: pop
    //   989: aload 10
    //   991: ldc_w 978
    //   994: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   997: ifeq +94 -> 1091
    //   1000: aload 10
    //   1002: ldc_w 978
    //   1005: invokevirtual 538	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1008: astore_2
    //   1009: aload_2
    //   1010: ldc_w 980
    //   1013: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1016: ifeq +75 -> 1091
    //   1019: aload_0
    //   1020: aload_2
    //   1021: ldc_w 980
    //   1024: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1027: aload 10
    //   1029: invokespecial 583	com/tencent/mobileqq/bubble/BubbleManager:b	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1032: astore 8
    //   1034: aload 8
    //   1036: ifnull +55 -> 1091
    //   1039: aload_0
    //   1040: aload 8
    //   1042: invokespecial 982	com/tencent/mobileqq/bubble/BubbleManager:a	(Lorg/json/JSONObject;)Lanrz;
    //   1045: astore 8
    //   1047: aload 8
    //   1049: aload_2
    //   1050: ldc_w 980
    //   1053: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1056: putfield 826	anrz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1059: aload 9
    //   1061: aload 8
    //   1063: putfield 857	ansc:jdField_d_of_type_Anrz	Lanrz;
    //   1066: aload 8
    //   1068: getfield 293	anrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1071: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1074: ifne +17 -> 1091
    //   1077: aload 9
    //   1079: getfield 945	ansc:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1082: aload 8
    //   1084: getfield 293	anrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1087: invokevirtual 948	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1090: pop
    //   1091: aload 10
    //   1093: ldc_w 984
    //   1096: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1099: ifeq +94 -> 1193
    //   1102: aload 10
    //   1104: ldc_w 984
    //   1107: invokevirtual 538	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1110: astore_2
    //   1111: aload_2
    //   1112: ldc_w 980
    //   1115: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1118: ifeq +75 -> 1193
    //   1121: aload_0
    //   1122: aload_2
    //   1123: ldc_w 980
    //   1126: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1129: aload 10
    //   1131: invokespecial 583	com/tencent/mobileqq/bubble/BubbleManager:b	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1134: astore 8
    //   1136: aload 8
    //   1138: ifnull +55 -> 1193
    //   1141: aload_0
    //   1142: aload 8
    //   1144: invokespecial 986	com/tencent/mobileqq/bubble/BubbleManager:b	(Lorg/json/JSONObject;)Lanrz;
    //   1147: astore 8
    //   1149: aload 8
    //   1151: aload_2
    //   1152: ldc_w 980
    //   1155: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1158: putfield 826	anrz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1161: aload 9
    //   1163: aload 8
    //   1165: putfield 859	ansc:jdField_e_of_type_Anrz	Lanrz;
    //   1168: aload 8
    //   1170: getfield 293	anrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1173: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1176: ifne +17 -> 1193
    //   1179: aload 9
    //   1181: getfield 945	ansc:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1184: aload 8
    //   1186: getfield 293	anrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1189: invokevirtual 948	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1192: pop
    //   1193: aload 10
    //   1195: ldc_w 988
    //   1198: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1201: ifeq +426 -> 1627
    //   1204: aload 10
    //   1206: ldc_w 988
    //   1209: invokevirtual 262	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1212: astore_2
    //   1213: new 48	java/util/ArrayList
    //   1216: dup
    //   1217: invokespecial 49	java/util/ArrayList:<init>	()V
    //   1220: astore 8
    //   1222: iconst_0
    //   1223: istore 5
    //   1225: iload 5
    //   1227: aload_2
    //   1228: invokevirtual 271	org/json/JSONArray:length	()I
    //   1231: if_icmpge +389 -> 1620
    //   1234: aload_2
    //   1235: iload 5
    //   1237: invokevirtual 523	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1240: astore 11
    //   1242: aload 11
    //   1244: ldc_w 938
    //   1247: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1250: ifeq +818 -> 2068
    //   1253: aload_0
    //   1254: aload 11
    //   1256: ldc_w 938
    //   1259: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1262: aload 10
    //   1264: invokespecial 940	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1267: astore 12
    //   1269: aload 12
    //   1271: ifnonnull +231 -> 1502
    //   1274: goto +794 -> 2068
    //   1277: astore_2
    //   1278: invokestatic 349	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1281: ifeq -968 -> 313
    //   1284: ldc 207
    //   1286: iconst_2
    //   1287: ldc_w 990
    //   1290: aload_2
    //   1291: invokestatic 234	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1294: goto -981 -> 313
    //   1297: astore_2
    //   1298: ldc 207
    //   1300: iconst_1
    //   1301: new 209	java/lang/StringBuilder
    //   1304: dup
    //   1305: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   1308: ldc_w 992
    //   1311: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: iload_1
    //   1315: invokevirtual 354	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1318: ldc_w 994
    //   1321: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: aload_2
    //   1328: invokestatic 234	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1331: aconst_null
    //   1332: areturn
    //   1333: astore_2
    //   1334: invokestatic 349	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1337: ifeq -954 -> 383
    //   1340: ldc 207
    //   1342: iconst_2
    //   1343: ldc_w 996
    //   1346: invokestatic 426	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1349: goto -966 -> 383
    //   1352: astore_2
    //   1353: ldc 207
    //   1355: iconst_1
    //   1356: ldc_w 998
    //   1359: aload_2
    //   1360: invokestatic 234	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1363: goto -32 -> 1331
    //   1366: astore_2
    //   1367: invokestatic 349	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1370: ifeq -917 -> 453
    //   1373: ldc 207
    //   1375: iconst_2
    //   1376: ldc_w 1000
    //   1379: invokestatic 426	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1382: goto -929 -> 453
    //   1385: astore_2
    //   1386: invokestatic 349	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1389: ifeq -860 -> 529
    //   1392: ldc 207
    //   1394: iconst_2
    //   1395: ldc_w 1002
    //   1398: invokestatic 426	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1401: goto -872 -> 529
    //   1404: aload 10
    //   1406: ldc_w 1004
    //   1409: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1412: ifeq -883 -> 529
    //   1415: aload 9
    //   1417: iconst_1
    //   1418: putfield 1005	ansc:jdField_b_of_type_Boolean	Z
    //   1421: aload 10
    //   1423: ldc_w 1004
    //   1426: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1429: astore 8
    //   1431: aload 8
    //   1433: astore_2
    //   1434: aload 8
    //   1436: ldc_w 906
    //   1439: invokevirtual 909	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1442: ifeq +10 -> 1452
    //   1445: aload 8
    //   1447: iconst_2
    //   1448: invokevirtual 885	java/lang/String:substring	(I)Ljava/lang/String;
    //   1451: astore_2
    //   1452: aload 9
    //   1454: new 209	java/lang/StringBuilder
    //   1457: dup
    //   1458: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   1461: ldc_w 911
    //   1464: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: aload_2
    //   1468: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1474: invokestatic 914	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1477: putfield 922	ansc:jdField_d_of_type_Int	I
    //   1480: goto -951 -> 529
    //   1483: astore_2
    //   1484: invokestatic 349	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1487: ifeq -958 -> 529
    //   1490: ldc 207
    //   1492: iconst_2
    //   1493: ldc_w 1002
    //   1496: invokestatic 426	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1499: goto -970 -> 529
    //   1502: aload_0
    //   1503: iconst_1
    //   1504: aload 12
    //   1506: invokespecial 942	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lanrz;
    //   1509: astore 12
    //   1511: aload 11
    //   1513: ldc_w 1007
    //   1516: invokevirtual 262	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1519: astore 13
    //   1521: aload 12
    //   1523: aload 13
    //   1525: invokevirtual 271	org/json/JSONArray:length	()I
    //   1528: anewarray 156	java/lang/String
    //   1531: putfield 1008	anrz:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1534: iconst_0
    //   1535: istore 6
    //   1537: iload 6
    //   1539: aload 13
    //   1541: invokevirtual 271	org/json/JSONArray:length	()I
    //   1544: if_icmpge +27 -> 1571
    //   1547: aload 12
    //   1549: getfield 1008	anrz:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1552: iload 6
    //   1554: aload 13
    //   1556: iload 6
    //   1558: invokevirtual 1010	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1561: aastore
    //   1562: iload 6
    //   1564: iconst_1
    //   1565: iadd
    //   1566: istore 6
    //   1568: goto -31 -> 1537
    //   1571: aload 12
    //   1573: aload 11
    //   1575: ldc_w 938
    //   1578: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1581: putfield 826	anrz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1584: aload 8
    //   1586: aload 12
    //   1588: invokevirtual 528	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1591: pop
    //   1592: aload 12
    //   1594: getfield 293	anrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1597: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1600: ifne +468 -> 2068
    //   1603: aload 9
    //   1605: getfield 945	ansc:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1608: aload 12
    //   1610: getfield 293	anrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1613: invokevirtual 948	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1616: pop
    //   1617: goto +451 -> 2068
    //   1620: aload 9
    //   1622: aload 8
    //   1624: putfield 860	ansc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1627: aload 9
    //   1629: iload_1
    //   1630: aload 10
    //   1632: invokestatic 1015	antk:a	(ILorg/json/JSONObject;)Ljava/util/HashMap;
    //   1635: putfield 1017	ansc:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1638: aload 10
    //   1640: ldc_w 1019
    //   1643: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1646: ifeq +211 -> 1857
    //   1649: aload 10
    //   1651: ldc_w 1019
    //   1654: invokevirtual 538	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1657: astore 8
    //   1659: new 245	anrz
    //   1662: dup
    //   1663: invokespecial 246	anrz:<init>	()V
    //   1666: astore_2
    //   1667: aload 8
    //   1669: ldc_w 1021
    //   1672: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1675: ifeq +15 -> 1690
    //   1678: aload_2
    //   1679: aload 8
    //   1681: ldc_w 1021
    //   1684: invokevirtual 280	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1687: putfield 1024	anrz:k	I
    //   1690: aload 8
    //   1692: ldc_w 980
    //   1695: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1698: ifeq +159 -> 1857
    //   1701: aload 8
    //   1703: ldc_w 980
    //   1706: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1709: astore 8
    //   1711: aload_2
    //   1712: aload 8
    //   1714: putfield 826	anrz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1717: aload_0
    //   1718: aload 8
    //   1720: aload 10
    //   1722: invokespecial 583	com/tencent/mobileqq/bubble/BubbleManager:b	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1725: astore 11
    //   1727: aload 11
    //   1729: ifnull +128 -> 1857
    //   1732: aload_2
    //   1733: aload 11
    //   1735: ldc_w 287
    //   1738: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1741: putfield 293	anrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1744: aload 11
    //   1746: ldc_w 1026
    //   1749: invokevirtual 262	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1752: astore 8
    //   1754: aload 11
    //   1756: ldc_w 553
    //   1759: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1762: ifeq +66 -> 1828
    //   1765: aload 11
    //   1767: ldc_w 553
    //   1770: invokevirtual 262	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1773: astore 11
    //   1775: aload 11
    //   1777: ifnull +51 -> 1828
    //   1780: aload 11
    //   1782: invokevirtual 271	org/json/JSONArray:length	()I
    //   1785: ifle +43 -> 1828
    //   1788: aload_2
    //   1789: aload 11
    //   1791: iconst_0
    //   1792: invokevirtual 275	org/json/JSONArray:getInt	(I)I
    //   1795: putfield 556	anrz:jdField_f_of_type_Int	I
    //   1798: aload_2
    //   1799: aload 11
    //   1801: iconst_1
    //   1802: invokevirtual 275	org/json/JSONArray:getInt	(I)I
    //   1805: putfield 559	anrz:jdField_h_of_type_Int	I
    //   1808: aload_2
    //   1809: aload 11
    //   1811: iconst_2
    //   1812: invokevirtual 275	org/json/JSONArray:getInt	(I)I
    //   1815: putfield 562	anrz:jdField_g_of_type_Int	I
    //   1818: aload_2
    //   1819: aload 11
    //   1821: iconst_3
    //   1822: invokevirtual 275	org/json/JSONArray:getInt	(I)I
    //   1825: putfield 564	anrz:i	I
    //   1828: aload 8
    //   1830: ifnull +21 -> 1851
    //   1833: aload 8
    //   1835: invokevirtual 271	org/json/JSONArray:length	()I
    //   1838: ifle +13 -> 1851
    //   1841: aload_2
    //   1842: aload_0
    //   1843: aload 8
    //   1845: invokespecial 1028	com/tencent/mobileqq/bubble/BubbleManager:a	(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    //   1848: putfield 841	anrz:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1851: aload 9
    //   1853: aload_2
    //   1854: putfield 838	ansc:jdField_f_of_type_Anrz	Lanrz;
    //   1857: aload 10
    //   1859: ldc_w 1030
    //   1862: invokevirtual 258	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1865: ifeq +200 -> 2065
    //   1868: aload 10
    //   1870: ldc_w 1030
    //   1873: invokevirtual 538	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1876: astore_2
    //   1877: aload_2
    //   1878: ldc_w 1007
    //   1881: invokevirtual 1033	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1884: astore 8
    //   1886: aload 9
    //   1888: new 597	java/util/HashMap
    //   1891: dup
    //   1892: invokespecial 1034	java/util/HashMap:<init>	()V
    //   1895: putfield 595	ansc:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1898: aload 8
    //   1900: ifnull +66 -> 1966
    //   1903: aload 8
    //   1905: invokevirtual 271	org/json/JSONArray:length	()I
    //   1908: ifle +58 -> 1966
    //   1911: aload 9
    //   1913: new 48	java/util/ArrayList
    //   1916: dup
    //   1917: aload 8
    //   1919: invokevirtual 271	org/json/JSONArray:length	()I
    //   1922: invokespecial 519	java/util/ArrayList:<init>	(I)V
    //   1925: putfield 1036	ansc:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1928: iconst_0
    //   1929: istore 5
    //   1931: iload 5
    //   1933: aload 8
    //   1935: invokevirtual 271	org/json/JSONArray:length	()I
    //   1938: if_icmpge +28 -> 1966
    //   1941: aload 9
    //   1943: getfield 1036	ansc:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1946: aload 8
    //   1948: iload 5
    //   1950: invokevirtual 1010	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1953: invokevirtual 528	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1956: pop
    //   1957: iload 5
    //   1959: iconst_1
    //   1960: iadd
    //   1961: istore 5
    //   1963: goto -32 -> 1931
    //   1966: aload 9
    //   1968: aload 10
    //   1970: ldc_w 1038
    //   1973: iconst_m1
    //   1974: invokevirtual 1041	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1977: putfield 1042	ansc:jdField_f_of_type_Int	I
    //   1980: aload 9
    //   1982: getfield 1042	ansc:jdField_f_of_type_Int	I
    //   1985: iconst_m1
    //   1986: if_icmpne +17 -> 2003
    //   1989: aload 9
    //   1991: aload 10
    //   1993: ldc_w 1044
    //   1996: iconst_m1
    //   1997: invokevirtual 1041	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2000: putfield 1042	ansc:jdField_f_of_type_Int	I
    //   2003: aload 9
    //   2005: aload 10
    //   2007: ldc_w 1046
    //   2010: iconst_2
    //   2011: invokevirtual 1041	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2014: putfield 1047	ansc:jdField_g_of_type_Int	I
    //   2017: aload_0
    //   2018: aload 9
    //   2020: aload 10
    //   2022: aload_2
    //   2023: ldc_w 1049
    //   2026: invokespecial 1051	com/tencent/mobileqq/bubble/BubbleManager:a	(Lansc;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   2029: aload_0
    //   2030: aload 9
    //   2032: aload 10
    //   2034: aload_2
    //   2035: ldc_w 1053
    //   2038: invokespecial 1051	com/tencent/mobileqq/bubble/BubbleManager:a	(Lansc;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   2041: aload_0
    //   2042: aload 9
    //   2044: aload 10
    //   2046: aload_2
    //   2047: ldc_w 1055
    //   2050: invokespecial 1051	com/tencent/mobileqq/bubble/BubbleManager:a	(Lansc;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   2053: aload_0
    //   2054: aload 9
    //   2056: aload 10
    //   2058: aload_2
    //   2059: ldc_w 1057
    //   2062: invokespecial 1051	com/tencent/mobileqq/bubble/BubbleManager:a	(Lansc;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)V
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
    //   154	1912	9	localansc	ansc
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
  
  public ansc a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = null;
      return localObject;
    }
    ansc localansc = (ansc)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.get(Integer.valueOf(paramInt));
    if (localansc == null)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label116;
      }
      ThreadManager.post(new BubbleManager.HandleBubbleConfigRunnable(this, paramInt, paramBoolean), 5, null, true);
    }
    for (;;)
    {
      localObject = localansc;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BubbleManager", 2, "getBubbleConfig bubbleId=" + paramInt + ",autoDownload=" + paramBoolean + ",bubbleConfig=" + localansc);
      return localansc;
      label116:
      new BubbleManager.HandleBubbleConfigRunnable(this, paramInt, paramBoolean).run();
    }
  }
  
  public ansf a(int paramInt, boolean paramBoolean)
  {
    if (paramInt < 1) {
      ??? = null;
    }
    Object localObject2;
    do
    {
      return ???;
      localObject2 = (ansf)this.jdField_a_of_type_Anss.get(Integer.valueOf(paramInt));
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
        localObject2 = new BubbleManager.2(this, paramInt);
        this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(paramInt));
        ThreadManager.post((Runnable)localObject2, 8, null, true);
      }
    }
    return null;
  }
  
  public anst a(QQAppInterface paramQQAppInterface, TextView paramTextView, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject2 = (BubbleManager)paramQQAppInterface.getManager(44);
    Object localObject1 = null;
    ansf localansf = antf.a(paramInt1, paramQQAppInterface, null, null);
    if (localansf.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      paramQQAppInterface = localansf.jdField_a_of_type_ArrayOfJavaLangString;
      if ((paramQQAppInterface == null) || (localObject2 == null) || (!((BubbleManager)localObject2).a())) {
        break label621;
      }
      if (paramInt2 >= 10) {
        break label88;
      }
      paramQQAppInterface = paramQQAppInterface[0];
    }
    for (;;)
    {
      if (paramQQAppInterface != null) {
        break label109;
      }
      return null;
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (paramInt1 <= 0) {
        break;
      }
      paramQQAppInterface = ((BubbleManager)localObject2).a(paramInt1);
      break;
      label88:
      if (paramInt2 < 100) {
        paramQQAppInterface = paramQQAppInterface[1];
      } else {
        paramQQAppInterface = paramQQAppInterface[2];
      }
    }
    label109:
    localObject2 = (Bitmap)this.jdField_a_of_type_AndroidUtilLruCache.get(paramQQAppInterface);
    if ((localObject2 != null) || (new File(paramQQAppInterface).exists()))
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = BitmapFactory.decodeFile(paramQQAppInterface);
        if (localObject1 != null) {
          this.jdField_a_of_type_AndroidUtilLruCache.put(paramQQAppInterface, localObject1);
        }
      }
      else if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString))) {}
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidGraphicsRect == null)
          {
            this.jdField_a_of_type_JavaLangString = paramString;
            this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
            paramQQAppInterface = paramTextView.getText();
            paramString = new Rect(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
            localObject2 = paramTextView.getBackground();
            paramTextView.setText("1");
            paramTextView.measure(0, 0);
            int n = paramTextView.getMeasuredWidth();
            if (Build.VERSION.SDK_INT >= 16)
            {
              paramTextView.setBackground(new BitmapDrawable((Bitmap)localObject1));
              paramTextView.setPadding(0, 0, 0, 0);
              paramTextView.measure(0, 0);
              paramInt2 = paramTextView.getMeasuredWidth();
              paramInt1 = paramTextView.getMeasuredHeight();
              int i = Math.max((n - paramInt2) / 2, 0);
              int k = Math.max((n - paramInt1) / 2, 0);
              int j = Math.max(n - paramInt2 - i, 0);
              int m = Math.max(n - paramInt1 - k, 0);
              paramTextView.setPadding(j, m, i, k);
              paramTextView.measure(0, 0);
              int i1 = n - paramTextView.getMeasuredWidth();
              paramInt2 = j;
              paramInt1 = i;
              if (i1 != 0)
              {
                paramInt2 = j + i1 / 2;
                paramInt1 = i + (i1 - i1 / 2);
              }
              n -= paramTextView.getMeasuredHeight();
              j = m;
              i = k;
              if (n != 0)
              {
                j = m + n / 2;
                i = k + (n - n / 2);
              }
              this.jdField_a_of_type_AndroidGraphicsRect.set(paramInt2, j, paramInt1, i);
              paramTextView.setText(paramQQAppInterface);
              if (Build.VERSION.SDK_INT < 16) {
                break label607;
              }
              paramTextView.setBackground((Drawable)localObject2);
              paramTextView.setPadding(paramString.left, paramString.top, paramString.right, paramString.bottom);
            }
          }
          else
          {
            paramQQAppInterface = new BitmapDrawable((Bitmap)localObject1);
            if (localansf.jdField_a_of_type_Int <= 0) {
              break label616;
            }
            paramInt1 = localansf.jdField_b_of_type_Int;
            return new anst(paramQQAppInterface, paramInt1, this.jdField_a_of_type_AndroidGraphicsRect);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleManager", 1, "find no bubble unread : decode error");
            }
            return null;
          }
          paramTextView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
          continue;
          paramTextView.setBackgroundDrawable((Drawable)localObject2);
        }
        finally {}
        label607:
        continue;
        label616:
        paramInt1 = -1;
      }
    }
    label621:
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 1, "find no bubble unread");
    }
    return null;
  }
  
  public Pair<ansg, ansg> a(int paramInt, anrz paramanrz, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramanrz == null) || (TextUtils.isEmpty(paramanrz.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramanrz.jdField_b_of_type_JavaLangString))) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "parseAnimToCommonAttrs, bubbleId = " + paramInt + " autoDown = " + paramBoolean);
    }
    ansg localansg = a(paramInt, paramanrz.jdField_b_of_type_JavaLangString, paramBoolean, false);
    if (localansg == null) {
      return null;
    }
    if (paramanrz.jdField_a_of_type_JavaLangString.equals(paramanrz.jdField_c_of_type_JavaLangString)) {
      bool = true;
    }
    return new Pair(localansg, a(paramInt, paramanrz.jdField_c_of_type_JavaLangString, paramBoolean, bool));
  }
  
  public Pair<ansg, ansg> a(int paramInt, String paramString, Pair<ansg, ansg> paramPair)
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
          paramPair = (ansf)this.jdField_a_of_type_Anss.get(Integer.valueOf(paramInt));
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
  
  public Boolean a(int paramInt)
  {
    if (!new File(a(), Integer.toString(paramInt)).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "bubble dir does not exist id:" + paramInt);
      }
      return Boolean.valueOf(false);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache)
      {
        JSONObject localJSONObject = (JSONObject)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(Integer.valueOf(paramInt));
        if (localJSONObject == null) {
          break;
        }
        if (localJSONObject.optInt("full_download") == 1)
        {
          bool = true;
          return Boolean.valueOf(bool);
        }
      }
      bool = false;
    }
    boolean bool = b(paramInt);
    return Boolean.valueOf(bool);
  }
  
  public String a(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      QLog.e("BubbleManager", 1, "getConfigContent file not exist : " + paramString);
      return null;
    }
    try
    {
      paramString = bdcs.b(localFile);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("BubbleManager", 2, paramString, new Object[0]);
      return null;
    }
    catch (IOException paramString)
    {
      QLog.e("BubbleManager", 1, paramString, new Object[0]);
    }
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
        localJSONObject1.put("message", alpo.a(2131701583));
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
          break label345;
        }
        f = ((Float)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).floatValue();
        if (f != 1.0F) {
          break;
        }
        localJSONObject2.put("status", 3);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", alpo.a(2131701586));
        break label393;
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
          localJSONObject1.put("message", alpo.a(2131701584));
        }
        else
        {
          localJSONException.put("status", 2);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", alpo.a(2131701582));
          break label393;
          label345:
          localJSONException.put("status", 1);
          localJSONException.put("progress", 0);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", alpo.a(2131701581));
          continue;
        }
        label393:
        if (f == 3.0F) {
          i = 1;
        } else {
          i = 0;
        }
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
      if ((this.jdField_a_of_type_Bdwb != null) && (paramString != null)) {
        this.jdField_a_of_type_Bdwb.a(paramInt, 3, localBundle);
      }
    }
    do
    {
      return;
      if (bdee.d(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
    } while ((this.jdField_a_of_type_Bdwb == null) || (paramString == null));
    this.jdField_a_of_type_Bdwb.a(paramInt, -1, localBundle);
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
      localVasQuickUpdateManager = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(184);
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
    localVasQuickUpdateManager.downloadItem(2L, str, paramString2);
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
      localVasQuickUpdateManager = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(184);
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
      localVasQuickUpdateManager.downloadGatherItem(2L, str, paramArrayOfString, paramString);
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Float.valueOf(0.0F));
      return;
    }
  }
  
  public void a(bdwb parambdwb)
  {
    this.jdField_a_of_type_Bdwb = parambdwb;
  }
  
  public void a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    int i = bdee.a(this.jdField_a_of_type_AndroidContentContext);
    String str = "0";
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      str = VipUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    }
    azmj.b(null, "CliOper", "", "", "Bubble", paramString1, 0, (int)paramLong, String.valueOf(paramInt), str, Integer.toString(i), paramString2);
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
      ansd.a().b(paramString1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (!b()) {
      paramBoolean = true;
    }
    int i;
    Object localObject;
    if (paramBoolean != a())
    {
      if (!paramBoolean) {
        break label139;
      }
      i = 1;
      this.jdField_c_of_type_Int = i;
      localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0).edit();
      if (i != 1) {
        break label144;
      }
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).putBoolean("svip_bubble_unread_switch", bool).apply();
      localObject = (ambd)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(27);
      if (localObject != null) {
        ((ambd)localObject).a(paramBoolean);
      }
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "setBubbleUnreadShow " + paramBoolean);
      }
      return;
      label139:
      i = -1;
      break;
      label144:
      bool = false;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_c_of_type_Int == 0) {
      if (!this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0).getBoolean("svip_bubble_unread_switch", true)) {
        break label89;
      }
    }
    label89:
    for (int i = 1;; i = -1)
    {
      this.jdField_c_of_type_Int = i;
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "showBubbleUnread " + this.jdField_c_of_type_Int);
      }
      if (this.jdField_c_of_type_Int != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool3 = bdvx.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext());
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
      localObject2 = (antb)((Iterator)localObject1).next();
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((antb)localObject2).jdField_a_of_type_JavaLangString))
      {
        File localFile = new File(a(paramInt1), ((antb)localObject2).jdField_d_of_type_JavaLangString);
        int i = 0;
        for (;;)
        {
          int j = paramInt2;
          if (i < ((antb)localObject2).jdField_b_of_type_Int)
          {
            String str = localFile.getAbsolutePath() + File.separatorChar + ((antb)localObject2).jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
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
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((antb)localObject2).jdField_a_of_type_JavaLangString, localObject2);
            paramInt2 = j;
            break label65;
            if ((((ansc)localObject2).jdField_b_of_type_JavaUtilHashMap == null) || (((ansc)localObject2).jdField_b_of_type_JavaUtilHashMap.size() <= 0)) {
              break;
            }
            localObject2 = ((ansc)localObject2).jdField_b_of_type_JavaUtilHashMap.values().iterator();
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
  
  boolean a(int paramInt, boolean paramBoolean)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "createBubbleInfo, bubbleId=" + paramInt + ", autoAsyncDownload=" + paramBoolean);
    }
    Object localObject1 = a(paramInt, paramBoolean);
    if (localObject1 == null)
    {
      QLog.e("BubbleManager", 1, "createBubbleInfo, no config, bubbleId=" + paramInt);
      this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
      return false;
    }
    Object localObject4;
    int j;
    try
    {
      localObject3 = new ArrayList();
      localObject4 = new HashMap();
      if (((ansc)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
      {
        i = 0;
        if (i < ((ansc)localObject1).jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject5 = (anrz)((ansc)localObject1).jdField_a_of_type_JavaUtilArrayList.get(i);
          j = 0;
          while (j < ((anrz)localObject5).jdField_a_of_type_ArrayOfJavaLangString.length)
          {
            localObject6 = localObject5.jdField_a_of_type_ArrayOfJavaLangString[j];
            ((ArrayList)localObject3).add(localObject6);
            ((HashMap)localObject4).put(localObject6, ((anrz)localObject5).jdField_b_of_type_JavaLangString);
            j += 1;
          }
        }
      }
      localObject4 = new ansf(paramInt, "", "", "", "", ((ansc)localObject1).jdField_a_of_type_Antl, ((ansc)localObject1).jdField_b_of_type_Int, ((ansc)localObject1).jdField_c_of_type_Int, ((ansc)localObject1).jdField_d_of_type_Int, ((ansc)localObject1).jdField_a_of_type_Boolean, ((ansc)localObject1).jdField_b_of_type_Boolean, ((ansc)localObject1).jdField_a_of_type_Double, (String[])((ArrayList)localObject3).toArray(new String[0]), null, 0, 0, null, null, (HashMap)localObject4);
      boolean bool = a((ansf)localObject4);
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "createBubbleInfo, isCheckOk=" + bool + ", bubbleId=" + paramInt);
      }
      if (!bool)
      {
        if (paramBoolean) {
          b(paramInt);
        }
        this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
        return false;
      }
      if (TextUtils.isEmpty(((ansf)localObject4).jdField_a_of_type_JavaLangString)) {
        break label1014;
      }
      i = 1;
      if (TextUtils.isEmpty(((ansf)localObject4).jdField_b_of_type_JavaLangString)) {
        break label1019;
      }
      j = 1;
    }
    catch (Exception localException)
    {
      Object localObject5;
      Object localObject6;
      label393:
      QLog.e("BubbleManager", 1, "createBubbleInfo failed", localException);
      return false;
    }
    Object localObject3 = null;
    localObject5 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject5).inDensity = 320;
    ((BitmapFactory.Options)localObject5).inTargetDensity = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
    localObject1 = localObject3;
    int i = j;
    if (j != 0)
    {
      localObject1 = a(((ansf)localObject4).jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject5);
      if (localObject1 == null) {
        break label738;
      }
      localObject6 = ((Bitmap)localObject1).getNinePatchChunk();
      if ((localObject6 != null) && (NinePatch.isNinePatchChunk((byte[])localObject6)))
      {
        ((ansf)localObject4).jdField_a_of_type_AndroidGraphicsNinePatch = new NinePatch((Bitmap)localObject1, (byte[])localObject6, null);
        i = j;
        localObject1 = localObject3;
      }
    }
    else
    {
      label504:
      localObject3 = localObject1;
      j = i;
      if (i == 0) {
        break label1031;
      }
      localObject5 = a(((ansf)localObject4).jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject5);
      if (localObject5 == null) {
        break label821;
      }
      localObject3 = ((Bitmap)localObject5).getNinePatchChunk();
      if ((localObject3 == null) || (!NinePatch.isNinePatchChunk((byte[])localObject3))) {
        break label774;
      }
      ((ansf)localObject4).jdField_b_of_type_AndroidGraphicsNinePatch = new NinePatch((Bitmap)localObject5, (byte[])localObject3, null);
      break label1011;
    }
    for (;;)
    {
      label572:
      if (i == 0)
      {
        QLog.e("BubbleManager", 1, "createBubbleInfo, load nine patch failed, abort, bubbleId=" + paramInt);
        bdqk.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "individual_v2_bubble_9png_err", (String)localObject1, "norPath:" + ((ansf)localObject4).jdField_a_of_type_JavaLangString + ", animatePath:" + ((ansf)localObject4).jdField_b_of_type_JavaLangString, null, 0.0F);
        bdqj.a("individual_v2_bubble_9png_err", (String)localObject1);
        this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
        return false;
        i = 0;
        localObject1 = "nor9pngErr";
        QLog.e("BubbleManager", 1, "createBubbleInfo, normal bg chunk null or not nine patch, chunk=" + localObject6 + ", bubbleId=" + paramInt);
        break label504;
        label738:
        i = 0;
        localObject2 = "norDecodeErr";
        QLog.e("BubbleManager", 1, "createBubbleInfo, decode normal bg null, bubbleId=" + paramInt);
        break label504;
        i = 0;
        localObject2 = "9pngErr";
        QLog.e("BubbleManager", 1, "createBubbleInfo, animation bg chunk null or not nine patch, chunk=" + localObject3 + ", bubbleId=" + paramInt);
        break label1011;
        j = 0;
        localObject3 = "decodeErr";
        QLog.e("BubbleManager", 1, "createBubbleInfo, decode animation bg null, bubbleId=" + paramInt);
        break label1031;
      }
      label774:
      label821:
      this.jdField_a_of_type_Anss.put(Integer.valueOf(paramInt), localObject4);
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        bdkd.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(FontSettingActivity.class);
        if (localObject2 != null)
        {
          ((MqqHandler)localObject2).removeMessages(16711697);
          ((MqqHandler)localObject2).sendMessageDelayed(((MqqHandler)localObject2).obtainMessage(16711697), jdField_a_of_type_Long);
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
        if ((i == 0) || (j == 0)) {
          break label1025;
        }
        j = 1;
        break label393;
        label1011:
        break label572;
        label1014:
        i = 0;
        break;
        label1019:
        j = 0;
      }
      label1025:
      j = 0;
      break label393;
      label1031:
      i = j;
      Object localObject2 = localObject3;
    }
  }
  
  public boolean a(long paramLong)
  {
    return (this.jdField_a_of_type_Anss != null) && (this.jdField_a_of_type_Anss.a((int)paramLong));
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
  
  public String[] a(int paramInt)
  {
    String str1 = a(paramInt).getAbsolutePath() + File.separatorChar + "unread" + File.separatorChar + "unread1.png";
    String str2 = a(paramInt).getAbsolutePath() + File.separatorChar + "unread" + File.separatorChar + "unread2.png";
    String str3 = a(paramInt).getAbsolutePath() + File.separatorChar + "unread" + File.separatorChar + "unread3.png";
    if ((new File(str1).exists()) && (new File(str2).exists()) && (new File(str3).exists())) {
      return new String[] { str1, str2, str3 };
    }
    return null;
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
    Object localObject = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(184);
    if (localObject != null) {
      ((VasQuickUpdateManager)localObject).cancelDwonloadItem(2L, "bubble.android." + paramInt + "." + "all.zip");
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("status", 0);
      ((JSONObject)localObject).put("message", alpo.a(2131701585));
      ((JSONObject)localObject).put("id", paramInt);
      ((JSONObject)localObject).put("result", 0);
      label106:
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "stopDownload id=" + paramInt + ",status=" + 0);
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Float.valueOf(3.0F));
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      break label106;
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
              if (!paramString1.endsWith("all.zip")) {
                break;
              }
              if (paramInt1 == 0) {
                a(paramInt2);
              }
            } while ((paramString3.equals("0")) || (this.jdField_a_of_type_Bdwb == null));
            paramString1 = new Bundle();
            paramString1.putInt("srcType", 3);
            paramString1.putString("callbackId", paramString3);
            ??? = this.jdField_a_of_type_Bdwb;
            long l = paramInt2;
            if (paramInt1 == 0) {}
            for (paramInt1 = i;; paramInt1 = -1)
            {
              ???.a(l, paramInt1, paramString1);
              return;
            }
            if (!paramString1.endsWith("static.zip")) {
              break;
            }
          } while (paramInt1 != 0);
          a(paramInt2, false);
          paramString1 = a(paramInt2, a(paramInt2, "static"), false);
        } while (paramString1 == null);
        ??? = (ansf)this.jdField_a_of_type_Anss.get(Integer.valueOf(paramInt2));
      } while (??? == null);
      ???.jdField_a_of_type_JavaUtilList.add(paramString1);
      return;
    } while ((!paramString1.endsWith("other.zip")) || (paramInt1 != 0));
    a(paramInt2, false);
  }
  
  public boolean b()
  {
    return QzoneConfig.getInstance().getConfig("K_QQ_VAS", "SK_QQ_VAS_ShowSwitchPersonalUnread", 0) == 1;
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
    this.jdField_a_of_type_Anss.a();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.clear();
    jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager
 * JD-Core Version:    0.7.0.1
 */