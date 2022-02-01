import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class betu
  extends berk
{
  long jdField_c_of_type_Long;
  byte[] jdField_c_of_type_ArrayOfByte;
  boolean s = true;
  
  public betu() {}
  
  public betu(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    this.jdField_a_of_type_Bete.jdField_b_of_type_Int = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bete.jdField_b_of_type_Long = this.jdField_a_of_type_Beyg.jdField_a_of_type_Long;
    this.jdField_a_of_type_Bete.jdField_c_of_type_Long = this.jdField_a_of_type_Beyg.jdField_b_of_type_Long;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Beyg.jdField_g_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Beyg.jdField_e_of_type_Int == 1030) || ((!paramBoolean) && (bewk.a(this.jdField_k_of_type_Int))) || (this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.n & 0x2) > 0)) || ((!paramBoolean) && ((this.n & 0x1) > 0))) {
      return false;
    }
    return true;
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
    if (!a(paramBoolean)) {
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
        break label939;
      }
      l1 = this.jdField_d_of_type_Berr.a();
      label299:
      ((HashMap)localObject1).put("param_trans_consume", String.valueOf(l1));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Beyg.jdField_g_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_k_of_type_Boolean));
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      l1 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_Beyj != null) {
        break label951;
      }
      i = 0;
      label424:
      ((HashMap)localObject1).put("param_recvDataLen", String.valueOf(l1 - i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailCode", String.valueOf(this.jdField_d_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailDesc", "" + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_inQueueCost", "" + this.p);
      this.jdField_a_of_type_JavaUtilHashMap.put("ipFromDns", "" + this.jdField_f_of_type_Boolean);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_encryptRollback", "" + this.i + ",decryptErrorMsg:" + this.jdField_f_of_type_JavaLangString);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.i) {
        break label962;
      }
      localObject1 = "1";
      label624:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_e_of_type_Boolean) {
        break label970;
      }
      localObject1 = "1";
      label653:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.jdField_a_of_type_Bevl != null) && (((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_Beun != null))
      {
        localObject1 = (beum)this.jdField_a_of_type_Bevl;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((beum)localObject1).jdField_a_of_type_Beun).jdField_a_of_type_Long));
      }
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int != 1) {
        break label978;
      }
      i = 1;
      label731:
      if (i != 0)
      {
        i = -1;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_groupPolicy", String.valueOf(i));
      }
      localObject2 = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
        }
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      e(paramBoolean);
      if (!paramBoolean) {
        break label983;
      }
      b(true, l2);
      bdmc.a(BaseApplication.getContext()).a(null, c(), true, l2, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      m();
      super.a(paramBoolean, "GroupPicDownloadErrorCode", l2, this.jdField_a_of_type_JavaUtilHashMap);
      return;
      i = 1;
      break;
      label939:
      l1 = this.jdField_b_of_type_Berr.a();
      break label299;
      label951:
      i = this.jdField_a_of_type_Beyj.jdField_a_of_type_Int;
      break label424;
      label962:
      localObject1 = "0";
      break label624;
      label970:
      localObject1 = "0";
      break label653;
      label978:
      i = 0;
      break label731;
      label983:
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
    return (this.jdField_a_of_type_Beyg.n) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x2) != 0);
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
    a("gchat.qpic.cn", 1000);
  }
  
  public void b(int paramInt, String paramString)
  {
    super.b(paramInt, paramString);
    if ((paramInt != 9302) || (!QLog.isColorLevel())) {
      return;
    }
    paramString = this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString;
    paramString = "setError,uuid:" + paramString + " md5:" + this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString;
    QLog.d("BaseTransProcessor", 1, paramString);
    bdlr.a("Download_Pic_Error_Param_Check", paramString);
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
      this.jdField_b_of_type_JavaLangString = "gchat.qpic.cn";
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
        break label705;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localbeum.jdField_g_of_type_Boolean = false;
      localbeum.jdField_b_of_type_JavaLangString = "gchat.qpic.cn";
      localObject = (String)localObject + "gchat.qpic.cn";
      localObject = a((String)localObject + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_g_of_type_Int);
      localbeum.jdField_a_of_type_Beuq = this;
      localbeum.jdField_a_of_type_Beur = this;
      localbeum.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbeum.jdField_f_of_type_Boolean = paramBoolean;
      localbeum.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localbeum.jdField_a_of_type_Int = 0;
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaLangString);
      localbeum.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_a_of_type_Bewo != null) {
        localbeum.jdField_a_of_type_Bewq = this.jdField_a_of_type_Bewo.a();
      }
      localbeum.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.h;
      if (this.jdField_a_of_type_Beyg.jdField_d_of_type_Boolean) {
        localbeum.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaIoOutputStream;
      }
      localbeum.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
      localbeum.jdField_f_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
      localbeum.jdField_e_of_type_Int = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
      localbeum.l = true;
      localbeum.jdField_a_of_type_Long = 0L;
      localbeum.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
      i = a(this.jdField_a_of_type_Beyg);
      if (i != 4) {
        break label903;
      }
      localbeum.jdField_a_of_type_Long = this.jdField_a_of_type_Beyg.i;
      localbeum.jdField_b_of_type_Long = 0L;
      localbeum.jdField_k_of_type_Boolean = false;
      str = "bytes=" + this.jdField_a_of_type_Beyg.i + "-";
      localbeum.jdField_a_of_type_JavaUtilHashMap.put("Range", str);
    }
    for (;;)
    {
      localbeum.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localbeum.jdField_a_of_type_Beup = jdField_a_of_type_Beup;
      localbeum.jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
      a(localbeum, (String)localObject);
      localbeum.m = true;
      localbeum.jdField_d_of_type_Boolean = true;
      localbeum.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCu");
      localbeum.jdField_d_of_type_Int = this.jdField_a_of_type_Beyg.jdField_f_of_type_Int;
      if (this.jdField_a_of_type_Boolean) {
        localbeum.jdField_b_of_type_Int = 0;
      }
      localObject = null;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        localObject = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
      b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + ",req.mReqUrl = " + localbeum.jdField_a_of_type_JavaLangString + " ipList:" + (String)localObject + " uuid:" + this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_Beyg.jdField_c_of_type_Long + " downOffset:" + localbeum.jdField_a_of_type_Long + ",isEncryptUrl:" + this.h + ",isEncryptPic:" + this.jdField_g_of_type_Boolean + ",isEncryptRollbackReq:" + this.i);
      if (!f()) {
        break;
      }
      this.jdField_a_of_type_Bevl = localbeum;
      o();
      this.jdField_a_of_type_Beuo.a(localbeum);
      return;
      localObject = "http://";
      break label62;
      label705:
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
      label903:
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
    int i = 0;
    b("uiParam", this.jdField_a_of_type_Beyg.toString());
    String str1 = this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString;
    if ((str1 == null) || (str1.equals("")) || (str1.equals("null")) || (bhmi.c(str1)) || (str1.startsWith("http://")))
    {
      if ((str1 == null) || (!str1.startsWith("http://"))) {
        break label191;
      }
      String str2 = d(str1);
      if (str2 != null) {
        this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString = str2;
      }
    }
    else
    {
      if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaIoOutputStream != null) || (!this.jdField_a_of_type_Beyg.jdField_d_of_type_Boolean)) {
        break label234;
      }
      b(9302, a(new Exception("no output stream")));
      d();
      i = -1;
      return i;
    }
    b(9302, a(new Exception("uuid illegal " + str1)));
    d();
    return -1;
    label191:
    b(9302, a(new Exception("uuid illegal " + str1)));
    d();
    return -1;
    label234:
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject instanceof beyj)))
    {
      b(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_Beyj = ((beyj)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Beyj.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        this.s = bool;
        try
        {
          this.jdField_c_of_type_ArrayOfByte = a(this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString);
          this.jdField_c_of_type_Long = this.jdField_a_of_type_Beyg.jdField_c_of_type_Long;
          if (this.jdField_c_of_type_ArrayOfByte != null) {
            break;
          }
          b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString)));
          d();
          return -1;
        }
        catch (Exception localException)
        {
          b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString)));
          d();
        }
      }
    }
    return -1;
  }
  
  protected String c()
  {
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 65537) {
        return "actGroupPicSmallDownV1";
      }
      return "actGroupPicDownloadV1";
    }
    if (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 65537) {
      return "actDiscussPicSmallDown";
    }
    return "actDiscussPicDown";
  }
  
  String d(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null) {
      localObject = paramString;
    }
    try
    {
      if (paramString.startsWith("/")) {
        localObject = paramString.substring(1);
      }
      if ((localObject != null) && (!((String)localObject).equals("null")) && (!((String)localObject).startsWith("http://"))) {}
      do
      {
        do
        {
          do
          {
            return null;
          } while ((localObject == null) || (((String)localObject).length() <= 0) || (!((String)localObject).contains("?")));
          i = ((String)localObject).indexOf("?");
        } while ((i < 0) || (i >= ((String)localObject).length() - 1));
        localObject = ((String)localObject).substring(i + 1).split("\\&");
      } while (localObject == null);
      paramString = null;
      int i = 0;
      while (i < localObject.length)
      {
        if (localObject[i].startsWith("pic=")) {
          paramString = localObject[i].substring(4);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = paramString;
      }
    }
    return paramString;
  }
  
  void f()
  {
    this.jdField_a_of_type_Berr.a();
    this.jdField_a_of_type_Boolean = false;
    bfau localbfau = new bfau();
    bfax localbfax = new bfax();
    localbfax.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString;
    localbfax.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfax.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_d_of_type_JavaLangString;
    localbfax.jdField_f_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbfax.jdField_a_of_type_Int = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
    localbfax.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    localbfax.jdField_a_of_type_ArrayOfByte = this.jdField_c_of_type_ArrayOfByte;
    localbfax.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Beyg.jdField_d_of_type_Long);
    localbfax.jdField_c_of_type_Int = 0;
    localbfau.jdField_a_of_type_Bfcb = this;
    localbfau.jdField_a_of_type_JavaLangString = "grp_pic_dw";
    localbfau.jdField_a_of_type_JavaUtilList.add(localbfax);
    localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
      d();
    }
    do
    {
      return;
      QLog.d("BaseTransProcessor", 1, "sendGroupPicDownRequest:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        b("requestStart", localbfau.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bfau = localbfau;
    bfca.a(localbfau);
  }
  
  protected void o()
  {
    int i = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_Bevl instanceof beum))
    {
      if (!this.s) {
        break label72;
      }
      if (i == 2) {
        ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttGd");
      }
    }
    else
    {
      return;
    }
    ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaUtilHashMap.put("mType", "picGd");
    return;
    label72:
    if (i == 2)
    {
      ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttDd");
      return;
    }
    ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaUtilHashMap.put("mType", "picDd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betu
 * JD-Core Version:    0.7.0.1
 */