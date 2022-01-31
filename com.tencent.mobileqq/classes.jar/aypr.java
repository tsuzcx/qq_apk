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

public class aypr
  extends aypj
{
  public aypr(ayvv paramayvv, aywa paramaywa)
  {
    super(paramayvv, paramaywa);
  }
  
  public void a(ayyn paramayyn, ayzc paramayzc)
  {
    super.a(paramayyn, paramayzc);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    HashMap localHashMap = new HashMap();
    if (!paramBoolean)
    {
      localHashMap.put("param_FailCode", String.valueOf(this.j));
      localHashMap.put("fail_url", this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
    }
    axrl.a(BaseApplicationImpl.getContext()).a(null, "actC2CSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.k) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void b(ayyn paramayyn, ayzc paramayzc)
  {
    this.jdField_a_of_type_Ayyn = null;
    if (paramayzc != null)
    {
      int i = 0;
      if (i < paramayzc.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyn = (ayze)paramayzc.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramayyn.toString());
        }
        this.i = paramayyn.d;
        a(this.jdField_a_of_type_Aypb, paramayyn);
        if (paramayyn.jdField_c_of_type_Int != 0) {
          break label386;
        }
        if (paramayyn.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp.isExist, mResid:" + paramayyn.jdField_a_of_type_JavaLangString + ", mUuid:" + paramayyn.jdField_b_of_type_JavaLangString + ", fileSize:" + this.jdField_a_of_type_Ayqm.jdField_a_of_type_Long);
          }
          this.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_Ayqm.e = this.jdField_a_of_type_Ayqm.jdField_a_of_type_Long;
          ayqm localayqm = this.jdField_a_of_type_Ayqm;
          String str = paramayyn.jdField_a_of_type_JavaLangString;
          localayqm.g = str;
          this.jdField_f_of_type_JavaLangString = str;
          localayqm = this.jdField_a_of_type_Ayqm;
          paramayyn = paramayyn.jdField_b_of_type_JavaLangString;
          localayqm.h = paramayyn;
          this.jdField_l_of_type_JavaLangString = paramayyn;
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
        d("<BDH_LOG> onBusiProtoResp() picUpResp exist: " + paramayyn.jdField_a_of_type_Boolean + " ,select HTTP channel");
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
      d("<BDH_LOG> onBusiProtoResp() picUpResp error : " + paramayyn.jdField_c_of_type_Int + " ,select HTTP channel");
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
    if ((localObject != null) && (((aywa)localObject).h))
    {
      if ((this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject instanceof aywe))) {
        this.jdField_l_of_type_Boolean = ((aywe)this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
      }
      return 0;
    }
    b("uiParam", this.jdField_a_of_type_Aywa.toString());
    if (TextUtils.isEmpty(this.jdField_a_of_type_Aywa.jdField_f_of_type_JavaLangString))
    {
      b(9042, a(new Exception("qzonePic md5 null!")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl)) || (TextUtils.isEmpty(this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5)))
    {
      b(9302, a(new Exception("qzonePic param_check error!")));
      d();
      return -1;
    }
    localObject = this.jdField_a_of_type_Ayqm;
    long l = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize;
    ((ayqm)localObject).jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    if (this.jdField_q_of_type_Long <= 0L)
    {
      b(9071, a(new Exception("qzonePic file size 0 ")));
      d();
      return -1;
    }
    if (this.jdField_q_of_type_Long >= ayxc.a())
    {
      b(9063, a(new Exception("qzonePic file size TooBig! ")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject instanceof aywe))) {
      this.jdField_l_of_type_Boolean = ((aywe)this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    }
    return 0;
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Aypb.a();
    ayyn localayyn = new ayyn();
    ayyw localayyw = new ayyw();
    localayyw.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_b_of_type_JavaLangString;
    localayyw.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString;
    localayyw.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_d_of_type_JavaLangString;
    localayyw.f = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
    localayyw.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localayyw.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localayyw.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localayyw.jdField_c_of_type_Int = this.p;
    localayyw.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    boolean bool;
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Int == 1006)
    {
      bool = true;
      localayyw.jdField_c_of_type_Boolean = bool;
      localayyw.jdField_b_of_type_Boolean = this.jdField_l_of_type_Boolean;
      localayyw.jdField_e_of_type_Int = 3;
      localayyw.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl;
      localayyn.jdField_a_of_type_Ayzu = this;
      localayyn.jdField_a_of_type_JavaLangString = "c2c_pic_up";
      localayyn.jdField_a_of_type_JavaUtilList.add(localayyw);
      localayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      MessageRecord localMessageRecord = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localMessageRecord))
      {
        localayyw.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
        this.u = ((MessageForPic)localMessageRecord).imageType;
      }
      if (e()) {
        break label264;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypb);
      d();
    }
    label264:
    do
    {
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        b("requestStart", localayyn.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Ayyn = localayyn;
    ayzt.a(localayyn);
  }
  
  protected void r()
  {
    d(1000);
    this.jdField_a_of_type_Ayqm.a();
    d(1001);
    aywa localaywa = a();
    if ((localaywa != null) && (localaywa.h))
    {
      this.p = localaywa.l;
      this.jdField_q_of_type_Int = localaywa.m;
      this.jdField_q_of_type_Long = localaywa.e;
      this.jdField_a_of_type_ArrayOfByte = bbdm.a(localaywa.jdField_f_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = localaywa.jdField_f_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Ayqm.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
      return;
    }
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams != null)
    {
      this.p = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
      this.jdField_q_of_type_Int = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
      this.jdField_a_of_type_ArrayOfByte = bbdm.a(this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5);
      this.jdField_d_of_type_JavaLangString = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Ayqm.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
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
 * Qualified Name:     aypr
 * JD-Core Version:    0.7.0.1
 */