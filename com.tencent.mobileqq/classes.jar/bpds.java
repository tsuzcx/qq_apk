import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.1;
import dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.3;
import dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.4;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class bpds
{
  public final int a;
  @NonNull
  protected final String a;
  @NonNull
  public final Map<String, AEEditorDownloadResBean> a;
  protected volatile boolean a;
  @NonNull
  public final String b;
  @NonNull
  protected final Map<String, AtomicBoolean> b;
  protected volatile boolean b;
  @NonNull
  public final String c;
  @NonNull
  protected final Map<String, List<bpdw>> c;
  
  protected bpds(@NonNull String paramString1, @NonNull String paramString2, int paramInt, @NonNull String paramString3)
  {
    this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  @NonNull
  protected String a(AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    return this.jdField_b_of_type_JavaLangString + File.separator + paramAEEditorDownloadResBean.getId() + File.separator + paramAEEditorDownloadResBean.getMd5();
  }
  
  @WorkerThread
  protected String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    String str1 = "";
    for (;;)
    {
      try
      {
        localInputStream = BaseApplicationImpl.getContext().getAssets().open(paramString);
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        String str2 = noe.a(localInputStream);
        paramString = str2;
        localObject2 = paramString;
      }
      catch (Throwable localThrowable)
      {
        InputStream localInputStream;
        localObject2 = localIOException1;
        bpam.a(this.jdField_c_of_type_JavaLangString, "readAssetsFileContent---read assets json exception: fileName=" + paramString, localThrowable);
        localObject2 = localIOException1;
        localThrowable.printStackTrace();
        localObject2 = str1;
        if (localIOException1 == null) {
          continue;
        }
        try
        {
          localIOException1.close();
          return "";
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return "";
        }
      }
      finally
      {
        if (localObject2 == null) {
          break label129;
        }
      }
      try
      {
        localInputStream.close();
        localObject2 = paramString;
        return localObject2;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return paramString;
      }
    }
    try
    {
      ((InputStream)localObject2).close();
      label129:
      throw paramString;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        localIOException2.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    bpam.b(this.jdField_c_of_type_JavaLangString, "loadAssets");
    ThreadManager.excute(new AEEditorResourceDownloader.1(this), 64, null, true);
  }
  
  @Deprecated
  public void a(AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    if (paramAEEditorDownloadResBean == null) {
      return;
    }
    bhmi.a(a(paramAEEditorDownloadResBean));
  }
  
  public void a(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean, bpdw parambpdw)
  {
    bpam.b(this.jdField_c_of_type_JavaLangString, "downLoadOneResInternal---BEGIN: id=" + paramAEEditorDownloadResBean.getId());
    String str = paramAEEditorDownloadResBean.getMd5();
    AtomicBoolean localAtomicBoolean;
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      if ((AtomicBoolean)this.jdField_b_of_type_JavaUtilMap.get(str) == null) {
        this.jdField_b_of_type_JavaUtilMap.put(str, new AtomicBoolean(false));
      }
      localAtomicBoolean = (AtomicBoolean)this.jdField_b_of_type_JavaUtilMap.get(str);
    }
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
        if (parambpdw != null) {
          ((List)???).add(parambpdw);
        }
        bpam.b(this.jdField_c_of_type_JavaLangString, "downLoadOneResInternal---is DOWNLOADING: id=" + paramAEEditorDownloadResBean.getId());
        return;
        paramAEEditorDownloadResBean = finally;
        throw paramAEEditorDownloadResBean;
      }
      localAtomicBoolean.compareAndSet(false, true);
      if (a(paramAEEditorDownloadResBean))
      {
        if (parambpdw != null) {
          parambpdw.a(true);
        }
        a(str, true);
        bpam.b(this.jdField_c_of_type_JavaLangString, "downLoadOneResInternal---is DOWNLOADED by other: id=" + paramAEEditorDownloadResBean.getId());
        return;
      }
    }
    finally {}
    ??? = this.jdField_b_of_type_JavaLangString + File.separator + paramAEEditorDownloadResBean.getId() + File.separator;
    bhmi.a((String)???);
    Object localObject2 = (String)??? + str + ".zip";
    if (parambpdw != null) {
      parambpdw.a(0);
    }
    bpag.a().a(paramAEEditorDownloadResBean.getUrl(), (String)localObject2, new bpdv(this, parambpdw, str, paramAEEditorDownloadResBean, (String)localObject2, (String)???));
  }
  
  public void a(String paramString, bpdw parambpdw)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (parambpdw != null) {
        parambpdw.a(false);
      }
      return;
    }
    ThreadManager.excute(new AEEditorResourceDownloader.4(this, paramString, parambpdw), 128, null, false);
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
          bpdw localbpdw = (bpdw)localIterator.next();
          if (localbpdw != null) {
            localbpdw.a(paramBoolean);
          }
        }
        paramString.clear();
      }
    }
    finally {}
  }
  
  public abstract void a(@NonNull List<AEEditorDownloadResBean> paramList);
  
  protected abstract void a(boolean paramBoolean, int paramInt, long paramLong, String paramString);
  
  public boolean a(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    return new File(a(paramAEEditorDownloadResBean)).exists();
  }
  
  protected boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    for (;;)
    {
      int i;
      try
      {
        nof.a(new File(paramString1), paramString2);
        paramString1 = new File(paramString2);
        if ((paramString1.exists()) && (paramString1.isDirectory()))
        {
          paramString1 = paramString1.listFiles();
          if ((paramString1 == null) || (paramString1.length <= 0)) {
            break label238;
          }
          int j = paramString1.length;
          i = 0;
          if (i < j)
          {
            Object localObject = paramString1[i];
            if (!localObject.getName().equals(paramString3)) {
              break label240;
            }
            bpam.b(this.jdField_c_of_type_JavaLangString, "begin rename zip folder---from: " + localObject.getName() + ", to: " + paramString4);
            return bhmi.c(paramString2 + paramString3, paramString2 + paramString4);
          }
          bpam.d(this.jdField_c_of_type_JavaLangString, "unZipAndRenameSpecificFolder--NOT found folder named " + paramString3);
          return false;
        }
      }
      catch (Exception paramString1)
      {
        bpam.a(this.jdField_c_of_type_JavaLangString, "unZipAndRenameSpecificFolder--exception ", paramString1);
        paramString1.printStackTrace();
        return false;
      }
      bpam.d(this.jdField_c_of_type_JavaLangString, "unZipAndRenameSpecificFolder--toDir not exists or not a directory: " + paramString1);
      label238:
      return false;
      label240:
      i += 1;
    }
  }
  
  /* Error */
  @WorkerThread
  protected String b(@NonNull String paramString)
  {
    // Byte code:
    //   0: new 52	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 242	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: ldc 76
    //   11: astore 5
    //   13: aload_2
    //   14: invokevirtual 245	java/io/File:exists	()Z
    //   17: ifne +8 -> 25
    //   20: aload 5
    //   22: astore_1
    //   23: aload_1
    //   24: areturn
    //   25: new 290	java/io/FileInputStream
    //   28: dup
    //   29: aload_2
    //   30: invokespecial 293	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_3
    //   34: aload_3
    //   35: astore_2
    //   36: aload_3
    //   37: invokestatic 99	noe:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   40: astore 4
    //   42: aload 4
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: aload_3
    //   48: ifnull -25 -> 23
    //   51: aload_3
    //   52: invokevirtual 104	java/io/InputStream:close	()V
    //   55: aload_2
    //   56: areturn
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   62: aload_2
    //   63: areturn
    //   64: astore 4
    //   66: aconst_null
    //   67: astore_3
    //   68: aload_3
    //   69: astore_2
    //   70: aload_0
    //   71: getfield 40	bpds:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   74: new 45	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 295
    //   84: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: aload 4
    //   96: invokestatic 114	bpam:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: aload_3
    //   100: astore_2
    //   101: aload 4
    //   103: invokevirtual 115	java/lang/Throwable:printStackTrace	()V
    //   106: aload 5
    //   108: astore_1
    //   109: aload_3
    //   110: ifnull -87 -> 23
    //   113: aload_3
    //   114: invokevirtual 104	java/io/InputStream:close	()V
    //   117: ldc 76
    //   119: areturn
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   125: ldc 76
    //   127: areturn
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +7 -> 139
    //   135: aload_2
    //   136: invokevirtual 104	java/io/InputStream:close	()V
    //   139: aload_1
    //   140: athrow
    //   141: astore_2
    //   142: aload_2
    //   143: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   146: goto -7 -> 139
    //   149: astore_1
    //   150: goto -19 -> 131
    //   153: astore 4
    //   155: goto -87 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	bpds
    //   0	158	1	paramString	String
    //   8	128	2	localObject	Object
    //   141	2	2	localIOException	IOException
    //   33	81	3	localFileInputStream	java.io.FileInputStream
    //   40	3	4	str1	String
    //   64	38	4	localThrowable1	Throwable
    //   153	1	4	localThrowable2	Throwable
    //   11	96	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   51	55	57	java/io/IOException
    //   25	34	64	java/lang/Throwable
    //   113	117	120	java/io/IOException
    //   25	34	128	finally
    //   135	139	141	java/io/IOException
    //   36	42	149	finally
    //   70	99	149	finally
    //   101	106	149	finally
    //   36	42	153	java/lang/Throwable
  }
  
  @WorkerThread
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      bpam.b(this.jdField_c_of_type_JavaLangString, "ensureSetupDownloadConfig--BEGIN");
      String str1 = a(this.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(str1))
      {
        bpam.d(this.jdField_c_of_type_JavaLangString, "ensureSetupDownloadConfig---read assets json content empty");
        return;
      }
    }
    Object localObject2 = (List)GsonUtils.json2Obj(str2, new bpdt(this).getType());
    String str3 = this.jdField_c_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("ensureSetupDownloadConfig---size = ");
    if (localObject2 == null) {}
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(((List)localObject2).size()))
    {
      bpam.b(str3, localObject1);
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AEEditorDownloadResBean)((Iterator)localObject1).next();
        this.jdField_a_of_type_JavaUtilMap.put(((AEEditorDownloadResBean)localObject2).getId(), localObject2);
      }
    }
  }
  
  public abstract void b(@NonNull List<AEEditorDownloadResBean> paramList);
  
  public abstract void c();
  
  public void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    ThreadManager.excute(new AEEditorResourceDownloader.3(this), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpds
 * JD-Core Version:    0.7.0.1
 */