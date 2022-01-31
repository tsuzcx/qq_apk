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

public class baoz
  extends bams
{
  long jdField_c_of_type_Long;
  byte[] jdField_c_of_type_ArrayOfByte;
  boolean q = true;
  
  public baoz() {}
  
  public baoz(batw parambatw, baub parambaub)
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
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Baub.jdField_g_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Baub.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.i));
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      long l2 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_Baue != null) {
        break label960;
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
        break label971;
      }
      localObject1 = "1";
      label646:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_g_of_type_Boolean) {
        break label979;
      }
      localObject1 = "1";
      label675:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.jdField_a_of_type_Baqv != null) && (((baps)this.jdField_a_of_type_Baqv).jdField_a_of_type_Bapu != null))
      {
        localObject1 = (baps)this.jdField_a_of_type_Baqv;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((baps)localObject1).jdField_a_of_type_Bapu).jdField_a_of_type_Long));
      }
      if (this.jdField_a_of_type_Baub.jdField_a_of_type_Int != 1) {
        break label987;
      }
      i = 1;
      label753:
      if (i != 0)
      {
        i = -1;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_groupPolicy", String.valueOf(i));
      }
      localObject2 = this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Long);
        }
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      f(paramBoolean);
      if (!paramBoolean) {
        break label992;
      }
      b(true, l1);
      azmz.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      l();
      super.a(paramBoolean, "GroupPicDownloadErrorCode", l1, this.jdField_a_of_type_JavaUtilHashMap);
      return;
      i = 1;
      break;
      label960:
      i = this.jdField_a_of_type_Baue.jdField_a_of_type_Int;
      break label451;
      label971:
      localObject1 = "0";
      break label646;
      label979:
      localObject1 = "0";
      break label675;
      label987:
      i = 0;
      break label753;
      label992:
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
    return (this.jdField_a_of_type_Baub.m) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x2) != 0);
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
    a("gchat.qpic.cn", 1000);
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_Baub.jdField_b_of_type_Int == 65537) {
        return "actGroupPicSmallDownV1";
      }
      return "actGroupPicDownloadV1";
    }
    if (this.jdField_a_of_type_Baub.jdField_b_of_type_Int == 65537) {
      return "actDiscussPicSmallDown";
    }
    return "actDiscussPicDown";
  }
  
  public void b(int paramInt, String paramString)
  {
    super.b(paramInt, paramString);
    if ((paramInt != 9302) || (!QLog.isColorLevel())) {
      return;
    }
    paramString = this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString;
    paramString = "setError,uuid:" + paramString + " md5:" + this.jdField_a_of_type_Baub.jdField_f_of_type_JavaLangString;
    QLog.d("BaseTransProcessor", 1, paramString);
    azmp.a("Download_Pic_Error_Param_Check", paramString);
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bamy.a();
    this.jdField_a_of_type_Boolean = false;
    bawo localbawo = new bawo();
    bawr localbawr = new bawr();
    localbawr.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_b_of_type_JavaLangString;
    localbawr.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString;
    localbawr.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_d_of_type_JavaLangString;
    localbawr.jdField_f_of_type_Int = this.jdField_a_of_type_Baub.jdField_a_of_type_Int;
    localbawr.jdField_a_of_type_Int = this.jdField_a_of_type_Baub.jdField_b_of_type_Int;
    localbawr.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    localbawr.jdField_a_of_type_ArrayOfByte = this.jdField_c_of_type_ArrayOfByte;
    localbawr.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Baub.jdField_d_of_type_Long);
    if (paramBoolean)
    {
      localbawr.jdField_c_of_type_Int = 0;
      localbawo.jdField_a_of_type_Baxv = this;
      localbawo.jdField_a_of_type_JavaLangString = "grp_pic_dw";
      localbawo.jdField_a_of_type_JavaUtilList.add(localbawr);
      localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label189;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Bamy);
      d();
    }
    label189:
    do
    {
      return;
      localbawr.jdField_c_of_type_Int = 1;
      break;
      QLog.d("BaseTransProcessor", 1, "sendGroupPicDownRequest:" + this.jdField_a_of_type_Baub.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        b("requestStart", localbawo.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bawo = localbawo;
    baxu.a(localbawo);
  }
  
  public int c()
  {
    int i = 0;
    b("uiParam", this.jdField_a_of_type_Baub.toString());
    String str1 = this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString;
    if ((str1 == null) || (str1.equals("")) || (str1.equals("null")) || (bdcs.c(str1)) || (str1.startsWith("http://")))
    {
      if ((str1 == null) || (!str1.startsWith("http://"))) {
        break label190;
      }
      String str2 = e(str1);
      if (str2 != null) {
        this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString = str2;
      }
    }
    else
    {
      if ((this.jdField_a_of_type_Baub.jdField_a_of_type_JavaIoOutputStream != null) || (!this.jdField_a_of_type_Baub.jdField_c_of_type_Boolean)) {
        break label233;
      }
      b(9302, a(new Exception("no output stream")));
      d();
      i = -1;
      return i;
    }
    b(9302, a(new Exception("uuid illegal " + str1)));
    d();
    return -1;
    label190:
    b(9302, a(new Exception("uuid illegal " + str1)));
    d();
    return -1;
    label233:
    if ((this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject instanceof baue)))
    {
      b(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_Baue = ((baue)this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Baue.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        this.q = bool;
        try
        {
          this.jdField_c_of_type_ArrayOfByte = a(this.jdField_a_of_type_Baub.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString);
          this.jdField_c_of_type_Long = this.jdField_a_of_type_Baub.jdField_c_of_type_Long;
          if (this.jdField_c_of_type_ArrayOfByte != null) {
            break;
          }
          b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Baub.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString)));
          d();
          return -1;
        }
        catch (Exception localException)
        {
          b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Baub.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString)));
          d();
        }
      }
    }
    return -1;
  }
  
  void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Bamy.a();
    if (this.o) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "gchat.qpic.cn";
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
        break label692;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localbaps.jdField_g_of_type_Boolean = false;
      localbaps.jdField_b_of_type_JavaLangString = "gchat.qpic.cn";
      localObject = (String)localObject + "gchat.qpic.cn";
      localObject = a((String)localObject + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_g_of_type_Int);
      localbaps.jdField_a_of_type_Bapx = this;
      localbaps.jdField_a_of_type_Bapy = this;
      localbaps.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbaps.jdField_f_of_type_Boolean = paramBoolean;
      localbaps.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localbaps.jdField_a_of_type_Int = 0;
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaLangString);
      localbaps.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_a_of_type_Basf != null) {
        localbaps.jdField_a_of_type_Bash = this.jdField_a_of_type_Basf.a();
      }
      localbaps.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Baub.h;
      if (this.jdField_a_of_type_Baub.jdField_c_of_type_Boolean) {
        localbaps.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Baub.jdField_a_of_type_JavaIoOutputStream;
      }
      localbaps.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Baub.jdField_a_of_type_Long);
      localbaps.jdField_g_of_type_Int = this.jdField_a_of_type_Baub.jdField_a_of_type_Int;
      localbaps.jdField_f_of_type_Int = this.jdField_a_of_type_Baub.jdField_b_of_type_Int;
      localbaps.k = true;
      localbaps.jdField_a_of_type_Long = 0L;
      localbaps.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
      i = a(this.jdField_a_of_type_Baub);
      if (i != 4) {
        break label890;
      }
      localbaps.jdField_a_of_type_Long = this.jdField_a_of_type_Baub.i;
      localbaps.jdField_b_of_type_Long = 0L;
      localbaps.jdField_j_of_type_Boolean = false;
      str = "bytes=" + this.jdField_a_of_type_Baub.i + "-";
      localbaps.jdField_a_of_type_JavaUtilHashMap.put("Range", str);
    }
    for (;;)
    {
      localbaps.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localbaps.jdField_a_of_type_Bapw = jdField_a_of_type_Bapw;
      localbaps.jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
      a(localbaps, (String)localObject);
      localbaps.l = true;
      localbaps.jdField_d_of_type_Boolean = true;
      localbaps.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCu");
      localbaps.jdField_e_of_type_Int = this.jdField_a_of_type_Baub.jdField_f_of_type_Int;
      if (this.jdField_a_of_type_Boolean) {
        localbaps.jdField_c_of_type_Int = 0;
      }
      localObject = null;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        localObject = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
      b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + ",req.mReqUrl = " + localbaps.jdField_a_of_type_JavaLangString + " ipList:" + (String)localObject + " uuid:" + this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_Baub.jdField_c_of_type_Long + " downOffset:" + localbaps.jdField_a_of_type_Long + ",isEncryptUrl:" + this.jdField_e_of_type_Boolean + ",isEncryptPic:" + this.jdField_d_of_type_Boolean + ",isEncryptRollbackReq:" + this.jdField_f_of_type_Boolean);
      if (!f()) {
        break;
      }
      this.jdField_a_of_type_Baqv = localbaps;
      n();
      this.jdField_a_of_type_Bapv.a(localbaps);
      return;
      localObject = "http://";
      break label49;
      label692:
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
      label890:
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
  
  String e(String paramString)
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
  
  protected void n()
  {
    int i = this.jdField_a_of_type_Baub.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_Baqv instanceof baps))
    {
      if (!this.q) {
        break label72;
      }
      if (i == 2) {
        ((baps)this.jdField_a_of_type_Baqv).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttGd");
      }
    }
    else
    {
      return;
    }
    ((baps)this.jdField_a_of_type_Baqv).jdField_a_of_type_JavaUtilHashMap.put("mType", "picGd");
    return;
    label72:
    if (i == 2)
    {
      ((baps)this.jdField_a_of_type_Baqv).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttDd");
      return;
    }
    ((baps)this.jdField_a_of_type_Baqv).jdField_a_of_type_JavaUtilHashMap.put("mType", "picDd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baoz
 * JD-Core Version:    0.7.0.1
 */