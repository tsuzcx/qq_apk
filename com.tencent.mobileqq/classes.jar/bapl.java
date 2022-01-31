import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class bapl
  implements bapx
{
  long jdField_a_of_type_Long = 0L;
  
  bapl(URLDrawableHandler paramURLDrawableHandler, String paramString, bapo parambapo) {}
  
  public void onResp(baqw parambaqw)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("HttpDownloader", 2, " structMsgCover download onResp result fileSize = " + this.jdField_a_of_type_Long + " file.path = " + parambaqw.jdField_a_of_type_Baqv.c + " resp.result = " + parambaqw.jdField_a_of_type_Int);
    }
    if (parambaqw.jdField_a_of_type_Int == 3) {
      return;
    }
    boolean bool1;
    if (parambaqw.jdField_a_of_type_Int == 0)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentImageURLDrawableHandler != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadSucceed(this.jdField_a_of_type_Long);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      try
      {
        bapk.a(bool1, new URL(this.jdField_a_of_type_JavaLangString), null, true, parambaqw.c, parambaqw.e, null, this.jdField_a_of_type_Bapo);
        return;
      }
      catch (Exception parambaqw)
      {
        return;
      }
      bool2 = false;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentImageURLDrawableHandler != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadFailed(parambaqw.jdField_a_of_type_Int);
        bool1 = bool2;
      }
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HttpDownloader", 2, " structMsgCover onUpdateProgeress totalLen = " + paramLong2 + " curOffset = " + paramLong1);
    }
    this.jdField_a_of_type_Long = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapl
 * JD-Core Version:    0.7.0.1
 */