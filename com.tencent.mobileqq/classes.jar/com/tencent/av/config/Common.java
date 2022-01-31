package com.tencent.av.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class Common
{
  public static final ConcurrentHashMap a = new ConcurrentHashMap();
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return "6.0.0";
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
        if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.versionName.trim())))
        {
          paramContext = paramContext.versionName.trim();
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "6.0.0";
  }
  
  public static void a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    Object localObject1 = localObject4;
    for (;;)
    {
      try
      {
        a.put(paramString, paramArrayOfByte);
        localObject2 = localObject3;
        localObject1 = localObject4;
        paramContext = paramContext.openFileOutput(paramString, 0);
        localObject2 = paramContext;
        localObject1 = paramContext;
        paramContext.write(paramArrayOfByte);
      }
      catch (Exception paramContext)
      {
        localObject1 = localObject2;
        paramContext.printStackTrace();
        if (localObject2 == null) {
          continue;
        }
        try
        {
          ((FileOutputStream)localObject2).close();
          return;
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
      }
      finally
      {
        if (localObject1 == null) {
          break label95;
        }
      }
      try
      {
        paramContext.close();
        return;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    try
    {
      ((FileOutputStream)localObject1).close();
      label95:
      throw paramContext;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static byte[] a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: getstatic 15	com/tencent/av/config/Common:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   9: aload_1
    //   10: invokevirtual 84	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 86	[B
    //   16: astore 4
    //   18: aload 4
    //   20: astore_3
    //   21: aload 4
    //   23: ifnonnull +46 -> 69
    //   26: aload 5
    //   28: astore_3
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 90	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   34: astore 5
    //   36: aload 4
    //   38: astore_0
    //   39: aload 5
    //   41: invokevirtual 96	java/io/FileInputStream:available	()I
    //   44: istore_2
    //   45: iload_2
    //   46: ifgt +33 -> 79
    //   49: aload 4
    //   51: astore_0
    //   52: aload 5
    //   54: invokevirtual 97	java/io/FileInputStream:close	()V
    //   57: aload 5
    //   59: ifnull +8 -> 67
    //   62: aload 5
    //   64: invokevirtual 97	java/io/FileInputStream:close	()V
    //   67: aconst_null
    //   68: astore_3
    //   69: aload_3
    //   70: areturn
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   76: goto -9 -> 67
    //   79: aload 4
    //   81: astore_0
    //   82: iload_2
    //   83: newarray byte
    //   85: astore 4
    //   87: aload 4
    //   89: astore_0
    //   90: aload 5
    //   92: aload 4
    //   94: invokevirtual 101	java/io/FileInputStream:read	([B)I
    //   97: pop
    //   98: aload 4
    //   100: astore_0
    //   101: getstatic 15	com/tencent/av/config/Common:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   104: aload_1
    //   105: aload 4
    //   107: invokevirtual 65	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: aload 4
    //   113: astore_3
    //   114: aload 5
    //   116: ifnull -47 -> 69
    //   119: aload 5
    //   121: invokevirtual 97	java/io/FileInputStream:close	()V
    //   124: aload 4
    //   126: areturn
    //   127: astore_0
    //   128: aload_0
    //   129: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   132: aload 4
    //   134: areturn
    //   135: astore_0
    //   136: aload 6
    //   138: astore_0
    //   139: aload_0
    //   140: astore_3
    //   141: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +30 -> 174
    //   147: aload_0
    //   148: astore_3
    //   149: ldc 109
    //   151: iconst_2
    //   152: new 111	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   159: ldc 114
    //   161: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_1
    //   165: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload 4
    //   176: astore_3
    //   177: aload_0
    //   178: ifnull -109 -> 69
    //   181: aload_0
    //   182: invokevirtual 97	java/io/FileInputStream:close	()V
    //   185: aload 4
    //   187: areturn
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   193: aload 4
    //   195: areturn
    //   196: astore_0
    //   197: aload_3
    //   198: ifnull +7 -> 205
    //   201: aload_3
    //   202: invokevirtual 97	java/io/FileInputStream:close	()V
    //   205: aload_0
    //   206: athrow
    //   207: astore_1
    //   208: aload_1
    //   209: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   212: goto -7 -> 205
    //   215: astore_0
    //   216: aload 5
    //   218: astore_3
    //   219: goto -22 -> 197
    //   222: astore_3
    //   223: aload_0
    //   224: astore 4
    //   226: aload 5
    //   228: astore_0
    //   229: goto -90 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramContext	Context
    //   0	232	1	paramString	String
    //   44	39	2	i	int
    //   20	199	3	localObject1	Object
    //   222	1	3	localException	Exception
    //   16	209	4	localObject2	Object
    //   1	226	5	localFileInputStream	java.io.FileInputStream
    //   4	133	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   62	67	71	java/io/IOException
    //   119	124	127	java/io/IOException
    //   29	36	135	java/lang/Exception
    //   181	185	188	java/io/IOException
    //   29	36	196	finally
    //   141	147	196	finally
    //   149	174	196	finally
    //   201	205	207	java/io/IOException
    //   39	45	215	finally
    //   52	57	215	finally
    //   82	87	215	finally
    //   90	98	215	finally
    //   101	111	215	finally
    //   39	45	222	java/lang/Exception
    //   52	57	222	java/lang/Exception
    //   82	87	222	java/lang/Exception
    //   90	98	222	java/lang/Exception
    //   101	111	222	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.config.Common
 * JD-Core Version:    0.7.0.1
 */