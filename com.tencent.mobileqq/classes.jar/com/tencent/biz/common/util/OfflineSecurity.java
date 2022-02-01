package com.tencent.biz.common.util;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class OfflineSecurity
{
  protected static String a;
  private static char[] a;
  private static String b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrREOFRN9uYS869mOeLmZXFw3djnofd7wbf3ru6zmRB7P6gTpmnvJNnclCcEC7TOmDImvVl+gVPXQ0AmWAI4q042rALV5NPCJiOpIzSgJH2l0F/ZVbj69QztBiKmSHVHqQ8yemqtFljNEJbE9HL3RXE/uwGmHViFl4fGg9am5w7QIDAQAB";
  
  static
  {
    jdField_a_of_type_ArrayOfChar = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  }
  
  public static String a(BufferedInputStream paramBufferedInputStream)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramBufferedInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localStringBuffer.append(new String(arrayOfByte, 0, i));
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = a(paramString, "SHA1");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  private static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 40	java/io/BufferedInputStream
    //   5: dup
    //   6: new 74	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 80	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: sipush 4096
    //   21: newarray byte
    //   23: astore_3
    //   24: aload_1
    //   25: invokestatic 86	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   28: astore_1
    //   29: aload_0
    //   30: aload_3
    //   31: invokevirtual 89	java/io/InputStream:read	([B)I
    //   34: istore_2
    //   35: iload_2
    //   36: ifle +13 -> 49
    //   39: aload_1
    //   40: aload_3
    //   41: iconst_0
    //   42: iload_2
    //   43: invokevirtual 92	java/security/MessageDigest:update	([BII)V
    //   46: goto -17 -> 29
    //   49: aload_0
    //   50: invokevirtual 95	java/io/InputStream:close	()V
    //   53: aload_1
    //   54: invokevirtual 99	java/security/MessageDigest:digest	()[B
    //   57: invokestatic 102	com/tencent/biz/common/util/OfflineSecurity:a	([B)Ljava/lang/String;
    //   60: areturn
    //   61: astore_3
    //   62: aload_0
    //   63: astore_1
    //   64: aload_3
    //   65: astore_0
    //   66: goto +6 -> 72
    //   69: astore_0
    //   70: aload_3
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 95	java/io/InputStream:close	()V
    //   80: goto +5 -> 85
    //   83: aload_0
    //   84: athrow
    //   85: goto -2 -> 83
    //   88: astore_0
    //   89: goto -36 -> 53
    //   92: astore_1
    //   93: goto -13 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramString1	String
    //   0	96	1	paramString2	String
    //   34	9	2	i	int
    //   1	40	3	arrayOfByte	byte[]
    //   61	10	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	29	61	finally
    //   29	35	61	finally
    //   39	46	61	finally
    //   2	18	69	finally
    //   49	53	88	java/io/IOException
    //   76	80	92	java/io/IOException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void a(int paramInt)
  {
    try
    {
      i = Integer.valueOf(jdField_a_of_type_JavaLangString).intValue();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      label13:
      StringBuilder localStringBuilder;
      break label13;
    }
    i = 0;
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_14", "lixian_security", i, paramInt, "", "3", "", "");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("report:");
      localStringBuilder.append(paramInt);
      QLog.d("offlneSecurity", 2, localStringBuilder.toString());
    }
  }
  
  private static void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    jdField_a_of_type_JavaLangString = str;
  }
  
  /* Error */
  private static boolean a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 157
    //   8: iconst_2
    //   9: ldc 168
    //   11: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 104	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_0
    //   24: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: ldc 173
    //   31: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: new 175	java/io/File
    //   38: dup
    //   39: aload_2
    //   40: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: astore 4
    //   48: aload 4
    //   50: invokevirtual 179	java/io/File:exists	()Z
    //   53: ifne +19 -> 72
    //   56: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +11 -> 70
    //   62: ldc 157
    //   64: iconst_2
    //   65: ldc 181
    //   67: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: iconst_0
    //   71: ireturn
    //   72: aconst_null
    //   73: astore_3
    //   74: aconst_null
    //   75: astore_2
    //   76: new 40	java/io/BufferedInputStream
    //   79: dup
    //   80: new 74	java/io/FileInputStream
    //   83: dup
    //   84: aload 4
    //   86: invokespecial 184	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: invokespecial 80	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: astore 4
    //   94: aload 4
    //   96: invokestatic 187	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)[B
    //   99: astore_3
    //   100: aload 4
    //   102: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   105: new 104	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   112: astore 4
    //   114: aload 4
    //   116: aload_0
    //   117: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 4
    //   123: ldc 190
    //   125: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: new 175	java/io/File
    //   132: dup
    //   133: aload 4
    //   135: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual 179	java/io/File:exists	()Z
    //   146: ifne +19 -> 165
    //   149: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +11 -> 163
    //   155: ldc 157
    //   157: iconst_2
    //   158: ldc 192
    //   160: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: iconst_0
    //   164: ireturn
    //   165: new 40	java/io/BufferedInputStream
    //   168: dup
    //   169: new 74	java/io/FileInputStream
    //   172: dup
    //   173: aload_0
    //   174: invokespecial 184	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   177: invokespecial 80	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   180: astore_0
    //   181: aload_0
    //   182: invokestatic 187	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)[B
    //   185: astore_2
    //   186: aload_0
    //   187: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   190: getstatic 194	com/tencent/biz/common/util/OfflineSecurity:b	Ljava/lang/String;
    //   193: aload_3
    //   194: aload_2
    //   195: invokestatic 197	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;[B[B)Z
    //   198: istore_1
    //   199: iload_1
    //   200: ireturn
    //   201: astore_3
    //   202: aload_0
    //   203: astore_2
    //   204: aload_3
    //   205: astore_0
    //   206: goto +4 -> 210
    //   209: astore_0
    //   210: aload_2
    //   211: ifnull +7 -> 218
    //   214: aload_2
    //   215: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   218: aload_0
    //   219: athrow
    //   220: astore_0
    //   221: aload 4
    //   223: astore_2
    //   224: goto +6 -> 230
    //   227: astore_0
    //   228: aload_3
    //   229: astore_2
    //   230: aload_2
    //   231: ifnull +7 -> 238
    //   234: aload_2
    //   235: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: astore_0
    //   241: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +11 -> 255
    //   247: ldc 157
    //   249: iconst_2
    //   250: ldc 199
    //   252: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: iconst_2
    //   256: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   259: aload_0
    //   260: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   263: iconst_0
    //   264: ireturn
    //   265: astore_0
    //   266: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +11 -> 280
    //   272: ldc 157
    //   274: iconst_2
    //   275: ldc 204
    //   277: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: iconst_1
    //   281: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   284: aload_0
    //   285: invokevirtual 205	java/io/FileNotFoundException:printStackTrace	()V
    //   288: iconst_0
    //   289: ireturn
    //   290: astore 4
    //   292: goto -187 -> 105
    //   295: astore_0
    //   296: goto -106 -> 190
    //   299: astore_2
    //   300: goto -82 -> 218
    //   303: astore_2
    //   304: goto -66 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramString	String
    //   198	2	1	bool	boolean
    //   21	214	2	localObject1	Object
    //   299	1	2	localIOException1	java.io.IOException
    //   303	1	2	localIOException2	java.io.IOException
    //   73	121	3	arrayOfByte	byte[]
    //   201	28	3	localObject2	Object
    //   46	176	4	localObject3	Object
    //   290	1	4	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   181	186	201	finally
    //   165	181	209	finally
    //   94	100	220	finally
    //   76	94	227	finally
    //   14	70	240	java/io/IOException
    //   105	163	240	java/io/IOException
    //   190	199	240	java/io/IOException
    //   218	220	240	java/io/IOException
    //   238	240	240	java/io/IOException
    //   14	70	265	java/io/FileNotFoundException
    //   100	105	265	java/io/FileNotFoundException
    //   105	163	265	java/io/FileNotFoundException
    //   186	190	265	java/io/FileNotFoundException
    //   190	199	265	java/io/FileNotFoundException
    //   214	218	265	java/io/FileNotFoundException
    //   218	220	265	java/io/FileNotFoundException
    //   234	238	265	java/io/FileNotFoundException
    //   238	240	265	java/io/FileNotFoundException
    //   100	105	290	java/io/IOException
    //   186	190	295	java/io/IOException
    //   214	218	299	java/io/IOException
    //   234	238	303	java/io/IOException
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("offlneSecurity", 2, "-->offline:verify");
    }
    a(paramString2);
    if (a(paramString1)) {
      return b(paramString1);
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString3);
    if (a(paramString1)) {
      return c(paramString1, paramString2);
    }
    return false;
  }
  
  private static boolean a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("offlneSecurity", 2, "-->offline:verify");
      }
      paramString = Base64Util.decode(paramString.getBytes("UTF-8"), 0);
      KeyFactory localKeyFactory = KeyFactory.getInstance("RSA");
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(localKeyFactory.generatePublic(new X509EncodedKeySpec(paramString)));
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append("-->offline:verify error:");
        paramArrayOfByte1.append(paramString.toString());
        QLog.i("offlneSecurity", 2, paramArrayOfByte1.toString());
      }
      paramString.printStackTrace();
      a(4);
    }
    return false;
  }
  
  public static byte[] a(BufferedInputStream paramBufferedInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramBufferedInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramBufferedInputStream = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramBufferedInputStream;
  }
  
  /* Error */
  private static boolean b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 157
    //   8: iconst_2
    //   9: ldc_w 280
    //   12: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aconst_null
    //   16: astore_3
    //   17: aconst_null
    //   18: astore 4
    //   20: aconst_null
    //   21: astore 5
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: new 104	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   34: astore 6
    //   36: aload_2
    //   37: astore_1
    //   38: aload 6
    //   40: aload_0
    //   41: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_2
    //   46: astore_1
    //   47: aload 6
    //   49: ldc 173
    //   51: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_2
    //   56: astore_1
    //   57: new 40	java/io/BufferedInputStream
    //   60: dup
    //   61: new 74	java/io/FileInputStream
    //   64: dup
    //   65: aload 6
    //   67: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   73: invokespecial 80	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   76: astore_2
    //   77: new 282	org/json/JSONObject
    //   80: dup
    //   81: aload_2
    //   82: invokestatic 284	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   85: invokespecial 285	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   88: astore_1
    //   89: aload_2
    //   90: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   93: aload_1
    //   94: invokevirtual 289	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   97: astore_2
    //   98: aload_2
    //   99: invokeinterface 294 1 0
    //   104: ifeq +173 -> 277
    //   107: aload_2
    //   108: invokeinterface 298 1 0
    //   113: invokevirtual 299	java/lang/Object:toString	()Ljava/lang/String;
    //   116: astore_3
    //   117: aload_1
    //   118: aload_3
    //   119: invokevirtual 302	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore 4
    //   124: new 104	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   131: astore 5
    //   133: aload 5
    //   135: aload_0
    //   136: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 5
    //   142: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   145: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 5
    //   151: aload_3
    //   152: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 4
    //   158: aload 5
    //   160: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 307	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   166: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifne -71 -> 98
    //   172: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +39 -> 214
    //   178: new 104	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   185: astore 4
    //   187: aload 4
    //   189: ldc_w 313
    //   192: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 4
    //   198: aload_3
    //   199: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: ldc 157
    //   205: iconst_2
    //   206: aload 4
    //   208: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: bipush 6
    //   216: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore 4
    //   223: aload 4
    //   225: invokevirtual 314	org/json/JSONException:printStackTrace	()V
    //   228: iconst_5
    //   229: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   232: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq -137 -> 98
    //   238: new 104	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   245: astore 4
    //   247: aload 4
    //   249: ldc_w 316
    //   252: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 4
    //   258: aload_3
    //   259: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: ldc 157
    //   265: iconst_2
    //   266: aload 4
    //   268: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: goto -176 -> 98
    //   277: iconst_1
    //   278: ireturn
    //   279: astore_0
    //   280: aload_2
    //   281: astore_1
    //   282: goto +165 -> 447
    //   285: astore_1
    //   286: aload_2
    //   287: astore_0
    //   288: aload_1
    //   289: astore_2
    //   290: goto +26 -> 316
    //   293: astore_1
    //   294: aload_2
    //   295: astore_0
    //   296: aload_1
    //   297: astore_2
    //   298: goto +63 -> 361
    //   301: astore_1
    //   302: aload_2
    //   303: astore_0
    //   304: aload_1
    //   305: astore_2
    //   306: goto +100 -> 406
    //   309: astore_0
    //   310: goto +137 -> 447
    //   313: astore_2
    //   314: aload_3
    //   315: astore_0
    //   316: aload_0
    //   317: astore_1
    //   318: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +14 -> 335
    //   324: aload_0
    //   325: astore_1
    //   326: ldc 157
    //   328: iconst_2
    //   329: ldc_w 318
    //   332: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_0
    //   336: astore_1
    //   337: iconst_2
    //   338: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   341: aload_0
    //   342: astore_1
    //   343: aload_2
    //   344: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   347: aload_0
    //   348: ifnull +7 -> 355
    //   351: aload_0
    //   352: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   355: iconst_0
    //   356: ireturn
    //   357: astore_2
    //   358: aload 4
    //   360: astore_0
    //   361: aload_0
    //   362: astore_1
    //   363: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq +14 -> 380
    //   369: aload_0
    //   370: astore_1
    //   371: ldc 157
    //   373: iconst_2
    //   374: ldc_w 320
    //   377: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: aload_0
    //   381: astore_1
    //   382: iconst_3
    //   383: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   386: aload_0
    //   387: astore_1
    //   388: aload_2
    //   389: invokevirtual 314	org/json/JSONException:printStackTrace	()V
    //   392: aload_0
    //   393: ifnull +7 -> 400
    //   396: aload_0
    //   397: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   400: iconst_0
    //   401: ireturn
    //   402: astore_2
    //   403: aload 5
    //   405: astore_0
    //   406: aload_0
    //   407: astore_1
    //   408: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +14 -> 425
    //   414: aload_0
    //   415: astore_1
    //   416: ldc 157
    //   418: iconst_2
    //   419: ldc_w 322
    //   422: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: aload_0
    //   426: astore_1
    //   427: iconst_1
    //   428: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   431: aload_0
    //   432: astore_1
    //   433: aload_2
    //   434: invokevirtual 205	java/io/FileNotFoundException:printStackTrace	()V
    //   437: aload_0
    //   438: ifnull +7 -> 445
    //   441: aload_0
    //   442: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   445: iconst_0
    //   446: ireturn
    //   447: aload_1
    //   448: ifnull +7 -> 455
    //   451: aload_1
    //   452: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   455: goto +5 -> 460
    //   458: aload_0
    //   459: athrow
    //   460: goto -2 -> 458
    //   463: astore_2
    //   464: goto -371 -> 93
    //   467: astore_0
    //   468: iconst_0
    //   469: ireturn
    //   470: astore_0
    //   471: iconst_0
    //   472: ireturn
    //   473: astore_0
    //   474: iconst_0
    //   475: ireturn
    //   476: astore_1
    //   477: goto -22 -> 455
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	paramString	String
    //   26	256	1	localObject1	Object
    //   285	4	1	localIOException1	java.io.IOException
    //   293	4	1	localJSONException1	org.json.JSONException
    //   301	4	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   317	135	1	str1	String
    //   476	1	1	localIOException2	java.io.IOException
    //   24	282	2	localObject2	Object
    //   313	31	2	localIOException3	java.io.IOException
    //   357	32	2	localJSONException2	org.json.JSONException
    //   402	32	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   463	1	2	localIOException4	java.io.IOException
    //   16	299	3	str2	String
    //   18	189	4	localObject3	Object
    //   221	3	4	localJSONException3	org.json.JSONException
    //   245	114	4	localStringBuilder1	StringBuilder
    //   21	383	5	localStringBuilder2	StringBuilder
    //   34	32	6	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   117	214	221	org/json/JSONException
    //   214	219	221	org/json/JSONException
    //   77	89	279	finally
    //   77	89	285	java/io/IOException
    //   77	89	293	org/json/JSONException
    //   77	89	301	java/io/FileNotFoundException
    //   27	36	309	finally
    //   38	45	309	finally
    //   47	55	309	finally
    //   57	77	309	finally
    //   318	324	309	finally
    //   326	335	309	finally
    //   337	341	309	finally
    //   343	347	309	finally
    //   363	369	309	finally
    //   371	380	309	finally
    //   382	386	309	finally
    //   388	392	309	finally
    //   408	414	309	finally
    //   416	425	309	finally
    //   427	431	309	finally
    //   433	437	309	finally
    //   27	36	313	java/io/IOException
    //   38	45	313	java/io/IOException
    //   47	55	313	java/io/IOException
    //   57	77	313	java/io/IOException
    //   27	36	357	org/json/JSONException
    //   38	45	357	org/json/JSONException
    //   47	55	357	org/json/JSONException
    //   57	77	357	org/json/JSONException
    //   27	36	402	java/io/FileNotFoundException
    //   38	45	402	java/io/FileNotFoundException
    //   47	55	402	java/io/FileNotFoundException
    //   57	77	402	java/io/FileNotFoundException
    //   89	93	463	java/io/IOException
    //   351	355	467	java/io/IOException
    //   396	400	470	java/io/IOException
    //   441	445	473	java/io/IOException
    //   451	455	476	java/io/IOException
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    a(paramString2);
    return a(paramString1);
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSecurity", 2, "-->offline:verifyIndex");
    }
    a(paramString3);
    if (a(paramString2)) {
      return c(paramString1, paramString2, paramString3);
    }
    return false;
  }
  
  /* Error */
  private static boolean c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +49 -> 52
    //   6: new 104	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 330
    //   18: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: aload_0
    //   24: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_3
    //   29: ldc_w 332
    //   32: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: aload_1
    //   38: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 157
    //   44: iconst_2
    //   45: aload_3
    //   46: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +1106 -> 1162
    //   59: aload_1
    //   60: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +5 -> 68
    //   66: iconst_0
    //   67: ireturn
    //   68: new 104	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   75: astore_3
    //   76: aload_3
    //   77: aload_0
    //   78: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_3
    //   83: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   86: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_3
    //   91: aload_1
    //   92: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: new 175	java/io/File
    //   99: dup
    //   100: aload_3
    //   101: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: invokevirtual 179	java/io/File:exists	()Z
    //   110: ifne +5 -> 115
    //   113: iconst_0
    //   114: ireturn
    //   115: aconst_null
    //   116: astore 5
    //   118: aconst_null
    //   119: astore 6
    //   121: aconst_null
    //   122: astore 7
    //   124: aconst_null
    //   125: astore 4
    //   127: aload 4
    //   129: astore_3
    //   130: new 104	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   137: astore 8
    //   139: aload 4
    //   141: astore_3
    //   142: aload 8
    //   144: aload_0
    //   145: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 4
    //   151: astore_3
    //   152: aload 8
    //   154: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   157: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 4
    //   163: astore_3
    //   164: aload 8
    //   166: ldc_w 340
    //   169: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 4
    //   175: astore_3
    //   176: new 40	java/io/BufferedInputStream
    //   179: dup
    //   180: new 74	java/io/FileInputStream
    //   183: dup
    //   184: aload 8
    //   186: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   192: invokespecial 80	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   195: astore 4
    //   197: new 282	org/json/JSONObject
    //   200: dup
    //   201: aload 4
    //   203: invokestatic 284	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   206: invokespecial 285	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   209: astore_3
    //   210: aload 4
    //   212: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   215: aload_3
    //   216: ldc_w 342
    //   219: invokevirtual 346	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   222: astore 5
    //   224: aload_3
    //   225: ldc_w 348
    //   228: invokevirtual 346	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   231: astore 6
    //   233: aload 4
    //   235: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   238: goto +8 -> 246
    //   241: astore_3
    //   242: aload_3
    //   243: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   246: new 350	java/util/HashMap
    //   249: dup
    //   250: invokespecial 351	java/util/HashMap:<init>	()V
    //   253: astore 4
    //   255: aload 5
    //   257: ifnull +114 -> 371
    //   260: aload 5
    //   262: invokevirtual 289	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   265: astore 7
    //   267: aload 7
    //   269: invokeinterface 294 1 0
    //   274: ifeq +97 -> 371
    //   277: aload 7
    //   279: invokeinterface 298 1 0
    //   284: invokevirtual 299	java/lang/Object:toString	()Ljava/lang/String;
    //   287: astore 8
    //   289: aload 5
    //   291: aload 8
    //   293: invokevirtual 302	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   296: astore_3
    //   297: goto +53 -> 350
    //   300: astore_3
    //   301: aload_3
    //   302: invokevirtual 314	org/json/JSONException:printStackTrace	()V
    //   305: iconst_5
    //   306: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   309: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq +36 -> 348
    //   315: new 104	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   322: astore_3
    //   323: aload_3
    //   324: ldc_w 353
    //   327: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_3
    //   332: aload 8
    //   334: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: ldc 157
    //   340: iconst_2
    //   341: aload_3
    //   342: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: aconst_null
    //   349: astore_3
    //   350: aload_3
    //   351: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifne -87 -> 267
    //   357: aload 4
    //   359: aload 8
    //   361: aload_3
    //   362: invokeinterface 359 3 0
    //   367: pop
    //   368: goto -101 -> 267
    //   371: aload 6
    //   373: ifnull +638 -> 1011
    //   376: aload 6
    //   378: invokevirtual 289	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   381: astore_3
    //   382: aload_3
    //   383: invokeinterface 294 1 0
    //   388: ifeq +623 -> 1011
    //   391: aload_3
    //   392: invokeinterface 298 1 0
    //   397: invokevirtual 299	java/lang/Object:toString	()Ljava/lang/String;
    //   400: astore 5
    //   402: aload 5
    //   404: ifnull -22 -> 382
    //   407: aload_1
    //   408: aload 5
    //   410: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   413: ifeq -31 -> 382
    //   416: aload 4
    //   418: aload_1
    //   419: invokeinterface 363 2 0
    //   424: checkcast 46	java/lang/String
    //   427: astore_3
    //   428: new 104	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   435: astore 7
    //   437: aload 7
    //   439: aload_0
    //   440: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 7
    //   446: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   449: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 7
    //   455: aload_1
    //   456: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 7
    //   462: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 307	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   468: astore_1
    //   469: aload_3
    //   470: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   473: ifne +469 -> 942
    //   476: aload_3
    //   477: aload_1
    //   478: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   481: ifne +6 -> 487
    //   484: goto +458 -> 942
    //   487: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   490: ifeq +44 -> 534
    //   493: new 104	java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   500: astore_1
    //   501: aload_1
    //   502: ldc_w 365
    //   505: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload_1
    //   510: aload 5
    //   512: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload_1
    //   517: ldc_w 367
    //   520: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: ldc 157
    //   526: iconst_2
    //   527: aload_1
    //   528: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: aload 6
    //   536: aload 5
    //   538: invokevirtual 371	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   541: astore_3
    //   542: goto +53 -> 595
    //   545: astore_1
    //   546: aload_1
    //   547: invokevirtual 314	org/json/JSONException:printStackTrace	()V
    //   550: iconst_5
    //   551: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   554: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   557: ifeq +36 -> 593
    //   560: new 104	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   567: astore_1
    //   568: aload_1
    //   569: ldc_w 353
    //   572: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload_1
    //   577: aload 5
    //   579: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: ldc 157
    //   585: iconst_2
    //   586: aload_1
    //   587: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: aconst_null
    //   594: astore_3
    //   595: aload_3
    //   596: ifnull +415 -> 1011
    //   599: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   602: ifeq +53 -> 655
    //   605: new 104	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   612: astore_1
    //   613: aload_1
    //   614: ldc_w 365
    //   617: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: aload_1
    //   622: aload 5
    //   624: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload_1
    //   629: ldc_w 373
    //   632: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload_1
    //   637: aload_3
    //   638: invokevirtual 376	org/json/JSONArray:toString	()Ljava/lang/String;
    //   641: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: ldc 157
    //   647: iconst_2
    //   648: aload_1
    //   649: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   655: iconst_0
    //   656: istore_2
    //   657: iload_2
    //   658: aload_3
    //   659: invokevirtual 379	org/json/JSONArray:length	()I
    //   662: if_icmpge +349 -> 1011
    //   665: aload_3
    //   666: iload_2
    //   667: invokevirtual 382	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   670: astore_1
    //   671: goto +29 -> 700
    //   674: astore_1
    //   675: aload_1
    //   676: invokevirtual 314	org/json/JSONException:printStackTrace	()V
    //   679: iconst_5
    //   680: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   683: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   686: ifeq +12 -> 698
    //   689: ldc 157
    //   691: iconst_2
    //   692: ldc_w 384
    //   695: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   698: aconst_null
    //   699: astore_1
    //   700: aload_1
    //   701: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   704: ifne +161 -> 865
    //   707: aload 4
    //   709: aload_1
    //   710: invokeinterface 363 2 0
    //   715: checkcast 46	java/lang/String
    //   718: astore 6
    //   720: new 104	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   727: astore 7
    //   729: aload 7
    //   731: aload_0
    //   732: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload 7
    //   738: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   741: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: aload 7
    //   747: aload_1
    //   748: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: aload 7
    //   754: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokestatic 307	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   760: astore 7
    //   762: aload 6
    //   764: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   767: ifne +13 -> 780
    //   770: aload 6
    //   772: aload 7
    //   774: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   777: ifne +88 -> 865
    //   780: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   783: ifeq +80 -> 863
    //   786: new 104	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   793: astore_0
    //   794: aload_0
    //   795: ldc_w 386
    //   798: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: aload_0
    //   803: aload 5
    //   805: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: pop
    //   809: aload_0
    //   810: ldc_w 388
    //   813: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload_0
    //   818: aload_1
    //   819: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload_0
    //   824: ldc_w 390
    //   827: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: aload_0
    //   832: aload 6
    //   834: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: pop
    //   838: aload_0
    //   839: ldc_w 392
    //   842: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload_0
    //   847: aload 7
    //   849: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: ldc 157
    //   855: iconst_2
    //   856: aload_0
    //   857: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   863: iconst_0
    //   864: ireturn
    //   865: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   868: ifeq +67 -> 935
    //   871: new 104	java/lang/StringBuilder
    //   874: dup
    //   875: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   878: astore 6
    //   880: aload 6
    //   882: ldc_w 394
    //   885: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: pop
    //   889: aload 6
    //   891: aload 5
    //   893: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload 6
    //   899: ldc_w 396
    //   902: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: aload_1
    //   907: ifnull +6 -> 913
    //   910: goto +7 -> 917
    //   913: ldc_w 398
    //   916: astore_1
    //   917: aload 6
    //   919: aload_1
    //   920: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: pop
    //   924: ldc 157
    //   926: iconst_2
    //   927: aload 6
    //   929: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   932: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   935: iload_2
    //   936: iconst_1
    //   937: iadd
    //   938: istore_2
    //   939: goto -282 -> 657
    //   942: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   945: ifeq +64 -> 1009
    //   948: new 104	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   955: astore_0
    //   956: aload_0
    //   957: ldc_w 400
    //   960: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: pop
    //   964: aload_0
    //   965: aload 5
    //   967: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: pop
    //   971: aload_0
    //   972: ldc_w 402
    //   975: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: aload_0
    //   980: aload_3
    //   981: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: aload_0
    //   986: ldc_w 404
    //   989: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: pop
    //   993: aload_0
    //   994: aload_1
    //   995: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: pop
    //   999: ldc 157
    //   1001: iconst_2
    //   1002: aload_0
    //   1003: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1006: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1009: iconst_0
    //   1010: ireturn
    //   1011: iconst_1
    //   1012: ireturn
    //   1013: astore_0
    //   1014: aload 4
    //   1016: astore_3
    //   1017: goto +127 -> 1144
    //   1020: astore_1
    //   1021: aload 4
    //   1023: astore_0
    //   1024: goto +25 -> 1049
    //   1027: astore_1
    //   1028: aload 4
    //   1030: astore_0
    //   1031: goto +51 -> 1082
    //   1034: astore_1
    //   1035: aload 4
    //   1037: astore_0
    //   1038: goto +77 -> 1115
    //   1041: astore_0
    //   1042: goto +102 -> 1144
    //   1045: astore_1
    //   1046: aload 5
    //   1048: astore_0
    //   1049: aload_0
    //   1050: astore_3
    //   1051: iconst_2
    //   1052: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   1055: aload_0
    //   1056: astore_3
    //   1057: aload_1
    //   1058: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   1061: aload_0
    //   1062: ifnull +14 -> 1076
    //   1065: aload_0
    //   1066: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   1069: iconst_0
    //   1070: ireturn
    //   1071: astore_0
    //   1072: aload_0
    //   1073: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   1076: iconst_0
    //   1077: ireturn
    //   1078: astore_1
    //   1079: aload 6
    //   1081: astore_0
    //   1082: aload_0
    //   1083: astore_3
    //   1084: iconst_3
    //   1085: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   1088: aload_0
    //   1089: astore_3
    //   1090: aload_1
    //   1091: invokevirtual 314	org/json/JSONException:printStackTrace	()V
    //   1094: aload_0
    //   1095: ifnull +14 -> 1109
    //   1098: aload_0
    //   1099: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   1102: iconst_0
    //   1103: ireturn
    //   1104: astore_0
    //   1105: aload_0
    //   1106: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   1109: iconst_0
    //   1110: ireturn
    //   1111: astore_1
    //   1112: aload 7
    //   1114: astore_0
    //   1115: aload_0
    //   1116: astore_3
    //   1117: iconst_1
    //   1118: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   1121: aload_0
    //   1122: astore_3
    //   1123: aload_1
    //   1124: invokevirtual 205	java/io/FileNotFoundException:printStackTrace	()V
    //   1127: aload_0
    //   1128: ifnull +14 -> 1142
    //   1131: aload_0
    //   1132: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   1135: iconst_0
    //   1136: ireturn
    //   1137: astore_0
    //   1138: aload_0
    //   1139: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   1142: iconst_0
    //   1143: ireturn
    //   1144: aload_3
    //   1145: ifnull +15 -> 1160
    //   1148: aload_3
    //   1149: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   1152: goto +8 -> 1160
    //   1155: astore_1
    //   1156: aload_1
    //   1157: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   1160: aload_0
    //   1161: athrow
    //   1162: iconst_0
    //   1163: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1164	0	paramString1	String
    //   0	1164	1	paramString2	String
    //   656	283	2	i	int
    //   13	212	3	localObject1	Object
    //   241	2	3	localIOException	java.io.IOException
    //   296	1	3	str	String
    //   300	2	3	localJSONException	org.json.JSONException
    //   322	827	3	localObject2	Object
    //   125	911	4	localObject3	Object
    //   116	931	5	localObject4	Object
    //   119	961	6	localObject5	Object
    //   122	991	7	localObject6	Object
    //   137	223	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   233	238	241	java/io/IOException
    //   289	297	300	org/json/JSONException
    //   534	542	545	org/json/JSONException
    //   665	671	674	org/json/JSONException
    //   197	233	1013	finally
    //   197	233	1020	java/io/IOException
    //   197	233	1027	org/json/JSONException
    //   197	233	1034	java/io/FileNotFoundException
    //   130	139	1041	finally
    //   142	149	1041	finally
    //   152	161	1041	finally
    //   164	173	1041	finally
    //   176	197	1041	finally
    //   1051	1055	1041	finally
    //   1057	1061	1041	finally
    //   1084	1088	1041	finally
    //   1090	1094	1041	finally
    //   1117	1121	1041	finally
    //   1123	1127	1041	finally
    //   130	139	1045	java/io/IOException
    //   142	149	1045	java/io/IOException
    //   152	161	1045	java/io/IOException
    //   164	173	1045	java/io/IOException
    //   176	197	1045	java/io/IOException
    //   1065	1069	1071	java/io/IOException
    //   130	139	1078	org/json/JSONException
    //   142	149	1078	org/json/JSONException
    //   152	161	1078	org/json/JSONException
    //   164	173	1078	org/json/JSONException
    //   176	197	1078	org/json/JSONException
    //   1098	1102	1104	java/io/IOException
    //   130	139	1111	java/io/FileNotFoundException
    //   142	149	1111	java/io/FileNotFoundException
    //   152	161	1111	java/io/FileNotFoundException
    //   164	173	1111	java/io/FileNotFoundException
    //   176	197	1111	java/io/FileNotFoundException
    //   1131	1135	1137	java/io/IOException
    //   1148	1152	1155	java/io/IOException
  }
  
  /* Error */
  public static boolean c(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 324
    //   9: iconst_2
    //   10: ldc_w 406
    //   13: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_2
    //   17: invokestatic 210	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +662 -> 686
    //   27: aload_1
    //   28: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +655 -> 686
    //   34: aload_2
    //   35: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +5 -> 43
    //   41: iconst_0
    //   42: ireturn
    //   43: aconst_null
    //   44: astore 8
    //   46: aconst_null
    //   47: astore 9
    //   49: aconst_null
    //   50: astore 10
    //   52: aconst_null
    //   53: astore 11
    //   55: aconst_null
    //   56: astore 4
    //   58: aload 8
    //   60: astore_3
    //   61: aload 9
    //   63: astore 5
    //   65: aload 10
    //   67: astore 6
    //   69: aload 11
    //   71: astore 7
    //   73: getstatic 411	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   76: ifnull +65 -> 141
    //   79: aload 8
    //   81: astore_3
    //   82: aload 9
    //   84: astore 5
    //   86: aload 10
    //   88: astore 6
    //   90: aload 11
    //   92: astore 7
    //   94: getstatic 411	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   97: aload_2
    //   98: invokevirtual 416	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   101: ifeq +40 -> 141
    //   104: aload 8
    //   106: astore_3
    //   107: aload 9
    //   109: astore 5
    //   111: aload 10
    //   113: astore 6
    //   115: aload 11
    //   117: astore 7
    //   119: getstatic 411	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   122: aload_2
    //   123: invokevirtual 417	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast 46	java/lang/String
    //   129: astore 8
    //   131: aload 4
    //   133: astore_2
    //   134: aload 8
    //   136: astore 4
    //   138: goto +139 -> 277
    //   141: aload 8
    //   143: astore_3
    //   144: aload 9
    //   146: astore 5
    //   148: aload 10
    //   150: astore 6
    //   152: aload 11
    //   154: astore 7
    //   156: new 104	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   163: astore 4
    //   165: aload 8
    //   167: astore_3
    //   168: aload 9
    //   170: astore 5
    //   172: aload 10
    //   174: astore 6
    //   176: aload 11
    //   178: astore 7
    //   180: aload 4
    //   182: aload_1
    //   183: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 8
    //   189: astore_3
    //   190: aload 9
    //   192: astore 5
    //   194: aload 10
    //   196: astore 6
    //   198: aload 11
    //   200: astore 7
    //   202: aload 4
    //   204: ldc 173
    //   206: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 8
    //   212: astore_3
    //   213: aload 9
    //   215: astore 5
    //   217: aload 10
    //   219: astore 6
    //   221: aload 11
    //   223: astore 7
    //   225: new 40	java/io/BufferedInputStream
    //   228: dup
    //   229: new 74	java/io/FileInputStream
    //   232: dup
    //   233: aload 4
    //   235: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   241: invokespecial 80	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   244: astore 4
    //   246: aload 4
    //   248: invokestatic 284	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   251: astore_3
    //   252: getstatic 411	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   255: ifnull +12 -> 267
    //   258: getstatic 411	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   261: aload_2
    //   262: aload_3
    //   263: invokevirtual 418	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   266: pop
    //   267: aload_3
    //   268: astore_2
    //   269: aload 4
    //   271: astore_3
    //   272: aload_2
    //   273: astore 4
    //   275: aload_3
    //   276: astore_2
    //   277: aload_2
    //   278: astore_3
    //   279: aload_2
    //   280: astore 5
    //   282: aload_2
    //   283: astore 6
    //   285: aload_2
    //   286: astore 7
    //   288: new 282	org/json/JSONObject
    //   291: dup
    //   292: aload 4
    //   294: invokespecial 285	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   297: astore 4
    //   299: aload_2
    //   300: ifnull +21 -> 321
    //   303: aload_2
    //   304: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   307: goto +14 -> 321
    //   310: astore_2
    //   311: ldc 157
    //   313: iconst_1
    //   314: ldc_w 420
    //   317: aload_2
    //   318: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   321: aload 4
    //   323: aload_0
    //   324: invokevirtual 427	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   327: astore_2
    //   328: aload_2
    //   329: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   332: ifeq +20 -> 352
    //   335: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq +12 -> 350
    //   341: ldc 157
    //   343: iconst_2
    //   344: ldc_w 429
    //   347: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: iconst_1
    //   351: ireturn
    //   352: new 104	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   359: astore_3
    //   360: aload_3
    //   361: aload_1
    //   362: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_3
    //   367: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   370: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload_3
    //   375: aload_0
    //   376: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_2
    //   381: aload_3
    //   382: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 307	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   388: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   391: ifne +48 -> 439
    //   394: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +35 -> 432
    //   400: new 104	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   407: astore_1
    //   408: aload_1
    //   409: ldc_w 431
    //   412: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_1
    //   417: aload_0
    //   418: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: ldc 157
    //   424: iconst_2
    //   425: aload_1
    //   426: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: bipush 6
    //   434: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   437: iconst_0
    //   438: ireturn
    //   439: iconst_1
    //   440: ireturn
    //   441: astore_0
    //   442: aload 4
    //   444: astore_3
    //   445: goto +217 -> 662
    //   448: astore_0
    //   449: aload 4
    //   451: astore 5
    //   453: goto +24 -> 477
    //   456: astore_0
    //   457: aload 4
    //   459: astore 6
    //   461: goto +78 -> 539
    //   464: astore_0
    //   465: aload 4
    //   467: astore 7
    //   469: goto +132 -> 601
    //   472: astore_0
    //   473: goto +189 -> 662
    //   476: astore_0
    //   477: aload 5
    //   479: astore_3
    //   480: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq +16 -> 499
    //   486: aload 5
    //   488: astore_3
    //   489: ldc_w 324
    //   492: iconst_2
    //   493: ldc_w 433
    //   496: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   499: aload 5
    //   501: astore_3
    //   502: iconst_2
    //   503: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   506: aload 5
    //   508: astore_3
    //   509: aload_0
    //   510: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   513: aload 5
    //   515: ifnull +21 -> 536
    //   518: aload 5
    //   520: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   523: iconst_0
    //   524: ireturn
    //   525: astore_0
    //   526: ldc 157
    //   528: iconst_1
    //   529: ldc_w 420
    //   532: aload_0
    //   533: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   536: iconst_0
    //   537: ireturn
    //   538: astore_0
    //   539: aload 6
    //   541: astore_3
    //   542: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   545: ifeq +16 -> 561
    //   548: aload 6
    //   550: astore_3
    //   551: ldc_w 324
    //   554: iconst_2
    //   555: ldc_w 435
    //   558: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: aload 6
    //   563: astore_3
    //   564: iconst_3
    //   565: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   568: aload 6
    //   570: astore_3
    //   571: aload_0
    //   572: invokevirtual 314	org/json/JSONException:printStackTrace	()V
    //   575: aload 6
    //   577: ifnull +21 -> 598
    //   580: aload 6
    //   582: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   585: iconst_0
    //   586: ireturn
    //   587: astore_0
    //   588: ldc 157
    //   590: iconst_1
    //   591: ldc_w 420
    //   594: aload_0
    //   595: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   598: iconst_0
    //   599: ireturn
    //   600: astore_0
    //   601: aload 7
    //   603: astore_3
    //   604: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   607: ifeq +16 -> 623
    //   610: aload 7
    //   612: astore_3
    //   613: ldc_w 324
    //   616: iconst_2
    //   617: ldc_w 437
    //   620: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   623: aload 7
    //   625: astore_3
    //   626: iconst_1
    //   627: invokestatic 201	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   630: aload 7
    //   632: astore_3
    //   633: aload_0
    //   634: invokevirtual 205	java/io/FileNotFoundException:printStackTrace	()V
    //   637: aload 7
    //   639: ifnull +21 -> 660
    //   642: aload 7
    //   644: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   647: iconst_0
    //   648: ireturn
    //   649: astore_0
    //   650: ldc 157
    //   652: iconst_1
    //   653: ldc_w 420
    //   656: aload_0
    //   657: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   660: iconst_0
    //   661: ireturn
    //   662: aload_3
    //   663: ifnull +21 -> 684
    //   666: aload_3
    //   667: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   670: goto +14 -> 684
    //   673: astore_1
    //   674: ldc 157
    //   676: iconst_1
    //   677: ldc_w 420
    //   680: aload_1
    //   681: invokestatic 424	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   684: aload_0
    //   685: athrow
    //   686: iconst_0
    //   687: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	688	0	paramString1	String
    //   0	688	1	paramString2	String
    //   0	688	2	paramString3	String
    //   60	607	3	localObject1	Object
    //   56	410	4	localObject2	Object
    //   63	456	5	localObject3	Object
    //   67	514	6	localObject4	Object
    //   71	572	7	localObject5	Object
    //   44	167	8	str	String
    //   47	167	9	localObject6	Object
    //   50	168	10	localObject7	Object
    //   53	169	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   303	307	310	java/lang/Exception
    //   246	267	441	finally
    //   246	267	448	java/io/IOException
    //   246	267	456	org/json/JSONException
    //   246	267	464	java/io/FileNotFoundException
    //   73	79	472	finally
    //   94	104	472	finally
    //   119	131	472	finally
    //   156	165	472	finally
    //   180	187	472	finally
    //   202	210	472	finally
    //   225	246	472	finally
    //   288	299	472	finally
    //   480	486	472	finally
    //   489	499	472	finally
    //   502	506	472	finally
    //   509	513	472	finally
    //   542	548	472	finally
    //   551	561	472	finally
    //   564	568	472	finally
    //   571	575	472	finally
    //   604	610	472	finally
    //   613	623	472	finally
    //   626	630	472	finally
    //   633	637	472	finally
    //   73	79	476	java/io/IOException
    //   94	104	476	java/io/IOException
    //   119	131	476	java/io/IOException
    //   156	165	476	java/io/IOException
    //   180	187	476	java/io/IOException
    //   202	210	476	java/io/IOException
    //   225	246	476	java/io/IOException
    //   288	299	476	java/io/IOException
    //   518	523	525	java/lang/Exception
    //   73	79	538	org/json/JSONException
    //   94	104	538	org/json/JSONException
    //   119	131	538	org/json/JSONException
    //   156	165	538	org/json/JSONException
    //   180	187	538	org/json/JSONException
    //   202	210	538	org/json/JSONException
    //   225	246	538	org/json/JSONException
    //   288	299	538	org/json/JSONException
    //   580	585	587	java/lang/Exception
    //   73	79	600	java/io/FileNotFoundException
    //   94	104	600	java/io/FileNotFoundException
    //   119	131	600	java/io/FileNotFoundException
    //   156	165	600	java/io/FileNotFoundException
    //   180	187	600	java/io/FileNotFoundException
    //   202	210	600	java/io/FileNotFoundException
    //   225	246	600	java/io/FileNotFoundException
    //   288	299	600	java/io/FileNotFoundException
    //   642	647	649	java/lang/Exception
    //   666	670	673	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.util.OfflineSecurity
 * JD-Core Version:    0.7.0.1
 */