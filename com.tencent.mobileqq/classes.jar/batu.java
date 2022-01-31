import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class batu
  implements baug
{
  long jdField_a_of_type_Long = 0L;
  
  batu(URLDrawableHandler paramURLDrawableHandler, String paramString, batx parambatx) {}
  
  public void onResp(bavf parambavf)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("HttpDownloader", 2, " structMsgCover download onResp result fileSize = " + this.jdField_a_of_type_Long + " file.path = " + parambavf.jdField_a_of_type_Bave.c + " resp.result = " + parambavf.jdField_a_of_type_Int);
    }
    if (parambavf.jdField_a_of_type_Int == 3) {
      return;
    }
    boolean bool1;
    if (parambavf.jdField_a_of_type_Int == 0)
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
        batt.a(bool1, new URL(this.jdField_a_of_type_JavaLangString), null, true, parambavf.c, parambavf.e, null, this.jdField_a_of_type_Batx);
        return;
      }
      catch (Exception parambavf)
      {
        return;
      }
      bool2 = false;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentImageURLDrawableHandler != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadFailed(parambavf.jdField_a_of_type_Int);
        bool1 = bool2;
      }
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HttpDownloader", 2, " structMsgCover onUpdateProgeress totalLen = " + paramLong2 + " curOffset = " + paramLong1);
    }
    this.jdField_a_of_type_Long = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batu
 * JD-Core Version:    0.7.0.1
 */