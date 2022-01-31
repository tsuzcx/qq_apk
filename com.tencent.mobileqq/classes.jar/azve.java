import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploader.1;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploader.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import mqq.os.MqqHandler;

public class azve
  implements apao, azsn, azum
{
  protected int a;
  protected final long a;
  public apaj a;
  protected final azsm a;
  protected azun a;
  protected azvf a;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  protected final String a;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  protected final long b;
  protected String b;
  private boolean b;
  protected int c;
  protected long c;
  protected String c;
  private boolean c;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long e;
  private long f;
  private long g;
  
  protected azve(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_Azvf = new azvf(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new VFSFile(paramString1).length();
    this.jdField_a_of_type_Azsm = new azsm(paramQQAppInterface, paramString4, this.jdField_a_of_type_Long, this);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Azsm.a();
    paramString1 = azsp.a(this.jdField_b_of_type_JavaLangString);
    if (paramString1 != null)
    {
      this.jdField_c_of_type_JavaLangString = paramString1.jdField_a_of_type_JavaLangString;
      this.jdField_b_of_type_Int = paramString1.jdField_a_of_type_Int;
      this.jdField_c_of_type_Int = paramString1.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_Apaj = apaj.a(paramQQAppInterface, this.jdField_a_of_type_Long, 1, 0, paramString2, paramString3, this.jdField_b_of_type_Long, false, null);
    if (this.jdField_a_of_type_Apaj != null) {
      this.jdField_a_of_type_Apaj.a(this);
    }
  }
  
  protected azve(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, boolean paramBoolean, String paramString5)
  {
    this.jdField_a_of_type_Azvf = new azvf(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new VFSFile(paramString1).length();
    this.jdField_a_of_type_Azsm = new azsm(paramQQAppInterface, paramList, paramString4, this.jdField_a_of_type_Long, paramBoolean, this);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Azsm.a();
    paramString1 = azsp.a(this.jdField_b_of_type_JavaLangString);
    if (paramString1 != null)
    {
      this.jdField_c_of_type_JavaLangString = paramString1.jdField_a_of_type_JavaLangString;
      this.jdField_b_of_type_Int = paramString1.jdField_a_of_type_Int;
      this.jdField_c_of_type_Int = paramString1.jdField_b_of_type_Int;
    }
    this.jdField_a_of_type_Apaj = apaj.a(paramQQAppInterface, this.jdField_a_of_type_Long, 1, 0, paramString2, paramString3, this.jdField_b_of_type_Long, paramBoolean, paramString5);
    if (this.jdField_a_of_type_Apaj != null) {
      this.jdField_a_of_type_Apaj.a(this);
    }
  }
  
  public static azum a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = "";
    if (paramString1 == null) {
      str = "strFilePath is null";
    }
    while (!TextUtils.isEmpty(str))
    {
      azsr.a("TroopFileUploader", azsr.jdField_a_of_type_Int, "getFileUploader " + str);
      return null;
      if (paramString1.length() == 0) {
        str = "strFilePath is empty";
      } else if (paramString2 == null) {
        str = "strCheckSum is null";
      } else if (paramString3 == null) {
        str = "strSHA is null";
      } else if (paramString4 == null) {
        str = "lstUrl is null";
      } else if (paramString4.length() == 0) {
        str = "lstUrl is empty";
      }
    }
    return new azve(paramQQAppInterface, paramLong, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static azum a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, boolean paramBoolean, String paramString5)
  {
    String str = "";
    if (paramString1 == null) {
      str = "strFilePath is null";
    }
    while (!TextUtils.isEmpty(str))
    {
      azsr.a("TroopFileUploader", azsr.jdField_a_of_type_Int, "getFileUploader " + str);
      return null;
      if (paramString1.length() == 0) {
        str = "strFilePath is empty";
      } else if (paramString2 == null) {
        str = "strCheckSum is null";
      } else if (paramString3 == null) {
        str = "strSHA is null";
      } else if (paramList == null) {
        str = "lstUrl is null";
      } else if (paramList.size() == 0) {
        str = "lstUrl is empty";
      } else if (paramString4 == null) {
        str = "urlParams is null";
      } else if (paramString4.length() == 0) {
        str = "urlParams is empty";
      }
    }
    return new azve(paramQQAppInterface, paramLong, paramString1, paramString2, paramString3, paramList, paramString4, paramBoolean, paramString5);
  }
  
  private boolean a(long paramLong)
  {
    byte[] arrayOfByte = a(paramLong);
    if (arrayOfByte == null)
    {
      azsr.a("TroopFileUploader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] sendFile. getSendStreamSlice return null");
      ThreadManager.post(new TroopFileUploader.1(this), 5, null, true);
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    return this.jdField_a_of_type_Apaj.a(this.jdField_b_of_type_JavaLangString, paramLong, arrayOfByte);
  }
  
  /* Error */
  private byte[] a(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifne +12 -> 15
    //   6: aload_0
    //   7: invokespecial 202	azve:b	()Z
    //   10: ifne +32 -> 42
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield 204	azve:e	J
    //   19: lstore 4
    //   21: lload_1
    //   22: lload 4
    //   24: lcmp
    //   25: ifle +80 -> 105
    //   28: aload_0
    //   29: getfield 166	azve:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   32: lload_1
    //   33: aload_0
    //   34: getfield 204	azve:e	J
    //   37: lsub
    //   38: invokevirtual 210	java/io/InputStream:skip	(J)J
    //   41: pop2
    //   42: aload_0
    //   43: lload_1
    //   44: putfield 204	azve:e	J
    //   47: aload_0
    //   48: getfield 38	azve:jdField_a_of_type_Azvf	Lazvf;
    //   51: aload_0
    //   52: getfield 102	azve:jdField_d_of_type_Long	J
    //   55: aload_0
    //   56: getfield 53	azve:jdField_b_of_type_Long	J
    //   59: invokevirtual 213	azvf:a	(JJ)I
    //   62: istore_3
    //   63: iload_3
    //   64: newarray byte
    //   66: astore 7
    //   68: aload_0
    //   69: getfield 166	azve:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   72: aload 7
    //   74: iconst_0
    //   75: iload_3
    //   76: invokevirtual 217	java/io/InputStream:read	([BII)I
    //   79: pop
    //   80: aload_0
    //   81: getfield 204	azve:e	J
    //   84: lstore_1
    //   85: aload_0
    //   86: iload_3
    //   87: i2l
    //   88: lload_1
    //   89: ladd
    //   90: putfield 204	azve:e	J
    //   93: aload 7
    //   95: areturn
    //   96: astore 7
    //   98: aload 7
    //   100: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   103: aconst_null
    //   104: areturn
    //   105: lload_1
    //   106: aload_0
    //   107: getfield 204	azve:e	J
    //   110: lcmp
    //   111: ifge -69 -> 42
    //   114: aload_0
    //   115: invokespecial 202	azve:b	()Z
    //   118: istore 6
    //   120: iload 6
    //   122: ifeq +71 -> 193
    //   125: aload_0
    //   126: getfield 166	azve:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   129: lload_1
    //   130: invokevirtual 210	java/io/InputStream:skip	(J)J
    //   133: pop2
    //   134: goto -92 -> 42
    //   137: astore 7
    //   139: aload_0
    //   140: aconst_null
    //   141: putfield 166	azve:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   144: aload 7
    //   146: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   149: aconst_null
    //   150: areturn
    //   151: astore 7
    //   153: aload 7
    //   155: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   158: ldc 115
    //   160: iconst_1
    //   161: new 120	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   168: ldc 223
    //   170: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload 7
    //   175: invokevirtual 224	java/lang/Exception:toString	()Ljava/lang/String;
    //   178: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 228	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aconst_null
    //   188: astore 7
    //   190: goto -97 -> 93
    //   193: aconst_null
    //   194: areturn
    //   195: astore 7
    //   197: aconst_null
    //   198: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	azve
    //   0	199	1	paramLong	long
    //   62	25	3	i	int
    //   19	4	4	l	long
    //   118	3	6	bool	boolean
    //   66	28	7	arrayOfByte	byte[]
    //   96	3	7	localIOException1	IOException
    //   137	8	7	localIOException2	IOException
    //   151	23	7	localException1	Exception
    //   188	1	7	localObject	Object
    //   195	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   28	42	96	java/io/IOException
    //   125	134	137	java/io/IOException
    //   68	93	151	java/lang/Exception
    //   6	13	195	java/lang/Exception
    //   15	21	195	java/lang/Exception
    //   28	42	195	java/lang/Exception
    //   42	68	195	java/lang/Exception
    //   98	103	195	java/lang/Exception
    //   105	120	195	java/lang/Exception
    //   125	134	195	java/lang/Exception
    //   139	149	195	java/lang/Exception
    //   153	187	195	java/lang/Exception
  }
  
  private void b(long paramLong, String paramString)
  {
    String str = "RangSizeError_rangError tSize[" + paramLong + "]<=mSize[" + this.jdField_d_of_type_Long + "], lastRoolbackSize[" + this.jdField_c_of_type_Long + "], retry[" + this.jdField_a_of_type_Int + "]";
    azsr.c("TroopFileUploader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] processRollback" + str);
    if (paramLong <= this.jdField_c_of_type_Long)
    {
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      if (i > 6)
      {
        this.jdField_a_of_type_Azun.a(true, paramLong, str, paramString);
        return;
      }
    }
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_d_of_type_Long = paramLong;
    ThreadManager.getSubThreadHandler().postDelayed(new TroopFileUploader.2(this), 6000L);
    this.jdField_a_of_type_Azun.a(false, paramLong, str, paramString);
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_JavaIoInputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_JavaIoInputStream = null;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_a_of_type_JavaLangString);
          return true;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          this.jdField_a_of_type_JavaIoInputStream = null;
          localFileNotFoundException.printStackTrace();
        }
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
    }
    return false;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    azsr.c("TroopFileUploader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] reSend mstrUrl:" + this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Azvf = new azvf(this);
    if (this.jdField_a_of_type_Azun != null) {
      this.jdField_a_of_type_Azun.i();
    }
    this.jdField_d_of_type_Long = 0L;
    a(0L);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Azsm.a();
  }
  
  public long a()
  {
    return this.f;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_JavaIoInputStream = null;
      this.jdField_a_of_type_Apaj.a();
      this.jdField_a_of_type_Boolean = true;
      azsr.c("TroopFileUploader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] cancelTask");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(true, this.jdField_d_of_type_Long, 9343, "parseDataErr", null);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (-9527 == paramInt)
    {
      if (paramString1.indexOf("-29602") > 0)
      {
        a(true, this.jdField_d_of_type_Long, -29602, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-6101") > 0)
      {
        a(true, this.jdField_d_of_type_Long, 9042, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-29120") > 0)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Azun.h();
        return;
      }
    }
    if ((paramString1 != null) && (paramString1.contains("SSLPeerUnverifiedException")))
    {
      this.jdField_a_of_type_Azun.a(true, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2);
      return;
    }
    if (!bbev.d(BaseApplication.getContext()))
    {
      a(true, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2);
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    azsr.a("TroopFileUploader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] onErr errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    if (this.jdField_a_of_type_Azsm.a(this.jdField_b_of_type_JavaLangString, paramInt, false))
    {
      a(false, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2);
      return;
    }
    a(true, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Azvf.a();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if (paramLong != this.g) {
        break label57;
      }
    }
    label57:
    for (this.f = 0L; paramLong <= this.jdField_d_of_type_Long; this.f = paramLong)
    {
      b(paramLong, paramString);
      return;
    }
    if ((this.jdField_d_of_type_Long == 0L) && (paramLong == this.jdField_b_of_type_Long))
    {
      this.jdField_a_of_type_Boolean = true;
      this.f = this.jdField_b_of_type_Long;
      this.jdField_d_of_type_Long = this.jdField_b_of_type_Long;
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Azun.f();
      return;
    }
    this.jdField_d_of_type_Long = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileUploader", 2, "send http data size[" + String.valueOf(this.jdField_d_of_type_Long) + "] fileSize[" + this.jdField_b_of_type_Long + "] success!");
    }
    if (paramLong < this.jdField_b_of_type_Long)
    {
      this.jdField_a_of_type_Azun.a(paramLong);
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_Azsm.a(this.jdField_b_of_type_JavaLangString);
      }
      a(this.jdField_d_of_type_Long);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Azun.g();
  }
  
  public void a(azun paramazun)
  {
    this.jdField_a_of_type_Azun = paramazun;
  }
  
  public void a(bbmg parambbmg)
  {
    parambbmg.a("User-Agent", "TroopFile");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(true, this.jdField_d_of_type_Long, 9062, "UrlOver", null);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Azun.a(paramBoolean, paramLong, paramInt, paramString1, paramString2);
  }
  
  public boolean a()
  {
    azsr.c("TroopFileUploader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] upload url:" + this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    boolean bool = a(0L);
    if ((bool) && (this.e > 0L))
    {
      this.g = this.e;
      return bool;
    }
    this.g = 0L;
    return bool;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long b()
  {
    return 6000L;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean)
    {
      this.f = this.jdField_b_of_type_Long;
      this.jdField_c_of_type_Boolean = true;
    }
    this.jdField_d_of_type_Long = this.jdField_b_of_type_Long;
    this.jdField_a_of_type_Azun.f();
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      azsr.c("TroopFileUploader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] onRetry but stoped");
      return;
    }
    int i = 0;
    if (!this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramString))
    {
      i = 1;
      azsr.c("TroopFileUploader", azsr.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] onRetry urlChanged");
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    if (i != 0)
    {
      paramString = azsp.a(this.jdField_b_of_type_JavaLangString);
      if (paramString != null)
      {
        this.jdField_c_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
        this.jdField_b_of_type_Int = paramString.jdField_a_of_type_Int;
        this.jdField_c_of_type_Int = paramString.jdField_b_of_type_Int;
      }
      this.jdField_a_of_type_Azun.a(this.jdField_b_of_type_JavaLangString);
    }
    c();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Azsm.a();
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int g()
  {
    return this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azve
 * JD-Core Version:    0.7.0.1
 */