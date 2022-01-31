import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;

class axvu
  implements IGalleryImageListener
{
  axvu(axvr paramaxvr, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, AIOPictureData paramAIOPictureData, GalleryUrlImageView paramGalleryUrlImageView) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Axvr.b.setVisibility(8);
    if (paramBoolean)
    {
      axvr.a(this.jdField_a_of_type_Axvr, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, paramInt);
      return;
    }
    if ((!axvr.a(this.jdField_a_of_type_Axvr, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView)) && (!axvr.b(this.jdField_a_of_type_Axvr, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView)) && (!axvr.c(this.jdField_a_of_type_Axvr, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView))) {
      axvr.a(this.jdField_a_of_type_Axvr, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView);
    }
    axvr.a(this.jdField_a_of_type_Axvr, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Int, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvu
 * JD-Core Version:    0.7.0.1
 */