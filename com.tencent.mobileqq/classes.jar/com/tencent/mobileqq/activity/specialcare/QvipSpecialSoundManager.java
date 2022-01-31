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
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import ycc;
import ycd;
import yce;
import ycf;
import ycg;

public class QvipSpecialSoundManager
{
  public static HashMap a;
  public static HashMap b = new HashMap();
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
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    try
    {
      paramContext = paramContext.getFilesDir().getCanonicalPath() + "/";
      ThreadManager.getFileThreadHandler().post(new ycd(this, paramContext));
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
        localDownloadTask.l = true;
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
    //   0: new 181	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 184	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 186	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 187	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_3
    //   17: aload_0
    //   18: getfield 34	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   21: sipush 4096
    //   24: invokevirtual 191	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   27: astore 4
    //   29: aload_1
    //   30: aload 4
    //   32: iconst_0
    //   33: sipush 4096
    //   36: invokevirtual 197	java/io/InputStream:read	([BII)I
    //   39: istore_2
    //   40: iload_2
    //   41: iconst_m1
    //   42: if_icmpeq +57 -> 99
    //   45: aload_3
    //   46: aload 4
    //   48: iconst_0
    //   49: iload_2
    //   50: invokevirtual 201	java/io/ByteArrayOutputStream:write	([BII)V
    //   53: goto -24 -> 29
    //   56: astore 5
    //   58: aload 5
    //   60: invokevirtual 169	java/io/IOException:printStackTrace	()V
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 204	java/io/InputStream:close	()V
    //   71: aload_3
    //   72: ifnull +7 -> 79
    //   75: aload_3
    //   76: invokevirtual 205	java/io/ByteArrayOutputStream:close	()V
    //   79: aload_0
    //   80: getfield 34	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   83: aload 4
    //   85: invokevirtual 209	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   88: ldc 127
    //   90: areturn
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 210	java/io/FileNotFoundException:printStackTrace	()V
    //   96: ldc 127
    //   98: areturn
    //   99: new 212	java/lang/String
    //   102: dup
    //   103: aload_3
    //   104: invokevirtual 216	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   107: ldc 218
    //   109: invokespecial 221	java/lang/String:<init>	([BLjava/lang/String;)V
    //   112: astore 5
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 204	java/io/InputStream:close	()V
    //   122: aload_3
    //   123: ifnull +7 -> 130
    //   126: aload_3
    //   127: invokevirtual 205	java/io/ByteArrayOutputStream:close	()V
    //   130: aload_0
    //   131: getfield 34	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   134: aload 4
    //   136: invokevirtual 209	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   139: aload 5
    //   141: areturn
    //   142: astore 5
    //   144: aload 5
    //   146: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 204	java/io/InputStream:close	()V
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 205	java/io/ByteArrayOutputStream:close	()V
    //   165: aload_0
    //   166: getfield 34	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   169: aload 4
    //   171: invokevirtual 209	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   174: goto -86 -> 88
    //   177: astore 5
    //   179: aload_1
    //   180: ifnull +7 -> 187
    //   183: aload_1
    //   184: invokevirtual 204	java/io/InputStream:close	()V
    //   187: aload_3
    //   188: ifnull +7 -> 195
    //   191: aload_3
    //   192: invokevirtual 205	java/io/ByteArrayOutputStream:close	()V
    //   195: aload_0
    //   196: getfield 34	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool	Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   199: aload 4
    //   201: invokevirtual 209	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
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
    this.jdField_a_of_type_AndroidOsHandler.post(new ycg(this, paramCallBack, paramBoolean));
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
        localObject = (ycc)paramString1.get(i);
        ycc localycc = (ycc)paramString2.get(i);
        if ((((ycc)localObject).jdField_a_of_type_Int == localycc.jdField_a_of_type_Int) && (!((ycc)localObject).jdField_b_of_type_JavaLangString.equals(localycc.jdField_b_of_type_JavaLangString))) {
          ThreadManager.post(new yce(this, (ycc)localObject), 5, null, true);
        }
        i += 1;
      }
    }
  }
  
  private void a(List paramList)
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
        ycc localycc = (ycc)paramList.get(i);
        if (!b.containsKey(String.valueOf(localycc.jdField_a_of_type_Int))) {
          b.put(String.valueOf(localycc.jdField_a_of_type_Int), localycc);
        }
        localEditor.putString("special_sound_url" + localycc.jdField_a_of_type_Int, localycc.jdField_c_of_type_JavaLangString);
        if (!b(localycc.d)) {
          b("is white list.");
        }
        for (;;)
        {
          i += 1;
          break;
          if (localycc.jdField_c_of_type_Int == 1) {
            if (localycc.jdField_b_of_type_Int == 1) {
              localArrayList1.add(localycc);
            } else if (localycc.jdField_b_of_type_Int == 2) {
              localArrayList2.add(localycc);
            } else {
              localArrayList3.add(localycc);
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
    ((SharedPreferences.Editor)localObject).putInt("defaulut_special_sound_source1", 2131230757);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public int a(String paramString)
  {
    Object localObject = "key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    localObject = (List)jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null) {
      return -1;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ycc localycc = (ycc)((Iterator)localObject).next();
      if (paramString.equals(localycc.jdField_c_of_type_JavaLangString)) {
        return localycc.jdField_a_of_type_Int;
      }
    }
    return -1;
  }
  
  public String a(int paramInt)
  {
    if ((b != null) && (!b.isEmpty()))
    {
      ycc localycc = (ycc)b.get(String.valueOf(paramInt));
      if (localycc != null) {
        return localycc.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 115	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: ldc 117
    //   9: iconst_4
    //   10: invokevirtual 123	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_1
    //   16: new 62	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: getfield 49	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   24: invokevirtual 60	android/content/Context:getFilesDir	()Ljava/io/File;
    //   27: ldc 100
    //   29: invokespecial 103	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 107	java/io/File:exists	()Z
    //   37: ifeq +9 -> 46
    //   40: aload_0
    //   41: aload_2
    //   42: invokespecial 166	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(Ljava/io/File;)Ljava/lang/String;
    //   45: astore_1
    //   46: aload_3
    //   47: ldc 125
    //   49: ldc 127
    //   51: invokeinterface 133 3 0
    //   56: astore_3
    //   57: new 109	com/tencent/mobileqq/vip/DownloadTask
    //   60: dup
    //   61: aload_3
    //   62: aload_2
    //   63: invokespecial 136	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   66: astore 5
    //   68: aload 5
    //   70: iconst_1
    //   71: putfield 139	com/tencent/mobileqq/vip/DownloadTask:a	B
    //   74: aload 5
    //   76: iconst_1
    //   77: putfield 143	com/tencent/mobileqq/vip/DownloadTask:l	Z
    //   80: aload_0
    //   81: getfield 51	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   84: sipush 192
    //   87: invokevirtual 424	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   90: checkcast 426	com/tencent/mobileqq/transfile/predownload/PreDownloadController
    //   93: astore 4
    //   95: aload 4
    //   97: invokevirtual 428	com/tencent/mobileqq/transfile/predownload/PreDownloadController:a	()Z
    //   100: ifeq +150 -> 250
    //   103: new 430	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager$SyncDownloadRunnable
    //   106: dup
    //   107: aload_0
    //   108: aload 5
    //   110: aload_0
    //   111: getfield 51	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   114: aload_2
    //   115: aload_1
    //   116: invokespecial 433	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager$SyncDownloadRunnable:<init>	(Lcom/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager;Lcom/tencent/mobileqq/vip/DownloadTask;Lcom/tencent/common/app/AppInterface;Ljava/io/File;Ljava/lang/String;)V
    //   119: astore_1
    //   120: new 435	com/tencent/mobileqq/transfile/predownload/RunnableTask
    //   123: dup
    //   124: aload_0
    //   125: getfield 51	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   128: checkcast 437	com/tencent/mobileqq/app/QQAppInterface
    //   131: ldc_w 439
    //   134: aload_1
    //   135: ldc2_w 440
    //   138: invokespecial 444	com/tencent/mobileqq/transfile/predownload/RunnableTask:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Runnable;J)V
    //   141: astore_1
    //   142: aload 4
    //   144: sipush 10021
    //   147: ldc_w 446
    //   150: ldc_w 439
    //   153: iconst_0
    //   154: aload_3
    //   155: aload_2
    //   156: invokevirtual 66	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   159: iconst_2
    //   160: iconst_0
    //   161: iconst_0
    //   162: aload_1
    //   163: invokevirtual 449	com/tencent/mobileqq/transfile/predownload/PreDownloadController:a	(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIZLcom/tencent/mobileqq/transfile/predownload/AbsPreDownloadTask;)Z
    //   166: pop
    //   167: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +42 -> 212
    //   173: ldc 224
    //   175: iconst_2
    //   176: new 53	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 451
    //   186: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_2
    //   190: invokevirtual 66	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   193: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 453
    //   199: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_3
    //   203: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: return
    //   213: astore_1
    //   214: aload_0
    //   215: new 53	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 455
    //   225: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_1
    //   229: invokevirtual 456	java/lang/Exception:toString	()Ljava/lang/String;
    //   232: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokevirtual 160	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   241: aload_1
    //   242: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   245: aconst_null
    //   246: astore_1
    //   247: goto -201 -> 46
    //   250: aload_0
    //   251: aload 5
    //   253: aload_0
    //   254: getfield 51	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   257: invokestatic 148	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lmqq/app/AppRuntime;)I
    //   260: aload_2
    //   261: aload_1
    //   262: invokespecial 267	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(ILjava/io/File;Ljava/lang/String;)V
    //   265: return
    //   266: astore_1
    //   267: aload_0
    //   268: new 53	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 455
    //   278: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_1
    //   282: invokevirtual 456	java/lang/Exception:toString	()Ljava/lang/String;
    //   285: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokevirtual 160	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   294: aload_1
    //   295: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   298: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	QvipSpecialSoundManager
    //   15	148	1	localObject1	Object
    //   213	29	1	localException1	Exception
    //   246	16	1	str	String
    //   266	29	1	localException2	Exception
    //   32	229	2	localFile	File
    //   13	190	3	localObject2	Object
    //   93	50	4	localPreDownloadController	com.tencent.mobileqq.transfile.predownload.PreDownloadController
    //   66	186	5	localDownloadTask	DownloadTask
    // Exception table:
    //   from	to	target	type
    //   33	46	213	java/lang/Exception
    //   46	212	266	java/lang/Exception
    //   250	265	266	java/lang/Exception
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      b("reportFlowData is Empty flowSize = " + paramLong);
      return;
    }
    String[] arrayOfString;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
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
  
  public void a(QvipSpecialSoundManager.CallBack paramCallBack)
  {
    ThreadManager.post(new ycf(this, paramCallBack), 5, null, true);
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