import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class awiy
  implements bbce
{
  awiy(String paramString1, String paramString2, PhotoSendParams paramPhotoSendParams) {}
  
  public void a(bbax parambbax, bbbm parambbbm)
  {
    int j = 0;
    if (j < parambbbm.a.size())
    {
      parambbax = (bbbz)parambbbm.a.get(j);
      int i = -1;
      if ((parambbax instanceof bbbr)) {
        i = ((bbbr)parambbax).c;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess request Result, resultCode:" + i + ", selfUin:" + this.jdField_a_of_type_JavaLangString + ", friendUin:" + this.b + ", md5:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5 + ", commonInfo:" + parambbax.toString());
        }
        j += 1;
        break;
        if ((parambbax instanceof bbbo)) {
          i = ((bbbo)parambbax).c;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awiy
 * JD-Core Version:    0.7.0.1
 */