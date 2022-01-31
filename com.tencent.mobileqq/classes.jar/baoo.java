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

public class baoo
  extends bamw
  implements arvd
{
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  private baop jdField_a_of_type_Baop;
  private baov jdField_a_of_type_Baov;
  private bauc jdField_a_of_type_Bauc;
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private baop jdField_b_of_type_Baop;
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
  
  public baoo(bamu parambamu, baub parambaub)
  {
    super(parambamu, parambaub);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext();
    if ((this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject instanceof bauh))
    {
      parambamu = (bauh)this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Int = parambamu.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = parambamu.jdField_b_of_type_Int;
      this.jdField_b_of_type_JavaLangString = parambamu.jdField_b_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = parambamu.jdField_c_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = parambamu.jdField_d_of_type_JavaLangString;
      this.l = parambamu.f;
      this.jdField_b_of_type_Long = parambamu.jdField_a_of_type_Long;
      this.jdField_a_of_type_JavaLangString = parambamu.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bauc = parambamu.jdField_a_of_type_Bauc;
      if (parambamu.jdField_c_of_type_Int != 2) {
        break label320;
      }
      this.e = parambamu.e;
      QLog.i("BaseTransProcessor", 1, "forwardShare info.imageUrlStatus =" + parambamu.jdField_c_of_type_Int + ",mRemoteImgUrl=" + this.f);
      parambaub = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if ((parambamu.jdField_c_of_type_Int != 1) && (parambamu.jdField_c_of_type_Int != 3)) {
        break label331;
      }
      bool1 = true;
      label266:
      parambaub.set(bool1);
      parambaub = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (parambamu.jdField_c_of_type_Int != 1) {
        break label336;
      }
      bool1 = true;
      label286:
      parambaub.set(bool1);
      parambaub = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (parambamu.jdField_d_of_type_Int != 1) {
        break label341;
      }
    }
    label320:
    label331:
    label336:
    label341:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      parambaub.set(bool1);
      this.jdField_a_of_type_Boolean = arzk.a();
      return;
      this.f = parambamu.e;
      break;
      bool1 = false;
      break label266;
      bool1 = false;
      break label286;
    }
  }
  
  public static baub a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    bauh localbauh = new bauh();
    localbauh.jdField_a_of_type_Int = paramAbsShareMsg.forwardType;
    localbauh.jdField_b_of_type_Int = paramAbsShareMsg.mMsgServiceID;
    localbauh.jdField_a_of_type_Long = paramAbsShareMsg.mSourceAppid;
    localbauh.jdField_a_of_type_JavaLangString = paramAbsShareMsg.shareData.pkgName;
    localbauh.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mMsgUrl;
    localbauh.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mContentTitle;
    localbauh.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mContentSummary;
    localbauh.e = paramAbsShareMsg.mContentCover;
    localbauh.f = paramAbsShareMsg.mContentSrc;
    localbauh.jdField_c_of_type_Int = paramAbsShareMsg.shareData.imageUrlStatus;
    localbauh.jdField_d_of_type_Int = paramAbsShareMsg.shareData.shortUrlStatus;
    localbauh.jdField_a_of_type_Bauc = new bauc();
    localbauh.jdField_a_of_type_Bauc.jdField_b_of_type_JavaLangString = paramAbsShareMsg.mSourceName;
    localbauh.jdField_a_of_type_Bauc.jdField_d_of_type_JavaLangString = paramAbsShareMsg.mSourceIcon;
    localbauh.jdField_a_of_type_Bauc.e = paramAbsShareMsg.shareData.sourceIconBig;
    localbauh.jdField_a_of_type_Bauc.jdField_c_of_type_JavaLangString = paramAbsShareMsg.mSourceUrl;
    localbauh.jdField_a_of_type_Bauc.jdField_a_of_type_JavaLangString = paramAbsShareMsg.mSource_A_ActionData;
    localbauh.jdField_a_of_type_Bauc.jdField_a_of_type_Int = paramAbsShareMsg.shareData.appInfoStatus;
    paramAbsShareMsg = new baub();
    paramAbsShareMsg.jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
    paramAbsShareMsg.jdField_c_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramAbsShareMsg.jdField_a_of_type_Int = paramMessageRecord.istroop;
    paramAbsShareMsg.jdField_b_of_type_Int = 52;
    paramAbsShareMsg.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramAbsShareMsg.jdField_a_of_type_Boolean = true;
    paramAbsShareMsg.jdField_e_of_type_Int = 11;
    paramAbsShareMsg.jdField_e_of_type_Boolean = false;
    paramAbsShareMsg.jdField_a_of_type_JavaLangObject = localbauh;
    return paramAbsShareMsg;
  }
  
  public static baub a(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg, awfy paramawfy)
  {
    paramMessageRecord = a(paramMessageRecord, paramAbsShareMsg);
    paramMessageRecord.jdField_a_of_type_Awfy = paramawfy;
    return paramMessageRecord;
  }
  
  private void f()
  {
    if (this.o) {
      return;
    }
    if (this.jdField_a_of_type_Baop != null) {
      this.jdField_a_of_type_Baop.e();
    }
    if (this.jdField_b_of_type_Baop != null) {
      this.jdField_b_of_type_Baop.e();
    }
    this.jdField_a_of_type_Bamu.a.post(new ForwardSdkShareProcessor.1(this));
  }
  
  public int a()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "cancel");
    super.a();
    if (this.jdField_a_of_type_Baop != null) {
      this.jdField_a_of_type_Baop.e();
    }
    if (this.jdField_b_of_type_Baop != null) {
      this.jdField_b_of_type_Baop.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Long, 32768, 9037);
    d(1004);
    return 0;
  }
  
  public void aS_()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.share.ForwardSdkShareProcessor", 2, "start");
    }
    this.jdField_a_of_type_Baop = new baox(this);
    this.jdField_b_of_type_Baop = new baow(this);
    baoy localbaoy = new baoy(this);
    baos localbaos;
    baoq localbaoq;
    baou localbaou;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 11))
    {
      this.jdField_b_of_type_Baop.a(new baop[] { localbaoy });
      localbaos = new baos(this);
      localbaoq = new baoq(this);
      localbaou = new baou(this);
      if ((localbaoy.a()) || (!localbaou.a())) {
        break label188;
      }
      localbaoy.a(new baop[] { localbaoq, localbaos });
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 11)) {
        break label240;
      }
      this.jdField_b_of_type_Baop.a();
      return;
      this.jdField_a_of_type_Baop.a(new baop[] { localbaoy });
      break;
      label188:
      localbaoy.a(new baop[] { localbaoq, localbaou });
      this.jdField_a_of_type_Baov = new baov(this);
      localbaou.a(new baop[] { this.jdField_a_of_type_Baov, localbaos });
    }
    label240:
    this.jdField_a_of_type_Baop.a();
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
      aS_();
    }
    return 0;
  }
  
  public int c()
  {
    if (!(this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject instanceof bauh))
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
    if (this.jdField_a_of_type_Bauc == null)
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
      if (this.jdField_a_of_type_Baop != null) {
        this.jdField_a_of_type_Baop.e();
      }
      if (this.jdField_b_of_type_Baop != null) {
        this.jdField_b_of_type_Baop.e();
      }
    }
  }
  
  void d()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.e("Q.share.ForwardSdkShareProcessor", 1, "On Error, code=" + this.j + ", cost=" + l1);
    super.d();
    if (this.jdField_a_of_type_Baop != null) {
      this.jdField_a_of_type_Baop.e();
    }
    if (this.jdField_b_of_type_Baop != null) {
      this.jdField_b_of_type_Baop.e();
    }
    awfz localawfz = new awfz();
    localawfz.jdField_a_of_type_Int = -1;
    Object localObject;
    if ((this.jdField_a_of_type_Baub != null) && (this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy != null))
    {
      if ((this.jdField_a_of_type_Int == 11) && (this.j == 9402) && (!ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext)))
      {
        String str1 = (String)this.jdField_b_of_type_JavaUtilHashMap.get("audioUrl");
        String str2 = this.f;
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = this.l;
        }
        localawfz.jdField_a_of_type_JavaLangObject = new String[] { str2, localObject };
        localawfz.jdField_b_of_type_Int = this.j;
      }
      this.jdField_a_of_type_Baub.jdField_a_of_type_Awfy.b(localawfz);
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
      bfdq.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Long, 32768, this.j);
      d(1005);
    }
  }
  
  void e()
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "OnSuccess, cost=" + l1);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Long);
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).shareData.status = 1003;
      ((AbsShareMsg)localObject).forwardType = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baub.jdField_a_of_type_Int, this.jdField_a_of_type_Baub.jdField_a_of_type_Long, ((AbsShareMsg)localObject).getBytes());
    }
    super.e();
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "56");
    ((Bundle)localObject).putString("intext_1", "0");
    ((Bundle)localObject).putString("intext_5", "" + l1);
    bfdq.a().a((Bundle)localObject, "" + this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baoo
 * JD-Core Version:    0.7.0.1
 */