package com.tencent.aelight.camera.aeeditor.manage;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.util.AEDownloader;
import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AEEditorResourceDownloader
{
  protected final int a;
  @NonNull
  protected final String a;
  @NonNull
  protected final Map<String, AEEditorDownloadResBean> a;
  protected volatile boolean a;
  @NonNull
  protected final String b;
  @NonNull
  protected final Map<String, AtomicBoolean> b;
  protected volatile boolean b;
  @NonNull
  protected final String c;
  @NonNull
  protected final Map<String, List<AEEditorResourceDownloader.ResDownLoadListener>> c;
  
  protected AEEditorResourceDownloader(@NonNull String paramString1, @NonNull String paramString2, int paramInt, @NonNull String paramString3)
  {
    this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    paramString1 = new StringBuilder();
    paramString1.append("[AEEditor2]");
    paramString1.append(paramString3);
    this.jdField_c_of_type_JavaLangString = paramString1.toString();
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = new File(paramString1);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      Object localObject2 = ((File)localObject1).listFiles();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          localObject1 = localObject2[i];
          if (((File)localObject1).getName().replaceAll("\\p{C}", "").equals(paramString2))
          {
            paramString2 = this.jdField_c_of_type_JavaLangString;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("begin rename zip folder---from: ");
            ((StringBuilder)localObject2).append(((File)localObject1).getName());
            ((StringBuilder)localObject2).append(", to: ");
            ((StringBuilder)localObject2).append(paramString3);
            AEQLog.b(paramString2, ((StringBuilder)localObject2).toString());
            paramString2 = new StringBuilder();
            paramString2.append(paramString1);
            paramString2.append(((File)localObject1).getName());
            paramString2 = paramString2.toString();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString1);
            ((StringBuilder)localObject1).append(paramString3);
            return FileUtils.rename(paramString2, ((StringBuilder)localObject1).toString());
          }
          i += 1;
        }
        paramString1 = this.jdField_c_of_type_JavaLangString;
        paramString3 = new StringBuilder();
        paramString3.append("reNameFile--NOT found folder named ");
        paramString3.append(paramString2);
        AEQLog.d(paramString1, paramString3.toString());
        return false;
      }
    }
    else
    {
      paramString1 = this.jdField_c_of_type_JavaLangString;
      paramString2 = new StringBuilder();
      paramString2.append("reNameFile--toDir not exists or not a directory: ");
      paramString2.append(localObject1);
      AEQLog.d(paramString1, paramString2.toString());
    }
    return false;
  }
  
  private boolean c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      ZipUtils.unZipFile(new File(paramString1), paramString2);
      boolean bool = a(paramString2, paramString3, paramString4);
      return bool;
    }
    catch (Exception paramString1)
    {
      AEQLog.a(this.jdField_c_of_type_JavaLangString, "unZipHasPackage--exception ", paramString1);
    }
    return false;
  }
  
  @NonNull
  public String a(MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramMetaMaterial.id);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramMetaMaterial.packageMd5);
    return localStringBuilder.toString();
  }
  
  @NonNull
  public String a(AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramAEEditorDownloadResBean.getId());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramAEEditorDownloadResBean.getMd5());
    return localStringBuilder.toString();
  }
  
  /* Error */
  @WorkerThread
  protected String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 168	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 174	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   10: aload_1
    //   11: invokevirtual 180	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore 4
    //   16: aload 4
    //   18: astore_2
    //   19: aload 4
    //   21: astore_3
    //   22: aload 4
    //   24: invokestatic 185	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   27: astore 5
    //   29: aload 5
    //   31: astore_1
    //   32: aload 4
    //   34: ifnull +103 -> 137
    //   37: aload 4
    //   39: invokevirtual 190	java/io/InputStream:close	()V
    //   42: aload 5
    //   44: areturn
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   50: aload 5
    //   52: areturn
    //   53: astore_1
    //   54: goto +85 -> 139
    //   57: astore 4
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 57	com/tencent/aelight/camera/aeeditor/manage/AEEditorResourceDownloader:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   65: astore 5
    //   67: aload_3
    //   68: astore_2
    //   69: new 44	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   76: astore 6
    //   78: aload_3
    //   79: astore_2
    //   80: aload 6
    //   82: ldc 195
    //   84: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_3
    //   89: astore_2
    //   90: aload 6
    //   92: aload_1
    //   93: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_3
    //   98: astore_2
    //   99: aload 5
    //   101: aload 6
    //   103: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aload 4
    //   108: invokestatic 134	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_3
    //   112: astore_2
    //   113: aload 4
    //   115: invokevirtual 196	java/lang/Throwable:printStackTrace	()V
    //   118: aload_3
    //   119: ifnull +15 -> 134
    //   122: aload_3
    //   123: invokevirtual 190	java/io/InputStream:close	()V
    //   126: goto +8 -> 134
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   134: ldc 83
    //   136: astore_1
    //   137: aload_1
    //   138: areturn
    //   139: aload_2
    //   140: ifnull +15 -> 155
    //   143: aload_2
    //   144: invokevirtual 190	java/io/InputStream:close	()V
    //   147: goto +8 -> 155
    //   150: astore_2
    //   151: aload_2
    //   152: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   155: aload_1
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	AEEditorResourceDownloader
    //   0	157	1	paramString	String
    //   3	141	2	localObject1	Object
    //   150	2	2	localIOException	IOException
    //   1	122	3	localObject2	Object
    //   14	24	4	localInputStream	java.io.InputStream
    //   57	57	4	localThrowable	java.lang.Throwable
    //   27	73	5	str	String
    //   76	26	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	42	45	java/io/IOException
    //   4	16	53	finally
    //   22	29	53	finally
    //   61	67	53	finally
    //   69	78	53	finally
    //   80	88	53	finally
    //   90	97	53	finally
    //   99	111	53	finally
    //   113	118	53	finally
    //   4	16	57	java/lang/Throwable
    //   22	29	57	java/lang/Throwable
    //   122	126	129	java/io/IOException
    //   143	147	150	java/io/IOException
  }
  
  @WorkerThread
  protected void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      AEQLog.b(this.jdField_c_of_type_JavaLangString, "ensureSetupDownloadConfig--BEGIN");
      Object localObject1 = a(this.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AEQLog.d(this.jdField_c_of_type_JavaLangString, "ensureSetupDownloadConfig---read assets json content empty");
        return;
      }
      Object localObject3 = (List)GsonUtils.json2Obj((String)localObject1, new AEEditorResourceDownloader.1(this).getType());
      String str = this.jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ensureSetupDownloadConfig---size = ");
      if (localObject3 == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.valueOf(((List)localObject3).size());
      }
      localStringBuilder.append(localObject1);
      AEQLog.b(str, localStringBuilder.toString());
      if (localObject3 != null)
      {
        localObject1 = ((List)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (AEEditorDownloadResBean)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilMap.put(((AEEditorDownloadResBean)localObject3).getId(), localObject3);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(@NonNull MetaMaterial paramMetaMaterial, AEEditorResourceDownloader.ResDownLoadListener paramResDownLoadListener)
  {
    ??? = this.jdField_c_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("downLoadOneResInternal---BEGIN: id=");
    ((StringBuilder)localObject2).append(paramMetaMaterial.id);
    AEQLog.b((String)???, ((StringBuilder)localObject2).toString());
    String str = paramMetaMaterial.packageMd5;
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      if ((AtomicBoolean)this.jdField_b_of_type_JavaUtilMap.get(str) == null) {
        this.jdField_b_of_type_JavaUtilMap.put(str, new AtomicBoolean(false));
      }
      AtomicBoolean localAtomicBoolean = (AtomicBoolean)this.jdField_b_of_type_JavaUtilMap.get(str);
      try
      {
        if (localAtomicBoolean.get())
        {
          localObject2 = (List)this.jdField_c_of_type_JavaUtilMap.get(str);
          ??? = localObject2;
          if (localObject2 == null)
          {
            ??? = new ArrayList();
            this.jdField_c_of_type_JavaUtilMap.put(str, ???);
          }
          if (paramResDownLoadListener != null) {
            ((List)???).add(paramResDownLoadListener);
          }
          paramResDownLoadListener = this.jdField_c_of_type_JavaLangString;
          ??? = new StringBuilder();
          ((StringBuilder)???).append("downLoadOneResInternal---is DOWNLOADING: id=");
          ((StringBuilder)???).append(paramMetaMaterial.id);
          AEQLog.b(paramResDownLoadListener, ((StringBuilder)???).toString());
          return;
        }
        localAtomicBoolean.compareAndSet(false, true);
        if (a(paramMetaMaterial))
        {
          if (paramResDownLoadListener != null) {
            paramResDownLoadListener.a(true);
          }
          a(str, true);
          paramResDownLoadListener = this.jdField_c_of_type_JavaLangString;
          ??? = new StringBuilder();
          ((StringBuilder)???).append("downLoadOneResInternal---is DOWNLOADED by other: id=");
          ((StringBuilder)???).append(paramMetaMaterial.id);
          AEQLog.b(paramResDownLoadListener, ((StringBuilder)???).toString());
          return;
        }
        ??? = new StringBuilder();
        ((StringBuilder)???).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)???).append(File.separator);
        ((StringBuilder)???).append(paramMetaMaterial.id);
        ((StringBuilder)???).append(File.separator);
        ??? = ((StringBuilder)???).toString();
        FileUtils.deleteDirectory((String)???);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)???);
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(".zip");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (paramResDownLoadListener != null) {
          paramResDownLoadListener.a(0);
        }
        AEDownloader.a().a(paramMetaMaterial.packageUrl, (String)localObject2, new AEEditorResourceDownloader.5(this, paramResDownLoadListener, str, paramMetaMaterial, (String)localObject2, (String)???));
        return;
      }
      finally {}
    }
  }
  
  public void a(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, AEEditorResourceDownloader.ResDownLoadListener paramResDownLoadListener)
  {
    ??? = this.jdField_c_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("downLoadOneResInternal---BEGIN: id=");
    ((StringBuilder)localObject2).append(paramAEEditorDownloadResBean.getId());
    AEQLog.b((String)???, ((StringBuilder)localObject2).toString());
    String str = paramAEEditorDownloadResBean.getMd5();
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      if ((AtomicBoolean)this.jdField_b_of_type_JavaUtilMap.get(str) == null) {
        this.jdField_b_of_type_JavaUtilMap.put(str, new AtomicBoolean(false));
      }
      AtomicBoolean localAtomicBoolean = (AtomicBoolean)this.jdField_b_of_type_JavaUtilMap.get(str);
      try
      {
        if (localAtomicBoolean.get())
        {
          localObject2 = (List)this.jdField_c_of_type_JavaUtilMap.get(str);
          ??? = localObject2;
          if (localObject2 == null)
          {
            ??? = new ArrayList();
            this.jdField_c_of_type_JavaUtilMap.put(str, ???);
          }
          if (paramResDownLoadListener != null) {
            ((List)???).add(paramResDownLoadListener);
          }
          paramResDownLoadListener = this.jdField_c_of_type_JavaLangString;
          ??? = new StringBuilder();
          ((StringBuilder)???).append("downLoadOneResInternal---is DOWNLOADING: id=");
          ((StringBuilder)???).append(paramAEEditorDownloadResBean.getId());
          AEQLog.b(paramResDownLoadListener, ((StringBuilder)???).toString());
          return;
        }
        localAtomicBoolean.compareAndSet(false, true);
        if (a(paramAEEditorDownloadResBean))
        {
          if (paramResDownLoadListener != null) {
            paramResDownLoadListener.a(true);
          }
          a(str, true);
          paramResDownLoadListener = this.jdField_c_of_type_JavaLangString;
          ??? = new StringBuilder();
          ((StringBuilder)???).append("downLoadOneResInternal---is DOWNLOADED by other: id=");
          ((StringBuilder)???).append(paramAEEditorDownloadResBean.getId());
          AEQLog.b(paramResDownLoadListener, ((StringBuilder)???).toString());
          return;
        }
        ??? = new StringBuilder();
        ((StringBuilder)???).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)???).append(File.separator);
        ((StringBuilder)???).append(paramAEEditorDownloadResBean.getId());
        ((StringBuilder)???).append(File.separator);
        ??? = ((StringBuilder)???).toString();
        FileUtils.deleteDirectory((String)???);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)???);
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(".zip");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (paramResDownLoadListener != null) {
          paramResDownLoadListener.a(0);
        }
        AEDownloader.a().a(paramAEEditorDownloadResBean.getUrl(), (String)localObject2, new AEEditorResourceDownloader.4(this, paramResDownLoadListener, str, paramAEEditorDownloadResBean, (String)localObject2, (String)???));
        return;
      }
      finally {}
    }
  }
  
  public void a(String paramString, AEEditorResourceDownloader.ResDownLoadListener paramResDownLoadListener)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramResDownLoadListener != null) {
        paramResDownLoadListener.a(false);
      }
      return;
    }
    ThreadManager.excute(new AEEditorResourceDownloader.3(this, paramString, paramResDownLoadListener), 128, null, false);
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    AtomicBoolean localAtomicBoolean = (AtomicBoolean)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (localAtomicBoolean == null) {
      return;
    }
    try
    {
      localAtomicBoolean.compareAndSet(true, false);
      paramString = (List)this.jdField_c_of_type_JavaUtilMap.get(paramString);
      if (paramString != null)
      {
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          AEEditorResourceDownloader.ResDownLoadListener localResDownLoadListener = (AEEditorResourceDownloader.ResDownLoadListener)localIterator.next();
          if (localResDownLoadListener != null) {
            localResDownLoadListener.a(paramBoolean);
          }
        }
        paramString.clear();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  protected abstract void a(@NonNull List<AEEditorDownloadResBean> paramList);
  
  protected abstract void a(boolean paramBoolean, int paramInt, long paramLong, String paramString);
  
  public boolean a(@NonNull MetaMaterial paramMetaMaterial)
  {
    return new File(a(paramMetaMaterial)).exists();
  }
  
  public boolean a(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    return new File(a(paramAEEditorDownloadResBean)).exists();
  }
  
  protected boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (c(paramString1, paramString2, paramString3, paramString4)) {
      return true;
    }
    return b(paramString1, paramString2, paramString3, paramString4);
  }
  
  /* Error */
  @WorkerThread
  protected String b(@NonNull String paramString)
  {
    // Byte code:
    //   0: new 62	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 69	java/io/File:exists	()Z
    //   15: istore_2
    //   16: ldc 83
    //   18: astore 6
    //   20: iload_2
    //   21: ifne +6 -> 27
    //   24: ldc 83
    //   26: areturn
    //   27: aconst_null
    //   28: astore 5
    //   30: aconst_null
    //   31: astore_3
    //   32: new 359	java/io/FileInputStream
    //   35: dup
    //   36: aload 4
    //   38: invokespecial 362	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokestatic 185	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: astore_1
    //   51: aload 4
    //   53: invokevirtual 190	java/io/InputStream:close	()V
    //   56: aload_3
    //   57: areturn
    //   58: astore_3
    //   59: aload_3
    //   60: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   63: aload_1
    //   64: areturn
    //   65: astore_1
    //   66: aload 4
    //   68: astore_3
    //   69: goto +102 -> 171
    //   72: astore 5
    //   74: goto +15 -> 89
    //   77: astore_1
    //   78: goto +93 -> 171
    //   81: astore_3
    //   82: aload 5
    //   84: astore 4
    //   86: aload_3
    //   87: astore 5
    //   89: aload 4
    //   91: astore_3
    //   92: aload_0
    //   93: getfield 57	com/tencent/aelight/camera/aeeditor/manage/AEEditorResourceDownloader:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   96: astore 7
    //   98: aload 4
    //   100: astore_3
    //   101: new 44	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   108: astore 8
    //   110: aload 4
    //   112: astore_3
    //   113: aload 8
    //   115: ldc_w 364
    //   118: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 4
    //   124: astore_3
    //   125: aload 8
    //   127: aload_1
    //   128: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 4
    //   134: astore_3
    //   135: aload 7
    //   137: aload 8
    //   139: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: aload 5
    //   144: invokestatic 134	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   147: aload 4
    //   149: astore_3
    //   150: aload 5
    //   152: invokevirtual 196	java/lang/Throwable:printStackTrace	()V
    //   155: aload 4
    //   157: ifnull +11 -> 168
    //   160: aload 6
    //   162: astore_1
    //   163: aload 4
    //   165: invokevirtual 190	java/io/InputStream:close	()V
    //   168: ldc 83
    //   170: areturn
    //   171: aload_3
    //   172: ifnull +15 -> 187
    //   175: aload_3
    //   176: invokevirtual 190	java/io/InputStream:close	()V
    //   179: goto +8 -> 187
    //   182: astore_3
    //   183: aload_3
    //   184: invokevirtual 193	java/io/IOException:printStackTrace	()V
    //   187: aload_1
    //   188: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	AEEditorResourceDownloader
    //   0	189	1	paramString	String
    //   15	6	2	bool	boolean
    //   31	26	3	str1	String
    //   58	2	3	localIOException1	IOException
    //   68	1	3	localObject1	Object
    //   81	6	3	localThrowable1	java.lang.Throwable
    //   91	85	3	localObject2	Object
    //   182	2	3	localIOException2	IOException
    //   8	156	4	localObject3	Object
    //   28	1	5	localObject4	Object
    //   72	11	5	localThrowable2	java.lang.Throwable
    //   87	64	5	localObject5	Object
    //   18	143	6	str2	String
    //   96	40	7	str3	String
    //   108	30	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   51	56	58	java/io/IOException
    //   163	168	58	java/io/IOException
    //   43	49	65	finally
    //   43	49	72	java/lang/Throwable
    //   32	43	77	finally
    //   92	98	77	finally
    //   101	110	77	finally
    //   113	122	77	finally
    //   125	132	77	finally
    //   135	147	77	finally
    //   150	155	77	finally
    //   32	43	81	java/lang/Throwable
    //   175	179	182	java/io/IOException
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    ThreadManager.excute(new AEEditorResourceDownloader.2(this), 128, null, false);
  }
  
  protected abstract void b(@NonNull List<AEEditorDownloadResBean> paramList);
  
  protected boolean b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(paramString3);
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    try
    {
      paramString1 = new File(paramString1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("/");
      ZipUtils.unZipFile(paramString1, ((StringBuilder)localObject).toString());
    }
    catch (IOException paramString1)
    {
      AEQLog.a(this.jdField_c_of_type_JavaLangString, "unZipNoPackage-- exception ", paramString1);
    }
    paramString1 = this.jdField_c_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unZipNoPackage-- zipPath: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(paramString3);
    AEQLog.d(paramString1, ((StringBuilder)localObject).toString());
    return a(paramString2, paramString3, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader
 * JD-Core Version:    0.7.0.1
 */