import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class axuk
  extends axoo
  implements axru
{
  static HashSet<String> a;
  private axrs b;
  int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long = 0L;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private String e;
  private String f;
  private String k;
  int p = 0;
  private int q;
  private int r;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public axuk(axvo paramaxvo, axvt paramaxvt)
  {
    super(paramaxvo, paramaxvt);
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_b_of_type_Axrs = new axul(this);
    paramaxvo = paramaxvt.i;
    if (paramaxvo != null)
    {
      String[] arrayOfString = paramaxvo.split("QQ_&_MoblieQQ_&_QQ");
      if (arrayOfString.length < 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "path was not set correctlly------path = " + paramaxvo);
        }
        throw new IllegalArgumentException("path was not set correctlly.");
      }
      paramaxvt.h = arrayOfString[0];
      this.f = arrayOfString[1];
      this.jdField_e_of_type_JavaLangString = (this.f + paramaxvt.jdField_b_of_type_Int + paramaxvt.jdField_a_of_type_Long);
      this.q = Integer.parseInt(arrayOfString[2]);
      if (arrayOfString.length > 3) {
        this.r = Integer.parseInt(arrayOfString[3]);
      }
    }
  }
  
  private boolean a()
  {
    if ((ahud.a.get()) && ((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localMessageForShortVideo.busiType != 0) || (!localMessageForShortVideo.supportProgressive)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "isSupportProgressive() : " + bool);
      }
      return bool;
    }
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "cancel()");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
    return super.a();
  }
  
  public void a(axsq paramaxsq)
  {
    a(paramaxsq, false);
  }
  
  protected void a(axsq paramaxsq, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((this.jdField_a_of_type_Axsp instanceof axro))
    {
      localHashMap.put("file_url", ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
      axuh localaxuh = axub.a(((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
      if (localaxuh != null)
      {
        if ((!paramBoolean) && (localaxuh.jdField_a_of_type_JavaLangString != null))
        {
          if (this.jdField_c_of_type_JavaUtilArrayList.contains(localaxuh.jdField_a_of_type_JavaLangString)) {
            return;
          }
          this.jdField_c_of_type_JavaUtilArrayList.add(localaxuh.jdField_a_of_type_JavaLangString);
        }
        localHashMap.put("server_ip", localaxuh.jdField_a_of_type_JavaLangString);
        localHashMap.put("server_port", localaxuh.jdField_a_of_type_Int + "");
      }
    }
    localHashMap.put("transfer_type", "2");
    localHashMap.put("business_type", this.jdField_c_of_type_Int + "");
    localHashMap.put("http_errorCode", paramaxsq.jdField_c_of_type_Int + "");
    localHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
    localHashMap.put("param_errorDesc", this.i);
    localHashMap.put("md5", this.jdField_a_of_type_Axvt.f);
    localHashMap.put("uuid", this.f);
    localHashMap.put("chatType", this.jdField_a_of_type_Axvt.jdField_a_of_type_Int + "");
    localHashMap.put("chatUin", this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString + "");
    awrn.a(BaseApplication.getContext()).a(null, "actRichMediaNetMonitor_videoDown", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void a(axyg paramaxyg, axyv paramaxyv)
  {
    this.jdField_a_of_type_Axyg = null;
    if (paramaxyv != null)
    {
      int i = 0;
      if (i < paramaxyv.jdField_a_of_type_JavaUtilList.size())
      {
        axzj localaxzj = (axzj)paramaxyv.jdField_a_of_type_JavaUtilList.get(i);
        b("procUrl", localaxzj.toString());
        a(this.jdField_a_of_type_Axow, localaxzj);
        if ((g()) && (localaxzj.jdField_b_of_type_JavaUtilArrayList.size() > 0))
        {
          this.jdField_a_of_type_JavaUtilArrayList = localaxzj.jdField_b_of_type_JavaUtilArrayList;
          if (h()) {
            this.jdField_a_of_type_JavaUtilArrayList.addAll(localaxzj.jdField_a_of_type_JavaUtilArrayList);
          }
          label108:
          this.jdField_b_of_type_JavaLangString = localaxzj.jdField_b_of_type_JavaLangString;
          if (this.jdField_j_of_type_Boolean)
          {
            this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
            if (this.jdField_a_of_type_JavaUtilArrayList != null) {
              this.jdField_a_of_type_JavaUtilArrayList.clear();
            }
          }
          if (localaxzj.jdField_c_of_type_Int != 0) {
            break label372;
          }
          if (QLog.isColorLevel()) {
            if ("onBusiProtoResp() cdn ---- mIpListSize:" + this.jdField_a_of_type_JavaUtilArrayList != null) {
              break label306;
            }
          }
        }
        label306:
        for (paramaxyg = Integer.valueOf(0);; paramaxyg = this.jdField_a_of_type_JavaUtilArrayList.size() + " mHostType:" + localaxzj.jdField_a_of_type_Int + " domain:" + localaxzj.jdField_b_of_type_JavaLangString + " url:" + localaxzj.jdField_c_of_type_JavaLangString)
        {
          QLog.d("ShortVideoDownloadProcessor", 2, new Object[] { paramaxyg });
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- mUiRequest.mMd5:" + this.jdField_a_of_type_Axvt.f);
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- downResp.md5:" + HexUtil.bytes2HexStr(localaxzj.jdField_a_of_type_ArrayOfByte));
          this.jdField_c_of_type_JavaLangString = localaxzj.jdField_c_of_type_JavaLangString;
          a(localaxzj.jdField_b_of_type_ArrayOfByte);
          i += 1;
          break;
          this.jdField_a_of_type_JavaUtilArrayList = localaxzj.jdField_a_of_type_JavaUtilArrayList;
          break label108;
        }
        label372:
        if ((!localaxzj.e) && (this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
        {
          ((MessageForShortVideo)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isAllowAutoDown = false;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()-- server return not allow auto retry");
          }
        }
        if (-5100026 != this.jdField_j_of_type_Int) {
          break label518;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_Axvt.f);
        }
        b(-5100026, "安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_Axvt.f);
      }
    }
    for (;;)
    {
      d();
      return;
      label518:
      if ((-9527 == this.jdField_j_of_type_Int) && ((this.i.equals("H_400_-5103017")) || (this.i.equals("H_400_-5103059"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + this.jdField_j_of_type_Int);
        }
        b(this.jdField_j_of_type_Int, ajjy.a(2131648281));
      }
      else if (-5100528 == this.jdField_j_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 后台不允许自动下载, errCode = " + this.jdField_j_of_type_Int);
        }
        b(-5100528, ajjy.a(2131648286));
      }
      else
      {
        b(9045, ajjy.a(2131648288));
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axvt.jdField_g_of_type_Boolean) {}
    while (((!paramBoolean) && (axtt.b(this.jdField_j_of_type_Int))) || (this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      if (this.p > 0)
      {
        new HashMap().put("businessType", String.valueOf(this.jdField_a_of_type_Axvt.jdField_b_of_type_Int));
        awrn.a(BaseApplication.getContext()).a(null, "actShortVideoRedirect", true, this.jdField_c_of_type_Long, this.p, this.jdField_a_of_type_JavaUtilHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "mRedirectReportInfo = " + this.p + " " + this.jdField_c_of_type_Long + " " + this.jdField_a_of_type_Axvt.jdField_b_of_type_Int);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "reportTag = " + b());
      }
      l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      String str = this.jdField_a_of_type_Axow.a(1) + ";" + this.jdField_b_of_type_Axow.a(2) + ";" + this.jdField_c_of_type_Axow.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.f);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Axqf.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", this.jdField_a_of_type_Axvt.f);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.jdField_c_of_type_Int + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.r));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Axvt.jdField_g_of_type_Int));
      if (!paramBoolean) {
        break label539;
      }
      awrn.a(BaseApplication.getContext()).a(null, b(), true, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      b(paramBoolean, l);
      l();
      return;
      i = 1;
      break;
      label539:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.i);
      if (this.jdField_j_of_type_Int == -6103066) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", "uierquest md5=" + this.jdField_a_of_type_Axvt.f + "fileMd5=" + this.jdField_k_of_type_JavaLangString);
      }
      awrn.a(BaseApplication.getContext()).a(null, b(), false, l, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  void a(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile encrypted ! ");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_encrypt", String.valueOf(1));
    }
    String str;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      this.jdField_b_of_type_Axow.a();
      str = c();
      localObject1 = new axro();
      if (!baip.a(this.jdField_b_of_type_JavaLangString)) {
        ((axro)localObject1).jdField_a_of_type_JavaUtilHashMap.put("host", this.jdField_b_of_type_JavaLangString);
      }
      ((axro)localObject1).jdField_a_of_type_Axrt = this;
      ((axro)localObject1).jdField_a_of_type_Axru = this;
      ((axro)localObject1).jdField_a_of_type_JavaLangString = str;
      ((axro)localObject1).jdField_a_of_type_Int = 0;
      ((axro)localObject1).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      ((axro)localObject1).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.h;
      ((axro)localObject1).jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
      ((axro)localObject1).jdField_g_of_type_Int = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
      ((axro)localObject1).f = this.jdField_a_of_type_Axvt.jdField_b_of_type_Int;
      if ((this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 6) || (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 9) || (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 17))
      {
        localObject2 = baig.f(BaseApplication.getContext());
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localObject2 = ((String)localObject2).split("\\|");
          if ((localObject2 != null) && (localObject2.length > 0)) {
            ((axro)localObject1).jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject2);
          }
        }
      }
      if (paramArrayOfByte != null) {
        ((axro)localObject1).jdField_a_of_type_Axrp = new axrp(paramArrayOfByte);
      }
      ((axro)localObject1).jdField_a_of_type_Long = 0L;
      ((axro)localObject1).jdField_k_of_type_Boolean = true;
      ((axro)localObject1).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      ((axro)localObject1).jdField_a_of_type_Axrs = this.jdField_b_of_type_Axrs;
      ((axro)localObject1).jdField_d_of_type_JavaLangString = (this.jdField_a_of_type_Axvt.h + "." + MD5.toMD5(this.f) + ".tmp");
      if (a())
      {
        paramArrayOfByte = (MessageForShortVideo)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        ((axro)localObject1).i = true;
        ((axro)localObject1).jdField_j_of_type_Boolean = false;
        if (new File(((axro)localObject1).jdField_d_of_type_JavaLangString).exists()) {
          ((axro)localObject1).jdField_a_of_type_Long = paramArrayOfByte.transferedSize;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mUseRaf =>>>");
        }
      }
      b("httpDown", "url:" + str + ",downOffset:" + ((axro)localObject1).jdField_a_of_type_Long);
      if (f()) {
        break;
      }
      jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile unencrypted ! ");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_encrypt", String.valueOf(0));
    }
    this.jdField_a_of_type_Axsp = ((axsp)localObject1);
    n();
    ((axro)localObject1).jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mIsOnlyGetUrl " + this.jdField_a_of_type_Axvt.jdField_g_of_type_Boolean + " domain=" + this.jdField_b_of_type_JavaLangString + " ipsize=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    if (this.jdField_a_of_type_Axvt.jdField_g_of_type_Boolean)
    {
      localObject1 = null;
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) || (!baip.a(this.jdField_b_of_type_JavaLangString)))
      {
        if (baip.a(this.jdField_b_of_type_JavaLangString))
        {
          paramArrayOfByte = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
          for (;;)
          {
            localObject1 = paramArrayOfByte;
            if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            localObject1 = (axuh)this.jdField_a_of_type_JavaUtilArrayList.get(i);
            localObject2 = new StringBuffer();
            ((StringBuffer)localObject2).append("http://");
            ((StringBuffer)localObject2).append(((axuh)localObject1).jdField_a_of_type_JavaLangString);
            if (((axuh)localObject1).jdField_a_of_type_Int != 80)
            {
              ((StringBuffer)localObject2).append(":");
              ((StringBuffer)localObject2).append(((axuh)localObject1).jdField_a_of_type_Int);
            }
            ((StringBuffer)localObject2).append("/");
            paramArrayOfByte[i] = axub.a(str, ((StringBuffer)localObject2).toString());
            i += 1;
          }
        }
        paramArrayOfByte = new String[this.jdField_a_of_type_JavaUtilArrayList.size() + 1];
        if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          paramArrayOfByte[(paramArrayOfByte.length - 1)] = str;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoDownloadProcessor", 2, "last url= " + paramArrayOfByte[(paramArrayOfByte.length - 1)]);
          }
          break;
          localObject1 = new StringBuffer();
          if (!this.jdField_b_of_type_JavaLangString.startsWith("http://")) {
            ((StringBuffer)localObject1).append("http://");
          }
          ((StringBuffer)localObject1).append(this.jdField_b_of_type_JavaLangString);
          if (!this.jdField_b_of_type_JavaLangString.endsWith("/")) {
            ((StringBuffer)localObject1).append("/");
          }
          paramArrayOfByte[(paramArrayOfByte.length - 1)] = axub.a(str, ((StringBuffer)localObject1).toString());
        }
      }
      this.jdField_a_of_type_Axqf.c = ((String[])localObject1);
      this.jdField_a_of_type_Axqf.u = this.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Axqf.f = this.jdField_a_of_type_Axow.a();
      d(2002);
      this.jdField_a_of_type_Axos.a(a());
      jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Axrr.a((axsp)localObject1);
  }
  
  public void aU_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "start()----runningTasks.contains(mTaskKey) = " + jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_e_of_type_JavaLangString));
    }
    if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      b("start", "[tvk] videoFileSize = " + localMessageForShortVideo.videoFileSize);
    }
    if ((this.jdField_a_of_type_Axvt.jdField_g_of_type_Int == 2) && (this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) && (!((MessageForShortVideo)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isAllowAutoDown) && ((this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 6) || (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 9) || (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 17)))
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
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      this.o = false;
      d(2001);
      this.jdField_j_of_type_Int = 0;
      this.i = "";
      this.jdField_a_of_type_Axos.a.post(new ShortVideoDownloadProcessor.1(this));
    }
    return 0;
  }
  
  protected String b()
  {
    String str = "actShortVideoDownloadVideo";
    if (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 7) {
      str = "actShortVideoDownloadThumb";
    }
    do
    {
      return str;
      if (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 6) {
        return "actShortVideoDownloadVideo";
      }
      if ((this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 16) || (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int == 18))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString);
        return "actShortVideoDiscussgroupDownloadThumb";
      }
    } while ((this.jdField_a_of_type_Axvt.jdField_b_of_type_Int != 9) && (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int != 17));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString);
    return "actShortVideoDiscussgroupDownloadVideo";
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Axvt == null) || (this.jdField_a_of_type_Axvt.h == null))
    {
      b(9302, ajjy.a(2131648258));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Axvt != null) && (this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0)) {
      this.n = true;
    }
    return 0;
  }
  
  protected String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      axuh localaxuh = (axuh)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localStringBuilder.append("http://");
      localStringBuilder.append(localaxuh.jdField_a_of_type_JavaLangString);
      if ((localaxuh.jdField_a_of_type_Int != 80) && (localaxuh.jdField_a_of_type_Int != 0))
      {
        localStringBuilder.append(":");
        localStringBuilder.append(localaxuh.jdField_a_of_type_Int);
      }
      localStringBuilder.append("/");
    }
    for (;;)
    {
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      b("getConnUrl", "cdn url = " + localStringBuilder.toString());
      return localStringBuilder.toString();
      if (!this.jdField_b_of_type_JavaLangString.startsWith("http://")) {
        localStringBuilder.append("http://");
      }
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      if (!this.jdField_b_of_type_JavaLangString.endsWith("/")) {
        localStringBuilder.append("/");
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "pause() mIsPause : " + this.jdField_k_of_type_Boolean);
    }
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = true;
      d(2004);
      if (this.jdField_a_of_type_Axyg != null)
      {
        axzm.b(this.jdField_a_of_type_Axyg);
        this.jdField_a_of_type_Axyg = null;
      }
      if (this.jdField_a_of_type_Axsp != null)
      {
        this.jdField_a_of_type_Axrr.b(this.jdField_a_of_type_Axsp);
        this.jdField_a_of_type_Axsp = null;
      }
    }
  }
  
  void d()
  {
    super.d();
    jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_Axqf.jdField_g_of_type_Int = this.jdField_j_of_type_Int;
    if (-5100026 == this.jdField_j_of_type_Int) {
      d(5001);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errCode:" + this.jdField_j_of_type_Int);
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errDesc:" + this.i);
      }
      Object localObject = null;
      if (this.jdField_a_of_type_Axvt != null) {
        localObject = this.jdField_a_of_type_Axvt.jdField_a_of_type_Axwa;
      }
      if (localObject != null)
      {
        ((axwa)localObject).jdField_a_of_type_Int = -1;
        ((axwa)localObject).jdField_a_of_type_Long = this.jdField_j_of_type_Int;
        ((axwa)localObject).jdField_a_of_type_JavaLangString = this.i;
        ((axwa)localObject).jdField_a_of_type_Axvt = this.jdField_a_of_type_Axvt;
      }
      localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        atpa localatpa = (atpa)((Iterator)localObject).next();
        atpb localatpb = new atpb();
        localatpb.jdField_a_of_type_Int = -1;
        localatpb.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
        localatpb.jdField_a_of_type_JavaLangString = this.i;
        localatpa.a(localatpb);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideo.TAG", 2, "onError ");
        }
      }
      if ((-9527 == this.jdField_j_of_type_Int) && ((this.i.equals("H_400_-5103017")) || (this.i.equals("H_400_-5103059")))) {
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
    if ((this.jdField_k_of_type_Boolean) && (2004 != paramInt)) {
      return;
    }
    aweg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Axqf, this.jdField_a_of_type_Axvt);
  }
  
  void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "successfully downloaded.");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
    d(2003);
    Object localObject = this.jdField_a_of_type_Axvt.jdField_a_of_type_Axwa;
    if (localObject != null)
    {
      ((axwa)localObject).jdField_a_of_type_Int = 0;
      ((axwa)localObject).jdField_a_of_type_Axvt = this.jdField_a_of_type_Axvt;
    }
    localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      atpa localatpa = (atpa)((Iterator)localObject).next();
      atpb localatpb = new atpb();
      localatpb.jdField_a_of_type_Int = 0;
      localatpb.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Axvt.h;
      localatpb.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.f;
      localatpb.jdField_d_of_type_Int = this.jdField_a_of_type_Axvt.jdField_g_of_type_Int;
      localatpa.a(localatpb);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Axow.a();
    axyg localaxyg = new axyg();
    axys localaxys = new axys();
    localaxys.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + localaxys.jdField_c_of_type_Int);
    }
    localaxys.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_b_of_type_JavaLangString;
    localaxys.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString;
    localaxys.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_d_of_type_JavaLangString;
    localaxys.f = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
    localaxys.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString;
    localaxys.jdField_d_of_type_Int = 0;
    if (localaxys.f == 0)
    {
      localaxys.jdField_a_of_type_Int = 0;
      if ((localaxys.f != 0) && (1008 != localaxys.f)) {
        break label480;
      }
      localaxys.jdField_b_of_type_JavaLangString = null;
      label164:
      localaxys.jdField_b_of_type_Int = 2;
      localaxys.jdField_a_of_type_JavaLangString = this.f;
      localaxys.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_Axvt.f);
      if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {
        break label494;
      }
      localaxys.jdField_e_of_type_Int = ((MessageForShortVideo)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;
      label231:
      this.jdField_c_of_type_Int = localaxys.jdField_e_of_type_Int;
      localaxys.jdField_j_of_type_Int = 0;
      if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
      {
        if (!(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForLightVideo)) {
          break label526;
        }
        localaxys.jdField_j_of_type_Int = 3;
      }
      label285:
      if ((this.jdField_a_of_type_Axvt.jdField_b_of_type_Int != 7) && (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int != 16) && (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int != 18)) {
        break label551;
      }
    }
    label526:
    label551:
    for (localaxys.jdField_g_of_type_Int = 1;; localaxys.jdField_g_of_type_Int = 2) {
      label480:
      label494:
      do
      {
        localaxys.h = this.jdField_a_of_type_Axvt.jdField_g_of_type_Int;
        if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject instanceof Integer))) {
          localaxys.i = ((Integer)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject).intValue();
        }
        localaxyg.jdField_a_of_type_Axzn = this;
        localaxyg.jdField_a_of_type_JavaLangString = "short_video_dw";
        localaxyg.jdField_a_of_type_JavaUtilList.add(localaxys);
        localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
        if (e()) {
          break label595;
        }
        a(9366, "illegal app", null, this.jdField_a_of_type_Axow);
        d();
        return;
        if (1 == localaxys.f)
        {
          localaxys.jdField_a_of_type_Int = 1;
          break;
        }
        if (3000 == localaxys.f)
        {
          localaxys.jdField_a_of_type_Int = 2;
          break;
        }
        localaxys.jdField_a_of_type_Int = 3;
        break;
        localaxys.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString;
        break label164;
        if (1008 == localaxys.f)
        {
          localaxys.jdField_e_of_type_Int = this.jdField_a_of_type_Axvt.jdField_e_of_type_Int;
          break label231;
        }
        localaxys.jdField_e_of_type_Int = 0;
        break label231;
        if (((MessageForShortVideo)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).subBusiType != 1) {
          break label285;
        }
        localaxys.jdField_j_of_type_Int = 1;
        break label285;
      } while ((this.jdField_a_of_type_Axvt.jdField_b_of_type_Int != 6) && (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int != 9) && (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int != 17));
    }
    label595:
    b("requestStart", localaxyg.toString());
    if (!f())
    {
      jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Axyg = localaxyg;
    axzm.a(localaxyg);
  }
  
  protected void n()
  {
    String str;
    if ((this.jdField_a_of_type_Axsp != null) && ((this.jdField_a_of_type_Axsp instanceof axro)))
    {
      if (!akbm.c(this.jdField_a_of_type_Axvt.jdField_a_of_type_Int)) {
        break label59;
      }
      str = "videoCd";
    }
    for (;;)
    {
      ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype(str, ((axro)this.jdField_a_of_type_Axsp).jdField_a_of_type_JavaLangString);
      return;
      label59:
      if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Int == 1) {
        str = "videoGd";
      } else if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Int == 3000) {
        str = "videoDd";
      } else {
        str = "videoOd";
      }
    }
  }
  
  /* Error */
  public void onResp(axsq paramaxsq)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 875	axoo:onResp	(Laxsq;)V
    //   11: new 81	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 877
    //   21: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 879	axuk:jdField_a_of_type_Boolean	Z
    //   28: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: ldc_w 881
    //   34: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: astore 9
    //   39: aload_1
    //   40: getfield 882	axsq:jdField_a_of_type_Int	I
    //   43: ifne +594 -> 637
    //   46: iconst_1
    //   47: istore 4
    //   49: aload_0
    //   50: ldc_w 884
    //   53: aload 9
    //   55: iload 4
    //   57: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 288	axuk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +90 -> 159
    //   72: ldc 79
    //   74: iconst_2
    //   75: new 81	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 886
    //   85: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_1
    //   89: getfield 882	axsq:jdField_a_of_type_Int	I
    //   92: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: ldc 79
    //   103: iconst_2
    //   104: new 81	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 888
    //   114: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: getfield 889	axsq:jdField_b_of_type_Int	I
    //   121: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: ldc 79
    //   132: iconst_2
    //   133: new 81	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 891
    //   143: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_1
    //   147: getfield 892	axsq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   150: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +36 -> 198
    //   165: ldc 79
    //   167: iconst_2
    //   168: new 81	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 894
    //   178: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: getfield 896	axsq:j	J
    //   185: ldc2_w 897
    //   188: ldiv
    //   189: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   192: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload_0
    //   199: getfield 879	axuk:jdField_a_of_type_Boolean	Z
    //   202: ifeq +441 -> 643
    //   205: aload_0
    //   206: getfield 900	axuk:d	Laxow;
    //   209: astore 9
    //   211: aload_1
    //   212: getfield 882	axsq:jdField_a_of_type_Int	I
    //   215: ifne +437 -> 652
    //   218: iconst_1
    //   219: istore 4
    //   221: aload_0
    //   222: aload 9
    //   224: aload_1
    //   225: iload 4
    //   227: invokevirtual 903	axuk:a	(Laxow;Laxsq;Z)V
    //   230: aload_0
    //   231: aload_1
    //   232: getfield 904	axsq:jdField_a_of_type_Long	J
    //   235: putfield 474	axuk:jdField_a_of_type_Long	J
    //   238: aload_0
    //   239: getfield 474	axuk:jdField_a_of_type_Long	J
    //   242: lconst_0
    //   243: lcmp
    //   244: ifgt +19 -> 263
    //   247: aload_0
    //   248: aload_1
    //   249: getfield 906	axsq:jdField_b_of_type_Long	J
    //   252: aload_1
    //   253: getfield 907	axsq:jdField_a_of_type_Axsp	Laxsp;
    //   256: getfield 910	axsp:jdField_a_of_type_Long	J
    //   259: ladd
    //   260: putfield 474	axuk:jdField_a_of_type_Long	J
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 911	axuk:jdField_b_of_type_Long	J
    //   268: aload_1
    //   269: getfield 912	axsq:jdField_c_of_type_Long	J
    //   272: ladd
    //   273: putfield 911	axuk:jdField_b_of_type_Long	J
    //   276: aload_0
    //   277: aload_1
    //   278: getfield 914	axsq:g	J
    //   281: putfield 44	axuk:jdField_c_of_type_Long	J
    //   284: aload_0
    //   285: aload_1
    //   286: getfield 915	axsq:jdField_e_of_type_Int	I
    //   289: putfield 46	axuk:p	I
    //   292: aload_1
    //   293: getfield 882	axsq:jdField_a_of_type_Int	I
    //   296: ifne +523 -> 819
    //   299: aload_0
    //   300: getfield 143	axuk:jdField_a_of_type_Axvt	Laxvt;
    //   303: getfield 238	axvt:f	Ljava/lang/String;
    //   306: astore 10
    //   308: aload 10
    //   310: invokestatic 921	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifne +689 -> 1002
    //   316: aload_0
    //   317: getfield 143	axuk:jdField_a_of_type_Axvt	Laxvt;
    //   320: getfield 106	axvt:h	Ljava/lang/String;
    //   323: astore 9
    //   325: new 923	java/io/FileInputStream
    //   328: dup
    //   329: aload 9
    //   331: invokespecial 924	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   334: astore 9
    //   336: aload 9
    //   338: aload 9
    //   340: invokevirtual 927	java/io/FileInputStream:available	()I
    //   343: i2l
    //   344: invokestatic 931	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   347: astore 11
    //   349: aload 11
    //   351: ifnull +646 -> 997
    //   354: aload_0
    //   355: aload 11
    //   357: invokestatic 346	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   360: putfield 40	axuk:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   363: aload_0
    //   364: getfield 40	axuk:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   367: aload 10
    //   369: invokevirtual 382	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   372: ifne +625 -> 997
    //   375: aload_0
    //   376: getfield 143	axuk:jdField_a_of_type_Axvt	Laxvt;
    //   379: getfield 110	axvt:jdField_b_of_type_Int	I
    //   382: bipush 6
    //   384: if_icmpeq +27 -> 411
    //   387: aload_0
    //   388: getfield 143	axuk:jdField_a_of_type_Axvt	Laxvt;
    //   391: getfield 110	axvt:jdField_b_of_type_Int	I
    //   394: bipush 9
    //   396: if_icmpeq +15 -> 411
    //   399: aload_0
    //   400: getfield 143	axuk:jdField_a_of_type_Axvt	Laxvt;
    //   403: getfield 110	axvt:jdField_b_of_type_Int	I
    //   406: bipush 17
    //   408: if_icmpne +589 -> 997
    //   411: aload_0
    //   412: ldc_w 486
    //   415: ldc_w 933
    //   418: invokevirtual 375	axuk:b	(ILjava/lang/String;)V
    //   421: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +43 -> 467
    //   427: ldc 79
    //   429: iconst_2
    //   430: new 81	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 935
    //   440: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 10
    //   445: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: ldc_w 937
    //   451: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload_0
    //   455: getfield 40	axuk:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   458: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 939	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: iconst_0
    //   468: istore_2
    //   469: iload_2
    //   470: istore_3
    //   471: aload 9
    //   473: ifnull +10 -> 483
    //   476: aload 9
    //   478: invokevirtual 942	java/io/FileInputStream:close	()V
    //   481: iload_2
    //   482: istore_3
    //   483: aload_0
    //   484: getfield 416	axuk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   487: astore 9
    //   489: iload_3
    //   490: ifeq +299 -> 789
    //   493: iconst_1
    //   494: istore_2
    //   495: aload 9
    //   497: ldc_w 944
    //   500: iload_2
    //   501: invokestatic 232	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   504: invokevirtual 192	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: pop
    //   508: aload_0
    //   509: invokespecial 163	axuk:a	()Z
    //   512: ifeq +104 -> 616
    //   515: new 568	java/io/File
    //   518: dup
    //   519: aload_0
    //   520: getfield 182	axuk:jdField_a_of_type_Axsp	Laxsp;
    //   523: getfield 945	axsp:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   526: invokespecial 569	java/io/File:<init>	(Ljava/lang/String;)V
    //   529: astore 9
    //   531: new 568	java/io/File
    //   534: dup
    //   535: aload_0
    //   536: getfield 143	axuk:jdField_a_of_type_Axvt	Laxvt;
    //   539: getfield 106	axvt:h	Ljava/lang/String;
    //   542: invokespecial 569	java/io/File:<init>	(Ljava/lang/String;)V
    //   545: astore 10
    //   547: aload 9
    //   549: aload 10
    //   551: invokestatic 950	ew:a	(Ljava/io/File;Ljava/io/File;)Z
    //   554: pop
    //   555: iload 6
    //   557: istore 4
    //   559: iload 4
    //   561: istore 5
    //   563: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +50 -> 616
    //   569: ldc 79
    //   571: iconst_2
    //   572: new 81	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   579: ldc_w 952
    //   582: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload_0
    //   586: getfield 143	axuk:jdField_a_of_type_Axvt	Laxvt;
    //   589: getfield 106	axvt:h	Ljava/lang/String;
    //   592: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: ldc_w 954
    //   598: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: iload 4
    //   603: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   606: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 939	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: iload 4
    //   614: istore 5
    //   616: iload 5
    //   618: ifne +13 -> 631
    //   621: aload_0
    //   622: invokevirtual 955	axuk:e	()V
    //   625: aload_0
    //   626: aload_1
    //   627: iconst_1
    //   628: invokevirtual 176	axuk:a	(Laxsq;Z)V
    //   631: aload_0
    //   632: aconst_null
    //   633: putfield 182	axuk:jdField_a_of_type_Axsp	Laxsp;
    //   636: return
    //   637: iconst_0
    //   638: istore 4
    //   640: goto -591 -> 49
    //   643: aload_0
    //   644: getfield 441	axuk:jdField_b_of_type_Axow	Laxow;
    //   647: astore 9
    //   649: goto -438 -> 211
    //   652: iconst_0
    //   653: istore 4
    //   655: goto -434 -> 221
    //   658: astore 9
    //   660: iload_2
    //   661: istore_3
    //   662: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   665: ifeq -182 -> 483
    //   668: ldc 79
    //   670: iconst_2
    //   671: ldc_w 957
    //   674: aload 9
    //   676: invokestatic 960	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   679: iload_2
    //   680: istore_3
    //   681: goto -198 -> 483
    //   684: astore 10
    //   686: aconst_null
    //   687: astore 9
    //   689: iconst_1
    //   690: istore_2
    //   691: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   694: ifeq +14 -> 708
    //   697: ldc 79
    //   699: iconst_2
    //   700: ldc_w 957
    //   703: aload 10
    //   705: invokestatic 960	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   708: iload_2
    //   709: istore_3
    //   710: aload 9
    //   712: ifnull -229 -> 483
    //   715: aload 9
    //   717: invokevirtual 942	java/io/FileInputStream:close	()V
    //   720: iload_2
    //   721: istore_3
    //   722: goto -239 -> 483
    //   725: astore 9
    //   727: iload_2
    //   728: istore_3
    //   729: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   732: ifeq -249 -> 483
    //   735: ldc 79
    //   737: iconst_2
    //   738: ldc_w 957
    //   741: aload 9
    //   743: invokestatic 960	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   746: iload_2
    //   747: istore_3
    //   748: goto -265 -> 483
    //   751: astore_1
    //   752: aconst_null
    //   753: astore 9
    //   755: aload 9
    //   757: ifnull +8 -> 765
    //   760: aload 9
    //   762: invokevirtual 942	java/io/FileInputStream:close	()V
    //   765: aload_1
    //   766: athrow
    //   767: astore 9
    //   769: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   772: ifeq -7 -> 765
    //   775: ldc 79
    //   777: iconst_2
    //   778: ldc_w 957
    //   781: aload 9
    //   783: invokestatic 960	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   786: goto -21 -> 765
    //   789: iconst_0
    //   790: istore_2
    //   791: goto -296 -> 495
    //   794: astore 9
    //   796: aload_0
    //   797: sipush -30000
    //   800: ldc_w 961
    //   803: invokestatic 391	ajjy:a	(I)Ljava/lang/String;
    //   806: invokevirtual 375	axuk:b	(ILjava/lang/String;)V
    //   809: aload_0
    //   810: invokevirtual 377	axuk:d	()V
    //   813: iconst_1
    //   814: istore 4
    //   816: goto -257 -> 559
    //   819: aload_0
    //   820: getfield 879	axuk:jdField_a_of_type_Boolean	Z
    //   823: ifeq +10 -> 833
    //   826: aload_0
    //   827: invokevirtual 670	axuk:f	()V
    //   830: goto -199 -> 631
    //   833: aload_1
    //   834: getfield 962	axsq:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   837: ldc_w 964
    //   840: invokevirtual 966	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   843: ifnonnull +71 -> 914
    //   846: ldc2_w 967
    //   849: lstore 7
    //   851: aload_0
    //   852: getfield 416	axuk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   855: ldc_w 970
    //   858: lload 7
    //   860: invokestatic 463	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   863: invokevirtual 192	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   866: pop
    //   867: aload_1
    //   868: getfield 889	axsq:jdField_b_of_type_Int	I
    //   871: sipush 9364
    //   874: if_icmpne +61 -> 935
    //   877: aload_0
    //   878: getfield 972	axuk:l	I
    //   881: iconst_3
    //   882: if_icmpge +53 -> 935
    //   885: aload_0
    //   886: ldc_w 974
    //   889: ldc_w 976
    //   892: invokevirtual 288	axuk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   895: aload_0
    //   896: aload_0
    //   897: getfield 972	axuk:l	I
    //   900: iconst_1
    //   901: iadd
    //   902: putfield 972	axuk:l	I
    //   905: aload_0
    //   906: invokevirtual 978	axuk:m	()V
    //   909: aload_0
    //   910: invokevirtual 670	axuk:f	()V
    //   913: return
    //   914: aload_1
    //   915: getfield 962	axsq:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   918: ldc_w 964
    //   921: invokevirtual 966	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   924: checkcast 67	java/lang/String
    //   927: invokestatic 984	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   930: lstore 7
    //   932: goto -81 -> 851
    //   935: aload_1
    //   936: getfield 962	axsq:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   939: getstatic 987	bakw:f	Ljava/lang/String;
    //   942: invokevirtual 966	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   945: checkcast 67	java/lang/String
    //   948: astore 9
    //   950: aload_0
    //   951: aload_1
    //   952: getfield 889	axsq:jdField_b_of_type_Int	I
    //   955: aload_1
    //   956: getfield 892	axsq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   959: aload 9
    //   961: aload_0
    //   962: getfield 441	axuk:jdField_b_of_type_Axow	Laxow;
    //   965: invokevirtual 842	axuk:a	(ILjava/lang/String;Ljava/lang/String;Laxow;)V
    //   968: aload_0
    //   969: invokevirtual 377	axuk:d	()V
    //   972: goto -341 -> 631
    //   975: astore_1
    //   976: goto -221 -> 755
    //   979: astore_1
    //   980: goto -225 -> 755
    //   983: astore 10
    //   985: iconst_1
    //   986: istore_2
    //   987: goto -296 -> 691
    //   990: astore 10
    //   992: iconst_0
    //   993: istore_2
    //   994: goto -303 -> 691
    //   997: iconst_1
    //   998: istore_2
    //   999: goto -530 -> 469
    //   1002: iconst_1
    //   1003: istore_3
    //   1004: goto -521 -> 483
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1007	0	this	axuk
    //   0	1007	1	paramaxsq	axsq
    //   468	531	2	i	int
    //   470	534	3	j	int
    //   47	768	4	bool1	boolean
    //   1	616	5	m	int
    //   4	552	6	bool2	boolean
    //   849	82	7	l	long
    //   37	611	9	localObject1	Object
    //   658	17	9	localIOException1	java.io.IOException
    //   687	29	9	localObject2	Object
    //   725	17	9	localIOException2	java.io.IOException
    //   753	8	9	localObject3	Object
    //   767	15	9	localIOException3	java.io.IOException
    //   794	1	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   948	12	9	str	String
    //   306	244	10	localObject4	Object
    //   684	20	10	localIOException4	java.io.IOException
    //   983	1	10	localIOException5	java.io.IOException
    //   990	1	10	localIOException6	java.io.IOException
    //   347	9	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   476	481	658	java/io/IOException
    //   325	336	684	java/io/IOException
    //   715	720	725	java/io/IOException
    //   325	336	751	finally
    //   760	765	767	java/io/IOException
    //   547	555	794	java/lang/OutOfMemoryError
    //   336	349	975	finally
    //   354	411	975	finally
    //   411	421	975	finally
    //   421	467	975	finally
    //   691	708	979	finally
    //   336	349	983	java/io/IOException
    //   354	411	983	java/io/IOException
    //   411	421	983	java/io/IOException
    //   421	467	990	java/io/IOException
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    if (this.jdField_k_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoDownloadProcessor", 2, "onUpdateProgeress: mIsPause=true, should not notify UI, just return!");
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Axqf.e = paramLong1;
      this.jdField_a_of_type_Axqf.jdField_a_of_type_Long = paramLong2;
      d(2002);
      int i = (int)(10000L * paramLong1 / paramLong2);
      paramaxsp = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (paramaxsp.hasNext()) {
        ((atpa)paramaxsp.next()).a(i, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axuk
 * JD-Core Version:    0.7.0.1
 */