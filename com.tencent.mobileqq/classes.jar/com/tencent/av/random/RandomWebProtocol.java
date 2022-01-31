package com.tencent.av.random;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jmr;
import jms;
import jmt;
import jmu;
import jmv;
import jmw;
import jmx;

public class RandomWebProtocol
{
  private static String jdField_a_of_type_JavaLangString;
  public int a;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  public List a;
  private Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private jmt jdField_a_of_type_Jmt;
  
  RandomWebProtocol(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Jmt = new jmt(this);
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: ldc 54
    //   7: astore 4
    //   9: new 56	java/net/URL
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 59	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 63	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   20: checkcast 65	java/net/HttpURLConnection
    //   23: astore_0
    //   24: aload_0
    //   25: iconst_1
    //   26: invokevirtual 69	java/net/HttpURLConnection:setDoInput	(Z)V
    //   29: aload_0
    //   30: iconst_1
    //   31: invokevirtual 72	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   34: aload_0
    //   35: ldc 74
    //   37: ldc 76
    //   39: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_2
    //   43: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +10 -> 56
    //   49: aload_0
    //   50: ldc 88
    //   52: aload_2
    //   53: invokevirtual 80	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: ldc 90
    //   59: invokevirtual 93	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: iconst_0
    //   64: invokevirtual 96	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   67: aload_0
    //   68: sipush 5000
    //   71: invokevirtual 100	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   74: aload_0
    //   75: sipush 10000
    //   78: invokevirtual 103	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   81: aload_0
    //   82: invokevirtual 106	java/net/HttpURLConnection:connect	()V
    //   85: aload_1
    //   86: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifne +28 -> 117
    //   92: new 108	java/io/DataOutputStream
    //   95: dup
    //   96: aload_0
    //   97: invokevirtual 112	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   100: invokespecial 115	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   103: astore_2
    //   104: aload_2
    //   105: aload_1
    //   106: invokevirtual 118	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   109: aload_2
    //   110: invokevirtual 121	java/io/DataOutputStream:flush	()V
    //   113: aload_2
    //   114: invokevirtual 124	java/io/DataOutputStream:close	()V
    //   117: new 126	java/io/BufferedReader
    //   120: dup
    //   121: new 128	java/io/InputStreamReader
    //   124: dup
    //   125: aload_0
    //   126: invokevirtual 132	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   129: invokespecial 135	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   132: invokespecial 138	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   135: astore_1
    //   136: new 140	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   143: astore_2
    //   144: aload_1
    //   145: invokevirtual 144	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   148: astore_3
    //   149: aload_3
    //   150: ifnull +33 -> 183
    //   153: aload_2
    //   154: aload_3
    //   155: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: goto -15 -> 144
    //   162: astore_1
    //   163: aload_0
    //   164: astore_3
    //   165: aload_1
    //   166: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   169: aload 4
    //   171: astore_1
    //   172: aload_0
    //   173: ifnull +55 -> 228
    //   176: aload_0
    //   177: invokevirtual 154	java/net/HttpURLConnection:disconnect	()V
    //   180: ldc 54
    //   182: areturn
    //   183: aload_1
    //   184: invokevirtual 155	java/io/BufferedReader:close	()V
    //   187: aload_2
    //   188: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: astore_2
    //   192: aload_2
    //   193: astore_1
    //   194: aload_0
    //   195: ifnull +33 -> 228
    //   198: aload_0
    //   199: invokevirtual 154	java/net/HttpURLConnection:disconnect	()V
    //   202: aload_2
    //   203: areturn
    //   204: astore_1
    //   205: aload_3
    //   206: astore_0
    //   207: aload_0
    //   208: ifnull +7 -> 215
    //   211: aload_0
    //   212: invokevirtual 154	java/net/HttpURLConnection:disconnect	()V
    //   215: aload_1
    //   216: athrow
    //   217: astore_1
    //   218: goto -11 -> 207
    //   221: astore_1
    //   222: aload 5
    //   224: astore_0
    //   225: goto -62 -> 163
    //   228: aload_1
    //   229: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramString1	String
    //   0	230	1	paramString2	String
    //   0	230	2	paramString3	String
    //   1	205	3	str1	String
    //   7	163	4	str2	String
    //   3	220	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	56	162	java/lang/Exception
    //   56	117	162	java/lang/Exception
    //   117	144	162	java/lang/Exception
    //   144	149	162	java/lang/Exception
    //   153	159	162	java/lang/Exception
    //   183	192	162	java/lang/Exception
    //   9	24	204	finally
    //   165	169	204	finally
    //   24	56	217	finally
    //   56	117	217	finally
    //   117	144	217	finally
    //   144	149	217	finally
    //   153	159	217	finally
    //   183	192	217	finally
    //   9	24	221	java/lang/Exception
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    if (paramLong != 0L)
    {
      if (b()) {
        QLog.w("RandomWebProtocol", 2, "[randomWeb]In Test Env");
      }
      paramString = new jmx(this, paramInt1, paramLong, paramInt2, paramString);
      if ((jms)this.jdField_a_of_type_JavaUtilMap.get(paramString.d) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb][multiRoomOwner]sessionType(" + paramInt1 + ")");
        }
        jms localjms = new jms(this, paramString);
        this.jdField_a_of_type_JavaUtilMap.put(paramString.d, localjms);
        localjms.start();
      }
    }
  }
  
  private static String b(String paramString)
  {
    String str = null;
    if (!TextUtils.isEmpty(paramString)) {
      str = ChatActivityUtils.a(jdField_a_of_type_JavaLangString, paramString);
    }
    return str;
  }
  
  public static boolean b()
  {
    return false;
  }
  
  private static byte[] b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = paramString.replace("+", "").split(",");
      byte[] arrayOfByte = new byte[paramString.length];
      int i = 0;
      while (i < paramString.length)
      {
        arrayOfByte[i] = Byte.parseByte(paramString[i].trim());
        i += 1;
      }
      return arrayOfByte;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  /* Error */
  public android.graphics.Bitmap a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +37 -> 40
    //   6: ldc 165
    //   8: iconst_2
    //   9: new 140	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   16: ldc 249
    //   18: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 251
    //   27: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_2
    //   31: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: getfield 28	com/tencent/av/random/RandomWebProtocol:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   44: invokevirtual 254	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   47: aload_1
    //   48: iconst_1
    //   49: invokevirtual 259	com/tencent/av/VideoController:a	(Ljava/lang/String;Z)Landroid/graphics/Bitmap;
    //   52: astore 4
    //   54: aload 4
    //   56: ifnull +60 -> 116
    //   59: aload 4
    //   61: astore 5
    //   63: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +39 -> 105
    //   69: ldc 165
    //   71: iconst_2
    //   72: new 140	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 261
    //   82: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 263
    //   92: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload 4
    //   103: astore 5
    //   105: aload 5
    //   107: areturn
    //   108: astore 4
    //   110: aconst_null
    //   111: astore 4
    //   113: goto -59 -> 54
    //   116: new 140	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   123: invokestatic 267	com/tencent/av/utils/ImageResUtil:a	()Ljava/lang/String;
    //   126: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_2
    //   130: invokestatic 272	com/tencent/mobileqq/mqsafeedit/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_2
    //   137: aload_2
    //   138: ldc_w 274
    //   141: invokevirtual 278	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   144: invokevirtual 282	java/lang/String:substring	(I)Ljava/lang/String;
    //   147: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: astore 5
    //   155: aload 5
    //   157: invokestatic 287	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   160: ifeq +107 -> 267
    //   163: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +40 -> 206
    //   169: ldc 165
    //   171: iconst_2
    //   172: new 140	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   179: ldc_w 289
    //   182: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_1
    //   186: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc_w 291
    //   192: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 5
    //   197: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload 5
    //   208: invokestatic 287	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   211: istore_3
    //   212: aload 4
    //   214: astore_2
    //   215: iload_3
    //   216: ifeq +32 -> 248
    //   219: new 293	java/io/BufferedInputStream
    //   222: dup
    //   223: new 295	java/io/FileInputStream
    //   226: dup
    //   227: aload 5
    //   229: invokespecial 296	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   232: invokespecial 297	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   235: astore 4
    //   237: aload 4
    //   239: invokestatic 303	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   242: astore_2
    //   243: aload 4
    //   245: invokevirtual 304	java/io/BufferedInputStream:close	()V
    //   248: aload_2
    //   249: ifnull +145 -> 394
    //   252: aload_0
    //   253: getfield 28	com/tencent/av/random/RandomWebProtocol:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   256: invokevirtual 254	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   259: aload_1
    //   260: aload_2
    //   261: iconst_1
    //   262: invokevirtual 307	com/tencent/av/VideoController:a	(Ljava/lang/String;Landroid/graphics/Bitmap;Z)V
    //   265: aload_2
    //   266: areturn
    //   267: new 309	java/io/File
    //   270: dup
    //   271: aload 5
    //   273: invokespecial 310	java/io/File:<init>	(Ljava/lang/String;)V
    //   276: astore 6
    //   278: aload_0
    //   279: getfield 28	com/tencent/av/random/RandomWebProtocol:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   282: aload_2
    //   283: aload 6
    //   285: invokestatic 315	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   288: istore_3
    //   289: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq -86 -> 206
    //   295: ldc 165
    //   297: iconst_2
    //   298: new 140	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   305: ldc_w 289
    //   308: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_1
    //   312: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc_w 317
    //   318: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_2
    //   322: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 319
    //   328: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 5
    //   333: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: ldc_w 321
    //   339: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: iload_3
    //   343: invokevirtual 324	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   346: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: goto -146 -> 206
    //   355: astore_2
    //   356: aload 4
    //   358: astore_2
    //   359: goto -111 -> 248
    //   362: astore_2
    //   363: aconst_null
    //   364: astore_2
    //   365: goto -117 -> 248
    //   368: astore_2
    //   369: aconst_null
    //   370: astore_2
    //   371: goto -123 -> 248
    //   374: astore_2
    //   375: aload_0
    //   376: getfield 28	com/tencent/av/random/RandomWebProtocol:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   379: invokevirtual 254	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   382: aload_1
    //   383: aconst_null
    //   384: iconst_1
    //   385: invokevirtual 307	com/tencent/av/VideoController:a	(Ljava/lang/String;Landroid/graphics/Bitmap;Z)V
    //   388: aload 4
    //   390: astore_2
    //   391: goto -143 -> 248
    //   394: aload_2
    //   395: astore 5
    //   397: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq -295 -> 105
    //   403: ldc 165
    //   405: iconst_2
    //   406: new 140	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 289
    //   416: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload_1
    //   420: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: ldc_w 326
    //   426: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   435: aload_2
    //   436: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	this	RandomWebProtocol
    //   0	437	1	paramString1	String
    //   0	437	2	paramString2	String
    //   211	132	3	bool	boolean
    //   52	50	4	localBitmap	android.graphics.Bitmap
    //   108	1	4	localException	java.lang.Exception
    //   111	278	4	localBufferedInputStream	java.io.BufferedInputStream
    //   61	335	5	localObject	Object
    //   276	8	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   40	54	108	java/lang/Exception
    //   116	206	355	java/lang/Exception
    //   206	212	355	java/lang/Exception
    //   267	352	355	java/lang/Exception
    //   219	248	362	java/lang/OutOfMemoryError
    //   219	248	368	java/lang/Exception
    //   116	206	374	java/lang/OutOfMemoryError
    //   206	212	374	java/lang/OutOfMemoryError
    //   267	352	374	java/lang/OutOfMemoryError
  }
  
  public void a()
  {
    jms localjms = (jms)this.jdField_a_of_type_JavaUtilMap.get("[d] RequestDouble");
    if (localjms != null) {
      localjms.a();
    }
    localjms = (jms)this.jdField_a_of_type_JavaUtilMap.get("[m] RequestMulti");
    if (localjms != null) {
      localjms.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Jmt.b = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] *** matchDouble ***");
    }
    boolean bool = b();
    if (bool) {
      QLog.w("RandomWebProtocol", 2, "[randomWeb]In Test Env");
    }
    if (bool) {}
    for (Object localObject = "https://play.mobile.qq.com/dchat_test/cgi-bin/chatplay/onechat";; localObject = "https://play.mobile.qq.com/dchat/cgi-bin/chatplay/onechat")
    {
      paramVarArgs = new jmu(this, this.jdField_a_of_type_Jmt, (String)localObject, paramInt1, paramInt2, paramInt3, paramVarArgs);
      localObject = (jms)this.jdField_a_of_type_JavaUtilMap.get(paramVarArgs.d);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb] matchDouble: last matching not finished, dropped it!");
        }
        ((jms)localObject).a();
      }
      localObject = new jms(this, paramVarArgs);
      this.jdField_a_of_type_JavaUtilMap.put(paramVarArgs.d, localObject);
      ((jms)localObject).start();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    boolean bool = b();
    if (bool) {
      QLog.w("RandomWebProtocol", 2, "[randomWeb]In Test Env");
    }
    if (bool) {}
    for (Object localObject = "https://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/grouppull";; localObject = "https://play.mobile.qq.com/randchat/cgi-bin/chatplay/grouppull")
    {
      localObject = new jmw(this, this.jdField_a_of_type_Jmt, (String)localObject, paramInt1, paramInt2, paramString, paramInt3, paramLong);
      if ((jms)this.jdField_a_of_type_JavaUtilMap.get(((jmw)localObject).d) != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomWebProtocol", 2, "[randomWeb][pullhead] ====== pullMulti ====== type(" + paramInt2 + "), uin(" + paramString + "), groupId(" + paramLong + "), gender(" + paramInt3 + ")");
      }
      paramString = new jms(this, (jmt)localObject);
      this.jdField_a_of_type_JavaUtilMap.put(((jmw)localObject).d, paramString);
      paramString.start();
      return;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, 5, null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] ====== pullDouble ====== uin(" + paramString1 + "), url(" + paramString2 + ")");
    }
    new jmr(this, paramString2, paramString1).start();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] *** matchMulti~ ***");
    }
    boolean bool = b();
    if (bool) {
      QLog.w("RandomWebProtocol", 2, "[randomWeb]In Test Env");
    }
    if (bool) {}
    for (Object localObject = "https://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/groupchat";; localObject = "https://play.mobile.qq.com/randchat/cgi-bin/chatplay/groupchat")
    {
      localObject = new jmv(this, this.jdField_a_of_type_Jmt, (String)localObject, paramBoolean, paramInt);
      jms localjms = (jms)this.jdField_a_of_type_JavaUtilMap.get(((jmv)localObject).d);
      if (localjms != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb] matchMulti~: last matching not finished, dropped it!");
        }
        localjms.a();
      }
      localjms = new jms(this, (jmt)localObject);
      this.jdField_a_of_type_JavaUtilMap.put(((jmv)localObject).d, localjms);
      localjms.start();
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Jmt.b != -1;
  }
  
  public void b()
  {
    jms localjms = (jms)this.jdField_a_of_type_JavaUtilMap.get("[m] RequestMultiRoomOwner");
    if (localjms != null) {
      localjms.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol
 * JD-Core Version:    0.7.0.1
 */