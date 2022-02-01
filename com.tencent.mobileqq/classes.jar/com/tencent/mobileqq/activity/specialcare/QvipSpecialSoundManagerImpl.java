package com.tencent.mobileqq.activity.specialcare;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qapmsdk.common.util.ByteArrayPool;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class QvipSpecialSoundManagerImpl
  implements IQvipSpecialSoundManager
{
  private Context jdField_a_of_type_AndroidContentContext = VasUtil.a().getApplicationContext();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ByteArrayPool jdField_a_of_type_ComTencentQapmsdkCommonUtilByteArrayPool = new ByteArrayPool(4096);
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime = VasUtil.a();
  
  public QvipSpecialSoundManagerImpl()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext.getFilesDir().getCanonicalPath());
      ((StringBuilder)localObject).append("/");
      localObject = ((StringBuilder)localObject).toString();
      ThreadManager.getFileThreadHandler().post(new MoveConfig((String)localObject));
      return;
    }
    catch (Exception localException) {}
  }
  
  private String a()
  {
    Object localObject = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "pddata/vas/special_remind/new_config.json");
    boolean bool = ((File)localObject).exists();
    int j = 1;
    int i = j;
    if (!bool)
    {
      try
      {
        DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getString("specialcare_config", ""), (File)localObject);
        localDownloadTask.a = 1;
        localDownloadTask.n = true;
        i = ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).specialSoundDownload(localDownloadTask);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        i = -1;
      }
      if (i == 0)
      {
        a(((File)localObject).length());
        i = j;
      }
      else
      {
        i = 0;
      }
    }
    if (i == 0)
    {
      b("downLoad Special Sound Config failed.");
      return "";
    }
    try
    {
      localObject = a((File)localObject);
      return localObject;
    }
    catch (Exception localException1)
    {
      b("decodeTextFile is exception.");
      localException1.printStackTrace();
      return "";
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      b("decodeTextFile is OutOfMemoryError.");
      localOutOfMemoryError.printStackTrace();
      return "";
    }
    catch (IOException localIOException)
    {
      b("decodeTextFile is IOException.");
      localIOException.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  private String a(File paramFile)
  {
    // Byte code:
    //   0: new 187	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 190	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 192	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 193	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_3
    //   17: aload_0
    //   18: getfield 24	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManagerImpl:jdField_a_of_type_ComTencentQapmsdkCommonUtilByteArrayPool	Lcom/tencent/qapmsdk/common/util/ByteArrayPool;
    //   21: sipush 4096
    //   24: invokevirtual 197	com/tencent/qapmsdk/common/util/ByteArrayPool:getBuf	(I)[B
    //   27: astore 4
    //   29: aload_1
    //   30: aload 4
    //   32: iconst_0
    //   33: sipush 4096
    //   36: invokevirtual 203	java/io/InputStream:read	([BII)I
    //   39: istore_2
    //   40: iload_2
    //   41: iconst_m1
    //   42: if_icmpeq +14 -> 56
    //   45: aload_3
    //   46: aload 4
    //   48: iconst_0
    //   49: iload_2
    //   50: invokevirtual 207	java/io/ByteArrayOutputStream:write	([BII)V
    //   53: goto -24 -> 29
    //   56: new 209	java/lang/String
    //   59: dup
    //   60: aload_3
    //   61: invokevirtual 213	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   64: ldc 215
    //   66: invokespecial 218	java/lang/String:<init>	([BLjava/lang/String;)V
    //   69: astore 5
    //   71: aload_1
    //   72: invokevirtual 221	java/io/InputStream:close	()V
    //   75: aload_3
    //   76: invokevirtual 222	java/io/ByteArrayOutputStream:close	()V
    //   79: aload_0
    //   80: getfield 24	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManagerImpl:jdField_a_of_type_ComTencentQapmsdkCommonUtilByteArrayPool	Lcom/tencent/qapmsdk/common/util/ByteArrayPool;
    //   83: aload 4
    //   85: invokevirtual 226	com/tencent/qapmsdk/common/util/ByteArrayPool:returnBuf	([B)V
    //   88: aload 5
    //   90: areturn
    //   91: astore 5
    //   93: goto +44 -> 137
    //   96: astore 5
    //   98: aload 5
    //   100: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   103: aload_1
    //   104: invokevirtual 221	java/io/InputStream:close	()V
    //   107: goto +14 -> 121
    //   110: astore 5
    //   112: aload 5
    //   114: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   117: aload_1
    //   118: invokevirtual 221	java/io/InputStream:close	()V
    //   121: aload_3
    //   122: invokevirtual 222	java/io/ByteArrayOutputStream:close	()V
    //   125: aload_0
    //   126: getfield 24	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManagerImpl:jdField_a_of_type_ComTencentQapmsdkCommonUtilByteArrayPool	Lcom/tencent/qapmsdk/common/util/ByteArrayPool;
    //   129: aload 4
    //   131: invokevirtual 226	com/tencent/qapmsdk/common/util/ByteArrayPool:returnBuf	([B)V
    //   134: ldc 126
    //   136: areturn
    //   137: aload_1
    //   138: invokevirtual 221	java/io/InputStream:close	()V
    //   141: aload_3
    //   142: invokevirtual 222	java/io/ByteArrayOutputStream:close	()V
    //   145: aload_0
    //   146: getfield 24	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManagerImpl:jdField_a_of_type_ComTencentQapmsdkCommonUtilByteArrayPool	Lcom/tencent/qapmsdk/common/util/ByteArrayPool;
    //   149: aload 4
    //   151: invokevirtual 226	com/tencent/qapmsdk/common/util/ByteArrayPool:returnBuf	([B)V
    //   154: aload 5
    //   156: athrow
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 227	java/io/FileNotFoundException:printStackTrace	()V
    //   162: ldc 126
    //   164: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	QvipSpecialSoundManagerImpl
    //   0	165	1	paramFile	File
    //   39	11	2	i	int
    //   16	126	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   27	123	4	arrayOfByte	byte[]
    //   69	20	5	str	String
    //   91	1	5	localObject	Object
    //   96	3	5	localException	Exception
    //   110	45	5	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   29	40	91	finally
    //   45	53	91	finally
    //   56	71	91	finally
    //   98	103	91	finally
    //   112	117	91	finally
    //   29	40	96	java/lang/Exception
    //   45	53	96	java/lang/Exception
    //   56	71	96	java/lang/Exception
    //   29	40	110	java/io/IOException
    //   45	53	110	java/io/IOException
    //   56	71	110	java/io/IOException
    //   0	9	157	java/io/FileNotFoundException
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    if (((SharedPreferences)localObject).contains("defaulut_special_sound_source1")) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("defaulut_special_sound_source1", 2131230766);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  private void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportFlowData is Empty flowSize = ");
      localStringBuilder.append(paramLong);
      b(localStringBuilder.toString());
      return;
    }
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      b("reportFlowData int wifi state");
    } else {
      b("reportFlowData int 2G/3G state");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendAppDataIncerment flowSize = ");
    localStringBuilder.append(paramLong);
    b(localStringBuilder.toString());
  }
  
  private void a(CallBack paramCallBack, boolean paramBoolean)
  {
    if (paramCallBack == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new QvipSpecialSoundManagerImpl.3(this, paramCallBack, paramBoolean));
  }
  
  private void a(String paramString)
  {
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
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
  
  private void a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ((!TextUtils.isEmpty(paramString1)) && (paramString2 != null))
        {
          if (TextUtils.isEmpty(paramString2)) {
            return;
          }
          paramString2 = QvipSpecialSoundConfig.a(new JSONObject(paramString2));
          Object localObject = QvipSpecialSoundConfig.a(new JSONObject(paramString1));
          paramString1 = paramString2.a;
          paramString2 = ((QvipSpecialSoundConfig)localObject).a;
          if ((paramString1 != null) && (paramString2 != null) && (!paramString1.isEmpty()) && (!paramString2.isEmpty()) && (paramString1.size() >= paramString2.size()))
          {
            int j = paramString2.size();
            i = 0;
            if (i < j)
            {
              localObject = (QvipSpecialSoundConfig.SpecialSound)paramString1.get(i);
              QvipSpecialSoundConfig.SpecialSound localSpecialSound = (QvipSpecialSoundConfig.SpecialSound)paramString2.get(i);
              if ((((QvipSpecialSoundConfig.SpecialSound)localObject).jdField_a_of_type_Int != localSpecialSound.jdField_a_of_type_Int) || (((QvipSpecialSoundConfig.SpecialSound)localObject).jdField_b_of_type_JavaLangString.equals(localSpecialSound.jdField_b_of_type_JavaLangString))) {
                break label212;
              }
              ThreadManager.post(new QvipSpecialSoundManagerImpl.1(this, (QvipSpecialSoundConfig.SpecialSound)localObject), 5, null, true);
              break label212;
            }
          }
          else
          {
            b("updateSpecialSound return.");
            return;
          }
        }
      }
      catch (Exception paramString1)
      {
        b("updateSpecialSound exception");
        paramString1.printStackTrace();
      }
      return;
      label212:
      i += 1;
    }
  }
  
  private void a(List<QvipSpecialSoundConfig.SpecialSound> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int j = paramList.size();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_MqqAppAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
      int i = 0;
      while (i < j)
      {
        QvipSpecialSoundConfig.SpecialSound localSpecialSound = (QvipSpecialSoundConfig.SpecialSound)paramList.get(i);
        if (!QvipSpecialConstants.b.containsKey(String.valueOf(localSpecialSound.jdField_a_of_type_Int))) {
          QvipSpecialConstants.b.put(String.valueOf(localSpecialSound.jdField_a_of_type_Int), localSpecialSound);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("special_sound_url");
        localStringBuilder.append(localSpecialSound.jdField_a_of_type_Int);
        localEditor.putString(localStringBuilder.toString(), localSpecialSound.jdField_c_of_type_JavaLangString);
        if (!b(localSpecialSound.d)) {
          b("is white list.");
        } else if (localSpecialSound.jdField_c_of_type_Int == 1) {
          if (localSpecialSound.jdField_b_of_type_Int == 1) {
            ((List)localObject1).add(localSpecialSound);
          } else if (localSpecialSound.jdField_b_of_type_Int == 2) {
            ((List)localObject2).add(localSpecialSound);
          } else {
            localArrayList.add(localSpecialSound);
          }
        }
        i += 1;
      }
      localEditor.commit();
      paramList.clear();
      paramList.addAll((Collection)localObject1);
      paramList.addAll((Collection)localObject2);
      paramList.addAll(localArrayList);
      localObject1 = QvipSpecialConstants.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("key_special_sound_list");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      if (!((HashMap)localObject1).containsKey(((StringBuilder)localObject2).toString()))
      {
        localObject1 = QvipSpecialConstants.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("key_special_sound_list");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramList);
      }
      return;
    }
    b("SpecialSoundList is empty, donot need sort.");
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), paramString);
      int i = -1;
      try
      {
        paramString = new DownloadTask(MsfSdkUtils.insertMtype("lingyin", paramString), localFile);
        paramString.a = 1;
        int j = ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).specialSoundDownload(paramString);
        i = j;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QvipSpecialSoundManager", 2, paramString);
    }
  }
  
  private boolean b(String paramString)
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return true;
      }
      if (paramString.contains("|")) {
        try
        {
          String[] arrayOfString = paramString.split("\\|");
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = arrayOfString[i].trim().equals(str);
            if (bool) {
              return true;
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
    return true;
  }
  
  public String getSoundName(int paramInt)
  {
    if ((QvipSpecialConstants.b != null) && (!QvipSpecialConstants.b.isEmpty()))
    {
      QvipSpecialSoundConfig.SpecialSound localSpecialSound = (QvipSpecialSoundConfig.SpecialSound)QvipSpecialConstants.b.get(String.valueOf(paramInt));
      if (localSpecialSound != null) {
        return localSpecialSound.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  public boolean isCacheData()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_special_sound_list");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
    localObject = ((StringBuilder)localObject).toString();
    return QvipSpecialConstants.a.containsKey(localObject);
  }
  
  public void loadSpecialSoundConfig(CallBack paramCallBack)
  {
    ThreadManager.post(new QvipSpecialSoundManagerImpl.2(this, paramCallBack), 5, null, true);
  }
  
  public void onSpecialSoundConfigDownloaded(int paramInt, File paramFile, String paramString)
  {
    if (paramFile == null)
    {
      QLog.e("QvipSpecialSoundManager", 1, "onSpecialSoundConfigDownloaded specialSoundPath == null");
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("QvipSpecialSoundManager", 2, "download SpecialSound Success");
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = a(paramFile);
        if (!paramFile.exists()) {
          break label155;
        }
        l = paramFile.length();
        a(l);
      }
      catch (OutOfMemoryError paramFile)
      {
        b("decodeTextFile is OutOfMemoryError.");
        paramFile.printStackTrace();
        localObject1 = localObject2;
      }
      catch (Exception paramFile)
      {
        b("decodeTextFile is exception.");
        paramFile.printStackTrace();
        localObject1 = localObject2;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        b("new Config is Empty");
        return;
      }
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(localObject1)))
      {
        b("Config is Same");
        return;
      }
      a(paramString, (String)localObject1);
      return;
      label155:
      long l = 0L;
    }
  }
  
  public void parseSpecialSoundConfigFile()
  {
    a();
    a(a());
  }
  
  public void updateSpecialSoundConfig()
  {
    Object localObject4 = this.jdField_a_of_type_MqqAppAppRuntime.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "pddata/vas/special_remind/new_config.json");
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject5;
    Object localObject2;
    try
    {
      if (localFile.exists()) {
        localObject1 = a(localFile);
      }
    }
    catch (Exception localException1)
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("download error:");
      ((StringBuilder)localObject5).append(localException1.toString());
      b(((StringBuilder)localObject5).toString());
      localException1.printStackTrace();
      localObject2 = localObject3;
    }
    try
    {
      localObject3 = ((SharedPreferences)localObject4).getString("specialcare_config", "");
      localObject5 = new DownloadTask((String)localObject3, localFile);
      ((DownloadTask)localObject5).a = 1;
      ((DownloadTask)localObject5).n = true;
      ((DownloadTask)localObject5).e = 20000;
      localObject4 = (IVasDepTemp)QRoute.api(IVasDepTemp.class);
      if (((IVasDepTemp)localObject4).isEnable())
      {
        localObject2 = new SyncDownloadRunnable((DownloadTask)localObject5, localFile, (String)localObject2, this);
        ((IVasDepTemp)localObject4).requestPreDownload(localFile, (String)localObject3, 10021, "vas", 2, 0, new RunnableTask((BaseQQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "vas_special_remind", (Runnable)localObject2, 4000L));
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[preDownload] path=");
          ((StringBuilder)localObject2).append(localFile.getCanonicalPath());
          ((StringBuilder)localObject2).append(" url=");
          ((StringBuilder)localObject2).append((String)localObject3);
          QLog.d("QvipSpecialSoundManager", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        onSpecialSoundConfigDownloaded(((IVasDepTemp)QRoute.api(IVasDepTemp.class)).specialSoundDownload((DownloadTask)localObject5), localFile, (String)localObject2);
        return;
      }
    }
    catch (Exception localException2)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("download error:");
      ((StringBuilder)localObject3).append(localException2.toString());
      b(((StringBuilder)localObject3).toString());
      localException2.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManagerImpl
 * JD-Core Version:    0.7.0.1
 */