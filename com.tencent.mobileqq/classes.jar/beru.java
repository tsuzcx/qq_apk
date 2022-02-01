import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

public class beru
  extends berp
{
  bluw jdField_a_of_type_Bluw = new bluw();
  ArrayList<bewy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public Transaction b;
  RandomAccessFile jdField_b_of_type_JavaIoRandomAccessFile;
  byte[] jdField_b_of_type_ArrayOfByte;
  String c;
  protected boolean c;
  protected byte[] c;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  protected byte[] d;
  String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean = false;
  String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean;
  String l;
  String m;
  int jdField_q_of_type_Int;
  long jdField_q_of_type_Long;
  int jdField_r_of_type_Int = 0;
  long jdField_r_of_type_Long;
  int jdField_s_of_type_Int = 0;
  long jdField_s_of_type_Long = 0L;
  int jdField_t_of_type_Int = 0;
  long jdField_t_of_type_Long = 20480L;
  public int u = -1;
  public long u;
  public int v = -1;
  protected int w = 0;
  
  public beru(bern parambern, beyg parambeyg)
  {
    super(parambern, parambeyg);
    this.jdField_c_of_type_Boolean = true;
    this.f = false;
    c(parambeyg.jdField_c_of_type_JavaLangString + parambeyg.jdField_a_of_type_Long);
    this.jdField_c_of_type_Boolean = parambeyg.f;
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
  
  protected beum a(byte[] paramArrayOfByte)
  {
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = this;
    localbeum.jdField_a_of_type_JavaLangString = a(paramArrayOfByte);
    localbeum.jdField_a_of_type_Int = 1;
    localbeum.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localbeum.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localbeum.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    localbeum.f = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbeum.jdField_e_of_type_Int = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
    localbeum.l = true;
    localbeum.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + this.jdField_s_of_type_Long + "-");
    localbeum.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    return localbeum;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, paramInt, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, paramInt, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, paramInt, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, paramInt, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  protected void a(String paramString1, boolean paramBoolean, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.jdField_a_of_type_Bfci.j = paramString4;
    this.jdField_a_of_type_Bfci.k = paramString5;
    this.jdField_a_of_type_Bfci.l = paramString6;
    this.jdField_a_of_type_Bfci.jdField_c_of_type_JavaLangString = String.valueOf(paramInt);
    this.jdField_a_of_type_Bfci.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Bfci.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Bfci.jdField_b_of_type_Long = this.q;
    a(paramString1, paramBoolean);
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    try
    {
      this.jdField_b_of_type_JavaIoRandomAccessFile.seek(paramInt1);
      byte[] arrayOfByte = new byte[paramInt2];
      int i = 0;
      paramInt1 = paramInt2;
      while (i < paramInt2)
      {
        int j = this.jdField_b_of_type_JavaIoRandomAccessFile.read(arrayOfByte, i, paramInt1);
        if (j == -1)
        {
          b(9303, "fileSize not enough");
          this.jdField_b_of_type_Berr.b();
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
  
  protected void aL_()
  {
    this.jdField_b_of_type_Berr.a();
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
        ((beum)localObject).jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
    } while (!f());
    this.jdField_a_of_type_Bevl = ((bevl)localObject);
    o();
    this.jdField_a_of_type_Beuo.a((bevl)localObject);
  }
  
  public int b()
  {
    return super.b();
  }
  
  public void b(HashMap<String, String> paramHashMap)
  {
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    String str6 = (String)paramHashMap.get("param_conf_connNum");
    String str7 = (String)paramHashMap.get("param_fin_lost");
    this.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramHashMap.get("ip"));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_bdhPort", paramHashMap.get("port"));
    this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", str1);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str2);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str3);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str4);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str5);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str6);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str7);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_retry_code", paramHashMap.get("param_retry_code"));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_ip_index", paramHashMap.get("param_ip_index"));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    this.jdField_a_of_type_Bfci.m = ((String)paramHashMap.get("param_Ip_ConnCost"));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_BDH_Cache_Diff", paramHashMap.get("param_BDH_Cache_Diff"));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", paramHashMap.get("param_is_ipv6"));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_hasV6List", paramHashMap.get("param_hasV6List"));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_ipv6First", paramHashMap.get("param_ipv6First"));
    this.jdField_m_of_type_Long = this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.mTransReport.timeCost_Ht;
    this.o = this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.mTransReport.timeCost_Cache;
  }
  
  public void c()
  {
    super.c();
    if (!this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        b("pause", "");
      }
      d(1004);
      if (this.jdField_a_of_type_Bfau != null)
      {
        bfca.b(this.jdField_a_of_type_Bfau);
        this.jdField_a_of_type_Bfau = null;
      }
      if (this.jdField_a_of_type_Bevl != null)
      {
        this.jdField_a_of_type_Beuo.b(this.jdField_a_of_type_Bevl);
        this.jdField_a_of_type_Bevl = null;
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
    if (this.jdField_b_of_type_JavaIoRandomAccessFile != null) {}
    try
    {
      this.jdField_b_of_type_JavaIoRandomAccessFile.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    finally
    {
      this.jdField_b_of_type_JavaIoRandomAccessFile = null;
    }
  }
  
  protected boolean g()
  {
    return (this.jdField_d_of_type_ArrayOfByte != null) && (this.jdField_d_of_type_ArrayOfByte.length > 0) && (this.jdField_c_of_type_ArrayOfByte != null) && (this.jdField_c_of_type_ArrayOfByte.length > 0);
  }
  
  /* Error */
  boolean h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 130	beru:jdField_a_of_type_Beyg	Lbeyg;
    //   4: getfield 410	beyg:i	Ljava/lang/String;
    //   7: astore 4
    //   9: new 412	java/io/FileInputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 414	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: aload_0
    //   22: aload_3
    //   23: aload_0
    //   24: getfield 417	beru:jdField_a_of_type_Bete	Lbete;
    //   27: getfield 420	bete:jdField_a_of_type_Long	J
    //   30: invokestatic 426	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   33: putfield 428	beru:jdField_b_of_type_ArrayOfByte	[B
    //   36: aload_3
    //   37: astore_2
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 428	beru:jdField_b_of_type_ArrayOfByte	[B
    //   43: invokestatic 433	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   46: putfield 435	beru:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   49: aload_3
    //   50: astore_2
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 435	beru:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   56: putfield 436	beru:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 417	beru:jdField_a_of_type_Bete	Lbete;
    //   65: aload_0
    //   66: getfield 435	beru:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   69: putfield 438	bete:f	Ljava/lang/String;
    //   72: aload_3
    //   73: astore_2
    //   74: aload_0
    //   75: new 73	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   82: aload_0
    //   83: getfield 435	beru:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   86: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 440
    //   92: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: getfield 441	beru:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   99: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: putfield 435	beru:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   108: aload_3
    //   109: ifnull +7 -> 116
    //   112: aload_3
    //   113: invokevirtual 442	java/io/FileInputStream:close	()V
    //   116: iconst_1
    //   117: istore_1
    //   118: iload_1
    //   119: ireturn
    //   120: astore_2
    //   121: aload_3
    //   122: astore_2
    //   123: new 444	java/io/File
    //   126: dup
    //   127: aload 4
    //   129: invokespecial 445	java/io/File:<init>	(Ljava/lang/String;)V
    //   132: astore 4
    //   134: aload_3
    //   135: astore_2
    //   136: aload 4
    //   138: invokevirtual 448	java/io/File:exists	()Z
    //   141: istore_1
    //   142: iload_1
    //   143: ifeq -107 -> 36
    //   146: aload_3
    //   147: astore_2
    //   148: aload 4
    //   150: invokestatic 453	bleb:a	(Ljava/io/File;)Ljava/lang/String;
    //   153: astore 4
    //   155: aload 4
    //   157: ifnull +17 -> 174
    //   160: aload_3
    //   161: astore_2
    //   162: aload_0
    //   163: aload 4
    //   165: invokestatic 457	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   168: putfield 428	beru:jdField_b_of_type_ArrayOfByte	[B
    //   171: goto -135 -> 36
    //   174: ldc_w 374
    //   177: astore 4
    //   179: goto -19 -> 160
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   187: goto -71 -> 116
    //   190: astore 4
    //   192: aconst_null
    //   193: astore_3
    //   194: aload_3
    //   195: astore_2
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 428	beru:jdField_b_of_type_ArrayOfByte	[B
    //   201: aload_3
    //   202: astore_2
    //   203: aload_0
    //   204: aload 4
    //   206: invokevirtual 232	beru:a	(Ljava/io/IOException;)V
    //   209: iconst_0
    //   210: istore_1
    //   211: aload_3
    //   212: ifnull -94 -> 118
    //   215: aload_3
    //   216: invokevirtual 442	java/io/FileInputStream:close	()V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_2
    //   222: aload_2
    //   223: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   226: iconst_0
    //   227: ireturn
    //   228: astore_3
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 442	java/io/FileInputStream:close	()V
    //   239: aload_3
    //   240: athrow
    //   241: astore_2
    //   242: aload_2
    //   243: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   246: goto -7 -> 239
    //   249: astore_3
    //   250: goto -19 -> 231
    //   253: astore 4
    //   255: goto -61 -> 194
    //   258: astore_2
    //   259: goto -223 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	beru
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
  
  protected void i()
  {
    try
    {
      int i;
      if (SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getHttpconn_sig_session() != null)
      {
        i = SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getHttpconn_sig_session().length;
        this.jdField_d_of_type_ArrayOfByte = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getHttpconn_sig_session(), 0, this.jdField_d_of_type_ArrayOfByte, 0, i);
      }
      if (SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getSessionKey() != null)
      {
        i = SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getSessionKey().length;
        this.jdField_c_of_type_ArrayOfByte = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getSessionKey(), 0, this.jdField_c_of_type_ArrayOfByte, 0, i);
      }
      return;
    }
    finally {}
  }
  
  protected void p()
  {
    int i = 1;
    if ((this.w == 2) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("param_BdhTrans"))) {
      if ((this.n > 0L) && (this.o > 0L))
      {
        if ((this.jdField_r_of_type_Boolean) && (i != 0))
        {
          this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
          this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.p).append("_").append("tr").append(this.n).append("_").append("ht").append(this.jdField_m_of_type_Long).append("_").append("pic").append(this.o).append(";");
          this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.o));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_CostEach", this.jdField_a_of_type_JavaLangStringBuilder.toString());
          this.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(this.p));
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sn:").append(this.p).append(";").append("tc_s:").append(this.n).append(";").append("tc_h:").append(this.jdField_m_of_type_Long).append(";").append("tc_p:").append(this.o).append(";");
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
    this.k = System.nanoTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beru
 * JD-Core Version:    0.7.0.1
 */