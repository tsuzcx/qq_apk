import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class aung
  implements ayzu
{
  aung(String paramString1, String paramString2, PhotoSendParams paramPhotoSendParams) {}
  
  public void a(ayyn paramayyn, ayzc paramayzc)
  {
    int j = 0;
    if (j < paramayzc.a.size())
    {
      paramayyn = (ayzp)paramayzc.a.get(j);
      int i = -1;
      if ((paramayyn instanceof ayzh)) {
        i = ((ayzh)paramayyn).c;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess request Result, resultCode:" + i + ", selfUin:" + this.jdField_a_of_type_JavaLangString + ", friendUin:" + this.b + ", md5:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5 + ", commonInfo:" + paramayyn.toString());
        }
        j += 1;
        break;
        if ((paramayyn instanceof ayze)) {
          i = ((ayze)paramayyn).c;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aung
 * JD-Core Version:    0.7.0.1
 */