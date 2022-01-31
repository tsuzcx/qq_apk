package com.tencent.component.network.module.cache.file;

import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.CacheManager;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import pow;
import pox;
import poy;

public class FileCacheService
{
  private static Comparator jdField_a_of_type_JavaUtilComparator = new pox();
  private final Context jdField_a_of_type_AndroidContentContext;
  private final FileCache jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCache;
  private FileCacheService.StorageHandler jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService$StorageHandler;
  private final String jdField_a_of_type_JavaLangString;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final boolean jdField_a_of_type_Boolean;
  private final FileCache b;
  
  public FileCacheService(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("file cache: name can NOT be empty!");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_JavaLangString = ("file" + File.separator + paramString);
    this.jdField_a_of_type_Boolean = paramBoolean;
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    if (paramInt1 > 0) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCache = new FileCache(paramInt1);
      this.b = new FileCache(i);
      b();
      return;
      paramInt1 = 2147483647;
    }
  }
  
  private FileCache a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCache;
    }
    return this.b;
  }
  
  private String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return CacheManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
    return CacheManager.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
  }
  
  private void a(boolean paramBoolean)
  {
    int j = 0;
    label182:
    for (;;)
    {
      String str;
      poy[] arrayOfpoy;
      int i;
      int k;
      try
      {
        str = a(paramBoolean);
        FileCache localFileCache = a(paramBoolean);
        paramBoolean = TextUtils.isEmpty(str);
        if (paramBoolean) {
          return;
        }
        String[] arrayOfString = new File(str).list();
        if ((arrayOfString == null) || (arrayOfString.length == 0)) {
          continue;
        }
        arrayOfpoy = new poy[arrayOfString.length];
        i = 0;
        if (i < arrayOfpoy.length)
        {
          arrayOfpoy[i] = new poy(str, arrayOfString[i]);
          i += 1;
          continue;
        }
        Arrays.sort(arrayOfpoy, jdField_a_of_type_JavaUtilComparator);
        k = arrayOfpoy.length;
        i = j;
      }
      finally {}
      if (!str.jdField_a_of_type_Boolean) {
        FileUtils.delete(str.jdField_a_of_type_JavaLangString);
      } else {
        localObject.a(str.b, str.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (i >= k) {
          break label182;
        }
        str = arrayOfpoy[i];
        if (str != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  private static boolean a(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile());
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    FileCache localFileCache = a(paramBoolean);
    Object localObject = a(paramString, paramBoolean);
    if (localObject == null) {}
    do
    {
      return false;
      localObject = new File((String)localObject);
      if (((File)localObject).isDirectory()) {
        FileUtils.delete((File)localObject);
      }
    } while (!a((File)localObject));
    localFileCache.a(paramString, ((File)localObject).getAbsolutePath());
    b(paramBoolean);
    return true;
  }
  
  private File b(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString, paramBoolean);
    if (paramString == null) {
      return null;
    }
    paramString = new File(paramString);
    if (!a(paramString)) {
      FileUtils.delete(paramString);
    }
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      QDLog.d("FileCacheService", "", localIOException);
    }
    return paramString;
  }
  
  private void b()
  {
    PriorityThreadPool.getDefault().submit(new pow(this));
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() < 3) {}
    Object localObject;
    long l1;
    long l2;
    long l3;
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      for (localObject = new File(a(paramBoolean)); !((File)localObject).exists(); localObject = ((File)localObject).getParentFile()) {}
      localObject = new StatFs(((File)localObject).getAbsolutePath());
      l1 = ((StatFs)localObject).getBlockCount();
      l2 = ((StatFs)localObject).getBlockSize();
      l3 = ((StatFs)localObject).getAvailableBlocks() * ((StatFs)localObject).getBlockSize();
      localObject = this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService$StorageHandler;
    } while ((l3 >= 10485760L) || (localObject == null));
    ((FileCacheService.StorageHandler)localObject).a(this, l1 * l2, l3, paramBoolean);
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCache.a();
    }
    return this.b.a();
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
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
    boolean bool = CacheManager.a();
    Object localObject1 = (String)a(bool).a(paramString);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      localObject1 = localObject2;
      if (!a((File)localObject2))
      {
        localObject1 = localObject2;
        if (bool)
        {
          localObject1 = (String)a(false).a(paramString);
          if (localObject1 != null) {
            break label172;
          }
          localObject1 = null;
        }
      }
      label77:
      localObject2 = localObject1;
      if (paramBoolean)
      {
        localObject2 = localObject1;
        if (!a((File)localObject1))
        {
          localObject2 = b(paramString, bool);
          localObject1 = localObject2;
          if (!a((File)localObject2)) {
            localObject1 = b(paramString, false);
          }
          localObject2 = localObject1;
          if (a((File)localObject1))
          {
            a(paramString);
            localObject2 = localObject1;
          }
        }
      }
      if (!a((File)localObject2)) {
        break label186;
      }
    }
    for (;;)
    {
      return localObject2;
      localObject2 = new File((String)localObject1);
      break;
      label172:
      localObject1 = new File((String)localObject1);
      break label77;
      label186:
      localObject2 = null;
    }
  }
  
  public String a(String paramString)
  {
    return a(paramString, CacheManager.a());
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return null;
      str = a(paramBoolean);
    } while (str == null);
    return str + File.separator + paramString;
  }
  
  public void a()
  {
    try
    {
      a(false).a();
      a(true).a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(FileCacheService.StorageHandler paramStorageHandler)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService$StorageHandler = paramStorageHandler;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(false).b(paramString);
    a(true).b(paramString);
    String str = a(paramString, false);
    paramString = a(paramString, true);
    FileUtils.delete(str);
    FileUtils.delete(paramString);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    try
    {
      a(paramBoolean).a(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    boolean bool3;
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        bool3 = CacheManager.a();
        bool2 = a(paramString, bool3);
        bool1 = bool2;
      } while (bool2);
      bool1 = bool2;
    } while (!bool3);
    return a(paramString, false);
  }
  
  public int b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCache.b();
    }
    return this.b.b();
  }
  
  public String toString()
  {
    return "AlbumUtil#" + this.jdField_a_of_type_JavaLangString + "#capacity=" + b(true) + "," + b(false) + "#size=" + a(true) + "," + a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.cache.file.FileCacheService
 * JD-Core Version:    0.7.0.1
 */