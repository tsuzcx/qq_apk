package com.tencent.mobileqq.auto.engine.loader.parse;

import android.text.TextUtils;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import mqq.app.MobileQQ;

public class ASPluginInfoUnZip
{
  private final File a = new File(new File(MobileQQ.sMobileQQ.getFilesDir(), "ShadowPluginManager"), "UnpackedPlugin");
  private final String b;
  
  public ASPluginInfoUnZip(ASPluginBean paramASPluginBean)
  {
    this.a.mkdirs();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramASPluginBean.getBusinessKey());
    localStringBuilder.append("-manager");
    this.b = localStringBuilder.toString();
  }
  
  private File a(File paramFile, String paramString)
  {
    return new File(paramFile, paramString);
  }
  
  private File a(File paramFile, String paramString1, String paramString2)
  {
    return new File(a(paramFile, paramString1), paramString2);
  }
  
  /* Error */
  public static String b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: ldc 70
    //   9: invokestatic 76	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   12: astore 5
    //   14: aload_0
    //   15: ifnonnull +6 -> 21
    //   18: ldc 78
    //   20: areturn
    //   21: aload_3
    //   22: astore_2
    //   23: aload_0
    //   24: invokevirtual 81	java/io/File:exists	()Z
    //   27: ifne +6 -> 33
    //   30: ldc 78
    //   32: areturn
    //   33: aload_3
    //   34: astore_2
    //   35: new 83	java/io/RandomAccessFile
    //   38: dup
    //   39: aload_0
    //   40: ldc 85
    //   42: invokespecial 86	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   45: astore_0
    //   46: sipush 2048
    //   49: newarray byte
    //   51: astore_2
    //   52: aload_0
    //   53: aload_2
    //   54: invokevirtual 90	java/io/RandomAccessFile:read	([B)I
    //   57: istore_1
    //   58: iload_1
    //   59: iconst_m1
    //   60: if_icmpeq +14 -> 74
    //   63: aload 5
    //   65: aload_2
    //   66: iconst_0
    //   67: iload_1
    //   68: invokevirtual 94	java/security/MessageDigest:update	([BII)V
    //   71: goto -19 -> 52
    //   74: new 40	java/lang/StringBuilder
    //   77: dup
    //   78: new 96	java/math/BigInteger
    //   81: dup
    //   82: iconst_1
    //   83: aload 5
    //   85: invokevirtual 100	java/security/MessageDigest:digest	()[B
    //   88: invokespecial 103	java/math/BigInteger:<init>	(I[B)V
    //   91: bipush 16
    //   93: invokevirtual 106	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   96: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: astore_2
    //   100: aload_2
    //   101: invokevirtual 113	java/lang/StringBuilder:length	()I
    //   104: bipush 32
    //   106: if_icmpge +14 -> 120
    //   109: aload_2
    //   110: iconst_0
    //   111: ldc 115
    //   113: invokevirtual 119	java/lang/StringBuilder:insert	(ILjava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: goto -17 -> 100
    //   120: aload_2
    //   121: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore_2
    //   125: aload_0
    //   126: invokevirtual 122	java/io/RandomAccessFile:close	()V
    //   129: aload_2
    //   130: areturn
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   136: aload_2
    //   137: areturn
    //   138: astore_2
    //   139: goto +44 -> 183
    //   142: astore_3
    //   143: goto +15 -> 158
    //   146: astore_3
    //   147: aload_2
    //   148: astore_0
    //   149: aload_3
    //   150: astore_2
    //   151: goto +32 -> 183
    //   154: astore_3
    //   155: aload 4
    //   157: astore_0
    //   158: aload_0
    //   159: astore_2
    //   160: aload_3
    //   161: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   164: aload_0
    //   165: ifnull +15 -> 180
    //   168: aload_0
    //   169: invokevirtual 122	java/io/RandomAccessFile:close	()V
    //   172: ldc 78
    //   174: areturn
    //   175: astore_0
    //   176: aload_0
    //   177: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   180: ldc 78
    //   182: areturn
    //   183: aload_0
    //   184: ifnull +15 -> 199
    //   187: aload_0
    //   188: invokevirtual 122	java/io/RandomAccessFile:close	()V
    //   191: goto +8 -> 199
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   199: goto +5 -> 204
    //   202: aload_2
    //   203: athrow
    //   204: goto -2 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramFile	File
    //   57	11	1	i	int
    //   6	131	2	localObject1	Object
    //   138	10	2	localObject2	Object
    //   150	53	2	localObject3	Object
    //   4	30	3	localObject4	Object
    //   142	1	3	localException1	java.lang.Exception
    //   146	4	3	localObject5	Object
    //   154	7	3	localException2	java.lang.Exception
    //   1	155	4	localObject6	Object
    //   12	72	5	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   125	129	131	java/io/IOException
    //   46	52	138	finally
    //   52	58	138	finally
    //   63	71	138	finally
    //   74	100	138	finally
    //   100	117	138	finally
    //   120	125	138	finally
    //   46	52	142	java/lang/Exception
    //   52	58	142	java/lang/Exception
    //   63	71	142	java/lang/Exception
    //   74	100	142	java/lang/Exception
    //   100	117	142	java/lang/Exception
    //   120	125	142	java/lang/Exception
    //   7	14	146	finally
    //   23	30	146	finally
    //   35	46	146	finally
    //   160	164	146	finally
    //   7	14	154	java/lang/Exception
    //   23	30	154	java/lang/Exception
    //   35	46	154	java/lang/Exception
    //   168	172	175	java/io/IOException
    //   187	191	194	java/io/IOException
  }
  
  private File c(File paramFile)
  {
    File localFile = paramFile.getParentFile();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unpacked.");
    localStringBuilder.append(paramFile.getName());
    return new File(localFile, localStringBuilder.toString());
  }
  
  private void d(File paramFile)
  {
    File[] arrayOfFile = g(paramFile);
    int j = arrayOfFile.length;
    paramFile = null;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      try
      {
        e(localFile);
      }
      catch (IOException paramFile) {}
      i += 1;
    }
    if (paramFile == null) {
      return;
    }
    for (;;)
    {
      throw paramFile;
    }
  }
  
  private void e(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      f(paramFile);
      return;
    }
    boolean bool = paramFile.exists();
    if (!paramFile.delete())
    {
      if (!bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("File does not exist: ");
        localStringBuilder.append(paramFile);
        throw new FileNotFoundException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to delete file: ");
      localStringBuilder.append(paramFile);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  private void f(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    d(paramFile);
    if (paramFile.delete()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to delete directory ");
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".");
    throw new IOException(localStringBuilder.toString());
  }
  
  private static File[] g(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
      {
        localObject = paramFile.listFiles();
        if (localObject != null) {
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to list contents of ");
        ((StringBuilder)localObject).append(paramFile);
        throw new IOException(((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile);
      ((StringBuilder)localObject).append(" is not a directory");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile);
    ((StringBuilder)localObject).append(" does not exist");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  File a(String paramString)
  {
    return a(this.a, this.b, paramString);
  }
  
  File a(String paramString, File paramFile)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = b(paramFile);
    }
    return new File(a(str), paramFile.getName());
  }
  
  boolean a(File paramFile)
  {
    return c(paramFile).exists();
  }
  
  /* Error */
  public boolean b(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +9 -> 16
    //   10: aload_2
    //   11: invokestatic 196	com/tencent/mobileqq/auto/engine/loader/parse/ASPluginInfoUnZip:b	(Ljava/io/File;)Ljava/lang/String;
    //   14: astore 5
    //   16: aload_0
    //   17: aload 5
    //   19: aload_2
    //   20: invokevirtual 204	com/tencent/mobileqq/auto/engine/loader/parse/ASPluginInfoUnZip:a	(Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 38	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_0
    //   32: aload 5
    //   34: invokespecial 201	com/tencent/mobileqq/auto/engine/loader/parse/ASPluginInfoUnZip:c	(Ljava/io/File;)Ljava/io/File;
    //   37: astore 7
    //   39: aload_0
    //   40: aload 5
    //   42: invokevirtual 206	com/tencent/mobileqq/auto/engine/loader/parse/ASPluginInfoUnZip:a	(Ljava/io/File;)Z
    //   45: ifeq +5 -> 50
    //   48: iconst_1
    //   49: ireturn
    //   50: aload_0
    //   51: aload 5
    //   53: invokespecial 167	com/tencent/mobileqq/auto/engine/loader/parse/ASPluginInfoUnZip:d	(Ljava/io/File;)V
    //   56: new 208	com/tencent/mobileqq/auto/engine/loader/parse/ASSafeZipInPutStream
    //   59: dup
    //   60: new 210	java/io/FileInputStream
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 212	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   68: invokespecial 215	com/tencent/mobileqq/auto/engine/loader/parse/ASSafeZipInPutStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore 6
    //   73: aload 6
    //   75: invokevirtual 219	com/tencent/mobileqq/auto/engine/loader/parse/ASSafeZipInPutStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   78: astore_1
    //   79: aload_1
    //   80: ifnull +114 -> 194
    //   83: aload_1
    //   84: invokevirtual 222	java/util/zip/ZipEntry:isDirectory	()Z
    //   87: istore 4
    //   89: iload 4
    //   91: ifne -18 -> 73
    //   94: aconst_null
    //   95: astore_2
    //   96: new 224	java/io/BufferedOutputStream
    //   99: dup
    //   100: new 226	java/io/FileOutputStream
    //   103: dup
    //   104: new 15	java/io/File
    //   107: dup
    //   108: aload 5
    //   110: aload_1
    //   111: invokevirtual 227	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   114: invokespecial 30	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   117: invokespecial 228	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   120: invokespecial 231	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   123: astore_1
    //   124: new 233	java/io/BufferedInputStream
    //   127: dup
    //   128: aload 6
    //   130: invokespecial 234	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   133: astore_2
    //   134: sipush 8192
    //   137: newarray byte
    //   139: astore 8
    //   141: aload_2
    //   142: aload 8
    //   144: iconst_0
    //   145: sipush 8192
    //   148: invokevirtual 237	java/io/BufferedInputStream:read	([BII)I
    //   151: istore_3
    //   152: iload_3
    //   153: iflt +14 -> 167
    //   156: aload_1
    //   157: aload 8
    //   159: iconst_0
    //   160: iload_3
    //   161: invokevirtual 240	java/io/BufferedOutputStream:write	([BII)V
    //   164: goto -23 -> 141
    //   167: aload 6
    //   169: invokevirtual 243	com/tencent/mobileqq/auto/engine/loader/parse/ASSafeZipInPutStream:closeEntry	()V
    //   172: aload_1
    //   173: invokevirtual 244	java/io/BufferedOutputStream:close	()V
    //   176: goto -103 -> 73
    //   179: aload 6
    //   181: invokevirtual 243	com/tencent/mobileqq/auto/engine/loader/parse/ASSafeZipInPutStream:closeEntry	()V
    //   184: aload_1
    //   185: ifnull +7 -> 192
    //   188: aload_1
    //   189: invokevirtual 244	java/io/BufferedOutputStream:close	()V
    //   192: aload_2
    //   193: athrow
    //   194: aload 7
    //   196: invokevirtual 247	java/io/File:createNewFile	()Z
    //   199: pop
    //   200: aload 6
    //   202: invokevirtual 248	com/tencent/mobileqq/auto/engine/loader/parse/ASSafeZipInPutStream:close	()V
    //   205: iconst_1
    //   206: ireturn
    //   207: astore_1
    //   208: aload 6
    //   210: invokevirtual 248	com/tencent/mobileqq/auto/engine/loader/parse/ASSafeZipInPutStream:close	()V
    //   213: goto +5 -> 218
    //   216: aload_1
    //   217: athrow
    //   218: goto -2 -> 216
    //   221: astore_2
    //   222: goto -43 -> 179
    //   225: astore 5
    //   227: aload_2
    //   228: astore_1
    //   229: aload 5
    //   231: astore_2
    //   232: goto -53 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	ASPluginInfoUnZip
    //   0	235	1	paramString	String
    //   0	235	2	paramFile	File
    //   151	10	3	i	int
    //   87	3	4	bool	boolean
    //   1	108	5	localObject1	Object
    //   225	5	5	localObject2	Object
    //   71	138	6	localASSafeZipInPutStream	ASSafeZipInPutStream
    //   37	158	7	localFile	File
    //   139	19	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   73	79	207	finally
    //   83	89	207	finally
    //   167	176	207	finally
    //   179	184	207	finally
    //   188	192	207	finally
    //   192	194	207	finally
    //   194	200	207	finally
    //   124	141	221	finally
    //   141	152	221	finally
    //   156	164	221	finally
    //   96	124	225	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.parse.ASPluginInfoUnZip
 * JD-Core Version:    0.7.0.1
 */