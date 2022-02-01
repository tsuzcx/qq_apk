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

public class bdva
  extends bdss
{
  long jdField_c_of_type_Long;
  byte[] jdField_c_of_type_ArrayOfByte;
  boolean s = true;
  
  public bdva() {}
  
  public bdva(bdzi parambdzi, bdzn parambdzn)
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
      localObject1 = this.d.a(1) + ";" + this.jdField_a_of_type_Bdsz.a(2) + ";" + this.jdField_b_of_type_Bdsz.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_a_of_type_Boolean) {
        break label1000;
      }
      l1 = this.d.a();
      label361:
      ((HashMap)localObject1).put("param_trans_consume", String.valueOf(l1));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Bdzn.g));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_k_of_type_Boolean));
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      l1 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_Bdzq != null) {
        break label1012;
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
        break label1023;
      }
      localObject1 = "1";
      label685:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_e_of_type_Boolean) {
        break label1031;
      }
      localObject1 = "1";
      label714:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.jdField_a_of_type_Bdws != null) && (((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_Bdvt != null))
      {
        localObject1 = (bdvs)this.jdField_a_of_type_Bdws;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((bdvs)localObject1).jdField_a_of_type_Bdvt).jdField_a_of_type_Long));
      }
      if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int != 1) {
        break label1039;
      }
      i = 1;
      label792:
      if (i != 0)
      {
        i = -1;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_groupPolicy", String.valueOf(i));
      }
      localObject2 = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
        }
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      e(paramBoolean);
      if (!paramBoolean) {
        break label1044;
      }
      b(true, l2);
      bctj.a(BaseApplication.getContext()).a(null, c(), true, l2, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      m();
      super.a(paramBoolean, "GroupPicDownloadErrorCode", l2, this.jdField_a_of_type_JavaUtilHashMap);
      return;
      i = 1;
      break;
      label1000:
      l1 = this.jdField_b_of_type_Bdsz.a();
      break label361;
      label1012:
      i = this.jdField_a_of_type_Bdzq.jdField_a_of_type_Int;
      break label486;
      label1023:
      localObject1 = "0";
      break label685;
      label1031:
      localObject1 = "0";
      break label714;
      label1039:
      i = 0;
      break label792;
      label1044:
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
    return (this.jdField_a_of_type_Bdzn.m) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x2) != 0);
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
    a("gchat.qpic.cn", 1000);
  }
  
  public void b(int paramInt, String paramString)
  {
    super.b(paramInt, paramString);
    if ((paramInt != 9302) || (!QLog.isColorLevel())) {
      return;
    }
    paramString = this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString;
    paramString = "setError,uuid:" + paramString + " md5:" + this.jdField_a_of_type_Bdzn.jdField_f_of_type_JavaLangString;
    QLog.d("BaseTransProcessor", 1, paramString);
    bcsz.a("Download_Pic_Error_Param_Check", paramString);
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
      this.jdField_b_of_type_JavaLangString = "gchat.qpic.cn";
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
        break label705;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localbdvs.g = false;
      localbdvs.jdField_b_of_type_JavaLangString = "gchat.qpic.cn";
      localObject = (String)localObject + "gchat.qpic.cn";
      localObject = a((String)localObject + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.g);
      localbdvs.jdField_a_of_type_Bdvw = this;
      localbdvs.jdField_a_of_type_Bdvx = this;
      localbdvs.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbdvs.jdField_f_of_type_Boolean = paramBoolean;
      localbdvs.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localbdvs.jdField_a_of_type_Int = 0;
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaLangString);
      localbdvs.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_a_of_type_Bdxv != null) {
        localbdvs.jdField_a_of_type_Bdxx = this.jdField_a_of_type_Bdxv.a();
      }
      localbdvs.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.h;
      if (this.jdField_a_of_type_Bdzn.jdField_c_of_type_Boolean) {
        localbdvs.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaIoOutputStream;
      }
      localbdvs.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
      localbdvs.jdField_f_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
      localbdvs.jdField_e_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int;
      localbdvs.l = true;
      localbdvs.jdField_a_of_type_Long = 0L;
      localbdvs.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
      i = a(this.jdField_a_of_type_Bdzn);
      if (i != 4) {
        break label903;
      }
      localbdvs.jdField_a_of_type_Long = this.jdField_a_of_type_Bdzn.i;
      localbdvs.jdField_b_of_type_Long = 0L;
      localbdvs.jdField_k_of_type_Boolean = false;
      str = "bytes=" + this.jdField_a_of_type_Bdzn.i + "-";
      localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Range", str);
    }
    for (;;)
    {
      localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localbdvs.jdField_a_of_type_Bdvv = jdField_a_of_type_Bdvv;
      localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
      a(localbdvs, (String)localObject);
      localbdvs.m = true;
      localbdvs.jdField_d_of_type_Boolean = true;
      localbdvs.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCu");
      localbdvs.jdField_d_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_f_of_type_Int;
      if (this.jdField_a_of_type_Boolean) {
        localbdvs.jdField_b_of_type_Int = 0;
      }
      localObject = null;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        localObject = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
      b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + ",req.mReqUrl = " + localbdvs.jdField_a_of_type_JavaLangString + " ipList:" + (String)localObject + " uuid:" + this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_Bdzn.jdField_c_of_type_Long + " downOffset:" + localbdvs.jdField_a_of_type_Long + ",isEncryptUrl:" + this.h + ",isEncryptPic:" + this.g + ",isEncryptRollbackReq:" + this.i);
      if (!f()) {
        break;
      }
      this.jdField_a_of_type_Bdws = localbdvs;
      o();
      this.jdField_a_of_type_Bdvu.a(localbdvs);
      return;
      localObject = "http://";
      break label62;
      label705:
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
      label903:
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
    int i = 0;
    b("uiParam", this.jdField_a_of_type_Bdzn.toString());
    String str1 = this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString;
    if ((str1 == null) || (str1.equals("")) || (str1.equals("null")) || (bgmg.c(str1)) || (str1.startsWith("http://")))
    {
      if ((str1 == null) || (!str1.startsWith("http://"))) {
        break label191;
      }
      String str2 = d(str1);
      if (str2 != null) {
        this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString = str2;
      }
    }
    else
    {
      if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaIoOutputStream != null) || (!this.jdField_a_of_type_Bdzn.jdField_c_of_type_Boolean)) {
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
    if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject instanceof bdzq)))
    {
      b(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_Bdzq = ((bdzq)this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Bdzq.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        this.s = bool;
        try
        {
          this.jdField_c_of_type_ArrayOfByte = a(this.jdField_a_of_type_Bdzn.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString);
          this.jdField_c_of_type_Long = this.jdField_a_of_type_Bdzn.jdField_c_of_type_Long;
          if (this.jdField_c_of_type_ArrayOfByte != null) {
            break;
          }
          b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Bdzn.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString)));
          d();
          return -1;
        }
        catch (Exception localException)
        {
          b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Bdzn.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString)));
          d();
        }
      }
    }
    return -1;
  }
  
  protected String c()
  {
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int == 65537) {
        return "actGroupPicSmallDownV1";
      }
      return "actGroupPicDownloadV1";
    }
    if (this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int == 65537) {
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
    this.jdField_a_of_type_Bdsz.a();
    this.jdField_a_of_type_Boolean = false;
    bebv localbebv = new bebv();
    beby localbeby = new beby();
    localbeby.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString;
    localbeby.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString;
    localbeby.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_d_of_type_JavaLangString;
    localbeby.jdField_f_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    localbeby.jdField_a_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int;
    localbeby.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    localbeby.jdField_a_of_type_ArrayOfByte = this.jdField_c_of_type_ArrayOfByte;
    localbeby.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Bdzn.jdField_d_of_type_Long);
    localbeby.jdField_c_of_type_Int = 0;
    localbebv.jdField_a_of_type_Bedc = this;
    localbebv.jdField_a_of_type_JavaLangString = "grp_pic_dw";
    localbebv.jdField_a_of_type_JavaUtilList.add(localbeby);
    localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Bdsz);
      d();
    }
    do
    {
      return;
      QLog.d("BaseTransProcessor", 1, "sendGroupPicDownRequest:" + this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        b("requestStart", localbebv.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bebv = localbebv;
    bedb.a(localbebv);
  }
  
  protected void o()
  {
    int i = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_Bdws instanceof bdvs))
    {
      if (!this.s) {
        break label72;
      }
      if (i == 2) {
        ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttGd");
      }
    }
    else
    {
      return;
    }
    ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaUtilHashMap.put("mType", "picGd");
    return;
    label72:
    if (i == 2)
    {
      ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttDd");
      return;
    }
    ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaUtilHashMap.put("mType", "picDd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdva
 * JD-Core Version:    0.7.0.1
 */