import android.os.Handler;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileUploader.1;
import com.tencent.mobileqq.filemanager.core.FileUploader.2;
import com.tencent.mobileqq.filemanager.core.FileUploader.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import mqq.os.MqqHandler;

public class atdm
  implements atdy, atec
{
  private int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private atdo jdField_a_of_type_Atdo;
  private atdp jdField_a_of_type_Atdp = new atdn(this);
  private final atdx jdField_a_of_type_Atdx;
  private ated jdField_a_of_type_Ated;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private long f;
  private long g;
  
  private atdm(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new VFSFile(paramString1).length();
    this.jdField_a_of_type_Atdx = new atdx(paramQQAppInterface, paramString2);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Atdx.a();
    this.jdField_a_of_type_Ated = ateq.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Ated != null) {
      this.jdField_a_of_type_Ated.a(this);
    }
  }
  
  private atdm(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new VFSFile(paramString1).length();
    this.jdField_a_of_type_Atdx = new atdx(paramQQAppInterface, paramString4);
    this.jdField_a_of_type_Atdx.a(paramBoolean);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Atdx.a();
    this.jdField_a_of_type_Ated = atdu.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2, paramString2, paramString3, this.jdField_b_of_type_Long, paramBoolean, paramString5);
    if (this.jdField_a_of_type_Ated != null) {
      this.jdField_a_of_type_Ated.a(this);
    }
  }
  
  private atdm(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, boolean paramBoolean, String paramString5)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new VFSFile(paramString1).length();
    this.jdField_a_of_type_Atdx = new atdx(paramQQAppInterface, paramList, paramString4);
    this.jdField_a_of_type_Atdx.a(paramBoolean);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Atdx.a();
    this.jdField_a_of_type_Ated = atdu.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2, paramString2, paramString3, this.jdField_b_of_type_Long, paramBoolean, paramString5);
    if (this.jdField_a_of_type_Ated != null) {
      this.jdField_a_of_type_Ated.a(this);
    }
  }
  
  private atdm(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, List<String> paramList, String paramString2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new VFSFile(paramString1).length();
    this.jdField_a_of_type_Atdx = new atdx(paramQQAppInterface, paramList, paramString2);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Atdx.a();
    this.jdField_a_of_type_Ated = ateq.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Ated != null) {
      this.jdField_a_of_type_Ated.a(this);
    }
  }
  
  public static atdm a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          if (paramString1.length() != 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
        return null;
        if (paramString2 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is null");
      return null;
      if (paramString2.length() != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is empty");
    return null;
    return new atdm(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public static atdm a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strCheckSum is null");
      }
      return null;
    }
    if (paramString3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strSHA is null");
      }
      return null;
    }
    if (paramString4 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is null");
      }
      return null;
    }
    if (paramString4.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is empty");
      }
      return null;
    }
    return new atdm(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramString5);
  }
  
  public static atdm a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, boolean paramBoolean, String paramString5)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strCheckSum is null");
      }
      return null;
    }
    if (paramString3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strSHA is null");
      }
      return null;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is null");
      }
      return null;
    }
    if (paramList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is empty");
      }
      return null;
    }
    if (paramString4 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is null");
      }
      return null;
    }
    if (paramString4.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is empty");
      }
      return null;
    }
    return new atdm(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramList, paramString4, paramBoolean, paramString5);
  }
  
  public static atdm a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, List<String> paramList, String paramString2)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
      }
      return null;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is null");
      }
      return null;
    }
    if (paramList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is null");
      }
      return null;
    }
    if (paramString2.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is empty");
      }
      return null;
    }
    return new atdm(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramList, paramString2);
  }
  
  private void a(int paramInt)
  {
    String str = null;
    if (this.jdField_a_of_type_Atdx != null) {
      str = this.jdField_a_of_type_Atdx.a();
    }
    if ((str == null) || (str.length() == 0))
    {
      QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] need chang Ip ,but can not get next ip errCode[" + paramInt + "]");
      return;
    }
    this.jdField_b_of_type_JavaLangString = str;
    this.jdField_c_of_type_Int += 1;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Atdo.a(this.jdField_b_of_type_JavaLangString);
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
    //   7: invokespecial 207	atdm:b	()Z
    //   10: ifne +32 -> 42
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield 209	atdm:g	J
    //   19: lstore 4
    //   21: lload_1
    //   22: lload 4
    //   24: lcmp
    //   25: ifle +82 -> 107
    //   28: aload_0
    //   29: getfield 159	atdm:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   32: lload_1
    //   33: aload_0
    //   34: getfield 209	atdm:g	J
    //   37: lsub
    //   38: invokevirtual 215	java/io/InputStream:skip	(J)J
    //   41: pop2
    //   42: aload_0
    //   43: lload_1
    //   44: putfield 209	atdm:g	J
    //   47: aload_0
    //   48: getfield 36	atdm:jdField_a_of_type_Atdp	Latdp;
    //   51: aload_0
    //   52: getfield 96	atdm:f	J
    //   55: aload_0
    //   56: getfield 51	atdm:jdField_b_of_type_Long	J
    //   59: invokeinterface 220 5 0
    //   64: istore_3
    //   65: iload_3
    //   66: newarray byte
    //   68: astore 7
    //   70: aload_0
    //   71: getfield 159	atdm:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   74: aload 7
    //   76: iconst_0
    //   77: iload_3
    //   78: invokevirtual 224	java/io/InputStream:read	([BII)I
    //   81: pop
    //   82: aload_0
    //   83: getfield 209	atdm:g	J
    //   86: lstore_1
    //   87: aload_0
    //   88: iload_3
    //   89: i2l
    //   90: lload_1
    //   91: ladd
    //   92: putfield 209	atdm:g	J
    //   95: aload 7
    //   97: areturn
    //   98: astore 7
    //   100: aload 7
    //   102: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   105: aconst_null
    //   106: areturn
    //   107: lload_1
    //   108: aload_0
    //   109: getfield 209	atdm:g	J
    //   112: lcmp
    //   113: ifge -71 -> 42
    //   116: aload_0
    //   117: invokespecial 207	atdm:b	()Z
    //   120: istore 6
    //   122: iload 6
    //   124: ifeq +71 -> 195
    //   127: aload_0
    //   128: getfield 159	atdm:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   131: lload_1
    //   132: invokevirtual 215	java/io/InputStream:skip	(J)J
    //   135: pop2
    //   136: goto -94 -> 42
    //   139: astore 7
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 159	atdm:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   146: aload 7
    //   148: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   151: aconst_null
    //   152: areturn
    //   153: astore 7
    //   155: aload 7
    //   157: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   160: ldc 106
    //   162: iconst_1
    //   163: new 162	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   170: ldc 230
    //   172: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload 7
    //   177: invokevirtual 231	java/lang/Exception:toString	()Ljava/lang/String;
    //   180: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aconst_null
    //   190: astore 7
    //   192: goto -97 -> 95
    //   195: aconst_null
    //   196: areturn
    //   197: astore 7
    //   199: aconst_null
    //   200: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	atdm
    //   0	201	1	paramLong	long
    //   64	25	3	i	int
    //   19	4	4	l	long
    //   120	3	6	bool	boolean
    //   68	28	7	arrayOfByte	byte[]
    //   98	3	7	localIOException1	IOException
    //   139	8	7	localIOException2	IOException
    //   153	23	7	localException1	Exception
    //   190	1	7	localObject	Object
    //   197	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   28	42	98	java/io/IOException
    //   127	136	139	java/io/IOException
    //   70	95	153	java/lang/Exception
    //   6	13	197	java/lang/Exception
    //   15	21	197	java/lang/Exception
    //   28	42	197	java/lang/Exception
    //   42	70	197	java/lang/Exception
    //   100	105	197	java/lang/Exception
    //   107	122	197	java/lang/Exception
    //   127	136	197	java/lang/Exception
    //   141	151	197	java/lang/Exception
    //   155	189	197	java/lang/Exception
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Atdp = new atdn(this);
    ThreadManager.getFileThreadHandler().postDelayed(new FileUploader.3(this), paramInt);
  }
  
  private void b(long paramLong, String paramString)
  {
    String str = "RangSizeError_rangError tSize[" + paramLong + "]<=mSize[" + this.f + "], lastRoolbackSize[" + this.jdField_e_of_type_Long + "], retry[" + this.jdField_e_of_type_Int + "]";
    if (paramLong <= this.jdField_e_of_type_Long)
    {
      int i = this.jdField_e_of_type_Int + 1;
      this.jdField_e_of_type_Int = i;
      if (i > 6)
      {
        this.jdField_a_of_type_Atdo.a(true, paramLong, str, paramString);
        return;
      }
    }
    this.jdField_e_of_type_Long = paramLong;
    this.f = paramLong;
    new Handler().postDelayed(new FileUploader.2(this), 6000L);
    this.jdField_a_of_type_Atdo.a(false, paramLong, str, paramString);
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
  
  private boolean b(long paramLong)
  {
    byte[] arrayOfByte = a(paramLong);
    if (arrayOfByte == null)
    {
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "getSendStreamSlice return null");
      ThreadManager.post(new FileUploader.1(this), 5, null, true);
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    return this.jdField_a_of_type_Ated.a(this.jdField_b_of_type_JavaLangString, paramLong, arrayOfByte);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
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
      label12:
      this.jdField_a_of_type_Ated.a();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      break label12;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Atdo.a(true, this.f, 9343, "parseDataErr", null);
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
        this.jdField_a_of_type_Atdo.a(true, this.f, -29602, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-6101") > 0)
      {
        this.jdField_a_of_type_Atdo.a(true, this.f, 9042, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-29120") > 0)
      {
        this.jdField_a_of_type_Atdo.h();
        return;
      }
    }
    if ((paramString1 != null) && (paramString1.contains("SSLPeerUnverifiedException")))
    {
      this.jdField_a_of_type_Atdo.a(true, this.f, paramInt, paramString1, paramString2);
      return;
    }
    if (!bgnt.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_Atdo.a(true, this.f, paramInt, paramString1, paramString2);
      return;
    }
    if (atjh.a(paramInt)) {
      a(paramInt);
    }
    if (this.jdField_a_of_type_Int < 8)
    {
      this.jdField_d_of_type_Int += 1;
      if ((this.jdField_b_of_type_Int < 3) && (9056 == paramInt))
      {
        this.jdField_b_of_type_Int += 1;
        if (paramInt != 9056) {
          break label280;
        }
      }
    }
    label280:
    for (int i = 0;; i = 6000)
    {
      this.jdField_a_of_type_Atdo.a(false, this.f, paramInt, paramString1, paramString2);
      b(i);
      return;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Int += 1;
      break;
      this.jdField_a_of_type_Atdo.a(true, this.f, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Atdp.a();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if (paramLong != this.jdField_d_of_type_Long) {
        break label59;
      }
    }
    label59:
    for (this.jdField_c_of_type_Long = 0L; paramLong <= this.f; this.jdField_c_of_type_Long = paramLong)
    {
      b(paramLong, paramString);
      return;
    }
    if ((this.f == 0L) && (paramLong == this.jdField_b_of_type_Long))
    {
      this.jdField_c_of_type_Long = this.jdField_b_of_type_Long;
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Atdo.f();
      return;
    }
    this.f = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("FtnHttpUploader<FileAssistant>", 2, "send http data size[" + String.valueOf(this.f) + "] fileSize[" + this.jdField_b_of_type_Long + "] success!");
    }
    if (paramLong < this.jdField_b_of_type_Long)
    {
      this.jdField_a_of_type_Atdo.a(paramLong);
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Int = 0;
      b(this.f);
      return;
    }
    this.jdField_a_of_type_Atdo.g();
  }
  
  public void a(atdo paramatdo)
  {
    this.jdField_a_of_type_Atdo = paramatdo;
  }
  
  public void a(bgux parambgux) {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Atdo.a(true, this.f, 9062, "UrlOver", null);
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    QLog.i("FtnHttpUploader<FileAssistant>", 1, "interSendFile url:" + this.jdField_b_of_type_JavaLangString + " pos:" + paramLong);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    boolean bool = b(paramLong);
    if ((bool) && (this.g > paramLong))
    {
      this.jdField_d_of_type_Long = (this.g - paramLong);
      return bool;
    }
    this.jdField_d_of_type_Long = 0L;
    return bool;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Long = this.jdField_b_of_type_Long;
      this.jdField_c_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Atdo.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdm
 * JD-Core Version:    0.7.0.1
 */