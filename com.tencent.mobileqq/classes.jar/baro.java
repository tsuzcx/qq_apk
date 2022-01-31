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

public class baro
  extends barb
{
  public baro() {}
  
  public baro(bayf parambayf, bayk parambayk)
  {
    super(parambayf, parambayk);
    this.jdField_a_of_type_Bass.jdField_b_of_type_Int = this.jdField_a_of_type_Bayk.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bass.jdField_b_of_type_Long = this.jdField_a_of_type_Bayk.jdField_a_of_type_Long;
    this.jdField_a_of_type_Bass.jdField_c_of_type_Long = this.jdField_a_of_type_Bayk.jdField_b_of_type_Long;
  }
  
  public void a(bbax parambbax, bbbm parambbbm)
  {
    this.jdField_a_of_type_Bbax = null;
    if (parambbbm != null)
    {
      int i = 0;
      if (i < parambbbm.jdField_a_of_type_JavaUtilList.size())
      {
        parambbax = (bbby)parambbbm.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambbax.toString());
        }
        this.i = parambbax.jdField_d_of_type_Boolean;
        a(this.jdField_a_of_type_Barh, parambbax);
        if (parambbax.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList = a(parambbax.jdField_b_of_type_JavaUtilArrayList, parambbax.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_b_of_type_JavaLangString = parambbax.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = parambbax.jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            b("proUrl", "picResp.protocolType = " + parambbax.jdField_a_of_type_Int);
          }
          if (parambbax.jdField_a_of_type_Int == 1)
          {
            this.jdField_g_of_type_Boolean = true;
            c(true);
          }
          for (;;)
          {
            i += 1;
            break;
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
      localObject1 = "Q.richmedia." + baws.b(this.jdField_a_of_type_Bayk.jdField_a_of_type_Int) + "." + baws.a(this.jdField_a_of_type_Bayk.jdField_b_of_type_Int);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.jdField_a_of_type_Bayk.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.jdField_j_of_type_Int + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.jdField_j_of_type_JavaLangString);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (!this.jdField_a_of_type_Bayk.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Bayk.jdField_e_of_type_Int == 1030) || ((!paramBoolean) && (bawk.b(this.jdField_j_of_type_Int))) || (this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
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
      localObject1 = this.jdField_d_of_type_Barh.a(1) + ";" + this.jdField_a_of_type_Barh.a(2) + ";" + this.jdField_b_of_type_Barh.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Bayk.jdField_g_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.i));
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      long l2 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_Bayn != null) {
        break label892;
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
        break label903;
      }
      localObject1 = "1";
      label645:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_g_of_type_Boolean) {
        break label911;
      }
      localObject1 = "1";
      label674:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.jdField_a_of_type_Bave != null) && (((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_Baud != null))
      {
        localObject1 = (baub)this.jdField_a_of_type_Bave;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((baub)localObject1).jdField_a_of_type_Baud).jdField_a_of_type_Long));
      }
      localObject2 = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      f(paramBoolean);
      if (!paramBoolean) {
        break label919;
      }
      b(true, l1);
      azri.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      l();
      super.a(paramBoolean, "C2CPicDownloadErrorCode", l1, this.jdField_a_of_type_JavaUtilHashMap);
      return;
      i = 1;
      break;
      label892:
      i = this.jdField_a_of_type_Bayn.jdField_a_of_type_Int;
      break label451;
      label903:
      localObject1 = "0";
      break label645;
      label911:
      localObject1 = "0";
      break label674;
      label919:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      b(false, l1);
      azri.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.jdField_a_of_type_Bayk.m) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x1) != 0);
  }
  
  public void aP_()
  {
    super.aP_();
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
      b("reportFailed", barz.a(localException));
    }
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_Bayk.jdField_b_of_type_Int == 65537) {
      return "actC2CPicSmallDownV1";
    }
    return "actC2CPicDownloadV1";
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Barh.a();
    this.jdField_a_of_type_Boolean = false;
    bbax localbbax = new bbax();
    bbay localbbay = new bbay();
    localbbay.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString;
    localbbay.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
    localbbay.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_d_of_type_JavaLangString;
    localbbay.jdField_f_of_type_Int = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
    localbbay.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString;
    localbbay.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Bayk.jdField_d_of_type_Long);
    MessageRecord localMessageRecord2 = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    MessageRecord localMessageRecord1 = localMessageRecord2;
    if (localMessageRecord2 == null) {
      localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    }
    boolean bool;
    if ((localMessageRecord1 != null) && ((localMessageRecord1 instanceof MessageForPic)))
    {
      this.jdField_d_of_type_JavaLangString = ((MessageForPic)localMessageRecord1).serverStoreSource;
      localbbay.jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localbbay.jdField_a_of_type_Int = this.jdField_a_of_type_Bayk.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int != 1006) {
        break label312;
      }
      bool = true;
      label210:
      localbbay.jdField_a_of_type_Boolean = bool;
      if (!paramBoolean) {
        break label317;
      }
      localbbay.jdField_c_of_type_Int = 0;
      label226:
      localbbax.jdField_a_of_type_Bbce = this;
      localbbax.jdField_a_of_type_JavaLangString = "c2c_pic_dw";
      localbbax.jdField_a_of_type_JavaUtilList.add(localbbay);
      localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label326;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Barh);
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
      localbbay.jdField_c_of_type_Int = 1;
      break label226;
      if (QLog.isColorLevel()) {
        b("requestStart", localbbax.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bbax = localbbax;
    bbcd.a(localbbax);
  }
  
  public int c()
  {
    b("uiParam", this.jdField_a_of_type_Bayk.toString());
    String str = this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bdhb.c(str)) || (str.startsWith("http")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaIoOutputStream == null) && (this.jdField_a_of_type_Bayk.jdField_c_of_type_Boolean))
    {
      b(9302, a(new Exception("no output stream")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject instanceof bayn)))
    {
      b(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_Bayn = ((bayn)this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Bayn.jdField_a_of_type_Int;
    return 0;
  }
  
  void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Barh.a();
    if (this.o) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "c2cpicdw.qpic.cn";
    }
    baub localbaub = new baub();
    Object localObject;
    label49:
    label98:
    int i;
    String str;
    if (paramBoolean)
    {
      localObject = "https://";
      if (!this.jdField_j_of_type_Boolean) {
        break label686;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localbaub.jdField_g_of_type_Boolean = false;
      localbaub.jdField_b_of_type_JavaLangString = "c2cpicdw.qpic.cn";
      localObject = (String)localObject + "c2cpicdw.qpic.cn";
      localObject = a((String)localObject + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_g_of_type_Int);
      localbaub.jdField_a_of_type_Baug = this;
      localbaub.jdField_a_of_type_Bauh = this;
      localbaub.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbaub.jdField_f_of_type_Boolean = paramBoolean;
      localbaub.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localbaub.jdField_a_of_type_Int = 0;
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaLangString);
      localbaub.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      localbaub.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bayk.h;
      if (this.jdField_a_of_type_Bayk.jdField_c_of_type_Boolean) {
        localbaub.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaIoOutputStream;
      }
      localbaub.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
      localbaub.jdField_g_of_type_Int = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
      localbaub.jdField_f_of_type_Int = this.jdField_a_of_type_Bayk.jdField_b_of_type_Int;
      localbaub.jdField_a_of_type_Long = 0L;
      localbaub.k = true;
      i = a(this.jdField_a_of_type_Bayk);
      if (i != 4) {
        break label884;
      }
      localbaub.jdField_a_of_type_Long = this.jdField_a_of_type_Bayk.i;
      localbaub.jdField_b_of_type_Long = 0L;
      localbaub.jdField_j_of_type_Boolean = false;
      str = "bytes=" + this.jdField_a_of_type_Bayk.i + "-";
      localbaub.jdField_a_of_type_JavaUtilHashMap.put("Range", str);
    }
    for (;;)
    {
      a(localbaub, (String)localObject);
      localbaub.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localbaub.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCd");
      localbaub.jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
      localbaub.jdField_a_of_type_Bauf = jdField_a_of_type_Bauf;
      localbaub.jdField_e_of_type_Int = this.jdField_a_of_type_Bayk.jdField_f_of_type_Int;
      if (this.jdField_a_of_type_Bawo != null) {
        localbaub.jdField_a_of_type_Bawq = this.jdField_a_of_type_Bawo.a();
      }
      localbaub.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
      localbaub.l = true;
      localbaub.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_Boolean) {
        localbaub.jdField_c_of_type_Long = 0L;
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
      b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + (String)localObject + " uniSeq:" + localbaub.jdField_e_of_type_JavaLangString + " uuid:" + this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString + ",downOffset:" + localbaub.jdField_a_of_type_Long + ",isEncryptUrl:" + this.jdField_e_of_type_Boolean + ",isEncryptPic:" + this.jdField_d_of_type_Boolean + ",isEncryptRollbackReq:" + this.jdField_f_of_type_Boolean);
      if (!f()) {
        break;
      }
      this.jdField_a_of_type_Bave = localbaub;
      this.jdField_a_of_type_Baue.a(localbaub);
      return;
      localObject = "http://";
      break label49;
      label686:
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localbaub.jdField_g_of_type_Boolean = true;
        bawy localbawy = (bawy)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((localbawy.jdField_a_of_type_Boolean) && (!localbawy.jdField_a_of_type_JavaLangString.startsWith("["))) {}
        for (str = (String)localObject + "[" + localbawy.jdField_a_of_type_JavaLangString + "]";; str = (String)localObject + localbawy.jdField_a_of_type_JavaLangString)
        {
          localObject = str;
          if (localbawy.jdField_a_of_type_Int == 80) {
            break;
          }
          localObject = str + ":" + localbawy.jdField_a_of_type_Int;
          break;
        }
      }
      localbaub.jdField_g_of_type_Boolean = false;
      localObject = (String)localObject + this.jdField_b_of_type_JavaLangString;
      break label98;
      label884:
      if ((i == 3) || (i == 2))
      {
        localbaub.jdField_a_of_type_Long = this.jdField_a_of_type_Bayk.i;
        localbaub.jdField_b_of_type_Long = (this.jdField_a_of_type_Bayk.i + this.jdField_a_of_type_Bayk.jdField_j_of_type_Int - 1);
        localbaub.jdField_j_of_type_Boolean = false;
        str = "bytes=" + this.jdField_a_of_type_Bayk.i + "-" + localbaub.jdField_b_of_type_Long;
        localbaub.jdField_a_of_type_JavaUtilHashMap.put("Range", str);
      }
      else
      {
        localbaub.jdField_b_of_type_Long = 0L;
        localbaub.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localbaub.jdField_a_of_type_Long + "-");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baro
 * JD-Core Version:    0.7.0.1
 */