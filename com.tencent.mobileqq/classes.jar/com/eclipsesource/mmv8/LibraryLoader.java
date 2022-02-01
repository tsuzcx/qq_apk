package com.eclipsesource.mmv8;

import java.io.File;

class LibraryLoader
{
  static final String DELIMITER = System.getProperty("line.separator");
  static final String SEPARATOR = System.getProperty("file.separator");
  static final String SWT_LIB_DIR = ".j2v8";
  
  static void chmod(String paramString1, String paramString2)
  {
    if (isWindows()) {
      return;
    }
    try
    {
      Runtime.getRuntime().exec(new String[] { "chmod", paramString1, paramString2 }).waitFor();
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  private static String computeLibraryFullName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib");
    localStringBuilder.append(computeLibraryShortName());
    localStringBuilder.append(".");
    localStringBuilder.append(getOSFileExtension());
    return localStringBuilder.toString();
  }
  
  private static String computeLibraryShortName()
  {
    String str1 = getOS();
    String str2 = getArchSuffix();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("j2v8");
    localStringBuilder.append("_");
    localStringBuilder.append(str1);
    localStringBuilder.append("_");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  /* Error */
  static boolean extract(String paramString1, String paramString2, StringBuffer paramStringBuffer)
  {
    // Byte code:
    //   0: new 95	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 8
    //   10: iconst_1
    //   11: istore_3
    //   12: aconst_null
    //   13: astore 6
    //   15: aload 8
    //   17: invokevirtual 101	java/io/File:exists	()Z
    //   20: ifeq +9 -> 29
    //   23: aload 8
    //   25: invokevirtual 104	java/io/File:delete	()Z
    //   28: pop
    //   29: new 61	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   36: astore 7
    //   38: aload 7
    //   40: ldc 106
    //   42: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 7
    //   48: aload_1
    //   49: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 2
    //   55: aload 7
    //   57: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokevirtual 112	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   63: astore 7
    //   65: aload 7
    //   67: ifnull +122 -> 189
    //   70: sipush 4096
    //   73: newarray byte
    //   75: astore 9
    //   77: new 114	java/io/FileOutputStream
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload 7
    //   88: aload 9
    //   90: invokevirtual 121	java/io/InputStream:read	([B)I
    //   93: istore 4
    //   95: iload 4
    //   97: iconst_m1
    //   98: if_icmpeq +15 -> 113
    //   101: aload_1
    //   102: aload 9
    //   104: iconst_0
    //   105: iload 4
    //   107: invokevirtual 125	java/io/FileOutputStream:write	([BII)V
    //   110: goto -24 -> 86
    //   113: aload_1
    //   114: invokevirtual 128	java/io/FileOutputStream:close	()V
    //   117: aload 7
    //   119: invokevirtual 129	java/io/InputStream:close	()V
    //   122: ldc 131
    //   124: aload_0
    //   125: invokestatic 133	com/eclipsesource/mmv8/LibraryLoader:chmod	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: aload_2
    //   130: invokestatic 137	com/eclipsesource/mmv8/LibraryLoader:load	(Ljava/lang/String;Ljava/lang/StringBuffer;)Z
    //   133: istore 5
    //   135: iload 5
    //   137: ifeq +52 -> 189
    //   140: iconst_1
    //   141: ireturn
    //   142: aload 7
    //   144: astore_0
    //   145: goto +10 -> 155
    //   148: aconst_null
    //   149: astore_0
    //   150: iconst_0
    //   151: istore_3
    //   152: aload 6
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 128	java/io/FileOutputStream:close	()V
    //   163: aload_0
    //   164: ifnull +7 -> 171
    //   167: aload_0
    //   168: invokevirtual 129	java/io/InputStream:close	()V
    //   171: iload_3
    //   172: ifeq +17 -> 189
    //   175: aload 8
    //   177: invokevirtual 101	java/io/File:exists	()Z
    //   180: ifeq +9 -> 189
    //   183: aload 8
    //   185: invokevirtual 104	java/io/File:delete	()Z
    //   188: pop
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_0
    //   192: goto -44 -> 148
    //   195: astore_0
    //   196: aload 6
    //   198: astore_1
    //   199: aload 7
    //   201: astore_0
    //   202: goto -47 -> 155
    //   205: astore_0
    //   206: goto -64 -> 142
    //   209: astore_1
    //   210: goto -47 -> 163
    //   213: astore_0
    //   214: goto -43 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramString1	String
    //   0	217	1	paramString2	String
    //   0	217	2	paramStringBuffer	StringBuffer
    //   11	161	3	i	int
    //   93	13	4	j	int
    //   133	3	5	bool	boolean
    //   13	184	6	localObject1	Object
    //   36	164	7	localObject2	Object
    //   8	176	8	localFile	File
    //   75	28	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   15	29	191	java/lang/Throwable
    //   29	65	191	java/lang/Throwable
    //   70	86	195	java/lang/Throwable
    //   86	95	205	java/lang/Throwable
    //   101	110	205	java/lang/Throwable
    //   113	135	205	java/lang/Throwable
    //   159	163	209	java/io/IOException
    //   167	171	213	java/io/IOException
  }
  
  static String getArchSuffix()
  {
    String str = System.getProperty("os.arch");
    if (str.equals("i686")) {
      return "x86";
    }
    if (str.equals("amd64")) {
      return "x86_64";
    }
    if (str.equals("nacl")) {
      return "armv7l";
    }
    if (str.equals("aarch64")) {
      return "armv7l";
    }
    return str;
  }
  
  static String getOS()
  {
    if (isWindows()) {
      return "win32";
    }
    if (isMac()) {
      return "macosx";
    }
    if ((isLinux()) && (!isAndroid())) {
      return "linux";
    }
    if (isAndroid()) {
      return "android";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unsupported platform: ");
    localStringBuilder.append(getOsName());
    throw new UnsatisfiedLinkError(localStringBuilder.toString());
  }
  
  static String getOSFileExtension()
  {
    if (isWindows()) {
      return "dll";
    }
    if (isMac()) {
      return "dylib";
    }
    if (isLinux()) {
      return "so";
    }
    if (isNativeClient()) {
      return "so";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unsupported platform: ");
    localStringBuilder.append(getOsName());
    throw new UnsatisfiedLinkError(localStringBuilder.toString());
  }
  
  static String getOsName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.getProperty("os.name"));
    localStringBuilder.append(System.getProperty("java.specification.vendor"));
    return localStringBuilder.toString();
  }
  
  static boolean isAndroid()
  {
    return getOsName().contains("Android");
  }
  
  static boolean isLinux()
  {
    return getOsName().startsWith("Linux");
  }
  
  static boolean isMac()
  {
    return getOsName().startsWith("Mac");
  }
  
  static boolean isNativeClient()
  {
    return getOsName().startsWith("nacl");
  }
  
  static boolean isWindows()
  {
    return getOsName().startsWith("Windows");
  }
  
  static boolean load(String paramString, StringBuffer paramStringBuffer)
  {
    try
    {
      if (paramString.indexOf(SEPARATOR) != -1) {
        System.load(paramString);
      } else {
        System.loadLibrary(paramString);
      }
      return true;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      if (paramStringBuffer.length() == 0) {
        paramStringBuffer.append(DELIMITER);
      }
      paramStringBuffer.append('\t');
      paramStringBuffer.append(paramString.getMessage());
      paramStringBuffer.append(DELIMITER);
    }
    return false;
  }
  
  static void loadLibrary(String paramString)
  {
    if (isAndroid())
    {
      System.loadLibrary("mmj2v8");
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1 = computeLibraryShortName();
    String str = computeLibraryFullName();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(System.getProperty("user.dir"));
    ((StringBuilder)localObject2).append(SEPARATOR);
    ((StringBuilder)localObject2).append("jni");
    ((StringBuilder)localObject2).append(SEPARATOR);
    ((StringBuilder)localObject2).append(computeLibraryFullName());
    localObject2 = ((StringBuilder)localObject2).toString();
    if (load(str, localStringBuffer)) {
      return;
    }
    if (load((String)localObject1, localStringBuffer)) {
      return;
    }
    if ((new File((String)localObject2).exists()) && (load((String)localObject2, localStringBuffer))) {
      return;
    }
    if (paramString == null) {
      paramString = System.getProperty("java.io.tmpdir");
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(SEPARATOR);
    ((StringBuilder)localObject1).append(str);
    if (extract(((StringBuilder)localObject1).toString(), str, localStringBuffer)) {
      return;
    }
    paramString = new StringBuilder();
    paramString.append("Could not load J2V8 library. Reasons: ");
    paramString.append(localStringBuffer.toString());
    throw new UnsatisfiedLinkError(paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.LibraryLoader
 * JD-Core Version:    0.7.0.1
 */