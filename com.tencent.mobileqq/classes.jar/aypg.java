import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

public class aypg
  extends aypb
{
  bgbd jdField_a_of_type_Bgbd = new bgbd();
  public RandomAccessFile a;
  ArrayList<ayuq> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public byte[] a;
  public Transaction b;
  protected byte[] b;
  public String c;
  protected boolean c;
  protected byte[] c;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean = false;
  protected String f;
  boolean f = false;
  protected String l;
  String m;
  int p;
  int q;
  public long q;
  protected int r = 0;
  protected long r;
  protected int s;
  public long s;
  protected int t;
  long t;
  public int u = -1;
  public long u;
  public int v = -1;
  protected int w = 0;
  
  public aypg(ayoz paramayoz, aywc paramaywc)
  {
    super(paramayoz, paramaywc);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_s_of_type_Long = 0L;
    this.jdField_s_of_type_Int = 0;
    this.jdField_t_of_type_Int = 0;
    this.jdField_t_of_type_Long = 20480L;
    c(paramaywc.jdField_c_of_type_JavaLangString + paramaywc.jdField_a_of_type_Long);
    this.jdField_c_of_type_Boolean = paramaywc.jdField_e_of_type_Boolean;
  }
  
  public int a()
  {
    return super.a();
  }
  
  protected long a(long paramLong)
  {
    long l1 = this.q;
    return Math.min(this.jdField_t_of_type_Long, l1 - paramLong);
  }
  
  protected ayrx a(byte[] paramArrayOfByte)
  {
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_Aysc = this;
    localayrx.jdField_a_of_type_JavaLangString = a(paramArrayOfByte);
    localayrx.jdField_a_of_type_Int = 1;
    localayrx.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localayrx.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localayrx.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
    localayrx.g = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
    localayrx.f = this.jdField_a_of_type_Aywc.jdField_b_of_type_Int;
    localayrx.jdField_k_of_type_Boolean = true;
    localayrx.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + this.jdField_s_of_type_Long + "-");
    localayrx.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    return localayrx;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, paramInt, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, paramInt, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, paramInt, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, paramInt, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  protected void a(String paramString1, boolean paramBoolean, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("md5", paramString4);
    localHashMap.put("uuid", paramString5);
    if (paramString6 != null) {
      localHashMap.put("business_type", paramString6);
    }
    a(paramBoolean, paramString2, paramString3, String.valueOf(paramInt), paramString1, localHashMap);
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile.seek(paramInt1);
      byte[] arrayOfByte = new byte[paramInt2];
      int i = 0;
      paramInt1 = paramInt2;
      while (i < paramInt2)
      {
        int j = this.jdField_a_of_type_JavaIoRandomAccessFile.read(arrayOfByte, i, paramInt1);
        if (j == -1)
        {
          b(9303, "fileSize not enough");
          this.jdField_b_of_type_Aypd.b();
          return null;
        }
        i += j;
        paramInt1 -= j;
      }
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      localIOException.printStackTrace();
    }
    return null;
  }
  
  protected void aP_()
  {
    this.jdField_b_of_type_Aypd.a();
    long l1 = this.jdField_s_of_type_Long;
    long l2 = a(l1);
    Object localObject = a((int)l1, (int)l2);
    if (localObject == null) {
      d();
    }
    do
    {
      return;
      b("sendingdata", "pos:" + l1 + "  transferData len:" + localObject.length);
      localObject = a((byte[])localObject);
      if (l1 + l2 >= this.q) {
        ((ayrx)localObject).jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
    } while (!f());
    this.jdField_a_of_type_Aysy = ((aysy)localObject);
    n();
    this.jdField_a_of_type_Aysa.a((aysy)localObject);
  }
  
  public int b()
  {
    return super.b();
  }
  
  public void c()
  {
    super.c();
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        b("pause", "");
      }
      d(1004);
      if (this.jdField_a_of_type_Ayyp != null)
      {
        ayzv.b(this.jdField_a_of_type_Ayyp);
        this.jdField_a_of_type_Ayyp = null;
      }
      if (this.jdField_a_of_type_Aysy != null)
      {
        this.jdField_a_of_type_Aysa.b(this.jdField_a_of_type_Aysy);
        this.jdField_a_of_type_Aysy = null;
      }
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, paramString);
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    if (this.jdField_a_of_type_JavaIoRandomAccessFile != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile = null;
    }
  }
  
  protected boolean i()
  {
    return (this.jdField_c_of_type_ArrayOfByte != null) && (this.jdField_c_of_type_ArrayOfByte.length > 0) && (this.jdField_b_of_type_ArrayOfByte != null) && (this.jdField_b_of_type_ArrayOfByte.length > 0);
  }
  
  /* Error */
  public boolean j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 131	aypg:jdField_a_of_type_Aywc	Laywc;
    //   4: getfield 319	aywc:i	Ljava/lang/String;
    //   7: astore 4
    //   9: new 321	java/io/FileInputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 323	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: aload_0
    //   22: aload_3
    //   23: aload_0
    //   24: getfield 326	aypg:jdField_a_of_type_Ayqo	Layqo;
    //   27: getfield 329	ayqo:jdField_a_of_type_Long	J
    //   30: invokestatic 335	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   33: putfield 336	aypg:jdField_a_of_type_ArrayOfByte	[B
    //   36: aload_3
    //   37: astore_2
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 336	aypg:jdField_a_of_type_ArrayOfByte	[B
    //   43: invokestatic 341	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   46: putfield 343	aypg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   49: aload_3
    //   50: astore_2
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 343	aypg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   56: putfield 344	aypg:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 326	aypg:jdField_a_of_type_Ayqo	Layqo;
    //   65: aload_0
    //   66: getfield 343	aypg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   69: putfield 346	ayqo:f	Ljava/lang/String;
    //   72: aload_3
    //   73: astore_2
    //   74: aload_0
    //   75: new 74	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   82: aload_0
    //   83: getfield 343	aypg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   86: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 348
    //   92: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: getfield 349	aypg:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   99: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: putfield 343	aypg:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   108: aload_3
    //   109: ifnull +7 -> 116
    //   112: aload_3
    //   113: invokevirtual 350	java/io/FileInputStream:close	()V
    //   116: iconst_1
    //   117: istore_1
    //   118: iload_1
    //   119: ireturn
    //   120: astore_2
    //   121: aload_3
    //   122: astore_2
    //   123: new 352	java/io/File
    //   126: dup
    //   127: aload 4
    //   129: invokespecial 353	java/io/File:<init>	(Ljava/lang/String;)V
    //   132: astore 4
    //   134: aload_3
    //   135: astore_2
    //   136: aload 4
    //   138: invokevirtual 356	java/io/File:exists	()Z
    //   141: istore_1
    //   142: iload_1
    //   143: ifeq -107 -> 36
    //   146: aload_3
    //   147: astore_2
    //   148: aload 4
    //   150: invokestatic 361	bfko:a	(Ljava/io/File;)Ljava/lang/String;
    //   153: astore 4
    //   155: aload 4
    //   157: ifnull +17 -> 174
    //   160: aload_3
    //   161: astore_2
    //   162: aload_0
    //   163: aload 4
    //   165: invokestatic 365	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   168: putfield 336	aypg:jdField_a_of_type_ArrayOfByte	[B
    //   171: goto -135 -> 36
    //   174: ldc_w 284
    //   177: astore 4
    //   179: goto -19 -> 160
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   187: goto -71 -> 116
    //   190: astore 4
    //   192: aconst_null
    //   193: astore_3
    //   194: aload_3
    //   195: astore_2
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 336	aypg:jdField_a_of_type_ArrayOfByte	[B
    //   201: aload_3
    //   202: astore_2
    //   203: aload_0
    //   204: aload 4
    //   206: invokevirtual 223	aypg:a	(Ljava/io/IOException;)V
    //   209: iconst_0
    //   210: istore_1
    //   211: aload_3
    //   212: ifnull -94 -> 118
    //   215: aload_3
    //   216: invokevirtual 350	java/io/FileInputStream:close	()V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_2
    //   222: aload_2
    //   223: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   226: iconst_0
    //   227: ireturn
    //   228: astore_3
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 350	java/io/FileInputStream:close	()V
    //   239: aload_3
    //   240: athrow
    //   241: astore_2
    //   242: aload_2
    //   243: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   246: goto -7 -> 239
    //   249: astore_3
    //   250: goto -19 -> 231
    //   253: astore 4
    //   255: goto -61 -> 194
    //   258: astore_2
    //   259: goto -223 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	aypg
    //   117	94	1	bool	boolean
    //   20	54	2	localFileInputStream1	java.io.FileInputStream
    //   120	1	2	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   122	40	2	localFileInputStream2	java.io.FileInputStream
    //   182	2	2	localIOException1	IOException
    //   195	8	2	localFileInputStream3	java.io.FileInputStream
    //   221	2	2	localIOException2	IOException
    //   230	6	2	localObject1	Object
    //   241	2	2	localIOException3	IOException
    //   258	1	2	localIOException4	IOException
    //   18	198	3	localFileInputStream4	java.io.FileInputStream
    //   228	12	3	localObject2	Object
    //   249	1	3	localObject3	Object
    //   7	171	4	localObject4	Object
    //   190	15	4	localIOException5	IOException
    //   253	1	4	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   21	36	120	java/lang/UnsatisfiedLinkError
    //   112	116	182	java/io/IOException
    //   9	19	190	java/io/IOException
    //   215	219	221	java/io/IOException
    //   9	19	228	finally
    //   235	239	241	java/io/IOException
    //   21	36	249	finally
    //   38	49	249	finally
    //   51	59	249	finally
    //   61	72	249	finally
    //   74	108	249	finally
    //   123	134	249	finally
    //   136	142	249	finally
    //   148	155	249	finally
    //   162	171	249	finally
    //   196	201	249	finally
    //   203	209	249	finally
    //   21	36	253	java/io/IOException
    //   38	49	253	java/io/IOException
    //   51	59	253	java/io/IOException
    //   61	72	253	java/io/IOException
    //   74	108	253	java/io/IOException
    //   123	134	253	java/io/IOException
    //   136	142	253	java/io/IOException
    //   148	155	258	java/io/IOException
    //   162	171	258	java/io/IOException
  }
  
  protected boolean k()
  {
    HwNetworkCenter.getInstance(BaseApplication.getContext()).updateNetInfo(BaseApplication.getContext());
    return HwNetworkCenter.getInstance(BaseApplication.getContext()).getNetType() != 0L;
  }
  
  protected void o()
  {
    try
    {
      int i;
      if (SessionInfo.getInstance(this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString).getHttpconn_sig_session() != null)
      {
        i = SessionInfo.getInstance(this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString).getHttpconn_sig_session().length;
        this.jdField_c_of_type_ArrayOfByte = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString).getHttpconn_sig_session(), 0, this.jdField_c_of_type_ArrayOfByte, 0, i);
      }
      if (SessionInfo.getInstance(this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString).getSessionKey() != null)
      {
        i = SessionInfo.getInstance(this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString).getSessionKey().length;
        this.jdField_b_of_type_ArrayOfByte = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString).getSessionKey(), 0, this.jdField_b_of_type_ArrayOfByte, 0, i);
      }
      return;
    }
    finally {}
  }
  
  protected void p()
  {
    int i = 1;
    if ((this.w == 2) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("param_BdhTrans"))) {
      if ((this.n > 0L) && (this.jdField_o_of_type_Long > 0L))
      {
        if ((this.p) && (i != 0))
        {
          this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
          this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.jdField_o_of_type_Int).append("_").append("tr").append(this.n).append("_").append("ht").append(this.m).append("_").append("pic").append(this.jdField_o_of_type_Long).append(";");
          this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.jdField_o_of_type_Long));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_CostEach", this.jdField_a_of_type_JavaLangStringBuilder.toString());
          this.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(this.jdField_o_of_type_Int));
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sn:").append(this.jdField_o_of_type_Int).append(";").append("tc_s:").append(this.n).append(";").append("tc_h:").append(this.m).append(";").append("tc_p:").append(this.jdField_o_of_type_Long).append(";");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", localStringBuilder.toString());
      }
    }
    while ((this.w != 1) || (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction == null)) {
      for (;;)
      {
        StringBuilder localStringBuilder;
        return;
        i = 0;
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.mTransReport.timeCost_Cache));
  }
  
  public void q()
  {
    this.jdField_k_of_type_Long = System.nanoTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aypg
 * JD-Core Version:    0.7.0.1
 */