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
import tencent.im.longconn.longmsg.LongMsg.MsgUpReq;
import tencent.im.longconn.longmsg.LongMsg.ReqBody;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;

public class axsi
  extends axox
{
  private static int c;
  public int a;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_i_of_type_JavaLangString;
  public boolean a;
  private int jdField_b_of_type_Int = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private bess jdField_b_of_type_Bess = new bess();
  private String jdField_b_of_type_JavaLangString;
  private byte[] d;
  private byte[] e;
  private byte[] f;
  private byte[] g;
  private byte[] h;
  private byte[] i;
  
  public axsi(axvo paramaxvo, axvt paramaxvt)
  {
    super(paramaxvo, paramaxvt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_ArrayOfByte = paramaxvt.jdField_b_of_type_ArrayOfByte;
    this.jdField_a_of_type_Int = paramaxvt.h;
    if (this.jdField_d_of_type_ArrayOfByte != null) {}
    for (this.q = paramaxvt.jdField_b_of_type_ArrayOfByte.length;; this.q = 0L) {
      try
      {
        this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_Axvt.jdField_b_of_type_JavaLangString);
        return;
      }
      catch (Exception paramaxvo)
      {
        paramaxvo.printStackTrace();
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
    ((LongMsg.MsgUpReq)localObject1).uint64_dst_uin.set(Long.valueOf(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString).longValue());
    ((LongMsg.MsgUpReq)localObject1).bytes_msg_content.set(ByteStringMicro.copyFrom(this.jdField_d_of_type_ArrayOfByte));
    ((LongMsg.MsgUpReq)localObject1).bytes_msg_ukey.set(ByteStringMicro.copyFrom(this.g));
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
    ((im_msg_head.LoginSig)localObject3).bytes_sig.set(ByteStringMicro.copyFrom(this.jdField_i_of_type_ArrayOfByte));
    localObject1 = new String();
    int j = 0;
    while (j < "8.2.6".length())
    {
      localObject2 = localObject1;
      if ("8.2.6".charAt(j) != '.') {
        localObject2 = ((String)localObject1).concat(Character.toString("8.2.6".charAt(j)));
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
    this.jdField_a_of_type_Axow.a();
    axyn localaxyn = new axyn();
    localaxyn.jdField_a_of_type_Long = this.q;
    localaxyn.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localaxyn.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localaxyn.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_b_of_type_JavaLangString;
    localaxyn.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString;
    localaxyn.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_d_of_type_JavaLangString;
    localaxyn.f = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
    axyg localaxyg = new axyg();
    localaxyg.jdField_a_of_type_Axzn = this;
    localaxyg.jdField_a_of_type_JavaLangString = "multi_msg_up";
    localaxyg.jdField_a_of_type_JavaUtilList.add(localaxyn);
    localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Axow);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localaxyg.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Axyg = localaxyg;
    axzm.a(localaxyg);
  }
  
  protected long a(long paramLong)
  {
    return this.jdField_e_of_type_ArrayOfByte.length;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    axuh localaxuh = (axuh)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(localaxuh.jdField_a_of_type_JavaLangString);
    if (localaxuh.jdField_a_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(localaxuh.jdField_a_of_type_Int);
    }
    paramArrayOfByte.append("/cgi-bin/httpconn");
    return paramArrayOfByte.toString();
  }
  
  public void a(axyg paramaxyg, axyv paramaxyv)
  {
    this.jdField_a_of_type_Axyg = null;
    if ((paramaxyv == null) || (paramaxyv.jdField_a_of_type_JavaUtilList == null) || (paramaxyv.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      b(9006, "resp == null || resp.resps == null || resp.resps.size() == 0");
      d();
    }
    for (;;)
    {
      return;
      paramaxyg = paramaxyv.jdField_a_of_type_JavaUtilList.iterator();
      while (paramaxyg.hasNext())
      {
        paramaxyv = (axzi)paramaxyg.next();
        if (QLog.isColorLevel()) {
          b("procUrl", paramaxyv.toString());
        }
        a(this.jdField_a_of_type_Axow, paramaxyv);
        paramaxyv = (axzf)paramaxyv;
        if (paramaxyv.jdField_c_of_type_Int != 0) {
          break label197;
        }
        this.f = paramaxyv.jdField_a_of_type_ArrayOfByte;
        this.g = paramaxyv.jdField_b_of_type_ArrayOfByte;
        this.jdField_a_of_type_JavaUtilArrayList = paramaxyv.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_h_of_type_ArrayOfByte = paramaxyv.jdField_c_of_type_ArrayOfByte;
        this.jdField_i_of_type_ArrayOfByte = paramaxyv.jdField_d_of_type_ArrayOfByte;
        try
        {
          this.jdField_b_of_type_JavaLangString = new String(this.f, "utf-8");
          if (a()) {
            aS_();
          }
        }
        catch (UnsupportedEncodingException paramaxyv)
        {
          for (;;)
          {
            paramaxyv.printStackTrace();
          }
          d();
        }
      }
    }
    label197:
    b(9007, "upResp.result=" + paramaxyv.jdField_c_of_type_Int);
    d();
  }
  
  protected void a(boolean paramBoolean)
  {
    int j = 2;
    String str = this.jdField_a_of_type_Axow.a(1) + ";" + this.jdField_b_of_type_Axow.a(2) + ";" + this.jdField_c_of_type_Axow.a(3);
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsgUpProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
    }
    if (this.jdField_a_of_type_Axvt.e == 1030) {}
    while (((!paramBoolean) && (axtt.b(this.j))) || (this.jdField_h_of_type_Boolean) || ((paramBoolean) && ((this.jdField_m_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_m_of_type_Int & 0x1) > 0))) {
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
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString);
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
      awrn.a(BaseApplication.getContext()).a(null, "actMultiMsgUpload", true, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
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
      if (this.j != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.j));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_i_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.q));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_Axvt.e));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Axvt.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_Axvt.jdField_a_of_type_Long));
      awrn.a(BaseApplication.getContext()).a(null, "actMultiMsgUpload", false, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    return this.jdField_e_of_type_ArrayOfByte;
  }
  
  public void aS_()
  {
    if (this.jdField_b_of_type_Long == -1L) {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
    this.jdField_b_of_type_Axow.a();
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
        localObject = axoa.d(this.jdField_b_of_type_JavaLangString);
        File localFile = new File((String)localObject);
        if (localFile.exists()) {
          localFile.delete();
        }
        bace.a(this.jdField_e_of_type_ArrayOfByte, (String)localObject);
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
        this.jdField_a_of_type_Axvt.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        super.j();
        localObject = new axsj(this);
        this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 27, this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ArrayOfByte, (ITransactionCallback)localObject, null, false);
        j = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        if (QLog.isColorLevel()) {
          QLog.i("TAG_MultiMsg", 2, "Multimsg upload file by BDH and retCode = " + j);
        }
      } while (j == 0);
      a(j, "SubmitError.", "", this.jdField_b_of_type_Axow);
      d();
      return;
      localObject = a((byte[])localObject);
      if (l1 + l2 >= this.q) {
        ((axro)localObject).jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
    } while (!f());
    this.jdField_a_of_type_Axsp = ((axsp)localObject);
    n();
    this.jdField_a_of_type_Axrr.a((axsp)localObject);
  }
  
  public void aU_()
  {
    super.aU_();
    d(1000);
    if ((this.jdField_d_of_type_ArrayOfByte == null) || (this.jdField_d_of_type_ArrayOfByte.length == 0))
    {
      b(9042, "data is empty");
      d();
      return;
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!j()))
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
      this.j = 0;
      this.jdField_i_of_type_JavaLangString = "";
      this.jdField_b_of_type_Bess.a();
      this.jdField_a_of_type_Axos.a.post(new MultiMsgUpProcessor.2(this));
    }
    return 0;
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Axvt.toString());
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
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq != null)
    {
      atqr localatqr = new atqr();
      localatqr.jdField_a_of_type_Int = -1;
      localatqr.jdField_b_of_type_Int = this.j;
      localatqr.jdField_a_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      localatqr.jdField_a_of_type_JavaLangObject = Long.valueOf(this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
      this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq.b(localatqr);
    }
  }
  
  public void e()
  {
    super.e();
    atqr localatqr;
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq != null)
    {
      localatqr = new atqr();
      localatqr.jdField_b_of_type_Int = 0;
      localatqr.jdField_a_of_type_Long = this.q;
      localatqr.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localatqr.jdField_a_of_type_JavaLangObject = Long.valueOf(this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    }
    try
    {
      localatqr.jdField_c_of_type_JavaLangString = new String(this.f, "UTF-8");
      this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq.b(localatqr);
      d(1003);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localatqr.jdField_b_of_type_Int = -1;
        localatqr.jdField_a_of_type_JavaLangString = ("Failed. Convert ResID to UTF-8 string failed, resID = " + this.f.toString());
        b("onSuccess", localatqr.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public boolean j()
  {
    this.jdField_a_of_type_ArrayOfByte = MD5.toMD5Byte(this.jdField_d_of_type_ArrayOfByte);
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      b(9041, "getMd5 error");
      return false;
    }
    this.jdField_d_of_type_JavaLangString = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
    this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_Axqf.f = this.jdField_d_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
    return true;
  }
  
  protected void n()
  {
    String str;
    if ((this.jdField_a_of_type_Axsp != null) && ((this.jdField_a_of_type_Axsp instanceof axro)))
    {
      if (!akbm.c(this.jdField_b_of_type_Int)) {
        break label56;
      }
      str = "multimsgCu";
    }
    for (;;)
    {
      ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype(str, ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
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
  public void onResp(axsq paramaxsq)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 842	axox:onResp	(Laxsq;)V
    //   5: aload_0
    //   6: getfield 729	axsi:jdField_o_of_type_Boolean	Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: getfield 727	axsi:jdField_k_of_type_Boolean	Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 705	axsi:jdField_a_of_type_Axsp	Laxsp;
    //   25: aload_0
    //   26: ldc_w 843
    //   29: new 393	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 394	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 845
    //   39: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: getfield 848	axsq:jdField_a_of_type_Int	I
    //   46: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 850
    //   52: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 851	axsq:jdField_b_of_type_Int	I
    //   59: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 853
    //   65: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: getfield 854	axsq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   72: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokevirtual 379	axsi:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_1
    //   82: getfield 848	axsq:jdField_a_of_type_Int	I
    //   85: ifne +209 -> 294
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 856	axsi:jdField_l_of_type_Int	I
    //   93: aload_1
    //   94: getfield 857	axsq:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   97: ldc_w 859
    //   100: invokevirtual 861	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: astore 8
    //   105: aload 8
    //   107: ifnull +162 -> 269
    //   110: aload_1
    //   111: getfield 857	axsq:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   114: ldc_w 859
    //   117: invokevirtual 861	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   120: checkcast 195	java/lang/String
    //   123: invokestatic 242	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   126: istore_2
    //   127: iload_2
    //   128: ifeq +10 -> 138
    //   131: iload_2
    //   132: ldc_w 862
    //   135: if_icmpne +141 -> 276
    //   138: iconst_1
    //   139: istore_3
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 484	axsi:jdField_b_of_type_Axow	Laxow;
    //   145: aload_1
    //   146: iload_3
    //   147: invokevirtual 865	axsi:a	(Laxow;Laxsq;Z)V
    //   150: invokestatic 624	android/os/SystemClock:uptimeMillis	()J
    //   153: lstore 4
    //   155: aload_0
    //   156: getfield 30	axsi:jdField_b_of_type_Long	J
    //   159: lstore 6
    //   161: iload_3
    //   162: ifeq +119 -> 281
    //   165: aload_0
    //   166: ldc_w 843
    //   169: new 393	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 394	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 867
    //   179: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: lload 4
    //   184: lload 6
    //   186: lsub
    //   187: invokevirtual 558	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: ldc_w 869
    //   193: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: getfield 813	axsi:jdField_a_of_type_Axqf	Laxqf;
    //   200: getfield 870	axqf:jdField_a_of_type_Long	J
    //   203: invokevirtual 558	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: ldc_w 872
    //   209: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload_2
    //   213: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokevirtual 379	axsi:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_0
    //   223: invokevirtual 873	axsi:e	()V
    //   226: return
    //   227: astore_1
    //   228: aload_0
    //   229: sipush 9343
    //   232: new 23	java/lang/Exception
    //   235: dup
    //   236: ldc_w 875
    //   239: invokespecial 876	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   242: invokestatic 881	axob:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   245: ldc_w 585
    //   248: aload_0
    //   249: getfield 484	axsi:jdField_b_of_type_Axow	Laxow;
    //   252: invokevirtual 370	axsi:a	(ILjava/lang/String;Ljava/lang/String;Laxow;)V
    //   255: aload_0
    //   256: invokevirtual 372	axsi:d	()V
    //   259: return
    //   260: astore 8
    //   262: ldc_w 882
    //   265: istore_2
    //   266: goto -139 -> 127
    //   269: ldc_w 862
    //   272: istore_2
    //   273: goto -146 -> 127
    //   276: iconst_0
    //   277: istore_3
    //   278: goto -138 -> 140
    //   281: aload_0
    //   282: iload_2
    //   283: ldc_w 884
    //   286: invokevirtual 309	axsi:b	(ILjava/lang/String;)V
    //   289: aload_0
    //   290: invokevirtual 372	axsi:d	()V
    //   293: return
    //   294: aload_0
    //   295: aload_0
    //   296: getfield 484	axsi:jdField_b_of_type_Axow	Laxow;
    //   299: aload_1
    //   300: iconst_0
    //   301: invokevirtual 865	axsi:a	(Laxow;Laxsq;Z)V
    //   304: aload_0
    //   305: aload_1
    //   306: getfield 851	axsq:jdField_b_of_type_Int	I
    //   309: aload_1
    //   310: getfield 854	axsq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   313: invokevirtual 309	axsi:b	(ILjava/lang/String;)V
    //   316: aload_0
    //   317: invokevirtual 372	axsi:d	()V
    //   320: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	axsi
    //   0	321	1	paramaxsq	axsq
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axsi
 * JD-Core Version:    0.7.0.1
 */