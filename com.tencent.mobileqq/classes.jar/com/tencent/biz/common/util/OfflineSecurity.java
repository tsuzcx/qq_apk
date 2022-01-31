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
    //   0: new 42	java/io/BufferedInputStream
    //   3: dup
    //   4: new 76	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 82	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: sipush 4096
    //   19: newarray byte
    //   21: astore_3
    //   22: aload_1
    //   23: invokestatic 88	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   26: astore_1
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 91	java/io/InputStream:read	([B)I
    //   32: istore_2
    //   33: iload_2
    //   34: ifle +28 -> 62
    //   37: aload_1
    //   38: aload_3
    //   39: iconst_0
    //   40: iload_2
    //   41: invokevirtual 94	java/security/MessageDigest:update	([BII)V
    //   44: goto -17 -> 27
    //   47: astore_3
    //   48: aload_0
    //   49: astore_1
    //   50: aload_3
    //   51: astore_0
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 97	java/io/InputStream:close	()V
    //   60: aload_0
    //   61: athrow
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 97	java/io/InputStream:close	()V
    //   70: aload_1
    //   71: invokevirtual 101	java/security/MessageDigest:digest	()[B
    //   74: invokestatic 104	com/tencent/biz/common/util/OfflineSecurity:a	([B)Ljava/lang/String;
    //   77: areturn
    //   78: astore_0
    //   79: goto -9 -> 70
    //   82: astore_1
    //   83: goto -23 -> 60
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_1
    //   89: goto -37 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramString1	String
    //   0	92	1	paramString2	String
    //   32	9	2	i	int
    //   21	18	3	arrayOfByte	byte[]
    //   47	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	27	47	finally
    //   27	33	47	finally
    //   37	44	47	finally
    //   66	70	78	java/io/IOException
    //   56	60	82	java/io/IOException
    //   0	16	86	finally
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
    int i = 0;
    try
    {
      int j = Integer.valueOf(jdField_a_of_type_JavaLangString).intValue();
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label14:
      break label14;
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_14", "lixian_security", i, paramInt, "", "3", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("offlneSecurity", 2, "report:" + paramInt);
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
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +11 -> 16
    //   8: ldc 150
    //   10: iconst_2
    //   11: ldc 170
    //   13: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: new 175	java/io/File
    //   19: dup
    //   20: new 106	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   27: aload_0
    //   28: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 177
    //   33: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 178	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual 181	java/io/File:exists	()Z
    //   47: ifne +19 -> 66
    //   50: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +11 -> 64
    //   56: ldc 150
    //   58: iconst_2
    //   59: ldc 183
    //   61: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: iconst_0
    //   65: ireturn
    //   66: new 42	java/io/BufferedInputStream
    //   69: dup
    //   70: new 76	java/io/FileInputStream
    //   73: dup
    //   74: aload_3
    //   75: invokespecial 186	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: invokespecial 82	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore_3
    //   82: aload_3
    //   83: invokestatic 189	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)[B
    //   86: astore 4
    //   88: aload_3
    //   89: ifnull +7 -> 96
    //   92: aload_3
    //   93: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   96: new 175	java/io/File
    //   99: dup
    //   100: new 106	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   107: aload_0
    //   108: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 192
    //   113: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 178	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 181	java/io/File:exists	()Z
    //   127: ifne +82 -> 209
    //   130: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq -69 -> 64
    //   136: ldc 150
    //   138: iconst_2
    //   139: ldc 194
    //   141: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: iconst_0
    //   145: ireturn
    //   146: astore_0
    //   147: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +11 -> 161
    //   153: ldc 150
    //   155: iconst_2
    //   156: ldc 196
    //   158: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: iconst_1
    //   162: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   165: aload_0
    //   166: invokevirtual 199	java/io/FileNotFoundException:printStackTrace	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_2
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   182: aload_0
    //   183: athrow
    //   184: astore_0
    //   185: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +11 -> 199
    //   191: ldc 150
    //   193: iconst_2
    //   194: ldc 201
    //   196: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: iconst_2
    //   200: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   203: aload_0
    //   204: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   207: iconst_0
    //   208: ireturn
    //   209: new 42	java/io/BufferedInputStream
    //   212: dup
    //   213: new 76	java/io/FileInputStream
    //   216: dup
    //   217: aload_0
    //   218: invokespecial 186	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   221: invokespecial 82	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   224: astore_0
    //   225: aload_0
    //   226: invokestatic 189	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)[B
    //   229: astore_2
    //   230: aload_0
    //   231: ifnull +7 -> 238
    //   234: aload_0
    //   235: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   238: getstatic 14	com/tencent/biz/common/util/OfflineSecurity:b	Ljava/lang/String;
    //   241: aload 4
    //   243: aload_2
    //   244: invokestatic 205	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;[B[B)Z
    //   247: istore_1
    //   248: iload_1
    //   249: ireturn
    //   250: astore_0
    //   251: aload_2
    //   252: ifnull +7 -> 259
    //   255: aload_2
    //   256: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   259: aload_0
    //   260: athrow
    //   261: astore_3
    //   262: goto -166 -> 96
    //   265: astore_2
    //   266: goto -84 -> 182
    //   269: astore_0
    //   270: goto -32 -> 238
    //   273: astore_2
    //   274: goto -15 -> 259
    //   277: astore_3
    //   278: aload_0
    //   279: astore_2
    //   280: aload_3
    //   281: astore_0
    //   282: goto -31 -> 251
    //   285: astore_0
    //   286: aload_3
    //   287: astore_2
    //   288: goto -114 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	paramString	String
    //   247	2	1	bool	boolean
    //   1	255	2	arrayOfByte1	byte[]
    //   265	1	2	localIOException1	java.io.IOException
    //   273	1	2	localIOException2	java.io.IOException
    //   279	9	2	localObject1	Object
    //   42	51	3	localObject2	Object
    //   261	1	3	localIOException3	java.io.IOException
    //   277	10	3	localObject3	Object
    //   86	156	4	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	64	146	java/io/FileNotFoundException
    //   92	96	146	java/io/FileNotFoundException
    //   96	144	146	java/io/FileNotFoundException
    //   178	182	146	java/io/FileNotFoundException
    //   182	184	146	java/io/FileNotFoundException
    //   234	238	146	java/io/FileNotFoundException
    //   238	248	146	java/io/FileNotFoundException
    //   255	259	146	java/io/FileNotFoundException
    //   259	261	146	java/io/FileNotFoundException
    //   66	82	171	finally
    //   16	64	184	java/io/IOException
    //   96	144	184	java/io/IOException
    //   182	184	184	java/io/IOException
    //   238	248	184	java/io/IOException
    //   259	261	184	java/io/IOException
    //   209	225	250	finally
    //   92	96	261	java/io/IOException
    //   178	182	265	java/io/IOException
    //   234	238	269	java/io/IOException
    //   255	259	273	java/io/IOException
    //   225	230	277	finally
    //   82	88	285	finally
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
      if (QLog.isColorLevel()) {
        QLog.i("offlneSecurity", 2, "-->offline:verify error:" + paramString.toString());
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
    //   0: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 150
    //   8: iconst_2
    //   9: ldc_w 280
    //   12: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aconst_null
    //   16: astore 4
    //   18: aconst_null
    //   19: astore_2
    //   20: aconst_null
    //   21: astore_3
    //   22: new 42	java/io/BufferedInputStream
    //   25: dup
    //   26: new 76	java/io/FileInputStream
    //   29: dup
    //   30: new 106	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 177
    //   43: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   52: invokespecial 82	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: astore_1
    //   56: aload_1
    //   57: astore_2
    //   58: new 282	org/json/JSONObject
    //   61: dup
    //   62: aload_1
    //   63: invokestatic 284	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   66: invokespecial 285	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   69: astore_3
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   78: aload_3
    //   79: invokevirtual 289	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   82: astore_1
    //   83: aload_1
    //   84: invokeinterface 294 1 0
    //   89: ifeq +289 -> 378
    //   92: aload_1
    //   93: invokeinterface 298 1 0
    //   98: invokevirtual 299	java/lang/Object:toString	()Ljava/lang/String;
    //   101: astore_2
    //   102: aload_3
    //   103: aload_2
    //   104: invokevirtual 302	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: new 106	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   114: aload_0
    //   115: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   121: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_2
    //   125: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 307	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   137: ifne -54 -> 83
    //   140: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +29 -> 172
    //   146: ldc 150
    //   148: iconst_2
    //   149: new 106	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 313
    //   159: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_2
    //   163: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: bipush 6
    //   174: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   177: iconst_0
    //   178: ireturn
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_1
    //   183: astore_2
    //   184: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +14 -> 201
    //   190: aload_1
    //   191: astore_2
    //   192: ldc 150
    //   194: iconst_2
    //   195: ldc_w 315
    //   198: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: aload_1
    //   202: astore_2
    //   203: iconst_1
    //   204: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   207: aload_1
    //   208: astore_2
    //   209: aload_0
    //   210: invokevirtual 199	java/io/FileNotFoundException:printStackTrace	()V
    //   213: aload_1
    //   214: ifnull -37 -> 177
    //   217: aload_1
    //   218: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   221: iconst_0
    //   222: ireturn
    //   223: astore_0
    //   224: iconst_0
    //   225: ireturn
    //   226: astore_1
    //   227: aload_3
    //   228: astore_0
    //   229: aload_0
    //   230: astore_2
    //   231: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq +14 -> 248
    //   237: aload_0
    //   238: astore_2
    //   239: ldc 150
    //   241: iconst_2
    //   242: ldc_w 317
    //   245: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: aload_0
    //   249: astore_2
    //   250: iconst_3
    //   251: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   254: aload_0
    //   255: astore_2
    //   256: aload_1
    //   257: invokevirtual 318	org/json/JSONException:printStackTrace	()V
    //   260: aload_0
    //   261: ifnull -84 -> 177
    //   264: aload_0
    //   265: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_0
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_1
    //   274: aload 4
    //   276: astore_0
    //   277: aload_0
    //   278: astore_2
    //   279: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +14 -> 296
    //   285: aload_0
    //   286: astore_2
    //   287: ldc 150
    //   289: iconst_2
    //   290: ldc_w 320
    //   293: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: aload_0
    //   297: astore_2
    //   298: iconst_2
    //   299: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   302: aload_0
    //   303: astore_2
    //   304: aload_1
    //   305: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   308: aload_0
    //   309: ifnull -132 -> 177
    //   312: aload_0
    //   313: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   316: iconst_0
    //   317: ireturn
    //   318: astore_0
    //   319: iconst_0
    //   320: ireturn
    //   321: astore_0
    //   322: aload_2
    //   323: ifnull +7 -> 330
    //   326: aload_2
    //   327: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   330: aload_0
    //   331: athrow
    //   332: astore 4
    //   334: aload 4
    //   336: invokevirtual 318	org/json/JSONException:printStackTrace	()V
    //   339: iconst_5
    //   340: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   343: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq -263 -> 83
    //   349: ldc 150
    //   351: iconst_2
    //   352: new 106	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   359: ldc_w 322
    //   362: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_2
    //   366: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: goto -292 -> 83
    //   378: iconst_1
    //   379: ireturn
    //   380: astore_1
    //   381: goto -303 -> 78
    //   384: astore_1
    //   385: goto -55 -> 330
    //   388: astore_0
    //   389: goto -67 -> 322
    //   392: astore_2
    //   393: aload_1
    //   394: astore_0
    //   395: aload_2
    //   396: astore_1
    //   397: goto -120 -> 277
    //   400: astore_2
    //   401: aload_1
    //   402: astore_0
    //   403: aload_2
    //   404: astore_1
    //   405: goto -176 -> 229
    //   408: astore_0
    //   409: goto -227 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	paramString	String
    //   55	163	1	localObject1	Object
    //   226	31	1	localJSONException1	org.json.JSONException
    //   273	32	1	localIOException1	java.io.IOException
    //   380	1	1	localIOException2	java.io.IOException
    //   384	10	1	localIOException3	java.io.IOException
    //   396	9	1	localObject2	Object
    //   19	347	2	localObject3	Object
    //   392	4	2	localIOException4	java.io.IOException
    //   400	4	2	localJSONException2	org.json.JSONException
    //   21	207	3	localJSONObject	org.json.JSONObject
    //   16	259	4	localObject4	Object
    //   332	3	4	localJSONException3	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   22	56	179	java/io/FileNotFoundException
    //   217	221	223	java/io/IOException
    //   22	56	226	org/json/JSONException
    //   264	268	270	java/io/IOException
    //   22	56	273	java/io/IOException
    //   312	316	318	java/io/IOException
    //   22	56	321	finally
    //   231	237	321	finally
    //   239	248	321	finally
    //   250	254	321	finally
    //   256	260	321	finally
    //   279	285	321	finally
    //   287	296	321	finally
    //   298	302	321	finally
    //   304	308	321	finally
    //   102	172	332	org/json/JSONException
    //   172	177	332	org/json/JSONException
    //   74	78	380	java/io/IOException
    //   326	330	384	java/io/IOException
    //   58	70	388	finally
    //   184	190	388	finally
    //   192	201	388	finally
    //   203	207	388	finally
    //   209	213	388	finally
    //   58	70	392	java/io/IOException
    //   58	70	400	org/json/JSONException
    //   58	70	408	java/io/FileNotFoundException
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
    //   0: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 150
    //   8: iconst_2
    //   9: new 106	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 330
    //   19: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 332
    //   29: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +10 -> 56
    //   49: aload_1
    //   50: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +5 -> 58
    //   56: iconst_0
    //   57: ireturn
    //   58: new 175	java/io/File
    //   61: dup
    //   62: new 106	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   69: aload_0
    //   70: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   76: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokespecial 178	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 181	java/io/File:exists	()Z
    //   92: ifeq -36 -> 56
    //   95: new 42	java/io/BufferedInputStream
    //   98: dup
    //   99: new 76	java/io/FileInputStream
    //   102: dup
    //   103: new 106	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   110: aload_0
    //   111: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   117: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 340
    //   123: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   132: invokespecial 82	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   135: astore 4
    //   137: new 282	org/json/JSONObject
    //   140: dup
    //   141: aload 4
    //   143: invokestatic 284	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   146: invokespecial 285	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   149: astore_3
    //   150: aload 4
    //   152: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   155: aload_3
    //   156: ldc_w 342
    //   159: invokevirtual 346	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   162: astore 5
    //   164: aload_3
    //   165: ldc_w 348
    //   168: invokevirtual 346	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   171: astore 6
    //   173: new 350	java/util/HashMap
    //   176: dup
    //   177: invokespecial 351	java/util/HashMap:<init>	()V
    //   180: astore 4
    //   182: aload 5
    //   184: ifnull +141 -> 325
    //   187: aload 5
    //   189: invokevirtual 289	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   192: astore 7
    //   194: aload 7
    //   196: invokeinterface 294 1 0
    //   201: ifeq +124 -> 325
    //   204: aload 7
    //   206: invokeinterface 298 1 0
    //   211: invokevirtual 299	java/lang/Object:toString	()Ljava/lang/String;
    //   214: astore 8
    //   216: aload 5
    //   218: aload 8
    //   220: invokevirtual 302	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore_3
    //   224: aload_3
    //   225: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifne -34 -> 194
    //   231: aload 4
    //   233: aload 8
    //   235: aload_3
    //   236: invokeinterface 357 3 0
    //   241: pop
    //   242: goto -48 -> 194
    //   245: astore_0
    //   246: iconst_1
    //   247: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   250: aload_0
    //   251: invokevirtual 199	java/io/FileNotFoundException:printStackTrace	()V
    //   254: iconst_0
    //   255: ireturn
    //   256: astore_0
    //   257: iconst_3
    //   258: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   261: aload_0
    //   262: invokevirtual 318	org/json/JSONException:printStackTrace	()V
    //   265: iconst_0
    //   266: ireturn
    //   267: astore_0
    //   268: iconst_2
    //   269: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   272: aload_0
    //   273: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   276: iconst_0
    //   277: ireturn
    //   278: astore_3
    //   279: aload_3
    //   280: invokevirtual 318	org/json/JSONException:printStackTrace	()V
    //   283: iconst_5
    //   284: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   287: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq +30 -> 320
    //   293: ldc 150
    //   295: iconst_2
    //   296: new 106	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   303: ldc_w 359
    //   306: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload 8
    //   311: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aconst_null
    //   321: astore_3
    //   322: goto -98 -> 224
    //   325: aload 6
    //   327: ifnull +541 -> 868
    //   330: aload 6
    //   332: invokevirtual 289	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   335: astore_3
    //   336: aload_3
    //   337: invokeinterface 294 1 0
    //   342: ifeq +526 -> 868
    //   345: aload_3
    //   346: invokeinterface 298 1 0
    //   351: invokevirtual 299	java/lang/Object:toString	()Ljava/lang/String;
    //   354: astore 5
    //   356: aload 5
    //   358: ifnull -22 -> 336
    //   361: aload_1
    //   362: aload 5
    //   364: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   367: ifeq -31 -> 336
    //   370: aload 4
    //   372: aload_1
    //   373: invokeinterface 363 2 0
    //   378: checkcast 48	java/lang/String
    //   381: astore_3
    //   382: new 106	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   389: aload_0
    //   390: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   396: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 307	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   409: astore_1
    //   410: aload_3
    //   411: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   414: ifne +11 -> 425
    //   417: aload_3
    //   418: aload_1
    //   419: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   422: ifne +58 -> 480
    //   425: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq -372 -> 56
    //   431: ldc 150
    //   433: iconst_2
    //   434: new 106	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   441: ldc_w 365
    //   444: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 5
    //   449: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc_w 367
    //   455: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload_3
    //   459: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 369
    //   465: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload_1
    //   469: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: iconst_0
    //   479: ireturn
    //   480: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq +36 -> 519
    //   486: ldc 150
    //   488: iconst_2
    //   489: new 106	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   496: ldc_w 371
    //   499: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 5
    //   504: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: ldc_w 373
    //   510: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: aload 6
    //   521: aload 5
    //   523: invokevirtual 377	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   526: astore_3
    //   527: aload_3
    //   528: ifnull +340 -> 868
    //   531: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   534: ifeq +43 -> 577
    //   537: ldc 150
    //   539: iconst_2
    //   540: new 106	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   547: ldc_w 371
    //   550: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 5
    //   555: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: ldc_w 379
    //   561: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_3
    //   565: invokevirtual 382	org/json/JSONArray:toString	()Ljava/lang/String;
    //   568: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: iconst_0
    //   578: istore_2
    //   579: iload_2
    //   580: aload_3
    //   581: invokevirtual 385	org/json/JSONArray:length	()I
    //   584: if_icmpge +284 -> 868
    //   587: aload_3
    //   588: iload_2
    //   589: invokevirtual 388	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   592: astore_1
    //   593: aload_1
    //   594: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   597: ifne +206 -> 803
    //   600: aload 4
    //   602: aload_1
    //   603: invokeinterface 363 2 0
    //   608: checkcast 48	java/lang/String
    //   611: astore 6
    //   613: new 106	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   620: aload_0
    //   621: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   627: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: aload_1
    //   631: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 307	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   640: astore 7
    //   642: aload 6
    //   644: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   647: ifne +13 -> 660
    //   650: aload 6
    //   652: aload 7
    //   654: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   657: ifne +146 -> 803
    //   660: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   663: ifeq -607 -> 56
    //   666: ldc 150
    //   668: iconst_2
    //   669: new 106	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   676: ldc_w 390
    //   679: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload 5
    //   684: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: ldc_w 392
    //   690: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload_1
    //   694: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: ldc_w 394
    //   700: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: aload 6
    //   705: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: ldc_w 396
    //   711: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload 7
    //   716: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   725: iconst_0
    //   726: ireturn
    //   727: astore_1
    //   728: aload_1
    //   729: invokevirtual 318	org/json/JSONException:printStackTrace	()V
    //   732: iconst_5
    //   733: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   736: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   739: ifeq +30 -> 769
    //   742: ldc 150
    //   744: iconst_2
    //   745: new 106	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   752: ldc_w 359
    //   755: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload 5
    //   760: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   769: aconst_null
    //   770: astore_3
    //   771: goto -244 -> 527
    //   774: astore_1
    //   775: aload_1
    //   776: invokevirtual 318	org/json/JSONException:printStackTrace	()V
    //   779: iconst_5
    //   780: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   783: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   786: ifeq +12 -> 798
    //   789: ldc 150
    //   791: iconst_2
    //   792: ldc_w 398
    //   795: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   798: aconst_null
    //   799: astore_1
    //   800: goto -207 -> 593
    //   803: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   806: ifeq +48 -> 854
    //   809: new 106	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   816: ldc_w 400
    //   819: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload 5
    //   824: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: ldc_w 402
    //   830: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: astore 6
    //   835: aload_1
    //   836: ifnull +25 -> 861
    //   839: ldc 150
    //   841: iconst_2
    //   842: aload 6
    //   844: aload_1
    //   845: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   854: iload_2
    //   855: iconst_1
    //   856: iadd
    //   857: istore_2
    //   858: goto -279 -> 579
    //   861: ldc_w 404
    //   864: astore_1
    //   865: goto -26 -> 839
    //   868: iconst_1
    //   869: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	870	0	paramString1	String
    //   0	870	1	paramString2	String
    //   578	280	2	i	int
    //   149	87	3	localObject1	Object
    //   278	2	3	localJSONException	org.json.JSONException
    //   321	450	3	localObject2	Object
    //   135	466	4	localObject3	Object
    //   162	661	5	localObject4	Object
    //   171	672	6	localObject5	Object
    //   192	523	7	localObject6	Object
    //   214	96	8	str	String
    // Exception table:
    //   from	to	target	type
    //   95	173	245	java/io/FileNotFoundException
    //   95	173	256	org/json/JSONException
    //   95	173	267	java/io/IOException
    //   216	224	278	org/json/JSONException
    //   519	527	727	org/json/JSONException
    //   587	593	774	org/json/JSONException
  }
  
  /* Error */
  public static boolean c(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 324
    //   9: iconst_2
    //   10: ldc_w 406
    //   13: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_2
    //   17: invokestatic 210	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +17 -> 41
    //   27: aload_1
    //   28: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +10 -> 41
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
    //   60: astore 5
    //   62: aload 9
    //   64: astore 6
    //   66: aload 10
    //   68: astore 7
    //   70: aload 11
    //   72: astore_3
    //   73: getstatic 411	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   76: ifnull +123 -> 199
    //   79: aload 8
    //   81: astore 5
    //   83: aload 9
    //   85: astore 6
    //   87: aload 10
    //   89: astore 7
    //   91: aload 11
    //   93: astore_3
    //   94: getstatic 411	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   97: aload_2
    //   98: invokevirtual 416	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   101: ifeq +98 -> 199
    //   104: aload 8
    //   106: astore 5
    //   108: aload 9
    //   110: astore 6
    //   112: aload 10
    //   114: astore 7
    //   116: aload 11
    //   118: astore_3
    //   119: getstatic 411	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   122: aload_2
    //   123: invokevirtual 417	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast 48	java/lang/String
    //   129: astore 8
    //   131: aload 4
    //   133: astore_2
    //   134: aload 8
    //   136: astore 4
    //   138: aload_2
    //   139: astore 5
    //   141: aload_2
    //   142: astore 6
    //   144: aload_2
    //   145: astore 7
    //   147: aload_2
    //   148: astore_3
    //   149: new 282	org/json/JSONObject
    //   152: dup
    //   153: aload 4
    //   155: invokespecial 285	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   158: astore 4
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   168: aload 4
    //   170: aload_0
    //   171: invokevirtual 420	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore_2
    //   175: aload_2
    //   176: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +322 -> 501
    //   182: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +12 -> 197
    //   188: ldc 150
    //   190: iconst_2
    //   191: ldc_w 422
    //   194: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: iconst_1
    //   198: ireturn
    //   199: aload 8
    //   201: astore 5
    //   203: aload 9
    //   205: astore 6
    //   207: aload 10
    //   209: astore 7
    //   211: aload 11
    //   213: astore_3
    //   214: new 42	java/io/BufferedInputStream
    //   217: dup
    //   218: new 76	java/io/FileInputStream
    //   221: dup
    //   222: new 106	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   229: aload_1
    //   230: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 177
    //   235: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   244: invokespecial 82	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   247: astore 4
    //   249: aload 4
    //   251: invokestatic 284	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   254: astore_3
    //   255: getstatic 411	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   258: aload_2
    //   259: aload_3
    //   260: invokevirtual 423	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   263: pop
    //   264: aload 4
    //   266: astore_2
    //   267: aload_3
    //   268: astore 4
    //   270: goto -132 -> 138
    //   273: astore_2
    //   274: ldc 150
    //   276: iconst_1
    //   277: ldc_w 425
    //   280: aload_2
    //   281: invokestatic 429	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   284: goto -116 -> 168
    //   287: astore_0
    //   288: aload 5
    //   290: astore_3
    //   291: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +16 -> 310
    //   297: aload 5
    //   299: astore_3
    //   300: ldc_w 324
    //   303: iconst_2
    //   304: ldc_w 431
    //   307: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   310: aload 5
    //   312: astore_3
    //   313: iconst_1
    //   314: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   317: aload 5
    //   319: astore_3
    //   320: aload_0
    //   321: invokevirtual 199	java/io/FileNotFoundException:printStackTrace	()V
    //   324: aload 5
    //   326: ifnull +8 -> 334
    //   329: aload 5
    //   331: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   334: iconst_0
    //   335: ireturn
    //   336: astore_0
    //   337: ldc 150
    //   339: iconst_1
    //   340: ldc_w 425
    //   343: aload_0
    //   344: invokestatic 429	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   347: goto -13 -> 334
    //   350: astore_0
    //   351: aload 6
    //   353: astore_3
    //   354: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +16 -> 373
    //   360: aload 6
    //   362: astore_3
    //   363: ldc_w 324
    //   366: iconst_2
    //   367: ldc_w 433
    //   370: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: aload 6
    //   375: astore_3
    //   376: iconst_3
    //   377: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   380: aload 6
    //   382: astore_3
    //   383: aload_0
    //   384: invokevirtual 318	org/json/JSONException:printStackTrace	()V
    //   387: aload 6
    //   389: ifnull +8 -> 397
    //   392: aload 6
    //   394: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   397: iconst_0
    //   398: ireturn
    //   399: astore_0
    //   400: ldc 150
    //   402: iconst_1
    //   403: ldc_w 425
    //   406: aload_0
    //   407: invokestatic 429	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   410: goto -13 -> 397
    //   413: astore_0
    //   414: aload 7
    //   416: astore_3
    //   417: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq +16 -> 436
    //   423: aload 7
    //   425: astore_3
    //   426: ldc_w 324
    //   429: iconst_2
    //   430: ldc_w 435
    //   433: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: aload 7
    //   438: astore_3
    //   439: iconst_2
    //   440: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   443: aload 7
    //   445: astore_3
    //   446: aload_0
    //   447: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   450: aload 7
    //   452: ifnull +8 -> 460
    //   455: aload 7
    //   457: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   460: iconst_0
    //   461: ireturn
    //   462: astore_0
    //   463: ldc 150
    //   465: iconst_1
    //   466: ldc_w 425
    //   469: aload_0
    //   470: invokestatic 429	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   473: goto -13 -> 460
    //   476: astore_0
    //   477: aload_3
    //   478: ifnull +7 -> 485
    //   481: aload_3
    //   482: invokevirtual 190	java/io/BufferedInputStream:close	()V
    //   485: aload_0
    //   486: athrow
    //   487: astore_1
    //   488: ldc 150
    //   490: iconst_1
    //   491: ldc_w 425
    //   494: aload_1
    //   495: invokestatic 429	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   498: goto -13 -> 485
    //   501: aload_2
    //   502: new 106	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   509: aload_1
    //   510: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   516: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload_0
    //   520: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 307	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   529: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   532: ifne +42 -> 574
    //   535: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq +29 -> 567
    //   541: ldc 150
    //   543: iconst_2
    //   544: new 106	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   551: ldc_w 437
    //   554: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_0
    //   558: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 173	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: bipush 6
    //   569: invokestatic 198	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   572: iconst_0
    //   573: ireturn
    //   574: iconst_1
    //   575: ireturn
    //   576: astore_0
    //   577: aload 4
    //   579: astore_3
    //   580: goto -103 -> 477
    //   583: astore_0
    //   584: aload 4
    //   586: astore 7
    //   588: goto -174 -> 414
    //   591: astore_0
    //   592: aload 4
    //   594: astore 6
    //   596: goto -245 -> 351
    //   599: astore_0
    //   600: aload 4
    //   602: astore 5
    //   604: goto -316 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	607	0	paramString1	String
    //   0	607	1	paramString2	String
    //   0	607	2	paramString3	String
    //   72	508	3	localObject1	Object
    //   56	545	4	localObject2	Object
    //   60	543	5	localObject3	Object
    //   64	531	6	localObject4	Object
    //   68	519	7	localObject5	Object
    //   44	156	8	str	String
    //   47	157	9	localObject6	Object
    //   50	158	10	localObject7	Object
    //   53	159	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   164	168	273	java/lang/Exception
    //   73	79	287	java/io/FileNotFoundException
    //   94	104	287	java/io/FileNotFoundException
    //   119	131	287	java/io/FileNotFoundException
    //   149	160	287	java/io/FileNotFoundException
    //   214	249	287	java/io/FileNotFoundException
    //   329	334	336	java/lang/Exception
    //   73	79	350	org/json/JSONException
    //   94	104	350	org/json/JSONException
    //   119	131	350	org/json/JSONException
    //   149	160	350	org/json/JSONException
    //   214	249	350	org/json/JSONException
    //   392	397	399	java/lang/Exception
    //   73	79	413	java/io/IOException
    //   94	104	413	java/io/IOException
    //   119	131	413	java/io/IOException
    //   149	160	413	java/io/IOException
    //   214	249	413	java/io/IOException
    //   455	460	462	java/lang/Exception
    //   73	79	476	finally
    //   94	104	476	finally
    //   119	131	476	finally
    //   149	160	476	finally
    //   214	249	476	finally
    //   291	297	476	finally
    //   300	310	476	finally
    //   313	317	476	finally
    //   320	324	476	finally
    //   354	360	476	finally
    //   363	373	476	finally
    //   376	380	476	finally
    //   383	387	476	finally
    //   417	423	476	finally
    //   426	436	476	finally
    //   439	443	476	finally
    //   446	450	476	finally
    //   481	485	487	java/lang/Exception
    //   249	264	576	finally
    //   249	264	583	java/io/IOException
    //   249	264	591	org/json/JSONException
    //   249	264	599	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.common.util.OfflineSecurity
 * JD-Core Version:    0.7.0.1
 */