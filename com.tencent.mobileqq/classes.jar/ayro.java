import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class ayro
  implements aysa
{
  long jdField_a_of_type_Long = 0L;
  
  ayro(URLDrawableHandler paramURLDrawableHandler, String paramString, ayrr paramayrr) {}
  
  public void onResp(aysx paramaysx)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("HttpDownloader", 2, " structMsgCover download onResp result fileSize = " + this.jdField_a_of_type_Long + " file.path = " + paramaysx.jdField_a_of_type_Aysw.c + " resp.result = " + paramaysx.jdField_a_of_type_Int);
    }
    if (paramaysx.jdField_a_of_type_Int == 3) {
      return;
    }
    boolean bool1;
    if (paramaysx.jdField_a_of_type_Int == 0)
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
        ayrn.a(bool1, new URL(this.jdField_a_of_type_JavaLangString), null, true, paramaysx.c, paramaysx.e, null, this.jdField_a_of_type_Ayrr);
        return;
      }
      catch (Exception paramaysx)
      {
        return;
      }
      bool2 = false;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentImageURLDrawableHandler != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadFailed(paramaysx.jdField_a_of_type_Int);
        bool1 = bool2;
      }
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HttpDownloader", 2, " structMsgCover onUpdateProgeress totalLen = " + paramLong2 + " curOffset = " + paramLong1);
    }
    this.jdField_a_of_type_Long = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayro
 * JD-Core Version:    0.7.0.1
 */