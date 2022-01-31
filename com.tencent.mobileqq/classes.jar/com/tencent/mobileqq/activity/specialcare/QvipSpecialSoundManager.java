package com.tencent.mobileqq.activity.specialcare;

import ahwk;
import ahwl;
import ahwm;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import badq;
import batm;
import bato;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class QvipSpecialSoundManager
{
  public static HashMap<String, List<ahwl>> a;
  public static HashMap<String, ahwl> b = new HashMap();
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ByteArrayPool jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool = new ByteArrayPool(4096);
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public QvipSpecialSoundManager(Context paramContext, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramAppInterface.getApp();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    try
    {
      paramContext = paramContext.getFilesDir().getCanonicalPath() + "/";
      ThreadManager.getFileThreadHandler().post(new QvipSpecialSoundManager.MoveConfig(paramContext, null));
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private String a()
  {
    Object localObject = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "pddata/vas/special_remind/new_config.json");
    if (!((File)localObject).exists()) {}
    for (;;)
    {
      try
      {
        batm localbatm = new batm(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getString("specialcare_config", ""), (File)localObject);
        localbatm.a = 1;
        localbatm.n = true;
        i = bato.a(localbatm, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        if (i != 0) {
          break label197;
        }
        if (localObject != null)
        {
          l = ((File)localObject).length();
          a(l);
          i = 1;
          if (i != 0) {
            break label138;
          }
          b("downLoad Special Sound Config failed.");
          return "";
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        i = -1;
        continue;
        long l = 0L;
        continue;
      }
      int i = 1;
      continue;
      try
      {
        label138:
        localObject = a((File)localObject);
        return localObject;
      }
      catch (IOException localIOException)
      {
        b("decodeTextFile is IOException.");
        localIOException.printStackTrace();
        return "";
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          b("decodeTextFile is OutOfMemoryError.");
          localOutOfMemoryError.printStackTrace();
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          b("decodeTextFile is exception.");
          localException1.printStackTrace();
        }
      }
      label197:
      i = 0;
    }
  }
  
  /* Error */
  private String a(File paramFile)
  {
    // Byte code:
    //   0: new 183	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 186	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 188	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 189	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_3
    //   17: aload_0
    //   18: getfield 36	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   21: sipush 4096
    //   24: invokevirtual 193	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   27: astore 4
    //   29: aload_1
    //   30: aload 4
    //   32: iconst_0
    //   33: sipush 4096
    //   36: invokevirtual 199	java/io/InputStream:read	([BII)I
    //   39: istore_2
    //   40: iload_2
    //   41: iconst_m1
    //   42: if_icmpeq +57 -> 99
    //   45: aload_3
    //   46: aload 4
    //   48: iconst_0
    //   49: iload_2
    //   50: invokevirtual 203	java/io/ByteArrayOutputStream:write	([BII)V
    //   53: goto -24 -> 29
    //   56: astore 5
    //   58: aload 5
    //   60: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 206	java/io/InputStream:close	()V
    //   71: aload_3
    //   72: ifnull +7 -> 79
    //   75: aload_3
    //   76: invokevirtual 207	java/io/ByteArrayOutputStream:close	()V
    //   79: aload_0
    //   80: getfield 36	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   83: aload 4
    //   85: invokevirtual 211	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   88: ldc 129
    //   90: areturn
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 212	java/io/FileNotFoundException:printStackTrace	()V
    //   96: ldc 129
    //   98: areturn
    //   99: new 214	java/lang/String
    //   102: dup
    //   103: aload_3
    //   104: invokevirtual 218	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   107: ldc 220
    //   109: invokespecial 223	java/lang/String:<init>	([BLjava/lang/String;)V
    //   112: astore 5
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 206	java/io/InputStream:close	()V
    //   122: aload_3
    //   123: ifnull +7 -> 130
    //   126: aload_3
    //   127: invokevirtual 207	java/io/ByteArrayOutputStream:close	()V
    //   130: aload_0
    //   131: getfield 36	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   134: aload 4
    //   136: invokevirtual 211	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   139: aload 5
    //   141: areturn
    //   142: astore 5
    //   144: aload 5
    //   146: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 206	java/io/InputStream:close	()V
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 207	java/io/ByteArrayOutputStream:close	()V
    //   165: aload_0
    //   166: getfield 36	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   169: aload 4
    //   171: invokevirtual 211	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   174: goto -86 -> 88
    //   177: astore 5
    //   179: aload_1
    //   180: ifnull +7 -> 187
    //   183: aload_1
    //   184: invokevirtual 206	java/io/InputStream:close	()V
    //   187: aload_3
    //   188: ifnull +7 -> 195
    //   191: aload_3
    //   192: invokevirtual 207	java/io/ByteArrayOutputStream:close	()V
    //   195: aload_0
    //   196: getfield 36	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   199: aload 4
    //   201: invokevirtual 211	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   204: aload 5
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	QvipSpecialSoundManager
    //   0	207	1	paramFile	File
    //   39	11	2	i	int
    //   16	176	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   27	173	4	arrayOfByte	byte[]
    //   56	3	5	localIOException	IOException
    //   112	28	5	str	String
    //   142	3	5	localException	Exception
    //   177	28	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	40	56	java/io/IOException
    //   45	53	56	java/io/IOException
    //   99	114	56	java/io/IOException
    //   0	9	91	java/io/FileNotFoundException
    //   29	40	142	java/lang/Exception
    //   45	53	142	java/lang/Exception
    //   99	114	142	java/lang/Exception
    //   29	40	177	finally
    //   45	53	177	finally
    //   58	63	177	finally
    //   99	114	177	finally
    //   144	149	177	finally
  }
  
  private void a(int paramInt, File paramFile, String paramString)
  {
    if (paramFile == null)
    {
      QLog.e("QvipSpecialSoundManager", 1, "onSpecialSoundConfigDownloaded specialSoundPath == null");
      return;
    }
    if (paramInt == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("QvipSpecialSoundManager", 2, "download SpecialSound Success");
      }
    }
    for (;;)
    {
      try
      {
        String str = a(paramFile);
        if (!paramFile.exists()) {
          continue;
        }
        l = paramFile.length();
        a(l);
        paramFile = str;
      }
      catch (Exception paramFile)
      {
        long l;
        b("decodeTextFile is exception.");
        paramFile.printStackTrace();
        paramFile = null;
        continue;
      }
      catch (OutOfMemoryError paramFile)
      {
        b("decodeTextFile is OutOfMemoryError.");
        paramFile.printStackTrace();
      }
      if (!TextUtils.isEmpty(paramFile)) {
        break;
      }
      b("new Config is Empty");
      return;
      l = 0L;
      continue;
      paramFile = null;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramFile)))
    {
      b("Config is Same");
      return;
    }
    a(paramString, paramFile);
  }
  
  private void a(ahwm paramahwm, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QvipSpecialSoundManager.3(this, paramahwm, paramBoolean));
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      Object localObject;
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null)) {
          return;
        }
        if (TextUtils.isEmpty(paramString2)) {
          return;
        }
        paramString2 = ahwk.a(new JSONObject(paramString2));
        localObject = ahwk.a(new JSONObject(paramString1));
        paramString1 = paramString2.a;
        paramString2 = ((ahwk)localObject).a;
        if ((paramString1 == null) || (paramString2 == null) || (paramString1.isEmpty()) || (paramString2.isEmpty()) || (paramString1.size() < paramString2.size()))
        {
          b("updateSpecialSound return.");
          return;
        }
      }
      catch (Exception paramString1)
      {
        b("updateSpecialSound exception");
        paramString1.printStackTrace();
        return;
      }
      int j = paramString2.size();
      int i = 0;
      while (i < j)
      {
        localObject = (ahwl)paramString1.get(i);
        ahwl localahwl = (ahwl)paramString2.get(i);
        if ((((ahwl)localObject).jdField_a_of_type_Int == localahwl.jdField_a_of_type_Int) && (!((ahwl)localObject).jdField_b_of_type_JavaLangString.equals(localahwl.jdField_b_of_type_JavaLangString))) {
          ThreadManager.post(new QvipSpecialSoundManager.1(this, (ahwl)localObject), 5, null, true);
        }
        i += 1;
      }
    }
  }
  
  private void a(List<ahwl> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      b("SpecialSoundList is empty, donot need sort.");
    }
    do
    {
      return;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int j = paramList.size();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
      int i = 0;
      if (i < j)
      {
        ahwl localahwl = (ahwl)paramList.get(i);
        if (!b.containsKey(String.valueOf(localahwl.jdField_a_of_type_Int))) {
          b.put(String.valueOf(localahwl.jdField_a_of_type_Int), localahwl);
        }
        localEditor.putString("special_sound_url" + localahwl.jdField_a_of_type_Int, localahwl.jdField_c_of_type_JavaLangString);
        if (!b(localahwl.d)) {
          b("is white list.");
        }
        for (;;)
        {
          i += 1;
          break;
          if (localahwl.jdField_c_of_type_Int == 1) {
            if (localahwl.jdField_b_of_type_Int == 1) {
              localArrayList1.add(localahwl);
            } else if (localahwl.jdField_b_of_type_Int == 2) {
              localArrayList2.add(localahwl);
            } else {
              localArrayList3.add(localahwl);
            }
          }
        }
      }
      localEditor.commit();
      paramList.clear();
      paramList.addAll(localArrayList1);
      paramList.addAll(localArrayList2);
      paramList.addAll(localArrayList3);
    } while (jdField_a_of_type_JavaUtilHashMap.containsKey("key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    jdField_a_of_type_JavaUtilHashMap.put("key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramList);
  }
  
  private boolean b(String paramString)
  {
    str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return true;
      if (paramString.contains("|")) {
        try
        {
          String[] arrayOfString = paramString.split("\\|");
          int j = arrayOfString.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label85;
            }
            boolean bool = arrayOfString[i].trim().equals(str);
            if (bool) {
              break;
            }
            i += 1;
          }
          return paramString.equals(str);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    if (((SharedPreferences)localObject).contains("defaulut_special_sound_source1")) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("defaulut_special_sound_source1", 2131230758);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public String a(int paramInt)
  {
    if ((b != null) && (!b.isEmpty()))
    {
      ahwl localahwl = (ahwl)b.get(String.valueOf(paramInt));
      if (localahwl != null) {
        return localahwl.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 55	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: ldc 119
    //   9: iconst_4
    //   10: invokevirtual 125	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_1
    //   16: new 70	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: getfield 57	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   24: invokevirtual 68	android/content/Context:getFilesDir	()Ljava/io/File;
    //   27: ldc 108
    //   29: invokespecial 111	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 115	java/io/File:exists	()Z
    //   37: ifeq +9 -> 46
    //   40: aload_0
    //   41: aload_2
    //   42: invokespecial 168	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(Ljava/io/File;)Ljava/lang/String;
    //   45: astore_1
    //   46: aload_3
    //   47: ldc 127
    //   49: ldc 129
    //   51: invokeinterface 135 3 0
    //   56: astore_3
    //   57: new 117	batm
    //   60: dup
    //   61: aload_3
    //   62: aload_2
    //   63: invokespecial 138	batm:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   66: astore 5
    //   68: aload 5
    //   70: iconst_1
    //   71: putfield 141	batm:a	B
    //   74: aload 5
    //   76: iconst_1
    //   77: putfield 145	batm:n	Z
    //   80: aload 5
    //   82: sipush 20000
    //   85: putfield 412	batm:e	I
    //   88: aload_0
    //   89: getfield 59	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   92: sipush 193
    //   95: invokevirtual 416	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   98: checkcast 418	axxj
    //   101: astore 4
    //   103: aload 4
    //   105: invokevirtual 420	axxj:a	()Z
    //   108: ifeq +150 -> 258
    //   111: new 422	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager$SyncDownloadRunnable
    //   114: dup
    //   115: aload_0
    //   116: aload 5
    //   118: aload_0
    //   119: getfield 59	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   122: aload_2
    //   123: aload_1
    //   124: invokespecial 425	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager$SyncDownloadRunnable:<init>	(Lcom/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager;Lbatm;Lcom/tencent/common/app/AppInterface;Ljava/io/File;Ljava/lang/String;)V
    //   127: astore_1
    //   128: new 427	axxk
    //   131: dup
    //   132: aload_0
    //   133: getfield 59	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   136: checkcast 429	com/tencent/mobileqq/app/QQAppInterface
    //   139: ldc_w 431
    //   142: aload_1
    //   143: ldc2_w 432
    //   146: invokespecial 436	axxk:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Runnable;J)V
    //   149: astore_1
    //   150: aload 4
    //   152: sipush 10021
    //   155: ldc_w 438
    //   158: ldc_w 431
    //   161: iconst_0
    //   162: aload_3
    //   163: aload_2
    //   164: invokevirtual 74	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   167: iconst_2
    //   168: iconst_0
    //   169: iconst_0
    //   170: aload_1
    //   171: invokevirtual 441	axxj:a	(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIZLaxxg;)Z
    //   174: pop
    //   175: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +42 -> 220
    //   181: ldc 226
    //   183: iconst_2
    //   184: new 61	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   191: ldc_w 443
    //   194: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_2
    //   198: invokevirtual 74	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   201: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc_w 445
    //   207: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_3
    //   211: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: return
    //   221: astore_1
    //   222: aload_0
    //   223: new 61	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   230: ldc_w 447
    //   233: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_1
    //   237: invokevirtual 448	java/lang/Exception:toString	()Ljava/lang/String;
    //   240: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokevirtual 162	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   249: aload_1
    //   250: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   253: aconst_null
    //   254: astore_1
    //   255: goto -209 -> 46
    //   258: aload_0
    //   259: aload 5
    //   261: aload_0
    //   262: getfield 59	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   265: invokestatic 150	bato:a	(Lbatm;Lmqq/app/AppRuntime;)I
    //   268: aload_2
    //   269: aload_1
    //   270: invokespecial 269	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(ILjava/io/File;Ljava/lang/String;)V
    //   273: return
    //   274: astore_1
    //   275: aload_0
    //   276: new 61	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 447
    //   286: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_1
    //   290: invokevirtual 448	java/lang/Exception:toString	()Ljava/lang/String;
    //   293: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokevirtual 162	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   302: aload_1
    //   303: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   306: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	QvipSpecialSoundManager
    //   15	156	1	localObject1	Object
    //   221	29	1	localException1	Exception
    //   254	16	1	str	String
    //   274	29	1	localException2	Exception
    //   32	237	2	localFile	File
    //   13	198	3	localObject2	Object
    //   101	50	4	localaxxj	axxj
    //   66	194	5	localbatm	batm
    // Exception table:
    //   from	to	target	type
    //   33	46	221	java/lang/Exception
    //   46	220	274	java/lang/Exception
    //   258	273	274	java/lang/Exception
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      b("reportFlowData is Empty flowSize = " + paramLong);
      return;
    }
    String[] arrayOfString;
    if (badq.b(BaseApplication.getContext()) == 1)
    {
      b("reportFlowData int wifi state");
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFISpecialCareDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
    for (;;)
    {
      b("sendAppDataIncerment flowSize = " + paramLong);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.sendAppDataIncerment(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), arrayOfString, paramLong);
      return;
      b("reportFlowData int 2G/3G state");
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGSpecialCareDownloadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
  
  public void a(ahwm paramahwm)
  {
    ThreadManager.post(new QvipSpecialSoundManager.2(this, paramahwm), 5, null, true);
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = ahwk.a(new JSONObject(paramString));
        if (paramString != null)
        {
          a(paramString.a);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public boolean a()
  {
    String str = "key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    return jdField_a_of_type_JavaUtilHashMap.containsKey(str);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), paramString);
      try
      {
        paramString = new batm(MsfSdkUtils.insertMtype("lingyin", paramString), localFile);
        paramString.a = 1;
        i = bato.a(paramString, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        if (i == 0) {
          continue;
        }
        return false;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          int i = -1;
        }
      }
    }
  }
  
  public void b()
  {
    c();
    a(a());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QvipSpecialSoundManager", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager
 * JD-Core Version:    0.7.0.1
 */