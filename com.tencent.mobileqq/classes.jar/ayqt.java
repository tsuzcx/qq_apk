import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.ShareData;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ayqt
  extends aypb
  implements aqbv
{
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  private ayqu jdField_a_of_type_Ayqu;
  private ayra jdField_a_of_type_Ayra;
  private aywd jdField_a_of_type_Aywd;
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ayqu jdField_b_of_type_Ayqu;
  private String jdField_b_of_type_JavaLangString;
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_b_of_type_Boolean;
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
  
  public ayqt(ayoz paramayoz, aywc paramaywc)
  {
    super(paramayoz, paramaywc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext();
    if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject instanceof aywi))
    {
      paramayoz = (aywi)this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Int = paramayoz.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramayoz.jdField_b_of_type_Int;
      this.jdField_b_of_type_JavaLangString = paramayoz.jdField_b_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramayoz.jdField_c_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = paramayoz.jdField_d_of_type_JavaLangString;
      this.l = paramayoz.f;
      this.jdField_b_of_type_Long = paramayoz.jdField_a_of_type_Long;
      this.jdField_a_of_type_JavaLangString = paramayoz.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Aywd = paramayoz.jdField_a_of_type_Aywd;
      if (paramayoz.jdField_c_of_type_Int != 2) {
        break label320;
      }
      this.e = paramayoz.e;
      QLog.i("BaseTransProcessor", 1, "forwardShare info.imageUrlStatus =" + paramayoz.jdField_c_of_type_Int + ",mRemoteImgUrl=" + this.f);
      paramaywc = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if ((paramayoz.jdField_c_of_type_Int != 1) && (paramayoz.jdField_c_of_type_Int != 3)) {
        break label331;
      }
      bool1 = true;
      label266:
      paramaywc.set(bool1);
      paramaywc = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (paramayoz.jdField_c_of_type_Int != 1) {
        break label336;
      }
      bool1 = true;
      label286:
      paramaywc.set(bool1);
      paramaywc = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (paramayoz.jdField_d_of_type_Int != 1) {
        break label341;
      }
    }
    label320:
    label331:
    label336:
    label341:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramaywc.set(bool1);
      this.jdField_a_of_type_Boolean = aqfv.a();
      return;
      this.f = paramayoz.e;
      break;
      bool1 = false;
      break label266;
      bool1 = false;
      break label286;
    }
  }
  
  public static aywc a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    aywi localaywi = new aywi();
    localaywi.jdField_a_of_type_Int = paramAbsShareMsg.forwardType;
    localaywi.jdField_b_of_type_Int = paramAbsShareMsg.mMsgServiceID;
    localaywi.jdField_a_of_type_Long = paramAbsShareMsg.mSourceAppid;
    localaywi.jdField_a_of_type_JavaLangString = paramAbsShareMsg.shareData.pkgName;
    localaywi.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mMsgUrl;
    localaywi.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mContentTitle;
    localaywi.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mContentSummary;
    localaywi.e = paramAbsShareMsg.mContentCover;
    localaywi.f = paramAbsShareMsg.mContentSrc;
    localaywi.jdField_c_of_type_Int = paramAbsShareMsg.shareData.imageUrlStatus;
    localaywi.jdField_d_of_type_Int = paramAbsShareMsg.shareData.shortUrlStatus;
    localaywi.jdField_a_of_type_Aywd = new aywd();
    localaywi.jdField_a_of_type_Aywd.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mSourceName;
    localaywi.jdField_a_of_type_Aywd.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mSourceIcon;
    localaywi.jdField_a_of_type_Aywd.e = paramAbsShareMsg.shareData.sourceIconBig;
    localaywi.jdField_a_of_type_Aywd.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mSourceUrl;
    localaywi.jdField_a_of_type_Aywd.jdField_a_of_type_JavaLangString = paramAbsShareMsg.mSource_A_ActionData;
    localaywi.jdField_a_of_type_Aywd.jdField_a_of_type_Int = paramAbsShareMsg.shareData.appInfoStatus;
    paramAbsShareMsg = new aywc();
    paramAbsShareMsg.jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
    paramAbsShareMsg.jdField_c_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramAbsShareMsg.jdField_a_of_type_Int = paramMessageRecord.istroop;
    paramAbsShareMsg.jdField_b_of_type_Int = 52;
    paramAbsShareMsg.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramAbsShareMsg.jdField_a_of_type_Boolean = true;
    paramAbsShareMsg.jdField_e_of_type_Int = 11;
    paramAbsShareMsg.jdField_e_of_type_Boolean = false;
    paramAbsShareMsg.jdField_a_of_type_JavaLangObject = localaywi;
    return paramAbsShareMsg;
  }
  
  public static aywc a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg, auoq paramauoq)
  {
    paramMessageRecord = a(paramMessageRecord, paramAbsShareMsg);
    paramMessageRecord.jdField_a_of_type_Auoq = paramauoq;
    return paramMessageRecord;
  }
  
  private void f()
  {
    if (this.o) {
      return;
    }
    if (this.jdField_a_of_type_Ayqu != null) {
      this.jdField_a_of_type_Ayqu.e();
    }
    if (this.jdField_b_of_type_Ayqu != null) {
      this.jdField_b_of_type_Ayqu.e();
    }
    this.jdField_a_of_type_Ayoz.a.post(new ForwardSdkShareProcessor.1(this));
  }
  
  public int a()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "cancel");
    super.a();
    if (this.jdField_a_of_type_Ayqu != null) {
      this.jdField_a_of_type_Ayqu.e();
    }
    if (this.jdField_b_of_type_Ayqu != null) {
      this.jdField_b_of_type_Ayqu.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_a_of_type_Aywc.jdField_a_of_type_Long, 32768, 9037);
    d(1004);
    return 0;
  }
  
  public void aR_()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "start");
    }
    this.jdField_a_of_type_Ayqu = new ayrc(this);
    this.jdField_b_of_type_Ayqu = new ayrb(this);
    ayrd localayrd = new ayrd(this);
    ayqx localayqx;
    ayqv localayqv;
    ayqz localayqz;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 11))
    {
      this.jdField_b_of_type_Ayqu.a(new ayqu[] { localayrd });
      localayqx = new ayqx(this);
      localayqv = new ayqv(this);
      localayqz = new ayqz(this);
      if ((localayrd.a()) || (!localayqz.a())) {
        break label188;
      }
      localayrd.a(new ayqu[] { localayqv, localayqx });
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 11)) {
        break label240;
      }
      this.jdField_b_of_type_Ayqu.a();
      return;
      this.jdField_a_of_type_Ayqu.a(new ayqu[] { localayrd });
      break;
      label188:
      localayrd.a(new ayqu[] { localayqv, localayqz });
      this.jdField_a_of_type_Ayra = new ayra(this);
      localayqz.a(new ayqu[] { this.jdField_a_of_type_Ayra, localayqx });
    }
    label240:
    this.jdField_a_of_type_Ayqu.a();
    d(1001);
    a(1002, MessageHandler.f);
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "resume");
    }
    if (this.k)
    {
      this.k = false;
      this.o = false;
      aR_();
    }
    return 0;
  }
  
  public int c()
  {
    if (!(this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject instanceof aywi))
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
    if (this.jdField_a_of_type_Aywd == null)
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
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "pause");
    }
    if (!this.k)
    {
      this.k = true;
      if (this.jdField_a_of_type_Ayqu != null) {
        this.jdField_a_of_type_Ayqu.e();
      }
      if (this.jdField_b_of_type_Ayqu != null) {
        this.jdField_b_of_type_Ayqu.e();
      }
    }
  }
  
  void d()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.e("Q.share.ForwardSdkShareProcessor", 1, "On Error, code=" + this.j + ", cost=" + l1);
    super.d();
    if (this.jdField_a_of_type_Ayqu != null) {
      this.jdField_a_of_type_Ayqu.e();
    }
    if (this.jdField_b_of_type_Ayqu != null) {
      this.jdField_b_of_type_Ayqu.e();
    }
    auor localauor = new auor();
    localauor.jdField_a_of_type_Int = -1;
    Object localObject;
    if ((this.jdField_a_of_type_Aywc != null) && (this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq != null))
    {
      if ((this.jdField_a_of_type_Int == 11) && (this.j == 9402) && (!ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext)))
      {
        String str1 = (String)this.jdField_b_of_type_JavaUtilHashMap.get("audioUrl");
        String str2 = this.f;
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = this.l;
        }
        localauor.jdField_a_of_type_JavaLangObject = new String[] { str2, localObject };
        localauor.jdField_b_of_type_Int = this.j;
      }
      this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq.b(localauor);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 11)) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "SDK_SHARE onError");
    }
    for (;;)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "56");
      ((Bundle)localObject).putString("intext_1", "" + this.j);
      ((Bundle)localObject).putString("intext_5", "" + l1);
      bdes.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_a_of_type_Aywc.jdField_a_of_type_Long, 32768, this.j);
      d(1005);
    }
  }
  
  void e()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "OnSuccess, cost=" + l1);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).shareData.status = 1003;
      ((AbsShareMsg)localObject).forwardType = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_a_of_type_Aywc.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
    }
    super.e();
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "56");
    ((Bundle)localObject).putString("intext_1", "0");
    ((Bundle)localObject).putString("intext_5", "" + l1);
    bdes.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqt
 * JD-Core Version:    0.7.0.1
 */