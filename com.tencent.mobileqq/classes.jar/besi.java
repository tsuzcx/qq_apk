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

public class besi
  extends besa
{
  public besi(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
  }
  
  public void a(bfau parambfau, bfbj parambfbj)
  {
    super.a(parambfau, parambfbj);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    HashMap localHashMap = new HashMap();
    if (!paramBoolean)
    {
      localHashMap.put("param_FailCode", String.valueOf(this.jdField_k_of_type_Int));
      localHashMap.put("fail_url", this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
    }
    bdmc.a(BaseApplicationImpl.getContext()).a(null, "actC2CSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void b(bfau parambfau, bfbj parambfbj)
  {
    this.jdField_a_of_type_Bfau = null;
    if (parambfbj != null)
    {
      int i = 0;
      if (i < parambfbj.jdField_a_of_type_JavaUtilList.size())
      {
        parambfau = (bfbl)parambfbj.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambfau.toString());
        }
        this.jdField_k_of_type_Boolean = parambfau.d;
        a(this.jdField_a_of_type_Berr, parambfau);
        if (parambfau.jdField_c_of_type_Int != 0) {
          break label386;
        }
        if (parambfau.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp.isExist, mResid:" + parambfau.jdField_a_of_type_JavaLangString + ", mUuid:" + parambfau.jdField_b_of_type_JavaLangString + ", fileSize:" + this.jdField_a_of_type_Bete.jdField_a_of_type_Long);
          }
          this.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_Bete.e = this.jdField_a_of_type_Bete.jdField_a_of_type_Long;
          bete localbete = this.jdField_a_of_type_Bete;
          String str = parambfau.jdField_a_of_type_JavaLangString;
          localbete.g = str;
          this.jdField_f_of_type_JavaLangString = str;
          localbete = this.jdField_a_of_type_Bete;
          parambfau = parambfau.jdField_b_of_type_JavaLangString;
          localbete.h = parambfau;
          this.l = parambfau;
          if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)) {
            if ((!this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isFinish.get()) || (!this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get()))
            {
              this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
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
        d("<BDH_LOG> onBusiProtoResp() picUpResp exist: " + parambfau.jdField_a_of_type_Boolean + " ,select HTTP channel");
        this.w = 2;
        if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction == null) || (!this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isFinish.get()) || (!this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get()))
        {
          if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().cancelTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
          }
          d();
        }
      }
    }
    label386:
    do
    {
      return;
      d("<BDH_LOG> onBusiProtoResp() picUpResp error : " + parambfau.jdField_c_of_type_Int + " ,select HTTP channel");
      this.w = 2;
    } while ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isFinish.get()) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get()));
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().cancelTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
    d();
  }
  
  public int c()
  {
    Object localObject = a();
    if ((localObject != null) && (((beyg)localObject).i))
    {
      if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject instanceof beyk))) {
        this.n = ((beyk)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
      }
      return 0;
    }
    b("uiParam", this.jdField_a_of_type_Beyg.toString());
    if (TextUtils.isEmpty(this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString))
    {
      b(9042, a(new Exception("qzonePic md5 null!")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl)) || (TextUtils.isEmpty(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5)))
    {
      b(9302, a(new Exception("qzonePic param_check error!")));
      d();
      return -1;
    }
    localObject = this.jdField_a_of_type_Bete;
    long l = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize;
    ((bete)localObject).jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    if (this.jdField_q_of_type_Long <= 0L)
    {
      b(9071, a(new Exception("qzonePic file size 0 ")));
      d();
      return -1;
    }
    if (this.jdField_q_of_type_Long >= bezh.a())
    {
      b(9063, a(new Exception("qzonePic file size TooBig! ")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject instanceof beyk))) {
      this.n = ((beyk)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    }
    return 0;
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Berr.a();
    bfau localbfau = new bfau();
    bfbd localbfbd = new bfbd();
    localbfbd.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString;
    localbfbd.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfbd.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_d_of_type_JavaLangString;
    localbfbd.f = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbfbd.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbfbd.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbfbd.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    localbfbd.jdField_c_of_type_Int = this.jdField_d_of_type_Int;
    localbfbd.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    boolean bool;
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 1006)
    {
      bool = true;
      localbfbd.jdField_c_of_type_Boolean = bool;
      localbfbd.jdField_b_of_type_Boolean = this.n;
      localbfbd.jdField_e_of_type_Int = 3;
      localbfbd.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl;
      localbfau.jdField_a_of_type_Bfcb = this;
      localbfau.jdField_a_of_type_JavaLangString = "c2c_pic_up";
      localbfau.jdField_a_of_type_JavaUtilList.add(localbfbd);
      localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      MessageRecord localMessageRecord = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localMessageRecord))
      {
        localbfbd.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
        this.u = ((MessageForPic)localMessageRecord).imageType;
      }
      if (e()) {
        break label264;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
      d();
    }
    label264:
    do
    {
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        b("requestStart", localbfau.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bfau = localbfau;
    bfca.a(localbfau);
  }
  
  protected void r()
  {
    d(1000);
    this.jdField_a_of_type_Bete.a();
    d(1001);
    beyg localbeyg = a();
    if ((localbeyg != null) && (localbeyg.i))
    {
      this.jdField_d_of_type_Int = localbeyg.l;
      this.jdField_q_of_type_Int = localbeyg.m;
      this.jdField_q_of_type_Long = localbeyg.e;
      this.jdField_b_of_type_ArrayOfByte = bhml.a(localbeyg.jdField_f_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = localbeyg.jdField_f_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Bete.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
      return;
    }
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams != null)
    {
      this.jdField_d_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
      this.jdField_q_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
      this.jdField_b_of_type_ArrayOfByte = bhml.a(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5);
      this.jdField_d_of_type_JavaLangString = HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte);
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Bete.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_e_of_type_JavaLangString = "jpg";
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mIsOpenUpEnable: " + this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_ArrayOfByte = a();
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead = a();
      this.jdField_e_of_type_ArrayOfByte = b();
      if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mOpenUpTicket: " + this.jdField_a_of_type_ArrayOfByte + " mLoginSigHead:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead);
        }
        f();
        aL_();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besi
 * JD-Core Version:    0.7.0.1
 */