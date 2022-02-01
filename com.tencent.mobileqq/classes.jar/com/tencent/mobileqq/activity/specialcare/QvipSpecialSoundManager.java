package com.tencent.mobileqq.activity.specialcare;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
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
  public static HashMap<String, List<QvipSpecialSoundConfig.SpecialSound>> a;
  public static HashMap<String, QvipSpecialSoundConfig.SpecialSound> b = new HashMap();
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
        DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getString("specialcare_config", ""), (File)localObject);
        localDownloadTask.a = 1;
        localDownloadTask.n = true;
        i = DownloaderFactory.a(localDownloadTask, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
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
  
  private void a(QvipSpecialSoundManager.CallBack paramCallBack, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QvipSpecialSoundManager.3(this, paramCallBack, paramBoolean));
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
        paramString2 = QvipSpecialSoundConfig.a(new JSONObject(paramString2));
        localObject = QvipSpecialSoundConfig.a(new JSONObject(paramString1));
        paramString1 = paramString2.a;
        paramString2 = ((QvipSpecialSoundConfig)localObject).a;
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
        localObject = (QvipSpecialSoundConfig.SpecialSound)paramString1.get(i);
        QvipSpecialSoundConfig.SpecialSound localSpecialSound = (QvipSpecialSoundConfig.SpecialSound)paramString2.get(i);
        if ((((QvipSpecialSoundConfig.SpecialSound)localObject).jdField_a_of_type_Int == localSpecialSound.jdField_a_of_type_Int) && (!((QvipSpecialSoundConfig.SpecialSound)localObject).jdField_b_of_type_JavaLangString.equals(localSpecialSound.jdField_b_of_type_JavaLangString))) {
          ThreadManager.post(new QvipSpecialSoundManager.1(this, (QvipSpecialSoundConfig.SpecialSound)localObject), 5, null, true);
        }
        i += 1;
      }
    }
  }
  
  private void a(List<QvipSpecialSoundConfig.SpecialSound> paramList)
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
        QvipSpecialSoundConfig.SpecialSound localSpecialSound = (QvipSpecialSoundConfig.SpecialSound)paramList.get(i);
        if (!b.containsKey(String.valueOf(localSpecialSound.jdField_a_of_type_Int))) {
          b.put(String.valueOf(localSpecialSound.jdField_a_of_type_Int), localSpecialSound);
        }
        localEditor.putString("special_sound_url" + localSpecialSound.jdField_a_of_type_Int, localSpecialSound.jdField_c_of_type_JavaLangString);
        if (!b(localSpecialSound.d)) {
          b("is white list.");
        }
        for (;;)
        {
          i += 1;
          break;
          if (localSpecialSound.jdField_c_of_type_Int == 1) {
            if (localSpecialSound.jdField_b_of_type_Int == 1) {
              localArrayList1.add(localSpecialSound);
            } else if (localSpecialSound.jdField_b_of_type_Int == 2) {
              localArrayList2.add(localSpecialSound);
            } else {
              localArrayList3.add(localSpecialSound);
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
    ((SharedPreferences.Editor)localObject).putInt("defaulut_special_sound_source1", 2131230762);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public String a(int paramInt)
  {
    if ((b != null) && (!b.isEmpty()))
    {
      QvipSpecialSoundConfig.SpecialSound localSpecialSound = (QvipSpecialSoundConfig.SpecialSound)b.get(String.valueOf(paramInt));
      if (localSpecialSound != null) {
        return localSpecialSound.jdField_a_of_type_JavaLangString;
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
    //   57: new 117	com/tencent/mobileqq/vip/DownloadTask
    //   60: dup
    //   61: aload_3
    //   62: aload_2
    //   63: invokespecial 138	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   66: astore 5
    //   68: aload 5
    //   70: iconst_1
    //   71: putfield 141	com/tencent/mobileqq/vip/DownloadTask:a	B
    //   74: aload 5
    //   76: iconst_1
    //   77: putfield 145	com/tencent/mobileqq/vip/DownloadTask:n	Z
    //   80: aload 5
    //   82: sipush 20000
    //   85: putfield 412	com/tencent/mobileqq/vip/DownloadTask:e	I
    //   88: aload_0
    //   89: getfield 59	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   92: getstatic 417	com/tencent/mobileqq/app/QQManagerFactory:PRE_DOWNLOAD_CONTROLLER_2	I
    //   95: invokevirtual 421	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   98: checkcast 423	com/tencent/mobileqq/transfile/predownload/PreDownloadController
    //   101: astore 4
    //   103: aload 4
    //   105: invokevirtual 426	com/tencent/mobileqq/transfile/predownload/PreDownloadController:isEnable	()Z
    //   108: ifeq +146 -> 254
    //   111: new 428	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager$SyncDownloadRunnable
    //   114: dup
    //   115: aload 5
    //   117: aload_2
    //   118: aload_1
    //   119: aload_0
    //   120: invokespecial 431	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager$SyncDownloadRunnable:<init>	(Lcom/tencent/mobileqq/vip/DownloadTask;Ljava/io/File;Ljava/lang/String;Lcom/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager;)V
    //   123: astore_1
    //   124: new 433	com/tencent/mobileqq/transfile/predownload/RunnableTask
    //   127: dup
    //   128: aload_0
    //   129: getfield 59	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   132: checkcast 435	com/tencent/mobileqq/app/QQAppInterface
    //   135: ldc_w 437
    //   138: aload_1
    //   139: ldc2_w 438
    //   142: invokespecial 442	com/tencent/mobileqq/transfile/predownload/RunnableTask:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Runnable;J)V
    //   145: astore_1
    //   146: aload 4
    //   148: sipush 10021
    //   151: ldc_w 444
    //   154: ldc_w 437
    //   157: iconst_0
    //   158: aload_3
    //   159: aload_2
    //   160: invokevirtual 74	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   163: iconst_2
    //   164: iconst_0
    //   165: iconst_0
    //   166: aload_1
    //   167: invokevirtual 448	com/tencent/mobileqq/transfile/predownload/PreDownloadController:requestPreDownload	(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIZLcom/tencent/mobileqq/transfile/predownload/AbsPreDownloadTask;)Z
    //   170: pop
    //   171: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +42 -> 216
    //   177: ldc 226
    //   179: iconst_2
    //   180: new 61	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 450
    //   190: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_2
    //   194: invokevirtual 74	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   197: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 452
    //   203: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_3
    //   207: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: return
    //   217: astore_1
    //   218: aload_0
    //   219: new 61	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 454
    //   229: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_1
    //   233: invokevirtual 455	java/lang/Exception:toString	()Ljava/lang/String;
    //   236: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokevirtual 162	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   245: aload_1
    //   246: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   249: aconst_null
    //   250: astore_1
    //   251: goto -205 -> 46
    //   254: aload_0
    //   255: aload 5
    //   257: aload_0
    //   258: getfield 59	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   261: invokestatic 150	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lmqq/app/AppRuntime;)I
    //   264: aload_2
    //   265: aload_1
    //   266: invokespecial 269	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(ILjava/io/File;Ljava/lang/String;)V
    //   269: return
    //   270: astore_1
    //   271: aload_0
    //   272: new 61	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 454
    //   282: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_1
    //   286: invokevirtual 455	java/lang/Exception:toString	()Ljava/lang/String;
    //   289: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokevirtual 162	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   298: aload_1
    //   299: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   302: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	QvipSpecialSoundManager
    //   15	152	1	localObject1	Object
    //   217	29	1	localException1	Exception
    //   250	16	1	str	String
    //   270	29	1	localException2	Exception
    //   32	233	2	localFile	File
    //   13	194	3	localObject2	Object
    //   101	46	4	localPreDownloadController	com.tencent.mobileqq.transfile.predownload.PreDownloadController
    //   66	190	5	localDownloadTask	DownloadTask
    // Exception table:
    //   from	to	target	type
    //   33	46	217	java/lang/Exception
    //   46	216	270	java/lang/Exception
    //   254	269	270	java/lang/Exception
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      b("reportFlowData is Empty flowSize = " + paramLong);
      return;
    }
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
      b("reportFlowData int wifi state");
    }
    for (;;)
    {
      b("sendAppDataIncerment flowSize = " + paramLong);
      return;
      b("reportFlowData int 2G/3G state");
    }
  }
  
  public void a(QvipSpecialSoundManager.CallBack paramCallBack)
  {
    ThreadManager.post(new QvipSpecialSoundManager.2(this, paramCallBack), 5, null, true);
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = QvipSpecialSoundConfig.a(new JSONObject(paramString));
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
        paramString = new DownloadTask(MsfSdkUtils.insertMtype("lingyin", paramString), localFile);
        paramString.a = 1;
        i = DownloaderFactory.a(paramString, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
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