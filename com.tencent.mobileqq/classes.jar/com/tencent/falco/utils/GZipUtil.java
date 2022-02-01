package com.tencent.falco.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;

public class GZipUtil
{
  public static final int BUFFER = 1024;
  public static final String EXT = ".gz";
  
  public static void compress(File paramFile)
  {
    compress(paramFile, true);
  }
  
  /* Error */
  public static void compress(File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 23	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 25	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore_3
    //   12: new 27	java/io/FileOutputStream
    //   15: dup
    //   16: new 29	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   23: aload_0
    //   24: invokevirtual 36	java/io/File:getPath	()Ljava/lang/String;
    //   27: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 11
    //   32: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokespecial 46	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: new 48	java/util/zip/GZIPOutputStream
    //   46: dup
    //   47: aload 4
    //   49: invokespecial 51	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: astore 7
    //   54: sipush 1024
    //   57: newarray byte
    //   59: astore 5
    //   61: aload_3
    //   62: aload 5
    //   64: iconst_0
    //   65: sipush 1024
    //   68: invokevirtual 55	java/io/FileInputStream:read	([BII)I
    //   71: istore_2
    //   72: iload_2
    //   73: iconst_m1
    //   74: if_icmpeq +57 -> 131
    //   77: aload 7
    //   79: aload 5
    //   81: iconst_0
    //   82: iload_2
    //   83: invokevirtual 59	java/util/zip/GZIPOutputStream:write	([BII)V
    //   86: goto -25 -> 61
    //   89: astore 8
    //   91: aload_3
    //   92: astore 5
    //   94: aload 4
    //   96: astore 6
    //   98: aload 7
    //   100: astore 4
    //   102: aload 8
    //   104: astore_3
    //   105: aload 4
    //   107: invokestatic 64	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   110: aload 5
    //   112: invokestatic 67	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   115: aload 6
    //   117: invokestatic 64	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   120: iload_1
    //   121: ifeq +8 -> 129
    //   124: aload_0
    //   125: invokevirtual 71	java/io/File:delete	()Z
    //   128: pop
    //   129: aload_3
    //   130: athrow
    //   131: aload 7
    //   133: invokevirtual 74	java/util/zip/GZIPOutputStream:finish	()V
    //   136: aload 7
    //   138: invokevirtual 77	java/util/zip/GZIPOutputStream:flush	()V
    //   141: aload 4
    //   143: invokevirtual 78	java/io/FileOutputStream:flush	()V
    //   146: aload 7
    //   148: invokestatic 64	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   151: aload_3
    //   152: invokestatic 67	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   155: aload 4
    //   157: invokestatic 64	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   160: iload_1
    //   161: ifeq +8 -> 169
    //   164: aload_0
    //   165: invokevirtual 71	java/io/File:delete	()Z
    //   168: pop
    //   169: return
    //   170: astore_3
    //   171: aconst_null
    //   172: astore 4
    //   174: aconst_null
    //   175: astore 5
    //   177: goto -72 -> 105
    //   180: astore 7
    //   182: aconst_null
    //   183: astore 4
    //   185: aload_3
    //   186: astore 5
    //   188: aload 7
    //   190: astore_3
    //   191: goto -86 -> 105
    //   194: astore 8
    //   196: aconst_null
    //   197: astore 7
    //   199: aload 4
    //   201: astore 6
    //   203: aload_3
    //   204: astore 5
    //   206: aload 8
    //   208: astore_3
    //   209: aload 7
    //   211: astore 4
    //   213: goto -108 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramFile	File
    //   0	216	1	paramBoolean	boolean
    //   71	12	2	i	int
    //   11	141	3	localObject1	Object
    //   170	16	3	localObject2	Object
    //   190	19	3	localObject3	Object
    //   41	171	4	localObject4	Object
    //   59	146	5	localObject5	Object
    //   1	201	6	localObject6	Object
    //   52	95	7	localGZIPOutputStream	GZIPOutputStream
    //   180	9	7	localObject7	Object
    //   197	13	7	localObject8	Object
    //   89	14	8	localObject9	Object
    //   194	13	8	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   54	61	89	finally
    //   61	72	89	finally
    //   77	86	89	finally
    //   131	146	89	finally
    //   3	12	170	finally
    //   12	43	180	finally
    //   43	54	194	finally
  }
  
  public static void compress(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    try
    {
      paramOutputStream = new GZIPOutputStream(paramOutputStream);
      try
      {
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte, 0, 1024);
          if (i == -1) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
        IOUtils.closeQuietly(paramOutputStream);
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        paramOutputStream = null;
      }
    }
    throw paramInputStream;
    paramOutputStream.finish();
    paramOutputStream.flush();
    IOUtils.closeQuietly(paramOutputStream);
  }
  
  public static void compress(String paramString)
  {
    compress(paramString, true);
  }
  
  public static void compress(String paramString, boolean paramBoolean)
  {
    compress(new File(paramString), paramBoolean);
  }
  
  public static byte[] compress(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    compress(paramArrayOfByte, localByteArrayOutputStream);
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    paramArrayOfByte.close();
    return arrayOfByte;
  }
  
  public static void decompress(File paramFile)
  {
    decompress(paramFile, true);
  }
  
  public static void decompress(File paramFile, boolean paramBoolean)
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile.getPath().replace(".gz", ""));
    decompress(localFileInputStream, localFileOutputStream);
    localFileInputStream.close();
    localFileOutputStream.flush();
    localFileOutputStream.close();
    if (paramBoolean) {
      paramFile.delete();
    }
  }
  
  public static void decompress(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    try
    {
      paramInputStream = new GZIPInputStream(paramInputStream);
      try
      {
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte, 0, 1024);
          if (i == -1) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
        IOUtils.closeQuietly(paramOutputStream);
      }
      finally
      {
        paramOutputStream = paramInputStream;
        paramInputStream = localObject;
      }
    }
    finally
    {
      for (;;)
      {
        paramOutputStream = null;
      }
    }
    throw paramInputStream;
    IOUtils.closeQuietly(paramInputStream);
  }
  
  public static void decompress(String paramString)
  {
    decompress(paramString, true);
  }
  
  public static void decompress(String paramString, boolean paramBoolean)
  {
    decompress(new File(paramString), paramBoolean);
  }
  
  public static byte[] decompress(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    decompress(paramArrayOfByte, localByteArrayOutputStream);
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    paramArrayOfByte.close();
    return arrayOfByte;
  }
  
  private static String getValidateName(ZipEntry paramZipEntry)
  {
    paramZipEntry = new String(paramZipEntry.getName().getBytes("8859_1"), "GB2312");
    if (paramZipEntry.contains("../")) {
      throw new IOException("Unsafe zip file");
    }
    return paramZipEntry;
  }
  
  /* Error */
  public static int unZipFolder(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 32	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 5
    //   13: aload 5
    //   15: invokevirtual 171	java/io/File:exists	()Z
    //   18: ifne +9 -> 27
    //   21: aload 5
    //   23: invokevirtual 174	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: new 32	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_0
    //   36: new 176	java/util/zip/ZipFile
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 177	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   44: astore 8
    //   46: aload 8
    //   48: invokevirtual 181	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   51: astore 9
    //   53: aload 9
    //   55: invokeinterface 186 1 0
    //   60: ifeq +441 -> 501
    //   63: aload 9
    //   65: invokeinterface 190 1 0
    //   70: checkcast 135	java/util/zip/ZipEntry
    //   73: astore 10
    //   75: aload 10
    //   77: invokevirtual 193	java/util/zip/ZipEntry:isDirectory	()Z
    //   80: ifeq +79 -> 159
    //   83: aload 10
    //   85: invokestatic 195	com/tencent/falco/utils/GZipUtil:getValidateName	(Ljava/util/zip/ZipEntry;)Ljava/lang/String;
    //   88: astore_0
    //   89: new 32	java/io/File
    //   92: dup
    //   93: new 29	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   100: aload_1
    //   101: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: getstatic 198	java/io/File:separator	Ljava/lang/String;
    //   107: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   120: astore_0
    //   121: aload_0
    //   122: invokevirtual 171	java/io/File:exists	()Z
    //   125: ifne -72 -> 53
    //   128: aload_0
    //   129: invokevirtual 174	java/io/File:mkdirs	()Z
    //   132: pop
    //   133: goto -80 -> 53
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 201	java/io/FileNotFoundException:printStackTrace	()V
    //   141: iconst_5
    //   142: istore_2
    //   143: aload 8
    //   145: invokevirtual 202	java/util/zip/ZipFile:close	()V
    //   148: iload_2
    //   149: ireturn
    //   150: astore_0
    //   151: iconst_1
    //   152: ireturn
    //   153: astore_0
    //   154: iconst_2
    //   155: ireturn
    //   156: astore_0
    //   157: iconst_3
    //   158: ireturn
    //   159: aload 8
    //   161: aload 10
    //   163: invokevirtual 206	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   166: astore_0
    //   167: new 208	java/util/zip/CheckedInputStream
    //   170: dup
    //   171: aload_0
    //   172: new 210	java/util/zip/CRC32
    //   175: dup
    //   176: invokespecial 211	java/util/zip/CRC32:<init>	()V
    //   179: invokespecial 214	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   182: astore 5
    //   184: new 32	java/io/File
    //   187: dup
    //   188: new 113	java/lang/String
    //   191: dup
    //   192: new 29	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   199: aload_1
    //   200: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: getstatic 198	java/io/File:separator	Ljava/lang/String;
    //   206: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 10
    //   211: invokestatic 195	com/tencent/falco/utils/GZipUtil:getValidateName	(Ljava/util/zip/ZipEntry;)Ljava/lang/String;
    //   214: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: ldc 140
    //   222: invokevirtual 144	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   225: ldc 146
    //   227: invokespecial 149	java/lang/String:<init>	([BLjava/lang/String;)V
    //   230: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   233: astore 7
    //   235: aload 7
    //   237: invokevirtual 171	java/io/File:exists	()Z
    //   240: ifne +30 -> 270
    //   243: aload 7
    //   245: invokevirtual 218	java/io/File:getParentFile	()Ljava/io/File;
    //   248: astore 11
    //   250: aload 11
    //   252: invokevirtual 171	java/io/File:exists	()Z
    //   255: ifne +9 -> 264
    //   258: aload 11
    //   260: invokevirtual 174	java/io/File:mkdirs	()Z
    //   263: pop
    //   264: aload 7
    //   266: invokevirtual 221	java/io/File:createNewFile	()Z
    //   269: pop
    //   270: new 27	java/io/FileOutputStream
    //   273: dup
    //   274: aload 7
    //   276: invokespecial 222	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   279: astore 7
    //   281: sipush 4096
    //   284: newarray byte
    //   286: astore 11
    //   288: aload 10
    //   290: invokevirtual 226	java/util/zip/ZipEntry:getSize	()J
    //   293: lstore_3
    //   294: lload_3
    //   295: lconst_0
    //   296: lcmp
    //   297: ifle +32 -> 329
    //   300: aload 5
    //   302: aload 11
    //   304: iconst_0
    //   305: sipush 4096
    //   308: invokevirtual 227	java/util/zip/CheckedInputStream:read	([BII)I
    //   311: istore_2
    //   312: aload 7
    //   314: aload 11
    //   316: iconst_0
    //   317: iload_2
    //   318: invokevirtual 129	java/io/OutputStream:write	([BII)V
    //   321: lload_3
    //   322: iload_2
    //   323: i2l
    //   324: lsub
    //   325: lstore_3
    //   326: goto -32 -> 294
    //   329: aload 10
    //   331: invokevirtual 230	java/util/zip/ZipEntry:getCrc	()J
    //   334: aload 5
    //   336: invokevirtual 234	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   339: invokeinterface 239 1 0
    //   344: lcmp
    //   345: ifeq +42 -> 387
    //   348: aload_0
    //   349: invokevirtual 240	java/io/InputStream:close	()V
    //   352: aload 7
    //   354: invokevirtual 241	java/io/OutputStream:close	()V
    //   357: iconst_4
    //   358: istore_2
    //   359: aload_0
    //   360: invokestatic 67	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   363: aload 7
    //   365: invokestatic 64	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   368: aload 5
    //   370: invokestatic 67	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   373: goto -230 -> 143
    //   376: astore_0
    //   377: aload_0
    //   378: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   381: bipush 6
    //   383: istore_2
    //   384: goto -241 -> 143
    //   387: aload_0
    //   388: invokestatic 67	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   391: aload 7
    //   393: invokestatic 64	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   396: aload 5
    //   398: invokestatic 67	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   401: goto -348 -> 53
    //   404: astore_0
    //   405: aload_0
    //   406: invokevirtual 243	java/lang/Exception:printStackTrace	()V
    //   409: bipush 7
    //   411: istore_2
    //   412: goto -269 -> 143
    //   415: astore_0
    //   416: aconst_null
    //   417: astore_1
    //   418: aconst_null
    //   419: astore 5
    //   421: aload 5
    //   423: invokestatic 67	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   426: aload_1
    //   427: invokestatic 64	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   430: aload 6
    //   432: invokestatic 67	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   435: aload_0
    //   436: athrow
    //   437: astore_0
    //   438: aload_0
    //   439: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   442: bipush 8
    //   444: ireturn
    //   445: astore 7
    //   447: aconst_null
    //   448: astore_1
    //   449: aload_0
    //   450: astore 5
    //   452: aload 7
    //   454: astore_0
    //   455: goto -34 -> 421
    //   458: astore 6
    //   460: aconst_null
    //   461: astore_1
    //   462: aload_0
    //   463: astore 7
    //   465: aload 6
    //   467: astore_0
    //   468: aload 5
    //   470: astore 6
    //   472: aload 7
    //   474: astore 5
    //   476: goto -55 -> 421
    //   479: astore 6
    //   481: aload 7
    //   483: astore_1
    //   484: aload_0
    //   485: astore 7
    //   487: aload 6
    //   489: astore_0
    //   490: aload 5
    //   492: astore 6
    //   494: aload 7
    //   496: astore 5
    //   498: goto -77 -> 421
    //   501: iconst_0
    //   502: istore_2
    //   503: goto -360 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	paramString1	String
    //   0	506	1	paramString2	String
    //   142	361	2	i	int
    //   293	33	3	l	long
    //   11	486	5	localObject1	Object
    //   1	430	6	localInputStream	InputStream
    //   458	8	6	localObject2	Object
    //   470	1	6	localObject3	Object
    //   479	9	6	localObject4	Object
    //   492	1	6	localObject5	Object
    //   233	159	7	localObject6	Object
    //   445	8	7	localObject7	Object
    //   463	32	7	str	String
    //   44	116	8	localZipFile	java.util.zip.ZipFile
    //   51	13	9	localEnumeration	java.util.Enumeration
    //   73	257	10	localZipEntry	ZipEntry
    //   248	67	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   46	53	136	java/io/FileNotFoundException
    //   53	133	136	java/io/FileNotFoundException
    //   359	373	136	java/io/FileNotFoundException
    //   387	401	136	java/io/FileNotFoundException
    //   421	437	136	java/io/FileNotFoundException
    //   36	46	150	java/util/zip/ZipException
    //   36	46	153	java/io/IOException
    //   36	46	156	java/lang/Exception
    //   46	53	376	java/io/IOException
    //   53	133	376	java/io/IOException
    //   359	373	376	java/io/IOException
    //   387	401	376	java/io/IOException
    //   421	437	376	java/io/IOException
    //   46	53	404	java/lang/Exception
    //   53	133	404	java/lang/Exception
    //   359	373	404	java/lang/Exception
    //   387	401	404	java/lang/Exception
    //   421	437	404	java/lang/Exception
    //   159	167	415	finally
    //   143	148	437	java/io/IOException
    //   167	184	445	finally
    //   184	264	458	finally
    //   264	270	458	finally
    //   270	281	458	finally
    //   281	294	479	finally
    //   300	321	479	finally
    //   329	357	479	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.GZipUtil
 * JD-Core Version:    0.7.0.1
 */