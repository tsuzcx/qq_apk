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

public class basx
  extends barf
  implements arzm
{
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  private basy jdField_a_of_type_Basy;
  private bate jdField_a_of_type_Bate;
  private bayl jdField_a_of_type_Bayl;
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private basy jdField_b_of_type_Basy;
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
  
  public basx(bard parambard, bayk parambayk)
  {
    super(parambard, parambayk);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext();
    if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject instanceof bayq))
    {
      parambard = (bayq)this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Int = parambard.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = parambard.jdField_b_of_type_Int;
      this.jdField_b_of_type_JavaLangString = parambard.jdField_b_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = parambard.jdField_c_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = parambard.jdField_d_of_type_JavaLangString;
      this.l = parambard.f;
      this.jdField_b_of_type_Long = parambard.jdField_a_of_type_Long;
      this.jdField_a_of_type_JavaLangString = parambard.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bayl = parambard.jdField_a_of_type_Bayl;
      if (parambard.jdField_c_of_type_Int != 2) {
        break label320;
      }
      this.e = parambard.e;
      QLog.i("BaseTransProcessor", 1, "forwardShare info.imageUrlStatus =" + parambard.jdField_c_of_type_Int + ",mRemoteImgUrl=" + this.f);
      parambayk = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if ((parambard.jdField_c_of_type_Int != 1) && (parambard.jdField_c_of_type_Int != 3)) {
        break label331;
      }
      bool1 = true;
      label266:
      parambayk.set(bool1);
      parambayk = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (parambard.jdField_c_of_type_Int != 1) {
        break label336;
      }
      bool1 = true;
      label286:
      parambayk.set(bool1);
      parambayk = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (parambard.jdField_d_of_type_Int != 1) {
        break label341;
      }
    }
    label320:
    label331:
    label336:
    label341:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      parambayk.set(bool1);
      this.jdField_a_of_type_Boolean = asdt.a();
      return;
      this.f = parambard.e;
      break;
      bool1 = false;
      break label266;
      bool1 = false;
      break label286;
    }
  }
  
  public static bayk a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    bayq localbayq = new bayq();
    localbayq.jdField_a_of_type_Int = paramAbsShareMsg.forwardType;
    localbayq.jdField_b_of_type_Int = paramAbsShareMsg.mMsgServiceID;
    localbayq.jdField_a_of_type_Long = paramAbsShareMsg.mSourceAppid;
    localbayq.jdField_a_of_type_JavaLangString = paramAbsShareMsg.shareData.pkgName;
    localbayq.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mMsgUrl;
    localbayq.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mContentTitle;
    localbayq.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mContentSummary;
    localbayq.e = paramAbsShareMsg.mContentCover;
    localbayq.f = paramAbsShareMsg.mContentSrc;
    localbayq.jdField_c_of_type_Int = paramAbsShareMsg.shareData.imageUrlStatus;
    localbayq.jdField_d_of_type_Int = paramAbsShareMsg.shareData.shortUrlStatus;
    localbayq.jdField_a_of_type_Bayl = new bayl();
    localbayq.jdField_a_of_type_Bayl.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mSourceName;
    localbayq.jdField_a_of_type_Bayl.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mSourceIcon;
    localbayq.jdField_a_of_type_Bayl.e = paramAbsShareMsg.shareData.sourceIconBig;
    localbayq.jdField_a_of_type_Bayl.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mSourceUrl;
    localbayq.jdField_a_of_type_Bayl.jdField_a_of_type_JavaLangString = paramAbsShareMsg.mSource_A_ActionData;
    localbayq.jdField_a_of_type_Bayl.jdField_a_of_type_Int = paramAbsShareMsg.shareData.appInfoStatus;
    paramAbsShareMsg = new bayk();
    paramAbsShareMsg.jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
    paramAbsShareMsg.jdField_c_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramAbsShareMsg.jdField_a_of_type_Int = paramMessageRecord.istroop;
    paramAbsShareMsg.jdField_b_of_type_Int = 52;
    paramAbsShareMsg.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramAbsShareMsg.jdField_a_of_type_Boolean = true;
    paramAbsShareMsg.jdField_e_of_type_Int = 11;
    paramAbsShareMsg.jdField_e_of_type_Boolean = false;
    paramAbsShareMsg.jdField_a_of_type_JavaLangObject = localbayq;
    return paramAbsShareMsg;
  }
  
  public static bayk a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg, awkh paramawkh)
  {
    paramMessageRecord = a(paramMessageRecord, paramAbsShareMsg);
    paramMessageRecord.jdField_a_of_type_Awkh = paramawkh;
    return paramMessageRecord;
  }
  
  private void f()
  {
    if (this.o) {
      return;
    }
    if (this.jdField_a_of_type_Basy != null) {
      this.jdField_a_of_type_Basy.e();
    }
    if (this.jdField_b_of_type_Basy != null) {
      this.jdField_b_of_type_Basy.e();
    }
    this.jdField_a_of_type_Bard.a.post(new ForwardSdkShareProcessor.1(this));
  }
  
  public int a()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "cancel");
    super.a();
    if (this.jdField_a_of_type_Basy != null) {
      this.jdField_a_of_type_Basy.e();
    }
    if (this.jdField_b_of_type_Basy != null) {
      this.jdField_b_of_type_Basy.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long, 32768, 9037);
    d(1004);
    return 0;
  }
  
  public void aP_()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "start");
    }
    this.jdField_a_of_type_Basy = new batg(this);
    this.jdField_b_of_type_Basy = new batf(this);
    bath localbath = new bath(this);
    batb localbatb;
    basz localbasz;
    batd localbatd;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 11))
    {
      this.jdField_b_of_type_Basy.a(new basy[] { localbath });
      localbatb = new batb(this);
      localbasz = new basz(this);
      localbatd = new batd(this);
      if ((localbath.a()) || (!localbatd.a())) {
        break label188;
      }
      localbath.a(new basy[] { localbasz, localbatb });
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 11)) {
        break label240;
      }
      this.jdField_b_of_type_Basy.a();
      return;
      this.jdField_a_of_type_Basy.a(new basy[] { localbath });
      break;
      label188:
      localbath.a(new basy[] { localbasz, localbatd });
      this.jdField_a_of_type_Bate = new bate(this);
      localbatd.a(new basy[] { this.jdField_a_of_type_Bate, localbatb });
    }
    label240:
    this.jdField_a_of_type_Basy.a();
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
      aP_();
    }
    return 0;
  }
  
  public int c()
  {
    if (!(this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject instanceof bayq))
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
    if (this.jdField_a_of_type_Bayl == null)
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
      if (this.jdField_a_of_type_Basy != null) {
        this.jdField_a_of_type_Basy.e();
      }
      if (this.jdField_b_of_type_Basy != null) {
        this.jdField_b_of_type_Basy.e();
      }
    }
  }
  
  void d()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.e("Q.share.ForwardSdkShareProcessor", 1, "On Error, code=" + this.j + ", cost=" + l1);
    super.d();
    if (this.jdField_a_of_type_Basy != null) {
      this.jdField_a_of_type_Basy.e();
    }
    if (this.jdField_b_of_type_Basy != null) {
      this.jdField_b_of_type_Basy.e();
    }
    awki localawki = new awki();
    localawki.jdField_a_of_type_Int = -1;
    Object localObject;
    if ((this.jdField_a_of_type_Bayk != null) && (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh != null))
    {
      if ((this.jdField_a_of_type_Int == 11) && (this.j == 9402) && (!ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext)))
      {
        String str1 = (String)this.jdField_b_of_type_JavaUtilHashMap.get("audioUrl");
        String str2 = this.f;
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = this.l;
        }
        localawki.jdField_a_of_type_JavaLangObject = new String[] { str2, localObject };
        localawki.jdField_b_of_type_Int = this.j;
      }
      this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh.b(localawki);
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
      bfhz.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long, 32768, this.j);
      d(1005);
    }
  }
  
  void e()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "OnSuccess, cost=" + l1);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).shareData.status = 1003;
      ((AbsShareMsg)localObject).forwardType = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
    }
    super.e();
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "56");
    ((Bundle)localObject).putString("intext_1", "0");
    ((Bundle)localObject).putString("intext_5", "" + l1);
    bfhz.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basx
 * JD-Core Version:    0.7.0.1
 */