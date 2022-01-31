import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class bakb
  implements URLDrawable.DownloadListener
{
  bakb(baka parambaka, String paramString) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (!baka.a(this.jdField_a_of_type_Baka).contains(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupPadTemplateAdapter", 2, "onFileDownloadFailed url: " + this.jdField_a_of_type_JavaLangString);
      }
      baka.a(this.jdField_a_of_type_Baka).add(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakb
 * JD-Core Version:    0.7.0.1
 */