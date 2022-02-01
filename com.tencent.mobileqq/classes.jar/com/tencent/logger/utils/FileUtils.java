package com.tencent.logger.utils;

import android.text.TextUtils;
import com.tencent.logger.Logger;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/logger/utils/FileUtils;", "", "()V", "TAG", "", "delete", "", "file", "Ljava/io/File;", "path", "doZip", "zos", "Ljava/util/zip/ZipOutputStream;", "parentDirName", "buffer", "", "zip", "", "srcFiles", "", "destFile", "([Ljava/io/File;Ljava/io/File;)Z", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class FileUtils
{
  public static final FileUtils a = new FileUtils();
  
  /* Error */
  private final void a(java.util.zip.ZipOutputStream paramZipOutputStream, File paramFile, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 53	java/io/File:exists	()Z
    //   4: ifeq +325 -> 329
    //   7: aload_3
    //   8: checkcast 55	java/lang/CharSequence
    //   11: astore 8
    //   13: iconst_0
    //   14: istore 6
    //   16: aload 8
    //   18: ifnull +22 -> 40
    //   21: aload 8
    //   23: invokeinterface 59 1 0
    //   28: ifne +6 -> 34
    //   31: goto +9 -> 40
    //   34: iconst_0
    //   35: istore 5
    //   37: goto +6 -> 43
    //   40: iconst_1
    //   41: istore 5
    //   43: iload 5
    //   45: ifeq +11 -> 56
    //   48: aload_2
    //   49: invokevirtual 63	java/io/File:getName	()Ljava/lang/String;
    //   52: astore_3
    //   53: goto +44 -> 97
    //   56: new 65	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   63: astore 8
    //   65: aload 8
    //   67: aload_3
    //   68: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 8
    //   74: getstatic 74	java/io/File:separator	Ljava/lang/String;
    //   77: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 8
    //   83: aload_2
    //   84: invokevirtual 63	java/io/File:getName	()Ljava/lang/String;
    //   87: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 8
    //   93: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore_3
    //   97: aload_2
    //   98: invokevirtual 80	java/io/File:isFile	()Z
    //   101: ifeq +164 -> 265
    //   104: new 82	java/io/BufferedInputStream
    //   107: dup
    //   108: new 84	java/io/FileInputStream
    //   111: dup
    //   112: aload_2
    //   113: invokespecial 87	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   116: checkcast 89	java/io/InputStream
    //   119: invokespecial 92	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   122: checkcast 94	java/io/Closeable
    //   125: astore 9
    //   127: aconst_null
    //   128: checkcast 45	java/lang/Throwable
    //   131: astore 8
    //   133: aload 8
    //   135: astore_2
    //   136: aload 9
    //   138: checkcast 82	java/io/BufferedInputStream
    //   141: astore 10
    //   143: aload 8
    //   145: astore_2
    //   146: aload_1
    //   147: new 96	java/util/zip/ZipEntry
    //   150: dup
    //   151: aload_3
    //   152: invokespecial 99	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   155: invokevirtual 105	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   158: aload 8
    //   160: astore_2
    //   161: new 107	kotlin/jvm/internal/Ref$IntRef
    //   164: dup
    //   165: invokespecial 108	kotlin/jvm/internal/Ref$IntRef:<init>	()V
    //   168: astore_3
    //   169: aload 8
    //   171: astore_2
    //   172: aload 10
    //   174: aload 4
    //   176: iconst_0
    //   177: aload 4
    //   179: arraylength
    //   180: invokevirtual 112	java/io/BufferedInputStream:read	([BII)I
    //   183: istore 5
    //   185: aload 8
    //   187: astore_2
    //   188: aload_3
    //   189: iload 5
    //   191: putfield 116	kotlin/jvm/internal/Ref$IntRef:element	I
    //   194: iconst_m1
    //   195: iload 5
    //   197: if_icmpeq +36 -> 233
    //   200: aload 8
    //   202: astore_2
    //   203: aload_1
    //   204: aload 4
    //   206: iconst_0
    //   207: aload_3
    //   208: getfield 116	kotlin/jvm/internal/Ref$IntRef:element	I
    //   211: invokevirtual 120	java/util/zip/ZipOutputStream:write	([BII)V
    //   214: goto -45 -> 169
    //   217: astore_1
    //   218: aload 8
    //   220: astore_2
    //   221: getstatic 125	com/tencent/logger/Logger:a	Lcom/tencent/logger/Logger;
    //   224: ldc 127
    //   226: aload_1
    //   227: checkcast 45	java/lang/Throwable
    //   230: invokevirtual 130	com/tencent/logger/Logger:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   233: aload 8
    //   235: astore_2
    //   236: getstatic 136	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   239: astore_1
    //   240: aload 9
    //   242: aload 8
    //   244: invokestatic 142	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   247: return
    //   248: astore_1
    //   249: goto +8 -> 257
    //   252: astore_1
    //   253: aload_1
    //   254: astore_2
    //   255: aload_1
    //   256: athrow
    //   257: aload 9
    //   259: aload_2
    //   260: invokestatic 142	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   263: aload_1
    //   264: athrow
    //   265: aload_2
    //   266: invokevirtual 145	java/io/File:isDirectory	()Z
    //   269: ifeq +59 -> 328
    //   272: aload_2
    //   273: invokevirtual 149	java/io/File:listFiles	()[Ljava/io/File;
    //   276: astore_2
    //   277: aload_2
    //   278: ifnull +50 -> 328
    //   281: aload_2
    //   282: arraylength
    //   283: istore 7
    //   285: iload 6
    //   287: istore 5
    //   289: iload 5
    //   291: iload 7
    //   293: if_icmpge +35 -> 328
    //   296: aload_2
    //   297: iload 5
    //   299: aaload
    //   300: astore 8
    //   302: aload 8
    //   304: ldc 150
    //   306: invokestatic 156	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   309: aload_0
    //   310: aload_1
    //   311: aload 8
    //   313: aload_3
    //   314: aload 4
    //   316: invokespecial 158	com/tencent/logger/utils/FileUtils:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;[B)V
    //   319: iload 5
    //   321: iconst_1
    //   322: iadd
    //   323: istore 5
    //   325: goto -36 -> 289
    //   328: return
    //   329: new 160	java/io/FileNotFoundException
    //   332: dup
    //   333: ldc 162
    //   335: invokespecial 163	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   338: checkcast 45	java/lang/Throwable
    //   341: astore_1
    //   342: goto +5 -> 347
    //   345: aload_1
    //   346: athrow
    //   347: goto -2 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	FileUtils
    //   0	350	1	paramZipOutputStream	java.util.zip.ZipOutputStream
    //   0	350	2	paramFile	File
    //   0	350	3	paramString	String
    //   0	350	4	paramArrayOfByte	byte[]
    //   35	289	5	i	int
    //   14	272	6	j	int
    //   283	11	7	k	int
    //   11	301	8	localObject	Object
    //   125	133	9	localCloseable	java.io.Closeable
    //   141	32	10	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   146	158	217	java/io/IOException
    //   161	169	217	java/io/IOException
    //   172	185	217	java/io/IOException
    //   188	194	217	java/io/IOException
    //   203	214	217	java/io/IOException
    //   136	143	248	finally
    //   146	158	248	finally
    //   161	169	248	finally
    //   172	185	248	finally
    //   188	194	248	finally
    //   203	214	248	finally
    //   221	233	248	finally
    //   236	240	248	finally
    //   255	257	248	finally
    //   136	143	252	java/lang/Throwable
    //   146	158	252	java/lang/Throwable
    //   161	169	252	java/lang/Throwable
    //   172	185	252	java/lang/Throwable
    //   188	194	252	java/lang/Throwable
    //   203	214	252	java/lang/Throwable
    //   221	233	252	java/lang/Throwable
    //   236	240	252	java/lang/Throwable
  }
  
  public final void a(@Nullable File paramFile)
  {
    if (paramFile == null)
    {
      Logger.a.c("FileUtils", "file delete file error,file null");
      return;
    }
    boolean bool;
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramFile.isFile())
    {
      bool = paramFile.delete();
      localObject = Logger.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file delete file:");
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append(",result:");
      localStringBuilder.append(bool);
      ((Logger)localObject).c("FileUtils", localStringBuilder.toString());
      return;
    }
    if (paramFile.isDirectory())
    {
      localObject = Logger.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file delete file is directory:");
      localStringBuilder.append(paramFile.getAbsolutePath());
      ((Logger)localObject).c("FileUtils", localStringBuilder.toString());
      localObject = paramFile.listFiles();
      if (localObject != null)
      {
        int i = localObject.length;
        int j = 0;
        if (i == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          int k = localObject.length;
          i = j;
          while (i < k)
          {
            a(localObject[i]);
            i += 1;
          }
          bool = paramFile.delete();
          localObject = Logger.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("file finally delete directory:");
          localStringBuilder.append(paramFile.getAbsolutePath());
          localStringBuilder.append(",result:");
          localStringBuilder.append(bool);
          ((Logger)localObject).c("FileUtils", localStringBuilder.toString());
          return;
        }
      }
      bool = paramFile.delete();
      localObject = Logger.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file delete directory:");
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append(",result:");
      localStringBuilder.append(bool);
      ((Logger)localObject).c("FileUtils", localStringBuilder.toString());
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      localLogger = Logger.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file delete:");
      localStringBuilder.append(paramString);
      localLogger.c("FileUtils", localStringBuilder.toString());
      return;
    }
    Logger localLogger = Logger.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file delete:");
    localStringBuilder.append(paramString);
    localLogger.c("FileUtils", localStringBuilder.toString());
    a(new File(paramString));
  }
  
  /* Error */
  public final boolean a(@NotNull File[] paramArrayOfFile, @NotNull File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 206
    //   3: invokestatic 196	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 207
    //   9: invokestatic 196	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: arraylength
    //   14: istore_3
    //   15: iconst_1
    //   16: istore 5
    //   18: iload_3
    //   19: ifne +8 -> 27
    //   22: iconst_1
    //   23: istore_3
    //   24: goto +5 -> 29
    //   27: iconst_0
    //   28: istore_3
    //   29: iload_3
    //   30: ifeq +5 -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: new 209	kotlin/jvm/internal/Ref$BooleanRef
    //   38: dup
    //   39: invokespecial 210	kotlin/jvm/internal/Ref$BooleanRef:<init>	()V
    //   42: astore 8
    //   44: aload 8
    //   46: iconst_0
    //   47: putfield 213	kotlin/jvm/internal/Ref$BooleanRef:element	Z
    //   50: sipush 4096
    //   53: newarray byte
    //   55: astore 9
    //   57: new 101	java/util/zip/ZipOutputStream
    //   60: dup
    //   61: new 215	java/io/BufferedOutputStream
    //   64: dup
    //   65: new 217	java/io/FileOutputStream
    //   68: dup
    //   69: aload_2
    //   70: iconst_0
    //   71: invokespecial 220	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   74: checkcast 222	java/io/OutputStream
    //   77: invokespecial 225	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   80: checkcast 222	java/io/OutputStream
    //   83: invokespecial 226	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: checkcast 94	java/io/Closeable
    //   89: astore 7
    //   91: aconst_null
    //   92: checkcast 45	java/lang/Throwable
    //   95: astore 6
    //   97: aload 6
    //   99: astore_2
    //   100: aload 7
    //   102: checkcast 101	java/util/zip/ZipOutputStream
    //   105: astore 10
    //   107: aload 6
    //   109: astore_2
    //   110: aload_1
    //   111: arraylength
    //   112: istore 4
    //   114: iconst_0
    //   115: istore_3
    //   116: iload_3
    //   117: iload 4
    //   119: if_icmpge +31 -> 150
    //   122: aload_1
    //   123: iload_3
    //   124: aaload
    //   125: astore 11
    //   127: aload 6
    //   129: astore_2
    //   130: getstatic 40	com/tencent/logger/utils/FileUtils:a	Lcom/tencent/logger/utils/FileUtils;
    //   133: aload 10
    //   135: aload 11
    //   137: aconst_null
    //   138: aload 9
    //   140: invokespecial 158	com/tencent/logger/utils/FileUtils:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;[B)V
    //   143: iload_3
    //   144: iconst_1
    //   145: iadd
    //   146: istore_3
    //   147: goto -31 -> 116
    //   150: aload 6
    //   152: astore_2
    //   153: aload 10
    //   155: invokevirtual 229	java/util/zip/ZipOutputStream:flush	()V
    //   158: aload 6
    //   160: astore_2
    //   161: aload 10
    //   163: invokevirtual 232	java/util/zip/ZipOutputStream:closeEntry	()V
    //   166: goto +22 -> 188
    //   169: astore_1
    //   170: aload 6
    //   172: astore_2
    //   173: getstatic 125	com/tencent/logger/Logger:a	Lcom/tencent/logger/Logger;
    //   176: ldc 127
    //   178: aload_1
    //   179: checkcast 45	java/lang/Throwable
    //   182: invokevirtual 130	com/tencent/logger/Logger:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   185: iconst_0
    //   186: istore 5
    //   188: aload 6
    //   190: astore_2
    //   191: aload 8
    //   193: iload 5
    //   195: putfield 213	kotlin/jvm/internal/Ref$BooleanRef:element	Z
    //   198: aload 6
    //   200: astore_2
    //   201: getstatic 136	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   204: astore_1
    //   205: aload 7
    //   207: aload 6
    //   209: invokestatic 142	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   212: aload 8
    //   214: getfield 213	kotlin/jvm/internal/Ref$BooleanRef:element	Z
    //   217: ireturn
    //   218: astore_1
    //   219: goto +8 -> 227
    //   222: astore_1
    //   223: aload_1
    //   224: astore_2
    //   225: aload_1
    //   226: athrow
    //   227: aload 7
    //   229: aload_2
    //   230: invokestatic 142	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   233: goto +5 -> 238
    //   236: aload_1
    //   237: athrow
    //   238: goto -2 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	FileUtils
    //   0	241	1	paramArrayOfFile	File[]
    //   0	241	2	paramFile	File
    //   14	133	3	i	int
    //   112	8	4	j	int
    //   16	178	5	bool	boolean
    //   95	113	6	localThrowable	java.lang.Throwable
    //   89	139	7	localCloseable	java.io.Closeable
    //   42	171	8	localBooleanRef	kotlin.jvm.internal.Ref.BooleanRef
    //   55	84	9	arrayOfByte	byte[]
    //   105	57	10	localZipOutputStream	java.util.zip.ZipOutputStream
    //   125	11	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   110	114	169	java/io/IOException
    //   130	143	169	java/io/IOException
    //   153	158	169	java/io/IOException
    //   161	166	169	java/io/IOException
    //   100	107	218	finally
    //   110	114	218	finally
    //   130	143	218	finally
    //   153	158	218	finally
    //   161	166	218	finally
    //   173	185	218	finally
    //   191	198	218	finally
    //   201	205	218	finally
    //   225	227	218	finally
    //   100	107	222	java/lang/Throwable
    //   110	114	222	java/lang/Throwable
    //   130	143	222	java/lang/Throwable
    //   153	158	222	java/lang/Throwable
    //   161	166	222	java/lang/Throwable
    //   173	185	222	java/lang/Throwable
    //   191	198	222	java/lang/Throwable
    //   201	205	222	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */