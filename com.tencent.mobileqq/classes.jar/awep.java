import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class awep
  implements baxv
{
  awep(String paramString1, String paramString2, PhotoSendParams paramPhotoSendParams) {}
  
  public void a(bawo parambawo, baxd parambaxd)
  {
    int j = 0;
    if (j < parambaxd.a.size())
    {
      parambawo = (baxq)parambaxd.a.get(j);
      int i = -1;
      if ((parambawo instanceof baxi)) {
        i = ((baxi)parambawo).c;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess request Result, resultCode:" + i + ", selfUin:" + this.jdField_a_of_type_JavaLangString + ", friendUin:" + this.b + ", md5:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5 + ", commonInfo:" + parambawo.toString());
        }
        j += 1;
        break;
        if ((parambawo instanceof baxf)) {
          i = ((baxf)parambawo).c;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awep
 * JD-Core Version:    0.7.0.1
 */