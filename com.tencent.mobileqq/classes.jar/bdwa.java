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

public class bdwa
  extends bdsr
  implements bdvv
{
  String[] a;
  String e;
  
  public bdwa(bdzi parambdzi, bdzn parambdzn)
  {
    super(parambdzi, parambdzn);
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
  }
  
  private cmd0x346.ReqBody a()
  {
    int j = 17;
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString));
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
    bdxe localbdxe;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = a();
      localbdxe = new bdxe();
      localbdxe.jdField_a_of_type_JavaLangString = str;
      localbdxe.jdField_a_of_type_ArrayOfByte = localReqBody.toByteArray();
      localbdxe.c = 1;
      localbdxe.jdField_a_of_type_Int = 30000;
      localbdxe.jdField_b_of_type_Int = 1;
      localbdxe.jdField_a_of_type_Bdxd = this;
      if (e()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Bdsz);
      d();
      return;
      if ("ftn".equals(this.d)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localbdxe);
  }
  
  public void a(bdws parambdws, bdwt parambdwt)
  {
    if ((parambdws == null) || (parambdwt == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambdws instanceof bdvs));
      parambdws = (bdvs)parambdws;
      parambdws.jdField_a_of_type_Long += parambdwt.c;
    } while (0L != parambdws.jdField_b_of_type_Long);
    parambdwt.c = 0L;
    parambdwt = "bytes=" + parambdws.jdField_a_of_type_Long + "-";
    parambdws.jdField_a_of_type_JavaUtilHashMap.put("Range", parambdwt);
  }
  
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    a(null, parambdxf.a, parambdxf.a.getWupBuffer());
  }
  
  public void a(bebv parambebv, beck parambeck)
  {
    this.jdField_a_of_type_Bebv = null;
    if (parambeck != null)
    {
      int i = 0;
      while (i < parambeck.jdField_a_of_type_JavaUtilList.size())
      {
        parambebv = (becn)parambeck.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambebv.toString());
        }
        this.k = parambebv.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.k);
        }
        a(this.jdField_a_of_type_Bdsz, parambebv);
        if (parambebv.c == 0)
        {
          this.c = parambebv.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Bduk.i = this.c;
          if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            parambebv = bdxz.a(this.c);
            if (parambebv != null) {
              this.jdField_a_of_type_JavaUtilArrayList.add(parambebv);
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
    //   6: invokevirtual 131	bdwa:b	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   50: invokevirtual 131	bdwa:b	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   156: invokevirtual 131	bdwa:b	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	176	0	this	bdwa
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
    b("uiParam", this.jdField_a_of_type_Bdzn.toString());
    String str = this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bgmg.c(str)) || (str.startsWith("http://")))
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
    this.jdField_a_of_type_Bdsz.a();
    this.d = "pttcenter";
    b("findDbRec", "not found");
    bebv localbebv = new bebv();
    bebx localbebx = new bebx();
    localbebx.c = this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString;
    localbebx.d = this.jdField_a_of_type_Bdzn.c;
    localbebx.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.d;
    localbebx.f = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    localbebx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString;
    localbebx.jdField_b_of_type_JavaLangString = this.d;
    localbebx.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Boolean;
    localbebx.jdField_a_of_type_Int = 0;
    localbebx.jdField_b_of_type_Int = 102;
    localbebv.jdField_a_of_type_Bedc = this;
    localbebv.jdField_a_of_type_JavaLangString = "c2c_ptt_dw";
    localbebv.jdField_a_of_type_JavaUtilList.add(localbebx);
    localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Bdsz);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbebv.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bebv = localbebv;
    bedb.a(localbebv);
  }
  
  void g()
  {
    this.jdField_b_of_type_Bdsz.a();
    String str3 = a(this.c, this.jdField_a_of_type_JavaUtilArrayList);
    bdsx.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = this;
    localbdvs.jdField_a_of_type_JavaLangString = str3;
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localbdvs.c = this.jdField_a_of_type_Bdzn.h;
    localbdvs.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
    localbdvs.f = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    localbdvs.jdField_e_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int;
    localbdvs.jdField_a_of_type_Long = 0L;
    localbdvs.l = true;
    localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localbdvs.m = true;
    localbdvs.jdField_a_of_type_Bdvv = this;
    localbdvs.d = this.jdField_e_of_type_JavaLangString;
    String str2 = null;
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      str1 = str2;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        str1 = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    str2 = bdxz.a(str3);
    b("httpDown", "RespDomain: " + str2 + " ipList:" + str1 + " uuid:" + this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString + " downOffset:" + localbdvs.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Bdws = localbdvs;
    o();
    this.jdField_a_of_type_Bdvu.a(localbdvs);
  }
  
  protected void o()
  {
    if ((this.jdField_a_of_type_Bdws != null) && ((this.jdField_a_of_type_Bdws instanceof bdvs))) {
      ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCd", ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onResp(bdwt parambdwt)
  {
    boolean bool2 = true;
    super.onResp(parambdwt);
    this.jdField_a_of_type_Bdws = null;
    Object localObject = new StringBuilder().append(" result:");
    if (parambdwt.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      b("onHttpResp", bool1);
      localObject = this.jdField_b_of_type_Bdsz;
      if (parambdwt.jdField_a_of_type_Int != 0) {
        break label152;
      }
    }
    label152:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a((bdsz)localObject, parambdwt, bool1);
      this.jdField_a_of_type_Long = parambdwt.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambdwt.jdField_b_of_type_Long + parambdwt.jdField_a_of_type_Bdws.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambdwt.c;
      if (parambdwt.jdField_a_of_type_Int != 0) {
        break label157;
      }
      tyj.d(this.jdField_a_of_type_Bdzn.h);
      h();
      e();
      return;
      bool1 = false;
      break;
    }
    label157:
    if ((parambdwt.jdField_b_of_type_Int == 9364) && (this.l < 3))
    {
      b("[netChg]", "failed.but net change detect.so retry");
      this.l += 1;
      n();
      f();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwa
 * JD-Core Version:    0.7.0.1
 */