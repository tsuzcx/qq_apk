import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;

public class bauk
  extends bara
  implements bauf
{
  String[] a;
  String e;
  
  public bauk(bayf parambayf, bayk parambayk)
  {
    super(parambayf, parambayk);
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
  }
  
  private cmd0x346.ReqBody a()
  {
    int j = 17;
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Bayk.e));
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(1000);
    localReqBody.uint32_seq.set(0);
    int i;
    if ("ftn".equals(this.d)) {
      i = 3;
    }
    for (;;)
    {
      localReqBody.uint32_business_id.set(i);
      localReqBody.uint32_client_type.set(104);
      localReqBody.msg_download_succ_req.set(localDownloadSuccReq);
      return localReqBody;
      i = j;
      if ("pttcenter".equals(this.d)) {
        i = j;
      }
    }
  }
  
  private void h()
  {
    b("setSuccess", "req");
    String str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    if ("pttcenter".equals(this.d)) {
      str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    }
    bavq localbavq;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = a();
      localbavq = new bavq();
      localbavq.jdField_a_of_type_JavaLangString = str;
      localbavq.jdField_a_of_type_ArrayOfByte = localReqBody.toByteArray();
      localbavq.c = 1;
      localbavq.jdField_a_of_type_Int = 30000;
      localbavq.jdField_b_of_type_Int = 1;
      localbavq.jdField_a_of_type_Bavp = this;
      if (e()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Barh);
      d();
      return;
      if ("ftn".equals(this.d)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localbavq);
  }
  
  public void a(bave parambave, bavf parambavf)
  {
    if ((parambave == null) || (parambavf == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambave instanceof baub));
      parambave = (baub)parambave;
      parambave.jdField_a_of_type_Long += parambavf.c;
    } while (0L != parambave.jdField_b_of_type_Long);
    parambavf.c = 0L;
    parambavf = "bytes=" + parambave.jdField_a_of_type_Long + "-";
    parambave.jdField_a_of_type_JavaUtilHashMap.put("Range", parambavf);
  }
  
  public void a(bavr parambavr, bavq parambavq)
  {
    a(null, parambavr.a, parambavr.a.getWupBuffer());
  }
  
  public void a(bbax parambbax, bbbm parambbbm)
  {
    this.jdField_a_of_type_Bbax = null;
    if (parambbbm != null)
    {
      int i = 0;
      while (i < parambbbm.jdField_a_of_type_JavaUtilList.size())
      {
        parambbax = (bbbp)parambbbm.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambbax.toString());
        }
        this.i = parambbax.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Barh, parambbax);
        if (parambbax.c == 0)
        {
          this.c = parambbax.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Bass.i = this.c;
          if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            parambbax = baws.a(this.c);
            if (parambbax != null) {
              this.jdField_a_of_type_JavaUtilArrayList.add(parambbax);
            }
          }
          g();
          i += 1;
        }
        else
        {
          d();
        }
      }
    }
  }
  
  /* Error */
  protected void a(com.tencent.qphone.base.remote.ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 126
    //   3: ldc_w 317
    //   6: invokevirtual 131	bauk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_2
    //   10: invokevirtual 320	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   13: sipush 1000
    //   16: if_icmpeq +38 -> 54
    //   19: aload_2
    //   20: invokevirtual 320	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   23: istore 4
    //   25: aload_0
    //   26: ldc_w 322
    //   29: new 196	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 324
    //   39: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 327	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokevirtual 131	bauk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: return
    //   54: new 329	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   57: dup
    //   58: invokespecial 330	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   61: astore_1
    //   62: aload_1
    //   63: aload_3
    //   64: invokevirtual 334	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: pop
    //   68: aload_1
    //   69: getfield 335	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: invokevirtual 338	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   75: ifeq +91 -> 166
    //   78: aload_1
    //   79: getfield 335	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 340	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: i2l
    //   86: lstore 5
    //   88: lload 5
    //   90: ldc2_w 341
    //   93: lcmp
    //   94: ifne -41 -> 53
    //   97: aload_1
    //   98: getfield 346	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   101: invokevirtual 349	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   104: ifeq -51 -> 53
    //   107: aload_1
    //   108: getfield 346	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   111: invokevirtual 352	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   114: checkcast 348	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   117: getfield 356	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   120: invokevirtual 359	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   123: istore 4
    //   125: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq -75 -> 53
    //   131: aload_0
    //   132: ldc_w 322
    //   135: new 196	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 361
    //   145: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload 4
    //   150: invokevirtual 327	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokevirtual 131	bauk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: return
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 364	java/lang/Exception:printStackTrace	()V
    //   165: return
    //   166: ldc2_w 365
    //   169: lstore 5
    //   171: goto -83 -> 88
    //   174: astore_1
    //   175: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	bauk
    //   0	176	1	paramToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   0	176	2	paramFromServiceMsg	FromServiceMsg
    //   0	176	3	paramArrayOfByte	byte[]
    //   23	126	4	i	int
    //   86	84	5	l	long
    // Exception table:
    //   from	to	target	type
    //   54	62	160	java/lang/Exception
    //   68	88	160	java/lang/Exception
    //   97	159	160	java/lang/Exception
    //   62	68	174	java/lang/Exception
  }
  
  public void aP_()
  {
    super.aP_();
    d(2001);
    f();
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Bayk.toString());
    String str = this.jdField_a_of_type_Bayk.e;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bdhb.c(str)) || (str.startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      return -1;
    }
    return 0;
  }
  
  void d()
  {
    super.d();
    d(2005);
  }
  
  void e()
  {
    super.e();
    d(2003);
  }
  
  void f()
  {
    this.jdField_a_of_type_Barh.a();
    this.d = "pttcenter";
    b("findDbRec", "not found");
    bbax localbbax = new bbax();
    bbaz localbbaz = new bbaz();
    localbbaz.c = this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString;
    localbbaz.d = this.jdField_a_of_type_Bayk.c;
    localbbaz.e = this.jdField_a_of_type_Bayk.d;
    localbbaz.f = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
    localbbaz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bayk.e;
    localbbaz.jdField_b_of_type_JavaLangString = this.d;
    localbbaz.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bayk.jdField_b_of_type_Boolean;
    localbbaz.jdField_a_of_type_Int = 0;
    localbbaz.jdField_b_of_type_Int = 102;
    localbbax.jdField_a_of_type_Bbce = this;
    localbbax.jdField_a_of_type_JavaLangString = "c2c_ptt_dw";
    localbbax.jdField_a_of_type_JavaUtilList.add(localbbaz);
    localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Barh);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbbax.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bbax = localbbax;
    bbcd.a(localbbax);
  }
  
  void g()
  {
    this.jdField_b_of_type_Barh.a();
    String str3 = a(this.c, this.jdField_a_of_type_JavaUtilArrayList);
    barf.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = this;
    localbaub.jdField_a_of_type_JavaLangString = str3;
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localbaub.c = this.jdField_a_of_type_Bayk.h;
    localbaub.e = String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    localbaub.g = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
    localbaub.f = this.jdField_a_of_type_Bayk.jdField_b_of_type_Int;
    localbaub.jdField_a_of_type_Long = 0L;
    localbaub.k = true;
    localbaub.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localbaub.l = true;
    localbaub.jdField_a_of_type_Bauf = this;
    localbaub.d = this.e;
    String str2 = null;
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      str1 = str2;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        str1 = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    str2 = baws.a(str3);
    b("httpDown", "RespDomain: " + str2 + " ipList:" + str1 + " uuid:" + this.jdField_a_of_type_Bayk.e + " downOffset:" + localbaub.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Bave = localbaub;
    n();
    this.jdField_a_of_type_Baue.a(localbaub);
  }
  
  protected void n()
  {
    if ((this.jdField_a_of_type_Bave != null) && ((this.jdField_a_of_type_Bave instanceof baub))) {
      ((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCd", ((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onResp(bavf parambavf)
  {
    boolean bool2 = true;
    super.onResp(parambavf);
    this.jdField_a_of_type_Bave = null;
    Object localObject = new StringBuilder().append(" result:");
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      b("onHttpResp", bool1);
      localObject = this.jdField_b_of_type_Barh;
      if (parambavf.jdField_a_of_type_Int != 0) {
        break label152;
      }
    }
    label152:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a((barh)localObject, parambavf, bool1);
      this.jdField_a_of_type_Long = parambavf.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambavf.jdField_b_of_type_Long + parambavf.jdField_a_of_type_Bave.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambavf.c;
      if (parambavf.jdField_a_of_type_Int != 0) {
        break label157;
      }
      sxb.d(this.jdField_a_of_type_Bayk.h);
      h();
      e();
      return;
      bool1 = false;
      break;
    }
    label157:
    if ((parambavf.jdField_b_of_type_Int == 9364) && (this.l < 3))
    {
      b("[netChg]", "failed.but net change detect.so retry");
      this.l += 1;
      m();
      f();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bauk
 * JD-Core Version:    0.7.0.1
 */