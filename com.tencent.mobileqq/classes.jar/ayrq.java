import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class ayrq
  implements aysc
{
  long jdField_a_of_type_Long = 0L;
  
  ayrq(URLDrawableHandler paramURLDrawableHandler, String paramString, ayrt paramayrt) {}
  
  public void onResp(aysz paramaysz)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("HttpDownloader", 2, " structMsgCover download onResp result fileSize = " + this.jdField_a_of_type_Long + " file.path = " + paramaysz.jdField_a_of_type_Aysy.c + " resp.result = " + paramaysz.jdField_a_of_type_Int);
    }
    if (paramaysz.jdField_a_of_type_Int == 3) {
      return;
    }
    boolean bool1;
    if (paramaysz.jdField_a_of_type_Int == 0)
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
        ayrp.a(bool1, new URL(this.jdField_a_of_type_JavaLangString), null, true, paramaysz.c, paramaysz.e, null, this.jdField_a_of_type_Ayrt);
        return;
      }
      catch (Exception paramaysz)
      {
        return;
      }
      bool2 = false;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentImageURLDrawableHandler != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadFailed(paramaysz.jdField_a_of_type_Int);
        bool1 = bool2;
      }
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HttpDownloader", 2, " structMsgCover onUpdateProgeress totalLen = " + paramLong2 + " curOffset = " + paramLong1);
    }
    this.jdField_a_of_type_Long = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrq
 * JD-Core Version:    0.7.0.1
 */