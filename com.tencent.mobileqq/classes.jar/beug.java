import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class beug
  implements beuq
{
  long jdField_a_of_type_Long = 0L;
  
  beug(URLDrawableHandler paramURLDrawableHandler, String paramString, beui parambeui) {}
  
  public void onResp(bevm parambevm)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("HttpDownloader", 2, " structMsgCover download onResp result fileSize = " + this.jdField_a_of_type_Long + " file.path = " + parambevm.jdField_a_of_type_Bevl.c + " resp.result = " + parambevm.jdField_a_of_type_Int);
    }
    if (parambevm.jdField_a_of_type_Int == 3) {
      return;
    }
    boolean bool1;
    if (parambevm.jdField_a_of_type_Int == 0)
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
        beuf.a(bool1, new URL(this.jdField_a_of_type_JavaLangString), true, parambevm.c, parambevm.e, null, this.jdField_a_of_type_Beui);
        return;
      }
      catch (Exception parambevm)
      {
        return;
      }
      bool2 = false;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentImageURLDrawableHandler != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadFailed(parambevm.jdField_a_of_type_Int);
        bool1 = bool2;
      }
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HttpDownloader", 2, " structMsgCover onUpdateProgeress totalLen = " + paramLong2 + " curOffset = " + paramLong1);
    }
    this.jdField_a_of_type_Long = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beug
 * JD-Core Version:    0.7.0.1
 */