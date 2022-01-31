package com.tencent.mobileqq.ar.config;

import aake;
import aakf;
import aakh;
import aakj;
import aakk;
import aakl;
import aakm;
import aakn;
import aako;
import aakp;
import aakq;
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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils;
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
import org.json.JSONArray;
import org.json.JSONObject;

public class WorldCupMgr
  implements Manager
{
  public static WorldCupConfigInfo a;
  private static WorldCupMgr jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr;
  static String jdField_b_of_type_JavaLangString;
  aakl jdField_a_of_type_Aakl = new aakl("menuicon_fixed", 1);
  public aakn a;
  public aako a;
  public aakp a;
  DownloadDependRes jdField_a_of_type_ComTencentMobileqqArConfigDownloadDependRes;
  MainDownAni jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni;
  MainEntryAni jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni;
  SplashPopupWin jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin;
  String jdField_a_of_type_JavaLangString;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  aakl jdField_b_of_type_Aakl = new aakl("menuleft_fixed", 1);
  
  public WorldCupMgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Aakn = null;
    this.jdField_a_of_type_Aakp = new aakp();
    this.jdField_a_of_type_Aako = new aako();
    this.jdField_a_of_type_JavaLangString = paramAppInterface.getAccount();
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
        QLog.w("WorldCupMgr", 1, "getInstance, sProcessId[" + BaseApplicationImpl.sProcessId + "], processName[" + BaseApplicationImpl.processName + "]");
      }
      return jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr;
    }
    finally {}
  }
  
  public static String a()
  {
    if (jdField_b_of_type_JavaLangString == null) {
      if (!SystemUtil.a()) {
        break label53;
      }
    }
    label53:
    for (String str = AppConstants.aJ + "pddata/prd/" + "ar_worldcup" + File.separator;; str = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "ar_worldcup" + File.separator)
    {
      jdField_b_of_type_JavaLangString = str;
      return jdField_b_of_type_JavaLangString;
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
    //   0: new 162	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: new 167	java/io/BufferedReader
    //   14: dup
    //   15: new 169	java/io/InputStreamReader
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 172	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: invokespecial 175	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   26: astore 4
    //   28: ldc 177
    //   30: astore_0
    //   31: aload_2
    //   32: astore_1
    //   33: aload 4
    //   35: invokevirtual 180	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +29 -> 69
    //   43: aload_2
    //   44: astore_1
    //   45: new 83	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   52: aload_0
    //   53: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_3
    //   57: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_3
    //   64: aload_3
    //   65: astore_0
    //   66: goto -35 -> 31
    //   69: aload_2
    //   70: astore_1
    //   71: aload 4
    //   73: invokevirtual 183	java/io/BufferedReader:close	()V
    //   76: aload_0
    //   77: astore_1
    //   78: aload_2
    //   79: ifnull +9 -> 88
    //   82: aload_2
    //   83: invokevirtual 184	java/io/FileInputStream:close	()V
    //   86: aload_0
    //   87: astore_1
    //   88: aload_1
    //   89: areturn
    //   90: astore_3
    //   91: aconst_null
    //   92: astore_2
    //   93: ldc 177
    //   95: astore_0
    //   96: aload_2
    //   97: astore_1
    //   98: aload_3
    //   99: invokevirtual 187	java/lang/Exception:printStackTrace	()V
    //   102: aload_0
    //   103: astore_1
    //   104: aload_2
    //   105: ifnull -17 -> 88
    //   108: aload_2
    //   109: invokevirtual 184	java/io/FileInputStream:close	()V
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
    //   125: invokevirtual 184	java/io/FileInputStream:close	()V
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
    //   142: ldc 177
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
  public static JSONObject a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 195	org/json/JSONObject
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 196	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: iload_2
    //   10: ifne +134 -> 144
    //   13: aload_0
    //   14: ldc 197
    //   16: invokevirtual 201	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   19: istore_3
    //   20: iload_1
    //   21: iload_3
    //   22: isub
    //   23: istore 4
    //   25: ldc 81
    //   27: iconst_1
    //   28: new 83	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   35: ldc 203
    //   37: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_1
    //   41: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: ldc 205
    //   46: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_3
    //   50: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc 207
    //   55: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload 4
    //   60: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: ldc 209
    //   65: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_2
    //   69: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc 106
    //   74: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 115	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: iload_2
    //   84: ifne +70 -> 154
    //   87: aload_0
    //   88: ldc 197
    //   90: iload_1
    //   91: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   94: pop
    //   95: aload_0
    //   96: ldc 215
    //   98: invokevirtual 219	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   101: astore 7
    //   103: aload 7
    //   105: ifnull +142 -> 247
    //   108: aload 7
    //   110: invokevirtual 225	org/json/JSONArray:length	()I
    //   113: istore 5
    //   115: iconst_0
    //   116: istore_1
    //   117: iload_1
    //   118: iload 5
    //   120: if_icmpge +127 -> 247
    //   123: aload 7
    //   125: iload_1
    //   126: invokevirtual 229	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   129: ldc 231
    //   131: invokevirtual 234	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   134: astore 8
    //   136: aload 8
    //   138: ifnonnull +27 -> 165
    //   141: goto +111 -> 252
    //   144: aload_0
    //   145: ldc 236
    //   147: invokevirtual 201	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   150: istore_3
    //   151: goto -131 -> 20
    //   154: aload_0
    //   155: ldc 236
    //   157: iload_1
    //   158: invokevirtual 213	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   161: pop
    //   162: goto -67 -> 95
    //   165: aload 8
    //   167: ldc 238
    //   169: invokevirtual 234	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   172: astore 8
    //   174: aload 8
    //   176: ifnull +76 -> 252
    //   179: aload 8
    //   181: ldc 240
    //   183: invokevirtual 219	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   186: astore 8
    //   188: aload 8
    //   190: ifnull +62 -> 252
    //   193: aload 8
    //   195: invokevirtual 225	org/json/JSONArray:length	()I
    //   198: istore 6
    //   200: iconst_0
    //   201: istore_3
    //   202: iload_3
    //   203: iload 6
    //   205: if_icmpge +47 -> 252
    //   208: aload 8
    //   210: iload_3
    //   211: invokevirtual 229	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   214: astore 9
    //   216: iload_1
    //   217: iload_3
    //   218: aload 9
    //   220: ldc 242
    //   222: iload 4
    //   224: iload_2
    //   225: invokestatic 245	com/tencent/mobileqq/ar/config/WorldCupMgr:a	(IILorg/json/JSONObject;Ljava/lang/String;II)V
    //   228: iload_1
    //   229: iload_3
    //   230: aload 9
    //   232: ldc 247
    //   234: iload 4
    //   236: iload_2
    //   237: invokestatic 245	com/tencent/mobileqq/ar/config/WorldCupMgr:a	(IILorg/json/JSONObject;Ljava/lang/String;II)V
    //   240: iload_3
    //   241: iconst_1
    //   242: iadd
    //   243: istore_3
    //   244: goto -42 -> 202
    //   247: aload_0
    //   248: areturn
    //   249: astore_0
    //   250: aconst_null
    //   251: areturn
    //   252: iload_1
    //   253: iconst_1
    //   254: iadd
    //   255: istore_1
    //   256: goto -139 -> 117
    //   259: astore 7
    //   261: aload_0
    //   262: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramString	String
    //   0	263	1	paramInt1	int
    //   0	263	2	paramInt2	int
    //   19	225	3	i	int
    //   23	212	4	j	int
    //   113	8	5	k	int
    //   198	8	6	m	int
    //   101	23	7	localJSONArray	JSONArray
    //   259	1	7	localException	Exception
    //   134	75	8	localObject	Object
    //   214	17	9	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	9	249	java/lang/Exception
    //   13	20	259	java/lang/Exception
    //   25	83	259	java/lang/Exception
    //   87	95	259	java/lang/Exception
    //   95	103	259	java/lang/Exception
    //   108	115	259	java/lang/Exception
    //   123	136	259	java/lang/Exception
    //   144	151	259	java/lang/Exception
    //   154	162	259	java/lang/Exception
    //   165	174	259	java/lang/Exception
    //   179	188	259	java/lang/Exception
    //   193	200	259	java/lang/Exception
    //   208	240	259	java/lang/Exception
  }
  
  static void a(int paramInt1, int paramInt2, JSONObject paramJSONObject, String paramString, int paramInt3, int paramInt4)
  {
    if (AudioHelper.a(0) == 1) {}
    JSONArray localJSONArray1;
    JSONArray localJSONArray2;
    int k;
    for (int i = 1;; i = 0)
    {
      localObject1 = paramJSONObject.opt(paramString);
      if (!(localObject1 instanceof JSONArray)) {
        break label375;
      }
      localJSONArray1 = (JSONArray)localObject1;
      localJSONArray2 = new JSONArray();
      if (localJSONArray1.length() <= paramInt4) {
        break label375;
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
        break label376;
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
        QLog.w("WorldCupMgr", 1, "readJson, layer[" + paramInt1 + "], keyFrame[" + paramInt2 + "], " + paramString + "[" + (String)localObject1 + "->" + (String)localObject2 + "]");
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
              break label387;
            }
            localObject2 = (Double)localObject1;
            str = String.valueOf(localObject2);
            localObject1 = str;
            if (((Double)localObject2).doubleValue() <= 60.0D) {
              break label376;
            }
            localObject1 = Double.valueOf(((Double)localObject2).doubleValue() + paramInt3);
            localObject2 = String.valueOf(localObject1);
            localJSONArray2.put(localObject1);
            paramInt3 = 1;
            localObject1 = str;
            break;
          }
        }
        paramJSONObject.remove(paramString);
        paramJSONObject.put(paramString, localJSONArray2);
      }
      label375:
      return;
      label376:
      localObject2 = localObject1;
      paramInt3 = k;
      continue;
      label387:
      localObject2 = null;
      localObject1 = null;
      paramInt3 = k;
    }
  }
  
  static void a(Resources paramResources, ArrayList paramArrayList, aakm paramaakm)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      aakq localaakq = (aakq)localIterator.next();
      if (localaakq.a()) {
        localArrayList.add(localaakq);
      }
    }
    localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ((aakq)localIterator.next()).b();
    }
    ThreadManager.post(new aakf(localArrayList, paramResources, paramaakm, paramArrayList), 8, null, true);
  }
  
  private void a(String paramString, boolean paramBoolean, QQAppInterface paramQQAppInterface, int paramInt, aake paramaake)
  {
    i = 0;
    if ((jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo == null) || (paramaake == null))
    {
      b(paramInt, -3);
      return;
    }
    ResDownloadManager.IResDownloadListener localIResDownloadListener = a(paramQQAppInterface, paramaake);
    paramaake.jdField_b_of_type_Long = System.currentTimeMillis();
    if (jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.a(paramInt))
    {
      paramQQAppInterface = paramaake.jdField_a_of_type_JavaLangObject;
      if (!paramBoolean) {}
      try
      {
        paramaake.jdField_b_of_type_Boolean = false;
        QLog.w("WorldCupMgr", 1, "innerDownloadRes[" + paramString + "], 资源已经存在, callByPreDownload[" + paramBoolean + "], item[" + paramaake + "]");
        localIResDownloadListener.a(paramaake.jdField_a_of_type_JavaLangString, paramaake.jdField_b_of_type_JavaLangString, 100, a().a(paramInt), paramaake);
        return;
      }
      finally {}
    }
    Object localObject = paramaake.jdField_a_of_type_JavaLangObject;
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramaake.jdField_b_of_type_Boolean = false;
        if (paramaake.c)
        {
          QLog.w("WorldCupMgr", 1, "innerDownloadRes[" + paramString + "], 已经在下载中, callByPreDownload[" + paramBoolean + "], item[" + paramaake + "]");
          return;
        }
      }
      finally {}
      try
      {
        bool = new File(a(paramInt, paramaake.jdField_b_of_type_JavaLangString)).exists();
        if (!bool) {
          break;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool;
          i = 1;
          continue;
          i = 1;
        }
      }
      if (i != 0) {
        b(a(paramInt));
      }
      ((PreDownloadController)paramQQAppInterface.getManager(192)).a(paramaake.jdField_a_of_type_JavaLangString);
      paramaake.c = true;
      bool = ((ResDownloadManager)paramQQAppInterface.getManager(190)).a(paramaake.jdField_a_of_type_JavaLangString, paramaake.jdField_b_of_type_JavaLangString, ".zip", true, 5, paramaake, paramaake.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener);
      QLog.w("WorldCupMgr", 1, "innerDownloadRes[" + paramString + "], 开始下载, callByPreDownload[" + paramBoolean + "], ret[" + bool + "], item[" + paramaake + "]");
      if (!bool) {
        localIResDownloadListener.a(paramaake.jdField_a_of_type_JavaLangString, paramaake.jdField_b_of_type_JavaLangString, -4, null, paramaake);
      }
    }
  }
  
  public static boolean a(Resources paramResources, aakl paramaakl, String paramString)
  {
    long l1 = AudioHelper.b();
    paramString = paramString + paramaakl.jdField_a_of_type_JavaLangString + "/";
    int i = 0;
    while (i < paramaakl.jdField_a_of_type_Int)
    {
      if ((Bitmap)paramaakl.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)) == null)
      {
        Bitmap localBitmap = RedBagUtil.a(paramResources, paramString + i + ".png");
        if (localBitmap != null) {
          paramaakl.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localBitmap);
        }
      }
      else
      {
        i += 1;
        continue;
      }
      QLog.w("WorldCupMgr", 1, "loadBitmap[" + paramaakl.jdField_a_of_type_JavaLangString + "], 图片不存在 index[" + i + "]");
      paramaakl.jdField_a_of_type_JavaUtilHashMap.clear();
      return false;
    }
    long l2 = AudioHelper.b();
    QLog.w("WorldCupMgr", 1, "loadBitmap[" + paramaakl.jdField_a_of_type_JavaLangString + "], suc, cost[" + (l2 - l1) + "]");
    return true;
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    if (paramJSONObject == null) {
      return false;
    }
    try
    {
      paramJSONObject = paramJSONObject.toString();
      QLog.w("WorldCupMgr", 1, "readJson, json[\n\n" + paramJSONObject + "\n\n]");
      paramString.createNewFile();
      paramString = new PrintStream(paramString);
      paramString.print(paramJSONObject);
      paramString.flush();
      paramString.close();
      return true;
    }
    catch (Exception paramJSONObject)
    {
      QLog.w("WorldCupMgr", 1, "readJson, Exception", paramJSONObject);
      paramJSONObject.printStackTrace();
    }
    return false;
  }
  
  static final String b(int paramInt, String paramString)
  {
    return a(paramInt) + paramString + File.separator;
  }
  
  static void b(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      boolean bool1 = localFile.exists();
      FileUtils.b(paramString);
      localFile.delete();
      boolean bool2 = localFile.exists();
      QLog.w("WorldCupMgr", 1, "deleteDir, path[" + paramString + "], [" + bool1 + "->" + bool2 + "]");
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("WorldCupMgr", 1, "deleteDir, Exception", paramString);
    }
  }
  
  int a(AppInterface paramAppInterface, View paramView, PopupMenuDialog paramPopupMenuDialog, int paramInt)
  {
    if (!WorldCupConfigInfo.c(a())) {
      return paramInt;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni == null) {
      this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni = new MainDownAni();
    }
    return this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni.a(paramAppInterface, this, paramView, paramPopupMenuDialog, paramInt);
  }
  
  public WorldCupConfigInfo a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo == null)
      {
        jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = WorldCupConfigInfo.a(this.jdField_a_of_type_JavaLangString, null);
        QLog.w("WorldCupMgr", 1, "getConfigInfo, Uin[" + this.jdField_a_of_type_JavaLangString + "], mConfigInfo[" + jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo + "]");
      }
      return jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo;
    }
    finally {}
  }
  
  /* Error */
  ResDownloadManager.IResDownloadListener a(QQAppInterface paramQQAppInterface, aake paramaake)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 417	aake:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
    //   6: ifnull +12 -> 18
    //   9: aload_2
    //   10: getfield 417	aake:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_2
    //   19: new 527	aaki
    //   22: dup
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: getfield 528	aake:jdField_a_of_type_Int	I
    //   29: invokespecial 531	aaki:<init>	(Lcom/tencent/mobileqq/ar/config/WorldCupMgr;Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   32: putfield 417	aake:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
    //   35: aload_2
    //   36: getfield 417	aake:jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener	Lcom/tencent/mobileqq/armap/ResDownloadManager$IResDownloadListener;
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
    //   0	48	2	paramaake	aake
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
      aake localaake = (aake)a().b.get(Integer.valueOf(paramInt));
      a("主动触发", false, (QQAppInterface)paramAppInterface, paramInt, localaake);
      return;
    }
    BusinessCommonConfig.a(2, paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (AudioHelper.e()) {
      QLog.w("WorldCupMgr", 1, "onGetConfig, enable[" + jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.jdField_a_of_type_Boolean + "], ZipList[" + jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.b.size() + "], isDevicesSupport[" + WorldCup.a() + "]");
    }
    if (!WorldCup.a()) {}
    while ((!jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.jdField_a_of_type_Boolean) || (jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.b.size() == 0)) {
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
    QLog.w("WorldCupMgr", 1, "onConversatoinTagShow, 资源未准备");
    return;
    a(paramQQAppInterface, paramFragmentActivity, paramView);
    a(paramQQAppInterface, paramFragmentActivity, paramView);
  }
  
  void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, View paramView, String paramString)
  {
    boolean bool;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onMainFragmentTabShow, curTabTag[").append(paramString).append("], Account[").append(paramQQAppInterface.getAccount()).append("], activity[");
      if (paramFragmentActivity != null)
      {
        bool = true;
        QLog.w("WorldCupMgr", 1, bool + "]");
      }
    }
    else
    {
      if (paramFragmentActivity != null) {
        break label84;
      }
    }
    label84:
    do
    {
      do
      {
        return;
        bool = false;
        break;
      } while ((WorldCupStaticInstance.a().jdField_a_of_type_Long != -1L) && (!WorldCup.a()));
      if (!"消息".equals(paramString)) {
        break label136;
      }
    } while (a("onMainFragmentTabShow", paramQQAppInterface, paramFragmentActivity, paramView, true));
    a(paramQQAppInterface, paramFragmentActivity, paramView);
    return;
    label136:
    a("onConversatoinTabHide", paramQQAppInterface, paramFragmentActivity, paramView);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, WorldCupConfigInfo paramWorldCupConfigInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetConfig, from server, configInfo[");
    if (paramWorldCupConfigInfo != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("WorldCupMgr", 1, bool + "]");
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
    if (jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo == null)
    {
      QLog.w("WorldCupMgr", 1, "requestPreDownload, ConfigInfo为空, callByPreDownload[" + paramBoolean + "], downloadIndex[" + paramInt + "]");
      return;
    }
    Object localObject = jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.b.entrySet().iterator();
    int i = -1;
    aake localaake;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      i += 1;
      localaake = (aake)((Map.Entry)((Iterator)localObject).next()).getValue();
    } while ((localaake.jdField_a_of_type_Int < paramInt) || (a(localaake.jdField_b_of_type_Int) == 0) || (jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.a(localaake.jdField_a_of_type_Int)));
    for (;;)
    {
      QLog.w("WorldCupMgr", 1, "requestPreDownload, expectIndex[" + paramInt + "], zipItem[" + localaake + "], index[" + i + "]");
      if (localaake == null) {
        break;
      }
      localObject = "md5_" + localaake.jdField_a_of_type_Int;
      RunnableTask localRunnableTask = new RunnableTask(paramQQAppInterface, (String)localObject, new aakk(this, paramQQAppInterface, localaake), 0L);
      paramQQAppInterface = (PreDownloadController)paramQQAppInterface.getManager(192);
      String str1 = localaake.jdField_a_of_type_JavaLangString;
      String str2 = a(localaake.jdField_a_of_type_Int);
      if (paramBoolean) {}
      for (paramInt = a(localaake.jdField_b_of_type_Int);; paramInt = 2)
      {
        paramBoolean = paramQQAppInterface.a(10074, "prd", (String)localObject, 0, str1, str2, paramInt, 0, true, localRunnableTask);
        localaake.jdField_a_of_type_Long = System.currentTimeMillis();
        QLog.w("WorldCupMgr", 1, "onGetConfig, 申请调度, ret[" + paramBoolean + "], index[" + localaake.jdField_a_of_type_Int + "]");
        return;
      }
      localaake = null;
    }
  }
  
  public void a(WorldCupConfigInfo paramWorldCupConfigInfo)
  {
    try
    {
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
    if (this.jdField_a_of_type_Aakn != null) {
      this.jdField_a_of_type_Aakn.jdField_a_of_type_Boolean = false;
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
    return jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo != null;
  }
  
  boolean a(AppInterface paramAppInterface)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.businessnotify.qq.to.subprocess");
    return paramAppInterface.getApp().registerReceiver(new aakh(this), localIntentFilter) != null;
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
    QLog.w("WorldCupMgr", 1, "playMainAni加号菜单已经显示");
    return false;
  }
  
  boolean a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView)
  {
    WorldCupConfigInfo localWorldCupConfigInfo = a();
    if (!WorldCupConfigInfo.b(localWorldCupConfigInfo)) {}
    while (!localWorldCupConfigInfo.a(0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin != null)
      {
        QLog.w("WorldCupMgr", 1, "playSplash, 清除闪屏");
        this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin.a();
        this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin = null;
      }
      return false;
    }
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
    if (this.jdField_a_of_type_Aakn == null) {
      this.jdField_a_of_type_Aakn = new aakn(this.jdField_a_of_type_JavaLangString, paramQQAppInterface);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Aakn.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Aakn.a())
    {
      QLog.w("WorldCupMgr", 1, "异步加载config[" + paramString + "]");
      paramFragmentActivity = new WeakReference(paramFragmentActivity);
      paramView = new WeakReference(paramView);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_Aakn);
      a(null, localArrayList, new aakj(this, paramFragmentActivity, paramView, paramQQAppInterface, paramString));
    }
    for (;;)
    {
      return true;
      QLog.w("WorldCupMgr", 1, "异步加载config[" + paramString + "], 已经在加载中");
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
  
  public void c(String paramString)
  {
    try
    {
      jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = WorldCupConfigInfo.a(this.jdField_a_of_type_JavaLangString, paramString);
      QLog.w("WorldCupMgr", 1, "reloadConfigInfo, Uin[" + this.jdField_a_of_type_JavaLangString + "] mConfigInfo[" + jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo + "]");
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    QLog.w("WorldCupMgr", 1, "onDestroy, ThreadID[" + Thread.currentThread().getId() + "], Tid[" + Process.myTid() + "]");
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni != null)
    {
      QLog.w("WorldCupMgr", 1, "onDestroy, 清除动画");
      this.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni.a();
      this.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin != null)
    {
      QLog.w("WorldCupMgr", 1, "onDestroy, 清除闪屏");
      this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin.a();
      this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigDownloadDependRes != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArConfigDownloadDependRes.a();
      this.jdField_a_of_type_ComTencentMobileqqArConfigDownloadDependRes = null;
    }
    if (this.jdField_a_of_type_Aakn != null)
    {
      this.jdField_a_of_type_Aakn.c();
      this.jdField_a_of_type_Aakn = null;
    }
    WorldCupStaticInstance.a().a();
    jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.WorldCupMgr
 * JD-Core Version:    0.7.0.1
 */