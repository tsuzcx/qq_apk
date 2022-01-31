import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.qphone.base.util.QLog;

class asqf
  implements asqy
{
  asqf(asqe paramasqe, HotVideoData paramHotVideoData, asqh paramasqh, URLDrawable paramURLDrawable) {}
  
  public void a(asqz paramasqz)
  {
    if (paramasqz.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.url = paramasqz.a();
      if (this.jdField_a_of_type_Asqh.a() == this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData)
      {
        this.jdField_a_of_type_Asqh.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
        this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "onFileDownloadFailed:" + this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.picIndex + " GetUrlFailed msg:" + paramasqz.jdField_a_of_type_JavaLangString);
      }
    } while (this.jdField_a_of_type_Asqh.a() != this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData);
    this.jdField_a_of_type_Asqh.a(-10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqf
 * JD-Core Version:    0.7.0.1
 */