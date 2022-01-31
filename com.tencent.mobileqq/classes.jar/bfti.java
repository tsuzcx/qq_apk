import android.text.TextUtils;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class bfti
{
  private int jdField_a_of_type_Int;
  private bftj jdField_a_of_type_Bftj;
  private final String jdField_a_of_type_JavaLangString;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int b;
  private int c;
  
  public bfti(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("file cache: name can NOT be empty!");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 5) {}
    String str;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          str = a();
        } while (TextUtils.isEmpty(str));
        for (localObject = new File(str); !((File)localObject).exists(); localObject = ((File)localObject).getParentFile()) {}
      } while (!bftk.a(((File)localObject).getAbsolutePath()));
      localObject = this.jdField_a_of_type_Bftj;
    } while (localObject == null);
    if (!bftg.a(str)) {}
    for (boolean bool = true;; bool = false)
    {
      ((bftj)localObject).a(this, bool);
      return;
    }
  }
  
  public static boolean a(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile());
  }
  
  private File b(String paramString)
  {
    paramString = a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new File(paramString);
    if (a(paramString)) {
      FileUtils.delete(paramString);
    }
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      QLog.e("CacheManager", 1, "", localIOException);
    }
    return paramString;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_Int;
    }
    return this.b;
  }
  
  public File a(String paramString)
  {
    return a(paramString, false);
  }
  
  public File a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = a(paramString);
    Object localObject;
    if (str == null)
    {
      localObject = null;
      if (!a((File)localObject)) {
        break label59;
      }
      a(str, false);
      label37:
      if (!a((File)localObject)) {
        break label92;
      }
    }
    for (;;)
    {
      return localObject;
      localObject = new File(str);
      break;
      label59:
      if (!paramBoolean) {
        break label37;
      }
      paramString = b(paramString);
      localObject = paramString;
      if (!a(paramString)) {
        break label37;
      }
      a(paramString.getAbsolutePath(), true);
      localObject = paramString;
      break label37;
      label92:
      localObject = null;
    }
  }
  
  public String a()
  {
    return bftg.a(this.jdField_a_of_type_JavaLangString, this.c);
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = a();
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    return str + File.separator + paramString;
  }
  
  public void a(bftj parambftj)
  {
    this.jdField_a_of_type_Bftj = parambftj;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    File localFile = new File(paramString);
    if ((localFile.exists()) && (!localFile.setLastModified(System.currentTimeMillis())) && (QLog.isDevelopLevel())) {
      QLog.w("FileCacheService", 2, "更新缓存文件的lru文件时间失败. path=" + paramString);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfti
 * JD-Core Version:    0.7.0.1
 */