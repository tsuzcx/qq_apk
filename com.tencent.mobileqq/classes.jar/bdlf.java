import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class bdlf
  implements URLDrawable.DownloadListener
{
  bdlf(bdle parambdle, String paramString) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (!bdle.a(this.jdField_a_of_type_Bdle).contains(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupPadTemplateAdapter", 2, "onFileDownloadFailed url: " + this.jdField_a_of_type_JavaLangString);
      }
      bdle.a(this.jdField_a_of_type_Bdle).add(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdlf
 * JD-Core Version:    0.7.0.1
 */