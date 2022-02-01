import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class azpy
  implements bfcb
{
  azpy(String paramString1, String paramString2, PhotoSendParams paramPhotoSendParams) {}
  
  public void a(bfau parambfau, bfbj parambfbj)
  {
    int j = 0;
    if (j < parambfbj.a.size())
    {
      parambfau = (bfbw)parambfbj.a.get(j);
      int i = -1;
      if ((parambfau instanceof bfbo)) {
        i = ((bfbo)parambfau).c;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess request Result, resultCode:" + i + ", selfUin:" + this.jdField_a_of_type_JavaLangString + ", friendUin:" + this.b + ", md5:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5 + ", commonInfo:" + parambfau.toString());
        }
        j += 1;
        break;
        if ((parambfau instanceof bfbl)) {
          i = ((bfbl)parambfau).c;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpy
 * JD-Core Version:    0.7.0.1
 */