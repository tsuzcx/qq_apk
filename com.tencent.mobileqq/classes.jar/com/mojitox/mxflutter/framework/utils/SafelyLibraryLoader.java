package com.mojitox.mxflutter.framework.utils;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SafelyLibraryLoader
{
  private static File a(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        if (paramContext.getFilesDir() != null)
        {
          paramContext = new File(paramContext.getFilesDir(), "libso");
          boolean bool = paramContext.exists();
          if (bool) {}
          for (;;)
          {
            return paramContext;
            paramContext.mkdirs();
          }
        }
      }
      finally {}
    }
    return null;
  }
  
  private static File a(Context paramContext, String paramString)
  {
    paramString = System.mapLibraryName(paramString);
    paramContext = a(paramContext);
    if (paramContext != null) {
      return new File(paramContext, paramString);
    }
    return null;
  }
  
  public static InputStream a(ZipFile paramZipFile, String paramString)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("lib/");
      ((StringBuilder)localObject1).append(Build.CPU_ABI);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(System.mapLibraryName(paramString));
      Object localObject2 = paramZipFile.getEntry(((StringBuilder)localObject1).toString());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        int j = Build.CPU_ABI.indexOf('-');
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("lib/");
        localObject2 = Build.CPU_ABI;
        int i = j;
        if (j <= 0) {
          i = Build.CPU_ABI.length();
        }
        ((StringBuilder)localObject1).append(((String)localObject2).substring(0, i));
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append(System.mapLibraryName(paramString));
        paramString = paramZipFile.getEntry(((StringBuilder)localObject1).toString());
        localObject1 = paramString;
        if (paramString == null) {
          return null;
        }
      }
      paramZipFile = paramZipFile.getInputStream((ZipEntry)localObject1);
      return paramZipFile;
    }
    catch (Throwable paramZipFile)
    {
      MxLog.b("SafelyLibraryLoader", paramZipFile.toString(), paramZipFile);
    }
    return null;
  }
  
  public static void a(int paramInt, String paramString) {}
  
  public static void a(ZipFile paramZipFile)
  {
    if (paramZipFile != null) {}
    try
    {
      paramZipFile.close();
      return;
    }
    catch (IOException paramZipFile) {}
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (Throwable paramContext)
    {
      MxLog.b("SafelyLibraryLoader", paramContext.toString(), paramContext);
      a(2, paramContext.getMessage());
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      MxLog.b("SafelyLibraryLoader", localUnsatisfiedLinkError1.toString(), localUnsatisfiedLinkError1);
      a(1, localUnsatisfiedLinkError1.getMessage());
    }
    try
    {
      localFile = a(paramContext, paramString);
      if ((localFile != null) && (localFile.exists()))
      {
        bool = localFile.isFile();
        if (!bool) {}
      }
    }
    catch (Throwable paramContext)
    {
      File localFile;
      boolean bool;
      label88:
      a(3, paramContext.getMessage());
    }
    try
    {
      System.load(localFile.getAbsolutePath());
      a(5, "recover success, from direct load");
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      break label88;
    }
    if (localFile.exists()) {
      localFile.delete();
    }
    bool = a(paramContext, paramString, localFile);
    if (bool) {}
    try
    {
      System.load(localFile.getAbsolutePath());
      a(4, "recover success, unpack and load");
      return true;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      label126:
      break label126;
    }
    if (localFile.exists()) {
      do
      {
        localFile.delete();
        break;
        paramContext = new StringBuilder();
        paramContext.append("Can't  recover library from apk: ");
        paramContext.append(paramString);
        a(3, paramContext.toString());
        if (localFile == null) {
          break;
        }
        bool = localFile.exists();
      } while (bool);
    }
    return false;
  }
  
  /* Error */
  private static boolean a(Context paramContext, String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: new 66	java/util/zip/ZipFile
    //   15: dup
    //   16: new 19	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokevirtual 147	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   24: getfield 152	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   27: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: iconst_1
    //   31: invokespecial 157	java/util/zip/ZipFile:<init>	(Ljava/io/File;I)V
    //   34: astore_0
    //   35: aload 7
    //   37: astore 4
    //   39: aload_0
    //   40: astore 5
    //   42: aload_0
    //   43: aload_1
    //   44: invokestatic 159	com/mojitox/mxflutter/framework/utils/SafelyLibraryLoader:a	(Ljava/util/zip/ZipFile;Ljava/lang/String;)Ljava/io/InputStream;
    //   47: astore_1
    //   48: aload_1
    //   49: astore 4
    //   51: aload_0
    //   52: astore 5
    //   54: aload_1
    //   55: ifnull +41 -> 96
    //   58: aload_1
    //   59: astore 6
    //   61: aload_2
    //   62: invokevirtual 162	java/io/File:createNewFile	()Z
    //   65: pop
    //   66: aload_1
    //   67: astore 6
    //   69: aload_1
    //   70: aload_2
    //   71: invokestatic 167	com/mojitox/mxflutter/framework/utils/FileUtils:a	(Ljava/io/InputStream;Ljava/io/File;)Z
    //   74: istore_3
    //   75: aload_1
    //   76: invokestatic 170	com/mojitox/mxflutter/framework/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   79: aload_0
    //   80: invokestatic 172	com/mojitox/mxflutter/framework/utils/SafelyLibraryLoader:a	(Ljava/util/zip/ZipFile;)V
    //   83: iload_3
    //   84: ireturn
    //   85: astore_2
    //   86: goto +72 -> 158
    //   89: astore_2
    //   90: aload 6
    //   92: astore_1
    //   93: goto +26 -> 119
    //   96: aload 4
    //   98: invokestatic 170	com/mojitox/mxflutter/framework/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   101: goto +43 -> 144
    //   104: astore_2
    //   105: aconst_null
    //   106: astore_0
    //   107: aload 5
    //   109: astore_1
    //   110: goto +48 -> 158
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_0
    //   116: aload 4
    //   118: astore_1
    //   119: aload_1
    //   120: astore 4
    //   122: aload_0
    //   123: astore 5
    //   125: ldc 90
    //   127: aload_2
    //   128: invokevirtual 91	java/lang/Throwable:toString	()Ljava/lang/String;
    //   131: aload_2
    //   132: invokestatic 97	com/mojitox/mxflutter/framework/utils/MxLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: aload_1
    //   136: astore 4
    //   138: aload_0
    //   139: astore 5
    //   141: goto -45 -> 96
    //   144: aload 5
    //   146: invokestatic 172	com/mojitox/mxflutter/framework/utils/SafelyLibraryLoader:a	(Ljava/util/zip/ZipFile;)V
    //   149: iconst_0
    //   150: ireturn
    //   151: astore_2
    //   152: aload 5
    //   154: astore_0
    //   155: aload 4
    //   157: astore_1
    //   158: aload_1
    //   159: invokestatic 170	com/mojitox/mxflutter/framework/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   162: aload_0
    //   163: invokestatic 172	com/mojitox/mxflutter/framework/utils/SafelyLibraryLoader:a	(Ljava/util/zip/ZipFile;)V
    //   166: goto +5 -> 171
    //   169: aload_2
    //   170: athrow
    //   171: goto -2 -> 169
    //   174: astore_0
    //   175: iload_3
    //   176: ireturn
    //   177: astore_0
    //   178: goto -29 -> 149
    //   181: astore_0
    //   182: goto -16 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramContext	Context
    //   0	185	1	paramString	String
    //   0	185	2	paramFile	File
    //   74	102	3	bool	boolean
    //   1	155	4	localObject1	Object
    //   7	146	5	localContext	Context
    //   10	81	6	str	String
    //   4	32	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   61	66	85	finally
    //   69	75	85	finally
    //   42	48	89	java/lang/Throwable
    //   61	66	89	java/lang/Throwable
    //   69	75	89	java/lang/Throwable
    //   12	35	104	finally
    //   12	35	113	java/lang/Throwable
    //   42	48	151	finally
    //   125	135	151	finally
    //   75	83	174	java/lang/Exception
    //   96	101	177	java/lang/Exception
    //   144	149	177	java/lang/Exception
    //   158	166	181	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.utils.SafelyLibraryLoader
 * JD-Core Version:    0.7.0.1
 */