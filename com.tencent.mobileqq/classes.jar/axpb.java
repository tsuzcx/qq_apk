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

public class axpb
  extends axop
{
  public axpb(axvo paramaxvo, axvt paramaxvt)
  {
    super(paramaxvo, paramaxvt);
    this.jdField_a_of_type_Axqf.jdField_b_of_type_Int = this.jdField_a_of_type_Axvt.jdField_b_of_type_Int;
    this.jdField_a_of_type_Axqf.jdField_b_of_type_Long = this.jdField_a_of_type_Axvt.jdField_a_of_type_Long;
    this.jdField_a_of_type_Axqf.jdField_c_of_type_Long = this.jdField_a_of_type_Axvt.jdField_b_of_type_Long;
  }
  
  public void a(axyg paramaxyg, axyv paramaxyv)
  {
    this.jdField_a_of_type_Axyg = null;
    if (paramaxyv != null)
    {
      int i = 0;
      if (i < paramaxyv.jdField_a_of_type_JavaUtilList.size())
      {
        paramaxyg = (axzh)paramaxyv.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramaxyg.toString());
        }
        this.jdField_i_of_type_Boolean = paramaxyg.jdField_d_of_type_Boolean;
        a(this.jdField_a_of_type_Axow, paramaxyg);
        if (paramaxyg.jdField_c_of_type_Int == 0)
        {
          if ((g()) && (paramaxyg.jdField_b_of_type_JavaUtilArrayList.size() > 0))
          {
            this.jdField_a_of_type_JavaUtilArrayList = paramaxyg.jdField_b_of_type_JavaUtilArrayList;
            if (h()) {
              this.jdField_a_of_type_JavaUtilArrayList.addAll(paramaxyg.jdField_a_of_type_JavaUtilArrayList);
            }
            label122:
            this.jdField_b_of_type_JavaLangString = paramaxyg.jdField_b_of_type_JavaLangString;
            this.jdField_a_of_type_JavaLangString = paramaxyg.jdField_a_of_type_JavaLangString;
            if (QLog.isColorLevel()) {
              b("proUrl", "picResp.protocolType = " + paramaxyg.jdField_a_of_type_Int);
            }
            if (paramaxyg.jdField_a_of_type_Int != 1) {
              break label208;
            }
            this.jdField_g_of_type_Boolean = true;
            c(true);
          }
          for (;;)
          {
            i += 1;
            break;
            this.jdField_a_of_type_JavaUtilArrayList = paramaxyg.jdField_a_of_type_JavaUtilArrayList;
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
      localObject1 = "Q.richmedia." + axub.b(this.jdField_a_of_type_Axvt.jdField_a_of_type_Int) + "." + axub.a(this.jdField_a_of_type_Axvt.jdField_b_of_type_Int);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.jdField_a_of_type_Axvt.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.jdField_j_of_type_Int + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.jdField_i_of_type_JavaLangString);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (!this.jdField_a_of_type_Axvt.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Axvt.jdField_e_of_type_Int == 1030) || ((!paramBoolean) && (axtt.b(this.jdField_j_of_type_Int))) || (this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
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
      localObject1 = this.jdField_d_of_type_Axow.a(1) + ";" + this.jdField_a_of_type_Axow.a(2) + ";" + this.jdField_b_of_type_Axow.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Axvt.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Axvt.jdField_g_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Axvt.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_i_of_type_Boolean));
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      long l2 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_Axvw != null) {
        break label898;
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
        break label909;
      }
      localObject1 = "1";
      label650:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_g_of_type_Boolean) {
        break label917;
      }
      localObject1 = "1";
      label679:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.jdField_a_of_type_Axsp != null) && (((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_Axrq != null))
      {
        localObject1 = (axro)this.jdField_a_of_type_Axsp;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((axro)localObject1).jdField_a_of_type_Axrq).jdField_a_of_type_Long));
      }
      localObject2 = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      f(paramBoolean);
      if (!paramBoolean) {
        break label925;
      }
      awrn.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      b(paramBoolean, l1);
      l();
      super.a(paramBoolean, "C2CPicDownloadErrorCode", l1, this.jdField_a_of_type_JavaUtilHashMap);
      return;
      i = 1;
      break;
      label898:
      i = this.jdField_a_of_type_Axvw.jdField_a_of_type_Int;
      break label451;
      label909:
      localObject1 = "0";
      break label650;
      label917:
      localObject1 = "0";
      break label679;
      label925:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_i_of_type_JavaLangString);
      awrn.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.jdField_a_of_type_Axvt.m) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x1) != 0);
  }
  
  public void aU_()
  {
    super.aU_();
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
      b("reportFailed", axpm.a(localException));
    }
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 65537) {
      return "actC2CPicSmallDownV1";
    }
    return "actC2CPicDownloadV1";
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Axow.a();
    this.jdField_a_of_type_Boolean = false;
    axyg localaxyg = new axyg();
    axyh localaxyh = new axyh();
    localaxyh.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_b_of_type_JavaLangString;
    localaxyh.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString;
    localaxyh.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_d_of_type_JavaLangString;
    localaxyh.jdField_f_of_type_Int = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
    localaxyh.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_e_of_type_JavaLangString;
    localaxyh.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Axvt.jdField_d_of_type_Long);
    MessageRecord localMessageRecord2 = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    MessageRecord localMessageRecord1 = localMessageRecord2;
    if (localMessageRecord2 == null) {
      localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    }
    boolean bool;
    if ((localMessageRecord1 != null) && ((localMessageRecord1 instanceof MessageForPic)))
    {
      this.jdField_d_of_type_JavaLangString = ((MessageForPic)localMessageRecord1).serverStoreSource;
      localaxyh.jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localaxyh.jdField_a_of_type_Int = this.jdField_a_of_type_Axvt.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Int != 1006) {
        break label312;
      }
      bool = true;
      label210:
      localaxyh.jdField_a_of_type_Boolean = bool;
      if (!paramBoolean) {
        break label317;
      }
      localaxyh.jdField_c_of_type_Int = 0;
      label226:
      localaxyg.jdField_a_of_type_Axzn = this;
      localaxyg.jdField_a_of_type_JavaLangString = "c2c_pic_dw";
      localaxyg.jdField_a_of_type_JavaUtilList.add(localaxyh);
      localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label326;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Axow);
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
      localaxyh.jdField_c_of_type_Int = 1;
      break label226;
      if (QLog.isColorLevel()) {
        b("requestStart", localaxyg.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Axyg = localaxyg;
    axzm.a(localaxyg);
  }
  
  public int c()
  {
    b("uiParam", this.jdField_a_of_type_Axvt.toString());
    String str = this.jdField_a_of_type_Axvt.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bace.c(str)) || (str.startsWith("http")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaIoOutputStream == null) && (this.jdField_a_of_type_Axvt.jdField_c_of_type_Boolean))
    {
      b(9302, a(new Exception("no output stream")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject instanceof axvw)))
    {
      b(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_Axvw = ((axvw)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Axvw.jdField_a_of_type_Int;
    return 0;
  }
  
  void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Axow.a();
    if (this.o) {
      return;
    }
    axro localaxro = new axro();
    Object localObject;
    label32:
    label81:
    int i;
    label164:
    String str;
    if (paramBoolean)
    {
      localObject = "https://";
      if (!this.jdField_j_of_type_Boolean) {
        break label666;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localaxro.jdField_g_of_type_Boolean = false;
      localaxro.jdField_b_of_type_JavaLangString = "c2cpicdw.qpic.cn";
      localObject = (String)localObject + "c2cpicdw.qpic.cn";
      localObject = a((String)localObject + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_g_of_type_Int);
      localaxro.jdField_a_of_type_Axrt = this;
      localaxro.jdField_a_of_type_Axru = this;
      localaxro.jdField_a_of_type_JavaLangString = ((String)localObject);
      localaxro.jdField_f_of_type_Boolean = paramBoolean;
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label881;
      }
      localaxro.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localaxro.jdField_a_of_type_Int = 0;
      localaxro.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      localaxro.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.h;
      if (this.jdField_a_of_type_Axvt.jdField_c_of_type_Boolean) {
        localaxro.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaIoOutputStream;
      }
      localaxro.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
      localaxro.jdField_g_of_type_Int = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
      localaxro.jdField_f_of_type_Int = this.jdField_a_of_type_Axvt.jdField_b_of_type_Int;
      localaxro.jdField_a_of_type_Long = 0L;
      localaxro.k = true;
      i = a(this.jdField_a_of_type_Axvt);
      if (i != 4) {
        break label892;
      }
      localaxro.jdField_a_of_type_Long = this.jdField_a_of_type_Axvt.i;
      localaxro.jdField_b_of_type_Long = 0L;
      localaxro.jdField_j_of_type_Boolean = false;
      str = "bytes=" + this.jdField_a_of_type_Axvt.i + "-";
      localaxro.jdField_a_of_type_JavaUtilHashMap.put("Range", str);
    }
    for (;;)
    {
      a(localaxro, (String)localObject);
      localaxro.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localaxro.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCd");
      localaxro.jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
      localaxro.jdField_a_of_type_Axrs = jdField_a_of_type_Axrs;
      localaxro.jdField_e_of_type_Int = this.jdField_a_of_type_Axvt.jdField_f_of_type_Int;
      localaxro.jdField_a_of_type_Axtz = jdField_a_of_type_Axtx.a();
      localaxro.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
      localaxro.l = true;
      localaxro.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_Boolean) {
        localaxro.jdField_c_of_type_Long = 0L;
      }
      str = null;
      localObject = str;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = str;
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          localObject = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
        }
      }
      b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + (String)localObject + " uniSeq:" + localaxro.jdField_e_of_type_JavaLangString + " uuid:" + this.jdField_a_of_type_Axvt.jdField_e_of_type_JavaLangString + ",downOffset:" + localaxro.jdField_a_of_type_Long + ",isEncryptUrl:" + this.jdField_e_of_type_Boolean + ",isEncryptPic:" + this.jdField_d_of_type_Boolean + ",isEncryptRollbackReq:" + this.jdField_f_of_type_Boolean);
      if (!f()) {
        break;
      }
      this.jdField_a_of_type_Axsp = localaxro;
      this.jdField_a_of_type_Axrr.a(localaxro);
      return;
      localObject = "http://";
      break label32;
      label666:
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localaxro.jdField_g_of_type_Boolean = true;
        axuh localaxuh = (axuh)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((localaxuh.jdField_a_of_type_Boolean) && (!localaxuh.jdField_a_of_type_JavaLangString.startsWith("["))) {}
        for (str = (String)localObject + "[" + localaxuh.jdField_a_of_type_JavaLangString + "]";; str = (String)localObject + localaxuh.jdField_a_of_type_JavaLangString)
        {
          localObject = str;
          if (localaxuh.jdField_a_of_type_Int == 80) {
            break;
          }
          localObject = str + ":" + localaxuh.jdField_a_of_type_Int;
          break;
        }
      }
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break;
      }
      localaxro.jdField_g_of_type_Boolean = false;
      localObject = (String)localObject + this.jdField_b_of_type_JavaLangString;
      break label81;
      label881:
      localaxro.jdField_b_of_type_JavaLangString = "c2cpicdw.qpic.cn";
      break label164;
      label892:
      if ((i == 3) || (i == 2))
      {
        localaxro.jdField_a_of_type_Long = this.jdField_a_of_type_Axvt.i;
        localaxro.jdField_b_of_type_Long = (this.jdField_a_of_type_Axvt.i + this.jdField_a_of_type_Axvt.jdField_j_of_type_Int - 1);
        localaxro.jdField_j_of_type_Boolean = false;
        str = "bytes=" + this.jdField_a_of_type_Axvt.i + "-" + localaxro.jdField_b_of_type_Long;
        localaxro.jdField_a_of_type_JavaUtilHashMap.put("Range", str);
      }
      else
      {
        localaxro.jdField_b_of_type_Long = 0L;
        localaxro.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localaxro.jdField_a_of_type_Long + "-");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axpb
 * JD-Core Version:    0.7.0.1
 */