package com.rookery.translate.model;

import android.content.Context;
import android.os.Environment;
import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class TransDiskCache
  implements ICache<String>
{
  private final DiskLruCache a;
  
  public TransDiskCache(Context paramContext, int paramInt, long paramLong)
  {
    paramContext = a(paramContext);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    this.a = DiskLruCache.open(paramContext, paramInt, 1, paramLong);
    a();
  }
  
  private File a(Context paramContext)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getPath());
    ((StringBuilder)localObject1).append("/Android/data/");
    ((StringBuilder)localObject1).append(paramContext.getPackageName());
    ((StringBuilder)localObject1).append("/cache/");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = Utils.a(paramContext);
    if ((("mounted".equals(Environment.getExternalStorageState())) || (!Utils.a())) && (localObject2 != null))
    {
      paramContext = ((File)localObject2).getPath();
    }
    else
    {
      localObject2 = paramContext.getCacheDir().getPath();
      paramContext = (Context)localObject1;
      if (localObject2 != null)
      {
        paramContext = (Context)localObject1;
        if (((String)localObject2).length() > 0) {
          paramContext = (Context)localObject2;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[TransDiskCache] getDiskCacheDir:");
      ((StringBuilder)localObject1).append(paramContext);
      QLog.d("Translator", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramContext);
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("TransDiskCache_simsun_qqi");
    return new File(((StringBuilder)localObject1).toString());
  }
  
  /* Error */
  private String b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 117	com/rookery/translate/model/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_1
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: getfield 34	com/rookery/translate/model/TransDiskCache:a	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   11: aload_1
    //   12: invokevirtual 121	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +25 -> 42
    //   20: aload_1
    //   21: astore_2
    //   22: aload_1
    //   23: iconst_0
    //   24: invokevirtual 127	com/jakewharton/disklrucache/DiskLruCache$Snapshot:getString	(I)Ljava/lang/String;
    //   27: astore_3
    //   28: aload_1
    //   29: ifnull +7 -> 36
    //   32: aload_1
    //   33: invokevirtual 130	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   36: aload_3
    //   37: areturn
    //   38: astore_3
    //   39: goto +17 -> 56
    //   42: aload_1
    //   43: ifnull +27 -> 70
    //   46: goto +20 -> 66
    //   49: astore_1
    //   50: goto +23 -> 73
    //   53: astore_3
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_1
    //   57: astore_2
    //   58: aload_3
    //   59: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 130	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   70: aconst_null
    //   71: areturn
    //   72: astore_1
    //   73: aload_2
    //   74: ifnull +7 -> 81
    //   77: aload_2
    //   78: invokevirtual 130	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	TransDiskCache
    //   0	83	1	paramString	String
    //   6	72	2	str1	String
    //   27	10	3	str2	String
    //   38	1	3	localException1	java.lang.Exception
    //   53	6	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   22	28	38	java/lang/Exception
    //   7	16	49	finally
    //   7	16	53	java/lang/Exception
    //   22	28	72	finally
    //   58	62	72	finally
  }
  
  private void b(String paramString1, String paramString2)
  {
    Object localObject = Utils.a(paramString1);
    paramString1 = null;
    try
    {
      localObject = this.a.edit((String)localObject);
      if (localObject == null) {
        return;
      }
      paramString1 = (String)localObject;
      ((DiskLruCache.Editor)localObject).set(0, paramString2);
      paramString1 = (String)localObject;
      ((DiskLruCache.Editor)localObject).commit();
      return;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        try
        {
          paramString1.abort();
          return;
        }
        catch (IOException paramString1) {}
        paramString2 = paramString2;
      }
    }
    if (paramString1 != null) {}
  }
  
  public Trans_entity a(String paramString1, long paramLong, String paramString2)
  {
    String str = a(Utils.a(paramString2, paramString1));
    if (str == null) {
      return null;
    }
    paramString2 = a(Utils.a(paramString2, paramString1, paramLong));
    paramString1 = Boolean.valueOf(false);
    if (paramString2 != null) {
      paramString1 = Boolean.valueOf(paramString2);
    }
    return new Trans_entity(str, paramString1.booleanValue());
  }
  
  public String a(String paramString)
  {
    return b(paramString);
  }
  
  public void a() {}
  
  public void a(String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      b(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, Boolean paramBoolean)
  {
    a(Utils.a(paramString1, paramString2, paramLong), paramBoolean.toString());
  }
  
  public void a(String paramString1, String paramString2, long paramLong, Boolean paramBoolean, String paramString3)
  {
    a(Utils.a(paramString3, paramString1, paramLong), paramBoolean.toString());
    a(Utils.a(paramString3, paramString1), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.model.TransDiskCache
 * JD-Core Version:    0.7.0.1
 */