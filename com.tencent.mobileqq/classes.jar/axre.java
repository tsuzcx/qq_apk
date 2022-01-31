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

public class axre
  extends axqw
{
  public axre(axvo paramaxvo, axvt paramaxvt)
  {
    super(paramaxvo, paramaxvt);
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
    awrn.a(BaseApplicationImpl.getContext()).a(null, "actGroupSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.k) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void b(axyg paramaxyg, axyv paramaxyv)
  {
    this.jdField_a_of_type_Axyg = null;
    if (paramaxyv != null)
    {
      int i = 0;
      while (i < paramaxyv.jdField_a_of_type_JavaUtilList.size())
      {
        paramaxyg = (axzi)paramaxyv.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramaxyg.toString());
        }
        this.i = paramaxyg.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Axow, paramaxyg);
        if ((paramaxyg instanceof axza))
        {
          paramaxyg = (axza)paramaxyg;
          if (paramaxyg.c != 0) {
            break label267;
          }
          if (paramaxyg.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp GroupPicUpResp.isExist, mFileID:" + paramaxyg.jdField_a_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Axqf.jdField_a_of_type_Long);
            }
            this.f = true;
            this.jdField_a_of_type_Axqf.jdField_e_of_type_Long = this.jdField_a_of_type_Axqf.jdField_a_of_type_Long;
            this.jdField_a_of_type_Long = paramaxyg.jdField_a_of_type_Long;
            this.jdField_a_of_type_JavaUtilArrayList = paramaxyg.jdField_a_of_type_JavaUtilArrayList;
            t();
          }
        }
        else
        {
          i += 1;
          continue;
        }
        d("<BDH_LOG> onBusiProtoResp() picUpResp exist : " + paramaxyg.jdField_a_of_type_Boolean + " ,select HTTP channel");
        this.w = 2;
        d();
      }
    }
    return;
    label267:
    d("<BDH_LOG> onBusiProtoResp() picUpResp error : " + paramaxyg.c + " ,select HTTP channel");
    this.w = 2;
    d();
  }
  
  protected void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    d(1000);
    this.jdField_a_of_type_Axqf.a();
    d(1001);
    axvt localaxvt = a();
    if ((localaxvt != null) && (localaxvt.h))
    {
      this.p = localaxvt.l;
      this.jdField_q_of_type_Int = localaxvt.m;
      this.jdField_q_of_type_Long = localaxvt.jdField_e_of_type_Long;
      this.jdField_a_of_type_ArrayOfByte = bach.a(localaxvt.f);
      this.d = localaxvt.f;
      this.c = this.d;
      this.jdField_a_of_type_Axqf.f = this.d;
      this.d = (this.d + "." + this.e);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
      return;
    }
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams != null)
    {
      this.p = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
      this.jdField_q_of_type_Int = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
      this.jdField_a_of_type_ArrayOfByte = bach.a(this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5);
      this.d = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      this.c = this.d;
      this.jdField_a_of_type_Axqf.f = this.d;
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
    b("uiParam", this.jdField_a_of_type_Axvt.toString());
    int i;
    switch (this.jdField_a_of_type_Axvt.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_b_of_type_Boolean = false;
      if (2 == this.jdField_a_of_type_Axvt.jdField_b_of_type_Int) {
        bool = false;
      }
      this.g = bool;
      if ((!this.g) && (this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null))
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
            if ((localObject == null) || (!((axvt)localObject).h)) {
              break label193;
            }
            i = j;
          } while (this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject == null);
          i = j;
        } while (!(this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject instanceof axvx));
        this.l = ((axvx)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
        return 0;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Axvt.f))
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
        Object localObject = this.jdField_a_of_type_Axqf;
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
        i = j;
      } while (this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject == null);
      i = j;
    } while (!(this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject instanceof axvx));
    this.l = ((axvx)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    return 0;
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Axow.a();
    axyg localaxyg = new axyg();
    axyp localaxyp = new axyp();
    localaxyp.jdField_a_of_type_JavaLangString = this.d;
    localaxyp.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localaxyp.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localaxyp.c = this.p;
    localaxyp.d = this.jdField_q_of_type_Int;
    localaxyp.jdField_b_of_type_Boolean = this.l;
    localaxyp.jdField_b_of_type_Int = this.jdField_a_of_type_Axvt.jdField_e_of_type_Int;
    localaxyp.jdField_e_of_type_Int = 3;
    localaxyp.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl;
    MessageRecord localMessageRecord = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (MessageForPic.class.isInstance(localMessageRecord))
    {
      localaxyp.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
      this.u = ((MessageForPic)localMessageRecord).imageType;
    }
    localaxyp.c = this.jdField_a_of_type_Axvt.jdField_b_of_type_JavaLangString;
    localaxyp.d = this.jdField_a_of_type_Axvt.c;
    localaxyp.e = this.jdField_a_of_type_Axvt.d;
    localaxyp.f = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
    localaxyg.jdField_a_of_type_Axzn = this;
    localaxyg.jdField_a_of_type_JavaLangString = "grp_pic_up";
    localaxyg.jdField_a_of_type_JavaUtilList.add(localaxyp);
    localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Axow);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localaxyg.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Axyg = localaxyg;
    axzm.a(localaxyg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axre
 * JD-Core Version:    0.7.0.1
 */