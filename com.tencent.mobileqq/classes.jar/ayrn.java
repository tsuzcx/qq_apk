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

public class ayrn
  extends ayrf
{
  public ayrn(ayvx paramayvx, aywc paramaywc)
  {
    super(paramayvx, paramaywc);
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
    axrn.a(BaseApplicationImpl.getContext()).a(null, "actGroupSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.k) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void b(ayyp paramayyp, ayze paramayze)
  {
    this.jdField_a_of_type_Ayyp = null;
    if (paramayze != null)
    {
      int i = 0;
      while (i < paramayze.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyp = (ayzr)paramayze.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramayyp.toString());
        }
        this.i = paramayyp.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Aypd, paramayyp);
        if ((paramayyp instanceof ayzj))
        {
          paramayyp = (ayzj)paramayyp;
          if (paramayyp.c != 0) {
            break label267;
          }
          if (paramayyp.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp GroupPicUpResp.isExist, mFileID:" + paramayyp.jdField_a_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long);
            }
            this.f = true;
            this.jdField_a_of_type_Ayqo.jdField_e_of_type_Long = this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long;
            this.jdField_a_of_type_Long = paramayyp.jdField_a_of_type_Long;
            this.jdField_a_of_type_JavaUtilArrayList = paramayyp.jdField_a_of_type_JavaUtilArrayList;
            t();
          }
        }
        else
        {
          i += 1;
          continue;
        }
        d("<BDH_LOG> onBusiProtoResp() picUpResp exist : " + paramayyp.jdField_a_of_type_Boolean + " ,select HTTP channel");
        this.w = 2;
        d();
      }
    }
    return;
    label267:
    d("<BDH_LOG> onBusiProtoResp() picUpResp error : " + paramayyp.c + " ,select HTTP channel");
    this.w = 2;
    d();
  }
  
  protected void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    d(1000);
    this.jdField_a_of_type_Ayqo.a();
    d(1001);
    aywc localaywc = a();
    if ((localaywc != null) && (localaywc.h))
    {
      this.p = localaywc.l;
      this.jdField_q_of_type_Int = localaywc.m;
      this.jdField_q_of_type_Long = localaywc.jdField_e_of_type_Long;
      this.jdField_a_of_type_ArrayOfByte = bbea.a(localaywc.f);
      this.d = localaywc.f;
      this.c = this.d;
      this.jdField_a_of_type_Ayqo.f = this.d;
      this.d = (this.d + "." + this.e);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
      return;
    }
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams != null)
    {
      this.p = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
      this.jdField_q_of_type_Int = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
      this.jdField_a_of_type_ArrayOfByte = bbea.a(this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5);
      this.d = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      this.c = this.d;
      this.jdField_a_of_type_Ayqo.f = this.d;
      this.e = "jpg";
      this.d = (this.d + "." + this.e);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    f();
  }
  
  protected int d()
  {
    boolean bool = true;
    int j = 0;
    b("uiParam", this.jdField_a_of_type_Aywc.toString());
    int i;
    switch (this.jdField_a_of_type_Aywc.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_b_of_type_Boolean = false;
      if (2 == this.jdField_a_of_type_Aywc.jdField_b_of_type_Int) {
        bool = false;
      }
      this.g = bool;
      if ((!this.g) && (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null))
      {
        b(9302, a(new Exception("message null")));
        d();
        i = -1;
      }
      break;
    }
    label193:
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            this.jdField_b_of_type_Boolean = true;
            break;
            localObject = a();
            if ((localObject == null) || (!((aywc)localObject).h)) {
              break label193;
            }
            i = j;
          } while (this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject == null);
          i = j;
        } while (!(this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject instanceof aywg));
        this.l = ((aywg)this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
        return 0;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Aywc.f))
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
        Object localObject = this.jdField_a_of_type_Ayqo;
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
        i = j;
      } while (this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject == null);
      i = j;
    } while (!(this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject instanceof aywg));
    this.l = ((aywg)this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    return 0;
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Aypd.a();
    ayyp localayyp = new ayyp();
    ayyy localayyy = new ayyy();
    localayyy.jdField_a_of_type_JavaLangString = this.d;
    localayyy.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localayyy.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localayyy.c = this.p;
    localayyy.d = this.jdField_q_of_type_Int;
    localayyy.jdField_b_of_type_Boolean = this.l;
    localayyy.jdField_b_of_type_Int = this.jdField_a_of_type_Aywc.jdField_e_of_type_Int;
    localayyy.jdField_e_of_type_Int = 3;
    localayyy.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl;
    MessageRecord localMessageRecord = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (MessageForPic.class.isInstance(localMessageRecord))
    {
      localayyy.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
      this.u = ((MessageForPic)localMessageRecord).imageType;
    }
    localayyy.c = this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString;
    localayyy.d = this.jdField_a_of_type_Aywc.c;
    localayyy.e = this.jdField_a_of_type_Aywc.d;
    localayyy.f = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
    localayyp.jdField_a_of_type_Ayzw = this;
    localayyp.jdField_a_of_type_JavaLangString = "grp_pic_up";
    localayyp.jdField_a_of_type_JavaUtilList.add(localayyy);
    localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypd);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localayyp.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Ayyp = localayyp;
    ayzv.a(localayyp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrn
 * JD-Core Version:    0.7.0.1
 */