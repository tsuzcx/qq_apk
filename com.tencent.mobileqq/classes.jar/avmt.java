import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.qphone.base.util.QLog;

class avmt
  implements avnm
{
  avmt(avms paramavms, HotVideoData paramHotVideoData, avmv paramavmv, URLDrawable paramURLDrawable) {}
  
  public void a(avnn paramavnn)
  {
    if (paramavnn.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.url = paramavnn.a();
      if (this.jdField_a_of_type_Avmv.a() == this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData)
      {
        this.jdField_a_of_type_Avmv.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
        this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManagerHotPicPageView", 2, "onFileDownloadFailed:" + this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.picIndex + " GetUrlFailed msg:" + paramavnn.jdField_a_of_type_JavaLangString);
      }
    } while (this.jdField_a_of_type_Avmv.a() != this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData);
    this.jdField_a_of_type_Avmv.a(-10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmt
 * JD-Core Version:    0.7.0.1
 */