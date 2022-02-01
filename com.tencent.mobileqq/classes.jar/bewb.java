import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.wx.voice.vad.WXVadSeg;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.jetbrains.annotations.Nullable;
import tencent.im.cs.smartptt.Smartptt.PttTransRsp;
import tencent.im.cs.smartptt.Smartptt.ReqBody;
import tencent.im.cs.smartptt.Smartptt.RspBody;

public class bewb
  extends beru
{
  private static final byte[] jdField_a_of_type_ArrayOfByte = bhrp.a(1, 16000);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bamy jdField_a_of_type_Bamy;
  private bexq jdField_a_of_type_Bexq;
  private Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String n = "";
  
  public bewb(bern parambern, beyg parambeyg)
  {
    super(parambern, parambeyg);
  }
  
  private bexq a()
  {
    bexq localbexq = new bexq();
    localbexq.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Beyg.p);
    localbexq.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    localbexq.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localbexq.e = this.jdField_a_of_type_Beyg.q;
    localbexq.jdField_b_of_type_JavaLangString = (this.jdField_a_of_type_Beyg.i.substring(0, this.jdField_a_of_type_Beyg.i.lastIndexOf(File.separator)) + "/tmp_" + localbexq.jdField_a_of_type_JavaLangString + "_" + this.jdField_a_of_type_Int + ".silk");
    localbexq.jdField_a_of_type_Int = 6;
    if (this.jdField_a_of_type_Int == 0) {}
    for (localbexq.jdField_a_of_type_Boolean = true;; localbexq.jdField_a_of_type_Boolean = false)
    {
      localbexq.jdField_c_of_type_Int = this.jdField_a_of_type_Beyg.o;
      localbexq.d = this.jdField_a_of_type_Beyg.p;
      return localbexq;
    }
  }
  
  @Nullable
  private File a()
  {
    File localFile2 = new File(this.jdField_b_of_type_JavaLangString);
    File localFile1 = localFile2;
    if (!localFile2.exists())
    {
      b(9042, a(new Exception("sendFile not exist " + this.jdField_b_of_type_JavaLangString)));
      d();
      localFile1 = null;
    }
    return localFile1;
  }
  
  private void a(bexq parambexq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "submitSlice, info:" + parambexq);
    }
    bewc localbewc = new bewc(this, SystemClock.uptimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 68, parambexq.jdField_b_of_type_JavaLangString, (int)this.r, a(parambexq.jdField_b_of_type_JavaLangString), localbewc, bexp.a(parambexq).toByteArray(), false);
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_Long + " bean:" + parambexq + " Cmd:");
    }
    if (i != 0)
    {
      a(i, "SubmitError.", "", this.jdField_b_of_type_Berr);
      d();
    }
  }
  
  private void a(bexq parambexq, int paramInt)
  {
    if ((!parambexq.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long < 6400L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttSliceUploadProcessor", 2, "last p of seg ");
      }
      Object localObject = new byte[(int)(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long)];
      paramInt = this.jdField_b_of_type_JavaIoRandomAccessFile.read((byte[])localObject, 0, (int)(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
      localObject = this.jdField_a_of_type_Bamy.a((byte[])localObject, 0, paramInt);
      if ((localObject == null) || (((bamv)localObject).jdField_a_of_type_Int == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttSliceUploadProcessor", 2, "last p silk len is 0 ");
        }
        parambexq.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Int = 0;
      }
    }
  }
  
  /* Error */
  private void a(bexq parambexq, bamv parambamv)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 81	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: getfield 102	bexq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 127	java/io/File:exists	()Z
    //   19: ifeq +8 -> 27
    //   22: aload_3
    //   23: invokevirtual 278	java/io/File:delete	()Z
    //   26: pop
    //   27: new 280	java/io/FileOutputStream
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 283	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore_3
    //   36: aload_1
    //   37: getfield 106	bexq:jdField_a_of_type_Boolean	Z
    //   40: ifeq +57 -> 97
    //   43: aload_3
    //   44: getstatic 23	bewb:jdField_a_of_type_ArrayOfByte	[B
    //   47: invokevirtual 286	java/io/FileOutputStream:write	([B)V
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 64	bewb:jdField_a_of_type_Int	I
    //   55: aload_2
    //   56: getfield 270	bamv:jdField_a_of_type_Int	I
    //   59: getstatic 23	bewb:jdField_a_of_type_ArrayOfByte	[B
    //   62: arraylength
    //   63: iadd
    //   64: iadd
    //   65: putfield 64	bewb:jdField_a_of_type_Int	I
    //   68: aload_3
    //   69: aload_2
    //   70: getfield 287	bamv:jdField_a_of_type_ArrayOfByte	[B
    //   73: aload_2
    //   74: getfield 288	bamv:jdField_b_of_type_Int	I
    //   77: aload_2
    //   78: getfield 270	bamv:jdField_a_of_type_Int	I
    //   81: invokevirtual 291	java/io/FileOutputStream:write	([BII)V
    //   84: aload_3
    //   85: invokevirtual 294	java/io/FileOutputStream:flush	()V
    //   88: aload_3
    //   89: ifnull +7 -> 96
    //   92: aload_3
    //   93: invokevirtual 297	java/io/FileOutputStream:close	()V
    //   96: return
    //   97: aload_1
    //   98: getfield 244	bexq:jdField_b_of_type_Boolean	Z
    //   101: ifne -33 -> 68
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 64	bewb:jdField_a_of_type_Int	I
    //   109: aload_2
    //   110: getfield 270	bamv:jdField_a_of_type_Int	I
    //   113: iadd
    //   114: putfield 64	bewb:jdField_a_of_type_Int	I
    //   117: goto -49 -> 68
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: aload_2
    //   124: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   127: aload_1
    //   128: ifnull -32 -> 96
    //   131: aload_1
    //   132: invokevirtual 297	java/io/FileOutputStream:close	()V
    //   135: return
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   141: return
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   147: return
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_2
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 297	java/io/FileOutputStream:close	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_2
    //   162: aload_2
    //   163: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   166: goto -7 -> 159
    //   169: astore_1
    //   170: aload_3
    //   171: astore_2
    //   172: goto -21 -> 151
    //   175: astore_3
    //   176: aload_1
    //   177: astore_2
    //   178: aload_3
    //   179: astore_1
    //   180: goto -29 -> 151
    //   183: astore_2
    //   184: aload 4
    //   186: astore_1
    //   187: goto -64 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	bewb
    //   0	190	1	parambexq	bexq
    //   0	190	2	parambamv	bamv
    //   14	157	3	localObject1	Object
    //   175	4	3	localObject2	Object
    //   1	184	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   36	68	120	java/io/IOException
    //   68	88	120	java/io/IOException
    //   97	117	120	java/io/IOException
    //   131	135	136	java/lang/Exception
    //   92	96	142	java/lang/Exception
    //   3	27	148	finally
    //   27	36	148	finally
    //   155	159	161	java/lang/Exception
    //   36	68	169	finally
    //   68	88	169	finally
    //   97	117	169	finally
    //   123	127	175	finally
    //   3	27	183	java/io/IOException
    //   27	36	183	java/io/IOException
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_q_of_type_Boolean) {
      d(1004);
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean1) {
          break;
        }
        d(2003);
      } while (!QLog.isColorLevel());
      QLog.d("PttSliceUploadProcessor", 2, "sendMessageToUpdate send finished!");
      return;
      g();
    } while (!paramBoolean2);
    d(2002);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    Smartptt.RspBody localRspBody = new Smartptt.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("PttSliceUploadProcessor", 2, "onSuccess  text =" + localRspBody.msg_ptttrans_rsp.str_text.get() + " id=" + localRspBody.msg_ptttrans_rsp.str_voice_id.get() + " pos=" + this.jdField_a_of_type_Beyg.p + " uint32_is_final=" + localRspBody.msg_ptttrans_rsp.uint32_is_final.get());
      }
      this.jdField_a_of_type_Bete.jdField_b_of_type_Int = 327696;
      this.jdField_a_of_type_Bete.A = (this.n + localRspBody.msg_ptttrans_rsp.str_text.get());
      this.jdField_a_of_type_Bete.jdField_c_of_type_Int = 68;
      this.jdField_a_of_type_Bete.i = this.jdField_a_of_type_Beyg.p;
      boolean bool1 = bool2;
      if (localRspBody.msg_ptttrans_rsp.uint32_is_final.get() != 1) {
        if (!this.jdField_a_of_type_Bexq.jdField_b_of_type_Boolean) {
          break label238;
        }
      }
      label238:
      for (bool1 = bool2;; bool1 = false)
      {
        a(bool1, true);
        this.jdField_b_of_type_Berr.b();
        this.jdField_b_of_type_Berr.jdField_a_of_type_Int = 1;
        return;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  private boolean a()
  {
    if (this.jdField_b_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_b_of_type_JavaLangString, "r");
        this.jdField_b_of_type_JavaIoRandomAccessFile.seek(0L);
        if (this.jdField_b_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read file error");
          d();
          return true;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_b_of_type_JavaIoRandomAccessFile = null;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
    return false;
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComWxVoiceVadWXVadSeg != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComWxVoiceVadWXVadSeg instanceof WXVadSeg)))
    {
      WXVadSeg localWXVadSeg = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComWxVoiceVadWXVadSeg;
      this.jdField_a_of_type_Long = (localWXVadSeg.mbtm * 32L);
      this.jdField_b_of_type_Long = (localWXVadSeg.metm * 32L);
      this.jdField_a_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d("PttSliceUploadProcessor", 2, "generateFileByOneSeg, vadSegStartPos=" + this.jdField_a_of_type_Long + " EPS=" + this.jdField_b_of_type_Long + " segPos=" + this.jdField_a_of_type_Beyg.p + " size=" + this.jdField_a_of_type_Beyg.o);
      }
    }
    try
    {
      this.jdField_b_of_type_JavaIoRandomAccessFile.seek(this.jdField_a_of_type_Long);
      g();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private void g()
  {
    if (this.jdField_q_of_type_Boolean) {
      return;
    }
    bexq localbexq = a();
    byte[] arrayOfByte;
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long > 6400L)
        {
          Object localObject = new byte[6400];
          i = this.jdField_b_of_type_JavaIoRandomAccessFile.read((byte[])localObject, 0, 6400);
          this.jdField_a_of_type_Long += 6400L;
          localbexq.jdField_b_of_type_Boolean = false;
          a(localbexq, i);
          localObject = this.jdField_a_of_type_Bamy.a((byte[])localObject, 0, i);
          if ((localObject != null) && (((bamv)localObject).jdField_a_of_type_Int != 0)) {
            break;
          }
          a(localbexq.jdField_b_of_type_Boolean, false);
          return;
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
      arrayOfByte = new byte[(int)(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long)];
      int i = this.jdField_b_of_type_JavaIoRandomAccessFile.read(arrayOfByte, 0, (int)(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
      localbexq.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
    }
    a(localbexq, arrayOfByte);
    this.jdField_a_of_type_Bexq = localbexq;
    a(localbexq);
  }
  
  public int a()
  {
    int i = super.a();
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "cancel");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
    }
    return i;
  }
  
  /* Error */
  byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 430	java/io/FileInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 431	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore 4
    //   16: aload 4
    //   18: astore_3
    //   19: aload 4
    //   21: aload_0
    //   22: getfield 358	bewb:jdField_a_of_type_Bete	Lbete;
    //   25: getfield 432	bete:jdField_a_of_type_Long	J
    //   28: invokestatic 438	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   31: astore 7
    //   33: aload 7
    //   35: astore_1
    //   36: aload_1
    //   37: astore_3
    //   38: aload 4
    //   40: ifnull +10 -> 50
    //   43: aload 4
    //   45: invokevirtual 439	java/io/FileInputStream:close	()V
    //   48: aload_1
    //   49: astore_3
    //   50: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +32 -> 85
    //   56: ldc 153
    //   58: iconst_2
    //   59: new 39	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 441
    //   69: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_3
    //   73: invokestatic 447	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   76: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_3
    //   86: areturn
    //   87: astore_3
    //   88: aload 4
    //   90: astore_3
    //   91: new 81	java/io/File
    //   94: dup
    //   95: aload_1
    //   96: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: astore 7
    //   101: aload 4
    //   103: astore_3
    //   104: aload 7
    //   106: invokevirtual 127	java/io/File:exists	()Z
    //   109: istore_2
    //   110: aload 5
    //   112: astore_1
    //   113: iload_2
    //   114: ifeq -78 -> 36
    //   117: aload 4
    //   119: astore_3
    //   120: aload 7
    //   122: invokestatic 452	bleb:a	(Ljava/io/File;)Ljava/lang/String;
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +14 -> 141
    //   130: aload 4
    //   132: astore_3
    //   133: aload_1
    //   134: invokestatic 455	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   137: astore_1
    //   138: goto -102 -> 36
    //   141: ldc 30
    //   143: astore_1
    //   144: goto -14 -> 130
    //   147: astore_3
    //   148: aload_3
    //   149: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   152: aload_1
    //   153: astore_3
    //   154: goto -104 -> 50
    //   157: astore 5
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: astore_3
    //   163: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +32 -> 198
    //   169: aload_1
    //   170: astore_3
    //   171: ldc 153
    //   173: iconst_2
    //   174: new 39	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 457
    //   184: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 5
    //   189: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload 6
    //   200: astore_3
    //   201: aload_1
    //   202: ifnull -152 -> 50
    //   205: aload_1
    //   206: invokevirtual 439	java/io/FileInputStream:close	()V
    //   209: aload 6
    //   211: astore_3
    //   212: goto -162 -> 50
    //   215: astore_1
    //   216: aload_1
    //   217: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   220: aload 6
    //   222: astore_3
    //   223: goto -173 -> 50
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_3
    //   229: aload_3
    //   230: ifnull +7 -> 237
    //   233: aload_3
    //   234: invokevirtual 439	java/io/FileInputStream:close	()V
    //   237: aload_1
    //   238: athrow
    //   239: astore_3
    //   240: aload_3
    //   241: invokevirtual 300	java/io/IOException:printStackTrace	()V
    //   244: goto -7 -> 237
    //   247: astore_1
    //   248: goto -19 -> 229
    //   251: astore 5
    //   253: aload 4
    //   255: astore_1
    //   256: goto -95 -> 161
    //   259: astore_1
    //   260: aload 5
    //   262: astore_1
    //   263: goto -227 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	bewb
    //   0	266	1	paramString	String
    //   109	5	2	bool	boolean
    //   18	68	3	localObject1	Object
    //   87	1	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   90	43	3	localFileInputStream1	java.io.FileInputStream
    //   147	2	3	localIOException1	IOException
    //   153	81	3	localObject2	Object
    //   239	2	3	localIOException2	IOException
    //   14	240	4	localFileInputStream2	java.io.FileInputStream
    //   4	107	5	localObject3	Object
    //   157	31	5	localIOException3	IOException
    //   251	10	5	localIOException4	IOException
    //   1	220	6	localObject4	Object
    //   31	90	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   19	33	87	java/lang/UnsatisfiedLinkError
    //   43	48	147	java/io/IOException
    //   6	16	157	java/io/IOException
    //   205	209	215	java/io/IOException
    //   6	16	226	finally
    //   233	237	239	java/io/IOException
    //   19	33	247	finally
    //   91	101	247	finally
    //   104	110	247	finally
    //   120	126	247	finally
    //   133	138	247	finally
    //   163	169	247	finally
    //   171	198	247	finally
    //   19	33	251	java/io/IOException
    //   91	101	251	java/io/IOException
    //   104	110	251	java/io/IOException
    //   120	126	259	java/io/IOException
    //   133	138	259	java/io/IOException
  }
  
  public void aN_()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Beyg.n;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      b(9042, "No pcm source");
      d();
    }
    File localFile;
    do
    {
      do
      {
        return;
        if ((this.jdField_b_of_type_ArrayOfByte == null) && (!h()))
        {
          b(9041, "No Local MD5");
          d();
          return;
        }
      } while (a());
      localFile = a();
    } while (localFile == null);
    this.jdField_q_of_type_Long = localFile.length();
    this.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Bamy = new bamy();
    this.jdField_a_of_type_Bamy.a(new SilkCodecWrapper(BaseApplication.getContext()));
    try
    {
      this.jdField_a_of_type_Bamy.a(16000, 16000, 1);
      f();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  protected void finalize()
  {
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewb
 * JD-Core Version:    0.7.0.1
 */