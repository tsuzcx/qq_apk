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

public class batr
  extends batj
{
  public batr(bayf parambayf, bayk parambayk)
  {
    super(parambayf, parambayk);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    HashMap localHashMap = new HashMap();
    if (!paramBoolean)
    {
      localHashMap.put("param_FailCode", String.valueOf(this.j));
      localHashMap.put("fail_url", this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
    }
    azri.a(BaseApplicationImpl.getContext()).a(null, "actGroupSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.k) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void b(bbax parambbax, bbbm parambbbm)
  {
    this.jdField_a_of_type_Bbax = null;
    if (parambbbm != null)
    {
      int i = 0;
      while (i < parambbbm.jdField_a_of_type_JavaUtilList.size())
      {
        parambbax = (bbbz)parambbbm.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambbax.toString());
        }
        this.i = parambbax.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.i);
        }
        a(this.jdField_a_of_type_Barh, parambbax);
        if ((parambbax instanceof bbbr))
        {
          parambbax = (bbbr)parambbax;
          if (parambbax.c != 0) {
            break label267;
          }
          if (parambbax.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp GroupPicUpResp.isExist, mFileID:" + parambbax.jdField_a_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Bass.jdField_a_of_type_Long);
            }
            this.f = true;
            this.jdField_a_of_type_Bass.jdField_e_of_type_Long = this.jdField_a_of_type_Bass.jdField_a_of_type_Long;
            this.jdField_a_of_type_Long = parambbax.jdField_a_of_type_Long;
            this.jdField_a_of_type_JavaUtilArrayList = parambbax.jdField_a_of_type_JavaUtilArrayList;
            t();
          }
        }
        else
        {
          i += 1;
          continue;
        }
        d("<BDH_LOG> onBusiProtoResp() picUpResp exist : " + parambbax.jdField_a_of_type_Boolean + " ,select HTTP channel");
        this.w = 2;
        d();
      }
    }
    return;
    label267:
    d("<BDH_LOG> onBusiProtoResp() picUpResp error : " + parambbax.c + " ,select HTTP channel");
    this.w = 2;
    d();
  }
  
  protected void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    d(1000);
    this.jdField_a_of_type_Bass.a();
    d(1001);
    bayk localbayk = a();
    if ((localbayk != null) && (localbayk.h))
    {
      this.p = localbayk.l;
      this.jdField_q_of_type_Int = localbayk.m;
      this.jdField_q_of_type_Long = localbayk.jdField_e_of_type_Long;
      this.jdField_a_of_type_ArrayOfByte = bdhe.a(localbayk.f);
      this.d = localbayk.f;
      this.c = this.d;
      this.jdField_a_of_type_Bass.f = this.d;
      this.d = (this.d + "." + this.e);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
      return;
    }
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams != null)
    {
      this.p = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
      this.jdField_q_of_type_Int = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
      this.jdField_a_of_type_ArrayOfByte = bdhe.a(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5);
      this.d = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      this.c = this.d;
      this.jdField_a_of_type_Bass.f = this.d;
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
    b("uiParam", this.jdField_a_of_type_Bayk.toString());
    int i;
    switch (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_b_of_type_Boolean = false;
      if (2 == this.jdField_a_of_type_Bayk.jdField_b_of_type_Int) {
        bool = false;
      }
      this.g = bool;
      if ((!this.g) && (this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null))
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
            if ((localObject == null) || (!((bayk)localObject).h)) {
              break label193;
            }
            i = j;
          } while (this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject == null);
          i = j;
        } while (!(this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject instanceof bayo));
        this.l = ((bayo)this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
        return 0;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Bayk.f))
        {
          b(9042, a(new Exception("qzonePic md5 null!")));
          d();
          return -1;
        }
        if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl)) || (TextUtils.isEmpty(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5)))
        {
          b(9302, a(new Exception("qzonePic param_check error!")));
          d();
          return -1;
        }
        Object localObject = this.jdField_a_of_type_Bass;
        long l = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize;
        ((bass)localObject).jdField_a_of_type_Long = l;
        this.jdField_q_of_type_Long = l;
        if (this.jdField_q_of_type_Long <= 0L)
        {
          b(9071, a(new Exception("qzonePic file size 0 ")));
          d();
          return -1;
        }
        if (this.jdField_q_of_type_Long >= bazm.a())
        {
          b(9063, a(new Exception("qzonePic file size TooBig! ")));
          d();
          return -1;
        }
        i = j;
      } while (this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject == null);
      i = j;
    } while (!(this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject instanceof bayo));
    this.l = ((bayo)this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    return 0;
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Barh.a();
    bbax localbbax = new bbax();
    bbbg localbbbg = new bbbg();
    localbbbg.jdField_a_of_type_JavaLangString = this.d;
    localbbbg.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbbbg.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localbbbg.c = this.p;
    localbbbg.d = this.jdField_q_of_type_Int;
    localbbbg.jdField_b_of_type_Boolean = this.l;
    localbbbg.jdField_b_of_type_Int = this.jdField_a_of_type_Bayk.jdField_e_of_type_Int;
    localbbbg.jdField_e_of_type_Int = 3;
    localbbbg.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl;
    MessageRecord localMessageRecord = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (MessageForPic.class.isInstance(localMessageRecord))
    {
      localbbbg.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
      this.u = ((MessageForPic)localMessageRecord).imageType;
    }
    localbbbg.c = this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString;
    localbbbg.d = this.jdField_a_of_type_Bayk.c;
    localbbbg.e = this.jdField_a_of_type_Bayk.d;
    localbbbg.f = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
    localbbax.jdField_a_of_type_Bbce = this;
    localbbax.jdField_a_of_type_JavaLangString = "grp_pic_up";
    localbbax.jdField_a_of_type_JavaUtilList.add(localbbbg);
    localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Barh);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbbax.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bbax = localbbax;
    bbcd.a(localbbax);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batr
 * JD-Core Version:    0.7.0.1
 */