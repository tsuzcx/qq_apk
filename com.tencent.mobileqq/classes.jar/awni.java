import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

public class awni
{
  protected static MessageDigest a;
  private static final int[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 2, 3 };
  }
  
  public static String a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return bdfr.encodeToString(localByteArrayOutputStream.toByteArray(), 2);
  }
  
  public static String a(String paramString)
  {
    localObject3 = null;
    try
    {
      byte[] arrayOfByte = MD5.getPartfileMd5(paramString, 0L);
      localObject1 = localObject3;
      if (arrayOfByte != null) {
        localObject1 = bhpp.b(arrayOfByte);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        localException.printStackTrace();
        QLog.e("PortalManager.PortalUtils", 2, "error ........ error getFileMD5String filePath: " + paramString + ", error=" + localException.getMessage());
        Object localObject2 = localObject3;
      }
    }
    if (QLog.isDebugVersion()) {
      QLog.e("PortalManager.PortalUtils", 2, "getFileMD5String md5: " + (String)localObject1);
    }
    return localObject1;
  }
  
  public static String a(String paramString, long paramLong)
  {
    for (i = 1;; i = j)
    {
      try
      {
        Long.valueOf(paramString);
        j = Integer.valueOf(paramString.substring(0, 1)).intValue() % 4;
        if (j != 0) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          int j;
          String str;
          i = 2;
        }
      }
      paramString = new StringBuilder();
      paramString.append("factorIndex").append("=").append(i).append(",");
      paramLong <<= i;
      paramString.append("value1").append("=").append(paramLong).append(",");
      str = i + paramLong;
      paramString.append("value2").append("=").append(str).append(",");
      str = bdfr.encodeToString(str.getBytes(), 2);
      paramString.append("value3").append("=").append(str);
      if (QLog.isColorLevel()) {
        QLog.d("PortalUtils", 2, paramString.toString());
      }
      return str;
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (jdField_a_of_type_JavaSecurityMessageDigest == null) {}
    try
    {
      jdField_a_of_type_JavaSecurityMessageDigest = MessageDigest.getInstance("MD5");
      jdField_a_of_type_JavaSecurityMessageDigest.update(paramArrayOfByte);
      return bhpp.b(jdField_a_of_type_JavaSecurityMessageDigest.digest());
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_0
    //   9: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +7 -> 19
    //   15: aload_2
    //   16: astore_0
    //   17: aload_0
    //   18: areturn
    //   19: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +28 -> 50
    //   25: ldc 63
    //   27: iconst_2
    //   28: new 65	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   35: ldc 194
    //   37: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: ldc 196
    //   53: invokevirtual 198	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   56: astore_0
    //   57: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +29 -> 89
    //   63: ldc 63
    //   65: iconst_2
    //   66: new 65	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   73: ldc 200
    //   75: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_0
    //   79: arraylength
    //   80: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: new 202	java/io/ByteArrayInputStream
    //   92: dup
    //   93: aload_0
    //   94: invokespecial 204	java/io/ByteArrayInputStream:<init>	([B)V
    //   97: astore_0
    //   98: new 15	java/io/ByteArrayOutputStream
    //   101: dup
    //   102: invokespecial 18	java/io/ByteArrayOutputStream:<init>	()V
    //   105: astore 6
    //   107: aload 4
    //   109: astore_2
    //   110: aload 5
    //   112: astore_3
    //   113: sipush 1024
    //   116: newarray byte
    //   118: astore 7
    //   120: aload 4
    //   122: astore_2
    //   123: aload 5
    //   125: astore_3
    //   126: new 206	java/util/zip/GZIPOutputStream
    //   129: dup
    //   130: aload 6
    //   132: invokespecial 209	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   135: astore 8
    //   137: aload 4
    //   139: astore_2
    //   140: aload 5
    //   142: astore_3
    //   143: aload_0
    //   144: aload 7
    //   146: iconst_0
    //   147: sipush 1024
    //   150: invokevirtual 213	java/io/ByteArrayInputStream:read	([BII)I
    //   153: istore_1
    //   154: iload_1
    //   155: iconst_m1
    //   156: if_icmpeq +113 -> 269
    //   159: aload 4
    //   161: astore_2
    //   162: aload 5
    //   164: astore_3
    //   165: aload 8
    //   167: aload 7
    //   169: iconst_0
    //   170: iload_1
    //   171: invokevirtual 217	java/util/zip/GZIPOutputStream:write	([BII)V
    //   174: goto -37 -> 137
    //   177: astore_3
    //   178: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   181: ifeq +31 -> 212
    //   184: ldc 63
    //   186: iconst_2
    //   187: new 65	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   194: ldc 219
    //   196: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_3
    //   200: invokevirtual 90	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   203: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload 6
    //   214: invokevirtual 222	java/io/ByteArrayOutputStream:close	()V
    //   217: aload_0
    //   218: invokevirtual 223	java/io/ByteArrayInputStream:close	()V
    //   221: aload_2
    //   222: areturn
    //   223: astore_3
    //   224: aload_2
    //   225: astore_0
    //   226: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq -212 -> 17
    //   232: ldc 63
    //   234: iconst_2
    //   235: new 65	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   242: ldc 225
    //   244: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_3
    //   248: invokevirtual 226	java/io/IOException:getMessage	()Ljava/lang/String;
    //   251: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload_2
    //   261: areturn
    //   262: astore_0
    //   263: aload_0
    //   264: invokevirtual 227	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   267: aconst_null
    //   268: areturn
    //   269: aload 4
    //   271: astore_2
    //   272: aload 5
    //   274: astore_3
    //   275: aload 8
    //   277: invokevirtual 230	java/util/zip/GZIPOutputStream:flush	()V
    //   280: aload 4
    //   282: astore_2
    //   283: aload 5
    //   285: astore_3
    //   286: aload 8
    //   288: invokevirtual 231	java/util/zip/GZIPOutputStream:close	()V
    //   291: aload 4
    //   293: astore_2
    //   294: aload 5
    //   296: astore_3
    //   297: aload 6
    //   299: invokevirtual 34	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   302: astore 4
    //   304: aload 4
    //   306: astore_2
    //   307: aload 4
    //   309: astore_3
    //   310: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +36 -> 349
    //   316: aload 4
    //   318: astore_2
    //   319: aload 4
    //   321: astore_3
    //   322: ldc 63
    //   324: iconst_2
    //   325: new 65	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   332: ldc 233
    //   334: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload 4
    //   339: arraylength
    //   340: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload 6
    //   351: invokevirtual 222	java/io/ByteArrayOutputStream:close	()V
    //   354: aload_0
    //   355: invokevirtual 223	java/io/ByteArrayInputStream:close	()V
    //   358: aload 4
    //   360: areturn
    //   361: astore_2
    //   362: aload 4
    //   364: astore_0
    //   365: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   368: ifeq -351 -> 17
    //   371: ldc 63
    //   373: iconst_2
    //   374: new 65	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   381: ldc 225
    //   383: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload_2
    //   387: invokevirtual 226	java/io/IOException:getMessage	()Ljava/lang/String;
    //   390: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: aload 4
    //   401: areturn
    //   402: astore_2
    //   403: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +31 -> 437
    //   409: ldc 63
    //   411: iconst_2
    //   412: new 65	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   419: ldc 235
    //   421: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_2
    //   425: invokevirtual 236	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   428: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload 6
    //   439: invokevirtual 222	java/io/ByteArrayOutputStream:close	()V
    //   442: aload_0
    //   443: invokevirtual 223	java/io/ByteArrayInputStream:close	()V
    //   446: aload_3
    //   447: areturn
    //   448: astore_2
    //   449: aload_3
    //   450: astore_0
    //   451: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   454: ifeq -437 -> 17
    //   457: ldc 63
    //   459: iconst_2
    //   460: new 65	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   467: ldc 225
    //   469: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_2
    //   473: invokevirtual 226	java/io/IOException:getMessage	()Ljava/lang/String;
    //   476: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: aload_3
    //   486: areturn
    //   487: astore_2
    //   488: aload 6
    //   490: invokevirtual 222	java/io/ByteArrayOutputStream:close	()V
    //   493: aload_0
    //   494: invokevirtual 223	java/io/ByteArrayInputStream:close	()V
    //   497: aload_2
    //   498: athrow
    //   499: astore_0
    //   500: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq -6 -> 497
    //   506: ldc 63
    //   508: iconst_2
    //   509: new 65	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   516: ldc 225
    //   518: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: aload_0
    //   522: invokevirtual 226	java/io/IOException:getMessage	()Ljava/lang/String;
    //   525: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: goto -37 -> 497
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	paramString	String
    //   153	18	1	i	int
    //   7	312	2	arrayOfByte1	byte[]
    //   361	26	2	localIOException1	IOException
    //   402	23	2	localOutOfMemoryError	OutOfMemoryError
    //   448	25	2	localIOException2	IOException
    //   487	11	2	localObject1	Object
    //   112	53	3	localObject2	Object
    //   177	23	3	localException	Exception
    //   223	25	3	localIOException3	IOException
    //   274	212	3	localObject3	Object
    //   1	399	4	arrayOfByte2	byte[]
    //   4	291	5	localObject4	Object
    //   105	384	6	localByteArrayOutputStream	ByteArrayOutputStream
    //   118	50	7	arrayOfByte3	byte[]
    //   135	152	8	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   113	120	177	java/lang/Exception
    //   126	137	177	java/lang/Exception
    //   143	154	177	java/lang/Exception
    //   165	174	177	java/lang/Exception
    //   275	280	177	java/lang/Exception
    //   286	291	177	java/lang/Exception
    //   297	304	177	java/lang/Exception
    //   310	316	177	java/lang/Exception
    //   322	349	177	java/lang/Exception
    //   212	221	223	java/io/IOException
    //   50	57	262	java/io/UnsupportedEncodingException
    //   349	358	361	java/io/IOException
    //   113	120	402	java/lang/OutOfMemoryError
    //   126	137	402	java/lang/OutOfMemoryError
    //   143	154	402	java/lang/OutOfMemoryError
    //   165	174	402	java/lang/OutOfMemoryError
    //   275	280	402	java/lang/OutOfMemoryError
    //   286	291	402	java/lang/OutOfMemoryError
    //   297	304	402	java/lang/OutOfMemoryError
    //   310	316	402	java/lang/OutOfMemoryError
    //   322	349	402	java/lang/OutOfMemoryError
    //   437	446	448	java/io/IOException
    //   113	120	487	finally
    //   126	137	487	finally
    //   143	154	487	finally
    //   165	174	487	finally
    //   178	212	487	finally
    //   275	280	487	finally
    //   286	291	487	finally
    //   297	304	487	finally
    //   310	316	487	finally
    //   322	349	487	finally
    //   403	437	487	finally
    //   488	497	499	java/io/IOException
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +6 -> 10
    //   7: ldc 238
    //   9: areturn
    //   10: new 65	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   17: astore 6
    //   19: aload_0
    //   20: invokevirtual 131	java/lang/String:getBytes	()[B
    //   23: iconst_2
    //   24: invokestatic 242	bdfr:decode	([BI)[B
    //   27: astore_0
    //   28: new 99	java/lang/String
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 243	java/lang/String:<init>	([B)V
    //   36: astore 7
    //   38: aload 6
    //   40: ldc 245
    //   42: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 116
    //   47: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: ldc 121
    //   56: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 7
    //   62: iconst_0
    //   63: iconst_1
    //   64: invokevirtual 103	java/lang/String:substring	(II)Ljava/lang/String;
    //   67: invokestatic 108	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   70: invokevirtual 112	java/lang/Integer:intValue	()I
    //   73: istore_1
    //   74: aload 6
    //   76: ldc 250
    //   78: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 116
    //   83: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: iload_1
    //   87: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: ldc 121
    //   92: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 7
    //   98: iconst_1
    //   99: invokevirtual 253	java/lang/String:substring	(I)Ljava/lang/String;
    //   102: invokestatic 97	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   105: invokevirtual 257	java/lang/Long:longValue	()J
    //   108: lstore_2
    //   109: lload_2
    //   110: iload_1
    //   111: lshr
    //   112: lstore_2
    //   113: aload 6
    //   115: ldc_w 259
    //   118: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 116
    //   123: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: lload_2
    //   127: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: lload_2
    //   132: lstore 4
    //   134: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +17 -> 154
    //   140: ldc 138
    //   142: iconst_2
    //   143: aload 6
    //   145: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: lload_2
    //   152: lstore 4
    //   154: lload 4
    //   156: invokestatic 262	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   159: areturn
    //   160: astore_0
    //   161: lconst_0
    //   162: lstore_2
    //   163: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +12 -> 178
    //   169: ldc 138
    //   171: iconst_2
    //   172: ldc 238
    //   174: aload_0
    //   175: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   178: lload_2
    //   179: lstore 4
    //   181: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq -30 -> 154
    //   187: ldc 138
    //   189: iconst_2
    //   190: aload 6
    //   192: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: lload_2
    //   199: lstore 4
    //   201: goto -47 -> 154
    //   204: astore_0
    //   205: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +14 -> 222
    //   211: ldc 138
    //   213: iconst_2
    //   214: aload 6
    //   216: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_0
    //   223: athrow
    //   224: astore_0
    //   225: goto -62 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramString	String
    //   73	39	1	i	int
    //   108	91	2	l1	long
    //   132	68	4	l2	long
    //   17	198	6	localStringBuilder	StringBuilder
    //   36	61	7	str	String
    // Exception table:
    //   from	to	target	type
    //   19	109	160	java/lang/Exception
    //   19	109	204	finally
    //   113	131	204	finally
    //   163	178	204	finally
    //   113	131	224	java/lang/Exception
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new byte[1024];
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(localByteArrayInputStream);
      for (;;)
      {
        int i = localGZIPInputStream.read(paramArrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
      }
      byte[] arrayOfByte1;
      byte[] arrayOfByte2;
      for (;;) {}
    }
    catch (Exception localException1)
    {
      paramArrayOfByte = null;
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw error," + localException1.getMessage());
      }
      try
      {
        localByteArrayOutputStream.close();
        localByteArrayInputStream.close();
        arrayOfByte1 = paramArrayOfByte;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("PortalManager.PortalUtils", 2, "ungzip:after unzip length:" + paramArrayOfByte.length);
            }
            try
            {
              localByteArrayOutputStream.close();
              localByteArrayInputStream.close();
              arrayOfByte1 = paramArrayOfByte;
            }
            catch (IOException localIOException2)
            {
              arrayOfByte1 = paramArrayOfByte;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw ioexception," + localIOException2.getMessage());
            arrayOfByte1 = paramArrayOfByte;
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            continue;
          }
          catch (Exception localException2) {}
          localIOException3 = localIOException3;
          arrayOfByte1 = paramArrayOfByte;
          if (QLog.isColorLevel())
          {
            QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw ioexception," + localIOException3.getMessage());
            arrayOfByte1 = paramArrayOfByte;
          }
        }
      }
      try
      {
        paramArrayOfByte = new String(arrayOfByte1, "UTF-8");
        return paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      arrayOfByte1.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        paramArrayOfByte = null;
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw error," + localOutOfMemoryError1.getMessage());
        }
        try
        {
          localByteArrayOutputStream.close();
          localIOException3.close();
          arrayOfByte2 = paramArrayOfByte;
        }
        catch (IOException localIOException4)
        {
          arrayOfByte2 = paramArrayOfByte;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw ioexception," + localIOException4.getMessage());
          arrayOfByte2 = paramArrayOfByte;
        }
      }
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localIOException4.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw ioexception," + localIOException1.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awni
 * JD-Core Version:    0.7.0.1
 */