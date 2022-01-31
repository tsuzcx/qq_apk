import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.MultiMsgUpProcessor.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import tencent.im.longconn.longmsg.LongMsg.MsgUpReq;
import tencent.im.longconn.longmsg.LongMsg.ReqBody;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;

public class baqo
  extends banb
{
  public static boolean b;
  private static int c;
  public int a;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Baub.i;
  public boolean a;
  private int jdField_b_of_type_Int = this.jdField_a_of_type_Baub.jdField_a_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private bica jdField_b_of_type_Bica = new bica();
  private String jdField_b_of_type_JavaLangString;
  private byte[] d;
  private byte[] e;
  private byte[] f;
  private byte[] g;
  private byte[] h;
  private byte[] i;
  
  static
  {
    jdField_b_of_type_Boolean = true;
  }
  
  public baqo(batw parambatw, baub parambaub)
  {
    super(parambatw, parambaub);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_ArrayOfByte = parambaub.jdField_b_of_type_ArrayOfByte;
    this.jdField_a_of_type_Int = parambaub.h;
    if (this.jdField_d_of_type_ArrayOfByte != null) {}
    for (this.q = parambaub.jdField_b_of_type_ArrayOfByte.length;; this.q = 0L) {
      try
      {
        this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_Baub.jdField_b_of_type_JavaLangString);
        return;
      }
      catch (Exception parambatw)
      {
        parambatw.printStackTrace();
        this.jdField_a_of_type_Long = 0L;
      }
    }
  }
  
  public static int a(int paramInt)
  {
    int j = 3;
    switch (paramInt)
    {
    default: 
      j = 1;
    case 1: 
    case 3000: 
      return j;
    case 1040: 
      return 15;
    }
    return 255;
  }
  
  private boolean a()
  {
    Object localObject1 = new LongMsg.MsgUpReq();
    ((LongMsg.MsgUpReq)localObject1).setHasFlag(true);
    ((LongMsg.MsgUpReq)localObject1).uint64_dst_uin.set(Long.valueOf(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString).longValue());
    ((LongMsg.MsgUpReq)localObject1).bytes_msg_content.set(ByteStringMicro.copyFrom(this.jdField_d_of_type_ArrayOfByte));
    if (!jdField_b_of_type_Boolean) {
      ((LongMsg.MsgUpReq)localObject1).bytes_msg_ukey.set(ByteStringMicro.copyFrom(this.g));
    }
    ((LongMsg.MsgUpReq)localObject1).uint32_store_type.set(2);
    ((LongMsg.MsgUpReq)localObject1).uint32_msg_type.set(a(this.jdField_b_of_type_Int));
    Object localObject2 = new LongMsg.ReqBody();
    ((LongMsg.ReqBody)localObject2).setHasFlag(true);
    ((LongMsg.ReqBody)localObject2).uint32_subcmd.set(1);
    ((LongMsg.ReqBody)localObject2).uint32_term_type.set(5);
    ((LongMsg.ReqBody)localObject2).uint32_platform_type.set(9);
    ((LongMsg.ReqBody)localObject2).rpt_msg_up_req.add((MessageMicro)localObject1);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 0)) {
      ((LongMsg.ReqBody)localObject2).uint32_agent_type.set(1);
    }
    this.jdField_e_of_type_ArrayOfByte = ((LongMsg.ReqBody)localObject2).toByteArray();
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    byte[] arrayOfByte = new Cryptor().encrypt(((LongMsg.ReqBody)localObject2).toByteArray(), this.jdField_h_of_type_ArrayOfByte);
    Object localObject3 = new im_msg_head.LoginSig();
    ((im_msg_head.LoginSig)localObject3).uint32_type.set(22);
    ((im_msg_head.LoginSig)localObject3).bytes_sig.set(ByteStringMicro.copyFrom(this.i));
    localObject1 = new String();
    int j = 0;
    while (j < "8.3.3".length())
    {
      localObject2 = localObject1;
      if ("8.3.3".charAt(j) != '.') {
        localObject2 = ((String)localObject1).concat(Character.toString("8.3.3".charAt(j)));
      }
      j += 1;
      localObject1 = localObject2;
    }
    localObject2 = new im_msg_head.HttpConnHead();
    ((im_msg_head.HttpConnHead)localObject2).uint64_uin.set(this.jdField_a_of_type_Long);
    ((im_msg_head.HttpConnHead)localObject2).uint32_command.set(1791);
    ((im_msg_head.HttpConnHead)localObject2).uint32_sub_command.set(1291);
    ((im_msg_head.HttpConnHead)localObject2).uint32_seq.set(d());
    ((im_msg_head.HttpConnHead)localObject2).uint32_version.set(Integer.parseInt((String)localObject1));
    ((im_msg_head.HttpConnHead)localObject2).uint32_flag.set(1);
    ((im_msg_head.HttpConnHead)localObject2).uint32_compress_type.set(0);
    ((im_msg_head.HttpConnHead)localObject2).uint32_error_code.set(0);
    localObject1 = new im_msg_head.Head();
    ((im_msg_head.Head)localObject1).uint32_head_type.set(4);
    ((im_msg_head.Head)localObject1).msg_login_sig.set((MessageMicro)localObject3);
    ((im_msg_head.Head)localObject1).msg_httpconn_head.set((MessageMicro)localObject2);
    localObject1 = ((im_msg_head.Head)localObject1).toByteArray();
    localObject2 = new ByteArrayOutputStream();
    try
    {
      localObject3 = new DataOutputStream((OutputStream)localObject2);
      ((DataOutputStream)localObject3).write(40);
      ((DataOutputStream)localObject3).writeInt(localObject1.length);
      ((DataOutputStream)localObject3).writeInt(arrayOfByte.length);
      ((DataOutputStream)localObject3).write((byte[])localObject1);
      ((DataOutputStream)localObject3).write(arrayOfByte);
      ((DataOutputStream)localObject3).write(41);
      ((DataOutputStream)localObject3).flush();
      this.jdField_e_of_type_ArrayOfByte = ((ByteArrayOutputStream)localObject2).toByteArray();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsgUpProcessor", 2, localException.getMessage());
      }
      b(9360, "constructToSendData() dos.write()");
    }
    return false;
  }
  
  private static int d()
  {
    int j = jdField_c_of_type_Int;
    jdField_c_of_type_Int = j + 1;
    return j;
  }
  
  private void f()
  {
    this.jdField_a_of_type_Bamy.a();
    bawv localbawv = new bawv();
    localbawv.jdField_a_of_type_Long = this.q;
    localbawv.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localbawv.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbawv.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_b_of_type_JavaLangString;
    localbawv.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString;
    localbawv.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_d_of_type_JavaLangString;
    localbawv.f = this.jdField_a_of_type_Baub.jdField_a_of_type_Int;
    bawo localbawo = new bawo();
    localbawo.jdField_a_of_type_Baxv = this;
    localbawo.jdField_a_of_type_JavaLangString = "multi_msg_up";
    localbawo.jdField_a_of_type_JavaUtilList.add(localbawv);
    localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Bamy);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbawo.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bawo = localbawo;
    if (jdField_b_of_type_Boolean)
    {
      if (!a()) {
        break label203;
      }
      aQ_();
    }
    for (;;)
    {
      baxu.a(localbawo);
      return;
      label203:
      d();
    }
  }
  
  protected long a(long paramLong)
  {
    return this.jdField_e_of_type_ArrayOfByte.length;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    basp localbasp = (basp)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(localbasp.jdField_a_of_type_JavaLangString);
    if (localbasp.jdField_a_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(localbasp.jdField_a_of_type_Int);
    }
    paramArrayOfByte.append("/cgi-bin/httpconn");
    return paramArrayOfByte.toString();
  }
  
  public void a(bawo parambawo, baxd parambaxd)
  {
    this.jdField_a_of_type_Bawo = null;
    if ((parambaxd == null) || (parambaxd.jdField_a_of_type_JavaUtilList == null) || (parambaxd.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      b(9006, "resp == null || resp.resps == null || resp.resps.size() == 0");
      d();
    }
    for (;;)
    {
      return;
      parambawo = parambaxd.jdField_a_of_type_JavaUtilList.iterator();
      while (parambawo.hasNext())
      {
        parambaxd = (baxq)parambawo.next();
        if (QLog.isColorLevel()) {
          b("procUrl", parambaxd.toString());
        }
        a(this.jdField_a_of_type_Bamy, parambaxd);
        parambaxd = (baxn)parambaxd;
        if (parambaxd.jdField_c_of_type_Int != 0) {
          break label197;
        }
        this.f = parambaxd.jdField_a_of_type_ArrayOfByte;
        this.g = parambaxd.jdField_b_of_type_ArrayOfByte;
        this.jdField_a_of_type_JavaUtilArrayList = parambaxd.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_h_of_type_ArrayOfByte = parambaxd.jdField_c_of_type_ArrayOfByte;
        this.i = parambaxd.jdField_d_of_type_ArrayOfByte;
        try
        {
          this.jdField_b_of_type_JavaLangString = new String(this.f, "utf-8");
          if (a()) {
            aQ_();
          }
        }
        catch (UnsupportedEncodingException parambaxd)
        {
          for (;;)
          {
            parambaxd.printStackTrace();
          }
          d();
        }
      }
    }
    label197:
    b(9007, "upResp.result=" + parambaxd.jdField_c_of_type_Int);
    d();
  }
  
  protected void a(boolean paramBoolean)
  {
    int j = 2;
    String str = this.jdField_a_of_type_Bamy.a(1) + ";" + this.jdField_b_of_type_Bamy.a(2) + ";" + this.jdField_c_of_type_Bamy.a(3);
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsgUpProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
    }
    if (this.jdField_a_of_type_Baub.e == 1030) {}
    while (((!paramBoolean) && (basb.b(this.jdField_j_of_type_Int))) || (this.jdField_h_of_type_Boolean) || ((paramBoolean) && ((this.jdField_m_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_m_of_type_Int & 0x1) > 0))) {
      return;
    }
    int k = this.jdField_m_of_type_Int;
    long l;
    if (paramBoolean)
    {
      this.jdField_m_of_type_Int = (j | k);
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString);
      if (!paramBoolean) {
        break label426;
      }
      if ((this.n <= 0L) || (this.jdField_o_of_type_Long <= 0L)) {
        break label421;
      }
      j = 1;
      label245:
      if ((this.p) && (j != 0))
      {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.jdField_o_of_type_Int).append("_").append("tr").append(this.n).append("_").append("ht").append(this.jdField_m_of_type_Long).append("_").append("pic").append(this.jdField_o_of_type_Long).append(";");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_CostEach", this.jdField_a_of_type_JavaLangStringBuilder.toString());
        this.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(this.jdField_o_of_type_Int));
      }
      azmz.a(BaseApplication.getContext()).a(null, "actMultiMsgUpload", true, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      l();
      return;
      j = 1;
      break;
      label421:
      j = 0;
      break label245;
      label426:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.q));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_Baub.e));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Baub.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_Baub.jdField_a_of_type_Long));
      azmz.a(BaseApplication.getContext()).a(null, "actMultiMsgUpload", false, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    return this.jdField_e_of_type_ArrayOfByte;
  }
  
  public void aQ_()
  {
    if (this.jdField_b_of_type_Long == -1L) {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
    this.jdField_b_of_type_Bamy.a();
    long l1 = this.jdField_s_of_type_Long;
    long l2 = a(l1);
    Object localObject = a((int)l1, (int)l2);
    if (localObject == null) {
      d();
    }
    do
    {
      int j;
      do
      {
        return;
        b("sendingdata", "pos:" + l1 + "  transferData len:" + localObject.length);
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_b_of_type_JavaLangString = UUID.randomUUID().toString();
        localObject = bame.d(this.jdField_b_of_type_JavaLangString);
        File localFile = new File((String)localObject);
        if (localFile.exists()) {
          localFile.delete();
        }
        bdcs.a(this.jdField_e_of_type_ArrayOfByte, (String)localObject);
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
        this.jdField_a_of_type_Baub.i = this.jdField_a_of_type_JavaLangString;
        super.h();
        localObject = new baqp(this);
        j = 77;
        if (!jdField_b_of_type_Boolean) {
          j = 27;
        }
        this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), j, this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ArrayOfByte, (ITransactionCallback)localObject, null, false);
        j = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        if (QLog.isColorLevel()) {
          QLog.i("MultiMsg_TAG", 2, "Multimsg upload file by BDH and retCode = " + j);
        }
      } while (j == 0);
      a(j, "SubmitError.", "", this.jdField_b_of_type_Bamy);
      d();
      return;
      localObject = a((byte[])localObject);
      if (l1 + l2 >= this.q) {
        ((baps)localObject).jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
    } while (!f());
    this.jdField_a_of_type_Baqv = ((baqv)localObject);
    n();
    this.jdField_a_of_type_Bapv.a((baqv)localObject);
  }
  
  public void aS_()
  {
    super.aS_();
    d(1000);
    if ((this.jdField_d_of_type_ArrayOfByte == null) || (this.jdField_d_of_type_ArrayOfByte.length == 0))
    {
      b(9042, "data is empty");
      d();
      return;
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!h()))
    {
      d();
      return;
    }
    f();
  }
  
  public int b()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      this.jdField_o_of_type_Boolean = false;
      d(1002);
      this.t = 0;
      this.jdField_s_of_type_Int = 0;
      this.g = null;
      this.r = 0;
      this.jdField_s_of_type_Long = 0L;
      this.jdField_j_of_type_Int = 0;
      this.jdField_j_of_type_JavaLangString = "";
      this.jdField_b_of_type_Bica.a();
      this.jdField_a_of_type_Bamu.a.post(new MultiMsgUpProcessor.2(this));
    }
    return 0;
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Baub.toString());
    if ((this.jdField_d_of_type_ArrayOfByte == null) || (0L >= this.q) || (0L == this.jdField_a_of_type_Long)) {
      return -1;
    }
    this.jdField_e_of_type_JavaLangString = "";
    return 0;
  }
  
  public void d()
  {
    super.d();
    d(1005);
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy != null)
    {
      awfz localawfz = new awfz();
      localawfz.jdField_a_of_type_Int = -1;
      localawfz.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
      localawfz.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      localawfz.jdField_a_of_type_JavaLangObject = Long.valueOf(this.jdField_a_of_type_Baub.jdField_a_of_type_Long);
      this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy.b(localawfz);
    }
  }
  
  public void e()
  {
    super.e();
    awfz localawfz;
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy != null)
    {
      localawfz = new awfz();
      localawfz.jdField_b_of_type_Int = 0;
      localawfz.jdField_a_of_type_Long = this.q;
      localawfz.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localawfz.jdField_a_of_type_JavaLangObject = Long.valueOf(this.jdField_a_of_type_Baub.jdField_a_of_type_Long);
    }
    try
    {
      localawfz.jdField_c_of_type_JavaLangString = new String(this.f, "UTF-8");
      this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy.b(localawfz);
      d(1003);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localawfz.jdField_b_of_type_Int = -1;
        localawfz.jdField_a_of_type_JavaLangString = ("Failed. Convert ResID to UTF-8 string failed, resID = " + this.f.toString());
        b("onSuccess", localawfz.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public boolean h()
  {
    this.jdField_a_of_type_ArrayOfByte = MD5.toMD5Byte(this.jdField_d_of_type_ArrayOfByte);
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      b(9041, "getMd5 error");
      return false;
    }
    this.jdField_d_of_type_JavaLangString = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
    this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_Baoj.f = this.jdField_d_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
    return true;
  }
  
  protected void n()
  {
    String str;
    if ((this.jdField_a_of_type_Baqv != null) && ((this.jdField_a_of_type_Baqv instanceof baps)))
    {
      if (!abot.d(this.jdField_b_of_type_Int)) {
        break label56;
      }
      str = "multimsgCu";
    }
    for (;;)
    {
      ((baps)this.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype(str, ((baps)this.jdField_a_of_type_Baqv).jdField_a_of_type_JavaLangString);
      return;
      label56:
      if (this.jdField_b_of_type_Int == 1) {
        str = "multimsgGu";
      } else {
        str = "multimsgDu";
      }
    }
  }
  
  /* Error */
  public void onResp(baqw parambaqw)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 855	banb:onResp	(Lbaqw;)V
    //   5: aload_0
    //   6: getfield 742	baqo:jdField_o_of_type_Boolean	Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: getfield 740	baqo:jdField_k_of_type_Boolean	Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 718	baqo:jdField_a_of_type_Baqv	Lbaqv;
    //   25: aload_0
    //   26: ldc_w 856
    //   29: new 405	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 858
    //   39: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: getfield 861	baqw:jdField_a_of_type_Int	I
    //   46: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 863
    //   52: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 864	baqw:jdField_b_of_type_Int	I
    //   59: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 866
    //   65: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: getfield 867	baqw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   72: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 433	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokevirtual 386	baqo:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_1
    //   82: getfield 861	baqw:jdField_a_of_type_Int	I
    //   85: ifne +209 -> 294
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 869	baqo:jdField_l_of_type_Int	I
    //   93: aload_1
    //   94: getfield 870	baqw:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   97: ldc_w 872
    //   100: invokevirtual 874	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: astore 8
    //   105: aload 8
    //   107: ifnull +162 -> 269
    //   110: aload_1
    //   111: getfield 870	baqw:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   114: ldc_w 872
    //   117: invokevirtual 874	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   120: checkcast 198	java/lang/String
    //   123: invokestatic 245	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   126: istore_2
    //   127: iload_2
    //   128: ifeq +10 -> 138
    //   131: iload_2
    //   132: ldc_w 875
    //   135: if_icmpne +141 -> 276
    //   138: iconst_1
    //   139: istore_3
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 489	baqo:jdField_b_of_type_Bamy	Lbamy;
    //   145: aload_1
    //   146: iload_3
    //   147: invokevirtual 878	baqo:a	(Lbamy;Lbaqw;Z)V
    //   150: invokestatic 630	android/os/SystemClock:uptimeMillis	()J
    //   153: lstore 4
    //   155: aload_0
    //   156: getfield 35	baqo:jdField_b_of_type_Long	J
    //   159: lstore 6
    //   161: iload_3
    //   162: ifeq +119 -> 281
    //   165: aload_0
    //   166: ldc_w 856
    //   169: new 405	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 880
    //   179: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: lload 4
    //   184: lload 6
    //   186: lsub
    //   187: invokevirtual 563	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: ldc_w 882
    //   193: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: getfield 826	baqo:jdField_a_of_type_Baoj	Lbaoj;
    //   200: getfield 883	baoj:jdField_a_of_type_Long	J
    //   203: invokevirtual 563	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: ldc_w 885
    //   209: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload_2
    //   213: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: invokevirtual 433	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokevirtual 386	baqo:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_0
    //   223: invokevirtual 886	baqo:e	()V
    //   226: return
    //   227: astore_1
    //   228: aload_0
    //   229: sipush 9343
    //   232: new 28	java/lang/Exception
    //   235: dup
    //   236: ldc_w 888
    //   239: invokespecial 889	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   242: invokestatic 894	bamf:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   245: ldc_w 590
    //   248: aload_0
    //   249: getfield 489	baqo:jdField_b_of_type_Bamy	Lbamy;
    //   252: invokevirtual 377	baqo:a	(ILjava/lang/String;Ljava/lang/String;Lbamy;)V
    //   255: aload_0
    //   256: invokevirtual 379	baqo:d	()V
    //   259: return
    //   260: astore 8
    //   262: ldc_w 895
    //   265: istore_2
    //   266: goto -139 -> 127
    //   269: ldc_w 875
    //   272: istore_2
    //   273: goto -146 -> 127
    //   276: iconst_0
    //   277: istore_3
    //   278: goto -138 -> 140
    //   281: aload_0
    //   282: iload_2
    //   283: ldc_w 897
    //   286: invokevirtual 312	baqo:b	(ILjava/lang/String;)V
    //   289: aload_0
    //   290: invokevirtual 379	baqo:d	()V
    //   293: return
    //   294: aload_0
    //   295: aload_0
    //   296: getfield 489	baqo:jdField_b_of_type_Bamy	Lbamy;
    //   299: aload_1
    //   300: iconst_0
    //   301: invokevirtual 878	baqo:a	(Lbamy;Lbaqw;Z)V
    //   304: aload_0
    //   305: aload_1
    //   306: getfield 864	baqw:jdField_b_of_type_Int	I
    //   309: aload_1
    //   310: getfield 867	baqw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   313: invokevirtual 312	baqo:b	(ILjava/lang/String;)V
    //   316: aload_0
    //   317: invokevirtual 379	baqo:d	()V
    //   320: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	baqo
    //   0	321	1	parambaqw	baqw
    //   126	157	2	j	int
    //   139	139	3	bool	boolean
    //   153	30	4	l1	long
    //   159	26	6	l2	long
    //   103	3	8	localObject	Object
    //   260	1	8	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   81	105	227	java/lang/Exception
    //   110	127	227	java/lang/Exception
    //   140	161	227	java/lang/Exception
    //   165	226	227	java/lang/Exception
    //   281	293	227	java/lang/Exception
    //   294	320	227	java/lang/Exception
    //   110	127	260	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqo
 * JD-Core Version:    0.7.0.1
 */