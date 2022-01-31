import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class atpi
  implements axzn
{
  atpi(String paramString1, String paramString2, PhotoSendParams paramPhotoSendParams) {}
  
  public void a(axyg paramaxyg, axyv paramaxyv)
  {
    int j = 0;
    if (j < paramaxyv.a.size())
    {
      paramaxyg = (axzi)paramaxyv.a.get(j);
      int i = -1;
      if ((paramaxyg instanceof axza)) {
        i = ((axza)paramaxyg).c;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess request Result, resultCode:" + i + ", selfUin:" + this.jdField_a_of_type_JavaLangString + ", friendUin:" + this.b + ", md5:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5 + ", commonInfo:" + paramaxyg.toString());
        }
        j += 1;
        break;
        if ((paramaxyg instanceof axyx)) {
          i = ((axyx)paramaxyg).c;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpi
 * JD-Core Version:    0.7.0.1
 */