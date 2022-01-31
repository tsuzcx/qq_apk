import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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

public class ayre
  extends ayox
{
  long jdField_c_of_type_Long;
  byte[] jdField_c_of_type_ArrayOfByte;
  boolean q = true;
  
  public ayre() {}
  
  public ayre(ayvx paramayvx, aywc paramaywc)
  {
    super(paramayvx, paramaywc);
    this.jdField_a_of_type_Ayqo.jdField_b_of_type_Int = this.jdField_a_of_type_Aywc.jdField_b_of_type_Int;
    this.jdField_a_of_type_Ayqo.jdField_b_of_type_Long = this.jdField_a_of_type_Aywc.jdField_a_of_type_Long;
    this.jdField_a_of_type_Ayqo.jdField_c_of_type_Long = this.jdField_a_of_type_Aywc.jdField_b_of_type_Long;
  }
  
  public void a(ayyp paramayyp, ayze paramayze)
  {
    this.jdField_a_of_type_Ayyp = null;
    if (paramayze != null)
    {
      int i = 0;
      if (i < paramayze.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyp = (ayzq)paramayze.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramayyp.toString());
        }
        this.i = paramayyp.jdField_d_of_type_Boolean;
        a(this.jdField_a_of_type_Aypd, paramayyp);
        if (paramayyp.jdField_c_of_type_Int == 0)
        {
          if ((g()) && (paramayyp.jdField_b_of_type_JavaUtilArrayList.size() > 0))
          {
            this.jdField_a_of_type_JavaUtilArrayList = paramayyp.jdField_b_of_type_JavaUtilArrayList;
            if (h()) {
              this.jdField_a_of_type_JavaUtilArrayList.addAll(paramayyp.jdField_a_of_type_JavaUtilArrayList);
            }
            label122:
            this.jdField_b_of_type_JavaLangString = paramayyp.jdField_b_of_type_JavaLangString;
            this.jdField_a_of_type_JavaLangString = paramayyp.jdField_a_of_type_JavaLangString;
            if (QLog.isColorLevel()) {
              b("proUrl", "picResp.protocolType = " + paramayyp.jdField_a_of_type_Int);
            }
            if (paramayyp.jdField_a_of_type_Int != 1) {
              break label208;
            }
            this.jdField_g_of_type_Boolean = true;
            c(true);
          }
          for (;;)
          {
            i += 1;
            break;
            this.jdField_a_of_type_JavaUtilArrayList = paramayyp.jdField_a_of_type_JavaUtilArrayList;
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
      localObject1 = "Q.richmedia." + ayuk.b(this.jdField_a_of_type_Aywc.jdField_a_of_type_Int) + "." + ayuk.a(this.jdField_a_of_type_Aywc.jdField_b_of_type_Int);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.jdField_a_of_type_Aywc.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.jdField_j_of_type_Int + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.jdField_j_of_type_JavaLangString);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (!this.jdField_a_of_type_Aywc.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Aywc.jdField_e_of_type_Int == 1030) || ((!paramBoolean) && (ayuc.b(this.jdField_j_of_type_Int))) || (this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
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
      localObject1 = this.jdField_d_of_type_Aypd.a(1) + ";" + this.jdField_a_of_type_Aypd.a(2) + ";" + this.jdField_b_of_type_Aypd.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Aywc.jdField_g_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Aywc.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.i));
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      long l2 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_Aywf != null) {
        break label981;
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
        break label992;
      }
      localObject1 = "1";
      label652:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_g_of_type_Boolean) {
        break label1000;
      }
      localObject1 = "1";
      label681:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.jdField_a_of_type_Aysy != null) && (((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_Ayrz != null))
      {
        localObject1 = (ayrx)this.jdField_a_of_type_Aysy;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((ayrx)localObject1).jdField_a_of_type_Ayrz).jdField_a_of_type_Long));
      }
      if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Int != 1) {
        break label1008;
      }
      i = 1;
      label759:
      if (i != 0)
      {
        i = -1;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_groupPolicy", String.valueOf(i));
      }
      localObject2 = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
        }
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      f(paramBoolean);
      localObject1 = new HashMap();
      ((HashMap)localObject1).putAll(this.jdField_a_of_type_JavaUtilHashMap);
      if (!paramBoolean) {
        break label1013;
      }
      axrn.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, (HashMap)localObject1, "");
    }
    for (;;)
    {
      b(paramBoolean, l1);
      l();
      super.a(paramBoolean, "GroupPicDownloadErrorCode", l1, (HashMap)localObject1);
      return;
      i = 1;
      break;
      label981:
      i = this.jdField_a_of_type_Aywf.jdField_a_of_type_Int;
      break label451;
      label992:
      localObject1 = "0";
      break label652;
      label1000:
      localObject1 = "0";
      break label681;
      label1008:
      i = 0;
      break label759;
      label1013:
      if (this.jdField_j_of_type_Int != -9527) {
        ((HashMap)localObject1).remove("param_rspHeader");
      }
      ((HashMap)localObject1).put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      ((HashMap)localObject1).put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      axrn.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, (HashMap)localObject1, "");
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.jdField_a_of_type_Aywc.m) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x2) != 0);
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
    a("gchat.qpic.cn", 1000);
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 65537) {
        return "actGroupPicSmallDownV1";
      }
      return "actGroupPicDownloadV1";
    }
    if (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 65537) {
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
    paramString = this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString;
    paramString = "setError,uuid:" + paramString + " md5:" + this.jdField_a_of_type_Aywc.jdField_f_of_type_JavaLangString;
    QLog.d("BaseTransProcessor", 1, paramString);
    axrd.a("Download_Pic_Error_Param_Check", paramString);
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aypd.a();
    this.jdField_a_of_type_Boolean = false;
    ayyp localayyp = new ayyp();
    ayys localayys = new ayys();
    localayys.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString;
    localayys.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString;
    localayys.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_d_of_type_JavaLangString;
    localayys.jdField_f_of_type_Int = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
    localayys.jdField_a_of_type_Int = this.jdField_a_of_type_Aywc.jdField_b_of_type_Int;
    localayys.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    localayys.jdField_a_of_type_ArrayOfByte = this.jdField_c_of_type_ArrayOfByte;
    localayys.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Aywc.jdField_d_of_type_Long);
    if (paramBoolean)
    {
      localayys.jdField_c_of_type_Int = 0;
      localayyp.jdField_a_of_type_Ayzw = this;
      localayyp.jdField_a_of_type_JavaLangString = "grp_pic_dw";
      localayyp.jdField_a_of_type_JavaUtilList.add(localayys);
      localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label189;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypd);
      d();
    }
    label189:
    do
    {
      return;
      localayys.jdField_c_of_type_Int = 1;
      break;
      QLog.d("BaseTransProcessor", 1, "sendGroupPicDownRequest:" + this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        b("requestStart", localayyp.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Ayyp = localayyp;
    ayzv.a(localayyp);
  }
  
  public int c()
  {
    int i = 0;
    b("uiParam", this.jdField_a_of_type_Aywc.toString());
    String str1 = this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString;
    if ((str1 == null) || (str1.equals("")) || (str1.equals("null")) || (bbdx.c(str1)) || (str1.startsWith("http://")))
    {
      if ((str1 == null) || (!str1.startsWith("http://"))) {
        break label191;
      }
      String str2 = e(str1);
      if (str2 != null) {
        this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString = str2;
      }
    }
    else
    {
      if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaIoOutputStream != null) || (!this.jdField_a_of_type_Aywc.jdField_c_of_type_Boolean)) {
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
    if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject instanceof aywf)))
    {
      b(9302, a(new Exception("extra obj")));
      d();
      return -1;
    }
    this.jdField_a_of_type_Aywf = ((aywf)this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Aywf.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        this.q = bool;
        try
        {
          this.jdField_c_of_type_ArrayOfByte = a(this.jdField_a_of_type_Aywc.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString);
          this.jdField_c_of_type_Long = this.jdField_a_of_type_Aywc.jdField_c_of_type_Long;
          if (this.jdField_c_of_type_ArrayOfByte != null) {
            break;
          }
          b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Aywc.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString)));
          d();
          return -1;
        }
        catch (Exception localException)
        {
          b(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_Aywc.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString)));
          d();
        }
      }
    }
    return -1;
  }
  
  void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Aypd.a();
    if (this.o) {
      return;
    }
    ayrx localayrx = new ayrx();
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
        break label731;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localayrx.jdField_g_of_type_Boolean = false;
      localayrx.jdField_b_of_type_JavaLangString = "gchat.qpic.cn";
      localObject1 = (String)localObject1 + "gchat.qpic.cn";
      localObject1 = a((String)localObject1 + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_g_of_type_Int);
      localayrx.jdField_a_of_type_Aysc = this;
      localayrx.jdField_a_of_type_Aysd = this;
      localayrx.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localayrx.jdField_f_of_type_Boolean = paramBoolean;
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label946;
      }
      localayrx.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localayrx.jdField_a_of_type_Int = 0;
      localObject2 = new ayuq();
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label957;
      }
      ((ayuq)localObject2).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((ayuq)localObject2).b = true;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      localayrx.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      if (this.jdField_a_of_type_Ayug != null) {
        localayrx.jdField_a_of_type_Ayui = this.jdField_a_of_type_Ayug.a();
      }
      localayrx.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywc.h;
      if (this.jdField_a_of_type_Aywc.jdField_c_of_type_Boolean) {
        localayrx.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaIoOutputStream;
      }
      localayrx.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
      localayrx.jdField_g_of_type_Int = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
      localayrx.jdField_f_of_type_Int = this.jdField_a_of_type_Aywc.jdField_b_of_type_Int;
      localayrx.k = true;
      localayrx.jdField_a_of_type_Long = 0L;
      localayrx.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
      i = a(this.jdField_a_of_type_Aywc);
      if (i != 4) {
        break label968;
      }
      localayrx.jdField_a_of_type_Long = this.jdField_a_of_type_Aywc.i;
      localayrx.jdField_b_of_type_Long = 0L;
      localayrx.jdField_j_of_type_Boolean = false;
      localObject2 = "bytes=" + this.jdField_a_of_type_Aywc.i + "-";
      localayrx.jdField_a_of_type_JavaUtilHashMap.put("Range", localObject2);
    }
    for (;;)
    {
      localayrx.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localayrx.jdField_a_of_type_Aysb = jdField_a_of_type_Aysb;
      localayrx.jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
      a(localayrx, (String)localObject1);
      localayrx.l = true;
      localayrx.jdField_d_of_type_Boolean = true;
      localayrx.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCu");
      localayrx.jdField_e_of_type_Int = this.jdField_a_of_type_Aywc.jdField_f_of_type_Int;
      if (this.jdField_a_of_type_Boolean) {
        localayrx.jdField_c_of_type_Int = 0;
      }
      localObject1 = null;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        localObject1 = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
      b("httpDown", "directMsgUrlDown:" + this.jdField_a_of_type_Boolean + ",req.mReqUrl = " + localayrx.jdField_a_of_type_JavaLangString + " ipList:" + (String)localObject1 + " uuid:" + this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_Aywc.jdField_c_of_type_Long + " downOffset:" + localayrx.jdField_a_of_type_Long + ",isEncryptUrl:" + this.jdField_e_of_type_Boolean + ",isEncryptPic:" + this.jdField_d_of_type_Boolean + ",isEncryptRollbackReq:" + this.jdField_f_of_type_Boolean);
      if (!f()) {
        break;
      }
      this.jdField_a_of_type_Aysy = localayrx;
      n();
      this.jdField_a_of_type_Aysa.a(localayrx);
      return;
      localObject1 = "http://";
      break label32;
      label731:
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localayrx.jdField_g_of_type_Boolean = true;
        ayuq localayuq = (ayuq)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((localayuq.jdField_a_of_type_Boolean) && (!localayuq.jdField_a_of_type_JavaLangString.startsWith("["))) {}
        for (localObject2 = (String)localObject1 + "[" + localayuq.jdField_a_of_type_JavaLangString + "]";; localObject2 = (String)localObject1 + localayuq.jdField_a_of_type_JavaLangString)
        {
          localObject1 = localObject2;
          if (localayuq.jdField_a_of_type_Int == 80) {
            break;
          }
          localObject1 = (String)localObject2 + ":" + localayuq.jdField_a_of_type_Int;
          break;
        }
      }
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break;
      }
      localayrx.jdField_g_of_type_Boolean = false;
      localObject1 = (String)localObject1 + this.jdField_b_of_type_JavaLangString;
      break label81;
      label946:
      localayrx.jdField_b_of_type_JavaLangString = "gchat.qpic.cn";
      break label164;
      label957:
      ((ayuq)localObject2).jdField_a_of_type_JavaLangString = "gchat.qpic.cn";
      break label205;
      label968:
      if ((i == 3) || (i == 2))
      {
        localayrx.jdField_a_of_type_Long = this.jdField_a_of_type_Aywc.i;
        localayrx.jdField_b_of_type_Long = (this.jdField_a_of_type_Aywc.i + this.jdField_a_of_type_Aywc.jdField_j_of_type_Int - 1);
        localayrx.jdField_j_of_type_Boolean = false;
        localObject2 = "bytes=" + this.jdField_a_of_type_Aywc.i + "-" + localayrx.jdField_b_of_type_Long;
        localayrx.jdField_a_of_type_JavaUtilHashMap.put("Range", localObject2);
      }
      else
      {
        localayrx.jdField_b_of_type_Long = 0L;
        localayrx.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localayrx.jdField_a_of_type_Long + "-");
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
    int i = this.jdField_a_of_type_Aywc.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_Aysy instanceof ayrx))
    {
      if (!this.q) {
        break label72;
      }
      if (i == 2) {
        ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttGd");
      }
    }
    else
    {
      return;
    }
    ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaUtilHashMap.put("mType", "picGd");
    return;
    label72:
    if (i == 2)
    {
      ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttDd");
      return;
    }
    ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaUtilHashMap.put("mType", "picDd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayre
 * JD-Core Version:    0.7.0.1
 */