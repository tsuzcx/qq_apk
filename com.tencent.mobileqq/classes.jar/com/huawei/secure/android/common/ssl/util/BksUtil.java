package com.huawei.secure.android.common.ssl.util;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class BksUtil
{
  private static final String AUTHORITY = "com.huawei.hwid";
  private static final Uri AUTHORITY_URI = Uri.parse("content://com.huawei.hwid");
  private static final String TAG = BksUtil.class.getSimpleName();
  private static final String ac = "com.huawei.hwid";
  private static final String ad = "com.huawei.hms";
  private static final String ae = "files/hmsrootcas.bks";
  private static final String af = "4.0.2.300";
  private static final String ag = "aegis";
  private static final String ah = "hmsrootcas.bks";
  private static final long ai = 604800000L;
  private static final String aj = "last_update_time";
  
  /* Error */
  private static void a(InputStream paramInputStream, Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_1
    //   10: invokestatic 66	com/huawei/secure/android/common/ssl/util/BksUtil:b	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore_1
    //   14: new 68	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 75	java/io/File:exists	()Z
    //   25: ifne +8 -> 33
    //   28: aload_1
    //   29: invokestatic 78	com/huawei/secure/android/common/ssl/util/BksUtil:b	(Ljava/lang/String;)I
    //   32: pop
    //   33: new 68	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: ldc 27
    //   40: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: astore_3
    //   44: aload_3
    //   45: invokevirtual 75	java/io/File:exists	()Z
    //   48: ifeq +8 -> 56
    //   51: aload_3
    //   52: invokevirtual 84	java/io/File:delete	()Z
    //   55: pop
    //   56: aconst_null
    //   57: astore_1
    //   58: getstatic 44	com/huawei/secure/android/common/ssl/util/BksUtil:TAG	Ljava/lang/String;
    //   61: ldc 86
    //   63: invokestatic 91	com/huawei/secure/android/common/ssl/util/g:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: new 93	java/io/FileOutputStream
    //   69: dup
    //   70: aload_3
    //   71: invokespecial 96	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: astore_3
    //   75: aload_3
    //   76: astore_1
    //   77: sipush 2048
    //   80: newarray byte
    //   82: astore 4
    //   84: aload_3
    //   85: astore_1
    //   86: aload_0
    //   87: aload 4
    //   89: iconst_0
    //   90: aload 4
    //   92: arraylength
    //   93: invokevirtual 102	java/io/InputStream:read	([BII)I
    //   96: istore_2
    //   97: iload_2
    //   98: iconst_m1
    //   99: if_icmpeq +34 -> 133
    //   102: aload_3
    //   103: astore_1
    //   104: aload_3
    //   105: aload 4
    //   107: iconst_0
    //   108: iload_2
    //   109: invokevirtual 108	java/io/OutputStream:write	([BII)V
    //   112: goto -28 -> 84
    //   115: astore_0
    //   116: aload_3
    //   117: astore_0
    //   118: aload_0
    //   119: astore_1
    //   120: getstatic 44	com/huawei/secure/android/common/ssl/util/BksUtil:TAG	Ljava/lang/String;
    //   123: ldc 110
    //   125: invokestatic 113	com/huawei/secure/android/common/ssl/util/g:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: invokestatic 118	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/OutputStream;)V
    //   132: return
    //   133: aload_3
    //   134: invokestatic 118	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/OutputStream;)V
    //   137: return
    //   138: astore_0
    //   139: aload_1
    //   140: invokestatic 118	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/OutputStream;)V
    //   143: aload_0
    //   144: athrow
    //   145: astore_0
    //   146: goto -7 -> 139
    //   149: astore_0
    //   150: aconst_null
    //   151: astore_0
    //   152: goto -34 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramInputStream	InputStream
    //   0	155	1	paramContext	Context
    //   96	13	2	i	int
    //   43	91	3	localObject	Object
    //   82	24	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   77	84	115	java/io/IOException
    //   86	97	115	java/io/IOException
    //   104	112	115	java/io/IOException
    //   58	75	138	finally
    //   77	84	145	finally
    //   86	97	145	finally
    //   104	112	145	finally
    //   120	128	145	finally
    //   58	75	149	java/io/IOException
  }
  
  private static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      g.d(TAG, "The directory  has already exists");
      return 1;
    }
    if (paramString.mkdirs())
    {
      g.b(TAG, "create directory  success");
      return 0;
    }
    g.e(TAG, "create directory  failed");
    return -1;
  }
  
  private static String b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramContext.createDeviceProtectedStorageContext().getFilesDir() + File.separator + "aegis";
    }
    return paramContext.getApplicationContext().getFilesDir() + File.separator + "aegis";
  }
  
  private static boolean c(Context paramContext)
  {
    return new File(b(paramContext) + File.separator + "hmsrootcas.bks").exists();
  }
  
  private static boolean c(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    int n;
    int i;
    label131:
    do
    {
      for (;;)
      {
        return bool1;
        g.c(TAG, "hms version code is : " + paramString);
        paramString = paramString.split("\\.");
        String[] arrayOfString = "4.0.2.300".split("\\.");
        int m = paramString.length;
        n = arrayOfString.length;
        int i1 = Math.max(m, n);
        i = 0;
        bool1 = bool2;
        if (i < i1)
        {
          if (i < m) {}
          try
          {
            int j = Integer.parseInt(paramString[i]);
            if (i < n) {}
            for (int k = Integer.parseInt(arrayOfString[i]);; k = 0)
            {
              if (j >= k) {
                break label131;
              }
              return false;
              j = 0;
              break;
            }
            bool1 = bool2;
            if (j <= k) {
              i += 1;
            }
          }
          catch (Exception paramString)
          {
            g.e(TAG, " exception : " + paramString.getMessage());
            bool1 = bool2;
          }
        }
      }
    } while (i >= n);
    return false;
  }
  
  private static String d(Context paramContext)
  {
    return b(paramContext) + File.separator + "hmsrootcas.bks";
  }
  
  private static void e(Context paramContext)
  {
    g.c(TAG, "load bks from aegis folder , time is : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(i.b("last_update_time", 0L, paramContext))));
  }
  
  @WorkerThread
  public static InputStream getBksFromTss(Context paramContext)
  {
    Object localObject = null;
    for (;;)
    {
      Context localContext;
      try
      {
        g.c(TAG, "get bks from tss begin");
        if (paramContext != null) {
          c.setContext(paramContext);
        }
        localContext = c.k();
        if (localContext == null)
        {
          g.e(TAG, "context is null");
          paramContext = localObject;
          return paramContext;
        }
        if ((!h.g("com.huawei.hwid")) && (!h.g("com.huawei.hms")))
        {
          g.e(TAG, "hms not exist");
          paramContext = localObject;
          continue;
        }
        if (c(h.h("com.huawei.hwid"))) {
          break label142;
        }
      }
      finally {}
      if (!c(h.h("com.huawei.hms")))
      {
        g.e(TAG, "hms version code is too low : " + h.h("com.huawei.hwid"));
        paramContext = localObject;
      }
      else
      {
        try
        {
          label142:
          paramContext = Uri.withAppendedPath(AUTHORITY_URI, "files/hmsrootcas.bks");
          paramContext = localContext.getContentResolver().openInputStream(paramContext);
          long l1 = i.b("last_update_time", 0L, localContext);
          long l2 = System.currentTimeMillis();
          if ((!c(localContext)) || (l2 - l1 > 604800000L) || (l1 == 0L))
          {
            i.a("last_update_time", l2, localContext);
            a(paramContext, localContext);
            g.c(TAG, "save last bks and update bks timestamp");
            if (paramContext != null) {
              f.c(paramContext);
            }
            paramContext = getFilesBksIS(localContext);
          }
          else
          {
            g.c(TAG, "load bks from hms core");
          }
        }
        catch (Exception paramContext)
        {
          g.e(TAG, "Get bks from HMS_VERSION_CODE exception : No content provider");
          paramContext = localObject;
        }
      }
    }
  }
  
  public static InputStream getFilesBksIS(Context paramContext)
  {
    if (c(paramContext))
    {
      e(paramContext);
      try
      {
        paramContext = new FileInputStream(d(paramContext));
        return paramContext;
      }
      catch (FileNotFoundException paramContext)
      {
        g.e(TAG, "FileNotFoundExceptio: ");
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.BksUtil
 * JD-Core Version:    0.7.0.1
 */