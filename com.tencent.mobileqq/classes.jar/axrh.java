import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class axrh
  implements axrt
{
  long jdField_a_of_type_Long = 0L;
  
  axrh(URLDrawableHandler paramURLDrawableHandler, String paramString, axrk paramaxrk) {}
  
  public void onResp(axsq paramaxsq)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("HttpDownloader", 2, " structMsgCover download onResp result fileSize = " + this.jdField_a_of_type_Long + " file.path = " + paramaxsq.jdField_a_of_type_Axsp.c + " resp.result = " + paramaxsq.jdField_a_of_type_Int);
    }
    if (paramaxsq.jdField_a_of_type_Int == 3) {
      return;
    }
    boolean bool1;
    if (paramaxsq.jdField_a_of_type_Int == 0)
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
        axrg.a(bool1, new URL(this.jdField_a_of_type_JavaLangString), null, true, paramaxsq.c, paramaxsq.e, null, this.jdField_a_of_type_Axrk);
        return;
      }
      catch (Exception paramaxsq)
      {
        return;
      }
      bool2 = false;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentImageURLDrawableHandler != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadFailed(paramaxsq.jdField_a_of_type_Int);
        bool1 = bool2;
      }
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HttpDownloader", 2, " structMsgCover onUpdateProgeress totalLen = " + paramLong2 + " curOffset = " + paramLong1);
    }
    this.jdField_a_of_type_Long = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axrh
 * JD-Core Version:    0.7.0.1
 */