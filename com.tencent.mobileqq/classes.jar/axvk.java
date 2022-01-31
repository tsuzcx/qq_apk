import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;

class axvk
  implements IGalleryImageListener
{
  axvk(axvg paramaxvg, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, AIOFilePictureData paramAIOFilePictureData, GalleryUrlImageView paramGalleryUrlImageView) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Axvg.b.setVisibility(8);
    if (paramBoolean)
    {
      axvg.a(this.jdField_a_of_type_Axvg, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, paramInt);
      return;
    }
    if ((!axvg.a(this.jdField_a_of_type_Axvg, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView)) && (!axvg.b(this.jdField_a_of_type_Axvg, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView))) {
      axvg.a(this.jdField_a_of_type_Axvg, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView);
    }
    axvg.a(this.jdField_a_of_type_Axvg, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvk
 * JD-Core Version:    0.7.0.1
 */