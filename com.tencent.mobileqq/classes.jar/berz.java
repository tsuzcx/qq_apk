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

public class berz
  extends berk
{
  public berz() {}
  
  public berz(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    this.jdField_a_of_type_Bete.jdField_b_of_type_Int = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bete.jdField_b_of_type_Long = this.jdField_a_of_type_Beyg.jdField_a_of_type_Long;
    this.jdField_a_of_type_Bete.jdField_c_of_type_Long = this.jdField_a_of_type_Beyg.jdField_b_of_type_Long;
  }
  
  public void a(bfau parambfau, bfbj parambfbj)
  {
    this.jdField_a_of_type_Bfau = null;
    if (parambfbj != null)
    {
      int i = 0;
      if (i < parambfbj.jdField_a_of_type_JavaUtilList.size())
      {
        parambfau = (bfbv)parambfbj.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambfau.toString());
        }
        this.jdField_k_of_type_Boolean = parambfau.jdField_d_of_type_Boolean;
        a(this.jdField_a_of_type_Berr, parambfau);
        if (parambfau.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList = a(parambfau.jdField_b_of_type_JavaUtilArrayList, parambfau.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_b_of_type_JavaLangString = parambfau.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = parambfau.jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            b("proUrl", "picResp.protocolType = " + parambfau.jdField_a_of_type_Int);
          }
          if (parambfau.jdField_a_of_type_Int == 1) {
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
      localObject1 = "Q.richmedia." + bews.b(this.jdField_a_of_type_Beyg.jdField_a_of_type_Int) + "." + bews.a(this.jdField_a_of_type_Beyg.jdField_b_of_type_Int);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.jdField_k_of_type_Int + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.jdField_j_of_type_JavaLangString);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (!this.jdField_a_of_type_Beyg.jdField_g_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Beyg.jdField_e_of_type_Int == 1030) || ((!paramBoolean) && (bewk.a(this.jdField_k_of_type_Int))) || (this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.n & 0x2) > 0)) || ((!paramBoolean) && ((this.n & 0x1) > 0))) {
      return;
    }
    int j = this.n;
    int i;
    long l2;
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.n = (i | j);
      l2 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      localObject1 = this.jdField_d_of_type_Berr.a(1) + ";" + this.jdField_a_of_type_Berr.a(2) + ";" + this.jdField_b_of_type_Berr.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_a_of_type_Boolean) {
        break label927;
      }
      l1 = this.jdField_d_of_type_Berr.a();
      label361:
      ((HashMap)localObject1).put("param_trans_consume", String.valueOf(l1));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Beyg.jdField_g_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_k_of_type_Boolean));
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      l1 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_Beyj != null) {
        break label939;
      }
      i = 0;
      label486:
      ((HashMap)localObject1).put("param_recvDataLen", String.valueOf(l1 - i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailCode", String.valueOf(this.jdField_d_of_type_Int));
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
      if ((this.jdField_a_of_type_Bevl != null) && (((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_Beun != null))
      {
        localObject1 = (beum)this.jdField_a_of_type_Bevl;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((beum)localObject1).jdField_a_of_type_Beun).jdField_a_of_type_Long));
      }
      localObject2 = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      e(paramBoolean);
      if (!paramBoolean) {
        break label966;
      }
      b(true, l2);
      bdmc.a(BaseApplication.getContext()).a(null, c(), true, l2, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      m();
      super.a(paramBoolean, "C2CPicDownloadErrorCode", l2, this.jdField_a_of_type_JavaUtilHashMap);
      return;
      i = 1;
      break;
      label927:
      l1 = this.jdField_b_of_type_Berr.a();
      break label361;
      label939:
      i = this.jdField_a_of_type_Beyj.jdField_a_of_type_Int;
      break label486;
      label950:
      localObject1 = "0";
      break label680;
      label958:
      localObject1 = "0";
      break label709;
      label966:
      if (this.jdField_k_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_k_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      b(false, l2);
      bdmc.a(BaseApplication.getContext()).a(null, c(), false, l2, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.jdField_a_of_type_Beyg.n) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x1) != 0);
  }
  
  public void aN_()
  {
    super.aN_();
    if ((this.h) && (this.jdField_g_of_type_Boolean) && (!a()))
    {
      this.h = false;
      this.jdField_g_of_type_Boolean = false;
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
      b("reportFailed", besk.a(localException));
    }
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bfci.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Berr.a();
    if (this.q) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "c2cpicdw.qpic.cn";
    }
    beum localbeum = new beum();
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
      localbeum.jdField_g_of_type_Boolean = false;
      localbeum.jdField_b_of_type_JavaLangString = "c2cpicdw.qpic.cn";
      localObject = (String)localObject + "c2cpicdw.qpic.cn";
      localObject = a((String)localObject + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_g_of_type_Int);
      localbeum.jdField_a_of_type_Beuq = this;
      localbeum.jdField_a_of_type_Beur = this;
      localbeum.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbeum.jdField_f_of_type_Boolean = paramBoolean;
      localbeum.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localbeum.jdField_a_of_type_Int = 0;
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaLangString);
      localbeum.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      localbeum.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.h;
      if (this.jdField_a_of_type_Beyg.jdField_d_of_type_Boolean) {
        localbeum.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaIoOutputStream;
      }
      localbeum.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
      localbeum.jdField_f_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
      localbeum.jdField_e_of_type_Int = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
      localbeum.jdField_a_of_type_Long = 0L;
      localbeum.l = true;
      i = a(this.jdField_a_of_type_Beyg);
      if (i != 4) {
        break label897;
      }
      localbeum.jdField_a_of_type_Long = this.jdField_a_of_type_Beyg.i;
      localbeum.jdField_b_of_type_Long = 0L;
      localbeum.jdField_k_of_type_Boolean = false;
      str = "bytes=" + this.jdField_a_of_type_Beyg.i + "-";
      localbeum.jdField_a_of_type_JavaUtilHashMap.put("Range", str);
    }
    for (;;)
    {
      a(localbeum, (String)localObject);
      localbeum.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localbeum.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCd");
      localbeum.jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
      localbeum.jdField_a_of_type_Beup = jdField_a_of_type_Beup;
      localbeum.jdField_d_of_type_Int = this.jdField_a_of_type_Beyg.jdField_f_of_type_Int;
      if (this.jdField_a_of_type_Bewo != null) {
        localbeum.jdField_a_of_type_Bewq = this.jdField_a_of_type_Bewo.a();
      }
      localbeum.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
      localbeum.m = true;
      localbeum.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_Boolean) {
        localbeum.jdField_c_of_type_Long = 0L;
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
      b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + (String)localObject + " uniSeq:" + localbeum.jdField_e_of_type_JavaLangString + " uuid:" + this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString + ",downOffset:" + localbeum.jdField_a_of_type_Long + ",isEncryptUrl:" + this.h + ",isEncryptPic:" + this.jdField_g_of_type_Boolean + ",isEncryptRollbackReq:" + this.i);
      if (!f()) {
        break;
      }
      this.jdField_a_of_type_Bevl = localbeum;
      this.jdField_a_of_type_Beuo.a(localbeum);
      return;
      localObject = "http://";
      break label62;
      label699:
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localbeum.jdField_g_of_type_Boolean = true;
        bewy localbewy = (bewy)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((localbewy.jdField_a_of_type_Boolean) && (!localbewy.jdField_a_of_type_JavaLangString.startsWith("["))) {}
        for (str = (String)localObject + "[" + localbewy.jdField_a_of_type_JavaLangString + "]";; str = (String)localObject + localbewy.jdField_a_of_type_JavaLangString)
        {
          localObject = str;
          if (localbewy.jdField_a_of_type_Int == 80) {
            break;
          }
          localObject = str + ":" + localbewy.jdField_a_of_type_Int;
          break;
        }
      }
      localbeum.jdField_g_of_type_Boolean = false;
      localObject = (String)localObject + this.jdField_b_of_type_JavaLangString;
      break label111;
      label897:
      if ((i == 3) || (i == 2))
      {
        localbeum.jdField_a_of_type_Long = this.jdField_a_of_type_Beyg.i;
        localbeum.jdField_b_of_type_Long = (this.jdField_a_of_type_Beyg.i + this.jdField_a_of_type_Beyg.j - 1);
        localbeum.jdField_k_of_type_Boolean = false;
        str = "bytes=" + this.jdField_a_of_type_Beyg.i + "-" + localbeum.jdField_b_of_type_Long;
        localbeum.jdField_a_of_type_JavaUtilHashMap.put("Range", str);
      }
      else
      {
        localbeum.jdField_b_of_type_Long = 0L;
        localbeum.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localbeum.jdField_a_of_type_Long + "-");
      }
    }
  }
  
  public int c()
  {
    b("uiParam", this.jdField_a_of_type_Beyg.toString());
    String str = this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bhmi.c(str)) || (str.startsWith("http")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaIoOutputStream == null) && (this.jdField_a_of_type_Beyg.jdField_d_of_type_Boolean))
    {
      b(9302, a(new Exception("no output stream")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject instanceof beyj)))
    {
      b(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_Beyj = ((beyj)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Beyj.jdField_a_of_type_Int;
    return 0;
  }
  
  protected String c()
  {
    if (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 65537) {
      return "actC2CPicSmallDownV1";
    }
    return "actC2CPicDownloadV1";
  }
  
  void f()
  {
    this.jdField_a_of_type_Berr.a();
    this.jdField_a_of_type_Boolean = false;
    bfau localbfau = new bfau();
    bfav localbfav = new bfav();
    localbfav.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString;
    localbfav.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfav.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_d_of_type_JavaLangString;
    localbfav.jdField_f_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbfav.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString;
    localbfav.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Beyg.jdField_d_of_type_Long);
    MessageRecord localMessageRecord2 = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    MessageRecord localMessageRecord1 = localMessageRecord2;
    if (localMessageRecord2 == null) {
      localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    }
    boolean bool;
    if ((localMessageRecord1 != null) && ((localMessageRecord1 instanceof MessageForPic)))
    {
      this.jdField_d_of_type_JavaLangString = ((MessageForPic)localMessageRecord1).serverStoreSource;
      localbfav.jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localbfav.jdField_a_of_type_Int = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int != 1006) {
        break label305;
      }
      bool = true;
      label207:
      localbfav.jdField_a_of_type_Boolean = bool;
      localbfav.jdField_c_of_type_Int = 0;
      localbfau.jdField_a_of_type_Bfcb = this;
      localbfau.jdField_a_of_type_JavaLangString = "c2c_pic_dw";
      localbfau.jdField_a_of_type_JavaUtilList.add(localbfav);
      localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label310;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
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
        b("requestStart", localbfau.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bfau = localbfau;
    bfca.a(localbfau);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berz
 * JD-Core Version:    0.7.0.1
 */