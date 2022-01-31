import com.tencent.image.Utils;
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

public class aytd
  extends ayow
  implements aysb
{
  String e;
  
  public aytd(ayvx paramayvx, aywc paramaywc)
  {
    super(paramayvx, paramaywc);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return bbvj.a(ajsd.aW + Utils.Crc64String(paramQQAppInterface.getAccount()) + "/" + "ptt" + "/pa_audio_" + paramString + ".amr");
  }
  
  private cmd0x346.ReqBody a()
  {
    int j = 17;
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Aywc.e));
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
    aytk localaytk;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = a();
      localaytk = new aytk();
      localaytk.jdField_a_of_type_JavaLangString = str;
      localaytk.jdField_a_of_type_ArrayOfByte = localReqBody.toByteArray();
      localaytk.c = 1;
      localaytk.jdField_a_of_type_Int = 30000;
      localaytk.jdField_b_of_type_Int = 1;
      localaytk.jdField_a_of_type_Aytj = this;
      if (e()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypd);
      d();
      return;
      if ("ftn".equals(this.d)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localaytk);
  }
  
  public void a(aysy paramaysy, aysz paramaysz)
  {
    if ((paramaysy == null) || (paramaysz == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramaysy instanceof ayrx));
      paramaysy = (ayrx)paramaysy;
      paramaysy.jdField_a_of_type_Long += paramaysz.c;
    } while (0L != paramaysy.jdField_b_of_type_Long);
    paramaysz.c = 0L;
    paramaysz = "bytes=" + paramaysy.jdField_a_of_type_Long + "-";
    paramaysy.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysz);
  }
  
  public void a(aytl paramaytl, aytk paramaytk)
  {
    a(null, paramaytl.a, paramaytl.a.getWupBuffer());
  }
  
  public void a(ayyp paramayyp, ayze paramayze)
  {
    this.jdField_a_of_type_Ayyp = null;
    if (paramayze != null)
    {
      int i = 0;
      while (i < paramayze.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyp = (ayzh)paramayze.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramayyp.toString());
        }
        this.i = paramayyp.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Aypd, paramayyp);
        if (paramayyp.c == 0)
        {
          this.c = paramayyp.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Ayqo.i = this.c;
          if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            paramayyp = ayuk.a(this.c);
            if (paramayyp != null) {
              this.jdField_a_of_type_JavaUtilArrayList.add(paramayyp);
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
    //   1: ldc 161
    //   3: ldc_w 341
    //   6: invokevirtual 166	aytd:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_2
    //   10: invokevirtual 344	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   13: sipush 1000
    //   16: if_icmpeq +38 -> 54
    //   19: aload_2
    //   20: invokevirtual 344	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   23: istore 4
    //   25: aload_0
    //   26: ldc_w 346
    //   29: new 35	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 348
    //   39: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 351	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokevirtual 166	aytd:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: return
    //   54: new 353	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   57: dup
    //   58: invokespecial 354	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   61: astore_1
    //   62: aload_1
    //   63: aload_3
    //   64: invokevirtual 358	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: pop
    //   68: aload_1
    //   69: getfield 359	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: invokevirtual 362	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   75: ifeq +91 -> 166
    //   78: aload_1
    //   79: getfield 359	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 364	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: i2l
    //   86: lstore 5
    //   88: lload 5
    //   90: ldc2_w 365
    //   93: lcmp
    //   94: ifne -41 -> 53
    //   97: aload_1
    //   98: getfield 370	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   101: invokevirtual 373	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   104: ifeq -51 -> 53
    //   107: aload_1
    //   108: getfield 370	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   111: invokevirtual 376	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   114: checkcast 372	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   117: getfield 380	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   120: invokevirtual 383	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   123: istore 4
    //   125: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq -75 -> 53
    //   131: aload_0
    //   132: ldc_w 346
    //   135: new 35	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 385
    //   145: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload 4
    //   150: invokevirtual 351	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokevirtual 166	aytd:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: return
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 388	java/lang/Exception:printStackTrace	()V
    //   165: return
    //   166: ldc2_w 389
    //   169: lstore 5
    //   171: goto -83 -> 88
    //   174: astore_1
    //   175: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	aytd
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
  
  public void aR_()
  {
    super.aR_();
    f();
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Aywc.toString());
    String str = this.jdField_a_of_type_Aywc.e;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bbdx.c(str)) || (str.startsWith("http://")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      return -1;
    }
    this.jdField_a_of_type_Aywc.h = bbvj.a(ajsd.aW + Utils.Crc64String(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()) + "/" + "ptt" + "/pa_audio_" + str + ".amr");
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
    this.jdField_a_of_type_Aypd.a();
    this.d = "pttcenter";
    b("findDbRec", "not found");
    ayyp localayyp = new ayyp();
    ayyr localayyr = new ayyr();
    localayyr.c = this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString;
    localayyr.d = this.jdField_a_of_type_Aywc.c;
    localayyr.e = this.jdField_a_of_type_Aywc.d;
    localayyr.f = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
    localayyr.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aywc.e;
    localayyr.jdField_b_of_type_JavaLangString = this.d;
    localayyr.jdField_a_of_type_Boolean = this.jdField_a_of_type_Aywc.jdField_b_of_type_Boolean;
    localayyr.jdField_a_of_type_Int = 0;
    localayyr.jdField_b_of_type_Int = 3;
    localayyp.jdField_a_of_type_Ayzw = this;
    localayyp.jdField_a_of_type_JavaLangString = "c2c_ptt_dw";
    localayyp.jdField_a_of_type_JavaUtilList.add(localayyr);
    localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypd);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localayyp.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Ayyp = localayyp;
    ayzv.a(localayyp);
  }
  
  void g()
  {
    this.jdField_b_of_type_Aypd.a();
    String str3 = a(this.c, this.jdField_a_of_type_JavaUtilArrayList);
    aypb.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_Aysc = this;
    localayrx.jdField_a_of_type_JavaLangString = str3;
    localayrx.jdField_a_of_type_Int = 0;
    localayrx.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localayrx.c = this.jdField_a_of_type_Aywc.h;
    localayrx.e = String.valueOf(this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
    localayrx.g = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
    localayrx.f = this.jdField_a_of_type_Aywc.jdField_b_of_type_Int;
    localayrx.jdField_a_of_type_Long = 0L;
    localayrx.k = true;
    localayrx.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localayrx.l = true;
    localayrx.jdField_a_of_type_Aysb = this;
    localayrx.d = this.e;
    String str2 = null;
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      str1 = str2;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        str1 = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    str2 = ayuk.a(str3);
    b("httpDown", "RespDomain: " + str2 + " ipList:" + str1 + " uuid:" + this.jdField_a_of_type_Aywc.e + " downOffset:" + localayrx.jdField_a_of_type_Long);
    if (!f()) {
      return;
    }
    this.jdField_a_of_type_Aysy = localayrx;
    n();
    this.jdField_a_of_type_Aysa.a(localayrx);
  }
  
  protected void n()
  {
    if ((this.jdField_a_of_type_Aysy != null) && ((this.jdField_a_of_type_Aysy instanceof ayrx))) {
      ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCd", ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onResp(aysz paramaysz)
  {
    boolean bool2 = true;
    super.onResp(paramaysz);
    this.jdField_a_of_type_Aysy = null;
    Object localObject = new StringBuilder().append(" result:");
    if (paramaysz.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      b("onHttpResp", bool1);
      localObject = this.jdField_b_of_type_Aypd;
      if (paramaysz.jdField_a_of_type_Int != 0) {
        break label142;
      }
    }
    label142:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a((aypd)localObject, paramaysz, bool1);
      this.jdField_a_of_type_Long = paramaysz.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramaysz.jdField_b_of_type_Long + paramaysz.jdField_a_of_type_Aysy.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += paramaysz.c;
      if (paramaysz.jdField_a_of_type_Int != 0) {
        break label147;
      }
      h();
      e();
      return;
      bool1 = false;
      break;
    }
    label147:
    if ((paramaysz.jdField_b_of_type_Int == 9364) && (this.l < 3))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aytd
 * JD-Core Version:    0.7.0.1
 */