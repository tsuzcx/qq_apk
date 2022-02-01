package com.tencent.mobileqq.bubble;

import amtj;
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
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;
import aneg;
import apdy;
import apdz;
import apeb;
import apec;
import apee;
import apef;
import apeq;
import aper;
import apes;
import apfa;
import apfb;
import apfc;
import apfd;
import apfe;
import apfj;
import bcef;
import bgae;
import bggj;
import bggk;
import bgod;
import bgog;
import bgok;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import java.util.HashSet;
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
  protected aper a;
  bgod jdField_a_of_type_Bgod = new apeq(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  bgok jdField_a_of_type_Bgok = null;
  protected AppInterface a;
  QQLruCache<Integer, JSONObject> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2015, 100);
  public BubbleManager.LruLinkedHashMap<Integer, apeb> a;
  private String jdField_a_of_type_JavaLangString;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  Map<Integer, Float> jdField_a_of_type_JavaUtilMap;
  protected Vector<Integer> a;
  public ConcurrentHashMap<String, apdy> a;
  private int b;
  public ConcurrentHashMap<String, apfa> b;
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
    this.jdField_a_of_type_Aper = new aper(this, 2010, 50, 10);
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
  
  private apdy a(int paramInt, JSONObject paramJSONObject)
  {
    apdy localapdy = new apdy();
    localapdy.jdField_a_of_type_Int = paramInt;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseCommonAnimationConfig animation = null");
      return null;
    }
    if (paramJSONObject.has("rect"))
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("rect");
      localapdy.jdField_a_of_type_ArrayOfInt = new int[4];
      paramInt = 0;
      while (paramInt < localJSONArray.length())
      {
        localapdy.jdField_a_of_type_ArrayOfInt[paramInt] = localJSONArray.getInt(paramInt);
        paramInt += 1;
      }
    }
    if (paramJSONObject.has("cycle_count")) {
      localapdy.jdField_b_of_type_Int = paramJSONObject.getInt("cycle_count");
    }
    if (paramJSONObject.has("count")) {
      localapdy.jdField_c_of_type_Int = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("zip_name")) {
      localapdy.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zip_name");
    }
    if (paramJSONObject.has("second_zip_name")) {
      localapdy.jdField_c_of_type_JavaLangString = paramJSONObject.getString("second_zip_name");
    }
    if (paramJSONObject.has("align")) {
      localapdy.jdField_d_of_type_JavaLangString = paramJSONObject.getString("align");
    }
    if ((!paramJSONObject.has("count_stiil")) || (paramJSONObject.has("alpha"))) {
      localapdy.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("alpha");
    }
    if (paramJSONObject.has("displayChartlet")) {
      localapdy.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("displayChartlet");
    }
    if (paramJSONObject.has("mirror")) {
      localapdy.jdField_c_of_type_Boolean = paramJSONObject.getBoolean("mirror");
    }
    a(localapdy, paramJSONObject);
    localapdy.jdField_d_of_type_Int = paramJSONObject.getInt("time");
    return localapdy;
  }
  
  private apdy a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseBubbleFrameAnimationConfig object = null");
      localObject = null;
    }
    apdy localapdy;
    do
    {
      return localObject;
      localapdy = new apdy();
      localapdy.jdField_a_of_type_Int = 4;
      localapdy.jdField_e_of_type_Int = 1;
      if (paramJSONObject.has("repeat")) {
        localapdy.jdField_b_of_type_Int = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("count")) {
        localapdy.jdField_c_of_type_Int = paramJSONObject.getInt("count");
      }
      if (paramJSONObject.has("zip_name")) {
        localapdy.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zip_name");
      }
      localObject = localapdy;
    } while (!paramJSONObject.has("time"));
    localapdy.jdField_d_of_type_Int = paramJSONObject.getInt("time");
    return localapdy;
  }
  
  private apdz a(String paramString, JSONObject paramJSONObject)
  {
    apdz localapdz = new apdz();
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseEachStepAttrInPathAnim jsonObject = null");
      paramString = null;
    }
    do
    {
      return paramString;
      if (paramJSONObject.has("count")) {
        localapdz.jdField_a_of_type_Int = paramJSONObject.getInt("count");
      }
      if (paramJSONObject.has("cycle_count")) {
        localapdz.jdField_b_of_type_Int = paramJSONObject.getInt("cycle_count");
      }
      paramString = localapdz;
    } while (!paramJSONObject.has("prefix_name"));
    localapdz.jdField_a_of_type_JavaLangString = paramJSONObject.getString("prefix_name");
    return localapdz;
  }
  
  private apef a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "getAttrsByConfig, bubbleId = " + paramInt + " animName = " + paramString + " autoDown = " + paramBoolean1 + " reversion = " + paramBoolean2);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    apdy localapdy = a(paramInt, paramString);
    if (localapdy == null) {
      return null;
    }
    apef localapef = new apef();
    localapef.jdField_a_of_type_Int = localapdy.jdField_c_of_type_Int;
    localapef.jdField_c_of_type_Int = localapdy.jdField_d_of_type_Int;
    localapef.jdField_b_of_type_Int = localapdy.jdField_b_of_type_Int;
    localapef.jdField_b_of_type_Boolean = localapdy.jdField_a_of_type_Boolean;
    localapef.jdField_e_of_type_Int = localapdy.jdField_e_of_type_Int;
    localapef.jdField_a_of_type_Apdy = localapdy;
    File localFile;
    String[] arrayOfString;
    int k;
    int i;
    Object localObject;
    label225:
    label228:
    int j;
    boolean bool;
    if (localapef.jdField_b_of_type_Int <= 1)
    {
      localapef.jdField_a_of_type_Boolean = true;
      localFile = new File(a(paramInt), localapdy.jdField_a_of_type_JavaLangString);
      arrayOfString = new String[localapdy.jdField_c_of_type_Int];
      k = 0;
      i = 0;
      if (localapdy.jdField_a_of_type_AndroidUtilSparseArray != null) {
        break label422;
      }
      if (localapdy.jdField_a_of_type_Int != 4) {
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
        localapef.jdField_a_of_type_Boolean = false;
        break;
        localObject = "%04d.png";
        break label225;
        i += 1;
        break label228;
        int n = localapdy.jdField_a_of_type_AndroidUtilSparseArray.size();
        m = 0;
        k = 0;
        label438:
        j = i;
        if (m >= n) {
          break label778;
        }
        localObject = (apdz)localapdy.jdField_a_of_type_AndroidUtilSparseArray.valueAt(m);
        j = 0;
        label467:
        if (j >= ((apdz)localObject).jdField_a_of_type_Int) {
          break label775;
        }
        arrayOfString[(j + k)] = (localFile.getAbsolutePath() + File.separatorChar + ((apdz)localObject).jdField_a_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(j + 1) }));
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
        j = ((apdz)localObject).jdField_a_of_type_Int;
        m += 1;
        k += j;
        break label438;
        if (i != 0) {
          return null;
        }
        if (arrayOfString.length > 0) {}
        for (localObject = arrayOfString;; localObject = null)
        {
          localapef.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
          localapef.jdField_b_of_type_JavaLangString = paramString;
          localapef.jdField_d_of_type_Int = a(localapdy.jdField_d_of_type_JavaLangString, paramBoolean2);
          if ((localapdy.jdField_a_of_type_ArrayOfInt != null) && (localapdy.jdField_a_of_type_ArrayOfInt.length > 0)) {
            localapef.jdField_a_of_type_AndroidGraphicsRect = a(localapdy.jdField_a_of_type_ArrayOfInt[0], localapdy.jdField_a_of_type_ArrayOfInt[1], localapdy.jdField_a_of_type_ArrayOfInt[2], localapdy.jdField_a_of_type_ArrayOfInt[3]);
          }
          return localapef;
        }
      }
      label778:
      i = j;
    }
  }
  
  private apfa a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "getPendantAnimConf object == null");
      localObject = null;
    }
    apfd localapfd;
    do
    {
      return localObject;
      localapfd = new apfd();
      if (paramJSONObject.has("key")) {
        localapfd.jdField_a_of_type_JavaLangString = paramJSONObject.getString("key");
      }
      if (paramJSONObject.has("duration")) {
        localapfd.jdField_a_of_type_Long = paramJSONObject.getInt("duration");
      }
      if (paramJSONObject.has("repeat")) {
        localapfd.jdField_a_of_type_Int = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("pendent_prefix")) {
        localapfd.jdField_b_of_type_JavaLangString = paramJSONObject.getString("pendent_prefix");
      }
      if (paramJSONObject.has("img_count")) {
        localapfd.jdField_b_of_type_Int = paramJSONObject.getInt("img_count");
      }
      localObject = localapfd;
    } while (!paramJSONObject.has("play_with"));
    localapfd.e = paramJSONObject.getString("play_with");
    return localapfd;
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
  
  private ArrayList<apfa> a(JSONArray paramJSONArray)
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
  
  private void a(apdy paramapdy, JSONObject paramJSONObject)
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
            paramapdy.jdField_e_of_type_Int = 10;
          }
          if ("circle".equalsIgnoreCase((String)localObject)) {
            paramapdy.jdField_e_of_type_Int = 11;
          }
          if ("static".equalsIgnoreCase((String)localObject)) {
            paramapdy.jdField_e_of_type_Int = 1;
          }
        }
        if (paramJSONObject.has("padding"))
        {
          localObject = paramJSONObject.getJSONArray("padding");
          paramapdy.jdField_f_of_type_Int = ((JSONArray)localObject).getInt(0);
          paramapdy.jdField_h_of_type_Int = ((JSONArray)localObject).getInt(1);
          paramapdy.jdField_g_of_type_Int = ((JSONArray)localObject).getInt(2);
          paramapdy.i = ((JSONArray)localObject).getInt(3);
        }
      } while (!paramJSONObject.has("step"));
      if (paramapdy.jdField_a_of_type_AndroidUtilSparseArray == null) {
        paramapdy.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
      }
      paramJSONObject = paramJSONObject.getJSONObject("step");
      if (paramJSONObject.has("static"))
      {
        localObject = paramJSONObject.getJSONObject("static");
        paramapdy.jdField_a_of_type_AndroidUtilSparseArray.put(0, a("static", (JSONObject)localObject));
      }
      if (paramJSONObject.has("moving"))
      {
        localObject = paramJSONObject.getJSONObject("moving");
        paramapdy.jdField_a_of_type_AndroidUtilSparseArray.put(1, a("moving", (JSONObject)localObject));
      }
    } while (!paramJSONObject.has("turnback"));
    paramJSONObject = paramJSONObject.getJSONObject("turnback");
    paramapdy.jdField_a_of_type_AndroidUtilSparseArray.put(2, a("turnback", paramJSONObject));
  }
  
  private void a(apeb paramapeb, JSONObject paramJSONObject)
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
          ((apdy)localObject2).jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).getString("animation_set");
          paramapeb.jdField_e_of_type_Apdy = ((apdy)localObject2);
          if (!TextUtils.isEmpty(((apdy)localObject2).jdField_a_of_type_JavaLangString)) {
            paramapeb.jdField_a_of_type_JavaUtilHashSet.add(((apdy)localObject2).jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
    if (paramJSONObject.has("key_animations"))
    {
      localObject1 = paramJSONObject.getJSONArray("key_animations");
      localObject2 = new ArrayList();
      int i = 0;
      if (i < ((JSONArray)localObject1).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
        Object localObject3;
        if (localJSONObject.has("animation"))
        {
          localObject3 = a(localJSONObject.getString("animation"), paramJSONObject);
          if (localObject3 != null) {
            break label186;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label186:
          localObject3 = a(1, (JSONObject)localObject3);
          JSONArray localJSONArray = localJSONObject.getJSONArray("key_word");
          ((apdy)localObject3).jdField_a_of_type_ArrayOfJavaLangString = new String[localJSONArray.length()];
          int j = 0;
          while (j < localJSONArray.length())
          {
            ((apdy)localObject3).jdField_a_of_type_ArrayOfJavaLangString[j] = localJSONArray.getString(j);
            j += 1;
          }
          ((apdy)localObject3).jdField_b_of_type_JavaLangString = localJSONObject.getString("animation");
          ((ArrayList)localObject2).add(localObject3);
          if (!TextUtils.isEmpty(((apdy)localObject3).jdField_a_of_type_JavaLangString)) {
            paramapeb.jdField_a_of_type_JavaUtilHashSet.add(((apdy)localObject3).jdField_a_of_type_JavaLangString);
          }
        }
      }
      paramapeb.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
    }
  }
  
  private void a(apeb paramapeb, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString)
  {
    paramJSONObject2 = paramJSONObject2.optString(paramString);
    paramJSONObject1 = b(paramJSONObject2, paramJSONObject1);
    apfb localapfb = new apfb();
    localapfb.a(paramapeb.jdField_a_of_type_Int, paramJSONObject2, paramJSONObject1);
    paramapeb.jdField_b_of_type_JavaUtilHashMap.put(paramString, localapfb);
  }
  
  private boolean a(apee paramapee)
  {
    if (paramapee == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "checkBubbleStaticSource|bubbleInfo is null");
      }
      return false;
    }
    Object localObject1 = a(paramapee.jdField_a_of_type_Int).getAbsolutePath() + File.separatorChar + "chartlet" + File.separatorChar;
    localObject1 = (String)localObject1 + "chartlet.png";
    boolean bool = new File((String)localObject1).exists();
    if (((!bool) || (!TextUtils.isEmpty(paramapee.e))) && (!TextUtils.isEmpty(paramapee.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramapee.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramapee.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BubbleManager", 2, "checkBubbleStaticSource|bubbleId=" + paramapee.jdField_a_of_type_Int + ",chkStaticSrcAndUpdate is ok | not empty");
      }
      return true;
    }
    String str3 = a(paramapee.jdField_a_of_type_Int).getAbsolutePath() + File.separatorChar + "static" + File.separatorChar;
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
          QLog.d("BubbleManager", 2, "checkBubbleStaticSource|file is not exists,bubbleId=" + paramapee.jdField_a_of_type_Int + ",strFilePath=" + str4);
        }
        return false;
      }
    }
    paramapee.jdField_d_of_type_JavaLangString = str3;
    paramapee.jdField_a_of_type_JavaLangString = str1;
    paramapee.jdField_b_of_type_JavaLangString = str2;
    paramapee.e = ((String)localObject1);
    paramapee.jdField_a_of_type_ArrayOfJavaLangString = a(paramapee.jdField_a_of_type_Int);
    try
    {
      localObject1 = a(str3, null);
      if (localObject1 != null)
      {
        int i = ((Bitmap)localObject1).getPixel(((Bitmap)localObject1).getWidth() / 2, ((Bitmap)localObject1).getHeight() / 2);
        if (paramapee.jdField_b_of_type_Int == i)
        {
          paramapee.jdField_b_of_type_Int = Color.rgb(255 - Color.red(i), 255 - Color.green(i), 255 - Color.blue(i));
          if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, "text color:" + Integer.toHexString(i) + ",  now chage to " + Integer.toHexString(paramapee.jdField_b_of_type_Int));
          }
        }
        if (paramapee.jdField_c_of_type_Int == i)
        {
          paramapee.jdField_c_of_type_Int = Color.rgb(255 - Color.red(i), 255 - Color.green(i), 255 - Color.blue(i));
          if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, "mLinkColor :" + Integer.toHexString(i) + ",  now chage to " + Integer.toHexString(paramapee.jdField_c_of_type_Int));
          }
        }
      }
    }
    catch (OutOfMemoryError paramapee)
    {
      for (;;)
      {
        QLog.e("BubbleManager", 2, "bubble change color out of memory error!", paramapee);
      }
    }
    catch (Exception paramapee)
    {
      for (;;)
      {
        QLog.e("BubbleManager", 2, "bubble change color throws exception!", paramapee);
      }
    }
    return true;
  }
  
  private apdy b(JSONObject paramJSONObject)
  {
    int i = 0;
    apdy localapdy = new apdy();
    localapdy.jdField_a_of_type_Int = 5;
    localapdy.jdField_e_of_type_Int = 1;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "parseVoicePrintAnimationConfig object = null");
      return null;
    }
    if (paramJSONObject.has("align")) {
      localapdy.jdField_d_of_type_JavaLangString = paramJSONObject.getString("align");
    }
    if (paramJSONObject.has("repeat")) {
      localapdy.jdField_b_of_type_Int = paramJSONObject.getInt("repeat");
    }
    if (paramJSONObject.has("count")) {
      localapdy.jdField_c_of_type_Int = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("zip_name")) {
      localapdy.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zip_name");
    }
    if (paramJSONObject.has("time")) {
      localapdy.jdField_d_of_type_Int = paramJSONObject.getInt("time");
    }
    if (paramJSONObject.has("padding"))
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("padding");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        localapdy.jdField_f_of_type_Int = AIOUtils.dp2px(localJSONArray.getInt(0) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
        localapdy.jdField_h_of_type_Int = AIOUtils.dp2px(localJSONArray.getInt(1) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
        localapdy.jdField_g_of_type_Int = AIOUtils.dp2px(localJSONArray.getInt(2) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
        localapdy.i = AIOUtils.dp2px(localJSONArray.getInt(3) / 2, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
    }
    if (paramJSONObject.has("cut_array"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("cut_array");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        localapdy.jdField_c_of_type_ArrayOfInt = new int[paramJSONObject.length()];
        while (i < paramJSONObject.length())
        {
          localapdy.jdField_c_of_type_ArrayOfInt[i] = paramJSONObject.getInt(i);
          i += 1;
        }
        Arrays.sort(localapdy.jdField_c_of_type_ArrayOfInt);
      }
    }
    return localapdy;
  }
  
  private apfa b(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null)
    {
      QLog.e("BubbleManager", 1, "getPathAnimConf object == null");
      localObject = null;
    }
    apfc localapfc;
    do
    {
      return localObject;
      localapfc = new apfc();
      if (paramJSONObject.has("key")) {
        localapfc.jdField_a_of_type_JavaLangString = paramJSONObject.getString("key");
      }
      if (paramJSONObject.has("start_end"))
      {
        localObject = paramJSONObject.getJSONArray("start_end");
        localapfc.jdField_a_of_type_Float = ((float)((JSONArray)localObject).getDouble(0));
        localapfc.jdField_b_of_type_Float = ((float)((JSONArray)localObject).getDouble(1));
        localapfc.jdField_c_of_type_Float = ((float)((JSONArray)localObject).getDouble(2));
        localapfc.d = ((float)((JSONArray)localObject).getDouble(3));
      }
      if (paramJSONObject.has("bezier"))
      {
        localObject = paramJSONObject.getJSONArray("bezier");
        localapfc.jdField_e_of_type_Float = ((float)((JSONArray)localObject).getDouble(0));
        localapfc.jdField_f_of_type_Float = ((float)((JSONArray)localObject).getDouble(1));
        localapfc.jdField_g_of_type_Float = ((float)((JSONArray)localObject).getDouble(2));
        localapfc.jdField_h_of_type_Float = ((float)((JSONArray)localObject).getDouble(3));
      }
      if (paramJSONObject.has("duration")) {
        localapfc.jdField_a_of_type_Long = paramJSONObject.getInt("duration");
      }
      if (paramJSONObject.has("speed")) {
        localapfc.jdField_e_of_type_Int = paramJSONObject.getInt("speed");
      }
      if (paramJSONObject.has("img_prefix")) {
        localapfc.jdField_b_of_type_JavaLangString = paramJSONObject.getString("img_prefix");
      }
      if (paramJSONObject.has("img_reverse")) {
        localapfc.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("img_reverse");
      }
      if (paramJSONObject.has("img_alpha"))
      {
        localObject = paramJSONObject.getJSONArray("img_alpha");
        localapfc.jdField_f_of_type_Int = ((JSONArray)localObject).getInt(0);
        localapfc.jdField_g_of_type_Int = ((JSONArray)localObject).getInt(1);
      }
      if (paramJSONObject.has("repeat")) {
        localapfc.jdField_a_of_type_Int = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("img_rotate"))
      {
        localObject = paramJSONObject.getJSONArray("img_rotate");
        localapfc.jdField_h_of_type_Int = ((JSONArray)localObject).getInt(0);
        localapfc.i = ((JSONArray)localObject).getInt(1);
      }
      if (paramJSONObject.has("img_count")) {
        localapfc.jdField_b_of_type_Int = paramJSONObject.getInt("img_count");
      }
      if (paramJSONObject.has("periodical")) {
        localapfc.jdField_c_of_type_Boolean = paramJSONObject.getBoolean("periodical");
      }
      localObject = localapfc;
    } while (!paramJSONObject.has("period_length"));
    localapfc.j = paramJSONObject.getInt("period_length");
    return localapfc;
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
  
  private void b(apeb paramapeb, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject;
    Object localObject1;
    if (paramJSONObject.has("voice_animation"))
    {
      localJSONObject = paramJSONObject.getJSONObject("voice_animation");
      if (localJSONObject.has("animation"))
      {
        localObject1 = a(localJSONObject.getString("animation"), paramJSONObject);
        if (localObject1 != null)
        {
          localObject1 = a(0, (JSONObject)localObject1);
          ((apdy)localObject1).jdField_b_of_type_JavaLangString = localJSONObject.getString("animation");
          paramapeb.jdField_a_of_type_Apdy = ((apdy)localObject1);
          if (!TextUtils.isEmpty(((apdy)localObject1).jdField_a_of_type_JavaLangString)) {
            paramapeb.jdField_a_of_type_JavaUtilHashSet.add(((apdy)localObject1).jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
    if (paramJSONObject.has("height_animation"))
    {
      localJSONObject = paramJSONObject.getJSONObject("height_animation");
      if (localJSONObject.has("animation"))
      {
        Object localObject2 = a(localJSONObject.getString("animation"), paramJSONObject);
        if (localObject2 != null)
        {
          localObject1 = a(2, (JSONObject)localObject2);
          localObject2 = ((JSONObject)localObject2).getJSONArray("height_interval");
          ((apdy)localObject1).jdField_b_of_type_ArrayOfInt = new int[] { ((JSONArray)localObject2).getInt(0), ((JSONArray)localObject2).getInt(1) };
          ((apdy)localObject1).jdField_b_of_type_JavaLangString = localJSONObject.getString("animation");
          paramapeb.jdField_b_of_type_Apdy = ((apdy)localObject1);
          if (!TextUtils.isEmpty(((apdy)localObject1).jdField_a_of_type_JavaLangString)) {
            paramapeb.jdField_a_of_type_JavaUtilHashSet.add(((apdy)localObject1).jdField_a_of_type_JavaLangString);
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
            double d = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay().getWidth();
            paramJSONObject.j = ((int)(i / 100.0D * d));
          }
          paramapeb.jdField_c_of_type_Apdy = paramJSONObject;
          if (!TextUtils.isEmpty(paramJSONObject.jdField_a_of_type_JavaLangString)) {
            paramapeb.jdField_a_of_type_JavaUtilHashSet.add(paramJSONObject.jdField_a_of_type_JavaLangString);
          }
        }
      }
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
      ??? = FileUtils.readFileToStringEx((File)???, -1);
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
  
  private void c(apeb paramapeb, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("pendant_animation"))
    {
      Object localObject = paramJSONObject.getJSONObject("pendant_animation");
      apdy localapdy = new apdy();
      if (((JSONObject)localObject).has("pendant_id")) {
        localapdy.k = ((JSONObject)localObject).getInt("pendant_id");
      }
      if (((JSONObject)localObject).has("animation_set"))
      {
        localObject = ((JSONObject)localObject).getString("animation_set");
        localapdy.jdField_b_of_type_JavaLangString = ((String)localObject);
        localObject = b((String)localObject, paramJSONObject);
        if (localObject != null)
        {
          localapdy.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("zip_name");
          paramJSONObject = ((JSONObject)localObject).getJSONArray("anim_sets");
          if (((JSONObject)localObject).has("padding"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("padding");
            if ((localObject != null) && (((JSONArray)localObject).length() > 0))
            {
              localapdy.jdField_f_of_type_Int = ((JSONArray)localObject).getInt(0);
              localapdy.jdField_h_of_type_Int = ((JSONArray)localObject).getInt(1);
              localapdy.jdField_g_of_type_Int = ((JSONArray)localObject).getInt(2);
              localapdy.i = ((JSONArray)localObject).getInt(3);
            }
          }
          if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
            localapdy.jdField_a_of_type_JavaUtilArrayList = a(paramJSONObject);
          }
          paramapeb.jdField_f_of_type_Apdy = localapdy;
        }
      }
    }
  }
  
  private void d(apeb paramapeb, JSONObject paramJSONObject)
  {
    String str3;
    String str1;
    if (paramJSONObject.has("color"))
    {
      str3 = paramJSONObject.getString("color");
      str1 = str3;
      if (str3.startsWith("0x")) {
        str1 = str3.substring(2);
      }
    }
    do
    {
      do
      {
        try
        {
          paramapeb.jdField_b_of_type_Int = Color.parseColor("#" + str1);
          if (paramJSONObject.has("link_color"))
          {
            str3 = paramJSONObject.getString("link_color");
            str1 = str3;
            if (str3.startsWith("0x")) {
              str1 = str3.substring(2);
            }
          }
        }
        catch (Exception localException2)
        {
          try
          {
            paramapeb.jdField_c_of_type_Int = Color.parseColor("#" + str1);
            if (paramJSONObject.has("shadow_blur_color"))
            {
              paramapeb.jdField_a_of_type_Boolean = true;
              str1 = paramJSONObject.getString("shadow_blur_color");
              paramJSONObject = str1;
              if (str1.startsWith("0x")) {
                paramJSONObject = str1.substring(2);
              }
            }
          }
          catch (Exception localException2)
          {
            try
            {
              do
              {
                for (;;)
                {
                  paramapeb.jdField_d_of_type_Int = Color.parseColor("#" + paramJSONObject);
                  return;
                  localException1 = localException1;
                  if (QLog.isColorLevel()) {
                    QLog.d("BubbleManager", 2, "color invalid");
                  }
                }
                localException2 = localException2;
              } while (!QLog.isColorLevel());
              QLog.d("BubbleManager", 2, "linkcolor invalid");
            }
            catch (Exception paramapeb)
            {
              while (!QLog.isColorLevel()) {}
              QLog.d("BubbleManager", 2, "strokeColor invalid");
              return;
            }
          }
        }
      } while (!paramJSONObject.has("shadow_color"));
      paramapeb.jdField_b_of_type_Boolean = true;
      String str2 = paramJSONObject.getString("shadow_color");
      paramJSONObject = str2;
      if (str2.startsWith("0x")) {
        paramJSONObject = str2.substring(2);
      }
      try
      {
        paramapeb.jdField_d_of_type_Int = Color.parseColor("#" + paramJSONObject);
        return;
      }
      catch (Exception paramapeb) {}
    } while (!QLog.isColorLevel());
    QLog.d("BubbleManager", 2, "strokeColor invalid");
  }
  
  private void e(apeb paramapeb, JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject.has("loopList")) {}
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("loopList");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        paramapeb.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        paramapeb.jdField_e_of_type_Int = 0;
        while (i < paramJSONObject.length())
        {
          paramapeb.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(paramJSONObject.getInt(i)));
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("BubbleManager", 2, "bubble loopList: " + TextUtils.join(",", paramapeb.jdField_b_of_type_JavaUtilArrayList));
        }
      }
      return;
    }
    catch (Exception paramapeb)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BubbleManager", 2, "", paramapeb);
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
  
  public apdy a(int paramInt1, int paramInt2)
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
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(((apdy)localObject).jdField_b_of_type_JavaLangString))
        {
          return localObject;
          localObject = ((apeb)localObject).jdField_c_of_type_Apdy;
          apdy.a((apdy)localObject);
          continue;
          localObject = ((apeb)localObject).jdField_b_of_type_Apdy;
          continue;
          localObject = ((apeb)localObject).jdField_f_of_type_Apdy;
        }
        else if ((localObject != null) && (((apdy)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (((apdy)localObject).jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          Iterator localIterator = ((apdy)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
          paramInt2 = 1;
          if (!localIterator.hasNext()) {
            break label315;
          }
          apfa localapfa = (apfa)localIterator.next();
          File localFile = new File(a(paramInt1), ((apdy)localObject).jdField_a_of_type_JavaLangString);
          i = 0;
          label188:
          if (i >= localapfa.jdField_b_of_type_Int) {
            break label350;
          }
          String str = localFile.getAbsolutePath() + File.separatorChar + localapfa.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
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
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((apdy)localObject).jdField_b_of_type_JavaLangString, localObject);
      return localObject;
    }
  }
  
  apdy a(int paramInt, String paramString)
  {
    Object localObject = a(paramInt, true);
    if (localObject == null)
    {
      QLog.e("BubbleManager", 1, "findAnimConfig bubbleId = " + paramInt + " bubbleConfig = null");
      return null;
    }
    if ((((apeb)localObject).jdField_a_of_type_Apdy != null) && (((apeb)localObject).jdField_a_of_type_Apdy.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((apeb)localObject).jdField_a_of_type_Apdy;
    }
    if ((((apeb)localObject).jdField_b_of_type_Apdy != null) && (((apeb)localObject).jdField_b_of_type_Apdy.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((apeb)localObject).jdField_b_of_type_Apdy;
    }
    if ((((apeb)localObject).jdField_c_of_type_Apdy != null) && (((apeb)localObject).jdField_c_of_type_Apdy.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((apeb)localObject).jdField_c_of_type_Apdy;
    }
    if ((((apeb)localObject).jdField_d_of_type_Apdy != null) && (((apeb)localObject).jdField_d_of_type_Apdy.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((apeb)localObject).jdField_d_of_type_Apdy;
    }
    if ((((apeb)localObject).jdField_e_of_type_Apdy != null) && (((apeb)localObject).jdField_e_of_type_Apdy.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((apeb)localObject).jdField_e_of_type_Apdy;
    }
    if (((apeb)localObject).jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = ((apeb)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        apdy localapdy = (apdy)((Iterator)localObject).next();
        if (localapdy.jdField_b_of_type_JavaLangString.equals(paramString)) {
          return localapdy;
        }
      }
    }
    return null;
  }
  
  apeb a(int paramInt, String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "createBubbleConfig, bubbleId = " + paramInt + " path = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = a(paramString);
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BubbleManager", 2, "content:" + paramString);
        }
        if ((Build.VERSION.SDK_INT <= 10) && (paramString.length() > 1) && (paramString.charAt(0) == 65279))
        {
          paramString = paramString.substring(1);
          apeb localapeb = new apeb(paramInt);
          paramString = new JSONObject(paramString);
          localapeb.jdField_a_of_type_JavaLangString = paramString.getString("name");
          e(localapeb, paramString);
          d(localapeb, paramString);
          localapeb.jdField_a_of_type_Double = paramString.optDouble("color_threshold_factor", 1.0D);
          Object localObject1;
          if (paramString.has("zoom_point"))
          {
            localObject1 = paramString.getJSONArray("zoom_point");
            localapeb.jdField_a_of_type_ArrayOfInt = new int[] { ((JSONArray)localObject1).getInt(0), ((JSONArray)localObject1).getInt(1) };
          }
          b(localapeb, paramString);
          Object localObject2;
          if (paramString.has("bubbleframe_animation"))
          {
            localObject1 = paramString.getJSONObject("bubbleframe_animation");
            if (((JSONObject)localObject1).has("animation_set"))
            {
              localObject2 = b(((JSONObject)localObject1).getString("animation_set"), paramString);
              if (localObject2 != null)
              {
                localObject2 = a((JSONObject)localObject2);
                ((apdy)localObject2).jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).getString("animation_set");
                localapeb.jdField_d_of_type_Apdy = ((apdy)localObject2);
                if (!TextUtils.isEmpty(((apdy)localObject2).jdField_a_of_type_JavaLangString)) {
                  localapeb.jdField_a_of_type_JavaUtilHashSet.add(((apdy)localObject2).jdField_a_of_type_JavaLangString);
                }
              }
            }
          }
          a(localapeb, paramString);
          localapeb.jdField_a_of_type_JavaUtilHashMap = apfj.a(paramInt, paramString);
          c(localapeb, paramString);
          if (paramString.has("interaction_animation"))
          {
            localObject1 = paramString.getJSONObject("interaction_animation");
            localObject2 = ((JSONObject)localObject1).optJSONArray("key_word");
            localapeb.jdField_b_of_type_JavaUtilHashMap = new HashMap();
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              localapeb.jdField_c_of_type_JavaUtilArrayList = new ArrayList(((JSONArray)localObject2).length());
              if (i < ((JSONArray)localObject2).length())
              {
                localapeb.jdField_c_of_type_JavaUtilArrayList.add(((JSONArray)localObject2).getString(i));
                i += 1;
                continue;
              }
            }
            localapeb.jdField_f_of_type_Int = paramString.optInt("package_id", -1);
            if (localapeb.jdField_f_of_type_Int == -1) {
              localapeb.jdField_f_of_type_Int = paramString.optInt("groupId", -1);
            }
            localapeb.jdField_g_of_type_Int = paramString.optInt("groupType", 2);
            a(localapeb, paramString, (JSONObject)localObject1, "animation_start");
            a(localapeb, paramString, (JSONObject)localObject1, "animation_running");
            a(localapeb, paramString, (JSONObject)localObject1, "animation_end");
            a(localapeb, paramString, (JSONObject)localObject1, "passive_animation");
          }
          return localapeb;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("BubbleManager", 1, "bubble " + paramInt + " json file invalidate exception=", paramString);
        return null;
      }
      catch (Exception paramString)
      {
        QLog.e("BubbleManager", 1, "null pointer or index out of range or other error", paramString);
        return null;
      }
    }
  }
  
  public apeb a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = null;
      return localObject;
    }
    apeb localapeb = (apeb)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.get(Integer.valueOf(paramInt));
    if (localapeb == null)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label116;
      }
      ThreadManager.post(new BubbleManager.HandleBubbleConfigRunnable(this, paramInt, paramBoolean), 5, null, true);
    }
    for (;;)
    {
      localObject = localapeb;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BubbleManager", 2, "getBubbleConfig bubbleId=" + paramInt + ",autoDownload=" + paramBoolean + ",bubbleConfig=" + localapeb);
      return localapeb;
      label116:
      new BubbleManager.HandleBubbleConfigRunnable(this, paramInt, paramBoolean).run();
    }
  }
  
  public apee a(int paramInt, boolean paramBoolean)
  {
    if (paramInt < 1) {
      ??? = null;
    }
    Object localObject2;
    do
    {
      return ???;
      localObject2 = (apee)this.jdField_a_of_type_Aper.get(Integer.valueOf(paramInt));
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
  
  public apes a(QQAppInterface paramQQAppInterface, TextView paramTextView, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject2 = (BubbleManager)paramQQAppInterface.getManager(44);
    Object localObject1 = null;
    apee localapee = apfe.a(paramInt1, paramQQAppInterface, null, null);
    if (localapee.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      paramQQAppInterface = localapee.jdField_a_of_type_ArrayOfJavaLangString;
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
            if (localapee.jdField_a_of_type_Int <= 0) {
              break label616;
            }
            paramInt1 = localapee.jdField_b_of_type_Int;
            return new apes(paramQQAppInterface, paramInt1, this.jdField_a_of_type_AndroidGraphicsRect);
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
  
  public Pair<apef, apef> a(int paramInt, apdy paramapdy, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramapdy == null) || (TextUtils.isEmpty(paramapdy.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramapdy.jdField_b_of_type_JavaLangString))) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "parseAnimToCommonAttrs, bubbleId = " + paramInt + " autoDown = " + paramBoolean);
    }
    apef localapef = a(paramInt, paramapdy.jdField_b_of_type_JavaLangString, paramBoolean, false);
    if (localapef == null) {
      return null;
    }
    if (paramapdy.jdField_a_of_type_JavaLangString.equals(paramapdy.jdField_c_of_type_JavaLangString)) {
      bool = true;
    }
    return new Pair(localapef, a(paramInt, paramapdy.jdField_c_of_type_JavaLangString, paramBoolean, bool));
  }
  
  public Pair<apef, apef> a(int paramInt, String paramString, Pair<apef, apef> paramPair)
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
          paramPair = (apee)this.jdField_a_of_type_Aper.get(Integer.valueOf(paramInt));
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
      paramString = FileUtils.readFileToString(localFile);
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
        localJSONObject1.put("message", amtj.a(2131700361));
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
        localJSONObject1.put("message", amtj.a(2131700364));
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
          localJSONObject1.put("message", amtj.a(2131700362));
        }
        else
        {
          localJSONException.put("status", 2);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", amtj.a(2131700360));
          break label393;
          label345:
          localJSONException.put("status", 1);
          localJSONException.put("progress", 0);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", amtj.a(2131700359));
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
      if ((this.jdField_a_of_type_Bgok != null) && (paramString != null)) {
        this.jdField_a_of_type_Bgok.a(paramInt, 3, localBundle);
      }
    }
    do
    {
      return;
      if (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
    } while ((this.jdField_a_of_type_Bgok == null) || (paramString == null));
    this.jdField_a_of_type_Bgok.a(paramInt, -1, localBundle);
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
  
  public void a(bgok parambgok)
  {
    this.jdField_a_of_type_Bgok = parambgok;
  }
  
  public void a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    int i = NetworkUtil.getSystemNetwork(this.jdField_a_of_type_AndroidContentContext);
    String str = "0";
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      str = VipUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    }
    bcef.b(null, "CliOper", "", "", "Bubble", paramString1, 0, (int)paramLong, String.valueOf(paramInt), str, Integer.toString(i), paramString2);
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
      apec.a().b(paramString1);
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
      localObject = (aneg)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(27);
      if (localObject != null) {
        ((aneg)localObject).a(paramBoolean);
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
    boolean bool3 = bgog.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext());
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
      localObject2 = (apfa)((Iterator)localObject1).next();
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((apfa)localObject2).jdField_a_of_type_JavaLangString))
      {
        File localFile = new File(a(paramInt1), ((apfa)localObject2).jdField_d_of_type_JavaLangString);
        int i = 0;
        for (;;)
        {
          int j = paramInt2;
          if (i < ((apfa)localObject2).jdField_b_of_type_Int)
          {
            String str = localFile.getAbsolutePath() + File.separatorChar + ((apfa)localObject2).jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
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
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((apfa)localObject2).jdField_a_of_type_JavaLangString, localObject2);
            paramInt2 = j;
            break label65;
            if ((((apeb)localObject2).jdField_b_of_type_JavaUtilHashMap == null) || (((apeb)localObject2).jdField_b_of_type_JavaUtilHashMap.size() <= 0)) {
              break;
            }
            localObject2 = ((apeb)localObject2).jdField_b_of_type_JavaUtilHashMap.values().iterator();
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
      if (((apeb)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
      {
        i = 0;
        if (i < ((apeb)localObject1).jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject5 = (apdy)((apeb)localObject1).jdField_a_of_type_JavaUtilArrayList.get(i);
          j = 0;
          while (j < ((apdy)localObject5).jdField_a_of_type_ArrayOfJavaLangString.length)
          {
            localObject6 = localObject5.jdField_a_of_type_ArrayOfJavaLangString[j];
            ((ArrayList)localObject3).add(localObject6);
            ((HashMap)localObject4).put(localObject6, ((apdy)localObject5).jdField_b_of_type_JavaLangString);
            j += 1;
          }
        }
      }
      localObject4 = new apee(paramInt, "", "", "", "", ((apeb)localObject1).jdField_a_of_type_Apfk, ((apeb)localObject1).jdField_b_of_type_Int, ((apeb)localObject1).jdField_c_of_type_Int, ((apeb)localObject1).jdField_d_of_type_Int, ((apeb)localObject1).jdField_a_of_type_Boolean, ((apeb)localObject1).jdField_b_of_type_Boolean, ((apeb)localObject1).jdField_a_of_type_Double, (String[])((ArrayList)localObject3).toArray(new String[0]), null, 0, 0, null, null, (HashMap)localObject4);
      boolean bool = a((apee)localObject4);
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
      if (TextUtils.isEmpty(((apee)localObject4).jdField_a_of_type_JavaLangString)) {
        break label1014;
      }
      i = 1;
      if (TextUtils.isEmpty(((apee)localObject4).jdField_b_of_type_JavaLangString)) {
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
      localObject1 = a(((apee)localObject4).jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject5);
      if (localObject1 == null) {
        break label738;
      }
      localObject6 = ((Bitmap)localObject1).getNinePatchChunk();
      if ((localObject6 != null) && (NinePatch.isNinePatchChunk((byte[])localObject6)))
      {
        ((apee)localObject4).jdField_a_of_type_AndroidGraphicsNinePatch = new NinePatch((Bitmap)localObject1, (byte[])localObject6, null);
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
      localObject5 = a(((apee)localObject4).jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject5);
      if (localObject5 == null) {
        break label821;
      }
      localObject3 = ((Bitmap)localObject5).getNinePatchChunk();
      if ((localObject3 == null) || (!NinePatch.isNinePatchChunk((byte[])localObject3))) {
        break label774;
      }
      ((apee)localObject4).jdField_b_of_type_AndroidGraphicsNinePatch = new NinePatch((Bitmap)localObject5, (byte[])localObject3, null);
      break label1011;
    }
    for (;;)
    {
      label572:
      if (i == 0)
      {
        QLog.e("BubbleManager", 1, "createBubbleInfo, load nine patch failed, abort, bubbleId=" + paramInt);
        bggk.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "individual_v2_bubble_9png_err", (String)localObject1, "norPath:" + ((apee)localObject4).jdField_a_of_type_JavaLangString + ", animatePath:" + ((apee)localObject4).jdField_b_of_type_JavaLangString, null, 0.0F);
        bggj.a("individual_v2_bubble_9png_err", (String)localObject1);
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
      this.jdField_a_of_type_Aper.put(Integer.valueOf(paramInt), localObject4);
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        bgae.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
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
    return (this.jdField_a_of_type_Aper != null) && (this.jdField_a_of_type_Aper.a((int)paramLong));
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
      ((JSONObject)localObject).put("message", amtj.a(2131700363));
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
            } while ((paramString3.equals("0")) || (this.jdField_a_of_type_Bgok == null));
            paramString1 = new Bundle();
            paramString1.putInt("srcType", 3);
            paramString1.putString("callbackId", paramString3);
            ??? = this.jdField_a_of_type_Bgok;
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
        ??? = (apee)this.jdField_a_of_type_Aper.get(Integer.valueOf(paramInt2));
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
    this.jdField_a_of_type_Aper.a();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.clear();
    jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager
 * JD-Core Version:    0.7.0.1
 */