import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class beud
  extends betv
{
  public beud(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
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
    bdmc.a(BaseApplicationImpl.getContext()).a(null, "actGroupSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void b(bfau parambfau, bfbj parambfbj)
  {
    this.jdField_a_of_type_Bfau = null;
    if (parambfbj != null)
    {
      int i = 0;
      while (i < parambfbj.jdField_a_of_type_JavaUtilList.size())
      {
        parambfau = (bfbw)parambfbj.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambfau.toString());
        }
        this.jdField_k_of_type_Boolean = parambfau.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_k_of_type_Boolean);
        }
        a(this.jdField_a_of_type_Berr, parambfau);
        if ((parambfau instanceof bfbo))
        {
          parambfau = (bfbo)parambfau;
          if (parambfau.c != 0) {
            break label267;
          }
          if (parambfau.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp GroupPicUpResp.isExist, mFileID:" + parambfau.jdField_a_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Bete.jdField_a_of_type_Long);
            }
            this.f = true;
            this.jdField_a_of_type_Bete.jdField_e_of_type_Long = this.jdField_a_of_type_Bete.jdField_a_of_type_Long;
            this.jdField_a_of_type_Long = parambfau.jdField_a_of_type_Long;
            this.jdField_a_of_type_JavaUtilArrayList = parambfau.jdField_a_of_type_JavaUtilArrayList;
            s();
          }
        }
        else
        {
          i += 1;
          continue;
        }
        d("<BDH_LOG> onBusiProtoResp() picUpResp exist : " + parambfau.jdField_a_of_type_Boolean + " ,select HTTP channel");
        this.w = 2;
        d();
      }
    }
    return;
    label267:
    d("<BDH_LOG> onBusiProtoResp() picUpResp error : " + parambfau.c + " ,select HTTP channel");
    this.w = 2;
    d();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Berr.a();
    bfau localbfau = new bfau();
    bfbd localbfbd = new bfbd();
    localbfbd.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbfbd.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbfbd.jdField_a_of_type_ArrayOfByte = this.b;
    localbfbd.c = this.jdField_d_of_type_Int;
    localbfbd.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    localbfbd.jdField_b_of_type_Boolean = this.n;
    localbfbd.jdField_b_of_type_Int = this.jdField_a_of_type_Beyg.jdField_e_of_type_Int;
    localbfbd.jdField_e_of_type_Int = 3;
    localbfbd.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl;
    MessageRecord localMessageRecord = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (MessageForPic.class.isInstance(localMessageRecord))
    {
      localbfbd.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
      this.u = ((MessageForPic)localMessageRecord).imageType;
    }
    localbfbd.c = this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString;
    localbfbd.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.c;
    localbfbd.e = this.jdField_a_of_type_Beyg.jdField_d_of_type_JavaLangString;
    localbfbd.f = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbfau.jdField_a_of_type_Bfcb = this;
    localbfau.jdField_a_of_type_JavaLangString = "grp_pic_up";
    localbfau.jdField_a_of_type_JavaUtilList.add(localbfbd);
    localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbfau.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bfau = localbfau;
    bfca.a(localbfau);
  }
  
  protected void f(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    d(1000);
    this.jdField_a_of_type_Bete.a();
    d(1001);
    beyg localbeyg = a();
    if ((localbeyg != null) && (localbeyg.i))
    {
      this.jdField_d_of_type_Int = localbeyg.l;
      this.jdField_q_of_type_Int = localbeyg.m;
      this.jdField_q_of_type_Long = localbeyg.jdField_e_of_type_Long;
      this.b = bhml.a(localbeyg.f);
      this.jdField_d_of_type_JavaLangString = localbeyg.f;
      this.c = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Bete.f = this.jdField_d_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.e);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
      return;
    }
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams != null)
    {
      this.jdField_d_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
      this.jdField_q_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
      this.b = bhml.a(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5);
      this.jdField_d_of_type_JavaLangString = HexUtil.bytes2HexStr(this.b);
      this.c = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Bete.f = this.jdField_d_of_type_JavaLangString;
      this.e = "jpg";
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.e);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    f();
  }
  
  protected int h()
  {
    b("uiParam", this.jdField_a_of_type_Beyg.toString());
    switch (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int)
    {
    }
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      localObject = a();
      if ((localObject == null) || (!((beyg)localObject).i)) {
        break;
      }
      if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject instanceof beyk))) {
        this.n = ((beyk)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
      }
      return 0;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Beyg.f))
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
    Object localObject = this.jdField_a_of_type_Bete;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beud
 * JD-Core Version:    0.7.0.1
 */