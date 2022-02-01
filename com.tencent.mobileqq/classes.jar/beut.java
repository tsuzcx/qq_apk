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

public class beut
  extends berj
  implements beup
{
  String[] a;
  String e;
  
  public beut(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
  }
  
  private cmd0x346.ReqBody a()
  {
    int j = 17;
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString));
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
    bevx localbevx;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = a();
      localbevx = new bevx();
      localbevx.jdField_a_of_type_JavaLangString = str;
      localbevx.jdField_a_of_type_ArrayOfByte = localReqBody.toByteArray();
      localbevx.c = 1;
      localbevx.jdField_a_of_type_Int = 30000;
      localbevx.jdField_b_of_type_Int = 1;
      localbevx.jdField_a_of_type_Bevw = this;
      if (e()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
      d();
      return;
      if ("ftn".equals(this.d)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localbevx);
  }
  
  public void a(bevl parambevl, bevm parambevm)
  {
    if ((parambevl == null) || (parambevm == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambevl instanceof beum));
      parambevl = (beum)parambevl;
      parambevl.jdField_a_of_type_Long += parambevm.c;
    } while (0L != parambevl.jdField_b_of_type_Long);
    parambevm.c = 0L;
    parambevm = "bytes=" + parambevl.jdField_a_of_type_Long + "-";
    parambevl.jdField_a_of_type_JavaUtilHashMap.put("Range", parambevm);
  }
  
  public void a(bevy parambevy, bevx parambevx)
  {
    a(null, parambevy.a, parambevy.a.getWupBuffer());
  }
  
  public void a(bfau parambfau, bfbj parambfbj)
  {
    this.jdField_a_of_type_Bfau = null;
    if (parambfbj != null)
    {
      int i = 0;
      while (i < parambfbj.jdField_a_of_type_JavaUtilList.size())
      {
        parambfau = (bfbm)parambfbj.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambfau.toString());
        }
        this.k = parambfau.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.k);
        }
        a(this.jdField_a_of_type_Berr, parambfau);
        if (parambfau.c == 0)
        {
          this.jdField_c_of_type_JavaLangString = parambfau.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Bete.i = this.jdField_c_of_type_JavaLangString;
          if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            parambfau = bews.a(this.jdField_c_of_type_JavaLangString);
            if (parambfau != null) {
              this.jdField_a_of_type_JavaUtilArrayList.add(parambfau);
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
    //   3: ldc_w 318
    //   6: invokevirtual 131	beut:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_2
    //   10: invokevirtual 321	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   13: sipush 1000
    //   16: if_icmpeq +38 -> 54
    //   19: aload_2
    //   20: invokevirtual 321	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   23: istore 4
    //   25: aload_0
    //   26: ldc_w 323
    //   29: new 196	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 325
    //   39: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokevirtual 131	beut:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: return
    //   54: new 330	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   57: dup
    //   58: invokespecial 331	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   61: astore_1
    //   62: aload_1
    //   63: aload_3
    //   64: invokevirtual 335	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: pop
    //   68: aload_1
    //   69: getfield 336	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   75: ifeq +91 -> 166
    //   78: aload_1
    //   79: getfield 336	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 341	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: i2l
    //   86: lstore 5
    //   88: lload 5
    //   90: ldc2_w 342
    //   93: lcmp
    //   94: ifne -41 -> 53
    //   97: aload_1
    //   98: getfield 347	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   101: invokevirtual 350	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   104: ifeq -51 -> 53
    //   107: aload_1
    //   108: getfield 347	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   111: invokevirtual 353	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   114: checkcast 349	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   117: getfield 357	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   120: invokevirtual 360	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   123: istore 4
    //   125: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq -75 -> 53
    //   131: aload_0
    //   132: ldc_w 323
    //   135: new 196	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 362
    //   145: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload 4
    //   150: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokevirtual 131	beut:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: return
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 365	java/lang/Exception:printStackTrace	()V
    //   165: return
    //   166: ldc2_w 366
    //   169: lstore 5
    //   171: goto -83 -> 88
    //   174: astore_1
    //   175: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	beut
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
  
  public void aN_()
  {
    super.aN_();
    d(2001);
    f();
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Beyg.toString());
    String str = this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bhmi.c(str)) || (str.startsWith("http://")))
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
    this.jdField_a_of_type_Berr.a();
    this.d = "pttcenter";
    b("findDbRec", "not found");
    bfau localbfau = new bfau();
    bfaw localbfaw = new bfaw();
    localbfaw.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString;
    localbfaw.d = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfaw.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Beyg.d;
    localbfaw.f = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbfaw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString;
    localbfaw.jdField_b_of_type_JavaLangString = this.d;
    localbfaw.jdField_a_of_type_Boolean = this.jdField_a_of_type_Beyg.jdField_c_of_type_Boolean;
    localbfaw.jdField_a_of_type_Int = 0;
    localbfaw.jdField_b_of_type_Int = 102;
    localbfau.jdField_a_of_type_Bfcb = this;
    localbfau.jdField_a_of_type_JavaLangString = "c2c_ptt_dw";
    localbfau.jdField_a_of_type_JavaUtilList.add(localbfaw);
    localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbfau.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bfau = localbfau;
    bfca.a(localbfau);
  }
  
  void g()
  {
    this.jdField_b_of_type_Berr.a();
    String str3 = a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
    berp.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = this;
    localbeum.jdField_a_of_type_JavaLangString = str3;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localbeum.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.h;
    localbeum.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    localbeum.f = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbeum.jdField_e_of_type_Int = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
    localbeum.jdField_a_of_type_Long = 0L;
    localbeum.l = true;
    localbeum.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localbeum.m = true;
    localbeum.jdField_a_of_type_Beup = this;
    localbeum.d = this.jdField_e_of_type_JavaLangString;
    String str2 = null;
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      str1 = str2;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        str1 = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    str2 = bews.a(str3);
    b("httpDown", "RespDomain: " + str2 + " ipList:" + str1 + " uuid:" + this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString + " downOffset:" + localbeum.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Bevl = localbeum;
    o();
    this.jdField_a_of_type_Beuo.a(localbeum);
  }
  
  protected void o()
  {
    if ((this.jdField_a_of_type_Bevl != null) && ((this.jdField_a_of_type_Bevl instanceof beum))) {
      ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCd", ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onResp(bevm parambevm)
  {
    boolean bool2 = true;
    super.onResp(parambevm);
    this.jdField_a_of_type_Bevl = null;
    Object localObject = new StringBuilder().append(" result:");
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      b("onHttpResp", bool1);
      localObject = this.jdField_b_of_type_Berr;
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label152;
      }
    }
    label152:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a((berr)localObject, parambevm, bool1);
      this.jdField_a_of_type_Long = parambevm.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambevm.jdField_b_of_type_Long + parambevm.jdField_a_of_type_Bevl.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambevm.c;
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label157;
      }
      tyl.d(this.jdField_a_of_type_Beyg.h);
      h();
      e();
      return;
      bool1 = false;
      break;
    }
    label157:
    if ((parambevm.jdField_b_of_type_Int == 9364) && (this.m < 3))
    {
      b("[netChg]", "failed.but net change detect.so retry");
      this.m += 1;
      n();
      f();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beut
 * JD-Core Version:    0.7.0.1
 */