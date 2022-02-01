import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class awgd
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  WeakReference<PreDownloadController> jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  ArrayList<awgh> b = new ArrayList();
  
  private static String a()
  {
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject2 != null)
    {
      localObject2 = ((File)localObject2).getAbsolutePath() + "/pddata/prd/common_resources";
      File localFile = new File((String)localObject2);
      localObject1 = localObject2;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return c(paramString2);
  }
  
  private void a(String paramString1, String arg2, boolean paramBoolean, awgi paramawgi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, "onDownloadEnd url:" + paramString1 + " success:" + paramBoolean + " mDestroyed:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramString1);
      if (paramawgi != null) {
        paramawgi.a(paramBoolean);
      }
    }
    synchronized (this.b)
    {
      int i = this.b.size() - 1;
      while (i >= 0)
      {
        paramawgi = (awgh)this.b.get(i);
        if ((paramawgi != null) && (TextUtils.equals(paramString1, paramawgi.jdField_a_of_type_JavaLangString)))
        {
          if (paramawgi.jdField_a_of_type_Awgi != null) {
            paramawgi.jdField_a_of_type_Awgi.a(paramBoolean);
          }
          this.b.remove(i);
        }
        i -= 1;
        continue;
        paramString1 = finally;
        throw paramString1;
      }
      return;
    }
  }
  
  private static boolean a(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static boolean a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return c(paramString1, paramString2, paramArrayOfString);
  }
  
  private static String b(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { a(), paramString });
  }
  
  private static void b(String paramString)
  {
    FileUtils.delete(paramString, false);
  }
  
  private static String c(String paramString)
  {
    return String.format("%s/%s", new Object[] { a(), paramString });
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (new File(paramString1).exists())
    {
      paramString1 = ayja.a(paramString1);
      bool1 = bool2;
      if (paramString2 != null)
      {
        bool1 = bool2;
        if (paramString2.equalsIgnoreCase(paramString1)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static boolean c(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = a(paramString1, paramString2);
      if (a(paramString1)) {}
    }
    else
    {
      return false;
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramString2 = paramArrayOfString[i];
        paramString2 = paramString1 + "/" + paramString2;
        if (!a(paramString2))
        {
          QLog.e("ZipResourcesDownloader", 1, String.format("isFilesExist check fail. filePath=%s", new Object[] { paramString2 }));
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private static boolean d(String paramString1, String paramString2)
  {
    try
    {
      aocu.a(paramString1, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      QLog.e("ZipResourcesDownloader", 1, "unzipResource fail.", paramString1);
    }
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    synchronized (this.b)
    {
      this.b.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void a(QQAppInterface arg1, int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, awgi paramawgi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("downloadResource url=%s md5=%s callback=%s", new Object[] { paramString2, paramString3, paramawgi }));
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (??? == null)) {
      QLog.e("ZipResourcesDownloader", 1, "downloadResource invalid parameters.");
    }
    label359:
    boolean bool1;
    do
    {
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        return;
        localObject1 = null;
        if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
          localObject1 = (PreDownloadController)this.jdField_a_of_type_MqqUtilWeakReference.get();
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = (PreDownloadController)???.getManager(193);
          this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localObject2);
        }
        if (localObject2 != null)
        {
          localObject1 = b(paramString3);
          if (c((String)localObject1, paramString3)) {
            break label359;
          }
          int i = 0;
          synchronized (this.jdField_a_of_type_JavaUtilArrayList)
          {
            if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString2)) {
              i = 1;
            }
            if (i != 0)
            {
              if (paramawgi == null) {
                continue;
              }
              synchronized (this.b)
              {
                this.b.add(new awgh(this, paramString2, paramawgi));
                return;
              }
            }
          }
        }
      }
      b((String)localObject1);
      ??? = new HttpNetReq();
      ((HttpNetReq)???).mCallback = new awge(this);
      ((HttpNetReq)???).mReqUrl = paramString2;
      ((HttpNetReq)???).mHttpMethod = 0;
      ((HttpNetReq)???).mOutPath = ((String)localObject1);
      ((HttpNetReq)???).mPrioty = 0;
      ((HttpNetReq)???).mBreakDownFix = new awgf(this);
      ((PreDownloadController)localObject2).requestPreDownload(paramInt, paramString1, paramString3, 0, paramString2, (String)localObject1, 2, 0, false, new HttpEngineTask(???, paramString3, new awgg(this, paramString3, paramArrayOfString, paramawgi), (HttpNetReq)???));
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString2);
        return;
      }
      boolean bool2 = c(paramString2, paramString3, paramArrayOfString);
      bool1 = bool2;
      if (!bool2)
      {
        boolean bool3 = d((String)localObject1, c(paramString3));
        bool2 = c(paramString2, paramString3, paramArrayOfString);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("ZipResourcesDownloader", 2, String.format("downloadResource unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2) }));
          bool1 = bool2;
        }
      }
    } while (paramawgi == null);
    paramawgi.a(bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgd
 * JD-Core Version:    0.7.0.1
 */