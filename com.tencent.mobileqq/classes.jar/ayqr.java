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

public class ayqr
  extends ayoz
  implements aqbt
{
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  private ayqs jdField_a_of_type_Ayqs;
  private ayqy jdField_a_of_type_Ayqy;
  private aywb jdField_a_of_type_Aywb;
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ayqs jdField_b_of_type_Ayqs;
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
  
  public ayqr(ayox paramayox, aywa paramaywa)
  {
    super(paramayox, paramaywa);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext();
    if ((this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject instanceof aywg))
    {
      paramayox = (aywg)this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Int = paramayox.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramayox.jdField_b_of_type_Int;
      this.jdField_b_of_type_JavaLangString = paramayox.jdField_b_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramayox.jdField_c_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = paramayox.jdField_d_of_type_JavaLangString;
      this.l = paramayox.f;
      this.jdField_b_of_type_Long = paramayox.jdField_a_of_type_Long;
      this.jdField_a_of_type_JavaLangString = paramayox.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Aywb = paramayox.jdField_a_of_type_Aywb;
      if (paramayox.jdField_c_of_type_Int != 2) {
        break label320;
      }
      this.e = paramayox.e;
      QLog.i("BaseTransProcessor", 1, "forwardShare info.imageUrlStatus =" + paramayox.jdField_c_of_type_Int + ",mRemoteImgUrl=" + this.f);
      paramaywa = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if ((paramayox.jdField_c_of_type_Int != 1) && (paramayox.jdField_c_of_type_Int != 3)) {
        break label331;
      }
      bool1 = true;
      label266:
      paramaywa.set(bool1);
      paramaywa = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (paramayox.jdField_c_of_type_Int != 1) {
        break label336;
      }
      bool1 = true;
      label286:
      paramaywa.set(bool1);
      paramaywa = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (paramayox.jdField_d_of_type_Int != 1) {
        break label341;
      }
    }
    label320:
    label331:
    label336:
    label341:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramaywa.set(bool1);
      this.jdField_a_of_type_Boolean = aqft.a();
      return;
      this.f = paramayox.e;
      break;
      bool1 = false;
      break label266;
      bool1 = false;
      break label286;
    }
  }
  
  public static aywa a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    aywg localaywg = new aywg();
    localaywg.jdField_a_of_type_Int = paramAbsShareMsg.forwardType;
    localaywg.jdField_b_of_type_Int = paramAbsShareMsg.mMsgServiceID;
    localaywg.jdField_a_of_type_Long = paramAbsShareMsg.mSourceAppid;
    localaywg.jdField_a_of_type_JavaLangString = paramAbsShareMsg.shareData.pkgName;
    localaywg.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mMsgUrl;
    localaywg.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mContentTitle;
    localaywg.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mContentSummary;
    localaywg.e = paramAbsShareMsg.mContentCover;
    localaywg.f = paramAbsShareMsg.mContentSrc;
    localaywg.jdField_c_of_type_Int = paramAbsShareMsg.shareData.imageUrlStatus;
    localaywg.jdField_d_of_type_Int = paramAbsShareMsg.shareData.shortUrlStatus;
    localaywg.jdField_a_of_type_Aywb = new aywb();
    localaywg.jdField_a_of_type_Aywb.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mSourceName;
    localaywg.jdField_a_of_type_Aywb.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mSourceIcon;
    localaywg.jdField_a_of_type_Aywb.e = paramAbsShareMsg.shareData.sourceIconBig;
    localaywg.jdField_a_of_type_Aywb.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mSourceUrl;
    localaywg.jdField_a_of_type_Aywb.jdField_a_of_type_JavaLangString = paramAbsShareMsg.mSource_A_ActionData;
    localaywg.jdField_a_of_type_Aywb.jdField_a_of_type_Int = paramAbsShareMsg.shareData.appInfoStatus;
    paramAbsShareMsg = new aywa();
    paramAbsShareMsg.jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
    paramAbsShareMsg.jdField_c_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramAbsShareMsg.jdField_a_of_type_Int = paramMessageRecord.istroop;
    paramAbsShareMsg.jdField_b_of_type_Int = 52;
    paramAbsShareMsg.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramAbsShareMsg.jdField_a_of_type_Boolean = true;
    paramAbsShareMsg.jdField_e_of_type_Int = 11;
    paramAbsShareMsg.jdField_e_of_type_Boolean = false;
    paramAbsShareMsg.jdField_a_of_type_JavaLangObject = localaywg;
    return paramAbsShareMsg;
  }
  
  public static aywa a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg, auoo paramauoo)
  {
    paramMessageRecord = a(paramMessageRecord, paramAbsShareMsg);
    paramMessageRecord.jdField_a_of_type_Auoo = paramauoo;
    return paramMessageRecord;
  }
  
  private void f()
  {
    if (this.o) {
      return;
    }
    if (this.jdField_a_of_type_Ayqs != null) {
      this.jdField_a_of_type_Ayqs.e();
    }
    if (this.jdField_b_of_type_Ayqs != null) {
      this.jdField_b_of_type_Ayqs.e();
    }
    this.jdField_a_of_type_Ayox.a.post(new ForwardSdkShareProcessor.1(this));
  }
  
  public int a()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "cancel");
    super.a();
    if (this.jdField_a_of_type_Ayqs != null) {
      this.jdField_a_of_type_Ayqs.e();
    }
    if (this.jdField_b_of_type_Ayqs != null) {
      this.jdField_b_of_type_Ayqs.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_a_of_type_Aywa.jdField_a_of_type_Long, 32768, 9037);
    d(1004);
    return 0;
  }
  
  public void aR_()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "start");
    }
    this.jdField_a_of_type_Ayqs = new ayra(this);
    this.jdField_b_of_type_Ayqs = new ayqz(this);
    ayrb localayrb = new ayrb(this);
    ayqv localayqv;
    ayqt localayqt;
    ayqx localayqx;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 11))
    {
      this.jdField_b_of_type_Ayqs.a(new ayqs[] { localayrb });
      localayqv = new ayqv(this);
      localayqt = new ayqt(this);
      localayqx = new ayqx(this);
      if ((localayrb.a()) || (!localayqx.a())) {
        break label188;
      }
      localayrb.a(new ayqs[] { localayqt, localayqv });
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 11)) {
        break label240;
      }
      this.jdField_b_of_type_Ayqs.a();
      return;
      this.jdField_a_of_type_Ayqs.a(new ayqs[] { localayrb });
      break;
      label188:
      localayrb.a(new ayqs[] { localayqt, localayqx });
      this.jdField_a_of_type_Ayqy = new ayqy(this);
      localayqx.a(new ayqs[] { this.jdField_a_of_type_Ayqy, localayqv });
    }
    label240:
    this.jdField_a_of_type_Ayqs.a();
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
    if (!(this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject instanceof aywg))
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
    if (this.jdField_a_of_type_Aywb == null)
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
      if (this.jdField_a_of_type_Ayqs != null) {
        this.jdField_a_of_type_Ayqs.e();
      }
      if (this.jdField_b_of_type_Ayqs != null) {
        this.jdField_b_of_type_Ayqs.e();
      }
    }
  }
  
  void d()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.e("Q.share.ForwardSdkShareProcessor", 1, "On Error, code=" + this.j + ", cost=" + l1);
    super.d();
    if (this.jdField_a_of_type_Ayqs != null) {
      this.jdField_a_of_type_Ayqs.e();
    }
    if (this.jdField_b_of_type_Ayqs != null) {
      this.jdField_b_of_type_Ayqs.e();
    }
    auop localauop = new auop();
    localauop.jdField_a_of_type_Int = -1;
    Object localObject;
    if ((this.jdField_a_of_type_Aywa != null) && (this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo != null))
    {
      if ((this.jdField_a_of_type_Int == 11) && (this.j == 9402) && (!ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext)))
      {
        String str1 = (String)this.jdField_b_of_type_JavaUtilHashMap.get("audioUrl");
        String str2 = this.f;
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = this.l;
        }
        localauop.jdField_a_of_type_JavaLangObject = new String[] { str2, localObject };
        localauop.jdField_b_of_type_Int = this.j;
      }
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo.b(localauop);
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
      bded.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_a_of_type_Aywa.jdField_a_of_type_Long, 32768, this.j);
      d(1005);
    }
  }
  
  void e()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "OnSuccess, cost=" + l1);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).shareData.status = 1003;
      ((AbsShareMsg)localObject).forwardType = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_a_of_type_Aywa.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
    }
    super.e();
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "56");
    ((Bundle)localObject).putString("intext_1", "0");
    ((Bundle)localObject).putString("intext_5", "" + l1);
    bded.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqr
 * JD-Core Version:    0.7.0.1
 */