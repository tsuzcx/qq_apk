import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class bhpp
{
  protected static MessageDigest a;
  protected static char[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfChar = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    try
    {
      jdField_a_of_type_JavaSecurityMessageDigest = MessageDigest.getInstance("MD5");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
  }
  
  /* Error */
  public static String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload 9
    //   8: astore 7
    //   10: aload_0
    //   11: ifnull +153 -> 164
    //   14: aload 9
    //   16: astore 7
    //   18: aload_0
    //   19: invokevirtual 51	java/io/File:exists	()Z
    //   22: ifeq +142 -> 164
    //   25: aload 9
    //   27: astore 7
    //   29: aload_0
    //   30: invokevirtual 55	java/io/File:length	()J
    //   33: lconst_0
    //   34: lcmp
    //   35: ifle +129 -> 164
    //   38: new 57	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: astore 8
    //   48: aload 8
    //   50: astore 7
    //   52: aload_0
    //   53: invokevirtual 55	java/io/File:length	()J
    //   56: lstore_1
    //   57: aload 8
    //   59: astore 7
    //   61: sipush 4096
    //   64: newarray byte
    //   66: astore_0
    //   67: lload_1
    //   68: lconst_0
    //   69: lcmp
    //   70: ifle +97 -> 167
    //   73: aload 8
    //   75: astore 7
    //   77: aload 8
    //   79: aload_0
    //   80: invokevirtual 65	java/io/FileInputStream:read	([B)I
    //   83: i2l
    //   84: lstore 5
    //   86: lload 5
    //   88: ldc2_w 66
    //   91: lcmp
    //   92: ifeq +75 -> 167
    //   95: lload 5
    //   97: lstore_3
    //   98: lload 5
    //   100: lload_1
    //   101: lcmp
    //   102: ifle +5 -> 107
    //   105: lload_1
    //   106: lstore_3
    //   107: lload_1
    //   108: lload_3
    //   109: lsub
    //   110: lstore_1
    //   111: aload 8
    //   113: astore 7
    //   115: getstatic 39	bhpp:jdField_a_of_type_JavaSecurityMessageDigest	Ljava/security/MessageDigest;
    //   118: aload_0
    //   119: iconst_0
    //   120: lload_3
    //   121: l2i
    //   122: invokestatic 73	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   125: invokevirtual 77	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   128: goto -61 -> 67
    //   131: astore 7
    //   133: aload 8
    //   135: astore_0
    //   136: aload 7
    //   138: astore 8
    //   140: aload_0
    //   141: astore 7
    //   143: aload 8
    //   145: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   148: aload 9
    //   150: astore 7
    //   152: aload_0
    //   153: ifnull +11 -> 164
    //   156: aload_0
    //   157: invokevirtual 83	java/io/FileInputStream:close	()V
    //   160: aload 9
    //   162: astore 7
    //   164: aload 7
    //   166: areturn
    //   167: aload 8
    //   169: astore 7
    //   171: aload 8
    //   173: invokevirtual 83	java/io/FileInputStream:close	()V
    //   176: aload 8
    //   178: astore 7
    //   180: getstatic 39	bhpp:jdField_a_of_type_JavaSecurityMessageDigest	Ljava/security/MessageDigest;
    //   183: invokevirtual 87	java/security/MessageDigest:digest	()[B
    //   186: astore 11
    //   188: aload 10
    //   190: astore_0
    //   191: aload 11
    //   193: ifnull +13 -> 206
    //   196: aload 8
    //   198: astore 7
    //   200: aload 11
    //   202: invokestatic 91	bhpp:b	([B)Ljava/lang/String;
    //   205: astore_0
    //   206: aload_0
    //   207: astore 7
    //   209: aload 8
    //   211: ifnull -47 -> 164
    //   214: aload 8
    //   216: invokevirtual 83	java/io/FileInputStream:close	()V
    //   219: aload_0
    //   220: areturn
    //   221: astore 7
    //   223: aload 7
    //   225: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   228: aload_0
    //   229: areturn
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_0
    //   238: aconst_null
    //   239: astore 7
    //   241: aload 7
    //   243: ifnull +8 -> 251
    //   246: aload 7
    //   248: invokevirtual 83	java/io/FileInputStream:close	()V
    //   251: aload_0
    //   252: athrow
    //   253: astore 7
    //   255: aload 7
    //   257: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   260: goto -9 -> 251
    //   263: astore_0
    //   264: goto -23 -> 241
    //   267: astore 8
    //   269: aconst_null
    //   270: astore_0
    //   271: goto -131 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramFile	java.io.File
    //   56	55	1	l1	long
    //   97	24	3	l2	long
    //   84	15	5	l3	long
    //   8	106	7	localObject1	Object
    //   131	6	7	localThrowable1	java.lang.Throwable
    //   141	67	7	localObject2	Object
    //   221	3	7	localIOException1	java.io.IOException
    //   239	8	7	localObject3	Object
    //   253	3	7	localIOException2	java.io.IOException
    //   46	169	8	localObject4	Object
    //   267	1	8	localThrowable2	java.lang.Throwable
    //   4	157	9	localObject5	Object
    //   1	188	10	localObject6	Object
    //   186	15	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   52	57	131	java/lang/Throwable
    //   61	67	131	java/lang/Throwable
    //   77	86	131	java/lang/Throwable
    //   115	128	131	java/lang/Throwable
    //   171	176	131	java/lang/Throwable
    //   180	188	131	java/lang/Throwable
    //   200	206	131	java/lang/Throwable
    //   214	219	221	java/io/IOException
    //   156	160	230	java/io/IOException
    //   38	48	237	finally
    //   246	251	253	java/io/IOException
    //   52	57	263	finally
    //   61	67	263	finally
    //   77	86	263	finally
    //   115	128	263	finally
    //   143	148	263	finally
    //   171	176	263	finally
    //   180	188	263	finally
    //   200	206	263	finally
    //   38	48	267	java/lang/Throwable
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 98
    //   3: lstore_3
    //   4: aconst_null
    //   5: astore 9
    //   7: ldc 31
    //   9: invokestatic 37	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   12: astore 10
    //   14: new 57	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore 8
    //   24: aload 8
    //   26: astore 7
    //   28: new 47	java/io/File
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 55	java/io/File:length	()J
    //   39: lstore 5
    //   41: lload 5
    //   43: ldc2_w 98
    //   46: lcmp
    //   47: ifle +276 -> 323
    //   50: aload 8
    //   52: astore 7
    //   54: sipush 4096
    //   57: newarray byte
    //   59: astore_0
    //   60: lload_3
    //   61: lconst_0
    //   62: lcmp
    //   63: ifle +78 -> 141
    //   66: aload 8
    //   68: astore 7
    //   70: aload 8
    //   72: aload_0
    //   73: invokevirtual 106	java/io/InputStream:read	([B)I
    //   76: istore_2
    //   77: iload_2
    //   78: iconst_m1
    //   79: if_icmpeq +62 -> 141
    //   82: iload_2
    //   83: istore_1
    //   84: iload_2
    //   85: i2l
    //   86: lload_3
    //   87: lcmp
    //   88: ifle +6 -> 94
    //   91: lload_3
    //   92: l2i
    //   93: istore_1
    //   94: lload_3
    //   95: iload_1
    //   96: i2l
    //   97: lsub
    //   98: lstore_3
    //   99: aload 8
    //   101: astore 7
    //   103: aload 10
    //   105: aload_0
    //   106: iconst_0
    //   107: iload_1
    //   108: invokevirtual 109	java/security/MessageDigest:update	([BII)V
    //   111: goto -51 -> 60
    //   114: astore_0
    //   115: aload 8
    //   117: astore 7
    //   119: aload_0
    //   120: invokevirtual 110	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   123: aload 9
    //   125: astore_0
    //   126: aload 8
    //   128: ifnull +11 -> 139
    //   131: aload 8
    //   133: invokevirtual 111	java/io/InputStream:close	()V
    //   136: aload 9
    //   138: astore_0
    //   139: aload_0
    //   140: areturn
    //   141: aload 8
    //   143: astore 7
    //   145: aload 8
    //   147: invokevirtual 111	java/io/InputStream:close	()V
    //   150: aload 8
    //   152: astore 7
    //   154: aload 10
    //   156: invokevirtual 87	java/security/MessageDigest:digest	()[B
    //   159: invokestatic 91	bhpp:b	([B)Ljava/lang/String;
    //   162: astore_0
    //   163: aload_0
    //   164: astore 7
    //   166: aload 7
    //   168: astore_0
    //   169: aload 8
    //   171: ifnull -32 -> 139
    //   174: aload 8
    //   176: invokevirtual 111	java/io/InputStream:close	()V
    //   179: aload 7
    //   181: areturn
    //   182: astore_0
    //   183: aload 7
    //   185: areturn
    //   186: astore_0
    //   187: aconst_null
    //   188: astore 8
    //   190: aload 8
    //   192: astore 7
    //   194: aload_0
    //   195: invokevirtual 112	java/io/FileNotFoundException:printStackTrace	()V
    //   198: aload 9
    //   200: astore_0
    //   201: aload 8
    //   203: ifnull -64 -> 139
    //   206: aload 8
    //   208: invokevirtual 111	java/io/InputStream:close	()V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_0
    //   214: aconst_null
    //   215: areturn
    //   216: astore_0
    //   217: aconst_null
    //   218: astore 8
    //   220: aload 8
    //   222: astore 7
    //   224: aload_0
    //   225: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   228: aload 9
    //   230: astore_0
    //   231: aload 8
    //   233: ifnull -94 -> 139
    //   236: aload 8
    //   238: invokevirtual 111	java/io/InputStream:close	()V
    //   241: aconst_null
    //   242: areturn
    //   243: astore_0
    //   244: aconst_null
    //   245: areturn
    //   246: astore_0
    //   247: aconst_null
    //   248: astore 8
    //   250: aload 8
    //   252: astore 7
    //   254: aload_0
    //   255: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   258: aload 9
    //   260: astore_0
    //   261: aload 8
    //   263: ifnull -124 -> 139
    //   266: aload 8
    //   268: invokevirtual 111	java/io/InputStream:close	()V
    //   271: aconst_null
    //   272: areturn
    //   273: astore_0
    //   274: aconst_null
    //   275: areturn
    //   276: astore_0
    //   277: aconst_null
    //   278: astore 7
    //   280: aload 7
    //   282: ifnull +8 -> 290
    //   285: aload 7
    //   287: invokevirtual 111	java/io/InputStream:close	()V
    //   290: aload_0
    //   291: athrow
    //   292: astore_0
    //   293: aconst_null
    //   294: areturn
    //   295: astore 7
    //   297: goto -7 -> 290
    //   300: astore_0
    //   301: goto -21 -> 280
    //   304: astore_0
    //   305: goto -55 -> 250
    //   308: astore_0
    //   309: goto -89 -> 220
    //   312: astore_0
    //   313: goto -123 -> 190
    //   316: astore_0
    //   317: aconst_null
    //   318: astore 8
    //   320: goto -205 -> 115
    //   323: lload 5
    //   325: lstore_3
    //   326: goto -276 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	paramString	String
    //   83	25	1	i	int
    //   76	9	2	j	int
    //   3	323	3	l1	long
    //   39	285	5	l2	long
    //   26	260	7	localObject1	Object
    //   295	1	7	localException	java.lang.Exception
    //   22	297	8	localFileInputStream	java.io.FileInputStream
    //   5	254	9	localObject2	Object
    //   12	143	10	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   28	41	114	java/security/NoSuchAlgorithmException
    //   54	60	114	java/security/NoSuchAlgorithmException
    //   70	77	114	java/security/NoSuchAlgorithmException
    //   103	111	114	java/security/NoSuchAlgorithmException
    //   145	150	114	java/security/NoSuchAlgorithmException
    //   154	163	114	java/security/NoSuchAlgorithmException
    //   174	179	182	java/lang/Exception
    //   7	24	186	java/io/FileNotFoundException
    //   206	211	213	java/lang/Exception
    //   7	24	216	java/io/IOException
    //   236	241	243	java/lang/Exception
    //   7	24	246	java/lang/Throwable
    //   266	271	273	java/lang/Exception
    //   7	24	276	finally
    //   131	136	292	java/lang/Exception
    //   285	290	295	java/lang/Exception
    //   28	41	300	finally
    //   54	60	300	finally
    //   70	77	300	finally
    //   103	111	300	finally
    //   119	123	300	finally
    //   145	150	300	finally
    //   154	163	300	finally
    //   194	198	300	finally
    //   224	228	300	finally
    //   254	258	300	finally
    //   28	41	304	java/lang/Throwable
    //   54	60	304	java/lang/Throwable
    //   70	77	304	java/lang/Throwable
    //   103	111	304	java/lang/Throwable
    //   145	150	304	java/lang/Throwable
    //   154	163	304	java/lang/Throwable
    //   28	41	308	java/io/IOException
    //   54	60	308	java/io/IOException
    //   70	77	308	java/io/IOException
    //   103	111	308	java/io/IOException
    //   145	150	308	java/io/IOException
    //   154	163	308	java/io/IOException
    //   28	41	312	java/io/FileNotFoundException
    //   54	60	312	java/io/FileNotFoundException
    //   70	77	312	java/io/FileNotFoundException
    //   103	111	312	java/io/FileNotFoundException
    //   145	150	312	java/io/FileNotFoundException
    //   154	163	312	java/io/FileNotFoundException
    //   7	24	316	java/security/NoSuchAlgorithmException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    jdField_a_of_type_JavaSecurityMessageDigest.update(paramArrayOfByte);
    return b(jdField_a_of_type_JavaSecurityMessageDigest.digest());
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      a(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static void a(byte paramByte, StringBuffer paramStringBuffer)
  {
    char c1 = jdField_a_of_type_ArrayOfChar[((paramByte & 0xF0) >> 4)];
    char c2 = jdField_a_of_type_ArrayOfChar[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  public static String b(String paramString)
  {
    return a(paramString.getBytes());
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhpp
 * JD-Core Version:    0.7.0.1
 */