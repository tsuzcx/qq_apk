import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.hotpic.HotVideoData;
import java.io.File;

class asrj
  implements asqy
{
  asrj(asri paramasri, HotVideoData paramHotVideoData, File paramFile, URLDrawableHandler paramURLDrawableHandler) {}
  
  public void a(asqz paramasqz)
  {
    if (paramasqz.a)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.url = paramasqz.a();
      asri.a(this.jdField_a_of_type_Asri, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaIoFile.delete();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.onFileDownloadFailed(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.picIndex);
    } while (this.jdField_a_of_type_ComTencentImageURLDrawableHandler == null);
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadFailed(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.picIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrj
 * JD-Core Version:    0.7.0.1
 */