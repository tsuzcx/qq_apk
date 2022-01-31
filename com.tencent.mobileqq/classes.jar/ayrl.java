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

public class ayrl
  extends ayrd
{
  public ayrl(ayvv paramayvv, aywa paramaywa)
  {
    super(paramayvv, paramaywa);
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
    axrl.a(BaseApplicationImpl.getContext()).a(null, "actGroupSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.k) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void b(ayyn paramayyn, ayzc paramayzc)
  {
    this.jdField_a_of_type_Ayyn = null;
    if (paramayzc != null)
    {
      int i = 0;
      while (i < paramayzc.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyn = (ayzp)paramayzc.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramayyn.toString());
        }
        this.i = paramayyn.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Aypb, paramayyn);
        if ((paramayyn instanceof ayzh))
        {
          paramayyn = (ayzh)paramayyn;
          if (paramayyn.c != 0) {
            break label267;
          }
          if (paramayyn.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp GroupPicUpResp.isExist, mFileID:" + paramayyn.jdField_a_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Ayqm.jdField_a_of_type_Long);
            }
            this.f = true;
            this.jdField_a_of_type_Ayqm.jdField_e_of_type_Long = this.jdField_a_of_type_Ayqm.jdField_a_of_type_Long;
            this.jdField_a_of_type_Long = paramayyn.jdField_a_of_type_Long;
            this.jdField_a_of_type_JavaUtilArrayList = paramayyn.jdField_a_of_type_JavaUtilArrayList;
            t();
          }
        }
        else
        {
          i += 1;
          continue;
        }
        d("<BDH_LOG> onBusiProtoResp() picUpResp exist : " + paramayyn.jdField_a_of_type_Boolean + " ,select HTTP channel");
        this.w = 2;
        d();
      }
    }
    return;
    label267:
    d("<BDH_LOG> onBusiProtoResp() picUpResp error : " + paramayyn.c + " ,select HTTP channel");
    this.w = 2;
    d();
  }
  
  protected void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    d(1000);
    this.jdField_a_of_type_Ayqm.a();
    d(1001);
    aywa localaywa = a();
    if ((localaywa != null) && (localaywa.h))
    {
      this.p = localaywa.l;
      this.jdField_q_of_type_Int = localaywa.m;
      this.jdField_q_of_type_Long = localaywa.jdField_e_of_type_Long;
      this.jdField_a_of_type_ArrayOfByte = bbdm.a(localaywa.f);
      this.d = localaywa.f;
      this.c = this.d;
      this.jdField_a_of_type_Ayqm.f = this.d;
      this.d = (this.d + "." + this.e);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
      return;
    }
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams != null)
    {
      this.p = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
      this.jdField_q_of_type_Int = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
      this.jdField_a_of_type_ArrayOfByte = bbdm.a(this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5);
      this.d = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      this.c = this.d;
      this.jdField_a_of_type_Ayqm.f = this.d;
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
    b("uiParam", this.jdField_a_of_type_Aywa.toString());
    int i;
    switch (this.jdField_a_of_type_Aywa.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_b_of_type_Boolean = false;
      if (2 == this.jdField_a_of_type_Aywa.jdField_b_of_type_Int) {
        bool = false;
      }
      this.g = bool;
      if ((!this.g) && (this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null))
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
            if ((localObject == null) || (!((aywa)localObject).h)) {
              break label193;
            }
            i = j;
          } while (this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject == null);
          i = j;
        } while (!(this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject instanceof aywe));
        this.l = ((aywe)this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
        return 0;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Aywa.f))
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
        Object localObject = this.jdField_a_of_type_Ayqm;
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
        i = j;
      } while (this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject == null);
      i = j;
    } while (!(this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject instanceof aywe));
    this.l = ((aywe)this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    return 0;
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Aypb.a();
    ayyn localayyn = new ayyn();
    ayyw localayyw = new ayyw();
    localayyw.jdField_a_of_type_JavaLangString = this.d;
    localayyw.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localayyw.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localayyw.c = this.p;
    localayyw.d = this.jdField_q_of_type_Int;
    localayyw.jdField_b_of_type_Boolean = this.l;
    localayyw.jdField_b_of_type_Int = this.jdField_a_of_type_Aywa.jdField_e_of_type_Int;
    localayyw.jdField_e_of_type_Int = 3;
    localayyw.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl;
    MessageRecord localMessageRecord = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (MessageForPic.class.isInstance(localMessageRecord))
    {
      localayyw.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
      this.u = ((MessageForPic)localMessageRecord).imageType;
    }
    localayyw.c = this.jdField_a_of_type_Aywa.jdField_b_of_type_JavaLangString;
    localayyw.d = this.jdField_a_of_type_Aywa.c;
    localayyw.e = this.jdField_a_of_type_Aywa.d;
    localayyw.f = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
    localayyn.jdField_a_of_type_Ayzu = this;
    localayyn.jdField_a_of_type_JavaLangString = "grp_pic_up";
    localayyn.jdField_a_of_type_JavaUtilList.add(localayyw);
    localayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypb);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localayyn.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Ayyn = localayyn;
    ayzt.a(localayyn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrl
 * JD-Core Version:    0.7.0.1
 */