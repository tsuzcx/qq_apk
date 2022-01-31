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

public class bano
  extends bang
{
  public bano(batw parambatw, baub parambaub)
  {
    super(parambatw, parambaub);
  }
  
  public void a(bawo parambawo, baxd parambaxd)
  {
    super.a(parambawo, parambaxd);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    HashMap localHashMap = new HashMap();
    if (!paramBoolean)
    {
      localHashMap.put("param_FailCode", String.valueOf(this.j));
      localHashMap.put("fail_url", this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
    }
    azmz.a(BaseApplicationImpl.getContext()).a(null, "actC2CSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.k) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void b(bawo parambawo, baxd parambaxd)
  {
    this.jdField_a_of_type_Bawo = null;
    if (parambaxd != null)
    {
      int i = 0;
      if (i < parambaxd.jdField_a_of_type_JavaUtilList.size())
      {
        parambawo = (baxf)parambaxd.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambawo.toString());
        }
        this.i = parambawo.d;
        a(this.jdField_a_of_type_Bamy, parambawo);
        if (parambawo.jdField_c_of_type_Int != 0) {
          break label386;
        }
        if (parambawo.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp.isExist, mResid:" + parambawo.jdField_a_of_type_JavaLangString + ", mUuid:" + parambawo.jdField_b_of_type_JavaLangString + ", fileSize:" + this.jdField_a_of_type_Baoj.jdField_a_of_type_Long);
          }
          this.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_Baoj.e = this.jdField_a_of_type_Baoj.jdField_a_of_type_Long;
          baoj localbaoj = this.jdField_a_of_type_Baoj;
          String str = parambawo.jdField_a_of_type_JavaLangString;
          localbaoj.g = str;
          this.jdField_f_of_type_JavaLangString = str;
          localbaoj = this.jdField_a_of_type_Baoj;
          parambawo = parambawo.jdField_b_of_type_JavaLangString;
          localbaoj.h = parambawo;
          this.jdField_l_of_type_JavaLangString = parambawo;
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
        d("<BDH_LOG> onBusiProtoResp() picUpResp exist: " + parambawo.jdField_a_of_type_Boolean + " ,select HTTP channel");
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
      d("<BDH_LOG> onBusiProtoResp() picUpResp error : " + parambawo.jdField_c_of_type_Int + " ,select HTTP channel");
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
    if ((localObject != null) && (((baub)localObject).h))
    {
      if ((this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject instanceof bauf))) {
        this.jdField_l_of_type_Boolean = ((bauf)this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
      }
      return 0;
    }
    b("uiParam", this.jdField_a_of_type_Baub.toString());
    if (TextUtils.isEmpty(this.jdField_a_of_type_Baub.jdField_f_of_type_JavaLangString))
    {
      b(9042, a(new Exception("qzonePic md5 null!")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl)) || (TextUtils.isEmpty(this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5)))
    {
      b(9302, a(new Exception("qzonePic param_check error!")));
      d();
      return -1;
    }
    localObject = this.jdField_a_of_type_Baoj;
    long l = this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize;
    ((baoj)localObject).jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    if (this.jdField_q_of_type_Long <= 0L)
    {
      b(9071, a(new Exception("qzonePic file size 0 ")));
      d();
      return -1;
    }
    if (this.jdField_q_of_type_Long >= bavd.a())
    {
      b(9063, a(new Exception("qzonePic file size TooBig! ")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject instanceof bauf))) {
      this.jdField_l_of_type_Boolean = ((bauf)this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    }
    return 0;
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Bamy.a();
    bawo localbawo = new bawo();
    bawx localbawx = new bawx();
    localbawx.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_b_of_type_JavaLangString;
    localbawx.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_c_of_type_JavaLangString;
    localbawx.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_d_of_type_JavaLangString;
    localbawx.f = this.jdField_a_of_type_Baub.jdField_a_of_type_Int;
    localbawx.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbawx.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbawx.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localbawx.jdField_c_of_type_Int = this.p;
    localbawx.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    boolean bool;
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Int == 1006)
    {
      bool = true;
      localbawx.jdField_c_of_type_Boolean = bool;
      localbawx.jdField_b_of_type_Boolean = this.jdField_l_of_type_Boolean;
      localbawx.jdField_e_of_type_Int = 3;
      localbawx.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl;
      localbawo.jdField_a_of_type_Baxv = this;
      localbawo.jdField_a_of_type_JavaLangString = "c2c_pic_up";
      localbawo.jdField_a_of_type_JavaUtilList.add(localbawx);
      localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      MessageRecord localMessageRecord = this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localMessageRecord))
      {
        localbawx.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
        this.u = ((MessageForPic)localMessageRecord).imageType;
      }
      if (e()) {
        break label264;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Bamy);
      d();
    }
    label264:
    do
    {
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        b("requestStart", localbawo.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bawo = localbawo;
    baxu.a(localbawo);
  }
  
  protected void r()
  {
    d(1000);
    this.jdField_a_of_type_Baoj.a();
    d(1001);
    baub localbaub = a();
    if ((localbaub != null) && (localbaub.h))
    {
      this.p = localbaub.l;
      this.jdField_q_of_type_Int = localbaub.m;
      this.jdField_q_of_type_Long = localbaub.e;
      this.jdField_a_of_type_ArrayOfByte = bdcv.a(localbaub.jdField_f_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = localbaub.jdField_f_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Baoj.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
      return;
    }
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams != null)
    {
      this.p = this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
      this.jdField_q_of_type_Int = this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
      this.jdField_a_of_type_ArrayOfByte = bdcv.a(this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5);
      this.jdField_d_of_type_JavaLangString = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Baoj.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
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
        aQ_();
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
 * Qualified Name:     bano
 * JD-Core Version:    0.7.0.1
 */