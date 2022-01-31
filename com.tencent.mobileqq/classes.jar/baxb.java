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
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class baxb
  extends bara
  implements bauh
{
  static HashSet<String> a;
  private bauf b;
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
  
  public baxb(bayf parambayf, bayk parambayk)
  {
    super(parambayf, parambayk);
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_b_of_type_Bauf = new baxc(this);
    parambayf = parambayk.i;
    if (parambayf != null)
    {
      String[] arrayOfString = parambayf.split("QQ_&_MoblieQQ_&_QQ");
      if (arrayOfString.length < 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "path was not set correctlly------path = " + parambayf);
        }
        throw new IllegalArgumentException("path was not set correctlly.");
      }
      parambayk.h = arrayOfString[0];
      this.f = arrayOfString[1];
      this.jdField_e_of_type_JavaLangString = (this.f + parambayk.jdField_b_of_type_Int + parambayk.jdField_a_of_type_Long);
      this.q = Integer.parseInt(arrayOfString[2]);
      if (arrayOfString.length > 3) {
        this.r = Integer.parseInt(arrayOfString[3]);
      }
    }
  }
  
  private boolean a()
  {
    if ((akcs.a.get()) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
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
  
  public void a(bavf parambavf)
  {
    this.jdField_a_of_type_Bawi.jdField_l_of_type_JavaLangString = (this.jdField_c_of_type_Int + "");
    this.jdField_a_of_type_Bawi.jdField_b_of_type_Long = this.jdField_a_of_type_Bass.jdField_a_of_type_Long;
    a(parambavf, false, "actRichMediaNetMonitor_videoDown", this.f);
  }
  
  public void a(bbax parambbax, bbbm parambbbm)
  {
    this.jdField_a_of_type_Bbax = null;
    if (parambbbm != null)
    {
      int i = 0;
      if (i < parambbbm.jdField_a_of_type_JavaUtilList.size())
      {
        bbca localbbca = (bbca)parambbbm.jdField_a_of_type_JavaUtilList.get(i);
        b("procUrl", localbbca.toString());
        a(this.jdField_a_of_type_Barh, localbbca);
        this.jdField_a_of_type_JavaUtilArrayList = a(localbbca.jdField_b_of_type_JavaUtilArrayList, localbbca.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaLangString = localbbca.jdField_b_of_type_JavaLangString;
        if (this.jdField_j_of_type_Boolean)
        {
          this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
          if (this.jdField_a_of_type_JavaUtilArrayList != null) {
            this.jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
        if (localbbca.jdField_c_of_type_Int == 0)
        {
          if (QLog.isColorLevel()) {
            if ("onBusiProtoResp() cdn ---- mIpListSize:" + this.jdField_a_of_type_JavaUtilArrayList != null) {
              break label262;
            }
          }
          label262:
          for (parambbax = Integer.valueOf(0);; parambbax = this.jdField_a_of_type_JavaUtilArrayList.size() + " mHostType:" + localbbca.jdField_a_of_type_Int + " domain:" + localbbca.jdField_b_of_type_JavaLangString + " url:" + localbbca.jdField_c_of_type_JavaLangString)
          {
            QLog.d("ShortVideoDownloadProcessor", 2, new Object[] { parambbax });
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- mUiRequest.mMd5:" + this.jdField_a_of_type_Bayk.f);
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp() cdn ---- downResp.md5:" + HexUtil.bytes2HexStr(localbbca.jdField_a_of_type_ArrayOfByte));
            this.jdField_c_of_type_JavaLangString = localbbca.jdField_c_of_type_JavaLangString;
            a(localbbca.jdField_b_of_type_ArrayOfByte);
            i += 1;
            break;
          }
        }
        if ((!localbbca.e) && (this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
        {
          ((MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isAllowAutoDown = false;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()-- server return not allow auto retry");
          }
        }
        if (-5100026 != this.jdField_j_of_type_Int) {
          break label474;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_Bayk.f);
        }
        b(-5100026, "安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_Bayk.f);
      }
    }
    for (;;)
    {
      d();
      return;
      label474:
      if ((-9527 == this.jdField_j_of_type_Int) && ((this.jdField_j_of_type_JavaLangString.equals("H_400_-5103017")) || (this.jdField_j_of_type_JavaLangString.equals("H_400_-5103059"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + this.jdField_j_of_type_Int);
        }
        b(this.jdField_j_of_type_Int, alud.a(2131714464));
      }
      else if (-5100528 == this.jdField_j_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 后台不允许自动下载, errCode = " + this.jdField_j_of_type_Int);
        }
        b(-5100528, alud.a(2131714469));
      }
      else
      {
        b(9045, alud.a(2131714471));
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bayk.jdField_g_of_type_Boolean) {}
    while (((!paramBoolean) && (bawk.b(this.jdField_j_of_type_Int))) || (this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
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
        new HashMap().put("businessType", String.valueOf(this.jdField_a_of_type_Bayk.jdField_b_of_type_Int));
        azri.a(BaseApplication.getContext()).a(null, "actShortVideoRedirect", true, this.jdField_c_of_type_Long, this.p, this.jdField_a_of_type_JavaUtilHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "mRedirectReportInfo = " + this.p + " " + this.jdField_c_of_type_Long + " " + this.jdField_a_of_type_Bayk.jdField_b_of_type_Int);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "reportTag = " + b());
      }
      l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      String str = this.jdField_a_of_type_Barh.a(1) + ";" + this.jdField_b_of_type_Barh.a(2) + ";" + this.jdField_c_of_type_Barh.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.f);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Bass.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", this.jdField_a_of_type_Bayk.f);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.jdField_c_of_type_Int + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.r));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_Bayk.jdField_g_of_type_Int));
      if (!paramBoolean) {
        break label539;
      }
      b(true, l1);
      azri.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
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
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", "uierquest md5=" + this.jdField_a_of_type_Bayk.f + "fileMd5=" + this.jdField_l_of_type_JavaLangString);
      }
      b(false, l1);
      azri.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
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
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = "grouptalk.c2c.qq.com";
      }
      this.jdField_b_of_type_Barh.a();
      str = c();
      localObject1 = new baub();
      if (!bdnn.a(this.jdField_b_of_type_JavaLangString)) {
        ((baub)localObject1).jdField_a_of_type_JavaUtilHashMap.put("host", this.jdField_b_of_type_JavaLangString);
      }
      ((baub)localObject1).jdField_a_of_type_Baug = this;
      ((baub)localObject1).jdField_a_of_type_Bauh = this;
      ((baub)localObject1).jdField_a_of_type_JavaLangString = str;
      ((baub)localObject1).jdField_a_of_type_Int = 0;
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaLangString);
      ((baub)localObject1).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      ((baub)localObject1).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bayk.h;
      ((baub)localObject1).jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
      ((baub)localObject1).jdField_g_of_type_Int = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
      ((baub)localObject1).f = this.jdField_a_of_type_Bayk.jdField_b_of_type_Int;
      if ((this.jdField_a_of_type_Bayk.jdField_b_of_type_Int == 6) || (this.jdField_a_of_type_Bayk.jdField_b_of_type_Int == 9) || (this.jdField_a_of_type_Bayk.jdField_b_of_type_Int == 17))
      {
        localObject2 = bdne.f(BaseApplication.getContext());
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localObject2 = ((String)localObject2).split("\\|");
          if ((localObject2 != null) && (localObject2.length > 0)) {
            ((baub)localObject1).jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject2);
          }
        }
      }
      if (paramArrayOfByte != null) {
        ((baub)localObject1).jdField_a_of_type_Bauc = new bauc(paramArrayOfByte);
      }
      ((baub)localObject1).jdField_a_of_type_Long = 0L;
      ((baub)localObject1).jdField_k_of_type_Boolean = true;
      ((baub)localObject1).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      ((baub)localObject1).jdField_a_of_type_Bauf = this.jdField_b_of_type_Bauf;
      ((baub)localObject1).jdField_d_of_type_JavaLangString = (this.jdField_a_of_type_Bayk.h + "." + MD5.toMD5(this.f) + ".tmp");
      if (a())
      {
        paramArrayOfByte = (MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        ((baub)localObject1).i = true;
        ((baub)localObject1).jdField_j_of_type_Boolean = false;
        if (new File(((baub)localObject1).jdField_d_of_type_JavaLangString).exists()) {
          ((baub)localObject1).jdField_a_of_type_Long = paramArrayOfByte.transferedSize;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mUseRaf =>>>");
        }
      }
      b("httpDown", "url:" + str + ",downOffset:" + ((baub)localObject1).jdField_a_of_type_Long);
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
    this.jdField_a_of_type_Bave = ((bave)localObject1);
    n();
    ((baub)localObject1).jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "recieveFile mIsOnlyGetUrl " + this.jdField_a_of_type_Bayk.jdField_g_of_type_Boolean + " domain=" + this.jdField_b_of_type_JavaLangString + " ipsize=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    if (this.jdField_a_of_type_Bayk.jdField_g_of_type_Boolean)
    {
      paramArrayOfByte = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (bawy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("http://");
        ((StringBuffer)localObject2).append(((bawy)localObject1).jdField_a_of_type_JavaLangString);
        if (((bawy)localObject1).jdField_a_of_type_Int != 80)
        {
          ((StringBuffer)localObject2).append(":");
          ((StringBuffer)localObject2).append(((bawy)localObject1).jdField_a_of_type_Int);
        }
        ((StringBuffer)localObject2).append("/");
        paramArrayOfByte[i] = baws.a(str, ((StringBuffer)localObject2).toString());
        i += 1;
      }
      this.jdField_a_of_type_Bass.c = paramArrayOfByte;
      this.jdField_a_of_type_Bass.u = this.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Bass.f = this.jdField_a_of_type_Barh.a();
      d(2002);
      this.jdField_a_of_type_Bard.a(a());
      jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Baue.a((bave)localObject1);
  }
  
  public void aP_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "start()----runningTasks.contains(mTaskKey) = " + jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_e_of_type_JavaLangString));
    }
    if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      b("start", "[tvk] videoFileSize = " + localMessageForShortVideo.videoFileSize);
    }
    if ((this.jdField_a_of_type_Bayk.jdField_g_of_type_Int == 2) && (this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) && (!((MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isAllowAutoDown) && ((this.jdField_a_of_type_Bayk.jdField_b_of_type_Int == 6) || (this.jdField_a_of_type_Bayk.jdField_b_of_type_Int == 9) || (this.jdField_a_of_type_Bayk.jdField_b_of_type_Int == 17)))
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
      this.jdField_a_of_type_Bard.a.post(new ShortVideoDownloadProcessor.1(this));
    }
    return 0;
  }
  
  protected String b()
  {
    String str = "actShortVideoDownloadVideo";
    if (this.jdField_a_of_type_Bayk.jdField_b_of_type_Int == 7) {
      str = "actShortVideoDownloadThumb";
    }
    do
    {
      return str;
      if (this.jdField_a_of_type_Bayk.jdField_b_of_type_Int == 6) {
        return "actShortVideoDownloadVideo";
      }
      if ((this.jdField_a_of_type_Bayk.jdField_b_of_type_Int == 16) || (this.jdField_a_of_type_Bayk.jdField_b_of_type_Int == 18))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString);
        return "actShortVideoDiscussgroupDownloadThumb";
      }
    } while ((this.jdField_a_of_type_Bayk.jdField_b_of_type_Int != 9) && (this.jdField_a_of_type_Bayk.jdField_b_of_type_Int != 17));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString);
    return "actShortVideoDiscussgroupDownloadVideo";
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Bayk == null) || (this.jdField_a_of_type_Bayk.h == null))
    {
      b(9302, alud.a(2131714441));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Bayk != null) && (this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0)) {
      this.n = true;
    }
    return 0;
  }
  
  protected String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    bawy localbawy;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localbawy = (bawy)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localStringBuilder.append("http://");
      if ((localbawy.jdField_a_of_type_Boolean) && (!localbawy.jdField_a_of_type_JavaLangString.startsWith("[")))
      {
        localStringBuilder.append("[" + localbawy.jdField_a_of_type_JavaLangString + "]");
        if ((localbawy.jdField_a_of_type_Int != 80) && (localbawy.jdField_a_of_type_Int != 0))
        {
          localStringBuilder.append(":");
          localStringBuilder.append(localbawy.jdField_a_of_type_Int);
        }
        localStringBuilder.append("/");
      }
    }
    for (;;)
    {
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      b("getConnUrl", "cdn url = " + localStringBuilder.toString());
      return localStringBuilder.toString();
      localStringBuilder.append(localbawy.jdField_a_of_type_JavaLangString);
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
      if (this.jdField_a_of_type_Bbax != null)
      {
        bbcd.b(this.jdField_a_of_type_Bbax);
        this.jdField_a_of_type_Bbax = null;
      }
      if (this.jdField_a_of_type_Bave != null)
      {
        this.jdField_a_of_type_Baue.b(this.jdField_a_of_type_Bave);
        this.jdField_a_of_type_Bave = null;
      }
    }
  }
  
  void d()
  {
    super.d();
    jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_Bass.jdField_g_of_type_Int = this.jdField_j_of_type_Int;
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
      if (this.jdField_a_of_type_Bayk != null) {
        localObject = this.jdField_a_of_type_Bayk.jdField_a_of_type_Bayr;
      }
      if (localObject != null)
      {
        ((bayr)localObject).jdField_a_of_type_Int = -1;
        ((bayr)localObject).jdField_a_of_type_Long = this.jdField_j_of_type_Int;
        ((bayr)localObject).jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        ((bayr)localObject).jdField_a_of_type_Bayk = this.jdField_a_of_type_Bayk;
      }
      localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        awiq localawiq = (awiq)((Iterator)localObject).next();
        awir localawir = new awir();
        localawir.jdField_a_of_type_Int = -1;
        localawir.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
        localawir.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        localawiq.a(localawir);
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
    azdd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bass, this.jdField_a_of_type_Bayk);
  }
  
  void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "successfully downloaded.");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
    d(2003);
    Object localObject = this.jdField_a_of_type_Bayk.jdField_a_of_type_Bayr;
    if (localObject != null)
    {
      ((bayr)localObject).jdField_a_of_type_Int = 0;
      ((bayr)localObject).jdField_a_of_type_Bayk = this.jdField_a_of_type_Bayk;
    }
    localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      awiq localawiq = (awiq)((Iterator)localObject).next();
      awir localawir = new awir();
      localawir.jdField_a_of_type_Int = 0;
      localawir.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bayk.h;
      localawir.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bayk.f;
      localawir.jdField_d_of_type_Int = this.jdField_a_of_type_Bayk.jdField_g_of_type_Int;
      localawiq.a(localawir);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Barh.a();
    bbax localbbax = new bbax();
    bbbj localbbbj = new bbbj();
    localbbbj.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + localbbbj.jdField_c_of_type_Int);
    }
    localbbbj.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString;
    localbbbj.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
    localbbbj.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_d_of_type_JavaLangString;
    localbbbj.f = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
    localbbbj.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
    localbbbj.jdField_d_of_type_Int = 0;
    if (localbbbj.f == 0)
    {
      localbbbj.jdField_a_of_type_Int = 0;
      if ((localbbbj.f != 0) && (1008 != localbbbj.f)) {
        break label480;
      }
      localbbbj.jdField_b_of_type_JavaLangString = null;
      label164:
      localbbbj.jdField_b_of_type_Int = 2;
      localbbbj.jdField_a_of_type_JavaLangString = this.f;
      localbbbj.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_Bayk.f);
      if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {
        break label494;
      }
      localbbbj.jdField_e_of_type_Int = ((MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;
      label231:
      this.jdField_c_of_type_Int = localbbbj.jdField_e_of_type_Int;
      localbbbj.jdField_j_of_type_Int = 0;
      if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
      {
        if (!(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForLightVideo)) {
          break label526;
        }
        localbbbj.jdField_j_of_type_Int = 3;
      }
      label285:
      if ((this.jdField_a_of_type_Bayk.jdField_b_of_type_Int != 7) && (this.jdField_a_of_type_Bayk.jdField_b_of_type_Int != 16) && (this.jdField_a_of_type_Bayk.jdField_b_of_type_Int != 18)) {
        break label551;
      }
    }
    label526:
    label551:
    for (localbbbj.jdField_g_of_type_Int = 1;; localbbbj.jdField_g_of_type_Int = 2) {
      label480:
      label494:
      do
      {
        localbbbj.h = this.jdField_a_of_type_Bayk.jdField_g_of_type_Int;
        if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject instanceof Integer))) {
          localbbbj.i = ((Integer)this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject).intValue();
        }
        localbbax.jdField_a_of_type_Bbce = this;
        localbbax.jdField_a_of_type_JavaLangString = "short_video_dw";
        localbbax.jdField_a_of_type_JavaUtilList.add(localbbbj);
        localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
        if (e()) {
          break label595;
        }
        a(9366, "illegal app", null, this.jdField_a_of_type_Barh);
        d();
        return;
        if (1 == localbbbj.f)
        {
          localbbbj.jdField_a_of_type_Int = 1;
          break;
        }
        if (3000 == localbbbj.f)
        {
          localbbbj.jdField_a_of_type_Int = 2;
          break;
        }
        localbbbj.jdField_a_of_type_Int = 3;
        break;
        localbbbj.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
        break label164;
        if (1008 == localbbbj.f)
        {
          localbbbj.jdField_e_of_type_Int = this.jdField_a_of_type_Bayk.jdField_e_of_type_Int;
          break label231;
        }
        localbbbj.jdField_e_of_type_Int = 0;
        break label231;
        if (((MessageForShortVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).subBusiType != 1) {
          break label285;
        }
        localbbbj.jdField_j_of_type_Int = 1;
        break label285;
      } while ((this.jdField_a_of_type_Bayk.jdField_b_of_type_Int != 6) && (this.jdField_a_of_type_Bayk.jdField_b_of_type_Int != 9) && (this.jdField_a_of_type_Bayk.jdField_b_of_type_Int != 17));
    }
    label595:
    b("requestStart", localbbax.toString());
    if (!f())
    {
      jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_e_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Bbax = localbbax;
    bbcd.a(localbbax);
  }
  
  protected void n()
  {
    String str;
    if ((this.jdField_a_of_type_Bave != null) && ((this.jdField_a_of_type_Bave instanceof baub)))
    {
      if (!abti.d(this.jdField_a_of_type_Bayk.jdField_a_of_type_Int)) {
        break label59;
      }
      str = "videoCd";
    }
    for (;;)
    {
      ((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype(str, ((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString);
      return;
      label59:
      if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int == 1) {
        str = "videoGd";
      } else if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int == 3000) {
        str = "videoDd";
      } else {
        str = "videoOd";
      }
    }
  }
  
  /* Error */
  public void onResp(bavf parambavf)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 862	bara:onResp	(Lbavf;)V
    //   11: new 81	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 864
    //   21: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 865	baxb:jdField_a_of_type_Boolean	Z
    //   28: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: ldc_w 867
    //   34: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: astore 9
    //   39: aload_1
    //   40: getfield 870	bavf:jdField_a_of_type_Int	I
    //   43: ifne +643 -> 686
    //   46: iconst_1
    //   47: istore 4
    //   49: aload_0
    //   50: ldc_w 872
    //   53: aload 9
    //   55: iload 4
    //   57: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 217	baxb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +90 -> 159
    //   72: ldc 79
    //   74: iconst_2
    //   75: new 81	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 874
    //   85: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_1
    //   89: getfield 870	bavf:jdField_a_of_type_Int	I
    //   92: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: ldc 79
    //   103: iconst_2
    //   104: new 81	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 876
    //   114: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: getfield 877	bavf:jdField_b_of_type_Int	I
    //   121: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: ldc 79
    //   132: iconst_2
    //   133: new 81	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 879
    //   143: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_1
    //   147: getfield 880	bavf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   175: ldc_w 882
    //   178: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: getfield 884	bavf:j	J
    //   185: ldc2_w 885
    //   188: ldiv
    //   189: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   192: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload_0
    //   199: getfield 865	baxb:jdField_a_of_type_Boolean	Z
    //   202: ifeq +490 -> 692
    //   205: aload_0
    //   206: getfield 888	baxb:d	Lbarh;
    //   209: astore 9
    //   211: aload_1
    //   212: getfield 870	bavf:jdField_a_of_type_Int	I
    //   215: ifne +486 -> 701
    //   218: iconst_1
    //   219: istore 4
    //   221: aload_0
    //   222: aload 9
    //   224: aload_1
    //   225: iload 4
    //   227: invokevirtual 891	baxb:a	(Lbarh;Lbavf;Z)V
    //   230: aload_0
    //   231: aload_1
    //   232: getfield 892	bavf:jdField_a_of_type_Long	J
    //   235: putfield 430	baxb:jdField_a_of_type_Long	J
    //   238: aload_0
    //   239: getfield 430	baxb:jdField_a_of_type_Long	J
    //   242: lconst_0
    //   243: lcmp
    //   244: ifgt +19 -> 263
    //   247: aload_0
    //   248: aload_1
    //   249: getfield 893	bavf:jdField_b_of_type_Long	J
    //   252: aload_1
    //   253: getfield 894	bavf:jdField_a_of_type_Bave	Lbave;
    //   256: getfield 897	bave:jdField_a_of_type_Long	J
    //   259: ladd
    //   260: putfield 430	baxb:jdField_a_of_type_Long	J
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 898	baxb:jdField_b_of_type_Long	J
    //   268: aload_1
    //   269: getfield 899	bavf:jdField_c_of_type_Long	J
    //   272: ladd
    //   273: putfield 898	baxb:jdField_b_of_type_Long	J
    //   276: aload_0
    //   277: aload_1
    //   278: getfield 901	bavf:g	J
    //   281: putfield 44	baxb:jdField_c_of_type_Long	J
    //   284: aload_0
    //   285: aload_1
    //   286: getfield 902	bavf:jdField_e_of_type_Int	I
    //   289: putfield 46	baxb:p	I
    //   292: aload_1
    //   293: getfield 870	bavf:jdField_a_of_type_Int	I
    //   296: ifne +572 -> 868
    //   299: aload_0
    //   300: getfield 143	baxb:jdField_a_of_type_Bayk	Lbayk;
    //   303: getfield 260	bayk:f	Ljava/lang/String;
    //   306: astore 10
    //   308: aload 10
    //   310: invokestatic 458	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifne +738 -> 1051
    //   316: aload_0
    //   317: getfield 143	baxb:jdField_a_of_type_Bayk	Lbayk;
    //   320: getfield 106	bayk:h	Ljava/lang/String;
    //   323: astore 9
    //   325: new 904	java/io/FileInputStream
    //   328: dup
    //   329: aload 9
    //   331: invokespecial 905	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   334: astore 9
    //   336: aload 9
    //   338: aload 9
    //   340: invokevirtual 908	java/io/FileInputStream:available	()I
    //   343: i2l
    //   344: invokestatic 912	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   347: astore 11
    //   349: aload 11
    //   351: ifnull +695 -> 1046
    //   354: aload_0
    //   355: aload 11
    //   357: invokestatic 271	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   360: putfield 40	baxb:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   363: aload_0
    //   364: getfield 40	baxb:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   367: aload 10
    //   369: invokevirtual 314	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   372: ifne +674 -> 1046
    //   375: aload_0
    //   376: getfield 143	baxb:jdField_a_of_type_Bayk	Lbayk;
    //   379: getfield 110	bayk:jdField_b_of_type_Int	I
    //   382: bipush 6
    //   384: if_icmpeq +27 -> 411
    //   387: aload_0
    //   388: getfield 143	baxb:jdField_a_of_type_Bayk	Lbayk;
    //   391: getfield 110	bayk:jdField_b_of_type_Int	I
    //   394: bipush 9
    //   396: if_icmpeq +15 -> 411
    //   399: aload_0
    //   400: getfield 143	baxb:jdField_a_of_type_Bayk	Lbayk;
    //   403: getfield 110	bayk:jdField_b_of_type_Int	I
    //   406: bipush 17
    //   408: if_icmpne +638 -> 1046
    //   411: aload_0
    //   412: ldc_w 442
    //   415: ldc_w 914
    //   418: invokevirtual 305	baxb:b	(ILjava/lang/String;)V
    //   421: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +43 -> 467
    //   427: ldc 79
    //   429: iconst_2
    //   430: new 81	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 916
    //   440: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 10
    //   445: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: ldc_w 918
    //   451: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload_0
    //   455: getfield 40	baxb:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   458: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 920	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: iconst_0
    //   468: istore_2
    //   469: iload_2
    //   470: istore_3
    //   471: aload 9
    //   473: ifnull +10 -> 483
    //   476: aload 9
    //   478: invokevirtual 923	java/io/FileInputStream:close	()V
    //   481: iload_2
    //   482: istore_3
    //   483: aload_0
    //   484: getfield 370	baxb:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   487: astore 9
    //   489: iload_3
    //   490: ifeq +348 -> 838
    //   493: iconst_1
    //   494: istore_2
    //   495: aload 9
    //   497: ldc_w 925
    //   500: iload_2
    //   501: invokestatic 350	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   504: invokevirtual 354	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: pop
    //   508: aload_0
    //   509: invokespecial 163	baxb:a	()Z
    //   512: ifeq +104 -> 616
    //   515: new 538	java/io/File
    //   518: dup
    //   519: aload_0
    //   520: getfield 560	baxb:jdField_a_of_type_Bave	Lbave;
    //   523: getfield 926	bave:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   526: invokespecial 539	java/io/File:<init>	(Ljava/lang/String;)V
    //   529: astore 9
    //   531: new 538	java/io/File
    //   534: dup
    //   535: aload_0
    //   536: getfield 143	baxb:jdField_a_of_type_Bayk	Lbayk;
    //   539: getfield 106	bayk:h	Ljava/lang/String;
    //   542: invokespecial 539	java/io/File:<init>	(Ljava/lang/String;)V
    //   545: astore 10
    //   547: aload 9
    //   549: aload 10
    //   551: invokestatic 931	ey:a	(Ljava/io/File;Ljava/io/File;)Z
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
    //   579: ldc_w 933
    //   582: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload_0
    //   586: getfield 143	baxb:jdField_a_of_type_Bayk	Lbayk;
    //   589: getfield 106	bayk:h	Ljava/lang/String;
    //   592: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: ldc_w 935
    //   598: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: iload 4
    //   603: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   606: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 920	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: iload 4
    //   614: istore 5
    //   616: iload 5
    //   618: ifne +7 -> 625
    //   621: aload_0
    //   622: invokevirtual 936	baxb:e	()V
    //   625: aload_0
    //   626: getfield 176	baxb:jdField_a_of_type_Bawi	Lbawi;
    //   629: new 81	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   636: aload_0
    //   637: getfield 42	baxb:jdField_c_of_type_Int	I
    //   640: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   643: ldc 38
    //   645: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: putfield 179	bawi:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   654: aload_0
    //   655: getfield 176	baxb:jdField_a_of_type_Bawi	Lbawi;
    //   658: aload_0
    //   659: getfield 182	baxb:jdField_a_of_type_Bass	Lbass;
    //   662: getfield 185	bass:jdField_a_of_type_Long	J
    //   665: putfield 187	bawi:jdField_b_of_type_Long	J
    //   668: aload_0
    //   669: aload_1
    //   670: iconst_1
    //   671: ldc 189
    //   673: aload_0
    //   674: getfield 108	baxb:f	Ljava/lang/String;
    //   677: invokevirtual 192	baxb:a	(Lbavf;ZLjava/lang/String;Ljava/lang/String;)V
    //   680: aload_0
    //   681: aconst_null
    //   682: putfield 560	baxb:jdField_a_of_type_Bave	Lbave;
    //   685: return
    //   686: iconst_0
    //   687: istore 4
    //   689: goto -640 -> 49
    //   692: aload_0
    //   693: getfield 399	baxb:jdField_b_of_type_Barh	Lbarh;
    //   696: astore 9
    //   698: goto -487 -> 211
    //   701: iconst_0
    //   702: istore 4
    //   704: goto -483 -> 221
    //   707: astore 9
    //   709: iload_2
    //   710: istore_3
    //   711: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   714: ifeq -231 -> 483
    //   717: ldc 79
    //   719: iconst_2
    //   720: ldc_w 938
    //   723: aload 9
    //   725: invokestatic 941	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   728: iload_2
    //   729: istore_3
    //   730: goto -247 -> 483
    //   733: astore 10
    //   735: aconst_null
    //   736: astore 9
    //   738: iconst_1
    //   739: istore_2
    //   740: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   743: ifeq +14 -> 757
    //   746: ldc 79
    //   748: iconst_2
    //   749: ldc_w 938
    //   752: aload 10
    //   754: invokestatic 941	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   757: iload_2
    //   758: istore_3
    //   759: aload 9
    //   761: ifnull -278 -> 483
    //   764: aload 9
    //   766: invokevirtual 923	java/io/FileInputStream:close	()V
    //   769: iload_2
    //   770: istore_3
    //   771: goto -288 -> 483
    //   774: astore 9
    //   776: iload_2
    //   777: istore_3
    //   778: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   781: ifeq -298 -> 483
    //   784: ldc 79
    //   786: iconst_2
    //   787: ldc_w 938
    //   790: aload 9
    //   792: invokestatic 941	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   795: iload_2
    //   796: istore_3
    //   797: goto -314 -> 483
    //   800: astore_1
    //   801: aconst_null
    //   802: astore 9
    //   804: aload 9
    //   806: ifnull +8 -> 814
    //   809: aload 9
    //   811: invokevirtual 923	java/io/FileInputStream:close	()V
    //   814: aload_1
    //   815: athrow
    //   816: astore 9
    //   818: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   821: ifeq -7 -> 814
    //   824: ldc 79
    //   826: iconst_2
    //   827: ldc_w 938
    //   830: aload 9
    //   832: invokestatic 941	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   835: goto -21 -> 814
    //   838: iconst_0
    //   839: istore_2
    //   840: goto -345 -> 495
    //   843: astore 9
    //   845: aload_0
    //   846: sipush -30000
    //   849: ldc_w 942
    //   852: invokestatic 324	alud:a	(I)Ljava/lang/String;
    //   855: invokevirtual 305	baxb:b	(ILjava/lang/String;)V
    //   858: aload_0
    //   859: invokevirtual 307	baxb:d	()V
    //   862: iconst_1
    //   863: istore 4
    //   865: goto -306 -> 559
    //   868: aload_0
    //   869: getfield 865	baxb:jdField_a_of_type_Boolean	Z
    //   872: ifeq +10 -> 882
    //   875: aload_0
    //   876: invokevirtual 645	baxb:f	()V
    //   879: goto -199 -> 680
    //   882: aload_1
    //   883: getfield 943	bavf:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   886: ldc_w 945
    //   889: invokevirtual 947	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   892: ifnonnull +71 -> 963
    //   895: ldc2_w 948
    //   898: lstore 7
    //   900: aload_0
    //   901: getfield 370	baxb:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   904: ldc_w 951
    //   907: lload 7
    //   909: invokestatic 416	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   912: invokevirtual 354	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   915: pop
    //   916: aload_1
    //   917: getfield 877	bavf:jdField_b_of_type_Int	I
    //   920: sipush 9364
    //   923: if_icmpne +61 -> 984
    //   926: aload_0
    //   927: getfield 953	baxb:jdField_l_of_type_Int	I
    //   930: iconst_3
    //   931: if_icmpge +53 -> 984
    //   934: aload_0
    //   935: ldc_w 955
    //   938: ldc_w 957
    //   941: invokevirtual 217	baxb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   944: aload_0
    //   945: aload_0
    //   946: getfield 953	baxb:jdField_l_of_type_Int	I
    //   949: iconst_1
    //   950: iadd
    //   951: putfield 953	baxb:jdField_l_of_type_Int	I
    //   954: aload_0
    //   955: invokevirtual 959	baxb:m	()V
    //   958: aload_0
    //   959: invokevirtual 645	baxb:f	()V
    //   962: return
    //   963: aload_1
    //   964: getfield 943	bavf:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   967: ldc_w 945
    //   970: invokevirtual 947	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   973: checkcast 67	java/lang/String
    //   976: invokestatic 965	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   979: lstore 7
    //   981: goto -81 -> 900
    //   984: aload_1
    //   985: getfield 943	bavf:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   988: getstatic 968	bdpx:f	Ljava/lang/String;
    //   991: invokevirtual 947	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   994: checkcast 67	java/lang/String
    //   997: astore 9
    //   999: aload_0
    //   1000: aload_1
    //   1001: getfield 877	bavf:jdField_b_of_type_Int	I
    //   1004: aload_1
    //   1005: getfield 880	bavf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1008: aload 9
    //   1010: aload_0
    //   1011: getfield 399	baxb:jdField_b_of_type_Barh	Lbarh;
    //   1014: invokevirtual 829	baxb:a	(ILjava/lang/String;Ljava/lang/String;Lbarh;)V
    //   1017: aload_0
    //   1018: invokevirtual 307	baxb:d	()V
    //   1021: goto -341 -> 680
    //   1024: astore_1
    //   1025: goto -221 -> 804
    //   1028: astore_1
    //   1029: goto -225 -> 804
    //   1032: astore 10
    //   1034: iconst_1
    //   1035: istore_2
    //   1036: goto -296 -> 740
    //   1039: astore 10
    //   1041: iconst_0
    //   1042: istore_2
    //   1043: goto -303 -> 740
    //   1046: iconst_1
    //   1047: istore_2
    //   1048: goto -579 -> 469
    //   1051: iconst_1
    //   1052: istore_3
    //   1053: goto -570 -> 483
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1056	0	this	baxb
    //   0	1056	1	parambavf	bavf
    //   468	580	2	i	int
    //   470	583	3	j	int
    //   47	817	4	bool1	boolean
    //   1	616	5	k	int
    //   4	552	6	bool2	boolean
    //   898	82	7	l1	long
    //   37	660	9	localObject1	Object
    //   707	17	9	localIOException1	java.io.IOException
    //   736	29	9	localObject2	Object
    //   774	17	9	localIOException2	java.io.IOException
    //   802	8	9	localObject3	Object
    //   816	15	9	localIOException3	java.io.IOException
    //   843	1	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   997	12	9	str	String
    //   306	244	10	localObject4	Object
    //   733	20	10	localIOException4	java.io.IOException
    //   1032	1	10	localIOException5	java.io.IOException
    //   1039	1	10	localIOException6	java.io.IOException
    //   347	9	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   476	481	707	java/io/IOException
    //   325	336	733	java/io/IOException
    //   764	769	774	java/io/IOException
    //   325	336	800	finally
    //   809	814	816	java/io/IOException
    //   547	555	843	java/lang/OutOfMemoryError
    //   336	349	1024	finally
    //   354	411	1024	finally
    //   411	421	1024	finally
    //   421	467	1024	finally
    //   740	757	1028	finally
    //   336	349	1032	java/io/IOException
    //   354	411	1032	java/io/IOException
    //   411	421	1032	java/io/IOException
    //   421	467	1039	java/io/IOException
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    if (this.jdField_k_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoDownloadProcessor", 2, "onUpdateProgeress: mIsPause=true, should not notify UI, just return!");
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Bass.e = paramLong1;
      this.jdField_a_of_type_Bass.jdField_a_of_type_Long = paramLong2;
      d(2002);
      int i = (int)(10000L * paramLong1 / paramLong2);
      parambave = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (parambave.hasNext()) {
        ((awiq)parambave.next()).a(i, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxb
 * JD-Core Version:    0.7.0.1
 */