import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import java.io.File;
import mqq.manager.TicketManager;

public class auyl
{
  /* Error */
  public static android.graphics.Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_2
    //   3: astore_1
    //   4: aload_0
    //   5: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifne +56 -> 64
    //   11: new 18	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_2
    //   21: astore_1
    //   22: aload_0
    //   23: invokevirtual 26	java/io/File:exists	()Z
    //   26: ifeq +38 -> 64
    //   29: new 28	java/io/BufferedInputStream
    //   32: dup
    //   33: new 30	java/io/FileInputStream
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 33	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: invokespecial 36	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_0
    //   45: aload_0
    //   46: invokestatic 42	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   49: astore_1
    //   50: aload_1
    //   51: astore_2
    //   52: aload_2
    //   53: astore_1
    //   54: aload_0
    //   55: ifnull +9 -> 64
    //   58: aload_0
    //   59: invokevirtual 46	java/io/BufferedInputStream:close	()V
    //   62: aload_2
    //   63: astore_1
    //   64: aload_1
    //   65: areturn
    //   66: astore_0
    //   67: aconst_null
    //   68: astore_0
    //   69: aload_2
    //   70: astore_1
    //   71: aload_0
    //   72: ifnull -8 -> 64
    //   75: aload_0
    //   76: invokevirtual 46	java/io/BufferedInputStream:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aconst_null
    //   83: areturn
    //   84: astore_0
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_2
    //   88: astore_1
    //   89: aload_0
    //   90: ifnull -26 -> 64
    //   93: aload_0
    //   94: invokevirtual 46	java/io/BufferedInputStream:close	()V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: aconst_null
    //   101: areturn
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 46	java/io/BufferedInputStream:close	()V
    //   113: aload_1
    //   114: athrow
    //   115: astore_0
    //   116: aload_2
    //   117: areturn
    //   118: astore_0
    //   119: goto -6 -> 113
    //   122: astore_1
    //   123: goto -18 -> 105
    //   126: astore_1
    //   127: goto -40 -> 87
    //   130: astore_1
    //   131: goto -62 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString	String
    //   3	86	1	localObject1	Object
    //   102	12	1	localObject2	Object
    //   122	1	1	localObject3	Object
    //   126	1	1	localException	java.lang.Exception
    //   130	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1	116	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   29	45	66	java/lang/OutOfMemoryError
    //   75	79	81	java/lang/Exception
    //   29	45	84	java/lang/Exception
    //   93	97	99	java/lang/Exception
    //   29	45	102	finally
    //   58	62	115	java/lang/Exception
    //   109	113	118	java/lang/Exception
    //   45	50	122	finally
    //   45	50	126	java/lang/Exception
    //   45	50	130	java/lang/OutOfMemoryError
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append(paramAppInterface.getCurrentAccountUin());
    paramString.append(System.currentTimeMillis());
    return paramString.toString();
  }
  
  /* Error */
  private static String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 83
    //   4: invokestatic 89	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual 92	java/security/MessageDigest:reset	()V
    //   12: new 30	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 33	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_1
    //   21: aload_3
    //   22: aload_1
    //   23: invokevirtual 96	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   26: getstatic 102	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   29: lconst_0
    //   30: aload_0
    //   31: invokevirtual 105	java/io/File:length	()J
    //   34: invokevirtual 111	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   37: invokevirtual 115	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   40: aload_3
    //   41: invokevirtual 119	java/security/MessageDigest:digest	()[B
    //   44: invokestatic 125	com/tencent/mobileqq/utils/SecUtil:toHexString	([B)Ljava/lang/String;
    //   47: astore_0
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 126	java/io/FileInputStream:close	()V
    //   56: aload_0
    //   57: areturn
    //   58: astore_0
    //   59: aload_2
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +7 -> 69
    //   65: aload_0
    //   66: invokevirtual 126	java/io/FileInputStream:close	()V
    //   69: ldc 128
    //   71: areturn
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull -7 -> 69
    //   79: aload_1
    //   80: invokevirtual 126	java/io/FileInputStream:close	()V
    //   83: goto -14 -> 69
    //   86: astore_0
    //   87: goto -18 -> 69
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull -25 -> 69
    //   97: aload_1
    //   98: invokevirtual 126	java/io/FileInputStream:close	()V
    //   101: goto -32 -> 69
    //   104: astore_0
    //   105: goto -36 -> 69
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 126	java/io/FileInputStream:close	()V
    //   119: aload_0
    //   120: athrow
    //   121: astore_1
    //   122: aload_0
    //   123: areturn
    //   124: astore_0
    //   125: goto -56 -> 69
    //   128: astore_1
    //   129: goto -10 -> 119
    //   132: astore_0
    //   133: goto -22 -> 111
    //   136: astore_0
    //   137: goto -44 -> 93
    //   140: astore_0
    //   141: goto -66 -> 75
    //   144: astore_0
    //   145: aload_1
    //   146: astore_0
    //   147: goto -86 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramFile	File
    //   20	96	1	localFileInputStream	java.io.FileInputStream
    //   121	1	1	localIOException1	java.io.IOException
    //   128	18	1	localIOException2	java.io.IOException
    //   1	59	2	localObject	Object
    //   7	34	3	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   2	21	58	java/security/NoSuchAlgorithmException
    //   2	21	72	java/io/FileNotFoundException
    //   79	83	86	java/io/IOException
    //   2	21	90	java/io/IOException
    //   97	101	104	java/io/IOException
    //   2	21	108	finally
    //   52	56	121	java/io/IOException
    //   65	69	124	java/io/IOException
    //   115	119	128	java/io/IOException
    //   21	48	132	finally
    //   21	48	136	java/io/IOException
    //   21	48	140	java/io/FileNotFoundException
    //   21	48	144	java/security/NoSuchAlgorithmException
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.length() < 204800L) {}
      for (paramString = a(paramString);; paramString = b(paramString))
      {
        String str = paramString;
        if ("".equals(paramString)) {
          str = null;
        }
        return str;
      }
    }
    return null;
  }
  
  public static byte[] a(AppInterface paramAppInterface)
  {
    return HexUtil.hexStr2Bytes(((TicketManager)paramAppInterface.getManager(2)).getA2(paramAppInterface.getCurrentAccountUin()));
  }
  
  /* Error */
  private static String b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 26	java/io/File:exists	()Z
    //   14: ifne +10 -> 24
    //   17: ldc 128
    //   19: astore 5
    //   21: aload 5
    //   23: areturn
    //   24: aload_0
    //   25: invokevirtual 105	java/io/File:length	()J
    //   28: lstore_2
    //   29: lload_2
    //   30: ldc2_w 159
    //   33: lcmp
    //   34: ifle +141 -> 175
    //   37: lload_2
    //   38: ldc2_w 161
    //   41: ldiv
    //   42: lstore_2
    //   43: bipush 32
    //   45: newarray byte
    //   47: astore 5
    //   49: new 30	java/io/FileInputStream
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 33	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: astore_0
    //   58: aload_0
    //   59: lload_2
    //   60: invokevirtual 166	java/io/FileInputStream:skip	(J)J
    //   63: pop2
    //   64: iconst_0
    //   65: istore_1
    //   66: iload_1
    //   67: iconst_4
    //   68: if_icmpge +33 -> 101
    //   71: aload_0
    //   72: aload 5
    //   74: iload_1
    //   75: bipush 8
    //   77: imul
    //   78: bipush 8
    //   80: invokevirtual 170	java/io/FileInputStream:read	([BII)I
    //   83: pop
    //   84: aload_0
    //   85: lload_2
    //   86: ldc2_w 171
    //   89: lsub
    //   90: invokevirtual 166	java/io/FileInputStream:skip	(J)J
    //   93: pop2
    //   94: iload_1
    //   95: iconst_1
    //   96: iadd
    //   97: istore_1
    //   98: goto -32 -> 66
    //   101: aload 5
    //   103: invokestatic 125	com/tencent/mobileqq/utils/SecUtil:toHexString	([B)Ljava/lang/String;
    //   106: astore 4
    //   108: aload 4
    //   110: astore 5
    //   112: aload_0
    //   113: ifnull -92 -> 21
    //   116: aload_0
    //   117: invokevirtual 126	java/io/FileInputStream:close	()V
    //   120: aload 4
    //   122: areturn
    //   123: astore_0
    //   124: aload 4
    //   126: areturn
    //   127: astore_0
    //   128: aload 4
    //   130: astore_0
    //   131: aload_0
    //   132: ifnull +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 126	java/io/FileInputStream:close	()V
    //   139: ldc 128
    //   141: areturn
    //   142: astore_0
    //   143: aconst_null
    //   144: astore_0
    //   145: aload_0
    //   146: ifnull -7 -> 139
    //   149: aload_0
    //   150: invokevirtual 126	java/io/FileInputStream:close	()V
    //   153: goto -14 -> 139
    //   156: astore_0
    //   157: goto -18 -> 139
    //   160: astore 4
    //   162: aconst_null
    //   163: astore_0
    //   164: aload_0
    //   165: ifnull +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 126	java/io/FileInputStream:close	()V
    //   172: aload 4
    //   174: athrow
    //   175: ldc 83
    //   177: invokestatic 89	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   180: astore 6
    //   182: aload 6
    //   184: invokevirtual 92	java/security/MessageDigest:reset	()V
    //   187: new 30	java/io/FileInputStream
    //   190: dup
    //   191: aload_0
    //   192: invokespecial 33	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   195: astore 4
    //   197: aload 6
    //   199: aload 4
    //   201: invokevirtual 96	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   204: getstatic 102	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   207: lconst_0
    //   208: aload_0
    //   209: invokevirtual 105	java/io/File:length	()J
    //   212: invokevirtual 111	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   215: invokevirtual 115	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   218: aload 6
    //   220: invokevirtual 119	java/security/MessageDigest:digest	()[B
    //   223: invokestatic 125	com/tencent/mobileqq/utils/SecUtil:toHexString	([B)Ljava/lang/String;
    //   226: astore_0
    //   227: aload_0
    //   228: astore 5
    //   230: aload 4
    //   232: ifnull -211 -> 21
    //   235: aload 4
    //   237: invokevirtual 126	java/io/FileInputStream:close	()V
    //   240: aload_0
    //   241: areturn
    //   242: astore 4
    //   244: aload_0
    //   245: areturn
    //   246: astore_0
    //   247: aload 5
    //   249: astore_0
    //   250: aload_0
    //   251: ifnull -112 -> 139
    //   254: aload_0
    //   255: invokevirtual 126	java/io/FileInputStream:close	()V
    //   258: goto -119 -> 139
    //   261: astore_0
    //   262: goto -123 -> 139
    //   265: astore_0
    //   266: aconst_null
    //   267: astore 4
    //   269: aload 4
    //   271: ifnull -132 -> 139
    //   274: aload 4
    //   276: invokevirtual 126	java/io/FileInputStream:close	()V
    //   279: goto -140 -> 139
    //   282: astore_0
    //   283: goto -144 -> 139
    //   286: astore_0
    //   287: aconst_null
    //   288: astore 4
    //   290: aload 4
    //   292: ifnull -153 -> 139
    //   295: aload 4
    //   297: invokevirtual 126	java/io/FileInputStream:close	()V
    //   300: goto -161 -> 139
    //   303: astore_0
    //   304: goto -165 -> 139
    //   307: astore_0
    //   308: aconst_null
    //   309: astore 4
    //   311: aload 4
    //   313: ifnull +8 -> 321
    //   316: aload 4
    //   318: invokevirtual 126	java/io/FileInputStream:close	()V
    //   321: aload_0
    //   322: athrow
    //   323: astore_0
    //   324: goto -185 -> 139
    //   327: astore_0
    //   328: goto -156 -> 172
    //   331: astore 4
    //   333: goto -12 -> 321
    //   336: astore_0
    //   337: goto -26 -> 311
    //   340: astore_0
    //   341: goto -51 -> 290
    //   344: astore_0
    //   345: goto -76 -> 269
    //   348: astore_0
    //   349: aload 4
    //   351: astore_0
    //   352: goto -102 -> 250
    //   355: astore 4
    //   357: goto -193 -> 164
    //   360: astore 4
    //   362: goto -217 -> 145
    //   365: astore 4
    //   367: goto -236 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramFile	File
    //   65	33	1	i	int
    //   28	58	2	l	long
    //   4	125	4	str	String
    //   160	13	4	localObject1	Object
    //   195	41	4	localFileInputStream	java.io.FileInputStream
    //   242	1	4	localIOException1	java.io.IOException
    //   267	50	4	localObject2	Object
    //   331	19	4	localIOException2	java.io.IOException
    //   355	1	4	localObject3	Object
    //   360	1	4	localIOException3	java.io.IOException
    //   365	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   1	247	5	localObject4	Object
    //   180	39	6	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   116	120	123	java/io/IOException
    //   49	58	127	java/io/FileNotFoundException
    //   49	58	142	java/io/IOException
    //   149	153	156	java/io/IOException
    //   49	58	160	finally
    //   235	240	242	java/io/IOException
    //   175	197	246	java/security/NoSuchAlgorithmException
    //   254	258	261	java/io/IOException
    //   175	197	265	java/io/FileNotFoundException
    //   274	279	282	java/io/IOException
    //   175	197	286	java/io/IOException
    //   295	300	303	java/io/IOException
    //   175	197	307	finally
    //   135	139	323	java/io/IOException
    //   168	172	327	java/io/IOException
    //   316	321	331	java/io/IOException
    //   197	227	336	finally
    //   197	227	340	java/io/IOException
    //   197	227	344	java/io/FileNotFoundException
    //   197	227	348	java/security/NoSuchAlgorithmException
    //   58	64	355	finally
    //   71	94	355	finally
    //   101	108	355	finally
    //   58	64	360	java/io/IOException
    //   71	94	360	java/io/IOException
    //   101	108	360	java/io/IOException
    //   58	64	365	java/io/FileNotFoundException
    //   71	94	365	java/io/FileNotFoundException
    //   101	108	365	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyl
 * JD-Core Version:    0.7.0.1
 */