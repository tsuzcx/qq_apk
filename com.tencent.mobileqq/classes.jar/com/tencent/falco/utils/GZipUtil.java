package com.tencent.falco.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
    //   1: astore 5
    //   3: new 23	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 25	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore 6
    //   13: new 27	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   20: astore_3
    //   21: aload_3
    //   22: aload_0
    //   23: invokevirtual 34	java/io/File:getPath	()Ljava/lang/String;
    //   26: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_3
    //   31: ldc 11
    //   33: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: new 40	java/io/FileOutputStream
    //   40: dup
    //   41: aload_3
    //   42: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 46	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: new 48	java/util/zip/GZIPOutputStream
    //   52: dup
    //   53: aload_3
    //   54: invokespecial 51	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: astore 7
    //   59: sipush 1024
    //   62: newarray byte
    //   64: astore 4
    //   66: aload 6
    //   68: aload 4
    //   70: iconst_0
    //   71: sipush 1024
    //   74: invokevirtual 55	java/io/FileInputStream:read	([BII)I
    //   77: istore_2
    //   78: iload_2
    //   79: iconst_m1
    //   80: if_icmpeq +15 -> 95
    //   83: aload 7
    //   85: aload 4
    //   87: iconst_0
    //   88: iload_2
    //   89: invokevirtual 59	java/util/zip/GZIPOutputStream:write	([BII)V
    //   92: goto -26 -> 66
    //   95: aload 7
    //   97: invokevirtual 62	java/util/zip/GZIPOutputStream:finish	()V
    //   100: aload 7
    //   102: invokevirtual 65	java/util/zip/GZIPOutputStream:flush	()V
    //   105: aload_3
    //   106: invokevirtual 66	java/io/FileOutputStream:flush	()V
    //   109: aload 7
    //   111: invokestatic 71	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   114: aload 6
    //   116: invokestatic 74	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   119: aload_3
    //   120: invokestatic 71	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   123: iload_1
    //   124: ifeq +8 -> 132
    //   127: aload_0
    //   128: invokevirtual 78	java/io/File:delete	()Z
    //   131: pop
    //   132: return
    //   133: astore 4
    //   135: aload 7
    //   137: astore 5
    //   139: aload_3
    //   140: astore 7
    //   142: aload 4
    //   144: astore_3
    //   145: aload 7
    //   147: astore 4
    //   149: goto +29 -> 178
    //   152: astore 7
    //   154: aload_3
    //   155: astore 4
    //   157: aload 7
    //   159: astore_3
    //   160: goto +18 -> 178
    //   163: astore_3
    //   164: aconst_null
    //   165: astore 4
    //   167: goto +11 -> 178
    //   170: astore_3
    //   171: aconst_null
    //   172: astore 4
    //   174: aload 4
    //   176: astore 6
    //   178: aload 5
    //   180: invokestatic 71	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   183: aload 6
    //   185: invokestatic 74	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   188: aload 4
    //   190: invokestatic 71	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   193: iload_1
    //   194: ifeq +8 -> 202
    //   197: aload_0
    //   198: invokevirtual 78	java/io/File:delete	()Z
    //   201: pop
    //   202: goto +5 -> 207
    //   205: aload_3
    //   206: athrow
    //   207: goto -2 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramFile	File
    //   0	210	1	paramBoolean	boolean
    //   77	12	2	i	int
    //   20	140	3	localObject1	Object
    //   163	1	3	localObject2	Object
    //   170	36	3	localObject3	Object
    //   64	22	4	arrayOfByte	byte[]
    //   133	10	4	localObject4	Object
    //   147	42	4	localObject5	Object
    //   1	178	5	localObject6	Object
    //   11	173	6	localObject7	Object
    //   57	89	7	localObject8	Object
    //   152	6	7	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   59	66	133	finally
    //   66	78	133	finally
    //   83	92	133	finally
    //   95	109	133	finally
    //   49	59	152	finally
    //   13	49	163	finally
    //   3	13	170	finally
  }
  
  /* Error */
  public static void compress(java.io.InputStream paramInputStream, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: new 48	java/util/zip/GZIPOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 51	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   8: astore_1
    //   9: sipush 1024
    //   12: newarray byte
    //   14: astore_3
    //   15: aload_0
    //   16: aload_3
    //   17: iconst_0
    //   18: sipush 1024
    //   21: invokevirtual 82	java/io/InputStream:read	([BII)I
    //   24: istore_2
    //   25: iload_2
    //   26: iconst_m1
    //   27: if_icmpeq +13 -> 40
    //   30: aload_1
    //   31: aload_3
    //   32: iconst_0
    //   33: iload_2
    //   34: invokevirtual 59	java/util/zip/GZIPOutputStream:write	([BII)V
    //   37: goto -22 -> 15
    //   40: aload_1
    //   41: invokevirtual 62	java/util/zip/GZIPOutputStream:finish	()V
    //   44: aload_1
    //   45: invokevirtual 65	java/util/zip/GZIPOutputStream:flush	()V
    //   48: aload_1
    //   49: invokestatic 71	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   52: return
    //   53: astore_3
    //   54: aload_1
    //   55: astore_0
    //   56: aload_3
    //   57: astore_1
    //   58: goto +6 -> 64
    //   61: astore_1
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_0
    //   65: invokestatic 71	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   68: goto +5 -> 73
    //   71: aload_1
    //   72: athrow
    //   73: goto -2 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramInputStream	java.io.InputStream
    //   0	76	1	paramOutputStream	java.io.OutputStream
    //   24	10	2	i	int
    //   14	18	3	arrayOfByte	byte[]
    //   53	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	15	53	finally
    //   15	25	53	finally
    //   30	37	53	finally
    //   40	48	53	finally
    //   0	9	61	finally
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
  
  /* Error */
  public static void decompress(java.io.InputStream paramInputStream, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: new 123	java/util/zip/GZIPInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 125	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   8: astore_0
    //   9: sipush 1024
    //   12: newarray byte
    //   14: astore_3
    //   15: aload_0
    //   16: aload_3
    //   17: iconst_0
    //   18: sipush 1024
    //   21: invokevirtual 126	java/util/zip/GZIPInputStream:read	([BII)I
    //   24: istore_2
    //   25: iload_2
    //   26: iconst_m1
    //   27: if_icmpeq +13 -> 40
    //   30: aload_1
    //   31: aload_3
    //   32: iconst_0
    //   33: iload_2
    //   34: invokevirtual 129	java/io/OutputStream:write	([BII)V
    //   37: goto -22 -> 15
    //   40: aload_0
    //   41: invokestatic 74	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   44: return
    //   45: astore_1
    //   46: goto +6 -> 52
    //   49: astore_1
    //   50: aconst_null
    //   51: astore_0
    //   52: aload_0
    //   53: invokestatic 74	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   56: goto +5 -> 61
    //   59: aload_1
    //   60: athrow
    //   61: goto -2 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramInputStream	java.io.InputStream
    //   0	64	1	paramOutputStream	java.io.OutputStream
    //   24	10	2	i	int
    //   14	18	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   9	15	45	finally
    //   15	25	45	finally
    //   30	37	45	finally
    //   0	9	49	finally
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
    if (!paramZipEntry.contains("../")) {
      return paramZipEntry;
    }
    throw new IOException("Unsafe zip file");
  }
  
  /* Error */
  public static int unZipFolder(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 30	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 6
    //   10: aload 6
    //   12: invokevirtual 171	java/io/File:exists	()Z
    //   15: ifne +9 -> 24
    //   18: aload 6
    //   20: invokevirtual 174	java/io/File:mkdirs	()Z
    //   23: pop
    //   24: new 30	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_0
    //   33: new 176	java/util/zip/ZipFile
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 177	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   41: astore 10
    //   43: aload 10
    //   45: invokevirtual 181	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   48: astore 9
    //   50: aload 9
    //   52: invokeinterface 186 1 0
    //   57: istore_3
    //   58: iconst_0
    //   59: istore_2
    //   60: iload_3
    //   61: ifeq +388 -> 449
    //   64: aload 9
    //   66: invokeinterface 190 1 0
    //   71: checkcast 135	java/util/zip/ZipEntry
    //   74: astore 11
    //   76: aload 11
    //   78: invokevirtual 193	java/util/zip/ZipEntry:isDirectory	()Z
    //   81: ifeq +69 -> 150
    //   84: aload 11
    //   86: invokestatic 195	com/tencent/falco/utils/GZipUtil:getValidateName	(Ljava/util/zip/ZipEntry;)Ljava/lang/String;
    //   89: astore_0
    //   90: new 27	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   97: astore 6
    //   99: aload 6
    //   101: aload_1
    //   102: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 6
    //   108: getstatic 198	java/io/File:separator	Ljava/lang/String;
    //   111: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 6
    //   117: aload_0
    //   118: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: new 30	java/io/File
    //   125: dup
    //   126: aload 6
    //   128: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 171	java/io/File:exists	()Z
    //   139: ifne -89 -> 50
    //   142: aload_0
    //   143: invokevirtual 174	java/io/File:mkdirs	()Z
    //   146: pop
    //   147: goto -97 -> 50
    //   150: aconst_null
    //   151: astore 6
    //   153: aload 10
    //   155: aload 11
    //   157: invokevirtual 202	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   160: astore 7
    //   162: new 204	java/util/zip/CheckedInputStream
    //   165: dup
    //   166: aload 7
    //   168: new 206	java/util/zip/CRC32
    //   171: dup
    //   172: invokespecial 207	java/util/zip/CRC32:<init>	()V
    //   175: invokespecial 210	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   178: astore_0
    //   179: new 27	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   186: astore 8
    //   188: aload 8
    //   190: aload_1
    //   191: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 8
    //   197: getstatic 198	java/io/File:separator	Ljava/lang/String;
    //   200: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 8
    //   206: aload 11
    //   208: invokestatic 195	com/tencent/falco/utils/GZipUtil:getValidateName	(Ljava/util/zip/ZipEntry;)Ljava/lang/String;
    //   211: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: new 30	java/io/File
    //   218: dup
    //   219: new 113	java/lang/String
    //   222: dup
    //   223: aload 8
    //   225: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: ldc 140
    //   230: invokevirtual 144	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   233: ldc 146
    //   235: invokespecial 149	java/lang/String:<init>	([BLjava/lang/String;)V
    //   238: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   241: astore 8
    //   243: aload 8
    //   245: invokevirtual 171	java/io/File:exists	()Z
    //   248: ifne +30 -> 278
    //   251: aload 8
    //   253: invokevirtual 214	java/io/File:getParentFile	()Ljava/io/File;
    //   256: astore 12
    //   258: aload 12
    //   260: invokevirtual 171	java/io/File:exists	()Z
    //   263: ifne +9 -> 272
    //   266: aload 12
    //   268: invokevirtual 174	java/io/File:mkdirs	()Z
    //   271: pop
    //   272: aload 8
    //   274: invokevirtual 217	java/io/File:createNewFile	()Z
    //   277: pop
    //   278: new 40	java/io/FileOutputStream
    //   281: dup
    //   282: aload 8
    //   284: invokespecial 218	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   287: astore 8
    //   289: sipush 4096
    //   292: newarray byte
    //   294: astore 6
    //   296: aload 11
    //   298: invokevirtual 222	java/util/zip/ZipEntry:getSize	()J
    //   301: lstore 4
    //   303: lload 4
    //   305: lconst_0
    //   306: lcmp
    //   307: ifle +33 -> 340
    //   310: aload_0
    //   311: aload 6
    //   313: iconst_0
    //   314: sipush 4096
    //   317: invokevirtual 223	java/util/zip/CheckedInputStream:read	([BII)I
    //   320: istore_2
    //   321: aload 8
    //   323: aload 6
    //   325: iconst_0
    //   326: iload_2
    //   327: invokevirtual 129	java/io/OutputStream:write	([BII)V
    //   330: lload 4
    //   332: iload_2
    //   333: i2l
    //   334: lsub
    //   335: lstore 4
    //   337: goto -34 -> 303
    //   340: aload 11
    //   342: invokevirtual 226	java/util/zip/ZipEntry:getCrc	()J
    //   345: aload_0
    //   346: invokevirtual 230	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   349: invokeinterface 235 1 0
    //   354: lcmp
    //   355: ifeq +32 -> 387
    //   358: aload 7
    //   360: invokevirtual 236	java/io/InputStream:close	()V
    //   363: aload 8
    //   365: invokevirtual 237	java/io/OutputStream:close	()V
    //   368: iconst_4
    //   369: istore_2
    //   370: aload 7
    //   372: invokestatic 74	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   375: aload 8
    //   377: invokestatic 71	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   380: aload_0
    //   381: invokestatic 74	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   384: goto +65 -> 449
    //   387: aload 7
    //   389: invokestatic 74	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   392: aload 8
    //   394: invokestatic 71	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   397: aload_0
    //   398: invokestatic 74	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   401: goto -351 -> 50
    //   404: aload 7
    //   406: invokestatic 74	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   409: aload 6
    //   411: invokestatic 71	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   414: aload_1
    //   415: invokestatic 74	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   418: aload_0
    //   419: athrow
    //   420: astore_0
    //   421: aload_0
    //   422: invokevirtual 240	java/lang/Exception:printStackTrace	()V
    //   425: bipush 7
    //   427: istore_2
    //   428: goto +21 -> 449
    //   431: astore_0
    //   432: aload_0
    //   433: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   436: bipush 6
    //   438: istore_2
    //   439: goto +10 -> 449
    //   442: astore_0
    //   443: aload_0
    //   444: invokevirtual 242	java/io/FileNotFoundException:printStackTrace	()V
    //   447: iconst_5
    //   448: istore_2
    //   449: aload 10
    //   451: invokevirtual 243	java/util/zip/ZipFile:close	()V
    //   454: iload_2
    //   455: ireturn
    //   456: astore_0
    //   457: aload_0
    //   458: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   461: bipush 8
    //   463: ireturn
    //   464: iconst_3
    //   465: ireturn
    //   466: iconst_2
    //   467: ireturn
    //   468: iconst_1
    //   469: ireturn
    //   470: astore_0
    //   471: goto -3 -> 468
    //   474: astore_0
    //   475: goto -9 -> 466
    //   478: astore_0
    //   479: goto -15 -> 464
    //   482: astore 9
    //   484: aload 8
    //   486: astore 6
    //   488: aload_0
    //   489: astore_1
    //   490: aload 9
    //   492: astore_0
    //   493: goto -89 -> 404
    //   496: astore 8
    //   498: aload_0
    //   499: astore_1
    //   500: aload 8
    //   502: astore_0
    //   503: goto -99 -> 404
    //   506: astore_0
    //   507: aconst_null
    //   508: astore_1
    //   509: goto -105 -> 404
    //   512: astore_0
    //   513: aconst_null
    //   514: astore 7
    //   516: aload 7
    //   518: astore_1
    //   519: goto -115 -> 404
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	522	0	paramString1	String
    //   0	522	1	paramString2	String
    //   59	396	2	i	int
    //   57	4	3	bool	boolean
    //   301	35	4	l	long
    //   8	479	6	localObject1	Object
    //   160	357	7	localInputStream	java.io.InputStream
    //   186	299	8	localObject2	Object
    //   496	5	8	localObject3	Object
    //   48	17	9	localEnumeration	java.util.Enumeration
    //   482	9	9	localObject4	Object
    //   41	409	10	localZipFile	java.util.zip.ZipFile
    //   74	267	11	localZipEntry	ZipEntry
    //   256	11	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   43	50	420	java/lang/Exception
    //   50	58	420	java/lang/Exception
    //   64	147	420	java/lang/Exception
    //   370	384	420	java/lang/Exception
    //   387	401	420	java/lang/Exception
    //   404	420	420	java/lang/Exception
    //   43	50	431	java/io/IOException
    //   50	58	431	java/io/IOException
    //   64	147	431	java/io/IOException
    //   370	384	431	java/io/IOException
    //   387	401	431	java/io/IOException
    //   404	420	431	java/io/IOException
    //   43	50	442	java/io/FileNotFoundException
    //   50	58	442	java/io/FileNotFoundException
    //   64	147	442	java/io/FileNotFoundException
    //   370	384	442	java/io/FileNotFoundException
    //   387	401	442	java/io/FileNotFoundException
    //   404	420	442	java/io/FileNotFoundException
    //   449	454	456	java/io/IOException
    //   33	43	470	java/util/zip/ZipException
    //   33	43	474	java/io/IOException
    //   33	43	478	java/lang/Exception
    //   289	303	482	finally
    //   310	330	482	finally
    //   340	368	482	finally
    //   179	272	496	finally
    //   272	278	496	finally
    //   278	289	496	finally
    //   162	179	506	finally
    //   153	162	512	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.GZipUtil
 * JD-Core Version:    0.7.0.1
 */