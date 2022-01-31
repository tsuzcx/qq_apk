import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.hotpic.HotVideoData;
import java.io.File;

class aqgr
  implements aqgg
{
  aqgr(aqgq paramaqgq, HotVideoData paramHotVideoData, File paramFile, URLDrawableHandler paramURLDrawableHandler) {}
  
  public void a(aqgh paramaqgh)
  {
    if (paramaqgh.a)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.url = paramaqgh.a();
      aqgq.a(this.jdField_a_of_type_Aqgq, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqgr
 * JD-Core Version:    0.7.0.1
 */