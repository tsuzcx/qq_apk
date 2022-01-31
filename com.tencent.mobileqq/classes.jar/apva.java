import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import java.io.File;

class apva
  implements begw
{
  apva(apux paramapux, begr parambegr, AIOPicData paramAIOPicData, File paramFile) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_Begr.dismiss();
      return;
    }
    paramView = this.jdField_a_of_type_Begr.a(paramInt);
    if (paramView == null)
    {
      this.jdField_a_of_type_Begr.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_Begr.dismiss();
      return;
    }
    if (this.jdField_a_of_type_Apux.a(paramView, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData, this.jdField_a_of_type_JavaIoFile)) {}
    this.jdField_a_of_type_Begr.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apva
 * JD-Core Version:    0.7.0.1
 */