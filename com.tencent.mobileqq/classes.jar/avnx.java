import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.hotpic.HotVideoData;
import java.io.File;

class avnx
  implements avnm
{
  avnx(avnw paramavnw, HotVideoData paramHotVideoData, File paramFile, URLDrawableHandler paramURLDrawableHandler) {}
  
  public void a(avnn paramavnn)
  {
    if (paramavnn.a)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.url = paramavnn.a();
      avnw.a(this.jdField_a_of_type_Avnw, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
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
 * Qualified Name:     avnx
 * JD-Core Version:    0.7.0.1
 */