import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.hotpic.HotVideoData;
import java.io.File;

class avvd
  implements avus
{
  avvd(avvc paramavvc, HotVideoData paramHotVideoData, File paramFile, URLDrawableHandler paramURLDrawableHandler) {}
  
  public void a(avut paramavut)
  {
    if (paramavut.a)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.url = paramavut.a();
      avvc.a(this.jdField_a_of_type_Avvc, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvd
 * JD-Core Version:    0.7.0.1
 */