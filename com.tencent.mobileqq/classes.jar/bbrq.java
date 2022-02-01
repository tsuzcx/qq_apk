import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;

class bbrq
  implements IGalleryImageListener
{
  bbrq(bbrl parambbrl, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, AIOPictureData paramAIOPictureData) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bbrl.b.setVisibility(8);
    if (paramBoolean)
    {
      bbrl.a(this.jdField_a_of_type_Bbrl, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, paramInt);
      return;
    }
    if ((!bbrl.a(this.jdField_a_of_type_Bbrl, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_Bbrl.a)) && (!bbrl.a(this.jdField_a_of_type_Bbrl, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_Bbrl.a)) && (!bbrl.b(this.jdField_a_of_type_Bbrl, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_Bbrl.a))) {
      bbrl.a(this.jdField_a_of_type_Bbrl, this.jdField_a_of_type_Bbrl.a);
    }
    bbrl.a(this.jdField_a_of_type_Bbrl, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Int, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrq
 * JD-Core Version:    0.7.0.1
 */