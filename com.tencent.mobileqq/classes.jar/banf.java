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

public class banf
  extends bams
{
  public banf() {}
  
  public banf(batw parambatw, baub parambaub)
  {
    super(parambatw, parambaub);
    this.jdField_a_of_type_Baoj.jdField_b_of_type_Int = this.jdField_a_of_type_Baub.jdField_b_of_type_Int;
    this.jdField_a_of_type_Baoj.jdField_b_of_type_Long = this.jdField_a_of_type_Baub.jdField_a_of_type_Long;
    this.jdField_a_of_type_Baoj.jdField_c_of_type_Long = this.jdField_a_of_type_Baub.jdField_b_of_type_Long;
  }
  
  public void a(bawo parambawo, baxd parambaxd)
  {
    this.jdField_a_of_type_Bawo = null;
    if (parambaxd != null)
    {
      int i = 0;
      if (i < parambaxd.jdField_a_of_type_JavaUtilList.size())
      {
        parambawo = (baxp)parambaxd.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambawo.toString());
        }
        this.i = parambawo.jdField_d_of_type_Boolean;
        a(this.jdField_a_of_type_Bamy, parambawo);
        if (parambawo.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList = a(parambawo.jdField_b_of_type_JavaUtilArrayList, parambawo.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_b_of_type_JavaLangString = parambawo.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = parambawo.jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            b("proUrl", "picResp.protocolType = " + parambawo.jdField_a_of_type_Int);
          }
          if (parambawo.jdField_a_of_type_Int == 1)
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
      localObject1 = "Q.richmedia." + basj.b(this.jdField_a_of_type_Baub.jdField_a_of_type_Int) + "." + basj.a(this.jdField_a_of_type_Baub.jdField_b_of_type_Int);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.jdField_a_of_type_Baub.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.jdField_j_of_type_Int + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.jdField_j_of_type_JavaLangString);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (!this.jdField_a_of_type_Baub.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Baub.jdField_e_of_type_Int == 1030) || ((!paramBoolean) && (basb.b(this.jdField_j_of_type_Int))) || (this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
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
      localObject1 = this.jdField_d_of_type_Bamy.a(1) + ";" + this.jdField_a_of_type_Bamy.a(2) + ";" + this.jdField_b_of_type_Bamy.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Baub.jdField_g_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Baub.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.i));
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      long l2 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_Baue != null) {
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
      if ((this.jdField_a_of_type_Baqv != null) && (((baps)this.jdField_a_of_type_Baqv).jdField_a_of_type_Bapu != null))
      {
        localObject1 = (baps)this.jdField_a_of_type_Baqv;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((baps)localObject1).jdField_a_of_type_Bapu).jdField_a_of_type_Long));
      }
      localObject2 = this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Long);
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      f(paramBoolean);
      if (!paramBoolean) {
        break label919;
      }
      b(true, l1);
      azmz.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      l();
      super.a(paramBoolean, "C2CPicDownloadErrorCode", l1, this.jdField_a_of_type_JavaUtilHashMap);
      return;
      i = 1;
      break;
      label892:
      i = this.jdField_a_of_type_Baue.jdField_a_of_type_Int;
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
      azmz.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.jdField_a_of_type_Baub.m) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x1) != 0);
  }
  
  public void aS_()
  {
    super.aS_();
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
      b("reportFailed", banq.a(localException));
    }
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_Baub.jdField_b_of_type_Int == 65537) {
      return "actC2CPicSmallDownV1";
    }
    return "actC2CPicDownloadV1";
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bamy.a();
    this.jdField_a_of_type_Boolean = false;
    bawo localbawo = new bawo();
    bawp localbawp = new bawp();
    localbawp.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_b_of_type_JavaLangString;
    localbawp.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString;
    localbawp.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_d_of_type_JavaLangString;
    localbawp.jdField_f_of_type_Int = this.jdField_a_of_type_Baub.jdField_a_of_type_Int;
    localbawp.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString;
    localbawp.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Baub.jdField_d_of_type_Long);
    MessageRecord localMessageRecord2 = this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    MessageRecord localMessageRecord1 = localMessageRecord2;
    if (localMessageRecord2 == null) {
      localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Long);
    }
    boolean bool;
    if ((localMessageRecord1 != null) && ((localMessageRecord1 instanceof MessageForPic)))
    {
      this.jdField_d_of_type_JavaLangString = ((MessageForPic)localMessageRecord1).serverStoreSource;
      localbawp.jdField_b_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localbawp.jdField_a_of_type_Int = this.jdField_a_of_type_Baub.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Baub.jdField_a_of_type_Int != 1006) {
        break label312;
      }
      bool = true;
      label210:
      localbawp.jdField_a_of_type_Boolean = bool;
      if (!paramBoolean) {
        break label317;
      }
      localbawp.jdField_c_of_type_Int = 0;
      label226:
      localbawo.jdField_a_of_type_Baxv = this;
      localbawo.jdField_a_of_type_JavaLangString = "c2c_pic_dw";
      localbawo.jdField_a_of_type_JavaUtilList.add(localbawp);
      localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label326;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Bamy);
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
      localbawp.jdField_c_of_type_Int = 1;
      break label226;
      if (QLog.isColorLevel()) {
        b("requestStart", localbawo.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bawo = localbawo;
    baxu.a(localbawo);
  }
  
  public int c()
  {
    b("uiParam", this.jdField_a_of_type_Baub.toString());
    String str = this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (bdcs.c(str)) || (str.startsWith("http")))
    {
      b(9302, a(new Exception("uuid illegal " + str)));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Baub.jdField_a_of_type_JavaIoOutputStream == null) && (this.jdField_a_of_type_Baub.jdField_c_of_type_Boolean))
    {
      b(9302, a(new Exception("no output stream")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject instanceof baue)))
    {
      b(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_Baue = ((baue)this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Baue.jdField_a_of_type_Int;
    return 0;
  }
  
  void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Bamy.a();
    if (this.o) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "c2cpicdw.qpic.cn";
    }
    baps localbaps = new baps();
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
      localbaps.jdField_g_of_type_Boolean = false;
      localbaps.jdField_b_of_type_JavaLangString = "c2cpicdw.qpic.cn";
      localObject = (String)localObject + "c2cpicdw.qpic.cn";
      localObject = a((String)localObject + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_g_of_type_Int);
      localbaps.jdField_a_of_type_Bapx = this;
      localbaps.jdField_a_of_type_Bapy = this;
      localbaps.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbaps.jdField_f_of_type_Boolean = paramBoolean;
      localbaps.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localbaps.jdField_a_of_type_Int = 0;
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaLangString);
      localbaps.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      localbaps.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Baub.h;
      if (this.jdField_a_of_type_Baub.jdField_c_of_type_Boolean) {
        localbaps.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Baub.jdField_a_of_type_JavaIoOutputStream;
      }
      localbaps.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Baub.jdField_a_of_type_Long);
      localbaps.jdField_g_of_type_Int = this.jdField_a_of_type_Baub.jdField_a_of_type_Int;
      localbaps.jdField_f_of_type_Int = this.jdField_a_of_type_Baub.jdField_b_of_type_Int;
      localbaps.jdField_a_of_type_Long = 0L;
      localbaps.k = true;
      i = a(this.jdField_a_of_type_Baub);
      if (i != 4) {
        break label884;
      }
      localbaps.jdField_a_of_type_Long = this.jdField_a_of_type_Baub.i;
      localbaps.jdField_b_of_type_Long = 0L;
      localbaps.jdField_j_of_type_Boolean = false;
      str = "bytes=" + this.jdField_a_of_type_Baub.i + "-";
      localbaps.jdField_a_of_type_JavaUtilHashMap.put("Range", str);
    }
    for (;;)
    {
      a(localbaps, (String)localObject);
      localbaps.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localbaps.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCd");
      localbaps.jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
      localbaps.jdField_a_of_type_Bapw = jdField_a_of_type_Bapw;
      localbaps.jdField_e_of_type_Int = this.jdField_a_of_type_Baub.jdField_f_of_type_Int;
      if (this.jdField_a_of_type_Basf != null) {
        localbaps.jdField_a_of_type_Bash = this.jdField_a_of_type_Basf.a();
      }
      localbaps.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
      localbaps.l = true;
      localbaps.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_Boolean) {
        localbaps.jdField_c_of_type_Long = 0L;
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
      b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + " ipList:" + (String)localObject + " uniSeq:" + localbaps.jdField_e_of_type_JavaLangString + " uuid:" + this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString + ",downOffset:" + localbaps.jdField_a_of_type_Long + ",isEncryptUrl:" + this.jdField_e_of_type_Boolean + ",isEncryptPic:" + this.jdField_d_of_type_Boolean + ",isEncryptRollbackReq:" + this.jdField_f_of_type_Boolean);
      if (!f()) {
        break;
      }
      this.jdField_a_of_type_Baqv = localbaps;
      this.jdField_a_of_type_Bapv.a(localbaps);
      return;
      localObject = "http://";
      break label49;
      label686:
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localbaps.jdField_g_of_type_Boolean = true;
        basp localbasp = (basp)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((localbasp.jdField_a_of_type_Boolean) && (!localbasp.jdField_a_of_type_JavaLangString.startsWith("["))) {}
        for (str = (String)localObject + "[" + localbasp.jdField_a_of_type_JavaLangString + "]";; str = (String)localObject + localbasp.jdField_a_of_type_JavaLangString)
        {
          localObject = str;
          if (localbasp.jdField_a_of_type_Int == 80) {
            break;
          }
          localObject = str + ":" + localbasp.jdField_a_of_type_Int;
          break;
        }
      }
      localbaps.jdField_g_of_type_Boolean = false;
      localObject = (String)localObject + this.jdField_b_of_type_JavaLangString;
      break label98;
      label884:
      if ((i == 3) || (i == 2))
      {
        localbaps.jdField_a_of_type_Long = this.jdField_a_of_type_Baub.i;
        localbaps.jdField_b_of_type_Long = (this.jdField_a_of_type_Baub.i + this.jdField_a_of_type_Baub.jdField_j_of_type_Int - 1);
        localbaps.jdField_j_of_type_Boolean = false;
        str = "bytes=" + this.jdField_a_of_type_Baub.i + "-" + localbaps.jdField_b_of_type_Long;
        localbaps.jdField_a_of_type_JavaUtilHashMap.put("Range", str);
      }
      else
      {
        localbaps.jdField_b_of_type_Long = 0L;
        localbaps.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localbaps.jdField_a_of_type_Long + "-");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banf
 * JD-Core Version:    0.7.0.1
 */