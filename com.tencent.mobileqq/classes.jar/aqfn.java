import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.qphone.base.util.QLog;

class aqfn
  implements aqgg
{
  aqfn(aqfm paramaqfm, HotVideoData paramHotVideoData, aqfp paramaqfp, URLDrawable paramURLDrawable) {}
  
  public void a(aqgh paramaqgh)
  {
    if (paramaqgh.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.url = paramaqgh.a();
      if (this.jdField_a_of_type_Aqfp.a() == this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData)
      {
        this.jdField_a_of_type_Aqfp.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
        this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "onFileDownloadFailed:" + this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.picIndex + " GetUrlFailed msg:" + paramaqgh.jdField_a_of_type_JavaLangString);
      }
    } while (this.jdField_a_of_type_Aqfp.a() != this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData);
    this.jdField_a_of_type_Aqfp.a(-10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqfn
 * JD-Core Version:    0.7.0.1
 */