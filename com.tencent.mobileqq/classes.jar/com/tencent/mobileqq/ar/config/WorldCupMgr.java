package com.tencent.mobileqq.ar.config;

import aaqx;
import aaqy;
import aara;
import aarb;
import aard;
import aare;
import aarf;
import aarg;
import aarh;
import aari;
import aarj;
import aark;
import android.app.Activity;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import java.io.File;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class WorldCupMgr
  implements Manager
{
  public static WorldCupConfigInfo a;
  private static WorldCupMgr jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr;
  static String c;
  aarf jdField_a_of_type_Aarf;
  public aarh a;
  public final aari a;
  public final aarj a;
  DownloadDependRes jdField_a_of_type_ComTencentMobileqqArConfigDownloadDependRes;
  MainDownAni jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni;
  MainEntryAni jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni;
  SplashPopupWin jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin;
  public final String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  aarf jdField_b_of_type_Aarf;
  public WorldCupConfigInfo b;
  String jdField_b_of_type_JavaLangString;
  
  public WorldCupMgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Aarh = null;
    this.jdField_a_of_type_JavaLangString = ("WorldCupMgr_" + AudioHelper.a());
    this.jdField_b_of_type_JavaLangString = paramAppInterface.getAccount();
    this.jdField_a_of_type_Aarf = new aarf(this.jdField_a_of_type_JavaLangString, "menuicon_fixed", 1);
    this.jdField_b_of_type_Aarf = new aarf(this.jdField_a_of_type_JavaLangString, "menuleft_fixed", 1);
    this.jdField_a_of_type_Aarj = new aarj(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Aari = new aari(this.jdField_a_of_type_JavaLangString);
  }
  
  static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 4;
    case 3: 
      return 3;
    case 4: 
      return 2;
    }
    return 2;
  }
  
  public static WorldCupMgr a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return (WorldCupMgr)paramAppInterface.getManager(279);
    }
    if (jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr == null)
      {
        jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr = new WorldCupMgr(paramAppInterface);
        jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a(paramAppInterface);
        QLog.w(jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.jdField_a_of_type_JavaLangString, 1, "getInstance, sProcessId[" + BaseApplicationImpl.sProcessId + "], processName[" + BaseApplicationImpl.processName + "]");
      }
      return jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr;
    }
    finally {}
  }
  
  public static String a()
  {
    if (c == null) {
      if (!SystemUtil.a()) {
        break label53;
      }
    }
    label53:
    for (String str = AppConstants.aK + "pddata/prd/" + "ar_worldcup" + File.separator;; str = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "ar_worldcup" + File.separator)
    {
      c = str;
      return c;
    }
  }
  
  public static String a(int paramInt)
  {
    return a() + paramInt + File.separator;
  }
  
  static final String a(int paramInt, String paramString)
  {
    return a(paramInt) + paramString + ".zip";
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 175	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 176	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: new 178	java/io/BufferedReader
    //   14: dup
    //   15: new 180	java/io/InputStreamReader
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 183	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: invokespecial 186	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   26: astore 4
    //   28: ldc 188
    //   30: astore_0
    //   31: aload_2
    //   32: astore_1
    //   33: aload 4
    //   35: invokevirtual 191	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +29 -> 69
    //   43: aload_2
    //   44: astore_1
    //   45: new 35	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   52: aload_0
    //   53: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_3
    //   57: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_3
    //   64: aload_3
    //   65: astore_0
    //   66: goto -35 -> 31
    //   69: aload_2
    //   70: astore_1
    //   71: aload 4
    //   73: invokevirtual 194	java/io/BufferedReader:close	()V
    //   76: aload_0
    //   77: astore_1
    //   78: aload_2
    //   79: ifnull +9 -> 88
    //   82: aload_2
    //   83: invokevirtual 195	java/io/FileInputStream:close	()V
    //   86: aload_0
    //   87: astore_1
    //   88: aload_1
    //   89: areturn
    //   90: astore_3
    //   91: aconst_null
    //   92: astore_2
    //   93: ldc 188
    //   95: astore_0
    //   96: aload_2
    //   97: astore_1
    //   98: aload_3
    //   99: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   102: aload_0
    //   103: astore_1
    //   104: aload_2
    //   105: ifnull -17 -> 88
    //   108: aload_2
    //   109: invokevirtual 195	java/io/FileInputStream:close	()V
    //   112: aload_0
    //   113: areturn
    //   114: astore_1
    //   115: aload_0
    //   116: areturn
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_1
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 195	java/io/FileInputStream:close	()V
    //   128: aload_0
    //   129: athrow
    //   130: astore_1
    //   131: aload_0
    //   132: areturn
    //   133: astore_1
    //   134: goto -6 -> 128
    //   137: astore_0
    //   138: goto -18 -> 120
    //   141: astore_3
    //   142: ldc 188
    //   144: astore_0
    //   145: goto -49 -> 96
    //   148: astore_3
    //   149: goto -53 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramString	String
    //   10	94	1	localObject1	Object
    //   114	1	1	localException1	Exception
    //   119	6	1	localObject2	Object
    //   130	1	1	localException2	Exception
    //   133	1	1	localException3	Exception
    //   8	101	2	localFileInputStream	java.io.FileInputStream
    //   38	27	3	str	String
    //   90	9	3	localException4	Exception
    //   141	1	3	localException5	Exception
    //   148	1	3	localException6	Exception
    //   26	46	4	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   0	9	90	java/lang/Exception
    //   108	112	114	java/lang/Exception
    //   0	9	117	finally
    //   82	86	130	java/lang/Exception
    //   124	128	133	java/lang/Exception
    //   11	28	137	finally
    //   33	39	137	finally
    //   45	64	137	finally
    //   71	76	137	finally
    //   98	102	137	finally
    //   11	28	141	java/lang/Exception
    //   33	39	148	java/lang/Exception
    //   45	64	148	java/lang/Exception
    //   71	76	148	java/lang/Exception
  }
  
  private ArrayList a()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      localArrayList2.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList2;
    }
  }
  
  /* Error */
  public static JSONObject a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 206	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 207	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: iload_3
    //   10: ifne +136 -> 146
    //   13: aload_1
    //   14: ldc 208
    //   16: invokevirtual 212	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   19: istore 4
    //   21: iload_2
    //   22: iload 4
    //   24: isub
    //   25: istore 5
    //   27: aload_0
    //   28: iconst_1
    //   29: new 35	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   36: ldc 214
    //   38: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload_2
    //   42: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: ldc 216
    //   47: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: iload 4
    //   52: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: ldc 218
    //   57: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload 5
    //   62: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc 220
    //   67: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload_3
    //   71: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: ldc 122
    //   76: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 128	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: iload_3
    //   86: ifne +71 -> 157
    //   89: aload_1
    //   90: ldc 208
    //   92: iload_2
    //   93: invokevirtual 224	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   96: pop
    //   97: aload_1
    //   98: ldc 226
    //   100: invokevirtual 230	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   103: astore 8
    //   105: aload 8
    //   107: ifnull +153 -> 260
    //   110: aload 8
    //   112: invokevirtual 236	org/json/JSONArray:length	()I
    //   115: istore 6
    //   117: iconst_0
    //   118: istore_2
    //   119: iload_2
    //   120: iload 6
    //   122: if_icmpge +138 -> 260
    //   125: aload 8
    //   127: iload_2
    //   128: invokevirtual 240	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   131: ldc 242
    //   133: invokevirtual 245	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   136: astore 9
    //   138: aload 9
    //   140: ifnonnull +28 -> 168
    //   143: goto +122 -> 265
    //   146: aload_1
    //   147: ldc 247
    //   149: invokevirtual 212	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   152: istore 4
    //   154: goto -133 -> 21
    //   157: aload_1
    //   158: ldc 247
    //   160: iload_2
    //   161: invokevirtual 224	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   164: pop
    //   165: goto -68 -> 97
    //   168: aload 9
    //   170: ldc 249
    //   172: invokevirtual 245	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   175: astore 9
    //   177: aload 9
    //   179: ifnull +86 -> 265
    //   182: aload 9
    //   184: ldc 251
    //   186: invokevirtual 230	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   189: astore 9
    //   191: aload 9
    //   193: ifnull +72 -> 265
    //   196: aload 9
    //   198: invokevirtual 236	org/json/JSONArray:length	()I
    //   201: istore 7
    //   203: iconst_0
    //   204: istore 4
    //   206: iload 4
    //   208: iload 7
    //   210: if_icmpge +55 -> 265
    //   213: aload 9
    //   215: iload 4
    //   217: invokevirtual 240	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   220: astore 10
    //   222: aload_0
    //   223: iload_2
    //   224: iload 4
    //   226: aload 10
    //   228: ldc 253
    //   230: iload 5
    //   232: iload_3
    //   233: invokestatic 256	com/tencent/mobileqq/ar/config/WorldCupMgr:a	(Ljava/lang/String;IILorg/json/JSONObject;Ljava/lang/String;II)V
    //   236: aload_0
    //   237: iload_2
    //   238: iload 4
    //   240: aload 10
    //   242: ldc_w 258
    //   245: iload 5
    //   247: iload_3
    //   248: invokestatic 256	com/tencent/mobileqq/ar/config/WorldCupMgr:a	(Ljava/lang/String;IILorg/json/JSONObject;Ljava/lang/String;II)V
    //   251: iload 4
    //   253: iconst_1
    //   254: iadd
    //   255: istore 4
    //   257: goto -51 -> 206
    //   260: aload_1
    //   261: areturn
    //   262: astore_0
    //   263: aconst_null
    //   264: areturn
    //   265: iload_2
    //   266: iconst_1
    //   267: iadd
    //   268: istore_2
    //   269: goto -150 -> 119
    //   272: astore_0
    //   273: aload_1
    //   274: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramString1	String
    //   0	275	1	paramString2	String
    //   0	275	2	paramInt1	int
    //   0	275	3	paramInt2	int
    //   19	237	4	i	int
    //   25	221	5	j	int
    //   115	8	6	k	int
    //   201	10	7	m	int
    //   103	23	8	localJSONArray	JSONArray
    //   136	78	9	localObject	Object
    //   220	21	10	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	9	262	java/lang/Exception
    //   13	21	272	java/lang/Exception
    //   27	85	272	java/lang/Exception
    //   89	97	272	java/lang/Exception
    //   97	105	272	java/lang/Exception
    //   110	117	272	java/lang/Exception
    //   125	138	272	java/lang/Exception
    //   146	154	272	java/lang/Exception
    //   157	165	272	java/lang/Exception
    //   168	177	272	java/lang/Exception
    //   182	191	272	java/lang/Exception
    //   196	203	272	java/lang/Exception
    //   213	251	272	java/lang/Exception
  }
  
  static void a(Resources paramResources, ArrayList paramArrayList, aarg paramaarg)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      aark localaark = (aark)localIterator.next();
      if (localaark.a()) {
        localArrayList.add(localaark);
      }
    }
    localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ((aark)localIterator.next()).b();
    }
    ThreadManager.post(new aaqy(localArrayList, paramResources, paramaarg, paramArrayList), 8, null, true);
  }
  
  static void a(String paramString1, int paramInt1, int paramInt2, JSONObject paramJSONObject, String paramString2, int paramInt3, int paramInt4)
  {
    if (AudioHelper.a(0) == 1) {}
    JSONArray localJSONArray1;
    JSONArray localJSONArray2;
    int k;
    for (int i = 1;; i = 0)
    {
      localObject1 = paramJSONObject.opt(paramString2);
      if (!(localObject1 instanceof JSONArray)) {
        break label378;
      }
      localJSONArray1 = (JSONArray)localObject1;
      localJSONArray2 = new JSONArray();
      if (localJSONArray1.length() <= paramInt4) {
        break label378;
      }
      k = 0;
      int j = 0;
      while (j < paramInt4)
      {
        localJSONArray2.put(localJSONArray1.opt(j));
        j += 1;
      }
    }
    Object localObject1 = localJSONArray1.opt(paramInt4);
    Object localObject2;
    String str;
    if ((localObject1 instanceof Integer))
    {
      paramInt4 = ((Integer)localObject1).intValue();
      localObject2 = String.valueOf(paramInt4);
      localObject1 = localObject2;
      if (paramInt4 <= 60) {
        break label379;
      }
      paramInt3 = paramInt4 + paramInt3;
      str = String.valueOf(paramInt3);
      localJSONArray2.put(paramInt3);
      paramInt3 = 1;
      localObject1 = localObject2;
      localObject2 = str;
    }
    for (;;)
    {
      if (i != 0) {
        QLog.w(paramString1, 1, "readJson, layer[" + paramInt1 + "], keyFrame[" + paramInt2 + "], " + paramString2 + "[" + (String)localObject1 + "->" + (String)localObject2 + "]");
      }
      if (paramInt3 != 0)
      {
        paramInt1 = 1;
        for (;;)
        {
          if (paramInt1 < localJSONArray1.length())
          {
            localJSONArray2.put(localJSONArray1.opt(paramInt1));
            paramInt1 += 1;
            continue;
            if (!(localObject1 instanceof Double)) {
              break label390;
            }
            localObject2 = (Double)localObject1;
            str = String.valueOf(localObject2);
            localObject1 = str;
            if (((Double)localObject2).doubleValue() <= 60.0D) {
              break label379;
            }
            localObject1 = Double.valueOf(((Double)localObject2).doubleValue() + paramInt3);
            localObject2 = String.valueOf(localObject1);
            localJSONArray2.put(localObject1);
            paramInt3 = 1;
            localObject1 = str;
            break;
          }
        }
        paramJSONObject.remove(paramString2);
        paramJSONObject.put(paramString2, localJSONArray2);
      }
      label378:
      return;
      label379:
      localObject2 = localObject1;
      paramInt3 = k;
      continue;
      label390:
      localObject2 = null;
      localObject1 = null;
      paramInt3 = k;
    }
  }
  
  static void a(String paramString1, String paramString2)
  {
    try
    {
      File localFile = new File(paramString2);
      boolean bool1 = localFile.exists();
      FileUtils.b(paramString2);
      localFile.delete();
      boolean bool2 = localFile.exists();
      QLog.w(paramString1, 1, "deleteDir, path[" + paramString2 + "], [" + bool1 + "->" + bool2 + "]");
      return;
    }
    catch (Exception paramString2)
    {
      QLog.w(paramString1, 1, "deleteDir, Exception", paramString2);
    }
  }
  
  private void a(String paramString, boolean paramBoolean, QQAppInterface paramQQAppInterface, int paramInt, aaqx paramaaqx)
  {
    i = 0;
    if ((this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo == null) || (paramaaqx == null))
    {
      b(paramInt, -3);
      return;
    }
    ResDownloadManager.IResDownloadListener localIResDownloadListener = a(paramQQAppInterface, paramaaqx);
    paramaaqx.jdField_b_of_type_Long = System.currentTimeMillis();
    if (this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.a(paramInt))
    {
      paramQQAppInterface = paramaaqx.jdField_a_of_type_JavaLangObject;
      if (!paramBoolean) {}
      try
      {
        paramaaqx.jdField_b_of_type_Boolean = false;
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString + "], 资源已经存在, callByPreDownload[" + paramBoolean + "], item[" + paramaaqx + "]");
        localIResDownloadListener.a(paramaaqx.jdField_a_of_type_JavaLangString, paramaaqx.jdField_b_of_type_JavaLangString, 100, a().a(paramInt), paramaaqx);
        return;
      }
      finally {}
    }
    Object localObject = paramaaqx.jdField_a_of_type_JavaLangObject;
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramaaqx.jdField_b_of_type_Boolean = false;
        if (paramaaqx.c)
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString + "], 已经在下载中, callByPreDownload[" + paramBoolean + "], item[" + paramaaqx + "]");
          return;
        }
      }
      finally {}
      try
      {
        bool = new File(a(paramInt, paramaaqx.jdField_b_of_type_JavaLangString)).exists();
        if (!bool) {
          break;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool;
          String str;
          i = 1;
          continue;
          i = 1;
        }
      }
      if (i != 0)
      {
        str = a(paramInt);
        a(this.jdField_a_of_type_JavaLangString, str);
      }
      ((PreDownloadController)paramQQAppInterface.getManager(192)).a(paramaaqx.jdField_a_of_type_JavaLangString);
      paramaaqx.c = true;
      bool = ((ResDownloadManager)paramQQAppInterface.getManager(190)).a(paramaaqx.jdField_a_of_type_JavaLangString, paramaaqx.jdField_b_of_type_JavaLangString, ".zip", true, 5, paramaaqx, paramaaqx.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerDownloadRes[" + paramString + "], 开始下载, callByPreDownload[" + paramBoolean + "], ret[" + bool + "], item[" + paramaaqx + "]");
      if (!bool) {
        localIResDownloadListener.a(paramaaqx.jdField_a_of_type_JavaLangString, paramaaqx.jdField_b_of_type_JavaLangString, -4, null, paramaaqx);
      }
    }
  }
  
  public static boolean a(String paramString1, Resources paramResources, aarf paramaarf, String paramString2)
  {
    long l1 = AudioHelper.b();
    paramString2 = paramString2 + paramaarf.jdField_a_of_type_JavaLangString + "/";
    int i = 0;
    while (i < paramaarf.jdField_a_of_type_Int)
    {
      if ((Bitmap)paramaarf.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)) == null)
      {
        Bitmap localBitmap = RedBagUtil.a(paramResources, paramString2 + i + ".png");
        if (localBitmap != null) {
          paramaarf.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localBitmap);
        }
      }
      else
      {
        i += 1;
        continue;
      }
      QLog.w(paramString1, 1, "loadBitmap[" + paramaarf.jdField_a_of_type_JavaLangString + "], 图片不存在 index[" + i + "]");
      paramaarf.jdField_a_of_type_JavaUtilHashMap.clear();
      return false;
    }
    long l2 = AudioHelper.b();
    QLog.w(paramString1, 1, "loadBitmap[" + paramaarf.jdField_a_of_type_JavaLangString + "], suc, cost[" + (l2 - l1) + "]");
    return true;
  }
  
  public static boolean a(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    paramString2 = new File(paramString2);
    if (paramString2.exists()) {
      paramString2.delete();
    }
    if (paramJSONObject == null) {
      return false;
    }
    try
    {
      paramJSONObject = paramJSONObject.toString();
      QLog.w(paramString1, 1, "readJson, json[\n\n" + paramJSONObject + "\n\n]");
      paramString2.createNewFile();
      paramString2 = new PrintStream(paramString2);
      paramString2.print(paramJSONObject);
      paramString2.flush();
      paramString2.close();
      return true;
    }
    catch (Exception paramJSONObject)
    {
      QLog.w(paramString1, 1, "readJson, Exception", paramJSONObject);
      paramJSONObject.printStackTrace();
    }
    return false;
  }
  
  static final String b(int paramInt, String paramString)
  {
    return a(paramInt) + paramString + File.separator;
  }
  
  int a(AppInterface paramAppInterface, View paramView, PopupMenuDialog paramPopupMenuDialog, int paramInt)
  {
    if (!WorldCupConfigInfo.c(a())) {
      return paramInt;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni == null) {
      this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni = new MainDownAni(this.jdField_a_of_type_JavaLangString);
    }
    return this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni.a(paramAppInterface, this, paramView, paramPopupMenuDialog, paramInt);
  }
  
  public WorldCupConfigInfo a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo == null) {}
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = WorldCupConfigInfo.a(this.jdField_b_of_type_JavaLangString, null);
        jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo;
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "getConfigInfo, Uin[" + this.jdField_b_of_type_JavaLangString + "], mConfigInfo[" + this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo + "]");
      }
      return this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo;
    }
    finally {}
  }
  
  /* Error */
  ResDownloadManager.IResDownloadListener a(QQAppInterface paramQQAppInterface, aaqx paramaaqx)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 441	aaqx:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
    //   6: ifnull +12 -> 18
    //   9: aload_2
    //   10: getfield 441	aaqx:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_2
    //   19: new 535	aarc
    //   22: dup
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: getfield 536	aaqx:jdField_a_of_type_Int	I
    //   29: invokespecial 539	aarc:<init>	(Lcom/tencent/mobileqq/ar/config/WorldCupMgr;Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   32: putfield 441	aaqx:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
    //   35: aload_2
    //   36: getfield 441	aaqx:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
    //   39: astore_1
    //   40: goto -26 -> 14
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	WorldCupMgr
    //   0	48	1	paramQQAppInterface	QQAppInterface
    //   0	48	2	paramaaqx	aaqx
    // Exception table:
    //   from	to	target	type
    //   2	14	43	finally
    //   18	40	43	finally
  }
  
  public void a()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((WorldCupMgr.DownloadListener)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((WorldCupMgr.DownloadListener)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  void a(AppInterface paramAppInterface)
  {
    GestureRecognitionUtils.b();
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigDownloadDependRes == null) {
      this.jdField_a_of_type_ComTencentMobileqqArConfigDownloadDependRes = new DownloadDependRes();
    }
    this.jdField_a_of_type_ComTencentMobileqqArConfigDownloadDependRes.a(paramAppInterface);
  }
  
  void a(AppInterface paramAppInterface, int paramInt)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      aaqx localaaqx = (aaqx)a().b.get(Integer.valueOf(paramInt));
      a("主动触发", false, (QQAppInterface)paramAppInterface, paramInt, localaaqx);
      return;
    }
    BusinessCommonConfig.a(2, paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    WorldCupConfigInfo localWorldCupConfigInfo = a();
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onGetConfig, WorldCupConfigInfo[" + localWorldCupConfigInfo + "], isDevicesSupport[" + WorldCup.a() + "]");
    }
    if (!WorldCup.a()) {}
    while ((localWorldCupConfigInfo == null) || (!localWorldCupConfigInfo.jdField_a_of_type_Boolean) || (localWorldCupConfigInfo.b.size() == 0)) {
      return;
    }
    a(paramQQAppInterface, true, 0);
  }
  
  void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView)
  {
    a("onConversatoinTabPause", paramQQAppInterface, paramActivity, paramView);
  }
  
  public void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, View paramView)
  {
    if (!WorldCup.a()) {}
    do
    {
      WorldCupConfigInfo localWorldCupConfigInfo;
      do
      {
        return;
        localWorldCupConfigInfo = a();
      } while (!localWorldCupConfigInfo.a());
      if (localWorldCupConfigInfo.a(0)) {
        break;
      }
    } while (!AudioHelper.e());
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "playPromotion, 资源未准备");
    return;
    a(paramQQAppInterface, paramFragmentActivity, paramView);
    a(paramQQAppInterface, paramFragmentActivity, paramView);
  }
  
  void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, View paramView, String paramString)
  {
    boolean bool;
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onMainFragmentTabShow, curTabTag[").append(paramString).append("], Account[").append(paramQQAppInterface.getAccount()).append("], activity[");
      if (paramFragmentActivity != null)
      {
        bool = true;
        QLog.w(str, 1, bool + "]");
      }
    }
    else
    {
      if (paramFragmentActivity != null) {
        break label90;
      }
    }
    label90:
    do
    {
      do
      {
        return;
        bool = false;
        break;
      } while ((WorldCupStaticInstance.a().jdField_a_of_type_Long != -1L) && (!WorldCup.a()));
      if (!"消息".equals(paramString)) {
        break label142;
      }
    } while (a("onMainFragmentTabShow", paramQQAppInterface, paramFragmentActivity, paramView, true));
    a(paramQQAppInterface, paramFragmentActivity, paramView);
    return;
    label142:
    a("onConversatoinTabHide", paramQQAppInterface, paramFragmentActivity, paramView);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, WorldCupConfigInfo paramWorldCupConfigInfo)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("onGetConfig, from server, configInfo[");
    if (paramWorldCupConfigInfo != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (paramWorldCupConfigInfo != null) {
        a(paramWorldCupConfigInfo);
      }
      if (!a("onGetConfig", paramQQAppInterface, null, null, false)) {
        break;
      }
      return;
    }
    a(paramString);
    a(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt)
  {
    Object localObject1 = a();
    if (localObject1 == null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, ConfigInfo为空, callByPreDownload[" + paramBoolean + "], downloadIndex[" + paramInt + "]");
      return;
    }
    Object localObject2 = ((WorldCupConfigInfo)localObject1).b.entrySet().iterator();
    int i = -1;
    aaqx localaaqx;
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      i += 1;
      localaaqx = (aaqx)((Map.Entry)((Iterator)localObject2).next()).getValue();
    } while ((localaaqx.jdField_a_of_type_Int < paramInt) || (a(localaaqx.jdField_b_of_type_Int) == 0) || (((WorldCupConfigInfo)localObject1).a(localaaqx.jdField_a_of_type_Int)));
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, expectIndex[" + paramInt + "], zipItem[" + localaaqx + "], index[" + i + "]");
      if (localaaqx == null) {
        break;
      }
      localObject1 = "md5_" + localaaqx.jdField_a_of_type_Int;
      localObject2 = new RunnableTask(paramQQAppInterface, (String)localObject1, new aare(this, paramQQAppInterface, localaaqx), 0L);
      paramQQAppInterface = (PreDownloadController)paramQQAppInterface.getManager(192);
      String str1 = localaaqx.jdField_a_of_type_JavaLangString;
      String str2 = a(localaaqx.jdField_a_of_type_Int);
      if (paramBoolean) {}
      for (paramInt = a(localaaqx.jdField_b_of_type_Int);; paramInt = 2)
      {
        paramBoolean = paramQQAppInterface.a(10074, "prd", (String)localObject1, 0, str1, str2, paramInt, 0, true, (AbsPreDownloadTask)localObject2);
        localaaqx.jdField_a_of_type_Long = System.currentTimeMillis();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onGetConfig, 申请调度, ret[" + paramBoolean + "], index[" + localaaqx.jdField_a_of_type_Int + "]");
        return;
      }
      localaaqx = null;
    }
  }
  
  public void a(WorldCupConfigInfo paramWorldCupConfigInfo)
  {
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = paramWorldCupConfigInfo;
      jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = paramWorldCupConfigInfo;
      return;
    }
    finally {}
  }
  
  public void a(WorldCupMgr.DownloadListener paramDownloadListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramDownloadListener);
      return;
    }
  }
  
  void a(String paramString)
  {
    a();
    BusinessCommonConfig.a(2, paramString);
  }
  
  void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView)
  {
    if (this.jdField_a_of_type_Aarh != null) {
      this.jdField_a_of_type_Aarh.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni != null) {
      this.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni.a(paramQQAppInterface, paramActivity, paramView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin != null) {
      this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin.a(paramString);
    }
  }
  
  boolean a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo != null;
  }
  
  boolean a(AppInterface paramAppInterface)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.businessnotify.qq.to.subprocess");
    return paramAppInterface.getApp().registerReceiver(new aara(this), localIntentFilter) != null;
  }
  
  boolean a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, View paramView)
  {
    WorldCupConfigInfo localWorldCupConfigInfo = a();
    if (WorldCupConfigInfo.d(localWorldCupConfigInfo)) {}
    while ((WorldCupConfigInfo.e(localWorldCupConfigInfo)) || (WorldCupConfigInfo.c(localWorldCupConfigInfo)) || (!WorldCupStaticInstance.a().jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni == null) {
        this.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni = new MainEntryAni();
      }
      return this.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni.a(paramQQAppInterface, this, paramFragmentActivity, paramView);
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "playMainAni加号菜单已经显示");
    return false;
  }
  
  boolean a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView)
  {
    if (UserguideActivity.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "playPromotion, sIsUserGuiderShowed为true。登陆前的图片前置引导界面 显示过");
    }
    WorldCupConfigInfo localWorldCupConfigInfo;
    do
    {
      while (this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin == null)
      {
        return false;
        if ((this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin != null) && (this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin.a()))
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "playSplash 闪屏正在播放");
          return true;
        }
        localWorldCupConfigInfo = a();
        if (WorldCupConfigInfo.b(localWorldCupConfigInfo)) {
          break;
        }
      }
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "playSplash, 清除闪屏");
      this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin.a();
      this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin = null;
      return false;
    } while (!localWorldCupConfigInfo.a(0));
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin == null) {
      this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin = new SplashPopupWin();
    }
    return this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin.a(paramQQAppInterface, paramBaseActivity, paramView);
  }
  
  boolean a(String paramString, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, View paramView, boolean paramBoolean)
  {
    if ((a()) && (WorldCupStaticInstance.a().jdField_a_of_type_Long != -1L)) {
      return false;
    }
    Object localObject2 = this.jdField_a_of_type_Aarh;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new aarh(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramQQAppInterface);
      this.jdField_a_of_type_Aarh = ((aarh)localObject1);
    }
    if (paramBoolean) {
      ((aarh)localObject1).jdField_a_of_type_Boolean = true;
    }
    if (((aarh)localObject1).a())
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "异步加载config[" + paramString + "]");
      paramFragmentActivity = new WeakReference(paramFragmentActivity);
      paramView = new WeakReference(paramView);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      a(null, (ArrayList)localObject2, new aard(this, paramFragmentActivity, paramView, paramQQAppInterface, paramString));
    }
    for (;;)
    {
      return true;
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "异步加载config[" + paramString + "], 已经在加载中");
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    BusinessCommonConfig.a(2, paramInt1, paramInt2);
  }
  
  public void b(WorldCupMgr.DownloadListener paramDownloadListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramDownloadListener);
      return;
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = WorldCupConfigInfo.a(this.jdField_b_of_type_JavaLangString, paramString);
      jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo;
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "reloadConfigInfo, Uin[" + this.jdField_b_of_type_JavaLangString + "] mConfigInfo[" + this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo + "]");
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onDestroy, ThreadID[" + Thread.currentThread().getId() + "], Tid[" + Process.myTid() + "]");
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni != null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onDestroy, 清除动画");
      this.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni.a();
      this.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin != null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onDestroy, 异步清除闪屏");
      SplashPopupWin localSplashPopupWin = this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin;
      this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin = null;
      ThreadManager.getUIHandler().post(new aarb(this, localSplashPopupWin));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigDownloadDependRes != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArConfigDownloadDependRes.a();
      this.jdField_a_of_type_ComTencentMobileqqArConfigDownloadDependRes = null;
    }
    if (this.jdField_a_of_type_Aarh != null)
    {
      this.jdField_a_of_type_Aarh.c();
      this.jdField_a_of_type_Aarh = null;
    }
    WorldCupStaticInstance.a().a();
    this.jdField_b_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = null;
    jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.WorldCupMgr
 * JD-Core Version:    0.7.0.1
 */