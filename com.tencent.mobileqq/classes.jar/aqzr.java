import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.qphone.base.util.QLog;

class aqzr
  implements arak
{
  aqzr(aqzq paramaqzq, HotVideoData paramHotVideoData, aqzt paramaqzt, URLDrawable paramURLDrawable) {}
  
  public void a(aral paramaral)
  {
    if (paramaral.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.url = paramaral.a();
      if (this.jdField_a_of_type_Aqzt.a() == this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData)
      {
        this.jdField_a_of_type_Aqzt.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
        this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "onFileDownloadFailed:" + this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.picIndex + " GetUrlFailed msg:" + paramaral.jdField_a_of_type_JavaLangString);
      }
    } while (this.jdField_a_of_type_Aqzt.a() != this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData);
    this.jdField_a_of_type_Aqzt.a(-10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqzr
 * JD-Core Version:    0.7.0.1
 */