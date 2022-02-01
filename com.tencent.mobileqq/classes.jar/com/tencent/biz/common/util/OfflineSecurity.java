package com.tencent.biz.common.util;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineSecurity
{
  protected static String a;
  private static String b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrREOFRN9uYS869mOeLmZXFw3djnofd7wbf3ru6zmRB7P6gTpmnvJNnclCcEC7TOmDImvVl+gVPXQ0AmWAI4q042rALV5NPCJiOpIzSgJH2l0F/ZVbj69QztBiKmSHVHqQ8yemqtFljNEJbE9HL3RXE/uwGmHViFl4fGg9am5w7QIDAQAB";
  private static char[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static Boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, JSONArray paramJSONArray, Map<String, String> paramMap)
  {
    if (paramJSONObject != null)
    {
      Object localObject = paramJSONObject.keys();
      while (((Iterator)localObject).hasNext())
      {
        String str = ((Iterator)localObject).next().toString();
        if ((str != null) && (paramString2.equals(str)))
        {
          localObject = (String)paramMap.get(paramString2);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(paramString2);
          paramString2 = a(localStringBuilder.toString());
          int i;
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(paramString2)))
          {
            if (QLog.isColorLevel())
            {
              paramString2 = new StringBuilder();
              paramString2.append("check local file:");
              paramString2.append(str);
              paramString2.append(" success");
              QLog.i("offlneSecurity", 2, paramString2.toString());
            }
            try
            {
              paramJSONObject = paramJSONObject.getJSONArray(str);
            }
            catch (JSONException paramString2)
            {
              paramString2.printStackTrace();
              a(5);
              paramJSONObject = paramJSONArray;
              if (QLog.isColorLevel())
              {
                paramString2 = new StringBuilder();
                paramString2.append("JSONException:");
                paramString2.append(str);
                QLog.i("offlneSecurity", 2, paramString2.toString());
                paramJSONObject = paramJSONArray;
              }
            }
            if (paramJSONObject != null)
            {
              if (QLog.isColorLevel())
              {
                paramString2 = new StringBuilder();
                paramString2.append("check local file:");
                paramString2.append(str);
                paramString2.append(",related files:");
                paramString2.append(paramJSONObject.toString());
                QLog.i("offlneSecurity", 2, paramString2.toString());
              }
              i = 0;
            }
          }
          else
          {
            while (i < paramJSONObject.length())
            {
              try
              {
                paramString2 = paramJSONObject.getString(i);
              }
              catch (JSONException paramString2)
              {
                paramString2.printStackTrace();
                a(5);
                if (QLog.isColorLevel()) {
                  QLog.i("offlneSecurity", 2, "jsonArray.getString");
                }
                paramString2 = null;
              }
              if (!TextUtils.isEmpty(paramString2))
              {
                paramJSONArray = (String)paramMap.get(paramString2);
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(paramString1);
                ((StringBuilder)localObject).append(File.separator);
                ((StringBuilder)localObject).append(paramString2);
                localObject = a(((StringBuilder)localObject).toString());
                if ((TextUtils.isEmpty(paramJSONArray)) || (!paramJSONArray.equals(localObject)))
                {
                  if (QLog.isColorLevel())
                  {
                    paramString1 = new StringBuilder();
                    paramString1.append("check related file md5 fail;html=");
                    paramString1.append(str);
                    paramString1.append("; resfile=");
                    paramString1.append(paramString2);
                    paramString1.append(";resMd5=");
                    paramString1.append(paramJSONArray);
                    paramString1.append("; reshash=");
                    paramString1.append((String)localObject);
                    QLog.i("offlneSecurity", 2, paramString1.toString());
                  }
                  return Boolean.valueOf(false);
                }
              }
              if (QLog.isColorLevel())
              {
                paramJSONArray = new StringBuilder();
                paramJSONArray.append("check related file md5 success ; html=");
                paramJSONArray.append(str);
                paramJSONArray.append(";  resfile=");
                if (paramString2 == null) {
                  paramString2 = "null";
                }
                paramJSONArray.append(paramString2);
                QLog.i("offlneSecurity", 2, paramJSONArray.toString());
              }
              i += 1;
              continue;
              if (QLog.isColorLevel())
              {
                paramString1 = new StringBuilder();
                paramString1.append("check md5 fail:");
                paramString1.append(str);
                paramString1.append(";fileMd5=");
                paramString1.append((String)localObject);
                paramString1.append("; filehash=");
                paramString1.append(paramString2);
                QLog.i("offlneSecurity", 2, paramString1.toString());
              }
              return Boolean.valueOf(false);
            }
          }
        }
      }
    }
    return null;
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
      paramString = d(paramString, "SHA1");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(c[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(c[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void a(int paramInt)
  {
    try
    {
      i = Integer.valueOf(a).intValue();
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
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("offlneSecurity", 2, "-->offline:verify");
    }
    b(paramString2);
    if (c(paramString1)) {
      return d(paramString1);
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    b(paramString3);
    if (c(paramString1)) {
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
  
  private static void b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    a = str;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    b(paramString2);
    return c(paramString1);
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSecurity", 2, "-->offline:verifyIndex");
    }
    b(paramString3);
    if (c(paramString2)) {
      return c(paramString1, paramString2, paramString3);
    }
    return false;
  }
  
  public static byte[] b(BufferedInputStream paramBufferedInputStream)
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
  private static boolean c(String paramString)
  {
    // Byte code:
    //   0: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 103
    //   8: iconst_2
    //   9: ldc_w 323
    //   12: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: new 72	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   22: astore_2
    //   23: aload_2
    //   24: aload_0
    //   25: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: ldc_w 325
    //   33: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: new 79	java/io/File
    //   40: dup
    //   41: aload_2
    //   42: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore 4
    //   50: aload 4
    //   52: invokevirtual 330	java/io/File:exists	()Z
    //   55: ifne +20 -> 75
    //   58: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +12 -> 73
    //   64: ldc 103
    //   66: iconst_2
    //   67: ldc_w 332
    //   70: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: iconst_0
    //   74: ireturn
    //   75: aconst_null
    //   76: astore_3
    //   77: aconst_null
    //   78: astore_2
    //   79: new 168	java/io/BufferedInputStream
    //   82: dup
    //   83: new 334	java/io/FileInputStream
    //   86: dup
    //   87: aload 4
    //   89: invokespecial 337	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   92: invokespecial 340	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   95: astore 4
    //   97: aload 4
    //   99: invokestatic 342	com/tencent/biz/common/util/OfflineSecurity:b	(Ljava/io/BufferedInputStream;)[B
    //   102: astore_3
    //   103: aload 4
    //   105: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   108: new 72	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   115: astore 4
    //   117: aload 4
    //   119: aload_0
    //   120: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 4
    //   126: ldc_w 345
    //   129: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: new 79	java/io/File
    //   136: dup
    //   137: aload 4
    //   139: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 330	java/io/File:exists	()Z
    //   150: ifne +20 -> 170
    //   153: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +12 -> 168
    //   159: ldc 103
    //   161: iconst_2
    //   162: ldc_w 347
    //   165: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: iconst_0
    //   169: ireturn
    //   170: new 168	java/io/BufferedInputStream
    //   173: dup
    //   174: new 334	java/io/FileInputStream
    //   177: dup
    //   178: aload_0
    //   179: invokespecial 337	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   182: invokespecial 340	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   185: astore_0
    //   186: aload_0
    //   187: invokestatic 342	com/tencent/biz/common/util/OfflineSecurity:b	(Ljava/io/BufferedInputStream;)[B
    //   190: astore_2
    //   191: aload_0
    //   192: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   195: getstatic 349	com/tencent/biz/common/util/OfflineSecurity:b	Ljava/lang/String;
    //   198: aload_3
    //   199: aload_2
    //   200: invokestatic 351	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;[B[B)Z
    //   203: istore_1
    //   204: iload_1
    //   205: ireturn
    //   206: astore_3
    //   207: aload_0
    //   208: astore_2
    //   209: aload_3
    //   210: astore_0
    //   211: goto +4 -> 215
    //   214: astore_0
    //   215: aload_2
    //   216: ifnull +7 -> 223
    //   219: aload_2
    //   220: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   223: aload_0
    //   224: athrow
    //   225: astore_0
    //   226: aload 4
    //   228: astore_2
    //   229: goto +6 -> 235
    //   232: astore_0
    //   233: aload_3
    //   234: astore_2
    //   235: aload_2
    //   236: ifnull +7 -> 243
    //   239: aload_2
    //   240: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   243: aload_0
    //   244: athrow
    //   245: astore_0
    //   246: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +12 -> 261
    //   252: ldc 103
    //   254: iconst_2
    //   255: ldc_w 353
    //   258: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: iconst_2
    //   262: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   265: aload_0
    //   266: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   269: iconst_0
    //   270: ireturn
    //   271: astore_0
    //   272: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +12 -> 287
    //   278: ldc 103
    //   280: iconst_2
    //   281: ldc_w 356
    //   284: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: iconst_1
    //   288: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   291: aload_0
    //   292: invokevirtual 357	java/io/FileNotFoundException:printStackTrace	()V
    //   295: iconst_0
    //   296: ireturn
    //   297: astore 4
    //   299: goto -191 -> 108
    //   302: astore_0
    //   303: goto -108 -> 195
    //   306: astore_2
    //   307: goto -84 -> 223
    //   310: astore_2
    //   311: goto -68 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	paramString	String
    //   203	2	1	bool	boolean
    //   22	218	2	localObject1	Object
    //   306	1	2	localIOException1	java.io.IOException
    //   310	1	2	localIOException2	java.io.IOException
    //   76	123	3	arrayOfByte	byte[]
    //   206	28	3	localObject2	Object
    //   48	179	4	localObject3	Object
    //   297	1	4	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   186	191	206	finally
    //   170	186	214	finally
    //   97	103	225	finally
    //   79	97	232	finally
    //   15	73	245	java/io/IOException
    //   108	168	245	java/io/IOException
    //   195	204	245	java/io/IOException
    //   223	225	245	java/io/IOException
    //   243	245	245	java/io/IOException
    //   15	73	271	java/io/FileNotFoundException
    //   103	108	271	java/io/FileNotFoundException
    //   108	168	271	java/io/FileNotFoundException
    //   191	195	271	java/io/FileNotFoundException
    //   195	204	271	java/io/FileNotFoundException
    //   219	223	271	java/io/FileNotFoundException
    //   223	225	271	java/io/FileNotFoundException
    //   239	243	271	java/io/FileNotFoundException
    //   243	245	271	java/io/FileNotFoundException
    //   103	108	297	java/io/IOException
    //   191	195	302	java/io/IOException
    //   219	223	306	java/io/IOException
    //   239	243	310	java/io/IOException
  }
  
  /* Error */
  private static boolean c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +49 -> 52
    //   6: new 72	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc_w 359
    //   18: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: aload_0
    //   24: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: ldc_w 361
    //   32: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: aload_1
    //   38: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 103
    //   44: iconst_2
    //   45: aload_2
    //   46: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +468 -> 524
    //   59: aload_1
    //   60: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +5 -> 68
    //   66: iconst_0
    //   67: ireturn
    //   68: new 72	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   75: astore_2
    //   76: aload_2
    //   77: aload_0
    //   78: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_2
    //   83: getstatic 82	java/io/File:separator	Ljava/lang/String;
    //   86: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_2
    //   91: aload_1
    //   92: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: new 79	java/io/File
    //   99: dup
    //   100: aload_2
    //   101: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: invokevirtual 330	java/io/File:exists	()Z
    //   110: ifne +5 -> 115
    //   113: iconst_0
    //   114: ireturn
    //   115: aconst_null
    //   116: astore 4
    //   118: aconst_null
    //   119: astore 5
    //   121: aconst_null
    //   122: astore 6
    //   124: aconst_null
    //   125: astore_3
    //   126: aload_3
    //   127: astore_2
    //   128: new 72	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   135: astore 7
    //   137: aload_3
    //   138: astore_2
    //   139: aload 7
    //   141: aload_0
    //   142: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_3
    //   147: astore_2
    //   148: aload 7
    //   150: getstatic 82	java/io/File:separator	Ljava/lang/String;
    //   153: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_3
    //   158: astore_2
    //   159: aload 7
    //   161: ldc_w 363
    //   164: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_3
    //   169: astore_2
    //   170: new 168	java/io/BufferedInputStream
    //   173: dup
    //   174: new 334	java/io/FileInputStream
    //   177: dup
    //   178: aload 7
    //   180: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokespecial 364	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   186: invokespecial 340	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   189: astore_3
    //   190: new 40	org/json/JSONObject
    //   193: dup
    //   194: aload_3
    //   195: invokestatic 366	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   198: invokespecial 367	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   201: astore_2
    //   202: aload_3
    //   203: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   206: aload_2
    //   207: ldc_w 369
    //   210: invokevirtual 373	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   213: astore 4
    //   215: aload_2
    //   216: ldc_w 375
    //   219: invokevirtual 373	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   222: astore 5
    //   224: aload_3
    //   225: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   228: goto +8 -> 236
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   236: new 377	java/util/HashMap
    //   239: dup
    //   240: invokespecial 378	java/util/HashMap:<init>	()V
    //   243: astore_3
    //   244: aload 4
    //   246: ifnull +112 -> 358
    //   249: aload 4
    //   251: invokevirtual 44	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   254: astore 6
    //   256: aload 6
    //   258: invokeinterface 50 1 0
    //   263: ifeq +95 -> 358
    //   266: aload 6
    //   268: invokeinterface 54 1 0
    //   273: invokevirtual 58	java/lang/Object:toString	()Ljava/lang/String;
    //   276: astore 7
    //   278: aload 4
    //   280: aload 7
    //   282: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: astore_2
    //   286: goto +52 -> 338
    //   289: astore_2
    //   290: aload_2
    //   291: invokevirtual 114	org/json/JSONException:printStackTrace	()V
    //   294: iconst_5
    //   295: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   298: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +35 -> 336
    //   304: new 72	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   311: astore_2
    //   312: aload_2
    //   313: ldc 119
    //   315: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_2
    //   320: aload 7
    //   322: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: ldc 103
    //   328: iconst_2
    //   329: aload_2
    //   330: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aconst_null
    //   337: astore_2
    //   338: aload_2
    //   339: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   342: ifne -86 -> 256
    //   345: aload_3
    //   346: aload 7
    //   348: aload_2
    //   349: invokeinterface 384 3 0
    //   354: pop
    //   355: goto -99 -> 256
    //   358: aload_0
    //   359: aload_1
    //   360: aload 5
    //   362: aconst_null
    //   363: aload_3
    //   364: invokestatic 386	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONArray;Ljava/util/Map;)Ljava/lang/Boolean;
    //   367: astore_0
    //   368: aload_0
    //   369: ifnull +8 -> 377
    //   372: aload_0
    //   373: invokevirtual 389	java/lang/Boolean:booleanValue	()Z
    //   376: ireturn
    //   377: iconst_1
    //   378: ireturn
    //   379: astore_0
    //   380: aload_3
    //   381: astore_2
    //   382: goto +124 -> 506
    //   385: astore_1
    //   386: aload_3
    //   387: astore_0
    //   388: goto +23 -> 411
    //   391: astore_1
    //   392: aload_3
    //   393: astore_0
    //   394: goto +50 -> 444
    //   397: astore_1
    //   398: aload_3
    //   399: astore_0
    //   400: goto +77 -> 477
    //   403: astore_0
    //   404: goto +102 -> 506
    //   407: astore_1
    //   408: aload 4
    //   410: astore_0
    //   411: aload_0
    //   412: astore_2
    //   413: iconst_2
    //   414: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   417: aload_0
    //   418: astore_2
    //   419: aload_1
    //   420: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   423: aload_0
    //   424: ifnull +14 -> 438
    //   427: aload_0
    //   428: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   431: iconst_0
    //   432: ireturn
    //   433: astore_0
    //   434: aload_0
    //   435: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   438: iconst_0
    //   439: ireturn
    //   440: astore_1
    //   441: aload 5
    //   443: astore_0
    //   444: aload_0
    //   445: astore_2
    //   446: iconst_3
    //   447: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   450: aload_0
    //   451: astore_2
    //   452: aload_1
    //   453: invokevirtual 114	org/json/JSONException:printStackTrace	()V
    //   456: aload_0
    //   457: ifnull +14 -> 471
    //   460: aload_0
    //   461: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   464: iconst_0
    //   465: ireturn
    //   466: astore_0
    //   467: aload_0
    //   468: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   471: iconst_0
    //   472: ireturn
    //   473: astore_1
    //   474: aload 6
    //   476: astore_0
    //   477: aload_0
    //   478: astore_2
    //   479: iconst_1
    //   480: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   483: aload_0
    //   484: astore_2
    //   485: aload_1
    //   486: invokevirtual 357	java/io/FileNotFoundException:printStackTrace	()V
    //   489: aload_0
    //   490: ifnull +14 -> 504
    //   493: aload_0
    //   494: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   497: iconst_0
    //   498: ireturn
    //   499: astore_0
    //   500: aload_0
    //   501: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   504: iconst_0
    //   505: ireturn
    //   506: aload_2
    //   507: ifnull +15 -> 522
    //   510: aload_2
    //   511: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   514: goto +8 -> 522
    //   517: astore_1
    //   518: aload_1
    //   519: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   522: aload_0
    //   523: athrow
    //   524: iconst_0
    //   525: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	526	0	paramString1	String
    //   0	526	1	paramString2	String
    //   13	203	2	localObject1	Object
    //   231	2	2	localIOException	java.io.IOException
    //   285	1	2	str	String
    //   289	2	2	localJSONException	JSONException
    //   311	200	2	localObject2	Object
    //   125	274	3	localObject3	Object
    //   116	293	4	localJSONObject1	JSONObject
    //   119	323	5	localJSONObject2	JSONObject
    //   122	353	6	localIterator	Iterator
    //   135	212	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   224	228	231	java/io/IOException
    //   278	286	289	org/json/JSONException
    //   190	224	379	finally
    //   190	224	385	java/io/IOException
    //   190	224	391	org/json/JSONException
    //   190	224	397	java/io/FileNotFoundException
    //   128	137	403	finally
    //   139	146	403	finally
    //   148	157	403	finally
    //   159	168	403	finally
    //   170	190	403	finally
    //   413	417	403	finally
    //   419	423	403	finally
    //   446	450	403	finally
    //   452	456	403	finally
    //   479	483	403	finally
    //   485	489	403	finally
    //   128	137	407	java/io/IOException
    //   139	146	407	java/io/IOException
    //   148	157	407	java/io/IOException
    //   159	168	407	java/io/IOException
    //   170	190	407	java/io/IOException
    //   427	431	433	java/io/IOException
    //   128	137	440	org/json/JSONException
    //   139	146	440	org/json/JSONException
    //   148	157	440	org/json/JSONException
    //   159	168	440	org/json/JSONException
    //   170	190	440	org/json/JSONException
    //   460	464	466	java/io/IOException
    //   128	137	473	java/io/FileNotFoundException
    //   139	146	473	java/io/FileNotFoundException
    //   148	157	473	java/io/FileNotFoundException
    //   159	168	473	java/io/FileNotFoundException
    //   170	190	473	java/io/FileNotFoundException
    //   493	497	499	java/io/IOException
    //   510	514	517	java/io/IOException
  }
  
  /* Error */
  public static boolean c(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 299
    //   9: iconst_2
    //   10: ldc_w 391
    //   13: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_2
    //   17: invokestatic 236	com/tencent/biz/common/util/OfflineSecurity:b	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +663 -> 687
    //   27: aload_1
    //   28: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +656 -> 687
    //   34: aload_2
    //   35: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   73: getstatic 397	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   76: ifnull +65 -> 141
    //   79: aload 8
    //   81: astore_3
    //   82: aload 9
    //   84: astore 5
    //   86: aload 10
    //   88: astore 6
    //   90: aload 11
    //   92: astore 7
    //   94: getstatic 397	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   97: aload_2
    //   98: invokevirtual 402	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   101: ifeq +40 -> 141
    //   104: aload 8
    //   106: astore_3
    //   107: aload 9
    //   109: astore 5
    //   111: aload 10
    //   113: astore 6
    //   115: aload 11
    //   117: astore 7
    //   119: getstatic 397	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   122: aload_2
    //   123: invokevirtual 403	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast 60	java/lang/String
    //   129: astore 8
    //   131: aload 4
    //   133: astore_2
    //   134: aload 8
    //   136: astore 4
    //   138: goto +140 -> 278
    //   141: aload 8
    //   143: astore_3
    //   144: aload 9
    //   146: astore 5
    //   148: aload 10
    //   150: astore 6
    //   152: aload 11
    //   154: astore 7
    //   156: new 72	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 73	java/lang/StringBuilder:<init>	()V
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
    //   183: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   204: ldc_w 325
    //   207: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 8
    //   213: astore_3
    //   214: aload 9
    //   216: astore 5
    //   218: aload 10
    //   220: astore 6
    //   222: aload 11
    //   224: astore 7
    //   226: new 168	java/io/BufferedInputStream
    //   229: dup
    //   230: new 334	java/io/FileInputStream
    //   233: dup
    //   234: aload 4
    //   236: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokespecial 364	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   242: invokespecial 340	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   245: astore 4
    //   247: aload 4
    //   249: invokestatic 366	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   252: astore_3
    //   253: getstatic 397	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   256: ifnull +12 -> 268
    //   259: getstatic 397	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   262: aload_2
    //   263: aload_3
    //   264: invokevirtual 404	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   267: pop
    //   268: aload_3
    //   269: astore_2
    //   270: aload 4
    //   272: astore_3
    //   273: aload_2
    //   274: astore 4
    //   276: aload_3
    //   277: astore_2
    //   278: aload_2
    //   279: astore_3
    //   280: aload_2
    //   281: astore 5
    //   283: aload_2
    //   284: astore 6
    //   286: aload_2
    //   287: astore 7
    //   289: new 40	org/json/JSONObject
    //   292: dup
    //   293: aload 4
    //   295: invokespecial 367	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   298: astore 4
    //   300: aload_2
    //   301: ifnull +21 -> 322
    //   304: aload_2
    //   305: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   308: goto +14 -> 322
    //   311: astore_2
    //   312: ldc 103
    //   314: iconst_1
    //   315: ldc_w 406
    //   318: aload_2
    //   319: invokestatic 410	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   322: aload 4
    //   324: aload_0
    //   325: invokevirtual 413	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   328: astore_2
    //   329: aload_2
    //   330: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   333: ifeq +20 -> 353
    //   336: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +12 -> 351
    //   342: ldc 103
    //   344: iconst_2
    //   345: ldc_w 415
    //   348: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: iconst_1
    //   352: ireturn
    //   353: new 72	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   360: astore_3
    //   361: aload_3
    //   362: aload_1
    //   363: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload_3
    //   368: getstatic 82	java/io/File:separator	Ljava/lang/String;
    //   371: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload_3
    //   376: aload_0
    //   377: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload_2
    //   382: aload_3
    //   383: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 86	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   389: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   392: ifne +48 -> 440
    //   395: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq +35 -> 433
    //   401: new 72	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   408: astore_1
    //   409: aload_1
    //   410: ldc_w 417
    //   413: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_1
    //   418: aload_0
    //   419: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: ldc 103
    //   425: iconst_2
    //   426: aload_1
    //   427: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: bipush 6
    //   435: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   438: iconst_0
    //   439: ireturn
    //   440: iconst_1
    //   441: ireturn
    //   442: astore_0
    //   443: aload 4
    //   445: astore_3
    //   446: goto +217 -> 663
    //   449: astore_0
    //   450: aload 4
    //   452: astore 5
    //   454: goto +24 -> 478
    //   457: astore_0
    //   458: aload 4
    //   460: astore 6
    //   462: goto +78 -> 540
    //   465: astore_0
    //   466: aload 4
    //   468: astore 7
    //   470: goto +132 -> 602
    //   473: astore_0
    //   474: goto +189 -> 663
    //   477: astore_0
    //   478: aload 5
    //   480: astore_3
    //   481: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +16 -> 500
    //   487: aload 5
    //   489: astore_3
    //   490: ldc_w 299
    //   493: iconst_2
    //   494: ldc_w 419
    //   497: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: aload 5
    //   502: astore_3
    //   503: iconst_2
    //   504: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   507: aload 5
    //   509: astore_3
    //   510: aload_0
    //   511: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   514: aload 5
    //   516: ifnull +21 -> 537
    //   519: aload 5
    //   521: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   524: iconst_0
    //   525: ireturn
    //   526: astore_0
    //   527: ldc 103
    //   529: iconst_1
    //   530: ldc_w 406
    //   533: aload_0
    //   534: invokestatic 410	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   537: iconst_0
    //   538: ireturn
    //   539: astore_0
    //   540: aload 6
    //   542: astore_3
    //   543: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq +16 -> 562
    //   549: aload 6
    //   551: astore_3
    //   552: ldc_w 299
    //   555: iconst_2
    //   556: ldc_w 421
    //   559: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: aload 6
    //   564: astore_3
    //   565: iconst_3
    //   566: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   569: aload 6
    //   571: astore_3
    //   572: aload_0
    //   573: invokevirtual 114	org/json/JSONException:printStackTrace	()V
    //   576: aload 6
    //   578: ifnull +21 -> 599
    //   581: aload 6
    //   583: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   586: iconst_0
    //   587: ireturn
    //   588: astore_0
    //   589: ldc 103
    //   591: iconst_1
    //   592: ldc_w 406
    //   595: aload_0
    //   596: invokestatic 410	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   599: iconst_0
    //   600: ireturn
    //   601: astore_0
    //   602: aload 7
    //   604: astore_3
    //   605: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   608: ifeq +16 -> 624
    //   611: aload 7
    //   613: astore_3
    //   614: ldc_w 299
    //   617: iconst_2
    //   618: ldc_w 423
    //   621: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   624: aload 7
    //   626: astore_3
    //   627: iconst_1
    //   628: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   631: aload 7
    //   633: astore_3
    //   634: aload_0
    //   635: invokevirtual 357	java/io/FileNotFoundException:printStackTrace	()V
    //   638: aload 7
    //   640: ifnull +21 -> 661
    //   643: aload 7
    //   645: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   648: iconst_0
    //   649: ireturn
    //   650: astore_0
    //   651: ldc 103
    //   653: iconst_1
    //   654: ldc_w 406
    //   657: aload_0
    //   658: invokestatic 410	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   661: iconst_0
    //   662: ireturn
    //   663: aload_3
    //   664: ifnull +21 -> 685
    //   667: aload_3
    //   668: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   671: goto +14 -> 685
    //   674: astore_1
    //   675: ldc 103
    //   677: iconst_1
    //   678: ldc_w 406
    //   681: aload_1
    //   682: invokestatic 410	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   685: aload_0
    //   686: athrow
    //   687: iconst_0
    //   688: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	689	0	paramString1	String
    //   0	689	1	paramString2	String
    //   0	689	2	paramString3	String
    //   60	608	3	localObject1	Object
    //   56	411	4	localObject2	Object
    //   63	457	5	localObject3	Object
    //   67	515	6	localObject4	Object
    //   71	573	7	localObject5	Object
    //   44	168	8	str	String
    //   47	168	9	localObject6	Object
    //   50	169	10	localObject7	Object
    //   53	170	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   304	308	311	java/lang/Exception
    //   247	268	442	finally
    //   247	268	449	java/io/IOException
    //   247	268	457	org/json/JSONException
    //   247	268	465	java/io/FileNotFoundException
    //   73	79	473	finally
    //   94	104	473	finally
    //   119	131	473	finally
    //   156	165	473	finally
    //   180	187	473	finally
    //   202	211	473	finally
    //   226	247	473	finally
    //   289	300	473	finally
    //   481	487	473	finally
    //   490	500	473	finally
    //   503	507	473	finally
    //   510	514	473	finally
    //   543	549	473	finally
    //   552	562	473	finally
    //   565	569	473	finally
    //   572	576	473	finally
    //   605	611	473	finally
    //   614	624	473	finally
    //   627	631	473	finally
    //   634	638	473	finally
    //   73	79	477	java/io/IOException
    //   94	104	477	java/io/IOException
    //   119	131	477	java/io/IOException
    //   156	165	477	java/io/IOException
    //   180	187	477	java/io/IOException
    //   202	211	477	java/io/IOException
    //   226	247	477	java/io/IOException
    //   289	300	477	java/io/IOException
    //   519	524	526	java/lang/Exception
    //   73	79	539	org/json/JSONException
    //   94	104	539	org/json/JSONException
    //   119	131	539	org/json/JSONException
    //   156	165	539	org/json/JSONException
    //   180	187	539	org/json/JSONException
    //   202	211	539	org/json/JSONException
    //   226	247	539	org/json/JSONException
    //   289	300	539	org/json/JSONException
    //   581	586	588	java/lang/Exception
    //   73	79	601	java/io/FileNotFoundException
    //   94	104	601	java/io/FileNotFoundException
    //   119	131	601	java/io/FileNotFoundException
    //   156	165	601	java/io/FileNotFoundException
    //   180	187	601	java/io/FileNotFoundException
    //   202	211	601	java/io/FileNotFoundException
    //   226	247	601	java/io/FileNotFoundException
    //   289	300	601	java/io/FileNotFoundException
    //   643	648	650	java/lang/Exception
    //   667	671	674	java/lang/Exception
  }
  
  /* Error */
  private static String d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 168	java/io/BufferedInputStream
    //   5: dup
    //   6: new 334	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 364	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 340	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: sipush 4096
    //   21: newarray byte
    //   23: astore_3
    //   24: aload_1
    //   25: invokestatic 428	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   28: astore_1
    //   29: aload_0
    //   30: aload_3
    //   31: invokevirtual 431	java/io/InputStream:read	([B)I
    //   34: istore_2
    //   35: iload_2
    //   36: ifle +13 -> 49
    //   39: aload_1
    //   40: aload_3
    //   41: iconst_0
    //   42: iload_2
    //   43: invokevirtual 433	java/security/MessageDigest:update	([BII)V
    //   46: goto -17 -> 29
    //   49: aload_0
    //   50: invokevirtual 434	java/io/InputStream:close	()V
    //   53: aload_1
    //   54: invokevirtual 437	java/security/MessageDigest:digest	()[B
    //   57: invokestatic 439	com/tencent/biz/common/util/OfflineSecurity:a	([B)Ljava/lang/String;
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
    //   77: invokevirtual 434	java/io/InputStream:close	()V
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
  
  /* Error */
  private static boolean d(String paramString)
  {
    // Byte code:
    //   0: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 103
    //   8: iconst_2
    //   9: ldc_w 441
    //   12: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   27: new 72	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   34: astore 6
    //   36: aload_2
    //   37: astore_1
    //   38: aload 6
    //   40: aload_0
    //   41: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_2
    //   46: astore_1
    //   47: aload 6
    //   49: ldc_w 325
    //   52: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_2
    //   57: astore_1
    //   58: new 168	java/io/BufferedInputStream
    //   61: dup
    //   62: new 334	java/io/FileInputStream
    //   65: dup
    //   66: aload 6
    //   68: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokespecial 364	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   74: invokespecial 340	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore_2
    //   78: new 40	org/json/JSONObject
    //   81: dup
    //   82: aload_2
    //   83: invokestatic 366	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   86: invokespecial 367	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   89: astore_1
    //   90: aload_2
    //   91: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   94: aload_1
    //   95: invokevirtual 44	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   98: astore_2
    //   99: aload_2
    //   100: invokeinterface 50 1 0
    //   105: ifeq +173 -> 278
    //   108: aload_2
    //   109: invokeinterface 54 1 0
    //   114: invokevirtual 58	java/lang/Object:toString	()Ljava/lang/String;
    //   117: astore_3
    //   118: aload_1
    //   119: aload_3
    //   120: invokevirtual 380	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   123: astore 4
    //   125: new 72	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   132: astore 5
    //   134: aload 5
    //   136: aload_0
    //   137: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 5
    //   143: getstatic 82	java/io/File:separator	Ljava/lang/String;
    //   146: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 5
    //   152: aload_3
    //   153: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 4
    //   159: aload 5
    //   161: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 86	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   167: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifne -71 -> 99
    //   173: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +39 -> 215
    //   179: new 72	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   186: astore 4
    //   188: aload 4
    //   190: ldc_w 443
    //   193: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 4
    //   199: aload_3
    //   200: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: ldc 103
    //   206: iconst_2
    //   207: aload 4
    //   209: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: bipush 6
    //   217: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   220: iconst_0
    //   221: ireturn
    //   222: astore 4
    //   224: aload 4
    //   226: invokevirtual 114	org/json/JSONException:printStackTrace	()V
    //   229: iconst_5
    //   230: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   233: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq -137 -> 99
    //   239: new 72	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   246: astore 4
    //   248: aload 4
    //   250: ldc_w 445
    //   253: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 4
    //   259: aload_3
    //   260: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc 103
    //   266: iconst_2
    //   267: aload 4
    //   269: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: goto -176 -> 99
    //   278: iconst_1
    //   279: ireturn
    //   280: astore_0
    //   281: aload_2
    //   282: astore_1
    //   283: goto +165 -> 448
    //   286: astore_1
    //   287: aload_2
    //   288: astore_0
    //   289: aload_1
    //   290: astore_2
    //   291: goto +26 -> 317
    //   294: astore_1
    //   295: aload_2
    //   296: astore_0
    //   297: aload_1
    //   298: astore_2
    //   299: goto +63 -> 362
    //   302: astore_1
    //   303: aload_2
    //   304: astore_0
    //   305: aload_1
    //   306: astore_2
    //   307: goto +100 -> 407
    //   310: astore_0
    //   311: goto +137 -> 448
    //   314: astore_2
    //   315: aload_3
    //   316: astore_0
    //   317: aload_0
    //   318: astore_1
    //   319: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +14 -> 336
    //   325: aload_0
    //   326: astore_1
    //   327: ldc 103
    //   329: iconst_2
    //   330: ldc_w 447
    //   333: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload_0
    //   337: astore_1
    //   338: iconst_2
    //   339: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   342: aload_0
    //   343: astore_1
    //   344: aload_2
    //   345: invokevirtual 354	java/io/IOException:printStackTrace	()V
    //   348: aload_0
    //   349: ifnull +7 -> 356
    //   352: aload_0
    //   353: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   356: iconst_0
    //   357: ireturn
    //   358: astore_2
    //   359: aload 4
    //   361: astore_0
    //   362: aload_0
    //   363: astore_1
    //   364: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +14 -> 381
    //   370: aload_0
    //   371: astore_1
    //   372: ldc 103
    //   374: iconst_2
    //   375: ldc_w 449
    //   378: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: aload_0
    //   382: astore_1
    //   383: iconst_3
    //   384: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   387: aload_0
    //   388: astore_1
    //   389: aload_2
    //   390: invokevirtual 114	org/json/JSONException:printStackTrace	()V
    //   393: aload_0
    //   394: ifnull +7 -> 401
    //   397: aload_0
    //   398: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   401: iconst_0
    //   402: ireturn
    //   403: astore_2
    //   404: aload 5
    //   406: astore_0
    //   407: aload_0
    //   408: astore_1
    //   409: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq +14 -> 426
    //   415: aload_0
    //   416: astore_1
    //   417: ldc 103
    //   419: iconst_2
    //   420: ldc_w 451
    //   423: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: aload_0
    //   427: astore_1
    //   428: iconst_1
    //   429: invokestatic 117	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   432: aload_0
    //   433: astore_1
    //   434: aload_2
    //   435: invokevirtual 357	java/io/FileNotFoundException:printStackTrace	()V
    //   438: aload_0
    //   439: ifnull +7 -> 446
    //   442: aload_0
    //   443: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   446: iconst_0
    //   447: ireturn
    //   448: aload_1
    //   449: ifnull +7 -> 456
    //   452: aload_1
    //   453: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   456: goto +5 -> 461
    //   459: aload_0
    //   460: athrow
    //   461: goto -2 -> 459
    //   464: astore_2
    //   465: goto -371 -> 94
    //   468: astore_0
    //   469: iconst_0
    //   470: ireturn
    //   471: astore_0
    //   472: iconst_0
    //   473: ireturn
    //   474: astore_0
    //   475: iconst_0
    //   476: ireturn
    //   477: astore_1
    //   478: goto -22 -> 456
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	481	0	paramString	String
    //   26	257	1	localObject1	Object
    //   286	4	1	localIOException1	java.io.IOException
    //   294	4	1	localJSONException1	JSONException
    //   302	4	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   318	135	1	str1	String
    //   477	1	1	localIOException2	java.io.IOException
    //   24	283	2	localObject2	Object
    //   314	31	2	localIOException3	java.io.IOException
    //   358	32	2	localJSONException2	JSONException
    //   403	32	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   464	1	2	localIOException4	java.io.IOException
    //   16	300	3	str2	String
    //   18	190	4	localObject3	Object
    //   222	3	4	localJSONException3	JSONException
    //   246	114	4	localStringBuilder1	StringBuilder
    //   21	384	5	localStringBuilder2	StringBuilder
    //   34	33	6	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   118	215	222	org/json/JSONException
    //   215	220	222	org/json/JSONException
    //   78	90	280	finally
    //   78	90	286	java/io/IOException
    //   78	90	294	org/json/JSONException
    //   78	90	302	java/io/FileNotFoundException
    //   27	36	310	finally
    //   38	45	310	finally
    //   47	56	310	finally
    //   58	78	310	finally
    //   319	325	310	finally
    //   327	336	310	finally
    //   338	342	310	finally
    //   344	348	310	finally
    //   364	370	310	finally
    //   372	381	310	finally
    //   383	387	310	finally
    //   389	393	310	finally
    //   409	415	310	finally
    //   417	426	310	finally
    //   428	432	310	finally
    //   434	438	310	finally
    //   27	36	314	java/io/IOException
    //   38	45	314	java/io/IOException
    //   47	56	314	java/io/IOException
    //   58	78	314	java/io/IOException
    //   27	36	358	org/json/JSONException
    //   38	45	358	org/json/JSONException
    //   47	56	358	org/json/JSONException
    //   58	78	358	org/json/JSONException
    //   27	36	403	java/io/FileNotFoundException
    //   38	45	403	java/io/FileNotFoundException
    //   47	56	403	java/io/FileNotFoundException
    //   58	78	403	java/io/FileNotFoundException
    //   90	94	464	java/io/IOException
    //   352	356	468	java/io/IOException
    //   397	401	471	java/io/IOException
    //   442	446	474	java/io/IOException
    //   452	456	477	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.OfflineSecurity
 * JD-Core Version:    0.7.0.1
 */