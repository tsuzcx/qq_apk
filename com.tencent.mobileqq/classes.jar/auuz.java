import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import mqq.app.MobileQQ;

public class auuz
  implements bhvc
{
  public static int a;
  public static String a;
  public static int b;
  public static int c;
  long jdField_a_of_type_Long = 0L;
  private auuy jdField_a_of_type_Auuy;
  private bhva jdField_a_of_type_Bhva;
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
  
  public auuz(long paramLong1, QQAppInterface paramQQAppInterface, String paramString1, long paramLong2, String paramString2, auuy paramauuy)
  {
    this.jdField_c_of_type_Long = paramLong1;
    this.jdField_b_of_type_JavaLangString = new atvr(paramQQAppInterface, paramString1).a();
    this.jdField_a_of_type_Auuy = paramauuy;
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
  
  private auuy a()
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      auuy localauuy = this.jdField_a_of_type_Auuy;
      return localauuy;
    }
  }
  
  private bhva a()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      bhva localbhva = this.jdField_a_of_type_Bhva;
      return localbhva;
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
    QQAppInterface localQQAppInterface = aure.a().a();
    if (localQQAppInterface != null)
    {
      aunj.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", this.jdField_e_of_type_Int, paramString2, null);
      aunj.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", this.jdField_e_of_type_Int, paramString2, null);
      bdmb.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
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
  
  private void a(auuy paramauuy)
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Auuy = paramauuy;
      return;
    }
  }
  
  private void a(bhva parambhva)
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Bhva = parambhva;
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
    //   6: invokespecial 174	auuz:a	(J)V
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
    //   36: getfield 64	auuz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   39: ifnull +237 -> 276
    //   42: aload_0
    //   43: getfield 64	auuz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   46: ldc 180
    //   48: invokevirtual 186	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   51: ifne +225 -> 276
    //   54: new 81	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   61: aload_0
    //   62: getfield 64	auuz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   65: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 188
    //   70: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: lload_1
    //   74: invokestatic 192	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   77: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore 4
    //   85: new 194	bhva
    //   88: dup
    //   89: aload 4
    //   91: aconst_null
    //   92: aload_0
    //   93: iconst_1
    //   94: invokespecial 197	bhva:<init>	(Ljava/lang/String;[BLbhvc;Z)V
    //   97: astore 6
    //   99: ldc 199
    //   101: astore 4
    //   103: invokestatic 205	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   106: invokestatic 210	bhnv:b	(Landroid/content/Context;)I
    //   109: iconst_1
    //   110: if_icmpne +7 -> 117
    //   113: ldc 212
    //   115: astore 4
    //   117: aload 6
    //   119: ldc 214
    //   121: aload 4
    //   123: invokevirtual 217	bhva:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 6
    //   128: ldc 219
    //   130: aload 5
    //   132: invokevirtual 217	bhva:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 6
    //   137: iconst_1
    //   138: invokevirtual 221	bhva:b	(I)V
    //   141: aload_0
    //   142: getfield 70	auuz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   145: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: ifne +14 -> 162
    //   151: aload 6
    //   153: ldc 228
    //   155: aload_0
    //   156: getfield 70	auuz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   159: invokevirtual 217	bhva:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload 6
    //   164: iconst_1
    //   165: invokevirtual 231	bhva:a	(Z)V
    //   168: aload 6
    //   170: iconst_5
    //   171: putfield 232	bhva:jdField_b_of_type_Int	I
    //   174: aload 6
    //   176: iconst_0
    //   177: putfield 233	bhva:jdField_c_of_type_Int	I
    //   180: aload 6
    //   182: invokestatic 238	java/lang/System:currentTimeMillis	()J
    //   185: invokestatic 192	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   188: putfield 239	bhva:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   191: aload 6
    //   193: ldc 241
    //   195: ldc 243
    //   197: invokevirtual 217	bhva:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload_0
    //   201: aload 6
    //   203: invokespecial 245	auuz:a	(Lbhva;)V
    //   206: invokestatic 115	aure:a	()Laure;
    //   209: invokevirtual 118	aure:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   212: astore 4
    //   214: aload 4
    //   216: ifnonnull +94 -> 310
    //   219: getstatic 25	auuz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   222: iconst_1
    //   223: new 81	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   230: ldc 84
    //   232: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_0
    //   236: getfield 54	auuz:jdField_c_of_type_Long	J
    //   239: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   242: ldc 247
    //   244: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: lload_1
    //   248: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   251: ldc 249
    //   253: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: lload_1
    //   257: aload_0
    //   258: getfield 68	auuz:jdField_d_of_type_Long	J
    //   261: ldiv
    //   262: l2i
    //   263: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload_0
    //   273: monitorexit
    //   274: iload_3
    //   275: ireturn
    //   276: new 81	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   283: aload_0
    //   284: getfield 64	auuz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   287: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc 251
    //   292: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: lload_1
    //   296: invokestatic 192	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   299: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: astore 4
    //   307: goto -222 -> 85
    //   310: aload 4
    //   312: invokevirtual 255	com/tencent/mobileqq/app/QQAppInterface:getHttpCommunicatort	()Lbhuw;
    //   315: aload 6
    //   317: invokevirtual 260	bhuw:a	(Lbhva;)I
    //   320: pop
    //   321: getstatic 25	auuz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   324: iconst_1
    //   325: new 81	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   332: ldc 84
    //   334: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_0
    //   338: getfield 54	auuz:jdField_c_of_type_Long	J
    //   341: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   344: ldc_w 262
    //   347: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: lload_1
    //   351: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   354: ldc 249
    //   356: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: lload_1
    //   360: aload_0
    //   361: getfield 68	auuz:jdField_d_of_type_Long	J
    //   364: ldiv
    //   365: l2i
    //   366: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: iconst_1
    //   376: istore_3
    //   377: goto -105 -> 272
    //   380: astore 4
    //   382: aload_0
    //   383: monitorexit
    //   384: aload 4
    //   386: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	auuz
    //   0	387	1	paramLong	long
    //   1	376	3	bool	boolean
    //   83	228	4	localObject1	Object
    //   380	5	4	localObject2	Object
    //   33	98	5	str	String
    //   97	219	6	localbhva	bhva
    // Exception table:
    //   from	to	target	type
    //   4	85	380	finally
    //   85	99	380	finally
    //   103	113	380	finally
    //   117	162	380	finally
    //   162	214	380	finally
    //   219	272	380	finally
    //   276	307	380	finally
    //   310	375	380	finally
  }
  
  private boolean a(bhva parambhva1, bhva parambhva2)
  {
    if (parambhva1 == null) {
      return false;
    }
    if (parambhva2 == null) {
      return true;
    }
    return parambhva2.c();
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
    bhva localbhva = a();
    if (localbhva != null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest");
      a(null);
      QQAppInterface localQQAppInterface = aure.a().a();
      if (localQQAppInterface == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest failed.APP=null");
        return;
      }
      localQQAppInterface.getHttpCommunicatort().b(localbhva);
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. stopHttpRequest: no request");
  }
  
  public void a()
  {
    c();
    a(null);
  }
  
  public void a(bhva parambhva1, bhva parambhva2)
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
            if ((parambhva2.c() == 206) || (parambhva2.c() == 200)) {
              if (!a(parambhva2.a()))
              {
                i = 3;
                parambhva1 = auuk.a(3);
                l1 = 0L;
                if (bhjr.a()) {
                  l1 = bhjr.a() * 1024L;
                }
                if (l1 < this.jdField_d_of_type_Long - a())
                {
                  QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] write file failed. sd card space is no enough:[" + this.jdField_d_of_type_Long + " " + a() + " " + l1 + "]");
                  i = 9;
                  parambhva1 = auuk.a(9);
                }
                a(i, parambhva1, parambhva1);
                return;
              }
            }
          }
          catch (Exception parambhva1)
          {
            parambhva1.printStackTrace();
            parambhva1 = auuk.a(12);
            a(12, parambhva1, parambhva1);
            return;
          }
        }
        l1 = a() + parambhva2.a().length;
        long l2 = parambhva2.a();
        if (this.jdField_d_of_type_Long != l2) {
          this.jdField_d_of_type_Long = l2;
        }
        a(l1);
        this.jdField_b_of_type_Long += parambhva2.a().length;
        if (l1 < this.jdField_d_of_type_Long) {
          break;
        }
        if (!c())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].closeFileStream falied.path=" + this.jdField_c_of_type_JavaLangString);
          parambhva1 = auuk.a(4);
          a(4, parambhva1, parambhva1);
          return;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].decode >>>>>>>. SUCESSFUL!!!");
        parambhva1 = a();
      } while (parambhva1 == null);
      parambhva2 = new Bundle();
      parambhva2.putLong("EXT_TRANS_SIZE ", this.jdField_e_of_type_Long);
      parambhva2.putLong("EXT_TTRANS_SIZE ", this.jdField_b_of_type_Long);
      parambhva2.putInt("EXT_AUTOTRY_COUNT", this.jdField_e_of_type_Int);
      parambhva1.a(this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Long, parambhva2);
      return;
      i = (int)((float)l1 / (float)this.jdField_d_of_type_Long * 100.0F);
      parambhva1 = a();
    } while (parambhva1 == null);
    parambhva1.a(i, null);
  }
  
  public void a(String paramString) {}
  
  public boolean a(bhva parambhva1, bhva parambhva2, int paramInt)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. HttpCommunicator statusChanged. status:" + paramInt);
    if ((5 == paramInt) && (a() < this.jdField_d_of_type_Long))
    {
      c();
      parambhva1 = auuk.a(14);
      QQAppInterface localQQAppInterface = aure.a().a();
      if (localQQAppInterface == null) {
        break label226;
      }
      aunj.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 14, parambhva1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, parambhva2.b(), parambhva2.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int, parambhva1, null);
      aunj.a(localQQAppInterface, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 14, parambhva1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, parambhva2.b(), parambhva2.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int, parambhva1, null);
      bdmb.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
    }
    for (;;)
    {
      parambhva1 = a();
      if (parambhva1 != null) {
        parambhva1.a(14, "downloader fialed", null);
      }
      return true;
      label226:
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 2");
    }
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
      paramString = auuk.a(8);
      a(8, paramString, paramString);
      return false;
    }
    if (!a(paramLong))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. start download failed. POS:" + paramLong);
      paramString = auuk.a(6);
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
  
  public void b(bhva parambhva1, bhva parambhva2)
  {
    if (a())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError..user puase");
      return;
    }
    if (parambhva2 == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. handleError.. response=NULL:");
      c();
      parambhva1 = auuk.a(5);
      parambhva2 = aure.a().a();
      if (parambhva2 != null)
      {
        aunj.a(parambhva2, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 5, parambhva1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, parambhva1, null);
        aunj.a(parambhva2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 5, parambhva1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, parambhva1, null);
        bdmb.a(parambhva2.getApplication().getApplicationContext(), parambhva2.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        parambhva2 = a();
        if (parambhva2 == null) {
          break;
        }
        parambhva2.a(5, parambhva1, null);
        return;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 111");
      }
    }
    Object localObject2 = parambhva2.d();
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
    if (!bhnv.d(BaseApplication.getContext()))
    {
      c();
      parambhva1 = auuk.a(2);
      parambhva2 = aure.a().a();
      if (parambhva2 != null)
      {
        aunj.a(parambhva2, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", 2, parambhva1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, parambhva1, null);
        aunj.a(parambhva2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", 2, parambhva1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, parambhva1, null);
        bdmb.a(parambhva2.getApplication().getApplicationContext(), parambhva2.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        parambhva2 = a();
        if (parambhva2 == null) {
          break;
        }
        parambhva2.a(2, parambhva1, null);
        return;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 11");
      }
    }
    long l = parambhva2.f;
    int i = parambhva2.a();
    localObject1 = parambhva2.d();
    if ((a(parambhva1, parambhva2)) && (this.jdField_e_of_type_Int < 3))
    {
      this.jdField_e_of_type_Int += 1;
      if ((this.f < 3) && (parambhva2.f == 9056))
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
        localObject1 = auuk.a((int)13L);
        l = 13L;
      }
    }
    for (parambhva1 = (bhva)localObject1;; parambhva1 = String.valueOf(i))
    {
      this.jdField_e_of_type_Int = 0;
      this.f = 0;
      c();
      localObject2 = aure.a().a();
      if (localObject2 != null)
      {
        if (13L == l) {
          break label1179;
        }
        l = 11L;
        localObject1 = auuk.a((int)11L);
        parambhva1 = (bhva)localObject1;
      }
      label1179:
      for (;;)
      {
        aunj.a((QQAppInterface)localObject2, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", l, parambhva1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, parambhva2.b(), parambhva2.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int, (String)localObject1, null);
        aunj.a((QQAppInterface)localObject2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", parambhva2.f, String.valueOf(parambhva2.a()), this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, parambhva2.b(), parambhva2.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int, parambhva2.d(), null);
        bdmb.a(((QQAppInterface)localObject2).getApplication().getApplicationContext(), ((QQAppInterface)localObject2).getCurrentAccountUin(), "Stop_download_2-0_3-1");
        for (;;)
        {
          parambhva1 = a();
          if (parambhva1 == null) {
            break;
          }
          parambhva1.a(6, "downloader fialed", null);
          return;
          this.f = 0;
          break label655;
          label995:
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. auto retry dowload started.");
          parambhva1 = aure.a().a();
          if (parambhva1 != null)
          {
            aunj.a(parambhva1, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", parambhva2.f, String.valueOf(parambhva2.a()), this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, parambhva2.b(), parambhva2.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_Int, parambhva2.d(), null);
            return;
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 1");
          return;
          QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "].report failed - 2");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auuz
 * JD-Core Version:    0.7.0.1
 */