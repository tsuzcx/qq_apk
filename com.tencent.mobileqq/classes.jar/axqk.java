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

public class axqk
  extends axou
  implements apig
{
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  private axql jdField_a_of_type_Axql;
  private axqr jdField_a_of_type_Axqr;
  private axvu jdField_a_of_type_Axvu;
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private axql jdField_b_of_type_Axql;
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
  private String k;
  private String l;
  private int p;
  
  public axqk(axos paramaxos, axvt paramaxvt)
  {
    super(paramaxos, paramaxvt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext();
    if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject instanceof axvz))
    {
      paramaxos = (axvz)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Int = paramaxos.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramaxos.jdField_b_of_type_Int;
      this.jdField_b_of_type_JavaLangString = paramaxos.jdField_b_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramaxos.jdField_c_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = paramaxos.jdField_d_of_type_JavaLangString;
      this.jdField_k_of_type_JavaLangString = paramaxos.f;
      this.jdField_b_of_type_Long = paramaxos.jdField_a_of_type_Long;
      this.jdField_a_of_type_JavaLangString = paramaxos.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Axvu = paramaxos.jdField_a_of_type_Axvu;
      if (paramaxos.jdField_c_of_type_Int != 2) {
        break label320;
      }
      this.e = paramaxos.e;
      QLog.i("BaseTransProcessor", 1, "forwardShare info.imageUrlStatus =" + paramaxos.jdField_c_of_type_Int + ",mRemoteImgUrl=" + this.f);
      paramaxvt = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if ((paramaxos.jdField_c_of_type_Int != 1) && (paramaxos.jdField_c_of_type_Int != 3)) {
        break label331;
      }
      bool1 = true;
      label266:
      paramaxvt.set(bool1);
      paramaxvt = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (paramaxos.jdField_c_of_type_Int != 1) {
        break label336;
      }
      bool1 = true;
      label286:
      paramaxvt.set(bool1);
      paramaxvt = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (paramaxos.jdField_d_of_type_Int != 1) {
        break label341;
      }
    }
    label320:
    label331:
    label336:
    label341:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramaxvt.set(bool1);
      this.jdField_a_of_type_Boolean = apmf.a();
      return;
      this.f = paramaxos.e;
      break;
      bool1 = false;
      break label266;
      bool1 = false;
      break label286;
    }
  }
  
  public static axvt a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    axvz localaxvz = new axvz();
    localaxvz.jdField_a_of_type_Int = paramAbsShareMsg.forwardType;
    localaxvz.jdField_b_of_type_Int = paramAbsShareMsg.mMsgServiceID;
    localaxvz.jdField_a_of_type_Long = paramAbsShareMsg.mSourceAppid;
    localaxvz.jdField_a_of_type_JavaLangString = paramAbsShareMsg.shareData.pkgName;
    localaxvz.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mMsgUrl;
    localaxvz.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mContentTitle;
    localaxvz.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mContentSummary;
    localaxvz.e = paramAbsShareMsg.mContentCover;
    localaxvz.f = paramAbsShareMsg.mContentSrc;
    localaxvz.jdField_c_of_type_Int = paramAbsShareMsg.shareData.imageUrlStatus;
    localaxvz.jdField_d_of_type_Int = paramAbsShareMsg.shareData.shortUrlStatus;
    localaxvz.jdField_a_of_type_Axvu = new axvu();
    localaxvz.jdField_a_of_type_Axvu.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mSourceName;
    localaxvz.jdField_a_of_type_Axvu.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mSourceIcon;
    localaxvz.jdField_a_of_type_Axvu.e = paramAbsShareMsg.shareData.sourceIconBig;
    localaxvz.jdField_a_of_type_Axvu.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mSourceUrl;
    localaxvz.jdField_a_of_type_Axvu.jdField_a_of_type_JavaLangString = paramAbsShareMsg.mSource_A_ActionData;
    localaxvz.jdField_a_of_type_Axvu.jdField_a_of_type_Int = paramAbsShareMsg.shareData.appInfoStatus;
    paramAbsShareMsg = new axvt();
    paramAbsShareMsg.jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
    paramAbsShareMsg.jdField_c_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramAbsShareMsg.jdField_a_of_type_Int = paramMessageRecord.istroop;
    paramAbsShareMsg.jdField_b_of_type_Int = 52;
    paramAbsShareMsg.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramAbsShareMsg.jdField_a_of_type_Boolean = true;
    paramAbsShareMsg.jdField_e_of_type_Int = 11;
    paramAbsShareMsg.jdField_e_of_type_Boolean = false;
    paramAbsShareMsg.jdField_a_of_type_JavaLangObject = localaxvz;
    return paramAbsShareMsg;
  }
  
  public static axvt a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg, atqq paramatqq)
  {
    paramMessageRecord = a(paramMessageRecord, paramAbsShareMsg);
    paramMessageRecord.jdField_a_of_type_Atqq = paramatqq;
    return paramMessageRecord;
  }
  
  private void f()
  {
    if (this.o) {
      return;
    }
    if (this.jdField_a_of_type_Axql != null) {
      this.jdField_a_of_type_Axql.e();
    }
    if (this.jdField_b_of_type_Axql != null) {
      this.jdField_b_of_type_Axql.e();
    }
    this.jdField_a_of_type_Axos.a.post(new ForwardSdkShareProcessor.1(this));
  }
  
  public int a()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "cancel");
    super.a();
    if (this.jdField_a_of_type_Axql != null) {
      this.jdField_a_of_type_Axql.e();
    }
    if (this.jdField_b_of_type_Axql != null) {
      this.jdField_b_of_type_Axql.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Long, 32768, 9037);
    d(1004);
    return 0;
  }
  
  public void aU_()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "start");
    }
    this.jdField_a_of_type_Axql = new axqt(this);
    this.jdField_b_of_type_Axql = new axqs(this);
    axqu localaxqu = new axqu(this);
    axqo localaxqo;
    axqm localaxqm;
    axqq localaxqq;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 11))
    {
      this.jdField_b_of_type_Axql.a(new axql[] { localaxqu });
      localaxqo = new axqo(this);
      localaxqm = new axqm(this);
      localaxqq = new axqq(this);
      if ((localaxqu.a()) || (!localaxqq.a())) {
        break label188;
      }
      localaxqu.a(new axql[] { localaxqm, localaxqo });
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 11)) {
        break label240;
      }
      this.jdField_b_of_type_Axql.a();
      return;
      this.jdField_a_of_type_Axql.a(new axql[] { localaxqu });
      break;
      label188:
      localaxqu.a(new axql[] { localaxqm, localaxqq });
      this.jdField_a_of_type_Axqr = new axqr(this);
      localaxqq.a(new axql[] { this.jdField_a_of_type_Axqr, localaxqo });
    }
    label240:
    this.jdField_a_of_type_Axql.a();
    d(1001);
    a(1002, MessageHandler.jdField_e_of_type_Int);
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "resume");
    }
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      this.o = false;
      aU_();
    }
    return 0;
  }
  
  public int c()
  {
    if (!(this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject instanceof axvz))
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
    if (this.jdField_a_of_type_Axvu == null)
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
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = true;
      if (this.jdField_a_of_type_Axql != null) {
        this.jdField_a_of_type_Axql.e();
      }
      if (this.jdField_b_of_type_Axql != null) {
        this.jdField_b_of_type_Axql.e();
      }
    }
  }
  
  void d()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, "On Error, code=" + this.j + ", cost=" + l1);
    super.d();
    if (this.jdField_a_of_type_Axql != null) {
      this.jdField_a_of_type_Axql.e();
    }
    if (this.jdField_b_of_type_Axql != null) {
      this.jdField_b_of_type_Axql.e();
    }
    Object localObject = new atqr();
    ((atqr)localObject).jdField_a_of_type_Int = -1;
    if ((this.jdField_a_of_type_Axvt != null) && (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq != null)) {
      this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq.b((atqr)localObject);
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
      bcad.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Long, 32768, this.j);
      d(1005);
    }
  }
  
  void e()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "OnSuccess, cost=" + l1);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).shareData.status = 1003;
      ((AbsShareMsg)localObject).forwardType = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
    }
    super.e();
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "56");
    ((Bundle)localObject).putString("intext_1", "0");
    ((Bundle)localObject).putString("intext_5", "" + l1);
    bcad.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axqk
 * JD-Core Version:    0.7.0.1
 */