import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class ayxk
  implements bedc
{
  ayxk(String paramString1, String paramString2, PhotoSendParams paramPhotoSendParams) {}
  
  public void a(bebv parambebv, beck parambeck)
  {
    int j = 0;
    if (j < parambeck.a.size())
    {
      parambebv = (becx)parambeck.a.get(j);
      int i = -1;
      if ((parambebv instanceof becp)) {
        i = ((becp)parambebv).c;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess request Result, resultCode:" + i + ", selfUin:" + this.jdField_a_of_type_JavaLangString + ", friendUin:" + this.b + ", md5:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5 + ", commonInfo:" + parambebv.toString());
        }
        j += 1;
        break;
        if ((parambebv instanceof becm)) {
          i = ((becm)parambebv).c;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxk
 * JD-Core Version:    0.7.0.1
 */