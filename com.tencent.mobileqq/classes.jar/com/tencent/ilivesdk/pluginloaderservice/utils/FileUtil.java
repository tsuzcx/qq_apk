package com.tencent.ilivesdk.pluginloaderservice.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil
{
  public static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    a(localStringBuffer, paramString);
    return localStringBuffer.toString();
  }
  
  /* Error */
  private static void a(com.tencent.ilivesdk.pluginloaderservice.install.SafeZipInputStream paramSafeZipInputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 24	java/io/BufferedOutputStream
    //   5: dup
    //   6: new 26	java/io/FileOutputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 29	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 32	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   17: astore_1
    //   18: sipush 8192
    //   21: newarray byte
    //   23: astore_3
    //   24: aload_0
    //   25: aload_3
    //   26: invokevirtual 38	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:read	([B)I
    //   29: istore_2
    //   30: iload_2
    //   31: iconst_m1
    //   32: if_icmpeq +13 -> 45
    //   35: aload_1
    //   36: aload_3
    //   37: iconst_0
    //   38: iload_2
    //   39: invokevirtual 42	java/io/BufferedOutputStream:write	([BII)V
    //   42: goto -18 -> 24
    //   45: aload_1
    //   46: invokevirtual 45	java/io/BufferedOutputStream:close	()V
    //   49: aload_1
    //   50: invokevirtual 45	java/io/BufferedOutputStream:close	()V
    //   53: return
    //   54: astore_3
    //   55: aload_1
    //   56: astore_0
    //   57: aload_3
    //   58: astore_1
    //   59: goto +6 -> 65
    //   62: astore_1
    //   63: aload_3
    //   64: astore_0
    //   65: aload_0
    //   66: ifnull +7 -> 73
    //   69: aload_0
    //   70: invokevirtual 45	java/io/BufferedOutputStream:close	()V
    //   73: goto +5 -> 78
    //   76: aload_1
    //   77: athrow
    //   78: goto -2 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	paramSafeZipInputStream	com.tencent.ilivesdk.pluginloaderservice.install.SafeZipInputStream
    //   0	81	1	paramString	String
    //   29	10	2	i	int
    //   1	36	3	arrayOfByte	byte[]
    //   54	10	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	24	54	finally
    //   24	30	54	finally
    //   35	42	54	finally
    //   45	49	54	finally
    //   2	18	62	finally
  }
  
  public static void a(StringBuffer paramStringBuffer, String paramString)
  {
    FileInputStream localFileInputStream = new FileInputStream(paramString);
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localFileInputStream));
    for (paramString = localBufferedReader.readLine(); paramString != null; paramString = localBufferedReader.readLine())
    {
      paramStringBuffer.append(paramString);
      paramStringBuffer.append("\n");
    }
    localBufferedReader.close();
    localFileInputStream.close();
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      int i = 0;
      while (i < arrayOfString.length)
      {
        if (!a(new File(paramFile, arrayOfString[i]))) {
          return false;
        }
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 94	java/io/File:exists	()Z
    //   4: ifne +8 -> 12
    //   7: aload_1
    //   8: invokevirtual 97	java/io/File:mkdir	()Z
    //   11: pop
    //   12: new 34	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream
    //   15: dup
    //   16: new 47	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: invokespecial 101	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 105	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +91 -> 125
    //   37: aload_2
    //   38: invokevirtual 110	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   41: ldc 112
    //   43: invokevirtual 118	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   46: ifeq +6 -> 52
    //   49: goto -21 -> 28
    //   52: new 120	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   59: astore_3
    //   60: aload_3
    //   61: aload_1
    //   62: invokevirtual 124	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   65: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: getstatic 131	java/io/File:separator	Ljava/lang/String;
    //   73: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_3
    //   78: aload_2
    //   79: invokevirtual 110	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   82: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore_3
    //   91: aload_2
    //   92: invokevirtual 133	java/util/zip/ZipEntry:isDirectory	()Z
    //   95: ifne +11 -> 106
    //   98: aload_0
    //   99: aload_3
    //   100: invokestatic 135	com/tencent/ilivesdk/pluginloaderservice/utils/FileUtil:a	(Lcom/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream;Ljava/lang/String;)V
    //   103: goto +15 -> 118
    //   106: new 74	java/io/File
    //   109: dup
    //   110: aload_3
    //   111: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: invokevirtual 97	java/io/File:mkdir	()Z
    //   117: pop
    //   118: aload_0
    //   119: invokevirtual 139	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:closeEntry	()V
    //   122: goto -94 -> 28
    //   125: aload_0
    //   126: invokevirtual 140	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:close	()V
    //   129: iconst_1
    //   130: ireturn
    //   131: astore_1
    //   132: goto +6 -> 138
    //   135: astore_1
    //   136: aconst_null
    //   137: astore_0
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 140	com/tencent/ilivesdk/pluginloaderservice/install/SafeZipInputStream:close	()V
    //   146: goto +5 -> 151
    //   149: aload_1
    //   150: athrow
    //   151: goto -2 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramFile1	File
    //   0	154	1	paramFile2	File
    //   32	60	2	localZipEntry	java.util.zip.ZipEntry
    //   59	52	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	33	131	finally
    //   37	49	131	finally
    //   52	103	131	finally
    //   106	118	131	finally
    //   118	122	131	finally
    //   12	28	135	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */