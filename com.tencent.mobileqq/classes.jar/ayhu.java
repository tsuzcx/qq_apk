import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class ayhu
  implements URLDrawable.DownloadListener
{
  ayhu(ayht paramayht, String paramString) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (!ayht.a(this.jdField_a_of_type_Ayht).contains(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupPadTemplateAdapter", 2, "onFileDownloadFailed url: " + this.jdField_a_of_type_JavaLangString);
      }
      ayht.a(this.jdField_a_of_type_Ayht).add(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhu
 * JD-Core Version:    0.7.0.1
 */