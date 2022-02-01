import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class bexb
  extends berj
  implements beur
{
  static HashSet<String> a;
  long c;
  int d;
  private String e;
  private String f;
  private String l;
  int q;
  private int r;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public bexb()
  {
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = -1;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_q_of_type_Int = 0;
  }
  
  public bexb(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = -1;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_q_of_type_Int = 0;
    parambeyb = parambeyg.i;
    if (parambeyb != null)
    {
      String[] arrayOfString = parambeyb.split("QQ_&_MoblieQQ_&_QQ");
      if (arrayOfString.length < 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "path was not set correctlly------path = " + parambeyb);
        }
        throw new IllegalArgumentException("path was not set correctlly.");
      }
      parambeyg.jdField_h_of_type_JavaLangString = arrayOfString[0];
      this.f = arrayOfString[1];
      this.jdField_e_of_type_JavaLangString = (this.f + parambeyg.jdField_b_of_type_Int + parambeyg.jdField_a_of_type_Long);
      if (arrayOfString.length > 3) {
        this.r = Integer.parseInt(arrayOfString[3]);
      }
    }
  }
  
  private void a(bfbg parambfbg)
  {
    if ((this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 7) || (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 16) || (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 18)) {
      parambfbg.g = 1;
    }
    while ((this.jdField_a_of_type_Beyg.jdField_b_of_type_Int != 6) && (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int != 9) && (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int != 17)) {
      return;
    }
    parambfbg.g = 2;
  }
  
  private void a(bfbx parambfbx)
  {
    if (QLog.isColorLevel()) {
      if ("onBusiProtoResp() cdn ---- mIpListSize:" + this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label113;
      }
    }
    label113:
    for (Object localObject = Integer.valueOf(0);; localObject = this.jdField_a_of_type_JavaUtilArrayList.size() + " mHostType:" + parambfbx.jdField_a_of_type_Int + " domain:" + parambfbx.jdField_b_of_type_JavaLangString + " url:" + parambfbx.jdField_c_of_type_JavaLangString)
    {
      QLog.d("ShortVideoDownloadProcessor", 2, new Object[] { localObject });
      QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- mUiRequest.mMd5:" + this.jdField_a_of_type_Beyg.f + " ---- downResp.md5:" + HexUtil.bytes2HexStr(parambfbx.jdField_a_of_type_ArrayOfByte));
      this.jdField_c_of_type_JavaLangString = parambfbx.jdField_c_of_type_JavaLangString;
      b(parambfbx.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  private void b(bfbg parambfbg)
  {
    if ((parambfbg.jdField_f_of_type_Int == 0) || (1008 == parambfbg.jdField_f_of_type_Int))
    {
      parambfbg.jdField_b_of_type_JavaLangString = null;
      return;
    }
    parambfbg.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
  }
  
  private void b(bfbx parambfbx)
  {
    if ((!parambfbx.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
    {
      ((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isAllowAutoDown = false;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()-- server return not allow auto retry");
      }
    }
    if (-5100026 == this.jdField_k_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_Beyg.f);
      }
      b(-5100026, "安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_Beyg.f);
    }
    for (;;)
    {
      d();
      return;
      if ((-9527 == this.jdField_k_of_type_Int) && ((this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")) || (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103059"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + this.jdField_k_of_type_Int);
        }
        b(this.jdField_k_of_type_Int, anzj.a(2131712943));
      }
      else if (-5100528 == this.jdField_k_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 后台不允许自动下载, errCode = " + this.jdField_k_of_type_Int);
        }
        b(-5100528, anzj.a(2131712948));
      }
      else
      {
        b(9045, anzj.a(2131712950));
      }
    }
  }
  
  private void c(bfbg parambfbg)
  {
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
    {
      parambfbg.jdField_e_of_type_Int = ((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;
      this.jdField_d_of_type_Int = parambfbg.jdField_e_of_type_Int;
      parambfbg.j = 0;
      if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
      {
        if (!(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForLightVideo)) {
          break label127;
        }
        parambfbg.j = 3;
      }
    }
    label127:
    while (((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).subBusiType != 1)
    {
      return;
      if (1008 == parambfbg.jdField_f_of_type_Int)
      {
        parambfbg.jdField_e_of_type_Int = this.jdField_a_of_type_Beyg.jdField_e_of_type_Int;
        break;
      }
      parambfbg.jdField_e_of_type_Int = 0;
      break;
    }
    parambfbg.j = 1;
  }
  
  private void d(bfbg parambfbg)
  {
    if (parambfbg.jdField_f_of_type_Int == 0)
    {
      parambfbg.jdField_a_of_type_Int = 0;
      return;
    }
    if (1 == parambfbg.jdField_f_of_type_Int)
    {
      parambfbg.jdField_a_of_type_Int = 1;
      return;
    }
    if (3000 == parambfbg.jdField_f_of_type_Int)
    {
      parambfbg.jdField_a_of_type_Int = 2;
      return;
    }
    parambfbg.jdField_a_of_type_Int = 3;
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "cancel()");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
    return super.a();
  }
  
  protected String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    bewy localbewy;
    if (paramBoolean)
    {
      localStringBuilder.append("https://");
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label204;
      }
      localbewy = (bewy)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((!localbewy.jdField_a_of_type_Boolean) || (localbewy.jdField_a_of_type_JavaLangString.startsWith("["))) {
        break label192;
      }
      localStringBuilder.append("[" + localbewy.jdField_a_of_type_JavaLangString + "]");
      label96:
      if ((localbewy.jdField_a_of_type_Int != 80) && (localbewy.jdField_a_of_type_Int != 0))
      {
        localStringBuilder.append(":");
        localStringBuilder.append(localbewy.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      localStringBuilder.append("/");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      b("getConnUrl", "cdn url = " + localStringBuilder.toString());
      return localStringBuilder.toString();
      localStringBuilder.append("http://");
      break;
      label192:
      localStringBuilder.append(localbewy.jdField_a_of_type_JavaLangString);
      break label96;
      label204:
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void a(bevm parambevm)
  {
    g();
    e();
    this.jdField_a_of_type_Bfci.jdField_l_of_type_JavaLangString = (this.jdField_d_of_type_Int + "");
    this.jdField_a_of_type_Bfci.jdField_b_of_type_Long = this.jdField_a_of_type_Bete.jdField_a_of_type_Long;
    a(parambevm, true, "actRichMediaNetMonitor_videoDown", this.f);
  }
  
  public void a(bfau parambfau, bfbj parambfbj)
  {
    this.jdField_a_of_type_Bfau = null;
    if (parambfbj != null)
    {
      int i = 0;
      if (i < parambfbj.jdField_a_of_type_JavaUtilList.size())
      {
        parambfau = (bfbx)parambfbj.jdField_a_of_type_JavaUtilList.get(i);
        b("procUrl", parambfau.toString());
        a(this.jdField_a_of_type_Berr, parambfau);
        this.jdField_a_of_type_JavaUtilArrayList = a(parambfau.jdField_b_of_type_JavaUtilArrayList, parambfau.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaLangString = parambfau.jdField_b_of_type_JavaLangString;
        if (this.jdField_l_of_type_Boolean)
        {
          this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
          if (this.jdField_a_of_type_JavaUtilArrayList != null) {
            this.jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
        if (parambfau.jdField_c_of_type_Int == 0) {
          a(parambfau);
        }
        for (;;)
        {
          i += 1;
          break;
          b(parambfau);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Beyg.jdField_h_of_type_Boolean) {}
    while (((!paramBoolean) && (bewk.a(this.jdField_k_of_type_Int))) || (this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.n & 0x2) > 0)) || ((!paramBoolean) && ((this.n & 0x1) > 0))) {
      return;
    }
    int j = this.n;
    int i;
    long l1;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.n = (i | j);
      if (this.jdField_q_of_type_Int > 0)
      {
        new HashMap().put("businessType", String.valueOf(this.jdField_a_of_type_Beyg.jdField_b_of_type_Int));
        bdmc.a(BaseApplication.getContext()).a(null, "actShortVideoRedirect", true, this.jdField_c_of_type_Long, this.jdField_q_of_type_Int, this.jdField_a_of_type_JavaUtilHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "mRedirectReportInfo = " + this.jdField_q_of_type_Int + " " + this.jdField_c_of_type_Long + " " + this.jdField_a_of_type_Beyg.jdField_b_of_type_Int);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "reportTag = " + c());
      }
      l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      str = this.jdField_a_of_type_Berr.a(1) + ";" + this.jdField_b_of_type_Berr.a(2) + ";" + this.jdField_c_of_type_Berr.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.f);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Bete.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", this.jdField_a_of_type_Beyg.f);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.jdField_d_of_type_Int + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.r));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Beyg.g));
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_e_of_type_Boolean) {
        break label589;
      }
      str = "1";
      label509:
      localHashMap.put("param_isHttps", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_trans_consume", String.valueOf(this.jdField_b_of_type_Berr.a()));
      if (!paramBoolean) {
        break label597;
      }
      b(true, l1);
      bdmc.a(BaseApplication.getContext()).a(null, c(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      m();
      return;
      i = 1;
      break;
      label589:
      str = "0";
      break label509;
      label597:
      if (this.jdField_k_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_k_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      if (this.jdField_k_of_type_Int == -6103066) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", "uierquest md5=" + this.jdField_a_of_type_Beyg.f + "fileMd5=" + this.jdField_l_of_type_JavaLangString);
      }
      b(false, l1);
      bdmc.a(BaseApplication.getContext()).a(null, c(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public void aN_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "start()----runningTasks.contains(mTaskKey) = " + jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_e_of_type_JavaLangString));
    }
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      b("start", "[tvk] videoFileSize = " + localMessageForShortVideo.videoFileSize);
    }
    if ((this.jdField_a_of_type_Beyg.g == 2) && (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) && (!((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isAllowAutoDown) && ((this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 6) || (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 9) || (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 17)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "start()-- server not allow auto down video");
      }
      jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
      super.a();
    }
    while (jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_e_of_type_JavaLangString)) {
      return;
    }
    jdField_a_of_type_JavaUtilHashSet.add(this.jdField_e_of_type_JavaLangString);
    d(2001);
    f();
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "resume()");
    }
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = false;
      this.jdField_q_of_type_Boolean = false;
      d(2001);
      this.jdField_k_of_type_Int = 0;
      this.jdField_j_of_type_JavaLangString = "";
      this.jdField_a_of_type_Bern.a.post(new ShortVideoDownloadProcessor.1(this));
    }
    return 0;
  }
  
  public void b(bevm parambevm)
  {
    if (parambevm.jdField_a_of_type_JavaUtilHashMap.get("X-RtFlag") == null) {}
    for (long l1 = 9223372036854775807L;; l1 = Long.parseLong((String)parambevm.jdField_a_of_type_JavaUtilHashMap.get("X-RtFlag")))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_xRtFlag", String.valueOf(l1));
      if ((parambevm.jdField_b_of_type_Int != 9364) || (this.jdField_m_of_type_Int >= 3)) {
        break;
      }
      b("[netChg]", "failed.but net change detect.so retry");
      this.jdField_m_of_type_Int += 1;
      n();
      f();
      return;
    }
    String str = (String)parambevm.jdField_a_of_type_JavaUtilHashMap.get(bhva.f);
    a(parambevm.jdField_b_of_type_Int, parambevm.jdField_a_of_type_JavaLangString, str, this.jdField_b_of_type_Berr);
    d();
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bfci.jdField_a_of_type_Boolean = paramBoolean;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
    }
    this.jdField_b_of_type_Berr.a();
    String str = a(paramBoolean);
    Object localObject1 = new beum();
    if (!bhsr.a(this.jdField_b_of_type_JavaLangString)) {
      ((beum)localObject1).jdField_a_of_type_JavaUtilHashMap.put("host", this.jdField_b_of_type_JavaLangString);
    }
    ((beum)localObject1).jdField_a_of_type_Beuq = this;
    ((beum)localObject1).jdField_a_of_type_Beur = this;
    ((beum)localObject1).jdField_a_of_type_JavaLangString = str;
    ((beum)localObject1).jdField_f_of_type_Boolean = paramBoolean;
    ((beum)localObject1).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((beum)localObject1).jdField_a_of_type_Int = 0;
    a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaLangString);
    ((beum)localObject1).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    ((beum)localObject1).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_h_of_type_JavaLangString;
    ((beum)localObject1).jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    ((beum)localObject1).jdField_f_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    ((beum)localObject1).jdField_e_of_type_Int = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
    Object localObject2;
    if ((this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 6) || (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 9) || (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 17))
    {
      localObject2 = bhsi.f(BaseApplication.getContext());
      if ((localObject2 != null) && (((String)localObject2).length() > 0))
      {
        localObject2 = ((String)localObject2).split("\\|");
        if ((localObject2 != null) && (localObject2.length > 0)) {
          ((beum)localObject1).jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject2);
        }
      }
    }
    ((beum)localObject1).jdField_a_of_type_Long = 0L;
    ((beum)localObject1).jdField_l_of_type_Boolean = true;
    ((beum)localObject1).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    ((beum)localObject1).jdField_a_of_type_Beup = jdField_a_of_type_Beup;
    ((beum)localObject1).jdField_d_of_type_JavaLangString = (this.jdField_a_of_type_Beyg.jdField_h_of_type_JavaLangString + "." + MD5.toMD5(this.f) + ".tmp");
    b("httpDown", "url:" + str + ",downOffset:" + ((beum)localObject1).jdField_a_of_type_Long);
    if (!f())
    {
      jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Bevl = ((bevl)localObject1);
    o();
    ((beum)localObject1).jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mIsOnlyGetUrl " + this.jdField_a_of_type_Beyg.jdField_h_of_type_Boolean + " domain=" + this.jdField_b_of_type_JavaLangString + " ipsize=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    if (this.jdField_a_of_type_Beyg.jdField_h_of_type_Boolean)
    {
      localObject1 = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject2 = (bewy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        StringBuffer localStringBuffer = new StringBuffer();
        if (paramBoolean) {
          localStringBuffer.append("https://");
        }
        for (;;)
        {
          localStringBuffer.append(((bewy)localObject2).jdField_a_of_type_JavaLangString);
          if (((bewy)localObject2).jdField_a_of_type_Int != 80)
          {
            localStringBuffer.append(":");
            localStringBuffer.append(((bewy)localObject2).jdField_a_of_type_Int);
          }
          localStringBuffer.append("/");
          localObject1[i] = bews.a(str, localStringBuffer.toString());
          i += 1;
          break;
          localStringBuffer.append("http://");
        }
      }
      this.jdField_a_of_type_Bete.c = ((String[])localObject1);
      this.jdField_a_of_type_Bete.u = this.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Bete.f = this.jdField_a_of_type_Berr.a();
      d(2002);
      this.jdField_a_of_type_Bern.a(b());
      jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Beuo.a((bevl)localObject1);
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Beyg == null) || (this.jdField_a_of_type_Beyg.jdField_h_of_type_JavaLangString == null))
    {
      b(9302, anzj.a(2131712920));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Beyg != null) && (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0)) {
      this.p = true;
    }
    return 0;
  }
  
  protected String c()
  {
    String str = "actShortVideoDownloadVideo";
    if (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 7) {
      str = "actShortVideoDownloadThumb";
    }
    do
    {
      return str;
      if (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 6) {
        return "actShortVideoDownloadVideo";
      }
      if ((this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 16) || (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int == 18))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
        return "actShortVideoDiscussgroupDownloadThumb";
      }
    } while ((this.jdField_a_of_type_Beyg.jdField_b_of_type_Int != 9) && (this.jdField_a_of_type_Beyg.jdField_b_of_type_Int != 17));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
    return "actShortVideoDiscussgroupDownloadVideo";
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "pause() mIsPause : " + this.jdField_m_of_type_Boolean);
    }
    if (!this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = true;
      d(2004);
      if (this.jdField_a_of_type_Bfau != null)
      {
        bfca.b(this.jdField_a_of_type_Bfau);
        this.jdField_a_of_type_Bfau = null;
      }
      if (this.jdField_a_of_type_Bevl != null)
      {
        this.jdField_a_of_type_Beuo.b(this.jdField_a_of_type_Bevl);
        this.jdField_a_of_type_Bevl = null;
      }
    }
  }
  
  public void c(bevm parambevm)
  {
    this.jdField_a_of_type_Bfci.jdField_l_of_type_JavaLangString = (this.jdField_d_of_type_Int + "");
    this.jdField_a_of_type_Bfci.jdField_b_of_type_Long = this.jdField_a_of_type_Bete.jdField_a_of_type_Long;
    a(parambevm, false, "actRichMediaNetMonitor_videoDown", this.f);
  }
  
  void d()
  {
    super.d();
    jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_Bete.g = this.jdField_k_of_type_Int;
    if (-5100026 == this.jdField_k_of_type_Int) {
      d(5001);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errCode:" + this.jdField_k_of_type_Int);
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errDesc:" + this.jdField_j_of_type_JavaLangString);
      }
      Object localObject = null;
      if (this.jdField_a_of_type_Beyg != null) {
        localObject = this.jdField_a_of_type_Beyg.jdField_a_of_type_Beyn;
      }
      if (localObject != null)
      {
        ((beyn)localObject).jdField_a_of_type_Int = -1;
        ((beyn)localObject).jdField_a_of_type_Long = this.jdField_k_of_type_Int;
        ((beyn)localObject).jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        ((beyn)localObject).jdField_a_of_type_Beyg = this.jdField_a_of_type_Beyg;
      }
      localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        azpp localazpp = (azpp)((Iterator)localObject).next();
        azpq localazpq = new azpq();
        localazpq.jdField_a_of_type_Int = -1;
        localazpq.jdField_b_of_type_Int = this.jdField_k_of_type_Int;
        localazpq.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        localazpp.a(localazpq);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideo.TAG", 2, "onError ");
        }
      }
      if ((-9527 == this.jdField_k_of_type_Int) && ((this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")) || (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103059")))) {
        d(5002);
      } else {
        d(2005);
      }
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendMessageToUpdate state = " + paramInt);
    }
    if ((this.jdField_m_of_type_Boolean) && (2004 != paramInt)) {
      return;
    }
    bcwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bete, this.jdField_a_of_type_Beyg);
  }
  
  void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "successfully downloaded.");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
    d(2003);
    Object localObject = this.jdField_a_of_type_Beyg.jdField_a_of_type_Beyn;
    if (localObject != null)
    {
      ((beyn)localObject).jdField_a_of_type_Int = 0;
      ((beyn)localObject).jdField_a_of_type_Beyg = this.jdField_a_of_type_Beyg;
    }
    localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      azpp localazpp = (azpp)((Iterator)localObject).next();
      azpq localazpq = new azpq();
      localazpq.jdField_a_of_type_Int = 0;
      localazpq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_h_of_type_JavaLangString;
      localazpq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.f;
      localazpq.jdField_d_of_type_Int = this.jdField_a_of_type_Beyg.g;
      localazpp.a(localazpq);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Berr.a();
    bfau localbfau = new bfau();
    bfbg localbfbg = new bfbg();
    localbfbg.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + localbfbg.jdField_c_of_type_Int);
    }
    localbfbg.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString;
    localbfbg.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfbg.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_d_of_type_JavaLangString;
    localbfbg.jdField_f_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbfbg.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfbg.jdField_d_of_type_Int = 0;
    localbfbg.jdField_b_of_type_Int = 2;
    localbfbg.jdField_a_of_type_JavaLangString = this.f;
    localbfbg.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_Beyg.f);
    d(localbfbg);
    b(localbfbg);
    c(localbfbg);
    a(localbfbg);
    localbfbg.h = this.jdField_a_of_type_Beyg.g;
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject instanceof Integer))) {
      localbfbg.i = ((Integer)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject).intValue();
    }
    localbfau.jdField_a_of_type_Bfcb = this;
    localbfau.jdField_a_of_type_JavaLangString = "short_video_dw";
    localbfau.jdField_a_of_type_JavaUtilList.add(localbfbg);
    localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
      d();
      return;
    }
    b("requestStart", localbfau.toString());
    if (!f())
    {
      jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Bfau = localbfau;
    bfca.a(localbfau);
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 117	bexb:jdField_a_of_type_Beyg	Lbeyg;
    //   6: getfield 143	beyg:f	Ljava/lang/String;
    //   9: astore 5
    //   11: aload 5
    //   13: invokestatic 572	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifne +359 -> 375
    //   19: aload_0
    //   20: getfield 117	bexb:jdField_a_of_type_Beyg	Lbeyg;
    //   23: getfield 90	beyg:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   26: astore 4
    //   28: aconst_null
    //   29: astore 6
    //   31: new 848	java/io/FileInputStream
    //   34: dup
    //   35: aload 4
    //   37: invokespecial 849	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   40: astore 4
    //   42: aload 4
    //   44: aload 4
    //   46: invokevirtual 852	java/io/FileInputStream:available	()I
    //   49: i2l
    //   50: invokestatic 856	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   53: astore 6
    //   55: aload 6
    //   57: ifnull +313 -> 370
    //   60: aload_0
    //   61: aload 6
    //   63: invokestatic 156	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   66: putfield 34	bexb:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   69: aload_0
    //   70: getfield 34	bexb:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload 5
    //   75: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifne +292 -> 370
    //   81: aload_0
    //   82: getfield 117	bexb:jdField_a_of_type_Beyg	Lbeyg;
    //   85: getfield 95	beyg:jdField_b_of_type_Int	I
    //   88: bipush 6
    //   90: if_icmpeq +29 -> 119
    //   93: aload_0
    //   94: getfield 117	bexb:jdField_a_of_type_Beyg	Lbeyg;
    //   97: getfield 95	beyg:jdField_b_of_type_Int	I
    //   100: bipush 9
    //   102: if_icmpeq +17 -> 119
    //   105: aload_0
    //   106: getfield 117	bexb:jdField_a_of_type_Beyg	Lbeyg;
    //   109: getfield 95	beyg:jdField_b_of_type_Int	I
    //   112: istore_1
    //   113: iload_1
    //   114: bipush 17
    //   116: if_icmpne +254 -> 370
    //   119: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +43 -> 165
    //   125: ldc 64
    //   127: iconst_2
    //   128: new 66	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 858
    //   138: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 5
    //   143: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 860
    //   149: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: getfield 34	bexb:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   156: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 862	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: iconst_0
    //   166: istore_1
    //   167: iload_1
    //   168: istore_2
    //   169: aload 4
    //   171: ifnull +10 -> 181
    //   174: aload 4
    //   176: invokevirtual 865	java/io/FileInputStream:close	()V
    //   179: iload_1
    //   180: istore_2
    //   181: aload_0
    //   182: getfield 394	bexb:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   185: astore 4
    //   187: iload_2
    //   188: ifeq +153 -> 341
    //   191: iload_3
    //   192: istore_1
    //   193: aload 4
    //   195: ldc_w 867
    //   198: iload_1
    //   199: invokestatic 374	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   202: invokevirtual 378	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: return
    //   207: astore 4
    //   209: iload_1
    //   210: istore_2
    //   211: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq -33 -> 181
    //   217: ldc 64
    //   219: iconst_2
    //   220: ldc_w 869
    //   223: aload 4
    //   225: invokestatic 872	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   228: iload_1
    //   229: istore_2
    //   230: goto -49 -> 181
    //   233: astore 5
    //   235: iconst_1
    //   236: istore_1
    //   237: aload 6
    //   239: astore 4
    //   241: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +14 -> 258
    //   247: ldc 64
    //   249: iconst_2
    //   250: ldc_w 869
    //   253: aload 5
    //   255: invokestatic 872	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: iload_1
    //   259: istore_2
    //   260: aload 4
    //   262: ifnull -81 -> 181
    //   265: aload 4
    //   267: invokevirtual 865	java/io/FileInputStream:close	()V
    //   270: iload_1
    //   271: istore_2
    //   272: goto -91 -> 181
    //   275: astore 4
    //   277: iload_1
    //   278: istore_2
    //   279: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq -101 -> 181
    //   285: ldc 64
    //   287: iconst_2
    //   288: ldc_w 869
    //   291: aload 4
    //   293: invokestatic 872	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   296: iload_1
    //   297: istore_2
    //   298: goto -117 -> 181
    //   301: astore 5
    //   303: aconst_null
    //   304: astore 4
    //   306: aload 4
    //   308: ifnull +8 -> 316
    //   311: aload 4
    //   313: invokevirtual 865	java/io/FileInputStream:close	()V
    //   316: aload 5
    //   318: athrow
    //   319: astore 4
    //   321: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq -8 -> 316
    //   327: ldc 64
    //   329: iconst_2
    //   330: ldc_w 869
    //   333: aload 4
    //   335: invokestatic 872	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   338: goto -22 -> 316
    //   341: iconst_0
    //   342: istore_1
    //   343: goto -150 -> 193
    //   346: astore 5
    //   348: goto -42 -> 306
    //   351: astore 5
    //   353: goto -47 -> 306
    //   356: astore 5
    //   358: iconst_1
    //   359: istore_1
    //   360: goto -119 -> 241
    //   363: astore 5
    //   365: iconst_0
    //   366: istore_1
    //   367: goto -126 -> 241
    //   370: iconst_1
    //   371: istore_1
    //   372: goto -205 -> 167
    //   375: iconst_1
    //   376: istore_2
    //   377: goto -196 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	bexb
    //   112	260	1	i	int
    //   168	209	2	j	int
    //   1	191	3	k	int
    //   26	168	4	localObject1	Object
    //   207	17	4	localIOException1	java.io.IOException
    //   239	27	4	localObject2	Object
    //   275	17	4	localIOException2	java.io.IOException
    //   304	8	4	localObject3	Object
    //   319	15	4	localIOException3	java.io.IOException
    //   9	133	5	str	String
    //   233	21	5	localIOException4	java.io.IOException
    //   301	16	5	localObject4	Object
    //   346	1	5	localObject5	Object
    //   351	1	5	localObject6	Object
    //   356	1	5	localIOException5	java.io.IOException
    //   363	1	5	localIOException6	java.io.IOException
    //   29	209	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   174	179	207	java/io/IOException
    //   31	42	233	java/io/IOException
    //   265	270	275	java/io/IOException
    //   31	42	301	finally
    //   311	316	319	java/io/IOException
    //   42	55	346	finally
    //   60	113	346	finally
    //   119	165	346	finally
    //   241	258	351	finally
    //   42	55	356	java/io/IOException
    //   60	113	356	java/io/IOException
    //   119	165	363	java/io/IOException
  }
  
  protected void o()
  {
    String str;
    if ((this.jdField_a_of_type_Bevl != null) && ((this.jdField_a_of_type_Bevl instanceof beum)))
    {
      if (!adak.d(this.jdField_a_of_type_Beyg.jdField_a_of_type_Int)) {
        break label59;
      }
      str = "videoCd";
    }
    for (;;)
    {
      ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype(str, ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString);
      return;
      label59:
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 1) {
        str = "videoGd";
      } else if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 3000) {
        str = "videoDd";
      } else {
        str = "videoOd";
      }
    }
  }
  
  public void onResp(bevm parambevm)
  {
    boolean bool2 = true;
    super.onResp(parambevm);
    Object localObject = new StringBuilder().append("directMsgUrlDown:").append(this.jdField_a_of_type_Boolean).append(" result:");
    boolean bool1;
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      b("onHttpResp", bool1);
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoDownloadProcessor", 2, "onResp()---- result:" + parambevm.jdField_a_of_type_Int);
        QLog.d("ShortVideoDownloadProcessor", 2, "onResp()---- errCode:" + parambevm.jdField_b_of_type_Int);
        QLog.d("ShortVideoDownloadProcessor", 2, "onResp()---- errDesc:" + parambevm.jdField_a_of_type_JavaLangString);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label268;
      }
      localObject = this.jdField_d_of_type_Berr;
      label166:
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label277;
      }
      bool1 = bool2;
      label175:
      a((berr)localObject, parambevm, bool1);
      this.jdField_a_of_type_Long = parambevm.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambevm.jdField_b_of_type_Long + parambevm.jdField_a_of_type_Bevl.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambevm.jdField_c_of_type_Long;
      this.jdField_c_of_type_Long = parambevm.f;
      this.jdField_q_of_type_Int = parambevm.jdField_e_of_type_Int;
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label282;
      }
      a(parambevm);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bevl = null;
      return;
      bool1 = false;
      break;
      label268:
      localObject = this.jdField_b_of_type_Berr;
      break label166;
      label277:
      bool1 = false;
      break label175;
      label282:
      b(parambevm);
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    if (this.jdField_m_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoDownloadProcessor", 2, "onUpdateProgeress: mIsPause=true, should not notify UI, just return!");
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Bete.e = paramLong1;
      this.jdField_a_of_type_Bete.jdField_a_of_type_Long = paramLong2;
      d(2002);
      int i = (int)(10000L * paramLong1 / paramLong2);
      parambevl = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (parambevl.hasNext()) {
        ((azpp)parambevl.next()).a(i, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bexb
 * JD-Core Version:    0.7.0.1
 */