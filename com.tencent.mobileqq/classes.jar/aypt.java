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

public class aypt
  extends aypl
{
  public aypt(ayvx paramayvx, aywc paramaywc)
  {
    super(paramayvx, paramaywc);
  }
  
  public void a(ayyp paramayyp, ayze paramayze)
  {
    super.a(paramayyp, paramayze);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    HashMap localHashMap = new HashMap();
    if (!paramBoolean)
    {
      localHashMap.put("param_FailCode", String.valueOf(this.j));
      localHashMap.put("fail_url", this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
    }
    axrn.a(BaseApplicationImpl.getContext()).a(null, "actC2CSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.k) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void b(ayyp paramayyp, ayze paramayze)
  {
    this.jdField_a_of_type_Ayyp = null;
    if (paramayze != null)
    {
      int i = 0;
      if (i < paramayze.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyp = (ayzg)paramayze.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramayyp.toString());
        }
        this.i = paramayyp.d;
        a(this.jdField_a_of_type_Aypd, paramayyp);
        if (paramayyp.jdField_c_of_type_Int != 0) {
          break label386;
        }
        if (paramayyp.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp.isExist, mResid:" + paramayyp.jdField_a_of_type_JavaLangString + ", mUuid:" + paramayyp.jdField_b_of_type_JavaLangString + ", fileSize:" + this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long);
          }
          this.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_Ayqo.e = this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long;
          ayqo localayqo = this.jdField_a_of_type_Ayqo;
          String str = paramayyp.jdField_a_of_type_JavaLangString;
          localayqo.g = str;
          this.jdField_f_of_type_JavaLangString = str;
          localayqo = this.jdField_a_of_type_Ayqo;
          paramayyp = paramayyp.jdField_b_of_type_JavaLangString;
          localayqo.h = paramayyp;
          this.jdField_l_of_type_JavaLangString = paramayyp;
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
        d("<BDH_LOG> onBusiProtoResp() picUpResp exist: " + paramayyp.jdField_a_of_type_Boolean + " ,select HTTP channel");
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
      d("<BDH_LOG> onBusiProtoResp() picUpResp error : " + paramayyp.jdField_c_of_type_Int + " ,select HTTP channel");
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
    if ((localObject != null) && (((aywc)localObject).h))
    {
      if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject instanceof aywg))) {
        this.jdField_l_of_type_Boolean = ((aywg)this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
      }
      return 0;
    }
    b("uiParam", this.jdField_a_of_type_Aywc.toString());
    if (TextUtils.isEmpty(this.jdField_a_of_type_Aywc.jdField_f_of_type_JavaLangString))
    {
      b(9042, a(new Exception("qzonePic md5 null!")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl)) || (TextUtils.isEmpty(this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5)))
    {
      b(9302, a(new Exception("qzonePic param_check error!")));
      d();
      return -1;
    }
    localObject = this.jdField_a_of_type_Ayqo;
    long l = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize;
    ((ayqo)localObject).jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    if (this.jdField_q_of_type_Long <= 0L)
    {
      b(9071, a(new Exception("qzonePic file size 0 ")));
      d();
      return -1;
    }
    if (this.jdField_q_of_type_Long >= ayxe.a())
    {
      b(9063, a(new Exception("qzonePic file size TooBig! ")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject instanceof aywg))) {
      this.jdField_l_of_type_Boolean = ((aywg)this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    }
    return 0;
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Aypd.a();
    ayyp localayyp = new ayyp();
    ayyy localayyy = new ayyy();
    localayyy.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString;
    localayyy.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString;
    localayyy.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_d_of_type_JavaLangString;
    localayyy.f = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
    localayyy.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localayyy.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localayyy.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localayyy.jdField_c_of_type_Int = this.p;
    localayyy.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    boolean bool;
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Int == 1006)
    {
      bool = true;
      localayyy.jdField_c_of_type_Boolean = bool;
      localayyy.jdField_b_of_type_Boolean = this.jdField_l_of_type_Boolean;
      localayyy.jdField_e_of_type_Int = 3;
      localayyy.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl;
      localayyp.jdField_a_of_type_Ayzw = this;
      localayyp.jdField_a_of_type_JavaLangString = "c2c_pic_up";
      localayyp.jdField_a_of_type_JavaUtilList.add(localayyy);
      localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      MessageRecord localMessageRecord = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localMessageRecord))
      {
        localayyy.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
        this.u = ((MessageForPic)localMessageRecord).imageType;
      }
      if (e()) {
        break label264;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypd);
      d();
    }
    label264:
    do
    {
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        b("requestStart", localayyp.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Ayyp = localayyp;
    ayzv.a(localayyp);
  }
  
  protected void r()
  {
    d(1000);
    this.jdField_a_of_type_Ayqo.a();
    d(1001);
    aywc localaywc = a();
    if ((localaywc != null) && (localaywc.h))
    {
      this.p = localaywc.l;
      this.jdField_q_of_type_Int = localaywc.m;
      this.jdField_q_of_type_Long = localaywc.e;
      this.jdField_a_of_type_ArrayOfByte = bbea.a(localaywc.jdField_f_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = localaywc.jdField_f_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Ayqo.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
      return;
    }
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams != null)
    {
      this.p = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
      this.jdField_q_of_type_Int = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
      this.jdField_a_of_type_ArrayOfByte = bbea.a(this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5);
      this.jdField_d_of_type_JavaLangString = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Ayqo.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
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
        aP_();
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
 * Qualified Name:     aypt
 * JD-Core Version:    0.7.0.1
 */