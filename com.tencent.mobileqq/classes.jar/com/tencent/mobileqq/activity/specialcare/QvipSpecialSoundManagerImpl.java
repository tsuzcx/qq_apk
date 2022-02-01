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
  private Context a = VasUtil.c().getApplicationContext();
  private ByteArrayPool b = new ByteArrayPool(4096);
  private AppRuntime c = VasUtil.c();
  private Handler d = new Handler(Looper.getMainLooper());
  
  public QvipSpecialSoundManagerImpl()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.getFilesDir().getCanonicalPath());
      ((StringBuilder)localObject).append("/");
      localObject = ((StringBuilder)localObject).toString();
      ThreadManager.getFileThreadHandler().post(new MoveConfig((String)localObject));
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportFlowData is Empty flowSize = ");
      localStringBuilder.append(paramLong);
      d(localStringBuilder.toString());
      return;
    }
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      d("reportFlowData int wifi state");
    } else {
      d("reportFlowData int 2G/3G state");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendAppDataIncerment flowSize = ");
    localStringBuilder.append(paramLong);
    d(localStringBuilder.toString());
  }
  
  private void a(CallBack paramCallBack, boolean paramBoolean)
  {
    if (paramCallBack == null) {
      return;
    }
    this.d.post(new QvipSpecialSoundManagerImpl.3(this, paramCallBack, paramBoolean));
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
  
  private void b()
  {
    Object localObject = this.c.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    if (((SharedPreferences)localObject).contains("defaulut_special_sound_source1")) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("defaulut_special_sound_source1", 2131230836);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  private boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      File localFile = new File(this.a.getFilesDir(), paramString);
      int i = -1;
      try
      {
        paramString = new DownloadTask(MsfSdkUtils.insertMtype("lingyin", paramString), localFile);
        paramString.O = 1;
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
  
  private boolean c(String paramString)
  {
    String str = this.c.getCurrentAccountUin();
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
  
  private void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QvipSpecialSoundManager", 2, paramString);
    }
  }
  
  public String a()
  {
    Object localObject = new File(this.a.getFilesDir(), "pddata/vas/special_remind/new_config.json");
    boolean bool = ((File)localObject).exists();
    int j = 1;
    int i = j;
    if (!bool)
    {
      try
      {
        DownloadTask localDownloadTask = new DownloadTask(this.c.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getString("specialcare_config", ""), (File)localObject);
        localDownloadTask.O = 1;
        localDownloadTask.J = true;
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
      d("downLoad Special Sound Config failed.");
      return "";
    }
    try
    {
      localObject = a((File)localObject);
      return localObject;
    }
    catch (Exception localException1)
    {
      d("decodeTextFile is exception.");
      localException1.printStackTrace();
      return "";
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      d("decodeTextFile is OutOfMemoryError.");
      localOutOfMemoryError.printStackTrace();
      return "";
    }
    catch (IOException localIOException)
    {
      d("decodeTextFile is IOException.");
      localIOException.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public String a(File paramFile)
  {
    // Byte code:
    //   0: new 307	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 312	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 313	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_3
    //   17: aload_0
    //   18: getfield 27	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManagerImpl:b	Lcom/tencent/qapmsdk/common/util/ByteArrayPool;
    //   21: sipush 4096
    //   24: invokevirtual 317	com/tencent/qapmsdk/common/util/ByteArrayPool:getBuf	(I)[B
    //   27: astore 4
    //   29: aload_1
    //   30: aload 4
    //   32: iconst_0
    //   33: sipush 4096
    //   36: invokevirtual 323	java/io/InputStream:read	([BII)I
    //   39: istore_2
    //   40: iload_2
    //   41: iconst_m1
    //   42: if_icmpeq +14 -> 56
    //   45: aload_3
    //   46: aload 4
    //   48: iconst_0
    //   49: iload_2
    //   50: invokevirtual 327	java/io/ByteArrayOutputStream:write	([BII)V
    //   53: goto -24 -> 29
    //   56: new 240	java/lang/String
    //   59: dup
    //   60: aload_3
    //   61: invokevirtual 331	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   64: ldc_w 333
    //   67: invokespecial 336	java/lang/String:<init>	([BLjava/lang/String;)V
    //   70: astore 5
    //   72: aload_1
    //   73: invokevirtual 339	java/io/InputStream:close	()V
    //   76: aload_3
    //   77: invokevirtual 340	java/io/ByteArrayOutputStream:close	()V
    //   80: aload_0
    //   81: getfield 27	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManagerImpl:b	Lcom/tencent/qapmsdk/common/util/ByteArrayPool;
    //   84: aload 4
    //   86: invokevirtual 344	com/tencent/qapmsdk/common/util/ByteArrayPool:returnBuf	([B)V
    //   89: aload 5
    //   91: areturn
    //   92: astore 5
    //   94: goto +45 -> 139
    //   97: astore 5
    //   99: aload 5
    //   101: invokevirtual 231	java/lang/Exception:printStackTrace	()V
    //   104: aload_1
    //   105: invokevirtual 339	java/io/InputStream:close	()V
    //   108: goto +14 -> 122
    //   111: astore 5
    //   113: aload 5
    //   115: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   118: aload_1
    //   119: invokevirtual 339	java/io/InputStream:close	()V
    //   122: aload_3
    //   123: invokevirtual 340	java/io/ByteArrayOutputStream:close	()V
    //   126: aload_0
    //   127: getfield 27	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManagerImpl:b	Lcom/tencent/qapmsdk/common/util/ByteArrayPool;
    //   130: aload 4
    //   132: invokevirtual 344	com/tencent/qapmsdk/common/util/ByteArrayPool:returnBuf	([B)V
    //   135: ldc_w 279
    //   138: areturn
    //   139: aload_1
    //   140: invokevirtual 339	java/io/InputStream:close	()V
    //   143: aload_3
    //   144: invokevirtual 340	java/io/ByteArrayOutputStream:close	()V
    //   147: aload_0
    //   148: getfield 27	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManagerImpl:b	Lcom/tencent/qapmsdk/common/util/ByteArrayPool;
    //   151: aload 4
    //   153: invokevirtual 344	com/tencent/qapmsdk/common/util/ByteArrayPool:returnBuf	([B)V
    //   156: aload 5
    //   158: athrow
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 345	java/io/FileNotFoundException:printStackTrace	()V
    //   164: ldc_w 279
    //   167: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	QvipSpecialSoundManagerImpl
    //   0	168	1	paramFile	File
    //   39	11	2	i	int
    //   16	128	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   27	125	4	arrayOfByte	byte[]
    //   70	20	5	str	String
    //   92	1	5	localObject	Object
    //   97	3	5	localException	Exception
    //   111	46	5	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   29	40	92	finally
    //   45	53	92	finally
    //   56	72	92	finally
    //   99	104	92	finally
    //   113	118	92	finally
    //   29	40	97	java/lang/Exception
    //   45	53	97	java/lang/Exception
    //   56	72	97	java/lang/Exception
    //   29	40	111	java/io/IOException
    //   45	53	111	java/io/IOException
    //   56	72	111	java/io/IOException
    //   0	9	159	java/io/FileNotFoundException
  }
  
  public void a(String paramString1, String paramString2)
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
              if ((((QvipSpecialSoundConfig.SpecialSound)localObject).a != localSpecialSound.a) || (((QvipSpecialSoundConfig.SpecialSound)localObject).d.equals(localSpecialSound.d))) {
                break label212;
              }
              ThreadManager.post(new QvipSpecialSoundManagerImpl.1(this, (QvipSpecialSoundConfig.SpecialSound)localObject), 5, null, true);
              break label212;
            }
          }
          else
          {
            d("updateSpecialSound return.");
            return;
          }
        }
      }
      catch (Exception paramString1)
      {
        d("updateSpecialSound exception");
        paramString1.printStackTrace();
      }
      return;
      label212:
      i += 1;
    }
  }
  
  public void a(List<QvipSpecialSoundConfig.SpecialSound> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int j = paramList.size();
      SharedPreferences.Editor localEditor = this.c.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
      int i = 0;
      while (i < j)
      {
        QvipSpecialSoundConfig.SpecialSound localSpecialSound = (QvipSpecialSoundConfig.SpecialSound)paramList.get(i);
        if (!QvipSpecialConstants.b.containsKey(String.valueOf(localSpecialSound.a))) {
          QvipSpecialConstants.b.put(String.valueOf(localSpecialSound.a), localSpecialSound);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("special_sound_url");
        localStringBuilder.append(localSpecialSound.a);
        localEditor.putString(localStringBuilder.toString(), localSpecialSound.e);
        if (!c(localSpecialSound.f)) {
          d("is white list.");
        } else if (localSpecialSound.g == 1) {
          if (localSpecialSound.c == 1) {
            ((List)localObject1).add(localSpecialSound);
          } else if (localSpecialSound.c == 2) {
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
      ((StringBuilder)localObject2).append(this.c.getCurrentAccountUin());
      if (!((HashMap)localObject1).containsKey(((StringBuilder)localObject2).toString()))
      {
        localObject1 = QvipSpecialConstants.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("key_special_sound_list");
        ((StringBuilder)localObject2).append(this.c.getCurrentAccountUin());
        ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramList);
      }
      return;
    }
    d("SpecialSoundList is empty, donot need sort.");
  }
  
  public String getSoundName(int paramInt)
  {
    if ((QvipSpecialConstants.b != null) && (!QvipSpecialConstants.b.isEmpty()))
    {
      QvipSpecialSoundConfig.SpecialSound localSpecialSound = (QvipSpecialSoundConfig.SpecialSound)QvipSpecialConstants.b.get(String.valueOf(paramInt));
      if (localSpecialSound != null) {
        return localSpecialSound.b;
      }
    }
    return "";
  }
  
  public boolean isCacheData()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_special_sound_list");
    ((StringBuilder)localObject).append(this.c.getCurrentAccountUin());
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
          break label157;
        }
        l = paramFile.length();
        a(l);
      }
      catch (OutOfMemoryError paramFile)
      {
        d("decodeTextFile is OutOfMemoryError.");
        paramFile.printStackTrace();
        localObject1 = localObject2;
      }
      catch (Exception paramFile)
      {
        d("decodeTextFile is exception.");
        paramFile.printStackTrace();
        localObject1 = localObject2;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        d("new Config is Empty");
        return;
      }
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(localObject1)))
      {
        d("Config is Same");
        return;
      }
      a(paramString, (String)localObject1);
      return;
      label157:
      long l = 0L;
    }
  }
  
  public void parseSpecialSoundConfigFile()
  {
    b();
    a(a());
  }
  
  public void updateSpecialSoundConfig()
  {
    Object localObject4 = this.c.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    File localFile = new File(this.a.getFilesDir(), "pddata/vas/special_remind/new_config.json");
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
      d(((StringBuilder)localObject5).toString());
      localException1.printStackTrace();
      localObject2 = localObject3;
    }
    try
    {
      localObject3 = ((SharedPreferences)localObject4).getString("specialcare_config", "");
      localObject5 = new DownloadTask((String)localObject3, localFile);
      ((DownloadTask)localObject5).O = 1;
      ((DownloadTask)localObject5).J = true;
      ((DownloadTask)localObject5).v = 20000;
      localObject4 = (IVasDepTemp)QRoute.api(IVasDepTemp.class);
      if (((IVasDepTemp)localObject4).isEnable())
      {
        localObject2 = new SyncDownloadRunnable((DownloadTask)localObject5, localFile, (String)localObject2, this);
        ((IVasDepTemp)localObject4).requestPreDownload(localFile, (String)localObject3, 10021, "vas", 2, 0, new RunnableTask((BaseQQAppInterface)this.c, "vas_special_remind", (Runnable)localObject2, 4000L));
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
      d(((StringBuilder)localObject3).toString());
      localException2.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManagerImpl
 * JD-Core Version:    0.7.0.1
 */