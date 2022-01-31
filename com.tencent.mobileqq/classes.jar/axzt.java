import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;

class axzt
  implements IGalleryImageListener
{
  axzt(axzp paramaxzp, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, AIOFilePictureData paramAIOFilePictureData, GalleryUrlImageView paramGalleryUrlImageView) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Axzp.b.setVisibility(8);
    if (paramBoolean)
    {
      axzp.a(this.jdField_a_of_type_Axzp, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, paramInt);
      return;
    }
    if ((!axzp.a(this.jdField_a_of_type_Axzp, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView)) && (!axzp.b(this.jdField_a_of_type_Axzp, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView))) {
      axzp.a(this.jdField_a_of_type_Axzp, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView);
    }
    axzp.a(this.jdField_a_of_type_Axzp, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzt
 * JD-Core Version:    0.7.0.1
 */