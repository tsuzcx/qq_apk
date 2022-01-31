import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class axpk
  extends axpc
{
  public axpk(axvo paramaxvo, axvt paramaxvt)
  {
    super(paramaxvo, paramaxvt);
  }
  
  public void a(axyg paramaxyg, axyv paramaxyv)
  {
    super.a(paramaxyg, paramaxyv);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    HashMap localHashMap = new HashMap();
    if (!paramBoolean)
    {
      localHashMap.put("param_FailCode", String.valueOf(this.j));
      localHashMap.put("fail_url", this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
    }
    awrn.a(BaseApplicationImpl.getContext()).a(null, "actC2CSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void b(axyg paramaxyg, axyv paramaxyv)
  {
    this.jdField_a_of_type_Axyg = null;
    if (paramaxyv != null)
    {
      int i = 0;
      if (i < paramaxyv.jdField_a_of_type_JavaUtilList.size())
      {
        paramaxyg = (axyx)paramaxyv.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramaxyg.toString());
        }
        this.i = paramaxyg.d;
        a(this.jdField_a_of_type_Axow, paramaxyg);
        if (paramaxyg.jdField_c_of_type_Int != 0) {
          break label386;
        }
        if (paramaxyg.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp.isExist, mResid:" + paramaxyg.jdField_a_of_type_JavaLangString + ", mUuid:" + paramaxyg.jdField_b_of_type_JavaLangString + ", fileSize:" + this.jdField_a_of_type_Axqf.jdField_a_of_type_Long);
          }
          this.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_Axqf.e = this.jdField_a_of_type_Axqf.jdField_a_of_type_Long;
          axqf localaxqf = this.jdField_a_of_type_Axqf;
          String str = paramaxyg.jdField_a_of_type_JavaLangString;
          localaxqf.g = str;
          this.jdField_f_of_type_JavaLangString = str;
          localaxqf = this.jdField_a_of_type_Axqf;
          paramaxyg = paramaxyg.jdField_b_of_type_JavaLangString;
          localaxqf.h = paramaxyg;
          this.jdField_k_of_type_JavaLangString = paramaxyg;
          if ((this.jdField_a_of_type_Boolean) && (this.b != null)) {
            if ((!this.b.isFinish.get()) || (!this.b.isSuccess.get()))
            {
              this.b.cancelTransaction();
              t();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            t();
          }
        }
        d("<BDH_LOG> onBusiProtoResp() picUpResp exist: " + paramaxyg.jdField_a_of_type_Boolean + " ,select HTTP channel");
        this.w = 2;
        if ((!this.jdField_a_of_type_Boolean) || (this.b == null) || (!this.b.isFinish.get()) || (!this.b.isSuccess.get()))
        {
          if ((this.jdField_a_of_type_Boolean) && (this.b != null)) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().cancelTransactionTask(this.b);
          }
          d();
        }
      }
    }
    label386:
    do
    {
      return;
      d("<BDH_LOG> onBusiProtoResp() picUpResp error : " + paramaxyg.jdField_c_of_type_Int + " ,select HTTP channel");
      this.w = 2;
    } while ((this.jdField_a_of_type_Boolean) && (this.b != null) && (this.b.isFinish.get()) && (this.b.isSuccess.get()));
    if ((this.jdField_a_of_type_Boolean) && (this.b != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().cancelTransactionTask(this.b);
    }
    d();
  }
  
  public int c()
  {
    Object localObject = a();
    if ((localObject != null) && (((axvt)localObject).h))
    {
      if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject instanceof axvx))) {
        this.l = ((axvx)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
      }
      return 0;
    }
    b("uiParam", this.jdField_a_of_type_Axvt.toString());
    if (TextUtils.isEmpty(this.jdField_a_of_type_Axvt.jdField_f_of_type_JavaLangString))
    {
      b(9042, a(new Exception("qzonePic md5 null!")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl)) || (TextUtils.isEmpty(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5)))
    {
      b(9302, a(new Exception("qzonePic param_check error!")));
      d();
      return -1;
    }
    localObject = this.jdField_a_of_type_Axqf;
    long l = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize;
    ((axqf)localObject).jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    if (this.jdField_q_of_type_Long <= 0L)
    {
      b(9071, a(new Exception("qzonePic file size 0 ")));
      d();
      return -1;
    }
    if (this.jdField_q_of_type_Long >= axwv.a())
    {
      b(9063, a(new Exception("qzonePic file size TooBig! ")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject instanceof axvx))) {
      this.l = ((axvx)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    }
    return 0;
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Axow.a();
    axyg localaxyg = new axyg();
    axyp localaxyp = new axyp();
    localaxyp.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_b_of_type_JavaLangString;
    localaxyp.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString;
    localaxyp.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_d_of_type_JavaLangString;
    localaxyp.f = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
    localaxyp.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localaxyp.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localaxyp.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localaxyp.jdField_c_of_type_Int = this.p;
    localaxyp.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    boolean bool;
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Int == 1006)
    {
      bool = true;
      localaxyp.jdField_c_of_type_Boolean = bool;
      localaxyp.jdField_b_of_type_Boolean = this.l;
      localaxyp.jdField_e_of_type_Int = 3;
      localaxyp.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl;
      localaxyg.jdField_a_of_type_Axzn = this;
      localaxyg.jdField_a_of_type_JavaLangString = "c2c_pic_up";
      localaxyg.jdField_a_of_type_JavaUtilList.add(localaxyp);
      localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      MessageRecord localMessageRecord = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localMessageRecord))
      {
        localaxyp.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
        this.u = ((MessageForPic)localMessageRecord).imageType;
      }
      if (e()) {
        break label264;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Axow);
      d();
    }
    label264:
    do
    {
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        b("requestStart", localaxyg.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Axyg = localaxyg;
    axzm.a(localaxyg);
  }
  
  protected void r()
  {
    d(1000);
    this.jdField_a_of_type_Axqf.a();
    d(1001);
    axvt localaxvt = a();
    if ((localaxvt != null) && (localaxvt.h))
    {
      this.p = localaxvt.l;
      this.jdField_q_of_type_Int = localaxvt.m;
      this.jdField_q_of_type_Long = localaxvt.e;
      this.jdField_a_of_type_ArrayOfByte = bach.a(localaxvt.jdField_f_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = localaxvt.jdField_f_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Axqf.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
      return;
    }
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams != null)
    {
      this.p = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
      this.jdField_q_of_type_Int = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
      this.jdField_a_of_type_ArrayOfByte = bach.a(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5);
      this.jdField_d_of_type_JavaLangString = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Axqf.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_e_of_type_JavaLangString = "jpg";
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mIsOpenUpEnable: " + this.jdField_a_of_type_Boolean);
      }
      this.jdField_d_of_type_ArrayOfByte = a();
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead = a();
      this.jdField_e_of_type_ArrayOfByte = b();
      if ((this.jdField_d_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mOpenUpTicket: " + this.jdField_d_of_type_ArrayOfByte + " mLoginSigHead:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead);
        }
        f();
        aS_();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> set mIsOpenUpEnable false");
      }
      this.jdField_a_of_type_Boolean = false;
      f();
      return;
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axpk
 * JD-Core Version:    0.7.0.1
 */