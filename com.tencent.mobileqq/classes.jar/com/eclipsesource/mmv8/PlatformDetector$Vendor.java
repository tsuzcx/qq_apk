package com.eclipsesource.mmv8;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class PlatformDetector$Vendor
{
  private static final String LINUX_ID_PREFIX = "ID=";
  private static final String[] LINUX_OS_RELEASE_FILES = { "/etc/os-release", "/usr/lib/os-release" };
  private static final String REDHAT_RELEASE_FILE = "/etc/redhat-release";
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private static String getLinuxOsReleaseId()
  {
    Object localObject = LINUX_OS_RELEASE_FILES;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      File localFile = new File(localObject[i]);
      if (localFile.exists()) {
        return parseLinuxOsReleaseFile(localFile);
      }
      i += 1;
    }
    localObject = new File("/etc/redhat-release");
    if (((File)localObject).exists()) {
      return parseLinuxRedhatReleaseFile((File)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unsupported linux vendor: ");
    ((StringBuilder)localObject).append(getName());
    localObject = new UnsatisfiedLinkError(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public static String getName()
  {
    if (PlatformDetector.OS.isWindows()) {
      return "microsoft";
    }
    if (PlatformDetector.OS.isMac()) {
      return "apple";
    }
    if (PlatformDetector.OS.isLinux()) {
      return getLinuxOsReleaseId();
    }
    if (PlatformDetector.OS.isAndroid()) {
      return "google";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unsupported vendor: ");
    localStringBuilder.append(getName());
    throw new UnsatisfiedLinkError(localStringBuilder.toString());
  }
  
  /* Error */
  private static String parseLinuxOsReleaseFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 98	java/io/BufferedReader
    //   7: dup
    //   8: new 100	java/io/InputStreamReader
    //   11: dup
    //   12: new 102	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 105	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: ldc 107
    //   22: invokespecial 110	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   25: invokespecial 113	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 116	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_3
    //   34: aload_2
    //   35: astore_1
    //   36: aload_3
    //   37: ifnull +21 -> 58
    //   40: aload_3
    //   41: ldc 8
    //   43: invokevirtual 120	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   46: ifeq -17 -> 29
    //   49: aload_3
    //   50: iconst_3
    //   51: invokevirtual 124	java/lang/String:substring	(I)Ljava/lang/String;
    //   54: invokestatic 130	com/eclipsesource/mmv8/PlatformDetector:access$300	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore_1
    //   58: aload_0
    //   59: invokestatic 132	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   62: aload_1
    //   63: areturn
    //   64: astore_1
    //   65: goto +6 -> 71
    //   68: astore_1
    //   69: aload_3
    //   70: astore_0
    //   71: aload_0
    //   72: invokestatic 132	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   75: aload_1
    //   76: athrow
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: invokestatic 132	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   83: aconst_null
    //   84: areturn
    //   85: astore_0
    //   86: goto -9 -> 77
    //   89: astore_1
    //   90: goto -11 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramFile	File
    //   35	28	1	localObject1	Object
    //   64	1	1	localObject2	Object
    //   68	8	1	localObject3	Object
    //   89	1	1	localIOException	IOException
    //   3	32	2	localObject4	Object
    //   1	69	3	str	String
    // Exception table:
    //   from	to	target	type
    //   29	34	64	finally
    //   40	58	64	finally
    //   4	29	68	finally
    //   4	29	85	java/io/IOException
    //   29	34	89	java/io/IOException
    //   40	58	89	java/io/IOException
  }
  
  /* Error */
  private static String parseLinuxRedhatReleaseFile(File paramFile)
  {
    // Byte code:
    //   0: ldc 134
    //   2: astore_3
    //   3: new 98	java/io/BufferedReader
    //   6: dup
    //   7: new 100	java/io/InputStreamReader
    //   10: dup
    //   11: new 102	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 105	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: ldc 107
    //   21: invokespecial 110	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   24: invokespecial 113	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 116	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 4
    //   34: aload_2
    //   35: astore_0
    //   36: aload 4
    //   38: ifnull +82 -> 120
    //   41: aload 4
    //   43: getstatic 140	java/util/Locale:US	Ljava/util/Locale;
    //   46: invokevirtual 144	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   49: astore_0
    //   50: aload_0
    //   51: ldc 134
    //   53: invokevirtual 148	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   56: istore_1
    //   57: iload_1
    //   58: ifeq +8 -> 66
    //   61: aload_3
    //   62: astore_0
    //   63: goto +30 -> 93
    //   66: aload_0
    //   67: ldc 150
    //   69: invokevirtual 148	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   72: ifeq +9 -> 81
    //   75: ldc 150
    //   77: astore_0
    //   78: goto +15 -> 93
    //   81: aload_0
    //   82: ldc 152
    //   84: invokevirtual 148	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   87: ifeq +12 -> 99
    //   90: ldc 154
    //   92: astore_0
    //   93: aload_2
    //   94: invokestatic 132	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   97: aload_0
    //   98: areturn
    //   99: aload_2
    //   100: invokestatic 132	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   103: aconst_null
    //   104: areturn
    //   105: astore_0
    //   106: goto +6 -> 112
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_2
    //   112: aload_2
    //   113: invokestatic 132	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   116: aload_0
    //   117: athrow
    //   118: aconst_null
    //   119: astore_0
    //   120: aload_0
    //   121: invokestatic 132	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   124: aconst_null
    //   125: areturn
    //   126: astore_0
    //   127: goto -9 -> 118
    //   130: astore_0
    //   131: aload_2
    //   132: astore_0
    //   133: goto -13 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramFile	File
    //   56	2	1	bool	boolean
    //   27	105	2	localBufferedReader	java.io.BufferedReader
    //   2	60	3	str1	String
    //   32	10	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   28	34	105	finally
    //   41	57	105	finally
    //   66	75	105	finally
    //   81	90	105	finally
    //   3	28	109	finally
    //   3	28	126	java/io/IOException
    //   28	34	130	java/io/IOException
    //   41	57	130	java/io/IOException
    //   66	75	130	java/io/IOException
    //   81	90	130	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.PlatformDetector.Vendor
 * JD-Core Version:    0.7.0.1
 */