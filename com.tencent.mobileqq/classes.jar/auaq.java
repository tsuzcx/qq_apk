import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class auaq
  implements bdvw
{
  final int jdField_a_of_type_Int = 3;
  long jdField_a_of_type_Long = 0L;
  private atdx jdField_a_of_type_Atdx;
  auar jdField_a_of_type_Auar = null;
  auat jdField_a_of_type_Auat = null;
  bdvs jdField_a_of_type_Bdvs = null;
  bdvu jdField_a_of_type_Bdvu = null;
  bktt jdField_a_of_type_Bktt = null;
  File jdField_a_of_type_JavaIoFile = null;
  InputStream jdField_a_of_type_JavaIoInputStream = null;
  final String jdField_a_of_type_JavaLangString = "FileHttpUploder<FileAssistant>";
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean;
  final int jdField_c_of_type_Int = 3;
  long jdField_c_of_type_Long = 0L;
  String jdField_c_of_type_JavaLangString = null;
  int jdField_d_of_type_Int = 0;
  String jdField_d_of_type_JavaLangString = null;
  final int jdField_e_of_type_Int = 5;
  private String jdField_e_of_type_JavaLangString;
  int f = 0;
  
  public auaq(QQAppInterface paramQQAppInterface, auar paramauar, String paramString1, int paramInt, String paramString2, long paramLong, auat paramauat, boolean paramBoolean, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_Bdvu = paramQQAppInterface.getNetEngine(0);
    this.jdField_a_of_type_Auat = paramauat;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_e_of_type_JavaLangString = paramString3;
    int i = paramInt;
    if (paramInt == 0)
    {
      if (this.jdField_b_of_type_Boolean) {
        i = 443;
      }
    }
    else
    {
      paramauat = paramString1 + ":" + i;
      paramString1 = new ArrayList(1);
      paramString1.add(paramauat);
      if ((!TextUtils.isEmpty(paramString4)) && (atcq.a().a(paramQQAppInterface, 5)))
      {
        QLog.i("FileHttpUploder<FileAssistant>", 1, "[IPv6-File] DiscFile uploader. is config enable IPv6. domain[" + paramString4 + "]");
        paramauat = new atcr(paramString4, i);
        paramauat = atcq.a().a(paramQQAppInterface, paramauat, 5);
        if ((paramauat == null) || (paramauat.a())) {
          break label465;
        }
        if (atcq.a())
        {
          QLog.d("FileHttpUploder<FileAssistant>", 1, "[IPv6-File] DiscFile uploader.debugIsDisableIPv4OnDoubleStack");
          paramString1.clear();
        }
        atcq.a(paramauat.a, paramString1, false, false);
        QLog.i("FileHttpUploder<FileAssistant>", 1, "[IPv6-File] DiscFile uploader. use IPv6. hostlist:" + paramString1.toString());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Atdx = new atdx(paramQQAppInterface, paramString1, "/ftn_handler");
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Atdx.a(true);
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Atdx.a();
      this.jdField_c_of_type_JavaLangString = paramString2;
      this.jdField_d_of_type_JavaLangString = String.valueOf(paramLong);
      this.jdField_a_of_type_Auar = paramauar;
      this.jdField_a_of_type_Bktt = new bktt();
      this.jdField_a_of_type_Bktt.a();
      this.jdField_a_of_type_JavaIoFile = new File(paramString2);
      this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaIoFile.length();
      this.jdField_a_of_type_Boolean = false;
      return;
      i = 80;
      break;
      label465:
      QLog.i("FileHttpUploder<FileAssistant>", 1, "[IPv6-File] DiscFile uploader. use IPv4");
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bdvu.b(this.jdField_a_of_type_Bdvs);
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_JavaIoInputStream = null;
      label30:
      if (QLog.isColorLevel()) {
        QLog.d("FileHttpUploder<FileAssistant>", 2, "=_= ^> Id[" + this.jdField_d_of_type_JavaLangString + "]stop");
      }
      return;
    }
    catch (Exception localException)
    {
      break label30;
    }
  }
  
  public void a(long paramLong)
  {
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = this;
    localbdvs.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localbdvs.jdField_a_of_type_Int = 1;
    localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localbdvs.jdField_e_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    Object localObject = "";
    if (this.jdField_b_of_type_JavaLangString != null) {
      localObject = this.jdField_b_of_type_JavaLangString.toLowerCase();
    }
    if ((this.jdField_b_of_type_Boolean) && (((String)localObject).startsWith("https")))
    {
      localbdvs.f = true;
      localbdvs.g = atdx.a(this.jdField_b_of_type_JavaLangString);
      localbdvs.jdField_b_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    }
    try
    {
      localObject = a(paramLong);
      if (localObject == null) {
        return;
      }
      localObject = this.jdField_a_of_type_Auat.a((byte[])localObject, paramLong, this.jdField_a_of_type_Auar);
      if (localObject != null)
      {
        localbdvs.jdField_a_of_type_ArrayOfByte = ((byte[])localObject);
        this.jdField_a_of_type_Auar.e = System.currentTimeMillis();
        this.jdField_a_of_type_Bdvs = localbdvs;
        localbdvs.jdField_a_of_type_Bdxx = atvo.a();
        this.jdField_a_of_type_Bdvu.a(localbdvs);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.i("FileHttpUploder<FileAssistant>", 1, "=_= ^> logID[" + this.jdField_d_of_type_JavaLangString + "] Exception:" + localException.toString());
      this.jdField_a_of_type_Auar.jdField_a_of_type_Long = 9360L;
      this.jdField_a_of_type_Auar.jdField_c_of_type_JavaLangString = atvo.a();
      this.jdField_a_of_type_Auat.a(this.jdField_a_of_type_Auar);
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
    //   8: putfield 51	auaq:jdField_b_of_type_Long	J
    //   11: aload_0
    //   12: getfield 49	auaq:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   15: ifnonnull +23 -> 38
    //   18: aload_0
    //   19: new 311	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: getfield 41	auaq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokespecial 312	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: putfield 49	auaq:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   33: aload_0
    //   34: lconst_0
    //   35: putfield 73	auaq:jdField_c_of_type_Long	J
    //   38: lload_1
    //   39: lconst_0
    //   40: lcmp
    //   41: ifne +113 -> 154
    //   44: aload_0
    //   45: getfield 73	auaq:jdField_c_of_type_Long	J
    //   48: lconst_0
    //   49: lcmp
    //   50: ifeq +23 -> 73
    //   53: aload_0
    //   54: new 311	java/io/FileInputStream
    //   57: dup
    //   58: aload_0
    //   59: getfield 41	auaq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   62: invokespecial 312	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   65: putfield 49	auaq:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   68: aload_0
    //   69: lconst_0
    //   70: putfield 73	auaq:jdField_c_of_type_Long	J
    //   73: aload_0
    //   74: lload_1
    //   75: putfield 73	auaq:jdField_c_of_type_Long	J
    //   78: aload_0
    //   79: getfield 43	auaq:jdField_a_of_type_Bktt	Lbktt;
    //   82: aload_0
    //   83: getfield 47	auaq:jdField_a_of_type_Long	J
    //   86: aload_0
    //   87: getfield 51	auaq:jdField_b_of_type_Long	J
    //   90: lload_1
    //   91: invokestatic 317	atjh:a	(Lbktt;JJJ)I
    //   94: istore_3
    //   95: iload_3
    //   96: newarray byte
    //   98: astore 4
    //   100: aload_0
    //   101: getfield 49	auaq:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   104: aload 4
    //   106: iconst_0
    //   107: iload_3
    //   108: invokevirtual 321	java/io/InputStream:read	([BII)I
    //   111: pop
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 73	auaq:jdField_c_of_type_Long	J
    //   117: iload_3
    //   118: i2l
    //   119: ladd
    //   120: putfield 73	auaq:jdField_c_of_type_Long	J
    //   123: aload 4
    //   125: areturn
    //   126: astore 4
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 49	auaq:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   133: aload 4
    //   135: invokevirtual 324	java/io/FileNotFoundException:printStackTrace	()V
    //   138: aconst_null
    //   139: areturn
    //   140: astore 4
    //   142: aload_0
    //   143: aconst_null
    //   144: putfield 49	auaq:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   147: aload 4
    //   149: invokevirtual 324	java/io/FileNotFoundException:printStackTrace	()V
    //   152: aconst_null
    //   153: areturn
    //   154: lload_1
    //   155: aload_0
    //   156: getfield 73	auaq:jdField_c_of_type_Long	J
    //   159: lcmp
    //   160: ifle +29 -> 189
    //   163: aload_0
    //   164: getfield 49	auaq:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   167: lload_1
    //   168: aload_0
    //   169: getfield 73	auaq:jdField_c_of_type_Long	J
    //   172: lsub
    //   173: invokevirtual 328	java/io/InputStream:skip	(J)J
    //   176: pop2
    //   177: goto -104 -> 73
    //   180: astore 4
    //   182: aload 4
    //   184: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   187: aconst_null
    //   188: areturn
    //   189: lload_1
    //   190: aload_0
    //   191: getfield 73	auaq:jdField_c_of_type_Long	J
    //   194: lcmp
    //   195: ifge -122 -> 73
    //   198: aload_0
    //   199: new 311	java/io/FileInputStream
    //   202: dup
    //   203: aload_0
    //   204: getfield 41	auaq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   207: invokespecial 312	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   210: putfield 49	auaq:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   213: aload_0
    //   214: lconst_0
    //   215: putfield 73	auaq:jdField_c_of_type_Long	J
    //   218: aload_0
    //   219: getfield 49	auaq:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   222: lload_1
    //   223: invokevirtual 328	java/io/InputStream:skip	(J)J
    //   226: pop2
    //   227: goto -154 -> 73
    //   230: astore 4
    //   232: aload_0
    //   233: aconst_null
    //   234: putfield 49	auaq:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   237: aload 4
    //   239: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   242: aconst_null
    //   243: areturn
    //   244: astore 4
    //   246: aconst_null
    //   247: astore 4
    //   249: goto -126 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	auaq
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
    QLog.i("FileHttpUploder<FileAssistant>", 1, "=_= ^> [Upload Step] Id[" + this.jdField_d_of_type_JavaLangString + "]Send Start url:" + this.jdField_b_of_type_JavaLangString);
    a(0L);
  }
  
  public void onResp(bdwt parambdwt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FileHttpUploder<FileAssistant>", 4, "logID[" + this.jdField_d_of_type_JavaLangString + "]onResp result:" + parambdwt.jdField_a_of_type_Int + " errCode:" + parambdwt.jdField_b_of_type_Int + " errDesc:" + parambdwt.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Bdvs = null;
      this.jdField_a_of_type_Auar.f = System.currentTimeMillis();
      i = parambdwt.jdField_c_of_type_Int;
      if ((parambdwt.jdField_b_of_type_Int == 9364) && (this.jdField_b_of_type_Int < 3))
      {
        QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "]onNetChanged:mNetworkChangRetryCount[" + this.jdField_b_of_type_Int + "] retry!");
        this.jdField_b_of_type_Int += 1;
        this.jdField_a_of_type_Bktt.a();
        if (this.jdField_a_of_type_Auat != null)
        {
          this.jdField_a_of_type_Auar.jdField_a_of_type_Long = 9364L;
          this.jdField_a_of_type_Auar.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
          this.jdField_a_of_type_Auar.f = System.currentTimeMillis();
          this.jdField_a_of_type_Auat.a(true, this.jdField_a_of_type_Auar);
        }
        a(this.jdField_b_of_type_Long);
        return;
      }
      if ((atjh.a(parambdwt.jdField_b_of_type_Int)) && (this.jdField_a_of_type_Atdx != null))
      {
        str = this.jdField_a_of_type_Atdx.a();
        if (str != null)
        {
          this.jdField_b_of_type_JavaLangString = str;
          a(this.jdField_b_of_type_Long);
          return;
        }
      }
      if ((i == 200) && (parambdwt.jdField_a_of_type_Int == 0)) {
        break;
      }
      this.jdField_a_of_type_Auar.jdField_a_of_type_Long = parambdwt.jdField_a_of_type_Int;
      this.jdField_a_of_type_Auar.jdField_c_of_type_JavaLangString = parambdwt.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Auar.j = ((String)parambdwt.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      this.jdField_a_of_type_Auar.g = ((String)parambdwt.jdField_a_of_type_JavaUtilHashMap.get("param_url"));
      if ((parambdwt.jdField_a_of_type_Int == 9056) && (this.f < 5))
      {
        this.jdField_a_of_type_Auar.a();
        this.f += 1;
        a(this.jdField_b_of_type_Long);
        return;
      }
      this.jdField_a_of_type_Auat.a(this.jdField_a_of_type_Auar);
    } while (!QLog.isColorLevel());
    QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "]httpRetCode:" + i + "]onResp result:" + parambdwt.jdField_a_of_type_Int + " errCode:" + parambdwt.jdField_b_of_type_Int + " errDesc:" + parambdwt.jdField_a_of_type_JavaLangString);
    return;
    this.f = 0;
    this.jdField_a_of_type_Bktt.b();
    String str = (String)parambdwt.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode");
    if (str != null) {}
    for (long l = Long.parseLong(str);; l = 0L)
    {
      if (l != 0L)
      {
        this.jdField_a_of_type_Auar.jdField_a_of_type_Long = -9527L;
        this.jdField_a_of_type_Auar.jdField_c_of_type_JavaLangString = ("ResponCode[206]But UserCode[" + String.valueOf(l) + "]");
        this.jdField_a_of_type_Auar.j = ((String)parambdwt.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
        this.jdField_a_of_type_Auat.a(this.jdField_a_of_type_Auar);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "ResponCode[206]But UserCode[" + l + "]");
        return;
      }
      l = this.jdField_a_of_type_Auat.a(parambdwt, this.jdField_a_of_type_Auar);
      if (l == -1L)
      {
        QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "server resp data read len -1");
        if (QLog.isDevelopLevel()) {
          throw new IllegalArgumentException();
        }
      }
      if (l == 0L)
      {
        QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "server resp data read len 0");
        return;
      }
      if (l == this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Auar.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Auar.f = (this.jdField_a_of_type_Auar.e + 1L);
        this.jdField_a_of_type_Auat.b(this.jdField_a_of_type_Auar);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "miaochuan");
        return;
      }
      if (l < this.jdField_b_of_type_Long)
      {
        parambdwt = "RangSizeError_rangError tSize[" + String.valueOf(l) + "]<=mSize[" + String.valueOf(this.jdField_b_of_type_Long) + "],reTryafter[" + String.valueOf(this.jdField_d_of_type_Int) + "]";
        QLog.w("FileHttpUploder<FileAssistant>", 1, "nSessionId[" + this.jdField_d_of_type_JavaLangString + "]" + parambdwt);
        this.jdField_d_of_type_Int += 1;
        this.jdField_a_of_type_Auar.jdField_a_of_type_Long = 9009L;
        this.jdField_a_of_type_Auar.jdField_c_of_type_JavaLangString = parambdwt;
        if (this.jdField_d_of_type_Int < 3)
        {
          QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "server rang error retry,mmaxRangErrorRetryCount [" + this.jdField_d_of_type_Int + "], maxRangErrorRetry[" + 3 + "]");
          this.jdField_a_of_type_Auar.a();
          a(l);
          return;
        }
        QLog.e("FileHttpUploder<FileAssistant>", 1, "logID[" + this.jdField_d_of_type_JavaLangString + "]server rang error not retry,mmaxRangErrorRetryCount [" + this.jdField_d_of_type_Int + "], maxRangErrorRetry[" + 3 + "]");
        this.jdField_a_of_type_Auat.a(this.jdField_a_of_type_Auar);
        return;
      }
      this.jdField_d_of_type_Int = 0;
      this.jdField_b_of_type_Long = l;
      this.jdField_a_of_type_Auat.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_Long);
      a(l);
      return;
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("FileHttpUploder<FileAssistant>", 1, "nID[" + this.jdField_d_of_type_JavaLangString + "]onUpdateProgeress[" + paramLong1 + "]/[" + paramLong2 + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auaq
 * JD-Core Version:    0.7.0.1
 */