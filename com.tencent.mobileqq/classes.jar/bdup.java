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

public class bdup
  extends bdsx
  implements augo
{
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  private bduq jdField_a_of_type_Bduq;
  private bduw jdField_a_of_type_Bduw;
  private bdzo jdField_a_of_type_Bdzo;
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private bduq jdField_b_of_type_Bduq;
  private String jdField_b_of_type_JavaLangString;
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private String d;
  private String e;
  private String f;
  private String l;
  private String m;
  private int p;
  
  public bdup(bdsv parambdsv, bdzn parambdzn)
  {
    super(parambdsv, parambdzn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext();
    if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject instanceof bdzt))
    {
      parambdsv = (bdzt)this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Int = parambdsv.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = parambdsv.jdField_b_of_type_Int;
      this.jdField_b_of_type_JavaLangString = parambdsv.jdField_b_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = parambdsv.jdField_c_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = parambdsv.jdField_d_of_type_JavaLangString;
      this.l = parambdsv.f;
      this.jdField_b_of_type_Long = parambdsv.jdField_a_of_type_Long;
      this.jdField_a_of_type_JavaLangString = parambdsv.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bdzo = parambdsv.jdField_a_of_type_Bdzo;
      if (parambdsv.jdField_c_of_type_Int == 2)
      {
        this.e = parambdsv.e;
        QLog.i("BaseTransProcessor", 1, "forwardShare info.imageUrlStatus =" + parambdsv.jdField_c_of_type_Int + ",mRemoteImgUrl=" + this.f);
        parambdzn = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if ((parambdsv.jdField_c_of_type_Int != 1) && (parambdsv.jdField_c_of_type_Int != 3)) {
          break label319;
        }
        bool1 = true;
        label261:
        parambdzn.set(bool1);
        parambdzn = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if (parambdsv.jdField_c_of_type_Int != 1) {
          break label324;
        }
        bool1 = true;
        label281:
        parambdzn.set(bool1);
        parambdzn = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if (parambdsv.jdField_d_of_type_Int != 1) {
          break label329;
        }
      }
      label319:
      label324:
      label329:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        parambdzn.set(bool1);
        return;
        this.f = parambdsv.e;
        break;
        bool1 = false;
        break label261;
        bool1 = false;
        break label281;
      }
    }
    QLog.i("BaseTransProcessor", 1, "mUiRequest.mExtraObj instanceof TransferRequest.ShareExtraInfo : false");
  }
  
  public static bdzn a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    bdzt localbdzt = new bdzt();
    localbdzt.jdField_a_of_type_Int = paramAbsShareMsg.forwardType;
    localbdzt.jdField_b_of_type_Int = paramAbsShareMsg.mMsgServiceID;
    localbdzt.jdField_a_of_type_Long = paramAbsShareMsg.mSourceAppid;
    localbdzt.jdField_a_of_type_JavaLangString = paramAbsShareMsg.shareData.pkgName;
    localbdzt.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mMsgUrl;
    localbdzt.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mContentTitle;
    localbdzt.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mContentSummary;
    localbdzt.e = paramAbsShareMsg.mContentCover;
    localbdzt.f = paramAbsShareMsg.mContentSrc;
    localbdzt.jdField_c_of_type_Int = paramAbsShareMsg.shareData.imageUrlStatus;
    localbdzt.jdField_d_of_type_Int = paramAbsShareMsg.shareData.shortUrlStatus;
    localbdzt.jdField_a_of_type_Bdzo = new bdzo();
    localbdzt.jdField_a_of_type_Bdzo.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mSourceName;
    localbdzt.jdField_a_of_type_Bdzo.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mSourceIcon;
    localbdzt.jdField_a_of_type_Bdzo.e = paramAbsShareMsg.shareData.sourceIconBig;
    localbdzt.jdField_a_of_type_Bdzo.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mSourceUrl;
    localbdzt.jdField_a_of_type_Bdzo.jdField_a_of_type_JavaLangString = paramAbsShareMsg.mSource_A_ActionData;
    localbdzt.jdField_a_of_type_Bdzo.jdField_a_of_type_Int = paramAbsShareMsg.shareData.appInfoStatus;
    paramAbsShareMsg = new bdzn();
    paramAbsShareMsg.jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
    paramAbsShareMsg.jdField_c_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramAbsShareMsg.jdField_a_of_type_Int = paramMessageRecord.istroop;
    paramAbsShareMsg.jdField_b_of_type_Int = 52;
    paramAbsShareMsg.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramAbsShareMsg.jdField_a_of_type_Boolean = true;
    paramAbsShareMsg.jdField_e_of_type_Int = 11;
    paramAbsShareMsg.jdField_e_of_type_Boolean = false;
    paramAbsShareMsg.jdField_a_of_type_JavaLangObject = localbdzt;
    return paramAbsShareMsg;
  }
  
  public static bdzn a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg, ayyt paramayyt)
  {
    paramMessageRecord = a(paramMessageRecord, paramAbsShareMsg);
    paramMessageRecord.jdField_a_of_type_Ayyt = paramayyt;
    return paramMessageRecord;
  }
  
  public static bdzn a(MessageRecord paramMessageRecord, JSONObject paramJSONObject, ayyt paramayyt)
  {
    bdzt localbdzt = new bdzt();
    localbdzt.jdField_a_of_type_Int = paramJSONObject.optInt("forward_type");
    localbdzt.jdField_b_of_type_Int = paramJSONObject.optInt("serviceType");
    localbdzt.jdField_a_of_type_Long = paramJSONObject.optLong("appId");
    localbdzt.jdField_a_of_type_JavaLangString = paramJSONObject.optString("pkg_name");
    localbdzt.jdField_b_of_type_JavaLangString = paramJSONObject.optString("targetUrl");
    localbdzt.jdField_c_of_type_JavaLangString = paramJSONObject.optString("title");
    localbdzt.jdField_d_of_type_JavaLangString = paramJSONObject.optString("summary");
    localbdzt.e = paramJSONObject.optString("image_url");
    localbdzt.f = paramJSONObject.optString("audio_url");
    localbdzt.jdField_c_of_type_Int = paramJSONObject.optInt("imageUrlStatus");
    localbdzt.jdField_d_of_type_Int = paramJSONObject.optInt("shortUrlStatus");
    localbdzt.jdField_a_of_type_Bdzo = new bdzo();
    localbdzt.jdField_a_of_type_Bdzo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("appInfo_sourceName");
    localbdzt.jdField_a_of_type_Bdzo.jdField_d_of_type_JavaLangString = paramJSONObject.optString("appInfo_sourceIconSmall");
    localbdzt.jdField_a_of_type_Bdzo.e = paramJSONObject.optString("appInfo_sourceIconBig");
    localbdzt.jdField_a_of_type_Bdzo.jdField_c_of_type_JavaLangString = paramJSONObject.optString("appInfo_sourceUrl");
    localbdzt.jdField_a_of_type_Bdzo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("appInfo_packName");
    localbdzt.jdField_a_of_type_Bdzo.jdField_a_of_type_Int = paramJSONObject.optInt("appInfo_status");
    paramJSONObject = new bdzn();
    paramJSONObject.jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
    paramJSONObject.jdField_c_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramJSONObject.jdField_a_of_type_Int = paramMessageRecord.istroop;
    paramJSONObject.jdField_b_of_type_Int = 52;
    paramJSONObject.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramJSONObject.jdField_a_of_type_Boolean = true;
    paramJSONObject.jdField_e_of_type_Int = 11;
    paramJSONObject.jdField_e_of_type_Boolean = false;
    paramJSONObject.jdField_a_of_type_JavaLangObject = localbdzt;
    paramJSONObject.jdField_a_of_type_Ayyt = paramayyt;
    return paramJSONObject;
  }
  
  private void f()
  {
    if (this.q) {
      return;
    }
    if (this.jdField_a_of_type_Bduq != null) {
      this.jdField_a_of_type_Bduq.e();
    }
    if (this.jdField_b_of_type_Bduq != null) {
      this.jdField_b_of_type_Bduq.e();
    }
    this.jdField_a_of_type_Bdsv.a.post(new ForwardSdkShareProcessor.1(this));
  }
  
  public int a()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "cancel");
    super.a();
    if (this.jdField_a_of_type_Bduq != null) {
      this.jdField_a_of_type_Bduq.e();
    }
    if (this.jdField_b_of_type_Bduq != null) {
      this.jdField_b_of_type_Bduq.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long, 32768, 9037);
    d(1004);
    return 0;
  }
  
  public void aN_()
  {
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, "start");
    this.jdField_a_of_type_Bduq = new bduy(this);
    this.jdField_b_of_type_Bduq = new bdux(this);
    bduz localbduz = new bduz(this);
    bdut localbdut;
    bdur localbdur;
    bduv localbduv;
    if (this.jdField_a_of_type_Int == 11)
    {
      this.jdField_b_of_type_Bduq.a(new bduq[] { localbduz });
      localbdut = new bdut(this);
      localbdur = new bdur(this);
      localbduv = new bduv(this);
      if ((localbduz.a()) || (!localbduv.a())) {
        break label168;
      }
      localbduz.a(new bduq[] { localbdur, localbdut });
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Int != 11) {
        break label220;
      }
      this.jdField_b_of_type_Bduq.a();
      return;
      this.jdField_a_of_type_Bduq.a(new bduq[] { localbduz });
      break;
      label168:
      localbduz.a(new bduq[] { localbdur, localbduv });
      this.jdField_a_of_type_Bduw = new bduw(this);
      localbduv.a(new bduq[] { this.jdField_a_of_type_Bduw, localbdut });
    }
    label220:
    this.jdField_a_of_type_Bduq.a();
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
    if (!(this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject instanceof bdzt))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "SdkShareInfo null");
      b(9302, a(new Exception("SdkShareInfo null")));
      d();
      return -1;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "share targetUrl null");
      b(9302, a(new Exception("share targetUrl null")));
      d();
      return -1;
    }
    if (this.jdField_a_of_type_Bdzo == null)
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
      if (this.jdField_a_of_type_Bduq != null) {
        this.jdField_a_of_type_Bduq.e();
      }
      if (this.jdField_b_of_type_Bduq != null) {
        this.jdField_b_of_type_Bduq.e();
      }
    }
  }
  
  void d()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.e("Q.share.ForwardSdkShareProcessor", 1, "On Error, code=" + this.j + ", cost=" + l1);
    super.d();
    if (this.jdField_a_of_type_Bduq != null) {
      this.jdField_a_of_type_Bduq.e();
    }
    if (this.jdField_b_of_type_Bduq != null) {
      this.jdField_b_of_type_Bduq.e();
    }
    ayyu localayyu = new ayyu();
    localayyu.jdField_a_of_type_Int = -1;
    Object localObject;
    if ((this.jdField_a_of_type_Bdzn != null) && (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt != null))
    {
      if ((this.jdField_a_of_type_Int == 11) && (this.j == 9402) && (!ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext)))
      {
        String str1 = (String)this.jdField_b_of_type_JavaUtilHashMap.get("audioUrl");
        String str2 = this.f;
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = this.l;
        }
        localayyu.jdField_a_of_type_JavaLangObject = new String[] { str2, localObject };
        localayyu.jdField_b_of_type_Int = this.j;
      }
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt.b(localayyu);
    }
    if (this.jdField_a_of_type_Int == 11) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "SDK_SHARE onError");
    }
    for (;;)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "56");
      ((Bundle)localObject).putString("intext_1", "" + this.j);
      ((Bundle)localObject).putString("intext_5", "" + l1);
      bipi.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long, 32768, this.j);
      d(1005);
    }
  }
  
  void e()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "OnSuccess, cost=" + l1);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).shareData.status = 1003;
      ((AbsShareMsg)localObject).forwardType = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
    }
    super.e();
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "56");
    ((Bundle)localObject).putString("intext_1", "0");
    ((Bundle)localObject).putString("intext_5", "" + l1);
    bipi.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdup
 * JD-Core Version:    0.7.0.1
 */