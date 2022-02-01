import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class bdtg
  extends bdss
{
  public bdtg() {}
  
  public bdtg(bdzi parambdzi, bdzn parambdzn)
  {
    super(parambdzi, parambdzn);
    this.jdField_a_of_type_Bduk.jdField_b_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bduk.jdField_b_of_type_Long = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long;
    this.jdField_a_of_type_Bduk.jdField_c_of_type_Long = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Long;
  }
  
  public void a(bebv parambebv, beck parambeck)
  {
    this.jdField_a_of_type_Bebv = null;
    if (parambeck != null)
    {
      int i = 0;
      if (i < parambeck.jdField_a_of_type_JavaUtilList.size())
      {
        parambebv = (becw)parambeck.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambebv.toString());
        }
        this.jdField_k_of_type_Boolean = parambebv.jdField_d_of_type_Boolean;
        a(this.jdField_a_of_type_Bdsz, parambebv);
        if (parambebv.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList = a(parambebv.jdField_b_of_type_JavaUtilArrayList, parambebv.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_b_of_type_JavaLangString = parambebv.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = parambebv.jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            b("proUrl", "picResp.protocolType = " + parambebv.jdField_a_of_type_Int);
          }
          if (parambebv.jdField_a_of_type_Int == 1) {
            b(true);
          }
          for (;;)
          {
            i += 1;
            break;
            b(false);
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
      localObject1 = "Q.richmedia." + bdxz.b(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int) + "." + bdxz.a(this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.jdField_j_of_type_Int + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.jdField_j_of_type_JavaLangString);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (!this.jdField_a_of_type_Bdzn.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Bdzn.jdField_e_of_type_Int == 1030) || ((!paramBoolean) && (bdxr.a(this.jdField_j_of_type_Int))) || (this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    long l2;
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      l2 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      localObject1 = this.jdField_d_of_type_Bdsz.a(1) + ";" + this.jdField_a_of_type_Bdsz.a(2) + ";" + this.jdField_b_of_type_Bdsz.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_a_of_type_Boolean) {
        break label927;
      }
      l1 = this.jdField_d_of_type_Bdsz.a();
      label361:
      ((HashMap)localObject1).put("param_trans_consume", String.valueOf(l1));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Bdzn.g));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_k_of_type_Boolean));
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      l1 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_Bdzq != null) {
        break label939;
      }
      i = 0;
      label486:
      ((HashMap)localObject1).put("param_recvDataLen", String.valueOf(l1 - i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailCode", String.valueOf(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailDesc", "" + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_inQueueCost", "" + this.p);
      this.jdField_a_of_type_JavaUtilHashMap.put("ipFromDns", "" + this.jdField_f_of_type_Boolean);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_encryptRollback", "" + this.i + ",decryptErrorMsg:" + this.jdField_f_of_type_JavaLangString);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.i) {
        break label950;
      }
      localObject1 = "1";
      label680:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_e_of_type_Boolean) {
        break label958;
      }
      localObject1 = "1";
      label709:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.jdField_a_of_type_Bdws != null) && (((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_Bdvt != null))
      {
        localObject1 = (bdvs)this.jdField_a_of_type_Bdws;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((bdvs)localObject1).jdField_a_of_type_Bdvt).jdField_a_of_type_Long));
      }
      localObject2 = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      e(paramBoolean);
      if (!paramBoolean) {
        break label966;
      }
      b(true, l2);
      bctj.a(BaseApplication.getContext()).a(null, c(), true, l2, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      m();
      super.a(paramBoolean, "C2CPicDownloadErrorCode", l2, this.jdField_a_of_type_JavaUtilHashMap);
      return;
      i = 1;
      break;
      label927:
      l1 = this.jdField_b_of_type_Bdsz.a();
      break label361;
      label939:
      i = this.jdField_a_of_type_Bdzq.jdField_a_of_type_Int;
      break label486;
      label950:
      localObject1 = "0";
      break label680;
      label958:
      localObject1 = "0";
      break label709;
      label966:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      b(false, l2);
      bctj.a(BaseApplication.getContext()).a(null, c(), false, l2, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.jdField_a_of_type_Bdzn.m) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x1) != 0);
  }
  
  public void aN_()
  {
    super.aN_();
    if ((this.h) && (this.g) && (!a()))
    {
      this.h = false;
      this.g = false;
      f();
      return;
    }
    try
    {
      a("c2cpicdw.qpic.cn", 1004);
      return;
    }
    catch (Exception localException)
    {
      b("reportFailed", bdtr.a(localException));
    }
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bedj.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Bdsz.a();
    if (this.q) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "c2cpicdw.qpic.cn";
    }
    bdvs localbdvs = new bdvs();
    Object localObject;
    label62:
    label111:
    int i;
    String str;
    if (paramBoolean)
    {
      localObject = "https://";
      if (!this.l) {
        break label699;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localbdvs.g = false;
      localbdvs.jdField_b_of_type_JavaLangString = "c2cpicdw.qpic.cn";
      localObject = (String)localObject + "c2cpicdw.qpic.cn";
      localObject = a((String)localObject + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.g);
      localbdvs.jdField_a_of_type_Bdvw = this;
      localbdvs.jdField_a_of_type_Bdvx = this;
      localbdvs.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbdvs.jdField_f_of_type_Boolean = paramBoolean;
      localbdvs.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localbdvs.jdField_a_of_type_Int = 0;
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaLangString);
      localbdvs.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      localbdvs.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.h;
      if (this.jdField_a_of_type_Bdzn.jdField_c_of_type_Boolean) {
        localbdvs.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaIoOutputStream;
      }
      localbdvs.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
      localbdvs.jdField_f_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
      localbdvs.jdField_e_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int;
      localbdvs.jdField_a_of_type_Long = 0L;
      localbdvs.l = true;
      i = a(this.jdField_a_of_type_Bdzn);
      if (i != 4) {
        break label897;
      }
      localbdvs.jdField_a_of_type_Long = this.jdField_a_of_type_Bdzn.i;
      localbdvs.jdField_b_of_type_Long = 0L;
      localbdvs.jdField_k_of_type_Boolean = false;
      str = "bytes=" + this.jdField_a_of_type_Bdzn.i + "-";
      localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Range", str);
    }
    for (;;)
    {
      a(localbdvs, (String)localObject);
      localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localbdvs.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCd");
      localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
      localbdvs.jdField_a_of_type_Bdvv = jdField_a_of_type_Bdvv;
      localbdvs.jdField_d_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_f_of_type_Int;
      if (this.jdField_a_of_type_Bdxv != null) {
        localbdvs.jdField_a_of_type_Bdxx = this.jdField_a_of_type_Bdxv.a();
      }
      localbdvs.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
      localbdvs.m = true;
      localbdvs.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_Boolean) {
        localbdvs.jdField_c_of_type_Long = 0L;
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
      b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + (String)localObject + " uniSeq:" + localbdvs.jdField_e_of_type_JavaLangString + " uuid:" + this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString + ",downOffset:" + localbdvs.jdField_a_of_type_Long + ",isEncryptUrl:" + this.h + ",isEncryptPic:" + this.g + ",isEncryptRollbackReq:" + this.i);
      if (!f()) {
        break;
      }
      this.jdField_a_of_type_Bdws = localbdvs;
      this.jdField_a_of_type_Bdvu.a(localbdvs);
      return;
      localObject = "http://";
      break label62;
      label699:
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localbdvs.g = true;
        bdyf localbdyf = (bdyf)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((localbdyf.jdField_a_of_type_Boolean) && (!localbdyf.jdField_a_of_type_JavaLangString.startsWith("["))) {}
        for (str = (String)localObject + "[" + localbdyf.jdField_a_of_type_JavaLangString + "]";; str = (String)localObject + localbdyf.jdField_a_of_type_JavaLangString)
        {
          localObject = str;
          if (localbdyf.jdField_a_of_type_Int == 80) {
            break;
          }
          localObject = str + ":" + localbdyf.jdField_a_of_type_Int;
          break;
        }
      }
      localbdvs.g = false;
      localObject = (String)localObject + this.jdField_b_of_type_JavaLangString;
      break label111;
      label897:
      if ((i == 3) || (i == 2))
      {
        localbdvs.jdField_a_of_type_Long = this.jdField_a_of_type_Bdzn.i;
        localbdvs.jdField_b_of_type_Long = (this.jdField_a_of_type_Bdzn.i + this.jdField_a_of_type_Bdzn.jdField_j_of_type_Int - 1);
        localbdvs.jdField_k_of_type_Boolean = false;
        str = "bytes=" + this.jdField_a_of_type_Bdzn.i + "-" + localbdvs.jdField_b_of_type_Long;
        localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Range", str);
      }
      else
      {
        localbdvs.jdField_b_of_type_Long = 0L;
        localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localbdvs.jdField_a_of_type_Long + "-");
      }
    }
  }
  
  public int c()
  {
    b("uiParam", this.jdField_a_of_type_Bdzn.toString());
    String str = this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bgmg.c(str)) || (str.startsWith("http")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaIoOutputStream == null) && (this.jdField_a_of_type_Bdzn.jdField_c_of_type_Boolean))
    {
      b(9302, a(new Exception("no output stream")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject instanceof bdzq)))
    {
      b(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_Bdzq = ((bdzq)this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Bdzq.jdField_a_of_type_Int;
    return 0;
  }
  
  protected String c()
  {
    if (this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int == 65537) {
      return "actC2CPicSmallDownV1";
    }
    return "actC2CPicDownloadV1";
  }
  
  void f()
  {
    this.jdField_a_of_type_Bdsz.a();
    this.jdField_a_of_type_Boolean = false;
    bebv localbebv = new bebv();
    bebw localbebw = new bebw();
    localbebw.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString;
    localbebw.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString;
    localbebw.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_d_of_type_JavaLangString;
    localbebw.jdField_f_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    localbebw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString;
    localbebw.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Bdzn.jdField_d_of_type_Long);
    MessageRecord localMessageRecord2 = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    MessageRecord localMessageRecord1 = localMessageRecord2;
    if (localMessageRecord2 == null) {
      localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
    }
    boolean bool;
    if ((localMessageRecord1 != null) && ((localMessageRecord1 instanceof MessageForPic)))
    {
      this.jdField_d_of_type_JavaLangString = ((MessageForPic)localMessageRecord1).serverStoreSource;
      localbebw.jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localbebw.jdField_a_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int != 1006) {
        break label305;
      }
      bool = true;
      label207:
      localbebw.jdField_a_of_type_Boolean = bool;
      localbebw.jdField_c_of_type_Int = 0;
      localbebv.jdField_a_of_type_Bedc = this;
      localbebv.jdField_a_of_type_JavaLangString = "c2c_pic_dw";
      localbebv.jdField_a_of_type_JavaUtilList.add(localbebw);
      localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label310;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Bdsz);
      d();
    }
    label305:
    label310:
    do
    {
      return;
      this.jdField_d_of_type_JavaLangString = "picplatform";
      b("findDbRec", "not found");
      break;
      bool = false;
      break label207;
      if (QLog.isColorLevel()) {
        b("requestStart", localbebv.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bebv = localbebv;
    bedb.a(localbebv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtg
 * JD-Core Version:    0.7.0.1
 */