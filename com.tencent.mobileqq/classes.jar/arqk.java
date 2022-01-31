import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class arqk
  implements baug
{
  final int jdField_a_of_type_Int = 3;
  long jdField_a_of_type_Long = 0L;
  private aqxx jdField_a_of_type_Aqxx;
  arqj jdField_a_of_type_Arqj = null;
  baub jdField_a_of_type_Baub = null;
  baue jdField_a_of_type_Baue = null;
  bigh jdField_a_of_type_Bigh = null;
  VFSFile jdField_a_of_type_ComTencentMmVfsVFSFile = null;
  InputStream jdField_a_of_type_JavaIoInputStream = null;
  final String jdField_a_of_type_JavaLangString = "OfflineFileHttpUploder<FileAssistant>";
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = null;
  final int jdField_c_of_type_Int = 3;
  long jdField_c_of_type_Long = 0L;
  String jdField_c_of_type_JavaLangString = null;
  int jdField_d_of_type_Int = 0;
  String jdField_d_of_type_JavaLangString = null;
  final int e = 5;
  int f = 0;
  
  public arqk(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, arqj paramarqj)
  {
    this.jdField_a_of_type_Baue = paramQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_Arqj = paramarqj;
    paramarqj = new ArrayList(1);
    paramarqj.add(paramString1);
    this.jdField_a_of_type_Aqxx = new aqxx(paramQQAppInterface, paramarqj, "/ftn_handler");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aqxx.a();
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
    this.jdField_a_of_type_Bigh = new bigh();
    this.jdField_a_of_type_Bigh.a();
    this.jdField_a_of_type_ComTencentMmVfsVFSFile = new VFSFile(paramString2);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMmVfsVFSFile.length();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Baue.b(this.jdField_a_of_type_Baub);
    if (QLog.isColorLevel()) {
      QLog.d("OfflineFileHttpUploder<FileAssistant>", 2, "Id[" + this.jdField_d_of_type_JavaLangString + "]stop");
    }
  }
  
  public void a(long paramLong)
  {
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = this;
    localbaub.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbaub.jdField_a_of_type_Int = 1;
    localbaub.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localbaub.e = this.jdField_d_of_type_JavaLangString;
    try
    {
      byte[] arrayOfByte = a(paramLong);
      arrayOfByte = this.jdField_a_of_type_Arqj.a(arrayOfByte, paramLong);
      if (arrayOfByte == null) {
        return;
      }
      localbaub.jdField_a_of_type_ArrayOfByte = arrayOfByte;
      this.jdField_a_of_type_Baub = localbaub;
      localbaub.jdField_a_of_type_Bawq = arrr.a();
      this.jdField_a_of_type_Baue.a(localbaub);
      if (QLog.isColorLevel())
      {
        QLog.i("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "]Send Http Request!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "] Exception:" + localException.toString());
      this.jdField_a_of_type_Arqj.b();
    }
  }
  
  /* Error */
  byte[] a(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifne +8 -> 11
    //   6: aload_0
    //   7: lconst_0
    //   8: putfield 50	arqk:jdField_b_of_type_Long	J
    //   11: aload_0
    //   12: getfield 48	arqk:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   15: ifnonnull +23 -> 38
    //   18: aload_0
    //   19: new 213	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: getfield 40	arqk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokespecial 214	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: putfield 48	arqk:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   33: aload_0
    //   34: lconst_0
    //   35: putfield 70	arqk:jdField_c_of_type_Long	J
    //   38: lload_1
    //   39: lconst_0
    //   40: lcmp
    //   41: ifne +113 -> 154
    //   44: aload_0
    //   45: getfield 70	arqk:jdField_c_of_type_Long	J
    //   48: lconst_0
    //   49: lcmp
    //   50: ifeq +23 -> 73
    //   53: aload_0
    //   54: new 213	java/io/FileInputStream
    //   57: dup
    //   58: aload_0
    //   59: getfield 40	arqk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   62: invokespecial 214	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   65: putfield 48	arqk:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   68: aload_0
    //   69: lconst_0
    //   70: putfield 70	arqk:jdField_c_of_type_Long	J
    //   73: aload_0
    //   74: lload_1
    //   75: putfield 70	arqk:jdField_c_of_type_Long	J
    //   78: aload_0
    //   79: getfield 42	arqk:jdField_a_of_type_Bigh	Lbigh;
    //   82: aload_0
    //   83: getfield 46	arqk:jdField_a_of_type_Long	J
    //   86: aload_0
    //   87: getfield 50	arqk:jdField_b_of_type_Long	J
    //   90: lload_1
    //   91: invokestatic 219	arql:a	(Lbigh;JJJ)I
    //   94: istore_3
    //   95: iload_3
    //   96: newarray byte
    //   98: astore 4
    //   100: aload_0
    //   101: getfield 48	arqk:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   104: aload 4
    //   106: iconst_0
    //   107: iload_3
    //   108: invokevirtual 225	java/io/InputStream:read	([BII)I
    //   111: pop
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 70	arqk:jdField_c_of_type_Long	J
    //   117: iload_3
    //   118: i2l
    //   119: ladd
    //   120: putfield 70	arqk:jdField_c_of_type_Long	J
    //   123: aload 4
    //   125: areturn
    //   126: astore 4
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 48	arqk:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   133: aload 4
    //   135: invokevirtual 228	java/io/FileNotFoundException:printStackTrace	()V
    //   138: aconst_null
    //   139: areturn
    //   140: astore 4
    //   142: aload_0
    //   143: aconst_null
    //   144: putfield 48	arqk:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   147: aload 4
    //   149: invokevirtual 228	java/io/FileNotFoundException:printStackTrace	()V
    //   152: aconst_null
    //   153: areturn
    //   154: lload_1
    //   155: aload_0
    //   156: getfield 70	arqk:jdField_c_of_type_Long	J
    //   159: lcmp
    //   160: ifle +29 -> 189
    //   163: aload_0
    //   164: getfield 48	arqk:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   167: lload_1
    //   168: aload_0
    //   169: getfield 70	arqk:jdField_c_of_type_Long	J
    //   172: lsub
    //   173: invokevirtual 232	java/io/InputStream:skip	(J)J
    //   176: pop2
    //   177: goto -104 -> 73
    //   180: astore 4
    //   182: aload 4
    //   184: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   187: aconst_null
    //   188: areturn
    //   189: lload_1
    //   190: aload_0
    //   191: getfield 70	arqk:jdField_c_of_type_Long	J
    //   194: lcmp
    //   195: ifge -122 -> 73
    //   198: aload_0
    //   199: new 213	java/io/FileInputStream
    //   202: dup
    //   203: aload_0
    //   204: getfield 40	arqk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   207: invokespecial 214	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   210: putfield 48	arqk:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   213: aload_0
    //   214: lconst_0
    //   215: putfield 70	arqk:jdField_c_of_type_Long	J
    //   218: aload_0
    //   219: getfield 48	arqk:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   222: lload_1
    //   223: invokevirtual 232	java/io/InputStream:skip	(J)J
    //   226: pop2
    //   227: goto -154 -> 73
    //   230: astore 4
    //   232: aload_0
    //   233: aconst_null
    //   234: putfield 48	arqk:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   237: aload 4
    //   239: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   242: aconst_null
    //   243: areturn
    //   244: astore 4
    //   246: aconst_null
    //   247: astore 4
    //   249: goto -126 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	arqk
    //   0	252	1	paramLong	long
    //   94	24	3	i	int
    //   98	26	4	arrayOfByte	byte[]
    //   126	8	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   140	8	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   180	3	4	localIOException1	java.io.IOException
    //   230	8	4	localIOException2	java.io.IOException
    //   244	1	4	localException	Exception
    //   247	1	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	38	126	java/io/FileNotFoundException
    //   53	73	140	java/io/FileNotFoundException
    //   163	177	180	java/io/IOException
    //   198	227	230	java/io/IOException
    //   100	123	244	java/lang/Exception
  }
  
  public void b()
  {
    this.jdField_b_of_type_Long = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("OfflineFileHttpUploder<FileAssistant>", 2, "Id[" + this.jdField_d_of_type_JavaLangString + "]Run");
    }
    a(0L);
  }
  
  public void onResp(bavf parambavf)
  {
    if (this.jdField_a_of_type_Boolean) {}
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("OfflineFileHttpUploder<FileAssistant>", 4, "logID[" + this.jdField_d_of_type_JavaLangString + "]onResp result:" + parambavf.jdField_a_of_type_Int + " errCode:" + parambavf.jdField_b_of_type_Int + " errDesc:" + parambavf.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Baub = null;
      i = parambavf.jdField_c_of_type_Int;
      if ((parambavf.jdField_b_of_type_Int == 9364) && (this.jdField_b_of_type_Int < 3))
      {
        QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "]onNetChanged:mNetworkChangRetryCount[" + this.jdField_b_of_type_Int + "] retry!");
        this.jdField_b_of_type_Int += 1;
        this.jdField_a_of_type_Bigh.a();
        if (this.jdField_a_of_type_Arqj != null) {
          this.jdField_a_of_type_Arqj.a(true);
        }
        a(this.jdField_b_of_type_Long);
        return;
      }
      if ((area.a(parambavf.jdField_b_of_type_Int)) && (this.jdField_a_of_type_Aqxx != null))
      {
        str = this.jdField_a_of_type_Aqxx.a();
        if (str != null)
        {
          this.jdField_b_of_type_JavaLangString = str;
          a(this.jdField_b_of_type_Long);
          return;
        }
      }
      if ((i == 200) && (parambavf.jdField_a_of_type_Int == 0)) {
        break;
      }
      if ((parambavf.jdField_a_of_type_Int == 9056) && (this.f < 5))
      {
        this.f += 1;
        a(this.jdField_b_of_type_Long);
        return;
      }
      this.jdField_a_of_type_Arqj.b();
    } while (!QLog.isColorLevel());
    QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "]httpRetCode:" + i + "]onResp result:" + parambavf.jdField_a_of_type_Int + " errCode:" + parambavf.jdField_b_of_type_Int + " errDesc:" + parambavf.jdField_a_of_type_JavaLangString);
    return;
    this.f = 0;
    this.jdField_a_of_type_Bigh.b();
    String str = (String)parambavf.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode");
    if (str != null) {}
    for (long l = Long.parseLong(str);; l = 0L)
    {
      if (l != 0L)
      {
        this.jdField_a_of_type_Arqj.b();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "ResponCode[206]But UserCode[" + l + "]");
        return;
      }
      l = this.jdField_a_of_type_Arqj.a(parambavf);
      if (l == -1L)
      {
        QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "server resp data read len -1");
        if (QLog.isDevelopLevel()) {
          throw new IllegalArgumentException();
        }
      }
      if (l == 0L)
      {
        QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "server resp data read len 0");
        return;
      }
      if (l == this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Arqj.a();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "miaochuan");
        return;
      }
      if (l < this.jdField_b_of_type_Long)
      {
        parambavf = "RangSizeError_rangError tSize[" + String.valueOf(l) + "]<=mSize[" + String.valueOf(this.jdField_b_of_type_Long) + "],reTryafter[" + String.valueOf(this.jdField_d_of_type_Int) + "]";
        QLog.w("OfflineFileHttpUploder<FileAssistant>", 1, "nSessionId[" + this.jdField_d_of_type_JavaLangString + "]" + parambavf);
        this.jdField_d_of_type_Int += 1;
        if (this.jdField_d_of_type_Int < 3)
        {
          QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "server rang error retry,mmaxRangErrorRetryCount [" + this.jdField_d_of_type_Int + "], maxRangErrorRetry[" + 3 + "]");
          a(l);
          return;
        }
        QLog.e("OfflineFileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "]server rang error not retry,mmaxRangErrorRetryCount [" + this.jdField_d_of_type_Int + "], maxRangErrorRetry[" + 3 + "]");
        this.jdField_a_of_type_Arqj.b();
        return;
      }
      this.jdField_d_of_type_Int = 0;
      this.jdField_b_of_type_Long = l;
      this.jdField_a_of_type_Arqj.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_Long);
      a(l);
      return;
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("OfflineFileHttpUploder<FileAssistant>", 1, "nID[" + this.jdField_d_of_type_JavaLangString + "]onUpdateProgeress[" + paramLong1 + "]/[" + paramLong2 + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqk
 * JD-Core Version:    0.7.0.1
 */