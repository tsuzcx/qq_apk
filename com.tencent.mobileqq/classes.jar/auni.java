import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class auni
  implements ayzw
{
  auni(String paramString1, String paramString2, PhotoSendParams paramPhotoSendParams) {}
  
  public void a(ayyp paramayyp, ayze paramayze)
  {
    int j = 0;
    if (j < paramayze.a.size())
    {
      paramayyp = (ayzr)paramayze.a.get(j);
      int i = -1;
      if ((paramayyp instanceof ayzj)) {
        i = ((ayzj)paramayyp).c;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess request Result, resultCode:" + i + ", selfUin:" + this.jdField_a_of_type_JavaLangString + ", friendUin:" + this.b + ", md5:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5 + ", commonInfo:" + paramayyp.toString());
        }
        j += 1;
        break;
        if ((paramayyp instanceof ayzg)) {
          i = ((ayzg)paramayyp).c;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auni
 * JD-Core Version:    0.7.0.1
 */