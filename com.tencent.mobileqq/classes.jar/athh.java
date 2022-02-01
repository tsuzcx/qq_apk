import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import mqq.app.MobileQQ;

public class athh
  implements IHttpCommunicatorListener
{
  public static int a;
  public static String a;
  public static int b;
  public static int c;
  long jdField_a_of_type_Long = 0L;
  private athg jdField_a_of_type_Athg;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private OutputStream jdField_a_of_type_JavaIoOutputStream;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  long jdField_b_of_type_Long = 0L;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private final String jdField_b_of_type_JavaLangString;
  private final long jdField_c_of_type_Long;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = jdField_b_of_type_Int;
  private long jdField_d_of_type_Long;
  private Object jdField_d_of_type_JavaLangObject = new Object();
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private Object jdField_e_of_type_JavaLangObject = new Object();
  private int f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloaderGenWorker<FileAssistant>";
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
  }
  
  public athh(long paramLong1, QQAppInterface paramQQAppInterface, String paramString1, long paramLong2, String paramString2, athg paramathg)
  {
    this.jdField_c_of_type_Long = paramLong1;
    this.jdField_b_of_type_JavaLangString = new asib(paramQQAppInterface, paramString1).a();
    this.jdField_a_of_type_Athg = paramathg;
    this.jdField_d_of_type_Long = paramLong2;
    this.jdField_d_of_type_JavaLangString = paramString2;
  }
  
  private int a()
  {
    int i = jdField_b_of_type_Int;
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      i = this.jdField_d_of_type_Int;
      return i;
    }
  }
  
  private long a()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      long l = this.jdField_e_of_type_Long;
      return l;
    }
  }
  
  private athg a()
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      athg localathg = this.jdField_a_of_type_Athg;
      return localathg;
    }
  }
  
  private HttpMsg a()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      HttpMsg localHttpMsg = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
      return localHttpMsg;
    }
  }
  
  private void a(int paramInt)
  {
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. setStatus: " + this.jdField_d_of_type_Int + " -> " + paramInt);
      this.jdField_d_of_type_Int = paramInt;
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    c();
    QQAppInterface localQQAppInterface = atdm.a().a();
    if (localQQAppInterface != null)
    {
      aszt.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", this.jdField_e_of_type_Int, paramString2, null);
      aszt.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", this.jdField_e_of_type_Int, paramString2, null);
      bcev.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
    }
    for (;;)
    {
      paramString2 = a();
      if (paramString2 != null) {
        paramString2.a(paramInt, paramString1, null);
      }
      return;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 3");
    }
  }
  
  private void a(long paramLong)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_e_of_type_Long = paramLong;
      return;
    }
  }
  
  private void a(athg paramathg)
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Athg = paramathg;
      return;
    }
  }
  
  private void a(HttpMsg paramHttpMsg)
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramHttpMsg;
      return;
    }
  }
  
  private boolean a()
  {
    return jdField_b_of_type_Int == a();
  }
  
  /* Error */
  private boolean a(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: lload_1
    //   6: invokespecial 174	athh:a	(J)V
    //   9: new 81	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   16: ldc 176
    //   18: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_1
    //   22: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: ldc 178
    //   27: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 5
    //   35: aload_0
    //   36: getfield 64	athh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   39: ifnull +239 -> 278
    //   42: aload_0
    //   43: getfield 64	athh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   46: ldc 180
    //   48: invokevirtual 186	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   51: ifne +227 -> 278
    //   54: new 81	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   61: aload_0
    //   62: getfield 64	athh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   65: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 188
    //   70: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: lload_1
    //   74: invokestatic 192	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   77: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore 4
    //   85: new 194	com/tencent/mobileqq/utils/httputils/HttpMsg
    //   88: dup
    //   89: aload 4
    //   91: aconst_null
    //   92: aload_0
    //   93: iconst_1
    //   94: invokespecial 197	com/tencent/mobileqq/utils/httputils/HttpMsg:<init>	(Ljava/lang/String;[BLcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;Z)V
    //   97: astore 6
    //   99: ldc 199
    //   101: astore 4
    //   103: invokestatic 205	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   106: invokestatic 211	com/tencent/mobileqq/utils/NetworkUtil:getNetworkType	(Landroid/content/Context;)I
    //   109: iconst_1
    //   110: if_icmpne +7 -> 117
    //   113: ldc 213
    //   115: astore 4
    //   117: aload 6
    //   119: ldc 215
    //   121: aload 4
    //   123: invokevirtual 219	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 6
    //   128: ldc 221
    //   130: aload 5
    //   132: invokevirtual 219	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 6
    //   137: iconst_1
    //   138: invokevirtual 224	com/tencent/mobileqq/utils/httputils/HttpMsg:setPriority	(I)V
    //   141: aload_0
    //   142: getfield 70	athh:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   145: invokestatic 229	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: ifne +14 -> 162
    //   151: aload 6
    //   153: ldc 231
    //   155: aload_0
    //   156: getfield 70	athh:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   159: invokevirtual 219	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload 6
    //   164: iconst_1
    //   165: invokevirtual 235	com/tencent/mobileqq/utils/httputils/HttpMsg:setDataSlice	(Z)V
    //   168: aload 6
    //   170: iconst_5
    //   171: putfield 238	com/tencent/mobileqq/utils/httputils/HttpMsg:fileType	I
    //   174: aload 6
    //   176: iconst_0
    //   177: putfield 241	com/tencent/mobileqq/utils/httputils/HttpMsg:busiType	I
    //   180: aload 6
    //   182: invokestatic 246	java/lang/System:currentTimeMillis	()J
    //   185: invokestatic 192	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   188: putfield 249	com/tencent/mobileqq/utils/httputils/HttpMsg:msgId	Ljava/lang/String;
    //   191: aload 6
    //   193: ldc 251
    //   195: ldc 253
    //   197: invokevirtual 219	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload_0
    //   201: aload 6
    //   203: invokespecial 255	athh:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   206: invokestatic 115	atdm:a	()Latdm;
    //   209: invokevirtual 118	atdm:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   212: astore 4
    //   214: aload 4
    //   216: ifnonnull +97 -> 313
    //   219: getstatic 25	athh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   222: iconst_1
    //   223: new 81	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   230: ldc 84
    //   232: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_0
    //   236: getfield 54	athh:jdField_c_of_type_Long	J
    //   239: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   242: ldc_w 257
    //   245: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: lload_1
    //   249: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   252: ldc_w 259
    //   255: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: lload_1
    //   259: aload_0
    //   260: getfield 68	athh:jdField_d_of_type_Long	J
    //   263: ldiv
    //   264: l2i
    //   265: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_0
    //   275: monitorexit
    //   276: iload_3
    //   277: ireturn
    //   278: new 81	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   285: aload_0
    //   286: getfield 64	athh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   289: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc_w 261
    //   295: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: lload_1
    //   299: invokestatic 192	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   302: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: astore 4
    //   310: goto -225 -> 85
    //   313: aload 4
    //   315: invokevirtual 265	com/tencent/mobileqq/app/QQAppInterface:getHttpCommunicatort	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   318: aload 6
    //   320: invokevirtual 271	com/tencent/mobileqq/utils/httputils/HttpCommunicator:sendMsg	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)I
    //   323: pop
    //   324: getstatic 25	athh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   327: iconst_1
    //   328: new 81	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   335: ldc 84
    //   337: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_0
    //   341: getfield 54	athh:jdField_c_of_type_Long	J
    //   344: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   347: ldc_w 273
    //   350: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: lload_1
    //   354: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   357: ldc_w 259
    //   360: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: lload_1
    //   364: aload_0
    //   365: getfield 68	athh:jdField_d_of_type_Long	J
    //   368: ldiv
    //   369: l2i
    //   370: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   373: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: iconst_1
    //   380: istore_3
    //   381: goto -107 -> 274
    //   384: astore 4
    //   386: aload_0
    //   387: monitorexit
    //   388: aload 4
    //   390: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	athh
    //   0	391	1	paramLong	long
    //   1	380	3	bool	boolean
    //   83	231	4	localObject1	Object
    //   384	5	4	localObject2	Object
    //   33	98	5	str	String
    //   97	222	6	localHttpMsg	HttpMsg
    // Exception table:
    //   from	to	target	type
    //   4	85	384	finally
    //   85	99	384	finally
    //   103	113	384	finally
    //   117	162	384	finally
    //   162	214	384	finally
    //   219	274	384	finally
    //   278	310	384	finally
    //   313	379	384	finally
  }
  
  private boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg1 == null) {
      return false;
    }
    if (paramHttpMsg2 == null) {
      return true;
    }
    return paramHttpMsg2.permitRetry();
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. writeFileStream: stream = null:");
          return false;
        }
        this.jdField_a_of_type_JavaIoOutputStream.write(paramArrayOfByte);
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return false;
      }
    }
  }
  
  private boolean b()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        OutputStream localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
        if (localOutputStream == null) {
          try
          {
            this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_c_of_type_JavaLangString, true);
            QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. openFileStream: filepath:" + this.jdField_c_of_type_JavaLangString);
            return true;
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. openFileStream: exception");
            localFileNotFoundException.printStackTrace();
            return false;
          }
        }
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. openFileStream: had be opened");
    }
  }
  
  private void c()
  {
    try
    {
      a(jdField_b_of_type_Int);
      d();
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream != null)
        {
          this.jdField_a_of_type_JavaIoOutputStream.close();
          this.jdField_a_of_type_JavaIoOutputStream = null;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. closeFileStream: filepath:" + this.jdField_c_of_type_JavaLangString);
        }
        for (;;)
        {
          return true;
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. closeFileStream.had closed: stream = null:");
        }
        localObject2 = finally;
      }
      catch (IOException localIOException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. closeFileStream: exception");
        localIOException.printStackTrace();
        return false;
      }
    }
  }
  
  private void d()
  {
    HttpMsg localHttpMsg = a();
    if (localHttpMsg != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest");
      a(null);
      QQAppInterface localQQAppInterface = atdm.a().a();
      if (localQQAppInterface == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest failed.APP=null");
        return;
      }
      localQQAppInterface.getHttpCommunicatort().cancelMsg(localHttpMsg);
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest: no request");
  }
  
  public void a()
  {
    c();
    a(null);
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start failed. filepath = null. POS:" + paramLong);
      return false;
    }
    if (jdField_a_of_type_Int == a())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start. is runing. POS:" + paramLong);
      return true;
    }
    this.jdField_c_of_type_JavaLangString = paramString;
    if (!b())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start failed. openFileStream failed. POS:" + paramLong);
      paramString = atgs.a(8);
      a(8, paramString, paramString);
      return false;
    }
    if (!a(paramLong))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start download failed. POS:" + paramLong);
      paramString = atgs.a(6);
      a(6, paramString, paramString);
      return false;
    }
    a(jdField_a_of_type_Int);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start to run download . POS:" + paramLong);
    return true;
  }
  
  public void b()
  {
    a(jdField_c_of_type_Int);
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (a()) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. decode. but had stoped");
    }
    int i;
    do
    {
      long l1;
      do
      {
        for (;;)
        {
          return;
          try
          {
            if ((paramHttpMsg2.getResponseCode() == 206) || (paramHttpMsg2.getResponseCode() == 200)) {
              if (!a(paramHttpMsg2.getRecvData()))
              {
                i = 3;
                paramHttpMsg1 = atgs.a(3);
                l1 = 0L;
                if (SystemUtil.isExistSDCard()) {
                  l1 = SystemUtil.getSDCardAvailableSize() * 1024L;
                }
                if (l1 < this.jdField_d_of_type_Long - a())
                {
                  QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] write file failed. sd card space is no enough:[" + this.jdField_d_of_type_Long + " " + a() + " " + l1 + "]");
                  i = 9;
                  paramHttpMsg1 = atgs.a(9);
                }
                a(i, paramHttpMsg1, paramHttpMsg1);
                return;
              }
            }
          }
          catch (Exception paramHttpMsg1)
          {
            paramHttpMsg1.printStackTrace();
            paramHttpMsg1 = atgs.a(12);
            a(12, paramHttpMsg1, paramHttpMsg1);
            return;
          }
        }
        l1 = a() + paramHttpMsg2.getRecvData().length;
        long l2 = paramHttpMsg2.getTotalLen();
        if (this.jdField_d_of_type_Long != l2) {
          this.jdField_d_of_type_Long = l2;
        }
        a(l1);
        this.jdField_b_of_type_Long += paramHttpMsg2.getRecvData().length;
        if (l1 < this.jdField_d_of_type_Long) {
          break;
        }
        if (!c())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].closeFileStream falied.path=" + this.jdField_c_of_type_JavaLangString);
          paramHttpMsg1 = atgs.a(4);
          a(4, paramHttpMsg1, paramHttpMsg1);
          return;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].decode >>>>>>>. SUCESSFUL!!!");
        paramHttpMsg1 = a();
      } while (paramHttpMsg1 == null);
      paramHttpMsg2 = new Bundle();
      paramHttpMsg2.putLong("EXT_TRANS_SIZE ", this.jdField_e_of_type_Long);
      paramHttpMsg2.putLong("EXT_TTRANS_SIZE ", this.jdField_b_of_type_Long);
      paramHttpMsg2.putInt("EXT_AUTOTRY_COUNT", this.jdField_e_of_type_Int);
      paramHttpMsg1.a(this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Long, paramHttpMsg2);
      return;
      i = (int)((float)l1 / (float)this.jdField_d_of_type_Long * 100.0F);
      paramHttpMsg1 = a();
    } while (paramHttpMsg1 == null);
    paramHttpMsg1.a(i, null);
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (a())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError..user puase");
      return;
    }
    if (paramHttpMsg2 == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError.. response=NULL:");
      c();
      paramHttpMsg1 = atgs.a(5);
      paramHttpMsg2 = atdm.a().a();
      if (paramHttpMsg2 != null)
      {
        aszt.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 5, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        aszt.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 5, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        bcev.a(paramHttpMsg2.getApplication().getApplicationContext(), paramHttpMsg2.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        paramHttpMsg2 = a();
        if (paramHttpMsg2 == null) {
          break;
        }
        paramHttpMsg2.a(5, paramHttpMsg1, null);
        return;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 111");
      }
    }
    Object localObject2 = paramHttpMsg2.getErrorString();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError.. errString:" + (String)localObject1);
    if (jdField_c_of_type_Int == a())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError.. slience pause. may app destroy!!");
      c();
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      c();
      paramHttpMsg1 = atgs.a(2);
      paramHttpMsg2 = atdm.a().a();
      if (paramHttpMsg2 != null)
      {
        aszt.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 2, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        aszt.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 2, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        bcev.a(paramHttpMsg2.getApplication().getApplicationContext(), paramHttpMsg2.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        paramHttpMsg2 = a();
        if (paramHttpMsg2 == null) {
          break;
        }
        paramHttpMsg2.a(2, paramHttpMsg1, null);
        return;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 11");
      }
    }
    long l = paramHttpMsg2.errCode;
    int i = paramHttpMsg2.getSerial();
    localObject1 = paramHttpMsg2.getErrorString();
    if ((a(paramHttpMsg1, paramHttpMsg2)) && (this.jdField_e_of_type_Int < 3))
    {
      this.jdField_e_of_type_Int += 1;
      if ((this.f < 3) && (paramHttpMsg2.errCode == 9056))
      {
        this.f += 1;
        this.jdField_e_of_type_Int -= 1;
        label655:
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError. auto retry to download. autoRetry=" + this.jdField_e_of_type_Int + " eofRetry=" + this.f);
        d();
        if (a(a())) {
          break label995;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. auto retry dowload failed.");
        localObject1 = atgs.a((int)13L);
        l = 13L;
      }
    }
    for (paramHttpMsg1 = (HttpMsg)localObject1;; paramHttpMsg1 = String.valueOf(i))
    {
      this.jdField_e_of_type_Int = 0;
      this.f = 0;
      c();
      localObject2 = atdm.a().a();
      if (localObject2 != null)
      {
        if (13L == l) {
          break label1179;
        }
        l = 11L;
        localObject1 = atgs.a((int)11L);
        paramHttpMsg1 = (HttpMsg)localObject1;
      }
      label1179:
      for (;;)
      {
        aszt.a((QQAppInterface)localObject2, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", l, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, (String)localObject1, null);
        aszt.a((QQAppInterface)localObject2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramHttpMsg2.errCode, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, paramHttpMsg2.getErrorString(), null);
        bcev.a(((QQAppInterface)localObject2).getApplication().getApplicationContext(), ((QQAppInterface)localObject2).getCurrentAccountUin(), "Stop_download_2-0_3-1");
        for (;;)
        {
          paramHttpMsg1 = a();
          if (paramHttpMsg1 == null) {
            break;
          }
          paramHttpMsg1.a(6, "downloader fialed", null);
          return;
          this.f = 0;
          break label655;
          label995:
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. auto retry dowload started.");
          paramHttpMsg1 = atdm.a().a();
          if (paramHttpMsg1 != null)
          {
            aszt.a(paramHttpMsg1, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramHttpMsg2.errCode, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, paramHttpMsg2.getErrorString(), null);
            return;
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 1");
          return;
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 2");
        }
      }
    }
  }
  
  public void handleRedirect(String paramString) {}
  
  public void onFlowEvent(HttpMsg paramHttpMsg)
  {
    int i;
    int j;
    int k;
    if (paramHttpMsg != null)
    {
      i = paramHttpMsg.fileType;
      j = paramHttpMsg.busiType;
      k = paramHttpMsg.netType;
      if (((i == -1) || (j == -1)) && (QLog.isColorLevel())) {
        QLog.e("flowstat", 2, "fileType:" + i + ",busiType:" + j);
      }
      if (!"POST".equals(paramHttpMsg.getRequestMethod())) {
        break label138;
      }
    }
    QQAppInterface localQQAppInterface;
    label138:
    for (boolean bool = true;; bool = false)
    {
      localQQAppInterface = atdm.a().a();
      if (localQQAppInterface != null) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. onFlowEvent failed.APP=null");
      return;
    }
    localQQAppInterface.sendAppDataIncerment(localQQAppInterface.getAccount(), bool, k, i, j, paramHttpMsg.flow);
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. HttpCommunicator statusChanged. status:" + paramInt);
    if ((5 == paramInt) && (a() < this.jdField_d_of_type_Long))
    {
      c();
      paramHttpMsg1 = atgs.a(14);
      QQAppInterface localQQAppInterface = atdm.a().a();
      if (localQQAppInterface == null) {
        break label226;
      }
      aszt.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 14, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, paramHttpMsg1, null);
      aszt.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 14, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, paramHttpMsg1, null);
      bcev.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
    }
    for (;;)
    {
      paramHttpMsg1 = a();
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(14, "downloader fialed", null);
      }
      return true;
      label226:
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 2");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     athh
 * JD-Core Version:    0.7.0.1
 */