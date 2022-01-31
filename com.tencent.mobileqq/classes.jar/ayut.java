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

public class ayut
  extends ayow
  implements aysd
{
  static HashSet<String> a;
  private aysb b;
  int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long = 0L;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private String e;
  private String f;
  private String l;
  int p = 0;
  private int q;
  private int r;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public ayut(ayvx paramayvx, aywc paramaywc)
  {
    super(paramayvx, paramaywc);
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_b_of_type_Aysb = new ayuu(this);
    paramayvx = paramaywc.i;
    if (paramayvx != null)
    {
      String[] arrayOfString = paramayvx.split("QQ_&_MoblieQQ_&_QQ");
      if (arrayOfString.length < 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "path was not set correctlly------path = " + paramayvx);
        }
        throw new IllegalArgumentException("path was not set correctlly.");
      }
      paramaywc.h = arrayOfString[0];
      this.f = arrayOfString[1];
      this.jdField_e_of_type_JavaLangString = (this.f + paramaywc.jdField_b_of_type_Int + paramaywc.jdField_a_of_type_Long);
      this.q = Integer.parseInt(arrayOfString[2]);
      if (arrayOfString.length > 3) {
        this.r = Integer.parseInt(arrayOfString[3]);
      }
    }
  }
  
  private boolean a()
  {
    if ((aigt.a.get()) && ((this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
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
  
  public void a(aysz paramaysz)
  {
    a(paramaysz, false, "actRichMediaNetMonitor_videoDown", this.jdField_a_of_type_Aywc.f, this.f, this.jdField_c_of_type_Int + "");
  }
  
  public void a(ayyp paramayyp, ayze paramayze)
  {
    this.jdField_a_of_type_Ayyp = null;
    if (paramayze != null)
    {
      int i = 0;
      if (i < paramayze.jdField_a_of_type_JavaUtilList.size())
      {
        ayzs localayzs = (ayzs)paramayze.jdField_a_of_type_JavaUtilList.get(i);
        b("procUrl", localayzs.toString());
        a(this.jdField_a_of_type_Aypd, localayzs);
        if ((g()) && (localayzs.jdField_b_of_type_JavaUtilArrayList.size() > 0))
        {
          this.jdField_a_of_type_JavaUtilArrayList = localayzs.jdField_b_of_type_JavaUtilArrayList;
          if (h()) {
            this.jdField_a_of_type_JavaUtilArrayList.addAll(localayzs.jdField_a_of_type_JavaUtilArrayList);
          }
          label107:
          this.jdField_b_of_type_JavaLangString = localayzs.jdField_b_of_type_JavaLangString;
          if (this.jdField_j_of_type_Boolean)
          {
            this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
            if (this.jdField_a_of_type_JavaUtilArrayList != null) {
              this.jdField_a_of_type_JavaUtilArrayList.clear();
            }
          }
          if (localayzs.jdField_c_of_type_Int != 0) {
            break label367;
          }
          if (QLog.isColorLevel()) {
            if ("onBusiProtoResp() cdn ---- mIpListSize:" + this.jdField_a_of_type_JavaUtilArrayList != null) {
              break label301;
            }
          }
        }
        label301:
        for (paramayyp = Integer.valueOf(0);; paramayyp = this.jdField_a_of_type_JavaUtilArrayList.size() + " mHostType:" + localayzs.jdField_a_of_type_Int + " domain:" + localayzs.jdField_b_of_type_JavaLangString + " url:" + localayzs.jdField_c_of_type_JavaLangString)
        {
          QLog.d("ShortVideoDownloadProcessor", 2, new Object[] { paramayyp });
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- mUiRequest.mMd5:" + this.jdField_a_of_type_Aywc.f);
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- downResp.md5:" + HexUtil.bytes2HexStr(localayzs.jdField_a_of_type_ArrayOfByte));
          this.jdField_c_of_type_JavaLangString = localayzs.jdField_c_of_type_JavaLangString;
          a(localayzs.jdField_b_of_type_ArrayOfByte);
          i += 1;
          break;
          this.jdField_a_of_type_JavaUtilArrayList = localayzs.jdField_a_of_type_JavaUtilArrayList;
          break label107;
        }
        label367:
        if ((!localayzs.e) && (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
        {
          ((MessageForShortVideo)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isAllowAutoDown = false;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()-- server return not allow auto retry");
          }
        }
        if (-5100026 != this.jdField_j_of_type_Int) {
          break label513;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_Aywc.f);
        }
        b(-5100026, "安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_Aywc.f);
      }
    }
    for (;;)
    {
      d();
      return;
      label513:
      if ((-9527 == this.jdField_j_of_type_Int) && ((this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")) || (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103059"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + this.jdField_j_of_type_Int);
        }
        b(this.jdField_j_of_type_Int, ajya.a(2131714080));
      }
      else if (-5100528 == this.jdField_j_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 后台不允许自动下载, errCode = " + this.jdField_j_of_type_Int);
        }
        b(-5100528, ajya.a(2131714085));
      }
      else
      {
        b(9045, ajya.a(2131714087));
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aywc.jdField_g_of_type_Boolean) {}
    while (((!paramBoolean) && (ayuc.b(this.jdField_j_of_type_Int))) || (this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      if (this.p > 0)
      {
        new HashMap().put("businessType", String.valueOf(this.jdField_a_of_type_Aywc.jdField_b_of_type_Int));
        axrn.a(BaseApplication.getContext()).a(null, "actShortVideoRedirect", true, this.jdField_c_of_type_Long, this.p, this.jdField_a_of_type_JavaUtilHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "mRedirectReportInfo = " + this.p + " " + this.jdField_c_of_type_Long + " " + this.jdField_a_of_type_Aywc.jdField_b_of_type_Int);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "reportTag = " + b());
      }
      l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      String str = this.jdField_a_of_type_Aypd.a(1) + ";" + this.jdField_b_of_type_Aypd.a(2) + ";" + this.jdField_c_of_type_Aypd.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.f);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", this.jdField_a_of_type_Aywc.f);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.jdField_c_of_type_Int + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.r));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Aywc.jdField_g_of_type_Int));
      if (!paramBoolean) {
        break label539;
      }
      axrn.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      b(paramBoolean, l1);
      l();
      return;
      i = 1;
      break;
      label539:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      if (this.jdField_j_of_type_Int == -6103066) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", "uierquest md5=" + this.jdField_a_of_type_Aywc.f + "fileMd5=" + this.jdField_l_of_type_JavaLangString);
      }
      axrn.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
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
      this.jdField_b_of_type_Aypd.a();
      str = c();
      localObject1 = new ayrx();
      if (!bbkk.a(this.jdField_b_of_type_JavaLangString)) {
        ((ayrx)localObject1).jdField_a_of_type_JavaUtilHashMap.put("host", this.jdField_b_of_type_JavaLangString);
      }
      ((ayrx)localObject1).jdField_a_of_type_Aysc = this;
      ((ayrx)localObject1).jdField_a_of_type_Aysd = this;
      ((ayrx)localObject1).jdField_a_of_type_JavaLangString = str;
      ((ayrx)localObject1).jdField_a_of_type_Int = 0;
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0))
      {
        localObject2 = new ayuq();
        ((ayuq)localObject2).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        ((ayuq)localObject2).b = true;
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
      ((ayrx)localObject1).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      ((ayrx)localObject1).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywc.h;
      ((ayrx)localObject1).jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
      ((ayrx)localObject1).jdField_g_of_type_Int = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
      ((ayrx)localObject1).f = this.jdField_a_of_type_Aywc.jdField_b_of_type_Int;
      if ((this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 6) || (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 9) || (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 17))
      {
        localObject2 = bbkb.f(BaseApplication.getContext());
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localObject2 = ((String)localObject2).split("\\|");
          if ((localObject2 != null) && (localObject2.length > 0)) {
            ((ayrx)localObject1).jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject2);
          }
        }
      }
      if (paramArrayOfByte != null) {
        ((ayrx)localObject1).jdField_a_of_type_Ayry = new ayry(paramArrayOfByte);
      }
      ((ayrx)localObject1).jdField_a_of_type_Long = 0L;
      ((ayrx)localObject1).jdField_k_of_type_Boolean = true;
      ((ayrx)localObject1).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      ((ayrx)localObject1).jdField_a_of_type_Aysb = this.jdField_b_of_type_Aysb;
      ((ayrx)localObject1).jdField_d_of_type_JavaLangString = (this.jdField_a_of_type_Aywc.h + "." + MD5.toMD5(this.f) + ".tmp");
      if (a())
      {
        paramArrayOfByte = (MessageForShortVideo)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        ((ayrx)localObject1).i = true;
        ((ayrx)localObject1).jdField_j_of_type_Boolean = false;
        if (new File(((ayrx)localObject1).jdField_d_of_type_JavaLangString).exists()) {
          ((ayrx)localObject1).jdField_a_of_type_Long = paramArrayOfByte.transferedSize;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mUseRaf =>>>");
        }
      }
      b("httpDown", "url:" + str + ",downOffset:" + ((ayrx)localObject1).jdField_a_of_type_Long);
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
    this.jdField_a_of_type_Aysy = ((aysy)localObject1);
    n();
    ((ayrx)localObject1).jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mIsOnlyGetUrl " + this.jdField_a_of_type_Aywc.jdField_g_of_type_Boolean + " domain=" + this.jdField_b_of_type_JavaLangString + " ipsize=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    if (this.jdField_a_of_type_Aywc.jdField_g_of_type_Boolean)
    {
      paramArrayOfByte = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (ayuq)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("http://");
        ((StringBuffer)localObject2).append(((ayuq)localObject1).jdField_a_of_type_JavaLangString);
        if (((ayuq)localObject1).jdField_a_of_type_Int != 80)
        {
          ((StringBuffer)localObject2).append(":");
          ((StringBuffer)localObject2).append(((ayuq)localObject1).jdField_a_of_type_Int);
        }
        ((StringBuffer)localObject2).append("/");
        paramArrayOfByte[i] = ayuk.a(str, ((StringBuffer)localObject2).toString());
        i += 1;
      }
      this.jdField_a_of_type_Ayqo.c = paramArrayOfByte;
      this.jdField_a_of_type_Ayqo.u = this.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Ayqo.f = this.jdField_a_of_type_Aypd.a();
      d(2002);
      this.jdField_a_of_type_Ayoz.a(a());
      jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Aysa.a((aysy)localObject1);
  }
  
  public void aR_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "start()----runningTasks.contains(mTaskKey) = " + jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_e_of_type_JavaLangString));
    }
    if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      b("start", "[tvk] videoFileSize = " + localMessageForShortVideo.videoFileSize);
    }
    if ((this.jdField_a_of_type_Aywc.jdField_g_of_type_Int == 2) && (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) && (!((MessageForShortVideo)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isAllowAutoDown) && ((this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 6) || (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 9) || (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 17)))
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
      this.jdField_j_of_type_JavaLangString = "";
      this.jdField_a_of_type_Ayoz.a.post(new ShortVideoDownloadProcessor.1(this));
    }
    return 0;
  }
  
  protected String b()
  {
    String str = "actShortVideoDownloadVideo";
    if (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 7) {
      str = "actShortVideoDownloadThumb";
    }
    do
    {
      return str;
      if (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 6) {
        return "actShortVideoDownloadVideo";
      }
      if ((this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 16) || (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 18))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString);
        return "actShortVideoDiscussgroupDownloadThumb";
      }
    } while ((this.jdField_a_of_type_Aywc.jdField_b_of_type_Int != 9) && (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int != 17));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString);
    return "actShortVideoDiscussgroupDownloadVideo";
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Aywc == null) || (this.jdField_a_of_type_Aywc.h == null))
    {
      b(9302, ajya.a(2131714057));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Aywc != null) && (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0)) {
      this.n = true;
    }
    return 0;
  }
  
  protected String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ayuq localayuq;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localayuq = (ayuq)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localStringBuilder.append("http://");
      if ((localayuq.jdField_a_of_type_Boolean) && (!localayuq.jdField_a_of_type_JavaLangString.startsWith("[")))
      {
        localStringBuilder.append("[" + localayuq.jdField_a_of_type_JavaLangString + "]");
        if ((localayuq.jdField_a_of_type_Int != 80) && (localayuq.jdField_a_of_type_Int != 0))
        {
          localStringBuilder.append(":");
          localStringBuilder.append(localayuq.jdField_a_of_type_Int);
        }
        localStringBuilder.append("/");
      }
    }
    for (;;)
    {
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      b("getConnUrl", "cdn url = " + localStringBuilder.toString());
      return localStringBuilder.toString();
      localStringBuilder.append(localayuq.jdField_a_of_type_JavaLangString);
      break;
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
      if (this.jdField_a_of_type_Ayyp != null)
      {
        ayzv.b(this.jdField_a_of_type_Ayyp);
        this.jdField_a_of_type_Ayyp = null;
      }
      if (this.jdField_a_of_type_Aysy != null)
      {
        this.jdField_a_of_type_Aysa.b(this.jdField_a_of_type_Aysy);
        this.jdField_a_of_type_Aysy = null;
      }
    }
  }
  
  void d()
  {
    super.d();
    jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_Ayqo.jdField_g_of_type_Int = this.jdField_j_of_type_Int;
    if (-5100026 == this.jdField_j_of_type_Int) {
      d(5001);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errCode:" + this.jdField_j_of_type_Int);
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errDesc:" + this.jdField_j_of_type_JavaLangString);
      }
      Object localObject = null;
      if (this.jdField_a_of_type_Aywc != null) {
        localObject = this.jdField_a_of_type_Aywc.jdField_a_of_type_Aywj;
      }
      if (localObject != null)
      {
        ((aywj)localObject).jdField_a_of_type_Int = -1;
        ((aywj)localObject).jdField_a_of_type_Long = this.jdField_j_of_type_Int;
        ((aywj)localObject).jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        ((aywj)localObject).jdField_a_of_type_Aywc = this.jdField_a_of_type_Aywc;
      }
      localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        auna localauna = (auna)((Iterator)localObject).next();
        aunb localaunb = new aunb();
        localaunb.jdField_a_of_type_Int = -1;
        localaunb.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
        localaunb.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        localauna.a(localaunb);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideo.TAG", 2, "onError ");
        }
      }
      if ((-9527 == this.jdField_j_of_type_Int) && ((this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")) || (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103059")))) {
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
    axdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ayqo, this.jdField_a_of_type_Aywc);
  }
  
  void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "successfully downloaded.");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
    d(2003);
    Object localObject = this.jdField_a_of_type_Aywc.jdField_a_of_type_Aywj;
    if (localObject != null)
    {
      ((aywj)localObject).jdField_a_of_type_Int = 0;
      ((aywj)localObject).jdField_a_of_type_Aywc = this.jdField_a_of_type_Aywc;
    }
    localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      auna localauna = (auna)((Iterator)localObject).next();
      aunb localaunb = new aunb();
      localaunb.jdField_a_of_type_Int = 0;
      localaunb.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aywc.h;
      localaunb.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywc.f;
      localaunb.jdField_d_of_type_Int = this.jdField_a_of_type_Aywc.jdField_g_of_type_Int;
      localauna.a(localaunb);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aypd.a();
    ayyp localayyp = new ayyp();
    ayzb localayzb = new ayzb();
    localayzb.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + localayzb.jdField_c_of_type_Int);
    }
    localayzb.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString;
    localayzb.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString;
    localayzb.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_d_of_type_JavaLangString;
    localayzb.f = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
    localayzb.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString;
    localayzb.jdField_d_of_type_Int = 0;
    if (localayzb.f == 0)
    {
      localayzb.jdField_a_of_type_Int = 0;
      if ((localayzb.f != 0) && (1008 != localayzb.f)) {
        break label480;
      }
      localayzb.jdField_b_of_type_JavaLangString = null;
      label164:
      localayzb.jdField_b_of_type_Int = 2;
      localayzb.jdField_a_of_type_JavaLangString = this.f;
      localayzb.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_Aywc.f);
      if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!(this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {
        break label494;
      }
      localayzb.jdField_e_of_type_Int = ((MessageForShortVideo)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;
      label231:
      this.jdField_c_of_type_Int = localayzb.jdField_e_of_type_Int;
      localayzb.jdField_j_of_type_Int = 0;
      if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
      {
        if (!(this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForLightVideo)) {
          break label526;
        }
        localayzb.jdField_j_of_type_Int = 3;
      }
      label285:
      if ((this.jdField_a_of_type_Aywc.jdField_b_of_type_Int != 7) && (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int != 16) && (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int != 18)) {
        break label551;
      }
    }
    label526:
    label551:
    for (localayzb.jdField_g_of_type_Int = 1;; localayzb.jdField_g_of_type_Int = 2) {
      label480:
      label494:
      do
      {
        localayzb.h = this.jdField_a_of_type_Aywc.jdField_g_of_type_Int;
        if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject instanceof Integer))) {
          localayzb.i = ((Integer)this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject).intValue();
        }
        localayyp.jdField_a_of_type_Ayzw = this;
        localayyp.jdField_a_of_type_JavaLangString = "short_video_dw";
        localayyp.jdField_a_of_type_JavaUtilList.add(localayzb);
        localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
        if (e()) {
          break label595;
        }
        a(9366, "illegal app", null, this.jdField_a_of_type_Aypd);
        d();
        return;
        if (1 == localayzb.f)
        {
          localayzb.jdField_a_of_type_Int = 1;
          break;
        }
        if (3000 == localayzb.f)
        {
          localayzb.jdField_a_of_type_Int = 2;
          break;
        }
        localayzb.jdField_a_of_type_Int = 3;
        break;
        localayzb.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString;
        break label164;
        if (1008 == localayzb.f)
        {
          localayzb.jdField_e_of_type_Int = this.jdField_a_of_type_Aywc.jdField_e_of_type_Int;
          break label231;
        }
        localayzb.jdField_e_of_type_Int = 0;
        break label231;
        if (((MessageForShortVideo)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).subBusiType != 1) {
          break label285;
        }
        localayzb.jdField_j_of_type_Int = 1;
        break label285;
      } while ((this.jdField_a_of_type_Aywc.jdField_b_of_type_Int != 6) && (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int != 9) && (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int != 17));
    }
    label595:
    b("requestStart", localayyp.toString());
    if (!f())
    {
      jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Ayyp = localayyp;
    ayzv.a(localayyp);
  }
  
  protected void n()
  {
    String str;
    if ((this.jdField_a_of_type_Aysy != null) && ((this.jdField_a_of_type_Aysy instanceof ayrx)))
    {
      if (!akpx.c(this.jdField_a_of_type_Aywc.jdField_a_of_type_Int)) {
        break label59;
      }
      str = "videoCd";
    }
    for (;;)
    {
      ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype(str, ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString);
      return;
      label59:
      if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Int == 1) {
        str = "videoGd";
      } else if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Int == 3000) {
        str = "videoDd";
      } else {
        str = "videoOd";
      }
    }
  }
  
  /* Error */
  public void onResp(aysz paramaysz)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 854	ayow:onResp	(Laysz;)V
    //   11: new 81	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 856
    //   21: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 857	ayut:jdField_a_of_type_Boolean	Z
    //   28: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: ldc_w 859
    //   34: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: astore 9
    //   39: aload_1
    //   40: getfield 862	aysz:jdField_a_of_type_Int	I
    //   43: ifne +629 -> 672
    //   46: iconst_1
    //   47: istore 4
    //   49: aload_0
    //   50: ldc_w 864
    //   53: aload 9
    //   55: iload 4
    //   57: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 204	ayut:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +90 -> 159
    //   72: ldc 79
    //   74: iconst_2
    //   75: new 81	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 866
    //   85: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_1
    //   89: getfield 862	aysz:jdField_a_of_type_Int	I
    //   92: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: ldc 79
    //   103: iconst_2
    //   104: new 81	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 868
    //   114: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: getfield 869	aysz:jdField_b_of_type_Int	I
    //   121: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: ldc 79
    //   132: iconst_2
    //   133: new 81	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 871
    //   143: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_1
    //   147: getfield 872	aysz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   175: ldc_w 874
    //   178: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: getfield 876	aysz:j	J
    //   185: ldc2_w 877
    //   188: ldiv
    //   189: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   192: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload_0
    //   199: getfield 857	ayut:jdField_a_of_type_Boolean	Z
    //   202: ifeq +476 -> 678
    //   205: aload_0
    //   206: getfield 880	ayut:d	Laypd;
    //   209: astore 9
    //   211: aload_1
    //   212: getfield 862	aysz:jdField_a_of_type_Int	I
    //   215: ifne +472 -> 687
    //   218: iconst_1
    //   219: istore 4
    //   221: aload_0
    //   222: aload 9
    //   224: aload_1
    //   225: iload 4
    //   227: invokevirtual 883	ayut:a	(Laypd;Laysz;Z)V
    //   230: aload_0
    //   231: aload_1
    //   232: getfield 884	aysz:jdField_a_of_type_Long	J
    //   235: putfield 424	ayut:jdField_a_of_type_Long	J
    //   238: aload_0
    //   239: getfield 424	ayut:jdField_a_of_type_Long	J
    //   242: lconst_0
    //   243: lcmp
    //   244: ifgt +19 -> 263
    //   247: aload_0
    //   248: aload_1
    //   249: getfield 886	aysz:jdField_b_of_type_Long	J
    //   252: aload_1
    //   253: getfield 887	aysz:jdField_a_of_type_Aysy	Laysy;
    //   256: getfield 890	aysy:jdField_a_of_type_Long	J
    //   259: ladd
    //   260: putfield 424	ayut:jdField_a_of_type_Long	J
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 891	ayut:jdField_b_of_type_Long	J
    //   268: aload_1
    //   269: getfield 892	aysz:jdField_c_of_type_Long	J
    //   272: ladd
    //   273: putfield 891	ayut:jdField_b_of_type_Long	J
    //   276: aload_0
    //   277: aload_1
    //   278: getfield 894	aysz:g	J
    //   281: putfield 44	ayut:jdField_c_of_type_Long	J
    //   284: aload_0
    //   285: aload_1
    //   286: getfield 895	aysz:jdField_e_of_type_Int	I
    //   289: putfield 46	ayut:p	I
    //   292: aload_1
    //   293: getfield 862	aysz:jdField_a_of_type_Int	I
    //   296: ifne +558 -> 854
    //   299: aload_0
    //   300: getfield 143	ayut:jdField_a_of_type_Aywc	Laywc;
    //   303: getfield 176	aywc:f	Ljava/lang/String;
    //   306: astore 10
    //   308: aload 10
    //   310: invokestatic 901	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifne +724 -> 1037
    //   316: aload_0
    //   317: getfield 143	ayut:jdField_a_of_type_Aywc	Laywc;
    //   320: getfield 106	aywc:h	Ljava/lang/String;
    //   323: astore 9
    //   325: new 903	java/io/FileInputStream
    //   328: dup
    //   329: aload 9
    //   331: invokespecial 904	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   334: astore 9
    //   336: aload 9
    //   338: aload 9
    //   340: invokevirtual 907	java/io/FileInputStream:available	()I
    //   343: i2l
    //   344: invokestatic 911	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   347: astore 11
    //   349: aload 11
    //   351: ifnull +681 -> 1032
    //   354: aload_0
    //   355: aload 11
    //   357: invokestatic 264	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   360: putfield 40	ayut:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   363: aload_0
    //   364: getfield 40	ayut:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   367: aload 10
    //   369: invokevirtual 306	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   372: ifne +660 -> 1032
    //   375: aload_0
    //   376: getfield 143	ayut:jdField_a_of_type_Aywc	Laywc;
    //   379: getfield 110	aywc:jdField_b_of_type_Int	I
    //   382: bipush 6
    //   384: if_icmpeq +27 -> 411
    //   387: aload_0
    //   388: getfield 143	ayut:jdField_a_of_type_Aywc	Laywc;
    //   391: getfield 110	aywc:jdField_b_of_type_Int	I
    //   394: bipush 9
    //   396: if_icmpeq +15 -> 411
    //   399: aload_0
    //   400: getfield 143	ayut:jdField_a_of_type_Aywc	Laywc;
    //   403: getfield 110	aywc:jdField_b_of_type_Int	I
    //   406: bipush 17
    //   408: if_icmpne +624 -> 1032
    //   411: aload_0
    //   412: ldc_w 439
    //   415: ldc_w 913
    //   418: invokevirtual 297	ayut:b	(ILjava/lang/String;)V
    //   421: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +43 -> 467
    //   427: ldc 79
    //   429: iconst_2
    //   430: new 81	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 915
    //   440: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 10
    //   445: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: ldc_w 917
    //   451: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload_0
    //   455: getfield 40	ayut:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   458: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 919	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: iconst_0
    //   468: istore_2
    //   469: iload_2
    //   470: istore_3
    //   471: aload 9
    //   473: ifnull +10 -> 483
    //   476: aload 9
    //   478: invokevirtual 922	java/io/FileInputStream:close	()V
    //   481: iload_2
    //   482: istore_3
    //   483: aload_0
    //   484: getfield 361	ayut:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   487: astore 9
    //   489: iload_3
    //   490: ifeq +334 -> 824
    //   493: iconst_1
    //   494: istore_2
    //   495: aload 9
    //   497: ldc_w 924
    //   500: iload_2
    //   501: invokestatic 341	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   504: invokevirtual 345	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: pop
    //   508: aload_0
    //   509: invokespecial 163	ayut:a	()Z
    //   512: ifeq +104 -> 616
    //   515: new 535	java/io/File
    //   518: dup
    //   519: aload_0
    //   520: getfield 557	ayut:jdField_a_of_type_Aysy	Laysy;
    //   523: getfield 925	aysy:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   526: invokespecial 536	java/io/File:<init>	(Ljava/lang/String;)V
    //   529: astore 9
    //   531: new 535	java/io/File
    //   534: dup
    //   535: aload_0
    //   536: getfield 143	ayut:jdField_a_of_type_Aywc	Laywc;
    //   539: getfield 106	aywc:h	Ljava/lang/String;
    //   542: invokespecial 536	java/io/File:<init>	(Ljava/lang/String;)V
    //   545: astore 10
    //   547: aload 9
    //   549: aload 10
    //   551: invokestatic 930	gp:a	(Ljava/io/File;Ljava/io/File;)Z
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
    //   579: ldc_w 932
    //   582: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload_0
    //   586: getfield 143	ayut:jdField_a_of_type_Aywc	Laywc;
    //   589: getfield 106	aywc:h	Ljava/lang/String;
    //   592: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: ldc_w 934
    //   598: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: iload 4
    //   603: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   606: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 919	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: iload 4
    //   614: istore 5
    //   616: iload 5
    //   618: ifne +7 -> 625
    //   621: aload_0
    //   622: invokevirtual 935	ayut:e	()V
    //   625: aload_0
    //   626: aload_1
    //   627: iconst_1
    //   628: ldc 175
    //   630: aload_0
    //   631: getfield 143	ayut:jdField_a_of_type_Aywc	Laywc;
    //   634: getfield 176	aywc:f	Ljava/lang/String;
    //   637: aload_0
    //   638: getfield 108	ayut:f	Ljava/lang/String;
    //   641: new 81	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   648: aload_0
    //   649: getfield 42	ayut:jdField_c_of_type_Int	I
    //   652: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   655: ldc 38
    //   657: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokevirtual 179	ayut:a	(Laysz;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   666: aload_0
    //   667: aconst_null
    //   668: putfield 557	ayut:jdField_a_of_type_Aysy	Laysy;
    //   671: return
    //   672: iconst_0
    //   673: istore 4
    //   675: goto -626 -> 49
    //   678: aload_0
    //   679: getfield 390	ayut:jdField_b_of_type_Aypd	Laypd;
    //   682: astore 9
    //   684: goto -473 -> 211
    //   687: iconst_0
    //   688: istore 4
    //   690: goto -469 -> 221
    //   693: astore 9
    //   695: iload_2
    //   696: istore_3
    //   697: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   700: ifeq -217 -> 483
    //   703: ldc 79
    //   705: iconst_2
    //   706: ldc_w 937
    //   709: aload 9
    //   711: invokestatic 940	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   714: iload_2
    //   715: istore_3
    //   716: goto -233 -> 483
    //   719: astore 10
    //   721: aconst_null
    //   722: astore 9
    //   724: iconst_1
    //   725: istore_2
    //   726: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   729: ifeq +14 -> 743
    //   732: ldc 79
    //   734: iconst_2
    //   735: ldc_w 937
    //   738: aload 10
    //   740: invokestatic 940	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   743: iload_2
    //   744: istore_3
    //   745: aload 9
    //   747: ifnull -264 -> 483
    //   750: aload 9
    //   752: invokevirtual 922	java/io/FileInputStream:close	()V
    //   755: iload_2
    //   756: istore_3
    //   757: goto -274 -> 483
    //   760: astore 9
    //   762: iload_2
    //   763: istore_3
    //   764: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   767: ifeq -284 -> 483
    //   770: ldc 79
    //   772: iconst_2
    //   773: ldc_w 937
    //   776: aload 9
    //   778: invokestatic 940	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   781: iload_2
    //   782: istore_3
    //   783: goto -300 -> 483
    //   786: astore_1
    //   787: aconst_null
    //   788: astore 9
    //   790: aload 9
    //   792: ifnull +8 -> 800
    //   795: aload 9
    //   797: invokevirtual 922	java/io/FileInputStream:close	()V
    //   800: aload_1
    //   801: athrow
    //   802: astore 9
    //   804: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   807: ifeq -7 -> 800
    //   810: ldc 79
    //   812: iconst_2
    //   813: ldc_w 937
    //   816: aload 9
    //   818: invokestatic 940	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   821: goto -21 -> 800
    //   824: iconst_0
    //   825: istore_2
    //   826: goto -331 -> 495
    //   829: astore 9
    //   831: aload_0
    //   832: sipush -30000
    //   835: ldc_w 941
    //   838: invokestatic 316	ajya:a	(I)Ljava/lang/String;
    //   841: invokevirtual 297	ayut:b	(ILjava/lang/String;)V
    //   844: aload_0
    //   845: invokevirtual 299	ayut:d	()V
    //   848: iconst_1
    //   849: istore 4
    //   851: goto -292 -> 559
    //   854: aload_0
    //   855: getfield 857	ayut:jdField_a_of_type_Boolean	Z
    //   858: ifeq +10 -> 868
    //   861: aload_0
    //   862: invokevirtual 637	ayut:f	()V
    //   865: goto -199 -> 666
    //   868: aload_1
    //   869: getfield 942	aysz:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   872: ldc_w 944
    //   875: invokevirtual 946	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   878: ifnonnull +71 -> 949
    //   881: ldc2_w 947
    //   884: lstore 7
    //   886: aload_0
    //   887: getfield 361	ayut:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   890: ldc_w 950
    //   893: lload 7
    //   895: invokestatic 413	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   898: invokevirtual 345	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   901: pop
    //   902: aload_1
    //   903: getfield 869	aysz:jdField_b_of_type_Int	I
    //   906: sipush 9364
    //   909: if_icmpne +61 -> 970
    //   912: aload_0
    //   913: getfield 952	ayut:jdField_l_of_type_Int	I
    //   916: iconst_3
    //   917: if_icmpge +53 -> 970
    //   920: aload_0
    //   921: ldc_w 954
    //   924: ldc_w 956
    //   927: invokevirtual 204	ayut:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   930: aload_0
    //   931: aload_0
    //   932: getfield 952	ayut:jdField_l_of_type_Int	I
    //   935: iconst_1
    //   936: iadd
    //   937: putfield 952	ayut:jdField_l_of_type_Int	I
    //   940: aload_0
    //   941: invokevirtual 958	ayut:m	()V
    //   944: aload_0
    //   945: invokevirtual 637	ayut:f	()V
    //   948: return
    //   949: aload_1
    //   950: getfield 942	aysz:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   953: ldc_w 944
    //   956: invokevirtual 946	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   959: checkcast 67	java/lang/String
    //   962: invokestatic 964	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   965: lstore 7
    //   967: goto -81 -> 886
    //   970: aload_1
    //   971: getfield 942	aysz:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   974: getstatic 967	bbmu:f	Ljava/lang/String;
    //   977: invokevirtual 946	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   980: checkcast 67	java/lang/String
    //   983: astore 9
    //   985: aload_0
    //   986: aload_1
    //   987: getfield 869	aysz:jdField_b_of_type_Int	I
    //   990: aload_1
    //   991: getfield 872	aysz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   994: aload 9
    //   996: aload_0
    //   997: getfield 390	ayut:jdField_b_of_type_Aypd	Laypd;
    //   1000: invokevirtual 821	ayut:a	(ILjava/lang/String;Ljava/lang/String;Laypd;)V
    //   1003: aload_0
    //   1004: invokevirtual 299	ayut:d	()V
    //   1007: goto -341 -> 666
    //   1010: astore_1
    //   1011: goto -221 -> 790
    //   1014: astore_1
    //   1015: goto -225 -> 790
    //   1018: astore 10
    //   1020: iconst_1
    //   1021: istore_2
    //   1022: goto -296 -> 726
    //   1025: astore 10
    //   1027: iconst_0
    //   1028: istore_2
    //   1029: goto -303 -> 726
    //   1032: iconst_1
    //   1033: istore_2
    //   1034: goto -565 -> 469
    //   1037: iconst_1
    //   1038: istore_3
    //   1039: goto -556 -> 483
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1042	0	this	ayut
    //   0	1042	1	paramaysz	aysz
    //   468	566	2	i	int
    //   470	569	3	j	int
    //   47	803	4	bool1	boolean
    //   1	616	5	k	int
    //   4	552	6	bool2	boolean
    //   884	82	7	l1	long
    //   37	646	9	localObject1	Object
    //   693	17	9	localIOException1	java.io.IOException
    //   722	29	9	localObject2	Object
    //   760	17	9	localIOException2	java.io.IOException
    //   788	8	9	localObject3	Object
    //   802	15	9	localIOException3	java.io.IOException
    //   829	1	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   983	12	9	str	String
    //   306	244	10	localObject4	Object
    //   719	20	10	localIOException4	java.io.IOException
    //   1018	1	10	localIOException5	java.io.IOException
    //   1025	1	10	localIOException6	java.io.IOException
    //   347	9	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   476	481	693	java/io/IOException
    //   325	336	719	java/io/IOException
    //   750	755	760	java/io/IOException
    //   325	336	786	finally
    //   795	800	802	java/io/IOException
    //   547	555	829	java/lang/OutOfMemoryError
    //   336	349	1010	finally
    //   354	411	1010	finally
    //   411	421	1010	finally
    //   421	467	1010	finally
    //   726	743	1014	finally
    //   336	349	1018	java/io/IOException
    //   354	411	1018	java/io/IOException
    //   411	421	1018	java/io/IOException
    //   421	467	1025	java/io/IOException
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    if (this.jdField_k_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoDownloadProcessor", 2, "onUpdateProgeress: mIsPause=true, should not notify UI, just return!");
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Ayqo.e = paramLong1;
      this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long = paramLong2;
      d(2002);
      int i = (int)(10000L * paramLong1 / paramLong2);
      paramaysy = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (paramaysy.hasNext()) {
        ((auna)paramaysy.next()).a(i, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayut
 * JD-Core Version:    0.7.0.1
 */