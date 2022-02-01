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

public class bdvj
  extends bdvb
{
  public bdvj(bdzi parambdzi, bdzn parambdzn)
  {
    super(parambdzi, parambdzn);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    HashMap localHashMap = new HashMap();
    if (!paramBoolean)
    {
      localHashMap.put("param_FailCode", String.valueOf(this.j));
      localHashMap.put("fail_url", this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
    }
    bctj.a(BaseApplicationImpl.getContext()).a(null, "actGroupSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void b(bebv parambebv, beck parambeck)
  {
    this.jdField_a_of_type_Bebv = null;
    if (parambeck != null)
    {
      int i = 0;
      while (i < parambeck.jdField_a_of_type_JavaUtilList.size())
      {
        parambebv = (becx)parambeck.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambebv.toString());
        }
        this.jdField_k_of_type_Boolean = parambebv.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_k_of_type_Boolean);
        }
        a(this.jdField_a_of_type_Bdsz, parambebv);
        if ((parambebv instanceof becp))
        {
          parambebv = (becp)parambebv;
          if (parambebv.c != 0) {
            break label267;
          }
          if (parambebv.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp GroupPicUpResp.isExist, mFileID:" + parambebv.jdField_a_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Bduk.jdField_a_of_type_Long);
            }
            this.f = true;
            this.jdField_a_of_type_Bduk.jdField_e_of_type_Long = this.jdField_a_of_type_Bduk.jdField_a_of_type_Long;
            this.jdField_a_of_type_Long = parambebv.jdField_a_of_type_Long;
            this.jdField_a_of_type_JavaUtilArrayList = parambebv.jdField_a_of_type_JavaUtilArrayList;
            s();
          }
        }
        else
        {
          i += 1;
          continue;
        }
        d("<BDH_LOG> onBusiProtoResp() picUpResp exist : " + parambebv.jdField_a_of_type_Boolean + " ,select HTTP channel");
        this.w = 2;
        d();
      }
    }
    return;
    label267:
    d("<BDH_LOG> onBusiProtoResp() picUpResp error : " + parambebv.c + " ,select HTTP channel");
    this.w = 2;
    d();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Bdsz.a();
    bebv localbebv = new bebv();
    bece localbece = new bece();
    localbece.jdField_a_of_type_JavaLangString = this.d;
    localbece.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbece.jdField_a_of_type_ArrayOfByte = this.b;
    localbece.c = this.p;
    localbece.d = this.jdField_q_of_type_Int;
    localbece.jdField_b_of_type_Boolean = this.n;
    localbece.jdField_b_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_e_of_type_Int;
    localbece.jdField_e_of_type_Int = 3;
    localbece.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl;
    MessageRecord localMessageRecord = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (MessageForPic.class.isInstance(localMessageRecord))
    {
      localbece.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
      this.u = ((MessageForPic)localMessageRecord).imageType;
    }
    localbece.c = this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString;
    localbece.d = this.jdField_a_of_type_Bdzn.c;
    localbece.e = this.jdField_a_of_type_Bdzn.d;
    localbece.f = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    localbebv.jdField_a_of_type_Bedc = this;
    localbebv.jdField_a_of_type_JavaLangString = "grp_pic_up";
    localbebv.jdField_a_of_type_JavaUtilList.add(localbece);
    localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Bdsz);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbebv.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bebv = localbebv;
    bedb.a(localbebv);
  }
  
  protected void f(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    d(1000);
    this.jdField_a_of_type_Bduk.a();
    d(1001);
    bdzn localbdzn = a();
    if ((localbdzn != null) && (localbdzn.h))
    {
      this.p = localbdzn.l;
      this.jdField_q_of_type_Int = localbdzn.m;
      this.jdField_q_of_type_Long = localbdzn.jdField_e_of_type_Long;
      this.b = bgmj.a(localbdzn.f);
      this.d = localbdzn.f;
      this.c = this.d;
      this.jdField_a_of_type_Bduk.f = this.d;
      this.d = (this.d + "." + this.e);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
      return;
    }
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams != null)
    {
      this.p = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
      this.jdField_q_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
      this.b = bgmj.a(this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5);
      this.d = HexUtil.bytes2HexStr(this.b);
      this.c = this.d;
      this.jdField_a_of_type_Bduk.f = this.d;
      this.e = "jpg";
      this.d = (this.d + "." + this.e);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    f();
  }
  
  protected int h()
  {
    b("uiParam", this.jdField_a_of_type_Bdzn.toString());
    switch (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int)
    {
    }
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      localObject = a();
      if ((localObject == null) || (!((bdzn)localObject).h)) {
        break;
      }
      if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject instanceof bdzr))) {
        this.n = ((bdzr)this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
      }
      return 0;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Bdzn.f))
    {
      b(9042, a(new Exception("qzonePic md5 null!")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl)) || (TextUtils.isEmpty(this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5)))
    {
      b(9302, a(new Exception("qzonePic param_check error!")));
      d();
      return -1;
    }
    Object localObject = this.jdField_a_of_type_Bduk;
    long l = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize;
    ((bduk)localObject).jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    if (this.jdField_q_of_type_Long <= 0L)
    {
      b(9071, a(new Exception("qzonePic file size 0 ")));
      d();
      return -1;
    }
    if (this.jdField_q_of_type_Long >= beao.a())
    {
      b(9063, a(new Exception("qzonePic file size TooBig! ")));
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject instanceof bdzr))) {
      this.n = ((bdzr)this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvj
 * JD-Core Version:    0.7.0.1
 */