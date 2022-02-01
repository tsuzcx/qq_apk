package com.tencent.biz.qcircleshadow.local.pluginparse;

import android.text.TextUtils;
import com.tencent.shadow.core.common.ILoggerFactory;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import mqq.app.MobileQQ;

public class QCircleUnZip
{
  private static Logger jdField_a_of_type_ComTencentShadowCoreCommonLogger = LoggerFactory.getILoggerFactory().getLogger("QCIRCLE_PLUGIN");
  private final File jdField_a_of_type_JavaIoFile = new File(new File(MobileQQ.sMobileQQ.getFilesDir(), "ShadowPluginManager"), "UnpackedPlugin");
  private final String jdField_a_of_type_JavaLangString;
  
  public QCircleUnZip()
  {
    this.jdField_a_of_type_JavaIoFile.mkdirs();
    this.jdField_a_of_type_JavaLangString = "qcircle-manager";
  }
  
  private File a(File paramFile)
  {
    File localFile = paramFile.getParentFile();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unpacked.");
    localStringBuilder.append(paramFile.getName());
    return new File(localFile, localStringBuilder.toString());
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
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: ldc 90
    //   9: invokestatic 96	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   12: astore 5
    //   14: aload_0
    //   15: ifnonnull +6 -> 21
    //   18: ldc 98
    //   20: areturn
    //   21: aload_3
    //   22: astore_2
    //   23: aload_0
    //   24: invokevirtual 101	java/io/File:exists	()Z
    //   27: ifne +6 -> 33
    //   30: ldc 98
    //   32: areturn
    //   33: aload_3
    //   34: astore_2
    //   35: new 103	java/io/RandomAccessFile
    //   38: dup
    //   39: aload_0
    //   40: ldc 105
    //   42: invokespecial 106	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   45: astore_0
    //   46: sipush 2048
    //   49: newarray byte
    //   51: astore_2
    //   52: aload_0
    //   53: aload_2
    //   54: invokevirtual 110	java/io/RandomAccessFile:read	([B)I
    //   57: istore_1
    //   58: iload_1
    //   59: iconst_m1
    //   60: if_icmpeq +14 -> 74
    //   63: aload 5
    //   65: aload_2
    //   66: iconst_0
    //   67: iload_1
    //   68: invokevirtual 114	java/security/MessageDigest:update	([BII)V
    //   71: goto -19 -> 52
    //   74: new 65	java/lang/StringBuilder
    //   77: dup
    //   78: new 116	java/math/BigInteger
    //   81: dup
    //   82: iconst_1
    //   83: aload 5
    //   85: invokevirtual 120	java/security/MessageDigest:digest	()[B
    //   88: invokespecial 123	java/math/BigInteger:<init>	(I[B)V
    //   91: bipush 16
    //   93: invokevirtual 126	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   96: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: astore_2
    //   100: aload_2
    //   101: invokevirtual 133	java/lang/StringBuilder:length	()I
    //   104: bipush 32
    //   106: if_icmpge +14 -> 120
    //   109: aload_2
    //   110: iconst_0
    //   111: ldc 135
    //   113: invokevirtual 139	java/lang/StringBuilder:insert	(ILjava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: goto -17 -> 100
    //   120: aload_2
    //   121: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore_2
    //   125: aload_0
    //   126: invokevirtual 142	java/io/RandomAccessFile:close	()V
    //   129: aload_2
    //   130: areturn
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   136: aload_2
    //   137: areturn
    //   138: astore_3
    //   139: aload_0
    //   140: astore_2
    //   141: aload_3
    //   142: astore_0
    //   143: goto +91 -> 234
    //   146: astore_3
    //   147: goto +11 -> 158
    //   150: astore_0
    //   151: goto +83 -> 234
    //   154: astore_3
    //   155: aload 4
    //   157: astore_0
    //   158: aload_0
    //   159: astore_2
    //   160: aload_3
    //   161: invokevirtual 146	java/lang/Exception:printStackTrace	()V
    //   164: aload_0
    //   165: astore_2
    //   166: getstatic 26	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleUnZip:jdField_a_of_type_ComTencentShadowCoreCommonLogger	Lcom/tencent/shadow/core/common/Logger;
    //   169: astore 4
    //   171: aload_0
    //   172: astore_2
    //   173: new 65	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   180: astore 5
    //   182: aload_0
    //   183: astore_2
    //   184: aload 5
    //   186: ldc 148
    //   188: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_0
    //   193: astore_2
    //   194: aload 5
    //   196: aload_3
    //   197: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_0
    //   202: astore_2
    //   203: aload 4
    //   205: aload 5
    //   207: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokeinterface 156 2 0
    //   215: aload_0
    //   216: ifnull +15 -> 231
    //   219: aload_0
    //   220: invokevirtual 142	java/io/RandomAccessFile:close	()V
    //   223: ldc 98
    //   225: areturn
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   231: ldc 98
    //   233: areturn
    //   234: aload_2
    //   235: ifnull +15 -> 250
    //   238: aload_2
    //   239: invokevirtual 142	java/io/RandomAccessFile:close	()V
    //   242: goto +8 -> 250
    //   245: astore_2
    //   246: aload_2
    //   247: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   250: goto +5 -> 255
    //   253: aload_0
    //   254: athrow
    //   255: goto -2 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	paramFile	File
    //   57	11	1	i	int
    //   6	233	2	localObject1	Object
    //   245	2	2	localIOException	IOException
    //   4	30	3	localObject2	Object
    //   138	4	3	localObject3	Object
    //   146	1	3	localException1	java.lang.Exception
    //   154	43	3	localException2	java.lang.Exception
    //   1	203	4	localLogger	Logger
    //   12	194	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   125	129	131	java/io/IOException
    //   46	52	138	finally
    //   52	58	138	finally
    //   63	71	138	finally
    //   74	100	138	finally
    //   100	117	138	finally
    //   120	125	138	finally
    //   46	52	146	java/lang/Exception
    //   52	58	146	java/lang/Exception
    //   63	71	146	java/lang/Exception
    //   74	100	146	java/lang/Exception
    //   100	117	146	java/lang/Exception
    //   120	125	146	java/lang/Exception
    //   7	14	150	finally
    //   23	30	150	finally
    //   35	46	150	finally
    //   160	164	150	finally
    //   166	171	150	finally
    //   173	182	150	finally
    //   184	192	150	finally
    //   194	201	150	finally
    //   203	215	150	finally
    //   7	14	154	java/lang/Exception
    //   23	30	154	java/lang/Exception
    //   35	46	154	java/lang/Exception
    //   219	223	226	java/io/IOException
    //   238	242	245	java/io/IOException
  }
  
  private void a(File paramFile)
  {
    File[] arrayOfFile = a(paramFile);
    int j = arrayOfFile.length;
    paramFile = null;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      try
      {
        b(localFile);
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
  
  private static File[] a(File paramFile)
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
  
  private void b(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      c(paramFile);
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
  
  private void c(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    a(paramFile);
    if (paramFile.delete()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to delete directory ");
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".");
    throw new IOException(localStringBuilder.toString());
  }
  
  File a(String paramString)
  {
    return a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  File a(String paramString, File paramFile)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = a(paramFile);
    }
    return new File(a(str), paramFile.getName());
  }
  
  boolean a(File paramFile)
  {
    return a(paramFile).exists();
  }
  
  /* Error */
  public boolean a(String paramString1, File paramFile, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 10
    //   3: aload_1
    //   4: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +9 -> 16
    //   10: aload_2
    //   11: invokestatic 211	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleUnZip:a	(Ljava/io/File;)Ljava/lang/String;
    //   14: astore 10
    //   16: aload_0
    //   17: aload 10
    //   19: aload_2
    //   20: invokevirtual 219	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleUnZip:a	(Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   23: astore 12
    //   25: aload 12
    //   27: invokevirtual 55	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_0
    //   32: aload 12
    //   34: invokespecial 216	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleUnZip:a	(Ljava/io/File;)Ljava/io/File;
    //   37: astore 11
    //   39: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   42: lstore 5
    //   44: aload_0
    //   45: aload 12
    //   47: invokevirtual 227	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleUnZip:a	(Ljava/io/File;)Z
    //   50: istore 9
    //   52: getstatic 26	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleUnZip:jdField_a_of_type_ComTencentShadowCoreCommonLogger	Lcom/tencent/shadow/core/common/Logger;
    //   55: astore_1
    //   56: new 65	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   63: astore 10
    //   65: aload 10
    //   67: aload_3
    //   68: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 10
    //   74: ldc 229
    //   76: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 10
    //   82: iload 9
    //   84: invokevirtual 232	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 10
    //   90: ldc 234
    //   92: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 10
    //   98: aload 12
    //   100: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 10
    //   106: ldc 236
    //   108: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 10
    //   114: aload 11
    //   116: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 10
    //   122: ldc 238
    //   124: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 10
    //   130: aload_0
    //   131: invokevirtual 241	java/lang/Object:hashCode	()I
    //   134: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_1
    //   139: aload 10
    //   141: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokeinterface 156 2 0
    //   149: iload 9
    //   151: ifeq +5 -> 156
    //   154: iconst_1
    //   155: ireturn
    //   156: aload_0
    //   157: aload 12
    //   159: invokespecial 195	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleUnZip:a	(Ljava/io/File;)V
    //   162: new 246	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleSafeZipInPutStream
    //   165: dup
    //   166: new 248	java/io/FileInputStream
    //   169: dup
    //   170: aload_2
    //   171: invokespecial 250	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   174: invokespecial 253	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleSafeZipInPutStream:<init>	(Ljava/io/InputStream;)V
    //   177: astore 10
    //   179: aload 10
    //   181: invokevirtual 257	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleSafeZipInPutStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   184: astore_1
    //   185: aload_1
    //   186: ifnull +117 -> 303
    //   189: aload_1
    //   190: invokevirtual 260	java/util/zip/ZipEntry:isDirectory	()Z
    //   193: istore 9
    //   195: iload 9
    //   197: ifne -18 -> 179
    //   200: aconst_null
    //   201: astore_2
    //   202: new 262	java/io/BufferedOutputStream
    //   205: dup
    //   206: new 264	java/io/FileOutputStream
    //   209: dup
    //   210: new 32	java/io/File
    //   213: dup
    //   214: aload 12
    //   216: aload_1
    //   217: invokevirtual 265	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   220: invokespecial 47	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   223: invokespecial 266	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   226: invokespecial 269	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   229: astore_1
    //   230: new 271	java/io/BufferedInputStream
    //   233: dup
    //   234: aload 10
    //   236: invokespecial 272	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   239: astore_2
    //   240: sipush 8192
    //   243: newarray byte
    //   245: astore 13
    //   247: aload_2
    //   248: aload 13
    //   250: iconst_0
    //   251: sipush 8192
    //   254: invokevirtual 275	java/io/BufferedInputStream:read	([BII)I
    //   257: istore 4
    //   259: iload 4
    //   261: iflt +15 -> 276
    //   264: aload_1
    //   265: aload 13
    //   267: iconst_0
    //   268: iload 4
    //   270: invokevirtual 278	java/io/BufferedOutputStream:write	([BII)V
    //   273: goto -26 -> 247
    //   276: aload 10
    //   278: invokevirtual 281	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleSafeZipInPutStream:closeEntry	()V
    //   281: aload_1
    //   282: invokevirtual 282	java/io/BufferedOutputStream:close	()V
    //   285: goto -106 -> 179
    //   288: aload 10
    //   290: invokevirtual 281	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleSafeZipInPutStream:closeEntry	()V
    //   293: aload_1
    //   294: ifnull +7 -> 301
    //   297: aload_1
    //   298: invokevirtual 282	java/io/BufferedOutputStream:close	()V
    //   301: aload_2
    //   302: athrow
    //   303: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   306: lstore 7
    //   308: getstatic 26	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleUnZip:jdField_a_of_type_ComTencentShadowCoreCommonLogger	Lcom/tencent/shadow/core/common/Logger;
    //   311: astore_1
    //   312: new 65	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   319: astore_2
    //   320: aload_2
    //   321: aload_3
    //   322: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_2
    //   327: ldc_w 284
    //   330: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_2
    //   335: lload 7
    //   337: lload 5
    //   339: lsub
    //   340: invokevirtual 287	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_1
    //   345: aload_2
    //   346: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokeinterface 156 2 0
    //   354: aload 11
    //   356: invokevirtual 290	java/io/File:createNewFile	()Z
    //   359: pop
    //   360: aload 10
    //   362: invokevirtual 291	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleSafeZipInPutStream:close	()V
    //   365: iconst_1
    //   366: ireturn
    //   367: astore_1
    //   368: aload 10
    //   370: invokevirtual 291	com/tencent/biz/qcircleshadow/local/pluginparse/QCircleSafeZipInPutStream:close	()V
    //   373: goto +5 -> 378
    //   376: aload_1
    //   377: athrow
    //   378: goto -2 -> 376
    //   381: astore_2
    //   382: goto -94 -> 288
    //   385: astore_3
    //   386: aload_2
    //   387: astore_1
    //   388: aload_3
    //   389: astore_2
    //   390: goto -102 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	this	QCircleUnZip
    //   0	393	1	paramString1	String
    //   0	393	2	paramFile	File
    //   0	393	3	paramString2	String
    //   257	12	4	i	int
    //   42	296	5	l1	long
    //   306	30	7	l2	long
    //   50	146	9	bool	boolean
    //   1	368	10	localObject	Object
    //   37	318	11	localFile1	File
    //   23	192	12	localFile2	File
    //   245	21	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   179	185	367	finally
    //   189	195	367	finally
    //   276	285	367	finally
    //   288	293	367	finally
    //   297	301	367	finally
    //   301	303	367	finally
    //   303	360	367	finally
    //   230	247	381	finally
    //   247	259	381	finally
    //   264	273	381	finally
    //   202	230	385	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginparse.QCircleUnZip
 * JD-Core Version:    0.7.0.1
 */