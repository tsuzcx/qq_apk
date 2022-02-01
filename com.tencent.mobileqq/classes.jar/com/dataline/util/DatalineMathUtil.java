package com.dataline.util;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.qphone.base.util.BaseApplication;

public class DatalineMathUtil
{
  private static String a = "9u23fh$jkf^%43hj";
  private static String b = "1234567890123456";
  
  public static long a()
  {
    WifiManager localWifiManager = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (!localWifiManager.isWifiEnabled()) {
      return 0L;
    }
    try
    {
      int i = localWifiManager.getConnectionInfo().getIpAddress();
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0L;
  }
  
  public static String a(long paramLong)
  {
    if (paramLong <= 4294967295L)
    {
      long l = paramLong;
      if (paramLong < 0L)
      {
        l = paramLong + 4294967296L;
        if (l < 0L) {
          throw new IllegalArgumentException("invalid ip");
        }
      }
      localObject = new StringBuilder();
      int i = 0;
      while (i <= 3)
      {
        int j = i * 8;
        ((StringBuilder)localObject).append((255 << j & l) >> j);
        if (i < 3) {
          ((StringBuilder)localObject).append(".");
        }
        i += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new IllegalArgumentException("invalid ip");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: ldc 88
    //   2: invokestatic 94	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore 9
    //   7: new 96	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   15: astore 8
    //   17: aload 8
    //   19: astore 7
    //   21: new 99	com/tencent/mm/vfs/VFSFile
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 100	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 103	com/tencent/mm/vfs/VFSFile:length	()J
    //   32: lstore 5
    //   34: lload 5
    //   36: lstore_3
    //   37: lload 5
    //   39: ldc2_w 104
    //   42: lcmp
    //   43: ifle +7 -> 50
    //   46: ldc2_w 104
    //   49: lstore_3
    //   50: aload 8
    //   52: astore 7
    //   54: sipush 1024
    //   57: newarray byte
    //   59: astore_0
    //   60: lload_3
    //   61: lconst_0
    //   62: lcmp
    //   63: ifle +51 -> 114
    //   66: aload 8
    //   68: astore 7
    //   70: aload 8
    //   72: aload_0
    //   73: invokevirtual 111	java/io/InputStream:read	([B)I
    //   76: istore_2
    //   77: iload_2
    //   78: iconst_m1
    //   79: if_icmpeq +35 -> 114
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
    //   103: aload 9
    //   105: aload_0
    //   106: iconst_0
    //   107: iload_1
    //   108: invokevirtual 115	java/security/MessageDigest:update	([BII)V
    //   111: goto -51 -> 60
    //   114: aload 8
    //   116: astore 7
    //   118: aload 8
    //   120: invokevirtual 118	java/io/InputStream:close	()V
    //   123: aload 8
    //   125: astore 7
    //   127: aload 9
    //   129: invokevirtual 122	java/security/MessageDigest:digest	()[B
    //   132: astore_0
    //   133: aload 8
    //   135: invokevirtual 118	java/io/InputStream:close	()V
    //   138: aload_0
    //   139: areturn
    //   140: astore 7
    //   142: aload 7
    //   144: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   147: aload_0
    //   148: areturn
    //   149: astore_0
    //   150: goto +22 -> 172
    //   153: astore_0
    //   154: goto +42 -> 196
    //   157: astore_0
    //   158: goto +62 -> 220
    //   161: astore_0
    //   162: aconst_null
    //   163: astore 7
    //   165: goto +83 -> 248
    //   168: astore_0
    //   169: aconst_null
    //   170: astore 8
    //   172: aload 8
    //   174: astore 7
    //   176: aload_0
    //   177: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   180: aload 8
    //   182: ifnull +63 -> 245
    //   185: aload 8
    //   187: invokevirtual 118	java/io/InputStream:close	()V
    //   190: aconst_null
    //   191: areturn
    //   192: astore_0
    //   193: aconst_null
    //   194: astore 8
    //   196: aload 8
    //   198: astore 7
    //   200: aload_0
    //   201: invokevirtual 124	java/io/FileNotFoundException:printStackTrace	()V
    //   204: aload 8
    //   206: ifnull +39 -> 245
    //   209: aload 8
    //   211: invokevirtual 118	java/io/InputStream:close	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_0
    //   217: aconst_null
    //   218: astore 8
    //   220: aload 8
    //   222: astore 7
    //   224: aload_0
    //   225: invokevirtual 125	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   228: aload 8
    //   230: ifnull +15 -> 245
    //   233: aload 8
    //   235: invokevirtual 118	java/io/InputStream:close	()V
    //   238: aconst_null
    //   239: areturn
    //   240: astore_0
    //   241: aload_0
    //   242: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   245: aconst_null
    //   246: areturn
    //   247: astore_0
    //   248: aload 7
    //   250: ifnull +18 -> 268
    //   253: aload 7
    //   255: invokevirtual 118	java/io/InputStream:close	()V
    //   258: goto +10 -> 268
    //   261: astore 7
    //   263: aload 7
    //   265: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   268: goto +5 -> 273
    //   271: aload_0
    //   272: athrow
    //   273: goto -2 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramString	String
    //   83	25	1	i	int
    //   76	9	2	j	int
    //   36	63	3	l1	long
    //   32	6	5	l2	long
    //   19	107	7	localFileInputStream1	java.io.FileInputStream
    //   140	3	7	localIOException1	java.io.IOException
    //   163	91	7	localFileInputStream2	java.io.FileInputStream
    //   261	3	7	localIOException2	java.io.IOException
    //   15	219	8	localFileInputStream3	java.io.FileInputStream
    //   5	123	9	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   133	138	140	java/io/IOException
    //   21	34	149	java/io/IOException
    //   54	60	149	java/io/IOException
    //   70	77	149	java/io/IOException
    //   103	111	149	java/io/IOException
    //   118	123	149	java/io/IOException
    //   127	133	149	java/io/IOException
    //   21	34	153	java/io/FileNotFoundException
    //   54	60	153	java/io/FileNotFoundException
    //   70	77	153	java/io/FileNotFoundException
    //   103	111	153	java/io/FileNotFoundException
    //   118	123	153	java/io/FileNotFoundException
    //   127	133	153	java/io/FileNotFoundException
    //   21	34	157	java/security/NoSuchAlgorithmException
    //   54	60	157	java/security/NoSuchAlgorithmException
    //   70	77	157	java/security/NoSuchAlgorithmException
    //   103	111	157	java/security/NoSuchAlgorithmException
    //   118	123	157	java/security/NoSuchAlgorithmException
    //   127	133	157	java/security/NoSuchAlgorithmException
    //   0	17	161	finally
    //   0	17	168	java/io/IOException
    //   0	17	192	java/io/FileNotFoundException
    //   0	17	216	java/security/NoSuchAlgorithmException
    //   185	190	240	java/io/IOException
    //   209	214	240	java/io/IOException
    //   233	238	240	java/io/IOException
    //   21	34	247	finally
    //   54	60	247	finally
    //   70	77	247	finally
    //   103	111	247	finally
    //   118	123	247	finally
    //   127	133	247	finally
    //   176	180	247	finally
    //   200	204	247	finally
    //   224	228	247	finally
    //   253	258	261	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.DatalineMathUtil
 * JD-Core Version:    0.7.0.1
 */