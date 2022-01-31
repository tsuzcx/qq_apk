import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class aypi
  extends ayov
{
  public aypi() {}
  
  public aypi(ayvv paramayvv, aywa paramaywa)
  {
    super(paramayvv, paramaywa);
    this.jdField_a_of_type_Ayqm.jdField_b_of_type_Int = this.jdField_a_of_type_Aywa.jdField_b_of_type_Int;
    this.jdField_a_of_type_Ayqm.jdField_b_of_type_Long = this.jdField_a_of_type_Aywa.jdField_a_of_type_Long;
    this.jdField_a_of_type_Ayqm.jdField_c_of_type_Long = this.jdField_a_of_type_Aywa.jdField_b_of_type_Long;
  }
  
  public void a(ayyn paramayyn, ayzc paramayzc)
  {
    this.jdField_a_of_type_Ayyn = null;
    if (paramayzc != null)
    {
      int i = 0;
      if (i < paramayzc.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyn = (ayzo)paramayzc.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramayyn.toString());
        }
        this.i = paramayyn.jdField_d_of_type_Boolean;
        a(this.jdField_a_of_type_Aypb, paramayyn);
        if (paramayyn.jdField_c_of_type_Int == 0)
        {
          if ((g()) && (paramayyn.jdField_b_of_type_JavaUtilArrayList.size() > 0))
          {
            this.jdField_a_of_type_JavaUtilArrayList = paramayyn.jdField_b_of_type_JavaUtilArrayList;
            if (h()) {
              this.jdField_a_of_type_JavaUtilArrayList.addAll(paramayyn.jdField_a_of_type_JavaUtilArrayList);
            }
            label122:
            this.jdField_b_of_type_JavaLangString = paramayyn.jdField_b_of_type_JavaLangString;
            this.jdField_a_of_type_JavaLangString = paramayyn.jdField_a_of_type_JavaLangString;
            if (QLog.isColorLevel()) {
              b("proUrl", "picResp.protocolType = " + paramayyn.jdField_a_of_type_Int);
            }
            if (paramayyn.jdField_a_of_type_Int != 1) {
              break label208;
            }
            this.jdField_g_of_type_Boolean = true;
            c(true);
          }
          for (;;)
          {
            i += 1;
            break;
            this.jdField_a_of_type_JavaUtilArrayList = paramayyn.jdField_a_of_type_JavaUtilArrayList;
            break label122;
            label208:
            this.jdField_g_of_type_Boolean = false;
            c(false);
          }
        }
        d();
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (!paramBoolean)
    {
      localObject1 = "Q.richmedia." + ayui.b(this.jdField_a_of_type_Aywa.jdField_a_of_type_Int) + "." + ayui.a(this.jdField_a_of_type_Aywa.jdField_b_of_type_Int);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.jdField_a_of_type_Aywa.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.jdField_j_of_type_Int + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.jdField_j_of_type_JavaLangString);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (!this.jdField_a_of_type_Aywa.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Aywa.jdField_e_of_type_Int == 1030) || ((!paramBoolean) && (ayua.b(this.jdField_j_of_type_Int))) || (this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      l1 = (System.nanoTime() - this.k) / 1000000L;
      localObject1 = this.jdField_d_of_type_Aypb.a(1) + ";" + this.jdField_a_of_type_Aypb.a(2) + ";" + this.jdField_b_of_type_Aypb.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Aywa.jdField_g_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Aywa.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.i));
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      long l2 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_Aywd != null) {
        break label899;
      }
      i = 0;
      label451:
      ((HashMap)localObject1).put("param_recvDataLen", String.valueOf(l2 - i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailCode", String.valueOf(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailDesc", "" + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_inQueueCost", "" + this.p);
      this.jdField_a_of_type_JavaUtilHashMap.put("ipFromDns", "" + this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_encryptRollback", "" + this.jdField_f_of_type_Boolean + ",decryptErrorMsg:" + this.jdField_f_of_type_JavaLangString);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_f_of_type_Boolean) {
        break label910;
      }
      localObject1 = "1";
      label651:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_g_of_type_Boolean) {
        break label918;
      }
      localObject1 = "1";
      label680:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.jdField_a_of_type_Aysw != null) && (((ayrv)this.jdField_a_of_type_Aysw).jdField_a_of_type_Ayrx != null))
      {
        localObject1 = (ayrv)this.jdField_a_of_type_Aysw;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((ayrv)localObject1).jdField_a_of_type_Ayrx).jdField_a_of_type_Long));
      }
      localObject2 = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      f(paramBoolean);
      if (!paramBoolean) {
        break label926;
      }
      axrl.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      b(paramBoolean, l1);
      l();
      super.a(paramBoolean, "C2CPicDownloadErrorCode", l1, this.jdField_a_of_type_JavaUtilHashMap);
      return;
      i = 1;
      break;
      label899:
      i = this.jdField_a_of_type_Aywd.jdField_a_of_type_Int;
      break label451;
      label910:
      localObject1 = "0";
      break label651;
      label918:
      localObject1 = "0";
      break label680;
      label926:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      axrl.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.jdField_a_of_type_Aywa.m) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x1) != 0);
  }
  
  public void aR_()
  {
    super.aR_();
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (!a()))
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      b(true);
      return;
    }
    try
    {
      a("c2cpicdw.qpic.cn", 1004);
      return;
    }
    catch (Exception localException)
    {
      b("reportFailed", aypt.a(localException));
    }
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_Aywa.jdField_b_of_type_Int == 65537) {
      return "actC2CPicSmallDownV1";
    }
    return "actC2CPicDownloadV1";
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aypb.a();
    this.jdField_a_of_type_Boolean = false;
    ayyn localayyn = new ayyn();
    ayyo localayyo = new ayyo();
    localayyo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_b_of_type_JavaLangString;
    localayyo.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString;
    localayyo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_d_of_type_JavaLangString;
    localayyo.jdField_f_of_type_Int = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
    localayyo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString;
    localayyo.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Aywa.jdField_d_of_type_Long);
    MessageRecord localMessageRecord2 = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    MessageRecord localMessageRecord1 = localMessageRecord2;
    if (localMessageRecord2 == null) {
      localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
    }
    boolean bool;
    if ((localMessageRecord1 != null) && ((localMessageRecord1 instanceof MessageForPic)))
    {
      this.jdField_d_of_type_JavaLangString = ((MessageForPic)localMessageRecord1).serverStoreSource;
      localayyo.jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localayyo.jdField_a_of_type_Int = this.jdField_a_of_type_Aywa.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Int != 1006) {
        break label312;
      }
      bool = true;
      label210:
      localayyo.jdField_a_of_type_Boolean = bool;
      if (!paramBoolean) {
        break label317;
      }
      localayyo.jdField_c_of_type_Int = 0;
      label226:
      localayyn.jdField_a_of_type_Ayzu = this;
      localayyn.jdField_a_of_type_JavaLangString = "c2c_pic_dw";
      localayyn.jdField_a_of_type_JavaUtilList.add(localayyo);
      localayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label326;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypb);
      d();
    }
    label312:
    label317:
    label326:
    do
    {
      return;
      this.jdField_d_of_type_JavaLangString = "picplatform";
      b("findDbRec", "not found");
      break;
      bool = false;
      break label210;
      localayyo.jdField_c_of_type_Int = 1;
      break label226;
      if (QLog.isColorLevel()) {
        b("requestStart", localayyn.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Ayyn = localayyn;
    ayzt.a(localayyn);
  }
  
  public int c()
  {
    b("uiParam", this.jdField_a_of_type_Aywa.toString());
    String str = this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bbdj.c(str)) || (str.startsWith("http")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaIoOutputStream == null) && (this.jdField_a_of_type_Aywa.jdField_c_of_type_Boolean))
    {
      b(9302, a(new Exception("no output stream")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject instanceof aywd)))
    {
      b(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_Aywd = ((aywd)this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Aywd.jdField_a_of_type_Int;
    return 0;
  }
  
  void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Aypb.a();
    if (this.o) {
      return;
    }
    ayrv localayrv = new ayrv();
    Object localObject1;
    label32:
    label81:
    Object localObject2;
    label164:
    label205:
    int i;
    if (paramBoolean)
    {
      localObject1 = "https://";
      if (!this.jdField_j_of_type_Boolean) {
        break label725;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localayrv.jdField_g_of_type_Boolean = false;
      localayrv.jdField_b_of_type_JavaLangString = "c2cpicdw.qpic.cn";
      localObject1 = (String)localObject1 + "c2cpicdw.qpic.cn";
      localObject1 = a((String)localObject1 + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_g_of_type_Int);
      localayrv.jdField_a_of_type_Aysa = this;
      localayrv.jdField_a_of_type_Aysb = this;
      localayrv.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localayrv.jdField_f_of_type_Boolean = paramBoolean;
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label940;
      }
      localayrv.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localayrv.jdField_a_of_type_Int = 0;
      localObject2 = new ayuo();
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label951;
      }
      ((ayuo)localObject2).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((ayuo)localObject2).b = true;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      localayrv.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      localayrv.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywa.h;
      if (this.jdField_a_of_type_Aywa.jdField_c_of_type_Boolean) {
        localayrv.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaIoOutputStream;
      }
      localayrv.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
      localayrv.jdField_g_of_type_Int = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
      localayrv.jdField_f_of_type_Int = this.jdField_a_of_type_Aywa.jdField_b_of_type_Int;
      localayrv.jdField_a_of_type_Long = 0L;
      localayrv.k = true;
      i = a(this.jdField_a_of_type_Aywa);
      if (i != 4) {
        break label962;
      }
      localayrv.jdField_a_of_type_Long = this.jdField_a_of_type_Aywa.i;
      localayrv.jdField_b_of_type_Long = 0L;
      localayrv.jdField_j_of_type_Boolean = false;
      localObject2 = "bytes=" + this.jdField_a_of_type_Aywa.i + "-";
      localayrv.jdField_a_of_type_JavaUtilHashMap.put("Range", localObject2);
    }
    for (;;)
    {
      a(localayrv, (String)localObject1);
      localayrv.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localayrv.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCd");
      localayrv.jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
      localayrv.jdField_a_of_type_Ayrz = jdField_a_of_type_Ayrz;
      localayrv.jdField_e_of_type_Int = this.jdField_a_of_type_Aywa.jdField_f_of_type_Int;
      if (this.jdField_a_of_type_Ayue != null) {
        localayrv.jdField_a_of_type_Ayug = this.jdField_a_of_type_Ayue.a();
      }
      localayrv.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
      localayrv.l = true;
      localayrv.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_Boolean) {
        localayrv.jdField_c_of_type_Long = 0L;
      }
      localObject2 = null;
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          localObject1 = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
        }
      }
      b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + (String)localObject1 + " uniSeq:" + localayrv.jdField_e_of_type_JavaLangString + " uuid:" + this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString + ",downOffset:" + localayrv.jdField_a_of_type_Long + ",isEncryptUrl:" + this.jdField_e_of_type_Boolean + ",isEncryptPic:" + this.jdField_d_of_type_Boolean + ",isEncryptRollbackReq:" + this.jdField_f_of_type_Boolean);
      if (!f()) {
        break;
      }
      this.jdField_a_of_type_Aysw = localayrv;
      this.jdField_a_of_type_Ayry.a(localayrv);
      return;
      localObject1 = "http://";
      break label32;
      label725:
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localayrv.jdField_g_of_type_Boolean = true;
        ayuo localayuo = (ayuo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((localayuo.jdField_a_of_type_Boolean) && (!localayuo.jdField_a_of_type_JavaLangString.startsWith("["))) {}
        for (localObject2 = (String)localObject1 + "[" + localayuo.jdField_a_of_type_JavaLangString + "]";; localObject2 = (String)localObject1 + localayuo.jdField_a_of_type_JavaLangString)
        {
          localObject1 = localObject2;
          if (localayuo.jdField_a_of_type_Int == 80) {
            break;
          }
          localObject1 = (String)localObject2 + ":" + localayuo.jdField_a_of_type_Int;
          break;
        }
      }
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break;
      }
      localayrv.jdField_g_of_type_Boolean = false;
      localObject1 = (String)localObject1 + this.jdField_b_of_type_JavaLangString;
      break label81;
      label940:
      localayrv.jdField_b_of_type_JavaLangString = "c2cpicdw.qpic.cn";
      break label164;
      label951:
      ((ayuo)localObject2).jdField_a_of_type_JavaLangString = "c2cpicdw.qpic.cn";
      break label205;
      label962:
      if ((i == 3) || (i == 2))
      {
        localayrv.jdField_a_of_type_Long = this.jdField_a_of_type_Aywa.i;
        localayrv.jdField_b_of_type_Long = (this.jdField_a_of_type_Aywa.i + this.jdField_a_of_type_Aywa.jdField_j_of_type_Int - 1);
        localayrv.jdField_j_of_type_Boolean = false;
        localObject2 = "bytes=" + this.jdField_a_of_type_Aywa.i + "-" + localayrv.jdField_b_of_type_Long;
        localayrv.jdField_a_of_type_JavaUtilHashMap.put("Range", localObject2);
      }
      else
      {
        localayrv.jdField_b_of_type_Long = 0L;
        localayrv.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localayrv.jdField_a_of_type_Long + "-");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aypi
 * JD-Core Version:    0.7.0.1
 */