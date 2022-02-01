import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;

class bbrg
  implements IGalleryImageListener
{
  bbrg(bbrb parambbrb, RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, AIOPictureData paramAIOPictureData) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable) {}
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bbrb.b.setVisibility(8);
    if (paramBoolean)
    {
      bbrb.a(this.jdField_a_of_type_Bbrb, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, paramInt);
      return;
    }
    if ((!bbrb.a(this.jdField_a_of_type_Bbrb, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_Bbrb.a)) && (!bbrb.a(this.jdField_a_of_type_Bbrb, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_Bbrb.a)) && (!bbrb.b(this.jdField_a_of_type_Bbrb, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_Bbrb.a))) {
      bbrb.a(this.jdField_a_of_type_Bbrb, this.jdField_a_of_type_Bbrb.a);
    }
    bbrb.a(this.jdField_a_of_type_Bbrb, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Int, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrg
 * JD-Core Version:    0.7.0.1
 */