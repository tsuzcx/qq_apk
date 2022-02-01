package com.tencent.av.random;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RandomWebProtocol
{
  private static String jdField_a_of_type_JavaLangString;
  int jdField_a_of_type_Int;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private RandomWebProtocol.RandomReportTask jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$RandomReportTask;
  private RandomWebProtocol.Request jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$Request;
  List<RandomWebProtocol.OnRequestListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, RandomWebProtocol.MatchTask> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  RandomWebProtocol(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$Request = new RandomWebProtocol.Request(this);
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: ldc 60
    //   7: astore 4
    //   9: new 62	java/net/URL
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 65	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 69	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   20: checkcast 71	java/net/HttpURLConnection
    //   23: astore_0
    //   24: aload_0
    //   25: iconst_1
    //   26: invokevirtual 75	java/net/HttpURLConnection:setDoInput	(Z)V
    //   29: aload_0
    //   30: iconst_1
    //   31: invokevirtual 78	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   34: aload_0
    //   35: ldc 80
    //   37: ldc 82
    //   39: invokevirtual 86	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_2
    //   43: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +10 -> 56
    //   49: aload_0
    //   50: ldc 94
    //   52: aload_2
    //   53: invokevirtual 86	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: ldc 96
    //   59: invokevirtual 99	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: iconst_0
    //   64: invokevirtual 102	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   67: aload_0
    //   68: sipush 5000
    //   71: invokevirtual 106	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   74: aload_0
    //   75: sipush 10000
    //   78: invokevirtual 109	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   81: aload_0
    //   82: invokevirtual 112	java/net/HttpURLConnection:connect	()V
    //   85: aload_1
    //   86: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifne +28 -> 117
    //   92: new 114	java/io/DataOutputStream
    //   95: dup
    //   96: aload_0
    //   97: invokevirtual 118	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   100: invokespecial 121	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   103: astore_2
    //   104: aload_2
    //   105: aload_1
    //   106: invokevirtual 124	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   109: aload_2
    //   110: invokevirtual 127	java/io/DataOutputStream:flush	()V
    //   113: aload_2
    //   114: invokevirtual 130	java/io/DataOutputStream:close	()V
    //   117: new 132	java/io/BufferedReader
    //   120: dup
    //   121: new 134	java/io/InputStreamReader
    //   124: dup
    //   125: aload_0
    //   126: invokevirtual 138	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   129: invokespecial 141	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   132: invokespecial 144	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   135: astore_1
    //   136: new 146	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   143: astore_2
    //   144: aload_1
    //   145: invokevirtual 150	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   148: astore_3
    //   149: aload_3
    //   150: ifnull +33 -> 183
    //   153: aload_2
    //   154: aload_3
    //   155: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: goto -15 -> 144
    //   162: astore_1
    //   163: aload_0
    //   164: astore_3
    //   165: aload_1
    //   166: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   169: aload 4
    //   171: astore_1
    //   172: aload_0
    //   173: ifnull +55 -> 228
    //   176: aload_0
    //   177: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   180: ldc 60
    //   182: areturn
    //   183: aload_1
    //   184: invokevirtual 161	java/io/BufferedReader:close	()V
    //   187: aload_2
    //   188: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: astore_2
    //   192: aload_2
    //   193: astore_1
    //   194: aload_0
    //   195: ifnull +33 -> 228
    //   198: aload_0
    //   199: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   202: aload_2
    //   203: areturn
    //   204: astore_1
    //   205: aload_3
    //   206: astore_0
    //   207: aload_0
    //   208: ifnull +7 -> 215
    //   211: aload_0
    //   212: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
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
      paramString = new RandomWebProtocol.RequestMultiRoomOwner(this, paramInt1, paramLong, paramInt2, paramString);
      if ((RandomWebProtocol.MatchTask)this.jdField_a_of_type_JavaUtilMap.get(paramString.d) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb][multiRoomOwner]sessionType(" + paramInt1 + ")");
        }
        RandomWebProtocol.MatchTask localMatchTask = new RandomWebProtocol.MatchTask(this, paramString);
        this.jdField_a_of_type_JavaUtilMap.put(paramString.d, localMatchTask);
        localMatchTask.start();
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
  android.graphics.Bitmap a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +38 -> 41
    //   6: ldc 171
    //   8: iconst_2
    //   9: new 146	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   16: ldc 255
    //   18: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc_w 257
    //   28: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_0
    //   42: getfield 31	com/tencent/av/random/RandomWebProtocol:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   45: invokevirtual 260	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   48: aload_1
    //   49: iconst_1
    //   50: invokevirtual 265	com/tencent/av/VideoController:a	(Ljava/lang/String;Z)Landroid/graphics/Bitmap;
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +60 -> 117
    //   60: aload 4
    //   62: astore 5
    //   64: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   67: ifeq +39 -> 106
    //   70: ldc 171
    //   72: iconst_2
    //   73: new 146	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 267
    //   83: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 269
    //   93: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload 4
    //   104: astore 5
    //   106: aload 5
    //   108: areturn
    //   109: astore 4
    //   111: aconst_null
    //   112: astore 4
    //   114: goto -59 -> 55
    //   117: new 146	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   124: invokestatic 273	com/tencent/av/utils/ImageResUtil:a	()Ljava/lang/String;
    //   127: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_2
    //   131: invokestatic 278	com/tencent/mobileqq/mqsafeedit/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_2
    //   138: aload_2
    //   139: ldc_w 280
    //   142: invokevirtual 284	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   145: invokevirtual 288	java/lang/String:substring	(I)Ljava/lang/String;
    //   148: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore 5
    //   156: aload 5
    //   158: invokestatic 293	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   161: ifeq +107 -> 268
    //   164: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +40 -> 207
    //   170: ldc 171
    //   172: iconst_2
    //   173: new 146	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 295
    //   183: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_1
    //   187: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc_w 297
    //   193: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 5
    //   198: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload 5
    //   209: invokestatic 293	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   212: istore_3
    //   213: aload 4
    //   215: astore_2
    //   216: iload_3
    //   217: ifeq +32 -> 249
    //   220: new 299	java/io/BufferedInputStream
    //   223: dup
    //   224: new 301	java/io/FileInputStream
    //   227: dup
    //   228: aload 5
    //   230: invokespecial 302	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   233: invokespecial 303	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   236: astore 4
    //   238: aload 4
    //   240: invokestatic 309	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   243: astore_2
    //   244: aload 4
    //   246: invokevirtual 310	java/io/BufferedInputStream:close	()V
    //   249: aload_2
    //   250: ifnull +145 -> 395
    //   253: aload_0
    //   254: getfield 31	com/tencent/av/random/RandomWebProtocol:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   257: invokevirtual 260	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   260: aload_1
    //   261: aload_2
    //   262: iconst_1
    //   263: invokevirtual 313	com/tencent/av/VideoController:a	(Ljava/lang/String;Landroid/graphics/Bitmap;Z)V
    //   266: aload_2
    //   267: areturn
    //   268: new 315	java/io/File
    //   271: dup
    //   272: aload 5
    //   274: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   277: astore 6
    //   279: aload_0
    //   280: getfield 31	com/tencent/av/random/RandomWebProtocol:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   283: aload_2
    //   284: aload 6
    //   286: invokestatic 322	com/tencent/mobileqq/utils/HttpDownloadUtil:download	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/io/File;)Z
    //   289: istore_3
    //   290: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   293: ifeq -86 -> 207
    //   296: ldc 171
    //   298: iconst_2
    //   299: new 146	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   306: ldc_w 295
    //   309: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_1
    //   313: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc_w 324
    //   319: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_2
    //   323: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc_w 326
    //   329: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload 5
    //   334: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc_w 328
    //   340: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: iload_3
    //   344: invokevirtual 331	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   347: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: goto -146 -> 207
    //   356: astore_2
    //   357: aload 4
    //   359: astore_2
    //   360: goto -111 -> 249
    //   363: astore_2
    //   364: aconst_null
    //   365: astore_2
    //   366: goto -117 -> 249
    //   369: astore_2
    //   370: aconst_null
    //   371: astore_2
    //   372: goto -123 -> 249
    //   375: astore_2
    //   376: aload_0
    //   377: getfield 31	com/tencent/av/random/RandomWebProtocol:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   380: invokevirtual 260	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/av/VideoController;
    //   383: aload_1
    //   384: aconst_null
    //   385: iconst_1
    //   386: invokevirtual 313	com/tencent/av/VideoController:a	(Ljava/lang/String;Landroid/graphics/Bitmap;Z)V
    //   389: aload 4
    //   391: astore_2
    //   392: goto -143 -> 249
    //   395: aload_2
    //   396: astore 5
    //   398: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   401: ifeq -295 -> 106
    //   404: ldc 171
    //   406: iconst_2
    //   407: new 146	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 295
    //   417: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_1
    //   421: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: ldc_w 333
    //   427: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: aload_2
    //   437: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	RandomWebProtocol
    //   0	438	1	paramString1	String
    //   0	438	2	paramString2	String
    //   212	132	3	bool	boolean
    //   53	50	4	localBitmap	android.graphics.Bitmap
    //   109	1	4	localException	java.lang.Exception
    //   112	278	4	localBufferedInputStream	java.io.BufferedInputStream
    //   62	335	5	localObject	Object
    //   277	8	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   41	55	109	java/lang/Exception
    //   117	207	356	java/lang/Exception
    //   207	213	356	java/lang/Exception
    //   268	353	356	java/lang/Exception
    //   220	249	363	java/lang/OutOfMemoryError
    //   220	249	369	java/lang/Exception
    //   117	207	375	java/lang/OutOfMemoryError
    //   207	213	375	java/lang/OutOfMemoryError
    //   268	353	375	java/lang/OutOfMemoryError
  }
  
  public void a()
  {
    RandomWebProtocol.MatchTask localMatchTask = (RandomWebProtocol.MatchTask)this.jdField_a_of_type_JavaUtilMap.get("[d] RequestDouble");
    if (localMatchTask != null) {
      localMatchTask.a();
    }
    localMatchTask = (RandomWebProtocol.MatchTask)this.jdField_a_of_type_JavaUtilMap.get("[m] RequestMulti");
    if (localMatchTask != null) {
      localMatchTask.a();
    }
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$Request.b = paramInt;
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
      paramVarArgs = new RandomWebProtocol.RequestDouble(this, this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$Request, (String)localObject, paramInt1, paramInt2, paramInt3, paramVarArgs);
      localObject = (RandomWebProtocol.MatchTask)this.jdField_a_of_type_JavaUtilMap.get(paramVarArgs.d);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb] matchDouble: last matching not finished, dropped it!");
        }
        ((RandomWebProtocol.MatchTask)localObject).a();
      }
      localObject = new RandomWebProtocol.MatchTask(this, paramVarArgs);
      this.jdField_a_of_type_JavaUtilMap.put(paramVarArgs.d, localObject);
      ((RandomWebProtocol.MatchTask)localObject).start();
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
      localObject = new RandomWebProtocol.RequestMultiPull(this, this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$Request, (String)localObject, paramInt1, paramInt2, paramString, paramInt3, paramLong);
      if ((RandomWebProtocol.MatchTask)this.jdField_a_of_type_JavaUtilMap.get(((RandomWebProtocol.RequestMultiPull)localObject).d) != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomWebProtocol", 2, "[randomWeb][pullhead] ====== pullMulti ====== type(" + paramInt2 + "), uin(" + paramString + "), groupId(" + paramLong + "), gender(" + paramInt3 + ")");
      }
      paramString = new RandomWebProtocol.MatchTask(this, (RandomWebProtocol.Request)localObject);
      this.jdField_a_of_type_JavaUtilMap.put(((RandomWebProtocol.RequestMultiPull)localObject).d, paramString);
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
    new RandomWebProtocol.1(this, paramString2, paramString1).start();
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
      localObject = new RandomWebProtocol.RequestMulti(this, this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$Request, (String)localObject, paramBoolean, paramInt);
      RandomWebProtocol.MatchTask localMatchTask = (RandomWebProtocol.MatchTask)this.jdField_a_of_type_JavaUtilMap.get(((RandomWebProtocol.RequestMulti)localObject).d);
      if (localMatchTask != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb] matchMulti~: last matching not finished, dropped it!");
        }
        localMatchTask.a();
      }
      localMatchTask = new RandomWebProtocol.MatchTask(this, (RandomWebProtocol.Request)localObject);
      this.jdField_a_of_type_JavaUtilMap.put(((RandomWebProtocol.RequestMulti)localObject).d, localMatchTask);
      localMatchTask.start();
      return;
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$Request.b != -1;
  }
  
  public void b()
  {
    RandomWebProtocol.MatchTask localMatchTask = (RandomWebProtocol.MatchTask)this.jdField_a_of_type_JavaUtilMap.get("[m] RequestMultiRoomOwner");
    if (localMatchTask != null) {
      localMatchTask.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol
 * JD-Core Version:    0.7.0.1
 */