import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.ShareData;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class betj
  extends berp
  implements auyl
{
  protected int a;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  private betk jdField_a_of_type_Betk;
  private betq jdField_a_of_type_Betq;
  protected beyh a;
  public QQAppInterface a;
  public String a;
  public AtomicBoolean a;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  private long jdField_b_of_type_Long;
  private betk jdField_b_of_type_Betk;
  protected String b;
  public HashMap<String, String> b;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  protected String c;
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int d;
  public String d;
  public String e;
  protected String f;
  private String l;
  private String m;
  
  public betj(bern parambern, beyg parambeyg)
  {
    super(parambern, parambeyg);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext();
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject instanceof beym))
    {
      parambern = (beym)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Int = parambern.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = parambern.jdField_b_of_type_Int;
      this.jdField_a_of_type_JavaLangString = parambern.jdField_b_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = parambern.jdField_c_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = parambern.jdField_d_of_type_JavaLangString;
      this.f = parambern.f;
      this.jdField_b_of_type_Long = parambern.jdField_a_of_type_Long;
      this.l = parambern.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Beyh = parambern.jdField_a_of_type_Beyh;
      if (parambern.jdField_c_of_type_Int == 2)
      {
        this.jdField_d_of_type_JavaLangString = parambern.e;
        QLog.i("BaseTransProcessor", 1, "forwardShare info.imageUrlStatus =" + parambern.jdField_c_of_type_Int + ",mRemoteImgUrl=" + this.e);
        parambeyg = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if ((parambern.jdField_c_of_type_Int != 1) && (parambern.jdField_c_of_type_Int != 3)) {
          break label319;
        }
        bool1 = true;
        label261:
        parambeyg.set(bool1);
        parambeyg = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if (parambern.jdField_c_of_type_Int != 1) {
          break label324;
        }
        bool1 = true;
        label281:
        parambeyg.set(bool1);
        parambeyg = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if (parambern.jdField_d_of_type_Int != 1) {
          break label329;
        }
      }
      label319:
      label324:
      label329:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        parambeyg.set(bool1);
        return;
        this.e = parambern.e;
        break;
        bool1 = false;
        break label261;
        bool1 = false;
        break label281;
      }
    }
    QLog.i("BaseTransProcessor", 1, "mUiRequest.mExtraObj instanceof TransferRequest.ShareExtraInfo : false");
  }
  
  public static beyg a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    beym localbeym = new beym();
    localbeym.jdField_a_of_type_Int = paramAbsShareMsg.forwardType;
    localbeym.jdField_b_of_type_Int = paramAbsShareMsg.mMsgServiceID;
    localbeym.jdField_a_of_type_Long = paramAbsShareMsg.mSourceAppid;
    localbeym.jdField_a_of_type_JavaLangString = paramAbsShareMsg.shareData.pkgName;
    localbeym.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mMsgUrl;
    localbeym.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mContentTitle;
    localbeym.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mContentSummary;
    localbeym.e = paramAbsShareMsg.mContentCover;
    localbeym.f = paramAbsShareMsg.mContentSrc;
    localbeym.jdField_c_of_type_Int = paramAbsShareMsg.shareData.imageUrlStatus;
    localbeym.jdField_d_of_type_Int = paramAbsShareMsg.shareData.shortUrlStatus;
    localbeym.jdField_a_of_type_Beyh = new beyh();
    localbeym.jdField_a_of_type_Beyh.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mSourceName;
    localbeym.jdField_a_of_type_Beyh.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mSourceIcon;
    localbeym.jdField_a_of_type_Beyh.e = paramAbsShareMsg.shareData.sourceIconBig;
    localbeym.jdField_a_of_type_Beyh.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mSourceUrl;
    localbeym.jdField_a_of_type_Beyh.jdField_a_of_type_JavaLangString = paramAbsShareMsg.mSource_A_ActionData;
    localbeym.jdField_a_of_type_Beyh.jdField_a_of_type_Int = paramAbsShareMsg.shareData.appInfoStatus;
    paramAbsShareMsg = new beyg();
    paramAbsShareMsg.jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
    paramAbsShareMsg.jdField_c_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramAbsShareMsg.jdField_a_of_type_Int = paramMessageRecord.istroop;
    paramAbsShareMsg.jdField_b_of_type_Int = 52;
    paramAbsShareMsg.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramAbsShareMsg.jdField_a_of_type_Boolean = true;
    paramAbsShareMsg.e = 11;
    paramAbsShareMsg.f = false;
    paramAbsShareMsg.jdField_a_of_type_JavaLangObject = localbeym;
    return paramAbsShareMsg;
  }
  
  public static beyg a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg, azrg paramazrg)
  {
    paramMessageRecord = a(paramMessageRecord, paramAbsShareMsg);
    paramMessageRecord.jdField_a_of_type_Azrg = paramazrg;
    return paramMessageRecord;
  }
  
  public static beyg a(MessageRecord paramMessageRecord, JSONObject paramJSONObject, azrg paramazrg)
  {
    beym localbeym = new beym();
    localbeym.jdField_a_of_type_Int = paramJSONObject.optInt("forward_type");
    localbeym.jdField_b_of_type_Int = paramJSONObject.optInt("serviceType");
    localbeym.jdField_a_of_type_Long = paramJSONObject.optLong("appId");
    localbeym.jdField_a_of_type_JavaLangString = paramJSONObject.optString("pkg_name");
    localbeym.jdField_b_of_type_JavaLangString = paramJSONObject.optString("targetUrl");
    localbeym.jdField_c_of_type_JavaLangString = paramJSONObject.optString("title");
    localbeym.jdField_d_of_type_JavaLangString = paramJSONObject.optString("summary");
    localbeym.e = paramJSONObject.optString("image_url");
    localbeym.f = paramJSONObject.optString("audio_url");
    localbeym.jdField_c_of_type_Int = paramJSONObject.optInt("imageUrlStatus");
    localbeym.jdField_d_of_type_Int = paramJSONObject.optInt("shortUrlStatus");
    localbeym.jdField_a_of_type_Beyh = new beyh();
    localbeym.jdField_a_of_type_Beyh.jdField_b_of_type_JavaLangString = paramJSONObject.optString("appInfo_sourceName");
    localbeym.jdField_a_of_type_Beyh.jdField_d_of_type_JavaLangString = paramJSONObject.optString("appInfo_sourceIconSmall");
    localbeym.jdField_a_of_type_Beyh.e = paramJSONObject.optString("appInfo_sourceIconBig");
    localbeym.jdField_a_of_type_Beyh.jdField_c_of_type_JavaLangString = paramJSONObject.optString("appInfo_sourceUrl");
    localbeym.jdField_a_of_type_Beyh.jdField_a_of_type_JavaLangString = paramJSONObject.optString("appInfo_packName");
    localbeym.jdField_a_of_type_Beyh.jdField_a_of_type_Int = paramJSONObject.optInt("appInfo_status");
    paramJSONObject = new beyg();
    paramJSONObject.jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
    paramJSONObject.jdField_c_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramJSONObject.jdField_a_of_type_Int = paramMessageRecord.istroop;
    paramJSONObject.jdField_b_of_type_Int = 52;
    paramJSONObject.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramJSONObject.jdField_a_of_type_Boolean = true;
    paramJSONObject.e = 11;
    paramJSONObject.f = false;
    paramJSONObject.jdField_a_of_type_JavaLangObject = localbeym;
    paramJSONObject.jdField_a_of_type_Azrg = paramazrg;
    return paramJSONObject;
  }
  
  private void f()
  {
    if (this.q) {
      return;
    }
    if (this.jdField_a_of_type_Betk != null) {
      this.jdField_a_of_type_Betk.e();
    }
    if (this.jdField_b_of_type_Betk != null) {
      this.jdField_b_of_type_Betk.e();
    }
    this.jdField_a_of_type_Bern.a.post(new ForwardSdkShareProcessor.1(this));
  }
  
  public int a()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "cancel");
    super.a();
    if (this.jdField_a_of_type_Betk != null) {
      this.jdField_a_of_type_Betk.e();
    }
    if (this.jdField_b_of_type_Betk != null) {
      this.jdField_b_of_type_Betk.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long, 32768, 9037);
    d(1004);
    return 0;
  }
  
  public void aN_()
  {
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, "start");
    this.jdField_a_of_type_Betk = new bets(this);
    this.jdField_b_of_type_Betk = new betr(this);
    bett localbett = new bett(this);
    betn localbetn;
    betl localbetl;
    betp localbetp;
    if (this.jdField_a_of_type_Int == 11)
    {
      this.jdField_b_of_type_Betk.a(new betk[] { localbett });
      localbetn = new betn(this);
      localbetl = new betl(this);
      localbetp = new betp(this);
      if ((localbett.a()) || (!localbetp.a())) {
        break label168;
      }
      localbett.a(new betk[] { localbetl, localbetn });
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Int != 11) {
        break label220;
      }
      this.jdField_b_of_type_Betk.a();
      return;
      this.jdField_a_of_type_Betk.a(new betk[] { localbett });
      break;
      label168:
      localbett.a(new betk[] { localbetl, localbetp });
      this.jdField_a_of_type_Betq = new betq(this);
      localbetp.a(new betk[] { this.jdField_a_of_type_Betq, localbetn });
    }
    label220:
    this.jdField_a_of_type_Betk.a();
    d(1001);
    a(1002, MessageHandler.f);
  }
  
  public int b()
  {
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, "resume");
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = false;
      this.q = false;
      aN_();
    }
    return 0;
  }
  
  public int c()
  {
    if (!(this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject instanceof beym))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "SdkShareInfo null");
      b(9302, a(new Exception("SdkShareInfo null")));
      d();
      return -1;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "share targetUrl null");
      b(9302, a(new Exception("share targetUrl null")));
      d();
      return -1;
    }
    if (this.jdField_a_of_type_Beyh == null)
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "mAppInfo null");
      b(9302, a(new Exception("mAppInfo null")));
      d();
      return -1;
    }
    if (!ForwardUtils.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int))
    {
      String str = "err forwardType=" + this.jdField_a_of_type_Int + ",serviceType=" + this.jdField_b_of_type_Int;
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + str);
      b(9302, a(new Exception(str)));
      d();
      return -1;
    }
    return 0;
  }
  
  public void c()
  {
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, "pause");
    if (!this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = true;
      if (this.jdField_a_of_type_Betk != null) {
        this.jdField_a_of_type_Betk.e();
      }
      if (this.jdField_b_of_type_Betk != null) {
        this.jdField_b_of_type_Betk.e();
      }
    }
  }
  
  void d()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.e("Q.share.ForwardSdkShareProcessor", 1, "On Error, code=" + this.k + ", cost=" + l1);
    super.d();
    if (this.jdField_a_of_type_Betk != null) {
      this.jdField_a_of_type_Betk.e();
    }
    if (this.jdField_b_of_type_Betk != null) {
      this.jdField_b_of_type_Betk.e();
    }
    azrh localazrh = new azrh();
    localazrh.jdField_a_of_type_Int = -1;
    Object localObject;
    if ((this.jdField_a_of_type_Beyg != null) && (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null))
    {
      if ((this.jdField_a_of_type_Int == 11) && (this.k == 9402) && (!ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext)))
      {
        String str1 = (String)this.jdField_b_of_type_JavaUtilHashMap.get("audioUrl");
        String str2 = this.e;
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = this.f;
        }
        localazrh.jdField_a_of_type_JavaLangObject = new String[] { str2, localObject };
        localazrh.jdField_b_of_type_Int = this.k;
      }
      this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.b(localazrh);
    }
    if (this.jdField_a_of_type_Int == 11) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "SDK_SHARE onError");
    }
    for (;;)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "56");
      ((Bundle)localObject).putString("intext_1", "" + this.k);
      ((Bundle)localObject).putString("intext_5", "" + l1);
      bjqh.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long, 32768, this.k);
      d(1005);
    }
  }
  
  void e()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "OnSuccess, cost=" + l1);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).shareData.status = 1003;
      ((AbsShareMsg)localObject).forwardType = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
    }
    super.e();
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "56");
    ((Bundle)localObject).putString("intext_1", "0");
    ((Bundle)localObject).putString("intext_5", "" + l1);
    bjqh.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betj
 * JD-Core Version:    0.7.0.1
 */